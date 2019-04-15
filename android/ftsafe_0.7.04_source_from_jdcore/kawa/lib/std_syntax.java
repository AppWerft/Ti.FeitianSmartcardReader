package kawa.lib; import kawa.lang.SyntaxRule;

public class std_syntax extends gnu.expr.ModuleBody { public static final kawa.lang.Macro cond; public static final kawa.lang.Macro and; public static final kawa.lang.Macro or; public static final kawa.lang.Macro let; public static final kawa.lang.Macro let$St; public static final kawa.lang.Macro jdField_do; public static final kawa.lang.Macro delay; public static final kawa.lang.Macro lazy; public static final kawa.lang.Macro delay$Mnforce; public static final kawa.lang.Macro jdField_else; public static final kawa.lang.Macro $Dt$Dt$Dt; public static final kawa.lang.Macro $Qu; public static final kawa.lang.Macro $Eq$Gr; public static final kawa.lang.Macro _; public static final kawa.lang.Macro unquote; public static final kawa.lang.Macro unquote$Mnsplicing; public static final gnu.expr.ModuleMethod syntax$Mn$Grdatum; public static final gnu.expr.ModuleMethod datum$Mn$Grsyntax; public static final kawa.lang.Macro with$Mnsyntax; public static final gnu.expr.ModuleMethod syntax$Mnobject$Mn$Grdatum; public static final gnu.expr.ModuleMethod datum$Mn$Grsyntax$Mnobject; public static final gnu.expr.ModuleMethod generate$Mntemporaries; public static final kawa.lang.Macro define$Mnprocedure; public static final gnu.expr.ModuleMethod identifier$Qu; public static final gnu.expr.ModuleMethod free$Mnidentifier$Eq$Qu; public static final gnu.expr.ModuleMethod bound$Mnidentifier$Eq$Qu; public static final gnu.expr.ModuleMethod syntax$Mnsource; public static final gnu.expr.ModuleMethod syntax$Mnline; public static final gnu.expr.ModuleMethod syntax$Mncolumn; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$if; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$letrec; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$syntax$Mncase; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$Pclet; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$Pcdefine; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$lambda; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$not; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$begin; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$syntax$Mnerror; public static final kawa.lang.Macro $Prvt$$Pclet$Mnlambda1; public static final kawa.lang.Macro $Prvt$$Pclet$Mnlambda2; public static final kawa.lang.Macro $Prvt$$Pclet$Mninit; public static final kawa.lang.Macro $Prvt$$Pcdo$Mnstep; public static final kawa.lang.Macro $Prvt$$Pcdo$Mninit; public static final kawa.lang.Macro $Prvt$$Pcdo$Mnlambda1; public static final kawa.lang.Macro $Prvt$$Pcdo$Mnlambda2; static final gnu.math.IntNum Lit0; static final gnu.math.IntNum Lit1; public static std_syntax $instance; static final gnu.mapping.SimpleSymbol Lit2; static final kawa.lang.SyntaxRules Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final kawa.lang.SyntaxRules Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final kawa.lang.SyntaxRules Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final kawa.lang.SyntaxRules Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final kawa.lang.SyntaxRules Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final kawa.lang.SyntaxRules Lit13; static final gnu.mapping.SimpleSymbol Lit14; static final kawa.lang.SyntaxRules Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final kawa.lang.SyntaxRules Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final kawa.lang.SyntaxPattern Lit19; static final kawa.lang.SyntaxPattern Lit20; static final kawa.lang.SyntaxTemplate Lit21; static final kawa.lang.SyntaxPattern Lit22; static final kawa.lang.SyntaxTemplate Lit23; static final gnu.mapping.SimpleSymbol Lit24; static final kawa.lang.SyntaxPattern Lit25; static final kawa.lang.SyntaxPattern Lit26; static final kawa.lang.SyntaxTemplate Lit27; static final kawa.lang.SyntaxPattern Lit28; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  static final kawa.lang.SyntaxTemplate Lit29;
  static final gnu.mapping.SimpleSymbol Lit30;
  static final kawa.lang.SyntaxRules Lit31;
  static final gnu.mapping.SimpleSymbol Lit32;
  static final kawa.lang.SyntaxRules Lit33;
  static final gnu.mapping.SimpleSymbol Lit34; static final kawa.lang.SyntaxRules Lit35; static final gnu.mapping.SimpleSymbol Lit36; static final kawa.lang.SyntaxRules Lit37; static final gnu.mapping.SimpleSymbol Lit38; static final kawa.lang.SyntaxRules Lit39; static final gnu.mapping.SimpleSymbol Lit40; static final kawa.lang.SyntaxRules Lit41; static final gnu.mapping.SimpleSymbol Lit42; static final kawa.lang.SyntaxRules Lit43; static final gnu.mapping.SimpleSymbol Lit44; static final kawa.lang.SyntaxRules Lit45; static final gnu.mapping.SimpleSymbol Lit46; static final kawa.lang.SyntaxRules Lit47; static final gnu.mapping.SimpleSymbol Lit48; static final kawa.lang.SyntaxRules Lit49; static final gnu.mapping.SimpleSymbol Lit50; static final kawa.lang.SyntaxPattern Lit51; static final kawa.lang.SyntaxTemplate Lit52; static final gnu.mapping.SimpleSymbol Lit53; static final kawa.lang.SyntaxPattern Lit54; static final kawa.lang.SyntaxTemplate Lit55; static final gnu.mapping.SimpleSymbol Lit56; static final kawa.lang.SyntaxPattern Lit57; static final kawa.lang.SyntaxTemplate Lit58; static final gnu.mapping.SimpleSymbol Lit59; static final kawa.lang.SyntaxRules Lit60; static final gnu.mapping.SimpleSymbol Lit61; static final gnu.mapping.SimpleSymbol Lit62; static final gnu.mapping.SimpleSymbol Lit63; static final gnu.mapping.SimpleSymbol Lit64; static final gnu.mapping.SimpleSymbol Lit65; static final gnu.mapping.SimpleSymbol Lit66; static final gnu.mapping.SimpleSymbol Lit67;
  static { gnu.mapping.SimpleSymbol tmp40_37 = gnu.mapping.Symbol.valueOf("=>");Lit4 = tmp40_37;(std_syntax.Lit93 = new Object[1])[0] = tmp40_37; gnu.mapping.SimpleSymbol tmp60_57 = gnu.mapping.Symbol.valueOf("else");Lit10 = tmp60_57;(std_syntax.Lit91 = new Object[1])[0] = tmp60_57; gnu.mapping.SimpleSymbol tmp79_76 = gnu.mapping.Symbol.valueOf("begin");Lit75 = tmp79_76;(std_syntax.Lit90 = new Object[1])[0] = tmp79_76;Lit89 = gnu.mapping.Symbol.valueOf("if"); gnu.mapping.SimpleSymbol tmp107_104 = gnu.mapping.Symbol.valueOf("%let-lambda2");Lit32 = tmp107_104;(std_syntax.Lit88 = new Object[1])[0] = tmp107_104; Object[] tmp120_117 = (std_syntax.Lit87 = new Object[2]); gnu.mapping.SimpleSymbol tmp128_125 = gnu.mapping.Symbol.valueOf("%let-lambda1");Lit30 = tmp128_125;tmp120_117[0] = tmp128_125; gnu.mapping.SimpleSymbol tmp140_137 = gnu.mapping.Symbol.valueOf("::");Lit79 = tmp140_137;tmp120_117[1] = tmp140_137;Lit86 = gnu.mapping.Symbol.valueOf("letrec");Lit85 = gnu.mapping.Symbol.valueOf("%let");(std_syntax.Lit84 = new Object[1])[0] = Lit85;Lit83 = gnu.mapping.Symbol.valueOf("syntax-error"); gnu.mapping.SimpleSymbol tmp199_196 = gnu.mapping.Symbol.valueOf("%do-lambda2");Lit46 = tmp199_196;(std_syntax.Lit82 = new Object[1])[0] = tmp199_196; gnu.mapping.SimpleSymbol tmp219_216 = gnu.mapping.Symbol.valueOf("%do-lambda1");Lit44 = tmp219_216;(std_syntax.Lit81 = new Object[1])[0] = tmp219_216; Object[] tmp232_229 = (std_syntax.Lit80 = new Object[2]);tmp232_229[0] = Lit44;tmp232_229[1] = Lit79;(std_syntax.Lit78 = new Object[1])[0] = Lit79;(std_syntax.Lit77 = new Object[1])[0] = gnu.mapping.Symbol.valueOf("lambda");Lit76 = gnu.mapping.Symbol.valueOf("syntax-case");Lit74 = new Object[0]; SyntaxRule[] tmp298_295 = new SyntaxRule[3]; SyntaxRule[] tmp299_298 = tmp298_295;tmp299_298[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\b\f\007\r\017\b\b\b", Lit74, 2, "std_syntax.scm:357"), "\001\003", "\021\030\004\t\003\b\r\013", Lit90, 1); SyntaxRule[] tmp336_299 = tmp299_298; Object[] tmp369_366 = new Object[2]; Object[] tmp370_369 = tmp369_366;tmp370_369[0] = Lit76;tmp370_369[1] = Lit75;tmp336_299[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<,\f\007\f\017\b\b\f\027\r\037\030\b\b", Lit74, 4, "std_syntax.scm:359"), "\001\001\001\003", "\021\030\004\t\013\t\020\b\t\003\b\021\030\f\t\023\b\035\033", tmp369_366, 1); Object[] tmp418_415 = new Object[3]; Object[] tmp419_418 = tmp418_415;tmp419_418[0] = Lit76; Object[] tmp425_419 = tmp419_418;tmp425_419[1] = gnu.mapping.Symbol.valueOf("list");tmp425_419[2] = Lit75;tmp336_299[2] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L-\f\007\f\017\b\000\020\b\f\027\r\037\030\b\b", Lit74, 4, "std_syntax.scm:361"), "\003\003\001\003", "\021\030\0041\021\030\f\b\r\013\t\020\b\031\b\005\003\b\021\030\024\t\023\b\035\033", tmp418_415, 1);Lit73 = new kawa.lang.SyntaxRules(Lit74, tmp298_295, 4, std_syntax.Lit72 = gnu.mapping.Symbol.valueOf("with-syntax"));Lit71 = gnu.mapping.Symbol.valueOf("syntax-column");Lit70 = gnu.mapping.Symbol.valueOf("syntax-line");Lit69 = gnu.mapping.Symbol.valueOf("syntax-source");Lit68 = gnu.mapping.Symbol.valueOf("bound-identifier=?");Lit67 = gnu.mapping.Symbol.valueOf("free-identifier=?");Lit66 = gnu.mapping.Symbol.valueOf("identifier?");Lit65 = gnu.mapping.Symbol.valueOf("generate-temporaries");Lit64 = gnu.mapping.Symbol.valueOf("datum->syntax-object");Lit63 = gnu.mapping.Symbol.valueOf("datum->syntax");Lit62 = gnu.mapping.Symbol.valueOf("syntax-object->datum");Lit61 = gnu.mapping.Symbol.valueOf("syntax->datum"); SyntaxRule[] tmp571_568 = new SyntaxRule[1]; Object[] tmp604_601 = new Object[3]; Object[] tmp605_604 = tmp604_601;tmp605_604[0] = gnu.mapping.Symbol.valueOf("%define"); Object[] tmp614_605 = tmp605_604;tmp614_605[1] = gnu.math.IntNum.valueOf(27);tmp614_605[2] = gnu.mapping.Symbol.valueOf("gnu.expr.GenericProc");tmp571_568[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\013", Lit74, 2, "std_syntax.scm:275"), "\001\000", "\021\030\004\t\003\t\f\021\030\024\n", tmp604_601, 0);Lit60 = new kawa.lang.SyntaxRules(Lit74, tmp571_568, 2, std_syntax.Lit59 = gnu.mapping.Symbol.valueOf("define-procedure"));Lit58 = new kawa.lang.SyntaxTemplate("\001\001", "\021\030\004\t\020\b\013", Lit77, 0);Lit57 = new kawa.lang.SyntaxPattern("\f\007\f\017\b", Lit74, 2, "std_syntax.scm:269");Lit56 = gnu.mapping.Symbol.valueOf("delay");Lit55 = new kawa.lang.SyntaxTemplate("\001", "\021\030\004\t\020\b\003", Lit77, 0);Lit54 = new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit74, 1, "std_syntax.scm:263");Lit53 = gnu.mapping.Symbol.valueOf("delay-force");Lit52 = new kawa.lang.SyntaxTemplate("\001", "\021\030\004\t\020\b\003", Lit77, 0);Lit51 = new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit74, 1, "std_syntax.scm:257");Lit50 = gnu.mapping.Symbol.valueOf("lazy"); SyntaxRule[] tmp810_807 = new SyntaxRule[1]; Object[] tmp844_841 = new Object[9]; Object[] tmp845_844 = tmp844_841;tmp845_844[0] = Lit86; Object[] tmp851_845 = tmp845_844;tmp851_845[1] = gnu.mapping.Symbol.valueOf("%do%loop"); Object[] tmp860_851 = tmp851_845;tmp860_851[2] = Lit44; Object[] tmp866_860 = tmp860_851;tmp866_860[3] = Lit89; Object[] tmp872_866 = tmp866_860;tmp872_866[4] = gnu.mapping.Symbol.valueOf("not"); Object[] tmp880_872 = tmp872_866;tmp880_872[5] = Lit75; Object[] tmp886_880 = tmp880_872; gnu.mapping.SimpleSymbol tmp895_892 = gnu.mapping.Symbol.valueOf("%do-step");Lit40 = tmp895_892;tmp886_880[6] = tmp895_892; Object[] tmp900_886 = tmp886_880;tmp900_886[7] = gnu.mapping.Values.empty; gnu.mapping.SimpleSymbol tmp915_912 = gnu.mapping.Symbol.valueOf("%do-init");Lit42 = tmp915_912;tmp900_886[8] = tmp915_912;tmp810_807[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030,\r\007\000\b\b\034\f\017\023\r\037\030\b\b", Lit74, 4, "std_syntax.scm:237"), "\003\001\000\003", "\021\030\004Ɖ\b\021\030\f\b\021\030\024\031\b\005\003\t\020\b\021\030\034)\021\030$\b\013\021\030,\021\035\033\b\021\030\f\b\005\021\0304\003\b\021\030,\021\030<\022\b\021\030\f\b\005\021\030D\b\003", tmp844_841, 1);Lit49 = new kawa.lang.SyntaxRules(Lit78, tmp810_807, 4, std_syntax.Lit48 = gnu.mapping.Symbol.valueOf("do")); SyntaxRule[] tmp953_950 = new SyntaxRule[2]; SyntaxRule[] tmp954_953 = tmp953_950;tmp954_953[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\013\f\027\f\037\b", Lit74, 4, "std_syntax.scm:230"), "\001\000\001\001", "\021\030\004\t\n\031\t\003\023\b\033", Lit82, 0);tmp954_953[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\b\f\007\f\017\b", Lit74, 2, "std_syntax.scm:232"), "\001\001", "\021\030\004\t\003\b\013", Lit77, 0);Lit47 = new kawa.lang.SyntaxRules(Lit74, tmp953_950, 4, Lit46); SyntaxRule[] tmp1048_1045 = new SyntaxRule[5]; SyntaxRule[] tmp1049_1048 = tmp1048_1045;tmp1049_1048[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030l\\\f\007\f\002\f\017\f\027\f\037\b#\f/\f7\b", Lit78, 7, "std_syntax.scm:216"), "\001\001\001\001\000\001\001", "\021\030\004\t\"I9\t\003\021\030\f\b\013+\b3", Lit80, 0); SyntaxRule[] tmp1087_1049 = tmp1049_1048;tmp1087_1049[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\L\f\007\f\002\f\017\f\027\b\033\f'\f/\b", Lit78, 6, "std_syntax.scm:218"), "\001\001\001\000\001\001", "\021\030\004\t\032I9\t\003\021\030\f\b\013#\b+", Lit80, 0); SyntaxRule[] tmp1125_1087 = tmp1087_1049;tmp1125_1087[2] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L<\f\007\f\017\f\027\b\033\f'\f/\b", Lit74, 6, "std_syntax.scm:220"), "\001\001\001\000\001\001", "\021\030\004\t\032\031\t\003#\b+", Lit81, 0); SyntaxRule[] tmp1163_1125 = tmp1125_1087;tmp1163_1125[3] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<,\f\007\f\017\b\023\f\037\f'\b", Lit74, 5, "std_syntax.scm:222"), "\001\001\000\001\001", "\021\030\004\t\022\031\t\003\033\b#", Lit81, 0);tmp1163_1125[4] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\b\f\007\f\017\b", Lit74, 2, "std_syntax.scm:224"), "\001\001", "\021\030\004\t\003\t\020\b\013", Lit82, 0);Lit45 = new kawa.lang.SyntaxRules(Lit78, tmp1048_1045, 7, Lit44); SyntaxRule[] tmp1259_1256 = new SyntaxRule[7]; SyntaxRule[] tmp1260_1259 = tmp1259_1256;tmp1260_1259[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\\f\007\f\002\f\017\f\027\f\037\b\b", Lit78, 4, "std_syntax.scm:198"), "\001\001\001\001", "\023", Lit74, 0); SyntaxRule[] tmp1297_1260 = tmp1260_1259;tmp1297_1260[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L\f\007\f\002\f\017\f\027\b\b", Lit78, 3, "std_syntax.scm:200"), "\001\001\001", "\023", Lit74, 0); SyntaxRule[] tmp1334_1297 = tmp1297_1260;tmp1334_1297[2] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", Lit74, 3, "std_syntax.scm:202"), "\001\001\001", "\013", Lit74, 0); SyntaxRule[] tmp1371_1334 = tmp1334_1297;tmp1371_1334[3] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030,\f\007\f\017\b\b", Lit74, 2, "std_syntax.scm:204"), "\001\001", "\013", Lit74, 0); SyntaxRule[] tmp1408_1371 = tmp1371_1334;tmp1408_1371[4] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", Lit74, 3, "std_syntax.scm:206"), "\001\001\001", "\023", Lit74, 0); SyntaxRule[] tmp1445_1408 = tmp1408_1371;tmp1445_1408[5] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\b\b", Lit74, 1, "std_syntax.scm:208"), "\001", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("do binding with no value", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 856082)) }, 0);tmp1445_1408[6] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\b", Lit74, 4, "std_syntax.scm:210"), "\001\001\001\001", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("do binding must have syntax: (var [:: type] init [step])", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 868357)) }, 0);Lit43 = new kawa.lang.SyntaxRules(Lit78, tmp1259_1256, 4, Lit42); SyntaxRule[] tmp1590_1587 = new SyntaxRule[4]; SyntaxRule[] tmp1591_1590 = tmp1590_1587;tmp1591_1590[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\f\037\b", Lit78, 4, "std_syntax.scm:191"), "\001\001\001\001", "\033", Lit74, 0); SyntaxRule[] tmp1628_1591 = tmp1591_1590;tmp1628_1591[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", Lit78, 3, "std_syntax.scm:192"), "\001\001\001", "\003", Lit74, 0); SyntaxRule[] tmp1665_1628 = tmp1628_1591;tmp1665_1628[2] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit74, 3, "std_syntax.scm:193"), "\001\001\001", "\023", Lit74, 0);tmp1665_1628[3] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit74, 2, "std_syntax.scm:194"), "\001\001", "\003", Lit74, 0);Lit41 = new kawa.lang.SyntaxRules(Lit78, tmp1590_1587, 4, Lit40); SyntaxRule[] tmp1759_1756 = new SyntaxRule[5]; SyntaxRule[] tmp1760_1759 = tmp1759_1756;tmp1760_1759[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\b\003", Lit74, 1, "std_syntax.scm:173"), "\000", "\021\030\004\t\020\002", Lit84, 0); SyntaxRule[] tmp1797_1760 = tmp1760_1759;tmp1797_1760[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\b\013", Lit74, 2, "std_syntax.scm:174"), "\001\000", "\021\030\004\021\b\003\n", Lit84, 0); SyntaxRule[] tmp1834_1797 = tmp1797_1760; Object[] tmp1867_1864 = new Object[2]; Object[] tmp1868_1867 = tmp1867_1864;tmp1868_1867[0] = Lit85; gnu.mapping.SimpleSymbol tmp1881_1878 = gnu.mapping.Symbol.valueOf("let*");Lit38 = tmp1881_1878;tmp1868_1867[1] = tmp1881_1878;tmp1834_1797[2] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\013\023", Lit74, 3, "std_syntax.scm:176"), "\001\000\000", "\021\030\004\021\b\003\b\021\030\f\t\n\022", tmp1867_1864, 0); SyntaxRule[] tmp1891_1834 = tmp1834_1797;tmp1891_1834[3] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\013", Lit74, 2, "std_syntax.scm:179"), "\001\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("invalid bindings list in let*", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 741383)) }, 0);tmp1891_1834[4] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit74, 1, "std_syntax.scm:182"), "\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("missing bindings list in let*", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 753671)) }, 0);Lit39 = new kawa.lang.SyntaxRules(Lit74, tmp1759_1756, 3, Lit38); SyntaxRule[] tmp2035_2032 = new SyntaxRule[2]; SyntaxRule[] tmp2036_2035 = tmp2035_2032;tmp2036_2035[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030,\r\007\000\b\b\013", Lit74, 2, "std_syntax.scm:157"), "\003\000", "\021\030\004\031\b\005\003\n", Lit84, 1); Object[] tmp2105_2102 = new Object[3]; Object[] tmp2106_2105 = tmp2105_2102;tmp2106_2105[0] = Lit86; Object[] tmp2112_2106 = tmp2106_2105;tmp2112_2106[1] = Lit30; gnu.mapping.SimpleSymbol tmp2125_2122 = gnu.mapping.Symbol.valueOf("%let-init");Lit34 = tmp2125_2122;tmp2112_2106[2] = tmp2125_2122;tmp2036_2035[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007,\r\017\b\b\b\023", Lit74, 3, "std_syntax.scm:164"), "\001\003\000", "©\021\030\004y\b\t\003\b\021\030\f\031\b\r\013\t\020\b\022\b\003\b\r\021\030\024\b\013", tmp2105_2102, 1);Lit37 = new kawa.lang.SyntaxRules(Lit74, tmp2035_2032, 3, std_syntax.Lit36 = gnu.mapping.Symbol.valueOf("let")); SyntaxRule[] tmp2162_2159 = new SyntaxRule[5]; SyntaxRule[] tmp2163_2162 = tmp2162_2159;tmp2163_2162[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030,\f\007\f\017\b\b", Lit74, 2, "std_syntax.scm:143"), "\001\001", "\013", Lit74, 0); SyntaxRule[] tmp2200_2163 = tmp2163_2162;tmp2200_2163[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L\f\007\f\002\f\017\f\027\b\b", Lit78, 3, "std_syntax.scm:145"), "\001\001\001", "\023", Lit74, 0); SyntaxRule[] tmp2237_2200 = tmp2200_2163;tmp2237_2200[2] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", Lit74, 3, "std_syntax.scm:147"), "\001\001\001", "\023", Lit74, 0); SyntaxRule[] tmp2274_2237 = tmp2237_2200;tmp2274_2237[3] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\b\b", Lit74, 1, "std_syntax.scm:149"), "\001", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("let binding with no value", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 614418)) }, 0);tmp2274_2237[4] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\b", Lit74, 4, "std_syntax.scm:151"), "\001\001\001\001", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("let binding must have syntax: (var [type] init)", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 626693)) }, 0);Lit35 = new kawa.lang.SyntaxRules(Lit78, tmp2162_2159, 4, Lit34); SyntaxRule[] tmp2418_2415 = new SyntaxRule[2]; SyntaxRule[] tmp2419_2418 = tmp2418_2415;tmp2419_2418[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\013\f\027\f\037\b", Lit74, 4, "std_syntax.scm:136"), "\001\000\001\001", "\021\030\004\t\n\031\t\003\023\b\033", Lit88, 0);tmp2419_2418[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\b\f\007\f\017\b", Lit74, 2, "std_syntax.scm:138"), "\001\001", "\021\030\004\t\003\013", Lit77, 0);Lit33 = new kawa.lang.SyntaxRules(Lit74, tmp2418_2415, 4, Lit32); SyntaxRule[] tmp2513_2510 = new SyntaxRule[4]; SyntaxRule[] tmp2514_2513 = tmp2513_2510;tmp2514_2513[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L<\f\007\f\017\f\027\b\033\f'\f/\b", Lit74, 6, "std_syntax.scm:124"), "\001\001\001\000\001\001", "\021\030\004\t\032I9\t\003\021\030\f\b\013#\b+", Lit87, 0); SyntaxRule[] tmp2552_2514 = tmp2514_2513;tmp2552_2514[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\\L\f\007\f\002\f\017\f\027\b\033\f'\f/\b", Lit78, 6, "std_syntax.scm:126"), "\001\001\001\000\001\001", "\021\030\004\t\032I9\t\003\021\030\f\b\013#\b+", Lit87, 0); SyntaxRule[] tmp2590_2552 = tmp2552_2514;tmp2590_2552[2] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<,\f\007\f\017\b\023\f\037\f'\b", Lit74, 5, "std_syntax.scm:128"), "\001\001\000\001\001", "\021\030\004\t\022\031\t\003\033\b#", new Object[] { Lit30 }, 0);tmp2590_2552[3] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\b\f\007\f\017\b", Lit74, 2, "std_syntax.scm:130"), "\001\001", "\021\030\004\t\003\t\020\b\013", Lit88, 0);Lit31 = new kawa.lang.SyntaxRules(Lit78, tmp2513_2510, 6, Lit30); Object[] tmp2695_2692 = new Object[4]; Object[] tmp2696_2695 = tmp2695_2692;tmp2696_2695[0] = Lit85; Object[] tmp2702_2696 = tmp2696_2695;tmp2702_2696[1] = gnu.mapping.Symbol.valueOf("x"); Object[] tmp2711_2702 = tmp2702_2696;tmp2711_2702[2] = Lit89; gnu.mapping.SimpleSymbol tmp2724_2721 = gnu.mapping.Symbol.valueOf("or");Lit24 = tmp2724_2721;tmp2711_2702[3] = tmp2724_2721;Lit29 = new kawa.lang.SyntaxTemplate("\001\003", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f\021\030\f\b\021\030\034\b\r\013", tmp2695_2692, 1);Lit28 = new kawa.lang.SyntaxPattern("\f\030\f\007\r\017\b\b\b", Lit74, 2, "std_syntax.scm:116");Lit27 = new kawa.lang.SyntaxTemplate("\001", "\003", Lit74, 0);Lit26 = new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit74, 1, "std_syntax.scm:115");Lit25 = new kawa.lang.SyntaxPattern("\f\030\b", Lit74, 0, "std_syntax.scm:114"); Object[] tmp2830_2827 = new Object[3]; Object[] tmp2831_2830 = tmp2830_2827;tmp2831_2830[0] = Lit89; Object[] tmp2837_2831 = tmp2831_2830; gnu.mapping.SimpleSymbol tmp2845_2842 = gnu.mapping.Symbol.valueOf("and");Lit18 = tmp2845_2842;tmp2837_2831[1] = tmp2845_2842;tmp2837_2831[2] = gnu.lists.PairWithPosition.make(Boolean.FALSE, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 446499);Lit23 = new kawa.lang.SyntaxTemplate("\001\000", "\021\030\004\t\003!\021\030\f\n\030\024", tmp2830_2827, 0);Lit22 = new kawa.lang.SyntaxPattern("\f\030\f\007\013", Lit74, 2, "std_syntax.scm:108");Lit21 = new kawa.lang.SyntaxTemplate("\001", "\003", Lit74, 0);Lit20 = new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit74, 1, "std_syntax.scm:107");Lit19 = new kawa.lang.SyntaxPattern("\f\030\b", Lit74, 0, "std_syntax.scm:106"); Object[] tmp2962_2959 = new Object[2]; Object[] tmp2963_2962 = tmp2962_2959;tmp2963_2962[0] = Lit10;tmp2963_2962[1] = Lit4; SyntaxRule[] tmp2979_2976 = new SyntaxRule[8]; SyntaxRule[] tmp2980_2979 = tmp2979_2976;tmp2980_2979[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L\f\002\f\007\r\017\b\b\b\b", Lit91, 2, "std_syntax.scm:64"), "\001\003", "\021\030\004\t\003\b\r\013", Lit90, 1); SyntaxRule[] tmp3017_2980 = tmp2980_2979;tmp3017_2980[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L\f\002\f\007\r\017\b\b\b\r\027\020\b\b", Lit91, 3, "std_syntax.scm:67"), "\001\003\003", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("else clause must be last clause of cond", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 278546)) }, 0); SyntaxRule[] tmp3079_3017 = tmp3017_2980; Object[] tmp3112_3109 = new Object[4]; Object[] tmp3113_3112 = tmp3112_3109;tmp3113_3112[0] = Lit85; Object[] tmp3119_3113 = tmp3113_3112;tmp3119_3113[1] = Lit92; Object[] tmp3125_3119 = tmp3119_3113;tmp3125_3119[2] = Lit89;tmp3125_3119[3] = Lit94;tmp3079_3017[2] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<\f\007\f\002\f\017\b\b", Lit93, 2, "std_syntax.scm:70"), "\001\001", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f\b\t\013\030\034", tmp3112_3109, 0); SyntaxRule[] tmp3141_3079 = tmp3079_3017; Object[] tmp3174_3171 = new Object[5]; Object[] tmp3175_3174 = tmp3174_3171;tmp3175_3174[0] = Lit85; Object[] tmp3181_3175 = tmp3175_3174;tmp3181_3175[1] = Lit92; Object[] tmp3187_3181 = tmp3181_3175;tmp3187_3181[2] = Lit89; Object[] tmp3193_3187 = tmp3187_3181;tmp3193_3187[3] = Lit94; gnu.mapping.SimpleSymbol tmp3206_3203 = gnu.mapping.Symbol.valueOf("cond");Lit16 = tmp3206_3203;tmp3193_3187[4] = tmp3206_3203;tmp3141_3079[3] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<\f\007\f\002\f\017\b\f\027\r\037\030\b\b", Lit93, 4, "std_syntax.scm:74"), "\001\001\001\003", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f!\t\013\030\034\b\021\030$\t\023\b\035\033", tmp3174_3171, 1); SyntaxRule[] tmp3216_3141 = tmp3141_3079;tmp3216_3141[4] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\b\b", Lit74, 1, "std_syntax.scm:80"), "\001", "\003", Lit74, 0); SyntaxRule[] tmp3253_3216 = tmp3216_3141; Object[] tmp3286_3283 = new Object[2]; Object[] tmp3287_3286 = tmp3286_3283;tmp3287_3286[0] = Lit24;tmp3287_3286[1] = Lit16;tmp3253_3216[5] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\b\f\017\r\027\020\b\b", Lit74, 3, "std_syntax.scm:83"), "\001\001\003", "\021\030\004\t\003\b\021\030\f\t\013\b\025\023", tmp3286_3283, 1); SyntaxRule[] tmp3303_3253 = tmp3253_3216; Object[] tmp3337_3334 = new Object[2]; Object[] tmp3338_3337 = tmp3337_3334;tmp3338_3337[0] = Lit89;tmp3338_3337[1] = Lit75;tmp3303_3253[6] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L\f\007\f\017\r\027\020\b\b\b", Lit74, 3, "std_syntax.scm:86"), "\001\001\003", "\021\030\004\t\003\b\021\030\f\t\013\b\025\023", tmp3337_3334, 1); Object[] tmp3387_3384 = new Object[3]; Object[] tmp3388_3387 = tmp3387_3384;tmp3388_3387[0] = Lit89; Object[] tmp3394_3388 = tmp3388_3387;tmp3394_3388[1] = Lit75;tmp3394_3388[2] = Lit16;tmp3303_3253[7] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030L\f\007\f\017\r\027\020\b\b\f\037\r' \b\b", Lit74, 5, "std_syntax.scm:89"), "\001\001\003\001\003", "\021\030\004\t\003A\021\030\f\t\013\b\025\023\b\021\030\024\t\033\b%#", tmp3387_3384, 1);Lit17 = new kawa.lang.SyntaxRules(tmp2962_2959, tmp2979_2976, 5, Lit16);Lit15 = new kawa.lang.SyntaxRules(Lit74, new SyntaxRule[] { new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit74, 1, "std_syntax.scm:56"), "\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("invalid use of 'unquote-splicing", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 233492)) }, 0) }, 1, std_syntax.Lit14 = gnu.mapping.Symbol.valueOf("unquote-splicing"));Lit13 = new kawa.lang.SyntaxRules(Lit74, new SyntaxRule[] { new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit74, 1, "std_syntax.scm:51"), "\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("invalid use of 'unquote", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 213012)) }, 0) }, 1, std_syntax.Lit12 = gnu.mapping.Symbol.valueOf("unquote"));Lit11 = new kawa.lang.SyntaxRules(Lit74, new SyntaxRule[] { new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit74, 1, "std_syntax.scm:46"), "\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("invalid use of 'else", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 192532)) }, 0) }, 1, Lit10);Lit9 = new kawa.lang.SyntaxRules(Lit74, new SyntaxRule[] { new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit74, 1, "std_syntax.scm:41"), "\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("invalid use of '_", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 172052)) }, 0) }, 1, std_syntax.Lit8 = gnu.mapping.Symbol.valueOf("_"));Lit7 = new kawa.lang.SyntaxRules(Lit74, new SyntaxRule[] { new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit74, 1, "std_syntax.scm:36"), "\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("invalid use of '...", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 151572)) }, 0) }, 1, std_syntax.Lit6 = gnu.mapping.Symbol.valueOf("..."));Lit5 = new kawa.lang.SyntaxRules(Lit74, new SyntaxRule[] { new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit74, 1, "std_syntax.scm:31"), "\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("invalid use of '=>", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 131092)) }, 0) }, 1, Lit4); SyntaxRule[] tmp3957_3954 = new SyntaxRule[2]; SyntaxRule[] tmp3958_3957 = tmp3957_3954;tmp3958_3957[0] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit74, 3, "std_syntax.scm:24"), "\001\001\001", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("missing init expression for '?'", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 102420)) }, 0);tmp3958_3957[1] = new SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit74, 1, "std_syntax.scm:26"), "\000", "\030\004", new Object[] { gnu.lists.Pair.make(Lit83, gnu.lists.PairWithPosition.make("'?' is only allowed in a conditional e.g. 'if' or 'and'", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 110612)) }, 0);Lit3 = new kawa.lang.SyntaxRules(Lit74, tmp3957_3954, 3, std_syntax.Lit2 = gnu.mapping.Symbol.valueOf("?"));Lit1 = gnu.math.IntNum.valueOf(1);Lit0 = gnu.math.IntNum.valueOf(0);$instance = new std_syntax();$Prvt$if = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.prim_syntax", "if");$Prvt$letrec = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.prim_syntax", "letrec");
    
    $Prvt$syntax$Mncase = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.syntax_case", "syntax_case");
    
    $Prvt$$Pclet = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.let", "let");
    $Prvt$$Pcdefine = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.define", "defineRaw");
    $Prvt$lambda = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
    $Prvt$not = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.Scheme", "not");
    $Prvt$begin = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.begin", "begin");
    $Prvt$syntax$Mnerror = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.syntax_error", "syntax_error");$Qu = kawa.lang.Macro.make(Lit2, Lit3, "kawa.lib.std_syntax");$Eq$Gr = kawa.lang.Macro.make(Lit4, Lit5, "kawa.lib.std_syntax");$Dt$Dt$Dt = kawa.lang.Macro.make(Lit6, Lit7, "kawa.lib.std_syntax");_ = kawa.lang.Macro.make(Lit8, Lit9, "kawa.lib.std_syntax");else = kawa.lang.Macro.make(Lit10, Lit11, "kawa.lib.std_syntax");unquote = kawa.lang.Macro.make(Lit12, Lit13, "kawa.lib.std_syntax");unquote$Mnsplicing = kawa.lang.Macro.make(Lit14, Lit15, "kawa.lib.std_syntax");cond = kawa.lang.Macro.make(Lit16, Lit17, "kawa.lib.std_syntax");std_syntax localStd_syntax1 = $instance;and = kawa.lang.Macro.make(Lit18, new gnu.expr.ModuleMethod(localStd_syntax1, 1, null, 4097), "kawa.lib.std_syntax");std_syntax localStd_syntax2 = $instance;or = kawa.lang.Macro.make(Lit24, new gnu.expr.ModuleMethod(localStd_syntax2, 2, null, 4097), "kawa.lib.std_syntax");$Prvt$$Pclet$Mnlambda1 = kawa.lang.Macro.make(Lit30, Lit31, "kawa.lib.std_syntax");$Prvt$$Pclet$Mnlambda2 = kawa.lang.Macro.make(Lit32, Lit33, "kawa.lib.std_syntax");$Prvt$$Pclet$Mninit = kawa.lang.Macro.make(Lit34, Lit35, "kawa.lib.std_syntax");let = kawa.lang.Macro.make(Lit36, Lit37, "kawa.lib.std_syntax");let$St = kawa.lang.Macro.make(Lit38, Lit39, "kawa.lib.std_syntax");$Prvt$$Pcdo$Mnstep = kawa.lang.Macro.make(Lit40, Lit41, "kawa.lib.std_syntax");$Prvt$$Pcdo$Mninit = kawa.lang.Macro.make(Lit42, Lit43, "kawa.lib.std_syntax");$Prvt$$Pcdo$Mnlambda1 = kawa.lang.Macro.make(Lit44, Lit45, "kawa.lib.std_syntax");$Prvt$$Pcdo$Mnlambda2 = kawa.lang.Macro.make(Lit46, Lit47, "kawa.lib.std_syntax");do = kawa.lang.Macro.make(Lit48, Lit49, "kawa.lib.std_syntax");std_syntax localStd_syntax3 = $instance;lazy = kawa.lang.Macro.make(Lit50, new gnu.expr.ModuleMethod(localStd_syntax3, 3, null, 4097), "kawa.lib.std_syntax");std_syntax localStd_syntax4 = $instance;delay$Mnforce = kawa.lang.Macro.make(Lit53, new gnu.expr.ModuleMethod(localStd_syntax4, 4, null, 4097), "kawa.lib.std_syntax");std_syntax localStd_syntax5 = $instance;delay = kawa.lang.Macro.make(Lit56, new gnu.expr.ModuleMethod(localStd_syntax5, 5, null, 4097), "kawa.lib.std_syntax");define$Mnprocedure = kawa.lang.Macro.make(Lit59, Lit60, "kawa.lib.std_syntax");std_syntax localStd_syntax6 = $instance;syntax$Mn$Grdatum = new gnu.expr.ModuleMethod(localStd_syntax6, 6, Lit61, 4097);syntax$Mnobject$Mn$Grdatum = new gnu.expr.ModuleMethod(localStd_syntax6, 7, Lit62, 4097);datum$Mn$Grsyntax = new gnu.expr.ModuleMethod(localStd_syntax6, 8, Lit63, 12290);datum$Mn$Grsyntax$Mnobject = new gnu.expr.ModuleMethod(localStd_syntax6, 10, Lit64, 8194);generate$Mntemporaries = new gnu.expr.ModuleMethod(localStd_syntax6, 11, Lit65, 4097);identifier$Qu = new gnu.expr.ModuleMethod(localStd_syntax6, 12, Lit66, 4097);free$Mnidentifier$Eq$Qu = new gnu.expr.ModuleMethod(localStd_syntax6, 13, Lit67, 8194);bound$Mnidentifier$Eq$Qu = new gnu.expr.ModuleMethod(localStd_syntax6, 14, Lit68, 8194);syntax$Mnsource = new gnu.expr.ModuleMethod(localStd_syntax6, 15, Lit69, 4097);syntax$Mnline = new gnu.expr.ModuleMethod(localStd_syntax6, 16, Lit70, 4097);syntax$Mncolumn = new gnu.expr.ModuleMethod(localStd_syntax6, 17, Lit71, 4097);with$Mnsyntax = kawa.lang.Macro.make(Lit72, Lit73, "kawa.lib.std_syntax");$runBody$(); } static final gnu.mapping.SimpleSymbol Lit68; static final gnu.mapping.SimpleSymbol Lit69; static final gnu.mapping.SimpleSymbol Lit70; static final gnu.mapping.SimpleSymbol Lit71; static final gnu.mapping.SimpleSymbol Lit72; static final kawa.lang.SyntaxRules Lit73; static final Object[] Lit74; static final gnu.mapping.SimpleSymbol Lit75; static final gnu.mapping.SimpleSymbol Lit76; static final Object[] Lit77; static final Object[] Lit78; static final gnu.mapping.SimpleSymbol Lit79; static final Object[] Lit80; static final Object[] Lit81; static final Object[] Lit82; static final gnu.mapping.SimpleSymbol Lit83; static final Object[] Lit84; static final gnu.mapping.SimpleSymbol Lit85; static final gnu.mapping.SimpleSymbol Lit86; static final Object[] Lit87; static final Object[] Lit88; static final gnu.mapping.SimpleSymbol Lit89; static final Object[] Lit90; static final Object[] Lit91; static final gnu.mapping.SimpleSymbol Lit92; static final Object[] Lit93; static final gnu.lists.PairWithPosition Lit94 = gnu.lists.PairWithPosition.make(std_syntax.Lit92 = gnu.mapping.Symbol.valueOf("temp"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 294935);
  


























































































  static Object lambda1(Object f)
  {
    Object localObject = f;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(2, null);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();return Lit22.match(f, arrayOfObject, 0) ? Lit23.execute(arrayOfObject, localTemplateScope) : Lit20.match(f, arrayOfObject, 0) ? Lit21.execute(arrayOfObject, localTemplateScope) : Lit19.match(f, arrayOfObject, 0) ? new gnu.expr.QuoteExp(gnu.expr.Language.getDefaultLanguage().booleanObject(true)) : kawa.standard.syntax_case.error("syntax-case", f);
  }
  
  static Object lambda2(Object f) {
    Object localObject = f;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(2, null);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();return Lit28.match(f, arrayOfObject, 0) ? Lit29.execute(arrayOfObject, localTemplateScope) : Lit26.match(f, arrayOfObject, 0) ? Lit27.execute(arrayOfObject, localTemplateScope) : Lit25.match(f, arrayOfObject, 0) ? new gnu.expr.QuoteExp(gnu.expr.Language.getDefaultLanguage().booleanObject(false)) : kawa.standard.syntax_case.error("syntax-case", f);
  }
  






































































































































  static Object lambda3(Object form)
  {
    Object localObject = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(1, null); gnu.expr.Expression[] 
    
      tmp31_28 = new gnu.expr.Expression[1];
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();tmp31_28[0] = kawa.lang.SyntaxForms.rewrite(Lit52.execute(arrayOfObject, localTemplateScope));return Lit51.match(form, arrayOfObject, 0) ? new gnu.expr.ApplyExp(gnu.kawa.functions.MakePromise.makeLazy, tmp31_28) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
  static Object lambda4(Object form) { Object localObject = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(1, null); gnu.expr.Expression[] 
    
      tmp31_28 = new gnu.expr.Expression[1];
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();tmp31_28[0] = kawa.lang.SyntaxForms.rewrite(Lit55.execute(arrayOfObject, localTemplateScope));return Lit54.match(form, arrayOfObject, 0) ? new gnu.expr.ApplyExp(gnu.kawa.functions.MakePromise.makeLazy, tmp31_28) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
  static Object lambda5(Object form) { Object localObject = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(2, null); gnu.expr.Expression[] 
    
      tmp31_28 = new gnu.expr.Expression[1];
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();tmp31_28[0] = kawa.lang.SyntaxForms.rewrite(Lit58.execute(arrayOfObject, localTemplateScope));return Lit57.match(form, arrayOfObject, 0) ? new gnu.expr.ApplyExp(gnu.kawa.functions.MakePromise.makeDelay, tmp31_28) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
























































  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 5:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; case 4:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; case 3:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; case 2:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; case 1:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; case 17:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 16: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 15: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 12: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 11: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 7: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 6: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static Object syntax$To$Datum(Object obj) { return kawa.lang.Quote.quote(obj); }
  
  public static Object syntaxObject$To$Datum(Object obj) {
    return syntax$To$Datum(obj);
  }
  




















  public int match2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 14:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 13: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 10: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 8: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public int match3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, gnu.mapping.CallContext paramCallContext) { if (selector == 8) { value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0; } return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext); } public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3) { if (selector == 8) return datum$To$Syntax(paramObject1, paramObject2, paramObject3); return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3); }
  public static Object datum$To$Syntax(Object template$Mnidentifier, Object obj, Object srcloc) { return kawa.lang.SyntaxForms.makeWithTemplate(template$Mnidentifier, obj, srcloc); }
  

  public static Object datum$To$SyntaxObject(Object template$Mnidentifier, Object obj) { return datum$To$Syntax(template$Mnidentifier, obj); }
  
  public static Object generateTemporaries(Object list) { Object lst;
    for (;;) { gnu.lists.EmptyList localEmptyList = gnu.lists.LList.Empty;Object n = Integer.valueOf(kawa.lang.Translator.listLength(list));
      
      tmpTernaryOp = (gnu.kawa.functions.NumberCompare.$Eq(n, Lit0) ? lst : new gnu.lists.Pair(datum$To$SyntaxObject(; } return gnu.kawa.functions.AddOp.apply2(-1, n, Lit1);
  }
  
  public static boolean isIdentifier(Object form) { boolean x = form instanceof gnu.mapping.Symbol;
    if ((form instanceof kawa.lang.SyntaxForm)) {}
    try { tmpTernaryOp = kawa.lang.SyntaxForms.isIdentifier((kawa.lang.SyntaxForm)(localObject = gnu.mapping.Promise.force(form, kawa.lang.SyntaxForm.class)));return x ? x : false; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "kawa.lang.SyntaxForms.isIdentifier(kawa.lang.SyntaxForm)", 1, localObject);
    }
  }
  
  public static boolean isFreeIdentifier$Eq(Object id1, Object id2)
  {
    return gnu.expr.KawaConvert.isTrue(prim_syntax.reportSyntaxError(isIdentifier(id1) ? id2 : id1, tmp39_36)) ? true : (isIdentifier(id1)) && (isIdentifier(id2)) ? kawa.lang.SyntaxForms.identifierEquals(id1, id2, false) : false;
  }
  
  public Object apply2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {case 8:  return datum$To$Syntax(paramObject1, paramObject2);
    
    case 10: 
      return datum$To$SyntaxObject(paramObject1, paramObject2);
    










    case 13: 
      return isFreeIdentifier$Eq(paramObject1, paramObject2) ? Boolean.TRUE : Boolean.FALSE;
    




    case 14: 
      return isBoundIdentifier$Eq(paramObject1, paramObject2) ? Boolean.TRUE : Boolean.FALSE; } return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public static boolean isBoundIdentifier$Eq(Object id1, Object id2) {
    return gnu.expr.KawaConvert.isTrue(prim_syntax.reportSyntaxError(isIdentifier(id1) ? id2 : id1, tmp39_36)) ? true : (isIdentifier(id1)) && (isIdentifier(id2)) ? kawa.lang.SyntaxForms.identifierEquals(id1, id2, true) : false;
  }
  
  public static Object syntaxSource(Object form) {
    while ((form instanceof kawa.lang.SyntaxForm)) {
      form = ((kawa.lang.SyntaxForm)gnu.mapping.Promise.force(form, kawa.lang.SyntaxForm.class)).getDatum();
    }
    Object str = ((gnu.lists.PairWithPosition)gnu.mapping.Promise.force(form, gnu.lists.PairWithPosition.class)).getFileName();
    return (form instanceof gnu.lists.PairWithPosition) ? str : str == null ? Boolean.FALSE : Boolean.FALSE;
  }
  
  public static Object syntaxLine(Object form)
  {
    while ((form instanceof kawa.lang.SyntaxForm)) {
      form = ((kawa.lang.SyntaxForm)gnu.mapping.Promise.force(form, kawa.lang.SyntaxForm.class)).getDatum();
    }
    return (form instanceof gnu.lists.PairWithPosition) ? Integer.valueOf(((gnu.lists.PairWithPosition)gnu.mapping.Promise.force(form, gnu.lists.PairWithPosition.class)).getLineNumber()) : Boolean.FALSE;
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 6:  return syntax$To$Datum(paramObject);
    
    case 7: 
      return syntaxObject$To$Datum(paramObject);
    






    case 11: 
      return generateTemporaries(paramObject);
    


    case 12: 
      return isIdentifier(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
















    case 15: 
      return syntaxSource(paramObject);
    






    case 16: 
      return syntaxLine(paramObject);
    






    case 17: 
      return syntaxColumn(paramObject); case 1:  return lambda1(paramObject); case 2:  return lambda2(paramObject); case 3:  return lambda3(paramObject); case 4:  return lambda4(paramObject); case 5:  return lambda5(paramObject); } return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static Object syntaxColumn(Object form) {
    return (form instanceof gnu.lists.PairWithPosition) ? Integer.valueOf(((gnu.lists.PairWithPosition)gnu.mapping.Promise.force(form, gnu.lists.PairWithPosition.class)).getColumnNumber() - 0) : (form instanceof kawa.lang.SyntaxForm) ? syntaxLine(((kawa.lang.SyntaxForm)gnu.mapping.Promise.force(form, kawa.lang.SyntaxForm.class)).getDatum()) : Boolean.FALSE;
  }
  
  public static Object datum$To$Syntax(Object paramObject1, Object paramObject2)
  {
    return datum$To$Syntax(paramObject1, paramObject2, null);
  }
  
  public std_syntax()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
}
