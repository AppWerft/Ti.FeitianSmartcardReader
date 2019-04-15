package gnu.kawa.slib;

import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.SourceMethodType;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class srfi13 extends ModuleBody
{
  public static final Macro $Cloptional;
  public static final Macro let$Mnoptionals$St;
  static final ModuleMethod char$Mncased$Qu;
  public static final Macro let$Mnstring$Mnstart$Plend;
  public static final Macro let$Mnstring$Mnstart$Plend2;
  public static final ModuleMethod string$Mnparse$Mnstart$Plend;
  public static final ModuleMethod $Pccheck$Mnbounds;
  public static final ModuleMethod string$Mnparse$Mnfinal$Mnstart$Plend;
  public static final ModuleMethod substring$Mnspec$Mnok$Qu;
  public static final ModuleMethod check$Mnsubstring$Mnspec;
  public static final ModuleMethod substring$Slshared;
  public static final ModuleMethod $Pcsubstring$Slshared;
  public static final StaticFieldLocation string$Mncopy;
  public static final ModuleMethod string$Mnmap;
  public static final ModuleMethod $Pcstring$Mnmap;
  public static final ModuleMethod string$Mnmap$Ex;
  public static final ModuleMethod $Pcstring$Mnmap$Ex;
  public static final ModuleMethod string$Mnfold;
  public static final ModuleMethod string$Mnfold$Mnright;
  public static final ModuleMethod string$Mnunfold;
  public static final ModuleMethod string$Mnunfold$Mnright;
  public static final StaticFieldLocation string$Mnfor$Mneach;
  public static final ModuleMethod string$Mnevery;
  public static final ModuleMethod string$Mnany;
  public static final ModuleMethod string$Mntabulate;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnlength;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnlength;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnlength$Mnci;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnlength$Mnci;
  public static final ModuleMethod string$Mnprefix$Mnlength;
  public static final ModuleMethod string$Mnsuffix$Mnlength;
  public static final ModuleMethod string$Mnprefix$Mnlength$Mnci;
  public static final ModuleMethod string$Mnsuffix$Mnlength$Mnci;
  public static final ModuleMethod string$Mnprefix$Qu;
  public static final ModuleMethod string$Mnsuffix$Qu;
  public static final ModuleMethod string$Mnprefix$Mnci$Qu;
  public static final ModuleMethod string$Mnsuffix$Mnci$Qu;
  public static final ModuleMethod $Pcstring$Mnprefix$Qu;
  public static final ModuleMethod $Pcstring$Mnsuffix$Qu;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnci$Qu;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnci$Qu;
  public static final ModuleMethod $Pcstring$Mncompare;
  public static final ModuleMethod $Pcstring$Mncompare$Mnci;
  public static final ModuleMethod string$Mncompare;
  public static final ModuleMethod string$Mncompare$Mnci;
  public static final ModuleMethod string$Eq;
  public static final ModuleMethod string$Ls$Gr;
  public static final ModuleMethod string$Ls;
  public static final ModuleMethod string$Gr;
  public static final ModuleMethod string$Ls$Eq;
  public static final ModuleMethod string$Gr$Eq;
  public static final ModuleMethod string$Mnci$Eq;
  public static final ModuleMethod string$Mnci$Ls$Gr;
  public static final ModuleMethod string$Mnci$Ls;
  public static final ModuleMethod string$Mnci$Gr;
  public static final ModuleMethod string$Mnci$Ls$Eq;
  public static final ModuleMethod string$Mnci$Gr$Eq;
  public static final ModuleMethod $Pcstring$Mnhash;
  public static final ModuleMethod string$Mnhash;
  public static final ModuleMethod string$Mnhash$Mnci;
  public static final ModuleMethod string$Mnupcase;
  public static final ModuleMethod string$Mnupcase$Ex;
  public static final ModuleMethod string$Mndowncase;
  public static final ModuleMethod string$Mndowncase$Ex;
  public static final ModuleMethod $Pcstring$Mntitlecase$Ex;
  public static final ModuleMethod string$Mntitlecase$Ex;
  public static final ModuleMethod string$Mntitlecase;
  public static final ModuleMethod string$Mntake;
  public static final ModuleMethod string$Mntake$Mnright;
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
  }
  
  static Object checkArg(Object pred, Object val, Object proc) {
    throw (KawaConvert.isTrue(Scheme.applyToArgs.apply2(pred, val)) ? val : Special.reachedUnexpected);return kawa.lib.exceptions.error(new Object[] { "Bad arg", val, pred, proc });
  }
  








  static Object lambda45(Object form)
  {
    Object localObject = form;Object[] arrayOfObject = SyntaxPattern.allocVars(6, null);
    
    TemplateScope localTemplateScope = TemplateScope.make(); if (Lit18.match(form, arrayOfObject, 0))
    {

      localTemplateScope = TemplateScope.make();
      localTemplateScope = TemplateScope.make(); } if (Lit21.match(form, arrayOfObject, 0))
    {
      localTemplateScope = TemplateScope.make();
      localTemplateScope = TemplateScope.make(); } if (Lit24.match(form, arrayOfObject, 0))
    {
      localTemplateScope = TemplateScope.make();
      localTemplateScope = TemplateScope.make();
    }
    



    localTemplateScope = TemplateScope.make();return Lit27.match(form, arrayOfObject, 0) ? Lit28.execute(arrayOfObject, localTemplateScope) : std_syntax.isIdentifier(Lit25.execute(arrayOfObject, localTemplateScope)) ? Lit26.execute(arrayOfObject, localTemplateScope) : std_syntax.isIdentifier(Lit22.execute(arrayOfObject, localTemplateScope)) ? Lit23.execute(arrayOfObject, localTemplateScope) : std_syntax.isIdentifier(Lit19.execute(arrayOfObject, localTemplateScope)) ? Lit20.execute(arrayOfObject, localTemplateScope) : Lit16.match(form, arrayOfObject, 0) ? Lit17.execute(arrayOfObject, localTemplateScope) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
  @SourceMethodType({"", "character"})
  static boolean isCharCased(int c) { return unicode.charUpcase(c) != unicode.charDowncase(c); }
  


















































  public static void $PcCheckBounds(Object proc, CharSequence s, int start, int end)
  {
    if (start < 0)
      throw Special.reachedUnexpected; if (start > end)
    {
      throw Special.reachedUnexpected; }
    if (end > strings.stringLength(s))
      throw Special.reachedUnexpected;
  }
  
  public static Values stringParseFinalStart$PlEnd(Object proc, Object s, Object args) { Object localObject1 = stringParseStart$PlEnd(proc, s, args);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    Object start; Object rest; if (lists.isPair(rest)) throw Special.reachedUnexpected;
    return Values.values2(start, end);
  }
  
  public static boolean isSubstringSpecOk(Object s, Object start, Object end) { if ((!strings.isString(s)) || (
      (!numbers.isInteger(start)) || (
      (!numbers.isExact(start)) || (
      (!numbers.isInteger(end)) || (
      (!numbers.isExact(end)) || (
      (!NumberCompare.$Ls$Eq(Lit0, start)) || 
      (NumberCompare.$Ls$Eq(start, end)))))))) {}
    try { tmpTernaryOp = NumberCompare.$Ls$Eq(end, Integer.valueOf(strings.stringLength((CharSequence)(localObject = Promise.force(s, CharSequence.class))))); break label102; tmpTernaryOp = false; break label102; tmpTernaryOp = false; break label102; tmpTernaryOp = false; break label102; tmpTernaryOp = false; break label102; tmpTernaryOp = false; break label102; tmpTernaryOp = false; label102: return false; } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "string-length", 1, localObject);
    } }
  
  public static void checkSubstringSpec(Object proc, Object s, Object start, Object end) { if (!isSubstringSpecOk(s, start, end)) {
      throw Special.reachedUnexpected;
    }
  }
  







  public static final ModuleMethod string$Mndrop;
  






  public static final ModuleMethod string$Mndrop$Mnright;
  






  public static final ModuleMethod string$Mntrim;
  






  public static final ModuleMethod string$Mntrim$Mnright;
  






  public static final ModuleMethod string$Mntrim$Mnboth;
  






  public static final ModuleMethod string$Mnpad$Mnright;
  






  public static final ModuleMethod string$Mnpad;
  






  public static final ModuleMethod string$Mndelete;
  






  public static final ModuleMethod string$Mnfilter;
  






  public static final ModuleMethod string$Mnindex;
  






  public static final ModuleMethod string$Mnindex$Mnright;
  






  public static final ModuleMethod string$Mnskip;
  






  public static final ModuleMethod string$Mnskip$Mnright;
  






  public static final ModuleMethod string$Mncount;
  






  public static final StaticFieldLocation string$Mnfill$Ex;
  






  public static final StaticFieldLocation string$Mncopy$Ex;
  






  public static final StaticFieldLocation $Pcstring$Mncopy$Ex;
  






  public static final ModuleMethod string$Mncontains;
  






  public static final ModuleMethod string$Mncontains$Mnci;
  






  public static final ModuleMethod $Pckmp$Mnsearch;
  






  public static final ModuleMethod make$Mnkmp$Mnrestart$Mnvector;
  






  public static final ModuleMethod kmp$Mnstep;
  






  public static final ModuleMethod string$Mnkmp$Mnpartial$Mnsearch;
  






  public static final ModuleMethod string$Mnnull$Qu;
  






  public static final ModuleMethod string$Mnreverse;
  






  public static final ModuleMethod string$Mnreverse$Ex;
  






  public static final ModuleMethod reverse$Mnlist$Mn$Grstring;
  






  public static final StaticFieldLocation string$Mn$Grlist;
  






  public static final ModuleMethod string$Mnappend$Slshared;
  






  public static final ModuleMethod string$Mnconcatenate$Slshared;
  






  public static final ModuleMethod string$Mnconcatenate;
  






  public static final ModuleMethod string$Mnconcatenate$Mnreverse;
  






  public static final ModuleMethod string$Mnconcatenate$Mnreverse$Slshared;
  






  public static final ModuleMethod $Pcfinish$Mnstring$Mnconcatenate$Mnreverse;
  






  public static final ModuleMethod string$Mnreplace;
  






  public static final ModuleMethod string$Mntokenize;
  






  public static final ModuleMethod xsubstring;
  






  public static final ModuleMethod string$Mnxcopy$Ex;
  






  public static final ModuleMethod $Pcmultispan$Mnrepcopy$Ex;
  






  public static final ModuleMethod string$Mnjoin;
  






  static final IntNum Lit0;
  






  static final ModuleMethod lambda$Fn1;
  






  static final IntNum Lit1;
  






  static final ModuleMethod lambda$Fn2;
  






  static final ModuleMethod lambda$Fn3;
  






  static final IntNum Lit2;
  






  static final ModuleMethod lambda$Fn4;
  






  static final ModuleMethod lambda$Fn5;
  






  static final IntNum Lit3;
  






  static final ModuleMethod lambda$Fn6;
  






  static final ModuleMethod lambda$Fn7;
  






  static final ModuleMethod lambda$Fn8;
  






  static final ModuleMethod lambda$Fn9;
  






  static final ModuleMethod lambda$Fn10;
  






  static final ModuleMethod lambda$Fn11;
  






  static final ModuleMethod lambda$Fn12;
  






  static final ModuleMethod lambda$Fn13;
  






  static final ModuleMethod lambda$Fn14;
  






  static final ModuleMethod lambda$Fn15;
  






  static final ModuleMethod lambda$Fn16;
  






  static final ModuleMethod lambda$Fn17;
  






  static final ModuleMethod lambda$Fn18;
  






  static final ModuleMethod lambda$Fn19;
  






  static final ModuleMethod lambda$Fn20;
  






  static final ModuleMethod lambda$Fn21;
  






  static final ModuleMethod lambda$Fn22;
  






  static final ModuleMethod lambda$Fn23;
  






  static final ModuleMethod lambda$Fn24;
  






  static final IntNum Lit4;
  






  static final IntNum Lit5;
  






  static final IntNum Lit6;
  






  static final ModuleMethod lambda$Fn25;
  






  static final Char Lit7;
  






  static final ModuleMethod lambda$Fn30;
  






  static final ModuleMethod lambda$Fn31;
  






  static final IntNum Lit8;
  






  static final ModuleMethod lambda$Fn39;
  






  static final ModuleMethod lambda$Fn41;
  






  static final ModuleMethod lambda$Fn42;
  






  static final SimpleSymbol Lit9;
  






  static final SimpleSymbol Lit10;
  






  static final SimpleSymbol Lit11;
  






  static final SimpleSymbol Lit12;
  






  public static srfi13 $instance;
  






  static final SimpleSymbol Lit13;
  






  static final SyntaxRules Lit14;
  






  static final SimpleSymbol Lit15;
  






  static final SyntaxPattern Lit16;
  






  static final SyntaxTemplate Lit17;
  






  static final SyntaxPattern Lit18;
  






  static final SyntaxTemplate Lit19;
  






  static final SyntaxTemplate Lit20;
  






  static final SyntaxPattern Lit21;
  






  static final SyntaxTemplate Lit22;
  






  static final SyntaxTemplate Lit23;
  






  static final SyntaxPattern Lit24;
  






  static final SyntaxTemplate Lit25;
  






  static final SyntaxTemplate Lit26;
  






  static final SyntaxPattern Lit27;
  






  static final SyntaxTemplate Lit28;
  






  static final SimpleSymbol Lit29;
  






  static final SimpleSymbol Lit30;
  






  static final SyntaxRules Lit31;
  






  static final SimpleSymbol Lit32;
  






  static final SyntaxRules Lit33;
  






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
  






  static final SimpleSymbol Lit62;
  






  static final SimpleSymbol Lit63;
  






  static final SimpleSymbol Lit64;
  






  static final SimpleSymbol Lit65;
  






  static final SimpleSymbol Lit66;
  






  static final SimpleSymbol Lit67;
  






  static final SimpleSymbol Lit68;
  






  static final SimpleSymbol Lit69;
  






  static final SimpleSymbol Lit70;
  






  static final SimpleSymbol Lit71;
  






  static final SimpleSymbol Lit72;
  






  static final SimpleSymbol Lit73;
  






  static final SimpleSymbol Lit74;
  






  static final SimpleSymbol Lit75;
  






  static final SimpleSymbol Lit76;
  






  static final SimpleSymbol Lit77;
  






  static final SimpleSymbol Lit78;
  






  static final SimpleSymbol Lit79;
  






  static final SimpleSymbol Lit80;
  






  static final SimpleSymbol Lit81;
  






  static final SimpleSymbol Lit82;
  






  static final SimpleSymbol Lit83;
  






  static final SimpleSymbol Lit84;
  






  static final SimpleSymbol Lit85;
  






  static final SimpleSymbol Lit86;
  






  static final SimpleSymbol Lit87;
  






  static final SimpleSymbol Lit88;
  






  static final SimpleSymbol Lit89;
  






  static final SimpleSymbol Lit90;
  






  static final SimpleSymbol Lit91;
  






  static final SimpleSymbol Lit92;
  






  static final SimpleSymbol Lit93;
  






  static final SimpleSymbol Lit94;
  






  static final SimpleSymbol Lit95;
  






  static final SimpleSymbol Lit96;
  






  static final SimpleSymbol Lit97;
  






  static final SimpleSymbol Lit98;
  






  static final SimpleSymbol Lit99;
  






  static final SimpleSymbol Lit100;
  






  static final SimpleSymbol Lit101;
  






  static final SimpleSymbol Lit102;
  






  static final SimpleSymbol Lit103;
  






  static final SimpleSymbol Lit104;
  






  static final SimpleSymbol Lit105;
  






  static final SimpleSymbol Lit106;
  






  static final SimpleSymbol Lit107;
  






  static final SimpleSymbol Lit108;
  






  static final SimpleSymbol Lit109;
  






  static final SimpleSymbol Lit110;
  






  static final SimpleSymbol Lit111;
  






  static final SimpleSymbol Lit112;
  






  static final SimpleSymbol Lit113;
  






  static final SimpleSymbol Lit114;
  






  static final SimpleSymbol Lit115;
  






  static final SimpleSymbol Lit116;
  






  static final SimpleSymbol Lit117;
  






  static final SimpleSymbol Lit118;
  






  static final SimpleSymbol Lit119;
  






  static final SimpleSymbol Lit120;
  






  static final SimpleSymbol Lit121;
  






  static final SimpleSymbol Lit122;
  





  static final SimpleSymbol Lit123;
  





  static final SimpleSymbol Lit124;
  





  static final SimpleSymbol Lit125;
  





  static final SimpleSymbol Lit126;
  





  static final SimpleSymbol Lit127;
  





  static final SimpleSymbol Lit128;
  





  static final SimpleSymbol Lit129;
  





  static final SimpleSymbol Lit130;
  





  static final SimpleSymbol Lit131;
  





  static final Object[] Lit132;
  





  static final SimpleSymbol Lit133;
  





  static final SimpleSymbol Lit134;
  





  static final SimpleSymbol Lit135;
  





  static final SimpleSymbol Lit136;
  





  static final SimpleSymbol Lit137;
  





  static final SimpleSymbol Lit138;
  





  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (selector) {case 142:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 141: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 140: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 137: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 135: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 134: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 132: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 131: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 128: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 126: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 125: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 123: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 122: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 121: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 120: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 119: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 118: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 117: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 116: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 115: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 114: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 113: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 112: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 111: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 110: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 108: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 106: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 105: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 104: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 99: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 98: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 96: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 95: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 94: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 93: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 92: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 90: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 89: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 88: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 86: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 84: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 81: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 78: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 76: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 73: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 71: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 69: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 66: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 63: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 61: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 58: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 57: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 56: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 55: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 54: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 53: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 52: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 51: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 50: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 49: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 48: 
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
    case 42: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 41: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 40: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 39: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 36: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 35: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 34: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 31: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 28: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 27: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 25: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 23: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 21: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  
  static boolean lambda1(Object start) { return numbers.isInteger(start) ? false : numbers.isExact(start) ? NumberCompare.$Ls$Eq(Lit0, start) : false; }
  









  public static Object $PcSubstring$SlShared(CharSequence s, int start, int end)
  {
    return (numbers.isZero(Integer.valueOf(start))) && (end == strings.stringLength(s)) ? s : strings.substring(s, start, end);
  }
  
































  public static FString stringMap$V(Object proc, Object s, Object[] argsArray)
  {
    LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    checkArg(misc.procedure$Qu, proc, string$Mnmap);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mnmap, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    Object start; return $PcStringMap(proc, s, start, end);
  }
  






  public static Object stringMap$Ex$V(Object proc, Object s, Object[] argsArray)
  {
    LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    checkArg(misc.procedure$Qu, proc, string$Mnmap$Ex);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mnmap$Ex, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    Object start; return $PcStringMap$Ex(proc, s, start, end);
  }
  


  public static Object stringFold$V(Object kons, Object knil, Object s, Object[] argsArray)
  {
    LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    checkArg(misc.procedure$Qu, kons, string$Mnfold);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mnfold, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    for (;;) { Object start; Object localObject3 = start;Object v = knil;
      Object i; Object localObject4; if (NumberCompare.$Ls(i, end)) localObject4 = Promise.force(s, CharSequence.class); try { localObject4 = Promise.force(i); } catch (ClassCastException localClassCastException1) { throw new WrongType(localClassCastException1, "string-ref", 1, localObject4); } try { tmpTernaryOp = AddOp.apply2(1, i, Lit1); } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "string-ref", 2, localObject4); } } return v;
  }
  
  public static Object stringFoldRight$V(Object kons, Object knil, Object s, Object[] argsArray) { LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    checkArg(misc.procedure$Qu, kons, string$Mnfold$Mnright);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mnfold$Mnright, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    for (;;) { Object start; Object localObject3 = AddOp.apply2(-1, end, Lit1);Object v = knil;
      Object i; Object localObject4; if (NumberCompare.$Gr$Eq(i, start)) localObject4 = Promise.force(s, CharSequence.class); try { localObject4 = Promise.force(i); } catch (ClassCastException localClassCastException1) { throw new WrongType(localClassCastException1, "string-ref", 1, localObject4); } try { tmpTernaryOp = AddOp.apply2(-1, i, Lit1); } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "string-ref", 2, localObject4); } } return v;
  }
  





































































  static String lambda2(Object x) { return ""; } static String lambda3(Object x) { return ""; }
  











































  static String lambda4(Object x) { return ""; } static String lambda5(Object x) { return ""; }
  









































  static
  {
    Lit138 = Symbol.valueOf("car");Lit137 = Symbol.valueOf("null?");Lit136 = Symbol.valueOf("if");Lit135 = Symbol.valueOf("let");Lit134 = Symbol.valueOf("receive");Lit133 = Symbol.valueOf("rest");Lit132 = new Object[0];Lit131 = Symbol.valueOf("string-join");Lit130 = Symbol.valueOf("%multispan-repcopy!");Lit129 = Symbol.valueOf("string-xcopy!");Lit128 = Symbol.valueOf("xsubstring");Lit127 = Symbol.valueOf("string-tokenize");Lit126 = Symbol.valueOf("string-replace");Lit125 = Symbol.valueOf("%finish-string-concatenate-reverse");Lit124 = Symbol.valueOf("string-concatenate-reverse/shared");Lit123 = Symbol.valueOf("string-concatenate-reverse");Lit122 = Symbol.valueOf("string-concatenate");Lit121 = Symbol.valueOf("string-concatenate/shared");Lit120 = Symbol.valueOf("string-append/shared");Lit119 = Symbol.valueOf("reverse-list->string");Lit118 = Symbol.valueOf("string-reverse!");Lit117 = Symbol.valueOf("string-reverse");Lit116 = Symbol.valueOf("string-null?");Lit115 = Symbol.valueOf("string-kmp-partial-search");Lit114 = Symbol.valueOf("kmp-step");Lit113 = Symbol.valueOf("make-kmp-restart-vector");Lit112 = Symbol.valueOf("%kmp-search");Lit111 = Symbol.valueOf("string-contains-ci");Lit110 = Symbol.valueOf("string-contains");Lit109 = Symbol.valueOf("string-count");Lit108 = Symbol.valueOf("string-skip-right");Lit107 = Symbol.valueOf("string-skip");Lit106 = Symbol.valueOf("string-index-right");Lit105 = Symbol.valueOf("string-index");Lit104 = Symbol.valueOf("string-filter");Lit103 = Symbol.valueOf("string-delete");Lit102 = Symbol.valueOf("string-pad");Lit101 = Symbol.valueOf("string-pad-right");Lit100 = Symbol.valueOf("string-trim-both");Lit99 = Symbol.valueOf("string-trim-right");Lit98 = Symbol.valueOf("string-trim");Lit97 = Symbol.valueOf("string-drop-right");Lit96 = Symbol.valueOf("string-drop");Lit95 = Symbol.valueOf("string-take-right");Lit94 = Symbol.valueOf("string-take");Lit93 = Symbol.valueOf("string-titlecase");Lit92 = Symbol.valueOf("string-titlecase!");Lit91 = Symbol.valueOf("%string-titlecase!");Lit90 = Symbol.valueOf("string-downcase!");Lit89 = Symbol.valueOf("string-downcase");Lit88 = Symbol.valueOf("string-upcase!");Lit87 = Symbol.valueOf("string-upcase");Lit86 = Symbol.valueOf("string-hash-ci");Lit85 = Symbol.valueOf("string-hash");Lit84 = Symbol.valueOf("%string-hash");Lit83 = Symbol.valueOf("string-ci>=");Lit82 = Symbol.valueOf("string-ci<=");Lit81 = Symbol.valueOf("string-ci>");Lit80 = Symbol.valueOf("string-ci<");Lit79 = Symbol.valueOf("string-ci<>");Lit78 = Symbol.valueOf("string-ci=");Lit77 = Symbol.valueOf("string>=");Lit76 = Symbol.valueOf("string<=");Lit75 = Symbol.valueOf("string>");Lit74 = Symbol.valueOf("string<");Lit73 = Symbol.valueOf("string<>");Lit72 = Symbol.valueOf("string=");Lit71 = Symbol.valueOf("string-compare-ci");Lit70 = Symbol.valueOf("string-compare");Lit69 = Symbol.valueOf("%string-compare-ci");Lit68 = Symbol.valueOf("%string-compare");Lit67 = Symbol.valueOf("%string-suffix-ci?");Lit66 = Symbol.valueOf("%string-prefix-ci?");Lit65 = Symbol.valueOf("%string-suffix?");Lit64 = Symbol.valueOf("%string-prefix?");Lit63 = Symbol.valueOf("string-suffix-ci?");Lit62 = Symbol.valueOf("string-prefix-ci?");Lit61 = Symbol.valueOf("string-suffix?");Lit60 = Symbol.valueOf("string-prefix?");Lit59 = Symbol.valueOf("string-suffix-length-ci");Lit58 = Symbol.valueOf("string-prefix-length-ci");Lit57 = Symbol.valueOf("string-suffix-length");Lit56 = Symbol.valueOf("string-prefix-length");Lit55 = Symbol.valueOf("%string-suffix-length-ci");Lit54 = Symbol.valueOf("%string-prefix-length-ci");Lit53 = Symbol.valueOf("%string-suffix-length");Lit52 = Symbol.valueOf("%string-prefix-length");Lit51 = Symbol.valueOf("string-tabulate");Lit50 = Symbol.valueOf("string-any");Lit49 = Symbol.valueOf("string-every");Lit48 = Symbol.valueOf("string-unfold-right");Lit47 = Symbol.valueOf("string-unfold");Lit46 = Symbol.valueOf("string-fold-right");Lit45 = Symbol.valueOf("string-fold");Lit44 = Symbol.valueOf("%string-map!");Lit43 = Symbol.valueOf("string-map!");Lit42 = Symbol.valueOf("%string-map");Lit41 = Symbol.valueOf("string-map");Lit40 = Symbol.valueOf("%substring/shared");Lit39 = Symbol.valueOf("substring/shared");Lit38 = Symbol.valueOf("check-substring-spec");Lit37 = Symbol.valueOf("substring-spec-ok?");Lit36 = Symbol.valueOf("string-parse-final-start+end");Lit35 = Symbol.valueOf("%check-bounds");Lit34 = Symbol.valueOf("string-parse-start+end"); SyntaxRule[] tmp961_958 = new SyntaxRule[1]; Object[] tmp995_992 = new Object[5]; Object[] tmp996_995 = tmp995_992;tmp996_995[0] = Lit135; Object[] tmp1002_996 = tmp996_995;tmp1002_996[1] = Symbol.valueOf("procv"); Object[] tmp1011_1002 = tmp1002_996; SimpleSymbol tmp1019_1016 = Symbol.valueOf("let-string-start+end");Lit30 = tmp1019_1016;tmp1011_1002[2] = tmp1019_1016; Object[] tmp1024_1011 = tmp1011_1002;tmp1024_1011[3] = PairWithPosition.make(Lit133, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm", 725035);tmp1024_1011[4] = Lit133;tmp961_958[0] = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\f'\f/\f7\f?\rG@\b\b", Lit132, 9, "srfi13.scm:175"), "\001\001\001\001\001\001\001\001\003", "\021\030\0041\b\021\030\f\b#\b\021\030\0241\t\003\t\013\030\034\021\030\f\t+\t;\b\021\030\024!\t\023\b\033\021\030\f\t3\021\030$\bEC", tmp995_992, 1);Lit33 = new SyntaxRules(Lit132, tmp961_958, 9, srfi13.Lit32 = Symbol.valueOf("let-string-start+end2")); SyntaxRule[] tmp1081_1078 = new SyntaxRule[2]; SyntaxRule[] tmp1082_1081 = tmp1081_1078; Object[] tmp1116_1113 = new Object[2]; Object[] tmp1117_1116 = tmp1116_1113;tmp1117_1116[0] = Lit134;tmp1117_1116[1] = Lit36;tmp1082_1081[0] = new SyntaxRule(new SyntaxPattern("\f\030,\f\007\f\017\b\f\027\f\037\f'\r/(\b\b", Lit132, 6, "srfi13.scm:164"), "\001\001\001\001\001\003", "\021\030\004!\t\003\b\013I\021\030\f\t\023\t\033\b#\b-+", tmp1116_1113, 1); Object[] tmp1166_1163 = new Object[2]; Object[] tmp1167_1166 = tmp1166_1163;tmp1167_1166[0] = Lit134;tmp1167_1166[1] = Lit34;tmp1082_1081[1] = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\f\037\f'\f/\r70\b\b", Lit132, 7, "srfi13.scm:167"), "\001\001\001\001\001\001\003", "\021\030\0041\t\023\t\003\b\013I\021\030\f\t\033\t#\b+\b53", tmp1166_1163, 1);Lit31 = new SyntaxRules(Lit132, tmp1081_1078, 7, Lit30);Lit29 = Symbol.valueOf("char-cased?"); Object[] tmp1217_1214 = new Object[3]; Object[] tmp1218_1217 = tmp1217_1214;tmp1218_1217[0] = Lit134; Object[] tmp1224_1218 = tmp1218_1217;tmp1224_1218[1] = Symbol.valueOf("r"); SimpleSymbol tmp1240_1237 = Symbol.valueOf("let-optionals*");Lit15 = tmp1240_1237;tmp1224_1218[2] = tmp1240_1237;Lit28 = new SyntaxTemplate("\001\001\003\001\003\003", "\021\030\004A\021\030\f\t\013\b\025\023!\t\033\b\003\b\021\030\024\021\030\f\031\b%#\b-+", tmp1217_1214, 1);Lit27 = new SyntaxPattern("\f\030\f\007\\<\f\017\r\027\020\b\b\f\037\b\r' \b\b\r/(\b\b", Lit132, 6, "srfi13.scm:149"); Object[] tmp1288_1285 = new Object[9]; Object[] tmp1289_1288 = tmp1288_1285;tmp1289_1288[0] = Lit135; Object[] tmp1295_1289 = tmp1289_1288;tmp1295_1289[1] = Lit136; Object[] tmp1301_1295 = tmp1295_1289;tmp1301_1295[2] = Symbol.valueOf("not"); Object[] tmp1310_1301 = tmp1301_1295;tmp1310_1301[3] = Lit137; Object[] tmp1316_1310 = tmp1310_1301;tmp1316_1310[4] = Lit138; Object[] tmp1322_1316 = tmp1316_1310;tmp1322_1316[5] = Symbol.valueOf("when"); Object[] tmp1331_1322 = tmp1322_1316;tmp1331_1322[6] = Symbol.valueOf("set!"); Object[] tmp1341_1331 = tmp1331_1322;tmp1341_1331[7] = Lit15;tmp1341_1331[8] = Symbol.valueOf("cdr");Lit26 = new SyntaxTemplate("\001\001\001\001\003\003", "\021\030\004É\b\t\013\b\021\030\fI\021\030\024\b\021\030\034\b\003)\021\030$\b\003\b\023\021\030,)\021\030\024\b\033\b\021\0304\t\013\b\023\b\021\030<©\021\030\fI\021\030\024\b\021\030\034\b\003)\021\030D\b\003\b\003\031\b%#\b-+", tmp1288_1285, 1);Lit25 = new SyntaxTemplate("\001\001\001\001\003\003", "\013", Lit132, 0);Lit24 = new SyntaxPattern("\f\030\f\007l<\f\017\f\027\f\037\b\r' \b\b\r/(\b\b", Lit132, 6, "srfi13.scm:142"); Object[] tmp1418_1415 = new Object[2]; Object[] tmp1419_1418 = tmp1418_1415;tmp1419_1418[0] = Lit15;tmp1419_1418[1] = PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm", 577583);Lit23 = new SyntaxTemplate("\001\001\001\003\003", "\021\030\004\t\003Q1\t\013\t\023\030\f\b\035\033\b%#", tmp1418_1415, 1);Lit22 = new SyntaxTemplate("\001\001\001\003\003", "\013", Lit132, 0);Lit21 = new SyntaxPattern("\f\030\f\007\\,\f\017\f\027\b\r\037\030\b\b\r' \b\b", Lit132, 5, "srfi13.scm:139");Lit20 = new SyntaxTemplate("\001\001\003", "\021\030\004)\b\t\013\b\003\b\025\023", new Object[] { Lit135 }, 1);Lit19 = new SyntaxTemplate("\001\001\003", "\013", Lit132, 0);Lit18 = new SyntaxPattern("\f\030\f\007\034\f\017\b\r\027\020\b\b", Lit132, 3, "srfi13.scm:137"); Object[] tmp1570_1567 = new Object[5]; Object[] tmp1571_1570 = tmp1570_1567;tmp1571_1570[0] = Lit136; Object[] tmp1577_1571 = tmp1571_1570;tmp1577_1571[1] = Lit137; Object[] tmp1583_1577 = tmp1577_1571;tmp1583_1577[2] = Lit135; Object[] tmp1589_1583 = tmp1583_1577;tmp1589_1583[3] = Symbol.valueOf("error");tmp1589_1583[4] = "too many arguments";Lit17 = new SyntaxTemplate("\001\003", "\021\030\004)\021\030\f\b\003A\021\030\024\t\020\b\r\013\b\021\030\034\t$\b\003", tmp1570_1567, 1);Lit16 = new SyntaxPattern("\f\030\f\007\f\b\r\017\b\b\b", Lit132, 2, "srfi13.scm:133"); SyntaxRule[] tmp1641_1638 = new SyntaxRule[1]; Object[] tmp1675_1672 = new Object[6]; Object[] tmp1676_1675 = tmp1675_1672;tmp1676_1675[0] = Lit136; Object[] tmp1682_1676 = tmp1676_1675;tmp1682_1676[1] = Lit137; Object[] tmp1688_1682 = tmp1682_1676;tmp1688_1682[2] = Lit135; Object[] tmp1694_1688 = tmp1688_1682;tmp1694_1688[3] = Lit139; Object[] tmp1700_1694 = tmp1694_1688;tmp1700_1694[4] = Lit138;tmp1700_1694[5] = PairWithPosition.make(Lit139, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm", 528407);tmp1641_1638[0] = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit132, 3, "srfi13.scm:126"), "\001\001\001", "\021\030\004)\021\030\f\b\003\t\013\b\021\030\024Q\b\021\030\034\b\021\030$\b\003\b\021\030\004!\t\023\030,\021\030\034\b\013", tmp1675_1672, 0);Lit14 = new SyntaxRules(Lit132, tmp1641_1638, 3, srfi13.Lit13 = Symbol.valueOf(":optional"));Lit12 = Symbol.valueOf("suffix");Lit11 = Symbol.valueOf("prefix");Lit10 = Symbol.valueOf("strict-infix");Lit9 = Symbol.valueOf("infix");Lit8 = IntNum.valueOf(-1);Lit7 = Char.valueOf(32);Lit6 = IntNum.valueOf(4194304);Lit5 = IntNum.valueOf(37);Lit4 = IntNum.valueOf(65536);Lit3 = IntNum.valueOf(40);Lit2 = IntNum.valueOf(4096);Lit1 = IntNum.valueOf(1);Lit0 = IntNum.valueOf(0);$instance = new srfi13();$Cloptional = Macro.make(Lit13, Lit14, "gnu.kawa.slib.srfi13");srfi13 localSrfi131 = $instance;let$Mnoptionals$St = Macro.make(Lit15, new ModuleMethod(localSrfi131, 13, null, 4097), "gnu.kawa.slib.srfi13");srfi13 localSrfi132 = $instance;char$Mncased$Qu = new ModuleMethod(localSrfi132, 14, Lit29, 4097);let$Mnstring$Mnstart$Plend = Macro.make(Lit30, Lit31, "gnu.kawa.slib.srfi13");let$Mnstring$Mnstart$Plend2 = Macro.make(Lit32, Lit33, "gnu.kawa.slib.srfi13");string$Mnparse$Mnstart$Plend = new ModuleMethod(localSrfi132, 15, Lit34, 12291);$Pccheck$Mnbounds = new ModuleMethod(localSrfi132, 16, Lit35, 16388);string$Mnparse$Mnfinal$Mnstart$Plend = new ModuleMethod(localSrfi132, 17, Lit36, 12291);substring$Mnspec$Mnok$Qu = new ModuleMethod(localSrfi132, 18, Lit37, 12291);check$Mnsubstring$Mnspec = new ModuleMethod(localSrfi132, 19, Lit38, 16388); void tmp2070_2067 = new ModuleMethod(localSrfi132, 20, null, 4097);tmp2070_2067.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:266");lambda$Fn1 = tmp2070_2067;substring$Slshared = new ModuleMethod(localSrfi132, 21, Lit39, 61442);$Pcsubstring$Slshared = new ModuleMethod(localSrfi132, 22, Lit40, 12291);string$Mncopy = StaticFieldLocation.make("kawa.lib.strings", "string$Mncopy");string$Mnmap = new ModuleMethod(localSrfi132, 23, Lit41, 61442);$Pcstring$Mnmap = new ModuleMethod(localSrfi132, 24, Lit42, 16388);string$Mnmap$Ex = new ModuleMethod(localSrfi132, 25, Lit43, 61442);$Pcstring$Mnmap$Ex = new ModuleMethod(localSrfi132, 26, Lit44, 16388);string$Mnfold = new ModuleMethod(localSrfi132, 27, Lit45, 61443);string$Mnfold$Mnright = new ModuleMethod(localSrfi132, 28, Lit46, 61443); void tmp2261_2258 = new ModuleMethod(localSrfi132, 29, null, 4097);tmp2261_2258.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:423");lambda$Fn2 = tmp2261_2258; void tmp2288_2285 = new ModuleMethod(localSrfi132, 30, null, 4097);tmp2288_2285.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:423");lambda$Fn3 = tmp2288_2285;string$Mnunfold = new ModuleMethod(localSrfi132, 31, Lit47, 61444); void tmp2334_2331 = new ModuleMethod(localSrfi132, 32, null, 4097);tmp2334_2331.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:468");lambda$Fn4 = tmp2334_2331; void tmp2361_2358 = new ModuleMethod(localSrfi132, 33, null, 4097);tmp2361_2358.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:468");lambda$Fn5 = tmp2361_2358;string$Mnunfold$Mnright = new ModuleMethod(localSrfi132, 34, Lit48, 61444);string$Mnfor$Mneach = StaticFieldLocation.make("kawa.lib.strings", "srfi$Mn13$Mnstring$Mnfor$Mneach");string$Mnevery = new ModuleMethod(localSrfi132, 35, Lit49, 61442);string$Mnany = new ModuleMethod(localSrfi132, 36, Lit50, 61442); void tmp2457_2454 = new ModuleMethod(localSrfi132, 37, null, 4097);tmp2457_2454.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:584");lambda$Fn6 = tmp2457_2454;string$Mntabulate = new ModuleMethod(localSrfi132, 38, Lit51, 8194);$Pcstring$Mnprefix$Mnlength = new ModuleMethod(localSrfi132, 39, Lit52, 24582);$Pcstring$Mnsuffix$Mnlength = new ModuleMethod(localSrfi132, 40, Lit53, 24582);$Pcstring$Mnprefix$Mnlength$Mnci = new ModuleMethod(localSrfi132, 41, Lit54, 24582);$Pcstring$Mnsuffix$Mnlength$Mnci = new ModuleMethod(localSrfi132, 42, Lit55, 24582);string$Mnprefix$Mnlength = new ModuleMethod(localSrfi132, 43, Lit56, 61442);string$Mnsuffix$Mnlength = new ModuleMethod(localSrfi132, 44, Lit57, 61442);string$Mnprefix$Mnlength$Mnci = new ModuleMethod(localSrfi132, 45, Lit58, 61442);string$Mnsuffix$Mnlength$Mnci = new ModuleMethod(localSrfi132, 46, Lit59, 61442);string$Mnprefix$Qu = new ModuleMethod(localSrfi132, 47, Lit60, 61442);string$Mnsuffix$Qu = new ModuleMethod(localSrfi132, 48, Lit61, 61442);string$Mnprefix$Mnci$Qu = new ModuleMethod(localSrfi132, 49, Lit62, 61442);string$Mnsuffix$Mnci$Qu = new ModuleMethod(localSrfi132, 50, Lit63, 61442);$Pcstring$Mnprefix$Qu = new ModuleMethod(localSrfi132, 51, Lit64, 24582);$Pcstring$Mnsuffix$Qu = new ModuleMethod(localSrfi132, 52, Lit65, 24582);$Pcstring$Mnprefix$Mnci$Qu = new ModuleMethod(localSrfi132, 53, Lit66, 24582);$Pcstring$Mnsuffix$Mnci$Qu = new ModuleMethod(localSrfi132, 54, Lit67, 24582);$Pcstring$Mncompare = new ModuleMethod(localSrfi132, 55, Lit68, 36873);$Pcstring$Mncompare$Mnci = new ModuleMethod(localSrfi132, 56, Lit69, 36873);string$Mncompare = new ModuleMethod(localSrfi132, 57, Lit70, 61445);string$Mncompare$Mnci = new ModuleMethod(localSrfi132, 58, Lit71, 61445); void tmp2883_2880 = new ModuleMethod(localSrfi132, 59, null, 4097);tmp2883_2880.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:805");lambda$Fn7 = tmp2883_2880; void tmp2910_2907 = new ModuleMethod(localSrfi132, 60, null, 4097);tmp2910_2907.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:807");lambda$Fn8 = tmp2910_2907;string$Eq = new ModuleMethod(localSrfi132, 61, Lit72, 61442); void tmp2956_2953 = new ModuleMethod(localSrfi132, 62, null, 4097);tmp2956_2953.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:816");lambda$Fn9 = tmp2956_2953;string$Ls$Gr = new ModuleMethod(localSrfi132, 63, Lit73, 61442); void tmp3002_2999 = new ModuleMethod(localSrfi132, 64, null, 4097);tmp3002_2999.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:827");lambda$Fn10 = tmp3002_2999; void tmp3029_3026 = new ModuleMethod(localSrfi132, 65, null, 4097);tmp3029_3026.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:828");lambda$Fn11 = tmp3029_3026;string$Ls = new ModuleMethod(localSrfi132, 66, Lit74, 61442); void tmp3075_3072 = new ModuleMethod(localSrfi132, 67, null, 4097);tmp3075_3072.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:837");lambda$Fn12 = tmp3075_3072; void tmp3102_3099 = new ModuleMethod(localSrfi132, 68, null, 4097);tmp3102_3099.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:838");lambda$Fn13 = tmp3102_3099;string$Gr = new ModuleMethod(localSrfi132, 69, Lit75, 61442); void tmp3148_3145 = new ModuleMethod(localSrfi132, 70, null, 4097);tmp3148_3145.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:850");lambda$Fn14 = tmp3148_3145;string$Ls$Eq = new ModuleMethod(localSrfi132, 71, Lit76, 61442); void tmp3194_3191 = new ModuleMethod(localSrfi132, 72, null, 4097);tmp3194_3191.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:859");lambda$Fn15 = tmp3194_3191;string$Gr$Eq = new ModuleMethod(localSrfi132, 73, Lit77, 61442); void tmp3240_3237 = new ModuleMethod(localSrfi132, 74, null, 4097);tmp3240_3237.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:869");lambda$Fn16 = tmp3240_3237; void tmp3267_3264 = new ModuleMethod(localSrfi132, 75, null, 4097);tmp3267_3264.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:871");lambda$Fn17 = tmp3267_3264;string$Mnci$Eq = new ModuleMethod(localSrfi132, 76, Lit78, 61442); void tmp3313_3310 = new ModuleMethod(localSrfi132, 77, null, 4097);tmp3313_3310.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:880");lambda$Fn18 = tmp3313_3310;string$Mnci$Ls$Gr = new ModuleMethod(localSrfi132, 78, Lit79, 61442); void tmp3359_3356 = new ModuleMethod(localSrfi132, 79, null, 4097);tmp3359_3356.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:891");lambda$Fn19 = tmp3359_3356; void tmp3386_3383 = new ModuleMethod(localSrfi132, 80, null, 4097);tmp3386_3383.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:892");lambda$Fn20 = tmp3386_3383;string$Mnci$Ls = new ModuleMethod(localSrfi132, 81, Lit80, 61442); void tmp3432_3429 = new ModuleMethod(localSrfi132, 82, null, 4097);tmp3432_3429.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:901");lambda$Fn21 = tmp3432_3429; void tmp3459_3456 = new ModuleMethod(localSrfi132, 83, null, 4097);tmp3459_3456.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:902");lambda$Fn22 = tmp3459_3456;string$Mnci$Gr = new ModuleMethod(localSrfi132, 84, Lit81, 61442); void tmp3505_3502 = new ModuleMethod(localSrfi132, 85, null, 4097);tmp3505_3502.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:914");lambda$Fn23 = tmp3505_3502;string$Mnci$Ls$Eq = new ModuleMethod(localSrfi132, 86, Lit82, 61442); void tmp3551_3548 = new ModuleMethod(localSrfi132, 87, null, 4097);tmp3551_3548.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:923");lambda$Fn24 = tmp3551_3548;string$Mnci$Gr$Eq = new ModuleMethod(localSrfi132, 88, Lit83, 61442);$Pcstring$Mnhash = new ModuleMethod(localSrfi132, 89, Lit84, 20485);string$Mnhash = new ModuleMethod(localSrfi132, 90, Lit85, 61441); void tmp3635_3632 = new ModuleMethod(localSrfi132, 91, null, 4097);tmp3635_3632.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:971");lambda$Fn25 = tmp3635_3632;string$Mnhash$Mnci = new ModuleMethod(localSrfi132, 92, Lit86, 61441);string$Mnupcase = new ModuleMethod(localSrfi132, 93, Lit87, 61441);string$Mnupcase$Ex = new ModuleMethod(localSrfi132, 94, Lit88, 61441);string$Mndowncase = new ModuleMethod(localSrfi132, 95, Lit89, 61441);string$Mndowncase$Ex = new ModuleMethod(localSrfi132, 96, Lit90, 61441);$Pcstring$Mntitlecase$Ex = new ModuleMethod(localSrfi132, 97, Lit91, 12291);string$Mntitlecase$Ex = new ModuleMethod(localSrfi132, 98, Lit92, 61441);string$Mntitlecase = new ModuleMethod(localSrfi132, 99, Lit93, 61441);string$Mntake = new ModuleMethod(localSrfi132, 100, Lit94, 8194);string$Mntake$Mnright = new ModuleMethod(localSrfi132, 101, Lit95, 8194);string$Mndrop = new ModuleMethod(localSrfi132, 102, Lit96, 8194);string$Mndrop$Mnright = new ModuleMethod(localSrfi132, 103, Lit97, 8194);string$Mntrim = new ModuleMethod(localSrfi132, 104, Lit98, 61441);string$Mntrim$Mnright = new ModuleMethod(localSrfi132, 105, Lit99, 61441);string$Mntrim$Mnboth = new ModuleMethod(localSrfi132, 106, Lit100, 61441); void tmp3947_3944 = new ModuleMethod(localSrfi132, 107, null, 4097);tmp3947_3944.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1096");lambda$Fn30 = tmp3947_3944;string$Mnpad$Mnright = new ModuleMethod(localSrfi132, 108, Lit101, 61442); void tmp3993_3990 = new ModuleMethod(localSrfi132, 109, null, 4097);tmp3993_3990.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1108");lambda$Fn31 = tmp3993_3990;string$Mnpad = new ModuleMethod(localSrfi132, 110, Lit102, 61442);string$Mndelete = new ModuleMethod(localSrfi132, 111, Lit103, 61442);string$Mnfilter = new ModuleMethod(localSrfi132, 112, Lit104, 61442);string$Mnindex = new ModuleMethod(localSrfi132, 113, Lit105, 61442);string$Mnindex$Mnright = new ModuleMethod(localSrfi132, 114, Lit106, 61442);string$Mnskip = new ModuleMethod(localSrfi132, 115, Lit107, 61442);string$Mnskip$Mnright = new ModuleMethod(localSrfi132, 116, Lit108, 61442);string$Mncount = new ModuleMethod(localSrfi132, 117, Lit109, 61442);string$Mnfill$Ex = StaticFieldLocation.make("kawa.lib.strings", "string$Mnfill$Ex");string$Mncopy$Ex = StaticFieldLocation.make("kawa.lib.strings", "string$Mncopy$Ex");$Pcstring$Mncopy$Ex = StaticFieldLocation.make("kawa.lib.strings", "string$Mncopy$Ex");string$Mncontains = new ModuleMethod(localSrfi132, 118, Lit110, 61442);string$Mncontains$Mnci = new ModuleMethod(localSrfi132, 119, Lit111, 61442);$Pckmp$Mnsearch = new ModuleMethod(localSrfi132, 120, Lit112, 28679);make$Mnkmp$Mnrestart$Mnvector = new ModuleMethod(localSrfi132, 121, Lit113, 61441);kmp$Mnstep = new ModuleMethod(localSrfi132, 122, Lit114, 24582);string$Mnkmp$Mnpartial$Mnsearch = new ModuleMethod(localSrfi132, 123, Lit115, 61444);string$Mnnull$Qu = new ModuleMethod(localSrfi132, 124, Lit116, 4097);string$Mnreverse = new ModuleMethod(localSrfi132, 125, Lit117, 61441);string$Mnreverse$Ex = new ModuleMethod(localSrfi132, 126, Lit118, 61441);reverse$Mnlist$Mn$Grstring = new ModuleMethod(localSrfi132, 127, Lit119, 4097);string$Mn$Grlist = StaticFieldLocation.make("kawa.lib.strings", "string$Mn$Grlist");string$Mnappend$Slshared = new ModuleMethod(localSrfi132, 128, Lit120, 61440);string$Mnconcatenate$Slshared = new ModuleMethod(localSrfi132, 129, Lit121, 4097);string$Mnconcatenate = new ModuleMethod(localSrfi132, 130, Lit122, 4097);string$Mnconcatenate$Mnreverse = new ModuleMethod(localSrfi132, 131, Lit123, 61441);string$Mnconcatenate$Mnreverse$Slshared = new ModuleMethod(localSrfi132, 132, Lit124, 61441);$Pcfinish$Mnstring$Mnconcatenate$Mnreverse = new ModuleMethod(localSrfi132, 133, Lit125, 16388);string$Mnreplace = new ModuleMethod(localSrfi132, 134, Lit126, 61444);string$Mntokenize = new ModuleMethod(localSrfi132, 135, Lit127, 61441); void tmp4571_4568 = new ModuleMethod(localSrfi132, 136, null, 4097);tmp4571_4568.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1795");lambda$Fn39 = tmp4571_4568;xsubstring = new ModuleMethod(localSrfi132, 137, Lit128, 61442); void tmp4619_4616 = new ModuleMethod(localSrfi132, 138, null, 4097);tmp4619_4616.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1836");lambda$Fn41 = tmp4619_4616; void tmp4647_4644 = new ModuleMethod(localSrfi132, 139, null, 4097);tmp4647_4644.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1842");lambda$Fn42 = tmp4647_4644;string$Mnxcopy$Ex = new ModuleMethod(localSrfi132, 140, Lit129, 61444);$Pcmultispan$Mnrepcopy$Ex = new ModuleMethod(localSrfi132, 141, Lit130, 28679);string$Mnjoin = new ModuleMethod(localSrfi132, 142, Lit131, 61441);$runBody$(); } static final SimpleSymbol Lit139 = Symbol.valueOf("x");
  



































































  static boolean lambda6(Object val)
  {
    return numbers.isInteger(val) ? false : numbers.isExact(val) ? NumberCompare.$Ls$Eq(Lit0, val) : false;
  }
  
  public static FString stringTabulate(Object proc, int len)
  {
    checkArg(misc.procedure$Qu, proc, string$Mntabulate);
    
    checkArg(lambda$Fn6, Integer.valueOf(len), string$Mntabulate);
    FString s = strings.makeString(len);
    int i = len - 1; for (;;) { if (i >= 0) {}
      try {
        strings.stringSet$Ex(s, i, Char.castToCharacter(localObject = Promise.force(Scheme.applyToArgs.apply2(proc, Integer.valueOf(i)))));i--; } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(
          localClassCastException, "string-set!", 3, localObject); } } return s;
  }
  



































































  public static Object stringPrefixLength$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnprefix$Mnlength, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnprefix$Mnlength, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    return $PcStringPrefixLength(s1, start1, end1, s2, start2, end2); }
  
  public static Object stringSuffixLength$V(Object s1, Object s2, Object[] argsArray) { LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnsuffix$Mnlength, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnsuffix$Mnlength, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    return $PcStringSuffixLength(s1, start1, end1, s2, start2, end2);
  }
  















  public static boolean isStringPrefix$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnprefix$Qu, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnprefix$Qu, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    return $PcStringPrefix$Qu(s1, start1, end1, s2, start2, end2); }
  
  public static boolean isStringSuffix$V(Object s1, Object s2, Object[] argsArray) { LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnsuffix$Qu, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnsuffix$Qu, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    return $PcStringSuffix$Qu(s1, start1, end1, s2, start2, end2); }
  
  public static boolean isStringPrefixCi$V(Object s1, Object s2, Object[] argsArray) { LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnprefix$Mnci$Qu, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnprefix$Mnci$Qu, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    return $PcStringPrefixCi$Qu(s1, start1, end1, s2, start2, end2); }
  
  public static boolean isStringSuffixCi$V(Object s1, Object s2, Object[] argsArray) { LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnsuffix$Mnci$Qu, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnsuffix$Mnci$Qu, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    return $PcStringSuffixCi$Qu(s1, start1, end1, s2, start2, end2);
  }
  

  public static boolean $PcStringPrefix$Qu(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2)
  {
    Object len1 = AddOp.apply2(-1, end1, start1);
    


    return NumberCompare.$Ls$Eq(len1, AddOp.apply2(-1, end2, start2)) ? NumberCompare.$Eq($PcStringPrefixLength(s1, start1, end1, s2, start2, end2), len1) : false;
  }
  
  public static boolean $PcStringSuffix$Qu(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2) { Object len1 = AddOp.apply2(-1, end1, start1);
    

    return NumberCompare.$Ls$Eq(len1, AddOp.apply2(-1, end2, start2)) ? NumberCompare.$Eq(len1, $PcStringSuffixLength(s1, start1, end1, s2, start2, end2)) : false;
  }
  













































  public static Object stringCompare$V(Object s1, Object s2, Object proc$Ls, Object proc$Eq, Object proc$Gr, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    checkArg(misc.procedure$Qu, proc$Ls, string$Mncompare);
    checkArg(misc.procedure$Qu, proc$Eq, string$Mncompare);
    checkArg(misc.procedure$Qu, proc$Gr, string$Mncompare);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mncompare, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mncompare, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    return $PcStringCompare(s1, start1, end1, s2, start2, end2, proc$Ls, proc$Eq, proc$Gr); }
  
  public static Object stringCompareCi$V(Object s1, Object s2, Object proc$Ls, Object proc$Eq, Object proc$Gr, Object[] argsArray) { LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    checkArg(misc.procedure$Qu, proc$Ls, string$Mncompare$Mnci);
    checkArg(misc.procedure$Qu, proc$Eq, string$Mncompare$Mnci);
    checkArg(misc.procedure$Qu, proc$Gr, string$Mncompare$Mnci);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mncompare$Mnci, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mncompare$Mnci, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    return $PcStringCompareCi(s1, start1, end1, s2, start2, end2, proc$Ls, proc$Eq, proc$Gr);
  }
  












  static boolean lambda7(Object i)
  {
    return false;
  }
  
  public static Object string$Eq$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Eq, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Eq, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    
    Object start2;
    boolean x = s1 == s2 ? NumberCompare.$Eq(start1, start2) : false;
    


    return NumberCompare.$Eq(AddOp.apply2(-1, end1, start1), AddOp.apply2(-1, end2, start2)) ? $PcStringCompare(s1, start1, end1, s2, start2, end2, lambda$Fn7, misc.values, lambda$Fn8) : x ? Boolean.FALSE : x ? Boolean.TRUE : Boolean.FALSE; } static boolean lambda8(Object i) { return false; }
  





  static boolean lambda9(Object i)
  {
    return false;
  }
  
  public static Object string$Ls$Gr$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Ls$Gr, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Ls$Gr, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    boolean x = !NumberCompare.$Eq(AddOp.apply2(-1, end1, start1), AddOp.apply2(-1, end2, start2));
    



    return (s1 != s2) || (!NumberCompare.$Eq(start1, start2)) ? $PcStringCompare(s1, start1, end1, s2, start2, end2, misc.values, lambda$Fn9, misc.values) : x ? Boolean.FALSE : x ? Boolean.TRUE : Boolean.FALSE;
  }
  





  static boolean lambda10(Object i)
  {
    return false;
  }
  
  public static Object string$Ls$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Ls, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Ls, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    


    Object start2;
    


    return (s1 == s2) && (NumberCompare.$Eq(start1, start2)) ? Boolean.FALSE : NumberCompare.$Ls(end1, end2) ? Boolean.TRUE : $PcStringCompare(s1, start1, end1, s2, start2, end2, misc.values, lambda$Fn10, lambda$Fn11); } static boolean lambda11(Object i) { return false; }
  







  static boolean lambda12(Object i) { return false; }
  static boolean lambda13(Object i) { return false;
  }
  
  public static Object string$Gr$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Gr, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Gr, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    


    Object start2;
    


    return (s1 == s2) && (NumberCompare.$Eq(start1, start2)) ? Boolean.FALSE : NumberCompare.$Gr(end1, end2) ? Boolean.TRUE : $PcStringCompare(s1, start1, end1, s2, start2, end2, lambda$Fn12, lambda$Fn13, misc.values); }
  
  public static Object string$Ls$Eq$V(Object s1, Object s2, Object[] argsArray) { LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Ls$Eq, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Ls$Eq, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    


    Object start2;
    


    return (s1 == s2) && (NumberCompare.$Eq(start1, start2)) ? Boolean.FALSE : NumberCompare.$Ls$Eq(end1, end2) ? Boolean.TRUE : $PcStringCompare(s1, start1, end1, s2, start2, end2, misc.values, misc.values, lambda$Fn14); } static boolean lambda14(Object i) { return false; }
  





  static boolean lambda15(Object i)
  {
    return false;
  }
  
  public static Object string$Gr$Eq$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Gr$Eq, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Gr$Eq, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    


    Object start2;
    


    return (s1 == s2) && (NumberCompare.$Eq(start1, start2)) ? Boolean.FALSE : NumberCompare.$Gr$Eq(end1, end2) ? Boolean.TRUE : $PcStringCompare(s1, start1, end1, s2, start2, end2, lambda$Fn15, misc.values, misc.values);
  }
  



  static boolean lambda16(Object i)
  {
    return false;
  }
  
  public static Object stringCi$Eq$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnci$Eq, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnci$Eq, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    
    Object start2;
    boolean x = s1 == s2 ? NumberCompare.$Eq(start1, start2) : false;
    


    return NumberCompare.$Eq(AddOp.apply2(-1, end1, start1), AddOp.apply2(-1, end2, start2)) ? $PcStringCompareCi(s1, start1, end1, s2, start2, end2, lambda$Fn16, misc.values, lambda$Fn17) : x ? Boolean.FALSE : x ? Boolean.TRUE : Boolean.FALSE; } static boolean lambda17(Object i) { return false; }
  





  static boolean lambda18(Object i)
  {
    return false;
  }
  
  public static Object stringCi$Ls$Gr$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnci$Ls$Gr, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnci$Ls$Gr, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    Object start2;
    boolean x = !NumberCompare.$Eq(AddOp.apply2(-1, end1, start1), AddOp.apply2(-1, end2, start2));
    



    return (s1 != s2) || (!NumberCompare.$Eq(start1, start2)) ? $PcStringCompareCi(s1, start1, end1, s2, start2, end2, misc.values, lambda$Fn18, misc.values) : x ? Boolean.FALSE : x ? Boolean.TRUE : Boolean.FALSE;
  }
  





  static boolean lambda19(Object i)
  {
    return false;
  }
  
  public static Object stringCi$Ls$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnci$Ls, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnci$Ls, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    


    Object start2;
    


    return (s1 == s2) && (NumberCompare.$Eq(start1, start2)) ? Boolean.FALSE : NumberCompare.$Ls(end1, end2) ? Boolean.TRUE : $PcStringCompareCi(s1, start1, end1, s2, start2, end2, misc.values, lambda$Fn19, lambda$Fn20); } static boolean lambda20(Object i) { return false; }
  







  static boolean lambda21(Object i) { return false; }
  static boolean lambda22(Object i) { return false;
  }
  
  public static Object stringCi$Gr$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnci$Gr, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnci$Gr, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    


    Object start2;
    


    return (s1 == s2) && (NumberCompare.$Eq(start1, start2)) ? Boolean.FALSE : NumberCompare.$Gr(end1, end2) ? Boolean.TRUE : $PcStringCompareCi(s1, start1, end1, s2, start2, end2, lambda$Fn21, lambda$Fn22, misc.values); }
  
  public static Object stringCi$Ls$Eq$V(Object s1, Object s2, Object[] argsArray) { LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnci$Ls$Eq, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnci$Ls$Eq, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    


    Object start2;
    


    return (s1 == s2) && (NumberCompare.$Eq(start1, start2)) ? Boolean.FALSE : NumberCompare.$Ls$Eq(end1, end2) ? Boolean.TRUE : $PcStringCompareCi(s1, start1, end1, s2, start2, end2, misc.values, misc.values, lambda$Fn23); } static boolean lambda23(Object i) { return false; }
  





  static boolean lambda24(Object i)
  {
    return false;
  }
  
  public static Object stringCi$Gr$Eq$V(Object s1, Object s2, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mnci$Gr$Eq, s1, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end1 = Values.getFromPosFinal(localObject1, i);
    Object start1;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mnci$Gr$Eq, 
      s2, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object end2 = Values.getFromPosFinal(localValues, j);
    


    Object start2;
    


    return (s1 == s2) && (NumberCompare.$Eq(start1, start2)) ? Boolean.FALSE : NumberCompare.$Gr$Eq(end1, end2) ? Boolean.TRUE : $PcStringCompareCi(s1, start1, end1, s2, start2, end2, lambda$Fn24, misc.values, misc.values);
  }
  







































  static int lambda25(Object c)
  {
    try
    {
      return unicode.charDowncase(Char.castToCharacter(localObject = Promise.force(c))); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "char-downcase", 1, localObject);
    }
  }
  









  public static FString stringUpcase$V(Object s, Object[] argsArray)
  {
    LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mnupcase, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    Object start; return $PcStringMap(unicode.char$Mnupcase, s, start, end); }
  
  public static Object stringUpcase$Ex$V(Object s, Object[] argsArray) { LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mnupcase$Ex, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    Object start; return $PcStringMap$Ex(unicode.char$Mnupcase, s, start, end); }
  
  public static FString stringDowncase$V(Object s, Object[] argsArray) { LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mndowncase, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    Object start; return $PcStringMap(unicode.char$Mndowncase, s, start, end); }
  
  public static Object stringDowncase$Ex$V(Object s, Object[] argsArray) { LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mndowncase$Ex, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    Object start; return $PcStringMap$Ex(unicode.char$Mndowncase, s, start, end);
  }
  









  public static Object stringTitlecase$Ex$V(Object s, Object[] argsArray)
  {
    LList maybe$Mnstart$Plend = localObject1 = LList.makeList(argsArray, 0);
    Object localObject1 = stringParseFinalStart$PlEnd(string$Mntitlecase$Ex, s, maybe$Mnstart$Plend);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object end = Values.getFromPosFinal(localObject1, i);
    Object start; return $PcStringTitlecase$Ex(s, start, end);
  }
  





  public class frame
    extends ModuleBody
  {
    Object s;
    



    Object n;
    



    final ModuleMethod lambda$Fn26;
    




    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 1) return lambda26(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda26(Object val) { if ((!numbers.isInteger(n)) || (numbers.isExact(n))) {}
      try { tmpTernaryOp = NumberCompare.$Ls$Eq$V(srfi13.Lit0, n, Integer.valueOf(strings.stringLength((CharSequence)(localObject = Promise.force(s, CharSequence.class)))), new Object[0]); break label62; tmpTernaryOp = false; label62: return false; } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "string-length", 1, localObject);
      } }
    
    public frame() { void tmp18_15 = new ModuleMethod(this, 1, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1045");
      lambda$Fn26 = tmp18_15; } }
  
  public class frame0 extends ModuleBody { int len;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 2) return lambda27(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 2) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda27(Object val) { return numbers.isInteger(n) ? false : numbers.isExact(n) ? NumberCompare.$Ls$Eq$V(srfi13.Lit0, n, Integer.valueOf(len), new Object[0]) : false; }
    
    Object n;
    final ModuleMethod lambda$Fn27;
    public frame0() { void tmp18_15 = new ModuleMethod(this, 2, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1053");
      lambda$Fn27 = tmp18_15; } }
  
  public class frame1 extends ModuleBody { public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 3) return lambda28(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 3) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda28(Object val) { return numbers.isInteger(n) ? false : numbers.isExact(n) ? NumberCompare.$Ls$Eq$V(srfi13.Lit0, n, Integer.valueOf(len), new Object[0]) : false; }
    
    int len;
    Object n;
    final ModuleMethod lambda$Fn28;
    public frame1()
    {
      void tmp18_15 = new ModuleMethod(this, 3, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1059");
      lambda$Fn28 = tmp18_15;
    }
  }
  
  public static Object stringDrop(CharSequence s, Object n)
  {
    frame1 $heapFrame = new frame1();n = n;
    len = strings.stringLength(s);
    
    checkArg(lambda$Fn28, n, string$Mndrop);
    try { return $PcSubstring$SlShared(s, ((Number)(localObject = Promise.force(n))).intValue(), len); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "%substring/shared", 1, localObject);
    }
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {} try { return stringTabulate(paramObject1, ((Number)Promise.force(paramObject2)).intValue()); } catch (ClassCastException localClassCastException1) { throw new WrongType(
      































































































































































































































































































































































































































































































        localClassCastException1, "string-tabulate", 2, paramObject2);
    }
    return stringTake(paramObject1, paramObject2);
    





    return stringTakeRight(paramObject1, paramObject2);
    



    try
    {
      return stringDrop((CharSequence)Promise.force(paramObject1, CharSequence.class), paramObject2); } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "string-drop", 1, paramObject1);
    }
    

    try
    {
      return stringDropRight((CharSequence)Promise.force(paramObject1, CharSequence.class), paramObject2); } catch (ClassCastException localClassCastException3) { throw new WrongType(localClassCastException3, "string-drop-right", 1, paramObject1); } return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  
  public class frame2 extends ModuleBody { public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 4) return lambda29(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 4) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda29(Object val) { return numbers.isInteger(n) ? false : numbers.isExact(n) ? NumberCompare.$Ls$Eq$V(srfi13.Lit0, n, Integer.valueOf(len), new Object[0]) : false;
    }
    
    int len;
    Object n;
    final ModuleMethod lambda$Fn29;
    public frame2()
    {
      void tmp18_15 = new ModuleMethod(this, 4, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1065");
      lambda$Fn29 = tmp18_15;
    }
  }
  
  public static Object stringDropRight(CharSequence s, Object n)
  {
    frame2 $heapFrame = new frame2();n = n;
    len = strings.stringLength(s);
    
    checkArg(lambda$Fn29, n, string$Mndrop$Mnright);
    try { return $PcSubstring$SlShared(s, 0, ((Number)(localObject = Promise.force(AddOp.apply2(-1, Integer.valueOf(len), n)))).intValue()); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "%substring/shared", 2, localObject);
    }
  }
  























  static boolean lambda30(Object n)
  {
    return numbers.isInteger(n) ? false : numbers.isExact(n) ? NumberCompare.$Ls$Eq(Lit0, n) : false;
  }
  







  static boolean lambda31(Object n)
  {
    return numbers.isInteger(n) ? false : numbers.isExact(n) ? NumberCompare.$Ls$Eq(Lit0, n) : false;
  }
  
  public class frame3
    extends ModuleBody
  {
    FString ans;
    Object cset;
    FString temp;
    Object criterion;
    final ModuleMethod lambda$Fn32;
    final ModuleMethod lambda$Fn33;
    final ModuleMethod lambda$Fn34;
    
    public frame3()
    {
      void tmp18_15 = new ModuleMethod(this, 5, null, 8194);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1138");
      lambda$Fn32 = tmp18_15;
      void tmp44_41 = new ModuleMethod(this, 6, null, 8194);
      tmp44_41.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1148");
      lambda$Fn33 = tmp44_41;
      void tmp70_67 = new ModuleMethod(this, 7, null, 8194);
      tmp70_67.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1153");
      lambda$Fn34 = tmp70_67;
    }
    
    /* Error */
    Object lambda32(Object c, Object i)
    {
      // Byte code:
      //   0: getstatic 6	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: aload_0
      //   4: getfield 12	gnu/kawa/slib/srfi13$frame3:criterion	Ljava/lang/Object;
      //   7: aload_1
      //   8: invokevirtual 18	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   11: invokestatic 24	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   14: ifeq +7 -> 21
      //   17: aload_2
      //   18: goto +39 -> 57
      //   21: aload_0
      //   22: getfield 28	gnu/kawa/slib/srfi13$frame3:temp	Lgnu/lists/FString;
      //   25: aload_2
      //   26: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   29: dup
      //   30: astore_3
      //   31: checkcast 36	java/lang/Number
      //   34: invokevirtual 40	java/lang/Number:intValue	()I
      //   37: aload_1
      //   38: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   41: dup
      //   42: astore_3
      //   43: invokestatic 56	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   46: invokestatic 62	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
      //   49: iconst_1
      //   50: aload_2
      //   51: getstatic 68	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   54: invokestatic 73	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   57: areturn
      //   58: new 44	gnu/mapping/WrongType
      //   61: dup_x1
      //   62: swap
      //   63: ldc 46
      //   65: iconst_2
      //   66: aload_3
      //   67: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   70: athrow
      //   71: new 44	gnu/mapping/WrongType
      //   74: dup_x1
      //   75: swap
      //   76: ldc 46
      //   78: iconst_3
      //   79: aload_3
      //   80: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   83: athrow
      // Line number table:
      //   Java source line #1138	-> byte code offset #0
      //   Java source line #1139	-> byte code offset #0
      //   Java source line #1140	-> byte code offset #21
      //   Java source line #1141	-> byte code offset #49
      //   Java source line #1140	-> byte code offset #58
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	frame3
      //   0	57	1	c	Object
      //   0	57	2	i	Object
      //   30	50	3	localObject	Object
      //   58	1	4	localClassCastException1	ClassCastException
      //   71	1	5	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   31	37	58	java/lang/ClassCastException
      //   43	46	71	java/lang/ClassCastException
    }
    
    /* Error */
    Object lambda33(Object c, Object i)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 76	gnu/kawa/slib/srfi13$frame3:cset	Ljava/lang/Object;
      //   4: ldc 78
      //   6: invokestatic 81	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   9: dup
      //   10: astore_3
      //   11: checkcast 78	gnu/kawa/slib/srfi14$CharSet
      //   14: aload_1
      //   15: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   18: dup
      //   19: astore_3
      //   20: invokestatic 56	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   23: invokestatic 89	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
      //   26: ifeq +7 -> 33
      //   29: aload_2
      //   30: goto +11 -> 41
      //   33: iconst_1
      //   34: aload_2
      //   35: getstatic 68	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   38: invokestatic 73	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   41: areturn
      //   42: new 44	gnu/mapping/WrongType
      //   45: dup_x1
      //   46: swap
      //   47: ldc 83
      //   49: iconst_0
      //   50: aload_3
      //   51: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   54: athrow
      //   55: new 44	gnu/mapping/WrongType
      //   58: dup_x1
      //   59: swap
      //   60: ldc 83
      //   62: iconst_1
      //   63: aload_3
      //   64: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   67: athrow
      // Line number table:
      //   Java source line #1148	-> byte code offset #0
      //   Java source line #1150	-> byte code offset #33
      //   Java source line #1148	-> byte code offset #42
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	42	0	this	frame3
      //   0	41	1	c	Object
      //   0	41	2	i	Object
      //   10	54	3	localObject	Object
      //   42	1	4	localClassCastException1	ClassCastException
      //   55	1	5	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   11	14	42	java/lang/ClassCastException
      //   20	23	55	java/lang/ClassCastException
    }
    
    /* Error */
    Object lambda34(Object c, Object i)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 76	gnu/kawa/slib/srfi13$frame3:cset	Ljava/lang/Object;
      //   4: ldc 78
      //   6: invokestatic 81	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   9: dup
      //   10: astore_3
      //   11: checkcast 78	gnu/kawa/slib/srfi14$CharSet
      //   14: aload_1
      //   15: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   18: dup
      //   19: astore_3
      //   20: invokestatic 56	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   23: invokestatic 89	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
      //   26: ifeq +7 -> 33
      //   29: aload_2
      //   30: goto +39 -> 69
      //   33: aload_0
      //   34: getfield 92	gnu/kawa/slib/srfi13$frame3:ans	Lgnu/lists/FString;
      //   37: aload_2
      //   38: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   41: dup
      //   42: astore_3
      //   43: checkcast 36	java/lang/Number
      //   46: invokevirtual 40	java/lang/Number:intValue	()I
      //   49: aload_1
      //   50: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   53: dup
      //   54: astore_3
      //   55: invokestatic 56	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   58: invokestatic 62	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
      //   61: iconst_1
      //   62: aload_2
      //   63: getstatic 68	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   66: invokestatic 73	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   69: areturn
      //   70: new 44	gnu/mapping/WrongType
      //   73: dup_x1
      //   74: swap
      //   75: ldc 83
      //   77: iconst_0
      //   78: aload_3
      //   79: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   82: athrow
      //   83: new 44	gnu/mapping/WrongType
      //   86: dup_x1
      //   87: swap
      //   88: ldc 83
      //   90: iconst_1
      //   91: aload_3
      //   92: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   95: athrow
      //   96: new 44	gnu/mapping/WrongType
      //   99: dup_x1
      //   100: swap
      //   101: ldc 46
      //   103: iconst_2
      //   104: aload_3
      //   105: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   108: athrow
      //   109: new 44	gnu/mapping/WrongType
      //   112: dup_x1
      //   113: swap
      //   114: ldc 46
      //   116: iconst_3
      //   117: aload_3
      //   118: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   121: athrow
      // Line number table:
      //   Java source line #1153	-> byte code offset #0
      //   Java source line #1155	-> byte code offset #33
      //   Java source line #1156	-> byte code offset #61
      //   Java source line #1153	-> byte code offset #70
      //   Java source line #1155	-> byte code offset #96
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	70	0	this	frame3
      //   0	69	1	c	Object
      //   0	69	2	i	Object
      //   10	108	3	localObject	Object
      //   70	1	4	localClassCastException1	ClassCastException
      //   83	1	5	localClassCastException2	ClassCastException
      //   96	1	6	localClassCastException3	ClassCastException
      //   109	1	7	localClassCastException4	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   11	14	70	java/lang/ClassCastException
      //   20	23	83	java/lang/ClassCastException
      //   43	49	96	java/lang/ClassCastException
      //   55	58	109	java/lang/ClassCastException
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (selector) {case 7:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      case 6: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      case 5: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { switch (selector) {case 5:  return lambda32(paramObject1, paramObject2);
      







      case 6: 
        return lambda33(paramObject1, paramObject2);
      


      case 7: 
        return lambda34(paramObject1, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
  }
  
  public class frame4
    extends ModuleBody
  {
    FString ans;
    Object cset;
    FString temp;
    Object criterion;
    final ModuleMethod lambda$Fn35;
    final ModuleMethod lambda$Fn36;
    final ModuleMethod lambda$Fn37;
    
    public frame4()
    {
      void tmp19_16 = new ModuleMethod(this, 8, null, 8194);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1165");
      lambda$Fn35 = tmp19_16;
      void tmp45_42 = new ModuleMethod(this, 9, null, 8194);
      tmp45_42.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1177");
      lambda$Fn36 = tmp45_42;
      void tmp71_68 = new ModuleMethod(this, 10, null, 8194);
      tmp71_68.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1182");
      lambda$Fn37 = tmp71_68;
    }
    
    /* Error */
    Object lambda35(Object c, Object i)
    {
      // Byte code:
      //   0: getstatic 6	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: aload_0
      //   4: getfield 12	gnu/kawa/slib/srfi13$frame4:criterion	Ljava/lang/Object;
      //   7: aload_1
      //   8: invokevirtual 18	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   11: invokestatic 24	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   14: ifeq +42 -> 56
      //   17: aload_0
      //   18: getfield 28	gnu/kawa/slib/srfi13$frame4:temp	Lgnu/lists/FString;
      //   21: aload_2
      //   22: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   25: dup
      //   26: astore_3
      //   27: checkcast 36	java/lang/Number
      //   30: invokevirtual 40	java/lang/Number:intValue	()I
      //   33: aload_1
      //   34: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   37: dup
      //   38: astore_3
      //   39: invokestatic 56	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   42: invokestatic 62	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
      //   45: iconst_1
      //   46: aload_2
      //   47: getstatic 68	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   50: invokestatic 73	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   53: goto +4 -> 57
      //   56: aload_2
      //   57: areturn
      //   58: new 44	gnu/mapping/WrongType
      //   61: dup_x1
      //   62: swap
      //   63: ldc 46
      //   65: iconst_2
      //   66: aload_3
      //   67: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   70: athrow
      //   71: new 44	gnu/mapping/WrongType
      //   74: dup_x1
      //   75: swap
      //   76: ldc 46
      //   78: iconst_3
      //   79: aload_3
      //   80: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   83: athrow
      // Line number table:
      //   Java source line #1165	-> byte code offset #0
      //   Java source line #1166	-> byte code offset #0
      //   Java source line #1167	-> byte code offset #17
      //   Java source line #1168	-> byte code offset #45
      //   Java source line #1166	-> byte code offset #56
      //   Java source line #1167	-> byte code offset #58
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	frame4
      //   0	57	1	c	Object
      //   0	57	2	i	Object
      //   26	54	3	localObject	Object
      //   58	1	4	localClassCastException1	ClassCastException
      //   71	1	5	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   27	33	58	java/lang/ClassCastException
      //   39	42	71	java/lang/ClassCastException
    }
    
    /* Error */
    Object lambda36(Object c, Object i)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 76	gnu/kawa/slib/srfi13$frame4:cset	Ljava/lang/Object;
      //   4: ldc 78
      //   6: invokestatic 81	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   9: dup
      //   10: astore_3
      //   11: checkcast 78	gnu/kawa/slib/srfi14$CharSet
      //   14: aload_1
      //   15: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   18: dup
      //   19: astore_3
      //   20: invokestatic 56	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   23: invokestatic 89	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
      //   26: ifeq +14 -> 40
      //   29: iconst_1
      //   30: aload_2
      //   31: getstatic 68	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   34: invokestatic 73	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   37: goto +4 -> 41
      //   40: aload_2
      //   41: areturn
      //   42: new 44	gnu/mapping/WrongType
      //   45: dup_x1
      //   46: swap
      //   47: ldc 83
      //   49: iconst_0
      //   50: aload_3
      //   51: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   54: athrow
      //   55: new 44	gnu/mapping/WrongType
      //   58: dup_x1
      //   59: swap
      //   60: ldc 83
      //   62: iconst_1
      //   63: aload_3
      //   64: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   67: athrow
      // Line number table:
      //   Java source line #1177	-> byte code offset #0
      //   Java source line #1178	-> byte code offset #29
      //   Java source line #1177	-> byte code offset #40
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	42	0	this	frame4
      //   0	41	1	c	Object
      //   0	41	2	i	Object
      //   10	54	3	localObject	Object
      //   42	1	4	localClassCastException1	ClassCastException
      //   55	1	5	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   11	14	42	java/lang/ClassCastException
      //   20	23	55	java/lang/ClassCastException
    }
    
    /* Error */
    Object lambda37(Object c, Object i)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 76	gnu/kawa/slib/srfi13$frame4:cset	Ljava/lang/Object;
      //   4: ldc 78
      //   6: invokestatic 81	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   9: dup
      //   10: astore_3
      //   11: checkcast 78	gnu/kawa/slib/srfi14$CharSet
      //   14: aload_1
      //   15: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   18: dup
      //   19: astore_3
      //   20: invokestatic 56	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   23: invokestatic 89	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
      //   26: ifeq +42 -> 68
      //   29: aload_0
      //   30: getfield 92	gnu/kawa/slib/srfi13$frame4:ans	Lgnu/lists/FString;
      //   33: aload_2
      //   34: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   37: dup
      //   38: astore_3
      //   39: checkcast 36	java/lang/Number
      //   42: invokevirtual 40	java/lang/Number:intValue	()I
      //   45: aload_1
      //   46: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   49: dup
      //   50: astore_3
      //   51: invokestatic 56	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   54: invokestatic 62	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
      //   57: iconst_1
      //   58: aload_2
      //   59: getstatic 68	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   62: invokestatic 73	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   65: goto +4 -> 69
      //   68: aload_2
      //   69: areturn
      //   70: new 44	gnu/mapping/WrongType
      //   73: dup_x1
      //   74: swap
      //   75: ldc 83
      //   77: iconst_0
      //   78: aload_3
      //   79: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   82: athrow
      //   83: new 44	gnu/mapping/WrongType
      //   86: dup_x1
      //   87: swap
      //   88: ldc 83
      //   90: iconst_1
      //   91: aload_3
      //   92: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   95: athrow
      //   96: new 44	gnu/mapping/WrongType
      //   99: dup_x1
      //   100: swap
      //   101: ldc 46
      //   103: iconst_2
      //   104: aload_3
      //   105: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   108: athrow
      //   109: new 44	gnu/mapping/WrongType
      //   112: dup_x1
      //   113: swap
      //   114: ldc 46
      //   116: iconst_3
      //   117: aload_3
      //   118: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   121: athrow
      // Line number table:
      //   Java source line #1182	-> byte code offset #0
      //   Java source line #1183	-> byte code offset #29
      //   Java source line #1184	-> byte code offset #57
      //   Java source line #1182	-> byte code offset #68
      //   Java source line #1183	-> byte code offset #96
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	70	0	this	frame4
      //   0	69	1	c	Object
      //   0	69	2	i	Object
      //   10	108	3	localObject	Object
      //   70	1	4	localClassCastException1	ClassCastException
      //   83	1	5	localClassCastException2	ClassCastException
      //   96	1	6	localClassCastException3	ClassCastException
      //   109	1	7	localClassCastException4	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   11	14	70	java/lang/ClassCastException
      //   20	23	83	java/lang/ClassCastException
      //   39	45	96	java/lang/ClassCastException
      //   51	54	109	java/lang/ClassCastException
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (selector) {case 10:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      case 9: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      case 8: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { switch (selector) {case 8:  return lambda35(paramObject1, paramObject2);
      









      case 9: 
        return lambda36(paramObject1, paramObject2);
      


      case 10: 
        return lambda37(paramObject1, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
  }
  



























































































































































































  public static Object stringContains$V(Object text, Object pattern, Object[] argsArray)
  {
    LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mncontains, text, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object t$Mnend = Values.getFromPosFinal(localObject1, i);
    Object t$Mnstart;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mncontains, 
      pattern, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object p$Mnend = Values.getFromPosFinal(localValues, j);
    Object p$Mnstart;
    return $PcKmpSearch(pattern, text, strings.char$Eq$Qu, p$Mnstart, p$Mnend, t$Mnstart, t$Mnend); }
  
  public static Object stringContainsCi$V(Object text, Object pattern, Object[] argsArray) { LList maybe$Mnstarts$Plends = localObject1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = stringParseStart$PlEnd(string$Mncontains$Mnci, text, maybe$Mnstarts$Plends);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object localObject3 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object t$Mnend = Values.getFromPosFinal(localObject1, i);
    Object t$Mnstart;
    Object rest;
    Values localValues = stringParseFinalStart$PlEnd(string$Mncontains$Mnci, 
      pattern, rest);int j = 0;j = Values.incrPos(localValues, j);Object localObject4 = Values.getFromPos(localValues, j);j = Values.incrPos(localValues, j);Object p$Mnend = Values.getFromPosFinal(localValues, j);
    Object p$Mnstart;
    return $PcKmpSearch(pattern, text, strings.char$Mnci$Eq$Qu, p$Mnstart, p$Mnend, t$Mnstart, t$Mnend);
  }
  













































  public class frame5
    extends ModuleBody
  {
    int patlen;
    












































    final ModuleMethod lambda$Fn38;
    












































    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 11) return lambda38(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 11) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda38(Object i) { return numbers.isInteger(i) ? false : numbers.isExact(i) ? false : NumberCompare.$Ls$Eq(srfi13.Lit0, i) ? NumberCompare.$Ls(i, Integer.valueOf(patlen)) : false; }
    








    public frame5()
    {
      void tmp19_16 = new ModuleMethod(this, 11, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1528");
      lambda$Fn38 = tmp19_16;
    }
  }
  







  public static boolean isStringNull(Object s)
  {
    try
    {
      return numbers.isZero(Integer.valueOf(strings.stringLength((CharSequence)(localObject = Promise.force(s, CharSequence.class))))); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "string-length", 1, localObject);
    }
  }
  



























  public static Object stringAppend$SlShared$V(Object[] argsArray)
  {
    LList localLList1;
    


























    LList strings = localLList1 = LList.makeList(argsArray, 0);return stringConcatenate$SlShared(strings);
  }
  
























































  public class frame6
    extends ModuleBody
  {
    Object from;
    























































    final ModuleMethod lambda$Fn40;
    
























































    static boolean lambda39(Object val)
    {
      return numbers.isInteger(val) ? numbers.isExact(val) : false;
    }
    

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (selector == 12) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 12) return lambda40(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); }
    
    boolean lambda40(Object val) { return numbers.isInteger(val) ? false : numbers.isExact(val) ? NumberCompare.$Ls$Eq(from, val) : false; }
    






    public frame6()
    {
      void tmp19_16 = new ModuleMethod(this, 12, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1801");
      lambda$Fn40 = tmp19_16;
    }
    






    public void apply(CallContext paramCallContext)
    {
      ModuleMethod.applyError();
    }
  }
  






  static boolean lambda41(Object val)
  {
    return numbers.isInteger(val) ? numbers.isExact(val) : false;
  }
  

  static boolean lambda42(Object val)
  {
    return numbers.isInteger(val) ? numbers.isExact(val) : false;
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return isCharCased(Char.castToCharacter(Promise.force(paramObject))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException) { throw new WrongType(
      























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        localClassCastException, "char-cased?", 1, paramObject);
    }
    return lambda1(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    



























































































































































    return lambda2(paramObject);return lambda3(paramObject);
    











































    return lambda4(paramObject);return lambda5(paramObject);
    


















































































































    return lambda6(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    



























































































































































































































    return lambda7(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    return lambda8(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    







    return lambda9(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    









    return lambda10(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    return lambda11(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    







    return lambda12(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    return lambda13(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    










    return lambda14(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    







    return lambda15(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    








    return lambda16(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    return lambda17(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    







    return lambda18(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    









    return lambda19(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    return lambda20(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    







    return lambda21(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    return lambda22(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    










    return lambda23(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    







    return lambda24(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    














































    return Integer.valueOf(lambda25(paramObject));
    



























































































































    return lambda30(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    










    return lambda31(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    





























































































































































































































































































































































































































































    return isStringNull(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    




















    return reverseList$To$String(paramObject);
    







































    return stringConcatenate$SlShared(paramObject);
    




























    return stringConcatenate(paramObject);
    

















































































































































    return frame6.lambda39(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    







































    return lambda41(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    




    return lambda42(paramObject) ? Boolean.TRUE : Boolean.FALSE;return lambda45(paramObject);return super.apply1(paramModuleMethod, paramObject);
  }
  
  /* Error */
  public static Object stringParseStart$PlEnd(Object proc, Object s, Object args)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 25	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   4: ifne +27 -> 31
    //   7: iconst_3
    //   8: anewarray 27	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: ldc 29
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_0
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: aload_1
    //   23: aastore
    //   24: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   27: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   30: athrow
    //   31: aload_1
    //   32: ldc 43
    //   34: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 4
    //   40: checkcast 43	java/lang/CharSequence
    //   43: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   46: istore_3
    //   47: aload_2
    //   48: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   51: ifeq +323 -> 374
    //   54: aload_2
    //   55: ldc 70
    //   57: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   60: dup
    //   61: astore 5
    //   63: checkcast 70	gnu/lists/Pair
    //   66: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   69: astore 4
    //   71: aload_2
    //   72: ldc 70
    //   74: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   77: dup
    //   78: astore 6
    //   80: checkcast 70	gnu/lists/Pair
    //   83: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   86: astore 5
    //   88: aload 4
    //   90: invokestatic 84	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   93: ifeq +252 -> 345
    //   96: aload 4
    //   98: invokestatic 87	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   101: ifeq +244 -> 345
    //   104: aload 4
    //   106: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   109: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   112: ifeq +233 -> 345
    //   115: aload 5
    //   117: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   120: ifeq +106 -> 226
    //   123: aload 5
    //   125: ldc 70
    //   127: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   130: dup
    //   131: astore 8
    //   133: checkcast 70	gnu/lists/Pair
    //   136: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   139: astore 7
    //   141: aload 5
    //   143: ldc 70
    //   145: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   148: dup
    //   149: astore 9
    //   151: checkcast 70	gnu/lists/Pair
    //   154: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   157: astore 8
    //   159: aload 7
    //   161: invokestatic 84	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   164: ifeq +33 -> 197
    //   167: aload 7
    //   169: invokestatic 87	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   172: ifeq +25 -> 197
    //   175: aload 7
    //   177: iload_3
    //   178: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   184: ifeq +13 -> 197
    //   187: aload 7
    //   189: aload 8
    //   191: invokestatic 114	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   194: goto +41 -> 235
    //   197: iconst_4
    //   198: anewarray 27	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: ldc 116
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_0
    //   209: aastore
    //   210: dup
    //   211: iconst_2
    //   212: aload 7
    //   214: aastore
    //   215: dup
    //   216: iconst_3
    //   217: aload_1
    //   218: aastore
    //   219: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   222: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   225: athrow
    //   226: iload_3
    //   227: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aload 5
    //   232: invokestatic 114	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   235: astore 6
    //   237: iconst_0
    //   238: istore 7
    //   240: aload 6
    //   242: iload 7
    //   244: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   247: istore 7
    //   249: aload 6
    //   251: iload 7
    //   253: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   256: astore 8
    //   258: aload 6
    //   260: iload 7
    //   262: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   265: istore 7
    //   267: aload 6
    //   269: iload 7
    //   271: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   274: astore 9
    //   276: aload 4
    //   278: aload 8
    //   280: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   283: ifeq +28 -> 311
    //   286: iconst_3
    //   287: anewarray 27	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload 9
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: aload 4
    //   299: aastore
    //   300: dup
    //   301: iconst_2
    //   302: aload 8
    //   304: aastore
    //   305: invokestatic 131	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   308: goto +92 -> 400
    //   311: iconst_5
    //   312: anewarray 27	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: ldc -123
    //   319: aastore
    //   320: dup
    //   321: iconst_1
    //   322: aload_0
    //   323: aastore
    //   324: dup
    //   325: iconst_2
    //   326: aload 4
    //   328: aastore
    //   329: dup
    //   330: iconst_3
    //   331: aload 8
    //   333: aastore
    //   334: dup
    //   335: iconst_4
    //   336: aload_1
    //   337: aastore
    //   338: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   341: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   344: athrow
    //   345: iconst_4
    //   346: anewarray 27	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: ldc -121
    //   353: aastore
    //   354: dup
    //   355: iconst_1
    //   356: aload_0
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: aload 4
    //   362: aastore
    //   363: dup
    //   364: iconst_3
    //   365: aload_1
    //   366: aastore
    //   367: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   370: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   373: athrow
    //   374: iconst_3
    //   375: anewarray 27	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: getstatic 141	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   383: aastore
    //   384: dup
    //   385: iconst_1
    //   386: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   389: aastore
    //   390: dup
    //   391: iconst_2
    //   392: iload_3
    //   393: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: aastore
    //   397: invokestatic 131	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   400: areturn
    //   401: new 53	gnu/mapping/WrongType
    //   404: dup_x1
    //   405: swap
    //   406: ldc 55
    //   408: iconst_1
    //   409: aload 4
    //   411: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   414: athrow
    //   415: new 53	gnu/mapping/WrongType
    //   418: dup_x1
    //   419: swap
    //   420: ldc 72
    //   422: iconst_1
    //   423: aload 5
    //   425: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   428: athrow
    //   429: new 53	gnu/mapping/WrongType
    //   432: dup_x1
    //   433: swap
    //   434: ldc 77
    //   436: iconst_1
    //   437: aload 6
    //   439: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   442: athrow
    //   443: new 53	gnu/mapping/WrongType
    //   446: dup_x1
    //   447: swap
    //   448: ldc 72
    //   450: iconst_1
    //   451: aload 8
    //   453: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   456: athrow
    //   457: new 53	gnu/mapping/WrongType
    //   460: dup_x1
    //   461: swap
    //   462: ldc 77
    //   464: iconst_1
    //   465: aload 9
    //   467: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   470: athrow
    // Line number table:
    //   Java source line #184	-> byte code offset #0
    //   Java source line #185	-> byte code offset #0
    //   Java source line #186	-> byte code offset #31
    //   Java source line #187	-> byte code offset #47
    //   Java source line #189	-> byte code offset #54
    //   Java source line #190	-> byte code offset #71
    //   Java source line #191	-> byte code offset #88
    //   Java source line #193	-> byte code offset #115
    //   Java source line #194	-> byte code offset #123
    //   Java source line #195	-> byte code offset #141
    //   Java source line #196	-> byte code offset #159
    //   Java source line #197	-> byte code offset #187
    //   Java source line #198	-> byte code offset #197
    //   Java source line #199	-> byte code offset #226
    //   Java source line #200	-> byte code offset #276
    //   Java source line #201	-> byte code offset #311
    //   Java source line #203	-> byte code offset #345
    //   Java source line #205	-> byte code offset #374
    //   Java source line #186	-> byte code offset #401
    //   Java source line #189	-> byte code offset #415
    //   Java source line #190	-> byte code offset #429
    //   Java source line #194	-> byte code offset #443
    //   Java source line #195	-> byte code offset #457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	proc	Object
    //   0	400	1	s	Object
    //   0	400	2	args	Object
    //   46	347	3	slen	int
    //   38	32	4	localObject1	Object
    //   88	322	4	start	Object
    //   61	1	5	localObject2	Object
    //   86	338	5	args	Object
    //   78	360	6	localObject3	Object
    //   139	1	7	localObject4	Object
    //   159	111	7	end	Object
    //   238	32	7	i	int
    //   131	1	8	localObject5	Object
    //   157	100	8	args	Object
    //   276	176	8	end	Object
    //   149	1	9	localObject6	Object
    //   274	192	9	args	Object
    //   401	1	17	localClassCastException1	ClassCastException
    //   415	1	18	localClassCastException2	ClassCastException
    //   429	1	19	localClassCastException3	ClassCastException
    //   443	1	20	localClassCastException4	ClassCastException
    //   457	1	21	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   40	43	401	java/lang/ClassCastException
    //   63	66	415	java/lang/ClassCastException
    //   80	83	429	java/lang/ClassCastException
    //   133	136	443	java/lang/ClassCastException
    //   151	154	457	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object substring$SlShared$V(Object s, Object start, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 161	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: getstatic 164	gnu/kawa/slib/srfi13:substring$Slshared	Lgnu/expr/ModuleMethod;
    //   16: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   19: pop
    //   20: aload_0
    //   21: ldc 43
    //   23: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   26: dup
    //   27: astore 5
    //   29: checkcast 43	java/lang/CharSequence
    //   32: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   35: istore 4
    //   37: getstatic 170	gnu/kawa/slib/srfi13:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   40: aload_1
    //   41: getstatic 164	gnu/kawa/slib/srfi13:substring$Slshared	Lgnu/expr/ModuleMethod;
    //   44: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload_0
    //   49: ldc 43
    //   51: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: dup
    //   55: astore 5
    //   57: checkcast 43	java/lang/CharSequence
    //   60: aload_1
    //   61: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: dup
    //   65: astore 5
    //   67: checkcast 177	java/lang/Number
    //   70: invokevirtual 181	java/lang/Number:intValue	()I
    //   73: aload_3
    //   74: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   77: ifeq +8 -> 85
    //   80: iload 4
    //   82: goto +72 -> 154
    //   85: aload_3
    //   86: dup
    //   87: astore 6
    //   89: checkcast 70	gnu/lists/Pair
    //   92: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   95: astore 5
    //   97: aload 5
    //   99: invokestatic 84	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   102: ifeq +50 -> 152
    //   105: aload 5
    //   107: invokestatic 87	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   110: ifeq +42 -> 152
    //   113: aload_1
    //   114: aload 5
    //   116: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   119: ifeq +33 -> 152
    //   122: aload 5
    //   124: iload 4
    //   126: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   132: ifeq +20 -> 152
    //   135: aload 5
    //   137: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: dup
    //   141: astore 6
    //   143: checkcast 177	java/lang/Number
    //   146: invokevirtual 181	java/lang/Number:intValue	()I
    //   149: goto +5 -> 154
    //   152: iload 4
    //   154: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   157: areturn
    //   158: new 53	gnu/mapping/WrongType
    //   161: dup_x1
    //   162: swap
    //   163: ldc 55
    //   165: iconst_1
    //   166: aload 5
    //   168: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: new 53	gnu/mapping/WrongType
    //   175: dup_x1
    //   176: swap
    //   177: ldc -84
    //   179: iconst_0
    //   180: aload 5
    //   182: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   185: athrow
    //   186: new 53	gnu/mapping/WrongType
    //   189: dup_x1
    //   190: swap
    //   191: ldc -84
    //   193: iconst_1
    //   194: aload 5
    //   196: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   199: athrow
    //   200: new 53	gnu/mapping/WrongType
    //   203: dup_x1
    //   204: swap
    //   205: ldc 72
    //   207: iconst_1
    //   208: aload 6
    //   210: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   213: athrow
    //   214: new 53	gnu/mapping/WrongType
    //   217: dup_x1
    //   218: swap
    //   219: ldc -84
    //   221: iconst_2
    //   222: aload 6
    //   224: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   227: athrow
    // Line number table:
    //   Java source line #263	-> byte code offset #0
    //   Java source line #264	-> byte code offset #9
    //   Java source line #265	-> byte code offset #20
    //   Java source line #266	-> byte code offset #37
    //   Java source line #267	-> byte code offset #40
    //   Java source line #268	-> byte code offset #48
    //   Java source line #269	-> byte code offset #73
    //   Java source line #129	-> byte code offset #97
    //   Java source line #270	-> byte code offset #97
    //   Java source line #272	-> byte code offset #113
    //   Java source line #273	-> byte code offset #122
    //   Java source line #269	-> byte code offset #135
    //   Java source line #265	-> byte code offset #158
    //   Java source line #268	-> byte code offset #172
    //   Java source line #269	-> byte code offset #200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	s	Object
    //   0	157	1	start	Object
    //   0	157	2	argsArray	Object[]
    //   0	86	3	maybe$Mnend	LList
    //   6	1	4	localLList1	LList
    //   35	118	4	slen	int
    //   27	39	5	localObject1	Object
    //   95	100	5	x	Object
    //   87	136	6	localObject2	Object
    //   158	1	9	localClassCastException1	ClassCastException
    //   172	1	10	localClassCastException2	ClassCastException
    //   186	1	11	localClassCastException3	ClassCastException
    //   200	1	12	localClassCastException4	ClassCastException
    //   214	1	13	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   29	32	158	java/lang/ClassCastException
    //   57	60	172	java/lang/ClassCastException
    //   67	73	186	java/lang/ClassCastException
    //   89	92	200	java/lang/ClassCastException
    //   143	149	214	java/lang/ClassCastException
  }
  
  /* Error */
  public static FString $PcStringMap(Object proc, Object s, Object start, Object end)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_3
    //   2: aload_2
    //   3: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: astore 4
    //   8: aload 4
    //   10: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: dup
    //   14: astore 6
    //   16: checkcast 177	java/lang/Number
    //   19: invokevirtual 181	java/lang/Number:intValue	()I
    //   22: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   25: astore 5
    //   27: iconst_m1
    //   28: aload_3
    //   29: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   32: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: iconst_m1
    //   36: aload 4
    //   38: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   41: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore 7
    //   46: astore 6
    //   48: aload 7
    //   50: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   53: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   56: ifne +91 -> 147
    //   59: aload 5
    //   61: aload 7
    //   63: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: dup
    //   67: astore 8
    //   69: checkcast 177	java/lang/Number
    //   72: invokevirtual 181	java/lang/Number:intValue	()I
    //   75: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   78: aload_0
    //   79: aload_1
    //   80: ldc 43
    //   82: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   85: dup
    //   86: astore 8
    //   88: checkcast 43	java/lang/CharSequence
    //   91: aload 6
    //   93: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: dup
    //   97: astore 8
    //   99: checkcast 177	java/lang/Number
    //   102: invokevirtual 181	java/lang/Number:intValue	()I
    //   105: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   108: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   111: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: dup
    //   118: astore 8
    //   120: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   123: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   126: iconst_m1
    //   127: aload 6
    //   129: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   132: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: iconst_m1
    //   136: aload 7
    //   138: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   141: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: goto -100 -> 44
    //   147: aload 5
    //   149: areturn
    //   150: new 53	gnu/mapping/WrongType
    //   153: dup_x1
    //   154: swap
    //   155: ldc -36
    //   157: iconst_1
    //   158: aload 6
    //   160: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   163: athrow
    //   164: new 53	gnu/mapping/WrongType
    //   167: dup_x1
    //   168: swap
    //   169: ldc -24
    //   171: iconst_2
    //   172: aload 8
    //   174: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   177: athrow
    //   178: new 53	gnu/mapping/WrongType
    //   181: dup_x1
    //   182: swap
    //   183: ldc -16
    //   185: iconst_1
    //   186: aload 8
    //   188: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   191: athrow
    //   192: new 53	gnu/mapping/WrongType
    //   195: dup_x1
    //   196: swap
    //   197: ldc -16
    //   199: iconst_2
    //   200: aload 8
    //   202: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   205: athrow
    //   206: new 53	gnu/mapping/WrongType
    //   209: dup_x1
    //   210: swap
    //   211: ldc -24
    //   213: iconst_3
    //   214: aload 8
    //   216: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   219: athrow
    // Line number table:
    //   Java source line #321	-> byte code offset #0
    //   Java source line #322	-> byte code offset #0
    //   Java source line #323	-> byte code offset #8
    //   Java source line #324	-> byte code offset #27
    //   Java source line #325	-> byte code offset #35
    //   Java source line #324	-> byte code offset #48
    //   Java source line #326	-> byte code offset #48
    //   Java source line #327	-> byte code offset #59
    //   Java source line #324	-> byte code offset #126
    //   Java source line #325	-> byte code offset #135
    //   Java source line #328	-> byte code offset #147
    //   Java source line #323	-> byte code offset #150
    //   Java source line #327	-> byte code offset #164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	proc	Object
    //   0	149	1	s	Object
    //   0	149	2	start	Object
    //   0	149	3	end	Object
    //   6	31	4	len	Object
    //   25	123	5	ans	FString
    //   14	1	6	localObject1	Object
    //   46	113	6	i	Object
    //   44	1	7	localObject2	Object
    //   48	89	7	j	Object
    //   67	148	8	localObject3	Object
    //   150	1	11	localClassCastException1	ClassCastException
    //   164	1	12	localClassCastException2	ClassCastException
    //   178	1	13	localClassCastException3	ClassCastException
    //   192	1	14	localClassCastException4	ClassCastException
    //   206	1	15	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   16	22	150	java/lang/ClassCastException
    //   69	75	164	java/lang/ClassCastException
    //   88	91	178	java/lang/ClassCastException
    //   99	105	192	java/lang/ClassCastException
    //   120	123	206	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcStringMap$Ex(Object proc, Object s, Object start, Object end)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_3
    //   2: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   5: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: aload_2
    //   13: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   16: ifne +93 -> 109
    //   19: aload_1
    //   20: ldc_w 272
    //   23: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   26: dup
    //   27: astore 5
    //   29: checkcast 272	gnu/lists/CharSeq
    //   32: aload 4
    //   34: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 5
    //   40: checkcast 177	java/lang/Number
    //   43: invokevirtual 181	java/lang/Number:intValue	()I
    //   46: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   49: aload_0
    //   50: aload_1
    //   51: ldc 43
    //   53: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   56: dup
    //   57: astore 5
    //   59: checkcast 43	java/lang/CharSequence
    //   62: aload 4
    //   64: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: dup
    //   68: astore 5
    //   70: checkcast 177	java/lang/Number
    //   73: invokevirtual 181	java/lang/Number:intValue	()I
    //   76: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   79: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   82: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: dup
    //   89: astore 5
    //   91: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   94: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   97: iconst_m1
    //   98: aload 4
    //   100: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   103: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: goto -98 -> 8
    //   109: getstatic 276	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   112: areturn
    //   113: new 53	gnu/mapping/WrongType
    //   116: dup_x1
    //   117: swap
    //   118: ldc -24
    //   120: iconst_1
    //   121: aload 5
    //   123: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    //   127: new 53	gnu/mapping/WrongType
    //   130: dup_x1
    //   131: swap
    //   132: ldc -24
    //   134: iconst_2
    //   135: aload 5
    //   137: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   140: athrow
    //   141: new 53	gnu/mapping/WrongType
    //   144: dup_x1
    //   145: swap
    //   146: ldc -16
    //   148: iconst_1
    //   149: aload 5
    //   151: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   154: athrow
    //   155: new 53	gnu/mapping/WrongType
    //   158: dup_x1
    //   159: swap
    //   160: ldc -16
    //   162: iconst_2
    //   163: aload 5
    //   165: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    //   169: new 53	gnu/mapping/WrongType
    //   172: dup_x1
    //   173: swap
    //   174: ldc -24
    //   176: iconst_3
    //   177: aload 5
    //   179: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    // Line number table:
    //   Java source line #335	-> byte code offset #0
    //   Java source line #336	-> byte code offset #0
    //   Java source line #337	-> byte code offset #10
    //   Java source line #338	-> byte code offset #19
    //   Java source line #336	-> byte code offset #97
    //   Java source line #338	-> byte code offset #113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	proc	Object
    //   0	112	1	s	Object
    //   0	112	2	start	Object
    //   0	112	3	end	Object
    //   8	91	4	i	Object
    //   27	151	5	localObject1	Object
    //   113	1	6	localClassCastException1	ClassCastException
    //   127	1	7	localClassCastException2	ClassCastException
    //   141	1	8	localClassCastException3	ClassCastException
    //   155	1	9	localClassCastException4	ClassCastException
    //   169	1	10	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   29	32	113	java/lang/ClassCastException
    //   40	46	127	java/lang/ClassCastException
    //   59	62	141	java/lang/ClassCastException
    //   70	76	155	java/lang/ClassCastException
    //   91	94	169	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringUnfold$V(Object p, Object f, Object g, Object seed, Object[] argsArray)
  {
    // Byte code:
    //   0: aload 4
    //   2: iconst_0
    //   3: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   6: dup
    //   7: astore 6
    //   9: astore 5
    //   11: getstatic 201	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   14: aload_0
    //   15: getstatic 288	gnu/kawa/slib/srfi13:string$Mnunfold	Lgnu/expr/ModuleMethod;
    //   18: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: getstatic 201	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   25: aload_1
    //   26: getstatic 288	gnu/kawa/slib/srfi13:string$Mnunfold	Lgnu/expr/ModuleMethod;
    //   29: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: getstatic 201	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   36: aload_2
    //   37: getstatic 288	gnu/kawa/slib/srfi13:string$Mnunfold	Lgnu/expr/ModuleMethod;
    //   40: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload 5
    //   46: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   49: ifne +17 -> 66
    //   52: aload 5
    //   54: dup
    //   55: astore 7
    //   57: checkcast 70	gnu/lists/Pair
    //   60: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   63: goto +6 -> 69
    //   66: ldc_w 290
    //   69: astore 6
    //   71: aload 6
    //   73: invokestatic 25	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   76: ifne +8 -> 84
    //   79: ldc_w 290
    //   82: astore 6
    //   84: aload 5
    //   86: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   89: ifne +17 -> 106
    //   92: aload 5
    //   94: dup
    //   95: astore 8
    //   97: checkcast 70	gnu/lists/Pair
    //   100: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   103: goto +5 -> 108
    //   106: aload 5
    //   108: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   111: ifne +50 -> 161
    //   114: aload 5
    //   116: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   119: ifne +28 -> 147
    //   122: aload 5
    //   124: dup
    //   125: astore 8
    //   127: checkcast 70	gnu/lists/Pair
    //   130: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   133: ldc 70
    //   135: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   138: dup
    //   139: astore 8
    //   141: checkcast 70	gnu/lists/Pair
    //   144: goto +11 -> 155
    //   147: aload 5
    //   149: dup
    //   150: astore 8
    //   152: checkcast 70	gnu/lists/Pair
    //   155: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   158: goto +6 -> 164
    //   161: getstatic 293	gnu/kawa/slib/srfi13:lambda$Fn2	Lgnu/expr/ModuleMethod;
    //   164: astore 7
    //   166: aload 7
    //   168: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   171: ifne +8 -> 179
    //   174: getstatic 299	gnu/kawa/slib/srfi13:lambda$Fn3	Lgnu/expr/ModuleMethod;
    //   177: astore 7
    //   179: aload 5
    //   181: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   184: ifne +17 -> 201
    //   187: aload 5
    //   189: dup
    //   190: astore 8
    //   192: checkcast 70	gnu/lists/Pair
    //   195: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   198: goto +5 -> 203
    //   201: aload 5
    //   203: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   206: ifne +50 -> 256
    //   209: aload 5
    //   211: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   214: ifne +28 -> 242
    //   217: aload 5
    //   219: dup
    //   220: astore 8
    //   222: checkcast 70	gnu/lists/Pair
    //   225: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   228: ldc 70
    //   230: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   233: dup
    //   234: astore 8
    //   236: checkcast 70	gnu/lists/Pair
    //   239: goto +11 -> 250
    //   242: aload 5
    //   244: dup
    //   245: astore 8
    //   247: checkcast 70	gnu/lists/Pair
    //   250: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   253: goto +27 -> 280
    //   256: aload 5
    //   258: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   261: ifne +17 -> 278
    //   264: aload 5
    //   266: dup
    //   267: astore 8
    //   269: checkcast 70	gnu/lists/Pair
    //   272: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   275: goto +5 -> 280
    //   278: aload 5
    //   280: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   283: ifeq +558 -> 841
    //   286: getstatic 141	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   289: iconst_0
    //   290: bipush 40
    //   292: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   295: bipush 40
    //   297: iconst_0
    //   298: aload_3
    //   299: astore 13
    //   301: istore 12
    //   303: istore 11
    //   305: astore 10
    //   307: istore 9
    //   309: astore 8
    //   311: iload 12
    //   313: invokestatic 304	gnu/math/IntNum:make	(I)Lgnu/math/IntNum;
    //   316: aload 13
    //   318: astore 15
    //   320: astore 14
    //   322: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   325: aload_0
    //   326: aload 15
    //   328: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   331: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   334: ifne +171 -> 505
    //   337: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   340: aload_1
    //   341: aload 15
    //   343: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: astore 16
    //   348: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   351: aload_2
    //   352: aload 15
    //   354: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   357: astore 17
    //   359: aload 14
    //   361: iload 11
    //   363: i2l
    //   364: invokestatic 313	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
    //   367: ifge +50 -> 417
    //   370: aload 10
    //   372: ldc_w 272
    //   375: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   378: dup
    //   379: astore 18
    //   381: checkcast 272	gnu/lists/CharSeq
    //   384: aload 14
    //   386: dup
    //   387: astore 18
    //   389: invokevirtual 181	java/lang/Number:intValue	()I
    //   392: aload 16
    //   394: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   397: dup
    //   398: astore 18
    //   400: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   403: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   406: aload 14
    //   408: iconst_1
    //   409: invokestatic 317	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   412: aload 17
    //   414: goto -96 -> 318
    //   417: iload 11
    //   419: iload 9
    //   421: iadd
    //   422: istore 18
    //   424: iconst_2
    //   425: anewarray 27	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: getstatic 320	gnu/kawa/slib/srfi13:Lit2	Lgnu/math/IntNum;
    //   433: aastore
    //   434: dup
    //   435: iconst_1
    //   436: iload 18
    //   438: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: aastore
    //   442: invokestatic 324	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   445: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   448: dup
    //   449: astore 20
    //   451: checkcast 177	java/lang/Number
    //   454: invokevirtual 181	java/lang/Number:intValue	()I
    //   457: istore 19
    //   459: iload 19
    //   461: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   464: astore 20
    //   466: aload 20
    //   468: iconst_0
    //   469: aload 16
    //   471: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   474: dup
    //   475: astore 21
    //   477: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   480: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   483: aload 10
    //   485: aload 8
    //   487: invokestatic 330	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   490: iload 9
    //   492: iload 11
    //   494: iadd
    //   495: aload 20
    //   497: iload 19
    //   499: iconst_1
    //   500: aload 17
    //   502: goto -203 -> 299
    //   505: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   508: aload 7
    //   510: aload 15
    //   512: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: astore 16
    //   517: aload 16
    //   519: ldc 43
    //   521: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   524: dup
    //   525: astore 18
    //   527: checkcast 43	java/lang/CharSequence
    //   530: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   533: istore 17
    //   535: aload 6
    //   537: ldc 43
    //   539: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   542: dup
    //   543: astore 19
    //   545: checkcast 43	java/lang/CharSequence
    //   548: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   551: istore 18
    //   553: iload 18
    //   555: iload 9
    //   557: iadd
    //   558: aload 14
    //   560: invokevirtual 181	java/lang/Number:intValue	()I
    //   563: iadd
    //   564: istore 19
    //   566: iload 19
    //   568: iload 17
    //   570: iadd
    //   571: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   574: astore 20
    //   576: aload 20
    //   578: ldc_w 332
    //   581: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   584: dup
    //   585: astore 21
    //   587: checkcast 332	gnu/lists/FString
    //   590: iload 19
    //   592: aload 16
    //   594: ldc 43
    //   596: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   599: dup
    //   600: astore 21
    //   602: checkcast 43	java/lang/CharSequence
    //   605: iconst_0
    //   606: iload 17
    //   608: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   611: iload 19
    //   613: aload 14
    //   615: invokevirtual 181	java/lang/Number:intValue	()I
    //   618: isub
    //   619: istore 21
    //   621: aload 20
    //   623: ldc_w 332
    //   626: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   629: dup
    //   630: astore 22
    //   632: checkcast 332	gnu/lists/FString
    //   635: iload 21
    //   637: aload 10
    //   639: ldc 43
    //   641: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   644: dup
    //   645: astore 22
    //   647: checkcast 43	java/lang/CharSequence
    //   650: iconst_0
    //   651: aload 14
    //   653: dup
    //   654: astore 22
    //   656: invokevirtual 181	java/lang/Number:intValue	()I
    //   659: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   662: iload 21
    //   664: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   667: aload 8
    //   669: astore 23
    //   671: astore 22
    //   673: aload 23
    //   675: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   678: ifeq +124 -> 802
    //   681: aload 23
    //   683: ldc 70
    //   685: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   688: dup
    //   689: astore 25
    //   691: checkcast 70	gnu/lists/Pair
    //   694: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   697: astore 24
    //   699: aload 23
    //   701: ldc 70
    //   703: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   706: dup
    //   707: astore 26
    //   709: checkcast 70	gnu/lists/Pair
    //   712: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   715: astore 25
    //   717: aload 24
    //   719: ldc 43
    //   721: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   724: dup
    //   725: astore 27
    //   727: checkcast 43	java/lang/CharSequence
    //   730: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   733: istore 26
    //   735: iconst_m1
    //   736: aload 22
    //   738: iload 26
    //   740: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   743: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   746: astore 27
    //   748: aload 20
    //   750: ldc_w 332
    //   753: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   756: dup
    //   757: astore 28
    //   759: checkcast 332	gnu/lists/FString
    //   762: aload 27
    //   764: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   767: dup
    //   768: astore 28
    //   770: checkcast 177	java/lang/Number
    //   773: invokevirtual 181	java/lang/Number:intValue	()I
    //   776: aload 24
    //   778: ldc 43
    //   780: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   783: dup
    //   784: astore 28
    //   786: checkcast 43	java/lang/CharSequence
    //   789: iconst_0
    //   790: iload 26
    //   792: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   795: aload 27
    //   797: aload 25
    //   799: goto -130 -> 669
    //   802: aload 20
    //   804: ldc_w 332
    //   807: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   810: dup
    //   811: astore 21
    //   813: checkcast 332	gnu/lists/FString
    //   816: iconst_0
    //   817: aload 6
    //   819: ldc 43
    //   821: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   824: dup
    //   825: astore 21
    //   827: checkcast 43	java/lang/CharSequence
    //   830: iconst_0
    //   831: iload 18
    //   833: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   836: aload 20
    //   838: goto +124 -> 962
    //   841: iconst_2
    //   842: anewarray 27	java/lang/Object
    //   845: dup
    //   846: iconst_0
    //   847: ldc_w 340
    //   850: aastore
    //   851: dup
    //   852: iconst_1
    //   853: aload 5
    //   855: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   858: ifne +17 -> 875
    //   861: aload 5
    //   863: dup
    //   864: astore 8
    //   866: checkcast 70	gnu/lists/Pair
    //   869: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   872: goto +5 -> 877
    //   875: aload 5
    //   877: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   880: ifne +50 -> 930
    //   883: aload 5
    //   885: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   888: ifne +28 -> 916
    //   891: aload 5
    //   893: dup
    //   894: astore 8
    //   896: checkcast 70	gnu/lists/Pair
    //   899: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   902: ldc 70
    //   904: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   907: dup
    //   908: astore 8
    //   910: checkcast 70	gnu/lists/Pair
    //   913: goto +11 -> 924
    //   916: aload 5
    //   918: dup
    //   919: astore 8
    //   921: checkcast 70	gnu/lists/Pair
    //   924: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   927: goto +27 -> 954
    //   930: aload 5
    //   932: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   935: ifne +17 -> 952
    //   938: aload 5
    //   940: dup
    //   941: astore 8
    //   943: checkcast 70	gnu/lists/Pair
    //   946: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   949: goto +5 -> 954
    //   952: aload 5
    //   954: aastore
    //   955: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   958: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   961: athrow
    //   962: areturn
    //   963: new 53	gnu/mapping/WrongType
    //   966: dup_x1
    //   967: swap
    //   968: ldc 72
    //   970: iconst_1
    //   971: aload 7
    //   973: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   976: athrow
    //   977: new 53	gnu/mapping/WrongType
    //   980: dup_x1
    //   981: swap
    //   982: ldc 77
    //   984: iconst_1
    //   985: aload 8
    //   987: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   990: athrow
    //   991: new 53	gnu/mapping/WrongType
    //   994: dup_x1
    //   995: swap
    //   996: ldc 77
    //   998: iconst_1
    //   999: aload 8
    //   1001: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1004: athrow
    //   1005: new 53	gnu/mapping/WrongType
    //   1008: dup_x1
    //   1009: swap
    //   1010: ldc 72
    //   1012: iconst_1
    //   1013: aload 8
    //   1015: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1018: athrow
    //   1019: new 53	gnu/mapping/WrongType
    //   1022: dup_x1
    //   1023: swap
    //   1024: ldc 72
    //   1026: iconst_1
    //   1027: aload 8
    //   1029: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1032: athrow
    //   1033: new 53	gnu/mapping/WrongType
    //   1036: dup_x1
    //   1037: swap
    //   1038: ldc 77
    //   1040: iconst_1
    //   1041: aload 8
    //   1043: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1046: athrow
    //   1047: new 53	gnu/mapping/WrongType
    //   1050: dup_x1
    //   1051: swap
    //   1052: ldc 77
    //   1054: iconst_1
    //   1055: aload 8
    //   1057: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1060: athrow
    //   1061: new 53	gnu/mapping/WrongType
    //   1064: dup_x1
    //   1065: swap
    //   1066: ldc 77
    //   1068: iconst_1
    //   1069: aload 8
    //   1071: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1074: athrow
    //   1075: new 53	gnu/mapping/WrongType
    //   1078: dup_x1
    //   1079: swap
    //   1080: ldc 77
    //   1082: iconst_1
    //   1083: aload 8
    //   1085: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1088: athrow
    //   1089: new 53	gnu/mapping/WrongType
    //   1092: dup_x1
    //   1093: swap
    //   1094: ldc 77
    //   1096: iconst_1
    //   1097: aload 8
    //   1099: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1102: athrow
    //   1103: new 53	gnu/mapping/WrongType
    //   1106: dup_x1
    //   1107: swap
    //   1108: ldc -24
    //   1110: iconst_1
    //   1111: aload 18
    //   1113: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1116: athrow
    //   1117: new 53	gnu/mapping/WrongType
    //   1120: dup_x1
    //   1121: swap
    //   1122: ldc -24
    //   1124: iconst_2
    //   1125: aload 18
    //   1127: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1130: athrow
    //   1131: new 53	gnu/mapping/WrongType
    //   1134: dup_x1
    //   1135: swap
    //   1136: ldc -24
    //   1138: iconst_3
    //   1139: aload 18
    //   1141: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1144: athrow
    //   1145: new 53	gnu/mapping/WrongType
    //   1148: dup_x1
    //   1149: swap
    //   1150: ldc_w 326
    //   1153: bipush -2
    //   1155: aload 20
    //   1157: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1160: athrow
    //   1161: new 53	gnu/mapping/WrongType
    //   1164: dup_x1
    //   1165: swap
    //   1166: ldc -24
    //   1168: iconst_3
    //   1169: aload 21
    //   1171: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1174: athrow
    //   1175: new 53	gnu/mapping/WrongType
    //   1178: dup_x1
    //   1179: swap
    //   1180: ldc 55
    //   1182: iconst_1
    //   1183: aload 18
    //   1185: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1188: athrow
    //   1189: new 53	gnu/mapping/WrongType
    //   1192: dup_x1
    //   1193: swap
    //   1194: ldc 55
    //   1196: iconst_1
    //   1197: aload 19
    //   1199: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1202: athrow
    //   1203: new 53	gnu/mapping/WrongType
    //   1206: dup_x1
    //   1207: swap
    //   1208: ldc_w 334
    //   1211: iconst_1
    //   1212: aload 21
    //   1214: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1217: athrow
    //   1218: new 53	gnu/mapping/WrongType
    //   1221: dup_x1
    //   1222: swap
    //   1223: ldc_w 334
    //   1226: iconst_3
    //   1227: aload 21
    //   1229: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1232: athrow
    //   1233: new 53	gnu/mapping/WrongType
    //   1236: dup_x1
    //   1237: swap
    //   1238: ldc_w 334
    //   1241: iconst_1
    //   1242: aload 22
    //   1244: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1247: athrow
    //   1248: new 53	gnu/mapping/WrongType
    //   1251: dup_x1
    //   1252: swap
    //   1253: ldc_w 334
    //   1256: iconst_3
    //   1257: aload 22
    //   1259: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1262: athrow
    //   1263: new 53	gnu/mapping/WrongType
    //   1266: dup_x1
    //   1267: swap
    //   1268: ldc_w 334
    //   1271: iconst_5
    //   1272: aload 22
    //   1274: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1277: athrow
    //   1278: new 53	gnu/mapping/WrongType
    //   1281: dup_x1
    //   1282: swap
    //   1283: ldc 72
    //   1285: iconst_1
    //   1286: aload 25
    //   1288: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1291: athrow
    //   1292: new 53	gnu/mapping/WrongType
    //   1295: dup_x1
    //   1296: swap
    //   1297: ldc 77
    //   1299: iconst_1
    //   1300: aload 26
    //   1302: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1305: athrow
    //   1306: new 53	gnu/mapping/WrongType
    //   1309: dup_x1
    //   1310: swap
    //   1311: ldc 55
    //   1313: iconst_1
    //   1314: aload 27
    //   1316: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1319: athrow
    //   1320: new 53	gnu/mapping/WrongType
    //   1323: dup_x1
    //   1324: swap
    //   1325: ldc_w 334
    //   1328: iconst_1
    //   1329: aload 28
    //   1331: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1334: athrow
    //   1335: new 53	gnu/mapping/WrongType
    //   1338: dup_x1
    //   1339: swap
    //   1340: ldc_w 334
    //   1343: iconst_2
    //   1344: aload 28
    //   1346: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1349: athrow
    //   1350: new 53	gnu/mapping/WrongType
    //   1353: dup_x1
    //   1354: swap
    //   1355: ldc_w 334
    //   1358: iconst_3
    //   1359: aload 28
    //   1361: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1364: athrow
    //   1365: new 53	gnu/mapping/WrongType
    //   1368: dup_x1
    //   1369: swap
    //   1370: ldc_w 334
    //   1373: iconst_1
    //   1374: aload 21
    //   1376: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1379: athrow
    //   1380: new 53	gnu/mapping/WrongType
    //   1383: dup_x1
    //   1384: swap
    //   1385: ldc_w 334
    //   1388: iconst_3
    //   1389: aload 21
    //   1391: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1394: athrow
    //   1395: new 53	gnu/mapping/WrongType
    //   1398: dup_x1
    //   1399: swap
    //   1400: ldc 77
    //   1402: iconst_1
    //   1403: aload 8
    //   1405: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1408: athrow
    //   1409: new 53	gnu/mapping/WrongType
    //   1412: dup_x1
    //   1413: swap
    //   1414: ldc 77
    //   1416: iconst_1
    //   1417: aload 8
    //   1419: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1422: athrow
    //   1423: new 53	gnu/mapping/WrongType
    //   1426: dup_x1
    //   1427: swap
    //   1428: ldc 77
    //   1430: iconst_1
    //   1431: aload 8
    //   1433: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1436: athrow
    //   1437: new 53	gnu/mapping/WrongType
    //   1440: dup_x1
    //   1441: swap
    //   1442: ldc 77
    //   1444: iconst_1
    //   1445: aload 8
    //   1447: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1450: athrow
    //   1451: new 53	gnu/mapping/WrongType
    //   1454: dup_x1
    //   1455: swap
    //   1456: ldc 77
    //   1458: iconst_1
    //   1459: aload 8
    //   1461: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1464: athrow
    // Line number table:
    //   Java source line #417	-> byte code offset #0
    //   Java source line #418	-> byte code offset #11
    //   Java source line #419	-> byte code offset #22
    //   Java source line #420	-> byte code offset #33
    //   Java source line #421	-> byte code offset #44
    //   Java source line #422	-> byte code offset #66
    //   Java source line #421	-> byte code offset #71
    //   Java source line #422	-> byte code offset #71
    //   Java source line #421	-> byte code offset #79
    //   Java source line #423	-> byte code offset #106
    //   Java source line #421	-> byte code offset #114
    //   Java source line #423	-> byte code offset #147
    //   Java source line #421	-> byte code offset #166
    //   Java source line #423	-> byte code offset #166
    //   Java source line #421	-> byte code offset #174
    //   Java source line #424	-> byte code offset #286
    //   Java source line #426	-> byte code offset #290
    //   Java source line #424	-> byte code offset #298
    //   Java source line #430	-> byte code offset #311
    //   Java source line #431	-> byte code offset #322
    //   Java source line #432	-> byte code offset #337
    //   Java source line #433	-> byte code offset #348
    //   Java source line #434	-> byte code offset #359
    //   Java source line #435	-> byte code offset #370
    //   Java source line #436	-> byte code offset #406
    //   Java source line #438	-> byte code offset #417
    //   Java source line #439	-> byte code offset #424
    //   Java source line #438	-> byte code offset #459
    //   Java source line #440	-> byte code offset #459
    //   Java source line #441	-> byte code offset #466
    //   Java source line #442	-> byte code offset #483
    //   Java source line #443	-> byte code offset #495
    //   Java source line #446	-> byte code offset #505
    //   Java source line #447	-> byte code offset #517
    //   Java source line #446	-> byte code offset #535
    //   Java source line #448	-> byte code offset #535
    //   Java source line #446	-> byte code offset #553
    //   Java source line #450	-> byte code offset #566
    //   Java source line #451	-> byte code offset #576
    //   Java source line #452	-> byte code offset #611
    //   Java source line #453	-> byte code offset #621
    //   Java source line #454	-> byte code offset #662
    //   Java source line #455	-> byte code offset #673
    //   Java source line #456	-> byte code offset #681
    //   Java source line #457	-> byte code offset #699
    //   Java source line #456	-> byte code offset #717
    //   Java source line #458	-> byte code offset #717
    //   Java source line #456	-> byte code offset #735
    //   Java source line #459	-> byte code offset #735
    //   Java source line #460	-> byte code offset #748
    //   Java source line #461	-> byte code offset #795
    //   Java source line #462	-> byte code offset #802
    //   Java source line #463	-> byte code offset #836
    //   Java source line #421	-> byte code offset #853
    //   Java source line #423	-> byte code offset #1019
    //   Java source line #421	-> byte code offset #1033
    //   Java source line #435	-> byte code offset #1103
    //   Java source line #439	-> byte code offset #1145
    //   Java source line #441	-> byte code offset #1161
    //   Java source line #447	-> byte code offset #1175
    //   Java source line #448	-> byte code offset #1189
    //   Java source line #451	-> byte code offset #1203
    //   Java source line #453	-> byte code offset #1233
    //   Java source line #456	-> byte code offset #1278
    //   Java source line #457	-> byte code offset #1292
    //   Java source line #458	-> byte code offset #1306
    //   Java source line #460	-> byte code offset #1320
    //   Java source line #462	-> byte code offset #1365
    //   Java source line #421	-> byte code offset #1395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	p	Object
    //   0	962	1	f	Object
    //   0	962	2	g	Object
    //   0	962	3	seed	Object
    //   0	962	4	argsArray	Object[]
    //   0	953	5	base$Plmake$Mnfinal	LList
    //   7	1	6	localLList1	LList
    //   69	749	6	base	Object
    //   55	1	7	localLList2	LList
    //   164	808	7	make$Mnfinal	Object
    //   95	173	8	localObject1	Object
    //   309	1151	8	chunks	Object
    //   307	1	9	i	int
    //   311	247	9	nchars	int
    //   305	1	10	localFString1	FString
    //   311	327	10	chunk	Object
    //   303	1	11	j	int
    //   311	184	11	chunk$Mnlen	int
    //   301	1	12	k	int
    //   311	1	12	i	int
    //   299	1	13	localObject2	Object
    //   311	6	13	seed	Object
    //   320	332	14	i	IntNum
    //   318	1	15	localObject3	Object
    //   322	189	15	seed	Object
    //   346	1	16	localObject4	Object
    //   359	111	16	c	Object
    //   515	78	16	final	Object
    //   357	144	17	seed	Object
    //   533	74	17	flen	int
    //   379	20	18	localObject5	Object
    //   422	104	18	nchars2	int
    //   525	1	18	localObject6	Object
    //   551	633	18	base$Mnlen	int
    //   457	87	19	chunk$Mnlen2	int
    //   564	634	19	j	int
    //   449	1	20	localObject7	Object
    //   464	32	20	new$Mnchunk	FString
    //   574	582	20	ans	Object
    //   475	126	21	localObject8	Object
    //   619	771	21	j	int
    //   811	579	21	localObject9	Object
    //   630	25	22	localObject10	Object
    //   671	602	22	j	Object
    //   669	1	23	localObject11	Object
    //   673	27	23	chunks	Object
    //   697	80	24	chunk	Object
    //   689	1	25	localObject12	Object
    //   715	572	25	chunks	Object
    //   707	1	26	localObject13	Object
    //   733	568	26	chunk$Mnlen	int
    //   725	1	27	localObject14	Object
    //   746	569	27	j	Object
    //   757	603	28	localObject15	Object
    //   963	1	54	localClassCastException1	ClassCastException
    //   977	1	55	localClassCastException2	ClassCastException
    //   991	1	56	localClassCastException3	ClassCastException
    //   1005	1	57	localClassCastException4	ClassCastException
    //   1019	1	58	localClassCastException5	ClassCastException
    //   1033	1	59	localClassCastException6	ClassCastException
    //   1047	1	60	localClassCastException7	ClassCastException
    //   1061	1	61	localClassCastException8	ClassCastException
    //   1075	1	62	localClassCastException9	ClassCastException
    //   1089	1	63	localClassCastException10	ClassCastException
    //   1103	1	64	localClassCastException11	ClassCastException
    //   1117	1	65	localClassCastException12	ClassCastException
    //   1131	1	66	localClassCastException13	ClassCastException
    //   1145	1	67	localClassCastException14	ClassCastException
    //   1161	1	68	localClassCastException15	ClassCastException
    //   1175	1	69	localClassCastException16	ClassCastException
    //   1189	1	70	localClassCastException17	ClassCastException
    //   1203	1	71	localClassCastException18	ClassCastException
    //   1218	1	72	localClassCastException19	ClassCastException
    //   1233	1	73	localClassCastException20	ClassCastException
    //   1248	1	74	localClassCastException21	ClassCastException
    //   1263	1	75	localClassCastException22	ClassCastException
    //   1278	1	76	localClassCastException23	ClassCastException
    //   1292	1	77	localClassCastException24	ClassCastException
    //   1306	1	78	localClassCastException25	ClassCastException
    //   1320	1	79	localClassCastException26	ClassCastException
    //   1335	1	80	localClassCastException27	ClassCastException
    //   1350	1	81	localClassCastException28	ClassCastException
    //   1365	1	82	localClassCastException29	ClassCastException
    //   1380	1	83	localClassCastException30	ClassCastException
    //   1395	1	84	localClassCastException31	ClassCastException
    //   1409	1	85	localClassCastException32	ClassCastException
    //   1423	1	86	localClassCastException33	ClassCastException
    //   1437	1	87	localClassCastException34	ClassCastException
    //   1451	1	88	localClassCastException35	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   57	60	963	java/lang/ClassCastException
    //   97	100	977	java/lang/ClassCastException
    //   127	130	991	java/lang/ClassCastException
    //   141	144	1005	java/lang/ClassCastException
    //   152	155	1019	java/lang/ClassCastException
    //   192	195	1033	java/lang/ClassCastException
    //   222	225	1047	java/lang/ClassCastException
    //   236	239	1061	java/lang/ClassCastException
    //   247	250	1075	java/lang/ClassCastException
    //   269	272	1089	java/lang/ClassCastException
    //   381	384	1103	java/lang/ClassCastException
    //   389	392	1117	java/lang/ClassCastException
    //   400	403	1131	java/lang/ClassCastException
    //   451	457	1145	java/lang/ClassCastException
    //   477	480	1161	java/lang/ClassCastException
    //   527	530	1175	java/lang/ClassCastException
    //   545	548	1189	java/lang/ClassCastException
    //   587	590	1203	java/lang/ClassCastException
    //   602	605	1218	java/lang/ClassCastException
    //   632	635	1233	java/lang/ClassCastException
    //   647	650	1248	java/lang/ClassCastException
    //   656	659	1263	java/lang/ClassCastException
    //   691	694	1278	java/lang/ClassCastException
    //   709	712	1292	java/lang/ClassCastException
    //   727	730	1306	java/lang/ClassCastException
    //   759	762	1320	java/lang/ClassCastException
    //   770	776	1335	java/lang/ClassCastException
    //   786	789	1350	java/lang/ClassCastException
    //   813	816	1365	java/lang/ClassCastException
    //   827	830	1380	java/lang/ClassCastException
    //   866	869	1395	java/lang/ClassCastException
    //   896	899	1409	java/lang/ClassCastException
    //   910	913	1423	java/lang/ClassCastException
    //   921	924	1437	java/lang/ClassCastException
    //   943	946	1451	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringUnfoldRight$V(Object p, Object f, Object g, Object seed, Object[] argsArray)
  {
    // Byte code:
    //   0: aload 4
    //   2: iconst_0
    //   3: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   6: dup
    //   7: astore 6
    //   9: astore 5
    //   11: aload 5
    //   13: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   16: ifne +17 -> 33
    //   19: aload 5
    //   21: dup
    //   22: astore 7
    //   24: checkcast 70	gnu/lists/Pair
    //   27: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   30: goto +6 -> 36
    //   33: ldc_w 290
    //   36: astore 6
    //   38: aload 6
    //   40: invokestatic 25	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   43: ifne +8 -> 51
    //   46: ldc_w 290
    //   49: astore 6
    //   51: aload 5
    //   53: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   56: ifne +17 -> 73
    //   59: aload 5
    //   61: dup
    //   62: astore 8
    //   64: checkcast 70	gnu/lists/Pair
    //   67: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   70: goto +5 -> 75
    //   73: aload 5
    //   75: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   78: ifne +50 -> 128
    //   81: aload 5
    //   83: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   86: ifne +28 -> 114
    //   89: aload 5
    //   91: dup
    //   92: astore 8
    //   94: checkcast 70	gnu/lists/Pair
    //   97: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   100: ldc 70
    //   102: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   105: dup
    //   106: astore 8
    //   108: checkcast 70	gnu/lists/Pair
    //   111: goto +11 -> 122
    //   114: aload 5
    //   116: dup
    //   117: astore 8
    //   119: checkcast 70	gnu/lists/Pair
    //   122: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   125: goto +6 -> 131
    //   128: getstatic 343	gnu/kawa/slib/srfi13:lambda$Fn4	Lgnu/expr/ModuleMethod;
    //   131: astore 7
    //   133: aload 7
    //   135: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   138: ifne +8 -> 146
    //   141: getstatic 346	gnu/kawa/slib/srfi13:lambda$Fn5	Lgnu/expr/ModuleMethod;
    //   144: astore 7
    //   146: aload 5
    //   148: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   151: ifne +17 -> 168
    //   154: aload 5
    //   156: dup
    //   157: astore 8
    //   159: checkcast 70	gnu/lists/Pair
    //   162: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   165: goto +5 -> 170
    //   168: aload 5
    //   170: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   173: ifne +50 -> 223
    //   176: aload 5
    //   178: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   181: ifne +28 -> 209
    //   184: aload 5
    //   186: dup
    //   187: astore 8
    //   189: checkcast 70	gnu/lists/Pair
    //   192: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   195: ldc 70
    //   197: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   200: dup
    //   201: astore 8
    //   203: checkcast 70	gnu/lists/Pair
    //   206: goto +11 -> 217
    //   209: aload 5
    //   211: dup
    //   212: astore 8
    //   214: checkcast 70	gnu/lists/Pair
    //   217: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   220: goto +27 -> 247
    //   223: aload 5
    //   225: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   228: ifne +17 -> 245
    //   231: aload 5
    //   233: dup
    //   234: astore 8
    //   236: checkcast 70	gnu/lists/Pair
    //   239: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   242: goto +5 -> 247
    //   245: aload 5
    //   247: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   250: ifeq +658 -> 908
    //   253: getstatic 141	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   256: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   259: bipush 40
    //   261: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   264: getstatic 349	gnu/kawa/slib/srfi13:Lit3	Lgnu/math/IntNum;
    //   267: getstatic 349	gnu/kawa/slib/srfi13:Lit3	Lgnu/math/IntNum;
    //   270: aload_3
    //   271: astore 13
    //   273: astore 12
    //   275: astore 11
    //   277: astore 10
    //   279: astore 9
    //   281: astore 8
    //   283: aload 12
    //   285: aload 13
    //   287: astore 15
    //   289: astore 14
    //   291: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   294: aload_0
    //   295: aload 15
    //   297: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   300: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   303: ifne +212 -> 515
    //   306: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   309: aload_1
    //   310: aload 15
    //   312: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   315: astore 16
    //   317: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   320: aload_2
    //   321: aload 15
    //   323: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   326: astore 17
    //   328: aload 14
    //   330: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   333: invokestatic 352	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   336: ifeq +63 -> 399
    //   339: iconst_m1
    //   340: aload 14
    //   342: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   345: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   348: astore 18
    //   350: aload 10
    //   352: ldc_w 272
    //   355: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   358: dup
    //   359: astore 19
    //   361: checkcast 272	gnu/lists/CharSeq
    //   364: aload 18
    //   366: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   369: dup
    //   370: astore 19
    //   372: checkcast 177	java/lang/Number
    //   375: invokevirtual 181	java/lang/Number:intValue	()I
    //   378: aload 16
    //   380: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   383: dup
    //   384: astore 19
    //   386: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   389: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   392: aload 18
    //   394: aload 17
    //   396: goto -109 -> 287
    //   399: iconst_1
    //   400: aload 11
    //   402: aload 9
    //   404: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   407: astore 18
    //   409: iconst_2
    //   410: anewarray 27	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: getstatic 320	gnu/kawa/slib/srfi13:Lit2	Lgnu/math/IntNum;
    //   418: aastore
    //   419: dup
    //   420: iconst_1
    //   421: aload 18
    //   423: aastore
    //   424: invokestatic 324	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   427: astore 19
    //   429: aload 19
    //   431: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   434: dup
    //   435: astore 21
    //   437: checkcast 177	java/lang/Number
    //   440: invokevirtual 181	java/lang/Number:intValue	()I
    //   443: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   446: astore 20
    //   448: iconst_m1
    //   449: aload 19
    //   451: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   454: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   457: astore 21
    //   459: aload 20
    //   461: aload 21
    //   463: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   466: dup
    //   467: astore 22
    //   469: checkcast 177	java/lang/Number
    //   472: invokevirtual 181	java/lang/Number:intValue	()I
    //   475: aload 16
    //   477: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   480: dup
    //   481: astore 22
    //   483: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   486: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   489: aload 10
    //   491: aload 8
    //   493: invokestatic 330	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   496: iconst_1
    //   497: aload 9
    //   499: aload 11
    //   501: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   504: aload 20
    //   506: aload 19
    //   508: aload 21
    //   510: aload 17
    //   512: goto -241 -> 271
    //   515: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   518: aload 7
    //   520: aload 15
    //   522: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   525: astore 16
    //   527: aload 16
    //   529: ldc 43
    //   531: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   534: dup
    //   535: astore 18
    //   537: checkcast 43	java/lang/CharSequence
    //   540: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   543: istore 17
    //   545: aload 6
    //   547: ldc 43
    //   549: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   552: dup
    //   553: astore 19
    //   555: checkcast 43	java/lang/CharSequence
    //   558: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   561: istore 18
    //   563: iconst_m1
    //   564: aload 11
    //   566: aload 14
    //   568: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   571: astore 19
    //   573: iconst_1
    //   574: iconst_1
    //   575: iload 18
    //   577: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   580: aload 9
    //   582: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   585: aload 19
    //   587: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   590: astore 20
    //   592: iconst_1
    //   593: aload 20
    //   595: iload 17
    //   597: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   603: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   606: dup
    //   607: astore 22
    //   609: checkcast 177	java/lang/Number
    //   612: invokevirtual 181	java/lang/Number:intValue	()I
    //   615: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   618: astore 21
    //   620: aload 21
    //   622: ldc_w 332
    //   625: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   628: dup
    //   629: astore 22
    //   631: checkcast 332	gnu/lists/FString
    //   634: iconst_0
    //   635: aload 16
    //   637: ldc 43
    //   639: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   642: dup
    //   643: astore 22
    //   645: checkcast 43	java/lang/CharSequence
    //   648: iconst_0
    //   649: iload 17
    //   651: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   654: aload 21
    //   656: ldc_w 332
    //   659: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   662: dup
    //   663: astore 22
    //   665: checkcast 332	gnu/lists/FString
    //   668: iload 17
    //   670: aload 10
    //   672: ldc 43
    //   674: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   677: dup
    //   678: astore 22
    //   680: checkcast 43	java/lang/CharSequence
    //   683: aload 14
    //   685: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   688: dup
    //   689: astore 22
    //   691: checkcast 177	java/lang/Number
    //   694: invokevirtual 181	java/lang/Number:intValue	()I
    //   697: aload 11
    //   699: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   702: dup
    //   703: astore 22
    //   705: checkcast 177	java/lang/Number
    //   708: invokevirtual 181	java/lang/Number:intValue	()I
    //   711: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   714: iconst_1
    //   715: iload 17
    //   717: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   720: aload 19
    //   722: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   725: aload 8
    //   727: astore 23
    //   729: astore 22
    //   731: aload 23
    //   733: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   736: ifeq +120 -> 856
    //   739: aload 23
    //   741: ldc 70
    //   743: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   746: dup
    //   747: astore 25
    //   749: checkcast 70	gnu/lists/Pair
    //   752: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   755: astore 24
    //   757: aload 23
    //   759: ldc 70
    //   761: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   764: dup
    //   765: astore 26
    //   767: checkcast 70	gnu/lists/Pair
    //   770: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   773: astore 25
    //   775: aload 24
    //   777: ldc 43
    //   779: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   782: dup
    //   783: astore 27
    //   785: checkcast 43	java/lang/CharSequence
    //   788: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   791: istore 26
    //   793: aload 21
    //   795: ldc_w 332
    //   798: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   801: dup
    //   802: astore 27
    //   804: checkcast 332	gnu/lists/FString
    //   807: aload 22
    //   809: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   812: dup
    //   813: astore 27
    //   815: checkcast 177	java/lang/Number
    //   818: invokevirtual 181	java/lang/Number:intValue	()I
    //   821: aload 24
    //   823: ldc 43
    //   825: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   828: dup
    //   829: astore 27
    //   831: checkcast 43	java/lang/CharSequence
    //   834: iconst_0
    //   835: iload 26
    //   837: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   840: iconst_1
    //   841: aload 22
    //   843: iload 26
    //   845: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   848: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   851: aload 25
    //   853: goto -126 -> 727
    //   856: aload 21
    //   858: ldc_w 332
    //   861: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   864: dup
    //   865: astore 24
    //   867: checkcast 332	gnu/lists/FString
    //   870: aload 22
    //   872: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   875: dup
    //   876: astore 24
    //   878: checkcast 177	java/lang/Number
    //   881: invokevirtual 181	java/lang/Number:intValue	()I
    //   884: aload 6
    //   886: ldc 43
    //   888: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   891: dup
    //   892: astore 24
    //   894: checkcast 43	java/lang/CharSequence
    //   897: iconst_0
    //   898: iload 18
    //   900: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   903: aload 21
    //   905: goto +124 -> 1029
    //   908: iconst_2
    //   909: anewarray 27	java/lang/Object
    //   912: dup
    //   913: iconst_0
    //   914: ldc_w 340
    //   917: aastore
    //   918: dup
    //   919: iconst_1
    //   920: aload 5
    //   922: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   925: ifne +17 -> 942
    //   928: aload 5
    //   930: dup
    //   931: astore 8
    //   933: checkcast 70	gnu/lists/Pair
    //   936: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   939: goto +5 -> 944
    //   942: aload 5
    //   944: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   947: ifne +50 -> 997
    //   950: aload 5
    //   952: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   955: ifne +28 -> 983
    //   958: aload 5
    //   960: dup
    //   961: astore 8
    //   963: checkcast 70	gnu/lists/Pair
    //   966: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   969: ldc 70
    //   971: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   974: dup
    //   975: astore 8
    //   977: checkcast 70	gnu/lists/Pair
    //   980: goto +11 -> 991
    //   983: aload 5
    //   985: dup
    //   986: astore 8
    //   988: checkcast 70	gnu/lists/Pair
    //   991: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   994: goto +27 -> 1021
    //   997: aload 5
    //   999: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   1002: ifne +17 -> 1019
    //   1005: aload 5
    //   1007: dup
    //   1008: astore 8
    //   1010: checkcast 70	gnu/lists/Pair
    //   1013: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   1016: goto +5 -> 1021
    //   1019: aload 5
    //   1021: aastore
    //   1022: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   1025: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   1028: athrow
    //   1029: areturn
    //   1030: new 53	gnu/mapping/WrongType
    //   1033: dup_x1
    //   1034: swap
    //   1035: ldc 72
    //   1037: iconst_1
    //   1038: aload 7
    //   1040: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1043: athrow
    //   1044: new 53	gnu/mapping/WrongType
    //   1047: dup_x1
    //   1048: swap
    //   1049: ldc 77
    //   1051: iconst_1
    //   1052: aload 8
    //   1054: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1057: athrow
    //   1058: new 53	gnu/mapping/WrongType
    //   1061: dup_x1
    //   1062: swap
    //   1063: ldc 77
    //   1065: iconst_1
    //   1066: aload 8
    //   1068: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1071: athrow
    //   1072: new 53	gnu/mapping/WrongType
    //   1075: dup_x1
    //   1076: swap
    //   1077: ldc 72
    //   1079: iconst_1
    //   1080: aload 8
    //   1082: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1085: athrow
    //   1086: new 53	gnu/mapping/WrongType
    //   1089: dup_x1
    //   1090: swap
    //   1091: ldc 72
    //   1093: iconst_1
    //   1094: aload 8
    //   1096: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1099: athrow
    //   1100: new 53	gnu/mapping/WrongType
    //   1103: dup_x1
    //   1104: swap
    //   1105: ldc 77
    //   1107: iconst_1
    //   1108: aload 8
    //   1110: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1113: athrow
    //   1114: new 53	gnu/mapping/WrongType
    //   1117: dup_x1
    //   1118: swap
    //   1119: ldc 77
    //   1121: iconst_1
    //   1122: aload 8
    //   1124: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1127: athrow
    //   1128: new 53	gnu/mapping/WrongType
    //   1131: dup_x1
    //   1132: swap
    //   1133: ldc 77
    //   1135: iconst_1
    //   1136: aload 8
    //   1138: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1141: athrow
    //   1142: new 53	gnu/mapping/WrongType
    //   1145: dup_x1
    //   1146: swap
    //   1147: ldc 77
    //   1149: iconst_1
    //   1150: aload 8
    //   1152: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1155: athrow
    //   1156: new 53	gnu/mapping/WrongType
    //   1159: dup_x1
    //   1160: swap
    //   1161: ldc 77
    //   1163: iconst_1
    //   1164: aload 8
    //   1166: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1169: athrow
    //   1170: new 53	gnu/mapping/WrongType
    //   1173: dup_x1
    //   1174: swap
    //   1175: ldc -24
    //   1177: iconst_1
    //   1178: aload 19
    //   1180: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1183: athrow
    //   1184: new 53	gnu/mapping/WrongType
    //   1187: dup_x1
    //   1188: swap
    //   1189: ldc -24
    //   1191: iconst_2
    //   1192: aload 19
    //   1194: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1197: athrow
    //   1198: new 53	gnu/mapping/WrongType
    //   1201: dup_x1
    //   1202: swap
    //   1203: ldc -24
    //   1205: iconst_3
    //   1206: aload 19
    //   1208: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1211: athrow
    //   1212: new 53	gnu/mapping/WrongType
    //   1215: dup_x1
    //   1216: swap
    //   1217: ldc -36
    //   1219: iconst_1
    //   1220: aload 21
    //   1222: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1225: athrow
    //   1226: new 53	gnu/mapping/WrongType
    //   1229: dup_x1
    //   1230: swap
    //   1231: ldc -24
    //   1233: iconst_2
    //   1234: aload 22
    //   1236: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1239: athrow
    //   1240: new 53	gnu/mapping/WrongType
    //   1243: dup_x1
    //   1244: swap
    //   1245: ldc -24
    //   1247: iconst_3
    //   1248: aload 22
    //   1250: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1253: athrow
    //   1254: new 53	gnu/mapping/WrongType
    //   1257: dup_x1
    //   1258: swap
    //   1259: ldc 55
    //   1261: iconst_1
    //   1262: aload 18
    //   1264: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1267: athrow
    //   1268: new 53	gnu/mapping/WrongType
    //   1271: dup_x1
    //   1272: swap
    //   1273: ldc 55
    //   1275: iconst_1
    //   1276: aload 19
    //   1278: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1281: athrow
    //   1282: new 53	gnu/mapping/WrongType
    //   1285: dup_x1
    //   1286: swap
    //   1287: ldc -36
    //   1289: iconst_1
    //   1290: aload 22
    //   1292: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1295: athrow
    //   1296: new 53	gnu/mapping/WrongType
    //   1299: dup_x1
    //   1300: swap
    //   1301: ldc_w 334
    //   1304: iconst_1
    //   1305: aload 22
    //   1307: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1310: athrow
    //   1311: new 53	gnu/mapping/WrongType
    //   1314: dup_x1
    //   1315: swap
    //   1316: ldc_w 334
    //   1319: iconst_3
    //   1320: aload 22
    //   1322: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1325: athrow
    //   1326: new 53	gnu/mapping/WrongType
    //   1329: dup_x1
    //   1330: swap
    //   1331: ldc_w 334
    //   1334: iconst_1
    //   1335: aload 22
    //   1337: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1340: athrow
    //   1341: new 53	gnu/mapping/WrongType
    //   1344: dup_x1
    //   1345: swap
    //   1346: ldc_w 334
    //   1349: iconst_3
    //   1350: aload 22
    //   1352: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1355: athrow
    //   1356: new 53	gnu/mapping/WrongType
    //   1359: dup_x1
    //   1360: swap
    //   1361: ldc_w 334
    //   1364: iconst_4
    //   1365: aload 22
    //   1367: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1370: athrow
    //   1371: new 53	gnu/mapping/WrongType
    //   1374: dup_x1
    //   1375: swap
    //   1376: ldc_w 334
    //   1379: iconst_5
    //   1380: aload 22
    //   1382: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1385: athrow
    //   1386: new 53	gnu/mapping/WrongType
    //   1389: dup_x1
    //   1390: swap
    //   1391: ldc 72
    //   1393: iconst_1
    //   1394: aload 25
    //   1396: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1399: athrow
    //   1400: new 53	gnu/mapping/WrongType
    //   1403: dup_x1
    //   1404: swap
    //   1405: ldc 77
    //   1407: iconst_1
    //   1408: aload 26
    //   1410: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1413: athrow
    //   1414: new 53	gnu/mapping/WrongType
    //   1417: dup_x1
    //   1418: swap
    //   1419: ldc 55
    //   1421: iconst_1
    //   1422: aload 27
    //   1424: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1427: athrow
    //   1428: new 53	gnu/mapping/WrongType
    //   1431: dup_x1
    //   1432: swap
    //   1433: ldc_w 334
    //   1436: iconst_1
    //   1437: aload 27
    //   1439: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1442: athrow
    //   1443: new 53	gnu/mapping/WrongType
    //   1446: dup_x1
    //   1447: swap
    //   1448: ldc_w 334
    //   1451: iconst_2
    //   1452: aload 27
    //   1454: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1457: athrow
    //   1458: new 53	gnu/mapping/WrongType
    //   1461: dup_x1
    //   1462: swap
    //   1463: ldc_w 334
    //   1466: iconst_3
    //   1467: aload 27
    //   1469: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1472: athrow
    //   1473: new 53	gnu/mapping/WrongType
    //   1476: dup_x1
    //   1477: swap
    //   1478: ldc_w 334
    //   1481: iconst_1
    //   1482: aload 24
    //   1484: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1487: athrow
    //   1488: new 53	gnu/mapping/WrongType
    //   1491: dup_x1
    //   1492: swap
    //   1493: ldc_w 334
    //   1496: iconst_2
    //   1497: aload 24
    //   1499: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1502: athrow
    //   1503: new 53	gnu/mapping/WrongType
    //   1506: dup_x1
    //   1507: swap
    //   1508: ldc_w 334
    //   1511: iconst_3
    //   1512: aload 24
    //   1514: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1517: athrow
    //   1518: new 53	gnu/mapping/WrongType
    //   1521: dup_x1
    //   1522: swap
    //   1523: ldc 77
    //   1525: iconst_1
    //   1526: aload 8
    //   1528: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1531: athrow
    //   1532: new 53	gnu/mapping/WrongType
    //   1535: dup_x1
    //   1536: swap
    //   1537: ldc 77
    //   1539: iconst_1
    //   1540: aload 8
    //   1542: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1545: athrow
    //   1546: new 53	gnu/mapping/WrongType
    //   1549: dup_x1
    //   1550: swap
    //   1551: ldc 77
    //   1553: iconst_1
    //   1554: aload 8
    //   1556: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1559: athrow
    //   1560: new 53	gnu/mapping/WrongType
    //   1563: dup_x1
    //   1564: swap
    //   1565: ldc 77
    //   1567: iconst_1
    //   1568: aload 8
    //   1570: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1573: athrow
    //   1574: new 53	gnu/mapping/WrongType
    //   1577: dup_x1
    //   1578: swap
    //   1579: ldc 77
    //   1581: iconst_1
    //   1582: aload 8
    //   1584: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1587: athrow
    // Line number table:
    //   Java source line #465	-> byte code offset #0
    //   Java source line #466	-> byte code offset #11
    //   Java source line #467	-> byte code offset #33
    //   Java source line #466	-> byte code offset #38
    //   Java source line #467	-> byte code offset #38
    //   Java source line #466	-> byte code offset #46
    //   Java source line #468	-> byte code offset #73
    //   Java source line #466	-> byte code offset #81
    //   Java source line #468	-> byte code offset #114
    //   Java source line #466	-> byte code offset #133
    //   Java source line #468	-> byte code offset #133
    //   Java source line #466	-> byte code offset #141
    //   Java source line #469	-> byte code offset #253
    //   Java source line #471	-> byte code offset #259
    //   Java source line #469	-> byte code offset #264
    //   Java source line #475	-> byte code offset #283
    //   Java source line #476	-> byte code offset #291
    //   Java source line #477	-> byte code offset #306
    //   Java source line #478	-> byte code offset #317
    //   Java source line #479	-> byte code offset #328
    //   Java source line #480	-> byte code offset #339
    //   Java source line #481	-> byte code offset #350
    //   Java source line #482	-> byte code offset #392
    //   Java source line #484	-> byte code offset #399
    //   Java source line #485	-> byte code offset #409
    //   Java source line #484	-> byte code offset #429
    //   Java source line #486	-> byte code offset #429
    //   Java source line #484	-> byte code offset #448
    //   Java source line #487	-> byte code offset #448
    //   Java source line #488	-> byte code offset #459
    //   Java source line #489	-> byte code offset #489
    //   Java source line #490	-> byte code offset #504
    //   Java source line #493	-> byte code offset #515
    //   Java source line #494	-> byte code offset #527
    //   Java source line #493	-> byte code offset #545
    //   Java source line #495	-> byte code offset #545
    //   Java source line #493	-> byte code offset #563
    //   Java source line #496	-> byte code offset #563
    //   Java source line #493	-> byte code offset #573
    //   Java source line #498	-> byte code offset #592
    //   Java source line #499	-> byte code offset #620
    //   Java source line #500	-> byte code offset #654
    //   Java source line #501	-> byte code offset #714
    //   Java source line #503	-> byte code offset #731
    //   Java source line #504	-> byte code offset #739
    //   Java source line #505	-> byte code offset #757
    //   Java source line #504	-> byte code offset #775
    //   Java source line #506	-> byte code offset #775
    //   Java source line #507	-> byte code offset #793
    //   Java source line #508	-> byte code offset #840
    //   Java source line #509	-> byte code offset #856
    //   Java source line #510	-> byte code offset #903
    //   Java source line #466	-> byte code offset #920
    //   Java source line #468	-> byte code offset #1086
    //   Java source line #466	-> byte code offset #1100
    //   Java source line #481	-> byte code offset #1170
    //   Java source line #486	-> byte code offset #1212
    //   Java source line #488	-> byte code offset #1226
    //   Java source line #494	-> byte code offset #1254
    //   Java source line #495	-> byte code offset #1268
    //   Java source line #498	-> byte code offset #1282
    //   Java source line #499	-> byte code offset #1296
    //   Java source line #500	-> byte code offset #1326
    //   Java source line #504	-> byte code offset #1386
    //   Java source line #505	-> byte code offset #1400
    //   Java source line #506	-> byte code offset #1414
    //   Java source line #507	-> byte code offset #1428
    //   Java source line #509	-> byte code offset #1473
    //   Java source line #466	-> byte code offset #1518
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1029	0	p	Object
    //   0	1029	1	f	Object
    //   0	1029	2	g	Object
    //   0	1029	3	seed	Object
    //   0	1029	4	argsArray	Object[]
    //   0	1020	5	base$Plmake$Mnfinal	LList
    //   7	1	6	localLList1	LList
    //   36	849	6	base	Object
    //   22	1	7	localLList2	LList
    //   131	908	7	make$Mnfinal	Object
    //   62	173	8	localObject1	Object
    //   281	1302	8	chunks	Object
    //   279	1	9	localIntNum1	IntNum
    //   283	298	9	nchars	Object
    //   277	1	10	localFString1	FString
    //   283	388	10	chunk	Object
    //   275	1	11	localIntNum2	IntNum
    //   283	415	11	chunk$Mnlen	Object
    //   273	1	12	localIntNum3	IntNum
    //   283	1	12	i	Object
    //   271	1	13	localObject2	Object
    //   283	3	13	seed	Object
    //   289	395	14	i	Object
    //   287	1	15	localObject3	Object
    //   291	230	15	seed	Object
    //   315	1	16	localObject4	Object
    //   328	148	16	c	Object
    //   525	111	16	final	Object
    //   326	185	17	seed	Object
    //   543	173	17	flen	int
    //   348	45	18	i	Object
    //   407	129	18	nchars2	Object
    //   561	702	18	base$Mnlen	int
    //   359	26	19	localObject5	Object
    //   427	127	19	chunk$Mnlen2	Object
    //   571	706	19	chunk$Mnused	Object
    //   446	59	20	new$Mnchunk	FString
    //   590	4	20	j	Object
    //   435	1	21	localObject6	Object
    //   457	52	21	i	Object
    //   618	603	21	ans	Object
    //   467	237	22	localObject7	Object
    //   729	652	22	j	Object
    //   727	1	23	localObject8	Object
    //   731	27	23	chunks	Object
    //   755	758	24	chunk	Object
    //   747	1	25	localObject9	Object
    //   773	622	25	chunks	Object
    //   765	1	26	localObject10	Object
    //   791	618	26	chunk$Mnlen	int
    //   783	685	27	localObject11	Object
    //   1030	1	51	localClassCastException1	ClassCastException
    //   1044	1	52	localClassCastException2	ClassCastException
    //   1058	1	53	localClassCastException3	ClassCastException
    //   1072	1	54	localClassCastException4	ClassCastException
    //   1086	1	55	localClassCastException5	ClassCastException
    //   1100	1	56	localClassCastException6	ClassCastException
    //   1114	1	57	localClassCastException7	ClassCastException
    //   1128	1	58	localClassCastException8	ClassCastException
    //   1142	1	59	localClassCastException9	ClassCastException
    //   1156	1	60	localClassCastException10	ClassCastException
    //   1170	1	61	localClassCastException11	ClassCastException
    //   1184	1	62	localClassCastException12	ClassCastException
    //   1198	1	63	localClassCastException13	ClassCastException
    //   1212	1	64	localClassCastException14	ClassCastException
    //   1226	1	65	localClassCastException15	ClassCastException
    //   1240	1	66	localClassCastException16	ClassCastException
    //   1254	1	67	localClassCastException17	ClassCastException
    //   1268	1	68	localClassCastException18	ClassCastException
    //   1282	1	69	localClassCastException19	ClassCastException
    //   1296	1	70	localClassCastException20	ClassCastException
    //   1311	1	71	localClassCastException21	ClassCastException
    //   1326	1	72	localClassCastException22	ClassCastException
    //   1341	1	73	localClassCastException23	ClassCastException
    //   1356	1	74	localClassCastException24	ClassCastException
    //   1371	1	75	localClassCastException25	ClassCastException
    //   1386	1	76	localClassCastException26	ClassCastException
    //   1400	1	77	localClassCastException27	ClassCastException
    //   1414	1	78	localClassCastException28	ClassCastException
    //   1428	1	79	localClassCastException29	ClassCastException
    //   1443	1	80	localClassCastException30	ClassCastException
    //   1458	1	81	localClassCastException31	ClassCastException
    //   1473	1	82	localClassCastException32	ClassCastException
    //   1488	1	83	localClassCastException33	ClassCastException
    //   1503	1	84	localClassCastException34	ClassCastException
    //   1518	1	85	localClassCastException35	ClassCastException
    //   1532	1	86	localClassCastException36	ClassCastException
    //   1546	1	87	localClassCastException37	ClassCastException
    //   1560	1	88	localClassCastException38	ClassCastException
    //   1574	1	89	localClassCastException39	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   24	27	1030	java/lang/ClassCastException
    //   64	67	1044	java/lang/ClassCastException
    //   94	97	1058	java/lang/ClassCastException
    //   108	111	1072	java/lang/ClassCastException
    //   119	122	1086	java/lang/ClassCastException
    //   159	162	1100	java/lang/ClassCastException
    //   189	192	1114	java/lang/ClassCastException
    //   203	206	1128	java/lang/ClassCastException
    //   214	217	1142	java/lang/ClassCastException
    //   236	239	1156	java/lang/ClassCastException
    //   361	364	1170	java/lang/ClassCastException
    //   372	378	1184	java/lang/ClassCastException
    //   386	389	1198	java/lang/ClassCastException
    //   437	443	1212	java/lang/ClassCastException
    //   469	475	1226	java/lang/ClassCastException
    //   483	486	1240	java/lang/ClassCastException
    //   537	540	1254	java/lang/ClassCastException
    //   555	558	1268	java/lang/ClassCastException
    //   609	615	1282	java/lang/ClassCastException
    //   631	634	1296	java/lang/ClassCastException
    //   645	648	1311	java/lang/ClassCastException
    //   665	668	1326	java/lang/ClassCastException
    //   680	683	1341	java/lang/ClassCastException
    //   691	697	1356	java/lang/ClassCastException
    //   705	711	1371	java/lang/ClassCastException
    //   749	752	1386	java/lang/ClassCastException
    //   767	770	1400	java/lang/ClassCastException
    //   785	788	1414	java/lang/ClassCastException
    //   804	807	1428	java/lang/ClassCastException
    //   815	821	1443	java/lang/ClassCastException
    //   831	834	1458	java/lang/ClassCastException
    //   867	870	1473	java/lang/ClassCastException
    //   878	884	1488	java/lang/ClassCastException
    //   894	897	1503	java/lang/ClassCastException
    //   933	936	1518	java/lang/ClassCastException
    //   963	966	1532	java/lang/ClassCastException
    //   977	980	1546	java/lang/ClassCastException
    //   988	991	1560	java/lang/ClassCastException
    //   1010	1013	1574	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringEvery$V(Object criterion, Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 355	gnu/kawa/slib/srfi13:string$Mnevery	Lgnu/expr/ModuleMethod;
    //   12: aload_1
    //   13: aload_3
    //   14: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload_0
    //   59: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   62: ifeq +95 -> 157
    //   65: aload 6
    //   67: astore 8
    //   69: aload 8
    //   71: aload 7
    //   73: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   76: istore 9
    //   78: iload 9
    //   80: ifeq +20 -> 100
    //   83: iload 9
    //   85: ifeq +9 -> 94
    //   88: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   91: goto +339 -> 430
    //   94: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   97: goto +333 -> 430
    //   100: aload_0
    //   101: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   104: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   107: aload_1
    //   108: ldc 43
    //   110: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   113: dup
    //   114: astore 10
    //   116: checkcast 43	java/lang/CharSequence
    //   119: aload 8
    //   121: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: dup
    //   125: astore 10
    //   127: checkcast 177	java/lang/Number
    //   130: invokevirtual 181	java/lang/Number:intValue	()I
    //   133: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   136: if_icmpne +15 -> 151
    //   139: iconst_1
    //   140: aload 8
    //   142: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   145: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: goto -81 -> 67
    //   151: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   154: goto +276 -> 430
    //   157: aload_0
    //   158: instanceof 371
    //   161: ifeq +104 -> 265
    //   164: aload 6
    //   166: astore 8
    //   168: aload 8
    //   170: aload 7
    //   172: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   175: istore 9
    //   177: iload 9
    //   179: ifeq +20 -> 199
    //   182: iload 9
    //   184: ifeq +9 -> 193
    //   187: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   190: goto +240 -> 430
    //   193: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   196: goto +234 -> 430
    //   199: aload_0
    //   200: ldc_w 371
    //   203: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   206: dup
    //   207: astore 10
    //   209: checkcast 371	gnu/kawa/slib/srfi14$CharSet
    //   212: aload_1
    //   213: ldc 43
    //   215: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   218: dup
    //   219: astore 10
    //   221: checkcast 43	java/lang/CharSequence
    //   224: aload 8
    //   226: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: dup
    //   230: astore 10
    //   232: checkcast 177	java/lang/Number
    //   235: invokevirtual 181	java/lang/Number:intValue	()I
    //   238: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   241: invokestatic 379	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
    //   244: ifeq +15 -> 259
    //   247: iconst_1
    //   248: aload 8
    //   250: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   253: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: goto -90 -> 166
    //   259: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   262: goto +168 -> 430
    //   265: aload_0
    //   266: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   269: ifeq +134 -> 403
    //   272: aload 6
    //   274: aload 7
    //   276: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   279: istore 8
    //   281: iload 8
    //   283: ifeq +20 -> 303
    //   286: iload 8
    //   288: ifeq +9 -> 297
    //   291: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   294: goto +136 -> 430
    //   297: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   300: goto +130 -> 430
    //   303: aload 6
    //   305: astore 9
    //   307: aload_1
    //   308: ldc 43
    //   310: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   313: dup
    //   314: astore 11
    //   316: checkcast 43	java/lang/CharSequence
    //   319: aload 9
    //   321: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   324: dup
    //   325: astore 11
    //   327: checkcast 177	java/lang/Number
    //   330: invokevirtual 181	java/lang/Number:intValue	()I
    //   333: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   336: istore 10
    //   338: iconst_1
    //   339: aload 9
    //   341: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   344: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: astore 11
    //   349: aload 11
    //   351: aload 7
    //   353: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   356: ifeq +18 -> 374
    //   359: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   362: aload_0
    //   363: iload 10
    //   365: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   368: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: goto +59 -> 430
    //   374: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   377: aload_0
    //   378: iload 10
    //   380: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   383: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   389: ifeq +8 -> 397
    //   392: aload 11
    //   394: goto -89 -> 305
    //   397: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   400: goto +30 -> 430
    //   403: iconst_3
    //   404: anewarray 27	java/lang/Object
    //   407: dup
    //   408: iconst_0
    //   409: ldc_w 384
    //   412: aastore
    //   413: dup
    //   414: iconst_1
    //   415: getstatic 355	gnu/kawa/slib/srfi13:string$Mnevery	Lgnu/expr/ModuleMethod;
    //   418: aastore
    //   419: dup
    //   420: iconst_2
    //   421: aload_0
    //   422: aastore
    //   423: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   426: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   429: athrow
    //   430: areturn
    //   431: new 53	gnu/mapping/WrongType
    //   434: dup_x1
    //   435: swap
    //   436: ldc -16
    //   438: iconst_1
    //   439: aload 10
    //   441: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   444: athrow
    //   445: new 53	gnu/mapping/WrongType
    //   448: dup_x1
    //   449: swap
    //   450: ldc -16
    //   452: iconst_2
    //   453: aload 10
    //   455: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   458: athrow
    //   459: new 53	gnu/mapping/WrongType
    //   462: dup_x1
    //   463: swap
    //   464: ldc_w 373
    //   467: iconst_0
    //   468: aload 10
    //   470: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   473: athrow
    //   474: new 53	gnu/mapping/WrongType
    //   477: dup_x1
    //   478: swap
    //   479: ldc -16
    //   481: iconst_1
    //   482: aload 10
    //   484: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   487: athrow
    //   488: new 53	gnu/mapping/WrongType
    //   491: dup_x1
    //   492: swap
    //   493: ldc -16
    //   495: iconst_2
    //   496: aload 10
    //   498: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   501: athrow
    //   502: new 53	gnu/mapping/WrongType
    //   505: dup_x1
    //   506: swap
    //   507: ldc -16
    //   509: iconst_1
    //   510: aload 11
    //   512: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   515: athrow
    //   516: new 53	gnu/mapping/WrongType
    //   519: dup_x1
    //   520: swap
    //   521: ldc -16
    //   523: iconst_2
    //   524: aload 11
    //   526: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   529: athrow
    // Line number table:
    //   Java source line #530	-> byte code offset #0
    //   Java source line #531	-> byte code offset #9
    //   Java source line #532	-> byte code offset #58
    //   Java source line #533	-> byte code offset #65
    //   Java source line #534	-> byte code offset #69
    //   Java source line #535	-> byte code offset #100
    //   Java source line #536	-> byte code offset #139
    //   Java source line #538	-> byte code offset #157
    //   Java source line #539	-> byte code offset #164
    //   Java source line #540	-> byte code offset #168
    //   Java source line #541	-> byte code offset #199
    //   Java source line #542	-> byte code offset #247
    //   Java source line #544	-> byte code offset #265
    //   Java source line #545	-> byte code offset #272
    //   Java source line #546	-> byte code offset #303
    //   Java source line #547	-> byte code offset #307
    //   Java source line #548	-> byte code offset #338
    //   Java source line #549	-> byte code offset #349
    //   Java source line #550	-> byte code offset #374
    //   Java source line #552	-> byte code offset #403
    //   Java source line #535	-> byte code offset #431
    //   Java source line #541	-> byte code offset #459
    //   Java source line #547	-> byte code offset #502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	criterion	Object
    //   0	430	1	s	Object
    //   0	430	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstart$Plend	LList
    //   6	44	4	localObject1	Object
    //   20	32	5	i	int
    //   38	1	6	localObject2	Object
    //   58	246	6	start	Object
    //   56	296	7	end	Object
    //   67	74	8	i	Object
    //   166	83	8	i	Object
    //   279	8	8	x	boolean
    //   76	8	9	x	boolean
    //   175	8	9	x	boolean
    //   305	35	9	i	Object
    //   114	117	10	localObject3	Object
    //   336	1	10	j	int
    //   349	148	10	c	int
    //   314	12	11	localObject4	Object
    //   347	178	11	i1	Object
    //   431	1	20	localClassCastException1	ClassCastException
    //   445	1	21	localClassCastException2	ClassCastException
    //   459	1	22	localClassCastException3	ClassCastException
    //   474	1	23	localClassCastException4	ClassCastException
    //   488	1	24	localClassCastException5	ClassCastException
    //   502	1	25	localClassCastException6	ClassCastException
    //   516	1	26	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   116	119	431	java/lang/ClassCastException
    //   127	133	445	java/lang/ClassCastException
    //   209	212	459	java/lang/ClassCastException
    //   221	224	474	java/lang/ClassCastException
    //   232	238	488	java/lang/ClassCastException
    //   316	319	502	java/lang/ClassCastException
    //   327	333	516	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringAny$V(Object criterion, Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 387	gnu/kawa/slib/srfi13:string$Mnany	Lgnu/expr/ModuleMethod;
    //   12: aload_1
    //   13: aload_3
    //   14: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload_0
    //   59: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   62: ifeq +103 -> 165
    //   65: aload 6
    //   67: astore 8
    //   69: aload 8
    //   71: aload 7
    //   73: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   76: ifeq +83 -> 159
    //   79: aload_0
    //   80: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   86: aload_1
    //   87: ldc 43
    //   89: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 10
    //   95: checkcast 43	java/lang/CharSequence
    //   98: aload 8
    //   100: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: dup
    //   104: astore 10
    //   106: checkcast 177	java/lang/Number
    //   109: invokevirtual 181	java/lang/Number:intValue	()I
    //   112: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   115: if_icmpne +7 -> 122
    //   118: iconst_1
    //   119: goto +4 -> 123
    //   122: iconst_0
    //   123: istore 9
    //   125: iload 9
    //   127: ifeq +20 -> 147
    //   130: iload 9
    //   132: ifeq +9 -> 141
    //   135: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   138: goto +288 -> 426
    //   141: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   144: goto +282 -> 426
    //   147: iconst_1
    //   148: aload 8
    //   150: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   153: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: goto -89 -> 67
    //   159: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   162: goto +264 -> 426
    //   165: aload_0
    //   166: instanceof 371
    //   169: ifeq +104 -> 273
    //   172: aload 6
    //   174: astore 8
    //   176: aload 8
    //   178: aload 7
    //   180: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   183: ifeq +84 -> 267
    //   186: aload_0
    //   187: ldc_w 371
    //   190: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   193: dup
    //   194: astore 10
    //   196: checkcast 371	gnu/kawa/slib/srfi14$CharSet
    //   199: aload_1
    //   200: ldc 43
    //   202: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   205: dup
    //   206: astore 10
    //   208: checkcast 43	java/lang/CharSequence
    //   211: aload 8
    //   213: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   216: dup
    //   217: astore 10
    //   219: checkcast 177	java/lang/Number
    //   222: invokevirtual 181	java/lang/Number:intValue	()I
    //   225: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   228: invokestatic 379	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
    //   231: istore 9
    //   233: iload 9
    //   235: ifeq +20 -> 255
    //   238: iload 9
    //   240: ifeq +9 -> 249
    //   243: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   246: goto +180 -> 426
    //   249: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   252: goto +174 -> 426
    //   255: iconst_1
    //   256: aload 8
    //   258: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   261: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: goto -90 -> 174
    //   267: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   270: goto +156 -> 426
    //   273: aload_0
    //   274: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   277: ifeq +122 -> 399
    //   280: aload 6
    //   282: aload 7
    //   284: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   287: ifeq +106 -> 393
    //   290: aload 6
    //   292: astore 8
    //   294: aload_1
    //   295: ldc 43
    //   297: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   300: dup
    //   301: astore 10
    //   303: checkcast 43	java/lang/CharSequence
    //   306: aload 8
    //   308: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: dup
    //   312: astore 10
    //   314: checkcast 177	java/lang/Number
    //   317: invokevirtual 181	java/lang/Number:intValue	()I
    //   320: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   323: istore 9
    //   325: iconst_1
    //   326: aload 8
    //   328: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   331: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: astore 10
    //   336: aload 10
    //   338: aload 7
    //   340: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   343: ifeq +18 -> 361
    //   346: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   349: aload_0
    //   350: iload 9
    //   352: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   355: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: goto +68 -> 426
    //   361: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   364: aload_0
    //   365: iload 9
    //   367: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   370: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   373: astore 11
    //   375: aload 11
    //   377: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   380: ifeq +8 -> 388
    //   383: aload 11
    //   385: goto +41 -> 426
    //   388: aload 10
    //   390: goto -98 -> 292
    //   393: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   396: goto +30 -> 426
    //   399: iconst_3
    //   400: anewarray 27	java/lang/Object
    //   403: dup
    //   404: iconst_0
    //   405: ldc_w 384
    //   408: aastore
    //   409: dup
    //   410: iconst_1
    //   411: getstatic 387	gnu/kawa/slib/srfi13:string$Mnany	Lgnu/expr/ModuleMethod;
    //   414: aastore
    //   415: dup
    //   416: iconst_2
    //   417: aload_0
    //   418: aastore
    //   419: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   422: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   425: athrow
    //   426: areturn
    //   427: new 53	gnu/mapping/WrongType
    //   430: dup_x1
    //   431: swap
    //   432: ldc -16
    //   434: iconst_1
    //   435: aload 10
    //   437: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   440: athrow
    //   441: new 53	gnu/mapping/WrongType
    //   444: dup_x1
    //   445: swap
    //   446: ldc -16
    //   448: iconst_2
    //   449: aload 10
    //   451: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   454: athrow
    //   455: new 53	gnu/mapping/WrongType
    //   458: dup_x1
    //   459: swap
    //   460: ldc_w 373
    //   463: iconst_0
    //   464: aload 10
    //   466: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   469: athrow
    //   470: new 53	gnu/mapping/WrongType
    //   473: dup_x1
    //   474: swap
    //   475: ldc -16
    //   477: iconst_1
    //   478: aload 10
    //   480: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   483: athrow
    //   484: new 53	gnu/mapping/WrongType
    //   487: dup_x1
    //   488: swap
    //   489: ldc -16
    //   491: iconst_2
    //   492: aload 10
    //   494: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   497: athrow
    //   498: new 53	gnu/mapping/WrongType
    //   501: dup_x1
    //   502: swap
    //   503: ldc -16
    //   505: iconst_1
    //   506: aload 10
    //   508: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   511: athrow
    //   512: new 53	gnu/mapping/WrongType
    //   515: dup_x1
    //   516: swap
    //   517: ldc -16
    //   519: iconst_2
    //   520: aload 10
    //   522: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   525: athrow
    // Line number table:
    //   Java source line #556	-> byte code offset #0
    //   Java source line #557	-> byte code offset #9
    //   Java source line #558	-> byte code offset #58
    //   Java source line #559	-> byte code offset #65
    //   Java source line #560	-> byte code offset #69
    //   Java source line #561	-> byte code offset #79
    //   Java source line #562	-> byte code offset #147
    //   Java source line #564	-> byte code offset #165
    //   Java source line #565	-> byte code offset #172
    //   Java source line #566	-> byte code offset #176
    //   Java source line #567	-> byte code offset #186
    //   Java source line #568	-> byte code offset #255
    //   Java source line #570	-> byte code offset #273
    //   Java source line #571	-> byte code offset #280
    //   Java source line #572	-> byte code offset #290
    //   Java source line #573	-> byte code offset #294
    //   Java source line #574	-> byte code offset #325
    //   Java source line #575	-> byte code offset #336
    //   Java source line #576	-> byte code offset #361
    //   Java source line #578	-> byte code offset #399
    //   Java source line #561	-> byte code offset #427
    //   Java source line #567	-> byte code offset #455
    //   Java source line #573	-> byte code offset #498
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	criterion	Object
    //   0	426	1	s	Object
    //   0	426	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstart$Plend	LList
    //   6	44	4	localObject1	Object
    //   20	32	5	i	int
    //   38	1	6	localObject2	Object
    //   58	233	6	start	Object
    //   56	283	7	end	Object
    //   67	82	8	i	Object
    //   174	83	8	i	Object
    //   292	35	8	i	Object
    //   123	8	9	x	boolean
    //   231	93	9	x	boolean
    //   336	30	9	c	int
    //   93	220	10	localObject3	Object
    //   334	187	10	i1	Object
    //   373	11	11	x	Object
    //   427	1	18	localClassCastException1	ClassCastException
    //   441	1	19	localClassCastException2	ClassCastException
    //   455	1	20	localClassCastException3	ClassCastException
    //   470	1	21	localClassCastException4	ClassCastException
    //   484	1	22	localClassCastException5	ClassCastException
    //   498	1	23	localClassCastException6	ClassCastException
    //   512	1	24	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   95	98	427	java/lang/ClassCastException
    //   106	112	441	java/lang/ClassCastException
    //   196	199	455	java/lang/ClassCastException
    //   208	211	470	java/lang/ClassCastException
    //   219	225	484	java/lang/ClassCastException
    //   303	306	498	java/lang/ClassCastException
    //   314	320	512	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcStringPrefixLength(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 27	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: iconst_m1
    //   7: aload_2
    //   8: aload_1
    //   9: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: iconst_m1
    //   16: aload 5
    //   18: aload 4
    //   20: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: aastore
    //   24: invokestatic 324	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   27: astore 6
    //   29: iconst_1
    //   30: aload_1
    //   31: aload 6
    //   33: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: astore 7
    //   38: aload_0
    //   39: aload_3
    //   40: if_acmpne +17 -> 57
    //   43: aload_1
    //   44: aload 4
    //   46: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   49: ifeq +8 -> 57
    //   52: aload 6
    //   54: goto +124 -> 178
    //   57: aload_1
    //   58: aload 4
    //   60: astore 9
    //   62: astore 8
    //   64: aload 8
    //   66: aload 7
    //   68: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   71: istore 10
    //   73: iload 10
    //   75: ifeq +11 -> 86
    //   78: iload 10
    //   80: ifeq +77 -> 157
    //   83: goto +64 -> 147
    //   86: aload_0
    //   87: ldc 43
    //   89: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 11
    //   95: checkcast 43	java/lang/CharSequence
    //   98: aload 8
    //   100: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: dup
    //   104: astore 11
    //   106: checkcast 177	java/lang/Number
    //   109: invokevirtual 181	java/lang/Number:intValue	()I
    //   112: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   115: aload_3
    //   116: ldc 43
    //   118: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   121: dup
    //   122: astore 11
    //   124: checkcast 43	java/lang/CharSequence
    //   127: aload 9
    //   129: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: dup
    //   133: astore 11
    //   135: checkcast 177	java/lang/Number
    //   138: invokevirtual 181	java/lang/Number:intValue	()I
    //   141: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   144: if_icmpeq +13 -> 157
    //   147: iconst_m1
    //   148: aload 8
    //   150: aload_1
    //   151: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: goto +24 -> 178
    //   157: iconst_1
    //   158: aload 8
    //   160: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   163: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: iconst_1
    //   167: aload 9
    //   169: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   172: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: goto -115 -> 60
    //   178: areturn
    //   179: new 53	gnu/mapping/WrongType
    //   182: dup_x1
    //   183: swap
    //   184: ldc -16
    //   186: iconst_1
    //   187: aload 11
    //   189: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   192: athrow
    //   193: new 53	gnu/mapping/WrongType
    //   196: dup_x1
    //   197: swap
    //   198: ldc -16
    //   200: iconst_2
    //   201: aload 11
    //   203: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   206: athrow
    //   207: new 53	gnu/mapping/WrongType
    //   210: dup_x1
    //   211: swap
    //   212: ldc -16
    //   214: iconst_1
    //   215: aload 11
    //   217: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: new 53	gnu/mapping/WrongType
    //   224: dup_x1
    //   225: swap
    //   226: ldc -16
    //   228: iconst_2
    //   229: aload 11
    //   231: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   234: athrow
    // Line number table:
    //   Java source line #603	-> byte code offset #0
    //   Java source line #604	-> byte code offset #0
    //   Java source line #605	-> byte code offset #29
    //   Java source line #607	-> byte code offset #38
    //   Java source line #610	-> byte code offset #57
    //   Java source line #611	-> byte code offset #64
    //   Java source line #612	-> byte code offset #86
    //   Java source line #613	-> byte code offset #115
    //   Java source line #614	-> byte code offset #147
    //   Java source line #615	-> byte code offset #157
    //   Java source line #612	-> byte code offset #179
    //   Java source line #613	-> byte code offset #207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	s1	Object
    //   0	178	1	start1	Object
    //   0	178	2	end1	Object
    //   0	178	3	s2	Object
    //   0	178	4	start2	Object
    //   0	178	5	end2	Object
    //   27	26	6	delta	Object
    //   36	31	7	end1	Object
    //   62	97	8	i	Object
    //   60	1	9	localObject1	Object
    //   64	104	9	j	Object
    //   71	8	10	x	boolean
    //   93	137	11	localObject2	Object
    //   179	1	13	localClassCastException1	ClassCastException
    //   193	1	14	localClassCastException2	ClassCastException
    //   207	1	15	localClassCastException3	ClassCastException
    //   221	1	16	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   95	98	179	java/lang/ClassCastException
    //   106	112	193	java/lang/ClassCastException
    //   124	127	207	java/lang/ClassCastException
    //   135	141	221	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcStringSuffixLength(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 27	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: iconst_m1
    //   7: aload_2
    //   8: aload_1
    //   9: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: iconst_m1
    //   16: aload 5
    //   18: aload 4
    //   20: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: aastore
    //   24: invokestatic 324	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   27: astore 6
    //   29: iconst_m1
    //   30: aload_2
    //   31: aload 6
    //   33: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: astore 7
    //   38: aload_0
    //   39: aload_3
    //   40: if_acmpne +17 -> 57
    //   43: aload_2
    //   44: aload 5
    //   46: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   49: ifeq +8 -> 57
    //   52: aload 6
    //   54: goto +145 -> 199
    //   57: iconst_m1
    //   58: aload_2
    //   59: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   62: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: iconst_m1
    //   66: aload 5
    //   68: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   71: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: astore 9
    //   76: astore 8
    //   78: aload 8
    //   80: aload 7
    //   82: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   85: istore 10
    //   87: iload 10
    //   89: ifeq +11 -> 100
    //   92: iload 10
    //   94: ifeq +84 -> 178
    //   97: goto +64 -> 161
    //   100: aload_0
    //   101: ldc 43
    //   103: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   106: dup
    //   107: astore 11
    //   109: checkcast 43	java/lang/CharSequence
    //   112: aload 8
    //   114: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: dup
    //   118: astore 11
    //   120: checkcast 177	java/lang/Number
    //   123: invokevirtual 181	java/lang/Number:intValue	()I
    //   126: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   129: aload_3
    //   130: ldc 43
    //   132: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   135: dup
    //   136: astore 11
    //   138: checkcast 43	java/lang/CharSequence
    //   141: aload 9
    //   143: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: dup
    //   147: astore 11
    //   149: checkcast 177	java/lang/Number
    //   152: invokevirtual 181	java/lang/Number:intValue	()I
    //   155: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   158: if_icmpeq +20 -> 178
    //   161: iconst_m1
    //   162: iconst_m1
    //   163: aload_2
    //   164: aload 8
    //   166: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   172: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: goto +24 -> 199
    //   178: iconst_m1
    //   179: aload 8
    //   181: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   184: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: iconst_m1
    //   188: aload 9
    //   190: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   193: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: goto -122 -> 74
    //   199: areturn
    //   200: new 53	gnu/mapping/WrongType
    //   203: dup_x1
    //   204: swap
    //   205: ldc -16
    //   207: iconst_1
    //   208: aload 11
    //   210: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   213: athrow
    //   214: new 53	gnu/mapping/WrongType
    //   217: dup_x1
    //   218: swap
    //   219: ldc -16
    //   221: iconst_2
    //   222: aload 11
    //   224: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   227: athrow
    //   228: new 53	gnu/mapping/WrongType
    //   231: dup_x1
    //   232: swap
    //   233: ldc -16
    //   235: iconst_1
    //   236: aload 11
    //   238: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   241: athrow
    //   242: new 53	gnu/mapping/WrongType
    //   245: dup_x1
    //   246: swap
    //   247: ldc -16
    //   249: iconst_2
    //   250: aload 11
    //   252: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    // Line number table:
    //   Java source line #617	-> byte code offset #0
    //   Java source line #618	-> byte code offset #0
    //   Java source line #619	-> byte code offset #29
    //   Java source line #621	-> byte code offset #38
    //   Java source line #624	-> byte code offset #57
    //   Java source line #625	-> byte code offset #78
    //   Java source line #626	-> byte code offset #100
    //   Java source line #627	-> byte code offset #129
    //   Java source line #628	-> byte code offset #161
    //   Java source line #629	-> byte code offset #178
    //   Java source line #626	-> byte code offset #200
    //   Java source line #627	-> byte code offset #228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	s1	Object
    //   0	199	1	start1	Object
    //   0	199	2	end1	Object
    //   0	199	3	s2	Object
    //   0	199	4	start2	Object
    //   0	199	5	end2	Object
    //   27	26	6	delta	Object
    //   36	45	7	start1	Object
    //   76	104	8	i	Object
    //   74	1	9	localObject1	Object
    //   78	111	9	j	Object
    //   85	8	10	x	boolean
    //   107	144	11	localObject2	Object
    //   200	1	13	localClassCastException1	ClassCastException
    //   214	1	14	localClassCastException2	ClassCastException
    //   228	1	15	localClassCastException3	ClassCastException
    //   242	1	16	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   109	112	200	java/lang/ClassCastException
    //   120	126	214	java/lang/ClassCastException
    //   138	141	228	java/lang/ClassCastException
    //   149	155	242	java/lang/ClassCastException
  }
  
  /* Error */
  public static int $PcStringPrefixLengthCi(Object s1, int start1, int end1, Object s2, int start2, int end2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 27	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: iload_2
    //   7: iload_1
    //   8: isub
    //   9: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: iload 5
    //   17: iload 4
    //   19: isub
    //   20: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: invokestatic 324	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   27: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: dup
    //   31: astore 7
    //   33: checkcast 177	java/lang/Number
    //   36: invokevirtual 181	java/lang/Number:intValue	()I
    //   39: istore 6
    //   41: iload_1
    //   42: iload 6
    //   44: iadd
    //   45: istore 7
    //   47: aload_0
    //   48: aload_3
    //   49: if_acmpne +14 -> 63
    //   52: iload_1
    //   53: iload 4
    //   55: if_icmpne +8 -> 63
    //   58: iload 6
    //   60: goto +96 -> 156
    //   63: iload_1
    //   64: iload 4
    //   66: istore 9
    //   68: istore 8
    //   70: iload 8
    //   72: iload 7
    //   74: if_icmplt +7 -> 81
    //   77: iconst_1
    //   78: goto +4 -> 82
    //   81: iconst_0
    //   82: istore 10
    //   84: iload 10
    //   86: ifeq +11 -> 97
    //   89: iload 10
    //   91: ifeq +56 -> 147
    //   94: goto +46 -> 140
    //   97: aload_0
    //   98: ldc 43
    //   100: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   103: dup
    //   104: astore 11
    //   106: checkcast 43	java/lang/CharSequence
    //   109: iload 8
    //   111: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   114: invokestatic 400	java/lang/Character:toUpperCase	(I)I
    //   117: aload_3
    //   118: ldc 43
    //   120: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   123: dup
    //   124: astore 11
    //   126: checkcast 43	java/lang/CharSequence
    //   129: iload 9
    //   131: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   134: invokestatic 400	java/lang/Character:toUpperCase	(I)I
    //   137: if_icmpeq +10 -> 147
    //   140: iload 8
    //   142: iload_1
    //   143: isub
    //   144: goto +12 -> 156
    //   147: iinc 9 1
    //   150: iinc 8 1
    //   153: goto -83 -> 70
    //   156: ireturn
    //   157: new 53	gnu/mapping/WrongType
    //   160: dup_x1
    //   161: swap
    //   162: ldc_w 395
    //   165: bipush -2
    //   167: aload 7
    //   169: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   172: athrow
    //   173: new 53	gnu/mapping/WrongType
    //   176: dup_x1
    //   177: swap
    //   178: ldc -16
    //   180: iconst_1
    //   181: aload 11
    //   183: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: new 53	gnu/mapping/WrongType
    //   190: dup_x1
    //   191: swap
    //   192: ldc -16
    //   194: iconst_1
    //   195: aload 11
    //   197: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    // Line number table:
    //   Java source line #631	-> byte code offset #0
    //   Java source line #633	-> byte code offset #0
    //   Java source line #634	-> byte code offset #41
    //   Java source line #636	-> byte code offset #47
    //   Java source line #639	-> byte code offset #63
    //   Java source line #640	-> byte code offset #70
    //   Java source line #641	-> byte code offset #97
    //   Java source line #642	-> byte code offset #117
    //   Java source line #643	-> byte code offset #140
    //   Java source line #644	-> byte code offset #147
    //   Java source line #633	-> byte code offset #157
    //   Java source line #641	-> byte code offset #173
    //   Java source line #642	-> byte code offset #187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	s1	Object
    //   0	156	1	start1	int
    //   0	156	2	end1	int
    //   0	156	3	s2	Object
    //   0	156	4	start2	int
    //   0	156	5	end2	int
    //   41	115	6	delta	int
    //   47	109	7	end1	int
    //   70	86	8	i	int
    //   70	86	9	j	int
    //   84	72	10	x	boolean
    // Exception table:
    //   from	to	target	type
    //   33	39	157	java/lang/ClassCastException
    //   106	109	173	java/lang/ClassCastException
    //   126	129	187	java/lang/ClassCastException
  }
  
  /* Error */
  public static int $PcStringSuffixLengthCi(Object s1, int start1, int end1, Object s2, int start2, int end2)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 27	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: iload_2
    //   7: iload_1
    //   8: isub
    //   9: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: iload 5
    //   17: iload 4
    //   19: isub
    //   20: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: invokestatic 324	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   27: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: dup
    //   31: astore 7
    //   33: checkcast 177	java/lang/Number
    //   36: invokevirtual 181	java/lang/Number:intValue	()I
    //   39: istore 6
    //   41: iload_2
    //   42: iload 6
    //   44: isub
    //   45: istore 7
    //   47: aload_0
    //   48: aload_3
    //   49: if_acmpne +14 -> 63
    //   52: iload_2
    //   53: iload 5
    //   55: if_icmpne +8 -> 63
    //   58: iload 6
    //   60: goto +102 -> 162
    //   63: iload_2
    //   64: iconst_1
    //   65: isub
    //   66: iload 5
    //   68: iconst_1
    //   69: isub
    //   70: istore 9
    //   72: istore 8
    //   74: iload 8
    //   76: iload 7
    //   78: if_icmpge +7 -> 85
    //   81: iconst_1
    //   82: goto +4 -> 86
    //   85: iconst_0
    //   86: istore 10
    //   88: iload 10
    //   90: ifeq +11 -> 101
    //   93: iload 10
    //   95: ifeq +58 -> 153
    //   98: goto +46 -> 144
    //   101: aload_0
    //   102: ldc 43
    //   104: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   107: dup
    //   108: astore 11
    //   110: checkcast 43	java/lang/CharSequence
    //   113: iload 8
    //   115: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   118: invokestatic 400	java/lang/Character:toUpperCase	(I)I
    //   121: aload_3
    //   122: ldc 43
    //   124: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   127: dup
    //   128: astore 11
    //   130: checkcast 43	java/lang/CharSequence
    //   133: iload 9
    //   135: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   138: invokestatic 400	java/lang/Character:toUpperCase	(I)I
    //   141: if_icmpeq +12 -> 153
    //   144: iload_2
    //   145: iload 8
    //   147: isub
    //   148: iconst_1
    //   149: isub
    //   150: goto +12 -> 162
    //   153: iinc 9 -1
    //   156: iinc 8 -1
    //   159: goto -85 -> 74
    //   162: ireturn
    //   163: new 53	gnu/mapping/WrongType
    //   166: dup_x1
    //   167: swap
    //   168: ldc_w 395
    //   171: bipush -2
    //   173: aload 7
    //   175: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   178: athrow
    //   179: new 53	gnu/mapping/WrongType
    //   182: dup_x1
    //   183: swap
    //   184: ldc -16
    //   186: iconst_1
    //   187: aload 11
    //   189: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   192: athrow
    //   193: new 53	gnu/mapping/WrongType
    //   196: dup_x1
    //   197: swap
    //   198: ldc -16
    //   200: iconst_1
    //   201: aload 11
    //   203: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   206: athrow
    // Line number table:
    //   Java source line #646	-> byte code offset #0
    //   Java source line #648	-> byte code offset #0
    //   Java source line #649	-> byte code offset #41
    //   Java source line #651	-> byte code offset #47
    //   Java source line #654	-> byte code offset #63
    //   Java source line #655	-> byte code offset #74
    //   Java source line #656	-> byte code offset #101
    //   Java source line #657	-> byte code offset #121
    //   Java source line #658	-> byte code offset #144
    //   Java source line #659	-> byte code offset #153
    //   Java source line #648	-> byte code offset #163
    //   Java source line #656	-> byte code offset #179
    //   Java source line #657	-> byte code offset #193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	s1	Object
    //   0	162	1	start1	int
    //   0	162	2	end1	int
    //   0	162	3	s2	Object
    //   0	162	4	start2	int
    //   0	162	5	end2	int
    //   41	121	6	delta	int
    //   47	115	7	start1	int
    //   74	88	8	i	int
    //   74	88	9	j	int
    //   88	74	10	x	boolean
    // Exception table:
    //   from	to	target	type
    //   33	39	163	java/lang/ClassCastException
    //   110	113	179	java/lang/ClassCastException
    //   130	133	193	java/lang/ClassCastException
  }
  
  /* Error */
  public static int stringPrefixLengthCi$V(Object s1, Object s2, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 416	gnu/kawa/slib/srfi13:string$Mnprefix$Mnlength$Mnci	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 145	gnu/kawa/slib/srfi13:stringParseStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload 4
    //   60: iload 5
    //   62: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   65: istore 5
    //   67: aload 4
    //   69: iload 5
    //   71: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   74: astore 8
    //   76: getstatic 416	gnu/kawa/slib/srfi13:string$Mnprefix$Mnlength$Mnci	Lgnu/expr/ModuleMethod;
    //   79: aload_1
    //   80: aload 6
    //   82: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   85: astore 9
    //   87: iconst_0
    //   88: istore 10
    //   90: aload 9
    //   92: iload 10
    //   94: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   97: istore 10
    //   99: aload 9
    //   101: iload 10
    //   103: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   106: astore 11
    //   108: aload 9
    //   110: iload 10
    //   112: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   115: istore 10
    //   117: aload 9
    //   119: iload 10
    //   121: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   124: astore 12
    //   126: aload_0
    //   127: aload 7
    //   129: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: dup
    //   133: astore 13
    //   135: checkcast 177	java/lang/Number
    //   138: invokevirtual 181	java/lang/Number:intValue	()I
    //   141: aload 8
    //   143: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: dup
    //   147: astore 13
    //   149: checkcast 177	java/lang/Number
    //   152: invokevirtual 181	java/lang/Number:intValue	()I
    //   155: aload_1
    //   156: aload 11
    //   158: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: dup
    //   162: astore 13
    //   164: checkcast 177	java/lang/Number
    //   167: invokevirtual 181	java/lang/Number:intValue	()I
    //   170: aload 12
    //   172: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: dup
    //   176: astore 13
    //   178: checkcast 177	java/lang/Number
    //   181: invokevirtual 181	java/lang/Number:intValue	()I
    //   184: invokestatic 422	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   187: ireturn
    //   188: new 53	gnu/mapping/WrongType
    //   191: dup_x1
    //   192: swap
    //   193: ldc_w 418
    //   196: iconst_1
    //   197: aload 13
    //   199: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: new 53	gnu/mapping/WrongType
    //   206: dup_x1
    //   207: swap
    //   208: ldc_w 418
    //   211: iconst_2
    //   212: aload 13
    //   214: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    //   218: new 53	gnu/mapping/WrongType
    //   221: dup_x1
    //   222: swap
    //   223: ldc_w 418
    //   226: iconst_4
    //   227: aload 13
    //   229: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: new 53	gnu/mapping/WrongType
    //   236: dup_x1
    //   237: swap
    //   238: ldc_w 418
    //   241: iconst_5
    //   242: aload 13
    //   244: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   247: athrow
    // Line number table:
    //   Java source line #672	-> byte code offset #0
    //   Java source line #673	-> byte code offset #9
    //   Java source line #674	-> byte code offset #9
    //   Java source line #673	-> byte code offset #9
    //   Java source line #674	-> byte code offset #12
    //   Java source line #673	-> byte code offset #76
    //   Java source line #674	-> byte code offset #79
    //   Java source line #673	-> byte code offset #80
    //   Java source line #675	-> byte code offset #126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	s1	Object
    //   0	187	1	s2	Object
    //   0	187	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstarts$Plends	LList
    //   6	62	4	localObject1	Object
    //   20	50	5	i	int
    //   38	1	6	localObject2	Object
    //   76	5	6	rest	Object
    //   56	1	7	localObject3	Object
    //   76	52	7	start1	Object
    //   74	68	8	end1	Object
    //   85	33	9	localValues	Values
    //   88	32	10	j	int
    //   106	1	11	localObject4	Object
    //   126	31	11	start2	Object
    //   124	47	12	end2	Object
    //   133	110	13	localObject5	Object
    //   188	1	17	localClassCastException1	ClassCastException
    //   203	1	18	localClassCastException2	ClassCastException
    //   218	1	19	localClassCastException3	ClassCastException
    //   233	1	20	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   135	141	188	java/lang/ClassCastException
    //   149	155	203	java/lang/ClassCastException
    //   164	170	218	java/lang/ClassCastException
    //   178	184	233	java/lang/ClassCastException
  }
  
  /* Error */
  public static int stringSuffixLengthCi$V(Object s1, Object s2, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 425	gnu/kawa/slib/srfi13:string$Mnsuffix$Mnlength$Mnci	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 145	gnu/kawa/slib/srfi13:stringParseStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload 4
    //   60: iload 5
    //   62: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   65: istore 5
    //   67: aload 4
    //   69: iload 5
    //   71: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   74: astore 8
    //   76: getstatic 425	gnu/kawa/slib/srfi13:string$Mnsuffix$Mnlength$Mnci	Lgnu/expr/ModuleMethod;
    //   79: aload_1
    //   80: aload 6
    //   82: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   85: astore 9
    //   87: iconst_0
    //   88: istore 10
    //   90: aload 9
    //   92: iload 10
    //   94: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   97: istore 10
    //   99: aload 9
    //   101: iload 10
    //   103: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   106: astore 11
    //   108: aload 9
    //   110: iload 10
    //   112: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   115: istore 10
    //   117: aload 9
    //   119: iload 10
    //   121: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   124: astore 12
    //   126: aload_0
    //   127: aload 7
    //   129: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: dup
    //   133: astore 13
    //   135: checkcast 177	java/lang/Number
    //   138: invokevirtual 181	java/lang/Number:intValue	()I
    //   141: aload 8
    //   143: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: dup
    //   147: astore 13
    //   149: checkcast 177	java/lang/Number
    //   152: invokevirtual 181	java/lang/Number:intValue	()I
    //   155: aload_1
    //   156: aload 11
    //   158: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: dup
    //   162: astore 13
    //   164: checkcast 177	java/lang/Number
    //   167: invokevirtual 181	java/lang/Number:intValue	()I
    //   170: aload 12
    //   172: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: dup
    //   176: astore 13
    //   178: checkcast 177	java/lang/Number
    //   181: invokevirtual 181	java/lang/Number:intValue	()I
    //   184: invokestatic 430	gnu/kawa/slib/srfi13:$PcStringSuffixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   187: ireturn
    //   188: new 53	gnu/mapping/WrongType
    //   191: dup_x1
    //   192: swap
    //   193: ldc_w 427
    //   196: iconst_1
    //   197: aload 13
    //   199: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: new 53	gnu/mapping/WrongType
    //   206: dup_x1
    //   207: swap
    //   208: ldc_w 427
    //   211: iconst_2
    //   212: aload 13
    //   214: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    //   218: new 53	gnu/mapping/WrongType
    //   221: dup_x1
    //   222: swap
    //   223: ldc_w 427
    //   226: iconst_4
    //   227: aload 13
    //   229: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: new 53	gnu/mapping/WrongType
    //   236: dup_x1
    //   237: swap
    //   238: ldc_w 427
    //   241: iconst_5
    //   242: aload 13
    //   244: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   247: athrow
    // Line number table:
    //   Java source line #677	-> byte code offset #0
    //   Java source line #678	-> byte code offset #9
    //   Java source line #679	-> byte code offset #9
    //   Java source line #678	-> byte code offset #9
    //   Java source line #679	-> byte code offset #12
    //   Java source line #678	-> byte code offset #76
    //   Java source line #679	-> byte code offset #79
    //   Java source line #678	-> byte code offset #80
    //   Java source line #680	-> byte code offset #126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	s1	Object
    //   0	187	1	s2	Object
    //   0	187	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstarts$Plends	LList
    //   6	62	4	localObject1	Object
    //   20	50	5	i	int
    //   38	1	6	localObject2	Object
    //   76	5	6	rest	Object
    //   56	1	7	localObject3	Object
    //   76	52	7	start1	Object
    //   74	68	8	end1	Object
    //   85	33	9	localValues	Values
    //   88	32	10	j	int
    //   106	1	11	localObject4	Object
    //   126	31	11	start2	Object
    //   124	47	12	end2	Object
    //   133	110	13	localObject5	Object
    //   188	1	17	localClassCastException1	ClassCastException
    //   203	1	18	localClassCastException2	ClassCastException
    //   218	1	19	localClassCastException3	ClassCastException
    //   233	1	20	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   135	141	188	java/lang/ClassCastException
    //   149	155	203	java/lang/ClassCastException
    //   164	170	218	java/lang/ClassCastException
    //   178	184	233	java/lang/ClassCastException
  }
  
  /* Error */
  public static boolean $PcStringPrefixCi$Qu(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_2
    //   2: aload_1
    //   3: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: astore 6
    //   8: aload 6
    //   10: iconst_m1
    //   11: aload 5
    //   13: aload 4
    //   15: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   21: ifeq +73 -> 94
    //   24: aload 6
    //   26: aload_0
    //   27: aload_1
    //   28: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: dup
    //   32: astore 7
    //   34: checkcast 177	java/lang/Number
    //   37: invokevirtual 181	java/lang/Number:intValue	()I
    //   40: aload_2
    //   41: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: dup
    //   45: astore 7
    //   47: checkcast 177	java/lang/Number
    //   50: invokevirtual 181	java/lang/Number:intValue	()I
    //   53: aload_3
    //   54: aload 4
    //   56: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: dup
    //   60: astore 7
    //   62: checkcast 177	java/lang/Number
    //   65: invokevirtual 181	java/lang/Number:intValue	()I
    //   68: aload 5
    //   70: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: dup
    //   74: astore 7
    //   76: checkcast 177	java/lang/Number
    //   79: invokevirtual 181	java/lang/Number:intValue	()I
    //   82: invokestatic 422	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   85: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   91: goto +4 -> 95
    //   94: iconst_0
    //   95: ireturn
    //   96: new 53	gnu/mapping/WrongType
    //   99: dup_x1
    //   100: swap
    //   101: ldc_w 418
    //   104: iconst_1
    //   105: aload 7
    //   107: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    //   111: new 53	gnu/mapping/WrongType
    //   114: dup_x1
    //   115: swap
    //   116: ldc_w 418
    //   119: iconst_2
    //   120: aload 7
    //   122: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: new 53	gnu/mapping/WrongType
    //   129: dup_x1
    //   130: swap
    //   131: ldc_w 418
    //   134: iconst_4
    //   135: aload 7
    //   137: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   140: athrow
    //   141: new 53	gnu/mapping/WrongType
    //   144: dup_x1
    //   145: swap
    //   146: ldc_w 418
    //   149: iconst_5
    //   150: aload 7
    //   152: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   155: athrow
    // Line number table:
    //   Java source line #726	-> byte code offset #0
    //   Java source line #727	-> byte code offset #0
    //   Java source line #728	-> byte code offset #8
    //   Java source line #729	-> byte code offset #24
    //   Java source line #730	-> byte code offset #53
    //   Java source line #729	-> byte code offset #96
    //   Java source line #730	-> byte code offset #126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	s1	Object
    //   0	95	1	start1	Object
    //   0	95	2	end1	Object
    //   0	95	3	s2	Object
    //   0	95	4	start2	Object
    //   0	95	5	end2	Object
    //   6	19	6	len1	Object
    //   32	119	7	localObject1	Object
    //   96	1	8	localClassCastException1	ClassCastException
    //   111	1	9	localClassCastException2	ClassCastException
    //   126	1	10	localClassCastException3	ClassCastException
    //   141	1	11	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   34	40	96	java/lang/ClassCastException
    //   47	53	111	java/lang/ClassCastException
    //   62	68	126	java/lang/ClassCastException
    //   76	82	141	java/lang/ClassCastException
  }
  
  /* Error */
  public static boolean $PcStringSuffixCi$Qu(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_2
    //   2: aload_1
    //   3: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: astore 6
    //   8: aload 6
    //   10: iconst_m1
    //   11: aload 5
    //   13: aload 4
    //   15: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   21: ifeq +73 -> 94
    //   24: aload 6
    //   26: aload_0
    //   27: aload_1
    //   28: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: dup
    //   32: astore 7
    //   34: checkcast 177	java/lang/Number
    //   37: invokevirtual 181	java/lang/Number:intValue	()I
    //   40: aload_2
    //   41: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: dup
    //   45: astore 7
    //   47: checkcast 177	java/lang/Number
    //   50: invokevirtual 181	java/lang/Number:intValue	()I
    //   53: aload_3
    //   54: aload 4
    //   56: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: dup
    //   60: astore 7
    //   62: checkcast 177	java/lang/Number
    //   65: invokevirtual 181	java/lang/Number:intValue	()I
    //   68: aload 5
    //   70: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: dup
    //   74: astore 7
    //   76: checkcast 177	java/lang/Number
    //   79: invokevirtual 181	java/lang/Number:intValue	()I
    //   82: invokestatic 430	gnu/kawa/slib/srfi13:$PcStringSuffixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   85: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   91: goto +4 -> 95
    //   94: iconst_0
    //   95: ireturn
    //   96: new 53	gnu/mapping/WrongType
    //   99: dup_x1
    //   100: swap
    //   101: ldc_w 427
    //   104: iconst_1
    //   105: aload 7
    //   107: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    //   111: new 53	gnu/mapping/WrongType
    //   114: dup_x1
    //   115: swap
    //   116: ldc_w 427
    //   119: iconst_2
    //   120: aload 7
    //   122: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: new 53	gnu/mapping/WrongType
    //   129: dup_x1
    //   130: swap
    //   131: ldc_w 427
    //   134: iconst_4
    //   135: aload 7
    //   137: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   140: athrow
    //   141: new 53	gnu/mapping/WrongType
    //   144: dup_x1
    //   145: swap
    //   146: ldc_w 427
    //   149: iconst_5
    //   150: aload 7
    //   152: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   155: athrow
    // Line number table:
    //   Java source line #732	-> byte code offset #0
    //   Java source line #733	-> byte code offset #0
    //   Java source line #734	-> byte code offset #8
    //   Java source line #735	-> byte code offset #24
    //   Java source line #736	-> byte code offset #53
    //   Java source line #735	-> byte code offset #96
    //   Java source line #736	-> byte code offset #126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	s1	Object
    //   0	95	1	start1	Object
    //   0	95	2	end1	Object
    //   0	95	3	s2	Object
    //   0	95	4	start2	Object
    //   0	95	5	end2	Object
    //   6	19	6	len1	Object
    //   32	119	7	localObject1	Object
    //   96	1	8	localClassCastException1	ClassCastException
    //   111	1	9	localClassCastException2	ClassCastException
    //   126	1	10	localClassCastException3	ClassCastException
    //   141	1	11	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   34	40	96	java/lang/ClassCastException
    //   47	53	111	java/lang/ClassCastException
    //   62	68	126	java/lang/ClassCastException
    //   76	82	141	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcStringCompare(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2, Object proc$Ls, Object proc$Eq, Object proc$Gr)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_2
    //   2: aload_1
    //   3: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: astore 9
    //   8: iconst_m1
    //   9: aload 5
    //   11: aload 4
    //   13: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: astore 10
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: aload_3
    //   22: aload 4
    //   24: aload 5
    //   26: invokestatic 407	gnu/kawa/slib/srfi13:$PcStringPrefixLength	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: astore 11
    //   31: aload 11
    //   33: aload 9
    //   35: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   38: ifeq +30 -> 68
    //   41: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   44: aload 11
    //   46: aload 10
    //   48: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   51: ifeq +8 -> 59
    //   54: aload 7
    //   56: goto +5 -> 61
    //   59: aload 6
    //   61: aload_2
    //   62: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: goto +110 -> 175
    //   68: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   71: aload 11
    //   73: aload 10
    //   75: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   78: ifeq +8 -> 86
    //   81: aload 8
    //   83: goto +82 -> 165
    //   86: aload_0
    //   87: ldc 43
    //   89: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 12
    //   95: checkcast 43	java/lang/CharSequence
    //   98: iconst_1
    //   99: aload_1
    //   100: aload 11
    //   102: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   108: dup
    //   109: astore 12
    //   111: checkcast 177	java/lang/Number
    //   114: invokevirtual 181	java/lang/Number:intValue	()I
    //   117: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   120: aload_3
    //   121: ldc 43
    //   123: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   126: dup
    //   127: astore 12
    //   129: checkcast 43	java/lang/CharSequence
    //   132: iconst_1
    //   133: aload 4
    //   135: aload 11
    //   137: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: dup
    //   144: astore 12
    //   146: checkcast 177	java/lang/Number
    //   149: invokevirtual 181	java/lang/Number:intValue	()I
    //   152: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   155: if_icmpge +8 -> 163
    //   158: aload 6
    //   160: goto +5 -> 165
    //   163: aload 8
    //   165: iconst_1
    //   166: aload 11
    //   168: aload_1
    //   169: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: areturn
    //   176: new 53	gnu/mapping/WrongType
    //   179: dup_x1
    //   180: swap
    //   181: ldc -16
    //   183: iconst_1
    //   184: aload 12
    //   186: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   189: athrow
    //   190: new 53	gnu/mapping/WrongType
    //   193: dup_x1
    //   194: swap
    //   195: ldc -16
    //   197: iconst_2
    //   198: aload 12
    //   200: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: new 53	gnu/mapping/WrongType
    //   207: dup_x1
    //   208: swap
    //   209: ldc -16
    //   211: iconst_1
    //   212: aload 12
    //   214: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    //   218: new 53	gnu/mapping/WrongType
    //   221: dup_x1
    //   222: swap
    //   223: ldc -16
    //   225: iconst_2
    //   226: aload 12
    //   228: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   231: athrow
    // Line number table:
    //   Java source line #747	-> byte code offset #0
    //   Java source line #749	-> byte code offset #0
    //   Java source line #750	-> byte code offset #8
    //   Java source line #751	-> byte code offset #18
    //   Java source line #752	-> byte code offset #31
    //   Java source line #753	-> byte code offset #41
    //   Java source line #754	-> byte code offset #68
    //   Java source line #756	-> byte code offset #86
    //   Java source line #757	-> byte code offset #120
    //   Java source line #756	-> byte code offset #158
    //   Java source line #759	-> byte code offset #165
    //   Java source line #756	-> byte code offset #176
    //   Java source line #757	-> byte code offset #204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	s1	Object
    //   0	175	1	start1	Object
    //   0	175	2	end1	Object
    //   0	175	3	s2	Object
    //   0	175	4	start2	Object
    //   0	175	5	end2	Object
    //   0	175	6	proc$Ls	Object
    //   0	175	7	proc$Eq	Object
    //   0	175	8	proc$Gr	Object
    //   6	1	9	localObject1	Object
    //   18	16	9	size1	Object
    //   16	58	10	size2	Object
    //   29	138	11	match	Object
    //   93	134	12	localObject2	Object
    //   176	1	14	localClassCastException1	ClassCastException
    //   190	1	15	localClassCastException2	ClassCastException
    //   204	1	16	localClassCastException3	ClassCastException
    //   218	1	17	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   95	98	176	java/lang/ClassCastException
    //   111	117	190	java/lang/ClassCastException
    //   129	132	204	java/lang/ClassCastException
    //   146	152	218	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcStringCompareCi(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2, Object proc$Ls, Object proc$Eq, Object proc$Gr)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_2
    //   2: aload_1
    //   3: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: astore 9
    //   8: iconst_m1
    //   9: aload 5
    //   11: aload 4
    //   13: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: astore 10
    //   18: aload_0
    //   19: aload_1
    //   20: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: dup
    //   24: astore 12
    //   26: checkcast 177	java/lang/Number
    //   29: invokevirtual 181	java/lang/Number:intValue	()I
    //   32: aload_2
    //   33: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: dup
    //   37: astore 12
    //   39: checkcast 177	java/lang/Number
    //   42: invokevirtual 181	java/lang/Number:intValue	()I
    //   45: aload_3
    //   46: aload 4
    //   48: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: dup
    //   52: astore 12
    //   54: checkcast 177	java/lang/Number
    //   57: invokevirtual 181	java/lang/Number:intValue	()I
    //   60: aload 5
    //   62: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: dup
    //   66: astore 12
    //   68: checkcast 177	java/lang/Number
    //   71: invokevirtual 181	java/lang/Number:intValue	()I
    //   74: invokestatic 422	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   77: istore 11
    //   79: iload 11
    //   81: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aload 9
    //   86: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   89: ifeq +33 -> 122
    //   92: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   95: iload 11
    //   97: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aload 10
    //   102: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   105: ifeq +8 -> 113
    //   108: aload 7
    //   110: goto +5 -> 115
    //   113: aload 6
    //   115: aload_2
    //   116: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: goto +128 -> 247
    //   122: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   125: iload 11
    //   127: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aload 10
    //   132: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   135: ifeq +8 -> 143
    //   138: aload 8
    //   140: goto +94 -> 234
    //   143: aload_0
    //   144: ldc 43
    //   146: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   149: dup
    //   150: astore 12
    //   152: checkcast 43	java/lang/CharSequence
    //   155: iconst_1
    //   156: aload_1
    //   157: iload 11
    //   159: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: dup
    //   169: astore 12
    //   171: checkcast 177	java/lang/Number
    //   174: invokevirtual 181	java/lang/Number:intValue	()I
    //   177: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   180: invokestatic 400	java/lang/Character:toUpperCase	(I)I
    //   183: aload_3
    //   184: ldc 43
    //   186: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   189: dup
    //   190: astore 12
    //   192: checkcast 43	java/lang/CharSequence
    //   195: iconst_1
    //   196: aload 4
    //   198: iload 11
    //   200: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   209: dup
    //   210: astore 12
    //   212: checkcast 177	java/lang/Number
    //   215: invokevirtual 181	java/lang/Number:intValue	()I
    //   218: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   221: invokestatic 400	java/lang/Character:toUpperCase	(I)I
    //   224: if_icmpge +8 -> 232
    //   227: aload 6
    //   229: goto +5 -> 234
    //   232: aload 8
    //   234: iconst_1
    //   235: aload_1
    //   236: iload 11
    //   238: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   244: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: areturn
    //   248: new 53	gnu/mapping/WrongType
    //   251: dup_x1
    //   252: swap
    //   253: ldc_w 418
    //   256: iconst_1
    //   257: aload 12
    //   259: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: new 53	gnu/mapping/WrongType
    //   266: dup_x1
    //   267: swap
    //   268: ldc_w 418
    //   271: iconst_2
    //   272: aload 12
    //   274: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   277: athrow
    //   278: new 53	gnu/mapping/WrongType
    //   281: dup_x1
    //   282: swap
    //   283: ldc_w 418
    //   286: iconst_4
    //   287: aload 12
    //   289: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   292: athrow
    //   293: new 53	gnu/mapping/WrongType
    //   296: dup_x1
    //   297: swap
    //   298: ldc_w 418
    //   301: iconst_5
    //   302: aload 12
    //   304: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   307: athrow
    //   308: new 53	gnu/mapping/WrongType
    //   311: dup_x1
    //   312: swap
    //   313: ldc -16
    //   315: iconst_1
    //   316: aload 12
    //   318: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   321: athrow
    //   322: new 53	gnu/mapping/WrongType
    //   325: dup_x1
    //   326: swap
    //   327: ldc -16
    //   329: iconst_2
    //   330: aload 12
    //   332: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   335: athrow
    //   336: new 53	gnu/mapping/WrongType
    //   339: dup_x1
    //   340: swap
    //   341: ldc -16
    //   343: iconst_1
    //   344: aload 12
    //   346: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   349: athrow
    //   350: new 53	gnu/mapping/WrongType
    //   353: dup_x1
    //   354: swap
    //   355: ldc -16
    //   357: iconst_2
    //   358: aload 12
    //   360: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   363: athrow
    // Line number table:
    //   Java source line #761	-> byte code offset #0
    //   Java source line #763	-> byte code offset #0
    //   Java source line #764	-> byte code offset #8
    //   Java source line #765	-> byte code offset #18
    //   Java source line #766	-> byte code offset #79
    //   Java source line #767	-> byte code offset #92
    //   Java source line #768	-> byte code offset #122
    //   Java source line #769	-> byte code offset #143
    //   Java source line #770	-> byte code offset #183
    //   Java source line #769	-> byte code offset #227
    //   Java source line #772	-> byte code offset #234
    //   Java source line #765	-> byte code offset #248
    //   Java source line #769	-> byte code offset #308
    //   Java source line #770	-> byte code offset #336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	s1	Object
    //   0	247	1	start1	Object
    //   0	247	2	end1	Object
    //   0	247	3	s2	Object
    //   0	247	4	start2	Object
    //   0	247	5	end2	Object
    //   0	247	6	proc$Ls	Object
    //   0	247	7	proc$Eq	Object
    //   0	247	8	proc$Gr	Object
    //   6	1	9	localObject1	Object
    //   18	67	9	size1	Object
    //   16	115	10	size2	Object
    //   77	160	11	match	int
    //   24	335	12	localObject2	Object
    //   248	1	14	localClassCastException1	ClassCastException
    //   263	1	15	localClassCastException2	ClassCastException
    //   278	1	16	localClassCastException3	ClassCastException
    //   293	1	17	localClassCastException4	ClassCastException
    //   308	1	18	localClassCastException5	ClassCastException
    //   322	1	19	localClassCastException6	ClassCastException
    //   336	1	20	localClassCastException7	ClassCastException
    //   350	1	21	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   26	32	248	java/lang/ClassCastException
    //   39	45	263	java/lang/ClassCastException
    //   54	60	278	java/lang/ClassCastException
    //   68	74	293	java/lang/ClassCastException
    //   152	155	308	java/lang/ClassCastException
    //   171	177	322	java/lang/ClassCastException
    //   192	195	336	java/lang/ClassCastException
    //   212	218	350	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcStringHash(Object s, Object char$Mn$Grint, Object bound, Object start, Object end)
  {
    // Byte code:
    //   0: getstatic 564	gnu/kawa/slib/srfi13:Lit4	Lgnu/math/IntNum;
    //   3: astore 6
    //   5: aload 6
    //   7: aload_2
    //   8: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   11: ifeq +15 -> 26
    //   14: iconst_m1
    //   15: aload 6
    //   17: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   20: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: goto +14 -> 37
    //   26: iconst_1
    //   27: aload 6
    //   29: aload 6
    //   31: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: goto -31 -> 3
    //   37: astore 5
    //   39: aload_3
    //   40: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   43: astore 7
    //   45: astore 6
    //   47: aload 6
    //   49: aload 4
    //   51: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   54: ifeq +15 -> 69
    //   57: getstatic 570	gnu/kawa/functions/DivideOp:modulo	Lgnu/kawa/functions/DivideOp;
    //   60: aload 7
    //   62: aload_2
    //   63: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: goto +85 -> 151
    //   69: iconst_1
    //   70: aload 6
    //   72: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   75: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: getstatic 576	gnu/kawa/functions/BitwiseOp:and	Lgnu/kawa/functions/BitwiseOp;
    //   81: aload 5
    //   83: iconst_1
    //   84: getstatic 582	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   87: getstatic 585	gnu/kawa/slib/srfi13:Lit5	Lgnu/math/IntNum;
    //   90: aload 7
    //   92: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: aload_0
    //   96: aload 6
    //   98: astore 9
    //   100: astore 8
    //   102: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   105: aload_1
    //   106: aload 8
    //   108: ldc 43
    //   110: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   113: dup
    //   114: astore 10
    //   116: checkcast 43	java/lang/CharSequence
    //   119: aload 9
    //   121: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: dup
    //   125: astore 10
    //   127: checkcast 177	java/lang/Number
    //   130: invokevirtual 181	java/lang/Number:intValue	()I
    //   133: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   136: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   139: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: goto -105 -> 43
    //   151: areturn
    //   152: new 53	gnu/mapping/WrongType
    //   155: dup_x1
    //   156: swap
    //   157: ldc -16
    //   159: iconst_1
    //   160: aload 10
    //   162: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   165: athrow
    //   166: new 53	gnu/mapping/WrongType
    //   169: dup_x1
    //   170: swap
    //   171: ldc -16
    //   173: iconst_2
    //   174: aload 10
    //   176: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   179: athrow
    // Line number table:
    //   Java source line #946	-> byte code offset #0
    //   Java source line #947	-> byte code offset #0
    //   Java source line #949	-> byte code offset #0
    //   Java source line #950	-> byte code offset #5
    //   Java source line #951	-> byte code offset #39
    //   Java source line #952	-> byte code offset #47
    //   Java source line #953	-> byte code offset #69
    //   Java source line #947	-> byte code offset #98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	s	Object
    //   0	151	1	char$Mn$Grint	Object
    //   0	151	2	bound	Object
    //   0	151	3	start	Object
    //   0	151	4	end	Object
    //   39	112	5	mask	Object
    //   5	32	6	i	Object
    //   47	104	6	i	Object
    //   47	104	7	ans	Object
    //   102	40	8	s	Object
    //   102	40	9	i	Object
    // Exception table:
    //   from	to	target	type
    //   116	119	152	java/lang/ClassCastException
    //   127	133	166	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringHash$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: getstatic 588	gnu/kawa/slib/srfi13:Lit6	Lgnu/math/IntNum;
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic 84	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   36: ifeq +20 -> 56
    //   39: aload_3
    //   40: invokestatic 87	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   43: ifeq +13 -> 56
    //   46: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   49: aload_3
    //   50: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   53: ifne +7 -> 60
    //   56: getstatic 588	gnu/kawa/slib/srfi13:Lit6	Lgnu/math/IntNum;
    //   59: astore_3
    //   60: aload_2
    //   61: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   64: ifne +16 -> 80
    //   67: aload_2
    //   68: dup
    //   69: astore 5
    //   71: checkcast 70	gnu/lists/Pair
    //   74: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   77: goto +4 -> 81
    //   80: aload_2
    //   81: astore 4
    //   83: aload_3
    //   84: ldc -79
    //   86: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   89: dup
    //   90: astore 6
    //   92: checkcast 177	java/lang/Number
    //   95: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   98: ifeq +9 -> 107
    //   101: getstatic 588	gnu/kawa/slib/srfi13:Lit6	Lgnu/math/IntNum;
    //   104: goto +4 -> 108
    //   107: aload_3
    //   108: astore 5
    //   110: getstatic 593	gnu/kawa/slib/srfi13:string$Mnhash	Lgnu/expr/ModuleMethod;
    //   113: aload_0
    //   114: aload 4
    //   116: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   119: astore 6
    //   121: iconst_0
    //   122: istore 7
    //   124: aload 6
    //   126: iload 7
    //   128: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   131: istore 7
    //   133: aload 6
    //   135: iload 7
    //   137: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   140: astore 8
    //   142: aload 6
    //   144: iload 7
    //   146: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   149: istore 7
    //   151: aload 6
    //   153: iload 7
    //   155: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   158: astore 9
    //   160: aload_0
    //   161: getstatic 596	kawa/lib/characters:char$Mn$Grinteger	Lgnu/expr/ModuleMethod;
    //   164: aload 5
    //   166: aload 8
    //   168: aload 9
    //   170: invokestatic 600	gnu/kawa/slib/srfi13:$PcStringHash	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: areturn
    //   174: new 53	gnu/mapping/WrongType
    //   177: dup_x1
    //   178: swap
    //   179: ldc 72
    //   181: iconst_1
    //   182: aload 4
    //   184: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   187: athrow
    //   188: new 53	gnu/mapping/WrongType
    //   191: dup_x1
    //   192: swap
    //   193: ldc 77
    //   195: iconst_1
    //   196: aload 5
    //   198: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   201: athrow
    //   202: new 53	gnu/mapping/WrongType
    //   205: dup_x1
    //   206: swap
    //   207: ldc_w 590
    //   210: iconst_1
    //   211: aload 6
    //   213: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    // Line number table:
    //   Java source line #955	-> byte code offset #0
    //   Java source line #956	-> byte code offset #8
    //   Java source line #957	-> byte code offset #39
    //   Java source line #958	-> byte code offset #46
    //   Java source line #956	-> byte code offset #56
    //   Java source line #959	-> byte code offset #80
    //   Java source line #960	-> byte code offset #83
    //   Java source line #961	-> byte code offset #110
    //   Java source line #962	-> byte code offset #160
    //   Java source line #956	-> byte code offset #174
    //   Java source line #960	-> byte code offset #202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	s	Object
    //   0	173	1	argsArray	Object[]
    //   0	81	2	maybe$Mnbound$Plstart$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	77	3	bound	Object
    //   17	1	4	localLList2	LList
    //   81	102	4	rest	Object
    //   69	1	5	localLList3	LList
    //   108	89	5	bound	Object
    //   90	122	6	localObject1	Object
    //   122	32	7	i	int
    //   140	1	8	localObject2	Object
    //   160	7	8	start	Object
    //   158	11	9	end	Object
    //   174	1	14	localClassCastException1	ClassCastException
    //   188	1	15	localClassCastException2	ClassCastException
    //   202	1	16	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	174	java/lang/ClassCastException
    //   71	74	188	java/lang/ClassCastException
    //   92	95	202	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringHashCi$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: getstatic 588	gnu/kawa/slib/srfi13:Lit6	Lgnu/math/IntNum;
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic 84	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   36: ifeq +20 -> 56
    //   39: aload_3
    //   40: invokestatic 87	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   43: ifeq +13 -> 56
    //   46: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   49: aload_3
    //   50: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   53: ifne +7 -> 60
    //   56: getstatic 588	gnu/kawa/slib/srfi13:Lit6	Lgnu/math/IntNum;
    //   59: astore_3
    //   60: aload_2
    //   61: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   64: ifne +16 -> 80
    //   67: aload_2
    //   68: dup
    //   69: astore 5
    //   71: checkcast 70	gnu/lists/Pair
    //   74: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   77: goto +4 -> 81
    //   80: aload_2
    //   81: astore 4
    //   83: aload_3
    //   84: ldc -79
    //   86: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   89: dup
    //   90: astore 6
    //   92: checkcast 177	java/lang/Number
    //   95: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   98: ifeq +9 -> 107
    //   101: getstatic 588	gnu/kawa/slib/srfi13:Lit6	Lgnu/math/IntNum;
    //   104: goto +4 -> 108
    //   107: aload_3
    //   108: astore 5
    //   110: getstatic 603	gnu/kawa/slib/srfi13:string$Mnhash$Mnci	Lgnu/expr/ModuleMethod;
    //   113: aload_0
    //   114: aload 4
    //   116: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   119: astore 6
    //   121: iconst_0
    //   122: istore 7
    //   124: aload 6
    //   126: iload 7
    //   128: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   131: istore 7
    //   133: aload 6
    //   135: iload 7
    //   137: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   140: astore 8
    //   142: aload 6
    //   144: iload 7
    //   146: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   149: istore 7
    //   151: aload 6
    //   153: iload 7
    //   155: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   158: astore 9
    //   160: aload_0
    //   161: getstatic 608	gnu/kawa/slib/srfi13:lambda$Fn25	Lgnu/expr/ModuleMethod;
    //   164: aload 5
    //   166: aload 8
    //   168: aload 9
    //   170: invokestatic 600	gnu/kawa/slib/srfi13:$PcStringHash	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: areturn
    //   174: new 53	gnu/mapping/WrongType
    //   177: dup_x1
    //   178: swap
    //   179: ldc 72
    //   181: iconst_1
    //   182: aload 4
    //   184: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   187: athrow
    //   188: new 53	gnu/mapping/WrongType
    //   191: dup_x1
    //   192: swap
    //   193: ldc 77
    //   195: iconst_1
    //   196: aload 5
    //   198: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   201: athrow
    //   202: new 53	gnu/mapping/WrongType
    //   205: dup_x1
    //   206: swap
    //   207: ldc_w 590
    //   210: iconst_1
    //   211: aload 6
    //   213: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    // Line number table:
    //   Java source line #964	-> byte code offset #0
    //   Java source line #965	-> byte code offset #8
    //   Java source line #966	-> byte code offset #39
    //   Java source line #967	-> byte code offset #46
    //   Java source line #965	-> byte code offset #56
    //   Java source line #968	-> byte code offset #80
    //   Java source line #969	-> byte code offset #83
    //   Java source line #970	-> byte code offset #110
    //   Java source line #971	-> byte code offset #160
    //   Java source line #972	-> byte code offset #164
    //   Java source line #965	-> byte code offset #174
    //   Java source line #969	-> byte code offset #202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	s	Object
    //   0	173	1	argsArray	Object[]
    //   0	81	2	maybe$Mnbound$Plstart$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	77	3	bound	Object
    //   17	1	4	localLList2	LList
    //   81	102	4	rest	Object
    //   69	1	5	localLList3	LList
    //   108	89	5	bound	Object
    //   90	122	6	localObject1	Object
    //   122	32	7	i	int
    //   140	1	8	localObject2	Object
    //   160	7	8	start	Object
    //   158	11	9	end	Object
    //   174	1	14	localClassCastException1	ClassCastException
    //   188	1	15	localClassCastException2	ClassCastException
    //   202	1	16	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	174	java/lang/ClassCastException
    //   71	74	188	java/lang/ClassCastException
    //   92	95	202	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcStringTitlecase$Ex(Object s, Object start, Object end)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: aload_0
    //   3: getstatic 629	gnu/kawa/slib/srfi13:char$Mncased$Qu	Lgnu/expr/ModuleMethod;
    //   6: iconst_2
    //   7: anewarray 27	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_3
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_2
    //   17: aastore
    //   18: invokestatic 633	gnu/kawa/slib/srfi13:stringIndex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   28: ifeq +157 -> 185
    //   31: aload_0
    //   32: ldc_w 272
    //   35: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   38: dup
    //   39: astore 5
    //   41: checkcast 272	gnu/lists/CharSeq
    //   44: aload 4
    //   46: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: dup
    //   50: astore 5
    //   52: checkcast 177	java/lang/Number
    //   55: invokevirtual 181	java/lang/Number:intValue	()I
    //   58: aload_0
    //   59: ldc 43
    //   61: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: astore 5
    //   67: checkcast 43	java/lang/CharSequence
    //   70: aload 4
    //   72: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: dup
    //   76: astore 5
    //   78: checkcast 177	java/lang/Number
    //   81: invokevirtual 181	java/lang/Number:intValue	()I
    //   84: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   87: invokestatic 636	kawa/lib/rnrs/unicode:charTitlecase	(I)I
    //   90: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   93: iconst_1
    //   94: aload 4
    //   96: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   99: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore 5
    //   104: aload_0
    //   105: getstatic 629	gnu/kawa/slib/srfi13:char$Mncased$Qu	Lgnu/expr/ModuleMethod;
    //   108: iconst_2
    //   109: anewarray 27	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload 5
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: aload_2
    //   120: aastore
    //   121: invokestatic 639	gnu/kawa/slib/srfi13:stringSkip$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore 6
    //   126: aload 6
    //   128: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   131: ifeq +34 -> 165
    //   134: aload_0
    //   135: iconst_2
    //   136: anewarray 27	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload 5
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload 6
    //   148: aastore
    //   149: invokestatic 643	gnu/kawa/slib/srfi13:stringDowncase$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: iconst_1
    //   154: aload 6
    //   156: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   159: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: goto -161 -> 1
    //   165: aload_0
    //   166: iconst_2
    //   167: anewarray 27	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload 5
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload_2
    //   178: aastore
    //   179: invokestatic 643	gnu/kawa/slib/srfi13:stringDowncase$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   182: goto +6 -> 188
    //   185: getstatic 276	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   188: areturn
    //   189: new 53	gnu/mapping/WrongType
    //   192: dup_x1
    //   193: swap
    //   194: ldc -24
    //   196: iconst_1
    //   197: aload 5
    //   199: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: new 53	gnu/mapping/WrongType
    //   206: dup_x1
    //   207: swap
    //   208: ldc -24
    //   210: iconst_2
    //   211: aload 5
    //   213: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: new 53	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc -16
    //   224: iconst_1
    //   225: aload 5
    //   227: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   230: athrow
    //   231: new 53	gnu/mapping/WrongType
    //   234: dup_x1
    //   235: swap
    //   236: ldc -16
    //   238: iconst_2
    //   239: aload 5
    //   241: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    // Line number table:
    //   Java source line #1002	-> byte code offset #0
    //   Java source line #1003	-> byte code offset #0
    //   Java source line #1004	-> byte code offset #2
    //   Java source line #10000	-> byte code offset #31
    //   Java source line #1006	-> byte code offset #31
    //   Java source line #1007	-> byte code offset #93
    //   Java source line #1008	-> byte code offset #104
    //   Java source line #10000	-> byte code offset #134
    //   Java source line #1010	-> byte code offset #134
    //   Java source line #1011	-> byte code offset #153
    //   Java source line #1012	-> byte code offset #165
    //   Java source line #1006	-> byte code offset #189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	s	Object
    //   0	188	1	start	Object
    //   0	188	2	end	Object
    //   1	12	3	i	Object
    //   21	74	4	temp	Object
    //   39	38	5	localObject1	Object
    //   102	138	5	i1	Object
    //   124	31	6	temp	Object
    //   189	1	8	localClassCastException1	ClassCastException
    //   203	1	9	localClassCastException2	ClassCastException
    //   217	1	10	localClassCastException3	ClassCastException
    //   231	1	11	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   41	44	189	java/lang/ClassCastException
    //   52	58	203	java/lang/ClassCastException
    //   67	70	217	java/lang/ClassCastException
    //   78	84	231	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringIndex$V(Object str, Object criterion, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 800	gnu/kawa/slib/srfi13:string$Mnindex	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload_1
    //   59: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   62: ifeq +79 -> 141
    //   65: aload 6
    //   67: astore 8
    //   69: aload 8
    //   71: aload 7
    //   73: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   76: ifeq +59 -> 135
    //   79: aload_1
    //   80: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   86: aload_0
    //   87: ldc 43
    //   89: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 9
    //   95: checkcast 43	java/lang/CharSequence
    //   98: aload 8
    //   100: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: dup
    //   104: astore 9
    //   106: checkcast 177	java/lang/Number
    //   109: invokevirtual 181	java/lang/Number:intValue	()I
    //   112: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   115: if_icmpne +8 -> 123
    //   118: aload 8
    //   120: goto +229 -> 349
    //   123: iconst_1
    //   124: aload 8
    //   126: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   129: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: goto -65 -> 67
    //   135: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   138: goto +211 -> 349
    //   141: aload_1
    //   142: instanceof 371
    //   145: ifeq +88 -> 233
    //   148: aload 6
    //   150: astore 8
    //   152: aload 8
    //   154: aload 7
    //   156: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   159: ifeq +68 -> 227
    //   162: aload_1
    //   163: ldc_w 371
    //   166: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   169: dup
    //   170: astore 9
    //   172: checkcast 371	gnu/kawa/slib/srfi14$CharSet
    //   175: aload_0
    //   176: ldc 43
    //   178: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   181: dup
    //   182: astore 9
    //   184: checkcast 43	java/lang/CharSequence
    //   187: aload 8
    //   189: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: dup
    //   193: astore 9
    //   195: checkcast 177	java/lang/Number
    //   198: invokevirtual 181	java/lang/Number:intValue	()I
    //   201: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   204: invokestatic 379	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
    //   207: ifeq +8 -> 215
    //   210: aload 8
    //   212: goto +137 -> 349
    //   215: iconst_1
    //   216: aload 8
    //   218: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   221: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: goto -74 -> 150
    //   227: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   230: goto +119 -> 349
    //   233: aload_1
    //   234: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   237: ifeq +85 -> 322
    //   240: aload 6
    //   242: astore 8
    //   244: aload 8
    //   246: aload 7
    //   248: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   251: ifeq +65 -> 316
    //   254: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   257: aload_1
    //   258: aload_0
    //   259: ldc 43
    //   261: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   264: dup
    //   265: astore 9
    //   267: checkcast 43	java/lang/CharSequence
    //   270: aload 8
    //   272: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   275: dup
    //   276: astore 9
    //   278: checkcast 177	java/lang/Number
    //   281: invokevirtual 181	java/lang/Number:intValue	()I
    //   284: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   287: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   290: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   296: ifeq +8 -> 304
    //   299: aload 8
    //   301: goto +48 -> 349
    //   304: iconst_1
    //   305: aload 8
    //   307: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   310: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   313: goto -71 -> 242
    //   316: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   319: goto +30 -> 349
    //   322: iconst_3
    //   323: anewarray 27	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: ldc_w 384
    //   331: aastore
    //   332: dup
    //   333: iconst_1
    //   334: getstatic 800	gnu/kawa/slib/srfi13:string$Mnindex	Lgnu/expr/ModuleMethod;
    //   337: aastore
    //   338: dup
    //   339: iconst_2
    //   340: aload_1
    //   341: aastore
    //   342: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   345: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   348: athrow
    //   349: areturn
    //   350: new 53	gnu/mapping/WrongType
    //   353: dup_x1
    //   354: swap
    //   355: ldc -16
    //   357: iconst_1
    //   358: aload 9
    //   360: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   363: athrow
    //   364: new 53	gnu/mapping/WrongType
    //   367: dup_x1
    //   368: swap
    //   369: ldc -16
    //   371: iconst_2
    //   372: aload 9
    //   374: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   377: athrow
    //   378: new 53	gnu/mapping/WrongType
    //   381: dup_x1
    //   382: swap
    //   383: ldc_w 373
    //   386: iconst_0
    //   387: aload 9
    //   389: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   392: athrow
    //   393: new 53	gnu/mapping/WrongType
    //   396: dup_x1
    //   397: swap
    //   398: ldc -16
    //   400: iconst_1
    //   401: aload 9
    //   403: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   406: athrow
    //   407: new 53	gnu/mapping/WrongType
    //   410: dup_x1
    //   411: swap
    //   412: ldc -16
    //   414: iconst_2
    //   415: aload 9
    //   417: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   420: athrow
    //   421: new 53	gnu/mapping/WrongType
    //   424: dup_x1
    //   425: swap
    //   426: ldc -16
    //   428: iconst_1
    //   429: aload 9
    //   431: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   434: athrow
    //   435: new 53	gnu/mapping/WrongType
    //   438: dup_x1
    //   439: swap
    //   440: ldc -16
    //   442: iconst_2
    //   443: aload 9
    //   445: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   448: athrow
    // Line number table:
    //   Java source line #1201	-> byte code offset #0
    //   Java source line #1202	-> byte code offset #9
    //   Java source line #1203	-> byte code offset #58
    //   Java source line #1204	-> byte code offset #65
    //   Java source line #1205	-> byte code offset #69
    //   Java source line #1206	-> byte code offset #79
    //   Java source line #1207	-> byte code offset #123
    //   Java source line #1208	-> byte code offset #141
    //   Java source line #1209	-> byte code offset #148
    //   Java source line #1210	-> byte code offset #152
    //   Java source line #1211	-> byte code offset #162
    //   Java source line #1212	-> byte code offset #215
    //   Java source line #1213	-> byte code offset #233
    //   Java source line #1214	-> byte code offset #240
    //   Java source line #1215	-> byte code offset #244
    //   Java source line #1216	-> byte code offset #254
    //   Java source line #1217	-> byte code offset #304
    //   Java source line #1218	-> byte code offset #322
    //   Java source line #1206	-> byte code offset #350
    //   Java source line #1211	-> byte code offset #378
    //   Java source line #1216	-> byte code offset #421
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	str	Object
    //   0	349	1	criterion	Object
    //   0	349	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstart$Plend	LList
    //   6	44	4	localObject1	Object
    //   20	32	5	i	int
    //   38	1	6	localObject2	Object
    //   58	183	6	start	Object
    //   56	191	7	end	Object
    //   67	58	8	i	Object
    //   150	67	8	i	Object
    //   242	64	8	i	Object
    //   93	351	9	localObject3	Object
    //   350	1	13	localClassCastException1	ClassCastException
    //   364	1	14	localClassCastException2	ClassCastException
    //   378	1	15	localClassCastException3	ClassCastException
    //   393	1	16	localClassCastException4	ClassCastException
    //   407	1	17	localClassCastException5	ClassCastException
    //   421	1	18	localClassCastException6	ClassCastException
    //   435	1	19	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   95	98	350	java/lang/ClassCastException
    //   106	112	364	java/lang/ClassCastException
    //   172	175	378	java/lang/ClassCastException
    //   184	187	393	java/lang/ClassCastException
    //   195	201	407	java/lang/ClassCastException
    //   267	270	421	java/lang/ClassCastException
    //   278	284	435	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringSkip$V(Object str, Object criterion, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 806	gnu/kawa/slib/srfi13:string$Mnskip	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload_1
    //   59: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   62: ifeq +79 -> 141
    //   65: aload 6
    //   67: astore 8
    //   69: aload 8
    //   71: aload 7
    //   73: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   76: ifeq +59 -> 135
    //   79: aload_1
    //   80: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   86: aload_0
    //   87: ldc 43
    //   89: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 9
    //   95: checkcast 43	java/lang/CharSequence
    //   98: aload 8
    //   100: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: dup
    //   104: astore 9
    //   106: checkcast 177	java/lang/Number
    //   109: invokevirtual 181	java/lang/Number:intValue	()I
    //   112: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   115: if_icmpne +15 -> 130
    //   118: iconst_1
    //   119: aload 8
    //   121: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   124: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: goto -60 -> 67
    //   130: aload 8
    //   132: goto +217 -> 349
    //   135: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   138: goto +211 -> 349
    //   141: aload_1
    //   142: instanceof 371
    //   145: ifeq +88 -> 233
    //   148: aload 6
    //   150: astore 8
    //   152: aload 8
    //   154: aload 7
    //   156: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   159: ifeq +68 -> 227
    //   162: aload_1
    //   163: ldc_w 371
    //   166: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   169: dup
    //   170: astore 9
    //   172: checkcast 371	gnu/kawa/slib/srfi14$CharSet
    //   175: aload_0
    //   176: ldc 43
    //   178: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   181: dup
    //   182: astore 9
    //   184: checkcast 43	java/lang/CharSequence
    //   187: aload 8
    //   189: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: dup
    //   193: astore 9
    //   195: checkcast 177	java/lang/Number
    //   198: invokevirtual 181	java/lang/Number:intValue	()I
    //   201: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   204: invokestatic 379	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
    //   207: ifeq +15 -> 222
    //   210: iconst_1
    //   211: aload 8
    //   213: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   216: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: goto -69 -> 150
    //   222: aload 8
    //   224: goto +125 -> 349
    //   227: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   230: goto +119 -> 349
    //   233: aload_1
    //   234: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   237: ifeq +85 -> 322
    //   240: aload 6
    //   242: astore 8
    //   244: aload 8
    //   246: aload 7
    //   248: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   251: ifeq +65 -> 316
    //   254: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   257: aload_1
    //   258: aload_0
    //   259: ldc 43
    //   261: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   264: dup
    //   265: astore 9
    //   267: checkcast 43	java/lang/CharSequence
    //   270: aload 8
    //   272: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   275: dup
    //   276: astore 9
    //   278: checkcast 177	java/lang/Number
    //   281: invokevirtual 181	java/lang/Number:intValue	()I
    //   284: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   287: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   290: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   296: ifeq +15 -> 311
    //   299: iconst_1
    //   300: aload 8
    //   302: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   305: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   308: goto -66 -> 242
    //   311: aload 8
    //   313: goto +36 -> 349
    //   316: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   319: goto +30 -> 349
    //   322: iconst_3
    //   323: anewarray 27	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: ldc_w 384
    //   331: aastore
    //   332: dup
    //   333: iconst_1
    //   334: getstatic 806	gnu/kawa/slib/srfi13:string$Mnskip	Lgnu/expr/ModuleMethod;
    //   337: aastore
    //   338: dup
    //   339: iconst_2
    //   340: aload_1
    //   341: aastore
    //   342: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   345: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   348: athrow
    //   349: areturn
    //   350: new 53	gnu/mapping/WrongType
    //   353: dup_x1
    //   354: swap
    //   355: ldc -16
    //   357: iconst_1
    //   358: aload 9
    //   360: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   363: athrow
    //   364: new 53	gnu/mapping/WrongType
    //   367: dup_x1
    //   368: swap
    //   369: ldc -16
    //   371: iconst_2
    //   372: aload 9
    //   374: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   377: athrow
    //   378: new 53	gnu/mapping/WrongType
    //   381: dup_x1
    //   382: swap
    //   383: ldc_w 373
    //   386: iconst_0
    //   387: aload 9
    //   389: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   392: athrow
    //   393: new 53	gnu/mapping/WrongType
    //   396: dup_x1
    //   397: swap
    //   398: ldc -16
    //   400: iconst_1
    //   401: aload 9
    //   403: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   406: athrow
    //   407: new 53	gnu/mapping/WrongType
    //   410: dup_x1
    //   411: swap
    //   412: ldc -16
    //   414: iconst_2
    //   415: aload 9
    //   417: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   420: athrow
    //   421: new 53	gnu/mapping/WrongType
    //   424: dup_x1
    //   425: swap
    //   426: ldc -16
    //   428: iconst_1
    //   429: aload 9
    //   431: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   434: athrow
    //   435: new 53	gnu/mapping/WrongType
    //   438: dup_x1
    //   439: swap
    //   440: ldc -16
    //   442: iconst_2
    //   443: aload 9
    //   445: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   448: athrow
    // Line number table:
    //   Java source line #1241	-> byte code offset #0
    //   Java source line #1242	-> byte code offset #9
    //   Java source line #1243	-> byte code offset #58
    //   Java source line #1244	-> byte code offset #65
    //   Java source line #1245	-> byte code offset #69
    //   Java source line #1246	-> byte code offset #79
    //   Java source line #1247	-> byte code offset #118
    //   Java source line #1246	-> byte code offset #130
    //   Java source line #1249	-> byte code offset #141
    //   Java source line #1250	-> byte code offset #148
    //   Java source line #1251	-> byte code offset #152
    //   Java source line #1252	-> byte code offset #162
    //   Java source line #1253	-> byte code offset #210
    //   Java source line #1252	-> byte code offset #222
    //   Java source line #1255	-> byte code offset #233
    //   Java source line #1256	-> byte code offset #240
    //   Java source line #1257	-> byte code offset #244
    //   Java source line #1258	-> byte code offset #254
    //   Java source line #1260	-> byte code offset #322
    //   Java source line #1246	-> byte code offset #350
    //   Java source line #1252	-> byte code offset #378
    //   Java source line #1258	-> byte code offset #421
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	str	Object
    //   0	349	1	criterion	Object
    //   0	349	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstart$Plend	LList
    //   6	44	4	localObject1	Object
    //   20	32	5	i	int
    //   38	1	6	localObject2	Object
    //   58	183	6	start	Object
    //   56	191	7	end	Object
    //   67	64	8	i	Object
    //   150	73	8	i	Object
    //   242	70	8	i	Object
    //   93	351	9	localObject3	Object
    //   350	1	13	localClassCastException1	ClassCastException
    //   364	1	14	localClassCastException2	ClassCastException
    //   378	1	15	localClassCastException3	ClassCastException
    //   393	1	16	localClassCastException4	ClassCastException
    //   407	1	17	localClassCastException5	ClassCastException
    //   421	1	18	localClassCastException6	ClassCastException
    //   435	1	19	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   95	98	350	java/lang/ClassCastException
    //   106	112	364	java/lang/ClassCastException
    //   172	175	378	java/lang/ClassCastException
    //   184	187	393	java/lang/ClassCastException
    //   195	201	407	java/lang/ClassCastException
    //   267	270	421	java/lang/ClassCastException
    //   278	284	435	java/lang/ClassCastException
  }
  
  /* Error */
  public static CharSequence stringTitlecase$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: getstatic 646	gnu/kawa/slib/srfi13:string$Mntitlecase$Ex	Lgnu/expr/ModuleMethod;
    //   11: aload_0
    //   12: aload_2
    //   13: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   16: astore_3
    //   17: iconst_0
    //   18: istore 4
    //   20: aload_3
    //   21: iload 4
    //   23: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   26: istore 4
    //   28: aload_3
    //   29: iload 4
    //   31: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   34: astore 5
    //   36: aload_3
    //   37: iload 4
    //   39: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   42: istore 4
    //   44: aload_3
    //   45: iload 4
    //   47: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   50: astore 6
    //   52: aload_0
    //   53: ldc 43
    //   55: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   58: dup
    //   59: astore 8
    //   61: checkcast 43	java/lang/CharSequence
    //   64: aload 5
    //   66: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: dup
    //   70: astore 8
    //   72: checkcast 177	java/lang/Number
    //   75: invokevirtual 181	java/lang/Number:intValue	()I
    //   78: aload 6
    //   80: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: dup
    //   84: astore 8
    //   86: checkcast 177	java/lang/Number
    //   89: invokevirtual 181	java/lang/Number:intValue	()I
    //   92: invokestatic 196	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   95: astore 7
    //   97: aload 7
    //   99: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   102: iconst_m1
    //   103: aload 6
    //   105: aload 5
    //   107: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: invokestatic 649	gnu/kawa/slib/srfi13:$PcStringTitlecase$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: aload 7
    //   116: areturn
    //   117: new 53	gnu/mapping/WrongType
    //   120: dup_x1
    //   121: swap
    //   122: ldc_w 650
    //   125: iconst_1
    //   126: aload 8
    //   128: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   131: athrow
    //   132: new 53	gnu/mapping/WrongType
    //   135: dup_x1
    //   136: swap
    //   137: ldc_w 650
    //   140: iconst_2
    //   141: aload 8
    //   143: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   146: athrow
    //   147: new 53	gnu/mapping/WrongType
    //   150: dup_x1
    //   151: swap
    //   152: ldc_w 650
    //   155: iconst_3
    //   156: aload 8
    //   158: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   161: athrow
    // Line number table:
    //   Java source line #1018	-> byte code offset #0
    //   Java source line #1019	-> byte code offset #8
    //   Java source line #1020	-> byte code offset #52
    //   Java source line #1021	-> byte code offset #97
    //   Java source line #1022	-> byte code offset #114
    //   Java source line #1020	-> byte code offset #117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	s	Object
    //   0	116	1	argsArray	Object[]
    //   0	13	2	maybe$Mnstart$Plend	LList
    //   6	39	3	localObject1	Object
    //   18	28	4	i	int
    //   34	1	5	localObject2	Object
    //   52	54	5	start	Object
    //   50	54	6	end	Object
    //   95	20	7	ans	CharSequence
    //   59	98	8	localObject3	Object
    //   117	1	10	localClassCastException1	ClassCastException
    //   132	1	11	localClassCastException2	ClassCastException
    //   147	1	12	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   61	64	117	java/lang/ClassCastException
    //   72	78	132	java/lang/ClassCastException
    //   86	92	147	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTake(Object s, Object n)
  {
    // Byte code:
    //   0: new 652	gnu/kawa/slib/srfi13$frame
    //   3: dup
    //   4: invokespecial 655	gnu/kawa/slib/srfi13$frame:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 659	gnu/kawa/slib/srfi13$frame:s	Ljava/lang/Object;
    //   13: aload_2
    //   14: aload_1
    //   15: putfield 662	gnu/kawa/slib/srfi13$frame:n	Ljava/lang/Object;
    //   18: getstatic 161	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   21: aload_2
    //   22: getfield 659	gnu/kawa/slib/srfi13$frame:s	Ljava/lang/Object;
    //   25: getstatic 665	gnu/kawa/slib/srfi13:string$Mntake	Lgnu/expr/ModuleMethod;
    //   28: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: pop
    //   32: aload_2
    //   33: getfield 668	gnu/kawa/slib/srfi13$frame:lambda$Fn26	Lgnu/expr/ModuleMethod;
    //   36: aload_2
    //   37: getfield 662	gnu/kawa/slib/srfi13$frame:n	Ljava/lang/Object;
    //   40: getstatic 665	gnu/kawa/slib/srfi13:string$Mntake	Lgnu/expr/ModuleMethod;
    //   43: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: aload_2
    //   48: getfield 659	gnu/kawa/slib/srfi13$frame:s	Ljava/lang/Object;
    //   51: ldc 43
    //   53: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   56: dup
    //   57: astore_3
    //   58: checkcast 43	java/lang/CharSequence
    //   61: iconst_0
    //   62: aload_2
    //   63: getfield 662	gnu/kawa/slib/srfi13$frame:n	Ljava/lang/Object;
    //   66: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: dup
    //   70: astore_3
    //   71: checkcast 177	java/lang/Number
    //   74: invokevirtual 181	java/lang/Number:intValue	()I
    //   77: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   80: areturn
    //   81: new 53	gnu/mapping/WrongType
    //   84: dup_x1
    //   85: swap
    //   86: ldc -84
    //   88: iconst_0
    //   89: aload_3
    //   90: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   93: athrow
    //   94: new 53	gnu/mapping/WrongType
    //   97: dup_x1
    //   98: swap
    //   99: ldc -84
    //   101: iconst_2
    //   102: aload_3
    //   103: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   106: athrow
    // Line number table:
    //   Java source line #1043	-> byte code offset #0
    //   Java source line #1044	-> byte code offset #18
    //   Java source line #1045	-> byte code offset #32
    //   Java source line #1047	-> byte code offset #36
    //   Java source line #1048	-> byte code offset #47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	s	Object
    //   0	80	1	n	Object
    //   7	56	2	$heapFrame	frame
    //   57	46	3	localObject	Object
    //   81	1	4	localClassCastException1	ClassCastException
    //   94	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   58	61	81	java/lang/ClassCastException
    //   71	77	94	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTakeRight(Object s, Object n)
  {
    // Byte code:
    //   0: new 670	gnu/kawa/slib/srfi13$frame0
    //   3: dup
    //   4: invokespecial 671	gnu/kawa/slib/srfi13$frame0:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: putfield 672	gnu/kawa/slib/srfi13$frame0:n	Ljava/lang/Object;
    //   13: getstatic 161	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   16: aload_0
    //   17: getstatic 675	gnu/kawa/slib/srfi13:string$Mntake$Mnright	Lgnu/expr/ModuleMethod;
    //   20: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: aload_0
    //   25: ldc 43
    //   27: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   30: dup
    //   31: astore_3
    //   32: checkcast 43	java/lang/CharSequence
    //   35: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   38: aload_2
    //   39: swap
    //   40: putfield 679	gnu/kawa/slib/srfi13$frame0:len	I
    //   43: aload_2
    //   44: getfield 682	gnu/kawa/slib/srfi13$frame0:lambda$Fn27	Lgnu/expr/ModuleMethod;
    //   47: aload_2
    //   48: getfield 672	gnu/kawa/slib/srfi13$frame0:n	Ljava/lang/Object;
    //   51: getstatic 675	gnu/kawa/slib/srfi13:string$Mntake$Mnright	Lgnu/expr/ModuleMethod;
    //   54: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: pop
    //   58: aload_0
    //   59: ldc 43
    //   61: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: astore_3
    //   66: checkcast 43	java/lang/CharSequence
    //   69: iconst_m1
    //   70: aload_2
    //   71: getfield 679	gnu/kawa/slib/srfi13$frame0:len	I
    //   74: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aload_2
    //   78: getfield 672	gnu/kawa/slib/srfi13$frame0:n	Ljava/lang/Object;
    //   81: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: dup
    //   88: astore_3
    //   89: checkcast 177	java/lang/Number
    //   92: invokevirtual 181	java/lang/Number:intValue	()I
    //   95: aload_2
    //   96: getfield 679	gnu/kawa/slib/srfi13$frame0:len	I
    //   99: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   102: areturn
    //   103: new 53	gnu/mapping/WrongType
    //   106: dup_x1
    //   107: swap
    //   108: ldc 55
    //   110: iconst_1
    //   111: aload_3
    //   112: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   115: athrow
    //   116: new 53	gnu/mapping/WrongType
    //   119: dup_x1
    //   120: swap
    //   121: ldc -84
    //   123: iconst_0
    //   124: aload_3
    //   125: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   128: athrow
    //   129: new 53	gnu/mapping/WrongType
    //   132: dup_x1
    //   133: swap
    //   134: ldc -84
    //   136: iconst_1
    //   137: aload_3
    //   138: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   141: athrow
    // Line number table:
    //   Java source line #1050	-> byte code offset #0
    //   Java source line #1051	-> byte code offset #13
    //   Java source line #1052	-> byte code offset #24
    //   Java source line #1053	-> byte code offset #43
    //   Java source line #1054	-> byte code offset #47
    //   Java source line #1055	-> byte code offset #58
    //   Java source line #1052	-> byte code offset #103
    //   Java source line #1055	-> byte code offset #116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	s	Object
    //   0	102	1	n	Object
    //   7	89	2	$heapFrame	frame0
    //   31	107	3	localObject	Object
    //   103	1	4	localClassCastException1	ClassCastException
    //   116	1	5	localClassCastException2	ClassCastException
    //   129	1	6	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   32	35	103	java/lang/ClassCastException
    //   66	69	116	java/lang/ClassCastException
    //   89	95	129	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTrim$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: getstatic 708	gnu/kawa/slib/srfi14$CharSet:whitespace	Lgnu/kawa/slib/srfi14$CharSet;
    //   31: astore_3
    //   32: aload_2
    //   33: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   36: ifne +16 -> 52
    //   39: aload_2
    //   40: dup
    //   41: astore 5
    //   43: checkcast 70	gnu/lists/Pair
    //   46: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   49: goto +4 -> 53
    //   52: aload_2
    //   53: astore 4
    //   55: getstatic 711	gnu/kawa/slib/srfi13:string$Mntrim	Lgnu/expr/ModuleMethod;
    //   58: aload_0
    //   59: aload 4
    //   61: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   64: astore 5
    //   66: iconst_0
    //   67: istore 6
    //   69: aload 5
    //   71: iload 6
    //   73: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   76: istore 6
    //   78: aload 5
    //   80: iload 6
    //   82: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   85: astore 7
    //   87: aload 5
    //   89: iload 6
    //   91: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   94: istore 6
    //   96: aload 5
    //   98: iload 6
    //   100: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   103: astore 8
    //   105: aload_0
    //   106: aload_3
    //   107: iconst_2
    //   108: anewarray 27	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 7
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload 8
    //   120: aastore
    //   121: invokestatic 639	gnu/kawa/slib/srfi13:stringSkip$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore 9
    //   126: aload 9
    //   128: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   131: ifeq +49 -> 180
    //   134: aload_0
    //   135: ldc 43
    //   137: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   140: dup
    //   141: astore 10
    //   143: checkcast 43	java/lang/CharSequence
    //   146: aload 9
    //   148: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: dup
    //   152: astore 10
    //   154: checkcast 177	java/lang/Number
    //   157: invokevirtual 181	java/lang/Number:intValue	()I
    //   160: aload 8
    //   162: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: dup
    //   166: astore 10
    //   168: checkcast 177	java/lang/Number
    //   171: invokevirtual 181	java/lang/Number:intValue	()I
    //   174: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   177: goto +6 -> 183
    //   180: ldc_w 290
    //   183: areturn
    //   184: new 53	gnu/mapping/WrongType
    //   187: dup_x1
    //   188: swap
    //   189: ldc 72
    //   191: iconst_1
    //   192: aload 4
    //   194: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   197: athrow
    //   198: new 53	gnu/mapping/WrongType
    //   201: dup_x1
    //   202: swap
    //   203: ldc 77
    //   205: iconst_1
    //   206: aload 5
    //   208: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   211: athrow
    //   212: new 53	gnu/mapping/WrongType
    //   215: dup_x1
    //   216: swap
    //   217: ldc -84
    //   219: iconst_0
    //   220: aload 10
    //   222: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   225: athrow
    //   226: new 53	gnu/mapping/WrongType
    //   229: dup_x1
    //   230: swap
    //   231: ldc -84
    //   233: iconst_1
    //   234: aload 10
    //   236: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   239: athrow
    //   240: new 53	gnu/mapping/WrongType
    //   243: dup_x1
    //   244: swap
    //   245: ldc -84
    //   247: iconst_2
    //   248: aload 10
    //   250: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   253: athrow
    // Line number table:
    //   Java source line #1070	-> byte code offset #0
    //   Java source line #1071	-> byte code offset #8
    //   Java source line #1072	-> byte code offset #55
    //   Java source line #1073	-> byte code offset #105
    //   Java source line #10000	-> byte code offset #134
    //   Java source line #1074	-> byte code offset #134
    //   Java source line #1075	-> byte code offset #180
    //   Java source line #1071	-> byte code offset #184
    //   Java source line #1074	-> byte code offset #212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	s	Object
    //   0	183	1	argsArray	Object[]
    //   0	53	2	criterion$Plstart$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	76	3	criterion	Object
    //   17	1	4	localLList2	LList
    //   53	140	4	rest	Object
    //   41	166	5	localObject1	Object
    //   67	32	6	i	int
    //   85	1	7	localObject2	Object
    //   105	9	7	start	Object
    //   103	58	8	end	Object
    //   124	23	9	temp	Object
    //   141	108	10	localObject3	Object
    //   184	1	14	localClassCastException1	ClassCastException
    //   198	1	15	localClassCastException2	ClassCastException
    //   212	1	16	localClassCastException3	ClassCastException
    //   226	1	17	localClassCastException4	ClassCastException
    //   240	1	18	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	184	java/lang/ClassCastException
    //   43	46	198	java/lang/ClassCastException
    //   143	146	212	java/lang/ClassCastException
    //   154	160	226	java/lang/ClassCastException
    //   168	174	240	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTrimRight$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: getstatic 708	gnu/kawa/slib/srfi14$CharSet:whitespace	Lgnu/kawa/slib/srfi14$CharSet;
    //   31: astore_3
    //   32: aload_2
    //   33: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   36: ifne +16 -> 52
    //   39: aload_2
    //   40: dup
    //   41: astore 5
    //   43: checkcast 70	gnu/lists/Pair
    //   46: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   49: goto +4 -> 53
    //   52: aload_2
    //   53: astore 4
    //   55: getstatic 714	gnu/kawa/slib/srfi13:string$Mntrim$Mnright	Lgnu/expr/ModuleMethod;
    //   58: aload_0
    //   59: aload 4
    //   61: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   64: astore 5
    //   66: iconst_0
    //   67: istore 6
    //   69: aload 5
    //   71: iload 6
    //   73: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   76: istore 6
    //   78: aload 5
    //   80: iload 6
    //   82: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   85: astore 7
    //   87: aload 5
    //   89: iload 6
    //   91: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   94: istore 6
    //   96: aload 5
    //   98: iload 6
    //   100: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   103: astore 8
    //   105: aload_0
    //   106: aload_3
    //   107: iconst_2
    //   108: anewarray 27	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 7
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload 8
    //   120: aastore
    //   121: invokestatic 717	gnu/kawa/slib/srfi13:stringSkipRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore 9
    //   126: aload 9
    //   128: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   131: ifeq +56 -> 187
    //   134: aload_0
    //   135: ldc 43
    //   137: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   140: dup
    //   141: astore 10
    //   143: checkcast 43	java/lang/CharSequence
    //   146: aload 7
    //   148: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: dup
    //   152: astore 10
    //   154: checkcast 177	java/lang/Number
    //   157: invokevirtual 181	java/lang/Number:intValue	()I
    //   160: iconst_1
    //   161: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   164: aload 9
    //   166: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: dup
    //   173: astore 10
    //   175: checkcast 177	java/lang/Number
    //   178: invokevirtual 181	java/lang/Number:intValue	()I
    //   181: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   184: goto +6 -> 190
    //   187: ldc_w 290
    //   190: areturn
    //   191: new 53	gnu/mapping/WrongType
    //   194: dup_x1
    //   195: swap
    //   196: ldc 72
    //   198: iconst_1
    //   199: aload 4
    //   201: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   204: athrow
    //   205: new 53	gnu/mapping/WrongType
    //   208: dup_x1
    //   209: swap
    //   210: ldc 77
    //   212: iconst_1
    //   213: aload 5
    //   215: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   218: athrow
    //   219: new 53	gnu/mapping/WrongType
    //   222: dup_x1
    //   223: swap
    //   224: ldc -84
    //   226: iconst_0
    //   227: aload 10
    //   229: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: new 53	gnu/mapping/WrongType
    //   236: dup_x1
    //   237: swap
    //   238: ldc -84
    //   240: iconst_1
    //   241: aload 10
    //   243: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: new 53	gnu/mapping/WrongType
    //   250: dup_x1
    //   251: swap
    //   252: ldc -84
    //   254: iconst_2
    //   255: aload 10
    //   257: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   260: athrow
    // Line number table:
    //   Java source line #1077	-> byte code offset #0
    //   Java source line #1078	-> byte code offset #8
    //   Java source line #1079	-> byte code offset #55
    //   Java source line #1080	-> byte code offset #105
    //   Java source line #10000	-> byte code offset #134
    //   Java source line #1081	-> byte code offset #134
    //   Java source line #1082	-> byte code offset #187
    //   Java source line #1078	-> byte code offset #191
    //   Java source line #1081	-> byte code offset #219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	s	Object
    //   0	190	1	argsArray	Object[]
    //   0	53	2	criterion$Plstart$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	76	3	criterion	Object
    //   17	1	4	localLList2	LList
    //   53	147	4	rest	Object
    //   41	173	5	localObject1	Object
    //   67	32	6	i	int
    //   85	1	7	localObject2	Object
    //   105	42	7	start	Object
    //   103	16	8	end	Object
    //   124	41	9	temp	Object
    //   141	115	10	localObject3	Object
    //   191	1	14	localClassCastException1	ClassCastException
    //   205	1	15	localClassCastException2	ClassCastException
    //   219	1	16	localClassCastException3	ClassCastException
    //   233	1	17	localClassCastException4	ClassCastException
    //   247	1	18	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	191	java/lang/ClassCastException
    //   43	46	205	java/lang/ClassCastException
    //   143	146	219	java/lang/ClassCastException
    //   154	160	233	java/lang/ClassCastException
    //   175	181	247	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringSkipRight$V(Object str, Object criterion, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 809	gnu/kawa/slib/srfi13:string$Mnskip$Mnright	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload_1
    //   59: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   62: ifeq +86 -> 148
    //   65: iconst_m1
    //   66: aload 7
    //   68: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   71: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: astore 8
    //   76: aload 8
    //   78: aload 6
    //   80: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   83: ifeq +59 -> 142
    //   86: aload_1
    //   87: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   93: aload_0
    //   94: ldc 43
    //   96: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   99: dup
    //   100: astore 9
    //   102: checkcast 43	java/lang/CharSequence
    //   105: aload 8
    //   107: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   110: dup
    //   111: astore 9
    //   113: checkcast 177	java/lang/Number
    //   116: invokevirtual 181	java/lang/Number:intValue	()I
    //   119: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   122: if_icmpne +15 -> 137
    //   125: iconst_m1
    //   126: aload 8
    //   128: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   131: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: goto -60 -> 74
    //   137: aload 8
    //   139: goto +231 -> 370
    //   142: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   145: goto +225 -> 370
    //   148: aload_1
    //   149: instanceof 371
    //   152: ifeq +95 -> 247
    //   155: iconst_m1
    //   156: aload 7
    //   158: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   161: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: astore 8
    //   166: aload 8
    //   168: aload 6
    //   170: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   173: ifeq +68 -> 241
    //   176: aload_1
    //   177: ldc_w 371
    //   180: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   183: dup
    //   184: astore 9
    //   186: checkcast 371	gnu/kawa/slib/srfi14$CharSet
    //   189: aload_0
    //   190: ldc 43
    //   192: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   195: dup
    //   196: astore 9
    //   198: checkcast 43	java/lang/CharSequence
    //   201: aload 8
    //   203: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   206: dup
    //   207: astore 9
    //   209: checkcast 177	java/lang/Number
    //   212: invokevirtual 181	java/lang/Number:intValue	()I
    //   215: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   218: invokestatic 379	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
    //   221: ifeq +15 -> 236
    //   224: iconst_m1
    //   225: aload 8
    //   227: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   230: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: goto -69 -> 164
    //   236: aload 8
    //   238: goto +132 -> 370
    //   241: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   244: goto +126 -> 370
    //   247: aload_1
    //   248: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   251: ifeq +92 -> 343
    //   254: iconst_m1
    //   255: aload 7
    //   257: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   260: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   263: astore 8
    //   265: aload 8
    //   267: aload 6
    //   269: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   272: ifeq +65 -> 337
    //   275: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   278: aload_1
    //   279: aload_0
    //   280: ldc 43
    //   282: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   285: dup
    //   286: astore 9
    //   288: checkcast 43	java/lang/CharSequence
    //   291: aload 8
    //   293: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   296: dup
    //   297: astore 9
    //   299: checkcast 177	java/lang/Number
    //   302: invokevirtual 181	java/lang/Number:intValue	()I
    //   305: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   308: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   311: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   314: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   317: ifeq +15 -> 332
    //   320: iconst_m1
    //   321: aload 8
    //   323: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   326: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: goto -66 -> 263
    //   332: aload 8
    //   334: goto +36 -> 370
    //   337: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   340: goto +30 -> 370
    //   343: iconst_3
    //   344: anewarray 27	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: ldc_w 811
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: getstatic 809	gnu/kawa/slib/srfi13:string$Mnskip$Mnright	Lgnu/expr/ModuleMethod;
    //   358: aastore
    //   359: dup
    //   360: iconst_2
    //   361: aload_1
    //   362: aastore
    //   363: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   366: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   369: athrow
    //   370: areturn
    //   371: new 53	gnu/mapping/WrongType
    //   374: dup_x1
    //   375: swap
    //   376: ldc -16
    //   378: iconst_1
    //   379: aload 9
    //   381: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   384: athrow
    //   385: new 53	gnu/mapping/WrongType
    //   388: dup_x1
    //   389: swap
    //   390: ldc -16
    //   392: iconst_2
    //   393: aload 9
    //   395: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   398: athrow
    //   399: new 53	gnu/mapping/WrongType
    //   402: dup_x1
    //   403: swap
    //   404: ldc_w 373
    //   407: iconst_0
    //   408: aload 9
    //   410: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   413: athrow
    //   414: new 53	gnu/mapping/WrongType
    //   417: dup_x1
    //   418: swap
    //   419: ldc -16
    //   421: iconst_1
    //   422: aload 9
    //   424: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   427: athrow
    //   428: new 53	gnu/mapping/WrongType
    //   431: dup_x1
    //   432: swap
    //   433: ldc -16
    //   435: iconst_2
    //   436: aload 9
    //   438: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   441: athrow
    //   442: new 53	gnu/mapping/WrongType
    //   445: dup_x1
    //   446: swap
    //   447: ldc -16
    //   449: iconst_1
    //   450: aload 9
    //   452: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   455: athrow
    //   456: new 53	gnu/mapping/WrongType
    //   459: dup_x1
    //   460: swap
    //   461: ldc -16
    //   463: iconst_2
    //   464: aload 9
    //   466: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   469: athrow
    // Line number table:
    //   Java source line #1263	-> byte code offset #0
    //   Java source line #1264	-> byte code offset #9
    //   Java source line #1265	-> byte code offset #58
    //   Java source line #1266	-> byte code offset #65
    //   Java source line #1267	-> byte code offset #76
    //   Java source line #1268	-> byte code offset #86
    //   Java source line #1269	-> byte code offset #125
    //   Java source line #1268	-> byte code offset #137
    //   Java source line #1271	-> byte code offset #148
    //   Java source line #1272	-> byte code offset #155
    //   Java source line #1273	-> byte code offset #166
    //   Java source line #1274	-> byte code offset #176
    //   Java source line #1275	-> byte code offset #224
    //   Java source line #1274	-> byte code offset #236
    //   Java source line #1277	-> byte code offset #247
    //   Java source line #1278	-> byte code offset #254
    //   Java source line #1279	-> byte code offset #265
    //   Java source line #1280	-> byte code offset #275
    //   Java source line #1282	-> byte code offset #343
    //   Java source line #1268	-> byte code offset #371
    //   Java source line #1274	-> byte code offset #399
    //   Java source line #1280	-> byte code offset #442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	str	Object
    //   0	370	1	criterion	Object
    //   0	370	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstart$Plend	LList
    //   6	44	4	localObject1	Object
    //   20	32	5	i	int
    //   38	1	6	localObject2	Object
    //   58	210	6	start	Object
    //   56	200	7	end	Object
    //   74	64	8	i	Object
    //   164	73	8	i	Object
    //   263	70	8	i	Object
    //   100	365	9	localObject3	Object
    //   371	1	13	localClassCastException1	ClassCastException
    //   385	1	14	localClassCastException2	ClassCastException
    //   399	1	15	localClassCastException3	ClassCastException
    //   414	1	16	localClassCastException4	ClassCastException
    //   428	1	17	localClassCastException5	ClassCastException
    //   442	1	18	localClassCastException6	ClassCastException
    //   456	1	19	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   102	105	371	java/lang/ClassCastException
    //   113	119	385	java/lang/ClassCastException
    //   186	189	399	java/lang/ClassCastException
    //   198	201	414	java/lang/ClassCastException
    //   209	215	428	java/lang/ClassCastException
    //   288	291	442	java/lang/ClassCastException
    //   299	305	456	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTrimBoth$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: getstatic 708	gnu/kawa/slib/srfi14$CharSet:whitespace	Lgnu/kawa/slib/srfi14$CharSet;
    //   31: astore_3
    //   32: aload_2
    //   33: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   36: ifne +16 -> 52
    //   39: aload_2
    //   40: dup
    //   41: astore 5
    //   43: checkcast 70	gnu/lists/Pair
    //   46: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   49: goto +4 -> 53
    //   52: aload_2
    //   53: astore 4
    //   55: getstatic 720	gnu/kawa/slib/srfi13:string$Mntrim$Mnboth	Lgnu/expr/ModuleMethod;
    //   58: aload_0
    //   59: aload 4
    //   61: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   64: astore 5
    //   66: iconst_0
    //   67: istore 6
    //   69: aload 5
    //   71: iload 6
    //   73: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   76: istore 6
    //   78: aload 5
    //   80: iload 6
    //   82: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   85: astore 7
    //   87: aload 5
    //   89: iload 6
    //   91: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   94: istore 6
    //   96: aload 5
    //   98: iload 6
    //   100: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   103: astore 8
    //   105: aload_0
    //   106: aload_3
    //   107: iconst_2
    //   108: anewarray 27	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 7
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload 8
    //   120: aastore
    //   121: invokestatic 639	gnu/kawa/slib/srfi13:stringSkip$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore 9
    //   126: aload 9
    //   128: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   131: ifeq +73 -> 204
    //   134: aload_0
    //   135: ldc 43
    //   137: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   140: dup
    //   141: astore 10
    //   143: checkcast 43	java/lang/CharSequence
    //   146: aload 9
    //   148: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: dup
    //   152: astore 10
    //   154: checkcast 177	java/lang/Number
    //   157: invokevirtual 181	java/lang/Number:intValue	()I
    //   160: iconst_1
    //   161: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   164: aload_0
    //   165: aload_3
    //   166: iconst_2
    //   167: anewarray 27	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload 9
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload 8
    //   179: aastore
    //   180: invokestatic 717	gnu/kawa/slib/srfi13:stringSkipRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   183: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: dup
    //   190: astore 10
    //   192: checkcast 177	java/lang/Number
    //   195: invokevirtual 181	java/lang/Number:intValue	()I
    //   198: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   201: goto +6 -> 207
    //   204: ldc_w 290
    //   207: areturn
    //   208: new 53	gnu/mapping/WrongType
    //   211: dup_x1
    //   212: swap
    //   213: ldc 72
    //   215: iconst_1
    //   216: aload 4
    //   218: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: new 53	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc 77
    //   229: iconst_1
    //   230: aload 5
    //   232: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   235: athrow
    //   236: new 53	gnu/mapping/WrongType
    //   239: dup_x1
    //   240: swap
    //   241: ldc -84
    //   243: iconst_0
    //   244: aload 10
    //   246: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   249: athrow
    //   250: new 53	gnu/mapping/WrongType
    //   253: dup_x1
    //   254: swap
    //   255: ldc -84
    //   257: iconst_1
    //   258: aload 10
    //   260: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //   264: new 53	gnu/mapping/WrongType
    //   267: dup_x1
    //   268: swap
    //   269: ldc -84
    //   271: iconst_2
    //   272: aload 10
    //   274: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   277: athrow
    // Line number table:
    //   Java source line #1084	-> byte code offset #0
    //   Java source line #1085	-> byte code offset #8
    //   Java source line #1086	-> byte code offset #55
    //   Java source line #1087	-> byte code offset #105
    //   Java source line #10000	-> byte code offset #134
    //   Java source line #1089	-> byte code offset #134
    //   Java source line #1090	-> byte code offset #204
    //   Java source line #1085	-> byte code offset #208
    //   Java source line #1089	-> byte code offset #236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	s	Object
    //   0	207	1	argsArray	Object[]
    //   0	53	2	criterion$Plstart$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	135	3	criterion	Object
    //   17	1	4	localLList2	LList
    //   53	164	4	rest	Object
    //   41	190	5	localObject1	Object
    //   67	32	6	i	int
    //   85	1	7	localObject2	Object
    //   105	9	7	start	Object
    //   103	75	8	end	Object
    //   124	49	9	temp	Object
    //   141	132	10	localObject3	Object
    //   208	1	14	localClassCastException1	ClassCastException
    //   222	1	15	localClassCastException2	ClassCastException
    //   236	1	16	localClassCastException3	ClassCastException
    //   250	1	17	localClassCastException4	ClassCastException
    //   264	1	18	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	208	java/lang/ClassCastException
    //   43	46	222	java/lang/ClassCastException
    //   143	146	236	java/lang/ClassCastException
    //   154	160	250	java/lang/ClassCastException
    //   192	198	264	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringPadRight$V(Object s, Object n, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   13: ifne +16 -> 29
    //   16: aload_3
    //   17: dup
    //   18: astore 5
    //   20: checkcast 70	gnu/lists/Pair
    //   23: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   26: goto +6 -> 32
    //   29: getstatic 724	gnu/kawa/slib/srfi13:Lit7	Lgnu/text/Char;
    //   32: astore 4
    //   34: aload 4
    //   36: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   39: ifne +8 -> 47
    //   42: getstatic 724	gnu/kawa/slib/srfi13:Lit7	Lgnu/text/Char;
    //   45: astore 4
    //   47: aload_3
    //   48: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   51: ifne +16 -> 67
    //   54: aload_3
    //   55: dup
    //   56: astore 6
    //   58: checkcast 70	gnu/lists/Pair
    //   61: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   64: goto +4 -> 68
    //   67: aload_3
    //   68: astore 5
    //   70: getstatic 727	gnu/kawa/slib/srfi13:string$Mnpad$Mnright	Lgnu/expr/ModuleMethod;
    //   73: aload_0
    //   74: aload 5
    //   76: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   79: astore 6
    //   81: iconst_0
    //   82: istore 7
    //   84: aload 6
    //   86: iload 7
    //   88: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   91: istore 7
    //   93: aload 6
    //   95: iload 7
    //   97: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   100: astore 8
    //   102: aload 6
    //   104: iload 7
    //   106: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   109: istore 7
    //   111: aload 6
    //   113: iload 7
    //   115: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   118: astore 9
    //   120: getstatic 730	gnu/kawa/slib/srfi13:lambda$Fn30	Lgnu/expr/ModuleMethod;
    //   123: aload_1
    //   124: getstatic 727	gnu/kawa/slib/srfi13:string$Mnpad$Mnright	Lgnu/expr/ModuleMethod;
    //   127: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: pop
    //   131: iconst_m1
    //   132: aload 9
    //   134: aload 8
    //   136: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: astore 10
    //   141: aload_1
    //   142: aload 10
    //   144: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   147: ifeq +54 -> 201
    //   150: aload_0
    //   151: ldc 43
    //   153: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   156: dup
    //   157: astore 11
    //   159: checkcast 43	java/lang/CharSequence
    //   162: aload 8
    //   164: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   167: dup
    //   168: astore 11
    //   170: checkcast 177	java/lang/Number
    //   173: invokevirtual 181	java/lang/Number:intValue	()I
    //   176: iconst_1
    //   177: aload 8
    //   179: aload_1
    //   180: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   186: dup
    //   187: astore 11
    //   189: checkcast 177	java/lang/Number
    //   192: invokevirtual 181	java/lang/Number:intValue	()I
    //   195: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   198: goto +80 -> 278
    //   201: aload_1
    //   202: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   205: dup
    //   206: astore 12
    //   208: checkcast 177	java/lang/Number
    //   211: invokevirtual 181	java/lang/Number:intValue	()I
    //   214: aload 4
    //   216: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   219: dup
    //   220: astore 12
    //   222: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   225: invokestatic 733	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   228: astore 11
    //   230: aload 11
    //   232: iconst_0
    //   233: aload_0
    //   234: ldc 43
    //   236: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   239: dup
    //   240: astore 12
    //   242: checkcast 43	java/lang/CharSequence
    //   245: aload 8
    //   247: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: dup
    //   251: astore 12
    //   253: checkcast 177	java/lang/Number
    //   256: invokevirtual 181	java/lang/Number:intValue	()I
    //   259: aload 9
    //   261: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   264: dup
    //   265: astore 12
    //   267: checkcast 177	java/lang/Number
    //   270: invokevirtual 181	java/lang/Number:intValue	()I
    //   273: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   276: aload 11
    //   278: areturn
    //   279: new 53	gnu/mapping/WrongType
    //   282: dup_x1
    //   283: swap
    //   284: ldc 72
    //   286: iconst_1
    //   287: aload 5
    //   289: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   292: athrow
    //   293: new 53	gnu/mapping/WrongType
    //   296: dup_x1
    //   297: swap
    //   298: ldc 77
    //   300: iconst_1
    //   301: aload 6
    //   303: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   306: athrow
    //   307: new 53	gnu/mapping/WrongType
    //   310: dup_x1
    //   311: swap
    //   312: ldc -84
    //   314: iconst_0
    //   315: aload 11
    //   317: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   320: athrow
    //   321: new 53	gnu/mapping/WrongType
    //   324: dup_x1
    //   325: swap
    //   326: ldc -84
    //   328: iconst_1
    //   329: aload 11
    //   331: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   334: athrow
    //   335: new 53	gnu/mapping/WrongType
    //   338: dup_x1
    //   339: swap
    //   340: ldc -84
    //   342: iconst_2
    //   343: aload 11
    //   345: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   348: athrow
    //   349: new 53	gnu/mapping/WrongType
    //   352: dup_x1
    //   353: swap
    //   354: ldc -36
    //   356: iconst_1
    //   357: aload 12
    //   359: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   362: athrow
    //   363: new 53	gnu/mapping/WrongType
    //   366: dup_x1
    //   367: swap
    //   368: ldc -36
    //   370: iconst_2
    //   371: aload 12
    //   373: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   376: athrow
    //   377: new 53	gnu/mapping/WrongType
    //   380: dup_x1
    //   381: swap
    //   382: ldc_w 334
    //   385: iconst_3
    //   386: aload 12
    //   388: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   391: athrow
    //   392: new 53	gnu/mapping/WrongType
    //   395: dup_x1
    //   396: swap
    //   397: ldc_w 334
    //   400: iconst_4
    //   401: aload 12
    //   403: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   406: athrow
    //   407: new 53	gnu/mapping/WrongType
    //   410: dup_x1
    //   411: swap
    //   412: ldc_w 334
    //   415: iconst_5
    //   416: aload 12
    //   418: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   421: athrow
    // Line number table:
    //   Java source line #1093	-> byte code offset #0
    //   Java source line #1094	-> byte code offset #9
    //   Java source line #1095	-> byte code offset #70
    //   Java source line #1096	-> byte code offset #120
    //   Java source line #1097	-> byte code offset #123
    //   Java source line #1098	-> byte code offset #131
    //   Java source line #1099	-> byte code offset #141
    //   Java source line #1100	-> byte code offset #150
    //   Java source line #1101	-> byte code offset #201
    //   Java source line #1102	-> byte code offset #230
    //   Java source line #1103	-> byte code offset #276
    //   Java source line #1094	-> byte code offset #279
    //   Java source line #1100	-> byte code offset #307
    //   Java source line #1101	-> byte code offset #349
    //   Java source line #1102	-> byte code offset #377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	s	Object
    //   0	278	1	n	Object
    //   0	278	2	argsArray	Object[]
    //   0	68	3	char$Plstart$Plend	LList
    //   6	1	4	localLList1	LList
    //   32	183	4	char	Object
    //   18	1	5	localLList2	LList
    //   68	220	5	rest	Object
    //   56	246	6	localObject1	Object
    //   82	32	7	i	int
    //   100	1	8	localObject2	Object
    //   120	126	8	start	Object
    //   118	142	9	end	Object
    //   139	4	10	len	Object
    //   157	31	11	localObject3	Object
    //   228	116	11	ans	FString
    //   206	211	12	localObject4	Object
    //   279	1	17	localClassCastException1	ClassCastException
    //   293	1	18	localClassCastException2	ClassCastException
    //   307	1	19	localClassCastException3	ClassCastException
    //   321	1	20	localClassCastException4	ClassCastException
    //   335	1	21	localClassCastException5	ClassCastException
    //   349	1	22	localClassCastException6	ClassCastException
    //   363	1	23	localClassCastException7	ClassCastException
    //   377	1	24	localClassCastException8	ClassCastException
    //   392	1	25	localClassCastException9	ClassCastException
    //   407	1	26	localClassCastException10	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   20	23	279	java/lang/ClassCastException
    //   58	61	293	java/lang/ClassCastException
    //   159	162	307	java/lang/ClassCastException
    //   170	176	321	java/lang/ClassCastException
    //   189	195	335	java/lang/ClassCastException
    //   208	214	349	java/lang/ClassCastException
    //   222	225	363	java/lang/ClassCastException
    //   242	245	377	java/lang/ClassCastException
    //   253	259	392	java/lang/ClassCastException
    //   267	273	407	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringPad$V(Object s, Object n, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   13: ifne +16 -> 29
    //   16: aload_3
    //   17: dup
    //   18: astore 5
    //   20: checkcast 70	gnu/lists/Pair
    //   23: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   26: goto +6 -> 32
    //   29: getstatic 724	gnu/kawa/slib/srfi13:Lit7	Lgnu/text/Char;
    //   32: astore 4
    //   34: aload 4
    //   36: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   39: ifne +8 -> 47
    //   42: getstatic 724	gnu/kawa/slib/srfi13:Lit7	Lgnu/text/Char;
    //   45: astore 4
    //   47: aload_3
    //   48: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   51: ifne +16 -> 67
    //   54: aload_3
    //   55: dup
    //   56: astore 6
    //   58: checkcast 70	gnu/lists/Pair
    //   61: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   64: goto +4 -> 68
    //   67: aload_3
    //   68: astore 5
    //   70: getstatic 736	gnu/kawa/slib/srfi13:string$Mnpad	Lgnu/expr/ModuleMethod;
    //   73: aload_0
    //   74: aload 5
    //   76: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   79: astore 6
    //   81: iconst_0
    //   82: istore 7
    //   84: aload 6
    //   86: iload 7
    //   88: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   91: istore 7
    //   93: aload 6
    //   95: iload 7
    //   97: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   100: astore 8
    //   102: aload 6
    //   104: iload 7
    //   106: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   109: istore 7
    //   111: aload 6
    //   113: iload 7
    //   115: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   118: astore 9
    //   120: getstatic 739	gnu/kawa/slib/srfi13:lambda$Fn31	Lgnu/expr/ModuleMethod;
    //   123: aload_1
    //   124: getstatic 736	gnu/kawa/slib/srfi13:string$Mnpad	Lgnu/expr/ModuleMethod;
    //   127: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: pop
    //   131: iconst_m1
    //   132: aload 9
    //   134: aload 8
    //   136: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: astore 10
    //   141: aload_1
    //   142: aload 10
    //   144: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   147: ifeq +54 -> 201
    //   150: aload_0
    //   151: ldc 43
    //   153: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   156: dup
    //   157: astore 11
    //   159: checkcast 43	java/lang/CharSequence
    //   162: iconst_m1
    //   163: aload 9
    //   165: aload_1
    //   166: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: dup
    //   173: astore 11
    //   175: checkcast 177	java/lang/Number
    //   178: invokevirtual 181	java/lang/Number:intValue	()I
    //   181: aload 9
    //   183: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   186: dup
    //   187: astore 11
    //   189: checkcast 177	java/lang/Number
    //   192: invokevirtual 181	java/lang/Number:intValue	()I
    //   195: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   198: goto +98 -> 296
    //   201: aload_1
    //   202: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   205: dup
    //   206: astore 12
    //   208: checkcast 177	java/lang/Number
    //   211: invokevirtual 181	java/lang/Number:intValue	()I
    //   214: aload 4
    //   216: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   219: dup
    //   220: astore 12
    //   222: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   225: invokestatic 733	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   228: astore 11
    //   230: aload 11
    //   232: iconst_m1
    //   233: aload_1
    //   234: aload 10
    //   236: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   239: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   242: dup
    //   243: astore 12
    //   245: checkcast 177	java/lang/Number
    //   248: invokevirtual 181	java/lang/Number:intValue	()I
    //   251: aload_0
    //   252: ldc 43
    //   254: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   257: dup
    //   258: astore 12
    //   260: checkcast 43	java/lang/CharSequence
    //   263: aload 8
    //   265: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   268: dup
    //   269: astore 12
    //   271: checkcast 177	java/lang/Number
    //   274: invokevirtual 181	java/lang/Number:intValue	()I
    //   277: aload 9
    //   279: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   282: dup
    //   283: astore 12
    //   285: checkcast 177	java/lang/Number
    //   288: invokevirtual 181	java/lang/Number:intValue	()I
    //   291: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   294: aload 11
    //   296: areturn
    //   297: new 53	gnu/mapping/WrongType
    //   300: dup_x1
    //   301: swap
    //   302: ldc 72
    //   304: iconst_1
    //   305: aload 5
    //   307: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   310: athrow
    //   311: new 53	gnu/mapping/WrongType
    //   314: dup_x1
    //   315: swap
    //   316: ldc 77
    //   318: iconst_1
    //   319: aload 6
    //   321: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   324: athrow
    //   325: new 53	gnu/mapping/WrongType
    //   328: dup_x1
    //   329: swap
    //   330: ldc -84
    //   332: iconst_0
    //   333: aload 11
    //   335: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   338: athrow
    //   339: new 53	gnu/mapping/WrongType
    //   342: dup_x1
    //   343: swap
    //   344: ldc -84
    //   346: iconst_1
    //   347: aload 11
    //   349: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   352: athrow
    //   353: new 53	gnu/mapping/WrongType
    //   356: dup_x1
    //   357: swap
    //   358: ldc -84
    //   360: iconst_2
    //   361: aload 11
    //   363: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //   367: new 53	gnu/mapping/WrongType
    //   370: dup_x1
    //   371: swap
    //   372: ldc -36
    //   374: iconst_1
    //   375: aload 12
    //   377: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 53	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc -36
    //   388: iconst_2
    //   389: aload 12
    //   391: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: new 53	gnu/mapping/WrongType
    //   398: dup_x1
    //   399: swap
    //   400: ldc_w 334
    //   403: iconst_2
    //   404: aload 12
    //   406: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   409: athrow
    //   410: new 53	gnu/mapping/WrongType
    //   413: dup_x1
    //   414: swap
    //   415: ldc_w 334
    //   418: iconst_3
    //   419: aload 12
    //   421: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   424: athrow
    //   425: new 53	gnu/mapping/WrongType
    //   428: dup_x1
    //   429: swap
    //   430: ldc_w 334
    //   433: iconst_4
    //   434: aload 12
    //   436: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   439: athrow
    //   440: new 53	gnu/mapping/WrongType
    //   443: dup_x1
    //   444: swap
    //   445: ldc_w 334
    //   448: iconst_5
    //   449: aload 12
    //   451: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   454: athrow
    // Line number table:
    //   Java source line #1105	-> byte code offset #0
    //   Java source line #1106	-> byte code offset #9
    //   Java source line #1107	-> byte code offset #70
    //   Java source line #1108	-> byte code offset #120
    //   Java source line #1109	-> byte code offset #123
    //   Java source line #1110	-> byte code offset #131
    //   Java source line #1111	-> byte code offset #141
    //   Java source line #1112	-> byte code offset #150
    //   Java source line #1113	-> byte code offset #201
    //   Java source line #1114	-> byte code offset #230
    //   Java source line #1115	-> byte code offset #294
    //   Java source line #1106	-> byte code offset #297
    //   Java source line #1112	-> byte code offset #325
    //   Java source line #1113	-> byte code offset #367
    //   Java source line #1114	-> byte code offset #395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	s	Object
    //   0	296	1	n	Object
    //   0	296	2	argsArray	Object[]
    //   0	68	3	char$Plstart$Plend	LList
    //   6	1	4	localLList1	LList
    //   32	183	4	char	Object
    //   18	1	5	localLList2	LList
    //   68	238	5	rest	Object
    //   56	264	6	localObject1	Object
    //   82	32	7	i	int
    //   100	1	8	localObject2	Object
    //   120	144	8	start	Object
    //   118	160	9	end	Object
    //   139	96	10	len	Object
    //   157	31	11	localObject3	Object
    //   228	134	11	ans	FString
    //   206	244	12	localObject4	Object
    //   297	1	17	localClassCastException1	ClassCastException
    //   311	1	18	localClassCastException2	ClassCastException
    //   325	1	19	localClassCastException3	ClassCastException
    //   339	1	20	localClassCastException4	ClassCastException
    //   353	1	21	localClassCastException5	ClassCastException
    //   367	1	22	localClassCastException6	ClassCastException
    //   381	1	23	localClassCastException7	ClassCastException
    //   395	1	24	localClassCastException8	ClassCastException
    //   410	1	25	localClassCastException9	ClassCastException
    //   425	1	26	localClassCastException10	ClassCastException
    //   440	1	27	localClassCastException11	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   20	23	297	java/lang/ClassCastException
    //   58	61	311	java/lang/ClassCastException
    //   159	162	325	java/lang/ClassCastException
    //   175	181	339	java/lang/ClassCastException
    //   189	195	353	java/lang/ClassCastException
    //   208	214	367	java/lang/ClassCastException
    //   222	225	381	java/lang/ClassCastException
    //   245	251	395	java/lang/ClassCastException
    //   260	263	410	java/lang/ClassCastException
    //   271	277	425	java/lang/ClassCastException
    //   285	291	440	java/lang/ClassCastException
  }
  
  /* Error */
  public static CharSequence stringDelete$V(Object criterion, Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: new 741	gnu/kawa/slib/srfi13$frame3
    //   3: dup
    //   4: invokespecial 742	gnu/kawa/slib/srfi13$frame3:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: putfield 745	gnu/kawa/slib/srfi13$frame3:criterion	Ljava/lang/Object;
    //   15: aload_2
    //   16: iconst_0
    //   17: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   20: dup
    //   21: astore 5
    //   23: astore_3
    //   24: getstatic 748	gnu/kawa/slib/srfi13:string$Mndelete	Lgnu/expr/ModuleMethod;
    //   27: aload_1
    //   28: aload_3
    //   29: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   32: astore 5
    //   34: iconst_0
    //   35: istore 6
    //   37: aload 5
    //   39: iload 6
    //   41: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   44: istore 6
    //   46: aload 5
    //   48: iload 6
    //   50: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   53: astore 7
    //   55: aload 5
    //   57: iload 6
    //   59: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   62: istore 6
    //   64: aload 5
    //   66: iload 6
    //   68: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   71: astore 8
    //   73: aload 4
    //   75: getfield 745	gnu/kawa/slib/srfi13$frame3:criterion	Ljava/lang/Object;
    //   78: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   81: ifeq +108 -> 189
    //   84: iconst_m1
    //   85: aload 8
    //   87: aload 7
    //   89: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 9
    //   94: aload 9
    //   96: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: dup
    //   100: astore 10
    //   102: checkcast 177	java/lang/Number
    //   105: invokevirtual 181	java/lang/Number:intValue	()I
    //   108: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   111: aload 4
    //   113: swap
    //   114: putfield 752	gnu/kawa/slib/srfi13$frame3:temp	Lgnu/lists/FString;
    //   117: aload 4
    //   119: getfield 755	gnu/kawa/slib/srfi13$frame3:lambda$Fn32	Lgnu/expr/ModuleMethod;
    //   122: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   125: aload_1
    //   126: iconst_2
    //   127: anewarray 27	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload 7
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: aload 8
    //   139: aastore
    //   140: invokestatic 759	gnu/kawa/slib/srfi13:stringFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   143: astore 10
    //   145: aload 10
    //   147: aload 9
    //   149: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   152: ifeq +11 -> 163
    //   155: aload 4
    //   157: getfield 752	gnu/kawa/slib/srfi13$frame3:temp	Lgnu/lists/FString;
    //   160: goto +212 -> 372
    //   163: aload 4
    //   165: getfield 752	gnu/kawa/slib/srfi13$frame3:temp	Lgnu/lists/FString;
    //   168: iconst_0
    //   169: aload 10
    //   171: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: dup
    //   175: astore 11
    //   177: checkcast 177	java/lang/Number
    //   180: invokevirtual 181	java/lang/Number:intValue	()I
    //   183: invokestatic 196	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   186: goto +186 -> 372
    //   189: aload 4
    //   191: getfield 745	gnu/kawa/slib/srfi13$frame3:criterion	Ljava/lang/Object;
    //   194: instanceof 371
    //   197: ifeq +11 -> 208
    //   200: aload 4
    //   202: getfield 745	gnu/kawa/slib/srfi13$frame3:criterion	Ljava/lang/Object;
    //   205: goto +78 -> 283
    //   208: aload 4
    //   210: getfield 745	gnu/kawa/slib/srfi13$frame3:criterion	Ljava/lang/Object;
    //   213: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   216: ifeq +42 -> 258
    //   219: new 371	gnu/kawa/slib/srfi14$CharSet
    //   222: dup
    //   223: aload 4
    //   225: getfield 745	gnu/kawa/slib/srfi13$frame3:criterion	Ljava/lang/Object;
    //   228: dup
    //   229: instanceof 761
    //   232: ifeq +9 -> 241
    //   235: checkcast 761	[I
    //   238: goto +14 -> 252
    //   241: iconst_1
    //   242: newarray int
    //   244: dup_x1
    //   245: swap
    //   246: iconst_0
    //   247: swap
    //   248: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   251: iastore
    //   252: invokespecial 764	gnu/kawa/slib/srfi14$CharSet:<init>	([I)V
    //   255: goto +28 -> 283
    //   258: iconst_2
    //   259: anewarray 27	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: ldc_w 766
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: aload 4
    //   272: getfield 745	gnu/kawa/slib/srfi13$frame3:criterion	Ljava/lang/Object;
    //   275: aastore
    //   276: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   279: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   282: athrow
    //   283: aload 4
    //   285: swap
    //   286: putfield 769	gnu/kawa/slib/srfi13$frame3:cset	Ljava/lang/Object;
    //   289: aload 4
    //   291: getfield 772	gnu/kawa/slib/srfi13$frame3:lambda$Fn33	Lgnu/expr/ModuleMethod;
    //   294: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   297: aload_1
    //   298: iconst_2
    //   299: anewarray 27	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: aload 7
    //   306: aastore
    //   307: dup
    //   308: iconst_1
    //   309: aload 8
    //   311: aastore
    //   312: invokestatic 759	gnu/kawa/slib/srfi13:stringFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   315: astore 9
    //   317: aload 9
    //   319: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: dup
    //   323: astore 10
    //   325: checkcast 177	java/lang/Number
    //   328: invokevirtual 181	java/lang/Number:intValue	()I
    //   331: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   334: aload 4
    //   336: swap
    //   337: putfield 775	gnu/kawa/slib/srfi13$frame3:ans	Lgnu/lists/FString;
    //   340: aload 4
    //   342: getfield 778	gnu/kawa/slib/srfi13$frame3:lambda$Fn34	Lgnu/expr/ModuleMethod;
    //   345: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   348: aload_1
    //   349: iconst_2
    //   350: anewarray 27	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload 7
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: aload 8
    //   362: aastore
    //   363: invokestatic 759	gnu/kawa/slib/srfi13:stringFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: aload 4
    //   369: getfield 775	gnu/kawa/slib/srfi13$frame3:ans	Lgnu/lists/FString;
    //   372: areturn
    //   373: new 53	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc -36
    //   380: iconst_1
    //   381: aload 10
    //   383: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   386: athrow
    //   387: new 53	gnu/mapping/WrongType
    //   390: dup_x1
    //   391: swap
    //   392: ldc_w 650
    //   395: iconst_3
    //   396: aload 11
    //   398: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   401: athrow
    //   402: new 53	gnu/mapping/WrongType
    //   405: dup_x1
    //   406: swap
    //   407: ldc -36
    //   409: iconst_1
    //   410: aload 10
    //   412: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   415: athrow
    // Line number table:
    //   Java source line #1133	-> byte code offset #0
    //   Java source line #1134	-> byte code offset #24
    //   Java source line #1135	-> byte code offset #73
    //   Java source line #1136	-> byte code offset #84
    //   Java source line #1137	-> byte code offset #94
    //   Java source line #1136	-> byte code offset #117
    //   Java source line #1138	-> byte code offset #117
    //   Java source line #1142	-> byte code offset #122
    //   Java source line #1143	-> byte code offset #145
    //   Java source line #1145	-> byte code offset #189
    //   Java source line #1146	-> byte code offset #208
    //   Java source line #1147	-> byte code offset #258
    //   Java source line #1145	-> byte code offset #289
    //   Java source line #1148	-> byte code offset #289
    //   Java source line #1151	-> byte code offset #294
    //   Java source line #1145	-> byte code offset #317
    //   Java source line #1152	-> byte code offset #317
    //   Java source line #1153	-> byte code offset #340
    //   Java source line #1157	-> byte code offset #345
    //   Java source line #1158	-> byte code offset #367
    //   Java source line #1137	-> byte code offset #373
    //   Java source line #1143	-> byte code offset #387
    //   Java source line #1152	-> byte code offset #402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	criterion	Object
    //   0	372	1	s	Object
    //   0	372	2	argsArray	Object[]
    //   0	29	3	maybe$Mnstart$Plend	LList
    //   7	361	4	$heapFrame	frame3
    //   21	44	5	localObject1	Object
    //   35	32	6	i	int
    //   53	1	7	localObject2	Object
    //   73	283	7	start	Object
    //   71	290	8	end	Object
    //   92	56	9	slen	Object
    //   315	3	9	len	Object
    //   100	1	10	localObject3	Object
    //   143	268	10	ans$Mnlen	Object
    //   175	222	11	localObject4	Object
    //   373	1	15	localClassCastException1	ClassCastException
    //   387	1	16	localClassCastException2	ClassCastException
    //   402	1	17	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   102	108	373	java/lang/ClassCastException
    //   177	183	387	java/lang/ClassCastException
    //   325	331	402	java/lang/ClassCastException
  }
  
  /* Error */
  public static CharSequence stringFilter$V(Object criterion, Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: new 780	gnu/kawa/slib/srfi13$frame4
    //   3: dup
    //   4: invokespecial 781	gnu/kawa/slib/srfi13$frame4:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: putfield 782	gnu/kawa/slib/srfi13$frame4:criterion	Ljava/lang/Object;
    //   15: aload_2
    //   16: iconst_0
    //   17: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   20: dup
    //   21: astore 5
    //   23: astore_3
    //   24: getstatic 785	gnu/kawa/slib/srfi13:string$Mnfilter	Lgnu/expr/ModuleMethod;
    //   27: aload_1
    //   28: aload_3
    //   29: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   32: astore 5
    //   34: iconst_0
    //   35: istore 6
    //   37: aload 5
    //   39: iload 6
    //   41: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   44: istore 6
    //   46: aload 5
    //   48: iload 6
    //   50: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   53: astore 7
    //   55: aload 5
    //   57: iload 6
    //   59: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   62: istore 6
    //   64: aload 5
    //   66: iload 6
    //   68: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   71: astore 8
    //   73: aload 4
    //   75: getfield 782	gnu/kawa/slib/srfi13$frame4:criterion	Ljava/lang/Object;
    //   78: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   81: ifeq +108 -> 189
    //   84: iconst_m1
    //   85: aload 8
    //   87: aload 7
    //   89: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 9
    //   94: aload 9
    //   96: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: dup
    //   100: astore 10
    //   102: checkcast 177	java/lang/Number
    //   105: invokevirtual 181	java/lang/Number:intValue	()I
    //   108: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   111: aload 4
    //   113: swap
    //   114: putfield 786	gnu/kawa/slib/srfi13$frame4:temp	Lgnu/lists/FString;
    //   117: aload 4
    //   119: getfield 789	gnu/kawa/slib/srfi13$frame4:lambda$Fn35	Lgnu/expr/ModuleMethod;
    //   122: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   125: aload_1
    //   126: iconst_2
    //   127: anewarray 27	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload 7
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: aload 8
    //   139: aastore
    //   140: invokestatic 759	gnu/kawa/slib/srfi13:stringFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   143: astore 10
    //   145: aload 10
    //   147: aload 9
    //   149: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   152: ifeq +11 -> 163
    //   155: aload 4
    //   157: getfield 786	gnu/kawa/slib/srfi13$frame4:temp	Lgnu/lists/FString;
    //   160: goto +212 -> 372
    //   163: aload 4
    //   165: getfield 786	gnu/kawa/slib/srfi13$frame4:temp	Lgnu/lists/FString;
    //   168: iconst_0
    //   169: aload 10
    //   171: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: dup
    //   175: astore 11
    //   177: checkcast 177	java/lang/Number
    //   180: invokevirtual 181	java/lang/Number:intValue	()I
    //   183: invokestatic 196	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   186: goto +186 -> 372
    //   189: aload 4
    //   191: getfield 782	gnu/kawa/slib/srfi13$frame4:criterion	Ljava/lang/Object;
    //   194: instanceof 371
    //   197: ifeq +11 -> 208
    //   200: aload 4
    //   202: getfield 782	gnu/kawa/slib/srfi13$frame4:criterion	Ljava/lang/Object;
    //   205: goto +78 -> 283
    //   208: aload 4
    //   210: getfield 782	gnu/kawa/slib/srfi13$frame4:criterion	Ljava/lang/Object;
    //   213: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   216: ifeq +42 -> 258
    //   219: new 371	gnu/kawa/slib/srfi14$CharSet
    //   222: dup
    //   223: aload 4
    //   225: getfield 782	gnu/kawa/slib/srfi13$frame4:criterion	Ljava/lang/Object;
    //   228: dup
    //   229: instanceof 761
    //   232: ifeq +9 -> 241
    //   235: checkcast 761	[I
    //   238: goto +14 -> 252
    //   241: iconst_1
    //   242: newarray int
    //   244: dup_x1
    //   245: swap
    //   246: iconst_0
    //   247: swap
    //   248: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   251: iastore
    //   252: invokespecial 764	gnu/kawa/slib/srfi14$CharSet:<init>	([I)V
    //   255: goto +28 -> 283
    //   258: iconst_2
    //   259: anewarray 27	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: ldc_w 766
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: aload 4
    //   272: getfield 782	gnu/kawa/slib/srfi13$frame4:criterion	Ljava/lang/Object;
    //   275: aastore
    //   276: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   279: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   282: athrow
    //   283: aload 4
    //   285: swap
    //   286: putfield 790	gnu/kawa/slib/srfi13$frame4:cset	Ljava/lang/Object;
    //   289: aload 4
    //   291: getfield 793	gnu/kawa/slib/srfi13$frame4:lambda$Fn36	Lgnu/expr/ModuleMethod;
    //   294: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   297: aload_1
    //   298: iconst_2
    //   299: anewarray 27	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: aload 7
    //   306: aastore
    //   307: dup
    //   308: iconst_1
    //   309: aload 8
    //   311: aastore
    //   312: invokestatic 759	gnu/kawa/slib/srfi13:stringFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   315: astore 9
    //   317: aload 9
    //   319: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: dup
    //   323: astore 10
    //   325: checkcast 177	java/lang/Number
    //   328: invokevirtual 181	java/lang/Number:intValue	()I
    //   331: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   334: aload 4
    //   336: swap
    //   337: putfield 794	gnu/kawa/slib/srfi13$frame4:ans	Lgnu/lists/FString;
    //   340: aload 4
    //   342: getfield 797	gnu/kawa/slib/srfi13$frame4:lambda$Fn37	Lgnu/expr/ModuleMethod;
    //   345: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   348: aload_1
    //   349: iconst_2
    //   350: anewarray 27	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload 7
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: aload 8
    //   362: aastore
    //   363: invokestatic 759	gnu/kawa/slib/srfi13:stringFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: aload 4
    //   369: getfield 794	gnu/kawa/slib/srfi13$frame4:ans	Lgnu/lists/FString;
    //   372: areturn
    //   373: new 53	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc -36
    //   380: iconst_1
    //   381: aload 10
    //   383: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   386: athrow
    //   387: new 53	gnu/mapping/WrongType
    //   390: dup_x1
    //   391: swap
    //   392: ldc_w 650
    //   395: iconst_3
    //   396: aload 11
    //   398: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   401: athrow
    //   402: new 53	gnu/mapping/WrongType
    //   405: dup_x1
    //   406: swap
    //   407: ldc -36
    //   409: iconst_1
    //   410: aload 10
    //   412: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   415: athrow
    // Line number table:
    //   Java source line #1160	-> byte code offset #0
    //   Java source line #1161	-> byte code offset #24
    //   Java source line #1162	-> byte code offset #73
    //   Java source line #1163	-> byte code offset #84
    //   Java source line #1164	-> byte code offset #94
    //   Java source line #1163	-> byte code offset #117
    //   Java source line #1165	-> byte code offset #117
    //   Java source line #1170	-> byte code offset #122
    //   Java source line #1171	-> byte code offset #145
    //   Java source line #1173	-> byte code offset #189
    //   Java source line #1174	-> byte code offset #208
    //   Java source line #1175	-> byte code offset #258
    //   Java source line #1173	-> byte code offset #289
    //   Java source line #1177	-> byte code offset #289
    //   Java source line #1180	-> byte code offset #294
    //   Java source line #1173	-> byte code offset #317
    //   Java source line #1181	-> byte code offset #317
    //   Java source line #1182	-> byte code offset #340
    //   Java source line #1186	-> byte code offset #345
    //   Java source line #1187	-> byte code offset #367
    //   Java source line #1164	-> byte code offset #373
    //   Java source line #1171	-> byte code offset #387
    //   Java source line #1181	-> byte code offset #402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	criterion	Object
    //   0	372	1	s	Object
    //   0	372	2	argsArray	Object[]
    //   0	29	3	maybe$Mnstart$Plend	LList
    //   7	361	4	$heapFrame	frame4
    //   21	44	5	localObject1	Object
    //   35	32	6	i	int
    //   53	1	7	localObject2	Object
    //   73	283	7	start	Object
    //   71	290	8	end	Object
    //   92	56	9	slen	Object
    //   315	3	9	len	Object
    //   100	1	10	localObject3	Object
    //   143	268	10	ans$Mnlen	Object
    //   175	222	11	localObject4	Object
    //   373	1	15	localClassCastException1	ClassCastException
    //   387	1	16	localClassCastException2	ClassCastException
    //   402	1	17	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   102	108	373	java/lang/ClassCastException
    //   177	183	387	java/lang/ClassCastException
    //   325	331	402	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringIndexRight$V(Object str, Object criterion, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 803	gnu/kawa/slib/srfi13:string$Mnindex$Mnright	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload_1
    //   59: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   62: ifeq +86 -> 148
    //   65: iconst_m1
    //   66: aload 7
    //   68: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   71: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: astore 8
    //   76: aload 8
    //   78: aload 6
    //   80: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   83: ifeq +59 -> 142
    //   86: aload_1
    //   87: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   93: aload_0
    //   94: ldc 43
    //   96: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   99: dup
    //   100: astore 9
    //   102: checkcast 43	java/lang/CharSequence
    //   105: aload 8
    //   107: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   110: dup
    //   111: astore 9
    //   113: checkcast 177	java/lang/Number
    //   116: invokevirtual 181	java/lang/Number:intValue	()I
    //   119: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   122: if_icmpne +8 -> 130
    //   125: aload 8
    //   127: goto +243 -> 370
    //   130: iconst_m1
    //   131: aload 8
    //   133: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   136: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: goto -65 -> 74
    //   142: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   145: goto +225 -> 370
    //   148: aload_1
    //   149: instanceof 371
    //   152: ifeq +95 -> 247
    //   155: iconst_m1
    //   156: aload 7
    //   158: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   161: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: astore 8
    //   166: aload 8
    //   168: aload 6
    //   170: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   173: ifeq +68 -> 241
    //   176: aload_1
    //   177: ldc_w 371
    //   180: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   183: dup
    //   184: astore 9
    //   186: checkcast 371	gnu/kawa/slib/srfi14$CharSet
    //   189: aload_0
    //   190: ldc 43
    //   192: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   195: dup
    //   196: astore 9
    //   198: checkcast 43	java/lang/CharSequence
    //   201: aload 8
    //   203: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   206: dup
    //   207: astore 9
    //   209: checkcast 177	java/lang/Number
    //   212: invokevirtual 181	java/lang/Number:intValue	()I
    //   215: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   218: invokestatic 379	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
    //   221: ifeq +8 -> 229
    //   224: aload 8
    //   226: goto +144 -> 370
    //   229: iconst_m1
    //   230: aload 8
    //   232: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   235: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: goto -74 -> 164
    //   241: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   244: goto +126 -> 370
    //   247: aload_1
    //   248: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   251: ifeq +92 -> 343
    //   254: iconst_m1
    //   255: aload 7
    //   257: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   260: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   263: astore 8
    //   265: aload 8
    //   267: aload 6
    //   269: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   272: ifeq +65 -> 337
    //   275: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   278: aload_1
    //   279: aload_0
    //   280: ldc 43
    //   282: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   285: dup
    //   286: astore 9
    //   288: checkcast 43	java/lang/CharSequence
    //   291: aload 8
    //   293: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   296: dup
    //   297: astore 9
    //   299: checkcast 177	java/lang/Number
    //   302: invokevirtual 181	java/lang/Number:intValue	()I
    //   305: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   308: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   311: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   314: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   317: ifeq +8 -> 325
    //   320: aload 8
    //   322: goto +48 -> 370
    //   325: iconst_m1
    //   326: aload 8
    //   328: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   331: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: goto -71 -> 263
    //   337: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   340: goto +30 -> 370
    //   343: iconst_3
    //   344: anewarray 27	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: ldc_w 384
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: getstatic 803	gnu/kawa/slib/srfi13:string$Mnindex$Mnright	Lgnu/expr/ModuleMethod;
    //   358: aastore
    //   359: dup
    //   360: iconst_2
    //   361: aload_1
    //   362: aastore
    //   363: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   366: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   369: athrow
    //   370: areturn
    //   371: new 53	gnu/mapping/WrongType
    //   374: dup_x1
    //   375: swap
    //   376: ldc -16
    //   378: iconst_1
    //   379: aload 9
    //   381: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   384: athrow
    //   385: new 53	gnu/mapping/WrongType
    //   388: dup_x1
    //   389: swap
    //   390: ldc -16
    //   392: iconst_2
    //   393: aload 9
    //   395: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   398: athrow
    //   399: new 53	gnu/mapping/WrongType
    //   402: dup_x1
    //   403: swap
    //   404: ldc_w 373
    //   407: iconst_0
    //   408: aload 9
    //   410: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   413: athrow
    //   414: new 53	gnu/mapping/WrongType
    //   417: dup_x1
    //   418: swap
    //   419: ldc -16
    //   421: iconst_1
    //   422: aload 9
    //   424: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   427: athrow
    //   428: new 53	gnu/mapping/WrongType
    //   431: dup_x1
    //   432: swap
    //   433: ldc -16
    //   435: iconst_2
    //   436: aload 9
    //   438: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   441: athrow
    //   442: new 53	gnu/mapping/WrongType
    //   445: dup_x1
    //   446: swap
    //   447: ldc -16
    //   449: iconst_1
    //   450: aload 9
    //   452: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   455: athrow
    //   456: new 53	gnu/mapping/WrongType
    //   459: dup_x1
    //   460: swap
    //   461: ldc -16
    //   463: iconst_2
    //   464: aload 9
    //   466: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   469: athrow
    // Line number table:
    //   Java source line #1221	-> byte code offset #0
    //   Java source line #1222	-> byte code offset #9
    //   Java source line #1223	-> byte code offset #58
    //   Java source line #1224	-> byte code offset #65
    //   Java source line #1225	-> byte code offset #76
    //   Java source line #1226	-> byte code offset #86
    //   Java source line #1227	-> byte code offset #130
    //   Java source line #1228	-> byte code offset #148
    //   Java source line #1229	-> byte code offset #155
    //   Java source line #1230	-> byte code offset #166
    //   Java source line #1231	-> byte code offset #176
    //   Java source line #1232	-> byte code offset #229
    //   Java source line #1233	-> byte code offset #247
    //   Java source line #1234	-> byte code offset #254
    //   Java source line #1235	-> byte code offset #265
    //   Java source line #1236	-> byte code offset #275
    //   Java source line #1237	-> byte code offset #325
    //   Java source line #1238	-> byte code offset #343
    //   Java source line #1226	-> byte code offset #371
    //   Java source line #1231	-> byte code offset #399
    //   Java source line #1236	-> byte code offset #442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	str	Object
    //   0	370	1	criterion	Object
    //   0	370	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstart$Plend	LList
    //   6	44	4	localObject1	Object
    //   20	32	5	i	int
    //   38	1	6	localObject2	Object
    //   58	210	6	start	Object
    //   56	200	7	end	Object
    //   74	58	8	i	Object
    //   164	67	8	i	Object
    //   263	64	8	i	Object
    //   100	365	9	localObject3	Object
    //   371	1	13	localClassCastException1	ClassCastException
    //   385	1	14	localClassCastException2	ClassCastException
    //   399	1	15	localClassCastException3	ClassCastException
    //   414	1	16	localClassCastException4	ClassCastException
    //   428	1	17	localClassCastException5	ClassCastException
    //   442	1	18	localClassCastException6	ClassCastException
    //   456	1	19	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   102	105	371	java/lang/ClassCastException
    //   113	119	385	java/lang/ClassCastException
    //   186	189	399	java/lang/ClassCastException
    //   198	201	414	java/lang/ClassCastException
    //   209	215	428	java/lang/ClassCastException
    //   288	291	442	java/lang/ClassCastException
    //   299	305	456	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringCount$V(Object s, Object criterion, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: getstatic 814	gnu/kawa/slib/srfi13:string$Mncount	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: aload_3
    //   14: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   17: astore 4
    //   19: iconst_0
    //   20: istore 5
    //   22: aload 4
    //   24: iload 5
    //   26: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   29: istore 5
    //   31: aload 4
    //   33: iload 5
    //   35: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 4
    //   42: iload 5
    //   44: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   47: istore 5
    //   49: aload 4
    //   51: iload 5
    //   53: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   56: astore 7
    //   58: aload_1
    //   59: invokestatic 360	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   62: ifeq +92 -> 154
    //   65: aload 6
    //   67: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   70: astore 9
    //   72: astore 8
    //   74: aload 8
    //   76: aload 7
    //   78: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   81: ifne +68 -> 149
    //   84: iconst_1
    //   85: aload 8
    //   87: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   90: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: aload_1
    //   94: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   100: aload_0
    //   101: ldc 43
    //   103: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   106: dup
    //   107: astore 10
    //   109: checkcast 43	java/lang/CharSequence
    //   112: aload 8
    //   114: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: dup
    //   118: astore 10
    //   120: checkcast 177	java/lang/Number
    //   123: invokevirtual 181	java/lang/Number:intValue	()I
    //   126: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   129: if_icmpne +15 -> 144
    //   132: iconst_1
    //   133: aload 9
    //   135: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   138: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: goto -71 -> 70
    //   144: aload 9
    //   146: goto -76 -> 70
    //   149: aload 9
    //   151: goto +237 -> 388
    //   154: aload_1
    //   155: instanceof 371
    //   158: ifeq +101 -> 259
    //   161: aload 6
    //   163: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   166: astore 9
    //   168: astore 8
    //   170: aload 8
    //   172: aload 7
    //   174: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   177: ifne +77 -> 254
    //   180: iconst_1
    //   181: aload 8
    //   183: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   186: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: aload_1
    //   190: ldc_w 371
    //   193: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   196: dup
    //   197: astore 10
    //   199: checkcast 371	gnu/kawa/slib/srfi14$CharSet
    //   202: aload_0
    //   203: ldc 43
    //   205: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: dup
    //   209: astore 10
    //   211: checkcast 43	java/lang/CharSequence
    //   214: aload 8
    //   216: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   219: dup
    //   220: astore 10
    //   222: checkcast 177	java/lang/Number
    //   225: invokevirtual 181	java/lang/Number:intValue	()I
    //   228: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   231: invokestatic 379	gnu/kawa/slib/srfi14:isCharSetContains	(Lgnu/kawa/slib/srfi14$CharSet;I)Z
    //   234: ifeq +15 -> 249
    //   237: iconst_1
    //   238: aload 9
    //   240: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   243: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: goto -80 -> 166
    //   249: aload 9
    //   251: goto -85 -> 166
    //   254: aload 9
    //   256: goto +132 -> 388
    //   259: aload_1
    //   260: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   263: ifeq +98 -> 361
    //   266: aload 6
    //   268: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   271: astore 9
    //   273: astore 8
    //   275: aload 8
    //   277: aload 7
    //   279: invokestatic 99	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   282: ifne +74 -> 356
    //   285: iconst_1
    //   286: aload 8
    //   288: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   291: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   297: aload_1
    //   298: aload_0
    //   299: ldc 43
    //   301: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   304: dup
    //   305: astore 10
    //   307: checkcast 43	java/lang/CharSequence
    //   310: aload 8
    //   312: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   315: dup
    //   316: astore 10
    //   318: checkcast 177	java/lang/Number
    //   321: invokevirtual 181	java/lang/Number:intValue	()I
    //   324: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   327: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   330: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   333: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   336: ifeq +15 -> 351
    //   339: iconst_1
    //   340: aload 9
    //   342: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   345: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   348: goto -77 -> 271
    //   351: aload 9
    //   353: goto -82 -> 271
    //   356: aload 9
    //   358: goto +30 -> 388
    //   361: iconst_3
    //   362: anewarray 27	java/lang/Object
    //   365: dup
    //   366: iconst_0
    //   367: ldc_w 811
    //   370: aastore
    //   371: dup
    //   372: iconst_1
    //   373: getstatic 814	gnu/kawa/slib/srfi13:string$Mncount	Lgnu/expr/ModuleMethod;
    //   376: aastore
    //   377: dup
    //   378: iconst_2
    //   379: aload_1
    //   380: aastore
    //   381: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   384: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   387: athrow
    //   388: areturn
    //   389: new 53	gnu/mapping/WrongType
    //   392: dup_x1
    //   393: swap
    //   394: ldc -16
    //   396: iconst_1
    //   397: aload 10
    //   399: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    //   403: new 53	gnu/mapping/WrongType
    //   406: dup_x1
    //   407: swap
    //   408: ldc -16
    //   410: iconst_2
    //   411: aload 10
    //   413: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   416: athrow
    //   417: new 53	gnu/mapping/WrongType
    //   420: dup_x1
    //   421: swap
    //   422: ldc_w 373
    //   425: iconst_0
    //   426: aload 10
    //   428: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   431: athrow
    //   432: new 53	gnu/mapping/WrongType
    //   435: dup_x1
    //   436: swap
    //   437: ldc -16
    //   439: iconst_1
    //   440: aload 10
    //   442: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   445: athrow
    //   446: new 53	gnu/mapping/WrongType
    //   449: dup_x1
    //   450: swap
    //   451: ldc -16
    //   453: iconst_2
    //   454: aload 10
    //   456: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   459: athrow
    //   460: new 53	gnu/mapping/WrongType
    //   463: dup_x1
    //   464: swap
    //   465: ldc -16
    //   467: iconst_1
    //   468: aload 10
    //   470: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   473: athrow
    //   474: new 53	gnu/mapping/WrongType
    //   477: dup_x1
    //   478: swap
    //   479: ldc -16
    //   481: iconst_2
    //   482: aload 10
    //   484: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   487: athrow
    // Line number table:
    //   Java source line #1286	-> byte code offset #0
    //   Java source line #1287	-> byte code offset #9
    //   Java source line #1288	-> byte code offset #58
    //   Java source line #1289	-> byte code offset #65
    //   Java source line #1293	-> byte code offset #74
    //   Java source line #1289	-> byte code offset #84
    //   Java source line #1290	-> byte code offset #93
    //   Java source line #1291	-> byte code offset #132
    //   Java source line #1290	-> byte code offset #144
    //   Java source line #1289	-> byte code offset #149
    //   Java source line #1293	-> byte code offset #149
    //   Java source line #1295	-> byte code offset #154
    //   Java source line #1296	-> byte code offset #161
    //   Java source line #1300	-> byte code offset #170
    //   Java source line #1296	-> byte code offset #180
    //   Java source line #1297	-> byte code offset #189
    //   Java source line #1298	-> byte code offset #237
    //   Java source line #1297	-> byte code offset #249
    //   Java source line #1296	-> byte code offset #254
    //   Java source line #1300	-> byte code offset #254
    //   Java source line #1302	-> byte code offset #259
    //   Java source line #1303	-> byte code offset #266
    //   Java source line #1305	-> byte code offset #275
    //   Java source line #1303	-> byte code offset #285
    //   Java source line #1304	-> byte code offset #294
    //   Java source line #1303	-> byte code offset #356
    //   Java source line #1305	-> byte code offset #356
    //   Java source line #1307	-> byte code offset #361
    //   Java source line #1290	-> byte code offset #389
    //   Java source line #1297	-> byte code offset #417
    //   Java source line #1304	-> byte code offset #460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	s	Object
    //   0	388	1	criterion	Object
    //   0	388	2	argsArray	Object[]
    //   0	14	3	maybe$Mnstart$Plend	LList
    //   6	44	4	localObject1	Object
    //   20	32	5	i	int
    //   38	1	6	localObject2	Object
    //   58	209	6	start	Object
    //   56	222	7	end	Object
    //   72	41	8	i	Object
    //   168	47	8	i	Object
    //   273	38	8	i	Object
    //   70	1	9	localIntNum	IntNum
    //   74	93	9	count	Object
    //   170	102	9	count	Object
    //   275	82	9	count	Object
    //   107	376	10	localObject3	Object
    //   389	1	17	localClassCastException1	ClassCastException
    //   403	1	18	localClassCastException2	ClassCastException
    //   417	1	19	localClassCastException3	ClassCastException
    //   432	1	20	localClassCastException4	ClassCastException
    //   446	1	21	localClassCastException5	ClassCastException
    //   460	1	22	localClassCastException6	ClassCastException
    //   474	1	23	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   109	112	389	java/lang/ClassCastException
    //   120	126	403	java/lang/ClassCastException
    //   199	202	417	java/lang/ClassCastException
    //   211	214	432	java/lang/ClassCastException
    //   222	228	446	java/lang/ClassCastException
    //   307	310	460	java/lang/ClassCastException
    //   318	324	474	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcKmpSearch(Object pattern, Object text, Object c$Eq, Object p$Mnstart, Object p$Mnend, Object t$Mnstart, Object t$Mnend)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload 4
    //   3: aload_3
    //   4: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   7: astore 7
    //   9: aload_0
    //   10: iconst_3
    //   11: anewarray 27	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_2
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_3
    //   21: aastore
    //   22: dup
    //   23: iconst_2
    //   24: aload 4
    //   26: aastore
    //   27: invokestatic 834	gnu/kawa/slib/srfi13:makeKmpRestartVector$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FVector;
    //   30: astore 8
    //   32: aload 5
    //   34: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   37: iconst_m1
    //   38: aload 6
    //   40: aload 5
    //   42: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: aload 7
    //   47: astore 12
    //   49: astore 11
    //   51: astore 10
    //   53: astore 9
    //   55: aload 10
    //   57: aload 7
    //   59: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   62: ifeq +14 -> 76
    //   65: iconst_m1
    //   66: aload 9
    //   68: aload 7
    //   70: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: goto +212 -> 285
    //   76: aload 12
    //   78: aload 11
    //   80: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   83: ifeq +199 -> 282
    //   86: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   89: aload_2
    //   90: aload_1
    //   91: ldc 43
    //   93: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   96: dup
    //   97: astore 13
    //   99: checkcast 43	java/lang/CharSequence
    //   102: aload 9
    //   104: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: dup
    //   108: astore 13
    //   110: checkcast 177	java/lang/Number
    //   113: invokevirtual 181	java/lang/Number:intValue	()I
    //   116: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   119: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   122: aload_0
    //   123: ldc 43
    //   125: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   128: dup
    //   129: astore 13
    //   131: checkcast 43	java/lang/CharSequence
    //   134: iconst_1
    //   135: aload_3
    //   136: aload 10
    //   138: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: dup
    //   145: astore 13
    //   147: checkcast 177	java/lang/Number
    //   150: invokevirtual 181	java/lang/Number:intValue	()I
    //   153: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   156: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   159: invokevirtual 282	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   165: ifeq +42 -> 207
    //   168: iconst_1
    //   169: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   172: aload 9
    //   174: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   177: iconst_1
    //   178: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   181: aload 10
    //   183: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: iconst_m1
    //   187: aload 11
    //   189: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   192: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: iconst_m1
    //   196: aload 12
    //   198: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   201: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: goto -157 -> 47
    //   207: aload 8
    //   209: aload 10
    //   211: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: dup
    //   215: astore 14
    //   217: checkcast 177	java/lang/Number
    //   220: invokevirtual 181	java/lang/Number:intValue	()I
    //   223: invokestatic 842	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   226: astore 13
    //   228: aload 13
    //   230: getstatic 845	gnu/kawa/slib/srfi13:Lit8	Lgnu/math/IntNum;
    //   233: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   236: ifeq +29 -> 265
    //   239: iconst_1
    //   240: aload 9
    //   242: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   245: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   248: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   251: iconst_m1
    //   252: aload 11
    //   254: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   257: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: aload 7
    //   262: goto -215 -> 47
    //   265: aload 13
    //   267: iconst_m1
    //   268: aload 7
    //   270: aload 13
    //   272: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   275: astore 12
    //   277: astore 10
    //   279: goto -224 -> 55
    //   282: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   285: areturn
    //   286: new 53	gnu/mapping/WrongType
    //   289: dup_x1
    //   290: swap
    //   291: ldc -16
    //   293: iconst_1
    //   294: aload 13
    //   296: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   299: athrow
    //   300: new 53	gnu/mapping/WrongType
    //   303: dup_x1
    //   304: swap
    //   305: ldc -16
    //   307: iconst_2
    //   308: aload 13
    //   310: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   313: athrow
    //   314: new 53	gnu/mapping/WrongType
    //   317: dup_x1
    //   318: swap
    //   319: ldc -16
    //   321: iconst_1
    //   322: aload 13
    //   324: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    //   328: new 53	gnu/mapping/WrongType
    //   331: dup_x1
    //   332: swap
    //   333: ldc -16
    //   335: iconst_2
    //   336: aload 13
    //   338: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   341: athrow
    //   342: new 53	gnu/mapping/WrongType
    //   345: dup_x1
    //   346: swap
    //   347: ldc_w 836
    //   350: iconst_2
    //   351: aload 14
    //   353: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   356: athrow
    // Line number table:
    //   Java source line #1403	-> byte code offset #0
    //   Java source line #1404	-> byte code offset #0
    //   Java source line #1405	-> byte code offset #9
    //   Java source line #1408	-> byte code offset #32
    //   Java source line #1409	-> byte code offset #37
    //   Java source line #1408	-> byte code offset #45
    //   Java source line #1412	-> byte code offset #55
    //   Java source line #1413	-> byte code offset #65
    //   Java source line #1414	-> byte code offset #76
    //   Java source line #1415	-> byte code offset #86
    //   Java source line #1416	-> byte code offset #122
    //   Java source line #1417	-> byte code offset #168
    //   Java source line #1419	-> byte code offset #207
    //   Java source line #1420	-> byte code offset #228
    //   Java source line #1421	-> byte code offset #239
    //   Java source line #1422	-> byte code offset #265
    //   Java source line #1415	-> byte code offset #286
    //   Java source line #1416	-> byte code offset #314
    //   Java source line #1419	-> byte code offset #342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	pattern	Object
    //   0	285	1	text	Object
    //   0	285	2	c$Eq	Object
    //   0	285	3	p$Mnstart	Object
    //   0	285	4	p$Mnend	Object
    //   0	285	5	t$Mnstart	Object
    //   0	285	6	t$Mnend	Object
    //   7	1	7	localObject1	Object
    //   32	237	7	plen	Object
    //   30	178	8	rv	gnu.lists.FVector
    //   53	188	9	ti	Object
    //   51	1	10	localIntNum	IntNum
    //   55	223	10	pi	Object
    //   49	1	11	localObject2	Object
    //   55	198	11	tj	Object
    //   47	1	12	localObject3	Object
    //   55	221	12	pj	Object
    //   97	49	13	localObject4	Object
    //   226	111	13	pi	Object
    //   215	137	14	localObject5	Object
    //   286	1	20	localClassCastException1	ClassCastException
    //   300	1	21	localClassCastException2	ClassCastException
    //   314	1	22	localClassCastException3	ClassCastException
    //   328	1	23	localClassCastException4	ClassCastException
    //   342	1	24	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   99	102	286	java/lang/ClassCastException
    //   110	116	300	java/lang/ClassCastException
    //   131	134	314	java/lang/ClassCastException
    //   147	153	328	java/lang/ClassCastException
    //   217	223	342	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.lists.FVector makeKmpRestartVector$V(Object pattern, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: getstatic 820	kawa/lib/strings:char$Eq$Qu	Lgnu/expr/ModuleMethod;
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   36: ifne +7 -> 43
    //   39: getstatic 820	kawa/lib/strings:char$Eq$Qu	Lgnu/expr/ModuleMethod;
    //   42: astore_3
    //   43: aload_2
    //   44: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   47: ifne +16 -> 63
    //   50: aload_2
    //   51: dup
    //   52: astore 6
    //   54: checkcast 70	gnu/lists/Pair
    //   57: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   60: goto +4 -> 64
    //   63: aload_2
    //   64: astore 5
    //   66: getstatic 848	gnu/kawa/slib/srfi13:make$Mnkmp$Mnrestart$Mnvector	Lgnu/expr/ModuleMethod;
    //   69: aload_0
    //   70: aload 5
    //   72: invokestatic 145	gnu/kawa/slib/srfi13:stringParseStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore 4
    //   77: iconst_0
    //   78: istore 5
    //   80: aload 4
    //   82: iload 5
    //   84: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   87: istore 5
    //   89: aload 4
    //   91: iload 5
    //   93: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   96: astore 6
    //   98: aload 4
    //   100: iload 5
    //   102: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   105: istore 5
    //   107: aload 4
    //   109: iload 5
    //   111: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   114: astore 7
    //   116: aload 4
    //   118: iload 5
    //   120: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   123: istore 5
    //   125: aload 4
    //   127: iload 5
    //   129: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   132: astore 8
    //   134: aload 6
    //   136: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   139: ifeq +403 -> 542
    //   142: iconst_m1
    //   143: aload 8
    //   145: aload 7
    //   147: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: astore 9
    //   152: aload 9
    //   154: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   157: dup
    //   158: astore 11
    //   160: checkcast 177	java/lang/Number
    //   163: invokevirtual 181	java/lang/Number:intValue	()I
    //   166: getstatic 845	gnu/kawa/slib/srfi13:Lit8	Lgnu/math/IntNum;
    //   169: invokestatic 854	kawa/lib/vectors:makeVector	(ILjava/lang/Object;)Lgnu/lists/FVector;
    //   172: astore 10
    //   174: aload 9
    //   176: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   179: invokestatic 352	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   182: ifeq +355 -> 537
    //   185: iconst_m1
    //   186: aload 9
    //   188: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   191: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: astore 11
    //   196: aload_0
    //   197: ldc 43
    //   199: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   202: dup
    //   203: astore 13
    //   205: checkcast 43	java/lang/CharSequence
    //   208: aload 7
    //   210: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: dup
    //   214: astore 13
    //   216: checkcast 177	java/lang/Number
    //   219: invokevirtual 181	java/lang/Number:intValue	()I
    //   222: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   225: istore 12
    //   227: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   230: getstatic 845	gnu/kawa/slib/srfi13:Lit8	Lgnu/math/IntNum;
    //   233: aload 7
    //   235: astore 15
    //   237: astore 14
    //   239: astore 13
    //   241: aload 13
    //   243: aload 11
    //   245: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   248: ifeq +289 -> 537
    //   251: aload 14
    //   253: astore 16
    //   255: aload 16
    //   257: getstatic 845	gnu/kawa/slib/srfi13:Lit8	Lgnu/math/IntNum;
    //   260: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   263: ifeq +110 -> 373
    //   266: iconst_1
    //   267: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   270: aload 13
    //   272: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   275: astore 17
    //   277: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   280: aload_3
    //   281: aload_0
    //   282: ldc 43
    //   284: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   287: dup
    //   288: astore 18
    //   290: checkcast 43	java/lang/CharSequence
    //   293: iconst_1
    //   294: aload 15
    //   296: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   299: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   302: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   305: dup
    //   306: astore 18
    //   308: checkcast 177	java/lang/Number
    //   311: invokevirtual 181	java/lang/Number:intValue	()I
    //   314: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   317: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   320: iload 12
    //   322: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   325: invokevirtual 282	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   331: ifne +25 -> 356
    //   334: aload 10
    //   336: aload 17
    //   338: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   341: dup
    //   342: astore 18
    //   344: checkcast 177	java/lang/Number
    //   347: invokevirtual 181	java/lang/Number:intValue	()I
    //   350: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   353: invokestatic 860	kawa/lib/vectors:vectorSet$Ex	(Lgnu/lists/FVector;ILjava/lang/Object;)V
    //   356: aload 17
    //   358: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   361: iconst_1
    //   362: aload 15
    //   364: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   367: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   370: goto -135 -> 235
    //   373: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   376: aload_3
    //   377: aload_0
    //   378: ldc 43
    //   380: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   383: dup
    //   384: astore 17
    //   386: checkcast 43	java/lang/CharSequence
    //   389: aload 15
    //   391: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   394: dup
    //   395: astore 17
    //   397: checkcast 177	java/lang/Number
    //   400: invokevirtual 181	java/lang/Number:intValue	()I
    //   403: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   406: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   409: aload_0
    //   410: ldc 43
    //   412: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   415: dup
    //   416: astore 17
    //   418: checkcast 43	java/lang/CharSequence
    //   421: iconst_1
    //   422: aload 16
    //   424: aload 7
    //   426: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   429: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   432: dup
    //   433: astore 17
    //   435: checkcast 177	java/lang/Number
    //   438: invokevirtual 181	java/lang/Number:intValue	()I
    //   441: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   444: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   447: invokevirtual 282	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   450: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   453: ifeq +62 -> 515
    //   456: iconst_1
    //   457: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   460: aload 13
    //   462: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: astore 17
    //   467: iconst_1
    //   468: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   471: aload 16
    //   473: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: astore 18
    //   478: aload 10
    //   480: aload 17
    //   482: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   485: dup
    //   486: astore 19
    //   488: checkcast 177	java/lang/Number
    //   491: invokevirtual 181	java/lang/Number:intValue	()I
    //   494: aload 18
    //   496: invokestatic 860	kawa/lib/vectors:vectorSet$Ex	(Lgnu/lists/FVector;ILjava/lang/Object;)V
    //   499: aload 17
    //   501: aload 18
    //   503: iconst_1
    //   504: aload 15
    //   506: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   509: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   512: goto -277 -> 235
    //   515: aload 10
    //   517: aload 16
    //   519: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   522: dup
    //   523: astore 17
    //   525: checkcast 177	java/lang/Number
    //   528: invokevirtual 181	java/lang/Number:intValue	()I
    //   531: invokestatic 842	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   534: goto -281 -> 253
    //   537: aload 10
    //   539: goto +25 -> 564
    //   542: iconst_2
    //   543: anewarray 27	java/lang/Object
    //   546: dup
    //   547: iconst_0
    //   548: ldc_w 340
    //   551: aastore
    //   552: dup
    //   553: iconst_1
    //   554: aload 6
    //   556: aastore
    //   557: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   560: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   563: athrow
    //   564: areturn
    //   565: new 53	gnu/mapping/WrongType
    //   568: dup_x1
    //   569: swap
    //   570: ldc 72
    //   572: iconst_1
    //   573: aload 4
    //   575: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   578: athrow
    //   579: new 53	gnu/mapping/WrongType
    //   582: dup_x1
    //   583: swap
    //   584: ldc 77
    //   586: iconst_1
    //   587: aload 6
    //   589: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   592: athrow
    //   593: new 53	gnu/mapping/WrongType
    //   596: dup_x1
    //   597: swap
    //   598: ldc_w 850
    //   601: iconst_1
    //   602: aload 11
    //   604: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   607: athrow
    //   608: new 53	gnu/mapping/WrongType
    //   611: dup_x1
    //   612: swap
    //   613: ldc -16
    //   615: iconst_1
    //   616: aload 13
    //   618: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   621: athrow
    //   622: new 53	gnu/mapping/WrongType
    //   625: dup_x1
    //   626: swap
    //   627: ldc -16
    //   629: iconst_2
    //   630: aload 13
    //   632: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   635: athrow
    //   636: new 53	gnu/mapping/WrongType
    //   639: dup_x1
    //   640: swap
    //   641: ldc -16
    //   643: iconst_1
    //   644: aload 18
    //   646: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   649: athrow
    //   650: new 53	gnu/mapping/WrongType
    //   653: dup_x1
    //   654: swap
    //   655: ldc -16
    //   657: iconst_2
    //   658: aload 18
    //   660: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   663: athrow
    //   664: new 53	gnu/mapping/WrongType
    //   667: dup_x1
    //   668: swap
    //   669: ldc_w 856
    //   672: iconst_2
    //   673: aload 18
    //   675: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   678: athrow
    //   679: new 53	gnu/mapping/WrongType
    //   682: dup_x1
    //   683: swap
    //   684: ldc -16
    //   686: iconst_1
    //   687: aload 17
    //   689: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   692: athrow
    //   693: new 53	gnu/mapping/WrongType
    //   696: dup_x1
    //   697: swap
    //   698: ldc -16
    //   700: iconst_2
    //   701: aload 17
    //   703: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   706: athrow
    //   707: new 53	gnu/mapping/WrongType
    //   710: dup_x1
    //   711: swap
    //   712: ldc -16
    //   714: iconst_1
    //   715: aload 17
    //   717: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   720: athrow
    //   721: new 53	gnu/mapping/WrongType
    //   724: dup_x1
    //   725: swap
    //   726: ldc -16
    //   728: iconst_2
    //   729: aload 17
    //   731: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   734: athrow
    //   735: new 53	gnu/mapping/WrongType
    //   738: dup_x1
    //   739: swap
    //   740: ldc_w 856
    //   743: iconst_2
    //   744: aload 19
    //   746: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   749: athrow
    //   750: new 53	gnu/mapping/WrongType
    //   753: dup_x1
    //   754: swap
    //   755: ldc_w 836
    //   758: iconst_2
    //   759: aload 17
    //   761: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   764: athrow
    // Line number table:
    //   Java source line #1452	-> byte code offset #0
    //   Java source line #1453	-> byte code offset #8
    //   Java source line #1454	-> byte code offset #28
    //   Java source line #1453	-> byte code offset #32
    //   Java source line #1454	-> byte code offset #32
    //   Java source line #1453	-> byte code offset #39
    //   Java source line #1455	-> byte code offset #63
    //   Java source line #1456	-> byte code offset #66
    //   Java source line #1457	-> byte code offset #69
    //   Java source line #1453	-> byte code offset #134
    //   Java source line #1458	-> byte code offset #142
    //   Java source line #1459	-> byte code offset #152
    //   Java source line #1460	-> byte code offset #174
    //   Java source line #1461	-> byte code offset #185
    //   Java source line #1462	-> byte code offset #196
    //   Java source line #1466	-> byte code offset #227
    //   Java source line #1467	-> byte code offset #241
    //   Java source line #1471	-> byte code offset #251
    //   Java source line #1472	-> byte code offset #255
    //   Java source line #1473	-> byte code offset #266
    //   Java source line #1474	-> byte code offset #277
    //   Java source line #1475	-> byte code offset #334
    //   Java source line #1476	-> byte code offset #356
    //   Java source line #1478	-> byte code offset #376
    //   Java source line #1479	-> byte code offset #456
    //   Java source line #1480	-> byte code offset #467
    //   Java source line #1481	-> byte code offset #478
    //   Java source line #1482	-> byte code offset #499
    //   Java source line #1484	-> byte code offset #515
    //   Java source line #1485	-> byte code offset #537
    //   Java source line #1453	-> byte code offset #565
    //   Java source line #1459	-> byte code offset #593
    //   Java source line #1462	-> byte code offset #608
    //   Java source line #1474	-> byte code offset #636
    //   Java source line #1475	-> byte code offset #664
    //   Java source line #1478	-> byte code offset #679
    //   Java source line #1481	-> byte code offset #735
    //   Java source line #1484	-> byte code offset #750
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	pattern	Object
    //   0	564	1	argsArray	Object[]
    //   0	64	2	maybe$Mnc$Eq$Plstart$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	346	3	c$Eq	Object
    //   17	557	4	localObject1	Object
    //   64	64	5	args	Object
    //   52	45	6	localObject2	Object
    //   134	454	6	r	Object
    //   114	1	7	localObject3	Object
    //   134	291	7	start	Object
    //   132	12	8	end	Object
    //   150	37	9	rvlen	Object
    //   172	366	10	rv	gnu.lists.FVector
    //   158	37	11	localObject4	Object
    //   227	376	11	rvlen$Mn1	Object
    //   225	96	12	c0	int
    //   203	12	13	localObject5	Object
    //   239	392	13	i	Object
    //   237	1	14	localIntNum	IntNum
    //   241	11	14	j	Object
    //   235	1	15	localObject6	Object
    //   241	264	15	k	Object
    //   253	265	16	j	Object
    //   275	159	17	i1	Object
    //   465	295	17	i1	Object
    //   288	55	18	localObject7	Object
    //   476	198	18	j1	Object
    //   486	259	19	localObject8	Object
    //   565	1	29	localClassCastException1	ClassCastException
    //   579	1	30	localClassCastException2	ClassCastException
    //   593	1	31	localClassCastException3	ClassCastException
    //   608	1	32	localClassCastException4	ClassCastException
    //   622	1	33	localClassCastException5	ClassCastException
    //   636	1	34	localClassCastException6	ClassCastException
    //   650	1	35	localClassCastException7	ClassCastException
    //   664	1	36	localClassCastException8	ClassCastException
    //   679	1	37	localClassCastException9	ClassCastException
    //   693	1	38	localClassCastException10	ClassCastException
    //   707	1	39	localClassCastException11	ClassCastException
    //   721	1	40	localClassCastException12	ClassCastException
    //   735	1	41	localClassCastException13	ClassCastException
    //   750	1	42	localClassCastException14	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	565	java/lang/ClassCastException
    //   54	57	579	java/lang/ClassCastException
    //   160	166	593	java/lang/ClassCastException
    //   205	208	608	java/lang/ClassCastException
    //   216	222	622	java/lang/ClassCastException
    //   290	293	636	java/lang/ClassCastException
    //   308	314	650	java/lang/ClassCastException
    //   344	350	664	java/lang/ClassCastException
    //   386	389	679	java/lang/ClassCastException
    //   397	403	693	java/lang/ClassCastException
    //   418	421	707	java/lang/ClassCastException
    //   435	441	721	java/lang/ClassCastException
    //   488	494	735	java/lang/ClassCastException
    //   525	531	750	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object kmpStep(Object pat, Object rv, Object c, Object i, Object c$Eq, Object p$Mnstart)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 6
    //   3: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   6: aload 4
    //   8: aload_2
    //   9: aload_0
    //   10: ldc 43
    //   12: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   15: dup
    //   16: astore 7
    //   18: checkcast 43	java/lang/CharSequence
    //   21: iconst_1
    //   22: aload 6
    //   24: aload 5
    //   26: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: dup
    //   33: astore 7
    //   35: checkcast 177	java/lang/Number
    //   38: invokevirtual 181	java/lang/Number:intValue	()I
    //   41: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   44: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   47: invokevirtual 282	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   53: ifeq +15 -> 68
    //   56: iconst_1
    //   57: aload 6
    //   59: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   62: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: goto +57 -> 122
    //   68: aload_1
    //   69: ldc_w 862
    //   72: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   75: dup
    //   76: astore 8
    //   78: checkcast 862	gnu/lists/FVector
    //   81: aload 6
    //   83: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: dup
    //   87: astore 8
    //   89: checkcast 177	java/lang/Number
    //   92: invokevirtual 181	java/lang/Number:intValue	()I
    //   95: invokestatic 842	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   98: astore 7
    //   100: aload 7
    //   102: getstatic 845	gnu/kawa/slib/srfi13:Lit8	Lgnu/math/IntNum;
    //   105: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   108: ifeq +9 -> 117
    //   111: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   114: goto +8 -> 122
    //   117: aload 7
    //   119: goto -118 -> 1
    //   122: areturn
    //   123: new 53	gnu/mapping/WrongType
    //   126: dup_x1
    //   127: swap
    //   128: ldc -16
    //   130: iconst_1
    //   131: aload 7
    //   133: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   136: athrow
    //   137: new 53	gnu/mapping/WrongType
    //   140: dup_x1
    //   141: swap
    //   142: ldc -16
    //   144: iconst_2
    //   145: aload 7
    //   147: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: new 53	gnu/mapping/WrongType
    //   154: dup_x1
    //   155: swap
    //   156: ldc_w 836
    //   159: iconst_1
    //   160: aload 8
    //   162: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   165: athrow
    //   166: new 53	gnu/mapping/WrongType
    //   169: dup_x1
    //   170: swap
    //   171: ldc_w 836
    //   174: iconst_2
    //   175: aload 8
    //   177: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   180: athrow
    // Line number table:
    //   Java source line #1500	-> byte code offset #0
    //   Java source line #1501	-> byte code offset #0
    //   Java source line #1502	-> byte code offset #3
    //   Java source line #1503	-> byte code offset #56
    //   Java source line #1504	-> byte code offset #68
    //   Java source line #1505	-> byte code offset #100
    //   Java source line #1506	-> byte code offset #117
    //   Java source line #1502	-> byte code offset #123
    //   Java source line #1504	-> byte code offset #151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	pat	Object
    //   0	122	1	rv	Object
    //   0	122	2	c	Object
    //   0	122	3	i	Object
    //   0	122	4	c$Eq	Object
    //   0	122	5	p$Mnstart	Object
    //   3	119	6	i	Object
    //   100	22	7	i	Object
    // Exception table:
    //   from	to	target	type
    //   18	21	123	java/lang/ClassCastException
    //   35	41	137	java/lang/ClassCastException
    //   78	81	151	java/lang/ClassCastException
    //   89	95	166	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringKmpPartialSearch$V(Object pat, Object rv, Object s, Object i, Object[] argsArray)
  {
    // Byte code:
    //   0: new 864	gnu/kawa/slib/srfi13$frame5
    //   3: dup
    //   4: invokespecial 865	gnu/kawa/slib/srfi13$frame5:<init>	()V
    //   7: astore 6
    //   9: aload 4
    //   11: iconst_0
    //   12: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   15: dup
    //   16: astore 7
    //   18: astore 5
    //   20: getstatic 868	kawa/lib/vectors:vector$Qu	Lgnu/expr/ModuleMethod;
    //   23: aload_1
    //   24: getstatic 871	gnu/kawa/slib/srfi13:string$Mnkmp$Mnpartial$Mnsearch	Lgnu/expr/ModuleMethod;
    //   27: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload 5
    //   33: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   36: ifne +17 -> 53
    //   39: aload 5
    //   41: dup
    //   42: astore 8
    //   44: checkcast 70	gnu/lists/Pair
    //   47: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   50: goto +6 -> 56
    //   53: getstatic 820	kawa/lib/strings:char$Eq$Qu	Lgnu/expr/ModuleMethod;
    //   56: astore 7
    //   58: aload 7
    //   60: invokestatic 296	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   63: ifne +8 -> 71
    //   66: getstatic 820	kawa/lib/strings:char$Eq$Qu	Lgnu/expr/ModuleMethod;
    //   69: astore 7
    //   71: aload 5
    //   73: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   76: ifne +17 -> 93
    //   79: aload 5
    //   81: dup
    //   82: astore 9
    //   84: checkcast 70	gnu/lists/Pair
    //   87: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   90: goto +5 -> 95
    //   93: aload 5
    //   95: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   98: ifne +50 -> 148
    //   101: aload 5
    //   103: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   106: ifne +28 -> 134
    //   109: aload 5
    //   111: dup
    //   112: astore 9
    //   114: checkcast 70	gnu/lists/Pair
    //   117: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   120: ldc 70
    //   122: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   125: dup
    //   126: astore 9
    //   128: checkcast 70	gnu/lists/Pair
    //   131: goto +11 -> 142
    //   134: aload 5
    //   136: dup
    //   137: astore 9
    //   139: checkcast 70	gnu/lists/Pair
    //   142: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   145: goto +6 -> 151
    //   148: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   151: astore 8
    //   153: aload 8
    //   155: invokestatic 84	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   158: ifeq +22 -> 180
    //   161: aload 8
    //   163: invokestatic 87	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   166: ifeq +14 -> 180
    //   169: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   172: aload 8
    //   174: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   177: ifne +8 -> 185
    //   180: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   183: astore 8
    //   185: aload 5
    //   187: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   190: ifne +17 -> 207
    //   193: aload 5
    //   195: dup
    //   196: astore 11
    //   198: checkcast 70	gnu/lists/Pair
    //   201: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   204: goto +5 -> 209
    //   207: aload 5
    //   209: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   212: ifne +50 -> 262
    //   215: aload 5
    //   217: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   220: ifne +28 -> 248
    //   223: aload 5
    //   225: dup
    //   226: astore 11
    //   228: checkcast 70	gnu/lists/Pair
    //   231: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   234: ldc 70
    //   236: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   239: dup
    //   240: astore 11
    //   242: checkcast 70	gnu/lists/Pair
    //   245: goto +11 -> 256
    //   248: aload 5
    //   250: dup
    //   251: astore 11
    //   253: checkcast 70	gnu/lists/Pair
    //   256: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   259: goto +27 -> 286
    //   262: aload 5
    //   264: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   267: ifne +17 -> 284
    //   270: aload 5
    //   272: dup
    //   273: astore 11
    //   275: checkcast 70	gnu/lists/Pair
    //   278: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   281: goto +5 -> 286
    //   284: aload 5
    //   286: astore 10
    //   288: getstatic 871	gnu/kawa/slib/srfi13:string$Mnkmp$Mnpartial$Mnsearch	Lgnu/expr/ModuleMethod;
    //   291: aload_2
    //   292: aload 10
    //   294: invokestatic 145	gnu/kawa/slib/srfi13:stringParseStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   297: astore 9
    //   299: iconst_0
    //   300: istore 10
    //   302: aload 9
    //   304: iload 10
    //   306: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   309: istore 10
    //   311: aload 9
    //   313: iload 10
    //   315: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   318: astore 11
    //   320: aload 9
    //   322: iload 10
    //   324: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   327: istore 10
    //   329: aload 9
    //   331: iload 10
    //   333: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   336: astore 12
    //   338: aload 9
    //   340: iload 10
    //   342: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   345: istore 10
    //   347: aload 9
    //   349: iload 10
    //   351: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   354: astore 13
    //   356: aload 11
    //   358: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   361: ifeq +254 -> 615
    //   364: aload_1
    //   365: ldc_w 862
    //   368: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   371: dup
    //   372: astore 14
    //   374: checkcast 862	gnu/lists/FVector
    //   377: invokestatic 877	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
    //   380: aload 6
    //   382: swap
    //   383: putfield 880	gnu/kawa/slib/srfi13$frame5:patlen	I
    //   386: aload 6
    //   388: getfield 883	gnu/kawa/slib/srfi13$frame5:lambda$Fn38	Lgnu/expr/ModuleMethod;
    //   391: aload_3
    //   392: getstatic 871	gnu/kawa/slib/srfi13:string$Mnkmp$Mnpartial$Mnsearch	Lgnu/expr/ModuleMethod;
    //   395: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: pop
    //   399: aload 12
    //   401: aload_3
    //   402: astore 15
    //   404: astore 14
    //   406: aload 15
    //   408: aload 6
    //   410: getfield 880	gnu/kawa/slib/srfi13$frame5:patlen	I
    //   413: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   416: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   419: ifeq +14 -> 433
    //   422: getstatic 887	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   425: aload 14
    //   427: invokevirtual 890	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   430: goto +207 -> 637
    //   433: aload 14
    //   435: aload 13
    //   437: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   440: ifeq +8 -> 448
    //   443: aload 15
    //   445: goto +192 -> 637
    //   448: aload_2
    //   449: ldc 43
    //   451: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   454: dup
    //   455: astore 17
    //   457: checkcast 43	java/lang/CharSequence
    //   460: aload 14
    //   462: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   465: dup
    //   466: astore 17
    //   468: checkcast 177	java/lang/Number
    //   471: invokevirtual 181	java/lang/Number:intValue	()I
    //   474: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   477: istore 16
    //   479: iconst_1
    //   480: aload 14
    //   482: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   485: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   488: aload 15
    //   490: astore 17
    //   492: getstatic 238	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   495: aload 7
    //   497: iload 16
    //   499: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   502: aload_0
    //   503: ldc 43
    //   505: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   508: dup
    //   509: astore 18
    //   511: checkcast 43	java/lang/CharSequence
    //   514: iconst_1
    //   515: aload 17
    //   517: aload 8
    //   519: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   522: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   525: dup
    //   526: astore 18
    //   528: checkcast 177	java/lang/Number
    //   531: invokevirtual 181	java/lang/Number:intValue	()I
    //   534: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   537: invokestatic 250	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   540: invokevirtual 282	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   543: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   546: ifeq +15 -> 561
    //   549: iconst_1
    //   550: aload 17
    //   552: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   555: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   558: goto -156 -> 402
    //   561: aload_1
    //   562: ldc_w 862
    //   565: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   568: dup
    //   569: astore 19
    //   571: checkcast 862	gnu/lists/FVector
    //   574: aload 17
    //   576: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   579: dup
    //   580: astore 19
    //   582: checkcast 177	java/lang/Number
    //   585: invokevirtual 181	java/lang/Number:intValue	()I
    //   588: invokestatic 842	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   591: astore 18
    //   593: aload 18
    //   595: getstatic 845	gnu/kawa/slib/srfi13:Lit8	Lgnu/math/IntNum;
    //   598: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   601: ifeq +9 -> 610
    //   604: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   607: goto -205 -> 402
    //   610: aload 18
    //   612: goto -122 -> 490
    //   615: iconst_2
    //   616: anewarray 27	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: ldc_w 340
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload 11
    //   629: aastore
    //   630: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   633: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   636: athrow
    //   637: areturn
    //   638: new 53	gnu/mapping/WrongType
    //   641: dup_x1
    //   642: swap
    //   643: ldc 72
    //   645: iconst_1
    //   646: aload 8
    //   648: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   651: athrow
    //   652: new 53	gnu/mapping/WrongType
    //   655: dup_x1
    //   656: swap
    //   657: ldc 77
    //   659: iconst_1
    //   660: aload 9
    //   662: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   665: athrow
    //   666: new 53	gnu/mapping/WrongType
    //   669: dup_x1
    //   670: swap
    //   671: ldc 77
    //   673: iconst_1
    //   674: aload 9
    //   676: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   679: athrow
    //   680: new 53	gnu/mapping/WrongType
    //   683: dup_x1
    //   684: swap
    //   685: ldc 72
    //   687: iconst_1
    //   688: aload 9
    //   690: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   693: athrow
    //   694: new 53	gnu/mapping/WrongType
    //   697: dup_x1
    //   698: swap
    //   699: ldc 72
    //   701: iconst_1
    //   702: aload 9
    //   704: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   707: athrow
    //   708: new 53	gnu/mapping/WrongType
    //   711: dup_x1
    //   712: swap
    //   713: ldc 77
    //   715: iconst_1
    //   716: aload 11
    //   718: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   721: athrow
    //   722: new 53	gnu/mapping/WrongType
    //   725: dup_x1
    //   726: swap
    //   727: ldc 77
    //   729: iconst_1
    //   730: aload 11
    //   732: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   735: athrow
    //   736: new 53	gnu/mapping/WrongType
    //   739: dup_x1
    //   740: swap
    //   741: ldc 77
    //   743: iconst_1
    //   744: aload 11
    //   746: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   749: athrow
    //   750: new 53	gnu/mapping/WrongType
    //   753: dup_x1
    //   754: swap
    //   755: ldc 77
    //   757: iconst_1
    //   758: aload 11
    //   760: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   763: athrow
    //   764: new 53	gnu/mapping/WrongType
    //   767: dup_x1
    //   768: swap
    //   769: ldc 77
    //   771: iconst_1
    //   772: aload 11
    //   774: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   777: athrow
    //   778: new 53	gnu/mapping/WrongType
    //   781: dup_x1
    //   782: swap
    //   783: ldc_w 873
    //   786: iconst_1
    //   787: aload 14
    //   789: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   792: athrow
    //   793: new 53	gnu/mapping/WrongType
    //   796: dup_x1
    //   797: swap
    //   798: ldc -16
    //   800: iconst_1
    //   801: aload 17
    //   803: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   806: athrow
    //   807: new 53	gnu/mapping/WrongType
    //   810: dup_x1
    //   811: swap
    //   812: ldc -16
    //   814: iconst_2
    //   815: aload 17
    //   817: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   820: athrow
    //   821: new 53	gnu/mapping/WrongType
    //   824: dup_x1
    //   825: swap
    //   826: ldc -16
    //   828: iconst_1
    //   829: aload 18
    //   831: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   834: athrow
    //   835: new 53	gnu/mapping/WrongType
    //   838: dup_x1
    //   839: swap
    //   840: ldc -16
    //   842: iconst_2
    //   843: aload 18
    //   845: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   848: athrow
    //   849: new 53	gnu/mapping/WrongType
    //   852: dup_x1
    //   853: swap
    //   854: ldc_w 836
    //   857: iconst_1
    //   858: aload 19
    //   860: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   863: athrow
    //   864: new 53	gnu/mapping/WrongType
    //   867: dup_x1
    //   868: swap
    //   869: ldc_w 836
    //   872: iconst_2
    //   873: aload 19
    //   875: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   878: athrow
    // Line number table:
    //   Java source line #1519	-> byte code offset #0
    //   Java source line #1520	-> byte code offset #20
    //   Java source line #1521	-> byte code offset #31
    //   Java source line #1522	-> byte code offset #53
    //   Java source line #1521	-> byte code offset #58
    //   Java source line #1522	-> byte code offset #58
    //   Java source line #1521	-> byte code offset #66
    //   Java source line #1523	-> byte code offset #93
    //   Java source line #1521	-> byte code offset #101
    //   Java source line #1523	-> byte code offset #134
    //   Java source line #1521	-> byte code offset #153
    //   Java source line #1523	-> byte code offset #153
    //   Java source line #1521	-> byte code offset #180
    //   Java source line #1524	-> byte code offset #207
    //   Java source line #1521	-> byte code offset #215
    //   Java source line #1524	-> byte code offset #248
    //   Java source line #1521	-> byte code offset #262
    //   Java source line #1524	-> byte code offset #284
    //   Java source line #1525	-> byte code offset #288
    //   Java source line #1526	-> byte code offset #291
    //   Java source line #1521	-> byte code offset #356
    //   Java source line #1527	-> byte code offset #364
    //   Java source line #1528	-> byte code offset #386
    //   Java source line #1529	-> byte code offset #391
    //   Java source line #1532	-> byte code offset #399
    //   Java source line #1534	-> byte code offset #406
    //   Java source line #1535	-> byte code offset #433
    //   Java source line #1537	-> byte code offset #448
    //   Java source line #1538	-> byte code offset #479
    //   Java source line #1539	-> byte code offset #488
    //   Java source line #1540	-> byte code offset #492
    //   Java source line #1541	-> byte code offset #549
    //   Java source line #1542	-> byte code offset #561
    //   Java source line #1543	-> byte code offset #593
    //   Java source line #1544	-> byte code offset #610
    //   Java source line #1521	-> byte code offset #638
    //   Java source line #1523	-> byte code offset #694
    //   Java source line #1521	-> byte code offset #708
    //   Java source line #1524	-> byte code offset #750
    //   Java source line #1521	-> byte code offset #764
    //   Java source line #1527	-> byte code offset #778
    //   Java source line #1537	-> byte code offset #793
    //   Java source line #1540	-> byte code offset #821
    //   Java source line #1542	-> byte code offset #849
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	pat	Object
    //   0	637	1	rv	Object
    //   0	637	2	s	Object
    //   0	637	3	i	Object
    //   0	637	4	argsArray	Object[]
    //   0	285	5	c$Eq$Plp$Mnstart$Pls$Mnstart$Pls$Mnend	LList
    //   7	402	6	$heapFrame	frame5
    //   16	1	7	localLList1	LList
    //   56	440	7	c$Eq	Object
    //   42	1	8	localLList2	LList
    //   151	496	8	p$Mnstart	Object
    //   82	621	9	localObject1	Object
    //   286	64	10	args	Object
    //   196	123	11	localObject2	Object
    //   356	417	11	r	Object
    //   336	1	12	localObject3	Object
    //   356	44	12	s$Mnstart	Object
    //   354	82	13	s$Mnend	Object
    //   372	1	14	localObject4	Object
    //   404	384	14	si	Object
    //   402	1	15	localObject5	Object
    //   406	83	15	vi	Object
    //   477	21	16	c	int
    //   455	12	17	localObject6	Object
    //   490	326	17	vi	Object
    //   509	18	18	localObject7	Object
    //   591	253	18	vi	Object
    //   569	305	19	localObject8	Object
    //   638	1	28	localClassCastException1	ClassCastException
    //   652	1	29	localClassCastException2	ClassCastException
    //   666	1	30	localClassCastException3	ClassCastException
    //   680	1	31	localClassCastException4	ClassCastException
    //   694	1	32	localClassCastException5	ClassCastException
    //   708	1	33	localClassCastException6	ClassCastException
    //   722	1	34	localClassCastException7	ClassCastException
    //   736	1	35	localClassCastException8	ClassCastException
    //   750	1	36	localClassCastException9	ClassCastException
    //   764	1	37	localClassCastException10	ClassCastException
    //   778	1	38	localClassCastException11	ClassCastException
    //   793	1	39	localClassCastException12	ClassCastException
    //   807	1	40	localClassCastException13	ClassCastException
    //   821	1	41	localClassCastException14	ClassCastException
    //   835	1	42	localClassCastException15	ClassCastException
    //   849	1	43	localClassCastException16	ClassCastException
    //   864	1	44	localClassCastException17	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   44	47	638	java/lang/ClassCastException
    //   84	87	652	java/lang/ClassCastException
    //   114	117	666	java/lang/ClassCastException
    //   128	131	680	java/lang/ClassCastException
    //   139	142	694	java/lang/ClassCastException
    //   198	201	708	java/lang/ClassCastException
    //   228	231	722	java/lang/ClassCastException
    //   242	245	736	java/lang/ClassCastException
    //   253	256	750	java/lang/ClassCastException
    //   275	278	764	java/lang/ClassCastException
    //   374	377	778	java/lang/ClassCastException
    //   457	460	793	java/lang/ClassCastException
    //   468	474	807	java/lang/ClassCastException
    //   511	514	821	java/lang/ClassCastException
    //   528	534	835	java/lang/ClassCastException
    //   571	574	849	java/lang/ClassCastException
    //   582	588	864	java/lang/ClassCastException
  }
  
  /* Error */
  public static FString stringReverse$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: getstatic 893	gnu/kawa/slib/srfi13:string$Mnreverse	Lgnu/expr/ModuleMethod;
    //   11: aload_0
    //   12: aload_2
    //   13: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   16: astore_3
    //   17: iconst_0
    //   18: istore 4
    //   20: aload_3
    //   21: iload 4
    //   23: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   26: istore 4
    //   28: aload_3
    //   29: iload 4
    //   31: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   34: astore 5
    //   36: aload_3
    //   37: iload 4
    //   39: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   42: istore 4
    //   44: aload_3
    //   45: iload 4
    //   47: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   50: astore 6
    //   52: iconst_m1
    //   53: aload 6
    //   55: aload 5
    //   57: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: dup
    //   68: astore 9
    //   70: checkcast 177	java/lang/Number
    //   73: invokevirtual 181	java/lang/Number:intValue	()I
    //   76: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   79: astore 8
    //   81: aload 5
    //   83: iconst_m1
    //   84: aload 7
    //   86: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   89: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 10
    //   94: astore 9
    //   96: aload 10
    //   98: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   101: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   104: ifne +72 -> 176
    //   107: aload 8
    //   109: aload 10
    //   111: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: dup
    //   115: astore 11
    //   117: checkcast 177	java/lang/Number
    //   120: invokevirtual 181	java/lang/Number:intValue	()I
    //   123: aload_0
    //   124: ldc 43
    //   126: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   129: dup
    //   130: astore 11
    //   132: checkcast 43	java/lang/CharSequence
    //   135: aload 9
    //   137: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: dup
    //   141: astore 11
    //   143: checkcast 177	java/lang/Number
    //   146: invokevirtual 181	java/lang/Number:intValue	()I
    //   149: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   152: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   155: iconst_1
    //   156: aload 9
    //   158: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   161: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: iconst_m1
    //   165: aload 10
    //   167: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   170: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: goto -81 -> 92
    //   176: aload 8
    //   178: areturn
    //   179: new 53	gnu/mapping/WrongType
    //   182: dup_x1
    //   183: swap
    //   184: ldc -36
    //   186: iconst_1
    //   187: aload 9
    //   189: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   192: athrow
    //   193: new 53	gnu/mapping/WrongType
    //   196: dup_x1
    //   197: swap
    //   198: ldc -24
    //   200: iconst_2
    //   201: aload 11
    //   203: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   206: athrow
    //   207: new 53	gnu/mapping/WrongType
    //   210: dup_x1
    //   211: swap
    //   212: ldc -16
    //   214: iconst_1
    //   215: aload 11
    //   217: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: new 53	gnu/mapping/WrongType
    //   224: dup_x1
    //   225: swap
    //   226: ldc -16
    //   228: iconst_2
    //   229: aload 11
    //   231: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   234: athrow
    // Line number table:
    //   Java source line #1557	-> byte code offset #0
    //   Java source line #1558	-> byte code offset #8
    //   Java source line #1559	-> byte code offset #52
    //   Java source line #1560	-> byte code offset #62
    //   Java source line #1561	-> byte code offset #81
    //   Java source line #1562	-> byte code offset #83
    //   Java source line #1561	-> byte code offset #96
    //   Java source line #1563	-> byte code offset #96
    //   Java source line #1564	-> byte code offset #107
    //   Java source line #1561	-> byte code offset #155
    //   Java source line #1562	-> byte code offset #164
    //   Java source line #1565	-> byte code offset #176
    //   Java source line #1560	-> byte code offset #179
    //   Java source line #1564	-> byte code offset #193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	s	Object
    //   0	178	1	argsArray	Object[]
    //   0	13	2	maybe$Mnstart$Plend	LList
    //   6	39	3	localObject1	Object
    //   18	28	4	i	int
    //   34	1	5	localObject2	Object
    //   52	30	5	start	Object
    //   50	4	6	end	Object
    //   60	25	7	len	Object
    //   79	98	8	ans	FString
    //   68	1	9	localObject3	Object
    //   94	94	9	i	Object
    //   92	1	10	localObject4	Object
    //   96	70	10	j	Object
    //   115	115	11	localObject5	Object
    //   179	1	15	localClassCastException1	ClassCastException
    //   193	1	16	localClassCastException2	ClassCastException
    //   207	1	17	localClassCastException3	ClassCastException
    //   221	1	18	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   70	76	179	java/lang/ClassCastException
    //   117	123	193	java/lang/ClassCastException
    //   132	135	207	java/lang/ClassCastException
    //   143	149	221	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringReverse$Ex$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: getstatic 896	gnu/kawa/slib/srfi13:string$Mnreverse$Ex	Lgnu/expr/ModuleMethod;
    //   11: aload_0
    //   12: aload_2
    //   13: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   16: astore_3
    //   17: iconst_0
    //   18: istore 4
    //   20: aload_3
    //   21: iload 4
    //   23: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   26: istore 4
    //   28: aload_3
    //   29: iload 4
    //   31: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   34: astore 5
    //   36: aload_3
    //   37: iload 4
    //   39: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   42: istore 4
    //   44: aload_3
    //   45: iload 4
    //   47: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   50: astore 6
    //   52: iconst_m1
    //   53: aload 6
    //   55: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   58: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: aload 5
    //   63: astore 8
    //   65: astore 7
    //   67: aload 7
    //   69: aload 8
    //   71: invokestatic 108	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   74: ifne +146 -> 220
    //   77: aload_0
    //   78: ldc 43
    //   80: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   83: dup
    //   84: astore 10
    //   86: checkcast 43	java/lang/CharSequence
    //   89: aload 7
    //   91: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: dup
    //   95: astore 10
    //   97: checkcast 177	java/lang/Number
    //   100: invokevirtual 181	java/lang/Number:intValue	()I
    //   103: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   106: istore 9
    //   108: aload_0
    //   109: ldc_w 272
    //   112: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   115: dup
    //   116: astore 10
    //   118: checkcast 272	gnu/lists/CharSeq
    //   121: aload 7
    //   123: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: dup
    //   127: astore 10
    //   129: checkcast 177	java/lang/Number
    //   132: invokevirtual 181	java/lang/Number:intValue	()I
    //   135: aload_0
    //   136: ldc 43
    //   138: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   141: dup
    //   142: astore 10
    //   144: checkcast 43	java/lang/CharSequence
    //   147: aload 8
    //   149: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   152: dup
    //   153: astore 10
    //   155: checkcast 177	java/lang/Number
    //   158: invokevirtual 181	java/lang/Number:intValue	()I
    //   161: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   164: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   167: aload_0
    //   168: ldc_w 272
    //   171: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   174: dup
    //   175: astore 10
    //   177: checkcast 272	gnu/lists/CharSeq
    //   180: aload 8
    //   182: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   185: dup
    //   186: astore 10
    //   188: checkcast 177	java/lang/Number
    //   191: invokevirtual 181	java/lang/Number:intValue	()I
    //   194: iload 9
    //   196: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   199: iconst_m1
    //   200: aload 7
    //   202: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   205: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   208: iconst_1
    //   209: aload 8
    //   211: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   214: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: goto -154 -> 63
    //   220: getstatic 276	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   223: areturn
    //   224: new 53	gnu/mapping/WrongType
    //   227: dup_x1
    //   228: swap
    //   229: ldc -16
    //   231: iconst_1
    //   232: aload 10
    //   234: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   237: athrow
    //   238: new 53	gnu/mapping/WrongType
    //   241: dup_x1
    //   242: swap
    //   243: ldc -16
    //   245: iconst_2
    //   246: aload 10
    //   248: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   251: athrow
    //   252: new 53	gnu/mapping/WrongType
    //   255: dup_x1
    //   256: swap
    //   257: ldc -24
    //   259: iconst_1
    //   260: aload 10
    //   262: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   265: athrow
    //   266: new 53	gnu/mapping/WrongType
    //   269: dup_x1
    //   270: swap
    //   271: ldc -24
    //   273: iconst_2
    //   274: aload 10
    //   276: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: new 53	gnu/mapping/WrongType
    //   283: dup_x1
    //   284: swap
    //   285: ldc -16
    //   287: iconst_1
    //   288: aload 10
    //   290: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   293: athrow
    //   294: new 53	gnu/mapping/WrongType
    //   297: dup_x1
    //   298: swap
    //   299: ldc -16
    //   301: iconst_2
    //   302: aload 10
    //   304: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   307: athrow
    //   308: new 53	gnu/mapping/WrongType
    //   311: dup_x1
    //   312: swap
    //   313: ldc -24
    //   315: iconst_1
    //   316: aload 10
    //   318: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   321: athrow
    //   322: new 53	gnu/mapping/WrongType
    //   325: dup_x1
    //   326: swap
    //   327: ldc -24
    //   329: iconst_2
    //   330: aload 10
    //   332: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   335: athrow
    // Line number table:
    //   Java source line #1567	-> byte code offset #0
    //   Java source line #1568	-> byte code offset #8
    //   Java source line #1569	-> byte code offset #52
    //   Java source line #1571	-> byte code offset #67
    //   Java source line #1572	-> byte code offset #77
    //   Java source line #1573	-> byte code offset #108
    //   Java source line #1574	-> byte code offset #167
    //   Java source line #1569	-> byte code offset #199
    //   Java source line #1570	-> byte code offset #208
    //   Java source line #1572	-> byte code offset #224
    //   Java source line #1573	-> byte code offset #252
    //   Java source line #1574	-> byte code offset #308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	s	Object
    //   0	223	1	argsArray	Object[]
    //   0	13	2	maybe$Mnstart$Plend	LList
    //   6	39	3	localObject1	Object
    //   18	28	4	i	int
    //   34	1	5	localObject2	Object
    //   52	10	5	start	Object
    //   50	4	6	end	Object
    //   65	136	7	i	Object
    //   63	1	8	localObject3	Object
    //   67	143	8	j	Object
    //   106	89	9	ci	int
    //   84	247	10	localObject4	Object
    //   224	1	13	localClassCastException1	ClassCastException
    //   238	1	14	localClassCastException2	ClassCastException
    //   252	1	15	localClassCastException3	ClassCastException
    //   266	1	16	localClassCastException4	ClassCastException
    //   280	1	17	localClassCastException5	ClassCastException
    //   294	1	18	localClassCastException6	ClassCastException
    //   308	1	19	localClassCastException7	ClassCastException
    //   322	1	20	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   86	89	224	java/lang/ClassCastException
    //   97	103	238	java/lang/ClassCastException
    //   118	121	252	java/lang/ClassCastException
    //   129	135	266	java/lang/ClassCastException
    //   144	147	280	java/lang/ClassCastException
    //   155	161	294	java/lang/ClassCastException
    //   177	180	308	java/lang/ClassCastException
    //   188	194	322	java/lang/ClassCastException
  }
  
  /* Error */
  public static FString reverseList$To$String(Object clist)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 901	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   4: istore_1
    //   5: iload_1
    //   6: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   9: astore_2
    //   10: iload_1
    //   11: iconst_1
    //   12: isub
    //   13: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: aload_0
    //   17: astore 4
    //   19: astore_3
    //   20: aload 4
    //   22: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   25: ifeq +72 -> 97
    //   28: aload_2
    //   29: aload_3
    //   30: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: dup
    //   34: astore 5
    //   36: checkcast 177	java/lang/Number
    //   39: invokevirtual 181	java/lang/Number:intValue	()I
    //   42: aload 4
    //   44: ldc 70
    //   46: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: astore 5
    //   52: checkcast 70	gnu/lists/Pair
    //   55: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   58: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 5
    //   64: invokestatic 259	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   67: invokestatic 263	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   70: iconst_m1
    //   71: aload_3
    //   72: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   75: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: aload 4
    //   80: ldc 70
    //   82: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   85: dup
    //   86: astore 5
    //   88: checkcast 70	gnu/lists/Pair
    //   91: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   94: goto -77 -> 17
    //   97: aload_2
    //   98: areturn
    //   99: new 53	gnu/mapping/WrongType
    //   102: dup_x1
    //   103: swap
    //   104: ldc -24
    //   106: iconst_2
    //   107: aload 5
    //   109: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   112: athrow
    //   113: new 53	gnu/mapping/WrongType
    //   116: dup_x1
    //   117: swap
    //   118: ldc 72
    //   120: iconst_1
    //   121: aload 5
    //   123: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    //   127: new 53	gnu/mapping/WrongType
    //   130: dup_x1
    //   131: swap
    //   132: ldc -24
    //   134: iconst_3
    //   135: aload 5
    //   137: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   140: athrow
    //   141: new 53	gnu/mapping/WrongType
    //   144: dup_x1
    //   145: swap
    //   146: ldc 77
    //   148: iconst_1
    //   149: aload 5
    //   151: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   154: athrow
    // Line number table:
    //   Java source line #1577	-> byte code offset #0
    //   Java source line #1578	-> byte code offset #0
    //   Java source line #1579	-> byte code offset #5
    //   Java source line #1580	-> byte code offset #10
    //   Java source line #1581	-> byte code offset #20
    //   Java source line #1582	-> byte code offset #28
    //   Java source line #1580	-> byte code offset #70
    //   Java source line #1583	-> byte code offset #97
    //   Java source line #1582	-> byte code offset #99
    //   Java source line #1580	-> byte code offset #141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	clist	Object
    //   4	7	1	len	int
    //   9	89	2	s	FString
    //   19	53	3	i	Object
    //   17	1	4	localObject1	Object
    //   20	59	4	clist	Object
    //   34	116	5	localObject2	Object
    //   99	1	7	localClassCastException1	ClassCastException
    //   113	1	8	localClassCastException2	ClassCastException
    //   127	1	9	localClassCastException3	ClassCastException
    //   141	1	10	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   36	42	99	java/lang/ClassCastException
    //   52	55	113	java/lang/ClassCastException
    //   64	67	127	java/lang/ClassCastException
    //   88	91	141	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringConcatenate$SlShared(Object strings)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   4: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   7: astore_3
    //   8: astore_2
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   14: ifeq +99 -> 113
    //   17: aload_1
    //   18: ldc 70
    //   20: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore 5
    //   26: checkcast 70	gnu/lists/Pair
    //   29: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   32: astore 4
    //   34: aload_1
    //   35: ldc 70
    //   37: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: dup
    //   41: astore 6
    //   43: checkcast 70	gnu/lists/Pair
    //   46: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   49: astore 5
    //   51: aload 4
    //   53: ldc 43
    //   55: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   58: dup
    //   59: astore 7
    //   61: checkcast 43	java/lang/CharSequence
    //   64: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   67: istore 6
    //   69: iload 6
    //   71: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   77: ifeq +9 -> 86
    //   80: aload 5
    //   82: astore_1
    //   83: goto -73 -> 10
    //   86: aload 5
    //   88: iconst_1
    //   89: aload_2
    //   90: iload 6
    //   92: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: aload_3
    //   99: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   102: ifeq +7 -> 109
    //   105: aload_3
    //   106: goto -99 -> 7
    //   109: aload_1
    //   110: goto -103 -> 7
    //   113: aload_2
    //   114: ldc -79
    //   116: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: dup
    //   120: astore 4
    //   122: checkcast 177	java/lang/Number
    //   125: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   128: ifeq +9 -> 137
    //   131: ldc_w 290
    //   134: goto +209 -> 343
    //   137: aload_2
    //   138: aload_3
    //   139: ldc 70
    //   141: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   144: dup
    //   145: astore 4
    //   147: checkcast 70	gnu/lists/Pair
    //   150: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   153: ldc 43
    //   155: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   158: dup
    //   159: astore 4
    //   161: checkcast 43	java/lang/CharSequence
    //   164: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   167: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   173: ifeq +21 -> 194
    //   176: aload_3
    //   177: ldc 70
    //   179: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   182: dup
    //   183: astore 4
    //   185: checkcast 70	gnu/lists/Pair
    //   188: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   191: goto +152 -> 343
    //   194: aload_2
    //   195: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: dup
    //   199: astore 5
    //   201: checkcast 177	java/lang/Number
    //   204: invokevirtual 181	java/lang/Number:intValue	()I
    //   207: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   210: astore 4
    //   212: aload_3
    //   213: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   216: astore 6
    //   218: astore 5
    //   220: aload 5
    //   222: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   225: ifeq +116 -> 341
    //   228: aload 5
    //   230: ldc 70
    //   232: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   235: dup
    //   236: astore 8
    //   238: checkcast 70	gnu/lists/Pair
    //   241: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   244: astore 7
    //   246: aload 7
    //   248: ldc 43
    //   250: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   253: dup
    //   254: astore 9
    //   256: checkcast 43	java/lang/CharSequence
    //   259: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   262: istore 8
    //   264: aload 4
    //   266: ldc_w 332
    //   269: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   272: dup
    //   273: astore 9
    //   275: checkcast 332	gnu/lists/FString
    //   278: aload 6
    //   280: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   283: dup
    //   284: astore 9
    //   286: checkcast 177	java/lang/Number
    //   289: invokevirtual 181	java/lang/Number:intValue	()I
    //   292: aload 7
    //   294: ldc 43
    //   296: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   299: dup
    //   300: astore 9
    //   302: checkcast 43	java/lang/CharSequence
    //   305: iconst_0
    //   306: iload 8
    //   308: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   311: aload 5
    //   313: ldc 70
    //   315: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   318: dup
    //   319: astore 9
    //   321: checkcast 70	gnu/lists/Pair
    //   324: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   327: iconst_1
    //   328: aload 6
    //   330: iload 8
    //   332: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: goto -122 -> 216
    //   341: aload 4
    //   343: areturn
    //   344: new 53	gnu/mapping/WrongType
    //   347: dup_x1
    //   348: swap
    //   349: ldc 72
    //   351: iconst_1
    //   352: aload 5
    //   354: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 53	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc 77
    //   365: iconst_1
    //   366: aload 6
    //   368: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   371: athrow
    //   372: new 53	gnu/mapping/WrongType
    //   375: dup_x1
    //   376: swap
    //   377: ldc 55
    //   379: iconst_1
    //   380: aload 7
    //   382: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   385: athrow
    //   386: new 53	gnu/mapping/WrongType
    //   389: dup_x1
    //   390: swap
    //   391: ldc_w 590
    //   394: iconst_1
    //   395: aload 4
    //   397: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   400: athrow
    //   401: new 53	gnu/mapping/WrongType
    //   404: dup_x1
    //   405: swap
    //   406: ldc 72
    //   408: iconst_1
    //   409: aload 4
    //   411: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   414: athrow
    //   415: new 53	gnu/mapping/WrongType
    //   418: dup_x1
    //   419: swap
    //   420: ldc 55
    //   422: iconst_1
    //   423: aload 4
    //   425: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   428: athrow
    //   429: new 53	gnu/mapping/WrongType
    //   432: dup_x1
    //   433: swap
    //   434: ldc 72
    //   436: iconst_1
    //   437: aload 4
    //   439: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   442: athrow
    //   443: new 53	gnu/mapping/WrongType
    //   446: dup_x1
    //   447: swap
    //   448: ldc -36
    //   450: iconst_1
    //   451: aload 5
    //   453: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   456: athrow
    //   457: new 53	gnu/mapping/WrongType
    //   460: dup_x1
    //   461: swap
    //   462: ldc 72
    //   464: iconst_1
    //   465: aload 8
    //   467: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   470: athrow
    //   471: new 53	gnu/mapping/WrongType
    //   474: dup_x1
    //   475: swap
    //   476: ldc 55
    //   478: iconst_1
    //   479: aload 9
    //   481: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   484: athrow
    //   485: new 53	gnu/mapping/WrongType
    //   488: dup_x1
    //   489: swap
    //   490: ldc_w 334
    //   493: iconst_1
    //   494: aload 9
    //   496: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   499: athrow
    //   500: new 53	gnu/mapping/WrongType
    //   503: dup_x1
    //   504: swap
    //   505: ldc_w 334
    //   508: iconst_2
    //   509: aload 9
    //   511: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   514: athrow
    //   515: new 53	gnu/mapping/WrongType
    //   518: dup_x1
    //   519: swap
    //   520: ldc_w 334
    //   523: iconst_3
    //   524: aload 9
    //   526: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   529: athrow
    //   530: new 53	gnu/mapping/WrongType
    //   533: dup_x1
    //   534: swap
    //   535: ldc 77
    //   537: iconst_1
    //   538: aload 9
    //   540: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   543: athrow
    // Line number table:
    //   Java source line #1618	-> byte code offset #0
    //   Java source line #1619	-> byte code offset #0
    //   Java source line #1620	-> byte code offset #10
    //   Java source line #1621	-> byte code offset #17
    //   Java source line #1622	-> byte code offset #34
    //   Java source line #1621	-> byte code offset #51
    //   Java source line #1623	-> byte code offset #51
    //   Java source line #1624	-> byte code offset #69
    //   Java source line #1625	-> byte code offset #80
    //   Java source line #1626	-> byte code offset #86
    //   Java source line #1628	-> byte code offset #113
    //   Java source line #1631	-> byte code offset #137
    //   Java source line #1633	-> byte code offset #194
    //   Java source line #1634	-> byte code offset #212
    //   Java source line #1635	-> byte code offset #220
    //   Java source line #1636	-> byte code offset #228
    //   Java source line #1637	-> byte code offset #246
    //   Java source line #1638	-> byte code offset #264
    //   Java source line #1639	-> byte code offset #311
    //   Java source line #1640	-> byte code offset #341
    //   Java source line #1621	-> byte code offset #344
    //   Java source line #1622	-> byte code offset #358
    //   Java source line #1623	-> byte code offset #372
    //   Java source line #1628	-> byte code offset #386
    //   Java source line #1631	-> byte code offset #401
    //   Java source line #1633	-> byte code offset #443
    //   Java source line #1636	-> byte code offset #457
    //   Java source line #1637	-> byte code offset #471
    //   Java source line #1638	-> byte code offset #485
    //   Java source line #1639	-> byte code offset #530
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	strings	Object
    //   9	101	1	strings	Object
    //   8	1	2	localIntNum1	IntNum
    //   10	185	2	nchars	Object
    //   7	1	3	localBoolean	Boolean
    //   10	203	3	first	Object
    //   32	152	4	string	Object
    //   210	228	4	ans	Object
    //   24	1	5	localObject1	Object
    //   49	151	5	tail	Object
    //   218	234	5	strings	Object
    //   41	1	6	localObject2	Object
    //   67	150	6	slen	int
    //   216	1	6	localIntNum2	IntNum
    //   220	147	6	i	Object
    //   59	1	7	localObject3	Object
    //   244	137	7	s	Object
    //   236	1	8	localObject4	Object
    //   262	204	8	slen	int
    //   254	285	9	localObject5	Object
    //   344	1	20	localClassCastException1	ClassCastException
    //   358	1	21	localClassCastException2	ClassCastException
    //   372	1	22	localClassCastException3	ClassCastException
    //   386	1	23	localClassCastException4	ClassCastException
    //   401	1	24	localClassCastException5	ClassCastException
    //   415	1	25	localClassCastException6	ClassCastException
    //   429	1	26	localClassCastException7	ClassCastException
    //   443	1	27	localClassCastException8	ClassCastException
    //   457	1	28	localClassCastException9	ClassCastException
    //   471	1	29	localClassCastException10	ClassCastException
    //   485	1	30	localClassCastException11	ClassCastException
    //   500	1	31	localClassCastException12	ClassCastException
    //   515	1	32	localClassCastException13	ClassCastException
    //   530	1	33	localClassCastException14	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   26	29	344	java/lang/ClassCastException
    //   43	46	358	java/lang/ClassCastException
    //   61	64	372	java/lang/ClassCastException
    //   122	125	386	java/lang/ClassCastException
    //   147	150	401	java/lang/ClassCastException
    //   161	164	415	java/lang/ClassCastException
    //   185	188	429	java/lang/ClassCastException
    //   201	207	443	java/lang/ClassCastException
    //   238	241	457	java/lang/ClassCastException
    //   256	259	471	java/lang/ClassCastException
    //   275	278	485	java/lang/ClassCastException
    //   286	292	500	java/lang/ClassCastException
    //   302	305	515	java/lang/ClassCastException
    //   321	324	530	java/lang/ClassCastException
  }
  
  /* Error */
  public static FString stringConcatenate(Object strings)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   4: astore_3
    //   5: astore_2
    //   6: aload_2
    //   7: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   10: ifeq +58 -> 68
    //   13: aload_2
    //   14: ldc 70
    //   16: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: astore 4
    //   22: checkcast 70	gnu/lists/Pair
    //   25: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   28: iconst_1
    //   29: aload_3
    //   30: aload_2
    //   31: ldc 70
    //   33: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: dup
    //   37: astore 4
    //   39: checkcast 70	gnu/lists/Pair
    //   42: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   45: ldc 43
    //   47: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   50: dup
    //   51: astore 4
    //   53: checkcast 43	java/lang/CharSequence
    //   56: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   59: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: goto -61 -> 4
    //   68: aload_3
    //   69: astore_1
    //   70: aload_1
    //   71: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: dup
    //   75: astore_3
    //   76: checkcast 177	java/lang/Number
    //   79: invokevirtual 181	java/lang/Number:intValue	()I
    //   82: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   85: astore_2
    //   86: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   89: aload_0
    //   90: astore 4
    //   92: astore_3
    //   93: aload 4
    //   95: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   98: ifeq +101 -> 199
    //   101: aload 4
    //   103: ldc 70
    //   105: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   108: dup
    //   109: astore 6
    //   111: checkcast 70	gnu/lists/Pair
    //   114: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   117: astore 5
    //   119: aload 5
    //   121: ldc 43
    //   123: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   126: dup
    //   127: astore 7
    //   129: checkcast 43	java/lang/CharSequence
    //   132: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   135: istore 6
    //   137: aload_2
    //   138: aload_3
    //   139: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: dup
    //   143: astore 7
    //   145: checkcast 177	java/lang/Number
    //   148: invokevirtual 181	java/lang/Number:intValue	()I
    //   151: aload 5
    //   153: ldc 43
    //   155: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   158: dup
    //   159: astore 7
    //   161: checkcast 43	java/lang/CharSequence
    //   164: iconst_0
    //   165: iload 6
    //   167: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   170: iconst_1
    //   171: aload_3
    //   172: iload 6
    //   174: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: aload 4
    //   182: ldc 70
    //   184: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: dup
    //   188: astore 7
    //   190: checkcast 70	gnu/lists/Pair
    //   193: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   196: goto -106 -> 90
    //   199: aload_2
    //   200: areturn
    //   201: new 53	gnu/mapping/WrongType
    //   204: dup_x1
    //   205: swap
    //   206: ldc 77
    //   208: iconst_1
    //   209: aload 4
    //   211: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   214: athrow
    //   215: new 53	gnu/mapping/WrongType
    //   218: dup_x1
    //   219: swap
    //   220: ldc 72
    //   222: iconst_1
    //   223: aload 4
    //   225: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   228: athrow
    //   229: new 53	gnu/mapping/WrongType
    //   232: dup_x1
    //   233: swap
    //   234: ldc 55
    //   236: iconst_1
    //   237: aload 4
    //   239: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   242: athrow
    //   243: new 53	gnu/mapping/WrongType
    //   246: dup_x1
    //   247: swap
    //   248: ldc -36
    //   250: iconst_1
    //   251: aload_3
    //   252: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: new 53	gnu/mapping/WrongType
    //   259: dup_x1
    //   260: swap
    //   261: ldc 72
    //   263: iconst_1
    //   264: aload 6
    //   266: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   269: athrow
    //   270: new 53	gnu/mapping/WrongType
    //   273: dup_x1
    //   274: swap
    //   275: ldc 55
    //   277: iconst_1
    //   278: aload 7
    //   280: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   283: athrow
    //   284: new 53	gnu/mapping/WrongType
    //   287: dup_x1
    //   288: swap
    //   289: ldc_w 334
    //   292: iconst_2
    //   293: aload 7
    //   295: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   298: athrow
    //   299: new 53	gnu/mapping/WrongType
    //   302: dup_x1
    //   303: swap
    //   304: ldc_w 334
    //   307: iconst_3
    //   308: aload 7
    //   310: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   313: athrow
    //   314: new 53	gnu/mapping/WrongType
    //   317: dup_x1
    //   318: swap
    //   319: ldc 77
    //   321: iconst_1
    //   322: aload 7
    //   324: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    // Line number table:
    //   Java source line #1648	-> byte code offset #0
    //   Java source line #1649	-> byte code offset #0
    //   Java source line #1651	-> byte code offset #6
    //   Java source line #1649	-> byte code offset #13
    //   Java source line #1650	-> byte code offset #28
    //   Java source line #1649	-> byte code offset #68
    //   Java source line #1651	-> byte code offset #68
    //   Java source line #1649	-> byte code offset #70
    //   Java source line #1652	-> byte code offset #70
    //   Java source line #1653	-> byte code offset #86
    //   Java source line #1654	-> byte code offset #93
    //   Java source line #1655	-> byte code offset #101
    //   Java source line #1656	-> byte code offset #119
    //   Java source line #1657	-> byte code offset #137
    //   Java source line #1658	-> byte code offset #170
    //   Java source line #1659	-> byte code offset #199
    //   Java source line #1649	-> byte code offset #201
    //   Java source line #1650	-> byte code offset #215
    //   Java source line #1652	-> byte code offset #243
    //   Java source line #1655	-> byte code offset #256
    //   Java source line #1656	-> byte code offset #270
    //   Java source line #1657	-> byte code offset #284
    //   Java source line #1658	-> byte code offset #314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	strings	Object
    //   69	2	1	total	Object
    //   5	26	2	strings	Object
    //   85	115	2	ans	FString
    //   4	1	3	localIntNum	IntNum
    //   6	70	3	i	Object
    //   92	160	3	i	Object
    //   20	71	4	localObject1	Object
    //   93	145	4	strings	Object
    //   117	35	5	s	Object
    //   109	1	6	localObject2	Object
    //   135	130	6	slen	int
    //   127	196	7	localObject3	Object
    //   201	1	13	localClassCastException1	ClassCastException
    //   215	1	14	localClassCastException2	ClassCastException
    //   229	1	15	localClassCastException3	ClassCastException
    //   243	1	16	localClassCastException4	ClassCastException
    //   256	1	17	localClassCastException5	ClassCastException
    //   270	1	18	localClassCastException6	ClassCastException
    //   284	1	19	localClassCastException7	ClassCastException
    //   299	1	20	localClassCastException8	ClassCastException
    //   314	1	21	localClassCastException9	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   22	25	201	java/lang/ClassCastException
    //   39	42	215	java/lang/ClassCastException
    //   53	56	229	java/lang/ClassCastException
    //   76	82	243	java/lang/ClassCastException
    //   111	114	256	java/lang/ClassCastException
    //   129	132	270	java/lang/ClassCastException
    //   145	151	284	java/lang/ClassCastException
    //   161	164	299	java/lang/ClassCastException
    //   190	193	314	java/lang/ClassCastException
  }
  
  /* Error */
  public static FString stringConcatenateReverse$V(Object string$Mnlist, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: ldc_w 290
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic 25	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   36: ifne +7 -> 43
    //   39: ldc_w 290
    //   42: astore_3
    //   43: aload_2
    //   44: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   47: ifne +16 -> 63
    //   50: aload_2
    //   51: dup
    //   52: astore 5
    //   54: checkcast 70	gnu/lists/Pair
    //   57: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   60: goto +4 -> 64
    //   63: aload_2
    //   64: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   67: ifne +47 -> 114
    //   70: aload_2
    //   71: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   74: ifne +27 -> 101
    //   77: aload_2
    //   78: dup
    //   79: astore 5
    //   81: checkcast 70	gnu/lists/Pair
    //   84: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   87: ldc 70
    //   89: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 5
    //   95: checkcast 70	gnu/lists/Pair
    //   98: goto +10 -> 108
    //   101: aload_2
    //   102: dup
    //   103: astore 5
    //   105: checkcast 70	gnu/lists/Pair
    //   108: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   111: goto +21 -> 132
    //   114: aload_3
    //   115: ldc 43
    //   117: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   120: dup
    //   121: astore 5
    //   123: checkcast 43	java/lang/CharSequence
    //   126: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   129: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: astore 4
    //   134: aload 4
    //   136: invokestatic 84	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   139: ifeq +44 -> 183
    //   142: aload 4
    //   144: invokestatic 87	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   147: ifeq +36 -> 183
    //   150: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   153: aload 4
    //   155: aload_3
    //   156: ldc 43
    //   158: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   161: dup
    //   162: astore 5
    //   164: checkcast 43	java/lang/CharSequence
    //   167: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   170: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: iconst_0
    //   174: anewarray 27	java/lang/Object
    //   177: invokestatic 908	gnu/kawa/functions/NumberCompare:$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   180: ifne +23 -> 203
    //   183: aload_3
    //   184: ldc 43
    //   186: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   189: dup
    //   190: astore 5
    //   192: checkcast 43	java/lang/CharSequence
    //   195: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   198: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: astore 4
    //   203: aload_2
    //   204: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   207: ifne +16 -> 223
    //   210: aload_2
    //   211: dup
    //   212: astore 5
    //   214: checkcast 70	gnu/lists/Pair
    //   217: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   220: goto +4 -> 224
    //   223: aload_2
    //   224: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   227: ifne +47 -> 274
    //   230: aload_2
    //   231: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   234: ifne +27 -> 261
    //   237: aload_2
    //   238: dup
    //   239: astore 5
    //   241: checkcast 70	gnu/lists/Pair
    //   244: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   247: ldc 70
    //   249: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   252: dup
    //   253: astore 5
    //   255: checkcast 70	gnu/lists/Pair
    //   258: goto +10 -> 268
    //   261: aload_2
    //   262: dup
    //   263: astore 5
    //   265: checkcast 70	gnu/lists/Pair
    //   268: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   271: goto +24 -> 295
    //   274: aload_2
    //   275: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   278: ifne +16 -> 294
    //   281: aload_2
    //   282: dup
    //   283: astore 5
    //   285: checkcast 70	gnu/lists/Pair
    //   288: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   291: goto +4 -> 295
    //   294: aload_2
    //   295: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   298: ifeq +93 -> 391
    //   301: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   304: aload_0
    //   305: astore 7
    //   307: astore 6
    //   309: aload 7
    //   311: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   314: ifeq +61 -> 375
    //   317: iconst_1
    //   318: aload 6
    //   320: aload 7
    //   322: ldc 70
    //   324: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   327: dup
    //   328: astore 8
    //   330: checkcast 70	gnu/lists/Pair
    //   333: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   336: ldc 43
    //   338: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   341: dup
    //   342: astore 8
    //   344: checkcast 43	java/lang/CharSequence
    //   347: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   350: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   356: aload 7
    //   358: ldc 70
    //   360: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   363: dup
    //   364: astore 8
    //   366: checkcast 70	gnu/lists/Pair
    //   369: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   372: goto -67 -> 305
    //   375: aload 6
    //   377: astore 5
    //   379: aload 5
    //   381: aload_0
    //   382: aload_3
    //   383: aload 4
    //   385: invokestatic 911	gnu/kawa/slib/srfi13:$PcFinishStringConcatenateReverse	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
    //   388: goto +115 -> 503
    //   391: iconst_2
    //   392: anewarray 27	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: ldc_w 340
    //   400: aastore
    //   401: dup
    //   402: iconst_1
    //   403: aload_2
    //   404: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   407: ifne +16 -> 423
    //   410: aload_2
    //   411: dup
    //   412: astore 5
    //   414: checkcast 70	gnu/lists/Pair
    //   417: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   420: goto +4 -> 424
    //   423: aload_2
    //   424: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   427: ifne +47 -> 474
    //   430: aload_2
    //   431: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   434: ifne +27 -> 461
    //   437: aload_2
    //   438: dup
    //   439: astore 5
    //   441: checkcast 70	gnu/lists/Pair
    //   444: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   447: ldc 70
    //   449: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   452: dup
    //   453: astore 5
    //   455: checkcast 70	gnu/lists/Pair
    //   458: goto +10 -> 468
    //   461: aload_2
    //   462: dup
    //   463: astore 5
    //   465: checkcast 70	gnu/lists/Pair
    //   468: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   471: goto +24 -> 495
    //   474: aload_2
    //   475: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   478: ifne +16 -> 494
    //   481: aload_2
    //   482: dup
    //   483: astore 5
    //   485: checkcast 70	gnu/lists/Pair
    //   488: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   491: goto +4 -> 495
    //   494: aload_2
    //   495: aastore
    //   496: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   499: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   502: athrow
    //   503: areturn
    //   504: new 53	gnu/mapping/WrongType
    //   507: dup_x1
    //   508: swap
    //   509: ldc 72
    //   511: iconst_1
    //   512: aload 4
    //   514: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   517: athrow
    //   518: new 53	gnu/mapping/WrongType
    //   521: dup_x1
    //   522: swap
    //   523: ldc 77
    //   525: iconst_1
    //   526: aload 5
    //   528: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   531: athrow
    //   532: new 53	gnu/mapping/WrongType
    //   535: dup_x1
    //   536: swap
    //   537: ldc 77
    //   539: iconst_1
    //   540: aload 5
    //   542: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   545: athrow
    //   546: new 53	gnu/mapping/WrongType
    //   549: dup_x1
    //   550: swap
    //   551: ldc 72
    //   553: iconst_1
    //   554: aload 5
    //   556: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   559: athrow
    //   560: new 53	gnu/mapping/WrongType
    //   563: dup_x1
    //   564: swap
    //   565: ldc 72
    //   567: iconst_1
    //   568: aload 5
    //   570: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   573: athrow
    //   574: new 53	gnu/mapping/WrongType
    //   577: dup_x1
    //   578: swap
    //   579: ldc 55
    //   581: iconst_1
    //   582: aload 5
    //   584: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   587: athrow
    //   588: new 53	gnu/mapping/WrongType
    //   591: dup_x1
    //   592: swap
    //   593: ldc 55
    //   595: iconst_1
    //   596: aload 5
    //   598: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   601: athrow
    //   602: new 53	gnu/mapping/WrongType
    //   605: dup_x1
    //   606: swap
    //   607: ldc 55
    //   609: iconst_1
    //   610: aload 5
    //   612: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   615: athrow
    //   616: new 53	gnu/mapping/WrongType
    //   619: dup_x1
    //   620: swap
    //   621: ldc 77
    //   623: iconst_1
    //   624: aload 5
    //   626: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   629: athrow
    //   630: new 53	gnu/mapping/WrongType
    //   633: dup_x1
    //   634: swap
    //   635: ldc 77
    //   637: iconst_1
    //   638: aload 5
    //   640: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   643: athrow
    //   644: new 53	gnu/mapping/WrongType
    //   647: dup_x1
    //   648: swap
    //   649: ldc 77
    //   651: iconst_1
    //   652: aload 5
    //   654: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   657: athrow
    //   658: new 53	gnu/mapping/WrongType
    //   661: dup_x1
    //   662: swap
    //   663: ldc 77
    //   665: iconst_1
    //   666: aload 5
    //   668: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   671: athrow
    //   672: new 53	gnu/mapping/WrongType
    //   675: dup_x1
    //   676: swap
    //   677: ldc 77
    //   679: iconst_1
    //   680: aload 5
    //   682: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   685: athrow
    //   686: new 53	gnu/mapping/WrongType
    //   689: dup_x1
    //   690: swap
    //   691: ldc 72
    //   693: iconst_1
    //   694: aload 8
    //   696: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   699: athrow
    //   700: new 53	gnu/mapping/WrongType
    //   703: dup_x1
    //   704: swap
    //   705: ldc 55
    //   707: iconst_1
    //   708: aload 8
    //   710: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   713: athrow
    //   714: new 53	gnu/mapping/WrongType
    //   717: dup_x1
    //   718: swap
    //   719: ldc 77
    //   721: iconst_1
    //   722: aload 8
    //   724: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   727: athrow
    //   728: new 53	gnu/mapping/WrongType
    //   731: dup_x1
    //   732: swap
    //   733: ldc 77
    //   735: iconst_1
    //   736: aload 5
    //   738: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   741: athrow
    //   742: new 53	gnu/mapping/WrongType
    //   745: dup_x1
    //   746: swap
    //   747: ldc 77
    //   749: iconst_1
    //   750: aload 5
    //   752: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   755: athrow
    //   756: new 53	gnu/mapping/WrongType
    //   759: dup_x1
    //   760: swap
    //   761: ldc 77
    //   763: iconst_1
    //   764: aload 5
    //   766: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   769: athrow
    //   770: new 53	gnu/mapping/WrongType
    //   773: dup_x1
    //   774: swap
    //   775: ldc 77
    //   777: iconst_1
    //   778: aload 5
    //   780: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   783: athrow
    //   784: new 53	gnu/mapping/WrongType
    //   787: dup_x1
    //   788: swap
    //   789: ldc 77
    //   791: iconst_1
    //   792: aload 5
    //   794: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   797: athrow
    // Line number table:
    //   Java source line #1673	-> byte code offset #0
    //   Java source line #1674	-> byte code offset #8
    //   Java source line #1675	-> byte code offset #63
    //   Java source line #1674	-> byte code offset #70
    //   Java source line #1675	-> byte code offset #101
    //   Java source line #1674	-> byte code offset #134
    //   Java source line #1676	-> byte code offset #134
    //   Java source line #1677	-> byte code offset #142
    //   Java source line #1678	-> byte code offset #150
    //   Java source line #1674	-> byte code offset #183
    //   Java source line #1675	-> byte code offset #183
    //   Java source line #1674	-> byte code offset #203
    //   Java source line #1679	-> byte code offset #301
    //   Java source line #1680	-> byte code offset #309
    //   Java source line #1681	-> byte code offset #317
    //   Java source line #1680	-> byte code offset #375
    //   Java source line #1684	-> byte code offset #379
    //   Java source line #1674	-> byte code offset #403
    //   Java source line #1675	-> byte code offset #560
    //   Java source line #1678	-> byte code offset #588
    //   Java source line #1675	-> byte code offset #602
    //   Java source line #1674	-> byte code offset #616
    //   Java source line #1681	-> byte code offset #686
    //   Java source line #1674	-> byte code offset #728
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	string$Mnlist	Object
    //   0	503	1	argsArray	Object[]
    //   0	495	2	maybe$Mnfinal$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	352	3	final	Object
    //   17	1	4	localLList2	LList
    //   132	381	4	end	Object
    //   52	232	5	localObject1	Object
    //   377	416	5	len	Object
    //   307	69	6	sum	Object
    //   305	1	7	localObject2	Object
    //   309	48	7	lis	Object
    //   328	395	8	localObject3	Object
    //   504	1	13	localClassCastException1	ClassCastException
    //   518	1	14	localClassCastException2	ClassCastException
    //   532	1	15	localClassCastException3	ClassCastException
    //   546	1	16	localClassCastException4	ClassCastException
    //   560	1	17	localClassCastException5	ClassCastException
    //   574	1	18	localClassCastException6	ClassCastException
    //   588	1	19	localClassCastException7	ClassCastException
    //   602	1	20	localClassCastException8	ClassCastException
    //   616	1	21	localClassCastException9	ClassCastException
    //   630	1	22	localClassCastException10	ClassCastException
    //   644	1	23	localClassCastException11	ClassCastException
    //   658	1	24	localClassCastException12	ClassCastException
    //   672	1	25	localClassCastException13	ClassCastException
    //   686	1	26	localClassCastException14	ClassCastException
    //   700	1	27	localClassCastException15	ClassCastException
    //   714	1	28	localClassCastException16	ClassCastException
    //   728	1	29	localClassCastException17	ClassCastException
    //   742	1	30	localClassCastException18	ClassCastException
    //   756	1	31	localClassCastException19	ClassCastException
    //   770	1	32	localClassCastException20	ClassCastException
    //   784	1	33	localClassCastException21	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	504	java/lang/ClassCastException
    //   54	57	518	java/lang/ClassCastException
    //   81	84	532	java/lang/ClassCastException
    //   95	98	546	java/lang/ClassCastException
    //   105	108	560	java/lang/ClassCastException
    //   123	126	574	java/lang/ClassCastException
    //   164	167	588	java/lang/ClassCastException
    //   192	195	602	java/lang/ClassCastException
    //   214	217	616	java/lang/ClassCastException
    //   241	244	630	java/lang/ClassCastException
    //   255	258	644	java/lang/ClassCastException
    //   265	268	658	java/lang/ClassCastException
    //   285	288	672	java/lang/ClassCastException
    //   330	333	686	java/lang/ClassCastException
    //   344	347	700	java/lang/ClassCastException
    //   366	369	714	java/lang/ClassCastException
    //   414	417	728	java/lang/ClassCastException
    //   441	444	742	java/lang/ClassCastException
    //   455	458	756	java/lang/ClassCastException
    //   465	468	770	java/lang/ClassCastException
    //   485	488	784	java/lang/ClassCastException
  }
  
  /* Error */
  public static FString $PcFinishStringConcatenateReverse(Object len, Object string$Mnlist, Object final, Object end)
  {
    // Byte code:
    //   0: iconst_1
    //   1: aload_3
    //   2: aload_0
    //   3: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: dup
    //   10: astore 5
    //   12: checkcast 177	java/lang/Number
    //   15: invokevirtual 181	java/lang/Number:intValue	()I
    //   18: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   21: astore 4
    //   23: aload 4
    //   25: aload_0
    //   26: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: dup
    //   30: astore 5
    //   32: checkcast 177	java/lang/Number
    //   35: invokevirtual 181	java/lang/Number:intValue	()I
    //   38: aload_2
    //   39: ldc 43
    //   41: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: astore 5
    //   47: checkcast 43	java/lang/CharSequence
    //   50: iconst_0
    //   51: aload_3
    //   52: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: dup
    //   56: astore 5
    //   58: checkcast 177	java/lang/Number
    //   61: invokevirtual 181	java/lang/Number:intValue	()I
    //   64: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   67: aload_0
    //   68: aload_1
    //   69: astore 6
    //   71: astore 5
    //   73: aload 6
    //   75: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   78: ifeq +112 -> 190
    //   81: aload 6
    //   83: ldc 70
    //   85: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   88: dup
    //   89: astore 8
    //   91: checkcast 70	gnu/lists/Pair
    //   94: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   97: astore 7
    //   99: aload 6
    //   101: ldc 70
    //   103: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   106: dup
    //   107: astore 9
    //   109: checkcast 70	gnu/lists/Pair
    //   112: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   115: astore 8
    //   117: aload 7
    //   119: ldc 43
    //   121: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   124: dup
    //   125: astore 10
    //   127: checkcast 43	java/lang/CharSequence
    //   130: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   133: istore 9
    //   135: iconst_m1
    //   136: aload 5
    //   138: iload 9
    //   140: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: astore 10
    //   148: aload 4
    //   150: aload 10
    //   152: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: dup
    //   156: astore 11
    //   158: checkcast 177	java/lang/Number
    //   161: invokevirtual 181	java/lang/Number:intValue	()I
    //   164: aload 7
    //   166: ldc 43
    //   168: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   171: dup
    //   172: astore 11
    //   174: checkcast 43	java/lang/CharSequence
    //   177: iconst_0
    //   178: iload 9
    //   180: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   183: aload 10
    //   185: aload 8
    //   187: goto -118 -> 69
    //   190: aload 4
    //   192: areturn
    //   193: new 53	gnu/mapping/WrongType
    //   196: dup_x1
    //   197: swap
    //   198: ldc -36
    //   200: iconst_1
    //   201: aload 5
    //   203: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   206: athrow
    //   207: new 53	gnu/mapping/WrongType
    //   210: dup_x1
    //   211: swap
    //   212: ldc_w 334
    //   215: iconst_2
    //   216: aload 5
    //   218: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: new 53	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc_w 334
    //   230: iconst_3
    //   231: aload 5
    //   233: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   236: athrow
    //   237: new 53	gnu/mapping/WrongType
    //   240: dup_x1
    //   241: swap
    //   242: ldc_w 334
    //   245: iconst_5
    //   246: aload 5
    //   248: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   251: athrow
    //   252: new 53	gnu/mapping/WrongType
    //   255: dup_x1
    //   256: swap
    //   257: ldc 72
    //   259: iconst_1
    //   260: aload 8
    //   262: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   265: athrow
    //   266: new 53	gnu/mapping/WrongType
    //   269: dup_x1
    //   270: swap
    //   271: ldc 77
    //   273: iconst_1
    //   274: aload 9
    //   276: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: new 53	gnu/mapping/WrongType
    //   283: dup_x1
    //   284: swap
    //   285: ldc 55
    //   287: iconst_1
    //   288: aload 10
    //   290: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   293: athrow
    //   294: new 53	gnu/mapping/WrongType
    //   297: dup_x1
    //   298: swap
    //   299: ldc_w 334
    //   302: iconst_2
    //   303: aload 11
    //   305: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   308: athrow
    //   309: new 53	gnu/mapping/WrongType
    //   312: dup_x1
    //   313: swap
    //   314: ldc_w 334
    //   317: iconst_3
    //   318: aload 11
    //   320: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   323: athrow
    // Line number table:
    //   Java source line #1711	-> byte code offset #0
    //   Java source line #1712	-> byte code offset #0
    //   Java source line #1713	-> byte code offset #23
    //   Java source line #1714	-> byte code offset #67
    //   Java source line #1715	-> byte code offset #73
    //   Java source line #1716	-> byte code offset #81
    //   Java source line #1717	-> byte code offset #99
    //   Java source line #1716	-> byte code offset #117
    //   Java source line #1718	-> byte code offset #117
    //   Java source line #1716	-> byte code offset #135
    //   Java source line #1719	-> byte code offset #135
    //   Java source line #1720	-> byte code offset #148
    //   Java source line #1721	-> byte code offset #183
    //   Java source line #1722	-> byte code offset #190
    //   Java source line #1712	-> byte code offset #193
    //   Java source line #1713	-> byte code offset #207
    //   Java source line #1716	-> byte code offset #252
    //   Java source line #1717	-> byte code offset #266
    //   Java source line #1718	-> byte code offset #280
    //   Java source line #1720	-> byte code offset #294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	len	Object
    //   0	192	1	string$Mnlist	Object
    //   0	192	2	final	Object
    //   0	192	3	end	Object
    //   21	170	4	ans	FString
    //   10	47	5	localObject1	Object
    //   71	176	5	i	Object
    //   69	1	6	localObject2	Object
    //   73	27	6	lis	Object
    //   97	68	7	s	Object
    //   89	1	8	localObject3	Object
    //   115	146	8	lis	Object
    //   107	1	9	localObject4	Object
    //   133	142	9	slen	int
    //   125	1	10	localObject5	Object
    //   146	143	10	i	Object
    //   156	163	11	localObject6	Object
    //   193	1	17	localClassCastException1	ClassCastException
    //   207	1	18	localClassCastException2	ClassCastException
    //   222	1	19	localClassCastException3	ClassCastException
    //   237	1	20	localClassCastException4	ClassCastException
    //   252	1	21	localClassCastException5	ClassCastException
    //   266	1	22	localClassCastException6	ClassCastException
    //   280	1	23	localClassCastException7	ClassCastException
    //   294	1	24	localClassCastException8	ClassCastException
    //   309	1	25	localClassCastException9	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	18	193	java/lang/ClassCastException
    //   32	38	207	java/lang/ClassCastException
    //   47	50	222	java/lang/ClassCastException
    //   58	64	237	java/lang/ClassCastException
    //   91	94	252	java/lang/ClassCastException
    //   109	112	266	java/lang/ClassCastException
    //   127	130	280	java/lang/ClassCastException
    //   158	164	294	java/lang/ClassCastException
    //   174	177	309	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringConcatenateReverse$SlShared$V(Object string$Mnlist, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: ldc_w 290
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic 25	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   36: ifne +7 -> 43
    //   39: ldc_w 290
    //   42: astore_3
    //   43: aload_2
    //   44: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   47: ifne +16 -> 63
    //   50: aload_2
    //   51: dup
    //   52: astore 5
    //   54: checkcast 70	gnu/lists/Pair
    //   57: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   60: goto +4 -> 64
    //   63: aload_2
    //   64: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   67: ifne +47 -> 114
    //   70: aload_2
    //   71: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   74: ifne +27 -> 101
    //   77: aload_2
    //   78: dup
    //   79: astore 5
    //   81: checkcast 70	gnu/lists/Pair
    //   84: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   87: ldc 70
    //   89: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 5
    //   95: checkcast 70	gnu/lists/Pair
    //   98: goto +10 -> 108
    //   101: aload_2
    //   102: dup
    //   103: astore 5
    //   105: checkcast 70	gnu/lists/Pair
    //   108: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   111: goto +21 -> 132
    //   114: aload_3
    //   115: ldc 43
    //   117: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   120: dup
    //   121: astore 5
    //   123: checkcast 43	java/lang/CharSequence
    //   126: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   129: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: astore 4
    //   134: aload 4
    //   136: invokestatic 84	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   139: ifeq +44 -> 183
    //   142: aload 4
    //   144: invokestatic 87	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   147: ifeq +36 -> 183
    //   150: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   153: aload 4
    //   155: aload_3
    //   156: ldc 43
    //   158: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   161: dup
    //   162: astore 5
    //   164: checkcast 43	java/lang/CharSequence
    //   167: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   170: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: iconst_0
    //   174: anewarray 27	java/lang/Object
    //   177: invokestatic 908	gnu/kawa/functions/NumberCompare:$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   180: ifne +23 -> 203
    //   183: aload_3
    //   184: ldc 43
    //   186: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   189: dup
    //   190: astore 5
    //   192: checkcast 43	java/lang/CharSequence
    //   195: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   198: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: astore 4
    //   203: aload_2
    //   204: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   207: ifne +16 -> 223
    //   210: aload_2
    //   211: dup
    //   212: astore 5
    //   214: checkcast 70	gnu/lists/Pair
    //   217: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   220: goto +4 -> 224
    //   223: aload_2
    //   224: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   227: ifne +47 -> 274
    //   230: aload_2
    //   231: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   234: ifne +27 -> 261
    //   237: aload_2
    //   238: dup
    //   239: astore 5
    //   241: checkcast 70	gnu/lists/Pair
    //   244: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   247: ldc 70
    //   249: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   252: dup
    //   253: astore 5
    //   255: checkcast 70	gnu/lists/Pair
    //   258: goto +10 -> 268
    //   261: aload_2
    //   262: dup
    //   263: astore 5
    //   265: checkcast 70	gnu/lists/Pair
    //   268: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   271: goto +24 -> 295
    //   274: aload_2
    //   275: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   278: ifne +16 -> 294
    //   281: aload_2
    //   282: dup
    //   283: astore 5
    //   285: checkcast 70	gnu/lists/Pair
    //   288: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   291: goto +4 -> 295
    //   294: aload_2
    //   295: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   298: ifeq +253 -> 551
    //   301: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   304: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   307: aload_0
    //   308: astore 7
    //   310: astore 6
    //   312: astore 5
    //   314: aload 7
    //   316: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   319: ifeq +102 -> 421
    //   322: aload 7
    //   324: ldc 70
    //   326: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   329: dup
    //   330: astore 9
    //   332: checkcast 70	gnu/lists/Pair
    //   335: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   338: ldc 43
    //   340: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   343: dup
    //   344: astore 9
    //   346: checkcast 43	java/lang/CharSequence
    //   349: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   352: istore 8
    //   354: iconst_1
    //   355: aload 5
    //   357: iload 8
    //   359: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: aload 6
    //   367: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   370: ifeq +14 -> 384
    //   373: aload 6
    //   375: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   378: ifeq +22 -> 400
    //   381: goto +14 -> 395
    //   384: iload 8
    //   386: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   389: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   392: ifeq +8 -> 400
    //   395: aload 6
    //   397: goto +5 -> 402
    //   400: aload 7
    //   402: aload 7
    //   404: ldc 70
    //   406: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   409: dup
    //   410: astore 9
    //   412: checkcast 70	gnu/lists/Pair
    //   415: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   418: goto -110 -> 308
    //   421: aload 5
    //   423: ldc -79
    //   425: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   428: dup
    //   429: astore 8
    //   431: checkcast 177	java/lang/Number
    //   434: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   437: ifeq +22 -> 459
    //   440: aload_3
    //   441: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   444: iconst_1
    //   445: anewarray 27	java/lang/Object
    //   448: dup
    //   449: iconst_0
    //   450: aload 4
    //   452: aastore
    //   453: invokestatic 914	gnu/kawa/slib/srfi13:substring$SlShared$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   456: goto +207 -> 663
    //   459: aload 4
    //   461: ldc -79
    //   463: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   466: dup
    //   467: astore 8
    //   469: checkcast 177	java/lang/Number
    //   472: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   475: ifeq +63 -> 538
    //   478: aload 5
    //   480: aload 6
    //   482: ldc 70
    //   484: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   487: dup
    //   488: astore 8
    //   490: checkcast 70	gnu/lists/Pair
    //   493: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   496: ldc 43
    //   498: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   501: dup
    //   502: astore 8
    //   504: checkcast 43	java/lang/CharSequence
    //   507: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   510: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   516: ifeq +22 -> 538
    //   519: aload 6
    //   521: ldc 70
    //   523: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   526: dup
    //   527: astore 8
    //   529: checkcast 70	gnu/lists/Pair
    //   532: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   535: goto +128 -> 663
    //   538: aload 5
    //   540: aload 6
    //   542: aload_3
    //   543: aload 4
    //   545: invokestatic 911	gnu/kawa/slib/srfi13:$PcFinishStringConcatenateReverse	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
    //   548: goto +115 -> 663
    //   551: iconst_2
    //   552: anewarray 27	java/lang/Object
    //   555: dup
    //   556: iconst_0
    //   557: ldc_w 340
    //   560: aastore
    //   561: dup
    //   562: iconst_1
    //   563: aload_2
    //   564: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   567: ifne +16 -> 583
    //   570: aload_2
    //   571: dup
    //   572: astore 5
    //   574: checkcast 70	gnu/lists/Pair
    //   577: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   580: goto +4 -> 584
    //   583: aload_2
    //   584: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   587: ifne +47 -> 634
    //   590: aload_2
    //   591: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   594: ifne +27 -> 621
    //   597: aload_2
    //   598: dup
    //   599: astore 5
    //   601: checkcast 70	gnu/lists/Pair
    //   604: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   607: ldc 70
    //   609: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   612: dup
    //   613: astore 5
    //   615: checkcast 70	gnu/lists/Pair
    //   618: goto +10 -> 628
    //   621: aload_2
    //   622: dup
    //   623: astore 5
    //   625: checkcast 70	gnu/lists/Pair
    //   628: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   631: goto +24 -> 655
    //   634: aload_2
    //   635: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   638: ifne +16 -> 654
    //   641: aload_2
    //   642: dup
    //   643: astore 5
    //   645: checkcast 70	gnu/lists/Pair
    //   648: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   651: goto +4 -> 655
    //   654: aload_2
    //   655: aastore
    //   656: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   659: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   662: athrow
    //   663: areturn
    //   664: new 53	gnu/mapping/WrongType
    //   667: dup_x1
    //   668: swap
    //   669: ldc 72
    //   671: iconst_1
    //   672: aload 4
    //   674: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   677: athrow
    //   678: new 53	gnu/mapping/WrongType
    //   681: dup_x1
    //   682: swap
    //   683: ldc 77
    //   685: iconst_1
    //   686: aload 5
    //   688: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   691: athrow
    //   692: new 53	gnu/mapping/WrongType
    //   695: dup_x1
    //   696: swap
    //   697: ldc 77
    //   699: iconst_1
    //   700: aload 5
    //   702: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   705: athrow
    //   706: new 53	gnu/mapping/WrongType
    //   709: dup_x1
    //   710: swap
    //   711: ldc 72
    //   713: iconst_1
    //   714: aload 5
    //   716: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   719: athrow
    //   720: new 53	gnu/mapping/WrongType
    //   723: dup_x1
    //   724: swap
    //   725: ldc 72
    //   727: iconst_1
    //   728: aload 5
    //   730: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   733: athrow
    //   734: new 53	gnu/mapping/WrongType
    //   737: dup_x1
    //   738: swap
    //   739: ldc 55
    //   741: iconst_1
    //   742: aload 5
    //   744: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   747: athrow
    //   748: new 53	gnu/mapping/WrongType
    //   751: dup_x1
    //   752: swap
    //   753: ldc 55
    //   755: iconst_1
    //   756: aload 5
    //   758: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   761: athrow
    //   762: new 53	gnu/mapping/WrongType
    //   765: dup_x1
    //   766: swap
    //   767: ldc 55
    //   769: iconst_1
    //   770: aload 5
    //   772: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   775: athrow
    //   776: new 53	gnu/mapping/WrongType
    //   779: dup_x1
    //   780: swap
    //   781: ldc 77
    //   783: iconst_1
    //   784: aload 5
    //   786: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   789: athrow
    //   790: new 53	gnu/mapping/WrongType
    //   793: dup_x1
    //   794: swap
    //   795: ldc 77
    //   797: iconst_1
    //   798: aload 5
    //   800: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   803: athrow
    //   804: new 53	gnu/mapping/WrongType
    //   807: dup_x1
    //   808: swap
    //   809: ldc 77
    //   811: iconst_1
    //   812: aload 5
    //   814: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   817: athrow
    //   818: new 53	gnu/mapping/WrongType
    //   821: dup_x1
    //   822: swap
    //   823: ldc 77
    //   825: iconst_1
    //   826: aload 5
    //   828: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   831: athrow
    //   832: new 53	gnu/mapping/WrongType
    //   835: dup_x1
    //   836: swap
    //   837: ldc 77
    //   839: iconst_1
    //   840: aload 5
    //   842: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   845: athrow
    //   846: new 53	gnu/mapping/WrongType
    //   849: dup_x1
    //   850: swap
    //   851: ldc 72
    //   853: iconst_1
    //   854: aload 9
    //   856: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   859: athrow
    //   860: new 53	gnu/mapping/WrongType
    //   863: dup_x1
    //   864: swap
    //   865: ldc 55
    //   867: iconst_1
    //   868: aload 9
    //   870: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   873: athrow
    //   874: new 53	gnu/mapping/WrongType
    //   877: dup_x1
    //   878: swap
    //   879: ldc 77
    //   881: iconst_1
    //   882: aload 9
    //   884: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   887: athrow
    //   888: new 53	gnu/mapping/WrongType
    //   891: dup_x1
    //   892: swap
    //   893: ldc_w 590
    //   896: iconst_1
    //   897: aload 8
    //   899: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   902: athrow
    //   903: new 53	gnu/mapping/WrongType
    //   906: dup_x1
    //   907: swap
    //   908: ldc_w 590
    //   911: iconst_1
    //   912: aload 8
    //   914: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   917: athrow
    //   918: new 53	gnu/mapping/WrongType
    //   921: dup_x1
    //   922: swap
    //   923: ldc 72
    //   925: iconst_1
    //   926: aload 8
    //   928: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   931: athrow
    //   932: new 53	gnu/mapping/WrongType
    //   935: dup_x1
    //   936: swap
    //   937: ldc 55
    //   939: iconst_1
    //   940: aload 8
    //   942: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   945: athrow
    //   946: new 53	gnu/mapping/WrongType
    //   949: dup_x1
    //   950: swap
    //   951: ldc 72
    //   953: iconst_1
    //   954: aload 8
    //   956: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   959: athrow
    //   960: new 53	gnu/mapping/WrongType
    //   963: dup_x1
    //   964: swap
    //   965: ldc 77
    //   967: iconst_1
    //   968: aload 5
    //   970: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   973: athrow
    //   974: new 53	gnu/mapping/WrongType
    //   977: dup_x1
    //   978: swap
    //   979: ldc 77
    //   981: iconst_1
    //   982: aload 5
    //   984: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   987: athrow
    //   988: new 53	gnu/mapping/WrongType
    //   991: dup_x1
    //   992: swap
    //   993: ldc 77
    //   995: iconst_1
    //   996: aload 5
    //   998: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1001: athrow
    //   1002: new 53	gnu/mapping/WrongType
    //   1005: dup_x1
    //   1006: swap
    //   1007: ldc 77
    //   1009: iconst_1
    //   1010: aload 5
    //   1012: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1015: athrow
    //   1016: new 53	gnu/mapping/WrongType
    //   1019: dup_x1
    //   1020: swap
    //   1021: ldc 77
    //   1023: iconst_1
    //   1024: aload 5
    //   1026: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1029: athrow
    // Line number table:
    //   Java source line #1686	-> byte code offset #0
    //   Java source line #1687	-> byte code offset #8
    //   Java source line #1688	-> byte code offset #63
    //   Java source line #1687	-> byte code offset #70
    //   Java source line #1688	-> byte code offset #101
    //   Java source line #1687	-> byte code offset #134
    //   Java source line #1689	-> byte code offset #134
    //   Java source line #1690	-> byte code offset #142
    //   Java source line #1691	-> byte code offset #150
    //   Java source line #1687	-> byte code offset #183
    //   Java source line #1688	-> byte code offset #183
    //   Java source line #1687	-> byte code offset #203
    //   Java source line #1695	-> byte code offset #301
    //   Java source line #1696	-> byte code offset #314
    //   Java source line #1697	-> byte code offset #322
    //   Java source line #1698	-> byte code offset #354
    //   Java source line #1699	-> byte code offset #365
    //   Java source line #1700	-> byte code offset #402
    //   Java source line #1702	-> byte code offset #421
    //   Java source line #1706	-> byte code offset #459
    //   Java source line #1707	-> byte code offset #519
    //   Java source line #1709	-> byte code offset #538
    //   Java source line #1687	-> byte code offset #563
    //   Java source line #1688	-> byte code offset #720
    //   Java source line #1691	-> byte code offset #748
    //   Java source line #1688	-> byte code offset #762
    //   Java source line #1687	-> byte code offset #776
    //   Java source line #1697	-> byte code offset #846
    //   Java source line #1700	-> byte code offset #874
    //   Java source line #1702	-> byte code offset #888
    //   Java source line #1706	-> byte code offset #903
    //   Java source line #1707	-> byte code offset #946
    //   Java source line #1687	-> byte code offset #960
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	string$Mnlist	Object
    //   0	663	1	argsArray	Object[]
    //   0	655	2	maybe$Mnfinal$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	512	3	final	Object
    //   17	1	4	localLList2	LList
    //   132	541	4	end	Object
    //   52	232	5	localObject1	Object
    //   312	713	5	len	Object
    //   310	1	6	localBoolean	Boolean
    //   314	227	6	nzlist	Object
    //   308	1	7	localObject2	Object
    //   314	89	7	lis	Object
    //   352	603	8	slen	int
    //   330	553	9	localObject3	Object
    //   664	1	15	localClassCastException1	ClassCastException
    //   678	1	16	localClassCastException2	ClassCastException
    //   692	1	17	localClassCastException3	ClassCastException
    //   706	1	18	localClassCastException4	ClassCastException
    //   720	1	19	localClassCastException5	ClassCastException
    //   734	1	20	localClassCastException6	ClassCastException
    //   748	1	21	localClassCastException7	ClassCastException
    //   762	1	22	localClassCastException8	ClassCastException
    //   776	1	23	localClassCastException9	ClassCastException
    //   790	1	24	localClassCastException10	ClassCastException
    //   804	1	25	localClassCastException11	ClassCastException
    //   818	1	26	localClassCastException12	ClassCastException
    //   832	1	27	localClassCastException13	ClassCastException
    //   846	1	28	localClassCastException14	ClassCastException
    //   860	1	29	localClassCastException15	ClassCastException
    //   874	1	30	localClassCastException16	ClassCastException
    //   888	1	31	localClassCastException17	ClassCastException
    //   903	1	32	localClassCastException18	ClassCastException
    //   918	1	33	localClassCastException19	ClassCastException
    //   932	1	34	localClassCastException20	ClassCastException
    //   946	1	35	localClassCastException21	ClassCastException
    //   960	1	36	localClassCastException22	ClassCastException
    //   974	1	37	localClassCastException23	ClassCastException
    //   988	1	38	localClassCastException24	ClassCastException
    //   1002	1	39	localClassCastException25	ClassCastException
    //   1016	1	40	localClassCastException26	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	664	java/lang/ClassCastException
    //   54	57	678	java/lang/ClassCastException
    //   81	84	692	java/lang/ClassCastException
    //   95	98	706	java/lang/ClassCastException
    //   105	108	720	java/lang/ClassCastException
    //   123	126	734	java/lang/ClassCastException
    //   164	167	748	java/lang/ClassCastException
    //   192	195	762	java/lang/ClassCastException
    //   214	217	776	java/lang/ClassCastException
    //   241	244	790	java/lang/ClassCastException
    //   255	258	804	java/lang/ClassCastException
    //   265	268	818	java/lang/ClassCastException
    //   285	288	832	java/lang/ClassCastException
    //   332	335	846	java/lang/ClassCastException
    //   346	349	860	java/lang/ClassCastException
    //   412	415	874	java/lang/ClassCastException
    //   431	434	888	java/lang/ClassCastException
    //   469	472	903	java/lang/ClassCastException
    //   490	493	918	java/lang/ClassCastException
    //   504	507	932	java/lang/ClassCastException
    //   529	532	946	java/lang/ClassCastException
    //   574	577	960	java/lang/ClassCastException
    //   601	604	974	java/lang/ClassCastException
    //   615	618	988	java/lang/ClassCastException
    //   625	628	1002	java/lang/ClassCastException
    //   645	648	1016	java/lang/ClassCastException
  }
  
  /* Error */
  public static FString stringReplace$V(Object s1, Object s2, Object start1, Object end1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload 4
    //   2: iconst_0
    //   3: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   6: dup
    //   7: astore 6
    //   9: astore 5
    //   11: getstatic 917	gnu/kawa/slib/srfi13:string$Mnreplace	Lgnu/expr/ModuleMethod;
    //   14: aload_0
    //   15: aload_2
    //   16: aload_3
    //   17: invokestatic 921	gnu/kawa/slib/srfi13:checkSubstringSpec	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   20: getstatic 917	gnu/kawa/slib/srfi13:string$Mnreplace	Lgnu/expr/ModuleMethod;
    //   23: aload_1
    //   24: aload 5
    //   26: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   29: astore 6
    //   31: iconst_0
    //   32: istore 7
    //   34: aload 6
    //   36: iload 7
    //   38: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   41: istore 7
    //   43: aload 6
    //   45: iload 7
    //   47: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   50: astore 8
    //   52: aload 6
    //   54: iload 7
    //   56: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   59: istore 7
    //   61: aload 6
    //   63: iload 7
    //   65: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   68: astore 9
    //   70: aload_0
    //   71: ldc 43
    //   73: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   76: dup
    //   77: astore 11
    //   79: checkcast 43	java/lang/CharSequence
    //   82: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   85: istore 10
    //   87: iconst_m1
    //   88: aload 9
    //   90: aload 8
    //   92: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: astore 11
    //   97: iconst_1
    //   98: iconst_m1
    //   99: iload 10
    //   101: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: iconst_m1
    //   105: aload_3
    //   106: aload_2
    //   107: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: aload 11
    //   115: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: astore 12
    //   120: aload 12
    //   122: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: dup
    //   126: astore 14
    //   128: checkcast 177	java/lang/Number
    //   131: invokevirtual 181	java/lang/Number:intValue	()I
    //   134: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   137: astore 13
    //   139: aload 13
    //   141: iconst_0
    //   142: aload_0
    //   143: ldc 43
    //   145: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   148: dup
    //   149: astore 14
    //   151: checkcast 43	java/lang/CharSequence
    //   154: iconst_0
    //   155: aload_2
    //   156: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   159: dup
    //   160: astore 14
    //   162: checkcast 177	java/lang/Number
    //   165: invokevirtual 181	java/lang/Number:intValue	()I
    //   168: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   171: aload 13
    //   173: aload_2
    //   174: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   177: dup
    //   178: astore 14
    //   180: checkcast 177	java/lang/Number
    //   183: invokevirtual 181	java/lang/Number:intValue	()I
    //   186: aload_1
    //   187: ldc 43
    //   189: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   192: dup
    //   193: astore 14
    //   195: checkcast 43	java/lang/CharSequence
    //   198: aload 8
    //   200: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: dup
    //   204: astore 14
    //   206: checkcast 177	java/lang/Number
    //   209: invokevirtual 181	java/lang/Number:intValue	()I
    //   212: aload 9
    //   214: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: dup
    //   218: astore 14
    //   220: checkcast 177	java/lang/Number
    //   223: invokevirtual 181	java/lang/Number:intValue	()I
    //   226: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   229: aload 13
    //   231: iconst_1
    //   232: aload_2
    //   233: aload 11
    //   235: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: dup
    //   242: astore 14
    //   244: checkcast 177	java/lang/Number
    //   247: invokevirtual 181	java/lang/Number:intValue	()I
    //   250: aload_0
    //   251: ldc 43
    //   253: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   256: dup
    //   257: astore 14
    //   259: checkcast 43	java/lang/CharSequence
    //   262: aload_3
    //   263: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   266: dup
    //   267: astore 14
    //   269: checkcast 177	java/lang/Number
    //   272: invokevirtual 181	java/lang/Number:intValue	()I
    //   275: iload 10
    //   277: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   280: aload 13
    //   282: areturn
    //   283: new 53	gnu/mapping/WrongType
    //   286: dup_x1
    //   287: swap
    //   288: ldc 55
    //   290: iconst_1
    //   291: aload 11
    //   293: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: new 53	gnu/mapping/WrongType
    //   300: dup_x1
    //   301: swap
    //   302: ldc -36
    //   304: iconst_1
    //   305: aload 14
    //   307: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   310: athrow
    //   311: new 53	gnu/mapping/WrongType
    //   314: dup_x1
    //   315: swap
    //   316: ldc_w 334
    //   319: iconst_3
    //   320: aload 14
    //   322: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   325: athrow
    //   326: new 53	gnu/mapping/WrongType
    //   329: dup_x1
    //   330: swap
    //   331: ldc_w 334
    //   334: iconst_5
    //   335: aload 14
    //   337: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   340: athrow
    //   341: new 53	gnu/mapping/WrongType
    //   344: dup_x1
    //   345: swap
    //   346: ldc_w 334
    //   349: iconst_2
    //   350: aload 14
    //   352: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   355: athrow
    //   356: new 53	gnu/mapping/WrongType
    //   359: dup_x1
    //   360: swap
    //   361: ldc_w 334
    //   364: iconst_3
    //   365: aload 14
    //   367: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   370: athrow
    //   371: new 53	gnu/mapping/WrongType
    //   374: dup_x1
    //   375: swap
    //   376: ldc_w 334
    //   379: iconst_4
    //   380: aload 14
    //   382: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   385: athrow
    //   386: new 53	gnu/mapping/WrongType
    //   389: dup_x1
    //   390: swap
    //   391: ldc_w 334
    //   394: iconst_5
    //   395: aload 14
    //   397: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   400: athrow
    //   401: new 53	gnu/mapping/WrongType
    //   404: dup_x1
    //   405: swap
    //   406: ldc_w 334
    //   409: iconst_2
    //   410: aload 14
    //   412: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   415: athrow
    //   416: new 53	gnu/mapping/WrongType
    //   419: dup_x1
    //   420: swap
    //   421: ldc_w 334
    //   424: iconst_3
    //   425: aload 14
    //   427: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   430: athrow
    //   431: new 53	gnu/mapping/WrongType
    //   434: dup_x1
    //   435: swap
    //   436: ldc_w 334
    //   439: iconst_4
    //   440: aload 14
    //   442: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   445: athrow
    // Line number table:
    //   Java source line #1731	-> byte code offset #0
    //   Java source line #1732	-> byte code offset #11
    //   Java source line #1733	-> byte code offset #20
    //   Java source line #1734	-> byte code offset #70
    //   Java source line #1735	-> byte code offset #87
    //   Java source line #1734	-> byte code offset #97
    //   Java source line #1736	-> byte code offset #97
    //   Java source line #1734	-> byte code offset #120
    //   Java source line #1737	-> byte code offset #120
    //   Java source line #1738	-> byte code offset #139
    //   Java source line #1739	-> byte code offset #171
    //   Java source line #1740	-> byte code offset #229
    //   Java source line #1741	-> byte code offset #280
    //   Java source line #1734	-> byte code offset #283
    //   Java source line #1737	-> byte code offset #297
    //   Java source line #1738	-> byte code offset #311
    //   Java source line #1739	-> byte code offset #341
    //   Java source line #1740	-> byte code offset #401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	s1	Object
    //   0	282	1	s2	Object
    //   0	282	2	start1	Object
    //   0	282	3	end1	Object
    //   0	282	4	argsArray	Object[]
    //   0	25	5	maybe$Mnstart$Plend	LList
    //   7	55	6	localObject1	Object
    //   32	32	7	i	int
    //   50	1	8	localObject2	Object
    //   70	129	8	start2	Object
    //   68	145	9	end2	Object
    //   85	191	10	slen1	int
    //   77	1	11	localObject3	Object
    //   95	197	11	sublen2	Object
    //   118	3	12	alen	Object
    //   137	144	13	ans	FString
    //   126	315	14	localObject4	Object
    //   283	1	17	localClassCastException1	ClassCastException
    //   297	1	18	localClassCastException2	ClassCastException
    //   311	1	19	localClassCastException3	ClassCastException
    //   326	1	20	localClassCastException4	ClassCastException
    //   341	1	21	localClassCastException5	ClassCastException
    //   356	1	22	localClassCastException6	ClassCastException
    //   371	1	23	localClassCastException7	ClassCastException
    //   386	1	24	localClassCastException8	ClassCastException
    //   401	1	25	localClassCastException9	ClassCastException
    //   416	1	26	localClassCastException10	ClassCastException
    //   431	1	27	localClassCastException11	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   79	82	283	java/lang/ClassCastException
    //   128	134	297	java/lang/ClassCastException
    //   151	154	311	java/lang/ClassCastException
    //   162	168	326	java/lang/ClassCastException
    //   180	186	341	java/lang/ClassCastException
    //   195	198	356	java/lang/ClassCastException
    //   206	212	371	java/lang/ClassCastException
    //   220	226	386	java/lang/ClassCastException
    //   244	250	401	java/lang/ClassCastException
    //   259	262	416	java/lang/ClassCastException
    //   269	275	431	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTokenize$V(Object s, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifne +16 -> 28
    //   15: aload_2
    //   16: dup
    //   17: astore 4
    //   19: checkcast 70	gnu/lists/Pair
    //   22: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   25: goto +6 -> 31
    //   28: getstatic 924	gnu/kawa/slib/srfi14$CharSet:graphic	Lgnu/kawa/slib/srfi14$CharSet;
    //   31: astore_3
    //   32: aload_3
    //   33: astore 4
    //   35: aload 4
    //   37: instanceof 371
    //   40: ifne +7 -> 47
    //   43: getstatic 924	gnu/kawa/slib/srfi14$CharSet:graphic	Lgnu/kawa/slib/srfi14$CharSet;
    //   46: astore_3
    //   47: aload_2
    //   48: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   51: ifne +16 -> 67
    //   54: aload_2
    //   55: dup
    //   56: astore 5
    //   58: checkcast 70	gnu/lists/Pair
    //   61: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   64: goto +4 -> 68
    //   67: aload_2
    //   68: astore 4
    //   70: getstatic 927	gnu/kawa/slib/srfi13:string$Mntokenize	Lgnu/expr/ModuleMethod;
    //   73: aload_0
    //   74: aload 4
    //   76: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   79: astore 5
    //   81: iconst_0
    //   82: istore 6
    //   84: aload 5
    //   86: iload 6
    //   88: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   91: istore 6
    //   93: aload 5
    //   95: iload 6
    //   97: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   100: astore 7
    //   102: aload 5
    //   104: iload 6
    //   106: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   109: istore 6
    //   111: aload 5
    //   113: iload 6
    //   115: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   118: astore 8
    //   120: aload 8
    //   122: getstatic 141	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   125: astore 10
    //   127: astore 9
    //   129: aload 7
    //   131: aload 9
    //   133: invokestatic 230	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   136: ifeq +25 -> 161
    //   139: aload_0
    //   140: aload_3
    //   141: iconst_2
    //   142: anewarray 27	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload 7
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload 9
    //   154: aastore
    //   155: invokestatic 930	gnu/kawa/slib/srfi13:stringIndexRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   158: goto +6 -> 164
    //   161: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   164: astore 11
    //   166: aload 11
    //   168: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   171: ifeq +154 -> 325
    //   174: iconst_1
    //   175: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   178: aload 11
    //   180: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: astore 12
    //   185: aload_0
    //   186: aload_3
    //   187: iconst_2
    //   188: anewarray 27	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload 7
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload 11
    //   200: aastore
    //   201: invokestatic 717	gnu/kawa/slib/srfi13:stringSkipRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   204: astore 13
    //   206: aload 13
    //   208: invokestatic 309	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   211: ifeq +63 -> 274
    //   214: aload 13
    //   216: aload_0
    //   217: ldc 43
    //   219: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   222: dup
    //   223: astore 14
    //   225: checkcast 43	java/lang/CharSequence
    //   228: iconst_1
    //   229: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   232: aload 13
    //   234: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   240: dup
    //   241: astore 14
    //   243: checkcast 177	java/lang/Number
    //   246: invokevirtual 181	java/lang/Number:intValue	()I
    //   249: aload 12
    //   251: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   254: dup
    //   255: astore 14
    //   257: checkcast 177	java/lang/Number
    //   260: invokevirtual 181	java/lang/Number:intValue	()I
    //   263: invokestatic 196	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   266: aload 10
    //   268: invokestatic 330	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   271: goto -146 -> 125
    //   274: aload_0
    //   275: ldc 43
    //   277: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   280: dup
    //   281: astore 14
    //   283: checkcast 43	java/lang/CharSequence
    //   286: aload 7
    //   288: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: dup
    //   292: astore 14
    //   294: checkcast 177	java/lang/Number
    //   297: invokevirtual 181	java/lang/Number:intValue	()I
    //   300: aload 12
    //   302: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   305: dup
    //   306: astore 14
    //   308: checkcast 177	java/lang/Number
    //   311: invokevirtual 181	java/lang/Number:intValue	()I
    //   314: invokestatic 196	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   317: aload 10
    //   319: invokestatic 330	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   322: goto +5 -> 327
    //   325: aload 10
    //   327: areturn
    //   328: new 53	gnu/mapping/WrongType
    //   331: dup_x1
    //   332: swap
    //   333: ldc 72
    //   335: iconst_1
    //   336: aload 4
    //   338: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   341: athrow
    //   342: new 53	gnu/mapping/WrongType
    //   345: dup_x1
    //   346: swap
    //   347: ldc 77
    //   349: iconst_1
    //   350: aload 5
    //   352: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   355: athrow
    //   356: new 53	gnu/mapping/WrongType
    //   359: dup_x1
    //   360: swap
    //   361: ldc_w 650
    //   364: iconst_1
    //   365: aload 14
    //   367: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   370: athrow
    //   371: new 53	gnu/mapping/WrongType
    //   374: dup_x1
    //   375: swap
    //   376: ldc_w 650
    //   379: iconst_2
    //   380: aload 14
    //   382: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   385: athrow
    //   386: new 53	gnu/mapping/WrongType
    //   389: dup_x1
    //   390: swap
    //   391: ldc_w 650
    //   394: iconst_3
    //   395: aload 14
    //   397: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   400: athrow
    //   401: new 53	gnu/mapping/WrongType
    //   404: dup_x1
    //   405: swap
    //   406: ldc_w 650
    //   409: iconst_1
    //   410: aload 14
    //   412: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   415: athrow
    //   416: new 53	gnu/mapping/WrongType
    //   419: dup_x1
    //   420: swap
    //   421: ldc_w 650
    //   424: iconst_2
    //   425: aload 14
    //   427: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   430: athrow
    //   431: new 53	gnu/mapping/WrongType
    //   434: dup_x1
    //   435: swap
    //   436: ldc_w 650
    //   439: iconst_3
    //   440: aload 14
    //   442: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   445: athrow
    // Line number table:
    //   Java source line #1750	-> byte code offset #0
    //   Java source line #1751	-> byte code offset #8
    //   Java source line #1752	-> byte code offset #28
    //   Java source line #1751	-> byte code offset #32
    //   Java source line #1752	-> byte code offset #32
    //   Java source line #1751	-> byte code offset #43
    //   Java source line #1752	-> byte code offset #67
    //   Java source line #1753	-> byte code offset #70
    //   Java source line #1754	-> byte code offset #120
    //   Java source line #1755	-> byte code offset #129
    //   Java source line #10000	-> byte code offset #174
    //   Java source line #1757	-> byte code offset #174
    //   Java source line #1758	-> byte code offset #185
    //   Java source line #10000	-> byte code offset #214
    //   Java source line #1760	-> byte code offset #214
    //   Java source line #1761	-> byte code offset #216
    //   Java source line #1762	-> byte code offset #266
    //   Java source line #1763	-> byte code offset #274
    //   Java source line #1764	-> byte code offset #325
    //   Java source line #1751	-> byte code offset #328
    //   Java source line #1761	-> byte code offset #356
    //   Java source line #1763	-> byte code offset #401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	s	Object
    //   0	327	1	argsArray	Object[]
    //   0	68	2	token$Mnchars$Plstart$Plend	LList
    //   6	1	3	localLList1	LList
    //   31	156	3	token$Mnchars	Object
    //   17	19	4	localObject1	Object
    //   68	269	4	rest	Object
    //   56	295	5	localObject2	Object
    //   82	32	6	i	int
    //   100	1	7	localObject3	Object
    //   120	167	7	start	Object
    //   118	3	8	end	Object
    //   127	26	9	i	Object
    //   125	1	10	localEmptyList	gnu.lists.EmptyList
    //   129	197	10	ans	Object
    //   164	35	11	temp	Object
    //   183	118	12	tend	Object
    //   204	29	13	temp	Object
    //   223	218	14	localObject4	Object
    //   328	1	19	localClassCastException1	ClassCastException
    //   342	1	20	localClassCastException2	ClassCastException
    //   356	1	21	localClassCastException3	ClassCastException
    //   371	1	22	localClassCastException4	ClassCastException
    //   386	1	23	localClassCastException5	ClassCastException
    //   401	1	24	localClassCastException6	ClassCastException
    //   416	1	25	localClassCastException7	ClassCastException
    //   431	1	26	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	328	java/lang/ClassCastException
    //   58	61	342	java/lang/ClassCastException
    //   225	228	356	java/lang/ClassCastException
    //   243	249	371	java/lang/ClassCastException
    //   257	263	386	java/lang/ClassCastException
    //   283	286	401	java/lang/ClassCastException
    //   294	300	416	java/lang/ClassCastException
    //   308	314	431	java/lang/ClassCastException
  }
  
  /* Error */
  public static CharSequence xsubstring$V(Object s, Object from, Object[] argsArray)
  {
    // Byte code:
    //   0: new 932	gnu/kawa/slib/srfi13$frame6
    //   3: dup
    //   4: invokespecial 933	gnu/kawa/slib/srfi13$frame6:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: putfield 936	gnu/kawa/slib/srfi13$frame6:from	Ljava/lang/Object;
    //   15: aload_2
    //   16: iconst_0
    //   17: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   20: dup
    //   21: astore 5
    //   23: astore_3
    //   24: getstatic 939	gnu/kawa/slib/srfi13:lambda$Fn39	Lgnu/expr/ModuleMethod;
    //   27: aload 4
    //   29: getfield 936	gnu/kawa/slib/srfi13$frame6:from	Ljava/lang/Object;
    //   32: getstatic 942	gnu/kawa/slib/srfi13:xsubstring	Lgnu/expr/ModuleMethod;
    //   35: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: pop
    //   39: aload_3
    //   40: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   43: ifeq +112 -> 155
    //   46: getstatic 942	gnu/kawa/slib/srfi13:xsubstring	Lgnu/expr/ModuleMethod;
    //   49: aload_0
    //   50: aload_3
    //   51: dup
    //   52: astore 7
    //   54: checkcast 70	gnu/lists/Pair
    //   57: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   60: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   63: astore 6
    //   65: iconst_0
    //   66: istore 7
    //   68: aload 6
    //   70: iload 7
    //   72: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   75: istore 7
    //   77: aload 6
    //   79: iload 7
    //   81: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   84: astore 8
    //   86: aload 6
    //   88: iload 7
    //   90: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   93: istore 7
    //   95: aload 6
    //   97: iload 7
    //   99: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   102: astore 9
    //   104: aload_3
    //   105: dup
    //   106: astore 11
    //   108: checkcast 70	gnu/lists/Pair
    //   111: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   114: astore 10
    //   116: aload 4
    //   118: getfield 945	gnu/kawa/slib/srfi13$frame6:lambda$Fn40	Lgnu/expr/ModuleMethod;
    //   121: aload 10
    //   123: getstatic 942	gnu/kawa/slib/srfi13:xsubstring	Lgnu/expr/ModuleMethod;
    //   126: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: iconst_3
    //   131: anewarray 27	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload 10
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload 8
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: aload 9
    //   148: aastore
    //   149: invokestatic 131	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   152: goto +67 -> 219
    //   155: getstatic 161	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   158: aload_0
    //   159: getstatic 942	gnu/kawa/slib/srfi13:xsubstring	Lgnu/expr/ModuleMethod;
    //   162: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: ldc 43
    //   167: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   170: dup
    //   171: astore 7
    //   173: checkcast 43	java/lang/CharSequence
    //   176: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   179: istore 6
    //   181: iconst_3
    //   182: anewarray 27	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: iconst_1
    //   188: aload 4
    //   190: getfield 936	gnu/kawa/slib/srfi13$frame6:from	Ljava/lang/Object;
    //   193: iload 6
    //   195: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   207: aastore
    //   208: dup
    //   209: iconst_2
    //   210: iload 6
    //   212: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aastore
    //   216: invokestatic 131	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   219: astore 5
    //   221: iconst_0
    //   222: istore 6
    //   224: aload 5
    //   226: iload 6
    //   228: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   231: istore 6
    //   233: aload 5
    //   235: iload 6
    //   237: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   240: astore 7
    //   242: aload 5
    //   244: iload 6
    //   246: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   249: istore 6
    //   251: aload 5
    //   253: iload 6
    //   255: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   258: astore 8
    //   260: aload 5
    //   262: iload 6
    //   264: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   267: istore 6
    //   269: aload 5
    //   271: iload 6
    //   273: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   276: astore 9
    //   278: iconst_m1
    //   279: aload 9
    //   281: aload 8
    //   283: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: astore 10
    //   288: iconst_m1
    //   289: aload 7
    //   291: aload 4
    //   293: getfield 936	gnu/kawa/slib/srfi13$frame6:from	Ljava/lang/Object;
    //   296: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   299: astore 11
    //   301: aload 11
    //   303: ldc -79
    //   305: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   308: dup
    //   309: astore 12
    //   311: checkcast 177	java/lang/Number
    //   314: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   317: ifeq +9 -> 326
    //   320: ldc_w 290
    //   323: goto +316 -> 639
    //   326: aload 10
    //   328: ldc -79
    //   330: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   333: dup
    //   334: astore 12
    //   336: checkcast 177	java/lang/Number
    //   339: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   342: ifeq +55 -> 397
    //   345: bipush 7
    //   347: anewarray 27	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: ldc_w 947
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: getstatic 942	gnu/kawa/slib/srfi13:xsubstring	Lgnu/expr/ModuleMethod;
    //   361: aastore
    //   362: dup
    //   363: iconst_2
    //   364: aload_0
    //   365: aastore
    //   366: dup
    //   367: iconst_3
    //   368: aload 4
    //   370: getfield 936	gnu/kawa/slib/srfi13$frame6:from	Ljava/lang/Object;
    //   373: aastore
    //   374: dup
    //   375: iconst_4
    //   376: aload 7
    //   378: aastore
    //   379: dup
    //   380: iconst_5
    //   381: aload 8
    //   383: aastore
    //   384: dup
    //   385: bipush 6
    //   387: aload 9
    //   389: aastore
    //   390: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   393: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   396: athrow
    //   397: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   400: aload 10
    //   402: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   405: ifeq +52 -> 457
    //   408: aload 11
    //   410: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   413: dup
    //   414: astore 12
    //   416: checkcast 177	java/lang/Number
    //   419: invokevirtual 181	java/lang/Number:intValue	()I
    //   422: aload_0
    //   423: ldc 43
    //   425: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   428: dup
    //   429: astore 12
    //   431: checkcast 43	java/lang/CharSequence
    //   434: aload 8
    //   436: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   439: dup
    //   440: astore 12
    //   442: checkcast 177	java/lang/Number
    //   445: invokevirtual 181	java/lang/Number:intValue	()I
    //   448: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   451: invokestatic 733	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   454: goto +185 -> 639
    //   457: getstatic 950	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   460: aload 4
    //   462: getfield 936	gnu/kawa/slib/srfi13$frame6:from	Ljava/lang/Object;
    //   465: aload 10
    //   467: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   470: ldc_w 952
    //   473: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   476: dup
    //   477: astore 12
    //   479: invokestatic 958	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   482: invokestatic 963	kawa/lib/numbers:floor	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   485: invokevirtual 967	java/lang/Number:doubleValue	()D
    //   488: getstatic 950	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   491: aload 7
    //   493: aload 10
    //   495: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   498: ldc_w 952
    //   501: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   504: dup
    //   505: astore 12
    //   507: invokestatic 958	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   510: invokestatic 963	kawa/lib/numbers:floor	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   513: invokevirtual 967	java/lang/Number:doubleValue	()D
    //   516: dcmpg
    //   517: ifne +80 -> 597
    //   520: aload_0
    //   521: ldc 43
    //   523: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   526: dup
    //   527: astore 12
    //   529: checkcast 43	java/lang/CharSequence
    //   532: iconst_1
    //   533: aload 8
    //   535: getstatic 570	gnu/kawa/functions/DivideOp:modulo	Lgnu/kawa/functions/DivideOp;
    //   538: aload 4
    //   540: getfield 936	gnu/kawa/slib/srfi13$frame6:from	Ljava/lang/Object;
    //   543: aload 10
    //   545: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   548: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   551: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   554: dup
    //   555: astore 12
    //   557: checkcast 177	java/lang/Number
    //   560: invokevirtual 181	java/lang/Number:intValue	()I
    //   563: iconst_1
    //   564: aload 8
    //   566: getstatic 570	gnu/kawa/functions/DivideOp:modulo	Lgnu/kawa/functions/DivideOp;
    //   569: aload 7
    //   571: aload 10
    //   573: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   576: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   582: dup
    //   583: astore 12
    //   585: checkcast 177	java/lang/Number
    //   588: invokevirtual 181	java/lang/Number:intValue	()I
    //   591: invokestatic 196	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   594: goto +45 -> 639
    //   597: aload 11
    //   599: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   602: dup
    //   603: astore 13
    //   605: checkcast 177	java/lang/Number
    //   608: invokevirtual 181	java/lang/Number:intValue	()I
    //   611: invokestatic 224	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   614: astore 12
    //   616: aload 12
    //   618: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   621: aload_0
    //   622: aload 4
    //   624: getfield 936	gnu/kawa/slib/srfi13$frame6:from	Ljava/lang/Object;
    //   627: aload 7
    //   629: aload 8
    //   631: aload 9
    //   633: invokestatic 970	gnu/kawa/slib/srfi13:$PcMultispanRepcopy$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   636: pop
    //   637: aload 12
    //   639: areturn
    //   640: new 53	gnu/mapping/WrongType
    //   643: dup_x1
    //   644: swap
    //   645: ldc 77
    //   647: iconst_1
    //   648: aload 7
    //   650: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   653: athrow
    //   654: new 53	gnu/mapping/WrongType
    //   657: dup_x1
    //   658: swap
    //   659: ldc 72
    //   661: iconst_1
    //   662: aload 11
    //   664: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   667: athrow
    //   668: new 53	gnu/mapping/WrongType
    //   671: dup_x1
    //   672: swap
    //   673: ldc 55
    //   675: iconst_1
    //   676: aload 7
    //   678: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   681: athrow
    //   682: new 53	gnu/mapping/WrongType
    //   685: dup_x1
    //   686: swap
    //   687: ldc_w 590
    //   690: iconst_1
    //   691: aload 12
    //   693: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   696: athrow
    //   697: new 53	gnu/mapping/WrongType
    //   700: dup_x1
    //   701: swap
    //   702: ldc_w 590
    //   705: iconst_1
    //   706: aload 12
    //   708: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   711: athrow
    //   712: new 53	gnu/mapping/WrongType
    //   715: dup_x1
    //   716: swap
    //   717: ldc -36
    //   719: iconst_1
    //   720: aload 12
    //   722: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   725: athrow
    //   726: new 53	gnu/mapping/WrongType
    //   729: dup_x1
    //   730: swap
    //   731: ldc -16
    //   733: iconst_1
    //   734: aload 12
    //   736: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   739: athrow
    //   740: new 53	gnu/mapping/WrongType
    //   743: dup_x1
    //   744: swap
    //   745: ldc -16
    //   747: iconst_2
    //   748: aload 12
    //   750: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   753: athrow
    //   754: new 53	gnu/mapping/WrongType
    //   757: dup_x1
    //   758: swap
    //   759: ldc_w 960
    //   762: iconst_1
    //   763: aload 12
    //   765: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   768: athrow
    //   769: new 53	gnu/mapping/WrongType
    //   772: dup_x1
    //   773: swap
    //   774: ldc_w 960
    //   777: iconst_1
    //   778: aload 12
    //   780: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   783: athrow
    //   784: new 53	gnu/mapping/WrongType
    //   787: dup_x1
    //   788: swap
    //   789: ldc_w 650
    //   792: iconst_1
    //   793: aload 12
    //   795: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   798: athrow
    //   799: new 53	gnu/mapping/WrongType
    //   802: dup_x1
    //   803: swap
    //   804: ldc_w 650
    //   807: iconst_2
    //   808: aload 12
    //   810: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   813: athrow
    //   814: new 53	gnu/mapping/WrongType
    //   817: dup_x1
    //   818: swap
    //   819: ldc_w 650
    //   822: iconst_3
    //   823: aload 12
    //   825: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   828: athrow
    //   829: new 53	gnu/mapping/WrongType
    //   832: dup_x1
    //   833: swap
    //   834: ldc -36
    //   836: iconst_1
    //   837: aload 13
    //   839: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   842: athrow
    // Line number table:
    //   Java source line #1794	-> byte code offset #0
    //   Java source line #1795	-> byte code offset #24
    //   Java source line #1796	-> byte code offset #27
    //   Java source line #1798	-> byte code offset #39
    //   Java source line #1799	-> byte code offset #46
    //   Java source line #1800	-> byte code offset #104
    //   Java source line #1801	-> byte code offset #116
    //   Java source line #1804	-> byte code offset #121
    //   Java source line #1805	-> byte code offset #130
    //   Java source line #1806	-> byte code offset #155
    //   Java source line #1807	-> byte code offset #181
    //   Java source line #1808	-> byte code offset #278
    //   Java source line #1809	-> byte code offset #288
    //   Java source line #1810	-> byte code offset #301
    //   Java source line #1811	-> byte code offset #326
    //   Java source line #1814	-> byte code offset #397
    //   Java source line #1815	-> byte code offset #408
    //   Java source line #1818	-> byte code offset #457
    //   Java source line #1819	-> byte code offset #520
    //   Java source line #1820	-> byte code offset #563
    //   Java source line #1823	-> byte code offset #597
    //   Java source line #1824	-> byte code offset #616
    //   Java source line #1825	-> byte code offset #637
    //   Java source line #1799	-> byte code offset #640
    //   Java source line #1800	-> byte code offset #654
    //   Java source line #1806	-> byte code offset #668
    //   Java source line #1810	-> byte code offset #682
    //   Java source line #1811	-> byte code offset #697
    //   Java source line #1815	-> byte code offset #712
    //   Java source line #1818	-> byte code offset #754
    //   Java source line #1819	-> byte code offset #784
    //   Java source line #1820	-> byte code offset #814
    //   Java source line #1823	-> byte code offset #829
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	s	Object
    //   0	639	1	from	Object
    //   0	639	2	argsArray	Object[]
    //   0	105	3	maybe$Mnto$Plstart$Plend	LList
    //   7	616	4	$heapFrame	frame6
    //   21	249	5	localObject1	Object
    //   63	33	6	localValues	Values
    //   179	93	6	slen	int
    //   52	1	7	localLList1	LList
    //   66	32	7	i	int
    //   171	70	7	localObject2	Object
    //   278	399	7	to	Object
    //   84	1	8	localObject3	Object
    //   104	155	8	start	Object
    //   278	352	8	start	Object
    //   102	45	9	end	Object
    //   276	356	9	end	Object
    //   114	173	10	to	Object
    //   301	271	10	slen	Object
    //   106	1	11	localLList2	LList
    //   299	364	11	anslen	Object
    //   309	275	12	localObject4	Object
    //   614	210	12	ans	FString
    //   603	235	13	localObject5	Object
    //   640	1	24	localClassCastException1	ClassCastException
    //   654	1	25	localClassCastException2	ClassCastException
    //   668	1	26	localClassCastException3	ClassCastException
    //   682	1	27	localClassCastException4	ClassCastException
    //   697	1	28	localClassCastException5	ClassCastException
    //   712	1	29	localClassCastException6	ClassCastException
    //   726	1	30	localClassCastException7	ClassCastException
    //   740	1	31	localClassCastException8	ClassCastException
    //   754	1	32	localClassCastException9	ClassCastException
    //   769	1	33	localClassCastException10	ClassCastException
    //   784	1	34	localClassCastException11	ClassCastException
    //   799	1	35	localClassCastException12	ClassCastException
    //   814	1	36	localClassCastException13	ClassCastException
    //   829	1	37	localClassCastException14	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   54	57	640	java/lang/ClassCastException
    //   108	111	654	java/lang/ClassCastException
    //   173	176	668	java/lang/ClassCastException
    //   311	314	682	java/lang/ClassCastException
    //   336	339	697	java/lang/ClassCastException
    //   416	422	712	java/lang/ClassCastException
    //   431	434	726	java/lang/ClassCastException
    //   442	448	740	java/lang/ClassCastException
    //   479	482	754	java/lang/ClassCastException
    //   507	510	769	java/lang/ClassCastException
    //   529	532	784	java/lang/ClassCastException
    //   557	563	799	java/lang/ClassCastException
    //   585	591	814	java/lang/ClassCastException
    //   605	611	829	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcMultispanRepcopy$Ex(Object target, Object tstart, Object s, Object sfrom, Object sto, Object start, Object end)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload 6
    //   3: aload 5
    //   5: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore 7
    //   10: iconst_1
    //   11: aload 5
    //   13: getstatic 570	gnu/kawa/functions/DivideOp:modulo	Lgnu/kawa/functions/DivideOp;
    //   16: aload_3
    //   17: aload 7
    //   19: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   22: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: astore 8
    //   27: iconst_m1
    //   28: aload 4
    //   30: aload_3
    //   31: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: astore 9
    //   36: aload_0
    //   37: ldc_w 332
    //   40: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   43: dup
    //   44: astore 10
    //   46: checkcast 332	gnu/lists/FString
    //   49: aload_1
    //   50: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: dup
    //   54: astore 10
    //   56: checkcast 177	java/lang/Number
    //   59: invokevirtual 181	java/lang/Number:intValue	()I
    //   62: aload_2
    //   63: ldc 43
    //   65: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   68: dup
    //   69: astore 10
    //   71: checkcast 43	java/lang/CharSequence
    //   74: aload 8
    //   76: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: dup
    //   80: astore 10
    //   82: checkcast 177	java/lang/Number
    //   85: invokevirtual 181	java/lang/Number:intValue	()I
    //   88: aload 6
    //   90: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: dup
    //   94: astore 10
    //   96: checkcast 177	java/lang/Number
    //   99: invokevirtual 181	java/lang/Number:intValue	()I
    //   102: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   105: iconst_m1
    //   106: aload 6
    //   108: aload 8
    //   110: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: astore 10
    //   115: iconst_m1
    //   116: aload 9
    //   118: aload 10
    //   120: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: astore 11
    //   125: getstatic 988	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
    //   128: aload 11
    //   130: aload 7
    //   132: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: astore 12
    //   137: iconst_1
    //   138: aload_1
    //   139: aload 10
    //   141: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: aload 12
    //   146: astore 14
    //   148: astore 13
    //   150: aload 14
    //   152: ldc -79
    //   154: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   157: dup
    //   158: astore 15
    //   160: checkcast 177	java/lang/Number
    //   163: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   166: ifne +93 -> 259
    //   169: aload_0
    //   170: ldc_w 332
    //   173: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   176: dup
    //   177: astore 15
    //   179: checkcast 332	gnu/lists/FString
    //   182: aload 13
    //   184: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: dup
    //   188: astore 15
    //   190: checkcast 177	java/lang/Number
    //   193: invokevirtual 181	java/lang/Number:intValue	()I
    //   196: aload_2
    //   197: ldc 43
    //   199: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   202: dup
    //   203: astore 15
    //   205: checkcast 43	java/lang/CharSequence
    //   208: aload 5
    //   210: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: dup
    //   214: astore 15
    //   216: checkcast 177	java/lang/Number
    //   219: invokevirtual 181	java/lang/Number:intValue	()I
    //   222: aload 6
    //   224: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   227: dup
    //   228: astore 15
    //   230: checkcast 177	java/lang/Number
    //   233: invokevirtual 181	java/lang/Number:intValue	()I
    //   236: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   239: iconst_1
    //   240: aload 13
    //   242: aload 7
    //   244: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: iconst_m1
    //   248: aload 14
    //   250: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   253: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: goto -110 -> 146
    //   259: aload_0
    //   260: ldc_w 332
    //   263: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   266: dup
    //   267: astore 15
    //   269: checkcast 332	gnu/lists/FString
    //   272: aload 13
    //   274: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: dup
    //   278: astore 15
    //   280: checkcast 177	java/lang/Number
    //   283: invokevirtual 181	java/lang/Number:intValue	()I
    //   286: aload_2
    //   287: ldc 43
    //   289: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   292: dup
    //   293: astore 15
    //   295: checkcast 43	java/lang/CharSequence
    //   298: aload 5
    //   300: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: dup
    //   304: astore 15
    //   306: checkcast 177	java/lang/Number
    //   309: invokevirtual 181	java/lang/Number:intValue	()I
    //   312: iconst_1
    //   313: aload 5
    //   315: iconst_m1
    //   316: aload 9
    //   318: iconst_m1
    //   319: aload 13
    //   321: aload_1
    //   322: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   331: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   334: dup
    //   335: astore 15
    //   337: checkcast 177	java/lang/Number
    //   340: invokevirtual 181	java/lang/Number:intValue	()I
    //   343: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   346: getstatic 276	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   349: areturn
    //   350: new 53	gnu/mapping/WrongType
    //   353: dup_x1
    //   354: swap
    //   355: ldc_w 334
    //   358: iconst_1
    //   359: aload 10
    //   361: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   364: athrow
    //   365: new 53	gnu/mapping/WrongType
    //   368: dup_x1
    //   369: swap
    //   370: ldc_w 334
    //   373: iconst_2
    //   374: aload 10
    //   376: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   379: athrow
    //   380: new 53	gnu/mapping/WrongType
    //   383: dup_x1
    //   384: swap
    //   385: ldc_w 334
    //   388: iconst_3
    //   389: aload 10
    //   391: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: new 53	gnu/mapping/WrongType
    //   398: dup_x1
    //   399: swap
    //   400: ldc_w 334
    //   403: iconst_4
    //   404: aload 10
    //   406: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   409: athrow
    //   410: new 53	gnu/mapping/WrongType
    //   413: dup_x1
    //   414: swap
    //   415: ldc_w 334
    //   418: iconst_5
    //   419: aload 10
    //   421: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   424: athrow
    //   425: new 53	gnu/mapping/WrongType
    //   428: dup_x1
    //   429: swap
    //   430: ldc_w 590
    //   433: iconst_1
    //   434: aload 15
    //   436: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   439: athrow
    //   440: new 53	gnu/mapping/WrongType
    //   443: dup_x1
    //   444: swap
    //   445: ldc_w 334
    //   448: iconst_1
    //   449: aload 15
    //   451: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   454: athrow
    //   455: new 53	gnu/mapping/WrongType
    //   458: dup_x1
    //   459: swap
    //   460: ldc_w 334
    //   463: iconst_2
    //   464: aload 15
    //   466: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   469: athrow
    //   470: new 53	gnu/mapping/WrongType
    //   473: dup_x1
    //   474: swap
    //   475: ldc_w 334
    //   478: iconst_3
    //   479: aload 15
    //   481: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   484: athrow
    //   485: new 53	gnu/mapping/WrongType
    //   488: dup_x1
    //   489: swap
    //   490: ldc_w 334
    //   493: iconst_4
    //   494: aload 15
    //   496: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   499: athrow
    //   500: new 53	gnu/mapping/WrongType
    //   503: dup_x1
    //   504: swap
    //   505: ldc_w 334
    //   508: iconst_5
    //   509: aload 15
    //   511: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   514: athrow
    //   515: new 53	gnu/mapping/WrongType
    //   518: dup_x1
    //   519: swap
    //   520: ldc_w 334
    //   523: iconst_1
    //   524: aload 15
    //   526: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   529: athrow
    //   530: new 53	gnu/mapping/WrongType
    //   533: dup_x1
    //   534: swap
    //   535: ldc_w 334
    //   538: iconst_2
    //   539: aload 15
    //   541: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   544: athrow
    //   545: new 53	gnu/mapping/WrongType
    //   548: dup_x1
    //   549: swap
    //   550: ldc_w 334
    //   553: iconst_3
    //   554: aload 15
    //   556: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   559: athrow
    //   560: new 53	gnu/mapping/WrongType
    //   563: dup_x1
    //   564: swap
    //   565: ldc_w 334
    //   568: iconst_4
    //   569: aload 15
    //   571: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   574: athrow
    //   575: new 53	gnu/mapping/WrongType
    //   578: dup_x1
    //   579: swap
    //   580: ldc_w 334
    //   583: iconst_5
    //   584: aload 15
    //   586: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   589: athrow
    // Line number table:
    //   Java source line #1871	-> byte code offset #0
    //   Java source line #1872	-> byte code offset #0
    //   Java source line #1873	-> byte code offset #10
    //   Java source line #1872	-> byte code offset #27
    //   Java source line #1874	-> byte code offset #27
    //   Java source line #1877	-> byte code offset #36
    //   Java source line #1879	-> byte code offset #105
    //   Java source line #1880	-> byte code offset #115
    //   Java source line #1879	-> byte code offset #125
    //   Java source line #1881	-> byte code offset #125
    //   Java source line #1884	-> byte code offset #137
    //   Java source line #1886	-> byte code offset #150
    //   Java source line #1890	-> byte code offset #169
    //   Java source line #1884	-> byte code offset #239
    //   Java source line #1885	-> byte code offset #247
    //   Java source line #1884	-> byte code offset #259
    //   Java source line #1888	-> byte code offset #259
    //   Java source line #1877	-> byte code offset #350
    //   Java source line #1886	-> byte code offset #425
    //   Java source line #1890	-> byte code offset #440
    //   Java source line #1888	-> byte code offset #515
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	target	Object
    //   0	349	1	tstart	Object
    //   0	349	2	s	Object
    //   0	349	3	sfrom	Object
    //   0	349	4	sto	Object
    //   0	349	5	start	Object
    //   0	349	6	end	Object
    //   8	235	7	slen	Object
    //   25	84	8	i0	Object
    //   34	283	9	total$Mnchars	Object
    //   44	51	10	localObject1	Object
    //   113	307	10	ncopied	Object
    //   123	6	11	nleft	Object
    //   135	10	12	nspans	Object
    //   148	172	13	i	Object
    //   146	1	14	localObject2	Object
    //   150	99	14	nspans	Object
    //   158	427	15	localObject3	Object
    //   350	1	18	localClassCastException1	ClassCastException
    //   365	1	19	localClassCastException2	ClassCastException
    //   380	1	20	localClassCastException3	ClassCastException
    //   395	1	21	localClassCastException4	ClassCastException
    //   410	1	22	localClassCastException5	ClassCastException
    //   425	1	23	localClassCastException6	ClassCastException
    //   440	1	24	localClassCastException7	ClassCastException
    //   455	1	25	localClassCastException8	ClassCastException
    //   470	1	26	localClassCastException9	ClassCastException
    //   485	1	27	localClassCastException10	ClassCastException
    //   500	1	28	localClassCastException11	ClassCastException
    //   515	1	29	localClassCastException12	ClassCastException
    //   530	1	30	localClassCastException13	ClassCastException
    //   545	1	31	localClassCastException14	ClassCastException
    //   560	1	32	localClassCastException15	ClassCastException
    //   575	1	33	localClassCastException16	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   46	49	350	java/lang/ClassCastException
    //   56	62	365	java/lang/ClassCastException
    //   71	74	380	java/lang/ClassCastException
    //   82	88	395	java/lang/ClassCastException
    //   96	102	410	java/lang/ClassCastException
    //   160	163	425	java/lang/ClassCastException
    //   179	182	440	java/lang/ClassCastException
    //   190	196	455	java/lang/ClassCastException
    //   205	208	470	java/lang/ClassCastException
    //   216	222	485	java/lang/ClassCastException
    //   230	236	500	java/lang/ClassCastException
    //   269	272	515	java/lang/ClassCastException
    //   280	286	530	java/lang/ClassCastException
    //   295	298	545	java/lang/ClassCastException
    //   306	312	560	java/lang/ClassCastException
    //   337	343	575	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringXcopy$Ex$V(Object target, Object tstart, Object s, Object sfrom, Object[] argsArray)
  {
    // Byte code:
    //   0: aload 4
    //   2: iconst_0
    //   3: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   6: dup
    //   7: astore 6
    //   9: astore 5
    //   11: getstatic 973	gnu/kawa/slib/srfi13:lambda$Fn41	Lgnu/expr/ModuleMethod;
    //   14: aload_3
    //   15: getstatic 976	gnu/kawa/slib/srfi13:string$Mnxcopy$Ex	Lgnu/expr/ModuleMethod;
    //   18: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: aload 5
    //   24: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   27: ifeq +112 -> 139
    //   30: getstatic 976	gnu/kawa/slib/srfi13:string$Mnxcopy$Ex	Lgnu/expr/ModuleMethod;
    //   33: aload_2
    //   34: aload 5
    //   36: dup
    //   37: astore 8
    //   39: checkcast 70	gnu/lists/Pair
    //   42: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   45: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   48: astore 7
    //   50: iconst_0
    //   51: istore 8
    //   53: aload 7
    //   55: iload 8
    //   57: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   60: istore 8
    //   62: aload 7
    //   64: iload 8
    //   66: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   69: astore 9
    //   71: aload 7
    //   73: iload 8
    //   75: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   78: istore 8
    //   80: aload 7
    //   82: iload 8
    //   84: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   87: astore 10
    //   89: aload 5
    //   91: dup
    //   92: astore 12
    //   94: checkcast 70	gnu/lists/Pair
    //   97: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   100: astore 11
    //   102: getstatic 979	gnu/kawa/slib/srfi13:lambda$Fn42	Lgnu/expr/ModuleMethod;
    //   105: aload 11
    //   107: getstatic 976	gnu/kawa/slib/srfi13:string$Mnxcopy$Ex	Lgnu/expr/ModuleMethod;
    //   110: invokestatic 167	gnu/kawa/slib/srfi13:checkArg	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: iconst_3
    //   115: anewarray 27	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload 11
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload 9
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: aload 10
    //   132: aastore
    //   133: invokestatic 131	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   136: goto +54 -> 190
    //   139: aload_2
    //   140: ldc 43
    //   142: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   145: dup
    //   146: astore 8
    //   148: checkcast 43	java/lang/CharSequence
    //   151: invokestatic 63	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   154: istore 7
    //   156: iconst_3
    //   157: anewarray 27	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: iconst_1
    //   163: aload_3
    //   164: iload 7
    //   166: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: getstatic 93	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   178: aastore
    //   179: dup
    //   180: iconst_2
    //   181: iload 7
    //   183: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: invokestatic 131	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   190: astore 6
    //   192: iconst_0
    //   193: istore 7
    //   195: aload 6
    //   197: iload 7
    //   199: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   202: istore 7
    //   204: aload 6
    //   206: iload 7
    //   208: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   211: astore 8
    //   213: aload 6
    //   215: iload 7
    //   217: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   220: istore 7
    //   222: aload 6
    //   224: iload 7
    //   226: invokestatic 124	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   229: astore 9
    //   231: aload 6
    //   233: iload 7
    //   235: invokestatic 120	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   238: istore 7
    //   240: aload 6
    //   242: iload 7
    //   244: invokestatic 127	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   247: astore 10
    //   249: iconst_m1
    //   250: aload 8
    //   252: aload_3
    //   253: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: astore 11
    //   258: iconst_1
    //   259: aload_1
    //   260: aload 11
    //   262: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: astore 12
    //   267: iconst_m1
    //   268: aload 10
    //   270: aload 9
    //   272: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   275: astore 13
    //   277: getstatic 976	gnu/kawa/slib/srfi13:string$Mnxcopy$Ex	Lgnu/expr/ModuleMethod;
    //   280: aload_0
    //   281: aload_1
    //   282: aload 12
    //   284: invokestatic 921	gnu/kawa/slib/srfi13:checkSubstringSpec	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   287: aload 11
    //   289: ldc -79
    //   291: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   294: dup
    //   295: astore 15
    //   297: checkcast 177	java/lang/Number
    //   300: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   303: istore 14
    //   305: iload 14
    //   307: ifeq +20 -> 327
    //   310: iload 14
    //   312: ifeq +9 -> 321
    //   315: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   318: goto +349 -> 667
    //   321: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   324: goto +343 -> 667
    //   327: aload 13
    //   329: ldc -79
    //   331: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   334: dup
    //   335: astore 15
    //   337: checkcast 177	java/lang/Number
    //   340: invokestatic 192	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   343: ifeq +61 -> 404
    //   346: bipush 9
    //   348: anewarray 27	java/lang/Object
    //   351: dup
    //   352: iconst_0
    //   353: ldc_w 947
    //   356: aastore
    //   357: dup
    //   358: iconst_1
    //   359: getstatic 976	gnu/kawa/slib/srfi13:string$Mnxcopy$Ex	Lgnu/expr/ModuleMethod;
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: aload_0
    //   366: aastore
    //   367: dup
    //   368: iconst_3
    //   369: aload_1
    //   370: aastore
    //   371: dup
    //   372: iconst_4
    //   373: aload_2
    //   374: aastore
    //   375: dup
    //   376: iconst_5
    //   377: aload_3
    //   378: aastore
    //   379: dup
    //   380: bipush 6
    //   382: aload 8
    //   384: aastore
    //   385: dup
    //   386: bipush 7
    //   388: aload 9
    //   390: aastore
    //   391: dup
    //   392: bipush 8
    //   394: aload 10
    //   396: aastore
    //   397: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   400: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   403: athrow
    //   404: getstatic 227	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   407: aload 13
    //   409: invokestatic 382	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   412: ifeq +81 -> 493
    //   415: aload_0
    //   416: ldc_w 272
    //   419: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   422: dup
    //   423: astore 15
    //   425: checkcast 272	gnu/lists/CharSeq
    //   428: aload_2
    //   429: ldc 43
    //   431: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   434: dup
    //   435: astore 15
    //   437: checkcast 43	java/lang/CharSequence
    //   440: aload 9
    //   442: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   445: dup
    //   446: astore 15
    //   448: checkcast 177	java/lang/Number
    //   451: invokevirtual 181	java/lang/Number:intValue	()I
    //   454: invokestatic 244	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   457: aload_1
    //   458: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   461: dup
    //   462: astore 15
    //   464: checkcast 177	java/lang/Number
    //   467: invokevirtual 181	java/lang/Number:intValue	()I
    //   470: aload 12
    //   472: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   475: dup
    //   476: astore 15
    //   478: checkcast 177	java/lang/Number
    //   481: invokevirtual 181	java/lang/Number:intValue	()I
    //   484: invokestatic 985	kawa/lib/strings:stringFill$Ex	(Lgnu/lists/CharSeq;III)V
    //   487: getstatic 276	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   490: goto +177 -> 667
    //   493: getstatic 950	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   496: aload_3
    //   497: aload 13
    //   499: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   502: ldc_w 952
    //   505: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   508: dup
    //   509: astore 15
    //   511: invokestatic 958	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   514: invokestatic 963	kawa/lib/numbers:floor	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   517: invokevirtual 967	java/lang/Number:doubleValue	()D
    //   520: getstatic 950	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   523: aload 8
    //   525: aload 13
    //   527: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   530: ldc_w 952
    //   533: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   536: dup
    //   537: astore 15
    //   539: invokestatic 958	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   542: invokestatic 963	kawa/lib/numbers:floor	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   545: invokevirtual 967	java/lang/Number:doubleValue	()D
    //   548: dcmpg
    //   549: ifne +105 -> 654
    //   552: aload_0
    //   553: ldc_w 332
    //   556: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   559: dup
    //   560: astore 15
    //   562: checkcast 332	gnu/lists/FString
    //   565: aload_1
    //   566: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   569: dup
    //   570: astore 15
    //   572: checkcast 177	java/lang/Number
    //   575: invokevirtual 181	java/lang/Number:intValue	()I
    //   578: aload_2
    //   579: ldc 43
    //   581: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   584: dup
    //   585: astore 15
    //   587: checkcast 43	java/lang/CharSequence
    //   590: iconst_1
    //   591: aload 9
    //   593: getstatic 570	gnu/kawa/functions/DivideOp:modulo	Lgnu/kawa/functions/DivideOp;
    //   596: aload_3
    //   597: aload 13
    //   599: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   602: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   605: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   608: dup
    //   609: astore 15
    //   611: checkcast 177	java/lang/Number
    //   614: invokevirtual 181	java/lang/Number:intValue	()I
    //   617: iconst_1
    //   618: aload 9
    //   620: getstatic 570	gnu/kawa/functions/DivideOp:modulo	Lgnu/kawa/functions/DivideOp;
    //   623: aload 8
    //   625: aload 13
    //   627: invokevirtual 255	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   630: invokestatic 218	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   633: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   636: dup
    //   637: astore 15
    //   639: checkcast 177	java/lang/Number
    //   642: invokevirtual 181	java/lang/Number:intValue	()I
    //   645: invokestatic 338	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   648: getstatic 276	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   651: goto +16 -> 667
    //   654: aload_0
    //   655: aload_1
    //   656: aload_2
    //   657: aload_3
    //   658: aload 8
    //   660: aload 9
    //   662: aload 10
    //   664: invokestatic 970	gnu/kawa/slib/srfi13:$PcMultispanRepcopy$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   667: areturn
    //   668: new 53	gnu/mapping/WrongType
    //   671: dup_x1
    //   672: swap
    //   673: ldc 77
    //   675: iconst_1
    //   676: aload 8
    //   678: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   681: athrow
    //   682: new 53	gnu/mapping/WrongType
    //   685: dup_x1
    //   686: swap
    //   687: ldc 72
    //   689: iconst_1
    //   690: aload 12
    //   692: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   695: athrow
    //   696: new 53	gnu/mapping/WrongType
    //   699: dup_x1
    //   700: swap
    //   701: ldc 55
    //   703: iconst_1
    //   704: aload 8
    //   706: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   709: athrow
    //   710: new 53	gnu/mapping/WrongType
    //   713: dup_x1
    //   714: swap
    //   715: ldc_w 590
    //   718: iconst_1
    //   719: aload 15
    //   721: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   724: athrow
    //   725: new 53	gnu/mapping/WrongType
    //   728: dup_x1
    //   729: swap
    //   730: ldc_w 590
    //   733: iconst_1
    //   734: aload 15
    //   736: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   739: athrow
    //   740: new 53	gnu/mapping/WrongType
    //   743: dup_x1
    //   744: swap
    //   745: ldc_w 981
    //   748: iconst_1
    //   749: aload 15
    //   751: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   754: athrow
    //   755: new 53	gnu/mapping/WrongType
    //   758: dup_x1
    //   759: swap
    //   760: ldc -16
    //   762: iconst_1
    //   763: aload 15
    //   765: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   768: athrow
    //   769: new 53	gnu/mapping/WrongType
    //   772: dup_x1
    //   773: swap
    //   774: ldc -16
    //   776: iconst_2
    //   777: aload 15
    //   779: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   782: athrow
    //   783: new 53	gnu/mapping/WrongType
    //   786: dup_x1
    //   787: swap
    //   788: ldc_w 981
    //   791: iconst_3
    //   792: aload 15
    //   794: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   797: athrow
    //   798: new 53	gnu/mapping/WrongType
    //   801: dup_x1
    //   802: swap
    //   803: ldc_w 981
    //   806: iconst_4
    //   807: aload 15
    //   809: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   812: athrow
    //   813: new 53	gnu/mapping/WrongType
    //   816: dup_x1
    //   817: swap
    //   818: ldc_w 960
    //   821: iconst_1
    //   822: aload 15
    //   824: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   827: athrow
    //   828: new 53	gnu/mapping/WrongType
    //   831: dup_x1
    //   832: swap
    //   833: ldc_w 960
    //   836: iconst_1
    //   837: aload 15
    //   839: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   842: athrow
    //   843: new 53	gnu/mapping/WrongType
    //   846: dup_x1
    //   847: swap
    //   848: ldc_w 334
    //   851: iconst_1
    //   852: aload 15
    //   854: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   857: athrow
    //   858: new 53	gnu/mapping/WrongType
    //   861: dup_x1
    //   862: swap
    //   863: ldc_w 334
    //   866: iconst_2
    //   867: aload 15
    //   869: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   872: athrow
    //   873: new 53	gnu/mapping/WrongType
    //   876: dup_x1
    //   877: swap
    //   878: ldc_w 334
    //   881: iconst_3
    //   882: aload 15
    //   884: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   887: athrow
    //   888: new 53	gnu/mapping/WrongType
    //   891: dup_x1
    //   892: swap
    //   893: ldc_w 334
    //   896: iconst_4
    //   897: aload 15
    //   899: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   902: athrow
    //   903: new 53	gnu/mapping/WrongType
    //   906: dup_x1
    //   907: swap
    //   908: ldc_w 334
    //   911: iconst_5
    //   912: aload 15
    //   914: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   917: athrow
    // Line number table:
    //   Java source line #1835	-> byte code offset #0
    //   Java source line #1836	-> byte code offset #11
    //   Java source line #1837	-> byte code offset #14
    //   Java source line #1839	-> byte code offset #22
    //   Java source line #1840	-> byte code offset #30
    //   Java source line #1841	-> byte code offset #89
    //   Java source line #1842	-> byte code offset #102
    //   Java source line #1843	-> byte code offset #105
    //   Java source line #1844	-> byte code offset #114
    //   Java source line #1845	-> byte code offset #139
    //   Java source line #1846	-> byte code offset #156
    //   Java source line #1848	-> byte code offset #249
    //   Java source line #1849	-> byte code offset #258
    //   Java source line #1848	-> byte code offset #267
    //   Java source line #1850	-> byte code offset #267
    //   Java source line #1851	-> byte code offset #277
    //   Java source line #1852	-> byte code offset #287
    //   Java source line #1853	-> byte code offset #327
    //   Java source line #1857	-> byte code offset #404
    //   Java source line #1858	-> byte code offset #415
    //   Java source line #1861	-> byte code offset #493
    //   Java source line #1862	-> byte code offset #552
    //   Java source line #1863	-> byte code offset #590
    //   Java source line #1864	-> byte code offset #617
    //   Java source line #1867	-> byte code offset #654
    //   Java source line #1840	-> byte code offset #668
    //   Java source line #1841	-> byte code offset #682
    //   Java source line #1845	-> byte code offset #696
    //   Java source line #1852	-> byte code offset #710
    //   Java source line #1853	-> byte code offset #725
    //   Java source line #1858	-> byte code offset #740
    //   Java source line #1861	-> byte code offset #813
    //   Java source line #1862	-> byte code offset #843
    //   Java source line #1863	-> byte code offset #888
    //   Java source line #1864	-> byte code offset #903
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	target	Object
    //   0	667	1	tstart	Object
    //   0	667	2	s	Object
    //   0	667	3	sfrom	Object
    //   0	667	4	argsArray	Object[]
    //   0	90	5	maybe$Mnsto$Plstart$Plend	LList
    //   7	234	6	localObject1	Object
    //   48	33	7	localValues	Values
    //   154	89	7	slen	int
    //   37	1	8	localLList1	LList
    //   51	32	8	i	int
    //   146	66	8	localObject2	Object
    //   249	456	8	sto	Object
    //   69	1	9	localObject3	Object
    //   89	141	9	start	Object
    //   249	412	9	start	Object
    //   87	44	10	end	Object
    //   247	416	10	end	Object
    //   100	21	11	sto	Object
    //   256	32	11	tocopy	Object
    //   92	1	12	localLList2	LList
    //   265	426	12	tend	Object
    //   275	351	13	slen	Object
    //   303	8	14	x	boolean
    //   295	618	15	localObject4	Object
    //   668	1	25	localClassCastException1	ClassCastException
    //   682	1	26	localClassCastException2	ClassCastException
    //   696	1	27	localClassCastException3	ClassCastException
    //   710	1	28	localClassCastException4	ClassCastException
    //   725	1	29	localClassCastException5	ClassCastException
    //   740	1	30	localClassCastException6	ClassCastException
    //   755	1	31	localClassCastException7	ClassCastException
    //   769	1	32	localClassCastException8	ClassCastException
    //   783	1	33	localClassCastException9	ClassCastException
    //   798	1	34	localClassCastException10	ClassCastException
    //   813	1	35	localClassCastException11	ClassCastException
    //   828	1	36	localClassCastException12	ClassCastException
    //   843	1	37	localClassCastException13	ClassCastException
    //   858	1	38	localClassCastException14	ClassCastException
    //   873	1	39	localClassCastException15	ClassCastException
    //   888	1	40	localClassCastException16	ClassCastException
    //   903	1	41	localClassCastException17	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   39	42	668	java/lang/ClassCastException
    //   94	97	682	java/lang/ClassCastException
    //   148	151	696	java/lang/ClassCastException
    //   297	300	710	java/lang/ClassCastException
    //   337	340	725	java/lang/ClassCastException
    //   425	428	740	java/lang/ClassCastException
    //   437	440	755	java/lang/ClassCastException
    //   448	454	769	java/lang/ClassCastException
    //   464	470	783	java/lang/ClassCastException
    //   478	484	798	java/lang/ClassCastException
    //   511	514	813	java/lang/ClassCastException
    //   539	542	828	java/lang/ClassCastException
    //   562	565	843	java/lang/ClassCastException
    //   572	578	858	java/lang/ClassCastException
    //   587	590	873	java/lang/ClassCastException
    //   611	617	888	java/lang/ClassCastException
    //   639	645	903	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringJoin$V(Object strings, Object[] argsArray)
  {
    // Byte code:
    //   0: new 990	gnu/kawa/slib/srfi13$frame7
    //   3: dup
    //   4: invokespecial 991	gnu/kawa/slib/srfi13$frame7:<init>	()V
    //   7: astore_3
    //   8: aload_1
    //   9: iconst_0
    //   10: invokestatic 157	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   13: dup
    //   14: astore 4
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   21: ifne +16 -> 37
    //   24: aload_2
    //   25: dup
    //   26: astore 4
    //   28: checkcast 70	gnu/lists/Pair
    //   31: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   34: goto +6 -> 40
    //   37: ldc_w 993
    //   40: aload_3
    //   41: swap
    //   42: putfield 996	gnu/kawa/slib/srfi13$frame7:delim	Ljava/lang/Object;
    //   45: aload_3
    //   46: getfield 996	gnu/kawa/slib/srfi13$frame7:delim	Ljava/lang/Object;
    //   49: invokestatic 25	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   52: ifne +10 -> 62
    //   55: aload_3
    //   56: ldc_w 993
    //   59: putfield 996	gnu/kawa/slib/srfi13$frame7:delim	Ljava/lang/Object;
    //   62: aload_2
    //   63: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   66: ifne +16 -> 82
    //   69: aload_2
    //   70: dup
    //   71: astore 5
    //   73: checkcast 70	gnu/lists/Pair
    //   76: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   79: goto +4 -> 83
    //   82: aload_2
    //   83: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   86: ifne +47 -> 133
    //   89: aload_2
    //   90: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   93: ifne +27 -> 120
    //   96: aload_2
    //   97: dup
    //   98: astore 5
    //   100: checkcast 70	gnu/lists/Pair
    //   103: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   106: ldc 70
    //   108: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   111: dup
    //   112: astore 5
    //   114: checkcast 70	gnu/lists/Pair
    //   117: goto +10 -> 127
    //   120: aload_2
    //   121: dup
    //   122: astore 5
    //   124: checkcast 70	gnu/lists/Pair
    //   127: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   130: goto +6 -> 136
    //   133: getstatic 1000	gnu/kawa/slib/srfi13:Lit9	Lgnu/mapping/SimpleSymbol;
    //   136: astore 4
    //   138: aload_2
    //   139: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   142: ifne +16 -> 158
    //   145: aload_2
    //   146: dup
    //   147: astore 5
    //   149: checkcast 70	gnu/lists/Pair
    //   152: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   155: goto +4 -> 159
    //   158: aload_2
    //   159: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   162: ifne +47 -> 209
    //   165: aload_2
    //   166: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   169: ifne +27 -> 196
    //   172: aload_2
    //   173: dup
    //   174: astore 5
    //   176: checkcast 70	gnu/lists/Pair
    //   179: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   182: ldc 70
    //   184: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: dup
    //   188: astore 5
    //   190: checkcast 70	gnu/lists/Pair
    //   193: goto +10 -> 203
    //   196: aload_2
    //   197: dup
    //   198: astore 5
    //   200: checkcast 70	gnu/lists/Pair
    //   203: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   206: goto +24 -> 230
    //   209: aload_2
    //   210: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   213: ifne +16 -> 229
    //   216: aload_2
    //   217: dup
    //   218: astore 5
    //   220: checkcast 70	gnu/lists/Pair
    //   223: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   226: goto +4 -> 230
    //   229: aload_2
    //   230: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   233: ifeq +316 -> 549
    //   236: aload_0
    //   237: invokestatic 68	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   240: ifeq +238 -> 478
    //   243: aload 4
    //   245: astore 5
    //   247: aload 5
    //   249: invokevirtual 1003	java/lang/Object:hashCode	()I
    //   252: lookupswitch	default:+192->444, -980110702:+112->364, -891422895:+134->386, -60774196:+58->310, 100348112:+44->296
    //   296: aload 5
    //   298: getstatic 1000	gnu/kawa/slib/srfi13:Lit9	Lgnu/mapping/SimpleSymbol;
    //   301: invokestatic 1008	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   304: ifeq +140 -> 444
    //   307: goto +14 -> 321
    //   310: aload 5
    //   312: getstatic 1011	gnu/kawa/slib/srfi13:Lit10	Lgnu/mapping/SimpleSymbol;
    //   315: invokestatic 1008	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   318: ifeq +126 -> 444
    //   321: aload_0
    //   322: ldc 70
    //   324: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   327: dup
    //   328: astore 6
    //   330: checkcast 70	gnu/lists/Pair
    //   333: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   336: aload_3
    //   337: aload_0
    //   338: ldc 70
    //   340: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   343: dup
    //   344: astore 6
    //   346: checkcast 70	gnu/lists/Pair
    //   349: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   352: getstatic 141	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   355: invokevirtual 1014	gnu/kawa/slib/srfi13$frame7:lambda43buildit	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: invokestatic 330	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   361: goto +111 -> 472
    //   364: aload 5
    //   366: getstatic 1017	gnu/kawa/slib/srfi13:Lit11	Lgnu/mapping/SimpleSymbol;
    //   369: invokestatic 1008	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   372: ifeq +72 -> 444
    //   375: aload_3
    //   376: aload_0
    //   377: getstatic 141	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   380: invokevirtual 1014	gnu/kawa/slib/srfi13$frame7:lambda43buildit	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: goto +89 -> 472
    //   386: aload 5
    //   388: getstatic 1020	gnu/kawa/slib/srfi13:Lit12	Lgnu/mapping/SimpleSymbol;
    //   391: invokestatic 1008	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   394: ifeq +50 -> 444
    //   397: aload_0
    //   398: ldc 70
    //   400: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   403: dup
    //   404: astore 6
    //   406: checkcast 70	gnu/lists/Pair
    //   409: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   412: aload_3
    //   413: aload_0
    //   414: ldc 70
    //   416: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   419: dup
    //   420: astore 6
    //   422: checkcast 70	gnu/lists/Pair
    //   425: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   428: aload_3
    //   429: getfield 996	gnu/kawa/slib/srfi13$frame7:delim	Ljava/lang/Object;
    //   432: invokestatic 1024	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   435: invokevirtual 1014	gnu/kawa/slib/srfi13$frame7:lambda43buildit	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   438: invokestatic 330	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   441: goto +31 -> 472
    //   444: iconst_3
    //   445: anewarray 27	java/lang/Object
    //   448: dup
    //   449: iconst_0
    //   450: ldc_w 1026
    //   453: aastore
    //   454: dup
    //   455: iconst_1
    //   456: aload 4
    //   458: aastore
    //   459: dup
    //   460: iconst_2
    //   461: getstatic 1029	gnu/kawa/slib/srfi13:string$Mnjoin	Lgnu/expr/ModuleMethod;
    //   464: aastore
    //   465: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   468: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   471: athrow
    //   472: invokestatic 1033	gnu/kawa/slib/srfi13:stringConcatenate	(Ljava/lang/Object;)Lgnu/lists/FString;
    //   475: goto +186 -> 661
    //   478: aload_0
    //   479: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   482: ifne +30 -> 512
    //   485: iconst_3
    //   486: anewarray 27	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: ldc_w 1035
    //   494: aastore
    //   495: dup
    //   496: iconst_1
    //   497: aload_0
    //   498: aastore
    //   499: dup
    //   500: iconst_2
    //   501: getstatic 1029	gnu/kawa/slib/srfi13:string$Mnjoin	Lgnu/expr/ModuleMethod;
    //   504: aastore
    //   505: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   508: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   511: athrow
    //   512: aload 4
    //   514: getstatic 1011	gnu/kawa/slib/srfi13:Lit10	Lgnu/mapping/SimpleSymbol;
    //   517: if_acmpne +26 -> 543
    //   520: iconst_2
    //   521: anewarray 27	java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: ldc_w 1037
    //   529: aastore
    //   530: dup
    //   531: iconst_1
    //   532: getstatic 1029	gnu/kawa/slib/srfi13:string$Mnjoin	Lgnu/expr/ModuleMethod;
    //   535: aastore
    //   536: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   539: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   542: athrow
    //   543: ldc_w 290
    //   546: goto +115 -> 661
    //   549: iconst_2
    //   550: anewarray 27	java/lang/Object
    //   553: dup
    //   554: iconst_0
    //   555: ldc_w 340
    //   558: aastore
    //   559: dup
    //   560: iconst_1
    //   561: aload_2
    //   562: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   565: ifne +16 -> 581
    //   568: aload_2
    //   569: dup
    //   570: astore 5
    //   572: checkcast 70	gnu/lists/Pair
    //   575: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   578: goto +4 -> 582
    //   581: aload_2
    //   582: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   585: ifne +47 -> 632
    //   588: aload_2
    //   589: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   592: ifne +27 -> 619
    //   595: aload_2
    //   596: dup
    //   597: astore 5
    //   599: checkcast 70	gnu/lists/Pair
    //   602: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   605: ldc 70
    //   607: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   610: dup
    //   611: astore 5
    //   613: checkcast 70	gnu/lists/Pair
    //   616: goto +10 -> 626
    //   619: aload_2
    //   620: dup
    //   621: astore 5
    //   623: checkcast 70	gnu/lists/Pair
    //   626: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   629: goto +24 -> 653
    //   632: aload_2
    //   633: invokestatic 184	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   636: ifne +16 -> 652
    //   639: aload_2
    //   640: dup
    //   641: astore 5
    //   643: checkcast 70	gnu/lists/Pair
    //   646: invokestatic 79	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   649: goto +4 -> 653
    //   652: aload_2
    //   653: aastore
    //   654: invokestatic 35	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   657: getstatic 41	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   660: athrow
    //   661: areturn
    //   662: new 53	gnu/mapping/WrongType
    //   665: dup_x1
    //   666: swap
    //   667: ldc 72
    //   669: iconst_1
    //   670: aload 4
    //   672: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   675: athrow
    //   676: new 53	gnu/mapping/WrongType
    //   679: dup_x1
    //   680: swap
    //   681: ldc 77
    //   683: iconst_1
    //   684: aload 5
    //   686: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   689: athrow
    //   690: new 53	gnu/mapping/WrongType
    //   693: dup_x1
    //   694: swap
    //   695: ldc 77
    //   697: iconst_1
    //   698: aload 5
    //   700: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   703: athrow
    //   704: new 53	gnu/mapping/WrongType
    //   707: dup_x1
    //   708: swap
    //   709: ldc 72
    //   711: iconst_1
    //   712: aload 5
    //   714: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   717: athrow
    //   718: new 53	gnu/mapping/WrongType
    //   721: dup_x1
    //   722: swap
    //   723: ldc 72
    //   725: iconst_1
    //   726: aload 5
    //   728: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   731: athrow
    //   732: new 53	gnu/mapping/WrongType
    //   735: dup_x1
    //   736: swap
    //   737: ldc 77
    //   739: iconst_1
    //   740: aload 5
    //   742: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   745: athrow
    //   746: new 53	gnu/mapping/WrongType
    //   749: dup_x1
    //   750: swap
    //   751: ldc 77
    //   753: iconst_1
    //   754: aload 5
    //   756: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   759: athrow
    //   760: new 53	gnu/mapping/WrongType
    //   763: dup_x1
    //   764: swap
    //   765: ldc 77
    //   767: iconst_1
    //   768: aload 5
    //   770: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   773: athrow
    //   774: new 53	gnu/mapping/WrongType
    //   777: dup_x1
    //   778: swap
    //   779: ldc 77
    //   781: iconst_1
    //   782: aload 5
    //   784: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   787: athrow
    //   788: new 53	gnu/mapping/WrongType
    //   791: dup_x1
    //   792: swap
    //   793: ldc 77
    //   795: iconst_1
    //   796: aload 5
    //   798: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   801: athrow
    //   802: new 53	gnu/mapping/WrongType
    //   805: dup_x1
    //   806: swap
    //   807: ldc 72
    //   809: iconst_1
    //   810: aload 6
    //   812: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   815: athrow
    //   816: new 53	gnu/mapping/WrongType
    //   819: dup_x1
    //   820: swap
    //   821: ldc 77
    //   823: iconst_1
    //   824: aload 6
    //   826: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   829: athrow
    //   830: new 53	gnu/mapping/WrongType
    //   833: dup_x1
    //   834: swap
    //   835: ldc 72
    //   837: iconst_1
    //   838: aload 6
    //   840: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   843: athrow
    //   844: new 53	gnu/mapping/WrongType
    //   847: dup_x1
    //   848: swap
    //   849: ldc 77
    //   851: iconst_1
    //   852: aload 6
    //   854: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   857: athrow
    //   858: new 53	gnu/mapping/WrongType
    //   861: dup_x1
    //   862: swap
    //   863: ldc 77
    //   865: iconst_1
    //   866: aload 5
    //   868: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   871: athrow
    //   872: new 53	gnu/mapping/WrongType
    //   875: dup_x1
    //   876: swap
    //   877: ldc 77
    //   879: iconst_1
    //   880: aload 5
    //   882: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   885: athrow
    //   886: new 53	gnu/mapping/WrongType
    //   889: dup_x1
    //   890: swap
    //   891: ldc 77
    //   893: iconst_1
    //   894: aload 5
    //   896: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   899: athrow
    //   900: new 53	gnu/mapping/WrongType
    //   903: dup_x1
    //   904: swap
    //   905: ldc 77
    //   907: iconst_1
    //   908: aload 5
    //   910: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   913: athrow
    //   914: new 53	gnu/mapping/WrongType
    //   917: dup_x1
    //   918: swap
    //   919: ldc 77
    //   921: iconst_1
    //   922: aload 5
    //   924: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   927: athrow
    // Line number table:
    //   Java source line #1908	-> byte code offset #0
    //   Java source line #1909	-> byte code offset #17
    //   Java source line #1910	-> byte code offset #82
    //   Java source line #1909	-> byte code offset #89
    //   Java source line #1910	-> byte code offset #120
    //   Java source line #1909	-> byte code offset #138
    //   Java source line #1911	-> byte code offset #236
    //   Java source line #1917	-> byte code offset #236
    //   Java source line #1918	-> byte code offset #243
    //   Java source line #1919	-> byte code offset #243
    //   Java source line #1922	-> byte code offset #321
    //   Java source line #1924	-> byte code offset #376
    //   Java source line #1927	-> byte code offset #397
    //   Java source line #1932	-> byte code offset #478
    //   Java source line #1933	-> byte code offset #485
    //   Java source line #1938	-> byte code offset #520
    //   Java source line #1941	-> byte code offset #543
    //   Java source line #1909	-> byte code offset #561
    //   Java source line #1910	-> byte code offset #718
    //   Java source line #1909	-> byte code offset #732
    //   Java source line #1922	-> byte code offset #802
    //   Java source line #1927	-> byte code offset #830
    //   Java source line #1909	-> byte code offset #858
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	strings	Object
    //   0	661	1	argsArray	Object[]
    //   0	653	2	delim$Plgrammar	LList
    //   7	422	3	$heapFrame	frame7
    //   14	13	4	localLList1	LList
    //   136	535	4	grammar	Object
    //   71	148	5	localObject1	Object
    //   245	678	5	tmp	Object
    //   328	525	6	localObject2	Object
    //   662	1	9	localClassCastException1	ClassCastException
    //   676	1	10	localClassCastException2	ClassCastException
    //   690	1	11	localClassCastException3	ClassCastException
    //   704	1	12	localClassCastException4	ClassCastException
    //   718	1	13	localClassCastException5	ClassCastException
    //   732	1	14	localClassCastException6	ClassCastException
    //   746	1	15	localClassCastException7	ClassCastException
    //   760	1	16	localClassCastException8	ClassCastException
    //   774	1	17	localClassCastException9	ClassCastException
    //   788	1	18	localClassCastException10	ClassCastException
    //   802	1	19	localClassCastException11	ClassCastException
    //   816	1	20	localClassCastException12	ClassCastException
    //   830	1	21	localClassCastException13	ClassCastException
    //   844	1	22	localClassCastException14	ClassCastException
    //   858	1	23	localClassCastException15	ClassCastException
    //   872	1	24	localClassCastException16	ClassCastException
    //   886	1	25	localClassCastException17	ClassCastException
    //   900	1	26	localClassCastException18	ClassCastException
    //   914	1	27	localClassCastException19	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   28	31	662	java/lang/ClassCastException
    //   73	76	676	java/lang/ClassCastException
    //   100	103	690	java/lang/ClassCastException
    //   114	117	704	java/lang/ClassCastException
    //   124	127	718	java/lang/ClassCastException
    //   149	152	732	java/lang/ClassCastException
    //   176	179	746	java/lang/ClassCastException
    //   190	193	760	java/lang/ClassCastException
    //   200	203	774	java/lang/ClassCastException
    //   220	223	788	java/lang/ClassCastException
    //   330	333	802	java/lang/ClassCastException
    //   346	349	816	java/lang/ClassCastException
    //   406	409	830	java/lang/ClassCastException
    //   422	425	844	java/lang/ClassCastException
    //   572	575	858	java/lang/ClassCastException
    //   599	602	872	java/lang/ClassCastException
    //   613	616	886	java/lang/ClassCastException
    //   623	626	900	java/lang/ClassCastException
    //   643	646	914	java/lang/ClassCastException
  }
  
  public srfi13()
  {
    ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+929->933, 13:+300->304, 14:+895->899, 20:+878->882, 29:+861->865, 30:+844->848, 32:+827->831, 33:+810->814, 37:+793->797, 59:+776->780, 60:+759->763, 62:+742->746, 64:+725->729, 65:+708->712, 67:+691->695, 68:+674->678, 70:+657->661, 72:+640->644, 74:+623->627, 75:+606->610, 77:+589->593, 79:+572->576, 80:+555->559, 82:+538->542, 83:+521->525, 85:+504->508, 87:+487->491, 91:+470->474, 107:+453->457, 109:+436->440, 124:+419->423, 127:+402->406, 129:+385->389, 130:+368->372, 136:+351->355, 138:+334->338, 139:+317->321
    //   304: aload_3
    //   305: aload_2
    //   306: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   309: aload_3
    //   310: aload_1
    //   311: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   314: aload_3
    //   315: iconst_1
    //   316: putfield 1685	gnu/mapping/CallContext:pc	I
    //   319: iconst_0
    //   320: ireturn
    //   321: aload_3
    //   322: aload_2
    //   323: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   326: aload_3
    //   327: aload_1
    //   328: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   331: aload_3
    //   332: iconst_1
    //   333: putfield 1685	gnu/mapping/CallContext:pc	I
    //   336: iconst_0
    //   337: ireturn
    //   338: aload_3
    //   339: aload_2
    //   340: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   343: aload_3
    //   344: aload_1
    //   345: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   348: aload_3
    //   349: iconst_1
    //   350: putfield 1685	gnu/mapping/CallContext:pc	I
    //   353: iconst_0
    //   354: ireturn
    //   355: aload_3
    //   356: aload_2
    //   357: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   360: aload_3
    //   361: aload_1
    //   362: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   365: aload_3
    //   366: iconst_1
    //   367: putfield 1685	gnu/mapping/CallContext:pc	I
    //   370: iconst_0
    //   371: ireturn
    //   372: aload_3
    //   373: aload_2
    //   374: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   377: aload_3
    //   378: aload_1
    //   379: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   382: aload_3
    //   383: iconst_1
    //   384: putfield 1685	gnu/mapping/CallContext:pc	I
    //   387: iconst_0
    //   388: ireturn
    //   389: aload_3
    //   390: aload_2
    //   391: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   394: aload_3
    //   395: aload_1
    //   396: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   399: aload_3
    //   400: iconst_1
    //   401: putfield 1685	gnu/mapping/CallContext:pc	I
    //   404: iconst_0
    //   405: ireturn
    //   406: aload_3
    //   407: aload_2
    //   408: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   411: aload_3
    //   412: aload_1
    //   413: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   416: aload_3
    //   417: iconst_1
    //   418: putfield 1685	gnu/mapping/CallContext:pc	I
    //   421: iconst_0
    //   422: ireturn
    //   423: aload_3
    //   424: aload_2
    //   425: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   428: aload_3
    //   429: aload_1
    //   430: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   433: aload_3
    //   434: iconst_1
    //   435: putfield 1685	gnu/mapping/CallContext:pc	I
    //   438: iconst_0
    //   439: ireturn
    //   440: aload_3
    //   441: aload_2
    //   442: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   445: aload_3
    //   446: aload_1
    //   447: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   450: aload_3
    //   451: iconst_1
    //   452: putfield 1685	gnu/mapping/CallContext:pc	I
    //   455: iconst_0
    //   456: ireturn
    //   457: aload_3
    //   458: aload_2
    //   459: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   462: aload_3
    //   463: aload_1
    //   464: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   467: aload_3
    //   468: iconst_1
    //   469: putfield 1685	gnu/mapping/CallContext:pc	I
    //   472: iconst_0
    //   473: ireturn
    //   474: aload_3
    //   475: aload_2
    //   476: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   479: aload_3
    //   480: aload_1
    //   481: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   484: aload_3
    //   485: iconst_1
    //   486: putfield 1685	gnu/mapping/CallContext:pc	I
    //   489: iconst_0
    //   490: ireturn
    //   491: aload_3
    //   492: aload_2
    //   493: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   496: aload_3
    //   497: aload_1
    //   498: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   501: aload_3
    //   502: iconst_1
    //   503: putfield 1685	gnu/mapping/CallContext:pc	I
    //   506: iconst_0
    //   507: ireturn
    //   508: aload_3
    //   509: aload_2
    //   510: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   513: aload_3
    //   514: aload_1
    //   515: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   518: aload_3
    //   519: iconst_1
    //   520: putfield 1685	gnu/mapping/CallContext:pc	I
    //   523: iconst_0
    //   524: ireturn
    //   525: aload_3
    //   526: aload_2
    //   527: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   530: aload_3
    //   531: aload_1
    //   532: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   535: aload_3
    //   536: iconst_1
    //   537: putfield 1685	gnu/mapping/CallContext:pc	I
    //   540: iconst_0
    //   541: ireturn
    //   542: aload_3
    //   543: aload_2
    //   544: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   547: aload_3
    //   548: aload_1
    //   549: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   552: aload_3
    //   553: iconst_1
    //   554: putfield 1685	gnu/mapping/CallContext:pc	I
    //   557: iconst_0
    //   558: ireturn
    //   559: aload_3
    //   560: aload_2
    //   561: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   564: aload_3
    //   565: aload_1
    //   566: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   569: aload_3
    //   570: iconst_1
    //   571: putfield 1685	gnu/mapping/CallContext:pc	I
    //   574: iconst_0
    //   575: ireturn
    //   576: aload_3
    //   577: aload_2
    //   578: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   581: aload_3
    //   582: aload_1
    //   583: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   586: aload_3
    //   587: iconst_1
    //   588: putfield 1685	gnu/mapping/CallContext:pc	I
    //   591: iconst_0
    //   592: ireturn
    //   593: aload_3
    //   594: aload_2
    //   595: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   598: aload_3
    //   599: aload_1
    //   600: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   603: aload_3
    //   604: iconst_1
    //   605: putfield 1685	gnu/mapping/CallContext:pc	I
    //   608: iconst_0
    //   609: ireturn
    //   610: aload_3
    //   611: aload_2
    //   612: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   615: aload_3
    //   616: aload_1
    //   617: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   620: aload_3
    //   621: iconst_1
    //   622: putfield 1685	gnu/mapping/CallContext:pc	I
    //   625: iconst_0
    //   626: ireturn
    //   627: aload_3
    //   628: aload_2
    //   629: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   632: aload_3
    //   633: aload_1
    //   634: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   637: aload_3
    //   638: iconst_1
    //   639: putfield 1685	gnu/mapping/CallContext:pc	I
    //   642: iconst_0
    //   643: ireturn
    //   644: aload_3
    //   645: aload_2
    //   646: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   649: aload_3
    //   650: aload_1
    //   651: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   654: aload_3
    //   655: iconst_1
    //   656: putfield 1685	gnu/mapping/CallContext:pc	I
    //   659: iconst_0
    //   660: ireturn
    //   661: aload_3
    //   662: aload_2
    //   663: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   666: aload_3
    //   667: aload_1
    //   668: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   671: aload_3
    //   672: iconst_1
    //   673: putfield 1685	gnu/mapping/CallContext:pc	I
    //   676: iconst_0
    //   677: ireturn
    //   678: aload_3
    //   679: aload_2
    //   680: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   683: aload_3
    //   684: aload_1
    //   685: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   688: aload_3
    //   689: iconst_1
    //   690: putfield 1685	gnu/mapping/CallContext:pc	I
    //   693: iconst_0
    //   694: ireturn
    //   695: aload_3
    //   696: aload_2
    //   697: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   700: aload_3
    //   701: aload_1
    //   702: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   705: aload_3
    //   706: iconst_1
    //   707: putfield 1685	gnu/mapping/CallContext:pc	I
    //   710: iconst_0
    //   711: ireturn
    //   712: aload_3
    //   713: aload_2
    //   714: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   717: aload_3
    //   718: aload_1
    //   719: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   722: aload_3
    //   723: iconst_1
    //   724: putfield 1685	gnu/mapping/CallContext:pc	I
    //   727: iconst_0
    //   728: ireturn
    //   729: aload_3
    //   730: aload_2
    //   731: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   734: aload_3
    //   735: aload_1
    //   736: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   739: aload_3
    //   740: iconst_1
    //   741: putfield 1685	gnu/mapping/CallContext:pc	I
    //   744: iconst_0
    //   745: ireturn
    //   746: aload_3
    //   747: aload_2
    //   748: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   751: aload_3
    //   752: aload_1
    //   753: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   756: aload_3
    //   757: iconst_1
    //   758: putfield 1685	gnu/mapping/CallContext:pc	I
    //   761: iconst_0
    //   762: ireturn
    //   763: aload_3
    //   764: aload_2
    //   765: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   768: aload_3
    //   769: aload_1
    //   770: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   773: aload_3
    //   774: iconst_1
    //   775: putfield 1685	gnu/mapping/CallContext:pc	I
    //   778: iconst_0
    //   779: ireturn
    //   780: aload_3
    //   781: aload_2
    //   782: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   785: aload_3
    //   786: aload_1
    //   787: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   790: aload_3
    //   791: iconst_1
    //   792: putfield 1685	gnu/mapping/CallContext:pc	I
    //   795: iconst_0
    //   796: ireturn
    //   797: aload_3
    //   798: aload_2
    //   799: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   802: aload_3
    //   803: aload_1
    //   804: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   807: aload_3
    //   808: iconst_1
    //   809: putfield 1685	gnu/mapping/CallContext:pc	I
    //   812: iconst_0
    //   813: ireturn
    //   814: aload_3
    //   815: aload_2
    //   816: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   819: aload_3
    //   820: aload_1
    //   821: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   824: aload_3
    //   825: iconst_1
    //   826: putfield 1685	gnu/mapping/CallContext:pc	I
    //   829: iconst_0
    //   830: ireturn
    //   831: aload_3
    //   832: aload_2
    //   833: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   836: aload_3
    //   837: aload_1
    //   838: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   841: aload_3
    //   842: iconst_1
    //   843: putfield 1685	gnu/mapping/CallContext:pc	I
    //   846: iconst_0
    //   847: ireturn
    //   848: aload_3
    //   849: aload_2
    //   850: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   853: aload_3
    //   854: aload_1
    //   855: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   858: aload_3
    //   859: iconst_1
    //   860: putfield 1685	gnu/mapping/CallContext:pc	I
    //   863: iconst_0
    //   864: ireturn
    //   865: aload_3
    //   866: aload_2
    //   867: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   870: aload_3
    //   871: aload_1
    //   872: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   875: aload_3
    //   876: iconst_1
    //   877: putfield 1685	gnu/mapping/CallContext:pc	I
    //   880: iconst_0
    //   881: ireturn
    //   882: aload_3
    //   883: aload_2
    //   884: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   887: aload_3
    //   888: aload_1
    //   889: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   892: aload_3
    //   893: iconst_1
    //   894: putfield 1685	gnu/mapping/CallContext:pc	I
    //   897: iconst_0
    //   898: ireturn
    //   899: aload_3
    //   900: aload_2
    //   901: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   904: dup
    //   905: invokestatic 1688	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   908: iflt +6 -> 914
    //   911: goto +7 -> 918
    //   914: ldc_w 1689
    //   917: ireturn
    //   918: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   921: aload_3
    //   922: aload_1
    //   923: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   926: aload_3
    //   927: iconst_1
    //   928: putfield 1685	gnu/mapping/CallContext:pc	I
    //   931: iconst_0
    //   932: ireturn
    //   933: aload_0
    //   934: aload_1
    //   935: aload_2
    //   936: aload_3
    //   937: invokespecial 1693	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   940: ireturn
    // Line number table:
    //   Java source line #1842	-> byte code offset #321
    //   Java source line #1836	-> byte code offset #338
    //   Java source line #1795	-> byte code offset #355
    //   Java source line #1648	-> byte code offset #372
    //   Java source line #1618	-> byte code offset #389
    //   Java source line #1577	-> byte code offset #406
    //   Java source line #1555	-> byte code offset #423
    //   Java source line #1108	-> byte code offset #440
    //   Java source line #1096	-> byte code offset #457
    //   Java source line #971	-> byte code offset #474
    //   Java source line #923	-> byte code offset #491
    //   Java source line #914	-> byte code offset #508
    //   Java source line #902	-> byte code offset #525
    //   Java source line #901	-> byte code offset #542
    //   Java source line #892	-> byte code offset #559
    //   Java source line #891	-> byte code offset #576
    //   Java source line #880	-> byte code offset #593
    //   Java source line #871	-> byte code offset #610
    //   Java source line #869	-> byte code offset #627
    //   Java source line #859	-> byte code offset #644
    //   Java source line #850	-> byte code offset #661
    //   Java source line #838	-> byte code offset #678
    //   Java source line #837	-> byte code offset #695
    //   Java source line #828	-> byte code offset #712
    //   Java source line #827	-> byte code offset #729
    //   Java source line #816	-> byte code offset #746
    //   Java source line #807	-> byte code offset #763
    //   Java source line #805	-> byte code offset #780
    //   Java source line #584	-> byte code offset #797
    //   Java source line #468	-> byte code offset #814
    //   Java source line #423	-> byte code offset #848
    //   Java source line #266	-> byte code offset #882
    //   Java source line #153	-> byte code offset #899
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+223->227, 38:+194->198, 100:+168->172, 101:+142->146, 102:+97->101, 103:+52->56
    //   56: aload 4
    //   58: aload_2
    //   59: ldc 43
    //   61: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: instanceof 43
    //   68: ifeq +6 -> 74
    //   71: goto +7 -> 78
    //   74: ldc_w 1689
    //   77: ireturn
    //   78: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   81: aload 4
    //   83: aload_3
    //   84: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   87: aload 4
    //   89: aload_1
    //   90: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   93: aload 4
    //   95: iconst_2
    //   96: putfield 1685	gnu/mapping/CallContext:pc	I
    //   99: iconst_0
    //   100: ireturn
    //   101: aload 4
    //   103: aload_2
    //   104: ldc 43
    //   106: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   109: dup
    //   110: instanceof 43
    //   113: ifeq +6 -> 119
    //   116: goto +7 -> 123
    //   119: ldc_w 1689
    //   122: ireturn
    //   123: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   126: aload 4
    //   128: aload_3
    //   129: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   132: aload 4
    //   134: aload_1
    //   135: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   138: aload 4
    //   140: iconst_2
    //   141: putfield 1685	gnu/mapping/CallContext:pc	I
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 4
    //   148: aload_2
    //   149: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   152: aload 4
    //   154: aload_3
    //   155: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   158: aload 4
    //   160: aload_1
    //   161: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   164: aload 4
    //   166: iconst_2
    //   167: putfield 1685	gnu/mapping/CallContext:pc	I
    //   170: iconst_0
    //   171: ireturn
    //   172: aload 4
    //   174: aload_2
    //   175: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   178: aload 4
    //   180: aload_3
    //   181: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   184: aload 4
    //   186: aload_1
    //   187: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   190: aload 4
    //   192: iconst_2
    //   193: putfield 1685	gnu/mapping/CallContext:pc	I
    //   196: iconst_0
    //   197: ireturn
    //   198: aload 4
    //   200: aload_2
    //   201: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   204: aload 4
    //   206: aload_3
    //   207: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   213: aload 4
    //   215: aload_1
    //   216: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   219: aload 4
    //   221: iconst_2
    //   222: putfield 1685	gnu/mapping/CallContext:pc	I
    //   225: iconst_0
    //   226: ireturn
    //   227: aload_0
    //   228: aload_1
    //   229: aload_2
    //   230: aload_3
    //   231: aload 4
    //   233: invokespecial 1700	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   236: ireturn
    // Line number table:
    //   Java source line #1063	-> byte code offset #56
    //   Java source line #1057	-> byte code offset #101
    //   Java source line #1050	-> byte code offset #146
    //   Java source line #1043	-> byte code offset #172
    //   Java source line #582	-> byte code offset #198
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+242->246, 15:+209->213, 17:+176->180, 18:+143->147, 22:+85->89, 97:+52->56
    //   56: aload 5
    //   58: aload_2
    //   59: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   62: aload 5
    //   64: aload_3
    //   65: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   68: aload 5
    //   70: aload 4
    //   72: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   75: aload 5
    //   77: aload_1
    //   78: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   81: aload 5
    //   83: iconst_3
    //   84: putfield 1685	gnu/mapping/CallContext:pc	I
    //   87: iconst_0
    //   88: ireturn
    //   89: aload 5
    //   91: aload_2
    //   92: ldc 43
    //   94: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   97: dup
    //   98: instanceof 43
    //   101: ifeq +6 -> 107
    //   104: goto +7 -> 111
    //   107: ldc_w 1689
    //   110: ireturn
    //   111: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   114: aload 5
    //   116: aload_3
    //   117: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   123: aload 5
    //   125: aload 4
    //   127: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   133: aload 5
    //   135: aload_1
    //   136: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   139: aload 5
    //   141: iconst_3
    //   142: putfield 1685	gnu/mapping/CallContext:pc	I
    //   145: iconst_0
    //   146: ireturn
    //   147: aload 5
    //   149: aload_2
    //   150: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   153: aload 5
    //   155: aload_3
    //   156: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   159: aload 5
    //   161: aload 4
    //   163: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   166: aload 5
    //   168: aload_1
    //   169: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   172: aload 5
    //   174: iconst_3
    //   175: putfield 1685	gnu/mapping/CallContext:pc	I
    //   178: iconst_0
    //   179: ireturn
    //   180: aload 5
    //   182: aload_2
    //   183: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   186: aload 5
    //   188: aload_3
    //   189: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   192: aload 5
    //   194: aload 4
    //   196: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   199: aload 5
    //   201: aload_1
    //   202: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   205: aload 5
    //   207: iconst_3
    //   208: putfield 1685	gnu/mapping/CallContext:pc	I
    //   211: iconst_0
    //   212: ireturn
    //   213: aload 5
    //   215: aload_2
    //   216: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   219: aload 5
    //   221: aload_3
    //   222: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   225: aload 5
    //   227: aload 4
    //   229: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   232: aload 5
    //   234: aload_1
    //   235: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   238: aload 5
    //   240: iconst_3
    //   241: putfield 1685	gnu/mapping/CallContext:pc	I
    //   244: iconst_0
    //   245: ireturn
    //   246: aload_0
    //   247: aload_1
    //   248: aload_2
    //   249: aload_3
    //   250: aload 4
    //   252: aload 5
    //   254: invokespecial 1707	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   257: ireturn
    // Line number table:
    //   Java source line #1002	-> byte code offset #56
    //   Java source line #277	-> byte code offset #89
    //   Java source line #220	-> byte code offset #147
    //   Java source line #215	-> byte code offset #180
    //   Java source line #184	-> byte code offset #213
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+277->281, 16:+212->216, 19:+172->176, 24:+132->136, 26:+92->96, 133:+52->56
    //   56: aload 6
    //   58: aload_2
    //   59: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   62: aload 6
    //   64: aload_3
    //   65: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   68: aload 6
    //   70: aload 4
    //   72: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   75: aload 6
    //   77: aload 5
    //   79: putfield 1710	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   82: aload 6
    //   84: aload_1
    //   85: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   88: aload 6
    //   90: iconst_4
    //   91: putfield 1685	gnu/mapping/CallContext:pc	I
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 6
    //   98: aload_2
    //   99: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   102: aload 6
    //   104: aload_3
    //   105: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   108: aload 6
    //   110: aload 4
    //   112: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   115: aload 6
    //   117: aload 5
    //   119: putfield 1710	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   122: aload 6
    //   124: aload_1
    //   125: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   128: aload 6
    //   130: iconst_4
    //   131: putfield 1685	gnu/mapping/CallContext:pc	I
    //   134: iconst_0
    //   135: ireturn
    //   136: aload 6
    //   138: aload_2
    //   139: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   142: aload 6
    //   144: aload_3
    //   145: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   148: aload 6
    //   150: aload 4
    //   152: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   155: aload 6
    //   157: aload 5
    //   159: putfield 1710	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   162: aload 6
    //   164: aload_1
    //   165: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   168: aload 6
    //   170: iconst_4
    //   171: putfield 1685	gnu/mapping/CallContext:pc	I
    //   174: iconst_0
    //   175: ireturn
    //   176: aload 6
    //   178: aload_2
    //   179: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   182: aload 6
    //   184: aload_3
    //   185: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   188: aload 6
    //   190: aload 4
    //   192: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   195: aload 6
    //   197: aload 5
    //   199: putfield 1710	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   202: aload 6
    //   204: aload_1
    //   205: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   208: aload 6
    //   210: iconst_4
    //   211: putfield 1685	gnu/mapping/CallContext:pc	I
    //   214: iconst_0
    //   215: ireturn
    //   216: aload 6
    //   218: aload_2
    //   219: putfield 1678	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   222: aload 6
    //   224: aload_3
    //   225: ldc 43
    //   227: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   230: dup
    //   231: instanceof 43
    //   234: ifeq +6 -> 240
    //   237: goto +7 -> 244
    //   240: ldc_w 1711
    //   243: ireturn
    //   244: putfield 1696	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   247: aload 6
    //   249: aload 4
    //   251: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   254: putfield 1703	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   257: aload 6
    //   259: aload 5
    //   261: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   264: putfield 1710	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   267: aload 6
    //   269: aload_1
    //   270: putfield 1682	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   273: aload 6
    //   275: iconst_4
    //   276: putfield 1685	gnu/mapping/CallContext:pc	I
    //   279: iconst_0
    //   280: ireturn
    //   281: aload_0
    //   282: aload_1
    //   283: aload_2
    //   284: aload_3
    //   285: aload 4
    //   287: aload 5
    //   289: aload 6
    //   291: invokespecial 1715	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   294: ireturn
    // Line number table:
    //   Java source line #1711	-> byte code offset #56
    //   Java source line #335	-> byte code offset #96
    //   Java source line #321	-> byte code offset #136
    //   Java source line #230	-> byte code offset #176
    //   Java source line #207	-> byte code offset #216
  }
  
  public void apply(CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+130->134, 15:+52->56, 17:+60->64, 18:+68->72, 22:+88->92, 97:+122->126
    //   56: aload_2
    //   57: aload_3
    //   58: aload 4
    //   60: invokestatic 145	gnu/kawa/slib/srfi13:stringParseStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: areturn
    //   64: aload_2
    //   65: aload_3
    //   66: aload 4
    //   68: invokestatic 208	gnu/kawa/slib/srfi13:stringParseFinalStart$PlEnd	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values;
    //   71: areturn
    //   72: aload_2
    //   73: aload_3
    //   74: aload 4
    //   76: invokestatic 151	gnu/kawa/slib/srfi13:isSubstringSpecOk	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   79: ifeq +9 -> 88
    //   82: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   85: goto +6 -> 91
    //   88: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   91: areturn
    //   92: aload_2
    //   93: ldc 43
    //   95: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: checkcast 43	java/lang/CharSequence
    //   101: aload_3
    //   102: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: checkcast 177	java/lang/Number
    //   108: invokevirtual 181	java/lang/Number:intValue	()I
    //   111: aload 4
    //   113: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 177	java/lang/Number
    //   119: invokevirtual 181	java/lang/Number:intValue	()I
    //   122: invokestatic 188	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   125: areturn
    //   126: aload_2
    //   127: aload_3
    //   128: aload 4
    //   130: invokestatic 649	gnu/kawa/slib/srfi13:$PcStringTitlecase$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: areturn
    //   134: aload_0
    //   135: aload_1
    //   136: aload_2
    //   137: aload_3
    //   138: aload 4
    //   140: invokespecial 1863	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: areturn
    //   144: new 53	gnu/mapping/WrongType
    //   147: dup_x1
    //   148: swap
    //   149: ldc -84
    //   151: iconst_1
    //   152: aload_2
    //   153: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   156: athrow
    //   157: new 53	gnu/mapping/WrongType
    //   160: dup_x1
    //   161: swap
    //   162: ldc -84
    //   164: iconst_2
    //   165: aload_3
    //   166: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   169: athrow
    //   170: new 53	gnu/mapping/WrongType
    //   173: dup_x1
    //   174: swap
    //   175: ldc -84
    //   177: iconst_3
    //   178: aload 4
    //   180: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    // Line number table:
    //   Java source line #184	-> byte code offset #56
    //   Java source line #215	-> byte code offset #64
    //   Java source line #220	-> byte code offset #72
    //   Java source line #277	-> byte code offset #92
    //   Java source line #1002	-> byte code offset #126
    //   Java source line #277	-> byte code offset #144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	srfi13
    //   0	184	1	paramModuleMethod	ModuleMethod
    //   0	184	2	paramObject1	Object
    //   0	184	3	paramObject2	Object
    //   0	184	4	paramObject3	Object
    //   144	1	5	localClassCastException1	ClassCastException
    //   157	1	6	localClassCastException2	ClassCastException
    //   170	1	7	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   98	101	144	java/lang/ClassCastException
    //   105	111	157	java/lang/ClassCastException
    //   116	122	170	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+134->138, 16:+52->56, 19:+91->95, 24:+104->108, 26:+114->118, 133:+124->128
    //   56: aload_2
    //   57: aload_3
    //   58: ldc 43
    //   60: invokestatic 49	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   63: checkcast 43	java/lang/CharSequence
    //   66: aload 4
    //   68: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 177	java/lang/Number
    //   74: invokevirtual 181	java/lang/Number:intValue	()I
    //   77: aload 5
    //   79: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 177	java/lang/Number
    //   85: invokevirtual 181	java/lang/Number:intValue	()I
    //   88: invokestatic 1869	gnu/kawa/slib/srfi13:$PcCheckBounds	(Ljava/lang/Object;Ljava/lang/CharSequence;II)V
    //   91: getstatic 276	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   94: areturn
    //   95: aload_2
    //   96: aload_3
    //   97: aload 4
    //   99: aload 5
    //   101: invokestatic 921	gnu/kawa/slib/srfi13:checkSubstringSpec	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   104: getstatic 276	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   107: areturn
    //   108: aload_2
    //   109: aload_3
    //   110: aload 4
    //   112: aload 5
    //   114: invokestatic 212	gnu/kawa/slib/srfi13:$PcStringMap	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
    //   117: areturn
    //   118: aload_2
    //   119: aload_3
    //   120: aload 4
    //   122: aload 5
    //   124: invokestatic 270	gnu/kawa/slib/srfi13:$PcStringMap$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: areturn
    //   128: aload_2
    //   129: aload_3
    //   130: aload 4
    //   132: aload 5
    //   134: invokestatic 911	gnu/kawa/slib/srfi13:$PcFinishStringConcatenateReverse	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
    //   137: areturn
    //   138: aload_0
    //   139: aload_1
    //   140: aload_2
    //   141: aload_3
    //   142: aload 4
    //   144: aload 5
    //   146: invokespecial 1873	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: areturn
    //   150: new 53	gnu/mapping/WrongType
    //   153: dup_x1
    //   154: swap
    //   155: ldc_w 1865
    //   158: iconst_2
    //   159: aload_3
    //   160: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   163: athrow
    //   164: new 53	gnu/mapping/WrongType
    //   167: dup_x1
    //   168: swap
    //   169: ldc_w 1865
    //   172: iconst_3
    //   173: aload 4
    //   175: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   178: athrow
    //   179: new 53	gnu/mapping/WrongType
    //   182: dup_x1
    //   183: swap
    //   184: ldc_w 1865
    //   187: iconst_4
    //   188: aload 5
    //   190: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   193: athrow
    // Line number table:
    //   Java source line #207	-> byte code offset #56
    //   Java source line #230	-> byte code offset #95
    //   Java source line #321	-> byte code offset #108
    //   Java source line #335	-> byte code offset #118
    //   Java source line #1711	-> byte code offset #128
    //   Java source line #207	-> byte code offset #150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	srfi13
    //   0	194	1	paramModuleMethod	ModuleMethod
    //   0	194	2	paramObject1	Object
    //   0	194	3	paramObject2	Object
    //   0	194	4	paramObject3	Object
    //   0	194	5	paramObject4	Object
    //   150	1	6	localClassCastException1	ClassCastException
    //   164	1	7	localClassCastException2	ClassCastException
    //   179	1	8	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   63	66	150	java/lang/ClassCastException
    //   71	77	164	java/lang/ClassCastException
    //   82	88	179	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+3410->3414, 21:+504->508, 22:+3410->3414, 23:+541->545, 24:+3410->3414, 25:+578->582, 26:+3410->3414, 27:+615->619, 28:+655->659, 29:+3410->3414, 30:+3410->3414, 31:+695->699, 32:+3410->3414, 33:+3410->3414, 34:+738->742, 35:+781->785, 36:+818->822, 37:+3410->3414, 38:+3410->3414, 39:+855->859, 40:+877->881, 41:+899->903, 42:+968->972, 43:+1037->1041, 44:+1074->1078, 45:+1111->1115, 46:+1151->1155, 47:+1191->1195, 48:+1240->1244, 49:+1289->1293, 50:+1338->1342, 51:+1387->1391, 52:+1421->1425, 53:+1455->1459, 54:+1489->1493, 55:+1523->1527, 56:+1557->1561, 57:+1591->1595, 58:+1637->1641, 59:+3410->3414, 60:+3410->3414, 61:+1683->1687, 62:+3410->3414, 63:+1720->1724, 64:+3410->3414, 65:+3410->3414, 66:+1757->1761, 67:+3410->3414, 68:+3410->3414, 69:+1794->1798, 70:+3410->3414, 71:+1831->1835, 72:+3410->3414, 73:+1868->1872, 74:+3410->3414, 75:+3410->3414, 76:+1905->1909, 77:+3410->3414, 78:+1942->1946, 79:+3410->3414, 80:+3410->3414, 81:+1979->1983, 82:+3410->3414, 83:+3410->3414, 84:+2016->2020, 85:+3410->3414, 86:+2053->2057, 87:+3410->3414, 88:+2090->2094, 89:+2127->2131, 90:+2146->2150, 91:+3410->3414, 92:+2180->2184, 93:+2214->2218, 94:+2248->2252, 95:+2282->2286, 96:+2316->2320, 97:+3410->3414, 98:+2350->2354, 99:+2384->2388, 100:+3410->3414, 101:+3410->3414, 102:+3410->3414, 103:+3410->3414, 104:+2418->2422, 105:+2452->2456, 106:+2486->2490, 107:+3410->3414, 108:+2520->2524, 109:+3410->3414, 110:+2557->2561, 111:+2594->2598, 112:+2631->2635, 113:+2668->2672, 114:+2705->2709, 115:+2742->2746, 116:+2779->2783, 117:+2816->2820, 118:+2853->2857, 119:+2890->2894, 120:+2927->2931, 121:+2953->2957, 122:+2987->2991, 123:+3009->3013, 124:+3410->3414, 125:+3052->3056, 126:+3086->3090, 127:+3410->3414, 128:+3120->3124, 129:+3410->3414, 130:+3410->3414, 131:+3125->3129, 132:+3159->3163, 133:+3410->3414, 134:+3193->3197, 135:+3236->3240, 136:+3410->3414, 137:+3270->3274, 138:+3410->3414, 139:+3410->3414, 140:+3307->3311, 141:+3350->3354, 142:+3376->3380
    //   508: aload_2
    //   509: iconst_0
    //   510: aaload
    //   511: aload_2
    //   512: iconst_1
    //   513: aaload
    //   514: aload_2
    //   515: arraylength
    //   516: iconst_2
    //   517: isub
    //   518: istore_3
    //   519: iload_3
    //   520: anewarray 27	java/lang/Object
    //   523: goto +11 -> 534
    //   526: dup
    //   527: iload_3
    //   528: aload_2
    //   529: iload_3
    //   530: iconst_2
    //   531: iadd
    //   532: aaload
    //   533: aastore
    //   534: iinc 3 -1
    //   537: iload_3
    //   538: ifge -12 -> 526
    //   541: invokestatic 914	gnu/kawa/slib/srfi13:substring$SlShared$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   544: areturn
    //   545: aload_2
    //   546: iconst_0
    //   547: aaload
    //   548: aload_2
    //   549: iconst_1
    //   550: aaload
    //   551: aload_2
    //   552: arraylength
    //   553: iconst_2
    //   554: isub
    //   555: istore_3
    //   556: iload_3
    //   557: anewarray 27	java/lang/Object
    //   560: goto +11 -> 571
    //   563: dup
    //   564: iload_3
    //   565: aload_2
    //   566: iload_3
    //   567: iconst_2
    //   568: iadd
    //   569: aaload
    //   570: aastore
    //   571: iinc 3 -1
    //   574: iload_3
    //   575: ifge -12 -> 563
    //   578: invokestatic 1877	gnu/kawa/slib/srfi13:stringMap$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FString;
    //   581: areturn
    //   582: aload_2
    //   583: iconst_0
    //   584: aaload
    //   585: aload_2
    //   586: iconst_1
    //   587: aaload
    //   588: aload_2
    //   589: arraylength
    //   590: iconst_2
    //   591: isub
    //   592: istore_3
    //   593: iload_3
    //   594: anewarray 27	java/lang/Object
    //   597: goto +11 -> 608
    //   600: dup
    //   601: iload_3
    //   602: aload_2
    //   603: iload_3
    //   604: iconst_2
    //   605: iadd
    //   606: aaload
    //   607: aastore
    //   608: iinc 3 -1
    //   611: iload_3
    //   612: ifge -12 -> 600
    //   615: invokestatic 1880	gnu/kawa/slib/srfi13:stringMap$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   618: areturn
    //   619: aload_2
    //   620: iconst_0
    //   621: aaload
    //   622: aload_2
    //   623: iconst_1
    //   624: aaload
    //   625: aload_2
    //   626: iconst_2
    //   627: aaload
    //   628: aload_2
    //   629: arraylength
    //   630: iconst_3
    //   631: isub
    //   632: istore_3
    //   633: iload_3
    //   634: anewarray 27	java/lang/Object
    //   637: goto +11 -> 648
    //   640: dup
    //   641: iload_3
    //   642: aload_2
    //   643: iload_3
    //   644: iconst_3
    //   645: iadd
    //   646: aaload
    //   647: aastore
    //   648: iinc 3 -1
    //   651: iload_3
    //   652: ifge -12 -> 640
    //   655: invokestatic 759	gnu/kawa/slib/srfi13:stringFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   658: areturn
    //   659: aload_2
    //   660: iconst_0
    //   661: aaload
    //   662: aload_2
    //   663: iconst_1
    //   664: aaload
    //   665: aload_2
    //   666: iconst_2
    //   667: aaload
    //   668: aload_2
    //   669: arraylength
    //   670: iconst_3
    //   671: isub
    //   672: istore_3
    //   673: iload_3
    //   674: anewarray 27	java/lang/Object
    //   677: goto +11 -> 688
    //   680: dup
    //   681: iload_3
    //   682: aload_2
    //   683: iload_3
    //   684: iconst_3
    //   685: iadd
    //   686: aaload
    //   687: aastore
    //   688: iinc 3 -1
    //   691: iload_3
    //   692: ifge -12 -> 680
    //   695: invokestatic 1883	gnu/kawa/slib/srfi13:stringFoldRight$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   698: areturn
    //   699: aload_2
    //   700: iconst_0
    //   701: aaload
    //   702: aload_2
    //   703: iconst_1
    //   704: aaload
    //   705: aload_2
    //   706: iconst_2
    //   707: aaload
    //   708: aload_2
    //   709: iconst_3
    //   710: aaload
    //   711: aload_2
    //   712: arraylength
    //   713: iconst_4
    //   714: isub
    //   715: istore_3
    //   716: iload_3
    //   717: anewarray 27	java/lang/Object
    //   720: goto +11 -> 731
    //   723: dup
    //   724: iload_3
    //   725: aload_2
    //   726: iload_3
    //   727: iconst_4
    //   728: iadd
    //   729: aaload
    //   730: aastore
    //   731: iinc 3 -1
    //   734: iload_3
    //   735: ifge -12 -> 723
    //   738: invokestatic 1887	gnu/kawa/slib/srfi13:stringUnfold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   741: areturn
    //   742: aload_2
    //   743: iconst_0
    //   744: aaload
    //   745: aload_2
    //   746: iconst_1
    //   747: aaload
    //   748: aload_2
    //   749: iconst_2
    //   750: aaload
    //   751: aload_2
    //   752: iconst_3
    //   753: aaload
    //   754: aload_2
    //   755: arraylength
    //   756: iconst_4
    //   757: isub
    //   758: istore_3
    //   759: iload_3
    //   760: anewarray 27	java/lang/Object
    //   763: goto +11 -> 774
    //   766: dup
    //   767: iload_3
    //   768: aload_2
    //   769: iload_3
    //   770: iconst_4
    //   771: iadd
    //   772: aaload
    //   773: aastore
    //   774: iinc 3 -1
    //   777: iload_3
    //   778: ifge -12 -> 766
    //   781: invokestatic 1890	gnu/kawa/slib/srfi13:stringUnfoldRight$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   784: areturn
    //   785: aload_2
    //   786: iconst_0
    //   787: aaload
    //   788: aload_2
    //   789: iconst_1
    //   790: aaload
    //   791: aload_2
    //   792: arraylength
    //   793: iconst_2
    //   794: isub
    //   795: istore_3
    //   796: iload_3
    //   797: anewarray 27	java/lang/Object
    //   800: goto +11 -> 811
    //   803: dup
    //   804: iload_3
    //   805: aload_2
    //   806: iload_3
    //   807: iconst_2
    //   808: iadd
    //   809: aaload
    //   810: aastore
    //   811: iinc 3 -1
    //   814: iload_3
    //   815: ifge -12 -> 803
    //   818: invokestatic 1893	gnu/kawa/slib/srfi13:stringEvery$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   821: areturn
    //   822: aload_2
    //   823: iconst_0
    //   824: aaload
    //   825: aload_2
    //   826: iconst_1
    //   827: aaload
    //   828: aload_2
    //   829: arraylength
    //   830: iconst_2
    //   831: isub
    //   832: istore_3
    //   833: iload_3
    //   834: anewarray 27	java/lang/Object
    //   837: goto +11 -> 848
    //   840: dup
    //   841: iload_3
    //   842: aload_2
    //   843: iload_3
    //   844: iconst_2
    //   845: iadd
    //   846: aaload
    //   847: aastore
    //   848: iinc 3 -1
    //   851: iload_3
    //   852: ifge -12 -> 840
    //   855: invokestatic 1896	gnu/kawa/slib/srfi13:stringAny$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   858: areturn
    //   859: aload_2
    //   860: iconst_0
    //   861: aaload
    //   862: aload_2
    //   863: iconst_1
    //   864: aaload
    //   865: aload_2
    //   866: iconst_2
    //   867: aaload
    //   868: aload_2
    //   869: iconst_3
    //   870: aaload
    //   871: aload_2
    //   872: iconst_4
    //   873: aaload
    //   874: aload_2
    //   875: iconst_5
    //   876: aaload
    //   877: invokestatic 407	gnu/kawa/slib/srfi13:$PcStringPrefixLength	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   880: areturn
    //   881: aload_2
    //   882: iconst_0
    //   883: aaload
    //   884: aload_2
    //   885: iconst_1
    //   886: aaload
    //   887: aload_2
    //   888: iconst_2
    //   889: aaload
    //   890: aload_2
    //   891: iconst_3
    //   892: aaload
    //   893: aload_2
    //   894: iconst_4
    //   895: aaload
    //   896: aload_2
    //   897: iconst_5
    //   898: aaload
    //   899: invokestatic 413	gnu/kawa/slib/srfi13:$PcStringSuffixLength	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   902: areturn
    //   903: aload_2
    //   904: iconst_0
    //   905: aaload
    //   906: aload_2
    //   907: iconst_1
    //   908: aaload
    //   909: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   912: dup
    //   913: astore_3
    //   914: checkcast 177	java/lang/Number
    //   917: invokevirtual 181	java/lang/Number:intValue	()I
    //   920: aload_2
    //   921: iconst_2
    //   922: aaload
    //   923: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   926: dup
    //   927: astore_3
    //   928: checkcast 177	java/lang/Number
    //   931: invokevirtual 181	java/lang/Number:intValue	()I
    //   934: aload_2
    //   935: iconst_3
    //   936: aaload
    //   937: aload_2
    //   938: iconst_4
    //   939: aaload
    //   940: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   943: dup
    //   944: astore_3
    //   945: checkcast 177	java/lang/Number
    //   948: invokevirtual 181	java/lang/Number:intValue	()I
    //   951: aload_2
    //   952: iconst_5
    //   953: aaload
    //   954: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   957: dup
    //   958: astore_3
    //   959: checkcast 177	java/lang/Number
    //   962: invokevirtual 181	java/lang/Number:intValue	()I
    //   965: invokestatic 422	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   968: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   971: areturn
    //   972: aload_2
    //   973: iconst_0
    //   974: aaload
    //   975: aload_2
    //   976: iconst_1
    //   977: aaload
    //   978: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   981: dup
    //   982: astore_3
    //   983: checkcast 177	java/lang/Number
    //   986: invokevirtual 181	java/lang/Number:intValue	()I
    //   989: aload_2
    //   990: iconst_2
    //   991: aaload
    //   992: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   995: dup
    //   996: astore_3
    //   997: checkcast 177	java/lang/Number
    //   1000: invokevirtual 181	java/lang/Number:intValue	()I
    //   1003: aload_2
    //   1004: iconst_3
    //   1005: aaload
    //   1006: aload_2
    //   1007: iconst_4
    //   1008: aaload
    //   1009: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1012: dup
    //   1013: astore_3
    //   1014: checkcast 177	java/lang/Number
    //   1017: invokevirtual 181	java/lang/Number:intValue	()I
    //   1020: aload_2
    //   1021: iconst_5
    //   1022: aaload
    //   1023: invokestatic 175	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1026: dup
    //   1027: astore_3
    //   1028: checkcast 177	java/lang/Number
    //   1031: invokevirtual 181	java/lang/Number:intValue	()I
    //   1034: invokestatic 430	gnu/kawa/slib/srfi13:$PcStringSuffixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   1037: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1040: areturn
    //   1041: aload_2
    //   1042: iconst_0
    //   1043: aaload
    //   1044: aload_2
    //   1045: iconst_1
    //   1046: aaload
    //   1047: aload_2
    //   1048: arraylength
    //   1049: iconst_2
    //   1050: isub
    //   1051: istore_3
    //   1052: iload_3
    //   1053: anewarray 27	java/lang/Object
    //   1056: goto +11 -> 1067
    //   1059: dup
    //   1060: iload_3
    //   1061: aload_2
    //   1062: iload_3
    //   1063: iconst_2
    //   1064: iadd
    //   1065: aaload
    //   1066: aastore
    //   1067: iinc 3 -1
    //   1070: iload_3
    //   1071: ifge -12 -> 1059
    //   1074: invokestatic 1899	gnu/kawa/slib/srfi13:stringPrefixLength$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1077: areturn
    //   1078: aload_2
    //   1079: iconst_0
    //   1080: aaload
    //   1081: aload_2
    //   1082: iconst_1
    //   1083: aaload
    //   1084: aload_2
    //   1085: arraylength
    //   1086: iconst_2
    //   1087: isub
    //   1088: istore_3
    //   1089: iload_3
    //   1090: anewarray 27	java/lang/Object
    //   1093: goto +11 -> 1104
    //   1096: dup
    //   1097: iload_3
    //   1098: aload_2
    //   1099: iload_3
    //   1100: iconst_2
    //   1101: iadd
    //   1102: aaload
    //   1103: aastore
    //   1104: iinc 3 -1
    //   1107: iload_3
    //   1108: ifge -12 -> 1096
    //   1111: invokestatic 1902	gnu/kawa/slib/srfi13:stringSuffixLength$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1114: areturn
    //   1115: aload_2
    //   1116: iconst_0
    //   1117: aaload
    //   1118: aload_2
    //   1119: iconst_1
    //   1120: aaload
    //   1121: aload_2
    //   1122: arraylength
    //   1123: iconst_2
    //   1124: isub
    //   1125: istore_3
    //   1126: iload_3
    //   1127: anewarray 27	java/lang/Object
    //   1130: goto +11 -> 1141
    //   1133: dup
    //   1134: iload_3
    //   1135: aload_2
    //   1136: iload_3
    //   1137: iconst_2
    //   1138: iadd
    //   1139: aaload
    //   1140: aastore
    //   1141: iinc 3 -1
    //   1144: iload_3
    //   1145: ifge -12 -> 1133
    //   1148: invokestatic 1906	gnu/kawa/slib/srfi13:stringPrefixLengthCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)I
    //   1151: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1154: areturn
    //   1155: aload_2
    //   1156: iconst_0
    //   1157: aaload
    //   1158: aload_2
    //   1159: iconst_1
    //   1160: aaload
    //   1161: aload_2
    //   1162: arraylength
    //   1163: iconst_2
    //   1164: isub
    //   1165: istore_3
    //   1166: iload_3
    //   1167: anewarray 27	java/lang/Object
    //   1170: goto +11 -> 1181
    //   1173: dup
    //   1174: iload_3
    //   1175: aload_2
    //   1176: iload_3
    //   1177: iconst_2
    //   1178: iadd
    //   1179: aaload
    //   1180: aastore
    //   1181: iinc 3 -1
    //   1184: iload_3
    //   1185: ifge -12 -> 1173
    //   1188: invokestatic 1909	gnu/kawa/slib/srfi13:stringSuffixLengthCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)I
    //   1191: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1194: areturn
    //   1195: aload_2
    //   1196: iconst_0
    //   1197: aaload
    //   1198: aload_2
    //   1199: iconst_1
    //   1200: aaload
    //   1201: aload_2
    //   1202: arraylength
    //   1203: iconst_2
    //   1204: isub
    //   1205: istore_3
    //   1206: iload_3
    //   1207: anewarray 27	java/lang/Object
    //   1210: goto +11 -> 1221
    //   1213: dup
    //   1214: iload_3
    //   1215: aload_2
    //   1216: iload_3
    //   1217: iconst_2
    //   1218: iadd
    //   1219: aaload
    //   1220: aastore
    //   1221: iinc 3 -1
    //   1224: iload_3
    //   1225: ifge -12 -> 1213
    //   1228: invokestatic 1913	gnu/kawa/slib/srfi13:isStringPrefix$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   1231: ifeq +9 -> 1240
    //   1234: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1237: goto +6 -> 1243
    //   1240: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1243: areturn
    //   1244: aload_2
    //   1245: iconst_0
    //   1246: aaload
    //   1247: aload_2
    //   1248: iconst_1
    //   1249: aaload
    //   1250: aload_2
    //   1251: arraylength
    //   1252: iconst_2
    //   1253: isub
    //   1254: istore_3
    //   1255: iload_3
    //   1256: anewarray 27	java/lang/Object
    //   1259: goto +11 -> 1270
    //   1262: dup
    //   1263: iload_3
    //   1264: aload_2
    //   1265: iload_3
    //   1266: iconst_2
    //   1267: iadd
    //   1268: aaload
    //   1269: aastore
    //   1270: iinc 3 -1
    //   1273: iload_3
    //   1274: ifge -12 -> 1262
    //   1277: invokestatic 1916	gnu/kawa/slib/srfi13:isStringSuffix$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   1280: ifeq +9 -> 1289
    //   1283: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1286: goto +6 -> 1292
    //   1289: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1292: areturn
    //   1293: aload_2
    //   1294: iconst_0
    //   1295: aaload
    //   1296: aload_2
    //   1297: iconst_1
    //   1298: aaload
    //   1299: aload_2
    //   1300: arraylength
    //   1301: iconst_2
    //   1302: isub
    //   1303: istore_3
    //   1304: iload_3
    //   1305: anewarray 27	java/lang/Object
    //   1308: goto +11 -> 1319
    //   1311: dup
    //   1312: iload_3
    //   1313: aload_2
    //   1314: iload_3
    //   1315: iconst_2
    //   1316: iadd
    //   1317: aaload
    //   1318: aastore
    //   1319: iinc 3 -1
    //   1322: iload_3
    //   1323: ifge -12 -> 1311
    //   1326: invokestatic 1919	gnu/kawa/slib/srfi13:isStringPrefixCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   1329: ifeq +9 -> 1338
    //   1332: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1335: goto +6 -> 1341
    //   1338: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1341: areturn
    //   1342: aload_2
    //   1343: iconst_0
    //   1344: aaload
    //   1345: aload_2
    //   1346: iconst_1
    //   1347: aaload
    //   1348: aload_2
    //   1349: arraylength
    //   1350: iconst_2
    //   1351: isub
    //   1352: istore_3
    //   1353: iload_3
    //   1354: anewarray 27	java/lang/Object
    //   1357: goto +11 -> 1368
    //   1360: dup
    //   1361: iload_3
    //   1362: aload_2
    //   1363: iload_3
    //   1364: iconst_2
    //   1365: iadd
    //   1366: aaload
    //   1367: aastore
    //   1368: iinc 3 -1
    //   1371: iload_3
    //   1372: ifge -12 -> 1360
    //   1375: invokestatic 1922	gnu/kawa/slib/srfi13:isStringSuffixCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   1378: ifeq +9 -> 1387
    //   1381: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1384: goto +6 -> 1390
    //   1387: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1390: areturn
    //   1391: aload_2
    //   1392: iconst_0
    //   1393: aaload
    //   1394: aload_2
    //   1395: iconst_1
    //   1396: aaload
    //   1397: aload_2
    //   1398: iconst_2
    //   1399: aaload
    //   1400: aload_2
    //   1401: iconst_3
    //   1402: aaload
    //   1403: aload_2
    //   1404: iconst_4
    //   1405: aaload
    //   1406: aload_2
    //   1407: iconst_5
    //   1408: aaload
    //   1409: invokestatic 437	gnu/kawa/slib/srfi13:$PcStringPrefix$Qu	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1412: ifeq +9 -> 1421
    //   1415: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1418: goto +6 -> 1424
    //   1421: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1424: areturn
    //   1425: aload_2
    //   1426: iconst_0
    //   1427: aaload
    //   1428: aload_2
    //   1429: iconst_1
    //   1430: aaload
    //   1431: aload_2
    //   1432: iconst_2
    //   1433: aaload
    //   1434: aload_2
    //   1435: iconst_3
    //   1436: aaload
    //   1437: aload_2
    //   1438: iconst_4
    //   1439: aaload
    //   1440: aload_2
    //   1441: iconst_5
    //   1442: aaload
    //   1443: invokestatic 443	gnu/kawa/slib/srfi13:$PcStringSuffix$Qu	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1446: ifeq +9 -> 1455
    //   1449: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1452: goto +6 -> 1458
    //   1455: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1458: areturn
    //   1459: aload_2
    //   1460: iconst_0
    //   1461: aaload
    //   1462: aload_2
    //   1463: iconst_1
    //   1464: aaload
    //   1465: aload_2
    //   1466: iconst_2
    //   1467: aaload
    //   1468: aload_2
    //   1469: iconst_3
    //   1470: aaload
    //   1471: aload_2
    //   1472: iconst_4
    //   1473: aaload
    //   1474: aload_2
    //   1475: iconst_5
    //   1476: aaload
    //   1477: invokestatic 449	gnu/kawa/slib/srfi13:$PcStringPrefixCi$Qu	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1480: ifeq +9 -> 1489
    //   1483: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1486: goto +6 -> 1492
    //   1489: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1492: areturn
    //   1493: aload_2
    //   1494: iconst_0
    //   1495: aaload
    //   1496: aload_2
    //   1497: iconst_1
    //   1498: aaload
    //   1499: aload_2
    //   1500: iconst_2
    //   1501: aaload
    //   1502: aload_2
    //   1503: iconst_3
    //   1504: aaload
    //   1505: aload_2
    //   1506: iconst_4
    //   1507: aaload
    //   1508: aload_2
    //   1509: iconst_5
    //   1510: aaload
    //   1511: invokestatic 455	gnu/kawa/slib/srfi13:$PcStringSuffixCi$Qu	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1514: ifeq +9 -> 1523
    //   1517: getstatic 366	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1520: goto +6 -> 1526
    //   1523: getstatic 369	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1526: areturn
    //   1527: aload_2
    //   1528: iconst_0
    //   1529: aaload
    //   1530: aload_2
    //   1531: iconst_1
    //   1532: aaload
    //   1533: aload_2
    //   1534: iconst_2
    //   1535: aaload
    //   1536: aload_2
    //   1537: iconst_3
    //   1538: aaload
    //   1539: aload_2
    //   1540: iconst_4
    //   1541: aaload
    //   1542: aload_2
    //   1543: iconst_5
    //   1544: aaload
    //   1545: aload_2
    //   1546: bipush 6
    //   1548: aaload
    //   1549: aload_2
    //   1550: bipush 7
    //   1552: aaload
    //   1553: aload_2
    //   1554: bipush 8
    //   1556: aaload
    //   1557: invokestatic 462	gnu/kawa/slib/srfi13:$PcStringCompare	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1560: areturn
    //   1561: aload_2
    //   1562: iconst_0
    //   1563: aaload
    //   1564: aload_2
    //   1565: iconst_1
    //   1566: aaload
    //   1567: aload_2
    //   1568: iconst_2
    //   1569: aaload
    //   1570: aload_2
    //   1571: iconst_3
    //   1572: aaload
    //   1573: aload_2
    //   1574: iconst_4
    //   1575: aaload
    //   1576: aload_2
    //   1577: iconst_5
    //   1578: aaload
    //   1579: aload_2
    //   1580: bipush 6
    //   1582: aaload
    //   1583: aload_2
    //   1584: bipush 7
    //   1586: aaload
    //   1587: aload_2
    //   1588: bipush 8
    //   1590: aaload
    //   1591: invokestatic 468	gnu/kawa/slib/srfi13:$PcStringCompareCi	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1594: areturn
    //   1595: aload_2
    //   1596: iconst_0
    //   1597: aaload
    //   1598: aload_2
    //   1599: iconst_1
    //   1600: aaload
    //   1601: aload_2
    //   1602: iconst_2
    //   1603: aaload
    //   1604: aload_2
    //   1605: iconst_3
    //   1606: aaload
    //   1607: aload_2
    //   1608: iconst_4
    //   1609: aaload
    //   1610: aload_2
    //   1611: arraylength
    //   1612: iconst_5
    //   1613: isub
    //   1614: istore_3
    //   1615: iload_3
    //   1616: anewarray 27	java/lang/Object
    //   1619: goto +11 -> 1630
    //   1622: dup
    //   1623: iload_3
    //   1624: aload_2
    //   1625: iload_3
    //   1626: iconst_5
    //   1627: iadd
    //   1628: aaload
    //   1629: aastore
    //   1630: iinc 3 -1
    //   1633: iload_3
    //   1634: ifge -12 -> 1622
    //   1637: invokestatic 1926	gnu/kawa/slib/srfi13:stringCompare$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1640: areturn
    //   1641: aload_2
    //   1642: iconst_0
    //   1643: aaload
    //   1644: aload_2
    //   1645: iconst_1
    //   1646: aaload
    //   1647: aload_2
    //   1648: iconst_2
    //   1649: aaload
    //   1650: aload_2
    //   1651: iconst_3
    //   1652: aaload
    //   1653: aload_2
    //   1654: iconst_4
    //   1655: aaload
    //   1656: aload_2
    //   1657: arraylength
    //   1658: iconst_5
    //   1659: isub
    //   1660: istore_3
    //   1661: iload_3
    //   1662: anewarray 27	java/lang/Object
    //   1665: goto +11 -> 1676
    //   1668: dup
    //   1669: iload_3
    //   1670: aload_2
    //   1671: iload_3
    //   1672: iconst_5
    //   1673: iadd
    //   1674: aaload
    //   1675: aastore
    //   1676: iinc 3 -1
    //   1679: iload_3
    //   1680: ifge -12 -> 1668
    //   1683: invokestatic 1929	gnu/kawa/slib/srfi13:stringCompareCi$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1686: areturn
    //   1687: aload_2
    //   1688: iconst_0
    //   1689: aaload
    //   1690: aload_2
    //   1691: iconst_1
    //   1692: aaload
    //   1693: aload_2
    //   1694: arraylength
    //   1695: iconst_2
    //   1696: isub
    //   1697: istore_3
    //   1698: iload_3
    //   1699: anewarray 27	java/lang/Object
    //   1702: goto +11 -> 1713
    //   1705: dup
    //   1706: iload_3
    //   1707: aload_2
    //   1708: iload_3
    //   1709: iconst_2
    //   1710: iadd
    //   1711: aaload
    //   1712: aastore
    //   1713: iinc 3 -1
    //   1716: iload_3
    //   1717: ifge -12 -> 1705
    //   1720: invokestatic 1932	gnu/kawa/slib/srfi13:string$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1723: areturn
    //   1724: aload_2
    //   1725: iconst_0
    //   1726: aaload
    //   1727: aload_2
    //   1728: iconst_1
    //   1729: aaload
    //   1730: aload_2
    //   1731: arraylength
    //   1732: iconst_2
    //   1733: isub
    //   1734: istore_3
    //   1735: iload_3
    //   1736: anewarray 27	java/lang/Object
    //   1739: goto +11 -> 1750
    //   1742: dup
    //   1743: iload_3
    //   1744: aload_2
    //   1745: iload_3
    //   1746: iconst_2
    //   1747: iadd
    //   1748: aaload
    //   1749: aastore
    //   1750: iinc 3 -1
    //   1753: iload_3
    //   1754: ifge -12 -> 1742
    //   1757: invokestatic 1935	gnu/kawa/slib/srfi13:string$Ls$Gr$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1760: areturn
    //   1761: aload_2
    //   1762: iconst_0
    //   1763: aaload
    //   1764: aload_2
    //   1765: iconst_1
    //   1766: aaload
    //   1767: aload_2
    //   1768: arraylength
    //   1769: iconst_2
    //   1770: isub
    //   1771: istore_3
    //   1772: iload_3
    //   1773: anewarray 27	java/lang/Object
    //   1776: goto +11 -> 1787
    //   1779: dup
    //   1780: iload_3
    //   1781: aload_2
    //   1782: iload_3
    //   1783: iconst_2
    //   1784: iadd
    //   1785: aaload
    //   1786: aastore
    //   1787: iinc 3 -1
    //   1790: iload_3
    //   1791: ifge -12 -> 1779
    //   1794: invokestatic 1938	gnu/kawa/slib/srfi13:string$Ls$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1797: areturn
    //   1798: aload_2
    //   1799: iconst_0
    //   1800: aaload
    //   1801: aload_2
    //   1802: iconst_1
    //   1803: aaload
    //   1804: aload_2
    //   1805: arraylength
    //   1806: iconst_2
    //   1807: isub
    //   1808: istore_3
    //   1809: iload_3
    //   1810: anewarray 27	java/lang/Object
    //   1813: goto +11 -> 1824
    //   1816: dup
    //   1817: iload_3
    //   1818: aload_2
    //   1819: iload_3
    //   1820: iconst_2
    //   1821: iadd
    //   1822: aaload
    //   1823: aastore
    //   1824: iinc 3 -1
    //   1827: iload_3
    //   1828: ifge -12 -> 1816
    //   1831: invokestatic 1941	gnu/kawa/slib/srfi13:string$Gr$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1834: areturn
    //   1835: aload_2
    //   1836: iconst_0
    //   1837: aaload
    //   1838: aload_2
    //   1839: iconst_1
    //   1840: aaload
    //   1841: aload_2
    //   1842: arraylength
    //   1843: iconst_2
    //   1844: isub
    //   1845: istore_3
    //   1846: iload_3
    //   1847: anewarray 27	java/lang/Object
    //   1850: goto +11 -> 1861
    //   1853: dup
    //   1854: iload_3
    //   1855: aload_2
    //   1856: iload_3
    //   1857: iconst_2
    //   1858: iadd
    //   1859: aaload
    //   1860: aastore
    //   1861: iinc 3 -1
    //   1864: iload_3
    //   1865: ifge -12 -> 1853
    //   1868: invokestatic 1944	gnu/kawa/slib/srfi13:string$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1871: areturn
    //   1872: aload_2
    //   1873: iconst_0
    //   1874: aaload
    //   1875: aload_2
    //   1876: iconst_1
    //   1877: aaload
    //   1878: aload_2
    //   1879: arraylength
    //   1880: iconst_2
    //   1881: isub
    //   1882: istore_3
    //   1883: iload_3
    //   1884: anewarray 27	java/lang/Object
    //   1887: goto +11 -> 1898
    //   1890: dup
    //   1891: iload_3
    //   1892: aload_2
    //   1893: iload_3
    //   1894: iconst_2
    //   1895: iadd
    //   1896: aaload
    //   1897: aastore
    //   1898: iinc 3 -1
    //   1901: iload_3
    //   1902: ifge -12 -> 1890
    //   1905: invokestatic 1947	gnu/kawa/slib/srfi13:string$Gr$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1908: areturn
    //   1909: aload_2
    //   1910: iconst_0
    //   1911: aaload
    //   1912: aload_2
    //   1913: iconst_1
    //   1914: aaload
    //   1915: aload_2
    //   1916: arraylength
    //   1917: iconst_2
    //   1918: isub
    //   1919: istore_3
    //   1920: iload_3
    //   1921: anewarray 27	java/lang/Object
    //   1924: goto +11 -> 1935
    //   1927: dup
    //   1928: iload_3
    //   1929: aload_2
    //   1930: iload_3
    //   1931: iconst_2
    //   1932: iadd
    //   1933: aaload
    //   1934: aastore
    //   1935: iinc 3 -1
    //   1938: iload_3
    //   1939: ifge -12 -> 1927
    //   1942: invokestatic 1950	gnu/kawa/slib/srfi13:stringCi$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1945: areturn
    //   1946: aload_2
    //   1947: iconst_0
    //   1948: aaload
    //   1949: aload_2
    //   1950: iconst_1
    //   1951: aaload
    //   1952: aload_2
    //   1953: arraylength
    //   1954: iconst_2
    //   1955: isub
    //   1956: istore_3
    //   1957: iload_3
    //   1958: anewarray 27	java/lang/Object
    //   1961: goto +11 -> 1972
    //   1964: dup
    //   1965: iload_3
    //   1966: aload_2
    //   1967: iload_3
    //   1968: iconst_2
    //   1969: iadd
    //   1970: aaload
    //   1971: aastore
    //   1972: iinc 3 -1
    //   1975: iload_3
    //   1976: ifge -12 -> 1964
    //   1979: invokestatic 1953	gnu/kawa/slib/srfi13:stringCi$Ls$Gr$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1982: areturn
    //   1983: aload_2
    //   1984: iconst_0
    //   1985: aaload
    //   1986: aload_2
    //   1987: iconst_1
    //   1988: aaload
    //   1989: aload_2
    //   1990: arraylength
    //   1991: iconst_2
    //   1992: isub
    //   1993: istore_3
    //   1994: iload_3
    //   1995: anewarray 27	java/lang/Object
    //   1998: goto +11 -> 2009
    //   2001: dup
    //   2002: iload_3
    //   2003: aload_2
    //   2004: iload_3
    //   2005: iconst_2
    //   2006: iadd
    //   2007: aaload
    //   2008: aastore
    //   2009: iinc 3 -1
    //   2012: iload_3
    //   2013: ifge -12 -> 2001
    //   2016: invokestatic 1956	gnu/kawa/slib/srfi13:stringCi$Ls$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2019: areturn
    //   2020: aload_2
    //   2021: iconst_0
    //   2022: aaload
    //   2023: aload_2
    //   2024: iconst_1
    //   2025: aaload
    //   2026: aload_2
    //   2027: arraylength
    //   2028: iconst_2
    //   2029: isub
    //   2030: istore_3
    //   2031: iload_3
    //   2032: anewarray 27	java/lang/Object
    //   2035: goto +11 -> 2046
    //   2038: dup
    //   2039: iload_3
    //   2040: aload_2
    //   2041: iload_3
    //   2042: iconst_2
    //   2043: iadd
    //   2044: aaload
    //   2045: aastore
    //   2046: iinc 3 -1
    //   2049: iload_3
    //   2050: ifge -12 -> 2038
    //   2053: invokestatic 1959	gnu/kawa/slib/srfi13:stringCi$Gr$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2056: areturn
    //   2057: aload_2
    //   2058: iconst_0
    //   2059: aaload
    //   2060: aload_2
    //   2061: iconst_1
    //   2062: aaload
    //   2063: aload_2
    //   2064: arraylength
    //   2065: iconst_2
    //   2066: isub
    //   2067: istore_3
    //   2068: iload_3
    //   2069: anewarray 27	java/lang/Object
    //   2072: goto +11 -> 2083
    //   2075: dup
    //   2076: iload_3
    //   2077: aload_2
    //   2078: iload_3
    //   2079: iconst_2
    //   2080: iadd
    //   2081: aaload
    //   2082: aastore
    //   2083: iinc 3 -1
    //   2086: iload_3
    //   2087: ifge -12 -> 2075
    //   2090: invokestatic 1962	gnu/kawa/slib/srfi13:stringCi$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2093: areturn
    //   2094: aload_2
    //   2095: iconst_0
    //   2096: aaload
    //   2097: aload_2
    //   2098: iconst_1
    //   2099: aaload
    //   2100: aload_2
    //   2101: arraylength
    //   2102: iconst_2
    //   2103: isub
    //   2104: istore_3
    //   2105: iload_3
    //   2106: anewarray 27	java/lang/Object
    //   2109: goto +11 -> 2120
    //   2112: dup
    //   2113: iload_3
    //   2114: aload_2
    //   2115: iload_3
    //   2116: iconst_2
    //   2117: iadd
    //   2118: aaload
    //   2119: aastore
    //   2120: iinc 3 -1
    //   2123: iload_3
    //   2124: ifge -12 -> 2112
    //   2127: invokestatic 1965	gnu/kawa/slib/srfi13:stringCi$Gr$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2130: areturn
    //   2131: aload_2
    //   2132: iconst_0
    //   2133: aaload
    //   2134: aload_2
    //   2135: iconst_1
    //   2136: aaload
    //   2137: aload_2
    //   2138: iconst_2
    //   2139: aaload
    //   2140: aload_2
    //   2141: iconst_3
    //   2142: aaload
    //   2143: aload_2
    //   2144: iconst_4
    //   2145: aaload
    //   2146: invokestatic 600	gnu/kawa/slib/srfi13:$PcStringHash	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2149: areturn
    //   2150: aload_2
    //   2151: iconst_0
    //   2152: aaload
    //   2153: aload_2
    //   2154: arraylength
    //   2155: iconst_1
    //   2156: isub
    //   2157: istore_3
    //   2158: iload_3
    //   2159: anewarray 27	java/lang/Object
    //   2162: goto +11 -> 2173
    //   2165: dup
    //   2166: iload_3
    //   2167: aload_2
    //   2168: iload_3
    //   2169: iconst_1
    //   2170: iadd
    //   2171: aaload
    //   2172: aastore
    //   2173: iinc 3 -1
    //   2176: iload_3
    //   2177: ifge -12 -> 2165
    //   2180: invokestatic 1968	gnu/kawa/slib/srfi13:stringHash$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2183: areturn
    //   2184: aload_2
    //   2185: iconst_0
    //   2186: aaload
    //   2187: aload_2
    //   2188: arraylength
    //   2189: iconst_1
    //   2190: isub
    //   2191: istore_3
    //   2192: iload_3
    //   2193: anewarray 27	java/lang/Object
    //   2196: goto +11 -> 2207
    //   2199: dup
    //   2200: iload_3
    //   2201: aload_2
    //   2202: iload_3
    //   2203: iconst_1
    //   2204: iadd
    //   2205: aaload
    //   2206: aastore
    //   2207: iinc 3 -1
    //   2210: iload_3
    //   2211: ifge -12 -> 2199
    //   2214: invokestatic 1971	gnu/kawa/slib/srfi13:stringHashCi$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2217: areturn
    //   2218: aload_2
    //   2219: iconst_0
    //   2220: aaload
    //   2221: aload_2
    //   2222: arraylength
    //   2223: iconst_1
    //   2224: isub
    //   2225: istore_3
    //   2226: iload_3
    //   2227: anewarray 27	java/lang/Object
    //   2230: goto +11 -> 2241
    //   2233: dup
    //   2234: iload_3
    //   2235: aload_2
    //   2236: iload_3
    //   2237: iconst_1
    //   2238: iadd
    //   2239: aaload
    //   2240: aastore
    //   2241: iinc 3 -1
    //   2244: iload_3
    //   2245: ifge -12 -> 2233
    //   2248: invokestatic 1975	gnu/kawa/slib/srfi13:stringUpcase$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FString;
    //   2251: areturn
    //   2252: aload_2
    //   2253: iconst_0
    //   2254: aaload
    //   2255: aload_2
    //   2256: arraylength
    //   2257: iconst_1
    //   2258: isub
    //   2259: istore_3
    //   2260: iload_3
    //   2261: anewarray 27	java/lang/Object
    //   2264: goto +11 -> 2275
    //   2267: dup
    //   2268: iload_3
    //   2269: aload_2
    //   2270: iload_3
    //   2271: iconst_1
    //   2272: iadd
    //   2273: aaload
    //   2274: aastore
    //   2275: iinc 3 -1
    //   2278: iload_3
    //   2279: ifge -12 -> 2267
    //   2282: invokestatic 1978	gnu/kawa/slib/srfi13:stringUpcase$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2285: areturn
    //   2286: aload_2
    //   2287: iconst_0
    //   2288: aaload
    //   2289: aload_2
    //   2290: arraylength
    //   2291: iconst_1
    //   2292: isub
    //   2293: istore_3
    //   2294: iload_3
    //   2295: anewarray 27	java/lang/Object
    //   2298: goto +11 -> 2309
    //   2301: dup
    //   2302: iload_3
    //   2303: aload_2
    //   2304: iload_3
    //   2305: iconst_1
    //   2306: iadd
    //   2307: aaload
    //   2308: aastore
    //   2309: iinc 3 -1
    //   2312: iload_3
    //   2313: ifge -12 -> 2301
    //   2316: invokestatic 1981	gnu/kawa/slib/srfi13:stringDowncase$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FString;
    //   2319: areturn
    //   2320: aload_2
    //   2321: iconst_0
    //   2322: aaload
    //   2323: aload_2
    //   2324: arraylength
    //   2325: iconst_1
    //   2326: isub
    //   2327: istore_3
    //   2328: iload_3
    //   2329: anewarray 27	java/lang/Object
    //   2332: goto +11 -> 2343
    //   2335: dup
    //   2336: iload_3
    //   2337: aload_2
    //   2338: iload_3
    //   2339: iconst_1
    //   2340: iadd
    //   2341: aaload
    //   2342: aastore
    //   2343: iinc 3 -1
    //   2346: iload_3
    //   2347: ifge -12 -> 2335
    //   2350: invokestatic 643	gnu/kawa/slib/srfi13:stringDowncase$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2353: areturn
    //   2354: aload_2
    //   2355: iconst_0
    //   2356: aaload
    //   2357: aload_2
    //   2358: arraylength
    //   2359: iconst_1
    //   2360: isub
    //   2361: istore_3
    //   2362: iload_3
    //   2363: anewarray 27	java/lang/Object
    //   2366: goto +11 -> 2377
    //   2369: dup
    //   2370: iload_3
    //   2371: aload_2
    //   2372: iload_3
    //   2373: iconst_1
    //   2374: iadd
    //   2375: aaload
    //   2376: aastore
    //   2377: iinc 3 -1
    //   2380: iload_3
    //   2381: ifge -12 -> 2369
    //   2384: invokestatic 1984	gnu/kawa/slib/srfi13:stringTitlecase$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2387: areturn
    //   2388: aload_2
    //   2389: iconst_0
    //   2390: aaload
    //   2391: aload_2
    //   2392: arraylength
    //   2393: iconst_1
    //   2394: isub
    //   2395: istore_3
    //   2396: iload_3
    //   2397: anewarray 27	java/lang/Object
    //   2400: goto +11 -> 2411
    //   2403: dup
    //   2404: iload_3
    //   2405: aload_2
    //   2406: iload_3
    //   2407: iconst_1
    //   2408: iadd
    //   2409: aaload
    //   2410: aastore
    //   2411: iinc 3 -1
    //   2414: iload_3
    //   2415: ifge -12 -> 2403
    //   2418: invokestatic 1988	gnu/kawa/slib/srfi13:stringTitlecase$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   2421: areturn
    //   2422: aload_2
    //   2423: iconst_0
    //   2424: aaload
    //   2425: aload_2
    //   2426: arraylength
    //   2427: iconst_1
    //   2428: isub
    //   2429: istore_3
    //   2430: iload_3
    //   2431: anewarray 27	java/lang/Object
    //   2434: goto +11 -> 2445
    //   2437: dup
    //   2438: iload_3
    //   2439: aload_2
    //   2440: iload_3
    //   2441: iconst_1
    //   2442: iadd
    //   2443: aaload
    //   2444: aastore
    //   2445: iinc 3 -1
    //   2448: iload_3
    //   2449: ifge -12 -> 2437
    //   2452: invokestatic 1991	gnu/kawa/slib/srfi13:stringTrim$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2455: areturn
    //   2456: aload_2
    //   2457: iconst_0
    //   2458: aaload
    //   2459: aload_2
    //   2460: arraylength
    //   2461: iconst_1
    //   2462: isub
    //   2463: istore_3
    //   2464: iload_3
    //   2465: anewarray 27	java/lang/Object
    //   2468: goto +11 -> 2479
    //   2471: dup
    //   2472: iload_3
    //   2473: aload_2
    //   2474: iload_3
    //   2475: iconst_1
    //   2476: iadd
    //   2477: aaload
    //   2478: aastore
    //   2479: iinc 3 -1
    //   2482: iload_3
    //   2483: ifge -12 -> 2471
    //   2486: invokestatic 1994	gnu/kawa/slib/srfi13:stringTrimRight$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2489: areturn
    //   2490: aload_2
    //   2491: iconst_0
    //   2492: aaload
    //   2493: aload_2
    //   2494: arraylength
    //   2495: iconst_1
    //   2496: isub
    //   2497: istore_3
    //   2498: iload_3
    //   2499: anewarray 27	java/lang/Object
    //   2502: goto +11 -> 2513
    //   2505: dup
    //   2506: iload_3
    //   2507: aload_2
    //   2508: iload_3
    //   2509: iconst_1
    //   2510: iadd
    //   2511: aaload
    //   2512: aastore
    //   2513: iinc 3 -1
    //   2516: iload_3
    //   2517: ifge -12 -> 2505
    //   2520: invokestatic 1997	gnu/kawa/slib/srfi13:stringTrimBoth$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2523: areturn
    //   2524: aload_2
    //   2525: iconst_0
    //   2526: aaload
    //   2527: aload_2
    //   2528: iconst_1
    //   2529: aaload
    //   2530: aload_2
    //   2531: arraylength
    //   2532: iconst_2
    //   2533: isub
    //   2534: istore_3
    //   2535: iload_3
    //   2536: anewarray 27	java/lang/Object
    //   2539: goto +11 -> 2550
    //   2542: dup
    //   2543: iload_3
    //   2544: aload_2
    //   2545: iload_3
    //   2546: iconst_2
    //   2547: iadd
    //   2548: aaload
    //   2549: aastore
    //   2550: iinc 3 -1
    //   2553: iload_3
    //   2554: ifge -12 -> 2542
    //   2557: invokestatic 2000	gnu/kawa/slib/srfi13:stringPadRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2560: areturn
    //   2561: aload_2
    //   2562: iconst_0
    //   2563: aaload
    //   2564: aload_2
    //   2565: iconst_1
    //   2566: aaload
    //   2567: aload_2
    //   2568: arraylength
    //   2569: iconst_2
    //   2570: isub
    //   2571: istore_3
    //   2572: iload_3
    //   2573: anewarray 27	java/lang/Object
    //   2576: goto +11 -> 2587
    //   2579: dup
    //   2580: iload_3
    //   2581: aload_2
    //   2582: iload_3
    //   2583: iconst_2
    //   2584: iadd
    //   2585: aaload
    //   2586: aastore
    //   2587: iinc 3 -1
    //   2590: iload_3
    //   2591: ifge -12 -> 2579
    //   2594: invokestatic 2003	gnu/kawa/slib/srfi13:stringPad$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2597: areturn
    //   2598: aload_2
    //   2599: iconst_0
    //   2600: aaload
    //   2601: aload_2
    //   2602: iconst_1
    //   2603: aaload
    //   2604: aload_2
    //   2605: arraylength
    //   2606: iconst_2
    //   2607: isub
    //   2608: istore_3
    //   2609: iload_3
    //   2610: anewarray 27	java/lang/Object
    //   2613: goto +11 -> 2624
    //   2616: dup
    //   2617: iload_3
    //   2618: aload_2
    //   2619: iload_3
    //   2620: iconst_2
    //   2621: iadd
    //   2622: aaload
    //   2623: aastore
    //   2624: iinc 3 -1
    //   2627: iload_3
    //   2628: ifge -12 -> 2616
    //   2631: invokestatic 2007	gnu/kawa/slib/srfi13:stringDelete$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   2634: areturn
    //   2635: aload_2
    //   2636: iconst_0
    //   2637: aaload
    //   2638: aload_2
    //   2639: iconst_1
    //   2640: aaload
    //   2641: aload_2
    //   2642: arraylength
    //   2643: iconst_2
    //   2644: isub
    //   2645: istore_3
    //   2646: iload_3
    //   2647: anewarray 27	java/lang/Object
    //   2650: goto +11 -> 2661
    //   2653: dup
    //   2654: iload_3
    //   2655: aload_2
    //   2656: iload_3
    //   2657: iconst_2
    //   2658: iadd
    //   2659: aaload
    //   2660: aastore
    //   2661: iinc 3 -1
    //   2664: iload_3
    //   2665: ifge -12 -> 2653
    //   2668: invokestatic 2010	gnu/kawa/slib/srfi13:stringFilter$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   2671: areturn
    //   2672: aload_2
    //   2673: iconst_0
    //   2674: aaload
    //   2675: aload_2
    //   2676: iconst_1
    //   2677: aaload
    //   2678: aload_2
    //   2679: arraylength
    //   2680: iconst_2
    //   2681: isub
    //   2682: istore_3
    //   2683: iload_3
    //   2684: anewarray 27	java/lang/Object
    //   2687: goto +11 -> 2698
    //   2690: dup
    //   2691: iload_3
    //   2692: aload_2
    //   2693: iload_3
    //   2694: iconst_2
    //   2695: iadd
    //   2696: aaload
    //   2697: aastore
    //   2698: iinc 3 -1
    //   2701: iload_3
    //   2702: ifge -12 -> 2690
    //   2705: invokestatic 633	gnu/kawa/slib/srfi13:stringIndex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2708: areturn
    //   2709: aload_2
    //   2710: iconst_0
    //   2711: aaload
    //   2712: aload_2
    //   2713: iconst_1
    //   2714: aaload
    //   2715: aload_2
    //   2716: arraylength
    //   2717: iconst_2
    //   2718: isub
    //   2719: istore_3
    //   2720: iload_3
    //   2721: anewarray 27	java/lang/Object
    //   2724: goto +11 -> 2735
    //   2727: dup
    //   2728: iload_3
    //   2729: aload_2
    //   2730: iload_3
    //   2731: iconst_2
    //   2732: iadd
    //   2733: aaload
    //   2734: aastore
    //   2735: iinc 3 -1
    //   2738: iload_3
    //   2739: ifge -12 -> 2727
    //   2742: invokestatic 930	gnu/kawa/slib/srfi13:stringIndexRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2745: areturn
    //   2746: aload_2
    //   2747: iconst_0
    //   2748: aaload
    //   2749: aload_2
    //   2750: iconst_1
    //   2751: aaload
    //   2752: aload_2
    //   2753: arraylength
    //   2754: iconst_2
    //   2755: isub
    //   2756: istore_3
    //   2757: iload_3
    //   2758: anewarray 27	java/lang/Object
    //   2761: goto +11 -> 2772
    //   2764: dup
    //   2765: iload_3
    //   2766: aload_2
    //   2767: iload_3
    //   2768: iconst_2
    //   2769: iadd
    //   2770: aaload
    //   2771: aastore
    //   2772: iinc 3 -1
    //   2775: iload_3
    //   2776: ifge -12 -> 2764
    //   2779: invokestatic 639	gnu/kawa/slib/srfi13:stringSkip$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2782: areturn
    //   2783: aload_2
    //   2784: iconst_0
    //   2785: aaload
    //   2786: aload_2
    //   2787: iconst_1
    //   2788: aaload
    //   2789: aload_2
    //   2790: arraylength
    //   2791: iconst_2
    //   2792: isub
    //   2793: istore_3
    //   2794: iload_3
    //   2795: anewarray 27	java/lang/Object
    //   2798: goto +11 -> 2809
    //   2801: dup
    //   2802: iload_3
    //   2803: aload_2
    //   2804: iload_3
    //   2805: iconst_2
    //   2806: iadd
    //   2807: aaload
    //   2808: aastore
    //   2809: iinc 3 -1
    //   2812: iload_3
    //   2813: ifge -12 -> 2801
    //   2816: invokestatic 717	gnu/kawa/slib/srfi13:stringSkipRight$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2819: areturn
    //   2820: aload_2
    //   2821: iconst_0
    //   2822: aaload
    //   2823: aload_2
    //   2824: iconst_1
    //   2825: aaload
    //   2826: aload_2
    //   2827: arraylength
    //   2828: iconst_2
    //   2829: isub
    //   2830: istore_3
    //   2831: iload_3
    //   2832: anewarray 27	java/lang/Object
    //   2835: goto +11 -> 2846
    //   2838: dup
    //   2839: iload_3
    //   2840: aload_2
    //   2841: iload_3
    //   2842: iconst_2
    //   2843: iadd
    //   2844: aaload
    //   2845: aastore
    //   2846: iinc 3 -1
    //   2849: iload_3
    //   2850: ifge -12 -> 2838
    //   2853: invokestatic 2013	gnu/kawa/slib/srfi13:stringCount$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2856: areturn
    //   2857: aload_2
    //   2858: iconst_0
    //   2859: aaload
    //   2860: aload_2
    //   2861: iconst_1
    //   2862: aaload
    //   2863: aload_2
    //   2864: arraylength
    //   2865: iconst_2
    //   2866: isub
    //   2867: istore_3
    //   2868: iload_3
    //   2869: anewarray 27	java/lang/Object
    //   2872: goto +11 -> 2883
    //   2875: dup
    //   2876: iload_3
    //   2877: aload_2
    //   2878: iload_3
    //   2879: iconst_2
    //   2880: iadd
    //   2881: aaload
    //   2882: aastore
    //   2883: iinc 3 -1
    //   2886: iload_3
    //   2887: ifge -12 -> 2875
    //   2890: invokestatic 2016	gnu/kawa/slib/srfi13:stringContains$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2893: areturn
    //   2894: aload_2
    //   2895: iconst_0
    //   2896: aaload
    //   2897: aload_2
    //   2898: iconst_1
    //   2899: aaload
    //   2900: aload_2
    //   2901: arraylength
    //   2902: iconst_2
    //   2903: isub
    //   2904: istore_3
    //   2905: iload_3
    //   2906: anewarray 27	java/lang/Object
    //   2909: goto +11 -> 2920
    //   2912: dup
    //   2913: iload_3
    //   2914: aload_2
    //   2915: iload_3
    //   2916: iconst_2
    //   2917: iadd
    //   2918: aaload
    //   2919: aastore
    //   2920: iinc 3 -1
    //   2923: iload_3
    //   2924: ifge -12 -> 2912
    //   2927: invokestatic 2019	gnu/kawa/slib/srfi13:stringContainsCi$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2930: areturn
    //   2931: aload_2
    //   2932: iconst_0
    //   2933: aaload
    //   2934: aload_2
    //   2935: iconst_1
    //   2936: aaload
    //   2937: aload_2
    //   2938: iconst_2
    //   2939: aaload
    //   2940: aload_2
    //   2941: iconst_3
    //   2942: aaload
    //   2943: aload_2
    //   2944: iconst_4
    //   2945: aaload
    //   2946: aload_2
    //   2947: iconst_5
    //   2948: aaload
    //   2949: aload_2
    //   2950: bipush 6
    //   2952: aaload
    //   2953: invokestatic 824	gnu/kawa/slib/srfi13:$PcKmpSearch	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2956: areturn
    //   2957: aload_2
    //   2958: iconst_0
    //   2959: aaload
    //   2960: aload_2
    //   2961: arraylength
    //   2962: iconst_1
    //   2963: isub
    //   2964: istore_3
    //   2965: iload_3
    //   2966: anewarray 27	java/lang/Object
    //   2969: goto +11 -> 2980
    //   2972: dup
    //   2973: iload_3
    //   2974: aload_2
    //   2975: iload_3
    //   2976: iconst_1
    //   2977: iadd
    //   2978: aaload
    //   2979: aastore
    //   2980: iinc 3 -1
    //   2983: iload_3
    //   2984: ifge -12 -> 2972
    //   2987: invokestatic 834	gnu/kawa/slib/srfi13:makeKmpRestartVector$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FVector;
    //   2990: areturn
    //   2991: aload_2
    //   2992: iconst_0
    //   2993: aaload
    //   2994: aload_2
    //   2995: iconst_1
    //   2996: aaload
    //   2997: aload_2
    //   2998: iconst_2
    //   2999: aaload
    //   3000: aload_2
    //   3001: iconst_3
    //   3002: aaload
    //   3003: aload_2
    //   3004: iconst_4
    //   3005: aaload
    //   3006: aload_2
    //   3007: iconst_5
    //   3008: aaload
    //   3009: invokestatic 2022	gnu/kawa/slib/srfi13:kmpStep	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3012: areturn
    //   3013: aload_2
    //   3014: iconst_0
    //   3015: aaload
    //   3016: aload_2
    //   3017: iconst_1
    //   3018: aaload
    //   3019: aload_2
    //   3020: iconst_2
    //   3021: aaload
    //   3022: aload_2
    //   3023: iconst_3
    //   3024: aaload
    //   3025: aload_2
    //   3026: arraylength
    //   3027: iconst_4
    //   3028: isub
    //   3029: istore_3
    //   3030: iload_3
    //   3031: anewarray 27	java/lang/Object
    //   3034: goto +11 -> 3045
    //   3037: dup
    //   3038: iload_3
    //   3039: aload_2
    //   3040: iload_3
    //   3041: iconst_4
    //   3042: iadd
    //   3043: aaload
    //   3044: aastore
    //   3045: iinc 3 -1
    //   3048: iload_3
    //   3049: ifge -12 -> 3037
    //   3052: invokestatic 2025	gnu/kawa/slib/srfi13:stringKmpPartialSearch$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3055: areturn
    //   3056: aload_2
    //   3057: iconst_0
    //   3058: aaload
    //   3059: aload_2
    //   3060: arraylength
    //   3061: iconst_1
    //   3062: isub
    //   3063: istore_3
    //   3064: iload_3
    //   3065: anewarray 27	java/lang/Object
    //   3068: goto +11 -> 3079
    //   3071: dup
    //   3072: iload_3
    //   3073: aload_2
    //   3074: iload_3
    //   3075: iconst_1
    //   3076: iadd
    //   3077: aaload
    //   3078: aastore
    //   3079: iinc 3 -1
    //   3082: iload_3
    //   3083: ifge -12 -> 3071
    //   3086: invokestatic 2028	gnu/kawa/slib/srfi13:stringReverse$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FString;
    //   3089: areturn
    //   3090: aload_2
    //   3091: iconst_0
    //   3092: aaload
    //   3093: aload_2
    //   3094: arraylength
    //   3095: iconst_1
    //   3096: isub
    //   3097: istore_3
    //   3098: iload_3
    //   3099: anewarray 27	java/lang/Object
    //   3102: goto +11 -> 3113
    //   3105: dup
    //   3106: iload_3
    //   3107: aload_2
    //   3108: iload_3
    //   3109: iconst_1
    //   3110: iadd
    //   3111: aaload
    //   3112: aastore
    //   3113: iinc 3 -1
    //   3116: iload_3
    //   3117: ifge -12 -> 3105
    //   3120: invokestatic 2031	gnu/kawa/slib/srfi13:stringReverse$Ex$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3123: areturn
    //   3124: aload_2
    //   3125: invokestatic 2034	gnu/kawa/slib/srfi13:stringAppend$SlShared$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   3128: areturn
    //   3129: aload_2
    //   3130: iconst_0
    //   3131: aaload
    //   3132: aload_2
    //   3133: arraylength
    //   3134: iconst_1
    //   3135: isub
    //   3136: istore_3
    //   3137: iload_3
    //   3138: anewarray 27	java/lang/Object
    //   3141: goto +11 -> 3152
    //   3144: dup
    //   3145: iload_3
    //   3146: aload_2
    //   3147: iload_3
    //   3148: iconst_1
    //   3149: iadd
    //   3150: aaload
    //   3151: aastore
    //   3152: iinc 3 -1
    //   3155: iload_3
    //   3156: ifge -12 -> 3144
    //   3159: invokestatic 2037	gnu/kawa/slib/srfi13:stringConcatenateReverse$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FString;
    //   3162: areturn
    //   3163: aload_2
    //   3164: iconst_0
    //   3165: aaload
    //   3166: aload_2
    //   3167: arraylength
    //   3168: iconst_1
    //   3169: isub
    //   3170: istore_3
    //   3171: iload_3
    //   3172: anewarray 27	java/lang/Object
    //   3175: goto +11 -> 3186
    //   3178: dup
    //   3179: iload_3
    //   3180: aload_2
    //   3181: iload_3
    //   3182: iconst_1
    //   3183: iadd
    //   3184: aaload
    //   3185: aastore
    //   3186: iinc 3 -1
    //   3189: iload_3
    //   3190: ifge -12 -> 3178
    //   3193: invokestatic 2040	gnu/kawa/slib/srfi13:stringConcatenateReverse$SlShared$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3196: areturn
    //   3197: aload_2
    //   3198: iconst_0
    //   3199: aaload
    //   3200: aload_2
    //   3201: iconst_1
    //   3202: aaload
    //   3203: aload_2
    //   3204: iconst_2
    //   3205: aaload
    //   3206: aload_2
    //   3207: iconst_3
    //   3208: aaload
    //   3209: aload_2
    //   3210: arraylength
    //   3211: iconst_4
    //   3212: isub
    //   3213: istore_3
    //   3214: iload_3
    //   3215: anewarray 27	java/lang/Object
    //   3218: goto +11 -> 3229
    //   3221: dup
    //   3222: iload_3
    //   3223: aload_2
    //   3224: iload_3
    //   3225: iconst_4
    //   3226: iadd
    //   3227: aaload
    //   3228: aastore
    //   3229: iinc 3 -1
    //   3232: iload_3
    //   3233: ifge -12 -> 3221
    //   3236: invokestatic 2044	gnu/kawa/slib/srfi13:stringReplace$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FString;
    //   3239: areturn
    //   3240: aload_2
    //   3241: iconst_0
    //   3242: aaload
    //   3243: aload_2
    //   3244: arraylength
    //   3245: iconst_1
    //   3246: isub
    //   3247: istore_3
    //   3248: iload_3
    //   3249: anewarray 27	java/lang/Object
    //   3252: goto +11 -> 3263
    //   3255: dup
    //   3256: iload_3
    //   3257: aload_2
    //   3258: iload_3
    //   3259: iconst_1
    //   3260: iadd
    //   3261: aaload
    //   3262: aastore
    //   3263: iinc 3 -1
    //   3266: iload_3
    //   3267: ifge -12 -> 3255
    //   3270: invokestatic 2047	gnu/kawa/slib/srfi13:stringTokenize$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3273: areturn
    //   3274: aload_2
    //   3275: iconst_0
    //   3276: aaload
    //   3277: aload_2
    //   3278: iconst_1
    //   3279: aaload
    //   3280: aload_2
    //   3281: arraylength
    //   3282: iconst_2
    //   3283: isub
    //   3284: istore_3
    //   3285: iload_3
    //   3286: anewarray 27	java/lang/Object
    //   3289: goto +11 -> 3300
    //   3292: dup
    //   3293: iload_3
    //   3294: aload_2
    //   3295: iload_3
    //   3296: iconst_2
    //   3297: iadd
    //   3298: aaload
    //   3299: aastore
    //   3300: iinc 3 -1
    //   3303: iload_3
    //   3304: ifge -12 -> 3292
    //   3307: invokestatic 2050	gnu/kawa/slib/srfi13:xsubstring$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   3310: areturn
    //   3311: aload_2
    //   3312: iconst_0
    //   3313: aaload
    //   3314: aload_2
    //   3315: iconst_1
    //   3316: aaload
    //   3317: aload_2
    //   3318: iconst_2
    //   3319: aaload
    //   3320: aload_2
    //   3321: iconst_3
    //   3322: aaload
    //   3323: aload_2
    //   3324: arraylength
    //   3325: iconst_4
    //   3326: isub
    //   3327: istore_3
    //   3328: iload_3
    //   3329: anewarray 27	java/lang/Object
    //   3332: goto +11 -> 3343
    //   3335: dup
    //   3336: iload_3
    //   3337: aload_2
    //   3338: iload_3
    //   3339: iconst_4
    //   3340: iadd
    //   3341: aaload
    //   3342: aastore
    //   3343: iinc 3 -1
    //   3346: iload_3
    //   3347: ifge -12 -> 3335
    //   3350: invokestatic 2053	gnu/kawa/slib/srfi13:stringXcopy$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3353: areturn
    //   3354: aload_2
    //   3355: iconst_0
    //   3356: aaload
    //   3357: aload_2
    //   3358: iconst_1
    //   3359: aaload
    //   3360: aload_2
    //   3361: iconst_2
    //   3362: aaload
    //   3363: aload_2
    //   3364: iconst_3
    //   3365: aaload
    //   3366: aload_2
    //   3367: iconst_4
    //   3368: aaload
    //   3369: aload_2
    //   3370: iconst_5
    //   3371: aaload
    //   3372: aload_2
    //   3373: bipush 6
    //   3375: aaload
    //   3376: invokestatic 970	gnu/kawa/slib/srfi13:$PcMultispanRepcopy$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3379: areturn
    //   3380: aload_2
    //   3381: iconst_0
    //   3382: aaload
    //   3383: aload_2
    //   3384: arraylength
    //   3385: iconst_1
    //   3386: isub
    //   3387: istore_3
    //   3388: iload_3
    //   3389: anewarray 27	java/lang/Object
    //   3392: goto +11 -> 3403
    //   3395: dup
    //   3396: iload_3
    //   3397: aload_2
    //   3398: iload_3
    //   3399: iconst_1
    //   3400: iadd
    //   3401: aaload
    //   3402: aastore
    //   3403: iinc 3 -1
    //   3406: iload_3
    //   3407: ifge -12 -> 3395
    //   3410: invokestatic 2056	gnu/kawa/slib/srfi13:stringJoin$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3413: areturn
    //   3414: aload_0
    //   3415: aload_1
    //   3416: aload_2
    //   3417: invokespecial 2060	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3420: areturn
    //   3421: new 53	gnu/mapping/WrongType
    //   3424: dup_x1
    //   3425: swap
    //   3426: ldc_w 418
    //   3429: iconst_2
    //   3430: aload_3
    //   3431: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3434: athrow
    //   3435: new 53	gnu/mapping/WrongType
    //   3438: dup_x1
    //   3439: swap
    //   3440: ldc_w 418
    //   3443: iconst_3
    //   3444: aload_3
    //   3445: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3448: athrow
    //   3449: new 53	gnu/mapping/WrongType
    //   3452: dup_x1
    //   3453: swap
    //   3454: ldc_w 418
    //   3457: iconst_5
    //   3458: aload_3
    //   3459: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3462: athrow
    //   3463: new 53	gnu/mapping/WrongType
    //   3466: dup_x1
    //   3467: swap
    //   3468: ldc_w 418
    //   3471: bipush 6
    //   3473: aload_3
    //   3474: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3477: athrow
    //   3478: new 53	gnu/mapping/WrongType
    //   3481: dup_x1
    //   3482: swap
    //   3483: ldc_w 427
    //   3486: iconst_2
    //   3487: aload_3
    //   3488: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3491: athrow
    //   3492: new 53	gnu/mapping/WrongType
    //   3495: dup_x1
    //   3496: swap
    //   3497: ldc_w 427
    //   3500: iconst_3
    //   3501: aload_3
    //   3502: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3505: athrow
    //   3506: new 53	gnu/mapping/WrongType
    //   3509: dup_x1
    //   3510: swap
    //   3511: ldc_w 427
    //   3514: iconst_5
    //   3515: aload_3
    //   3516: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3519: athrow
    //   3520: new 53	gnu/mapping/WrongType
    //   3523: dup_x1
    //   3524: swap
    //   3525: ldc_w 427
    //   3528: bipush 6
    //   3530: aload_3
    //   3531: invokespecial 59	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3534: athrow
    // Line number table:
    //   Java source line #263	-> byte code offset #508
    //   Java source line #316	-> byte code offset #545
    //   Java source line #330	-> byte code offset #582
    //   Java source line #340	-> byte code offset #619
    //   Java source line #347	-> byte code offset #659
    //   Java source line #417	-> byte code offset #699
    //   Java source line #465	-> byte code offset #742
    //   Java source line #530	-> byte code offset #785
    //   Java source line #556	-> byte code offset #822
    //   Java source line #603	-> byte code offset #859
    //   Java source line #617	-> byte code offset #881
    //   Java source line #631	-> byte code offset #903
    //   Java source line #646	-> byte code offset #972
    //   Java source line #662	-> byte code offset #1041
    //   Java source line #667	-> byte code offset #1078
    //   Java source line #672	-> byte code offset #1115
    //   Java source line #677	-> byte code offset #1155
    //   Java source line #690	-> byte code offset #1195
    //   Java source line #695	-> byte code offset #1244
    //   Java source line #700	-> byte code offset #1293
    //   Java source line #705	-> byte code offset #1342
    //   Java source line #713	-> byte code offset #1391
    //   Java source line #720	-> byte code offset #1425
    //   Java source line #726	-> byte code offset #1459
    //   Java source line #732	-> byte code offset #1493
    //   Java source line #747	-> byte code offset #1527
    //   Java source line #761	-> byte code offset #1561
    //   Java source line #774	-> byte code offset #1595
    //   Java source line #782	-> byte code offset #1641
    //   Java source line #799	-> byte code offset #1687
    //   Java source line #809	-> byte code offset #1724
    //   Java source line #819	-> byte code offset #1761
    //   Java source line #830	-> byte code offset #1798
    //   Java source line #841	-> byte code offset #1835
    //   Java source line #852	-> byte code offset #1872
    //   Java source line #863	-> byte code offset #1909
    //   Java source line #873	-> byte code offset #1946
    //   Java source line #883	-> byte code offset #1983
    //   Java source line #894	-> byte code offset #2020
    //   Java source line #905	-> byte code offset #2057
    //   Java source line #916	-> byte code offset #2094
    //   Java source line #946	-> byte code offset #2131
    //   Java source line #955	-> byte code offset #2150
    //   Java source line #964	-> byte code offset #2184
    //   Java source line #986	-> byte code offset #2218
    //   Java source line #990	-> byte code offset #2252
    //   Java source line #994	-> byte code offset #2286
    //   Java source line #998	-> byte code offset #2320
    //   Java source line #1014	-> byte code offset #2354
    //   Java source line #1018	-> byte code offset #2388
    //   Java source line #1070	-> byte code offset #2422
    //   Java source line #1077	-> byte code offset #2456
    //   Java source line #1084	-> byte code offset #2490
    //   Java source line #1093	-> byte code offset #2524
    //   Java source line #1105	-> byte code offset #2561
    //   Java source line #1133	-> byte code offset #2598
    //   Java source line #1160	-> byte code offset #2635
    //   Java source line #1201	-> byte code offset #2672
    //   Java source line #1221	-> byte code offset #2709
    //   Java source line #1241	-> byte code offset #2746
    //   Java source line #1263	-> byte code offset #2783
    //   Java source line #1286	-> byte code offset #2820
    //   Java source line #1375	-> byte code offset #2857
    //   Java source line #1380	-> byte code offset #2894
    //   Java source line #1403	-> byte code offset #2931
    //   Java source line #1452	-> byte code offset #2957
    //   Java source line #1500	-> byte code offset #2991
    //   Java source line #1519	-> byte code offset #3013
    //   Java source line #1557	-> byte code offset #3056
    //   Java source line #1567	-> byte code offset #3090
    //   Java source line #1616	-> byte code offset #3124
    //   Java source line #1673	-> byte code offset #3129
    //   Java source line #1686	-> byte code offset #3163
    //   Java source line #1731	-> byte code offset #3197
    //   Java source line #1750	-> byte code offset #3240
    //   Java source line #1794	-> byte code offset #3274
    //   Java source line #1835	-> byte code offset #3311
    //   Java source line #1871	-> byte code offset #3354
    //   Java source line #1908	-> byte code offset #3380
    //   Java source line #631	-> byte code offset #3421
    //   Java source line #632	-> byte code offset #3449
    //   Java source line #646	-> byte code offset #3478
    //   Java source line #647	-> byte code offset #3506
    // Exception table:
    //   from	to	target	type
    //   914	920	3421	java/lang/ClassCastException
    //   928	934	3435	java/lang/ClassCastException
    //   945	951	3449	java/lang/ClassCastException
    //   959	965	3463	java/lang/ClassCastException
    //   983	989	3478	java/lang/ClassCastException
    //   997	1003	3492	java/lang/ClassCastException
    //   1014	1020	3506	java/lang/ClassCastException
    //   1028	1034	3520	java/lang/ClassCastException
  }
  
  public class frame7
    extends ModuleBody
  {
    Object delim;
    
    public frame7() {}
    
    public Object lambda43buildit(Object lis, Object final)
    {
      void tmp7_4 = new srfi13.frame8();74staticLink = this;srfi13.frame8 $heapFrame = tmp7_4;jdField_final = final;
      return $heapFrame.lambda44recur(lis);
    }
  }
}
