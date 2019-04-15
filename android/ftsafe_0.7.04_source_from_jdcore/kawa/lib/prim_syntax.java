package kawa.lib; import kawa.lang.SyntaxTemplate;

public class prim_syntax extends gnu.expr.ModuleBody { public static final kawa.lang.Macro define$Mnsyntax; public static final kawa.lang.Macro define; public static final kawa.lang.Macro define$Mnprivate; public static final kawa.lang.Macro define$Mnconstant; public static final kawa.lang.Macro define$Mnearly$Mnconstant; public static final kawa.lang.Macro define$Mnvariable; public static final gnu.expr.ModuleMethod report$Mnsyntax$Mnerror; public static final kawa.lang.Macro syntax$Mn$Grexpression; public static final kawa.lang.Macro syntax$Mnbody$Mn$Grexpression; public static final kawa.lang.Macro jdField_if; public static final kawa.lang.Macro try$Mncatch; public static final kawa.lang.Macro letrec; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$Pcdefine; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$Pcdefine$Mnsyntax; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$Pclet; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$set$Ex; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$lambda; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$mlambda; public static final kawa.lang.Macro $Prvt$$Pcif$Mnand$Mnx; public static prim_syntax $instance; static final gnu.mapping.SimpleSymbol Lit0; static final kawa.lang.SyntaxRules Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final kawa.lang.SyntaxRules Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final kawa.lang.SyntaxRules Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final kawa.lang.SyntaxRules Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final kawa.lang.SyntaxRules Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final kawa.lang.SyntaxRules Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final kawa.lang.SyntaxRules Lit14; static final gnu.mapping.SimpleSymbol Lit15; static final kawa.lang.SyntaxRules Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final kawa.lang.SyntaxPattern Lit18; static final SyntaxTemplate Lit19; static final SyntaxTemplate Lit20; static final kawa.lang.SyntaxPattern Lit21; static final SyntaxTemplate Lit22; static final gnu.mapping.SimpleSymbol Lit23; static final kawa.lang.SyntaxPattern Lit24; static final SyntaxTemplate Lit25; static final SyntaxTemplate Lit26; static final SyntaxTemplate Lit27; static final kawa.lang.SyntaxPattern Lit28; static final SyntaxTemplate Lit29; static final kawa.lang.SyntaxPattern Lit30; static final SyntaxTemplate Lit31; static final kawa.lang.SyntaxPattern Lit32; static final SyntaxTemplate Lit33; static final kawa.lang.SyntaxPattern Lit34; static final SyntaxTemplate Lit35; static final kawa.lang.SyntaxPattern Lit36; static final SyntaxTemplate Lit37; static final SyntaxTemplate Lit38; static final kawa.lang.SyntaxPattern Lit39; static final SyntaxTemplate Lit40; static final SyntaxTemplate Lit41; static final SyntaxTemplate Lit42; static final kawa.lang.SyntaxPattern Lit43; static final SyntaxTemplate Lit44; static final kawa.lang.SyntaxPattern Lit45; static final SyntaxTemplate Lit46; static final gnu.mapping.SimpleSymbol Lit47; static final kawa.lang.SyntaxPattern Lit48; static final SyntaxTemplate Lit49; static final SyntaxTemplate Lit50; static final gnu.mapping.SimpleSymbol Lit51; static final kawa.lang.SyntaxPattern Lit52; static final SyntaxTemplate Lit53; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  static final kawa.lang.SyntaxPattern Lit54;
  static final kawa.lang.SyntaxPattern Lit55;
  static final SyntaxTemplate Lit56;
  static final SyntaxTemplate Lit57; static final SyntaxTemplate Lit58; static final kawa.lang.SyntaxPattern Lit59; static final SyntaxTemplate Lit60; static final SyntaxTemplate Lit61; static final SyntaxTemplate Lit62; static final kawa.lang.SyntaxPattern Lit63; static final kawa.lang.SyntaxPattern Lit64; static final SyntaxTemplate Lit65; static final SyntaxTemplate Lit66; static final Object[] Lit67; static final Object[] Lit68; static final Object[] Lit69; static final gnu.mapping.SimpleSymbol Lit70; static final gnu.mapping.SimpleSymbol Lit71; static final gnu.mapping.SimpleSymbol Lit72; static final gnu.lists.PairWithPosition Lit73; static final gnu.mapping.SimpleSymbol Lit74; static final gnu.mapping.SimpleSymbol Lit75; static final gnu.lists.PairWithPosition Lit76; static final Object[] Lit77; static final Object[] Lit78; static final gnu.mapping.SimpleSymbol Lit79; static final gnu.mapping.SimpleSymbol Lit80; static final gnu.mapping.SimpleSymbol Lit81; static final Object[] Lit82; static final gnu.lists.PairWithPosition Lit83; static final gnu.mapping.SimpleSymbol Lit84; static final gnu.math.IntNum Lit85; static final gnu.math.IntNum Lit86; static final Object[] Lit87; static final Object[] Lit88; static final Object[] Lit89; static final gnu.math.IntNum Lit90; static final gnu.math.IntNum Lit91; static final gnu.math.IntNum Lit92; static final gnu.math.IntNum Lit93; static final gnu.math.IntNum Lit94; static final gnu.math.IntNum Lit95; static final gnu.math.IntNum Lit96; static final gnu.math.IntNum Lit97; static final gnu.mapping.SimpleSymbol Lit98 = gnu.mapping.Symbol.valueOf("%define-syntax");
  















































































  public int matchN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    if (selector == 1) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); }
  public static gnu.expr.Expression reportSyntaxError(Object id, Object... msg) { return kawa.standard.syntax_error.error(id, msg); }
  





































































  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 5:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 4: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 3: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  static Object lambda1(Object x) { Object localObject1 = x;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(4, null); if (Lit18.match(x, arrayOfObject, 0))
    {
      localTemplateScope = kawa.lang.TemplateScope.make();;; }
    try { break label101;
      kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make(); label101: return Lit21.match(x, arrayOfObject, 0) ? Lit22.execute(arrayOfObject, localTemplateScope) : kawa.standard.syntax_case.error("syntax-case", x);
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject2;
      throw new gnu.mapping.WrongType(
      
        localClassCastException, "gnu.expr.ExitExp.<init>(gnu.expr.Expression,gnu.expr.BlockExp)", 2, localObject2);
    }
  }
  
  static Object lambda2(Object x) {
    Object localObject = x;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(5, null);
    
    gnu.expr.BlockExp bl = new gnu.expr.BlockExp();
    bl.setRunFinallyBlocks(false);
    

    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();
    localTemplateScope = kawa.lang.TemplateScope.make();bl.setBody(new gnu.expr.BeginExp(kawa.lang.SyntaxForms.rewrite(kawa.lang.Quote.append$V(new Object[] { Lit25.execute(arrayOfObject, localTemplateScope), kawa.lang.Quote.consX$V(new Object[] { bl, Lit26.execute(arrayOfObject, localTemplateScope) }) })), kawa.lang.SyntaxForms.rewrite(Lit27.execute(arrayOfObject, localTemplateScope))));
    

    bl = kawa.lang.TemplateScope.make();
    
    bl = kawa.lang.TemplateScope.make();
    
    bl = kawa.lang.TemplateScope.make();
    



    bl = kawa.lang.TemplateScope.make();
    




    bl = kawa.lang.TemplateScope.make();
    bl = kawa.lang.TemplateScope.make();
    


    bl = kawa.lang.TemplateScope.make();
    bl = kawa.lang.TemplateScope.make();
    bl = kawa.lang.TemplateScope.make();
    
    bl = kawa.lang.TemplateScope.make();
    

    bl = kawa.lang.TemplateScope.make();return Lit45.match(x, arrayOfObject, 0) ? reportSyntaxError(Lit46.execute(arrayOfObject, bl), new Object[] { "too few expressions for 'if'" }) : Lit43.match(x, arrayOfObject, 0) ? reportSyntaxError(Lit44.execute(arrayOfObject, bl), new Object[] { "too many expressions for 'if'" }) : Lit39.match(x, arrayOfObject, 0) ? new gnu.expr.IfExp(kawa.lang.SyntaxForms.rewrite(Lit40.execute(arrayOfObject, bl)), kawa.lang.SyntaxForms.rewrite(Lit41.execute(arrayOfObject, bl)), kawa.lang.SyntaxForms.rewrite(Lit42.execute(arrayOfObject, bl))) : Lit36.match(x, arrayOfObject, 0) ? new gnu.expr.IfExp(kawa.lang.SyntaxForms.rewrite(Lit37.execute(arrayOfObject, bl)), kawa.lang.SyntaxForms.rewrite(Lit38.execute(arrayOfObject, bl)), null) : Lit34.match(x, arrayOfObject, 0) ? kawa.lang.Quote.consX$V(new Object[] { gnu.kawa.reflect.TypeSwitch.typeSwitch, Lit35.execute(arrayOfObject, bl) }) : Lit32.match(x, arrayOfObject, 0) ? kawa.lang.Quote.consX$V(new Object[] { gnu.kawa.reflect.TypeSwitch.typeSwitch, Lit33.execute(arrayOfObject, bl) }) : Lit30.match(x, arrayOfObject, 0) ? Lit31.execute(arrayOfObject, bl) : Lit28.match(x, arrayOfObject, 0) ? Lit29.execute(arrayOfObject, bl) : Lit24.match(x, arrayOfObject, 0) ? bl : kawa.standard.syntax_case.error("syntax-case", x);
  }
  
  static Object lambda3(Object x)
  {
    Object localObject = x;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(4, null);
    

    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();
    localTemplateScope = kawa.lang.TemplateScope.make();return Lit48.match(x, arrayOfObject, 0) ? kawa.standard.try_catch.rewrite(Lit49.execute(arrayOfObject, localTemplateScope), Lit50.execute(arrayOfObject, localTemplateScope)) : kawa.standard.syntax_case.error("syntax-case", x);
  }
  
  static
  {
    Lit97 = gnu.math.IntNum.valueOf(0);Lit96 = gnu.math.IntNum.valueOf(1);Lit95 = gnu.math.IntNum.valueOf(4);Lit94 = gnu.math.IntNum.valueOf(5);Lit93 = gnu.math.IntNum.valueOf(8);Lit92 = gnu.math.IntNum.valueOf(9);Lit91 = gnu.math.IntNum.valueOf(24);Lit90 = gnu.math.IntNum.valueOf(25); gnu.mapping.SimpleSymbol tmp84_81 = gnu.mapping.Symbol.valueOf("$lookup$");Lit79 = tmp84_81;(prim_syntax.Lit89 = new Object[1])[0] = tmp84_81; Object[] tmp97_94 = (prim_syntax.Lit88 = new Object[2]);tmp97_94[0] = Lit79; gnu.mapping.SimpleSymbol tmp110_107 = gnu.mapping.Symbol.valueOf("::");Lit71 = tmp110_107;tmp97_94[1] = tmp110_107; Object[] tmp123_120 = (prim_syntax.Lit87 = new Object[2]);tmp123_120[0] = Lit71;tmp123_120[1] = Lit79;Lit86 = gnu.math.IntNum.valueOf(32);Lit85 = gnu.math.IntNum.valueOf(33);Lit84 = gnu.mapping.Symbol.valueOf("%define");Lit83 = gnu.lists.PairWithPosition.make(gnu.expr.Special.undefined, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 753726);(prim_syntax.Lit82 = new Object[1])[0] = Lit71;Lit81 = gnu.mapping.Symbol.valueOf("quasiquote");Lit80 = gnu.mapping.Symbol.valueOf("kawa.lang.SyntaxForms"); gnu.mapping.SimpleSymbol tmp223_220 = gnu.mapping.Symbol.valueOf("and");Lit75 = tmp223_220;(prim_syntax.Lit78 = new Object[1])[0] = tmp223_220; gnu.mapping.SimpleSymbol tmp243_240 = gnu.mapping.Symbol.valueOf("?");Lit74 = tmp243_240;(prim_syntax.Lit77 = new Object[1])[0] = tmp243_240;Lit76 = gnu.lists.PairWithPosition.make(gnu.mapping.Values.empty, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 520224);Lit73 = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("unused"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 561171);Lit72 = gnu.mapping.Symbol.valueOf("lambda");Lit70 = gnu.mapping.Symbol.valueOf("mlambda");(prim_syntax.Lit69 = new Object[1])[0] = Lit83;(prim_syntax.Lit68 = new Object[1])[0] = gnu.mapping.Symbol.valueOf("set!");Lit67 = new Object[0];Lit66 = new SyntaxTemplate("\001\000", "\n", Lit67, 0);Lit65 = new SyntaxTemplate("\001\000", "\030\004", new Object[] { gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("%let"), gnu.lists.LList.Empty) }, 0);Lit64 = new kawa.lang.SyntaxPattern("\023", Lit67, 3, "prim_syntax.scm:189");Lit63 = new kawa.lang.SyntaxPattern("\034\f\027\b\033", Lit67, 4, "prim_syntax.scm:187");Lit62 = new SyntaxTemplate("\001\000\001\001\001\001\000", "2", Lit67, 0);Lit61 = new SyntaxTemplate("\001\000\001\001\001\001\000", "\021\030\004\t\023\b+", Lit68, 0);Lit60 = new SyntaxTemplate("\001\000\001\001\001\001\000", "\t\023\t\033\t#\030\004", Lit69, 0);Lit59 = new kawa.lang.SyntaxPattern("L\f\027\f\037\f'\f/\b3", Lit67, 7, "prim_syntax.scm:182");Lit58 = new SyntaxTemplate("\001\000\001\001\000", "\"", Lit67, 0);Lit57 = new SyntaxTemplate("\001\000\001\001\000", "\021\030\004\t\023\b\033", Lit68, 0);Lit56 = new SyntaxTemplate("\001\000\001\001\000", "\t\023\030\004", Lit69, 0);Lit55 = new kawa.lang.SyntaxPattern(",\f\027\f\037\b#", Lit67, 5, "prim_syntax.scm:176");Lit54 = new kawa.lang.SyntaxPattern("\b", Lit67, 2, "prim_syntax.scm:175");Lit53 = new SyntaxTemplate("\001\000", "\003", Lit67, 0);Lit52 = new kawa.lang.SyntaxPattern("\f\030\f\007\013", Lit67, 2, "prim_syntax.scm:168");Lit51 = gnu.mapping.Symbol.valueOf("letrec");Lit50 = new SyntaxTemplate("\001\003\003\002", "(\b\rA\b\t\013\021\030\004\b\023\032", Lit82, 1);Lit49 = new SyntaxTemplate("\001\003\003\002", "\003", Lit67, 0);Lit48 = new kawa.lang.SyntaxPattern("\f\030\f\007-\f\017\f\027\033\b\030\b", Lit67, 4, "prim_syntax.scm:158");Lit47 = gnu.mapping.Symbol.valueOf("try-catch");Lit46 = new SyntaxTemplate("\000", "\002", Lit67, 0);Lit45 = new kawa.lang.SyntaxPattern("\f\030\003", Lit67, 1, "prim_syntax.scm:151");Lit44 = new SyntaxTemplate("\001\001\001\000", "\032", Lit67, 0);Lit43 = new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\033", Lit67, 4, "prim_syntax.scm:148");Lit42 = new SyntaxTemplate("\001\001\001", "\023", Lit67, 0);Lit41 = new SyntaxTemplate("\001\001\001", "\013", Lit67, 0);Lit40 = new SyntaxTemplate("\001\001\001", "\003", Lit67, 0);Lit39 = new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit67, 3, "prim_syntax.scm:143");Lit38 = new SyntaxTemplate("\001\001", "\013", Lit67, 0);Lit37 = new SyntaxTemplate("\001\001", "\003", Lit67, 0);Lit36 = new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit67, 2, "prim_syntax.scm:138"); Object[] tmp968_965 = new Object[3]; Object[] tmp969_968 = tmp968_965;tmp969_968[0] = Lit70; Object[] tmp975_969 = tmp969_968;tmp975_969[1] = Lit72;tmp975_969[2] = Lit73;Lit35 = new SyntaxTemplate("\001\001\001\001", "\t\013A\021\030\004\021\b\003\b\023\b\021\030\f\021\030\024\b\033", tmp968_965, 0);Lit34 = new kawa.lang.SyntaxPattern("\f\030<\f\002\f\007\f\017\b\f\027\f\037\b", Lit77, 4, "prim_syntax.scm:133"); Object[] tmp1027_1024 = new Object[4]; Object[] tmp1028_1027 = tmp1027_1024;tmp1028_1027[0] = Lit70; Object[] tmp1034_1028 = tmp1028_1027;tmp1034_1028[1] = Lit71; Object[] tmp1040_1034 = tmp1034_1028;tmp1040_1034[2] = Lit72;tmp1040_1034[3] = Lit73;Lit33 = new SyntaxTemplate("\001\001\001\001\001", "\t\023i\021\030\0049\t\003\021\030\f\b\013\b\033\b\021\030\024\021\030\034\b#", tmp1027_1024, 0); Object[] tmp1069_1066 = new Object[2]; Object[] tmp1070_1069 = tmp1069_1066;tmp1070_1069[0] = Lit74;tmp1070_1069[1] = Lit71;Lit32 = new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007\f\n\f\017\f\027\b\f\037\f'\b", tmp1069_1066, 5, "prim_syntax.scm:128"); Object[] tmp1105_1102 = new Object[3]; Object[] tmp1106_1105 = tmp1105_1102; gnu.mapping.SimpleSymbol tmp1114_1111 = gnu.mapping.Symbol.valueOf("if");Lit23 = tmp1114_1111;tmp1106_1105[0] = tmp1114_1111; Object[] tmp1119_1106 = tmp1106_1105;tmp1119_1106[1] = Lit75;tmp1119_1106[2] = Lit76;Lit31 = new SyntaxTemplate("\000\001", "\021\030\004!\021\030\f\002\t\013\030\024", tmp1105_1102, 0);Lit30 = new kawa.lang.SyntaxPattern("\f\030\034\f\002\003\f\017\b", Lit78, 2, "prim_syntax.scm:126"); Object[] tmp1171_1168 = new Object[3]; Object[] tmp1172_1171 = tmp1171_1168;tmp1172_1171[0] = Lit23; Object[] tmp1178_1172 = tmp1172_1171;tmp1178_1172[1] = Lit74;tmp1178_1172[2] = Lit76;Lit29 = new SyntaxTemplate("\000\001", "\021\030\004!\021\030\f\002\t\013\030\024", tmp1171_1168, 0);Lit28 = new kawa.lang.SyntaxPattern("\f\030\034\f\002\003\f\017\b", Lit77, 2, "prim_syntax.scm:124");Lit27 = new SyntaxTemplate("\000\001\001", "\023", Lit67, 0);Lit26 = new SyntaxTemplate("\000\001\001", "\t\013\002", Lit67, 0); Object[] tmp1270_1267 = new Object[1]; gnu.mapping.SimpleSymbol tmp1278_1275 = gnu.mapping.Symbol.valueOf("%if-and-x");Lit17 = tmp1278_1275;tmp1270_1267[0] = gnu.lists.Pair.make(tmp1278_1275, gnu.lists.LList.Empty);Lit25 = new SyntaxTemplate("\000\001\001", "\030\004", tmp1270_1267, 0);Lit24 = new kawa.lang.SyntaxPattern("\f\030\034\f\002\003\f\017\f\027\b", Lit78, 3, "prim_syntax.scm:116"); Object[] tmp1330_1327 = new Object[2]; Object[] tmp1331_1330 = tmp1330_1327;tmp1331_1330[0] = Lit23;tmp1331_1330[1] = Lit17;Lit22 = new SyntaxTemplate("\001\001\001\000", "\021\030\004\t\023\b\021\030\f\t\003\t\013\032", tmp1330_1327, 0);Lit21 = new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\033", Lit67, 4, "prim_syntax.scm:109");Lit20 = new SyntaxTemplate("\001\001", "\003", Lit67, 0);Lit19 = new SyntaxTemplate("\001\001", "\013", Lit67, 0);Lit18 = new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit67, 2, "prim_syntax.scm:107");Lit16 = new kawa.lang.SyntaxRules(Lit67, new kawa.lang.SyntaxRule[] { new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit67, 1, "prim_syntax.scm:101"), "\001", "\021\030\004\b\003", new Object[] { gnu.lists.PairWithPosition.make(Lit79, gnu.lists.Pair.make(Lit80, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit81, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("rewriteBody"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 417799) }, 0) }, 1, prim_syntax.Lit15 = gnu.mapping.Symbol.valueOf("syntax-body->expression"));Lit14 = new kawa.lang.SyntaxRules(Lit67, new kawa.lang.SyntaxRule[] { new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit67, 1, "prim_syntax.scm:96"), "\001", "\021\030\004\b\003", new Object[] { gnu.lists.PairWithPosition.make(Lit79, gnu.lists.Pair.make(Lit80, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit81, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("rewrite"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 397319) }, 0) }, 1, prim_syntax.Lit13 = gnu.mapping.Symbol.valueOf("syntax->expression"));Lit12 = gnu.mapping.Symbol.valueOf("report-syntax-error"); kawa.lang.SyntaxRule[] tmp1672_1669 = new kawa.lang.SyntaxRule[6]; kawa.lang.SyntaxRule[] tmp1673_1672 = tmp1672_1669; Object[] tmp1706_1703 = new Object[3]; Object[] tmp1707_1706 = tmp1706_1703; gnu.mapping.SimpleSymbol tmp1715_1712 = gnu.mapping.Symbol.valueOf("define-variable");Lit10 = tmp1715_1712;tmp1707_1706[0] = tmp1715_1712; Object[] tmp1720_1707 = tmp1707_1706;tmp1720_1707[1] = Lit71;tmp1720_1707[2] = Lit83;tmp1673_1672[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\002\f\017\b", Lit82, 2, "prim_syntax.scm:78"), "\001\001", "\021\030\004\t\003\021\030\f\t\013\030\024", tmp1706_1703, 0); kawa.lang.SyntaxRule[] tmp1736_1673 = tmp1673_1672; Object[] tmp1769_1766 = new Object[2]; Object[] tmp1770_1769 = tmp1769_1766;tmp1770_1769[0] = Lit10;tmp1770_1769[1] = Lit83;tmp1736_1673[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit67, 1, "prim_syntax.scm:80"), "\001", "\021\030\004\t\003\030\f", tmp1769_1766, 0); kawa.lang.SyntaxRule[] tmp1786_1736 = tmp1736_1673; Object[] tmp1819_1816 = new Object[3]; Object[] tmp1820_1819 = tmp1819_1816;tmp1820_1819[0] = Lit84; Object[] tmp1826_1820 = tmp1820_1819;tmp1826_1820[1] = Lit79;tmp1826_1820[2] = Lit85;tmp1786_1736[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", Lit88, 5, "prim_syntax.scm:82"), "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\t\033\b#", tmp1819_1816, 0); kawa.lang.SyntaxRule[] tmp1842_1786 = tmp1786_1736; Object[] tmp1875_1872 = new Object[4]; Object[] tmp1876_1875 = tmp1875_1872;tmp1876_1875[0] = Lit84; Object[] tmp1882_1876 = tmp1876_1875;tmp1882_1876[1] = Lit79;tmp1882_1876[2] = Lit86;tmp1842_1786[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", Lit89, 4, "prim_syntax.scm:84"), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\021\030\034\b\033", tmp1875_1872, 0); kawa.lang.SyntaxRule[] tmp1898_1842 = tmp1842_1786; Object[] tmp1931_1928 = new Object[2]; Object[] tmp1932_1931 = tmp1931_1928;tmp1932_1931[0] = Lit84;tmp1932_1931[1] = Lit85;tmp1898_1842[4] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", Lit82, 3, "prim_syntax.scm:86"), "\001\001\001", "\021\030\004\t\003\t\f\t\013\b\023", tmp1931_1928, 0); Object[] tmp1980_1977 = new Object[3]; Object[] tmp1981_1980 = tmp1980_1977;tmp1981_1980[0] = Lit84;tmp1981_1980[1] = Lit86;tmp1898_1842[5] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit67, 2, "prim_syntax.scm:88"), "\001\001", "\021\030\004\t\003\t\f\021\030\024\b\013", tmp1980_1977, 0);Lit11 = new kawa.lang.SyntaxRules(Lit87, tmp1672_1669, 5, Lit10); kawa.lang.SyntaxRule[] tmp2018_2015 = new kawa.lang.SyntaxRule[4]; kawa.lang.SyntaxRule[] tmp2019_2018 = tmp2018_2015; Object[] tmp2052_2049 = new Object[3]; Object[] tmp2053_2052 = tmp2052_2049;tmp2053_2052[0] = Lit84; Object[] tmp2059_2053 = tmp2053_2052;tmp2059_2053[1] = Lit79;tmp2059_2053[2] = Lit90;tmp2019_2018[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", Lit88, 5, "prim_syntax.scm:67"), "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\t\033\b#", tmp2052_2049, 0); kawa.lang.SyntaxRule[] tmp2075_2019 = tmp2019_2018; Object[] tmp2108_2105 = new Object[4]; Object[] tmp2109_2108 = tmp2108_2105;tmp2109_2108[0] = Lit84; Object[] tmp2115_2109 = tmp2109_2108;tmp2115_2109[1] = Lit79;tmp2115_2109[2] = Lit91;tmp2075_2019[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", Lit89, 4, "prim_syntax.scm:69"), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\021\030\034\b\033", tmp2108_2105, 0); kawa.lang.SyntaxRule[] tmp2131_2075 = tmp2075_2019; Object[] tmp2164_2161 = new Object[2]; Object[] tmp2165_2164 = tmp2164_2161;tmp2165_2164[0] = Lit84;tmp2165_2164[1] = Lit90;tmp2131_2075[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", Lit82, 3, "prim_syntax.scm:71"), "\001\001\001", "\021\030\004\t\003\t\f\t\013\b\023", tmp2164_2161, 0); Object[] tmp2213_2210 = new Object[3]; Object[] tmp2214_2213 = tmp2213_2210;tmp2214_2213[0] = Lit84;tmp2214_2213[1] = Lit91;tmp2131_2075[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit67, 2, "prim_syntax.scm:73"), "\001\001", "\021\030\004\t\003\t\f\021\030\024\b\013", tmp2213_2210, 0);Lit9 = new kawa.lang.SyntaxRules(Lit87, tmp2018_2015, 5, prim_syntax.Lit8 = gnu.mapping.Symbol.valueOf("define-early-constant")); kawa.lang.SyntaxRule[] tmp2258_2255 = new kawa.lang.SyntaxRule[4]; kawa.lang.SyntaxRule[] tmp2259_2258 = tmp2258_2255; Object[] tmp2292_2289 = new Object[3]; Object[] tmp2293_2292 = tmp2292_2289;tmp2293_2292[0] = Lit84; Object[] tmp2299_2293 = tmp2293_2292;tmp2299_2293[1] = Lit79;tmp2299_2293[2] = Lit92;tmp2259_2258[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", Lit88, 5, "prim_syntax.scm:56"), "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\t\033\b#", tmp2292_2289, 0); kawa.lang.SyntaxRule[] tmp2315_2259 = tmp2259_2258; Object[] tmp2348_2345 = new Object[4]; Object[] tmp2349_2348 = tmp2348_2345;tmp2349_2348[0] = Lit84; Object[] tmp2355_2349 = tmp2349_2348;tmp2355_2349[1] = Lit79;tmp2355_2349[2] = Lit93;tmp2315_2259[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", Lit89, 4, "prim_syntax.scm:58"), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\021\030\034\b\033", tmp2348_2345, 0); kawa.lang.SyntaxRule[] tmp2371_2315 = tmp2315_2259; Object[] tmp2404_2401 = new Object[2]; Object[] tmp2405_2404 = tmp2404_2401;tmp2405_2404[0] = Lit84;tmp2405_2404[1] = Lit92;tmp2371_2315[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", Lit82, 3, "prim_syntax.scm:60"), "\001\001\001", "\021\030\004\t\003\t\f\t\013\b\023", tmp2404_2401, 0); Object[] tmp2453_2450 = new Object[3]; Object[] tmp2454_2453 = tmp2453_2450;tmp2454_2453[0] = Lit84;tmp2454_2453[1] = Lit93;tmp2371_2315[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit67, 2, "prim_syntax.scm:62"), "\001\001", "\021\030\004\t\003\t\f\021\030\024\b\013", tmp2453_2450, 0);Lit7 = new kawa.lang.SyntaxRules(Lit87, tmp2258_2255, 5, prim_syntax.Lit6 = gnu.mapping.Symbol.valueOf("define-constant")); kawa.lang.SyntaxRule[] tmp2498_2495 = new kawa.lang.SyntaxRule[5]; kawa.lang.SyntaxRule[] tmp2499_2498 = tmp2498_2495; Object[] tmp2532_2529 = new Object[3]; Object[] tmp2533_2532 = tmp2532_2529;tmp2533_2532[0] = Lit84; Object[] tmp2539_2533 = tmp2533_2532;tmp2539_2533[1] = Lit79;tmp2539_2533[2] = Lit94;tmp2499_2498[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", Lit88, 5, "prim_syntax.scm:43"), "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\t\033\b#", tmp2532_2529, 0); kawa.lang.SyntaxRule[] tmp2555_2499 = tmp2499_2498; Object[] tmp2588_2585 = new Object[4]; Object[] tmp2589_2588 = tmp2588_2585;tmp2589_2588[0] = Lit84; Object[] tmp2595_2589 = tmp2589_2588;tmp2595_2589[1] = Lit79;tmp2595_2589[2] = Lit95;tmp2555_2499[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", Lit89, 4, "prim_syntax.scm:45"), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\021\030\034\b\033", tmp2588_2585, 0); kawa.lang.SyntaxRule[] tmp2611_2555 = tmp2555_2499; Object[] tmp2644_2641 = new Object[3]; Object[] tmp2645_2644 = tmp2644_2641;tmp2645_2644[0] = Lit84; Object[] tmp2651_2645 = tmp2645_2644;tmp2651_2645[1] = gnu.math.IntNum.valueOf(6);tmp2651_2645[2] = Boolean.TRUE;tmp2611_2555[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\013\023", Lit67, 3, "prim_syntax.scm:47"), "\001\000\000", "\021\030\004\t\003\t\f\t\024\t\n\022", tmp2644_2641, 0); kawa.lang.SyntaxRule[] tmp2669_2611 = tmp2611_2555; Object[] tmp2702_2699 = new Object[2]; Object[] tmp2703_2702 = tmp2702_2699;tmp2703_2702[0] = Lit84;tmp2703_2702[1] = Lit94;tmp2669_2611[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", Lit82, 3, "prim_syntax.scm:49"), "\001\001\001", "\021\030\004\t\003\t\f\t\013\b\023", tmp2702_2699, 0); Object[] tmp2751_2748 = new Object[3]; Object[] tmp2752_2751 = tmp2751_2748;tmp2752_2751[0] = Lit84;tmp2752_2751[1] = Lit95;tmp2669_2611[4] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit67, 2, "prim_syntax.scm:51"), "\001\001", "\021\030\004\t\003\t\f\021\030\024\b\013", tmp2751_2748, 0);Lit5 = new kawa.lang.SyntaxRules(Lit87, tmp2498_2495, 5, prim_syntax.Lit4 = gnu.mapping.Symbol.valueOf("define-private")); kawa.lang.SyntaxRule[] tmp2796_2793 = new kawa.lang.SyntaxRule[5]; kawa.lang.SyntaxRule[] tmp2797_2796 = tmp2796_2793; Object[] tmp2830_2827 = new Object[3]; Object[] tmp2831_2830 = tmp2830_2827;tmp2831_2830[0] = Lit84; Object[] tmp2837_2831 = tmp2831_2830;tmp2837_2831[1] = Lit79;tmp2837_2831[2] = Lit96;tmp2797_2796[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", Lit88, 5, "prim_syntax.scm:30"), "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\t\033\b#", tmp2830_2827, 0); kawa.lang.SyntaxRule[] tmp2853_2797 = tmp2797_2796; Object[] tmp2886_2883 = new Object[4]; Object[] tmp2887_2886 = tmp2886_2883;tmp2887_2886[0] = Lit84; Object[] tmp2893_2887 = tmp2887_2886;tmp2893_2887[1] = Lit79;tmp2893_2887[2] = Lit97;tmp2853_2797[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", Lit89, 4, "prim_syntax.scm:32"), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\t\024\021\030\034\b\033", tmp2886_2883, 0); kawa.lang.SyntaxRule[] tmp2909_2853 = tmp2853_2797; Object[] tmp2942_2939 = new Object[3]; Object[] tmp2943_2942 = tmp2942_2939;tmp2943_2942[0] = Lit84; Object[] tmp2949_2943 = tmp2943_2942;tmp2949_2943[1] = gnu.math.IntNum.valueOf(2);tmp2949_2943[2] = Boolean.TRUE;tmp2909_2853[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\013\023", Lit67, 3, "prim_syntax.scm:34"), "\001\000\000", "\021\030\004\t\003\t\f\t\024\t\n\022", tmp2942_2939, 0); kawa.lang.SyntaxRule[] tmp2966_2909 = tmp2909_2853; Object[] tmp2999_2996 = new Object[2]; Object[] tmp3000_2999 = tmp2999_2996;tmp3000_2999[0] = Lit84;tmp3000_2999[1] = Lit96;tmp2966_2909[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", Lit82, 3, "prim_syntax.scm:36"), "\001\001\001", "\021\030\004\t\003\t\f\t\013\b\023", tmp2999_2996, 0); Object[] tmp3048_3045 = new Object[3]; Object[] tmp3049_3048 = tmp3048_3045;tmp3049_3048[0] = Lit84;tmp3049_3048[1] = Lit97;tmp2966_2909[4] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit67, 2, "prim_syntax.scm:38"), "\001\001", "\021\030\004\t\003\t\f\021\030\024\b\013", tmp3048_3045, 0);Lit3 = new kawa.lang.SyntaxRules(Lit87, tmp2796_2793, 5, prim_syntax.Lit2 = gnu.mapping.Symbol.valueOf("define")); kawa.lang.SyntaxRule[] tmp3093_3090 = new kawa.lang.SyntaxRule[4]; kawa.lang.SyntaxRule[] tmp3094_3093 = tmp3093_3090; Object[] tmp3127_3124 = new Object[3]; Object[] tmp3128_3127 = tmp3127_3124;tmp3128_3127[0] = Lit98; Object[] tmp3134_3128 = tmp3128_3127;tmp3134_3128[1] = Lit79;tmp3134_3128[2] = Lit72;tmp3094_3093[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030l\\\f\002\f\007,\f\017\f\027\b\b\033#", Lit89, 5, "prim_syntax.scm:17"), "\001\001\001\000\000", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\b\021\030\024\t\032\"", tmp3127_3124, 0); kawa.lang.SyntaxRule[] tmp3150_3094 = tmp3094_3093; Object[] tmp3183_3180 = new Object[2]; Object[] tmp3184_3183 = tmp3183_3180;tmp3184_3183[0] = Lit98;tmp3184_3183[1] = Lit79;tmp3150_3094[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", Lit89, 4, "prim_syntax.scm:20"), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\b\033", tmp3183_3180, 0); kawa.lang.SyntaxRule[] tmp3200_3150 = tmp3150_3094; Object[] tmp3233_3230 = new Object[2]; Object[] tmp3234_3233 = tmp3233_3230;tmp3234_3233[0] = Lit98;tmp3234_3233[1] = Lit72;tmp3200_3150[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\013\023", Lit67, 3, "prim_syntax.scm:22"), "\001\000\000", "\021\030\004\t\003\b\021\030\f\t\n\022", tmp3233_3230, 0);tmp3200_3150[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit67, 2, "prim_syntax.scm:25"), "\001\001", "\021\030\004\t\003\b\013", new Object[] { Lit98 }, 0);Lit1 = new kawa.lang.SyntaxRules(Lit89, tmp3093_3090, 5, prim_syntax.Lit0 = gnu.mapping.Symbol.valueOf("define-syntax"));$instance = new prim_syntax();$Prvt$$Pcdefine = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.define", "defineRaw");
    $Prvt$$Pcdefine$Mnsyntax = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.define_syntax", "define_syntax");
    $Prvt$$Pclet = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.let", "let");
    $Prvt$set$Ex = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.set_b", "set");
    
    $Prvt$lambda = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");$Prvt$mlambda = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.SchemeCompilation", "mlambda");define$Mnsyntax = kawa.lang.Macro.make(Lit0, Lit1, "kawa.lib.prim_syntax");define = kawa.lang.Macro.make(Lit2, Lit3, "kawa.lib.prim_syntax");define$Mnprivate = kawa.lang.Macro.make(Lit4, Lit5, "kawa.lib.prim_syntax");define$Mnconstant = kawa.lang.Macro.make(Lit6, Lit7, "kawa.lib.prim_syntax");define$Mnearly$Mnconstant = kawa.lang.Macro.make(Lit8, Lit9, "kawa.lib.prim_syntax");define$Mnvariable = kawa.lang.Macro.make(Lit10, Lit11, "kawa.lib.prim_syntax");prim_syntax localPrim_syntax1 = $instance;report$Mnsyntax$Mnerror = new gnu.expr.ModuleMethod(localPrim_syntax1, 1, Lit12, 61441);syntax$Mn$Grexpression = kawa.lang.Macro.make(Lit13, Lit14, "kawa.lib.prim_syntax");syntax$Mnbody$Mn$Grexpression = kawa.lang.Macro.make(Lit15, Lit16, "kawa.lib.prim_syntax");
    


























































































    prim_syntax localPrim_syntax2 = $instance; void tmp3534_3531 = new gnu.expr.ModuleMethod(localPrim_syntax2, 2, null, 4097);tmp3534_3531.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:105");$Prvt$$Pcif$Mnand$Mnx = kawa.lang.Macro.make(Lit17, tmp3534_3531, "kawa.lib.prim_syntax");
    







    prim_syntax localPrim_syntax3 = $instance; void tmp3572_3569 = new gnu.expr.ModuleMethod(localPrim_syntax3, 3, null, 4097);tmp3572_3569.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:114");if = kawa.lang.Macro.makeSkipScanForm(Lit23, tmp3572_3569, "kawa.lib.prim_syntax");
    








































    prim_syntax localPrim_syntax4 = $instance; void tmp3610_3607 = new gnu.expr.ModuleMethod(localPrim_syntax4, 4, null, 4097);tmp3610_3607.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:156");try$Mncatch = kawa.lang.Macro.makeSkipScanForm(Lit47, tmp3610_3607, "kawa.lib.prim_syntax");
    







    prim_syntax localPrim_syntax5 = $instance; void tmp3650_3647 = new gnu.expr.ModuleMethod(localPrim_syntax5, 5, null, 4097);tmp3650_3647.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:165");letrec = kawa.lang.Macro.make(Lit51, tmp3650_3647, "kawa.lib.prim_syntax");$runBody$();
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 2:  return lambda1(paramObject);
    






    case 3: 
      return lambda2(paramObject);
    







































    case 4: 
      return lambda3(paramObject);
    






    case 5: 
      return lambda4(paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  static Object lambda4(Object form) { gnu.lists.EmptyList localEmptyList = gnu.lists.LList.Empty;Object out$Mninits = gnu.lists.LList.Empty;
    Object localObject1 = form;Object[] arrayOfObject1 = kawa.lang.SyntaxPattern.allocVars(2, null);
    






















    kawa.lang.TemplateScope localTemplateScope1 = kawa.lang.TemplateScope.make();Object b = Lit53.execute(arrayOfObject1, localTemplateScope1);Object localObject2 = b;Object[] arrayOfObject2 = kawa.lang.SyntaxPattern.allocVars(7, arrayOfObject1); if (!Lit54.match(b, arrayOfObject2, 0))
    {



      kawa.lang.TemplateScope localTemplateScope2 = kawa.lang.TemplateScope.make();out$Mnbindings = new gnu.lists.Pair(Lit56.execute(arrayOfObject2, localTemplateScope2), out$Mnbindings);
      localTemplateScope2 = kawa.lang.TemplateScope.make();out$Mninits = new gnu.lists.Pair(Lit57.execute(arrayOfObject2, localTemplateScope2), out$Mninits);
      localTemplateScope2 = kawa.lang.TemplateScope.make();
      

      localTemplateScope2 = kawa.lang.TemplateScope.make();out$Mnbindings = new gnu.lists.Pair(Lit60.execute(arrayOfObject2, localTemplateScope2), out$Mnbindings);
      localTemplateScope2 = kawa.lang.TemplateScope.make();out$Mninits = new gnu.lists.Pair(Lit61.execute(arrayOfObject2, localTemplateScope2), out$Mninits);
      localTemplateScope2 = kawa.lang.TemplateScope.make(); if (Lit63.match(b, arrayOfObject2, 0))
      {
        reportSyntaxError(b, new Object[] { "missing initializion in letrec" }); } else if (Lit64.match(b, arrayOfObject2, 0))
      {
        reportSyntaxError(b, new Object[] { "invalid bindings syntax in letrec" }); } else kawa.standard.syntax_case.error("syntax-case", b);
    }
    Object out$Mnbindings = gnu.lists.LList.reverseInPlace(out$Mnbindings);
    out$Mninits = gnu.lists.LList.reverseInPlace(out$Mninits);
    b = kawa.lang.TemplateScope.make();return Lit52.match(form, arrayOfObject1, 0) ? kawa.lang.Quote.append$V(new Object[] { Lit65.execute(arrayOfObject1, (kawa.lang.TemplateScope)b), kawa.lang.Quote.consX$V(new Object[] { out$Mnbindings, kawa.lang.Quote.append$V(new Object[] { out$Mninits, Lit66.execute(arrayOfObject1, (kawa.lang.TemplateScope)b) }) }) }) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
  public prim_syntax()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
  
  /* Error */
  public Object applyN(gnu.expr.ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 490	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_1
    //   5: if_icmpne +40 -> 45
    //   8: goto +3 -> 11
    //   11: aload_2
    //   12: iconst_0
    //   13: aaload
    //   14: aload_2
    //   15: arraylength
    //   16: iconst_1
    //   17: isub
    //   18: istore_3
    //   19: iload_3
    //   20: anewarray 282	java/lang/Object
    //   23: goto +11 -> 34
    //   26: dup
    //   27: iload_3
    //   28: aload_2
    //   29: iload_3
    //   30: iconst_1
    //   31: iadd
    //   32: aaload
    //   33: aastore
    //   34: iinc 3 -1
    //   37: iload_3
    //   38: ifge -12 -> 26
    //   41: invokestatic 374	kawa/lib/prim_syntax:reportSyntaxError	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/Expression;
    //   44: areturn
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 537	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   51: areturn
    // Line number table:
    //   Java source line #91	-> byte code offset #11
  }
}
