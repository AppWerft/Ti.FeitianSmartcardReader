package gnu.kawa.slib;

import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lib.lists;

public class srfi14 extends gnu.expr.ModuleBody
{
  public static final ModuleMethod char$Mnset$Eq;
  public static final ModuleMethod char$Mnset$Ls$Eq;
  public static final ModuleMethod char$Mnset$Mnhash;
  public static final ModuleMethod char$Mnset$Mncursor;
  public static final ModuleMethod char$Mnset$Mnref;
  public static final ModuleMethod char$Mnset$Mncursor$Mnnext;
  public static final ModuleMethod end$Mnof$Mnchar$Mnset$Qu;
  public static final ModuleMethod char$Mnset$Mnfold;
  public static final ModuleMethod char$Mnset$Mnunfold;
  public static final ModuleMethod char$Mnset$Mnunfold$Ex;
  public static final ModuleMethod char$Mnset$Mnfor$Mneach;
  public static final ModuleMethod char$Mnset$Mnmap;
  public static final ModuleMethod char$Mnset$Mncopy;
  public static final Class char$Mnset;
  public static final ModuleMethod list$Mn$Grchar$Mnset;
  public static final ModuleMethod string$Mn$Grchar$Mnset;
  public static final ModuleMethod list$Mn$Grchar$Mnset$Ex;
  public static final ModuleMethod string$Mn$Grchar$Mnset$Ex;
  public static final ModuleMethod char$Mnset$Mnfilter;
  public static final ModuleMethod ucs$Mnrange$Mn$Grchar$Mnset;
  public static final ModuleMethod char$Mnset$Mnfilter$Ex;
  public static final ModuleMethod ucs$Mnrange$Mn$Grchar$Mnset$Ex;
  public static final ModuleMethod $Mn$Grchar$Mnset;
  public static final ModuleMethod char$Mnset$Mn$Grlist;
  public static final ModuleMethod char$Mnset$Mn$Grstring;
  public static final ModuleMethod char$Mnset$Mnsize;
  public static final ModuleMethod char$Mnset$Mncount;
  public static final ModuleMethod char$Mnset$Mncontains$Qu;
  public static final ModuleMethod char$Mnset$Mnevery;
  public static final ModuleMethod char$Mnset$Mnany;
  public static final ModuleMethod char$Mnset$Mnadjoin;
  public static final ModuleMethod char$Mnset$Mndelete;
  public static final ModuleMethod char$Mnset$Mnadjoin$Ex;
  public static final ModuleMethod char$Mnset$Mndelete$Ex;
  public static final ModuleMethod char$Mnset$Mncomplement;
  public static final ModuleMethod char$Mnset$Mnunion;
  public static final ModuleMethod char$Mnset$Mnintersection;
  public static final ModuleMethod char$Mnset$Mncomplement$Ex;
  public static final ModuleMethod char$Mnset$Mnunion$Ex;
  public static final ModuleMethod char$Mnset$Mnintersection$Ex;
  public static final ModuleMethod char$Mnset$Mndifference;
  public static final ModuleMethod char$Mnset$Mnxor;
  public static final ModuleMethod char$Mnset$Mndiff$Plintersection;
  public static final ModuleMethod char$Mnset$Mndifference$Ex;
  public static final ModuleMethod char$Mnset$Mnxor$Ex;
  public static Procedure char$Mnset$Mndiff$Plintersection$Ex;
  public static final Class $Prvt$reflectArray;
  public static final Class $Prvt$Arrays;
  static final int[] $Pctitle$Mncase;
  static final int[] $Pcwhitespace;
  static final int[] $Pcblank;
  static final int[] $Pclower$Mncase;
  static final int[] $Pcupper$Mncase;
  static final int[] $Pcletter;
  static final int[] $Pcdigit;
  static final int[] $Pcpunctuation;
  static final int[] $Pcsymbol;
  static final int[] $Pcletter$Pldigit;
  static final int[] $Pcgraphic;
  static final int[] $Pcprinting;
  static final ModuleMethod $Pcboundary$Mnpairs$Mnintersection;
  static final ModuleMethod $Pcboundary$Mnpairs$Mnunion;
  static final ModuleMethod $Pcboundary$Mnpairs$Mnxor;
  static final SimpleSymbol Lit0;
  static final gnu.math.IntNum Lit1;
  static final gnu.math.IntNum Lit2;
  static final gnu.bytecode.ClassType Lit3;
  static final Integer Lit4;
  public static srfi14 $instance;
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
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
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
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SimpleSymbol Lit50;
  
  static CharSet $PcMakeBuiltin(Object nm, int[] arr)
  {
    void tmp10_7 = new CharSet(new int[0]);107inversion$Mnlist = arr; void tmp15_10 = tmp10_7;1510inversion$Mnlist$Mnsize = arr.length; void tmp21_15 = tmp15_10; Object tmp28_25 = Promise.force(nm, String.class);tmp28_25;2115name = (tmp28_25 == null ? null : tmp28_25.toString()); void tmp43_21 = tmp21_15;4321immutable$Qu = true;return tmp43_21;
  }
  











































































































































































































































































































































































































































































































































































































































































































































































































  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 52:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 51: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 50: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 49: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 47: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 46: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 45: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 44: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 43: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 41: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 40: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 39: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 38: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 13: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 11: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 3: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 2: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  

  public static boolean charSet$Eq(CharSet... csets)
  {
    boolean x = csets.length < 2;
    int i = 1;
    for (;;) { boolean x = i == csets.length;
      if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(csets[0], csets[i]))) break;
      i++; } return x ? x : x ? x : false;
  }
  




  public static boolean charSet$Ls$Eq(CharSet... csets)
  {
    boolean x = csets.length < 2;
    int i = 1;
    for (;;) { boolean x = i == csets.length;
      if (!csets[(i - 1)].isSubsetOf(csets[i])) break;
      i++; } return x ? x : x ? x : false;
  }
  








  public static int charSetHash(CharSet cs, int bound)
  {
    int natural$Mnhash = cs.hashCode();
    if (natural$Mnhash < 0) {}
    try { Object localObject;
      natural$Mnhash = ((Number)(localObject = Promise.force(gnu.kawa.functions.DivideOp.modulo.apply2(Integer.valueOf(natural$Mnhash), Integer.valueOf(Integer.MAX_VALUE))))).intValue();
      x = bound == 0;
      
      return x ? x : natural$Mnhash < bound ? natural$Mnhash : natural$Mnhash % bound;
    }
    catch (ClassCastException localClassCastException)
    {
      boolean x;
      throw new WrongType(
      


        localClassCastException, "natural-hash", -2, x);
    }
  }
  
  public static int charSetCursor(CharSet cset)
  {
    return cset.getCursor();
  }
  


  @kawa.SourceMethodType({"character"})
  public static int charSetRef(CharSet cset, int cursor)
  {
    return cursor;
  }
  


  public static int charSetCursorNext(CharSet cset, int cursor)
  {
    return cset.cursorNext(cursor);
  }
  



  public static boolean isEndOfCharSet(int cursor)
  {
    return cursor > 1114111;
  }
  






















  public static CharSet charSetUnfold(Procedure p, Procedure f, Procedure g, Object seed, CharSet base$Mncs)
  {
    return charSetUnfold$Ex(p, f, g, seed, charSetCopy(base$Mncs));
  }
  
  public static Object charSetForEach(Procedure proc, CharSet cs)
  {
    for (;; 
        











        ) { Object cursor = Integer.valueOf(charSetCursor(cs));
      try { if (isEndOfCharSet(((Number)(localObject1 = Promise.force(cursor))).intValue())) {} } catch (ClassCastException localClassCastException1) { throw new WrongType(localClassCastException1, "end-of-char-set?", 0, localObject1);
      }
      try {
        proc.apply1(gnu.text.Char.make(charSetRef(cs, ((Number)(localObject1 = Promise.force(cursor))).intValue()))); } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "char-set-ref", 1, localObject1);
      }
    }
    return Lit0;
  }
  




















  public static CharSet charSetCopy(CharSet cs) { return cs.clone(); }
  
  public class CharSet implements Cloneable { public static CharSet empty;
    public static CharSet full;
    public static CharSet ascii;
    public static CharSet title$Mncase;
    public static CharSet whitespace;
    public static CharSet blank;
    public static CharSet lower$Mncase;
    public static CharSet upper$Mncase;
    public static CharSet letter; public static CharSet digit; public static CharSet punctuation; public static CharSet symbol; public static CharSet letter$Pldigit; public static CharSet graphic;
    static { void tmp10_7 = new CharSet(new int[0]);107name = "char-set:empty"; void tmp16_10 = tmp10_7;1610immutable$Qu = true;empty = tmp16_10; void 
      


        tmp34_31 = new CharSet(new int[0]);3431inversion$Mnlist = new int[] { 0 }; void tmp45_34 = tmp34_31;4534inversion$Mnlist$Mnsize = 1; void tmp50_45 = tmp45_34;5045name = "char-set:full"; void tmp56_50 = tmp50_45;5650immutable$Qu = true;full = tmp56_50; void 
      



        tmp74_71 = new CharSet(new int[0]);7471inversion$Mnlist = new int[] { 128, 0 }; void tmp91_74 = tmp74_71;9174inversion$Mnlist$Mnsize = 2; void tmp96_91 = tmp91_74;9691name = "char-set:ascii"; void tmp102_96 = tmp96_91;10296immutable$Qu = true;ascii = tmp102_96;
      







      title$Mncase = srfi14.$PcMakeBuiltin("char-set:title-case", srfi14.$Pctitle$Mncase);
      




      whitespace = srfi14.$PcMakeBuiltin("char-set:whitespace", srfi14.$Pcwhitespace);
      




      blank = srfi14.$PcMakeBuiltin("char-set:blank", srfi14.$Pcblank);
      



      lower$Mncase = srfi14.$PcMakeBuiltin("char-set:lower-case", srfi14.$Pclower$Mncase);
      



      upper$Mncase = srfi14.$PcMakeBuiltin("char-set:upper-case", srfi14.$Pcupper$Mncase);
      



      letter = srfi14.$PcMakeBuiltin("char-set:letter", srfi14.$Pcletter);
      



      digit = srfi14.$PcMakeBuiltin("char-set:digit", srfi14.$Pcdigit);
      








      punctuation = srfi14.$PcMakeBuiltin("char-set:punctuation", srfi14.$Pcpunctuation);
      





      symbol = srfi14.$PcMakeBuiltin("char-set:symbol", srfi14.$Pcsymbol);
      



      letter$Pldigit = srfi14.$PcMakeBuiltin("char-set:letter+digit", srfi14.$Pcletter$Pldigit);
      




      graphic = srfi14.$PcMakeBuiltin("char-set:graphic", srfi14.$Pcgraphic);
      



      printing = srfi14.$PcMakeBuiltin("char-set:printing", srfi14.$Pcprinting); void 
      
        tmp252_249 = new CharSet(new int[0]);252249inversion$Mnlist = new int[] { 103, 97, 71, 65, 58, 48, 0 }; void tmp295_252 = tmp252_249;295252inversion$Mnlist$Mnsize = 6; void tmp301_295 = tmp295_252;301295name = "char-set:hex-digit"; void tmp307_301 = tmp301_295;307301immutable$Qu = true;hex$Mndigit = tmp307_301; void 
      



        tmp325_322 = new CharSet(new int[0]);325322inversion$Mnlist = new int[] { 160, 127, 32, 0 }; void tmp352_325 = tmp325_322;352325inversion$Mnlist$Mnsize = 4; void tmp357_352 = tmp352_325;357352name = "char-set:iso-control"; void tmp363_357 = tmp357_352;363357immutable$Qu = true; } public static CharSet printing; public static CharSet hex$Mndigit; public static CharSet iso$Mncontrol = tmp363_357;
    public int[] inversion$Mnlist;
    public int inversion$Mnlist$Mnsize;
    public boolean immutable$Qu;
    public String name;
    
    private void $finit$() {
      inversion$Mnlist = new int[] { 0 };
      inversion$Mnlist$Mnsize = 0;
      immutable$Qu = false;
      
      name = null; }
    
    @kawa.SourceMethodType({"", "character[]"})
    public CharSet() { $finit$();
      
      if (characters.length > 0)
      {

        int[] chars = (int[])java.util.Arrays.copyOf(characters, characters.length);
        java.util.Arrays.sort(chars);
        int first$Mnpt = chars[0];
        

        LList localLList1 = (LList)Promise.force(kawa.lang.Quote.consX$V(new Object[] { Integer.valueOf(first$Mnpt), LList.Empty }), LList.class);int i = 1 + first$Mnpt;int index = 1;
        for (;;) { Object inv$Mnls; int pt; int len; int i; if (index == chars.length) {
            if (pt != 1114111)
              inv$Mnls = lists.cons(Integer.valueOf(pt), inv$Mnls);
            len = ((LList)inv$Mnls).size();
            inversion$Mnlist = new int[1 + len];
            inversion$Mnlist$Mnsize = len;
            Object localObject1 = inv$Mnls;i = 0; }
          for (;; )
          {
            LList inv$Mnls;
            if (i == len) {
              break label260;
            }
            LList tmp140_138 = inv$Mnls;localLList2 = tmp140_138; try { inversion$Mnlist[i] = ((Number)Promise.force(lists.car((gnu.lists.Pair)tmp140_138))).intValue(); } catch (ClassCastException localClassCastException1) { int next$Mnchar$Mnpt; throw new WrongType(
              








                localClassCastException1, "car", 1, localLList2);
            }
          }
          next$Mnchar$Mnpt = chars[index];
          if (pt < next$Mnchar$Mnpt)
          {

            inv$Mnls = lists.cons(Integer.valueOf(next$Mnchar$Mnpt), lists.cons(Integer.valueOf(pt), inv$Mnls));pt = 1 + next$Mnchar$Mnpt;index++; } else if (pt == next$Mnchar$Mnpt)
          {
            pt++;index++; } else { if (pt <= next$Mnchar$Mnpt)
              break;
            index++;
          } } }
      label260: }
    
    public CharSet clone() { try { CharSet copy = (CharSet)(localObject = Promise.force(super.clone(), CharSet.class));
        
        inversion$Mnlist = java.util.Arrays.copyOf(inversion$Mnlist, inversion$Mnlist$Mnsize);immutable$Qu = false;name = null;
        

        return copy;
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new WrongType(
        



          localClassCastException, "copy", -2, localObject);
      }
    }
    
    /* Error */
    public int hashCode()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 28	gnu/kawa/slib/srfi14$CharSet:inversion$Mnlist$Mnsize	I
      //   4: iconst_1
      //   5: isub
      //   6: iconst_1
      //   7: istore_2
      //   8: istore_1
      //   9: iload_1
      //   10: iconst_m1
      //   11: if_icmpne +7 -> 18
      //   14: iload_2
      //   15: goto +21 -> 36
      //   18: bipush 31
      //   20: iload_2
      //   21: imul
      //   22: aload_0
      //   23: getfield 24	gnu/kawa/slib/srfi14$CharSet:inversion$Mnlist	[I
      //   26: iload_1
      //   27: iaload
      //   28: iadd
      //   29: istore_2
      //   30: iinc 1 -1
      //   33: goto -24 -> 9
      //   36: ireturn
      // Line number table:
      //   Java source line #448	-> byte code offset #0
      //   Java source line #449	-> byte code offset #0
      //   Java source line #450	-> byte code offset #9
      //   Java source line #451	-> byte code offset #18
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	37	0	this	CharSet
      //   9	27	1	i	int
      //   9	27	2	hash	int
    }
    
    public String toString()
    {
      String s = super.toString(); gnu.lists.FString 
      

        tmp44_41 = kawa.lib.strings.stringAppend(new Object[] { s, ": (", name, ")" });tmp44_41;return tmp44_41 == null ? null : name == null ? s : tmp44_41.toString();
    }
    
    public boolean equals(Object o)
    {
      CharSet other = (CharSet)Promise.force(o, CharSet.class);
      
      int i = 0;
      for (;;) { boolean x = i == inversion$Mnlist$Mnsize;
        if (inversion$Mnlist[i] != inversion$Mnlist[i])
          break;
        i++; } return (o instanceof CharSet) ? false : inversion$Mnlist$Mnsize == inversion$Mnlist$Mnsize ? false : x ? x : false;
    }
    
    public boolean isSubsetOf(CharSet cs) {
      int i = inversion$Mnlist$Mnsize - 1;int ai = inversion$Mnlist$Mnsize - 1;
      for (;;) { int bi; if (inversion$Mnlist[(ai - 1)] < inversion$Mnlist[(bi - 1)])
        {






          ai -= 2; } else if (inversion$Mnlist[(ai - 1)] == inversion$Mnlist[(bi - 1)])
        {

          bi -= 2;ai -= 2; } else { if (inversion$Mnlist[ai] <= inversion$Mnlist[(bi - 1)]) {
            break;
          }
          bi -= 2; } } return ai == -1;
    }
    
    @kawa.SourceMethodType({"", "character"})
    public boolean isContains(int char)
    {
      int charnum = char;
      int i = inversion$Mnlist$Mnsize;int low = 0;
      int high; int mid; for (;;) { mid = gnu.math.BitOps.shift(low + high, -1);
        if ((charnum < inversion$Mnlist[mid]) && (mid < inversion$Mnlist$Mnsize - 1))
        {

          low = mid; } else { if ((mid <= 0) || (charnum < inversion$Mnlist[(mid - 1)])) {
            break;
          }
          high = mid;
        }
      }
      
      return low != high;
    }
    
    /* Error */
    public int size()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 28	gnu/kawa/slib/srfi14$CharSet:inversion$Mnlist$Mnsize	I
      //   4: iconst_1
      //   5: isub
      //   6: iconst_0
      //   7: istore_2
      //   8: istore_1
      //   9: iload_1
      //   10: iconst_m1
      //   11: if_icmpne +7 -> 18
      //   14: iload_2
      //   15: goto +47 -> 62
      //   18: iload_1
      //   19: ifne +19 -> 38
      //   22: iload_2
      //   23: ldc -63
      //   25: aload_0
      //   26: getfield 24	gnu/kawa/slib/srfi14$CharSet:inversion$Mnlist	[I
      //   29: iload_1
      //   30: iaload
      //   31: isub
      //   32: iadd
      //   33: iconst_1
      //   34: iadd
      //   35: goto +27 -> 62
      //   38: iload_2
      //   39: aload_0
      //   40: getfield 24	gnu/kawa/slib/srfi14$CharSet:inversion$Mnlist	[I
      //   43: iload_1
      //   44: iconst_1
      //   45: isub
      //   46: iaload
      //   47: aload_0
      //   48: getfield 24	gnu/kawa/slib/srfi14$CharSet:inversion$Mnlist	[I
      //   51: iload_1
      //   52: iaload
      //   53: isub
      //   54: iadd
      //   55: istore_2
      //   56: iinc 1 -2
      //   59: goto -50 -> 9
      //   62: ireturn
      // Line number table:
      //   Java source line #509	-> byte code offset #0
      //   Java source line #510	-> byte code offset #0
      //   Java source line #512	-> byte code offset #9
      //   Java source line #515	-> byte code offset #38
      //   Java source line #516	-> byte code offset #38
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	CharSet
      //   9	53	1	i	int
      //   9	53	2	num	int
    }
    
    public LList toList()
    {
      return (LList)Promise.force(srfi14.charSetFold(lists.cons, LList.Empty, this), LList.class);
    }
    



    public int getCursor() { return inversion$Mnlist$Mnsize == 0 ? 1114112 : inversion$Mnlist[(inversion$Mnlist$Mnsize - 1)]; }
    
    public int cursorNext(int cursor) {
      boolean x = inversion$Mnlist$Mnsize == 0;
      


      int cursor = cursor + 1;
      int i = inversion$Mnlist$Mnsize;int low = 0;
      int mid; for (;;) { int high; mid = gnu.math.BitOps.shift(low + high, -1);
        if (cursor < inversion$Mnlist[mid])
        {
          low = mid; } else { if ((mid <= 0) || (cursor < inversion$Mnlist[(mid - 1)])) {
            break;
          }
          high = mid;
        } }
      return (inversion$Mnlist$Mnsize - mid & 0x1) != 0 ? cursor : low == high ? inversion$Mnlist[low] : x ? x : (1 - (inversion$Mnlist$Mnsize & 0x1) != 0) && (cursor + 1 >= inversion$Mnlist[0]) ? 1114112 : inversion$Mnlist[(mid - 1)];
    }
    
    public CharSet complement$Ex() {
      if (immutable$Qu) {
        throw gnu.expr.Special.reachedUnexpected;
      }
      
      inversion$Mnlist$Mnsize -= 1; if (inversion$Mnlist$Mnsize < inversion$Mnlist.length)
      {
        inversion$Mnlist[inversion$Mnlist$Mnsize] = 0;
        inversion$Mnlist$Mnsize = (1 + inversion$Mnlist$Mnsize);
      }
      else
      {
        inversion$Mnlist = java.util.Arrays.copyOf(inversion$Mnlist, 1 + inversion$Mnlist$Mnsize * 2);
        inversion$Mnlist$Mnsize = ((inversion$Mnlist$Mnsize > 0) && (inversion$Mnlist[(inversion$Mnlist$Mnsize - 1)] == 0) ? kawa.lib.exceptions.error(new Object[] { "attempted to modify an immutable char-set", this }) : 1 + inversion$Mnlist$Mnsize); }
      return this;
    }
    
    @kawa.SourceMethodType({"", "character"})
    public CharSet adjoin$Ex(int c) { int i = c;
      return union$Ex(new int[] { i + 1, i }, 2);
    }
    
    @kawa.SourceMethodType({"", "character"})
    public CharSet delete$Ex(int c) { int i = c;
      return intersection$Ex(new int[] { i + 1, i, 0 }, 3);
    }
    
    private CharSet combine$Ex(int[] arr, int arr$Mnsize, Procedure proc)
    {
      if (immutable$Qu) {
        throw gnu.expr.Special.reachedUnexpected;
      }
      l1 = srfi14.$PcMakeBoundaryPairs(inversion$Mnlist, inversion$Mnlist$Mnsize);
      l2 = srfi14.$PcMakeBoundaryPairs(arr, arr$Mnsize);
      combo$Mnpairs = (LList)(localObject = Promise.force(proc.apply2(l1, l2), LList.class));
      new$Mnlength = srfi14.$PcBoundaryPairsLength(combo$Mnpairs);
      x = new$Mnlength > inversion$Mnlist.length; if (x) { if (!x) {
          break label141;
        }
        tmpTernaryOp = kawa.lib.exceptions.error(new Object[] { "attempted to modify an immutable char-set", this });
      }
      try { LList l1;
        LList l2;
        Object localObject;
        LList combo$Mnpairs;
        boolean x;
        if (new$Mnlength < gnu.math.RatNum.make(gnu.math.IntNum.make(inversion$Mnlist.length), gnu.math.IntNum.make(2)).doubleValue())
          inversion$Mnlist = new int[new$Mnlength * 2];
        label141: srfi14.$PcWriteInversionList(inversion$Mnlist, combo$Mnpairs, new$Mnlength);
        inversion$Mnlist$Mnsize = new$Mnlength;
        return this;
      }
      catch (ClassCastException localClassCastException)
      {
        int new$Mnlength;
        throw new WrongType(
        





          localClassCastException, "combo-pairs", -2, new$Mnlength);
      } }
    
    public CharSet intersection$Ex(CharSet cs) { return intersection$Ex(inversion$Mnlist, inversion$Mnlist$Mnsize); }
    
    public CharSet intersection$Ex(int[] arr, int arr$Mnsize) {
      return combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnintersection);
    }
    
    public CharSet union$Ex(CharSet cs) { return union$Ex(inversion$Mnlist, inversion$Mnlist$Mnsize); }
    
    public CharSet union$Ex(int[] arr, int arr$Mnsize) {
      return combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnunion);
    }
    
    public CharSet xor$Ex(CharSet cs) { return xor$Ex(inversion$Mnlist, inversion$Mnlist$Mnsize); }
    
    public CharSet xor$Ex(int[] arr, int arr$Mnsize) {
      return combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnxor);
    }
  }
  





  public static CharSet list$To$CharSet(LList char$Mnlist, CharSet base$Mncs)
  {
    int i = 1;LList localLList = char$Mnlist; int j; i = (j = gnu.kawa.functions.MakeSplice.count(localLList)) + i;int k = 1;gnu.kawa.functions.MakeSplice.copyTo(new Object[] { CharSet.class }, k, j, localLList);k += j; try { CharSet res$Mncs = (CharSet)(localObject = Promise.force(gnu.kawa.reflect.Invoke.make.applyN(tmp28_23), CharSet.class));
      return charSetUnion$Ex(new CharSet[] { res$Mncs, base$Mncs });
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new WrongType(
        localClassCastException, "res-cs", -2, localObject);
    }
  }
  



  public static CharSet list$To$CharSet$Ex(LList char$Mnlist, CharSet base$Mncs)
  {
    int i = 0;LList localLList = char$Mnlist; int j; i = (j = gnu.kawa.functions.MakeSplice.count(localLList)) + i; int[] tmp18_16 = new int[i];int k = 0;gnu.kawa.functions.MakeSplice.copyTo(tmp18_16, k, j, localLList, gnu.kawa.lispexpr.LangPrimType.characterType);k += j;return charSetAdjoin$Ex(base$Mncs, tmp18_16);
  }
  






  public static CharSet string$To$CharSet(String s, CharSet base$Mncs)
  {
    return list$To$CharSet(kawa.lib.strings.string$To$List(s), base$Mncs);
  }
  




  public static CharSet string$To$CharSet$Ex(String s, CharSet base$Mncs)
  {
    return list$To$CharSet$Ex(kawa.lib.strings.string$To$List(s), base$Mncs);
  }
  













































  public static CharSet ucsRange$To$CharSet(int lower, int upper, boolean error$Qu, CharSet base$Mncs)
  {
    void tmp10_7 = new CharSet(new int[0]);107inversion$Mnlist = new int[] { upper, lower }; void tmp25_10 = tmp10_7;2510inversion$Mnlist$Mnsize = 2;CharSet res$Mncs = tmp25_10;
    
    return charSetUnion$Ex(new CharSet[] { res$Mncs, base$Mncs });
  }
  












  public static CharSet ucsRange$To$CharSet$Ex(int lower, int upper, boolean error$Qu, CharSet base$Mncs)
  {
    return base$Mncs.union$Ex(new int[] { upper, lower }, 2);
  }
  













  public static int charSetSize(CharSet cs) { return cs.size(); }
  
  public class frame extends gnu.expr.ModuleBody {
    Procedure pred;
    final ModuleMethod lambda$Fn1;
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 1) return lambda1(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); }
    Object lambda1(Object x, Object sum) { return gnu.expr.KawaConvert.isTrue(pred.apply1(x)) ? gnu.kawa.functions.AddOp.apply2(1, sum, srfi14.Lit1) : sum;
    }
    
    public frame()
    {
      void tmp18_15 = new ModuleMethod(this, 1, null, 8194);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi14.scm:737");
      lambda$Fn1 = tmp18_15;
    }
  }
  
  public static int charSetCount(Procedure pred, CharSet cs)
  {
    frame $heapFrame = new frame();pred = pred;
    



    return ((Number)Promise.force(charSetFold(lambda$Fn1, Lit2, cs))).intValue();
  }
  

  public static LList charSet$To$List(CharSet cs)
  {
    return cs.toList();
  }
  

  public static String charSet$To$String(CharSet cs)
  {
    CharSequence tmp7_4 = kawa.lib.strings.list$To$String(charSet$To$List(cs));tmp7_4;return tmp7_4 == null ? null : tmp7_4.toString();
  }
  
  @kawa.SourceMethodType({"", "", "character"})
  public static boolean isCharSetContains(CharSet cs, int char) {
    return cs.isContains(char);
  }
  
  public static boolean charSetEvery(Procedure pred, CharSet cs)
  {
    for (;;)
    {
      Object cursor = Integer.valueOf(charSetCursor(cs));
      Object localObject1; for (;;) { try { boolean x = isEndOfCharSet(((Number)(localObject1 = Promise.force(cursor))).intValue()); if (x) tmpTernaryOp = x; } catch (ClassCastException localClassCastException1) { throw new WrongType(
          
            localClassCastException1, "end-of-char-set?", 0, localObject1);
        }
        try
        {
          if (!gnu.expr.KawaConvert.isTrue(pred.apply1(gnu.text.Char.make(charSetRef(cs, ((Number)(localObject1 = Promise.force(cursor))).intValue()))))) {} } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "char-set-ref", 1, localObject1); } }
      try { tmpTernaryOp = Integer.valueOf(charSetCursorNext(cs, ((Number)(localObject1 = Promise.force(cursor))).intValue())); } catch (ClassCastException localClassCastException3) { throw new WrongType(localClassCastException3, "char-set-cursor-next", 1, localObject1); } } return false;
  }
  














  @kawa.SourceMethodType({"", "", "character[]"})
  public static CharSet charSetAdjoin(CharSet cs, int... chars)
  {
    return charSetAdjoin$Ex(charSetCopy(cs), chars);
  }
  
  @kawa.SourceMethodType({"", "", "character[]"})
  public static CharSet charSetDelete(CharSet cs, int... chars) {
    return charSetDelete$Ex(charSetCopy(cs), chars);
  }
  


  @kawa.SourceMethodType({"", "", "character[]"})
  public static CharSet charSetAdjoin$Ex(CharSet cs, int... chars)
  {
    int tmp = chars.length; switch (tmp) {
    case 0: 
      break;
    case 1:  break; default:  int i = 1;int[] arrayOfInt = chars; int j; i = (j = gnu.kawa.functions.MakeSplice.count(arrayOfInt)) + i;int k = 1;gnu.kawa.functions.MakeSplice.copyTo(new Object[] { CharSet.class }, k, j, arrayOfInt);k += j; } try { return cs.union$Ex((CharSet)(localObject = Promise.force(gnu.kawa.reflect.Invoke.make.applyN(tmp71_66), CharSet.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "gnu.kawa.slib.srfi14$CharSet.union$Ex(gnu.kawa.slib.srfi14$CharSet)", 2, localObject);
    }
  }
  

  @kawa.SourceMethodType({"", "", "character[]"})
  public static CharSet charSetDelete$Ex(CharSet cs, int... chars)
  {
    int tmp = chars.length; switch (tmp) {
    case 0: 
      break;
    case 1:  break; default:  int i = 1;int[] arrayOfInt = chars; int j; i = (j = gnu.kawa.functions.MakeSplice.count(arrayOfInt)) + i;int k = 1;gnu.kawa.functions.MakeSplice.copyTo(new Object[] { CharSet.class }, k, j, arrayOfInt);k += j; } try { CharSet to$Mnremove = (CharSet)(localObject = Promise.force(gnu.kawa.reflect.Invoke.make.applyN(tmp74_69), CharSet.class));
      return cs.intersection$Ex(to$Mnremove.complement$Ex());
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new WrongType(
        localClassCastException, "to-remove", -2, localObject);
    }
  }
  
  public static CharSet charSetComplement(CharSet cs) {
    return charSetComplement$Ex(charSetCopy(cs));
  }
  

  public static CharSet charSetUnion(CharSet... csets)
  {
    int tmp = csets.length; switch (tmp) {
    case 0: 
      break;
    case 1: 
      break; default:  int i = 1;CharSet cs = charSetCopy(csets[0]);
      
      int i;
      cs.union$Ex(csets[i]);tmpTernaryOp = cs;break;
    }
    return csets[0];
  }
  


  public static CharSet charSetIntersection(CharSet... csets)
  {
    int tmp = csets.length; switch (tmp) {
    case 0: 
      break;
    case 1: 
      break; default:  int i = 1;CharSet cs = charSetCopy(csets[0]);
      
      int i;
      cs.intersection$Ex(csets[i]);tmpTernaryOp = cs;break;
    }
    return csets[0];
  }
  







  public static CharSet charSetDifference(CharSet cs1, CharSet... csets)
  {
    CharSet rest = charSetUnion(csets);
    return csets.length == 0 ? cs1 : charSetIntersection(new CharSet[] { cs1, charSetComplement(rest) });
  }
  

  public static CharSet charSetXor(CharSet... csets)
  {
    int tmp = csets.length; switch (tmp) {
    case 0: 
      break;
    case 1: 
      break; default:  int i = 1;CharSet cs = charSetCopy(csets[0]);
      
      int i;
      cs.xor$Ex(csets[i]);tmpTernaryOp = cs;break;
    }
    return csets[0];
  }
  


  public static gnu.mapping.Values charSetDiff$PlIntersection(CharSet cs1, CharSet cs2, CharSet... csets)
  {
    int i = 1;CharSet[] arrayOfCharSet = csets; int j; i = (j = gnu.kawa.functions.MakeSplice.count(arrayOfCharSet)) + i;int k = 1;gnu.kawa.functions.MakeSplice.copyTo(new CharSet[] { cs2 }, k, j, arrayOfCharSet, Lit3);k += j;CharSet union = charSetUnion(tmp28_24);
    
    return gnu.mapping.Values.values2(charSetIntersection(new CharSet[] { cs1, charSetComplement(union) }), charSetIntersection(new CharSet[] { cs1, union }));
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} for (;;) { try { return Integer.valueOf(charSetHash((CharSet)Promise.force(paramObject, CharSet.class))); } catch (ClassCastException localClassCastException1) { throw new WrongType(
        




























































































































































































































































































































































































































































































































































































































































































































          localClassCastException1, "char-set-hash", 1, paramObject);
      }
      try
      {
        return Integer.valueOf(charSetCursor((CharSet)Promise.force(paramObject, CharSet.class))); } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "char-set-cursor", 1, paramObject);
      }
      
















      try
      {
        return isEndOfCharSet(((Number)Promise.force(paramObject)).intValue()) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException3) { throw new WrongType(localClassCastException3, "end-of-char-set?", 1, paramObject);
      }
    }
    































































    try
    {
      return charSetCopy((CharSet)Promise.force(paramObject, CharSet.class)); } catch (ClassCastException localClassCastException4) { throw new WrongType(localClassCastException4, "char-set-copy", 1, paramObject);
    }
    




























































































































































































































































































































    try
    {
      return list$To$CharSet((LList)Promise.force(paramObject, LList.class)); } catch (ClassCastException localClassCastException5) { throw new WrongType(localClassCastException5, "list->char-set", 1, paramObject);
    }
    


















    Object tmp203_200 = Promise.force(paramObject, String.class);tmp203_200;return string$To$CharSet(tmp203_200 == null ? null : tmp203_200.toString());
    























































































    return $To$CharSet(paramObject);
    








    try
    {
      return Integer.valueOf(charSetSize((CharSet)Promise.force(paramObject, CharSet.class))); } catch (ClassCastException localClassCastException6) { throw new WrongType(localClassCastException6, "char-set-size", 1, paramObject);
    }
    






    try
    {
      return charSet$To$List((CharSet)Promise.force(paramObject, CharSet.class)); } catch (ClassCastException localClassCastException7) { throw new WrongType(localClassCastException7, "char-set->list", 1, paramObject);
    }
    

    try
    {
      return charSet$To$String((CharSet)Promise.force(paramObject, CharSet.class)); } catch (ClassCastException localClassCastException8) { throw new WrongType(localClassCastException8, "char-set->string", 1, paramObject);
    }
    

































































    try
    {
      return charSetComplement((CharSet)Promise.force(paramObject, CharSet.class)); } catch (ClassCastException localClassCastException9) { throw new WrongType(localClassCastException9, "char-set-complement", 1, paramObject);
    }
    


























































    try
    {
      return charSetComplement$Ex((CharSet)Promise.force(paramObject, CharSet.class)); } catch (ClassCastException localClassCastException10) { throw new WrongType(localClassCastException10, "char-set-complement!", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static CharSet charSetComplement$Ex(CharSet cs) { return cs.complement$Ex(); }
  

  public static CharSet charSetUnion$Ex(CharSet... csets)
  {
    int tmp = csets.length; switch (tmp) {
    case 0: 
      break;
    case 1: 
      break; default:  int i = 1;
      
      csets[0].union$Ex(csets[i]);tmpTernaryOp = csets[0];break; } return csets[0];
  }
  


  public static CharSet charSetIntersection$Ex(CharSet... csets)
  {
    int tmp = csets.length; switch (tmp) {
    case 0: 
      break;
    case 1: 
      break; default:  int i = 1;
      
      csets[0].intersection$Ex(csets[i]);tmpTernaryOp = csets[0];break; } return csets[0];
  }
  




  public static CharSet charSetDifference$Ex(CharSet cs1, CharSet... csets)
  {
    CharSet rest = charSetUnion(csets);
    return csets.length == 0 ? cs1 : charSetIntersection$Ex(new CharSet[] { cs1, charSetComplement(rest) });
  }
  
  public static CharSet charSetXor$Ex(CharSet... csets)
  {
    int tmp = csets.length; switch (tmp) {
    case 0: 
      break;
    case 1: 
      break; default:  int i = 1;
      
      csets[0].xor$Ex(csets[i]);tmpTernaryOp = csets[0];break; } return csets[0];
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    





































































































































































































































































































































































































































































































































































































































































































































































































































































    char$Mnset$Mndiff$Plintersection$Ex = char$Mnset$Mndiff$Plintersection;
  }
  

  public class frame0
    extends gnu.expr.ModuleBody
  {
    int[] arr;
    
    int len;
    

    public frame0() {}
    

    public LList lambda2makePairs(int i)
    {
      return i == len ? LList.Empty : lists.cons(lists.cons(Integer.valueOf(arr[(1 + i)]), Integer.valueOf(arr[i] - 1)), lambda2makePairs(i + 2));
    }
  }
  
  static LList $PcMakeBoundaryPairs(int[] arr, int len)
  {
    frame0 $heapFrame = new frame0();arr = arr;len = len;
    








    return 1 - (len & 0x1) != 0 ? $heapFrame.lambda2makePairs(0) : len == 0 ? LList.Empty : lists.cons(lists.cons(Integer.valueOf(arr[0]), Lit4), $heapFrame.lambda2makePairs(1));
  }
  
















  static Object $PcWriteInversionList(int[] arr, LList l, int len)
  {
    arr[0] = ((Number)Promise.force(lists.caar(l))).intValue();
    for (;;)
    {
      LList localLList3;
      try
      {
        LList localLList1;
        LList localLList2 = 
        





          (LList)Promise.force(lists.cdr((gnu.lists.Pair)(localLList1 = l)), LList.class);i = 1;
        if (i < len) {
          arr[i] = ((Number)Promise.force(gnu.kawa.functions.AddOp.apply2(1, Lit1, lists.cdar(l)))).intValue();arr[(i + 1)] = 
            ((Number)Promise.force(lists.caar(l))).intValue();
        }
      } catch (ClassCastException localClassCastException1) { int i;
        LList l;
        throw new WrongType(
          localClassCastException1, "cdr", 1, i);
      }
      try
      {
        l = (LList)Promise.force(lists.cdr((gnu.lists.Pair)(localLList3 = l)), LList.class);i += 2; } catch (ClassCastException localClassCastException2) { throw new WrongType(
        

          localClassCastException2, "cdr", 1, localLList3); } }
    return gnu.kawa.functions.NumberCompare.$Eq(Lit4, lists.cdar(l)) ? gnu.mapping.Values.empty : gnu.mapping.Values.empty;
  }
  
































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































  static final SimpleSymbol Lit51 = Symbol.valueOf("%boundary-pairs-xor"); static { Lit50 = Symbol.valueOf("%boundary-pairs-union");Lit49 = Symbol.valueOf("%boundary-pairs-intersection");Lit48 = Symbol.valueOf("char-set-xor!");Lit47 = Symbol.valueOf("char-set-difference!");Lit46 = Symbol.valueOf("char-set-intersection!");Lit45 = Symbol.valueOf("char-set-union!");Lit44 = Symbol.valueOf("char-set-complement!");Lit43 = Symbol.valueOf("char-set-diff+intersection");Lit42 = Symbol.valueOf("char-set-xor");Lit41 = Symbol.valueOf("char-set-difference");Lit40 = Symbol.valueOf("char-set-intersection");Lit39 = Symbol.valueOf("char-set-union");Lit38 = Symbol.valueOf("char-set-complement");Lit37 = Symbol.valueOf("char-set-delete!");Lit36 = Symbol.valueOf("char-set-adjoin!");Lit35 = Symbol.valueOf("char-set-delete");Lit34 = Symbol.valueOf("char-set-adjoin");Lit33 = Symbol.valueOf("char-set-any");Lit32 = Symbol.valueOf("char-set-every");Lit31 = Symbol.valueOf("char-set-contains?");Lit30 = Symbol.valueOf("char-set->string");Lit29 = Symbol.valueOf("char-set->list");Lit28 = Symbol.valueOf("char-set-count");Lit27 = Symbol.valueOf("char-set-size");Lit26 = Symbol.valueOf("->char-set");Lit25 = Symbol.valueOf("ucs-range->char-set!");Lit24 = Symbol.valueOf("ucs-range->char-set");Lit23 = Symbol.valueOf("char-set-filter!");Lit22 = Symbol.valueOf("char-set-filter");Lit21 = Symbol.valueOf("string->char-set!");Lit20 = Symbol.valueOf("string->char-set");Lit19 = Symbol.valueOf("list->char-set!");Lit18 = Symbol.valueOf("list->char-set");Lit17 = Symbol.valueOf("char-set-copy");Lit16 = Symbol.valueOf("char-set-map");Lit15 = Symbol.valueOf("char-set-for-each");Lit14 = Symbol.valueOf("char-set-unfold!");Lit13 = Symbol.valueOf("char-set-unfold");Lit12 = Symbol.valueOf("char-set-fold");Lit11 = Symbol.valueOf("end-of-char-set?");Lit10 = Symbol.valueOf("char-set-cursor-next");Lit9 = Symbol.valueOf("char-set-ref");Lit8 = Symbol.valueOf("char-set-cursor");Lit7 = Symbol.valueOf("char-set-hash");Lit6 = Symbol.valueOf("char-set<=");Lit5 = Symbol.valueOf("char-set=");Lit4 = Integer.valueOf(1114111);Lit3 = (gnu.bytecode.ClassType)gnu.bytecode.Type.make(CharSet.class);Lit2 = gnu.math.IntNum.valueOf(0);Lit1 = gnu.math.IntNum.valueOf(1);Lit0 = Symbol.valueOf("done");$Prvt$Arrays = java.util.Arrays.class;$Prvt$reflectArray = java.lang.reflect.Array.class;$instance = new srfi14();$Pctitle$Mncase = new int[] { 8189, 8188, 8141, 8140, 8125, 8124, 8112, 8104, 8096, 8088, 8080, 8072, 499, 498, 460, 459, 457, 456, 454, 453 };
    

    $Pcwhitespace = new int[] { 12289, 12288, 8288, 8287, 8240, 8239, 8234, 8232, 8203, 8192, 6159, 6158, 5761, 5760, 161, 160, 33, 32, 14, 9 };
    

    $Pcblank = new int[] { 12289, 12288, 8288, 8287, 8240, 8239, 8203, 8192, 6159, 6158, 5761, 5760, 161, 160, 33, 32, 10, 9 };
    

    $Pclower$Mncase = new int[] { 120780, 120779, 120778, 120772, 120771, 120746, 120720, 120714, 120713, 120688, 120662, 120656, 120655, 120630, 120604, 120598, 120597, 120572, 120546, 120540, 120539, 120514, 120486, 120458, 120432, 120406, 120380, 120354, 120328, 120302, 120276, 120250, 120224, 120198, 120172, 120146, 120120, 120094, 120068, 120042, 120016, 120005, 120004, 119997, 119996, 119995, 119994, 119990, 119964, 119938, 119912, 119894, 119893, 119886, 119860, 119834, 66640, 66600, 65371, 65345, 64280, 64275, 64263, 64256, 43003, 43000, 42922, 42921, 42920, 42919, 42918, 42917, 42916, 42915, 42914, 42913, 42900, 42899, 42898, 42897, 42895, 42894, 42893, 42892, 42888, 42887, 42886, 42885, 42884, 42883, 42882, 42881, 42880, 42879, 42877, 42876, 42875, 42874, 42873, 42863, 42862, 42861, 42860, 42859, 42858, 42857, 42856, 42855, 42854, 42853, 42852, 42851, 42850, 42849, 42848, 42847, 42846, 42845, 42844, 42843, 42842, 42841, 42840, 42839, 42838, 42837, 42836, 42835, 42834, 42833, 42832, 42831, 42830, 42829, 42828, 42827, 42826, 42825, 42824, 42823, 42822, 42821, 42820, 42819, 42818, 42817, 42816, 42815, 42814, 42813, 42812, 42811, 42810, 42809, 42808, 42807, 42806, 42805, 42804, 42803, 42802, 42799, 42798, 42797, 42796, 42795, 42794, 42793, 42792, 42791, 42790, 42789, 42788, 42787, 42648, 42647, 42646, 42645, 42644, 42643, 42642, 42641, 42640, 42639, 42638, 42637, 42636, 42635, 42634, 42633, 42632, 42631, 42630, 42629, 42628, 42627, 42626, 42625, 42606, 42605, 42604, 42603, 42602, 42601, 42600, 42599, 42598, 42597, 42596, 42595, 42594, 42593, 42592, 42591, 42590, 42589, 42588, 42587, 42586, 42585, 42584, 42583, 42582, 42581, 42580, 42579, 42578, 42577, 42576, 42575, 42574, 42573, 42572, 42571, 42570, 42569, 42568, 42567, 42566, 42565, 42564, 42563, 42562, 42561, 11566, 11565, 11560, 11559, 11558, 11520, 11508, 11507, 11503, 11502, 11501, 11500, 11493, 11491, 11490, 11489, 11488, 11487, 11486, 11485, 11484, 11483, 11482, 11481, 11480, 11479, 11478, 11477, 11476, 11475, 11474, 11473, 11472, 11471, 11470, 11469, 11468, 11467, 11466, 11465, 11464, 11463, 11462, 11461, 11460, 11459, 11458, 11457, 11456, 11455, 11454, 11453, 11452, 11451, 11450, 11449, 11448, 11447, 11446, 11445, 11444, 11443, 11442, 11441, 11440, 11439, 11438, 11437, 11436, 11435, 11434, 11433, 11432, 11431, 11430, 11429, 11428, 11427, 11426, 11425, 11424, 11423, 11422, 11421, 11420, 11419, 11418, 11417, 11416, 11415, 11414, 11413, 11412, 11411, 11410, 11409, 11408, 11407, 11406, 11405, 11404, 11403, 11402, 11401, 11400, 11399, 11398, 11397, 11396, 11395, 11394, 11393, 11390, 11382, 11381, 11379, 11378, 11377, 11373, 11372, 11371, 11370, 11369, 11368, 11367, 11365, 11362, 11361, 11359, 11312, 9450, 9424, 8581, 8580, 8576, 8560, 8527, 8526, 8522, 8518, 8510, 8508, 8506, 8505, 8501, 8500, 8496, 8495, 8468, 8467, 8464, 8462, 8459, 8458, 8349, 8336, 8320, 8319, 8306, 8305, 8184, 8182, 8181, 8178, 8168, 8160, 8152, 8150, 8148, 8144, 8136, 8134, 8133, 8130, 8127, 8126, 8120, 8118, 8117, 8112, 8104, 8096, 8088, 8080, 8072, 8064, 8062, 8048, 8040, 8032, 8024, 8016, 8006, 8000, 7992, 7984, 7976, 7968, 7958, 7952, 7944, 7935, 7934, 7933, 7932, 7931, 7930, 7929, 7928, 7927, 7926, 7925, 7924, 7923, 7922, 7921, 7920, 7919, 7918, 7917, 7916, 7915, 7914, 7913, 7912, 7911, 7910, 7909, 7908, 7907, 7906, 7905, 7904, 7903, 7902, 7901, 7900, 7899, 7898, 7897, 7896, 7895, 7894, 7893, 7892, 7891, 7890, 7889, 7888, 7887, 7886, 7885, 7884, 7883, 7882, 7881, 7880, 7879, 7878, 7877, 7876, 7875, 7874, 7873, 7872, 7871, 7870, 7869, 7868, 7867, 7866, 7865, 7864, 7863, 7862, 7861, 7860, 7859, 7858, 7857, 7856, 7855, 7854, 7853, 7852, 7851, 7850, 7849, 7848, 7847, 7846, 7845, 7844, 7843, 7842, 7841, 7840, 7839, 7838, 7829, 7828, 7827, 7826, 7825, 7824, 7823, 7822, 7821, 7820, 7819, 7818, 7817, 7816, 7815, 7814, 7813, 7812, 7811, 7810, 7809, 7808, 7807, 7806, 7805, 7804, 7803, 7802, 7801, 7800, 7799, 7798, 7797, 7796, 7795, 7794, 7793, 7792, 7791, 7790, 7789, 7788, 7787, 7786, 7785, 7784, 7783, 7782, 7781, 7780, 7779, 7778, 7777, 7776, 7775, 7774, 7773, 7772, 7771, 7770, 7769, 7768, 7767, 7766, 7765, 7764, 7763, 7762, 7761, 7760, 7759, 7758, 7757, 7756, 7755, 7754, 7753, 7752, 7751, 7750, 7749, 7748, 7747, 7746, 7745, 7744, 7743, 7742, 7741, 7740, 7739, 7738, 7737, 7736, 7735, 7734, 7733, 7732, 7731, 7730, 7729, 7728, 7727, 7726, 7725, 7724, 7723, 7722, 7721, 7720, 7719, 7718, 7717, 7716, 7715, 7714, 7713, 7712, 7711, 7710, 7709, 7708, 7707, 7706, 7705, 7704, 7703, 7702, 7701, 7700, 7699, 7698, 7697, 7696, 7695, 7694, 7693, 7692, 7691, 7690, 7689, 7688, 7687, 7686, 7685, 7684, 7683, 7682, 7681, 7616, 7424, 1416, 1377, 1320, 1319, 1318, 1317, 1316, 1315, 1314, 1313, 1312, 1311, 1310, 1309, 1308, 1307, 1306, 1305, 1304, 1303, 1302, 1301, 1300, 1299, 1298, 1297, 1296, 1295, 1294, 1293, 1292, 1291, 1290, 1289, 1288, 1287, 1286, 1285, 1284, 1283, 1282, 1281, 1280, 1279, 1278, 1277, 1276, 1275, 1274, 1273, 1272, 1271, 1270, 1269, 1268, 1267, 1266, 1265, 1264, 1263, 1262, 1261, 1260, 1259, 1258, 1257, 1256, 1255, 1254, 1253, 1252, 1251, 1250, 1249, 1248, 1247, 1246, 1245, 1244, 1243, 1242, 1241, 1240, 1239, 1238, 1237, 1236, 1235, 1234, 1233, 1232, 1230, 1229, 1228, 1227, 1226, 1225, 1224, 1223, 1222, 1221, 1220, 1219, 1218, 1216, 1215, 1214, 1213, 1212, 1211, 1210, 1209, 1208, 1207, 1206, 1205, 1204, 1203, 1202, 1201, 1200, 1199, 1198, 1197, 1196, 1195, 1194, 1193, 1192, 1191, 1190, 1189, 1188, 1187, 1186, 1185, 1184, 1183, 1182, 1181, 1180, 1179, 1178, 1177, 1176, 1175, 1174, 1173, 1172, 1171, 1170, 1169, 1168, 1167, 1166, 1165, 1164, 1163, 1154, 1153, 1152, 1151, 1150, 1149, 1148, 1147, 1146, 1145, 1144, 1143, 1142, 1141, 1140, 1139, 1138, 1137, 1136, 1135, 1134, 1133, 1132, 1131, 1130, 1129, 1128, 1127, 1126, 1125, 1124, 1123, 1122, 1121, 1120, 1072, 1021, 1019, 1017, 1016, 1014, 1013, 1012, 1007, 1006, 1005, 1004, 1003, 1002, 1001, 1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 981, 978, 976, 975, 940, 913, 912, 894, 890, 888, 887, 884, 883, 882, 881, 838, 837, 741, 736, 706, 704, 697, 661, 660, 591, 590, 589, 588, 587, 586, 585, 584, 583, 579, 578, 577, 575, 573, 572, 570, 563, 562, 561, 560, 559, 558, 557, 556, 555, 554, 553, 552, 551, 550, 549, 548, 547, 546, 545, 544, 543, 542, 541, 540, 539, 538, 537, 536, 535, 534, 533, 532, 531, 530, 529, 528, 527, 526, 525, 524, 523, 522, 521, 520, 519, 518, 517, 516, 515, 514, 513, 512, 511, 510, 509, 508, 507, 506, 505, 502, 501, 500, 499, 497, 495, 494, 493, 492, 491, 490, 489, 488, 487, 486, 485, 484, 483, 482, 481, 480, 479, 478, 476, 475, 474, 473, 472, 471, 470, 469, 468, 467, 466, 465, 464, 463, 462, 461, 460, 458, 457, 455, 454, 448, 445, 443, 441, 439, 438, 437, 436, 433, 432, 430, 429, 428, 426, 425, 424, 422, 421, 420, 419, 418, 417, 415, 414, 412, 409, 406, 405, 403, 402, 398, 396, 393, 392, 390, 389, 388, 387, 385, 382, 381, 380, 379, 378, 376, 375, 374, 373, 372, 371, 370, 369, 368, 367, 366, 365, 364, 363, 362, 361, 360, 359, 358, 357, 356, 355, 354, 353, 352, 351, 350, 349, 348, 347, 346, 345, 344, 343, 342, 341, 340, 339, 338, 337, 336, 335, 334, 333, 332, 331, 330, 328, 327, 326, 325, 324, 323, 322, 321, 320, 319, 318, 317, 316, 315, 314, 313, 311, 310, 309, 308, 307, 306, 305, 304, 303, 302, 301, 300, 299, 298, 297, 296, 295, 294, 293, 292, 291, 290, 289, 288, 287, 286, 285, 284, 283, 282, 281, 280, 279, 278, 277, 276, 275, 274, 273, 272, 271, 270, 269, 268, 267, 266, 265, 264, 263, 262, 261, 260, 259, 258, 257, 256, 248, 247, 223, 187, 186, 182, 181, 171, 170, 123, 97 };
    





















































































    $Pcupper$Mncase = new int[] { 120779, 120778, 120745, 120720, 120687, 120662, 120629, 120604, 120571, 120546, 120513, 120488, 120458, 120432, 120406, 120380, 120354, 120328, 120302, 120276, 120250, 120224, 120198, 120172, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120120, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120068, 120042, 120016, 119990, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119964, 119938, 119912, 119886, 119860, 119834, 119808, 66600, 66560, 65339, 65313, 42923, 42922, 42921, 42920, 42919, 42918, 42917, 42916, 42915, 42914, 42913, 42912, 42899, 42898, 42897, 42896, 42894, 42893, 42892, 42891, 42887, 42886, 42885, 42884, 42883, 42882, 42881, 42880, 42879, 42877, 42876, 42875, 42874, 42873, 42863, 42862, 42861, 42860, 42859, 42858, 42857, 42856, 42855, 42854, 42853, 42852, 42851, 42850, 42849, 42848, 42847, 42846, 42845, 42844, 42843, 42842, 42841, 42840, 42839, 42838, 42837, 42836, 42835, 42834, 42833, 42832, 42831, 42830, 42829, 42828, 42827, 42826, 42825, 42824, 42823, 42822, 42821, 42820, 42819, 42818, 42817, 42816, 42815, 42814, 42813, 42812, 42811, 42810, 42809, 42808, 42807, 42806, 42805, 42804, 42803, 42802, 42799, 42798, 42797, 42796, 42795, 42794, 42793, 42792, 42791, 42790, 42789, 42788, 42787, 42786, 42647, 42646, 42645, 42644, 42643, 42642, 42641, 42640, 42639, 42638, 42637, 42636, 42635, 42634, 42633, 42632, 42631, 42630, 42629, 42628, 42627, 42626, 42625, 42624, 42605, 42604, 42603, 42602, 42601, 42600, 42599, 42598, 42597, 42596, 42595, 42594, 42593, 42592, 42591, 42590, 42589, 42588, 42587, 42586, 42585, 42584, 42583, 42582, 42581, 42580, 42579, 42578, 42577, 42576, 42575, 42574, 42573, 42572, 42571, 42570, 42569, 42568, 42567, 42566, 42565, 42564, 42563, 42562, 42561, 42560, 11507, 11506, 11502, 11501, 11500, 11499, 11491, 11490, 11489, 11488, 11487, 11486, 11485, 11484, 11483, 11482, 11481, 11480, 11479, 11478, 11477, 11476, 11475, 11474, 11473, 11472, 11471, 11470, 11469, 11468, 11467, 11466, 11465, 11464, 11463, 11462, 11461, 11460, 11459, 11458, 11457, 11456, 11455, 11454, 11453, 11452, 11451, 11450, 11449, 11448, 11447, 11446, 11445, 11444, 11443, 11442, 11441, 11440, 11439, 11438, 11437, 11436, 11435, 11434, 11433, 11432, 11431, 11430, 11429, 11428, 11427, 11426, 11425, 11424, 11423, 11422, 11421, 11420, 11419, 11418, 11417, 11416, 11415, 11414, 11413, 11412, 11411, 11410, 11409, 11408, 11407, 11406, 11405, 11404, 11403, 11402, 11401, 11400, 11399, 11398, 11397, 11396, 11395, 11394, 11393, 11390, 11382, 11381, 11379, 11378, 11377, 11373, 11372, 11371, 11370, 11369, 11368, 11367, 11365, 11362, 11361, 11360, 11311, 11264, 9424, 9398, 8580, 8579, 8560, 8544, 8518, 8517, 8512, 8510, 8500, 8496, 8494, 8490, 8489, 8488, 8487, 8486, 8485, 8484, 8478, 8473, 8470, 8469, 8467, 8464, 8462, 8459, 8456, 8455, 8451, 8450, 8188, 8184, 8173, 8168, 8156, 8152, 8140, 8136, 8124, 8120, 8048, 8040, 8032, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8014, 8008, 8000, 7992, 7984, 7976, 7966, 7960, 7952, 7944, 7935, 7934, 7933, 7932, 7931, 7930, 7929, 7928, 7927, 7926, 7925, 7924, 7923, 7922, 7921, 7920, 7919, 7918, 7917, 7916, 7915, 7914, 7913, 7912, 7911, 7910, 7909, 7908, 7907, 7906, 7905, 7904, 7903, 7902, 7901, 7900, 7899, 7898, 7897, 7896, 7895, 7894, 7893, 7892, 7891, 7890, 7889, 7888, 7887, 7886, 7885, 7884, 7883, 7882, 7881, 7880, 7879, 7878, 7877, 7876, 7875, 7874, 7873, 7872, 7871, 7870, 7869, 7868, 7867, 7866, 7865, 7864, 7863, 7862, 7861, 7860, 7859, 7858, 7857, 7856, 7855, 7854, 7853, 7852, 7851, 7850, 7849, 7848, 7847, 7846, 7845, 7844, 7843, 7842, 7841, 7840, 7839, 7838, 7829, 7828, 7827, 7826, 7825, 7824, 7823, 7822, 7821, 7820, 7819, 7818, 7817, 7816, 7815, 7814, 7813, 7812, 7811, 7810, 7809, 7808, 7807, 7806, 7805, 7804, 7803, 7802, 7801, 7800, 7799, 7798, 7797, 7796, 7795, 7794, 7793, 7792, 7791, 7790, 7789, 7788, 7787, 7786, 7785, 7784, 7783, 7782, 7781, 7780, 7779, 7778, 7777, 7776, 7775, 7774, 7773, 7772, 7771, 7770, 7769, 7768, 7767, 7766, 7765, 7764, 7763, 7762, 7761, 7760, 7759, 7758, 7757, 7756, 7755, 7754, 7753, 7752, 7751, 7750, 7749, 7748, 7747, 7746, 7745, 7744, 7743, 7742, 7741, 7740, 7739, 7738, 7737, 7736, 7735, 7734, 7733, 7732, 7731, 7730, 7729, 7728, 7727, 7726, 7725, 7724, 7723, 7722, 7721, 7720, 7719, 7718, 7717, 7716, 7715, 7714, 7713, 7712, 7711, 7710, 7709, 7708, 7707, 7706, 7705, 7704, 7703, 7702, 7701, 7700, 7699, 7698, 7697, 7696, 7695, 7694, 7693, 7692, 7691, 7690, 7689, 7688, 7687, 7686, 7685, 7684, 7683, 7682, 7681, 7680, 4302, 4301, 4296, 4295, 4294, 4256, 1367, 1329, 1319, 1318, 1317, 1316, 1315, 1314, 1313, 1312, 1311, 1310, 1309, 1308, 1307, 1306, 1305, 1304, 1303, 1302, 1301, 1300, 1299, 1298, 1297, 1296, 1295, 1294, 1293, 1292, 1291, 1290, 1289, 1288, 1287, 1286, 1285, 1284, 1283, 1282, 1281, 1280, 1279, 1278, 1277, 1276, 1275, 1274, 1273, 1272, 1271, 1270, 1269, 1268, 1267, 1266, 1265, 1264, 1263, 1262, 1261, 1260, 1259, 1258, 1257, 1256, 1255, 1254, 1253, 1252, 1251, 1250, 1249, 1248, 1247, 1246, 1245, 1244, 1243, 1242, 1241, 1240, 1239, 1238, 1237, 1236, 1235, 1234, 1233, 1232, 1230, 1229, 1228, 1227, 1226, 1225, 1224, 1223, 1222, 1221, 1220, 1219, 1218, 1216, 1215, 1214, 1213, 1212, 1211, 1210, 1209, 1208, 1207, 1206, 1205, 1204, 1203, 1202, 1201, 1200, 1199, 1198, 1197, 1196, 1195, 1194, 1193, 1192, 1191, 1190, 1189, 1188, 1187, 1186, 1185, 1184, 1183, 1182, 1181, 1180, 1179, 1178, 1177, 1176, 1175, 1174, 1173, 1172, 1171, 1170, 1169, 1168, 1167, 1166, 1165, 1164, 1163, 1162, 1153, 1152, 1151, 1150, 1149, 1148, 1147, 1146, 1145, 1144, 1143, 1142, 1141, 1140, 1139, 1138, 1137, 1136, 1135, 1134, 1133, 1132, 1131, 1130, 1129, 1128, 1127, 1126, 1125, 1124, 1123, 1122, 1121, 1120, 1072, 1021, 1019, 1017, 1016, 1015, 1013, 1012, 1007, 1006, 1005, 1004, 1003, 1002, 1001, 1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 981, 978, 976, 975, 940, 931, 930, 913, 912, 910, 909, 908, 907, 904, 903, 902, 887, 886, 883, 882, 881, 880, 591, 590, 589, 588, 587, 586, 585, 584, 583, 579, 578, 577, 575, 573, 572, 570, 563, 562, 561, 560, 559, 558, 557, 556, 555, 554, 553, 552, 551, 550, 549, 548, 547, 546, 545, 544, 543, 542, 541, 540, 539, 538, 537, 536, 535, 534, 533, 532, 531, 530, 529, 528, 527, 526, 525, 524, 523, 522, 521, 520, 519, 518, 517, 516, 515, 514, 513, 512, 511, 510, 509, 508, 507, 506, 505, 502, 501, 500, 498, 497, 495, 494, 493, 492, 491, 490, 489, 488, 487, 486, 485, 484, 483, 482, 481, 480, 479, 478, 476, 475, 474, 473, 472, 471, 470, 469, 468, 467, 466, 465, 464, 463, 462, 461, 459, 458, 456, 455, 453, 452, 445, 444, 441, 439, 438, 437, 436, 433, 432, 430, 429, 428, 426, 425, 424, 422, 421, 420, 419, 418, 417, 415, 414, 412, 409, 406, 405, 403, 402, 398, 396, 393, 392, 390, 389, 388, 387, 385, 382, 381, 380, 379, 378, 376, 375, 374, 373, 372, 371, 370, 369, 368, 367, 366, 365, 364, 363, 362, 361, 360, 359, 358, 357, 356, 355, 354, 353, 352, 351, 350, 349, 348, 347, 346, 345, 344, 343, 342, 341, 340, 339, 338, 337, 336, 335, 334, 333, 332, 331, 330, 328, 327, 326, 325, 324, 323, 322, 321, 320, 319, 318, 317, 316, 315, 314, 313, 311, 310, 309, 308, 307, 306, 305, 304, 303, 302, 301, 300, 299, 298, 297, 296, 295, 294, 293, 292, 291, 290, 289, 288, 287, 286, 285, 284, 283, 282, 281, 280, 279, 278, 277, 276, 275, 274, 273, 272, 271, 270, 269, 268, 267, 266, 265, 264, 263, 262, 261, 260, 259, 258, 257, 256, 223, 216, 215, 192, 91, 65 };
    




















































































    $Pcletter = new int[] { 195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120780, 120772, 120771, 120746, 120745, 120714, 120713, 120688, 120687, 120656, 120655, 120630, 120629, 120598, 120597, 120572, 120571, 120540, 120539, 120514, 120513, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74607, 73728, 71339, 71296, 70085, 70081, 70067, 70019, 69927, 69891, 69865, 69840, 69808, 69763, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68416, 68406, 68352, 68221, 68192, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67898, 67872, 67862, 67840, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66718, 66560, 66512, 66504, 66500, 66464, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65382, 65371, 65345, 65339, 65313, 65277, 65142, 65141, 65136, 65020, 65008, 64968, 64914, 64912, 64848, 64830, 64467, 64434, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64298, 64297, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43762, 43755, 43744, 43742, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43642, 43639, 43616, 43596, 43588, 43587, 43584, 43561, 43520, 43472, 43471, 43443, 43396, 43389, 43360, 43335, 43312, 43302, 43274, 43260, 43259, 43256, 43250, 43188, 43138, 43124, 43072, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42891, 42889, 42786, 42784, 42775, 42726, 42656, 42648, 42623, 42607, 42560, 42540, 42538, 42528, 42512, 42509, 42240, 42238, 42192, 42125, 40960, 40909, 19968, 19894, 13312, 12800, 12784, 12731, 12704, 12687, 12593, 12590, 12549, 12544, 12540, 12539, 12449, 12448, 12445, 12439, 12353, 12349, 12347, 12342, 12337, 12295, 12293, 11824, 11823, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11632, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11520, 11508, 11506, 11503, 11499, 11493, 11360, 11359, 11312, 11311, 11264, 8581, 8579, 8527, 8526, 8522, 8517, 8512, 8508, 8506, 8495, 8494, 8490, 8489, 8488, 8487, 8486, 8485, 8484, 8478, 8473, 8470, 8469, 8468, 8458, 8456, 8455, 8451, 8450, 8349, 8336, 8320, 8319, 8306, 8305, 8189, 8182, 8181, 8178, 8173, 8160, 8156, 8150, 8148, 8144, 8141, 8134, 8133, 8130, 8127, 8126, 8125, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7294, 7258, 7248, 7245, 7204, 7168, 7142, 7098, 7088, 7086, 7073, 7043, 6988, 6981, 6964, 6917, 6824, 6823, 6741, 6688, 6679, 6656, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6480, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6109, 6108, 6104, 6103, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5938, 5920, 5906, 5902, 5901, 5888, 5867, 5792, 5787, 5761, 5760, 5743, 5741, 5121, 5109, 5024, 5008, 4992, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4348, 4347, 4304, 4302, 4301, 4296, 4295, 4294, 4256, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4176, 4160, 4159, 4139, 4096, 3981, 3976, 3949, 3913, 3912, 3904, 3841, 3840, 3808, 3804, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3655, 3648, 3636, 3634, 3633, 3585, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3450, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2929, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2546, 2544, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2417, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2137, 2112, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2042, 2038, 2036, 2027, 1994, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1792, 1791, 1789, 1786, 1776, 1774, 1767, 1765, 1750, 1749, 1748, 1649, 1648, 1646, 1611, 1568, 1523, 1520, 1515, 1488, 1416, 1377, 1370, 1369, 1367, 1329, 1320, 1162, 1154, 1015, 1014, 931, 930, 910, 909, 908, 907, 904, 903, 902, 894, 890, 888, 886, 885, 880, 751, 750, 749, 748, 741, 736, 722, 710, 706, 248, 247, 216, 215, 192, 187, 186, 182, 181, 171, 170, 123, 97, 91, 65 };
    









































































    $Pcdigit = new int[] { 120832, 120782, 71370, 71360, 70106, 70096, 69952, 69942, 69882, 69872, 69744, 69734, 66730, 66720, 65306, 65296, 44026, 44016, 43610, 43600, 43482, 43472, 43274, 43264, 43226, 43216, 42538, 42528, 7258, 7248, 7242, 7232, 7098, 7088, 7002, 6992, 6810, 6800, 6794, 6784, 6618, 6608, 6480, 6470, 6170, 6160, 6122, 6112, 4250, 4240, 4170, 4160, 3882, 3872, 3802, 3792, 3674, 3664, 3440, 3430, 3312, 3302, 3184, 3174, 3056, 3046, 2928, 2918, 2800, 2790, 2672, 2662, 2544, 2534, 2416, 2406, 1994, 1984, 1786, 1776, 1642, 1632, 58, 48 };
    






    $Pcpunctuation = new int[] { 74868, 74864, 70089, 70085, 69956, 69952, 69826, 69822, 69821, 69819, 69710, 69703, 68416, 68409, 68224, 68223, 68185, 68176, 67904, 67903, 67872, 67871, 67672, 67671, 66513, 66512, 66464, 66463, 65795, 65792, 65382, 65375, 65374, 65373, 65372, 65371, 65344, 65343, 65342, 65339, 65313, 65311, 65308, 65306, 65296, 65292, 65291, 65285, 65284, 65281, 65132, 65130, 65129, 65128, 65124, 65123, 65122, 65108, 65107, 65072, 65050, 65040, 64832, 64830, 44012, 44011, 43762, 43760, 43744, 43742, 43616, 43612, 43488, 43486, 43470, 43457, 43360, 43359, 43312, 43310, 43259, 43256, 43216, 43214, 43128, 43124, 42744, 42738, 42623, 42622, 42612, 42611, 42512, 42509, 42240, 42238, 12540, 12539, 12449, 12448, 12350, 12349, 12337, 12336, 12320, 12308, 12306, 12296, 12292, 12289, 11836, 11824, 11823, 11776, 11633, 11632, 11520, 11518, 11517, 11513, 10750, 10748, 10716, 10712, 10649, 10627, 10224, 10214, 10183, 10181, 10102, 10088, 9003, 9001, 8335, 8333, 8319, 8317, 8287, 8275, 8274, 8261, 8260, 8240, 8232, 8208, 7380, 7379, 7368, 7360, 7296, 7294, 7232, 7227, 7168, 7164, 7009, 7002, 6830, 6824, 6823, 6816, 6688, 6686, 6470, 6468, 6155, 6144, 6107, 6104, 6103, 6100, 5943, 5941, 5870, 5867, 5789, 5787, 5743, 5741, 5121, 5120, 4969, 4960, 4348, 4347, 4176, 4170, 4059, 4057, 4053, 4048, 3974, 3973, 3902, 3898, 3861, 3860, 3859, 3844, 3676, 3674, 3664, 3663, 3573, 3572, 2801, 2800, 2417, 2416, 2406, 2404, 2143, 2142, 2111, 2096, 2042, 2039, 1806, 1792, 1749, 1748, 1646, 1642, 1568, 1566, 1564, 1563, 1550, 1548, 1547, 1545, 1525, 1523, 1479, 1478, 1476, 1475, 1473, 1472, 1471, 1470, 1419, 1417, 1376, 1370, 904, 903, 895, 894, 192, 191, 188, 187, 184, 182, 172, 171, 168, 167, 162, 161, 126, 125, 124, 123, 96, 95, 94, 91, 65, 63, 60, 58, 48, 44, 43, 37, 36, 33 };
    




















    $Pcsymbol = new int[] { 128884, 128768, 128710, 128640, 128592, 128581, 128577, 128507, 128360, 128336, 128324, 128320, 128318, 128256, 128253, 128249, 128248, 128066, 128065, 128064, 128063, 128000, 127985, 127968, 127947, 127942, 127941, 127904, 127892, 127872, 127869, 127799, 127798, 127792, 127777, 127744, 127570, 127568, 127561, 127552, 127547, 127504, 127491, 127462, 127387, 127344, 127340, 127280, 127279, 127248, 127200, 127185, 127184, 127169, 127167, 127153, 127151, 127136, 127124, 127024, 127020, 126976, 126706, 126704, 120772, 120771, 120746, 120745, 120714, 120713, 120688, 120687, 120656, 120655, 120630, 120629, 120598, 120597, 120572, 120571, 120540, 120539, 120514, 120513, 119639, 119552, 119366, 119365, 119362, 119296, 119262, 119214, 119210, 119180, 119173, 119171, 119149, 119146, 119141, 119081, 119079, 119040, 119030, 118784, 66045, 66000, 65948, 65936, 65930, 65913, 65856, 65847, 65534, 65532, 65519, 65512, 65511, 65504, 65375, 65374, 65373, 65372, 65345, 65344, 65343, 65342, 65311, 65308, 65292, 65291, 65285, 65284, 65130, 65129, 65127, 65124, 65123, 65122, 65022, 65020, 64450, 64434, 64298, 64297, 43642, 43639, 43066, 43062, 43052, 43048, 42891, 42889, 42786, 42784, 42775, 42752, 42183, 42128, 19968, 19904, 13312, 13056, 13055, 12992, 12977, 12938, 12928, 12896, 12881, 12880, 12872, 12842, 12831, 12800, 12772, 12736, 12704, 12694, 12690, 12688, 12445, 12443, 12352, 12350, 12344, 12342, 12321, 12320, 12308, 12306, 12293, 12292, 12284, 12272, 12246, 12032, 12020, 11931, 11930, 11904, 11499, 11493, 11098, 11088, 11085, 10750, 10748, 10716, 10712, 10649, 10627, 10224, 10214, 10183, 10181, 10132, 10088, 9985, 9984, 9472, 9450, 9372, 9291, 9280, 9255, 9216, 9204, 9003, 9001, 8592, 8528, 8527, 8526, 8522, 8517, 8512, 8508, 8506, 8495, 8494, 8490, 8489, 8488, 8487, 8486, 8485, 8484, 8478, 8473, 8470, 8469, 8468, 8458, 8456, 8455, 8451, 8450, 8448, 8379, 8352, 8333, 8330, 8317, 8314, 8275, 8274, 8261, 8260, 8191, 8189, 8176, 8173, 8160, 8157, 8144, 8141, 8130, 8127, 8126, 8125, 7037, 7028, 7019, 7009, 6656, 6622, 6465, 6464, 6108, 6107, 5018, 5008, 4256, 4254, 4057, 4053, 4048, 4046, 4045, 4039, 4038, 4030, 3897, 3896, 3895, 3894, 3893, 3892, 3872, 3866, 3864, 3861, 3860, 3859, 3844, 3841, 3648, 3647, 3450, 3449, 3200, 3199, 3067, 3059, 2929, 2928, 2802, 2801, 2556, 2554, 2548, 2546, 2039, 2038, 1791, 1789, 1770, 1769, 1759, 1758, 1552, 1550, 1548, 1547, 1545, 1542, 1424, 1423, 1155, 1154, 1015, 1014, 902, 900, 886, 885, 768, 751, 750, 749, 748, 741, 736, 722, 710, 706, 248, 247, 216, 215, 185, 184, 181, 180, 178, 174, 173, 172, 170, 168, 167, 162, 127, 126, 125, 124, 97, 96, 95, 94, 63, 60, 44, 43, 37, 36 };
    































    $Pcletter$Pldigit = new int[] { 195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120832, 120782, 120780, 120772, 120771, 120746, 120745, 120714, 120713, 120688, 120687, 120656, 120655, 120630, 120629, 120598, 120597, 120572, 120571, 120540, 120539, 120514, 120513, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74607, 73728, 71370, 71360, 71339, 71296, 70106, 70096, 70085, 70081, 70067, 70019, 69952, 69942, 69927, 69891, 69882, 69872, 69865, 69840, 69808, 69763, 69744, 69734, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68416, 68406, 68352, 68221, 68192, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67898, 67872, 67862, 67840, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66730, 66720, 66718, 66560, 66512, 66504, 66500, 66464, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65382, 65371, 65345, 65339, 65313, 65306, 65296, 65277, 65142, 65141, 65136, 65020, 65008, 64968, 64914, 64912, 64848, 64830, 64467, 64434, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64298, 64297, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44026, 44016, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43762, 43755, 43744, 43742, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43642, 43639, 43616, 43610, 43600, 43596, 43588, 43587, 43584, 43561, 43520, 43482, 43471, 43443, 43396, 43389, 43360, 43335, 43312, 43302, 43264, 43260, 43259, 43256, 43250, 43226, 43216, 43188, 43138, 43124, 43072, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42891, 42889, 42786, 42784, 42775, 42726, 42656, 42648, 42623, 42607, 42560, 42540, 42512, 42509, 42240, 42238, 42192, 42125, 40960, 40909, 19968, 19894, 13312, 12800, 12784, 12731, 12704, 12687, 12593, 12590, 12549, 12544, 12540, 12539, 12449, 12448, 12445, 12439, 12353, 12349, 12347, 12342, 12337, 12295, 12293, 11824, 11823, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11632, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11520, 11508, 11506, 11503, 11499, 11493, 11360, 11359, 11312, 11311, 11264, 8581, 8579, 8527, 8526, 8522, 8517, 8512, 8508, 8506, 8495, 8494, 8490, 8489, 8488, 8487, 8486, 8485, 8484, 8478, 8473, 8470, 8469, 8468, 8458, 8456, 8455, 8451, 8450, 8349, 8336, 8320, 8319, 8306, 8305, 8189, 8182, 8181, 8178, 8173, 8160, 8156, 8150, 8148, 8144, 8141, 8134, 8133, 8130, 8127, 8126, 8125, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7294, 7245, 7242, 7232, 7204, 7168, 7142, 7086, 7073, 7043, 7002, 6992, 6988, 6981, 6964, 6917, 6824, 6823, 6810, 6800, 6794, 6784, 6741, 6688, 6679, 6656, 6618, 6608, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6470, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6170, 6160, 6122, 6112, 6109, 6108, 6104, 6103, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5938, 5920, 5906, 5902, 5901, 5888, 5867, 5792, 5787, 5761, 5760, 5743, 5741, 5121, 5109, 5024, 5008, 4992, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4348, 4347, 4304, 4302, 4301, 4296, 4295, 4294, 4256, 4250, 4240, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4176, 4170, 4159, 4139, 4096, 3981, 3976, 3949, 3913, 3912, 3904, 3882, 3872, 3841, 3840, 3808, 3804, 3802, 3792, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3674, 3664, 3655, 3648, 3636, 3634, 3633, 3585, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3450, 3440, 3430, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3312, 3302, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3184, 3174, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3056, 3046, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2929, 2928, 2918, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2800, 2790, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2672, 2662, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2546, 2534, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2417, 2416, 2406, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2137, 2112, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2042, 2038, 2036, 2027, 1984, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1792, 1791, 1789, 1774, 1767, 1765, 1750, 1749, 1748, 1649, 1648, 1646, 1642, 1632, 1611, 1568, 1523, 1520, 1515, 1488, 1416, 1377, 1370, 1369, 1367, 1329, 1320, 1162, 1154, 1015, 1014, 931, 930, 910, 909, 908, 907, 904, 903, 902, 894, 890, 888, 886, 885, 880, 751, 750, 749, 748, 741, 736, 722, 710, 706, 248, 247, 216, 215, 192, 187, 186, 182, 181, 171, 170, 123, 97, 91, 65, 58, 48 };
    














































































    $Pcgraphic = new int[] { 195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 128884, 128768, 128710, 128640, 128592, 128581, 128577, 128507, 128360, 128336, 128324, 128320, 128318, 128256, 128253, 128249, 128248, 128066, 128065, 128064, 128063, 128000, 127985, 127968, 127947, 127942, 127941, 127904, 127892, 127872, 127869, 127799, 127798, 127792, 127777, 127744, 127570, 127568, 127561, 127552, 127547, 127504, 127491, 127462, 127387, 127344, 127340, 127280, 127279, 127248, 127200, 127185, 127184, 127169, 127167, 127153, 127151, 127136, 127124, 127024, 127020, 126976, 126706, 126704, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120832, 120782, 120780, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 119639, 119552, 119366, 119365, 119362, 119296, 119262, 119214, 119210, 119180, 119173, 119171, 119149, 119146, 119141, 119081, 119079, 119040, 119030, 118784, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74868, 74864, 74607, 73728, 71370, 71360, 71339, 71296, 70106, 70096, 70089, 70081, 70067, 70019, 69956, 69942, 69927, 69891, 69882, 69872, 69865, 69840, 69826, 69822, 69821, 69819, 69808, 69763, 69744, 69734, 69710, 69703, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68409, 68406, 68352, 68224, 68223, 68221, 68192, 68185, 68176, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67904, 67903, 67898, 67871, 67862, 67840, 67672, 67671, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66730, 66720, 66718, 66560, 66513, 66504, 66500, 66463, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 66045, 66000, 65948, 65936, 65930, 65913, 65856, 65847, 65795, 65792, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65534, 65532, 65519, 65512, 65511, 65504, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65281, 65277, 65142, 65141, 65136, 65132, 65128, 65127, 65108, 65107, 65072, 65050, 65040, 65022, 65008, 64968, 64914, 64912, 64848, 64832, 64467, 64450, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44026, 44016, 44012, 44011, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43760, 43755, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43612, 43610, 43600, 43596, 43588, 43587, 43584, 43561, 43520, 43488, 43486, 43482, 43471, 43470, 43457, 43443, 43396, 43389, 43359, 43335, 43310, 43302, 43264, 43260, 43250, 43226, 43214, 43188, 43138, 43128, 43072, 43066, 43062, 43052, 43048, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42752, 42744, 42738, 42726, 42656, 42648, 42622, 42612, 42611, 42607, 42560, 42540, 42192, 42183, 42128, 42125, 40960, 40909, 19904, 19894, 13056, 13055, 12992, 12977, 12938, 12928, 12896, 12881, 12880, 12872, 12842, 12831, 12784, 12772, 12736, 12731, 12694, 12690, 12688, 12687, 12593, 12590, 12549, 12544, 12443, 12439, 12353, 12352, 12347, 12344, 12336, 12321, 12296, 12295, 12289, 12284, 12272, 12246, 12032, 12020, 11931, 11930, 11904, 11836, 11776, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11633, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11518, 11517, 11513, 11508, 11506, 11503, 11360, 11359, 11312, 11311, 11264, 11098, 11088, 11085, 10132, 10102, 9985, 9984, 9472, 9450, 9372, 9291, 9280, 9255, 9216, 9204, 8592, 8581, 8579, 8528, 8448, 8379, 8352, 8349, 8336, 8335, 8330, 8320, 8314, 8306, 8305, 8287, 8240, 8232, 8208, 8191, 8182, 8181, 8178, 8176, 8157, 8156, 8150, 8148, 8134, 8133, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7380, 7379, 7368, 7360, 7296, 7245, 7242, 7227, 7204, 7164, 7142, 7086, 7073, 7043, 7037, 7028, 7019, 6992, 6988, 6981, 6964, 6917, 6830, 6816, 6810, 6800, 6794, 6784, 6741, 6686, 6679, 6622, 6618, 6608, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6468, 6465, 6464, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6170, 6160, 6155, 6144, 6122, 6112, 6109, 6100, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5943, 5941, 5938, 5920, 5906, 5902, 5901, 5888, 5870, 5792, 5789, 5761, 5760, 5120, 5109, 5024, 5018, 4992, 4969, 4960, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4304, 4302, 4301, 4296, 4295, 4294, 4254, 4250, 4240, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4159, 4139, 4096, 4059, 4046, 4045, 4039, 4038, 4030, 3981, 3976, 3974, 3973, 3949, 3913, 3912, 3904, 3902, 3898, 3897, 3896, 3895, 3894, 3893, 3892, 3882, 3866, 3864, 3840, 3808, 3804, 3802, 3792, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3676, 3663, 3655, 3647, 3636, 3634, 3633, 3585, 3573, 3572, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3449, 3440, 3430, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3312, 3302, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3200, 3199, 3184, 3174, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3067, 3059, 3056, 3046, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2918, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2802, 2790, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2672, 2662, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2556, 2554, 2548, 2534, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2404, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2143, 2142, 2137, 2112, 2111, 2096, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2036, 2027, 1984, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1806, 1774, 1770, 1769, 1767, 1765, 1759, 1758, 1750, 1649, 1648, 1632, 1611, 1566, 1564, 1563, 1552, 1542, 1525, 1520, 1515, 1488, 1479, 1478, 1476, 1475, 1473, 1472, 1471, 1470, 1424, 1423, 1419, 1417, 1416, 1377, 1376, 1369, 1367, 1329, 1320, 1162, 1155, 931, 930, 910, 909, 908, 907, 900, 895, 890, 888, 880, 768, 191, 188, 186, 185, 180, 178, 174, 173, 161, 127, 33 };
    


























































































    $Pcprinting = new int[] { 195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 128884, 128768, 128710, 128640, 128592, 128581, 128577, 128507, 128360, 128336, 128324, 128320, 128318, 128256, 128253, 128249, 128248, 128066, 128065, 128064, 128063, 128000, 127985, 127968, 127947, 127942, 127941, 127904, 127892, 127872, 127869, 127799, 127798, 127792, 127777, 127744, 127570, 127568, 127561, 127552, 127547, 127504, 127491, 127462, 127387, 127344, 127340, 127280, 127279, 127248, 127200, 127185, 127184, 127169, 127167, 127153, 127151, 127136, 127124, 127024, 127020, 126976, 126706, 126704, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120832, 120782, 120780, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 119639, 119552, 119366, 119365, 119362, 119296, 119262, 119214, 119210, 119180, 119173, 119171, 119149, 119146, 119141, 119081, 119079, 119040, 119030, 118784, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74868, 74864, 74607, 73728, 71370, 71360, 71339, 71296, 70106, 70096, 70089, 70081, 70067, 70019, 69956, 69942, 69927, 69891, 69882, 69872, 69865, 69840, 69826, 69822, 69821, 69819, 69808, 69763, 69744, 69734, 69710, 69703, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68409, 68406, 68352, 68224, 68223, 68221, 68192, 68185, 68176, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67904, 67903, 67898, 67871, 67862, 67840, 67672, 67671, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66730, 66720, 66718, 66560, 66513, 66504, 66500, 66463, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 66045, 66000, 65948, 65936, 65930, 65913, 65856, 65847, 65795, 65792, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65534, 65532, 65519, 65512, 65511, 65504, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65281, 65277, 65142, 65141, 65136, 65132, 65128, 65127, 65108, 65107, 65072, 65050, 65040, 65022, 65008, 64968, 64914, 64912, 64848, 64832, 64467, 64450, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44026, 44016, 44012, 44011, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43760, 43755, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43612, 43610, 43600, 43596, 43588, 43587, 43584, 43561, 43520, 43488, 43486, 43482, 43471, 43470, 43457, 43443, 43396, 43389, 43359, 43335, 43310, 43302, 43264, 43260, 43250, 43226, 43214, 43188, 43138, 43128, 43072, 43066, 43062, 43052, 43048, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42752, 42744, 42738, 42726, 42656, 42648, 42622, 42612, 42611, 42607, 42560, 42540, 42192, 42183, 42128, 42125, 40960, 40909, 19904, 19894, 13056, 13055, 12992, 12977, 12938, 12928, 12896, 12881, 12880, 12872, 12842, 12831, 12784, 12772, 12736, 12731, 12694, 12690, 12688, 12687, 12593, 12590, 12549, 12544, 12443, 12439, 12353, 12352, 12347, 12344, 12336, 12321, 12296, 12295, 12288, 12284, 12272, 12246, 12032, 12020, 11931, 11930, 11904, 11836, 11776, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11633, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11518, 11517, 11513, 11508, 11506, 11503, 11360, 11359, 11312, 11311, 11264, 11098, 11088, 11085, 10132, 10102, 9985, 9984, 9472, 9450, 9372, 9291, 9280, 9255, 9216, 9204, 8592, 8581, 8579, 8528, 8448, 8379, 8352, 8349, 8336, 8335, 8330, 8320, 8314, 8306, 8305, 8288, 8239, 8234, 8208, 8203, 8192, 8191, 8182, 8181, 8178, 8176, 8157, 8156, 8150, 8148, 8134, 8133, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7380, 7379, 7368, 7360, 7296, 7245, 7242, 7227, 7204, 7164, 7142, 7086, 7073, 7043, 7037, 7028, 7019, 6992, 6988, 6981, 6964, 6917, 6830, 6816, 6810, 6800, 6794, 6784, 6741, 6686, 6679, 6622, 6618, 6608, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6468, 6465, 6464, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6170, 6160, 6159, 6158, 6155, 6144, 6122, 6112, 6109, 6100, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5943, 5941, 5938, 5920, 5906, 5902, 5901, 5888, 5870, 5792, 5789, 5120, 5109, 5024, 5018, 4992, 4969, 4960, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4304, 4302, 4301, 4296, 4295, 4294, 4254, 4250, 4240, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4159, 4139, 4096, 4059, 4046, 4045, 4039, 4038, 4030, 3981, 3976, 3974, 3973, 3949, 3913, 3912, 3904, 3902, 3898, 3897, 3896, 3895, 3894, 3893, 3892, 3882, 3866, 3864, 3840, 3808, 3804, 3802, 3792, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3676, 3663, 3655, 3647, 3636, 3634, 3633, 3585, 3573, 3572, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3449, 3440, 3430, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3312, 3302, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3200, 3199, 3184, 3174, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3067, 3059, 3056, 3046, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2918, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2802, 2790, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2672, 2662, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2556, 2554, 2548, 2534, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2404, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2143, 2142, 2137, 2112, 2111, 2096, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2036, 2027, 1984, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1806, 1774, 1770, 1769, 1767, 1765, 1759, 1758, 1750, 1649, 1648, 1632, 1611, 1566, 1564, 1563, 1552, 1542, 1525, 1520, 1515, 1488, 1479, 1478, 1476, 1475, 1473, 1472, 1471, 1470, 1424, 1423, 1419, 1417, 1416, 1377, 1376, 1369, 1367, 1329, 1320, 1162, 1155, 931, 930, 910, 909, 908, 907, 900, 895, 890, 888, 880, 768, 191, 188, 186, 185, 180, 178, 174, 173, 160, 127, 32, 14, 9 };srfi14 localSrfi14 = $instance;char$Mnset$Eq = new ModuleMethod(localSrfi14, 2, Lit5, 61440);char$Mnset$Ls$Eq = new ModuleMethod(localSrfi14, 3, Lit6, 61440);char$Mnset$Mnhash = new ModuleMethod(localSrfi14, 4, Lit7, 8193);char$Mnset$Mncursor = new ModuleMethod(localSrfi14, 6, Lit8, 4097);char$Mnset$Mnref = new ModuleMethod(localSrfi14, 7, Lit9, 8194);char$Mnset$Mncursor$Mnnext = new ModuleMethod(localSrfi14, 8, Lit10, 8194);end$Mnof$Mnchar$Mnset$Qu = new ModuleMethod(localSrfi14, 9, Lit11, 4097);char$Mnset$Mnfold = new ModuleMethod(localSrfi14, 10, Lit12, 12291);char$Mnset$Mnunfold = new ModuleMethod(localSrfi14, 11, Lit13, 20484);char$Mnset$Mnunfold$Ex = new ModuleMethod(localSrfi14, 13, Lit14, 20485);char$Mnset$Mnfor$Mneach = new ModuleMethod(localSrfi14, 14, Lit15, 8194);char$Mnset$Mnmap = new ModuleMethod(localSrfi14, 15, Lit16, 8194);char$Mnset$Mncopy = new ModuleMethod(localSrfi14, 16, Lit17, 4097);char$Mnset = CharSet.class;list$Mn$Grchar$Mnset = new ModuleMethod(localSrfi14, 17, Lit18, 8193);list$Mn$Grchar$Mnset$Ex = new ModuleMethod(localSrfi14, 19, Lit19, 8194);string$Mn$Grchar$Mnset = new ModuleMethod(localSrfi14, 20, Lit20, 8193);string$Mn$Grchar$Mnset$Ex = new ModuleMethod(localSrfi14, 22, Lit21, 8194);char$Mnset$Mnfilter = new ModuleMethod(localSrfi14, 23, Lit22, 12290);char$Mnset$Mnfilter$Ex = new ModuleMethod(localSrfi14, 25, Lit23, 12291);ucs$Mnrange$Mn$Grchar$Mnset = new ModuleMethod(localSrfi14, 26, Lit24, 16386);ucs$Mnrange$Mn$Grchar$Mnset$Ex = new ModuleMethod(localSrfi14, 29, Lit25, 16388);$Mn$Grchar$Mnset = new ModuleMethod(localSrfi14, 30, Lit26, 4097);char$Mnset$Mnsize = new ModuleMethod(localSrfi14, 31, Lit27, 4097);char$Mnset$Mncount = new ModuleMethod(localSrfi14, 32, Lit28, 8194);char$Mnset$Mn$Grlist = new ModuleMethod(localSrfi14, 33, Lit29, 4097);char$Mnset$Mn$Grstring = new ModuleMethod(localSrfi14, 34, Lit30, 4097);char$Mnset$Mncontains$Qu = new ModuleMethod(localSrfi14, 35, Lit31, 8194);char$Mnset$Mnevery = new ModuleMethod(localSrfi14, 36, Lit32, 8194);char$Mnset$Mnany = new ModuleMethod(localSrfi14, 37, Lit33, 8194);char$Mnset$Mnadjoin = new ModuleMethod(localSrfi14, 38, Lit34, 61441);char$Mnset$Mndelete = new ModuleMethod(localSrfi14, 39, Lit35, 61441);char$Mnset$Mnadjoin$Ex = new ModuleMethod(localSrfi14, 40, Lit36, 61441);char$Mnset$Mndelete$Ex = new ModuleMethod(localSrfi14, 41, Lit37, 61441);char$Mnset$Mncomplement = new ModuleMethod(localSrfi14, 42, Lit38, 4097);char$Mnset$Mnunion = new ModuleMethod(localSrfi14, 43, Lit39, 61440);char$Mnset$Mnintersection = new ModuleMethod(localSrfi14, 44, Lit40, 61440);char$Mnset$Mndifference = new ModuleMethod(localSrfi14, 45, Lit41, 61441);char$Mnset$Mnxor = new ModuleMethod(localSrfi14, 46, Lit42, 61440);char$Mnset$Mndiff$Plintersection = new ModuleMethod(localSrfi14, 47, Lit43, 61442);char$Mnset$Mncomplement$Ex = new ModuleMethod(localSrfi14, 48, Lit44, 4097);char$Mnset$Mnunion$Ex = new ModuleMethod(localSrfi14, 49, Lit45, 61440);char$Mnset$Mnintersection$Ex = new ModuleMethod(localSrfi14, 50, Lit46, 61440);char$Mnset$Mndifference$Ex = new ModuleMethod(localSrfi14, 51, Lit47, 61441);char$Mnset$Mnxor$Ex = new ModuleMethod(localSrfi14, 52, Lit48, 61440);$Pcboundary$Mnpairs$Mnintersection = new ModuleMethod(localSrfi14, 53, Lit49, 8194);$Pcboundary$Mnpairs$Mnunion = new ModuleMethod(localSrfi14, 54, Lit50, 8194);$Pcboundary$Mnpairs$Mnxor = new ModuleMethod(localSrfi14, 55, Lit51, 8194);$runBody$();
  }
  
  public static int charSetHash(CharSet paramCharSet)
  {
    return charSetHash(paramCharSet, 0);
  }
  
  /* Error */
  public static Object charSetFold(Procedure kons, Object knil, CharSet cs)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 93	gnu/kawa/slib/srfi14:charSetCursor	(Lgnu/kawa/slib/srfi14$CharSet;)I
    //   4: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: aload_1
    //   8: astore 4
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: dup
    //   16: astore 5
    //   18: checkcast 68	java/lang/Number
    //   21: invokevirtual 71	java/lang/Number:intValue	()I
    //   24: invokestatic 99	gnu/kawa/slib/srfi14:isEndOfCharSet	(I)Z
    //   27: ifeq +8 -> 35
    //   30: aload 4
    //   32: goto +52 -> 84
    //   35: aload_2
    //   36: aload_3
    //   37: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: dup
    //   41: astore 5
    //   43: checkcast 68	java/lang/Number
    //   46: invokevirtual 71	java/lang/Number:intValue	()I
    //   49: invokestatic 104	gnu/kawa/slib/srfi14:charSetCursorNext	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   52: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aload_0
    //   56: aload_2
    //   57: aload_3
    //   58: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 5
    //   64: checkcast 68	java/lang/Number
    //   67: invokevirtual 71	java/lang/Number:intValue	()I
    //   70: invokestatic 109	gnu/kawa/slib/srfi14:charSetRef	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   73: invokestatic 115	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   76: aload 4
    //   78: invokevirtual 22	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: goto -73 -> 8
    //   84: areturn
    //   85: new 75	gnu/mapping/WrongType
    //   88: dup_x1
    //   89: swap
    //   90: ldc 95
    //   92: iconst_0
    //   93: aload 5
    //   95: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   98: athrow
    //   99: new 75	gnu/mapping/WrongType
    //   102: dup_x1
    //   103: swap
    //   104: ldc 101
    //   106: iconst_1
    //   107: aload 5
    //   109: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   112: athrow
    //   113: new 75	gnu/mapping/WrongType
    //   116: dup_x1
    //   117: swap
    //   118: ldc 106
    //   120: iconst_1
    //   121: aload 5
    //   123: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    // Line number table:
    //   Java source line #225	-> byte code offset #0
    //   Java source line #226	-> byte code offset #0
    //   Java source line #232	-> byte code offset #0
    //   Java source line #233	-> byte code offset #11
    //   Java source line #234	-> byte code offset #35
    //   Java source line #235	-> byte code offset #55
    //   Java source line #233	-> byte code offset #85
    //   Java source line #234	-> byte code offset #99
    //   Java source line #235	-> byte code offset #113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	kons	Procedure
    //   0	84	1	knil	Object
    //   0	84	2	cs	CharSet
    //   10	48	3	cursor	Object
    //   8	1	4	localObject1	Object
    //   11	66	4	answer	Object
    //   16	106	5	localObject2	Object
    //   85	1	7	localClassCastException1	ClassCastException
    //   99	1	8	localClassCastException2	ClassCastException
    //   113	1	9	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	24	85	java/lang/ClassCastException
    //   43	49	99	java/lang/ClassCastException
    //   64	70	113	java/lang/ClassCastException
  }
  
  public static CharSet charSetUnfold(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject)
  {
    return charSetUnfold(paramProcedure1, paramProcedure2, paramProcedure3, paramObject, CharSet.empty);
  }
  
  /* Error */
  public static CharSet charSetUnfold$Ex(Procedure p, Procedure f, Procedure g, Object seed, CharSet base$Mncs)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload 4
    //   3: astore 6
    //   5: astore 5
    //   7: aload_0
    //   8: aload 5
    //   10: invokevirtual 133	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: invokestatic 28	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   16: ifeq +8 -> 24
    //   19: aload 6
    //   21: goto +47 -> 68
    //   24: aload_2
    //   25: aload 5
    //   27: invokevirtual 133	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: aload 6
    //   32: aload_1
    //   33: aload 5
    //   35: invokevirtual 133	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: dup
    //   39: instanceof 135
    //   42: ifeq +9 -> 51
    //   45: checkcast 135	[I
    //   48: goto +14 -> 62
    //   51: iconst_1
    //   52: newarray int
    //   54: dup_x1
    //   55: swap
    //   56: iconst_0
    //   57: swap
    //   58: invokestatic 139	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   61: iastore
    //   62: invokestatic 143	gnu/kawa/slib/srfi14:charSetAdjoin$Ex	(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
    //   65: goto -62 -> 3
    //   68: areturn
    // Line number table:
    //   Java source line #252	-> byte code offset #0
    //   Java source line #255	-> byte code offset #0
    //   Java source line #259	-> byte code offset #0
    //   Java source line #260	-> byte code offset #7
    //   Java source line #261	-> byte code offset #24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	p	Procedure
    //   0	68	1	f	Procedure
    //   0	68	2	g	Procedure
    //   0	68	3	seed	Object
    //   0	68	4	base$Mncs	CharSet
    //   7	61	5	seed	Object
    //   7	61	6	cs	CharSet
  }
  
  /* Error */
  public static CharSet charSetMap(Procedure proc, CharSet cs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 93	gnu/kawa/slib/srfi14:charSetCursor	(Lgnu/kawa/slib/srfi14$CharSet;)I
    //   4: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: getstatic 119	gnu/kawa/slib/srfi14$CharSet:empty	Lgnu/kawa/slib/srfi14$CharSet;
    //   10: invokestatic 127	gnu/kawa/slib/srfi14:charSetCopy	(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   13: astore_3
    //   14: astore_2
    //   15: aload_2
    //   16: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: dup
    //   20: astore 4
    //   22: checkcast 68	java/lang/Number
    //   25: invokevirtual 71	java/lang/Number:intValue	()I
    //   28: invokestatic 99	gnu/kawa/slib/srfi14:isEndOfCharSet	(I)Z
    //   31: ifne +89 -> 120
    //   34: aload_1
    //   35: aload_2
    //   36: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: dup
    //   40: astore 4
    //   42: checkcast 68	java/lang/Number
    //   45: invokevirtual 71	java/lang/Number:intValue	()I
    //   48: invokestatic 104	gnu/kawa/slib/srfi14:charSetCursorNext	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   51: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aload_3
    //   55: ldc 30
    //   57: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   60: dup
    //   61: astore 4
    //   63: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   66: aload_0
    //   67: aload_1
    //   68: aload_2
    //   69: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: dup
    //   73: astore 4
    //   75: checkcast 68	java/lang/Number
    //   78: invokevirtual 71	java/lang/Number:intValue	()I
    //   81: invokestatic 109	gnu/kawa/slib/srfi14:charSetRef	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   84: invokestatic 115	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   87: invokevirtual 133	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: dup
    //   91: instanceof 135
    //   94: ifeq +9 -> 103
    //   97: checkcast 135	[I
    //   100: goto +14 -> 114
    //   103: iconst_1
    //   104: newarray int
    //   106: dup_x1
    //   107: swap
    //   108: iconst_0
    //   109: swap
    //   110: invokestatic 139	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   113: iastore
    //   114: invokestatic 143	gnu/kawa/slib/srfi14:charSetAdjoin$Ex	(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
    //   117: goto -104 -> 13
    //   120: aload_3
    //   121: ldc 30
    //   123: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   126: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   129: areturn
    //   130: new 75	gnu/mapping/WrongType
    //   133: dup_x1
    //   134: swap
    //   135: ldc 95
    //   137: iconst_0
    //   138: aload 4
    //   140: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //   144: new 75	gnu/mapping/WrongType
    //   147: dup_x1
    //   148: swap
    //   149: ldc 101
    //   151: iconst_1
    //   152: aload 4
    //   154: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   157: athrow
    //   158: new 75	gnu/mapping/WrongType
    //   161: dup_x1
    //   162: swap
    //   163: ldc -104
    //   165: iconst_0
    //   166: aload 4
    //   168: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: new 75	gnu/mapping/WrongType
    //   175: dup_x1
    //   176: swap
    //   177: ldc 106
    //   179: iconst_1
    //   180: aload 4
    //   182: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   185: athrow
    // Line number table:
    //   Java source line #274	-> byte code offset #0
    //   Java source line #275	-> byte code offset #0
    //   Java source line #280	-> byte code offset #0
    //   Java source line #281	-> byte code offset #7
    //   Java source line #280	-> byte code offset #15
    //   Java source line #284	-> byte code offset #15
    //   Java source line #280	-> byte code offset #34
    //   Java source line #282	-> byte code offset #54
    //   Java source line #283	-> byte code offset #66
    //   Java source line #280	-> byte code offset #120
    //   Java source line #284	-> byte code offset #120
    //   Java source line #280	-> byte code offset #144
    //   Java source line #282	-> byte code offset #158
    //   Java source line #283	-> byte code offset #172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	proc	Procedure
    //   0	129	1	cs	CharSet
    //   14	55	2	cursor	Object
    //   13	1	3	localCharSet	CharSet
    //   15	106	3	result$Mncs	Object
    //   20	161	4	localObject1	Object
    //   130	1	6	localClassCastException1	ClassCastException
    //   144	1	7	localClassCastException2	ClassCastException
    //   158	1	8	localClassCastException3	ClassCastException
    //   172	1	9	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   22	28	130	java/lang/ClassCastException
    //   42	48	144	java/lang/ClassCastException
    //   63	66	158	java/lang/ClassCastException
    //   75	81	172	java/lang/ClassCastException
  }
  
  public static CharSet list$To$CharSet(LList paramLList)
  {
    return list$To$CharSet(paramLList, CharSet.empty);
  }
  
  public static CharSet string$To$CharSet(String paramString)
  {
    return string$To$CharSet(paramString, CharSet.empty);
  }
  
  public static CharSet charSetFilter(Procedure paramProcedure, CharSet paramCharSet)
  {
    return charSetFilter(paramProcedure, paramCharSet, CharSet.empty);
  }
  
  /* Error */
  public static CharSet charSetFilter(Procedure pred, CharSet cs, CharSet base$Mncs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 93	gnu/kawa/slib/srfi14:charSetCursor	(Lgnu/kawa/slib/srfi14$CharSet;)I
    //   4: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: aload_2
    //   8: invokestatic 127	gnu/kawa/slib/srfi14:charSetCopy	(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   11: astore 4
    //   13: astore_3
    //   14: aload_3
    //   15: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: dup
    //   19: astore 5
    //   21: checkcast 68	java/lang/Number
    //   24: invokevirtual 71	java/lang/Number:intValue	()I
    //   27: invokestatic 99	gnu/kawa/slib/srfi14:isEndOfCharSet	(I)Z
    //   30: ifne +89 -> 119
    //   33: aload_1
    //   34: aload_3
    //   35: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: dup
    //   39: astore 5
    //   41: checkcast 68	java/lang/Number
    //   44: invokevirtual 71	java/lang/Number:intValue	()I
    //   47: invokestatic 104	gnu/kawa/slib/srfi14:charSetCursorNext	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   50: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aload_1
    //   54: aload_3
    //   55: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: dup
    //   59: astore 6
    //   61: checkcast 68	java/lang/Number
    //   64: invokevirtual 71	java/lang/Number:intValue	()I
    //   67: invokestatic 109	gnu/kawa/slib/srfi14:charSetRef	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   70: istore 5
    //   72: aload_0
    //   73: iload 5
    //   75: invokestatic 115	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   78: invokevirtual 133	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: invokestatic 28	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   84: ifeq +30 -> 114
    //   87: aload 4
    //   89: ldc 30
    //   91: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   94: dup
    //   95: astore 6
    //   97: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   100: iconst_1
    //   101: newarray int
    //   103: dup
    //   104: iconst_0
    //   105: iload 5
    //   107: iastore
    //   108: invokestatic 143	gnu/kawa/slib/srfi14:charSetAdjoin$Ex	(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
    //   111: goto -100 -> 11
    //   114: aload 4
    //   116: goto -105 -> 11
    //   119: aload 4
    //   121: ldc 30
    //   123: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   126: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   129: areturn
    //   130: new 75	gnu/mapping/WrongType
    //   133: dup_x1
    //   134: swap
    //   135: ldc 95
    //   137: iconst_0
    //   138: aload 5
    //   140: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //   144: new 75	gnu/mapping/WrongType
    //   147: dup_x1
    //   148: swap
    //   149: ldc 101
    //   151: iconst_1
    //   152: aload 5
    //   154: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   157: athrow
    //   158: new 75	gnu/mapping/WrongType
    //   161: dup_x1
    //   162: swap
    //   163: ldc 106
    //   165: iconst_1
    //   166: aload 6
    //   168: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: new 75	gnu/mapping/WrongType
    //   175: dup_x1
    //   176: swap
    //   177: ldc -104
    //   179: iconst_0
    //   180: aload 6
    //   182: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   185: athrow
    // Line number table:
    //   Java source line #648	-> byte code offset #0
    //   Java source line #652	-> byte code offset #0
    //   Java source line #657	-> byte code offset #0
    //   Java source line #658	-> byte code offset #7
    //   Java source line #657	-> byte code offset #14
    //   Java source line #662	-> byte code offset #14
    //   Java source line #657	-> byte code offset #33
    //   Java source line #659	-> byte code offset #53
    //   Java source line #660	-> byte code offset #72
    //   Java source line #657	-> byte code offset #119
    //   Java source line #662	-> byte code offset #119
    //   Java source line #657	-> byte code offset #144
    //   Java source line #659	-> byte code offset #158
    //   Java source line #660	-> byte code offset #172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	pred	Procedure
    //   0	129	1	cs	CharSet
    //   0	129	2	base$Mncs	CharSet
    //   13	42	3	cursor	Object
    //   11	1	4	localCharSet	CharSet
    //   14	106	4	result$Mncs	Object
    //   19	21	5	localObject1	Object
    //   70	83	5	c	int
    //   59	122	6	localObject2	Object
    //   130	1	9	localClassCastException1	ClassCastException
    //   144	1	10	localClassCastException2	ClassCastException
    //   158	1	11	localClassCastException3	ClassCastException
    //   172	1	12	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   21	27	130	java/lang/ClassCastException
    //   41	47	144	java/lang/ClassCastException
    //   61	67	158	java/lang/ClassCastException
    //   97	100	172	java/lang/ClassCastException
  }
  
  /* Error */
  public static CharSet charSetFilter$Ex(Procedure pred, CharSet cs, CharSet base$Mncs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 93	gnu/kawa/slib/srfi14:charSetCursor	(Lgnu/kawa/slib/srfi14$CharSet;)I
    //   4: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: aload_2
    //   8: astore 4
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: dup
    //   16: astore 5
    //   18: checkcast 68	java/lang/Number
    //   21: invokevirtual 71	java/lang/Number:intValue	()I
    //   24: invokestatic 99	gnu/kawa/slib/srfi14:isEndOfCharSet	(I)Z
    //   27: ifeq +16 -> 43
    //   30: aload 4
    //   32: ldc 30
    //   34: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   40: goto +108 -> 148
    //   43: aload_1
    //   44: aload_3
    //   45: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: dup
    //   49: astore 6
    //   51: checkcast 68	java/lang/Number
    //   54: invokevirtual 71	java/lang/Number:intValue	()I
    //   57: invokestatic 109	gnu/kawa/slib/srfi14:charSetRef	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   60: istore 5
    //   62: aload_0
    //   63: iload 5
    //   65: invokestatic 115	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   68: invokevirtual 133	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: invokestatic 28	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   74: ifeq +50 -> 124
    //   77: aload_1
    //   78: aload_3
    //   79: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: dup
    //   83: astore 6
    //   85: checkcast 68	java/lang/Number
    //   88: invokevirtual 71	java/lang/Number:intValue	()I
    //   91: invokestatic 104	gnu/kawa/slib/srfi14:charSetCursorNext	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   94: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aload 4
    //   99: ldc 30
    //   101: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   104: dup
    //   105: astore 6
    //   107: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   110: iconst_1
    //   111: newarray int
    //   113: dup
    //   114: iconst_0
    //   115: iload 5
    //   117: iastore
    //   118: invokestatic 143	gnu/kawa/slib/srfi14:charSetAdjoin$Ex	(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
    //   121: goto -113 -> 8
    //   124: aload_1
    //   125: aload_3
    //   126: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: dup
    //   130: astore 6
    //   132: checkcast 68	java/lang/Number
    //   135: invokevirtual 71	java/lang/Number:intValue	()I
    //   138: invokestatic 104	gnu/kawa/slib/srfi14:charSetCursorNext	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   141: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: astore_3
    //   145: goto -134 -> 11
    //   148: areturn
    //   149: new 75	gnu/mapping/WrongType
    //   152: dup_x1
    //   153: swap
    //   154: ldc 95
    //   156: iconst_0
    //   157: aload 5
    //   159: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   162: athrow
    //   163: new 75	gnu/mapping/WrongType
    //   166: dup_x1
    //   167: swap
    //   168: ldc 106
    //   170: iconst_1
    //   171: aload 6
    //   173: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   176: athrow
    //   177: new 75	gnu/mapping/WrongType
    //   180: dup_x1
    //   181: swap
    //   182: ldc 101
    //   184: iconst_1
    //   185: aload 6
    //   187: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   190: athrow
    //   191: new 75	gnu/mapping/WrongType
    //   194: dup_x1
    //   195: swap
    //   196: ldc -104
    //   198: iconst_0
    //   199: aload 6
    //   201: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   204: athrow
    //   205: new 75	gnu/mapping/WrongType
    //   208: dup_x1
    //   209: swap
    //   210: ldc 101
    //   212: iconst_1
    //   213: aload 6
    //   215: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   218: athrow
    // Line number table:
    //   Java source line #664	-> byte code offset #0
    //   Java source line #667	-> byte code offset #0
    //   Java source line #672	-> byte code offset #0
    //   Java source line #673	-> byte code offset #11
    //   Java source line #674	-> byte code offset #43
    //   Java source line #675	-> byte code offset #62
    //   Java source line #676	-> byte code offset #77
    //   Java source line #677	-> byte code offset #97
    //   Java source line #678	-> byte code offset #124
    //   Java source line #673	-> byte code offset #149
    //   Java source line #674	-> byte code offset #163
    //   Java source line #676	-> byte code offset #177
    //   Java source line #677	-> byte code offset #191
    //   Java source line #678	-> byte code offset #205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	pred	Procedure
    //   0	148	1	cs	CharSet
    //   0	148	2	base$Mncs	CharSet
    //   11	137	3	cursor	Object
    //   11	137	4	base$Mncs	Object
    //   62	86	5	c	int
    // Exception table:
    //   from	to	target	type
    //   18	24	149	java/lang/ClassCastException
    //   51	57	163	java/lang/ClassCastException
    //   85	91	177	java/lang/ClassCastException
    //   107	110	191	java/lang/ClassCastException
    //   132	138	205	java/lang/ClassCastException
  }
  
  public static CharSet ucsRange$To$CharSet(int paramInt1, int paramInt2)
  {
    return ucsRange$To$CharSet(paramInt1, paramInt2, false);
  }
  
  public static CharSet ucsRange$To$CharSet(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return ucsRange$To$CharSet(paramInt1, paramInt2, paramBoolean, CharSet.empty);
  }
  
  /* Error */
  public static CharSet $To$CharSet(Object x)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 235	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   4: ifeq +27 -> 31
    //   7: aload_0
    //   8: ldc -19
    //   10: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: ifnonnull +8 -> 22
    //   17: pop
    //   18: aconst_null
    //   19: goto +6 -> 25
    //   22: invokevirtual 241	java/lang/Object:toString	()Ljava/lang/String;
    //   25: invokestatic 244	gnu/kawa/slib/srfi14:string$To$CharSet	(Ljava/lang/String;)Lgnu/kawa/slib/srfi14$CharSet;
    //   28: goto +74 -> 102
    //   31: aload_0
    //   32: instanceof 111
    //   35: ifeq +38 -> 73
    //   38: new 30	gnu/kawa/slib/srfi14$CharSet
    //   41: dup
    //   42: aload_0
    //   43: dup
    //   44: instanceof 135
    //   47: ifeq +9 -> 56
    //   50: checkcast 135	[I
    //   53: goto +14 -> 67
    //   56: iconst_1
    //   57: newarray int
    //   59: dup_x1
    //   60: swap
    //   61: iconst_0
    //   62: swap
    //   63: invokestatic 139	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   66: iastore
    //   67: invokespecial 222	gnu/kawa/slib/srfi14$CharSet:<init>	([I)V
    //   70: goto +32 -> 102
    //   73: aload_0
    //   74: instanceof 30
    //   77: ifeq +15 -> 92
    //   80: aload_0
    //   81: ldc 30
    //   83: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   86: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   89: goto +13 -> 102
    //   92: new 73	java/lang/ClassCastException
    //   95: dup
    //   96: ldc -10
    //   98: invokespecial 249	java/lang/ClassCastException:<init>	(Ljava/lang/String;)V
    //   101: athrow
    //   102: areturn
    // Line number table:
    //   Java source line #717	-> byte code offset #0
    //   Java source line #718	-> byte code offset #0
    //   Java source line #724	-> byte code offset #0
    //   Java source line #725	-> byte code offset #31
    //   Java source line #726	-> byte code offset #73
    //   Java source line #727	-> byte code offset #92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	x	Object
  }
  
  /* Error */
  public static Object charSetAny(Procedure pred, CharSet cs)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 93	gnu/kawa/slib/srfi14:charSetCursor	(Lgnu/kawa/slib/srfi14$CharSet;)I
    //   4: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: dup
    //   13: astore_3
    //   14: checkcast 68	java/lang/Number
    //   17: invokevirtual 71	java/lang/Number:intValue	()I
    //   20: invokestatic 99	gnu/kawa/slib/srfi14:isEndOfCharSet	(I)Z
    //   23: ifeq +9 -> 32
    //   26: getstatic 294	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   29: goto +62 -> 91
    //   32: aload_0
    //   33: aload_1
    //   34: aload_2
    //   35: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: dup
    //   39: astore 4
    //   41: checkcast 68	java/lang/Number
    //   44: invokevirtual 71	java/lang/Number:intValue	()I
    //   47: invokestatic 109	gnu/kawa/slib/srfi14:charSetRef	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   50: invokestatic 115	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   53: invokevirtual 133	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 28	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   61: ifeq +7 -> 68
    //   64: aload_3
    //   65: goto +26 -> 91
    //   68: aload_1
    //   69: aload_2
    //   70: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: dup
    //   74: astore 4
    //   76: checkcast 68	java/lang/Number
    //   79: invokevirtual 71	java/lang/Number:intValue	()I
    //   82: invokestatic 104	gnu/kawa/slib/srfi14:charSetCursorNext	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   85: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: goto -81 -> 7
    //   91: areturn
    //   92: new 75	gnu/mapping/WrongType
    //   95: dup_x1
    //   96: swap
    //   97: ldc 95
    //   99: iconst_0
    //   100: aload_3
    //   101: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   104: athrow
    //   105: new 75	gnu/mapping/WrongType
    //   108: dup_x1
    //   109: swap
    //   110: ldc 106
    //   112: iconst_1
    //   113: aload 4
    //   115: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   118: athrow
    //   119: new 75	gnu/mapping/WrongType
    //   122: dup_x1
    //   123: swap
    //   124: ldc 101
    //   126: iconst_1
    //   127: aload 4
    //   129: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   132: athrow
    // Line number table:
    //   Java source line #767	-> byte code offset #0
    //   Java source line #768	-> byte code offset #0
    //   Java source line #777	-> byte code offset #0
    //   Java source line #778	-> byte code offset #8
    //   Java source line #779	-> byte code offset #32
    //   Java source line #778	-> byte code offset #57
    //   Java source line #10493	-> byte code offset #64
    //   Java source line #780	-> byte code offset #68
    //   Java source line #778	-> byte code offset #92
    //   Java source line #779	-> byte code offset #105
    //   Java source line #780	-> byte code offset #119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	pred	Procedure
    //   0	91	1	cs	CharSet
    //   8	83	2	cursor	Object
    //   57	34	3	temp	Object
    // Exception table:
    //   from	to	target	type
    //   14	20	92	java/lang/ClassCastException
    //   41	47	105	java/lang/ClassCastException
    //   76	82	119	java/lang/ClassCastException
  }
  
  /* Error */
  static LList $PcBoundaryPairsIntersection(LList l1, LList l2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 358	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: istore_2
    //   5: iload_2
    //   6: ifeq +10 -> 16
    //   9: iload_2
    //   10: ifeq +19 -> 29
    //   13: goto +10 -> 23
    //   16: aload_1
    //   17: invokestatic 358	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   20: ifeq +9 -> 29
    //   23: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   26: goto +477 -> 503
    //   29: aload_0
    //   30: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: aload_1
    //   34: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   40: ifeq +30 -> 70
    //   43: aload_0
    //   44: dup
    //   45: astore_3
    //   46: checkcast 378	gnu/lists/Pair
    //   49: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   52: ldc_w 360
    //   55: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   58: dup
    //   59: astore_3
    //   60: checkcast 360	gnu/lists/LList
    //   63: aload_1
    //   64: invokestatic 389	gnu/kawa/slib/srfi14:$PcBoundaryPairsIntersection	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   67: goto +436 -> 503
    //   70: aload_1
    //   71: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: aload_0
    //   75: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   81: ifeq +30 -> 111
    //   84: aload_0
    //   85: aload_1
    //   86: dup
    //   87: astore_3
    //   88: checkcast 378	gnu/lists/Pair
    //   91: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   94: ldc_w 360
    //   97: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   100: dup
    //   101: astore_3
    //   102: checkcast 360	gnu/lists/LList
    //   105: invokestatic 389	gnu/kawa/slib/srfi14:$PcBoundaryPairsIntersection	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   108: goto +395 -> 503
    //   111: aload_0
    //   112: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: dup
    //   119: astore 4
    //   121: checkcast 68	java/lang/Number
    //   124: invokevirtual 71	java/lang/Number:intValue	()I
    //   127: istore_3
    //   128: aload_0
    //   129: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: dup
    //   136: astore 5
    //   138: checkcast 68	java/lang/Number
    //   141: invokevirtual 71	java/lang/Number:intValue	()I
    //   144: istore 4
    //   146: aload_1
    //   147: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: dup
    //   154: astore 6
    //   156: checkcast 68	java/lang/Number
    //   159: invokevirtual 71	java/lang/Number:intValue	()I
    //   162: istore 5
    //   164: aload_1
    //   165: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   171: dup
    //   172: astore 7
    //   174: checkcast 68	java/lang/Number
    //   177: invokevirtual 71	java/lang/Number:intValue	()I
    //   180: istore 6
    //   182: iload_3
    //   183: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: iload 5
    //   188: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: iload 4
    //   193: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: iconst_1
    //   197: anewarray 172	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: iload 6
    //   204: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: invokestatic 401	gnu/kawa/functions/NumberCompare:$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   211: ifeq +126 -> 337
    //   214: iconst_2
    //   215: anewarray 172	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: iload 5
    //   222: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: iload 4
    //   230: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: aastore
    //   234: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   237: iconst_2
    //   238: anewarray 172	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: iconst_2
    //   244: anewarray 172	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: iload_3
    //   250: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: iload 5
    //   258: iconst_1
    //   259: isub
    //   260: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: aastore
    //   264: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   267: iconst_2
    //   268: anewarray 172	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload_0
    //   274: dup
    //   275: astore 7
    //   277: checkcast 378	gnu/lists/Pair
    //   280: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   289: aastore
    //   290: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   293: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   296: aload_1
    //   297: dup
    //   298: astore 7
    //   300: checkcast 378	gnu/lists/Pair
    //   303: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   306: ldc_w 360
    //   309: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   312: dup
    //   313: astore 7
    //   315: checkcast 360	gnu/lists/LList
    //   318: invokestatic 389	gnu/kawa/slib/srfi14:$PcBoundaryPairsIntersection	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   327: aastore
    //   328: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   331: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   334: goto +169 -> 503
    //   337: iload_3
    //   338: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: iload 5
    //   343: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: iload 6
    //   348: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: iconst_1
    //   352: anewarray 172	java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: iload 4
    //   359: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: invokestatic 401	gnu/kawa/functions/NumberCompare:$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   366: ifeq +132 -> 498
    //   369: iconst_2
    //   370: anewarray 172	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: aload_1
    //   376: dup
    //   377: astore 7
    //   379: checkcast 378	gnu/lists/Pair
    //   382: invokestatic 416	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   385: aastore
    //   386: dup
    //   387: iconst_1
    //   388: iconst_2
    //   389: anewarray 172	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: iconst_2
    //   395: anewarray 172	java/lang/Object
    //   398: dup
    //   399: iconst_0
    //   400: iload_3
    //   401: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: iload 5
    //   409: iconst_1
    //   410: isub
    //   411: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   418: iconst_2
    //   419: anewarray 172	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: aload_0
    //   425: dup
    //   426: astore 7
    //   428: checkcast 378	gnu/lists/Pair
    //   431: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   434: aastore
    //   435: dup
    //   436: iconst_1
    //   437: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   440: aastore
    //   441: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   444: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   447: aload_1
    //   448: dup
    //   449: astore 7
    //   451: checkcast 378	gnu/lists/Pair
    //   454: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   457: ldc_w 360
    //   460: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   463: dup
    //   464: astore 7
    //   466: checkcast 360	gnu/lists/LList
    //   469: invokestatic 389	gnu/kawa/slib/srfi14:$PcBoundaryPairsIntersection	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   472: aastore
    //   473: dup
    //   474: iconst_1
    //   475: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   478: aastore
    //   479: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   482: aastore
    //   483: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   486: ldc_w 360
    //   489: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   492: checkcast 360	gnu/lists/LList
    //   495: goto +8 -> 503
    //   498: aload_1
    //   499: aload_0
    //   500: invokestatic 389	gnu/kawa/slib/srfi14:$PcBoundaryPairsIntersection	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   503: areturn
    //   504: new 75	gnu/mapping/WrongType
    //   507: dup_x1
    //   508: swap
    //   509: ldc_w 380
    //   512: iconst_1
    //   513: aload_3
    //   514: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   517: athrow
    //   518: new 75	gnu/mapping/WrongType
    //   521: dup_x1
    //   522: swap
    //   523: ldc_w 385
    //   526: iconst_0
    //   527: aload_3
    //   528: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   531: athrow
    //   532: new 75	gnu/mapping/WrongType
    //   535: dup_x1
    //   536: swap
    //   537: ldc_w 380
    //   540: iconst_1
    //   541: aload_3
    //   542: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   545: athrow
    //   546: new 75	gnu/mapping/WrongType
    //   549: dup_x1
    //   550: swap
    //   551: ldc_w 385
    //   554: iconst_1
    //   555: aload_3
    //   556: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   559: athrow
    //   560: new 75	gnu/mapping/WrongType
    //   563: dup_x1
    //   564: swap
    //   565: ldc_w 391
    //   568: bipush -2
    //   570: aload 4
    //   572: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   575: athrow
    //   576: new 75	gnu/mapping/WrongType
    //   579: dup_x1
    //   580: swap
    //   581: ldc_w 393
    //   584: bipush -2
    //   586: aload 5
    //   588: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   591: athrow
    //   592: new 75	gnu/mapping/WrongType
    //   595: dup_x1
    //   596: swap
    //   597: ldc_w 395
    //   600: bipush -2
    //   602: aload 6
    //   604: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   607: athrow
    //   608: new 75	gnu/mapping/WrongType
    //   611: dup_x1
    //   612: swap
    //   613: ldc_w 397
    //   616: bipush -2
    //   618: aload 7
    //   620: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   623: athrow
    //   624: new 75	gnu/mapping/WrongType
    //   627: dup_x1
    //   628: swap
    //   629: ldc_w 380
    //   632: iconst_1
    //   633: aload 7
    //   635: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   638: athrow
    //   639: new 75	gnu/mapping/WrongType
    //   642: dup_x1
    //   643: swap
    //   644: ldc_w 380
    //   647: iconst_1
    //   648: aload 7
    //   650: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   653: athrow
    //   654: new 75	gnu/mapping/WrongType
    //   657: dup_x1
    //   658: swap
    //   659: ldc_w 385
    //   662: iconst_1
    //   663: aload 7
    //   665: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   668: athrow
    //   669: new 75	gnu/mapping/WrongType
    //   672: dup_x1
    //   673: swap
    //   674: ldc_w 414
    //   677: iconst_1
    //   678: aload 7
    //   680: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   683: athrow
    //   684: new 75	gnu/mapping/WrongType
    //   687: dup_x1
    //   688: swap
    //   689: ldc_w 380
    //   692: iconst_1
    //   693: aload 7
    //   695: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   698: athrow
    //   699: new 75	gnu/mapping/WrongType
    //   702: dup_x1
    //   703: swap
    //   704: ldc_w 380
    //   707: iconst_1
    //   708: aload 7
    //   710: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   713: athrow
    //   714: new 75	gnu/mapping/WrongType
    //   717: dup_x1
    //   718: swap
    //   719: ldc_w 385
    //   722: iconst_1
    //   723: aload 7
    //   725: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   728: athrow
    // Line number table:
    //   Java source line #977	-> byte code offset #0
    //   Java source line #978	-> byte code offset #0
    //   Java source line #979	-> byte code offset #29
    //   Java source line #980	-> byte code offset #43
    //   Java source line #981	-> byte code offset #70
    //   Java source line #982	-> byte code offset #84
    //   Java source line #984	-> byte code offset #111
    //   Java source line #985	-> byte code offset #128
    //   Java source line #986	-> byte code offset #146
    //   Java source line #987	-> byte code offset #164
    //   Java source line #988	-> byte code offset #182
    //   Java source line #989	-> byte code offset #214
    //   Java source line #991	-> byte code offset #243
    //   Java source line #992	-> byte code offset #337
    //   Java source line #993	-> byte code offset #369
    //   Java source line #995	-> byte code offset #394
    //   Java source line #996	-> byte code offset #498
    //   Java source line #980	-> byte code offset #504
    //   Java source line #982	-> byte code offset #532
    //   Java source line #984	-> byte code offset #560
    //   Java source line #985	-> byte code offset #576
    //   Java source line #986	-> byte code offset #592
    //   Java source line #987	-> byte code offset #608
    //   Java source line #991	-> byte code offset #624
    //   Java source line #993	-> byte code offset #669
    //   Java source line #995	-> byte code offset #684
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	l1	LList
    //   0	503	1	l2	LList
    //   4	6	2	x	boolean
    //   45	57	3	localObject1	Object
    //   127	1	3	i	int
    //   182	374	3	l1a	int
    //   119	1	4	localObject2	Object
    //   144	1	4	j	int
    //   182	389	4	l1b	int
    //   136	1	5	localObject3	Object
    //   162	1	5	k	int
    //   182	405	5	l2a	int
    //   154	1	6	localObject4	Object
    //   180	423	6	l2b	int
    //   172	552	7	localObject5	Object
    //   504	1	15	localClassCastException1	ClassCastException
    //   518	1	16	localClassCastException2	ClassCastException
    //   532	1	17	localClassCastException3	ClassCastException
    //   546	1	18	localClassCastException4	ClassCastException
    //   560	1	19	localClassCastException5	ClassCastException
    //   576	1	20	localClassCastException6	ClassCastException
    //   592	1	21	localClassCastException7	ClassCastException
    //   608	1	22	localClassCastException8	ClassCastException
    //   624	1	23	localClassCastException9	ClassCastException
    //   639	1	24	localClassCastException10	ClassCastException
    //   654	1	25	localClassCastException11	ClassCastException
    //   669	1	26	localClassCastException12	ClassCastException
    //   684	1	27	localClassCastException13	ClassCastException
    //   699	1	28	localClassCastException14	ClassCastException
    //   714	1	29	localClassCastException15	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   46	49	504	java/lang/ClassCastException
    //   60	63	518	java/lang/ClassCastException
    //   88	91	532	java/lang/ClassCastException
    //   102	105	546	java/lang/ClassCastException
    //   121	127	560	java/lang/ClassCastException
    //   138	144	576	java/lang/ClassCastException
    //   156	162	592	java/lang/ClassCastException
    //   174	180	608	java/lang/ClassCastException
    //   277	280	624	java/lang/ClassCastException
    //   300	303	639	java/lang/ClassCastException
    //   315	318	654	java/lang/ClassCastException
    //   379	382	669	java/lang/ClassCastException
    //   428	431	684	java/lang/ClassCastException
    //   451	454	699	java/lang/ClassCastException
    //   466	469	714	java/lang/ClassCastException
  }
  
  /* Error */
  static LList $PcBoundaryPairsUnion(LList l1, LList l2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 358	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +7 -> 11
    //   7: aload_1
    //   8: goto +439 -> 447
    //   11: aload_1
    //   12: invokestatic 358	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   15: ifeq +7 -> 22
    //   18: aload_0
    //   19: goto +428 -> 447
    //   22: aload_1
    //   23: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: aload_0
    //   27: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifeq +10 -> 45
    //   38: iload_2
    //   39: ifeq +56 -> 95
    //   42: goto +45 -> 87
    //   45: aload_1
    //   46: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: aload_0
    //   50: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: invokestatic 419	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   56: ifeq +39 -> 95
    //   59: aload_1
    //   60: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: aload_0
    //   64: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: invokestatic 422	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   70: ifeq +25 -> 95
    //   73: aload_1
    //   74: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: aload_0
    //   78: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   84: ifeq +11 -> 95
    //   87: aload_1
    //   88: aload_0
    //   89: invokestatic 425	gnu/kawa/slib/srfi14:$PcBoundaryPairsUnion	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   92: goto +355 -> 447
    //   95: aload_0
    //   96: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: dup
    //   103: astore 4
    //   105: checkcast 68	java/lang/Number
    //   108: invokevirtual 71	java/lang/Number:intValue	()I
    //   111: istore_3
    //   112: aload_0
    //   113: aload_1
    //   114: astore 5
    //   116: astore 4
    //   118: aload 5
    //   120: invokestatic 358	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   123: ifeq +75 -> 198
    //   126: iconst_2
    //   127: anewarray 172	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload 4
    //   134: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: iload_3
    //   141: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   148: iconst_2
    //   149: anewarray 172	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 4
    //   156: dup
    //   157: astore 6
    //   159: checkcast 378	gnu/lists/Pair
    //   162: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   165: ldc_w 360
    //   168: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   171: dup
    //   172: astore 6
    //   174: checkcast 360	gnu/lists/LList
    //   177: aload 5
    //   179: invokestatic 425	gnu/kawa/slib/srfi14:$PcBoundaryPairsUnion	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   188: aastore
    //   189: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   192: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   195: goto +252 -> 447
    //   198: aload 5
    //   200: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: iconst_m1
    //   204: aload 4
    //   206: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   209: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   212: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   215: iconst_m1
    //   216: aload 5
    //   218: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   224: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   227: iconst_0
    //   228: anewarray 172	java/lang/Object
    //   231: invokestatic 440	gnu/kawa/functions/NumberCompare:$Gr$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   234: ifeq +28 -> 262
    //   237: aload 5
    //   239: aload 4
    //   241: dup
    //   242: astore 6
    //   244: checkcast 378	gnu/lists/Pair
    //   247: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   250: ldc_w 360
    //   253: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   256: checkcast 360	gnu/lists/LList
    //   259: goto -145 -> 114
    //   262: aload 5
    //   264: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   267: iconst_m1
    //   268: aload 4
    //   270: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   273: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   276: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: invokestatic 443	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   282: ifeq +96 -> 378
    //   285: iconst_2
    //   286: anewarray 172	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload 4
    //   293: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: iload_3
    //   300: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   307: iconst_2
    //   308: anewarray 172	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload 4
    //   315: dup
    //   316: astore 6
    //   318: checkcast 378	gnu/lists/Pair
    //   321: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   324: ldc_w 360
    //   327: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   330: dup
    //   331: astore 6
    //   333: checkcast 360	gnu/lists/LList
    //   336: aload 5
    //   338: dup
    //   339: astore 6
    //   341: checkcast 378	gnu/lists/Pair
    //   344: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   347: ldc_w 360
    //   350: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   353: dup
    //   354: astore 6
    //   356: checkcast 360	gnu/lists/LList
    //   359: invokestatic 425	gnu/kawa/slib/srfi14:$PcBoundaryPairsUnion	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   368: aastore
    //   369: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   372: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   375: goto +72 -> 447
    //   378: iconst_2
    //   379: anewarray 172	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: aload 4
    //   386: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: iload_3
    //   393: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: aastore
    //   397: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   400: iconst_2
    //   401: anewarray 172	java/lang/Object
    //   404: dup
    //   405: iconst_0
    //   406: aload 4
    //   408: dup
    //   409: astore 6
    //   411: checkcast 378	gnu/lists/Pair
    //   414: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   417: ldc_w 360
    //   420: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   423: dup
    //   424: astore 6
    //   426: checkcast 360	gnu/lists/LList
    //   429: aload 5
    //   431: invokestatic 425	gnu/kawa/slib/srfi14:$PcBoundaryPairsUnion	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   434: aastore
    //   435: dup
    //   436: iconst_1
    //   437: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   440: aastore
    //   441: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   444: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   447: areturn
    //   448: new 75	gnu/mapping/WrongType
    //   451: dup_x1
    //   452: swap
    //   453: ldc_w 427
    //   456: bipush -2
    //   458: aload 4
    //   460: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   463: athrow
    //   464: new 75	gnu/mapping/WrongType
    //   467: dup_x1
    //   468: swap
    //   469: ldc_w 380
    //   472: iconst_1
    //   473: aload 6
    //   475: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   478: athrow
    //   479: new 75	gnu/mapping/WrongType
    //   482: dup_x1
    //   483: swap
    //   484: ldc_w 429
    //   487: iconst_0
    //   488: aload 6
    //   490: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   493: athrow
    //   494: new 75	gnu/mapping/WrongType
    //   497: dup_x1
    //   498: swap
    //   499: ldc_w 380
    //   502: iconst_1
    //   503: aload 6
    //   505: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   508: athrow
    //   509: new 75	gnu/mapping/WrongType
    //   512: dup_x1
    //   513: swap
    //   514: ldc_w 380
    //   517: iconst_1
    //   518: aload 6
    //   520: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   523: athrow
    //   524: new 75	gnu/mapping/WrongType
    //   527: dup_x1
    //   528: swap
    //   529: ldc_w 429
    //   532: iconst_0
    //   533: aload 6
    //   535: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   538: athrow
    //   539: new 75	gnu/mapping/WrongType
    //   542: dup_x1
    //   543: swap
    //   544: ldc_w 380
    //   547: iconst_1
    //   548: aload 6
    //   550: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   553: athrow
    //   554: new 75	gnu/mapping/WrongType
    //   557: dup_x1
    //   558: swap
    //   559: ldc_w 429
    //   562: iconst_1
    //   563: aload 6
    //   565: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   568: athrow
    //   569: new 75	gnu/mapping/WrongType
    //   572: dup_x1
    //   573: swap
    //   574: ldc_w 380
    //   577: iconst_1
    //   578: aload 6
    //   580: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   583: athrow
    //   584: new 75	gnu/mapping/WrongType
    //   587: dup_x1
    //   588: swap
    //   589: ldc_w 429
    //   592: iconst_0
    //   593: aload 6
    //   595: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   598: athrow
    // Line number table:
    //   Java source line #1000	-> byte code offset #0
    //   Java source line #1001	-> byte code offset #0
    //   Java source line #1002	-> byte code offset #11
    //   Java source line #1003	-> byte code offset #22
    //   Java source line #1004	-> byte code offset #45
    //   Java source line #1005	-> byte code offset #59
    //   Java source line #1006	-> byte code offset #73
    //   Java source line #1007	-> byte code offset #87
    //   Java source line #1009	-> byte code offset #95
    //   Java source line #1010	-> byte code offset #112
    //   Java source line #1013	-> byte code offset #118
    //   Java source line #1014	-> byte code offset #126
    //   Java source line #1015	-> byte code offset #154
    //   Java source line #1016	-> byte code offset #198
    //   Java source line #1017	-> byte code offset #237
    //   Java source line #1018	-> byte code offset #262
    //   Java source line #1019	-> byte code offset #285
    //   Java source line #1020	-> byte code offset #313
    //   Java source line #1022	-> byte code offset #378
    //   Java source line #1023	-> byte code offset #406
    //   Java source line #1009	-> byte code offset #448
    //   Java source line #1015	-> byte code offset #464
    //   Java source line #1017	-> byte code offset #494
    //   Java source line #1020	-> byte code offset #509
    //   Java source line #1023	-> byte code offset #569
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	l1	LList
    //   0	447	1	l2	LList
    //   33	6	2	x	boolean
    //   111	282	3	ending	int
    //   103	1	4	localObject1	Object
    //   116	343	4	l1	LList
    //   114	1	5	localLList1	LList
    //   118	312	5	l2	LList
    //   157	437	6	localObject2	Object
    //   448	1	9	localClassCastException1	ClassCastException
    //   464	1	10	localClassCastException2	ClassCastException
    //   479	1	11	localClassCastException3	ClassCastException
    //   494	1	12	localClassCastException4	ClassCastException
    //   509	1	13	localClassCastException5	ClassCastException
    //   524	1	14	localClassCastException6	ClassCastException
    //   539	1	15	localClassCastException7	ClassCastException
    //   554	1	16	localClassCastException8	ClassCastException
    //   569	1	17	localClassCastException9	ClassCastException
    //   584	1	18	localClassCastException10	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   105	111	448	java/lang/ClassCastException
    //   159	162	464	java/lang/ClassCastException
    //   174	177	479	java/lang/ClassCastException
    //   244	247	494	java/lang/ClassCastException
    //   318	321	509	java/lang/ClassCastException
    //   333	336	524	java/lang/ClassCastException
    //   341	344	539	java/lang/ClassCastException
    //   356	359	554	java/lang/ClassCastException
    //   411	414	569	java/lang/ClassCastException
    //   426	429	584	java/lang/ClassCastException
  }
  
  /* Error */
  static LList $PcBoundaryPairsXor(LList l1, LList l2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 358	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +7 -> 11
    //   7: aload_1
    //   8: goto +813 -> 821
    //   11: aload_1
    //   12: invokestatic 358	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   15: ifeq +7 -> 22
    //   18: aload_0
    //   19: goto +802 -> 821
    //   22: aload_0
    //   23: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: iconst_1
    //   27: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   30: aload_1
    //   31: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   40: ifeq +77 -> 117
    //   43: iconst_2
    //   44: anewarray 172	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: dup
    //   51: astore_2
    //   52: checkcast 378	gnu/lists/Pair
    //   55: invokestatic 416	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: iconst_2
    //   62: anewarray 172	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: dup
    //   69: astore_2
    //   70: checkcast 378	gnu/lists/Pair
    //   73: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   76: ldc_w 360
    //   79: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   82: dup
    //   83: astore_2
    //   84: checkcast 360	gnu/lists/LList
    //   87: aload_1
    //   88: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   97: aastore
    //   98: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   101: aastore
    //   102: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   105: ldc_w 360
    //   108: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   111: checkcast 360	gnu/lists/LList
    //   114: goto +707 -> 821
    //   117: aload_1
    //   118: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: iconst_1
    //   122: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   125: aload_0
    //   126: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   135: ifeq +77 -> 212
    //   138: iconst_2
    //   139: anewarray 172	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: dup
    //   146: astore_2
    //   147: checkcast 378	gnu/lists/Pair
    //   150: invokestatic 416	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: iconst_2
    //   157: anewarray 172	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_0
    //   163: aload_1
    //   164: dup
    //   165: astore_2
    //   166: checkcast 378	gnu/lists/Pair
    //   169: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   172: ldc_w 360
    //   175: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   178: dup
    //   179: astore_2
    //   180: checkcast 360	gnu/lists/LList
    //   183: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   192: aastore
    //   193: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   196: aastore
    //   197: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   200: ldc_w 360
    //   203: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   206: checkcast 360	gnu/lists/LList
    //   209: goto +612 -> 821
    //   212: aload_0
    //   213: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   216: iconst_1
    //   217: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   220: aload_1
    //   221: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   224: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   227: invokestatic 419	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   230: ifeq +52 -> 282
    //   233: aload_1
    //   234: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   237: aload_0
    //   238: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: invokestatic 451	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   244: aload_0
    //   245: dup
    //   246: astore_2
    //   247: checkcast 378	gnu/lists/Pair
    //   250: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   253: invokestatic 451	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   256: aload_1
    //   257: dup
    //   258: astore_2
    //   259: checkcast 378	gnu/lists/Pair
    //   262: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   265: ldc_w 360
    //   268: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   271: dup
    //   272: astore_2
    //   273: checkcast 360	gnu/lists/LList
    //   276: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   279: goto +542 -> 821
    //   282: aload_1
    //   283: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: iconst_1
    //   287: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   290: aload_0
    //   291: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   294: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   297: invokestatic 419	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   300: ifeq +52 -> 352
    //   303: aload_0
    //   304: dup
    //   305: astore_2
    //   306: checkcast 378	gnu/lists/Pair
    //   309: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   312: ldc_w 360
    //   315: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   318: dup
    //   319: astore_2
    //   320: checkcast 360	gnu/lists/LList
    //   323: aload_0
    //   324: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   327: aload_1
    //   328: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: invokestatic 451	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   334: aload_1
    //   335: dup
    //   336: astore_2
    //   337: checkcast 378	gnu/lists/Pair
    //   340: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   343: invokestatic 451	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   346: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   349: goto +472 -> 821
    //   352: aload_0
    //   353: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   356: aload_1
    //   357: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   363: ifeq +106 -> 469
    //   366: iconst_2
    //   367: anewarray 172	java/lang/Object
    //   370: dup
    //   371: iconst_0
    //   372: iconst_1
    //   373: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   376: aload_1
    //   377: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   380: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: aastore
    //   384: dup
    //   385: iconst_1
    //   386: aload_0
    //   387: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   390: aastore
    //   391: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   394: iconst_2
    //   395: anewarray 172	java/lang/Object
    //   398: dup
    //   399: iconst_0
    //   400: iconst_2
    //   401: anewarray 172	java/lang/Object
    //   404: dup
    //   405: iconst_0
    //   406: aload_0
    //   407: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   410: aastore
    //   411: dup
    //   412: iconst_1
    //   413: aload_1
    //   414: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   417: aastore
    //   418: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   421: iconst_2
    //   422: anewarray 172	java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: aload_0
    //   428: dup
    //   429: astore_2
    //   430: checkcast 378	gnu/lists/Pair
    //   433: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   436: aastore
    //   437: dup
    //   438: iconst_1
    //   439: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   442: aastore
    //   443: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   446: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   449: aload_1
    //   450: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   453: aastore
    //   454: dup
    //   455: iconst_1
    //   456: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   459: aastore
    //   460: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   463: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   466: goto +355 -> 821
    //   469: aload_1
    //   470: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   473: aload_0
    //   474: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   477: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   480: ifeq +106 -> 586
    //   483: iconst_2
    //   484: anewarray 172	java/lang/Object
    //   487: dup
    //   488: iconst_0
    //   489: iconst_1
    //   490: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   493: aload_0
    //   494: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   497: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: aastore
    //   501: dup
    //   502: iconst_1
    //   503: aload_1
    //   504: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   507: aastore
    //   508: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   511: iconst_2
    //   512: anewarray 172	java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: iconst_2
    //   518: anewarray 172	java/lang/Object
    //   521: dup
    //   522: iconst_0
    //   523: aload_1
    //   524: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   527: aastore
    //   528: dup
    //   529: iconst_1
    //   530: aload_0
    //   531: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   534: aastore
    //   535: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   538: iconst_2
    //   539: anewarray 172	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: aload_1
    //   545: dup
    //   546: astore_2
    //   547: checkcast 378	gnu/lists/Pair
    //   550: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   553: aastore
    //   554: dup
    //   555: iconst_1
    //   556: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   559: aastore
    //   560: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   563: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   566: aload_0
    //   567: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   570: aastore
    //   571: dup
    //   572: iconst_1
    //   573: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   576: aastore
    //   577: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   580: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   583: goto +238 -> 821
    //   586: aload_0
    //   587: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   590: aload_1
    //   591: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   594: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   597: ifeq +85 -> 682
    //   600: aload_0
    //   601: dup
    //   602: astore_2
    //   603: checkcast 378	gnu/lists/Pair
    //   606: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   609: ldc_w 360
    //   612: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   615: dup
    //   616: astore_2
    //   617: checkcast 360	gnu/lists/LList
    //   620: iconst_2
    //   621: anewarray 172	java/lang/Object
    //   624: dup
    //   625: iconst_0
    //   626: aload_1
    //   627: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   630: aastore
    //   631: dup
    //   632: iconst_1
    //   633: iconst_m1
    //   634: aload_0
    //   635: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   638: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   641: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   644: aastore
    //   645: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   648: iconst_2
    //   649: anewarray 172	java/lang/Object
    //   652: dup
    //   653: iconst_0
    //   654: aload_1
    //   655: dup
    //   656: astore_2
    //   657: checkcast 378	gnu/lists/Pair
    //   660: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   663: aastore
    //   664: dup
    //   665: iconst_1
    //   666: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   669: aastore
    //   670: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   673: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   676: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   679: goto +142 -> 821
    //   682: aload_1
    //   683: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   686: aload_0
    //   687: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   690: invokestatic 376	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   693: ifeq +85 -> 778
    //   696: aload_1
    //   697: dup
    //   698: astore_2
    //   699: checkcast 378	gnu/lists/Pair
    //   702: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   705: ldc_w 360
    //   708: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   711: dup
    //   712: astore_2
    //   713: checkcast 360	gnu/lists/LList
    //   716: iconst_2
    //   717: anewarray 172	java/lang/Object
    //   720: dup
    //   721: iconst_0
    //   722: aload_0
    //   723: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   726: aastore
    //   727: dup
    //   728: iconst_1
    //   729: iconst_m1
    //   730: aload_1
    //   731: invokestatic 367	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   734: getstatic 432	gnu/kawa/slib/srfi14:Lit1	Lgnu/math/IntNum;
    //   737: invokestatic 437	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   740: aastore
    //   741: invokestatic 406	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   744: iconst_2
    //   745: anewarray 172	java/lang/Object
    //   748: dup
    //   749: iconst_0
    //   750: aload_0
    //   751: dup
    //   752: astore_2
    //   753: checkcast 378	gnu/lists/Pair
    //   756: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   759: aastore
    //   760: dup
    //   761: iconst_1
    //   762: getstatic 364	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   765: aastore
    //   766: invokestatic 409	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   769: invokestatic 412	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   772: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   775: goto +46 -> 821
    //   778: aload_0
    //   779: dup
    //   780: astore_2
    //   781: checkcast 378	gnu/lists/Pair
    //   784: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   787: ldc_w 360
    //   790: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   793: dup
    //   794: astore_2
    //   795: checkcast 360	gnu/lists/LList
    //   798: aload_1
    //   799: dup
    //   800: astore_2
    //   801: checkcast 378	gnu/lists/Pair
    //   804: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   807: ldc_w 360
    //   810: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   813: dup
    //   814: astore_2
    //   815: checkcast 360	gnu/lists/LList
    //   818: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   821: areturn
    //   822: new 75	gnu/mapping/WrongType
    //   825: dup_x1
    //   826: swap
    //   827: ldc_w 414
    //   830: iconst_1
    //   831: aload_2
    //   832: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   835: athrow
    //   836: new 75	gnu/mapping/WrongType
    //   839: dup_x1
    //   840: swap
    //   841: ldc_w 380
    //   844: iconst_1
    //   845: aload_2
    //   846: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   849: athrow
    //   850: new 75	gnu/mapping/WrongType
    //   853: dup_x1
    //   854: swap
    //   855: ldc_w 445
    //   858: iconst_0
    //   859: aload_2
    //   860: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   863: athrow
    //   864: new 75	gnu/mapping/WrongType
    //   867: dup_x1
    //   868: swap
    //   869: ldc_w 414
    //   872: iconst_1
    //   873: aload_2
    //   874: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   877: athrow
    //   878: new 75	gnu/mapping/WrongType
    //   881: dup_x1
    //   882: swap
    //   883: ldc_w 380
    //   886: iconst_1
    //   887: aload_2
    //   888: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   891: athrow
    //   892: new 75	gnu/mapping/WrongType
    //   895: dup_x1
    //   896: swap
    //   897: ldc_w 445
    //   900: iconst_1
    //   901: aload_2
    //   902: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   905: athrow
    //   906: new 75	gnu/mapping/WrongType
    //   909: dup_x1
    //   910: swap
    //   911: ldc_w 380
    //   914: iconst_1
    //   915: aload_2
    //   916: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   919: athrow
    //   920: new 75	gnu/mapping/WrongType
    //   923: dup_x1
    //   924: swap
    //   925: ldc_w 380
    //   928: iconst_1
    //   929: aload_2
    //   930: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   933: athrow
    //   934: new 75	gnu/mapping/WrongType
    //   937: dup_x1
    //   938: swap
    //   939: ldc_w 445
    //   942: iconst_1
    //   943: aload_2
    //   944: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   947: athrow
    //   948: new 75	gnu/mapping/WrongType
    //   951: dup_x1
    //   952: swap
    //   953: ldc_w 380
    //   956: iconst_1
    //   957: aload_2
    //   958: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   961: athrow
    //   962: new 75	gnu/mapping/WrongType
    //   965: dup_x1
    //   966: swap
    //   967: ldc_w 445
    //   970: iconst_0
    //   971: aload_2
    //   972: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   975: athrow
    //   976: new 75	gnu/mapping/WrongType
    //   979: dup_x1
    //   980: swap
    //   981: ldc_w 380
    //   984: iconst_1
    //   985: aload_2
    //   986: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   989: athrow
    //   990: new 75	gnu/mapping/WrongType
    //   993: dup_x1
    //   994: swap
    //   995: ldc_w 380
    //   998: iconst_1
    //   999: aload_2
    //   1000: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1003: athrow
    //   1004: new 75	gnu/mapping/WrongType
    //   1007: dup_x1
    //   1008: swap
    //   1009: ldc_w 380
    //   1012: iconst_1
    //   1013: aload_2
    //   1014: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1017: athrow
    //   1018: new 75	gnu/mapping/WrongType
    //   1021: dup_x1
    //   1022: swap
    //   1023: ldc_w 380
    //   1026: iconst_1
    //   1027: aload_2
    //   1028: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1031: athrow
    //   1032: new 75	gnu/mapping/WrongType
    //   1035: dup_x1
    //   1036: swap
    //   1037: ldc_w 445
    //   1040: iconst_0
    //   1041: aload_2
    //   1042: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1045: athrow
    //   1046: new 75	gnu/mapping/WrongType
    //   1049: dup_x1
    //   1050: swap
    //   1051: ldc_w 380
    //   1054: iconst_1
    //   1055: aload_2
    //   1056: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1059: athrow
    //   1060: new 75	gnu/mapping/WrongType
    //   1063: dup_x1
    //   1064: swap
    //   1065: ldc_w 380
    //   1068: iconst_1
    //   1069: aload_2
    //   1070: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1073: athrow
    //   1074: new 75	gnu/mapping/WrongType
    //   1077: dup_x1
    //   1078: swap
    //   1079: ldc_w 445
    //   1082: iconst_0
    //   1083: aload_2
    //   1084: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1087: athrow
    //   1088: new 75	gnu/mapping/WrongType
    //   1091: dup_x1
    //   1092: swap
    //   1093: ldc_w 380
    //   1096: iconst_1
    //   1097: aload_2
    //   1098: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1101: athrow
    //   1102: new 75	gnu/mapping/WrongType
    //   1105: dup_x1
    //   1106: swap
    //   1107: ldc_w 380
    //   1110: iconst_1
    //   1111: aload_2
    //   1112: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1115: athrow
    //   1116: new 75	gnu/mapping/WrongType
    //   1119: dup_x1
    //   1120: swap
    //   1121: ldc_w 445
    //   1124: iconst_0
    //   1125: aload_2
    //   1126: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1129: athrow
    //   1130: new 75	gnu/mapping/WrongType
    //   1133: dup_x1
    //   1134: swap
    //   1135: ldc_w 380
    //   1138: iconst_1
    //   1139: aload_2
    //   1140: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1143: athrow
    //   1144: new 75	gnu/mapping/WrongType
    //   1147: dup_x1
    //   1148: swap
    //   1149: ldc_w 445
    //   1152: iconst_1
    //   1153: aload_2
    //   1154: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1157: athrow
    // Line number table:
    //   Java source line #1027	-> byte code offset #0
    //   Java source line #1028	-> byte code offset #0
    //   Java source line #1029	-> byte code offset #11
    //   Java source line #1030	-> byte code offset #22
    //   Java source line #1032	-> byte code offset #43
    //   Java source line #1033	-> byte code offset #117
    //   Java source line #1035	-> byte code offset #138
    //   Java source line #1036	-> byte code offset #212
    //   Java source line #1038	-> byte code offset #233
    //   Java source line #1039	-> byte code offset #233
    //   Java source line #1040	-> byte code offset #282
    //   Java source line #1042	-> byte code offset #303
    //   Java source line #1043	-> byte code offset #303
    //   Java source line #1045	-> byte code offset #352
    //   Java source line #1046	-> byte code offset #366
    //   Java source line #1048	-> byte code offset #400
    //   Java source line #1049	-> byte code offset #469
    //   Java source line #1050	-> byte code offset #483
    //   Java source line #1052	-> byte code offset #517
    //   Java source line #1054	-> byte code offset #586
    //   Java source line #1055	-> byte code offset #600
    //   Java source line #1056	-> byte code offset #600
    //   Java source line #1057	-> byte code offset #682
    //   Java source line #1058	-> byte code offset #696
    //   Java source line #1059	-> byte code offset #696
    //   Java source line #1061	-> byte code offset #778
    //   Java source line #1032	-> byte code offset #822
    //   Java source line #1035	-> byte code offset #864
    //   Java source line #1039	-> byte code offset #906
    //   Java source line #1043	-> byte code offset #948
    //   Java source line #1048	-> byte code offset #990
    //   Java source line #1052	-> byte code offset #1004
    //   Java source line #1056	-> byte code offset #1018
    //   Java source line #1059	-> byte code offset #1060
    //   Java source line #1061	-> byte code offset #1102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	l1	LList
    //   0	821	1	l2	LList
    //   51	1103	2	localObject	Object
    //   822	1	3	localClassCastException1	ClassCastException
    //   836	1	4	localClassCastException2	ClassCastException
    //   850	1	5	localClassCastException3	ClassCastException
    //   864	1	6	localClassCastException4	ClassCastException
    //   878	1	7	localClassCastException5	ClassCastException
    //   892	1	8	localClassCastException6	ClassCastException
    //   906	1	9	localClassCastException7	ClassCastException
    //   920	1	10	localClassCastException8	ClassCastException
    //   934	1	11	localClassCastException9	ClassCastException
    //   948	1	12	localClassCastException10	ClassCastException
    //   962	1	13	localClassCastException11	ClassCastException
    //   976	1	14	localClassCastException12	ClassCastException
    //   990	1	15	localClassCastException13	ClassCastException
    //   1004	1	16	localClassCastException14	ClassCastException
    //   1018	1	17	localClassCastException15	ClassCastException
    //   1032	1	18	localClassCastException16	ClassCastException
    //   1046	1	19	localClassCastException17	ClassCastException
    //   1060	1	20	localClassCastException18	ClassCastException
    //   1074	1	21	localClassCastException19	ClassCastException
    //   1088	1	22	localClassCastException20	ClassCastException
    //   1102	1	23	localClassCastException21	ClassCastException
    //   1116	1	24	localClassCastException22	ClassCastException
    //   1130	1	25	localClassCastException23	ClassCastException
    //   1144	1	26	localClassCastException24	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   52	55	822	java/lang/ClassCastException
    //   70	73	836	java/lang/ClassCastException
    //   84	87	850	java/lang/ClassCastException
    //   147	150	864	java/lang/ClassCastException
    //   166	169	878	java/lang/ClassCastException
    //   180	183	892	java/lang/ClassCastException
    //   247	250	906	java/lang/ClassCastException
    //   259	262	920	java/lang/ClassCastException
    //   273	276	934	java/lang/ClassCastException
    //   306	309	948	java/lang/ClassCastException
    //   320	323	962	java/lang/ClassCastException
    //   337	340	976	java/lang/ClassCastException
    //   430	433	990	java/lang/ClassCastException
    //   547	550	1004	java/lang/ClassCastException
    //   603	606	1018	java/lang/ClassCastException
    //   617	620	1032	java/lang/ClassCastException
    //   657	660	1046	java/lang/ClassCastException
    //   699	702	1060	java/lang/ClassCastException
    //   713	716	1074	java/lang/ClassCastException
    //   753	756	1088	java/lang/ClassCastException
    //   781	784	1102	java/lang/ClassCastException
    //   795	798	1116	java/lang/ClassCastException
    //   801	804	1130	java/lang/ClassCastException
    //   815	818	1144	java/lang/ClassCastException
  }
  
  /* Error */
  static int $PcBoundaryPairsLength(LList l)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: istore_2
    //   3: astore_1
    //   4: aload_1
    //   5: invokestatic 358	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   8: ifeq +7 -> 15
    //   11: iload_2
    //   12: goto +66 -> 78
    //   15: getstatic 476	gnu/kawa/slib/srfi14:Lit4	Ljava/lang/Integer;
    //   18: aload_1
    //   19: invokestatic 370	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: invokestatic 419	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   25: ifeq +28 -> 53
    //   28: aload_1
    //   29: dup
    //   30: astore_3
    //   31: checkcast 378	gnu/lists/Pair
    //   34: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   37: ldc_w 360
    //   40: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   43: checkcast 360	gnu/lists/LList
    //   46: iinc 2 1
    //   49: astore_1
    //   50: goto -46 -> 4
    //   53: aload_1
    //   54: dup
    //   55: astore_3
    //   56: checkcast 378	gnu/lists/Pair
    //   59: invokestatic 383	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   62: ldc_w 360
    //   65: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   68: checkcast 360	gnu/lists/LList
    //   71: iinc 2 2
    //   74: astore_1
    //   75: goto -71 -> 4
    //   78: ireturn
    //   79: new 75	gnu/mapping/WrongType
    //   82: dup_x1
    //   83: swap
    //   84: ldc_w 380
    //   87: iconst_1
    //   88: aload_3
    //   89: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   92: athrow
    //   93: new 75	gnu/mapping/WrongType
    //   96: dup_x1
    //   97: swap
    //   98: ldc_w 380
    //   101: iconst_1
    //   102: aload_3
    //   103: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   106: athrow
    // Line number table:
    //   Java source line #954	-> byte code offset #0
    //   Java source line #955	-> byte code offset #0
    //   Java source line #956	-> byte code offset #4
    //   Java source line #957	-> byte code offset #18
    //   Java source line #958	-> byte code offset #28
    //   Java source line #959	-> byte code offset #53
    //   Java source line #958	-> byte code offset #79
    //   Java source line #959	-> byte code offset #93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	l	LList
    //   4	74	1	l	LList
    //   4	74	2	size	int
    // Exception table:
    //   from	to	target	type
    //   31	34	79	java/lang/ClassCastException
    //   56	59	93	java/lang/ClassCastException
  }
  
  public srfi14()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1612	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+468->472, 4:+435->439, 6:+402->406, 9:+382->386, 16:+349->353, 17:+312->316, 20:+290->294, 30:+273->277, 31:+240->244, 33:+207->211, 34:+174->178, 42:+141->145, 48:+108->112
    //   112: aload_3
    //   113: aload_2
    //   114: ldc 30
    //   116: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: dup
    //   120: instanceof 30
    //   123: ifne +7 -> 130
    //   126: ldc_w 1613
    //   129: ireturn
    //   130: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   133: aload_3
    //   134: aload_1
    //   135: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   138: aload_3
    //   139: iconst_1
    //   140: putfield 1623	gnu/mapping/CallContext:pc	I
    //   143: iconst_0
    //   144: ireturn
    //   145: aload_3
    //   146: aload_2
    //   147: ldc 30
    //   149: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   152: dup
    //   153: instanceof 30
    //   156: ifne +7 -> 163
    //   159: ldc_w 1613
    //   162: ireturn
    //   163: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   166: aload_3
    //   167: aload_1
    //   168: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   171: aload_3
    //   172: iconst_1
    //   173: putfield 1623	gnu/mapping/CallContext:pc	I
    //   176: iconst_0
    //   177: ireturn
    //   178: aload_3
    //   179: aload_2
    //   180: ldc 30
    //   182: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   185: dup
    //   186: instanceof 30
    //   189: ifne +7 -> 196
    //   192: ldc_w 1613
    //   195: ireturn
    //   196: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   199: aload_3
    //   200: aload_1
    //   201: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   204: aload_3
    //   205: iconst_1
    //   206: putfield 1623	gnu/mapping/CallContext:pc	I
    //   209: iconst_0
    //   210: ireturn
    //   211: aload_3
    //   212: aload_2
    //   213: ldc 30
    //   215: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   218: dup
    //   219: instanceof 30
    //   222: ifne +7 -> 229
    //   225: ldc_w 1613
    //   228: ireturn
    //   229: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   232: aload_3
    //   233: aload_1
    //   234: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   237: aload_3
    //   238: iconst_1
    //   239: putfield 1623	gnu/mapping/CallContext:pc	I
    //   242: iconst_0
    //   243: ireturn
    //   244: aload_3
    //   245: aload_2
    //   246: ldc 30
    //   248: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   251: dup
    //   252: instanceof 30
    //   255: ifne +7 -> 262
    //   258: ldc_w 1613
    //   261: ireturn
    //   262: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   265: aload_3
    //   266: aload_1
    //   267: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   270: aload_3
    //   271: iconst_1
    //   272: putfield 1623	gnu/mapping/CallContext:pc	I
    //   275: iconst_0
    //   276: ireturn
    //   277: aload_3
    //   278: aload_2
    //   279: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   282: aload_3
    //   283: aload_1
    //   284: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   287: aload_3
    //   288: iconst_1
    //   289: putfield 1623	gnu/mapping/CallContext:pc	I
    //   292: iconst_0
    //   293: ireturn
    //   294: aload_3
    //   295: aload_2
    //   296: ldc -19
    //   298: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   301: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   304: aload_3
    //   305: aload_1
    //   306: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   309: aload_3
    //   310: iconst_1
    //   311: putfield 1623	gnu/mapping/CallContext:pc	I
    //   314: iconst_0
    //   315: ireturn
    //   316: aload_3
    //   317: aload_2
    //   318: ldc_w 360
    //   321: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   324: dup
    //   325: instanceof 360
    //   328: ifeq +6 -> 334
    //   331: goto +7 -> 338
    //   334: ldc_w 1613
    //   337: ireturn
    //   338: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   341: aload_3
    //   342: aload_1
    //   343: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   346: aload_3
    //   347: iconst_1
    //   348: putfield 1623	gnu/mapping/CallContext:pc	I
    //   351: iconst_0
    //   352: ireturn
    //   353: aload_3
    //   354: aload_2
    //   355: ldc 30
    //   357: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   360: dup
    //   361: instanceof 30
    //   364: ifne +7 -> 371
    //   367: ldc_w 1613
    //   370: ireturn
    //   371: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   374: aload_3
    //   375: aload_1
    //   376: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   379: aload_3
    //   380: iconst_1
    //   381: putfield 1623	gnu/mapping/CallContext:pc	I
    //   384: iconst_0
    //   385: ireturn
    //   386: aload_3
    //   387: aload_2
    //   388: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   391: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   394: aload_3
    //   395: aload_1
    //   396: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   399: aload_3
    //   400: iconst_1
    //   401: putfield 1623	gnu/mapping/CallContext:pc	I
    //   404: iconst_0
    //   405: ireturn
    //   406: aload_3
    //   407: aload_2
    //   408: ldc 30
    //   410: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   413: dup
    //   414: instanceof 30
    //   417: ifne +7 -> 424
    //   420: ldc_w 1613
    //   423: ireturn
    //   424: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   427: aload_3
    //   428: aload_1
    //   429: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   432: aload_3
    //   433: iconst_1
    //   434: putfield 1623	gnu/mapping/CallContext:pc	I
    //   437: iconst_0
    //   438: ireturn
    //   439: aload_3
    //   440: aload_2
    //   441: ldc 30
    //   443: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   446: dup
    //   447: instanceof 30
    //   450: ifne +7 -> 457
    //   453: ldc_w 1613
    //   456: ireturn
    //   457: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   460: aload_3
    //   461: aload_1
    //   462: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   465: aload_3
    //   466: iconst_1
    //   467: putfield 1623	gnu/mapping/CallContext:pc	I
    //   470: iconst_0
    //   471: ireturn
    //   472: aload_0
    //   473: aload_1
    //   474: aload_2
    //   475: aload_3
    //   476: invokespecial 1627	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   479: ireturn
    // Line number table:
    //   Java source line #879	-> byte code offset #112
    //   Java source line #816	-> byte code offset #145
    //   Java source line #746	-> byte code offset #178
    //   Java source line #740	-> byte code offset #211
    //   Java source line #729	-> byte code offset #244
    //   Java source line #717	-> byte code offset #277
    //   Java source line #628	-> byte code offset #294
    //   Java source line #607	-> byte code offset #316
    //   Java source line #286	-> byte code offset #353
    //   Java source line #217	-> byte code offset #386
    //   Java source line #196	-> byte code offset #406
    //   Java source line #177	-> byte code offset #439
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1612	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+1164->1168, 4:+1119->1123, 7:+1074->1078, 8:+1029->1033, 14:+968->972, 15:+907->911, 17:+845->849, 19:+783->787, 20:+736->740, 22:+689->693, 23:+628->632, 26:+596->600, 32:+535->539, 35:+476->480, 36:+415->419, 37:+354->358, 53:+288->292, 54:+222->226, 55:+156->160
    //   160: aload 4
    //   162: aload_2
    //   163: ldc_w 360
    //   166: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   169: dup
    //   170: instanceof 360
    //   173: ifeq +6 -> 179
    //   176: goto +7 -> 183
    //   179: ldc_w 1613
    //   182: ireturn
    //   183: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   186: aload 4
    //   188: aload_3
    //   189: ldc_w 360
    //   192: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   195: dup
    //   196: instanceof 360
    //   199: ifeq +6 -> 205
    //   202: goto +7 -> 209
    //   205: ldc_w 1628
    //   208: ireturn
    //   209: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   212: aload 4
    //   214: aload_1
    //   215: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   218: aload 4
    //   220: iconst_2
    //   221: putfield 1623	gnu/mapping/CallContext:pc	I
    //   224: iconst_0
    //   225: ireturn
    //   226: aload 4
    //   228: aload_2
    //   229: ldc_w 360
    //   232: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   235: dup
    //   236: instanceof 360
    //   239: ifeq +6 -> 245
    //   242: goto +7 -> 249
    //   245: ldc_w 1613
    //   248: ireturn
    //   249: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   252: aload 4
    //   254: aload_3
    //   255: ldc_w 360
    //   258: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   261: dup
    //   262: instanceof 360
    //   265: ifeq +6 -> 271
    //   268: goto +7 -> 275
    //   271: ldc_w 1628
    //   274: ireturn
    //   275: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   278: aload 4
    //   280: aload_1
    //   281: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   284: aload 4
    //   286: iconst_2
    //   287: putfield 1623	gnu/mapping/CallContext:pc	I
    //   290: iconst_0
    //   291: ireturn
    //   292: aload 4
    //   294: aload_2
    //   295: ldc_w 360
    //   298: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   301: dup
    //   302: instanceof 360
    //   305: ifeq +6 -> 311
    //   308: goto +7 -> 315
    //   311: ldc_w 1613
    //   314: ireturn
    //   315: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   318: aload 4
    //   320: aload_3
    //   321: ldc_w 360
    //   324: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   327: dup
    //   328: instanceof 360
    //   331: ifeq +6 -> 337
    //   334: goto +7 -> 341
    //   337: ldc_w 1628
    //   340: ireturn
    //   341: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   344: aload 4
    //   346: aload_1
    //   347: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   350: aload 4
    //   352: iconst_2
    //   353: putfield 1623	gnu/mapping/CallContext:pc	I
    //   356: iconst_0
    //   357: ireturn
    //   358: aload 4
    //   360: aload_2
    //   361: ldc 18
    //   363: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   366: dup
    //   367: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   370: ifnull +6 -> 376
    //   373: goto +7 -> 380
    //   376: ldc_w 1613
    //   379: ireturn
    //   380: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   383: aload 4
    //   385: aload_3
    //   386: ldc 30
    //   388: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   391: dup
    //   392: instanceof 30
    //   395: ifne +7 -> 402
    //   398: ldc_w 1628
    //   401: ireturn
    //   402: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   405: aload 4
    //   407: aload_1
    //   408: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   411: aload 4
    //   413: iconst_2
    //   414: putfield 1623	gnu/mapping/CallContext:pc	I
    //   417: iconst_0
    //   418: ireturn
    //   419: aload 4
    //   421: aload_2
    //   422: ldc 18
    //   424: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   427: dup
    //   428: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   431: ifnull +6 -> 437
    //   434: goto +7 -> 441
    //   437: ldc_w 1613
    //   440: ireturn
    //   441: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   444: aload 4
    //   446: aload_3
    //   447: ldc 30
    //   449: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   452: dup
    //   453: instanceof 30
    //   456: ifne +7 -> 463
    //   459: ldc_w 1628
    //   462: ireturn
    //   463: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   466: aload 4
    //   468: aload_1
    //   469: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   472: aload 4
    //   474: iconst_2
    //   475: putfield 1623	gnu/mapping/CallContext:pc	I
    //   478: iconst_0
    //   479: ireturn
    //   480: aload 4
    //   482: aload_2
    //   483: ldc 30
    //   485: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   488: dup
    //   489: instanceof 30
    //   492: ifne +7 -> 499
    //   495: ldc_w 1613
    //   498: ireturn
    //   499: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   502: aload 4
    //   504: aload_3
    //   505: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   508: dup
    //   509: invokestatic 1640	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   512: iflt +6 -> 518
    //   515: goto +7 -> 522
    //   518: ldc_w 1628
    //   521: ireturn
    //   522: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   525: aload 4
    //   527: aload_1
    //   528: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   531: aload 4
    //   533: iconst_2
    //   534: putfield 1623	gnu/mapping/CallContext:pc	I
    //   537: iconst_0
    //   538: ireturn
    //   539: aload 4
    //   541: aload_2
    //   542: ldc 18
    //   544: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   547: dup
    //   548: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   551: ifnull +6 -> 557
    //   554: goto +7 -> 561
    //   557: ldc_w 1613
    //   560: ireturn
    //   561: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   564: aload 4
    //   566: aload_3
    //   567: ldc 30
    //   569: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   572: dup
    //   573: instanceof 30
    //   576: ifne +7 -> 583
    //   579: ldc_w 1628
    //   582: ireturn
    //   583: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   586: aload 4
    //   588: aload_1
    //   589: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   592: aload 4
    //   594: iconst_2
    //   595: putfield 1623	gnu/mapping/CallContext:pc	I
    //   598: iconst_0
    //   599: ireturn
    //   600: aload 4
    //   602: aload_2
    //   603: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   606: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   609: aload 4
    //   611: aload_3
    //   612: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   615: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   618: aload 4
    //   620: aload_1
    //   621: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   624: aload 4
    //   626: iconst_2
    //   627: putfield 1623	gnu/mapping/CallContext:pc	I
    //   630: iconst_0
    //   631: ireturn
    //   632: aload 4
    //   634: aload_2
    //   635: ldc 18
    //   637: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   640: dup
    //   641: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   644: ifnull +6 -> 650
    //   647: goto +7 -> 654
    //   650: ldc_w 1613
    //   653: ireturn
    //   654: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   657: aload 4
    //   659: aload_3
    //   660: ldc 30
    //   662: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   665: dup
    //   666: instanceof 30
    //   669: ifne +7 -> 676
    //   672: ldc_w 1628
    //   675: ireturn
    //   676: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   679: aload 4
    //   681: aload_1
    //   682: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   685: aload 4
    //   687: iconst_2
    //   688: putfield 1623	gnu/mapping/CallContext:pc	I
    //   691: iconst_0
    //   692: ireturn
    //   693: aload 4
    //   695: aload_2
    //   696: ldc -19
    //   698: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   701: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   704: aload 4
    //   706: aload_3
    //   707: ldc 30
    //   709: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   712: dup
    //   713: instanceof 30
    //   716: ifne +7 -> 723
    //   719: ldc_w 1628
    //   722: ireturn
    //   723: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   726: aload 4
    //   728: aload_1
    //   729: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   732: aload 4
    //   734: iconst_2
    //   735: putfield 1623	gnu/mapping/CallContext:pc	I
    //   738: iconst_0
    //   739: ireturn
    //   740: aload 4
    //   742: aload_2
    //   743: ldc -19
    //   745: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   748: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   751: aload 4
    //   753: aload_3
    //   754: ldc 30
    //   756: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   759: dup
    //   760: instanceof 30
    //   763: ifne +7 -> 770
    //   766: ldc_w 1628
    //   769: ireturn
    //   770: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   773: aload 4
    //   775: aload_1
    //   776: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   779: aload 4
    //   781: iconst_2
    //   782: putfield 1623	gnu/mapping/CallContext:pc	I
    //   785: iconst_0
    //   786: ireturn
    //   787: aload 4
    //   789: aload_2
    //   790: ldc_w 360
    //   793: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   796: dup
    //   797: instanceof 360
    //   800: ifeq +6 -> 806
    //   803: goto +7 -> 810
    //   806: ldc_w 1613
    //   809: ireturn
    //   810: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   813: aload 4
    //   815: aload_3
    //   816: ldc 30
    //   818: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   821: dup
    //   822: instanceof 30
    //   825: ifne +7 -> 832
    //   828: ldc_w 1628
    //   831: ireturn
    //   832: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   835: aload 4
    //   837: aload_1
    //   838: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   841: aload 4
    //   843: iconst_2
    //   844: putfield 1623	gnu/mapping/CallContext:pc	I
    //   847: iconst_0
    //   848: ireturn
    //   849: aload 4
    //   851: aload_2
    //   852: ldc_w 360
    //   855: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   858: dup
    //   859: instanceof 360
    //   862: ifeq +6 -> 868
    //   865: goto +7 -> 872
    //   868: ldc_w 1613
    //   871: ireturn
    //   872: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   875: aload 4
    //   877: aload_3
    //   878: ldc 30
    //   880: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   883: dup
    //   884: instanceof 30
    //   887: ifne +7 -> 894
    //   890: ldc_w 1628
    //   893: ireturn
    //   894: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   897: aload 4
    //   899: aload_1
    //   900: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   903: aload 4
    //   905: iconst_2
    //   906: putfield 1623	gnu/mapping/CallContext:pc	I
    //   909: iconst_0
    //   910: ireturn
    //   911: aload 4
    //   913: aload_2
    //   914: ldc 18
    //   916: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   919: dup
    //   920: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   923: ifnull +6 -> 929
    //   926: goto +7 -> 933
    //   929: ldc_w 1613
    //   932: ireturn
    //   933: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   936: aload 4
    //   938: aload_3
    //   939: ldc 30
    //   941: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   944: dup
    //   945: instanceof 30
    //   948: ifne +7 -> 955
    //   951: ldc_w 1628
    //   954: ireturn
    //   955: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   958: aload 4
    //   960: aload_1
    //   961: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   964: aload 4
    //   966: iconst_2
    //   967: putfield 1623	gnu/mapping/CallContext:pc	I
    //   970: iconst_0
    //   971: ireturn
    //   972: aload 4
    //   974: aload_2
    //   975: ldc 18
    //   977: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   980: dup
    //   981: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   984: ifnull +6 -> 990
    //   987: goto +7 -> 994
    //   990: ldc_w 1613
    //   993: ireturn
    //   994: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   997: aload 4
    //   999: aload_3
    //   1000: ldc 30
    //   1002: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1005: dup
    //   1006: instanceof 30
    //   1009: ifne +7 -> 1016
    //   1012: ldc_w 1628
    //   1015: ireturn
    //   1016: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1019: aload 4
    //   1021: aload_1
    //   1022: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1025: aload 4
    //   1027: iconst_2
    //   1028: putfield 1623	gnu/mapping/CallContext:pc	I
    //   1031: iconst_0
    //   1032: ireturn
    //   1033: aload 4
    //   1035: aload_2
    //   1036: ldc 30
    //   1038: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1041: dup
    //   1042: instanceof 30
    //   1045: ifne +7 -> 1052
    //   1048: ldc_w 1613
    //   1051: ireturn
    //   1052: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1055: aload 4
    //   1057: aload_3
    //   1058: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1061: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1064: aload 4
    //   1066: aload_1
    //   1067: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1070: aload 4
    //   1072: iconst_2
    //   1073: putfield 1623	gnu/mapping/CallContext:pc	I
    //   1076: iconst_0
    //   1077: ireturn
    //   1078: aload 4
    //   1080: aload_2
    //   1081: ldc 30
    //   1083: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1086: dup
    //   1087: instanceof 30
    //   1090: ifne +7 -> 1097
    //   1093: ldc_w 1613
    //   1096: ireturn
    //   1097: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1100: aload 4
    //   1102: aload_3
    //   1103: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1106: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1109: aload 4
    //   1111: aload_1
    //   1112: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1115: aload 4
    //   1117: iconst_2
    //   1118: putfield 1623	gnu/mapping/CallContext:pc	I
    //   1121: iconst_0
    //   1122: ireturn
    //   1123: aload 4
    //   1125: aload_2
    //   1126: ldc 30
    //   1128: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1131: dup
    //   1132: instanceof 30
    //   1135: ifne +7 -> 1142
    //   1138: ldc_w 1613
    //   1141: ireturn
    //   1142: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1145: aload 4
    //   1147: aload_3
    //   1148: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1151: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1154: aload 4
    //   1156: aload_1
    //   1157: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1160: aload 4
    //   1162: iconst_2
    //   1163: putfield 1623	gnu/mapping/CallContext:pc	I
    //   1166: iconst_0
    //   1167: ireturn
    //   1168: aload_0
    //   1169: aload_1
    //   1170: aload_2
    //   1171: aload_3
    //   1172: aload 4
    //   1174: invokespecial 1644	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   1177: ireturn
    // Line number table:
    //   Java source line #1027	-> byte code offset #160
    //   Java source line #1000	-> byte code offset #226
    //   Java source line #977	-> byte code offset #292
    //   Java source line #767	-> byte code offset #358
    //   Java source line #757	-> byte code offset #419
    //   Java source line #752	-> byte code offset #480
    //   Java source line #733	-> byte code offset #539
    //   Java source line #680	-> byte code offset #600
    //   Java source line #648	-> byte code offset #632
    //   Java source line #639	-> byte code offset #693
    //   Java source line #628	-> byte code offset #740
    //   Java source line #619	-> byte code offset #787
    //   Java source line #607	-> byte code offset #849
    //   Java source line #274	-> byte code offset #911
    //   Java source line #263	-> byte code offset #972
    //   Java source line #210	-> byte code offset #1033
    //   Java source line #202	-> byte code offset #1078
    //   Java source line #177	-> byte code offset #1123
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1612	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+336->340, 10:+268->272, 23:+184->188, 25:+100->104, 26:+44->48
    //   48: aload 5
    //   50: aload_2
    //   51: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   57: aload 5
    //   59: aload_3
    //   60: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   66: aload 5
    //   68: aload 4
    //   70: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: dup
    //   74: instanceof 290
    //   77: ifeq +6 -> 83
    //   80: goto +7 -> 87
    //   83: ldc_w 1645
    //   86: ireturn
    //   87: putfield 1648	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   90: aload 5
    //   92: aload_1
    //   93: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   96: aload 5
    //   98: iconst_3
    //   99: putfield 1623	gnu/mapping/CallContext:pc	I
    //   102: iconst_0
    //   103: ireturn
    //   104: aload 5
    //   106: aload_2
    //   107: ldc 18
    //   109: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   112: dup
    //   113: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   116: ifnull +6 -> 122
    //   119: goto +7 -> 126
    //   122: ldc_w 1613
    //   125: ireturn
    //   126: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   129: aload 5
    //   131: aload_3
    //   132: ldc 30
    //   134: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   137: dup
    //   138: instanceof 30
    //   141: ifne +7 -> 148
    //   144: ldc_w 1628
    //   147: ireturn
    //   148: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   151: aload 5
    //   153: aload 4
    //   155: ldc 30
    //   157: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   160: dup
    //   161: instanceof 30
    //   164: ifne +7 -> 171
    //   167: ldc_w 1645
    //   170: ireturn
    //   171: putfield 1648	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   174: aload 5
    //   176: aload_1
    //   177: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   180: aload 5
    //   182: iconst_3
    //   183: putfield 1623	gnu/mapping/CallContext:pc	I
    //   186: iconst_0
    //   187: ireturn
    //   188: aload 5
    //   190: aload_2
    //   191: ldc 18
    //   193: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   196: dup
    //   197: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   200: ifnull +6 -> 206
    //   203: goto +7 -> 210
    //   206: ldc_w 1613
    //   209: ireturn
    //   210: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   213: aload 5
    //   215: aload_3
    //   216: ldc 30
    //   218: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   221: dup
    //   222: instanceof 30
    //   225: ifne +7 -> 232
    //   228: ldc_w 1628
    //   231: ireturn
    //   232: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   235: aload 5
    //   237: aload 4
    //   239: ldc 30
    //   241: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   244: dup
    //   245: instanceof 30
    //   248: ifne +7 -> 255
    //   251: ldc_w 1645
    //   254: ireturn
    //   255: putfield 1648	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   258: aload 5
    //   260: aload_1
    //   261: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   264: aload 5
    //   266: iconst_3
    //   267: putfield 1623	gnu/mapping/CallContext:pc	I
    //   270: iconst_0
    //   271: ireturn
    //   272: aload 5
    //   274: aload_2
    //   275: ldc 18
    //   277: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   280: dup
    //   281: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   284: ifnull +6 -> 290
    //   287: goto +7 -> 294
    //   290: ldc_w 1613
    //   293: ireturn
    //   294: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   297: aload 5
    //   299: aload_3
    //   300: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   303: aload 5
    //   305: aload 4
    //   307: ldc 30
    //   309: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   312: dup
    //   313: instanceof 30
    //   316: ifne +7 -> 323
    //   319: ldc_w 1645
    //   322: ireturn
    //   323: putfield 1648	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   326: aload 5
    //   328: aload_1
    //   329: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   332: aload 5
    //   334: iconst_3
    //   335: putfield 1623	gnu/mapping/CallContext:pc	I
    //   338: iconst_0
    //   339: ireturn
    //   340: aload_0
    //   341: aload_1
    //   342: aload_2
    //   343: aload_3
    //   344: aload 4
    //   346: aload 5
    //   348: invokespecial 1652	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   351: ireturn
    // Line number table:
    //   Java source line #680	-> byte code offset #48
    //   Java source line #664	-> byte code offset #104
    //   Java source line #648	-> byte code offset #188
    //   Java source line #225	-> byte code offset #272
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1612	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+291->295, 11:+194->198, 26:+115->119, 29:+36->40
    //   40: aload 6
    //   42: aload_2
    //   43: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   49: aload 6
    //   51: aload_3
    //   52: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   58: aload 6
    //   60: aload 4
    //   62: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: dup
    //   66: instanceof 290
    //   69: ifeq +6 -> 75
    //   72: goto +7 -> 79
    //   75: ldc_w 1645
    //   78: ireturn
    //   79: putfield 1648	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   82: aload 6
    //   84: aload 5
    //   86: ldc 30
    //   88: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   91: dup
    //   92: instanceof 30
    //   95: ifne +7 -> 102
    //   98: ldc_w 1653
    //   101: ireturn
    //   102: putfield 1656	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   105: aload 6
    //   107: aload_1
    //   108: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   111: aload 6
    //   113: iconst_4
    //   114: putfield 1623	gnu/mapping/CallContext:pc	I
    //   117: iconst_0
    //   118: ireturn
    //   119: aload 6
    //   121: aload_2
    //   122: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   128: aload 6
    //   130: aload_3
    //   131: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   137: aload 6
    //   139: aload 4
    //   141: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: dup
    //   145: instanceof 290
    //   148: ifeq +6 -> 154
    //   151: goto +7 -> 158
    //   154: ldc_w 1645
    //   157: ireturn
    //   158: putfield 1648	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   161: aload 6
    //   163: aload 5
    //   165: ldc 30
    //   167: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   170: dup
    //   171: instanceof 30
    //   174: ifne +7 -> 181
    //   177: ldc_w 1653
    //   180: ireturn
    //   181: putfield 1656	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   184: aload 6
    //   186: aload_1
    //   187: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   190: aload 6
    //   192: iconst_4
    //   193: putfield 1623	gnu/mapping/CallContext:pc	I
    //   196: iconst_0
    //   197: ireturn
    //   198: aload 6
    //   200: aload_2
    //   201: ldc 18
    //   203: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   206: dup
    //   207: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   210: ifnull +6 -> 216
    //   213: goto +7 -> 220
    //   216: ldc_w 1613
    //   219: ireturn
    //   220: putfield 1617	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   223: aload 6
    //   225: aload_3
    //   226: ldc 18
    //   228: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   231: dup
    //   232: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   235: ifnull +6 -> 241
    //   238: goto +7 -> 245
    //   241: ldc_w 1628
    //   244: ireturn
    //   245: putfield 1631	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   248: aload 6
    //   250: aload 4
    //   252: ldc 18
    //   254: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   257: dup
    //   258: invokestatic 1637	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   261: ifnull +6 -> 267
    //   264: goto +7 -> 271
    //   267: ldc_w 1645
    //   270: ireturn
    //   271: putfield 1648	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   274: aload 6
    //   276: aload 5
    //   278: putfield 1656	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   281: aload 6
    //   283: aload_1
    //   284: putfield 1620	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   287: aload 6
    //   289: iconst_4
    //   290: putfield 1623	gnu/mapping/CallContext:pc	I
    //   293: iconst_0
    //   294: ireturn
    //   295: aload_0
    //   296: aload_1
    //   297: aload_2
    //   298: aload_3
    //   299: aload 4
    //   301: aload 5
    //   303: aload 6
    //   305: invokespecial 1660	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   308: ireturn
    // Line number table:
    //   Java source line #700	-> byte code offset #40
    //   Java source line #680	-> byte code offset #119
    //   Java source line #237	-> byte code offset #198
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1612	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+617->621, 4:+156->160, 7:+182->186, 8:+208->212, 14:+234->238, 15:+256->260, 17:+278->282, 19:+301->305, 20:+324->328, 22:+355->359, 23:+386->390, 26:+408->412, 32:+432->436, 35:+457->461, 36:+489->493, 37:+523->527, 53:+545->549, 54:+569->573, 55:+593->597
    //   160: aload_2
    //   161: ldc 30
    //   163: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   166: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   169: aload_3
    //   170: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast 68	java/lang/Number
    //   176: invokevirtual 71	java/lang/Number:intValue	()I
    //   179: invokestatic 40	gnu/kawa/slib/srfi14:charSetHash	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   182: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: areturn
    //   186: aload_2
    //   187: ldc 30
    //   189: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   192: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   195: aload_3
    //   196: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 68	java/lang/Number
    //   202: invokevirtual 71	java/lang/Number:intValue	()I
    //   205: invokestatic 109	gnu/kawa/slib/srfi14:charSetRef	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   208: invokestatic 115	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   211: areturn
    //   212: aload_2
    //   213: ldc 30
    //   215: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   218: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   221: aload_3
    //   222: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   225: checkcast 68	java/lang/Number
    //   228: invokevirtual 71	java/lang/Number:intValue	()I
    //   231: invokestatic 104	gnu/kawa/slib/srfi14:charSetCursorNext	(Lgnu/kawa/slib/srfi14$CharSet;I)I
    //   234: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: areturn
    //   238: aload_2
    //   239: ldc 18
    //   241: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   244: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   247: aload_3
    //   248: ldc 30
    //   250: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   253: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   256: invokestatic 1720	gnu/kawa/slib/srfi14:charSetForEach	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Ljava/lang/Object;
    //   259: areturn
    //   260: aload_2
    //   261: ldc 18
    //   263: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   266: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   269: aload_3
    //   270: ldc 30
    //   272: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   275: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   278: invokestatic 1726	gnu/kawa/slib/srfi14:charSetMap	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   281: areturn
    //   282: aload_2
    //   283: ldc_w 360
    //   286: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   289: checkcast 360	gnu/lists/LList
    //   292: aload_3
    //   293: ldc 30
    //   295: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   298: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   301: invokestatic 160	gnu/kawa/slib/srfi14:list$To$CharSet	(Lgnu/lists/LList;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   304: areturn
    //   305: aload_2
    //   306: ldc_w 360
    //   309: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   312: checkcast 360	gnu/lists/LList
    //   315: aload_3
    //   316: ldc 30
    //   318: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   321: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   324: invokestatic 208	gnu/kawa/slib/srfi14:list$To$CharSet$Ex	(Lgnu/lists/LList;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   327: areturn
    //   328: aload_2
    //   329: ldc -19
    //   331: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   334: dup
    //   335: ifnonnull +8 -> 343
    //   338: pop
    //   339: aconst_null
    //   340: goto +6 -> 346
    //   343: invokevirtual 241	java/lang/Object:toString	()Ljava/lang/String;
    //   346: aload_3
    //   347: ldc 30
    //   349: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   352: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   355: invokestatic 199	gnu/kawa/slib/srfi14:string$To$CharSet	(Ljava/lang/String;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   358: areturn
    //   359: aload_2
    //   360: ldc -19
    //   362: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   365: dup
    //   366: ifnonnull +8 -> 374
    //   369: pop
    //   370: aconst_null
    //   371: goto +6 -> 377
    //   374: invokevirtual 241	java/lang/Object:toString	()Ljava/lang/String;
    //   377: aload_3
    //   378: ldc 30
    //   380: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   383: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   386: invokestatic 1735	gnu/kawa/slib/srfi14:string$To$CharSet$Ex	(Ljava/lang/String;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   389: areturn
    //   390: aload_2
    //   391: ldc 18
    //   393: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   396: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   399: aload_3
    //   400: ldc 30
    //   402: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   405: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   408: invokestatic 1739	gnu/kawa/slib/srfi14:charSetFilter	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   411: areturn
    //   412: aload_2
    //   413: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   416: checkcast 68	java/lang/Number
    //   419: invokevirtual 71	java/lang/Number:intValue	()I
    //   422: aload_3
    //   423: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   426: checkcast 68	java/lang/Number
    //   429: invokevirtual 71	java/lang/Number:intValue	()I
    //   432: invokestatic 1744	gnu/kawa/slib/srfi14:ucsRange$To$CharSet	(II)Lgnu/kawa/slib/srfi14$CharSet;
    //   435: areturn
    //   436: aload_2
    //   437: ldc 18
    //   439: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   442: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   445: aload_3
    //   446: ldc 30
    //   448: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   451: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   454: invokestatic 1750	gnu/kawa/slib/srfi14:charSetCount	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)I
    //   457: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: areturn
    //   461: aload_2
    //   462: ldc 30
    //   464: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   467: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   470: aload_3
    //   471: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   474: invokestatic 139	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   477: invokestatic 1756	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
    //   480: ifeq +9 -> 489
    //   483: getstatic 1680	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   486: goto +6 -> 492
    //   489: getstatic 294	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   492: areturn
    //   493: aload_2
    //   494: ldc 18
    //   496: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   499: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   502: aload_3
    //   503: ldc 30
    //   505: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   508: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   511: invokestatic 1762	gnu/kawa/slib/srfi14:charSetEvery	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Z
    //   514: ifeq +9 -> 523
    //   517: getstatic 1680	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   520: goto +6 -> 526
    //   523: getstatic 294	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   526: areturn
    //   527: aload_2
    //   528: ldc 18
    //   530: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   533: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   536: aload_3
    //   537: ldc 30
    //   539: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   542: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   545: invokestatic 1767	gnu/kawa/slib/srfi14:charSetAny	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Ljava/lang/Object;
    //   548: areturn
    //   549: aload_2
    //   550: ldc_w 360
    //   553: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   556: checkcast 360	gnu/lists/LList
    //   559: aload_3
    //   560: ldc_w 360
    //   563: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   566: checkcast 360	gnu/lists/LList
    //   569: invokestatic 389	gnu/kawa/slib/srfi14:$PcBoundaryPairsIntersection	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   572: areturn
    //   573: aload_2
    //   574: ldc_w 360
    //   577: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   580: checkcast 360	gnu/lists/LList
    //   583: aload_3
    //   584: ldc_w 360
    //   587: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   590: checkcast 360	gnu/lists/LList
    //   593: invokestatic 425	gnu/kawa/slib/srfi14:$PcBoundaryPairsUnion	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   596: areturn
    //   597: aload_2
    //   598: ldc_w 360
    //   601: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   604: checkcast 360	gnu/lists/LList
    //   607: aload_3
    //   608: ldc_w 360
    //   611: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   614: checkcast 360	gnu/lists/LList
    //   617: invokestatic 448	gnu/kawa/slib/srfi14:$PcBoundaryPairsXor	(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   620: areturn
    //   621: aload_0
    //   622: aload_1
    //   623: aload_2
    //   624: aload_3
    //   625: invokespecial 1770	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   628: areturn
    //   629: new 75	gnu/mapping/WrongType
    //   632: dup_x1
    //   633: swap
    //   634: ldc_w 1673
    //   637: iconst_1
    //   638: aload_2
    //   639: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   642: athrow
    //   643: new 75	gnu/mapping/WrongType
    //   646: dup_x1
    //   647: swap
    //   648: ldc_w 1673
    //   651: iconst_2
    //   652: aload_3
    //   653: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   656: athrow
    //   657: new 75	gnu/mapping/WrongType
    //   660: dup_x1
    //   661: swap
    //   662: ldc 106
    //   664: iconst_1
    //   665: aload_2
    //   666: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   669: athrow
    //   670: new 75	gnu/mapping/WrongType
    //   673: dup_x1
    //   674: swap
    //   675: ldc 106
    //   677: iconst_2
    //   678: aload_3
    //   679: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   682: athrow
    //   683: new 75	gnu/mapping/WrongType
    //   686: dup_x1
    //   687: swap
    //   688: ldc 101
    //   690: iconst_1
    //   691: aload_2
    //   692: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   695: athrow
    //   696: new 75	gnu/mapping/WrongType
    //   699: dup_x1
    //   700: swap
    //   701: ldc 101
    //   703: iconst_2
    //   704: aload_3
    //   705: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   708: athrow
    //   709: new 75	gnu/mapping/WrongType
    //   712: dup_x1
    //   713: swap
    //   714: ldc_w 1716
    //   717: iconst_1
    //   718: aload_2
    //   719: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   722: athrow
    //   723: new 75	gnu/mapping/WrongType
    //   726: dup_x1
    //   727: swap
    //   728: ldc_w 1716
    //   731: iconst_2
    //   732: aload_3
    //   733: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   736: athrow
    //   737: new 75	gnu/mapping/WrongType
    //   740: dup_x1
    //   741: swap
    //   742: ldc_w 1722
    //   745: iconst_1
    //   746: aload_2
    //   747: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   750: athrow
    //   751: new 75	gnu/mapping/WrongType
    //   754: dup_x1
    //   755: swap
    //   756: ldc_w 1722
    //   759: iconst_2
    //   760: aload_3
    //   761: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   764: athrow
    //   765: new 75	gnu/mapping/WrongType
    //   768: dup_x1
    //   769: swap
    //   770: ldc_w 1684
    //   773: iconst_1
    //   774: aload_2
    //   775: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   778: athrow
    //   779: new 75	gnu/mapping/WrongType
    //   782: dup_x1
    //   783: swap
    //   784: ldc_w 1684
    //   787: iconst_2
    //   788: aload_3
    //   789: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   792: athrow
    //   793: new 75	gnu/mapping/WrongType
    //   796: dup_x1
    //   797: swap
    //   798: ldc_w 1728
    //   801: iconst_1
    //   802: aload_2
    //   803: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   806: athrow
    //   807: new 75	gnu/mapping/WrongType
    //   810: dup_x1
    //   811: swap
    //   812: ldc_w 1728
    //   815: iconst_2
    //   816: aload_3
    //   817: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   820: athrow
    //   821: new 75	gnu/mapping/WrongType
    //   824: dup_x1
    //   825: swap
    //   826: ldc_w 1730
    //   829: iconst_2
    //   830: aload_3
    //   831: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   834: athrow
    //   835: new 75	gnu/mapping/WrongType
    //   838: dup_x1
    //   839: swap
    //   840: ldc_w 1732
    //   843: iconst_2
    //   844: aload_3
    //   845: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   848: athrow
    //   849: new 75	gnu/mapping/WrongType
    //   852: dup_x1
    //   853: swap
    //   854: ldc_w 1737
    //   857: iconst_1
    //   858: aload_2
    //   859: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   862: athrow
    //   863: new 75	gnu/mapping/WrongType
    //   866: dup_x1
    //   867: swap
    //   868: ldc_w 1737
    //   871: iconst_2
    //   872: aload_3
    //   873: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   876: athrow
    //   877: new 75	gnu/mapping/WrongType
    //   880: dup_x1
    //   881: swap
    //   882: ldc_w 1741
    //   885: iconst_1
    //   886: aload_2
    //   887: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   890: athrow
    //   891: new 75	gnu/mapping/WrongType
    //   894: dup_x1
    //   895: swap
    //   896: ldc_w 1741
    //   899: iconst_2
    //   900: aload_3
    //   901: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   904: athrow
    //   905: new 75	gnu/mapping/WrongType
    //   908: dup_x1
    //   909: swap
    //   910: ldc_w 1746
    //   913: iconst_1
    //   914: aload_2
    //   915: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   918: athrow
    //   919: new 75	gnu/mapping/WrongType
    //   922: dup_x1
    //   923: swap
    //   924: ldc_w 1746
    //   927: iconst_2
    //   928: aload_3
    //   929: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   932: athrow
    //   933: new 75	gnu/mapping/WrongType
    //   936: dup_x1
    //   937: swap
    //   938: ldc_w 1752
    //   941: iconst_1
    //   942: aload_2
    //   943: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   946: athrow
    //   947: new 75	gnu/mapping/WrongType
    //   950: dup_x1
    //   951: swap
    //   952: ldc_w 1752
    //   955: iconst_2
    //   956: aload_3
    //   957: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   960: athrow
    //   961: new 75	gnu/mapping/WrongType
    //   964: dup_x1
    //   965: swap
    //   966: ldc_w 1758
    //   969: iconst_1
    //   970: aload_2
    //   971: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   974: athrow
    //   975: new 75	gnu/mapping/WrongType
    //   978: dup_x1
    //   979: swap
    //   980: ldc_w 1758
    //   983: iconst_2
    //   984: aload_3
    //   985: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   988: athrow
    //   989: new 75	gnu/mapping/WrongType
    //   992: dup_x1
    //   993: swap
    //   994: ldc_w 1764
    //   997: iconst_1
    //   998: aload_2
    //   999: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1002: athrow
    //   1003: new 75	gnu/mapping/WrongType
    //   1006: dup_x1
    //   1007: swap
    //   1008: ldc_w 1764
    //   1011: iconst_2
    //   1012: aload_3
    //   1013: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1016: athrow
    //   1017: new 75	gnu/mapping/WrongType
    //   1020: dup_x1
    //   1021: swap
    //   1022: ldc_w 385
    //   1025: iconst_1
    //   1026: aload_2
    //   1027: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1030: athrow
    //   1031: new 75	gnu/mapping/WrongType
    //   1034: dup_x1
    //   1035: swap
    //   1036: ldc_w 385
    //   1039: iconst_2
    //   1040: aload_3
    //   1041: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1044: athrow
    //   1045: new 75	gnu/mapping/WrongType
    //   1048: dup_x1
    //   1049: swap
    //   1050: ldc_w 429
    //   1053: iconst_1
    //   1054: aload_2
    //   1055: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1058: athrow
    //   1059: new 75	gnu/mapping/WrongType
    //   1062: dup_x1
    //   1063: swap
    //   1064: ldc_w 429
    //   1067: iconst_2
    //   1068: aload_3
    //   1069: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1072: athrow
    //   1073: new 75	gnu/mapping/WrongType
    //   1076: dup_x1
    //   1077: swap
    //   1078: ldc_w 445
    //   1081: iconst_1
    //   1082: aload_2
    //   1083: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1086: athrow
    //   1087: new 75	gnu/mapping/WrongType
    //   1090: dup_x1
    //   1091: swap
    //   1092: ldc_w 445
    //   1095: iconst_2
    //   1096: aload_3
    //   1097: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1100: athrow
    // Line number table:
    //   Java source line #177	-> byte code offset #160
    //   Java source line #202	-> byte code offset #186
    //   Java source line #210	-> byte code offset #212
    //   Java source line #263	-> byte code offset #238
    //   Java source line #274	-> byte code offset #260
    //   Java source line #607	-> byte code offset #282
    //   Java source line #619	-> byte code offset #305
    //   Java source line #628	-> byte code offset #328
    //   Java source line #639	-> byte code offset #359
    //   Java source line #648	-> byte code offset #390
    //   Java source line #680	-> byte code offset #412
    //   Java source line #733	-> byte code offset #436
    //   Java source line #752	-> byte code offset #461
    //   Java source line #757	-> byte code offset #493
    //   Java source line #767	-> byte code offset #527
    //   Java source line #977	-> byte code offset #549
    //   Java source line #1000	-> byte code offset #573
    //   Java source line #1027	-> byte code offset #597
    //   Java source line #177	-> byte code offset #629
    //   Java source line #178	-> byte code offset #643
    //   Java source line #202	-> byte code offset #657
    //   Java source line #210	-> byte code offset #683
    //   Java source line #263	-> byte code offset #709
    //   Java source line #274	-> byte code offset #737
    //   Java source line #607	-> byte code offset #765
    //   Java source line #609	-> byte code offset #779
    //   Java source line #619	-> byte code offset #793
    //   Java source line #630	-> byte code offset #821
    //   Java source line #639	-> byte code offset #835
    //   Java source line #648	-> byte code offset #849
    //   Java source line #680	-> byte code offset #877
    //   Java source line #733	-> byte code offset #905
    //   Java source line #752	-> byte code offset #933
    //   Java source line #757	-> byte code offset #961
    //   Java source line #767	-> byte code offset #989
    //   Java source line #977	-> byte code offset #1017
    //   Java source line #1000	-> byte code offset #1045
    //   Java source line #1027	-> byte code offset #1073
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1101	0	this	srfi14
    //   0	1101	1	paramModuleMethod	ModuleMethod
    //   0	1101	2	paramObject1	Object
    //   0	1101	3	paramObject2	Object
    //   629	1	4	localClassCastException1	ClassCastException
    //   643	1	5	localClassCastException2	ClassCastException
    //   657	1	6	localClassCastException3	ClassCastException
    //   670	1	7	localClassCastException4	ClassCastException
    //   683	1	8	localClassCastException5	ClassCastException
    //   696	1	9	localClassCastException6	ClassCastException
    //   709	1	10	localClassCastException7	ClassCastException
    //   723	1	11	localClassCastException8	ClassCastException
    //   737	1	12	localClassCastException9	ClassCastException
    //   751	1	13	localClassCastException10	ClassCastException
    //   765	1	14	localClassCastException11	ClassCastException
    //   779	1	15	localClassCastException12	ClassCastException
    //   793	1	16	localClassCastException13	ClassCastException
    //   807	1	17	localClassCastException14	ClassCastException
    //   821	1	18	localClassCastException15	ClassCastException
    //   835	1	19	localClassCastException16	ClassCastException
    //   849	1	20	localClassCastException17	ClassCastException
    //   863	1	21	localClassCastException18	ClassCastException
    //   877	1	22	localClassCastException19	ClassCastException
    //   891	1	23	localClassCastException20	ClassCastException
    //   905	1	24	localClassCastException21	ClassCastException
    //   919	1	25	localClassCastException22	ClassCastException
    //   933	1	26	localClassCastException23	ClassCastException
    //   947	1	27	localClassCastException24	ClassCastException
    //   961	1	28	localClassCastException25	ClassCastException
    //   975	1	29	localClassCastException26	ClassCastException
    //   989	1	30	localClassCastException27	ClassCastException
    //   1003	1	31	localClassCastException28	ClassCastException
    //   1017	1	32	localClassCastException29	ClassCastException
    //   1031	1	33	localClassCastException30	ClassCastException
    //   1045	1	34	localClassCastException31	ClassCastException
    //   1059	1	35	localClassCastException32	ClassCastException
    //   1073	1	36	localClassCastException33	ClassCastException
    //   1087	1	37	localClassCastException34	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   166	169	629	java/lang/ClassCastException
    //   173	179	643	java/lang/ClassCastException
    //   192	195	657	java/lang/ClassCastException
    //   199	205	670	java/lang/ClassCastException
    //   218	221	683	java/lang/ClassCastException
    //   225	231	696	java/lang/ClassCastException
    //   244	247	709	java/lang/ClassCastException
    //   253	256	723	java/lang/ClassCastException
    //   266	269	737	java/lang/ClassCastException
    //   275	278	751	java/lang/ClassCastException
    //   289	292	765	java/lang/ClassCastException
    //   298	301	779	java/lang/ClassCastException
    //   312	315	793	java/lang/ClassCastException
    //   321	324	807	java/lang/ClassCastException
    //   352	355	821	java/lang/ClassCastException
    //   383	386	835	java/lang/ClassCastException
    //   396	399	849	java/lang/ClassCastException
    //   405	408	863	java/lang/ClassCastException
    //   416	422	877	java/lang/ClassCastException
    //   426	432	891	java/lang/ClassCastException
    //   442	445	905	java/lang/ClassCastException
    //   451	454	919	java/lang/ClassCastException
    //   467	470	933	java/lang/ClassCastException
    //   474	477	947	java/lang/ClassCastException
    //   499	502	961	java/lang/ClassCastException
    //   508	511	975	java/lang/ClassCastException
    //   533	536	989	java/lang/ClassCastException
    //   542	545	1003	java/lang/ClassCastException
    //   556	559	1017	java/lang/ClassCastException
    //   566	569	1031	java/lang/ClassCastException
    //   580	583	1045	java/lang/ClassCastException
    //   590	593	1059	java/lang/ClassCastException
    //   604	607	1073	java/lang/ClassCastException
    //   614	617	1087	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1612	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+172->176, 10:+44->48, 23:+68->72, 25:+100->104, 26:+132->136
    //   48: aload_2
    //   49: ldc 18
    //   51: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   57: aload_3
    //   58: aload 4
    //   60: ldc 30
    //   62: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   65: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   68: invokestatic 273	gnu/kawa/slib/srfi14:charSetFold	(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/srfi14$CharSet;)Ljava/lang/Object;
    //   71: areturn
    //   72: aload_2
    //   73: ldc 18
    //   75: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   81: aload_3
    //   82: ldc 30
    //   84: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   87: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   90: aload 4
    //   92: ldc 30
    //   94: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   97: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   100: invokestatic 212	gnu/kawa/slib/srfi14:charSetFilter	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   103: areturn
    //   104: aload_2
    //   105: ldc 18
    //   107: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   110: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   113: aload_3
    //   114: ldc 30
    //   116: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   122: aload 4
    //   124: ldc 30
    //   126: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   129: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   132: invokestatic 1777	gnu/kawa/slib/srfi14:charSetFilter$Ex	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   135: areturn
    //   136: aload_2
    //   137: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast 68	java/lang/Number
    //   143: invokevirtual 71	java/lang/Number:intValue	()I
    //   146: aload_3
    //   147: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: checkcast 68	java/lang/Number
    //   153: invokevirtual 71	java/lang/Number:intValue	()I
    //   156: aload 4
    //   158: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: invokestatic 28	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   164: ifeq +7 -> 171
    //   167: iconst_1
    //   168: goto +4 -> 172
    //   171: iconst_0
    //   172: invokestatic 216	gnu/kawa/slib/srfi14:ucsRange$To$CharSet	(IIZ)Lgnu/kawa/slib/srfi14$CharSet;
    //   175: areturn
    //   176: aload_0
    //   177: aload_1
    //   178: aload_2
    //   179: aload_3
    //   180: aload 4
    //   182: invokespecial 1781	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: areturn
    //   186: new 75	gnu/mapping/WrongType
    //   189: dup_x1
    //   190: swap
    //   191: ldc_w 1772
    //   194: iconst_1
    //   195: aload_2
    //   196: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   199: athrow
    //   200: new 75	gnu/mapping/WrongType
    //   203: dup_x1
    //   204: swap
    //   205: ldc_w 1772
    //   208: iconst_3
    //   209: aload 4
    //   211: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   214: athrow
    //   215: new 75	gnu/mapping/WrongType
    //   218: dup_x1
    //   219: swap
    //   220: ldc_w 1737
    //   223: iconst_1
    //   224: aload_2
    //   225: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   228: athrow
    //   229: new 75	gnu/mapping/WrongType
    //   232: dup_x1
    //   233: swap
    //   234: ldc_w 1737
    //   237: iconst_2
    //   238: aload_3
    //   239: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   242: athrow
    //   243: new 75	gnu/mapping/WrongType
    //   246: dup_x1
    //   247: swap
    //   248: ldc_w 1737
    //   251: iconst_3
    //   252: aload 4
    //   254: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   257: athrow
    //   258: new 75	gnu/mapping/WrongType
    //   261: dup_x1
    //   262: swap
    //   263: ldc_w 1774
    //   266: iconst_1
    //   267: aload_2
    //   268: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   271: athrow
    //   272: new 75	gnu/mapping/WrongType
    //   275: dup_x1
    //   276: swap
    //   277: ldc_w 1774
    //   280: iconst_2
    //   281: aload_3
    //   282: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   285: athrow
    //   286: new 75	gnu/mapping/WrongType
    //   289: dup_x1
    //   290: swap
    //   291: ldc_w 1774
    //   294: iconst_3
    //   295: aload 4
    //   297: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   300: athrow
    //   301: new 75	gnu/mapping/WrongType
    //   304: dup_x1
    //   305: swap
    //   306: ldc_w 1741
    //   309: iconst_1
    //   310: aload_2
    //   311: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   314: athrow
    //   315: new 75	gnu/mapping/WrongType
    //   318: dup_x1
    //   319: swap
    //   320: ldc_w 1741
    //   323: iconst_2
    //   324: aload_3
    //   325: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   328: athrow
    //   329: new 75	gnu/mapping/WrongType
    //   332: dup_x1
    //   333: swap
    //   334: ldc_w 1741
    //   337: iconst_3
    //   338: aload 4
    //   340: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   343: athrow
    // Line number table:
    //   Java source line #225	-> byte code offset #48
    //   Java source line #648	-> byte code offset #72
    //   Java source line #664	-> byte code offset #104
    //   Java source line #680	-> byte code offset #136
    //   Java source line #225	-> byte code offset #186
    //   Java source line #648	-> byte code offset #215
    //   Java source line #650	-> byte code offset #243
    //   Java source line #664	-> byte code offset #258
    //   Java source line #665	-> byte code offset #286
    //   Java source line #680	-> byte code offset #301
    //   Java source line #682	-> byte code offset #329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	srfi14
    //   0	344	1	paramModuleMethod	ModuleMethod
    //   0	344	2	paramObject1	Object
    //   0	344	3	paramObject2	Object
    //   0	344	4	paramObject3	Object
    //   186	1	5	localClassCastException1	ClassCastException
    //   200	1	6	localClassCastException2	ClassCastException
    //   215	1	7	localClassCastException3	ClassCastException
    //   229	1	8	localClassCastException4	ClassCastException
    //   243	1	9	localClassCastException5	ClassCastException
    //   258	1	10	localClassCastException6	ClassCastException
    //   272	1	11	localClassCastException7	ClassCastException
    //   286	1	12	localClassCastException8	ClassCastException
    //   301	1	13	localClassCastException9	ClassCastException
    //   315	1	14	localClassCastException10	ClassCastException
    //   329	1	15	localClassCastException11	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   54	57	186	java/lang/ClassCastException
    //   65	68	200	java/lang/ClassCastException
    //   78	81	215	java/lang/ClassCastException
    //   87	90	229	java/lang/ClassCastException
    //   97	100	243	java/lang/ClassCastException
    //   110	113	258	java/lang/ClassCastException
    //   119	122	272	java/lang/ClassCastException
    //   129	132	286	java/lang/ClassCastException
    //   140	146	301	java/lang/ClassCastException
    //   150	156	315	java/lang/ClassCastException
    //   161	172	329	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1612	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+170->174, 11:+36->40, 26:+70->74, 29:+120->124
    //   40: aload_2
    //   41: ldc 18
    //   43: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   46: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   49: aload_3
    //   50: ldc 18
    //   52: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   55: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   58: aload 4
    //   60: ldc 18
    //   62: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   65: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   68: aload 5
    //   70: invokestatic 1786	gnu/kawa/slib/srfi14:charSetUnfold	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Lgnu/kawa/slib/srfi14$CharSet;
    //   73: areturn
    //   74: aload_2
    //   75: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: checkcast 68	java/lang/Number
    //   81: invokevirtual 71	java/lang/Number:intValue	()I
    //   84: aload_3
    //   85: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 68	java/lang/Number
    //   91: invokevirtual 71	java/lang/Number:intValue	()I
    //   94: aload 4
    //   96: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: invokestatic 28	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   102: ifeq +7 -> 109
    //   105: iconst_1
    //   106: goto +4 -> 110
    //   109: iconst_0
    //   110: aload 5
    //   112: ldc 30
    //   114: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   120: invokestatic 219	gnu/kawa/slib/srfi14:ucsRange$To$CharSet	(IIZLgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   123: areturn
    //   124: aload_2
    //   125: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: checkcast 68	java/lang/Number
    //   131: invokevirtual 71	java/lang/Number:intValue	()I
    //   134: aload_3
    //   135: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 68	java/lang/Number
    //   141: invokevirtual 71	java/lang/Number:intValue	()I
    //   144: aload 4
    //   146: invokestatic 66	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   149: invokestatic 28	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   152: ifeq +7 -> 159
    //   155: iconst_1
    //   156: goto +4 -> 160
    //   159: iconst_0
    //   160: aload 5
    //   162: ldc 30
    //   164: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   167: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   170: invokestatic 1791	gnu/kawa/slib/srfi14:ucsRange$To$CharSet$Ex	(IIZLgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   173: areturn
    //   174: aload_0
    //   175: aload_1
    //   176: aload_2
    //   177: aload_3
    //   178: aload 4
    //   180: aload 5
    //   182: invokespecial 1795	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: areturn
    //   186: new 75	gnu/mapping/WrongType
    //   189: dup_x1
    //   190: swap
    //   191: ldc_w 1783
    //   194: iconst_1
    //   195: aload_2
    //   196: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   199: athrow
    //   200: new 75	gnu/mapping/WrongType
    //   203: dup_x1
    //   204: swap
    //   205: ldc_w 1783
    //   208: iconst_2
    //   209: aload_3
    //   210: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   213: athrow
    //   214: new 75	gnu/mapping/WrongType
    //   217: dup_x1
    //   218: swap
    //   219: ldc_w 1783
    //   222: iconst_3
    //   223: aload 4
    //   225: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   228: athrow
    //   229: new 75	gnu/mapping/WrongType
    //   232: dup_x1
    //   233: swap
    //   234: ldc_w 1741
    //   237: iconst_1
    //   238: aload_2
    //   239: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   242: athrow
    //   243: new 75	gnu/mapping/WrongType
    //   246: dup_x1
    //   247: swap
    //   248: ldc_w 1741
    //   251: iconst_2
    //   252: aload_3
    //   253: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   256: athrow
    //   257: new 75	gnu/mapping/WrongType
    //   260: dup_x1
    //   261: swap
    //   262: ldc_w 1741
    //   265: iconst_3
    //   266: aload 4
    //   268: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   271: athrow
    //   272: new 75	gnu/mapping/WrongType
    //   275: dup_x1
    //   276: swap
    //   277: ldc_w 1741
    //   280: iconst_4
    //   281: aload 5
    //   283: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   286: athrow
    //   287: new 75	gnu/mapping/WrongType
    //   290: dup_x1
    //   291: swap
    //   292: ldc_w 1788
    //   295: iconst_1
    //   296: aload_2
    //   297: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   300: athrow
    //   301: new 75	gnu/mapping/WrongType
    //   304: dup_x1
    //   305: swap
    //   306: ldc_w 1788
    //   309: iconst_2
    //   310: aload_3
    //   311: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   314: athrow
    //   315: new 75	gnu/mapping/WrongType
    //   318: dup_x1
    //   319: swap
    //   320: ldc_w 1788
    //   323: iconst_3
    //   324: aload 4
    //   326: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   329: athrow
    //   330: new 75	gnu/mapping/WrongType
    //   333: dup_x1
    //   334: swap
    //   335: ldc_w 1788
    //   338: iconst_4
    //   339: aload 5
    //   341: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   344: athrow
    // Line number table:
    //   Java source line #237	-> byte code offset #40
    //   Java source line #680	-> byte code offset #74
    //   Java source line #700	-> byte code offset #124
    //   Java source line #237	-> byte code offset #186
    //   Java source line #238	-> byte code offset #214
    //   Java source line #680	-> byte code offset #229
    //   Java source line #682	-> byte code offset #257
    //   Java source line #683	-> byte code offset #272
    //   Java source line #700	-> byte code offset #287
    //   Java source line #701	-> byte code offset #315
    //   Java source line #702	-> byte code offset #330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	srfi14
    //   0	345	1	paramModuleMethod	ModuleMethod
    //   0	345	2	paramObject1	Object
    //   0	345	3	paramObject2	Object
    //   0	345	4	paramObject3	Object
    //   0	345	5	paramObject4	Object
    //   186	1	6	localClassCastException1	ClassCastException
    //   200	1	7	localClassCastException2	ClassCastException
    //   214	1	8	localClassCastException3	ClassCastException
    //   229	1	9	localClassCastException4	ClassCastException
    //   243	1	10	localClassCastException5	ClassCastException
    //   257	1	11	localClassCastException6	ClassCastException
    //   272	1	12	localClassCastException7	ClassCastException
    //   287	1	13	localClassCastException8	ClassCastException
    //   301	1	14	localClassCastException9	ClassCastException
    //   315	1	15	localClassCastException10	ClassCastException
    //   330	1	16	localClassCastException11	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   46	49	186	java/lang/ClassCastException
    //   55	58	200	java/lang/ClassCastException
    //   65	68	214	java/lang/ClassCastException
    //   78	84	229	java/lang/ClassCastException
    //   88	94	243	java/lang/ClassCastException
    //   99	110	257	java/lang/ClassCastException
    //   117	120	272	java/lang/ClassCastException
    //   128	134	287	java/lang/ClassCastException
    //   138	144	301	java/lang/ClassCastException
    //   149	160	315	java/lang/ClassCastException
    //   167	170	330	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1612	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+1012->1016, 2:+148->152, 3:+193->197, 11:+238->242, 13:+319->323, 38:+382->386, 39:+437->441, 40:+492->496, 41:+547->551, 43:+602->606, 44:+640->644, 45:+678->682, 46:+734->738, 47:+772->776, 49:+842->846, 50:+880->884, 51:+918->922, 52:+974->978
    //   152: aload_2
    //   153: arraylength
    //   154: istore_3
    //   155: iload_3
    //   156: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   159: goto +15 -> 174
    //   162: dup
    //   163: iload_3
    //   164: aload_2
    //   165: iload_3
    //   166: aaload
    //   167: dup
    //   168: astore 4
    //   170: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   173: aastore
    //   174: iinc 3 -1
    //   177: iload_3
    //   178: ifge -16 -> 162
    //   181: invokestatic 1801	gnu/kawa/slib/srfi14:charSet$Eq	([Lgnu/kawa/slib/srfi14$CharSet;)Z
    //   184: ifeq +9 -> 193
    //   187: getstatic 1680	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   190: goto +6 -> 196
    //   193: getstatic 294	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   196: areturn
    //   197: aload_2
    //   198: arraylength
    //   199: istore_3
    //   200: iload_3
    //   201: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   204: goto +15 -> 219
    //   207: dup
    //   208: iload_3
    //   209: aload_2
    //   210: iload_3
    //   211: aaload
    //   212: dup
    //   213: astore 4
    //   215: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   218: aastore
    //   219: iinc 3 -1
    //   222: iload_3
    //   223: ifge -16 -> 207
    //   226: invokestatic 1806	gnu/kawa/slib/srfi14:charSet$Ls$Eq	([Lgnu/kawa/slib/srfi14$CharSet;)Z
    //   229: ifeq +9 -> 238
    //   232: getstatic 1680	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   235: goto +6 -> 241
    //   238: getstatic 294	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   241: areturn
    //   242: aload_2
    //   243: arraylength
    //   244: iconst_4
    //   245: isub
    //   246: istore_3
    //   247: aload_2
    //   248: iconst_0
    //   249: aaload
    //   250: ldc 18
    //   252: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   255: dup
    //   256: astore 4
    //   258: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   261: aload_2
    //   262: iconst_1
    //   263: aaload
    //   264: ldc 18
    //   266: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   269: dup
    //   270: astore 4
    //   272: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   275: aload_2
    //   276: iconst_2
    //   277: aaload
    //   278: ldc 18
    //   280: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   283: dup
    //   284: astore 4
    //   286: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   289: aload_2
    //   290: iconst_3
    //   291: aaload
    //   292: iload_3
    //   293: ifgt +9 -> 302
    //   296: invokestatic 1786	gnu/kawa/slib/srfi14:charSetUnfold	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Lgnu/kawa/slib/srfi14$CharSet;
    //   299: goto +23 -> 322
    //   302: iinc 3 -1
    //   305: aload_2
    //   306: iconst_4
    //   307: aaload
    //   308: ldc 30
    //   310: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   313: dup
    //   314: astore 4
    //   316: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   319: invokestatic 123	gnu/kawa/slib/srfi14:charSetUnfold	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   322: areturn
    //   323: aload_2
    //   324: iconst_0
    //   325: aaload
    //   326: ldc 18
    //   328: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   331: dup
    //   332: astore 4
    //   334: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   337: aload_2
    //   338: iconst_1
    //   339: aaload
    //   340: ldc 18
    //   342: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   345: dup
    //   346: astore 4
    //   348: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   351: aload_2
    //   352: iconst_2
    //   353: aaload
    //   354: ldc 18
    //   356: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   359: dup
    //   360: astore 4
    //   362: invokestatic 1714	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   365: aload_2
    //   366: iconst_3
    //   367: aaload
    //   368: aload_2
    //   369: iconst_4
    //   370: aaload
    //   371: ldc 30
    //   373: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   376: dup
    //   377: astore 4
    //   379: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   382: invokestatic 130	gnu/kawa/slib/srfi14:charSetUnfold$Ex	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   385: areturn
    //   386: aload_2
    //   387: iconst_0
    //   388: aaload
    //   389: ldc 30
    //   391: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   394: dup
    //   395: astore 4
    //   397: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   400: aload_2
    //   401: arraylength
    //   402: iconst_1
    //   403: isub
    //   404: istore 4
    //   406: iload 4
    //   408: newarray int
    //   410: goto +19 -> 429
    //   413: dup
    //   414: iload 4
    //   416: aload_2
    //   417: iload 4
    //   419: iconst_1
    //   420: iadd
    //   421: aaload
    //   422: dup
    //   423: astore 5
    //   425: invokestatic 139	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   428: iastore
    //   429: iinc 4 -1
    //   432: iload 4
    //   434: ifge -21 -> 413
    //   437: invokestatic 1813	gnu/kawa/slib/srfi14:charSetAdjoin	(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
    //   440: areturn
    //   441: aload_2
    //   442: iconst_0
    //   443: aaload
    //   444: ldc 30
    //   446: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   449: dup
    //   450: astore 4
    //   452: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   455: aload_2
    //   456: arraylength
    //   457: iconst_1
    //   458: isub
    //   459: istore 4
    //   461: iload 4
    //   463: newarray int
    //   465: goto +19 -> 484
    //   468: dup
    //   469: iload 4
    //   471: aload_2
    //   472: iload 4
    //   474: iconst_1
    //   475: iadd
    //   476: aaload
    //   477: dup
    //   478: astore 5
    //   480: invokestatic 139	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   483: iastore
    //   484: iinc 4 -1
    //   487: iload 4
    //   489: ifge -21 -> 468
    //   492: invokestatic 1818	gnu/kawa/slib/srfi14:charSetDelete	(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
    //   495: areturn
    //   496: aload_2
    //   497: iconst_0
    //   498: aaload
    //   499: ldc 30
    //   501: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   504: dup
    //   505: astore 4
    //   507: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   510: aload_2
    //   511: arraylength
    //   512: iconst_1
    //   513: isub
    //   514: istore 4
    //   516: iload 4
    //   518: newarray int
    //   520: goto +19 -> 539
    //   523: dup
    //   524: iload 4
    //   526: aload_2
    //   527: iload 4
    //   529: iconst_1
    //   530: iadd
    //   531: aaload
    //   532: dup
    //   533: astore 5
    //   535: invokestatic 139	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   538: iastore
    //   539: iinc 4 -1
    //   542: iload 4
    //   544: ifge -21 -> 523
    //   547: invokestatic 143	gnu/kawa/slib/srfi14:charSetAdjoin$Ex	(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
    //   550: areturn
    //   551: aload_2
    //   552: iconst_0
    //   553: aaload
    //   554: ldc 30
    //   556: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   559: dup
    //   560: astore 4
    //   562: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   565: aload_2
    //   566: arraylength
    //   567: iconst_1
    //   568: isub
    //   569: istore 4
    //   571: iload 4
    //   573: newarray int
    //   575: goto +19 -> 594
    //   578: dup
    //   579: iload 4
    //   581: aload_2
    //   582: iload 4
    //   584: iconst_1
    //   585: iadd
    //   586: aaload
    //   587: dup
    //   588: astore 5
    //   590: invokestatic 139	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   593: iastore
    //   594: iinc 4 -1
    //   597: iload 4
    //   599: ifge -21 -> 578
    //   602: invokestatic 297	gnu/kawa/slib/srfi14:charSetDelete$Ex	(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
    //   605: areturn
    //   606: aload_2
    //   607: arraylength
    //   608: istore 4
    //   610: iload 4
    //   612: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   615: goto +17 -> 632
    //   618: dup
    //   619: iload 4
    //   621: aload_2
    //   622: iload 4
    //   624: aaload
    //   625: dup
    //   626: astore 5
    //   628: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   631: aastore
    //   632: iinc 4 -1
    //   635: iload 4
    //   637: ifge -19 -> 618
    //   640: invokestatic 325	gnu/kawa/slib/srfi14:charSetUnion	([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   643: areturn
    //   644: aload_2
    //   645: arraylength
    //   646: istore 4
    //   648: iload 4
    //   650: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   653: goto +17 -> 670
    //   656: dup
    //   657: iload 4
    //   659: aload_2
    //   660: iload 4
    //   662: aaload
    //   663: dup
    //   664: astore 5
    //   666: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   669: aastore
    //   670: iinc 4 -1
    //   673: iload 4
    //   675: ifge -19 -> 656
    //   678: invokestatic 331	gnu/kawa/slib/srfi14:charSetIntersection	([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   681: areturn
    //   682: aload_2
    //   683: iconst_0
    //   684: aaload
    //   685: ldc 30
    //   687: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   690: dup
    //   691: astore 4
    //   693: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   696: aload_2
    //   697: arraylength
    //   698: iconst_1
    //   699: isub
    //   700: istore 4
    //   702: iload 4
    //   704: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   707: goto +19 -> 726
    //   710: dup
    //   711: iload 4
    //   713: aload_2
    //   714: iload 4
    //   716: iconst_1
    //   717: iadd
    //   718: aaload
    //   719: dup
    //   720: astore 5
    //   722: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   725: aastore
    //   726: iinc 4 -1
    //   729: iload 4
    //   731: ifge -21 -> 710
    //   734: invokestatic 1830	gnu/kawa/slib/srfi14:charSetDifference	(Lgnu/kawa/slib/srfi14$CharSet;[Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   737: areturn
    //   738: aload_2
    //   739: arraylength
    //   740: istore 4
    //   742: iload 4
    //   744: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   747: goto +17 -> 764
    //   750: dup
    //   751: iload 4
    //   753: aload_2
    //   754: iload 4
    //   756: aaload
    //   757: dup
    //   758: astore 5
    //   760: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   763: aastore
    //   764: iinc 4 -1
    //   767: iload 4
    //   769: ifge -19 -> 750
    //   772: invokestatic 1835	gnu/kawa/slib/srfi14:charSetXor	([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   775: areturn
    //   776: aload_2
    //   777: iconst_0
    //   778: aaload
    //   779: ldc 30
    //   781: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   784: dup
    //   785: astore 4
    //   787: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   790: aload_2
    //   791: iconst_1
    //   792: aaload
    //   793: ldc 30
    //   795: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   798: dup
    //   799: astore 4
    //   801: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   804: aload_2
    //   805: arraylength
    //   806: iconst_2
    //   807: isub
    //   808: istore 4
    //   810: iload 4
    //   812: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   815: goto +19 -> 834
    //   818: dup
    //   819: iload 4
    //   821: aload_2
    //   822: iload 4
    //   824: iconst_2
    //   825: iadd
    //   826: aaload
    //   827: dup
    //   828: astore 5
    //   830: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   833: aastore
    //   834: iinc 4 -1
    //   837: iload 4
    //   839: ifge -21 -> 818
    //   842: invokestatic 1841	gnu/kawa/slib/srfi14:charSetDiff$PlIntersection	(Lgnu/kawa/slib/srfi14$CharSet;Lgnu/kawa/slib/srfi14$CharSet;[Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/mapping/Values;
    //   845: areturn
    //   846: aload_2
    //   847: arraylength
    //   848: istore 4
    //   850: iload 4
    //   852: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   855: goto +17 -> 872
    //   858: dup
    //   859: iload 4
    //   861: aload_2
    //   862: iload 4
    //   864: aaload
    //   865: dup
    //   866: astore 5
    //   868: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   871: aastore
    //   872: iinc 4 -1
    //   875: iload 4
    //   877: ifge -19 -> 858
    //   880: invokestatic 186	gnu/kawa/slib/srfi14:charSetUnion$Ex	([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   883: areturn
    //   884: aload_2
    //   885: arraylength
    //   886: istore 4
    //   888: iload 4
    //   890: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   893: goto +17 -> 910
    //   896: dup
    //   897: iload 4
    //   899: aload_2
    //   900: iload 4
    //   902: aaload
    //   903: dup
    //   904: astore 5
    //   906: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   909: aastore
    //   910: iinc 4 -1
    //   913: iload 4
    //   915: ifge -19 -> 896
    //   918: invokestatic 347	gnu/kawa/slib/srfi14:charSetIntersection$Ex	([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   921: areturn
    //   922: aload_2
    //   923: iconst_0
    //   924: aaload
    //   925: ldc 30
    //   927: invokestatic 150	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   930: dup
    //   931: astore 4
    //   933: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   936: aload_2
    //   937: arraylength
    //   938: iconst_1
    //   939: isub
    //   940: istore 4
    //   942: iload 4
    //   944: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   947: goto +19 -> 966
    //   950: dup
    //   951: iload 4
    //   953: aload_2
    //   954: iload 4
    //   956: iconst_1
    //   957: iadd
    //   958: aaload
    //   959: dup
    //   960: astore 5
    //   962: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   965: aastore
    //   966: iinc 4 -1
    //   969: iload 4
    //   971: ifge -21 -> 950
    //   974: invokestatic 1850	gnu/kawa/slib/srfi14:charSetDifference$Ex	(Lgnu/kawa/slib/srfi14$CharSet;[Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   977: areturn
    //   978: aload_2
    //   979: arraylength
    //   980: istore 4
    //   982: iload 4
    //   984: anewarray 30	gnu/kawa/slib/srfi14$CharSet
    //   987: goto +17 -> 1004
    //   990: dup
    //   991: iload 4
    //   993: aload_2
    //   994: iload 4
    //   996: aaload
    //   997: dup
    //   998: astore 5
    //   1000: checkcast 30	gnu/kawa/slib/srfi14$CharSet
    //   1003: aastore
    //   1004: iinc 4 -1
    //   1007: iload 4
    //   1009: ifge -19 -> 990
    //   1012: invokestatic 1855	gnu/kawa/slib/srfi14:charSetXor$Ex	([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
    //   1015: areturn
    //   1016: aload_0
    //   1017: aload_1
    //   1018: aload_2
    //   1019: invokespecial 1858	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1022: areturn
    //   1023: new 75	gnu/mapping/WrongType
    //   1026: dup_x1
    //   1027: swap
    //   1028: ldc_w 1797
    //   1031: iconst_0
    //   1032: aload 4
    //   1034: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1037: athrow
    //   1038: new 75	gnu/mapping/WrongType
    //   1041: dup_x1
    //   1042: swap
    //   1043: ldc_w 1803
    //   1046: iconst_0
    //   1047: aload 4
    //   1049: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1052: athrow
    //   1053: new 75	gnu/mapping/WrongType
    //   1056: dup_x1
    //   1057: swap
    //   1058: ldc_w 1783
    //   1061: iconst_1
    //   1062: aload 4
    //   1064: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1067: athrow
    //   1068: new 75	gnu/mapping/WrongType
    //   1071: dup_x1
    //   1072: swap
    //   1073: ldc_w 1783
    //   1076: iconst_2
    //   1077: aload 4
    //   1079: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1082: athrow
    //   1083: new 75	gnu/mapping/WrongType
    //   1086: dup_x1
    //   1087: swap
    //   1088: ldc_w 1783
    //   1091: iconst_3
    //   1092: aload 4
    //   1094: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1097: athrow
    //   1098: new 75	gnu/mapping/WrongType
    //   1101: dup_x1
    //   1102: swap
    //   1103: ldc_w 1783
    //   1106: iconst_5
    //   1107: aload 4
    //   1109: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1112: athrow
    //   1113: new 75	gnu/mapping/WrongType
    //   1116: dup_x1
    //   1117: swap
    //   1118: ldc_w 1808
    //   1121: iconst_1
    //   1122: aload 4
    //   1124: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1127: athrow
    //   1128: new 75	gnu/mapping/WrongType
    //   1131: dup_x1
    //   1132: swap
    //   1133: ldc_w 1808
    //   1136: iconst_2
    //   1137: aload 4
    //   1139: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1142: athrow
    //   1143: new 75	gnu/mapping/WrongType
    //   1146: dup_x1
    //   1147: swap
    //   1148: ldc_w 1808
    //   1151: iconst_3
    //   1152: aload 4
    //   1154: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1157: athrow
    //   1158: new 75	gnu/mapping/WrongType
    //   1161: dup_x1
    //   1162: swap
    //   1163: ldc_w 1808
    //   1166: iconst_5
    //   1167: aload 4
    //   1169: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1172: athrow
    //   1173: new 75	gnu/mapping/WrongType
    //   1176: dup_x1
    //   1177: swap
    //   1178: ldc_w 1810
    //   1181: iconst_1
    //   1182: aload 4
    //   1184: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1187: athrow
    //   1188: new 75	gnu/mapping/WrongType
    //   1191: dup_x1
    //   1192: swap
    //   1193: ldc_w 1810
    //   1196: iconst_0
    //   1197: aload 5
    //   1199: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1202: athrow
    //   1203: new 75	gnu/mapping/WrongType
    //   1206: dup_x1
    //   1207: swap
    //   1208: ldc_w 1815
    //   1211: iconst_1
    //   1212: aload 4
    //   1214: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1217: athrow
    //   1218: new 75	gnu/mapping/WrongType
    //   1221: dup_x1
    //   1222: swap
    //   1223: ldc_w 1815
    //   1226: iconst_0
    //   1227: aload 5
    //   1229: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1232: athrow
    //   1233: new 75	gnu/mapping/WrongType
    //   1236: dup_x1
    //   1237: swap
    //   1238: ldc -104
    //   1240: iconst_1
    //   1241: aload 4
    //   1243: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1246: athrow
    //   1247: new 75	gnu/mapping/WrongType
    //   1250: dup_x1
    //   1251: swap
    //   1252: ldc -104
    //   1254: iconst_0
    //   1255: aload 5
    //   1257: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1260: athrow
    //   1261: new 75	gnu/mapping/WrongType
    //   1264: dup_x1
    //   1265: swap
    //   1266: ldc_w 1820
    //   1269: iconst_1
    //   1270: aload 4
    //   1272: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1275: athrow
    //   1276: new 75	gnu/mapping/WrongType
    //   1279: dup_x1
    //   1280: swap
    //   1281: ldc_w 1820
    //   1284: iconst_0
    //   1285: aload 5
    //   1287: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1290: athrow
    //   1291: new 75	gnu/mapping/WrongType
    //   1294: dup_x1
    //   1295: swap
    //   1296: ldc_w 1822
    //   1299: iconst_0
    //   1300: aload 5
    //   1302: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1305: athrow
    //   1306: new 75	gnu/mapping/WrongType
    //   1309: dup_x1
    //   1310: swap
    //   1311: ldc_w 1824
    //   1314: iconst_0
    //   1315: aload 5
    //   1317: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1320: athrow
    //   1321: new 75	gnu/mapping/WrongType
    //   1324: dup_x1
    //   1325: swap
    //   1326: ldc_w 1826
    //   1329: iconst_1
    //   1330: aload 4
    //   1332: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1335: athrow
    //   1336: new 75	gnu/mapping/WrongType
    //   1339: dup_x1
    //   1340: swap
    //   1341: ldc_w 1826
    //   1344: iconst_0
    //   1345: aload 5
    //   1347: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1350: athrow
    //   1351: new 75	gnu/mapping/WrongType
    //   1354: dup_x1
    //   1355: swap
    //   1356: ldc_w 1832
    //   1359: iconst_0
    //   1360: aload 5
    //   1362: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1365: athrow
    //   1366: new 75	gnu/mapping/WrongType
    //   1369: dup_x1
    //   1370: swap
    //   1371: ldc_w 1837
    //   1374: iconst_1
    //   1375: aload 4
    //   1377: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1380: athrow
    //   1381: new 75	gnu/mapping/WrongType
    //   1384: dup_x1
    //   1385: swap
    //   1386: ldc_w 1837
    //   1389: iconst_2
    //   1390: aload 4
    //   1392: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1395: athrow
    //   1396: new 75	gnu/mapping/WrongType
    //   1399: dup_x1
    //   1400: swap
    //   1401: ldc_w 1837
    //   1404: iconst_0
    //   1405: aload 5
    //   1407: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1410: athrow
    //   1411: new 75	gnu/mapping/WrongType
    //   1414: dup_x1
    //   1415: swap
    //   1416: ldc_w 1843
    //   1419: iconst_0
    //   1420: aload 5
    //   1422: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1425: athrow
    //   1426: new 75	gnu/mapping/WrongType
    //   1429: dup_x1
    //   1430: swap
    //   1431: ldc_w 1845
    //   1434: iconst_0
    //   1435: aload 5
    //   1437: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1440: athrow
    //   1441: new 75	gnu/mapping/WrongType
    //   1444: dup_x1
    //   1445: swap
    //   1446: ldc_w 1847
    //   1449: iconst_1
    //   1450: aload 4
    //   1452: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1455: athrow
    //   1456: new 75	gnu/mapping/WrongType
    //   1459: dup_x1
    //   1460: swap
    //   1461: ldc_w 1847
    //   1464: iconst_0
    //   1465: aload 5
    //   1467: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1470: athrow
    //   1471: new 75	gnu/mapping/WrongType
    //   1474: dup_x1
    //   1475: swap
    //   1476: ldc_w 1852
    //   1479: iconst_0
    //   1480: aload 5
    //   1482: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1485: athrow
    // Line number table:
    //   Java source line #152	-> byte code offset #152
    //   Java source line #164	-> byte code offset #197
    //   Java source line #237	-> byte code offset #242
    //   Java source line #252	-> byte code offset #323
    //   Java source line #782	-> byte code offset #386
    //   Java source line #787	-> byte code offset #441
    //   Java source line #792	-> byte code offset #496
    //   Java source line #803	-> byte code offset #551
    //   Java source line #820	-> byte code offset #606
    //   Java source line #833	-> byte code offset #644
    //   Java source line #846	-> byte code offset #682
    //   Java source line #858	-> byte code offset #738
    //   Java source line #871	-> byte code offset #776
    //   Java source line #884	-> byte code offset #846
    //   Java source line #895	-> byte code offset #884
    //   Java source line #907	-> byte code offset #922
    //   Java source line #916	-> byte code offset #978
    //   Java source line #152	-> byte code offset #1023
    //   Java source line #164	-> byte code offset #1038
    //   Java source line #237	-> byte code offset #1053
    //   Java source line #238	-> byte code offset #1083
    //   Java source line #240	-> byte code offset #1098
    //   Java source line #252	-> byte code offset #1113
    //   Java source line #253	-> byte code offset #1143
    //   Java source line #782	-> byte code offset #1173
    //   Java source line #787	-> byte code offset #1203
    //   Java source line #792	-> byte code offset #1233
    //   Java source line #803	-> byte code offset #1261
    //   Java source line #820	-> byte code offset #1291
    //   Java source line #833	-> byte code offset #1306
    //   Java source line #846	-> byte code offset #1321
    //   Java source line #858	-> byte code offset #1351
    //   Java source line #871	-> byte code offset #1366
    //   Java source line #884	-> byte code offset #1411
    //   Java source line #895	-> byte code offset #1426
    //   Java source line #907	-> byte code offset #1441
    //   Java source line #916	-> byte code offset #1471
    // Exception table:
    //   from	to	target	type
    //   170	173	1023	java/lang/ClassCastException
    //   215	218	1038	java/lang/ClassCastException
    //   258	261	1053	java/lang/ClassCastException
    //   272	275	1068	java/lang/ClassCastException
    //   286	289	1083	java/lang/ClassCastException
    //   316	319	1098	java/lang/ClassCastException
    //   334	337	1113	java/lang/ClassCastException
    //   348	351	1128	java/lang/ClassCastException
    //   362	365	1143	java/lang/ClassCastException
    //   379	382	1158	java/lang/ClassCastException
    //   397	400	1173	java/lang/ClassCastException
    //   425	428	1188	java/lang/ClassCastException
    //   452	455	1203	java/lang/ClassCastException
    //   480	483	1218	java/lang/ClassCastException
    //   507	510	1233	java/lang/ClassCastException
    //   535	538	1247	java/lang/ClassCastException
    //   562	565	1261	java/lang/ClassCastException
    //   590	593	1276	java/lang/ClassCastException
    //   628	631	1291	java/lang/ClassCastException
    //   666	669	1306	java/lang/ClassCastException
    //   693	696	1321	java/lang/ClassCastException
    //   722	725	1336	java/lang/ClassCastException
    //   760	763	1351	java/lang/ClassCastException
    //   787	790	1366	java/lang/ClassCastException
    //   801	804	1381	java/lang/ClassCastException
    //   830	833	1396	java/lang/ClassCastException
    //   868	871	1411	java/lang/ClassCastException
    //   906	909	1426	java/lang/ClassCastException
    //   933	936	1441	java/lang/ClassCastException
    //   962	965	1456	java/lang/ClassCastException
    //   1000	1003	1471	java/lang/ClassCastException
  }
}
