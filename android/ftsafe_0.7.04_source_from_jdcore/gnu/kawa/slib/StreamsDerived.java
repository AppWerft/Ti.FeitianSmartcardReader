package gnu.kawa.slib;

import gnu.expr.ModuleMethod;

public class StreamsDerived extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation stream$Mnnull;
  public static final gnu.kawa.reflect.StaticFieldLocation stream$Mncons;
  public static final gnu.kawa.reflect.StaticFieldLocation stream$Qu;
  public static final gnu.kawa.reflect.StaticFieldLocation stream$Mnnull$Qu;
  public static final gnu.kawa.reflect.StaticFieldLocation stream$Mnpair$Qu;
  public static final gnu.kawa.reflect.StaticFieldLocation stream$Mncar;
  public static final gnu.kawa.reflect.StaticFieldLocation stream$Mncdr;
  public static final gnu.kawa.reflect.StaticFieldLocation stream$Mnlambda;
  public static final kawa.lang.Macro define$Mnstream;
  public static final ModuleMethod list$Mn$Grstream;
  public static final ModuleMethod port$Mn$Grstream;
  public static final kawa.lang.Macro stream;
  public static final ModuleMethod stream$Mn$Grlist;
  public static final ModuleMethod stream$Mnappend;
  public static final ModuleMethod stream$Mnconcat;
  public static final ModuleMethod stream$Mnconstant;
  public static final ModuleMethod stream$Mndrop;
  public static final ModuleMethod stream$Mndrop$Mnwhile;
  public static final ModuleMethod stream$Mnfilter;
  public static final ModuleMethod stream$Mnfold;
  public static final ModuleMethod stream$Mnfor$Mneach;
  public static final ModuleMethod stream$Mnfrom;
  public static final ModuleMethod stream$Mniterate;
  public static final ModuleMethod stream$Mnlength;
  public static final kawa.lang.Macro stream$Mnlet;
  public static final ModuleMethod stream$Mnmap; public static final kawa.lang.Macro stream$Mnmatch; public static final kawa.lang.Macro stream$Mnof; public static final ModuleMethod stream$Mnrange; public static final ModuleMethod stream$Mnref; public static final ModuleMethod stream$Mnreverse; public static final ModuleMethod stream$Mnscan; public static final ModuleMethod stream$Mntake; public static final ModuleMethod stream$Mntake$Mnwhile; public static final ModuleMethod stream$Mnunfold; public static final ModuleMethod stream$Mnunfolds; public static final ModuleMethod stream$Mnzip; public static final int $Pcprovide$Pcsrfi$Mn41$Mnstreams$Mnderived = 123; public static final kawa.lang.Macro $Prvt$stream$Mnmatch$Mntest; public static final kawa.lang.Macro $Prvt$stream$Mnmatch$Mnpattern; public static final kawa.lang.Macro $Prvt$stream$Mnof$Mnaux; static final gnu.mapping.SimpleSymbol Lit0; static final gnu.math.IntNum Lit1; static final ModuleMethod lambda$Fn7; static final gnu.mapping.SimpleSymbol Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final ModuleMethod lambda$Fn26; static final gnu.math.IntNum Lit6; static final gnu.math.IntNum Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final ModuleMethod lambda$Fn33; static final gnu.mapping.SimpleSymbol Lit9; static final ModuleMethod lambda$Fn45; static final gnu.mapping.SimpleSymbol Lit10; static final ModuleMethod lambda$Fn57; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final ModuleMethod lambda$Fn65; public static StreamsDerived $instance; static final gnu.mapping.SimpleSymbol Lit13; static final kawa.lang.SyntaxRules Lit14; static final gnu.mapping.SimpleSymbol Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final kawa.lang.SyntaxRules Lit18; static final gnu.mapping.SimpleSymbol Lit19; static final gnu.mapping.SimpleSymbol Lit20; static final gnu.mapping.SimpleSymbol Lit21; static final gnu.mapping.SimpleSymbol Lit22; static final gnu.mapping.SimpleSymbol Lit23; static final gnu.mapping.SimpleSymbol Lit24; static final gnu.mapping.SimpleSymbol Lit25; static final kawa.lang.SyntaxRules Lit26; static final gnu.mapping.SimpleSymbol Lit27; static final kawa.lang.SyntaxRules Lit28; static final gnu.mapping.SimpleSymbol Lit29; static final kawa.lang.SyntaxRules Lit30; static final gnu.mapping.SimpleSymbol Lit31; static final kawa.lang.SyntaxPattern Lit32; static final kawa.lang.SyntaxTemplate Lit33; static final kawa.lang.SyntaxPattern Lit34; static final kawa.lang.SyntaxTemplate Lit35; static final kawa.lang.SyntaxTemplate Lit36; static final kawa.lang.SyntaxPattern Lit37; static final kawa.lang.SyntaxTemplate Lit38; static final kawa.lang.SyntaxPattern Lit39; static final kawa.lang.SyntaxTemplate Lit40; static final kawa.lang.SyntaxTemplate Lit41; static final kawa.lang.SyntaxPattern Lit42; static final kawa.lang.SyntaxTemplate Lit43; static final kawa.lang.SyntaxTemplate Lit44; static final gnu.mapping.SimpleSymbol Lit45; static final kawa.lang.SyntaxRules Lit46; static final gnu.mapping.SimpleSymbol Lit47; static final kawa.lang.SyntaxRules Lit48; static final gnu.mapping.SimpleSymbol Lit49; static final gnu.mapping.SimpleSymbol Lit50; static final gnu.mapping.SimpleSymbol Lit51; static final gnu.mapping.SimpleSymbol Lit52; static final gnu.mapping.SimpleSymbol Lit53; static final gnu.mapping.SimpleSymbol Lit54; static final gnu.mapping.SimpleSymbol Lit55; static final gnu.lists.PairWithPosition Lit56; static final gnu.mapping.SimpleSymbol Lit57; static final gnu.mapping.SimpleSymbol Lit58; static final gnu.mapping.SimpleSymbol Lit59; static final Object[] Lit60; static final gnu.mapping.SimpleSymbol Lit61; static final Object[] Lit62; static final gnu.mapping.SimpleSymbol Lit63; static final gnu.mapping.SimpleSymbol Lit64; static final gnu.mapping.SimpleSymbol Lit65; static final gnu.mapping.SimpleSymbol Lit66; static final gnu.mapping.SimpleSymbol Lit67; static final gnu.mapping.SimpleSymbol Lit68; static final gnu.mapping.SimpleSymbol Lit69; static final gnu.mapping.SimpleSymbol Lit70; static final gnu.lists.PairWithPosition Lit71; static final gnu.mapping.SimpleSymbol Lit72; static final gnu.mapping.SimpleSymbol Lit73; static final gnu.mapping.SimpleSymbol Lit74 = gnu.mapping.Symbol.valueOf("stream-lambda"); static { Lit73 = gnu.mapping.Symbol.valueOf("stream-cons");Lit72 = gnu.mapping.Symbol.valueOf("stream-null");Lit71 = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("quote"), gnu.lists.PairWithPosition.make(StreamsDerived.Lit27 = gnu.mapping.Symbol.valueOf("stream-match"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847911), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847911);Lit70 = gnu.mapping.Symbol.valueOf("error");Lit69 = gnu.mapping.Symbol.valueOf("list");Lit68 = gnu.mapping.Symbol.valueOf("stream-null?");Lit67 = gnu.mapping.Symbol.valueOf("stream-pair?");Lit66 = gnu.mapping.Symbol.valueOf("and");Lit65 = gnu.mapping.Symbol.valueOf("temp");Lit64 = gnu.mapping.Symbol.valueOf("stream-cdr");Lit63 = gnu.mapping.Symbol.valueOf("stream-car"); gnu.mapping.SimpleSymbol tmp154_151 = gnu.mapping.Symbol.valueOf("let");Lit59 = tmp154_151;(StreamsDerived.Lit62 = new Object[1])[0] = tmp154_151;Lit61 = gnu.mapping.Symbol.valueOf("if");Lit60 = new Object[0];Lit58 = gnu.mapping.Symbol.valueOf("is");Lit57 = gnu.mapping.Symbol.valueOf("loop");Lit56 = gnu.lists.PairWithPosition.make(StreamsDerived.Lit55 = gnu.mapping.Symbol.valueOf("strm"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1032218);Lit54 = gnu.mapping.Symbol.valueOf("in");Lit53 = gnu.mapping.Symbol.valueOf("stream-unfold");Lit52 = gnu.mapping.Symbol.valueOf("stream-take-while");Lit51 = gnu.mapping.Symbol.valueOf("stream-scan");Lit50 = gnu.mapping.Symbol.valueOf("stream-reverse");Lit49 = gnu.mapping.Symbol.valueOf("stream-range"); Object[] tmp278_275 = new Object[2]; Object[] tmp279_278 = tmp278_275;tmp279_278[0] = Lit54;tmp279_278[1] = Lit58; kawa.lang.SyntaxRule[] tmp294_291 = new kawa.lang.SyntaxRule[4]; kawa.lang.SyntaxRule[] tmp295_294 = tmp294_291;tmp295_294[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit60, 2, "StreamsDerived.scm:248"), "\001\001", "\021\030\004\t\003\b\013", new Object[] { Lit73 }, 0); kawa.lang.SyntaxRule[] tmp339_295 = tmp295_294; Object[] tmp380_377 = new Object[9]; Object[] tmp381_380 = tmp380_377; gnu.mapping.SimpleSymbol tmp389_386 = gnu.mapping.Symbol.valueOf("stream-let");Lit25 = tmp389_386;tmp381_380[0] = tmp389_386; Object[] tmp394_381 = tmp381_380;tmp394_381[1] = Lit57; Object[] tmp400_394 = tmp394_381;tmp400_394[2] = Lit55; Object[] tmp406_400 = tmp400_394;tmp406_400[3] = Lit61; Object[] tmp412_406 = tmp406_400;tmp412_406[4] = gnu.lists.PairWithPosition.make(Lit68, Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1032204); Object[] tmp430_412 = tmp412_406;tmp430_412[5] = Lit59; Object[] tmp436_430 = tmp430_412;tmp436_430[6] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit63, Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1040407), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1040407); Object[] tmp467_436 = tmp436_430; gnu.mapping.SimpleSymbol tmp476_473 = gnu.mapping.Symbol.valueOf("stream-of-aux");Lit47 = tmp476_473;tmp467_436[7] = tmp476_473;tmp467_436[8] = gnu.lists.PairWithPosition.make(Lit57, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit64, Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044520), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044520), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044514);tmp339_295[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017<\f\027\f\002\f\037\b\r' \b\b", new Object[] { Lit54 }, 5, "StreamsDerived.scm:250"), "\001\001\001\001\003", "\021\030\004\021\030\f1\b\021\030\024\b\033\b\021\030\034\021\030$\t\013\b\021\030,)\b\t\023\0304\b\021\030<\t\003\021\030D\b%#", tmp380_377, 1); kawa.lang.SyntaxRule[] tmp528_339 = tmp339_295; Object[] tmp568_565 = new Object[2]; Object[] tmp569_568 = tmp568_565;tmp569_568[0] = Lit59;tmp569_568[1] = Lit47;tmp528_339[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017<\f\027\f\002\f\037\b\r' \b\b", new Object[] { Lit58 }, 5, "StreamsDerived.scm:256"), "\001\001\001\001\003", "\021\030\004)\b\t\023\b\033\b\021\030\f\t\003\t\013\b%#", tmp568_565, 1); Object[] tmp617_614 = new Object[2]; Object[] tmp618_617 = tmp617_614;tmp618_617[0] = Lit61;tmp618_617[1] = Lit47;tmp528_339[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\r\037\030\b\b", Lit60, 4, "StreamsDerived.scm:258"), "\001\001\001\003", "\021\030\004\t\023Q\021\030\f\t\003\t\013\b\035\033\b\013", tmp617_614, 1);Lit48 = new kawa.lang.SyntaxRules(tmp278_275, tmp294_291, 5, Lit47); kawa.lang.SyntaxRule[] tmp655_652 = new kawa.lang.SyntaxRule[1]; Object[] tmp688_685 = new Object[2]; Object[] tmp689_688 = tmp688_685;tmp689_688[0] = Lit47;tmp689_688[1] = Lit72;tmp655_652[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\r\017\b\b\b", Lit60, 2, "StreamsDerived.scm:243"), "\001\003", "\021\030\004\t\003\021\030\f\b\r\013", tmp688_685, 1);Lit46 = new kawa.lang.SyntaxRules(Lit60, tmp655_652, 2, StreamsDerived.Lit45 = gnu.mapping.Symbol.valueOf("stream-of"));Lit44 = new kawa.lang.SyntaxTemplate("", "\030\004", new Object[] { gnu.mapping.Symbol.valueOf("_") }, 0);Lit43 = new kawa.lang.SyntaxTemplate("\001\001\003\001", "\021\030\004A!\t\013\b\003\b\025\023\b\033", Lit62, 1);Lit42 = new kawa.lang.SyntaxPattern("\f\030\f\007\f\017,\r\027\020\b\b\f\037\b", Lit60, 4, "StreamsDerived.scm:238");Lit41 = new kawa.lang.SyntaxTemplate("\001\001\003\001", "\021\030\004\031\b\025\023\b\033", Lit62, 1);Lit40 = new kawa.lang.SyntaxTemplate("\001\001\003\001", "\013", Lit60, 0);Lit39 = new kawa.lang.SyntaxPattern("\f\030\f\007\f\017,\r\027\020\b\b\f\037\b", Lit60, 4, "StreamsDerived.scm:235"); Object[] tmp867_864 = new Object[8]; Object[] tmp868_867 = tmp867_864;tmp868_867[0] = Lit66; Object[] tmp874_868 = tmp868_867;tmp874_868[1] = Lit67; Object[] tmp880_874 = tmp874_868;tmp880_874[2] = Lit59; Object[] tmp886_880 = tmp880_874;tmp886_880[3] = Lit65; Object[] tmp892_886 = tmp886_880;tmp892_886[4] = Lit63; Object[] tmp898_892 = tmp892_886;tmp898_892[5] = Lit64; Object[] tmp904_898 = tmp898_892; gnu.mapping.SimpleSymbol tmp913_910 = gnu.mapping.Symbol.valueOf("stream-match-pattern");Lit31 = tmp913_910;tmp904_898[6] = tmp913_910;tmp904_898[7] = gnu.lists.PairWithPosition.make(Lit65, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 958525);Lit38 = new kawa.lang.SyntaxTemplate("\001\001\000\003\001", "\021\030\004)\021\030\f\b\003\b\021\030\024I\021\030\034\b\021\030$\b\003\b\t\003\b\021\030,\b\003\b\021\0304\t\003\t\022A!\t\013\030<\b\035\033\b#", tmp867_864, 1);Lit37 = new kawa.lang.SyntaxPattern("\f\030\f\007\034\f\017\023,\r\037\030\b\b\f'\b", Lit60, 5, "StreamsDerived.scm:231"); Object[] tmp977_974 = new Object[5]; Object[] tmp978_977 = tmp977_974;tmp978_977[0] = Lit66; Object[] tmp984_978 = tmp978_977;tmp984_978[1] = Lit67; Object[] tmp990_984 = tmp984_978;tmp990_984[2] = Lit59; Object[] tmp996_990 = tmp990_984;tmp996_990[3] = Lit64;tmp996_990[4] = Lit31;Lit36 = new kawa.lang.SyntaxTemplate("\001\001\000\003\001", "\021\030\004)\021\030\f\b\003\b\021\030\024I\b\t\003\b\021\030\034\b\003\b\021\030$\t\003\t\022\031\b\035\033\b#", tmp977_974, 1);Lit35 = new kawa.lang.SyntaxTemplate("\001\001\000\003\001", "\013", Lit60, 0);Lit34 = new kawa.lang.SyntaxPattern("\f\030\f\007\034\f\017\023,\r\037\030\b\b\f'\b", Lit60, 5, "StreamsDerived.scm:226"); Object[] tmp1068_1065 = new Object[3]; Object[] tmp1069_1068 = tmp1068_1065;tmp1069_1068[0] = Lit66; Object[] tmp1075_1069 = tmp1069_1068;tmp1075_1069[1] = Lit68;tmp1075_1069[2] = Lit59;Lit33 = new kawa.lang.SyntaxTemplate("\001\003\001", "\021\030\004)\021\030\f\b\003\b\021\030\024\031\b\r\013\b\023", tmp1068_1065, 1);Lit32 = new kawa.lang.SyntaxPattern("\f\030\f\007\f\b,\r\017\b\b\b\f\027\b", Lit60, 3, "StreamsDerived.scm:224"); kawa.lang.SyntaxRule[] tmp1124_1121 = new kawa.lang.SyntaxRule[2]; kawa.lang.SyntaxRule[] tmp1125_1124 = tmp1124_1121; Object[] tmp1158_1155 = new Object[3]; Object[] tmp1159_1158 = tmp1158_1155;tmp1159_1158[0] = Lit31; Object[] tmp1165_1159 = tmp1159_1158;tmp1165_1159[1] = Lit66;tmp1165_1159[2] = Lit69;tmp1125_1124[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007<\f\017\f\027\f\037\b\b", Lit60, 4, "StreamsDerived.scm:213"), "\001\001\001\001", "\021\030\004\t\003\t\013\t\020\b\021\030\f\t\023\b\021\030\024\b\033", tmp1158_1155, 0); Object[] tmp1213_1210 = new Object[2]; Object[] tmp1214_1213 = tmp1213_1210;tmp1214_1213[0] = Lit31;tmp1214_1213[1] = Lit69;tmp1125_1124[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007,\f\017\f\027\b\b", Lit60, 3, "StreamsDerived.scm:215"), "\001\001\001", "\021\030\004\t\003\t\013\t\020\b\021\030\f\b\023", tmp1213_1210, 0);Lit30 = new kawa.lang.SyntaxRules(Lit60, tmp1124_1121, 4, StreamsDerived.Lit29 = gnu.mapping.Symbol.valueOf("stream-match-test")); kawa.lang.SyntaxRule[] tmp1258_1255 = new kawa.lang.SyntaxRule[1]; Object[] tmp1292_1289 = new Object[7]; Object[] tmp1293_1292 = tmp1292_1289;tmp1293_1292[0] = Lit59; Object[] tmp1299_1293 = tmp1293_1292;tmp1299_1293[1] = Lit55; Object[] tmp1305_1299 = tmp1299_1293;tmp1305_1299[2] = gnu.mapping.Symbol.valueOf("cond"); Object[] tmp1314_1305 = tmp1305_1299;tmp1314_1305[3] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("not"), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("stream?"), Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847887), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847887), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847882), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit70, gnu.lists.PairWithPosition.make(Lit71, gnu.lists.PairWithPosition.make("non-stream argument", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847924), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847903), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847903), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847881); Object[] tmp1421_1314 = tmp1314_1305;tmp1421_1314[4] = Lit29; Object[] tmp1427_1421 = tmp1421_1314;tmp1427_1421[5] = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("=>"), gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("car"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 852013), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 852010);tmp1427_1421[6] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("else"), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit70, gnu.lists.PairWithPosition.make(Lit71, gnu.lists.PairWithPosition.make("pattern failure", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856100), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856086), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856079), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856079), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856073), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856073);tmp1258_1255[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\r\017\b\b\b", Lit60, 2, "StreamsDerived.scm:204"), "\001\003", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\034a\rA\021\030$\021\030\f\b\013\030,\0304", tmp1292_1289, 1);Lit28 = new kawa.lang.SyntaxRules(Lit60, tmp1258_1255, 2, Lit27); kawa.lang.SyntaxRule[] tmp1569_1566 = new kawa.lang.SyntaxRule[1]; Object[] tmp1602_1599 = new Object[2]; Object[] tmp1603_1602 = tmp1602_1599;tmp1603_1602[0] = gnu.mapping.Symbol.valueOf("letrec");tmp1603_1602[1] = Lit74;tmp1569_1566[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007L-\f\017\f\027\b\b\020\b\f\037\r' \b\b", Lit60, 5, "StreamsDerived.scm:187"), "\001\003\003\001\003", "±\021\030\004\b\t\003\b\021\030\f\031\b\r\013\t\033\b%#\b\003\b\025\023", tmp1602_1599, 1);Lit26 = new kawa.lang.SyntaxRules(Lit60, tmp1569_1566, 5, Lit25);Lit24 = gnu.mapping.Symbol.valueOf("stream-length");Lit23 = gnu.mapping.Symbol.valueOf("stream-iterate");Lit22 = gnu.mapping.Symbol.valueOf("stream-from");Lit21 = gnu.mapping.Symbol.valueOf("stream-fold");Lit20 = gnu.mapping.Symbol.valueOf("stream-filter");Lit19 = gnu.mapping.Symbol.valueOf("stream-drop-while"); kawa.lang.SyntaxRule[] tmp1697_1694 = new kawa.lang.SyntaxRule[2]; kawa.lang.SyntaxRule[] tmp1698_1697 = tmp1697_1694;tmp1698_1697[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\b", Lit60, 0, "StreamsDerived.scm:78"), "", "\030\004", new Object[] { Lit72 }, 0); Object[] tmp1774_1771 = new Object[2]; Object[] tmp1775_1774 = tmp1774_1771;tmp1775_1774[0] = Lit73; gnu.mapping.SimpleSymbol tmp1788_1785 = gnu.mapping.Symbol.valueOf("stream");Lit17 = tmp1788_1785;tmp1775_1774[1] = tmp1788_1785;tmp1698_1697[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\r\017\b\b\b", Lit60, 2, "StreamsDerived.scm:79"), "\001\003", "\021\030\004\t\003\b\021\030\f\b\r\013", tmp1774_1771, 1);Lit18 = new kawa.lang.SyntaxRules(Lit60, tmp1697_1694, 2, Lit17);Lit16 = gnu.mapping.Symbol.valueOf("port->stream");Lit15 = gnu.mapping.Symbol.valueOf("list->stream"); kawa.lang.SyntaxRule[] tmp1837_1834 = new kawa.lang.SyntaxRule[1]; Object[] tmp1870_1867 = new Object[2]; Object[] tmp1871_1870 = tmp1870_1867;tmp1871_1870[0] = gnu.mapping.Symbol.valueOf("define");tmp1871_1870[1] = Lit74;tmp1837_1834[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\034\f\007\013\f\027\r\037\030\b\b", Lit60, 4, "StreamsDerived.scm:56"), "\001\000\001\003", "\021\030\004\t\003\b\021\030\f\t\n\t\023\b\035\033", tmp1870_1867, 1);Lit14 = new kawa.lang.SyntaxRules(Lit60, tmp1837_1834, 4, StreamsDerived.Lit13 = gnu.mapping.Symbol.valueOf("define-stream"));Lit12 = gnu.mapping.Symbol.valueOf("stream-zip");Lit11 = gnu.mapping.Symbol.valueOf("stream-unfolds");Lit10 = gnu.mapping.Symbol.valueOf("stream-take");Lit9 = gnu.mapping.Symbol.valueOf("stream-ref");Lit8 = gnu.mapping.Symbol.valueOf("stream-map");Lit7 = gnu.math.IntNum.valueOf(0);Lit6 = gnu.math.IntNum.valueOf(1);Lit5 = gnu.mapping.Symbol.valueOf("stream-for-each");Lit4 = gnu.mapping.Symbol.valueOf("stream-drop");Lit3 = gnu.mapping.Symbol.valueOf("stream-concat");Lit2 = gnu.mapping.Symbol.valueOf("stream-append");Lit1 = gnu.math.IntNum.valueOf(-1);Lit0 = gnu.mapping.Symbol.valueOf("stream->list");$instance = new StreamsDerived();stream$Mnnull = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnnull");stream$Mncons = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncons");stream$Qu = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Qu");stream$Mnnull$Qu = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnnull$Qu");stream$Mnpair$Qu = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnpair$Qu");stream$Mncar = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncar");stream$Mncdr = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncdr");stream$Mnlambda = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnlambda");
    





    define$Mnstream = kawa.lang.Macro.make(Lit13, Lit14, "gnu.kawa.slib.StreamsDerived");StreamsDerived localStreamsDerived1 = $instance;list$Mn$Grstream = new ModuleMethod(localStreamsDerived1, 63, Lit15, 4097);port$Mn$Grstream = new ModuleMethod(localStreamsDerived1, 64, Lit16, 4096);stream = kawa.lang.Macro.make(Lit17, Lit18, "gnu.kawa.slib.StreamsDerived");stream$Mn$Grlist = new ModuleMethod(localStreamsDerived1, 66, Lit0, 61440); void tmp2229_2226 = new ModuleMethod(localStreamsDerived1, 67, null, 4097);tmp2229_2226.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:100");lambda$Fn7 = tmp2229_2226;stream$Mnappend = new ModuleMethod(localStreamsDerived1, 68, Lit2, 61440);stream$Mnconcat = new ModuleMethod(localStreamsDerived1, 69, Lit3, 4097); void tmp2296_2293 = new ModuleMethod(localStreamsDerived1, 70, "stream-constant", 61440);tmp2296_2293.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:119");stream$Mnconstant = tmp2296_2293;stream$Mndrop = new ModuleMethod(localStreamsDerived1, 71, Lit4, 8194);stream$Mndrop$Mnwhile = new ModuleMethod(localStreamsDerived1, 72, Lit19, 8194);stream$Mnfilter = new ModuleMethod(localStreamsDerived1, 73, Lit20, 8194);stream$Mnfold = new ModuleMethod(localStreamsDerived1, 74, Lit21, 12291); void tmp2399_2396 = new ModuleMethod(localStreamsDerived1, 75, null, 4097);tmp2399_2396.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:163");lambda$Fn26 = tmp2399_2396;stream$Mnfor$Mneach = new ModuleMethod(localStreamsDerived1, 76, Lit5, 61441);stream$Mnfrom = new ModuleMethod(localStreamsDerived1, 77, Lit22, 8193);stream$Mniterate = new ModuleMethod(localStreamsDerived1, 79, Lit23, 8194);stream$Mnlength = new ModuleMethod(localStreamsDerived1, 80, Lit24, 4097);
    


    stream$Mnlet = kawa.lang.Macro.make(Lit25, Lit26, "gnu.kawa.slib.StreamsDerived"); void tmp2517_2514 = new ModuleMethod(localStreamsDerived1, 81, null, 4097);tmp2517_2514.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:198");lambda$Fn33 = tmp2517_2514;stream$Mnmap = new ModuleMethod(localStreamsDerived1, 82, Lit8, 61441);
    stream$Mnmatch = kawa.lang.Macro.make(Lit27, Lit28, "gnu.kawa.slib.StreamsDerived");$Prvt$stream$Mnmatch$Mntest = kawa.lang.Macro.make(Lit29, Lit30, "gnu.kawa.slib.StreamsDerived");
    















































































































































































    StreamsDerived localStreamsDerived2 = $instance; void tmp2600_2597 = new ModuleMethod(localStreamsDerived2, 83, null, 4097);tmp2600_2597.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:219");$Prvt$stream$Mnmatch$Mnpattern = kawa.lang.Macro.make(Lit31, tmp2600_2597, "gnu.kawa.slib.StreamsDerived");stream$Mnof = kawa.lang.Macro.make(Lit45, Lit46, "gnu.kawa.slib.StreamsDerived");$Prvt$stream$Mnof$Mnaux = kawa.lang.Macro.make(Lit47, Lit48, "gnu.kawa.slib.StreamsDerived");stream$Mnrange = new ModuleMethod(localStreamsDerived1, 84, Lit49, 61442);stream$Mnref = new ModuleMethod(localStreamsDerived1, 85, Lit9, 8194);stream$Mnreverse = new ModuleMethod(localStreamsDerived1, 86, Lit50, 4097);lambda$Fn45 = new ModuleMethod(localStreamsDerived1, 87, null, 0);stream$Mnscan = new ModuleMethod(localStreamsDerived1, 88, Lit51, 12291);stream$Mntake = new ModuleMethod(localStreamsDerived1, 89, Lit10, 8194);stream$Mntake$Mnwhile = new ModuleMethod(localStreamsDerived1, 90, Lit52, 8194);stream$Mnunfold = new ModuleMethod(localStreamsDerived1, 91, Lit53, 16388); void tmp2811_2808 = new ModuleMethod(localStreamsDerived1, 92, null, 61440);tmp2811_2808.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:326");lambda$Fn57 = tmp2811_2808;stream$Mnunfolds = new ModuleMethod(localStreamsDerived1, 93, Lit11, 8194); void tmp2857_2854 = new ModuleMethod(localStreamsDerived1, 94, null, 4097);tmp2857_2854.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:358");lambda$Fn65 = tmp2857_2854;stream$Mnzip = new ModuleMethod(localStreamsDerived1, 95, Lit12, 61440);$runBody$();
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    





















    ModuleMethod exists = srfi1.any;
  }
  
  public class frame extends gnu.expr.ModuleBody
  {
    public frame() {}
    
    public Object lambda1list$To$Stream(gnu.lists.LList objs)
    {
      void tmp7_4 = new StreamsDerived.frame0();74staticLink = this;StreamsDerived.frame0 $heapFrame = tmp7_4;objs = objs;return new StreamPromise(lambda$Fn1, true);
    }
  }
  
  public static Stream list$To$Stream(gnu.lists.LList objs)
  {
    frame $heapFrame = new frame();
    




    return (Stream)$heapFrame.lambda1list$To$Stream(objs); }
  
  public static Stream port$To$Stream() { return port$To$Stream((gnu.kawa.io.InPort)kawa.lib.ports.current$Mninput$Mnport.getValue()); } public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext) { switch (selector) {case 87:  proc = paramModuleMethod;pc = 0;return 0; case 64:  proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); } public Object apply0(ModuleMethod paramModuleMethod) { switch (selector) {case 64:  return port$To$Stream(); case 87:  return frame26.lambda59(); } return super.apply0(paramModuleMethod); }
  public class frame1 extends gnu.expr.ModuleBody { public frame1() {}
    public Object lambda5port$To$Stream(gnu.kawa.io.InPort p) { void tmp7_4 = new StreamsDerived.frame2();74staticLink = this;StreamsDerived.frame2 $heapFrame = tmp7_4;p = p;return new StreamPromise(lambda$Fn4, true);
    }
  }
  
  public static Stream port$To$Stream(gnu.kawa.io.InPort p)
  {
    frame1 $heapFrame = new frame1();
    





    return (Stream)$heapFrame.lambda5port$To$Stream(p);
  }
  
















































































































































































































































































  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 95:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 92: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 84: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 82: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 76: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 70: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 68: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 66: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  

  public static Object lambda9loop(gnu.math.IntNum n, Stream strm)
  {
    boolean x = kawa.lib.numbers.isZero(n);
    try
    {
      return x ? x : StreamsPrimitive.isStreamNull(strm) ? gnu.lists.LList.Empty : kawa.lib.lists.cons(StreamsPrimitive.streamCar(strm), lambda9loop(gnu.math.IntNum.add(n, -1), (Stream)(localObject = StreamsPrimitive.streamCdr(strm)))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "loop", 1, localObject);
    }
  }
  
  public class frame4 extends gnu.expr.ModuleBody { public Object lambda11streamAppend(gnu.lists.LList strms) { void tmp7_4 = new StreamsDerived.frame5();74staticLink = this;StreamsDerived.frame5 $heapFrame = tmp7_4;strms = strms;return new StreamPromise(lambda$Fn8, true);
    }
    

    static boolean lambda10(Object x)
    {
      return !StreamsPrimitive.isStream(x);
    }
    
    public frame4() {}
  }
  
  public static Stream streamAppend$V(Object[] argsArray)
  {
    frame4 $heapFrame = new frame4(); gnu.lists.LList localLList1; gnu.lists.LList strms = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    






    if (gnu.expr.KawaConvert.isTrue(srfi1.any$V(lambda$Fn7, strms, new Object[0])))
      throw gnu.expr.Special.reachedUnexpected;
    return kawa.lib.lists.isNull(strms) ? StreamsPrimitive.stream$Mnnull : (Stream)$heapFrame.lambda11streamAppend(strms); }
  
  public class frame6 extends gnu.expr.ModuleBody { public frame6() {}
    
    public Object lambda15streamConcat(Stream strms) { void tmp7_4 = new StreamsDerived.frame7();74staticLink = this;StreamsDerived.frame7 $heapFrame = tmp7_4;strms = strms;return new StreamPromise(lambda$Fn11, true);
    }
  }
  
  public static Stream streamConcat(Stream strms)
  {
    frame6 $heapFrame = new frame6();
    










    return (Stream)$heapFrame.lambda15streamConcat(strms); }
  
  public static Object streamConstant$V(Object[] argsArray) { ;
    frame8 $heapFrame = new frame8(); gnu.lists.LList localLList1; objs = (localLList1 = gnu.lists.LList.makeList(argsArray, 0));return new StreamPromise(lambda$Fn16, true); }
  
  public class frame8 extends gnu.expr.ModuleBody { Object lambda22() { try { return kawa.lib.lists.car((gnu.lists.Pair)(localLList = objs)); } catch (ClassCastException localClassCastException) { gnu.lists.LList localLList; throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localLList); } } Object lambda23() { Object[] tmp4_1 = new Object[1]; gnu.lists.LList tmp10_7 = objs;gnu.lists.LList localLList = tmp10_7; try { tmp4_1[0] = kawa.lib.lists.car((gnu.lists.Pair)tmp10_7);return StreamsDerived.streamConstant$V(tmp4_1); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localLList); } }
    Object lambda21() { try { return kawa.lib.lists.isNull(objs) ? StreamsPrimitive.stream$Mnnull : kawa.lib.lists.isNull(kawa.lib.lists.cdr((gnu.lists.Pair)(localLList = objs))) ? new StreamPair(new StreamPromise(lambda$Fn17, false), new StreamPromise(lambda$Fn18, true)) : new StreamPair(new StreamPromise(lambda$Fn19, false), new StreamPromise(lambda$Fn20, true));
      }
      catch (ClassCastException localClassCastException)
      {
        gnu.lists.LList localLList;
        throw new gnu.mapping.WrongType(
          localClassCastException, "cdr", 1, localLList); } } Object lambda24() { try { return kawa.lib.lists.car((gnu.lists.Pair)(localLList = objs)); } catch (ClassCastException localClassCastException) { gnu.lists.LList localLList; throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localLList);
      }
    }
    
    gnu.lists.LList objs;
    final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 19, null, 0);
    final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 15, null, 0);
    final ModuleMethod lambda$Fn18 = new ModuleMethod(this, 16, null, 0);
    final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 17, null, 0);
    final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 18, null, 0);
    public frame8() {}
    
    /* Error */
    Object lambda25()
    {
      // Byte code:
      //   0: getstatic 71	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   3: getstatic 74	gnu/kawa/slib/StreamsDerived:stream$Mnconstant	Lgnu/expr/ModuleMethod;
      //   6: iconst_2
      //   7: anewarray 50	java/lang/Object
      //   10: dup
      //   11: iconst_0
      //   12: aload_0
      //   13: getfield 6	gnu/kawa/slib/StreamsDerived$frame8:objs	Lgnu/lists/LList;
      //   16: dup
      //   17: astore_1
      //   18: checkcast 20	gnu/lists/Pair
      //   21: invokestatic 33	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   24: aastore
      //   25: dup
      //   26: iconst_1
      //   27: aload_0
      //   28: getfield 6	gnu/kawa/slib/StreamsDerived$frame8:objs	Lgnu/lists/LList;
      //   31: dup
      //   32: astore_1
      //   33: checkcast 20	gnu/lists/Pair
      //   36: invokestatic 41	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   39: invokestatic 80	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   42: aastore
      //   43: invokestatic 85	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   46: invokevirtual 91	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   49: areturn
      //   50: new 24	gnu/mapping/WrongType
      //   53: dup_x1
      //   54: swap
      //   55: ldc 26
      //   57: iconst_1
      //   58: aload_1
      //   59: invokespecial 30	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   62: athrow
      //   63: new 24	gnu/mapping/WrongType
      //   66: dup_x1
      //   67: swap
      //   68: ldc 39
      //   70: iconst_1
      //   71: aload_1
      //   72: invokespecial 30	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   75: athrow
      // Line number table:
      //   Java source line #123	-> byte code offset #0
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	frame8
      //   17	55	1	localLList	gnu.lists.LList
      //   50	1	2	localClassCastException1	ClassCastException
      //   63	1	3	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   18	21	50	java/lang/ClassCastException
      //   33	36	63	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
    {
      switch (selector)
      {
      case 19: 
        proc = paramModuleMethod;
        pc = 0;
        return 0;
      case 18: 
        proc = paramModuleMethod;
        pc = 0;
        return 0;
      case 17: 
        proc = paramModuleMethod;
        pc = 0;
        return 0;
      case 16: 
        proc = paramModuleMethod;
        pc = 0;
        return 0;
      case 15: 
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
      switch (selector)
      {
      case 15: 
        return lambda22();
      case 16: 
        return lambda23();
      case 17: 
        return lambda24();
      case 18: 
        return lambda25();
      case 19: 
        return lambda21();
      }
      return super.apply0(paramModuleMethod);
    }
  }
  
  public class frame9
    extends gnu.expr.ModuleBody
  {
    public frame9() {}
    
    public Object lambda26streamDrop(gnu.math.IntNum n, Stream strm)
    {
      void tmp7_4 = new StreamsDerived.frame10();74staticLink = this;StreamsDerived.frame10 $heapFrame = tmp7_4;n = n;strm = strm;return new StreamPromise(lambda$Fn21, true);
    }
  }
  
  public static Stream streamDrop(gnu.math.IntNum n, Stream strm)
  {
    frame9 $heapFrame = new frame9();
    




    if (kawa.lib.numbers.isNegative(n)) throw gnu.expr.Special.reachedUnexpected;
    return (Stream)$heapFrame.lambda26streamDrop(n, strm); }
  
  public class frame11 extends gnu.expr.ModuleBody { public frame11() {}
    
    public Object lambda28streamDropWhile(Stream strm) { void tmp7_4 = new StreamsDerived.frame12();74staticLink = this;StreamsDerived.frame12 $heapFrame = tmp7_4;strm = strm;return new StreamPromise(lambda$Fn22, true);
    }
    
    gnu.mapping.Procedure pred$Qu;
  }
  
  public static Stream streamDropWhile(gnu.mapping.Procedure isPred, Stream strm)
  {
    frame11 $heapFrame = new frame11();pred$Qu = isPred;
    




    return (Stream)$heapFrame.lambda28streamDropWhile(strm); }
  
  public class frame13 extends gnu.expr.ModuleBody { public frame13() {}
    
    public Object lambda30streamFilter(Stream strm) { void tmp7_4 = new StreamsDerived.frame14();74staticLink = this;StreamsDerived.frame14 $heapFrame = tmp7_4;strm = strm;return new StreamPromise(lambda$Fn23, true);
    }
    
    gnu.mapping.Procedure pred$Qu;
  }
  
  public static Stream streamFilter(gnu.mapping.Procedure isPred, Stream strm)
  {
    frame13 $heapFrame = new frame13();pred$Qu = isPred;
    





    return (Stream)$heapFrame.lambda30streamFilter(strm);
  }
  
  public static Object streamFold(gnu.mapping.Procedure proc, Object base, Stream strm) { for (;;) { Stream localStream1 = strm;Object base = base;
      
      Stream strm;
      tmpTernaryOp = (StreamsPrimitive.isStreamNull(strm) ? base : (Stream)StreamsPrimitive.streamCdr(strm); } return proc.apply2(base, StreamsPrimitive.streamCar(strm));
  }
  





  static boolean lambda34(Object x) { return !StreamsPrimitive.isStream(x); }
  
  public class frame15 extends gnu.expr.ModuleBody {
    public frame15() {}
    
    public Object lambda35streamFrom(gnu.math.Numeric first, gnu.math.Numeric delta) {
      void tmp7_4 = new StreamsDerived.frame16();74staticLink = this;StreamsDerived.frame16 $heapFrame = tmp7_4;first = first;delta = delta;return new StreamPromise(lambda$Fn27, true);
    }
  }
  
  public static Stream streamFrom(gnu.math.Numeric first, gnu.math.Numeric delta)
  {
    frame15 $heapFrame = new frame15();
    


    return (Stream)$heapFrame.lambda35streamFrom(first, delta); }
  
  public class frame17 extends gnu.expr.ModuleBody { public frame17() {}
    
    public Object lambda39streamIterate(Object base) { void tmp7_4 = new StreamsDerived.frame18();74staticLink = this;StreamsDerived.frame18 $heapFrame = tmp7_4;base = base;return new StreamPromise(lambda$Fn30, true);
    }
    
    gnu.mapping.Procedure proc;
  }
  
  public static Stream streamIterate(gnu.mapping.Procedure proc, Object base)
  {
    frame17 $heapFrame = new frame17();proc = proc;
    


    return (Stream)$heapFrame.lambda39streamIterate(base);
  }
  
  public static gnu.math.IntNum streamLength(Stream strm) { for (;;) { Stream localStream1 = strm;gnu.math.IntNum len = Lit7;
      
      Stream strm;
      tmpTernaryOp = (StreamsPrimitive.isStreamNull(strm) ? len : (Stream)StreamsPrimitive.streamCdr(strm); } return gnu.math.IntNum.add(len, 1);
  }
  
  public class frame19 extends gnu.expr.ModuleBody
  {
    gnu.mapping.Procedure proc;
    
    public Object lambda44streamMap(gnu.lists.LList strms)
    {
      void tmp7_4 = new StreamsDerived.frame20();74staticLink = this;StreamsDerived.frame20 $heapFrame = tmp7_4;strms = strms;return new StreamPromise(lambda$Fn34, true);
    }
    

    static boolean lambda43(Object x)
    {
      return !StreamsPrimitive.isStream(x);
    }
    
    public frame19() {}
  }
  
  public static Stream streamMap$V(gnu.mapping.Procedure proc, Object[] argsArray)
  {
    frame19 $heapFrame = new frame19();proc = proc; gnu.lists.LList localLList1; gnu.lists.LList strms = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    





    if (kawa.lib.lists.isNull(strms)) throw gnu.expr.Special.reachedUnexpected;
    if (gnu.expr.KawaConvert.isTrue(srfi1.any$V(lambda$Fn33, strms, new Object[0])))
      throw gnu.expr.Special.reachedUnexpected;
    return (Stream)$heapFrame.lambda44streamMap(strms);
  }
  

















  public static boolean lambda90isWildcard(Object x)
  {
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();return kawa.lib.std_syntax.isIdentifier(x) ? kawa.lib.std_syntax.isFreeIdentifier$Eq(x, Lit44.execute(null, localTemplateScope)) : false; }
  static Object lambda89(Object x) { Object localObject = x;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(5, null);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make(); if (Lit34.match(x, arrayOfObject, 0))
    {
      localTemplateScope = kawa.lang.TemplateScope.make();
      localTemplateScope = kawa.lang.TemplateScope.make();
    }
    

    localTemplateScope = kawa.lang.TemplateScope.make(); if (Lit39.match(x, arrayOfObject, 0))
    {


      localTemplateScope = kawa.lang.TemplateScope.make();
      localTemplateScope = kawa.lang.TemplateScope.make();
    }
    localTemplateScope = kawa.lang.TemplateScope.make();return Lit42.match(x, arrayOfObject, 0) ? Lit43.execute(arrayOfObject, localTemplateScope) : lambda90isWildcard(Lit40.execute(arrayOfObject, localTemplateScope)) ? Lit41.execute(arrayOfObject, localTemplateScope) : Lit37.match(x, arrayOfObject, 0) ? Lit38.execute(arrayOfObject, localTemplateScope) : lambda90isWildcard(Lit35.execute(arrayOfObject, localTemplateScope)) ? Lit36.execute(arrayOfObject, localTemplateScope) : Lit32.match(x, arrayOfObject, 0) ? Lit33.execute(arrayOfObject, localTemplateScope) : kawa.standard.syntax_case.error("syntax-case", x);
  }
  







  public class frame21
    extends gnu.expr.ModuleBody
  {
    public frame21() {}
    







    public Object lambda48streamRange(gnu.math.Numeric first, gnu.math.Numeric past, gnu.math.Numeric delta, gnu.mapping.Procedure isLt)
    {
      void tmp7_4 = new StreamsDerived.frame22();74staticLink = this;StreamsDerived.frame22 $heapFrame = tmp7_4;first = first;past = past;delta = delta;lt$Qu = isLt;return new StreamPromise(lambda$Fn37, true);
    }
  }
  




  public static Object streamRef(Stream strm, gnu.math.IntNum n)
  {
    if (kawa.lib.numbers.isNegative(n)) throw gnu.expr.Special.reachedUnexpected;
    for (;;) { gnu.math.IntNum localIntNum1 = n;Stream strm = strm;
      gnu.math.IntNum n; if (StreamsPrimitive.isStreamNull(strm)) { throw gnu.expr.Special.reachedUnexpected;
      }
      tmpTernaryOp = (kawa.lib.numbers.isZero(n) ? StreamsPrimitive.streamCar(strm) : gnu.math.IntNum.add(n, -1); } return (Stream)StreamsPrimitive.streamCdr(strm); }
  
  public class frame23 extends gnu.expr.ModuleBody { public frame23() {}
    
    public Object lambda52streamReverse(Stream strm, Stream rev) { void tmp7_4 = new StreamsDerived.frame24();74staticLink = this;StreamsDerived.frame24 $heapFrame = tmp7_4;strm = strm;rev = rev;return new StreamPromise(lambda$Fn40, true);
    }
  }
  
  public static Stream streamReverse(Stream strm)
  {
    frame23 $heapFrame = new frame23();
    




    return (Stream)$heapFrame.lambda52streamReverse(strm, StreamsPrimitive.stream$Mnnull); }
  
  public class frame25 extends gnu.expr.ModuleBody { public frame25() {}
    gnu.mapping.Procedure proc;
    public Object lambda56streamScan(Object base, Stream strm) { void tmp7_4 = new StreamsDerived.frame26();74staticLink = this;StreamsDerived.frame26 $heapFrame = tmp7_4;base = base;strm = strm;return new StreamPromise(lambda$Fn43, true); }
     }
  public class frame26 extends gnu.expr.ModuleBody { Object lambda58() { return base; } static StreamPromise lambda59() { return StreamsPrimitive.stream$Mnnull; }
    StreamPair lambda57() { return StreamsPrimitive.isStreamNull(strm) ? new StreamPair(new StreamPromise(lambda$Fn44, false), new StreamPromise(StreamsDerived.lambda$Fn45, true)) : new StreamPair(new StreamPromise(lambda$Fn46, false), new StreamPromise(lambda$Fn47, true)); } Object lambda60() { return base; } Object lambda61() { try { return staticLink.lambda56streamScan(staticLink.proc.apply2(base, StreamsPrimitive.streamCar(strm)), (Stream)(localObject = StreamsPrimitive.streamCdr(strm))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "stream-scan", 1, localObject);
      }
    }
    
    Object base;
    Stream strm;
    StreamsDerived.frame25 staticLink;
    final ModuleMethod lambda$Fn43 = new ModuleMethod(this, 43, null, 0);
    final ModuleMethod lambda$Fn44 = new ModuleMethod(this, 40, null, 0);
    final ModuleMethod lambda$Fn46 = new ModuleMethod(this, 41, null, 0);
    final ModuleMethod lambda$Fn47 = new ModuleMethod(this, 42, null, 0);
    public frame26() {}
    
    public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
    {
      switch (selector)
      {
      case 43: 
        proc = paramModuleMethod;
        pc = 0;
        return 0;
      case 42: 
        proc = paramModuleMethod;
        pc = 0;
        return 0;
      case 41: 
        proc = paramModuleMethod;
        pc = 0;
        return 0;
      case 40: 
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
      switch (selector)
      {
      case 40: 
        return lambda58();
      case 41: 
        return lambda60();
      case 42: 
        return lambda61();
      case 43: 
        return lambda57();
      }
      return super.apply0(paramModuleMethod);
    }
  }
  
  public static Stream streamScan(gnu.mapping.Procedure proc, Object base, Stream strm)
  {
    frame25 $heapFrame = new frame25();proc = proc;
    




    return (Stream)$heapFrame.lambda56streamScan(base, strm); }
  
  public class frame27 extends gnu.expr.ModuleBody { public frame27() {}
    
    public Object lambda62streamTake(gnu.math.IntNum n, Stream strm) { void tmp7_4 = new StreamsDerived.frame28();74staticLink = this;StreamsDerived.frame28 $heapFrame = tmp7_4;n = n;strm = strm;return new StreamPromise(lambda$Fn48, true);
    }
  }
  
  public static Stream streamTake(gnu.math.IntNum n, Stream strm)
  {
    frame27 $heapFrame = new frame27();
    




    if (kawa.lib.numbers.isNegative(n)) throw gnu.expr.Special.reachedUnexpected;
    return (Stream)$heapFrame.lambda62streamTake(n, strm); }
  
  public class frame29 extends gnu.expr.ModuleBody { public frame29() {}
    
    public Object lambda66streamTakeWhile(Stream strm) { void tmp7_4 = new StreamsDerived.frame30();74staticLink = this;StreamsDerived.frame30 $heapFrame = tmp7_4;strm = strm;return new StreamPromise(lambda$Fn51, true);
    }
    
    gnu.mapping.Procedure pred$Qu;
  }
  
  public static Stream streamTakeWhile(gnu.mapping.Procedure isPred, Stream strm)
  {
    frame29 $heapFrame = new frame29();pred$Qu = isPred;
    





    return (Stream)$heapFrame.lambda66streamTakeWhile(strm);
  }
  
  public class frame31 extends gnu.expr.ModuleBody { public frame31() {}
    
    public Object lambda70streamUnfold(Object base) { void tmp7_4 = new StreamsDerived.frame32();74staticLink = this;StreamsDerived.frame32 $heapFrame = tmp7_4;base = base;return new StreamPromise(lambda$Fn54, true);
    }
    
    gnu.mapping.Procedure generator;
    gnu.mapping.Procedure mapper;
    gnu.mapping.Procedure pred$Qu;
  }
  
  public static Stream streamUnfold(gnu.mapping.Procedure mapper, gnu.mapping.Procedure isPred, gnu.mapping.Procedure generator, Object base)
  {
    frame31 $heapFrame = new frame31();mapper = mapper;pred$Qu = isPred;generator = generator;
    





    return (Stream)$heapFrame.lambda70streamUnfold(base);
  }
  
  public class frame33 extends gnu.expr.ModuleBody {
    static int lambda75$V(Object[] argsArray) {
      gnu.lists.LList localLList1;
      gnu.lists.LList vs = localLList1 = gnu.lists.LList.makeList(argsArray, 0);return vs.size() - 1; }
    
    public Object lambda74unfoldResultStream(gnu.mapping.Procedure gen, Object seed) { void tmp7_4 = new StreamsDerived.frame34();74staticLink = this;StreamsDerived.frame34 $heapFrame = tmp7_4;gen = gen;seed = seed;return new StreamPromise(lambda$Fn58, true);
    }
    

    public Object lambda76resultStream$To$OutputStream(Stream resultStream, gnu.math.IntNum i)
    {
      void tmp7_4 = new StreamsDerived.frame36();74staticLink = this;StreamsDerived.frame36 $heapFrame = tmp7_4;result$Mnstream = resultStream;i = i;return new StreamPromise(lambda$Fn62, true);
    }
    
    public frame33() {}
  }
  
  public static Object streamUnfolds(gnu.mapping.Procedure gen, Object seed)
  {
    frame33 $heapFrame = new frame33();
    




















    Object result$Mnstream = 
    



      $heapFrame.lambda74unfoldResultStream(gen, seed);Object localObject1 = seed;gnu.mapping.Procedure gen = gen;
    for (;;)
    {
      Object seed = gnu.lists.LList.Empty;gnu.math.IntNum i = gnu.kawa.lispexpr.LangObjType.coerceIntNum(gnu.mapping.Promise.force(gnu.kawa.functions.ApplyWithValues.applyWithValues.apply2(gen.apply1(seed), lambda$Fn57), gnu.math.IntNum.class));
      








      try
      {
        gnu.lists.LList outputs;
        








        tmpTernaryOp = (kawa.lib.numbers.isZero(i) ? kawa.standard.Scheme.apply.apply2(kawa.lib.misc.values, outputs) : kawa.lib.lists.cons($heapFrame.lambda76resultStream$To$OutputStream((Stream)(localObject2 = result$Mnstream), i), outputs); } catch (ClassCastException localClassCastException) { Object localObject2; throw new gnu.mapping.WrongType(localClassCastException, "result-stream->output-stream", 0, localObject2); } } return gnu.math.IntNum.add(i, -1);
  }
  
  public class frame38 extends gnu.expr.ModuleBody {
    public Object lambda85streamZip(gnu.lists.LList strms) {
      void tmp7_4 = new StreamsDerived.frame39();74staticLink = this;StreamsDerived.frame39 $heapFrame = tmp7_4;strms = strms;return new StreamPromise(lambda$Fn66, true);
    }
    
    static boolean lambda84(Object x)
    {
      return !StreamsPrimitive.isStream(x);
    }
    
    public frame38() {}
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return list$To$Stream((gnu.lists.LList)gnu.mapping.Promise.force(paramObject, gnu.lists.LList.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      






























































































































































        localClassCastException1, "list->stream", 1, paramObject);
    }
    try
    {
      return port$To$Stream((gnu.kawa.io.InPort)gnu.mapping.Promise.force(paramObject, gnu.kawa.io.InPort.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "port->stream", 1, paramObject);
    }
    






























    return frame4.lambda10(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    try
    {
      return streamConcat((Stream)paramObject); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "stream-concat", 1, paramObject);
    }
    
























































    return lambda34(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    try
    {
      return streamFrom(gnu.kawa.lispexpr.LangObjType.coerceNumeric(gnu.mapping.Promise.force(paramObject, gnu.math.Numeric.class))); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "stream-from", 1, paramObject);
    }
    







    try
    {
      return streamLength((Stream)paramObject); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "stream-length", 1, paramObject);
    }
    
















    return frame19.lambda43(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    













































































    try
    {
      return streamReverse((Stream)paramObject); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "stream-reverse", 1, paramObject);
    }
    












































































    return frame38.lambda84(paramObject) ? Boolean.TRUE : Boolean.FALSE;return lambda89(paramObject);return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static Stream streamZip$V(Object[] argsArray)
  {
    frame38 $heapFrame = new frame38(); gnu.lists.LList localLList1; gnu.lists.LList strms = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    




    if (kawa.lib.lists.isNull(strms)) throw gnu.expr.Special.reachedUnexpected;
    if (gnu.expr.KawaConvert.isTrue(srfi1.any$V(lambda$Fn65, strms, new Object[0])))
      throw gnu.expr.Special.reachedUnexpected;
    return (Stream)$heapFrame.lambda85streamZip(strms);
  }
  
  /* Error */
  public static gnu.lists.LList stream$To$List$V(Object[] argsArray)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokestatic 62	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_2
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 66	gnu/lists/LList:size	()I
    //   12: iconst_1
    //   13: if_icmpne +9 -> 22
    //   16: getstatic 72	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   19: goto +12 -> 31
    //   22: aload_1
    //   23: dup
    //   24: astore_3
    //   25: checkcast 74	gnu/lists/Pair
    //   28: invokestatic 88	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   31: astore_2
    //   32: aload_1
    //   33: invokevirtual 66	gnu/lists/LList:size	()I
    //   36: iconst_1
    //   37: if_icmpne +22 -> 59
    //   40: aload_1
    //   41: dup
    //   42: astore 4
    //   44: checkcast 74	gnu/lists/Pair
    //   47: invokestatic 88	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   50: dup
    //   51: astore 4
    //   53: checkcast 29	gnu/kawa/slib/Stream
    //   56: goto +13 -> 69
    //   59: aload_1
    //   60: invokestatic 94	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: dup
    //   64: astore 4
    //   66: checkcast 29	gnu/kawa/slib/Stream
    //   69: astore_3
    //   70: aload_2
    //   71: invokestatic 100	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   74: ifeq +32 -> 106
    //   77: aload_2
    //   78: invokestatic 105	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   81: ifne +25 -> 106
    //   84: iconst_2
    //   85: anewarray 107	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: getstatic 111	gnu/kawa/slib/StreamsDerived:Lit0	Lgnu/mapping/SimpleSymbol;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: ldc 113
    //   98: aastore
    //   99: invokestatic 119	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   102: getstatic 125	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   105: athrow
    //   106: aload_2
    //   107: invokestatic 100	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   110: ifeq +43 -> 153
    //   113: aload_2
    //   114: ldc 127
    //   116: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: dup
    //   120: astore 4
    //   122: invokestatic 139	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   125: invokestatic 145	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   128: ifeq +25 -> 153
    //   131: iconst_2
    //   132: anewarray 107	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: getstatic 111	gnu/kawa/slib/StreamsDerived:Lit0	Lgnu/mapping/SimpleSymbol;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: ldc -109
    //   145: aastore
    //   146: invokestatic 119	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   149: getstatic 125	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   152: athrow
    //   153: aload_2
    //   154: invokestatic 100	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   157: ifeq +18 -> 175
    //   160: aload_2
    //   161: ldc -107
    //   163: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   166: dup
    //   167: astore 4
    //   169: invokestatic 153	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   172: goto +6 -> 178
    //   175: getstatic 159	gnu/kawa/slib/StreamsDerived:Lit1	Lgnu/math/IntNum;
    //   178: aload_3
    //   179: invokestatic 163	gnu/kawa/slib/StreamsDerived:lambda9loop	(Lgnu/math/IntNum;Lgnu/kawa/slib/Stream;)Ljava/lang/Object;
    //   182: ldc 58
    //   184: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: checkcast 58	gnu/lists/LList
    //   190: areturn
    //   191: new 78	gnu/mapping/WrongType
    //   194: dup_x1
    //   195: swap
    //   196: ldc 80
    //   198: iconst_1
    //   199: aload_3
    //   200: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: new 78	gnu/mapping/WrongType
    //   207: dup_x1
    //   208: swap
    //   209: ldc 80
    //   211: iconst_1
    //   212: aload 4
    //   214: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    //   218: new 78	gnu/mapping/WrongType
    //   221: dup_x1
    //   222: swap
    //   223: ldc 90
    //   225: bipush -2
    //   227: aload 4
    //   229: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: new 78	gnu/mapping/WrongType
    //   236: dup_x1
    //   237: swap
    //   238: ldc 90
    //   240: bipush -2
    //   242: aload 4
    //   244: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   247: athrow
    //   248: new 78	gnu/mapping/WrongType
    //   251: dup_x1
    //   252: swap
    //   253: ldc -115
    //   255: iconst_1
    //   256: aload 4
    //   258: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   261: athrow
    //   262: new 78	gnu/mapping/WrongType
    //   265: dup_x1
    //   266: swap
    //   267: ldc -101
    //   269: iconst_0
    //   270: aload 4
    //   272: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   275: athrow
    // Line number table:
    //   Java source line #81	-> byte code offset #0
    //   Java source line #82	-> byte code offset #8
    //   Java source line #83	-> byte code offset #32
    //   Java source line #84	-> byte code offset #70
    //   Java source line #85	-> byte code offset #113
    //   Java source line #86	-> byte code offset #153
    //   Java source line #82	-> byte code offset #191
    //   Java source line #83	-> byte code offset #204
    //   Java source line #85	-> byte code offset #248
    //   Java source line #86	-> byte code offset #262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	argsArray	Object[]
    //   0	60	1	args	gnu.lists.LList
    //   6	26	2	localObject1	Object
    //   70	91	2	n	Object
    //   24	1	3	localLList1	gnu.lists.LList
    //   69	131	3	strm	Stream
    //   42	229	4	localObject2	Object
    //   191	1	7	localClassCastException1	ClassCastException
    //   204	1	8	localClassCastException2	ClassCastException
    //   218	1	9	localClassCastException3	ClassCastException
    //   233	1	10	localClassCastException4	ClassCastException
    //   248	1	11	localClassCastException5	ClassCastException
    //   262	1	12	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   25	28	191	java/lang/ClassCastException
    //   44	47	204	java/lang/ClassCastException
    //   53	56	218	java/lang/ClassCastException
    //   66	69	233	java/lang/ClassCastException
    //   122	125	248	java/lang/ClassCastException
    //   169	172	262	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object streamForEach$V(gnu.mapping.Procedure proc, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 62	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 196	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: ifeq +26 -> 38
    //   15: iconst_2
    //   16: anewarray 107	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: getstatic 274	gnu/kawa/slib/StreamsDerived:Lit5	Lgnu/mapping/SimpleSymbol;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 276
    //   30: aastore
    //   31: invokestatic 119	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   34: getstatic 125	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   37: athrow
    //   38: getstatic 282	gnu/kawa/slib/StreamsDerived:lambda$Fn26	Lgnu/expr/ModuleMethod;
    //   41: aload_2
    //   42: iconst_0
    //   43: anewarray 107	java/lang/Object
    //   46: invokestatic 207	gnu/kawa/slib/srfi1:any$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   49: invokestatic 100	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   52: ifeq +25 -> 77
    //   55: iconst_2
    //   56: anewarray 107	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: getstatic 274	gnu/kawa/slib/StreamsDerived:Lit5	Lgnu/mapping/SimpleSymbol;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: ldc -44
    //   69: aastore
    //   70: invokestatic 119	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   73: getstatic 125	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   76: athrow
    //   77: aload_2
    //   78: astore_3
    //   79: getstatic 285	gnu/kawa/slib/StreamsPrimitive:stream$Mnnull$Qu	Lgnu/expr/ModuleMethod;
    //   82: aload_3
    //   83: iconst_0
    //   84: anewarray 107	java/lang/Object
    //   87: invokestatic 207	gnu/kawa/slib/srfi1:any$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   90: invokestatic 100	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   93: ifne +184 -> 277
    //   96: getstatic 291	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   99: aload_0
    //   100: aload_3
    //   101: astore 4
    //   103: getstatic 176	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 6
    //   111: aload 4
    //   113: getstatic 176	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   116: if_acmpeq +67 -> 183
    //   119: aload 4
    //   121: ldc 74
    //   123: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   126: checkcast 74	gnu/lists/Pair
    //   129: astore 7
    //   131: aload 7
    //   133: invokevirtual 294	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   136: astore 8
    //   138: new 74	gnu/lists/Pair
    //   141: dup
    //   142: aload 8
    //   144: invokestatic 179	gnu/kawa/slib/StreamsPrimitive:streamCar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: getstatic 176	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   150: invokespecial 297	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   153: aload 6
    //   155: ifnonnull +9 -> 164
    //   158: dup
    //   159: astore 5
    //   161: goto +10 -> 171
    //   164: aload 6
    //   166: swap
    //   167: dup_x1
    //   168: invokevirtual 301	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   171: astore 6
    //   173: aload 7
    //   175: invokevirtual 304	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   178: astore 4
    //   180: goto -69 -> 111
    //   183: aload 5
    //   185: invokevirtual 271	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload_3
    //   190: astore 4
    //   192: getstatic 176	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   195: astore 5
    //   197: aconst_null
    //   198: astore 6
    //   200: aload 4
    //   202: getstatic 176	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   205: if_acmpeq +67 -> 272
    //   208: aload 4
    //   210: ldc 74
    //   212: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   215: checkcast 74	gnu/lists/Pair
    //   218: astore 7
    //   220: aload 7
    //   222: invokevirtual 294	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   225: astore 8
    //   227: new 74	gnu/lists/Pair
    //   230: dup
    //   231: aload 8
    //   233: invokestatic 186	gnu/kawa/slib/StreamsPrimitive:streamCdr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   236: getstatic 176	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   239: invokespecial 297	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   242: aload 6
    //   244: ifnonnull +9 -> 253
    //   247: dup
    //   248: astore 5
    //   250: goto +10 -> 260
    //   253: aload 6
    //   255: swap
    //   256: dup_x1
    //   257: invokevirtual 301	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   260: astore 6
    //   262: aload 7
    //   264: invokevirtual 304	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   267: astore 4
    //   269: goto -69 -> 200
    //   272: aload 5
    //   274: goto -196 -> 78
    //   277: getstatic 310	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   280: areturn
    // Line number table:
    //   Java source line #157	-> byte code offset #0
    //   Java source line #158	-> byte code offset #8
    //   Java source line #162	-> byte code offset #8
    //   Java source line #163	-> byte code offset #38
    //   Java source line #164	-> byte code offset #55
    //   Java source line #165	-> byte code offset #77
    //   Java source line #158	-> byte code offset #78
    //   Java source line #159	-> byte code offset #79
    //   Java source line #160	-> byte code offset #96
    //   Java source line #161	-> byte code offset #189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	proc	gnu.mapping.Procedure
    //   0	280	1	argsArray	Object[]
    //   0	280	2	strms	gnu.lists.LList
    //   79	201	3	strms	gnu.lists.LList
  }
  
  public static Stream streamFrom(gnu.math.Numeric paramNumeric)
  {
    return streamFrom(paramNumeric, Lit6);
  }
  
  /* Error */
  public static Stream streamRange$V(gnu.math.Numeric first, gnu.math.Numeric past, Object[] argsArray)
  {
    // Byte code:
    //   0: new 351	gnu/kawa/slib/StreamsDerived$frame21
    //   3: dup
    //   4: invokespecial 352	gnu/kawa/slib/StreamsDerived$frame21:<init>	()V
    //   7: astore 4
    //   9: aload_2
    //   10: iconst_0
    //   11: invokestatic 62	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   14: dup
    //   15: astore 5
    //   17: astore_3
    //   18: aload_3
    //   19: invokestatic 355	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   22: ifeq +28 -> 50
    //   25: aload_3
    //   26: dup
    //   27: astore 6
    //   29: checkcast 74	gnu/lists/Pair
    //   32: invokestatic 88	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   35: ldc_w 357
    //   38: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   41: dup
    //   42: astore 6
    //   44: invokestatic 361	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   47: goto +20 -> 67
    //   50: aload_0
    //   51: aload_1
    //   52: invokestatic 369	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   55: ifeq +9 -> 64
    //   58: getstatic 313	gnu/kawa/slib/StreamsDerived:Lit6	Lgnu/math/IntNum;
    //   61: goto +6 -> 67
    //   64: getstatic 159	gnu/kawa/slib/StreamsDerived:Lit1	Lgnu/math/IntNum;
    //   67: astore 5
    //   69: getstatic 336	gnu/kawa/slib/StreamsDerived:Lit7	Lgnu/math/IntNum;
    //   72: aload 5
    //   74: invokestatic 369	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   77: ifeq +9 -> 86
    //   80: getstatic 373	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   83: goto +6 -> 89
    //   86: getstatic 376	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   89: astore 6
    //   91: aload 4
    //   93: aload_0
    //   94: aload_1
    //   95: aload 5
    //   97: aload 6
    //   99: invokevirtual 380	gnu/kawa/slib/StreamsDerived$frame21:lambda48streamRange	(Lgnu/math/Numeric;Lgnu/math/Numeric;Lgnu/math/Numeric;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   102: checkcast 29	gnu/kawa/slib/Stream
    //   105: areturn
    //   106: new 78	gnu/mapping/WrongType
    //   109: dup_x1
    //   110: swap
    //   111: ldc 80
    //   113: iconst_1
    //   114: aload 6
    //   116: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   119: athrow
    //   120: new 78	gnu/mapping/WrongType
    //   123: dup_x1
    //   124: swap
    //   125: ldc_w 363
    //   128: bipush -2
    //   130: aload 6
    //   132: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    // Line number table:
    //   Java source line #261	-> byte code offset #0
    //   Java source line #262	-> byte code offset #18
    //   Java source line #263	-> byte code offset #18
    //   Java source line #262	-> byte code offset #18
    //   Java source line #268	-> byte code offset #18
    //   Java source line #269	-> byte code offset #69
    //   Java source line #270	-> byte code offset #91
    //   Java source line #268	-> byte code offset #106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	first	gnu.math.Numeric
    //   0	105	1	past	gnu.math.Numeric
    //   0	105	2	argsArray	Object[]
    //   0	26	3	step	gnu.lists.LList
    //   7	85	4	$heapFrame	frame21
    //   15	1	5	localLList1	gnu.lists.LList
    //   67	29	5	delta	Object
    //   27	16	6	localObject1	Object
    //   89	42	6	lt$Qu	gnu.kawa.functions.NumberCompare
    //   106	1	9	localClassCastException1	ClassCastException
    //   120	1	10	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   29	32	106	java/lang/ClassCastException
    //   44	47	120	java/lang/ClassCastException
  }
  
  public StreamsDerived()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 838	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+375->379, 63:+339->343, 64:+306->310, 67:+289->293, 69:+261->265, 75:+244->248, 77:+207->211, 80:+179->183, 81:+162->166, 83:+100->104, 86:+134->138, 94:+117->121
    //   104: aload_3
    //   105: aload_2
    //   106: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   109: aload_3
    //   110: aload_1
    //   111: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   114: aload_3
    //   115: iconst_1
    //   116: putfield 842	gnu/mapping/CallContext:pc	I
    //   119: iconst_0
    //   120: ireturn
    //   121: aload_3
    //   122: aload_2
    //   123: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   126: aload_3
    //   127: aload_1
    //   128: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   131: aload_3
    //   132: iconst_1
    //   133: putfield 842	gnu/mapping/CallContext:pc	I
    //   136: iconst_0
    //   137: ireturn
    //   138: aload_3
    //   139: aload_2
    //   140: dup
    //   141: instanceof 29
    //   144: ifne +7 -> 151
    //   147: ldc_w 851
    //   150: ireturn
    //   151: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   154: aload_3
    //   155: aload_1
    //   156: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   159: aload_3
    //   160: iconst_1
    //   161: putfield 842	gnu/mapping/CallContext:pc	I
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_3
    //   167: aload_2
    //   168: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   171: aload_3
    //   172: aload_1
    //   173: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   176: aload_3
    //   177: iconst_1
    //   178: putfield 842	gnu/mapping/CallContext:pc	I
    //   181: iconst_0
    //   182: ireturn
    //   183: aload_3
    //   184: aload_2
    //   185: dup
    //   186: instanceof 29
    //   189: ifne +7 -> 196
    //   192: ldc_w 851
    //   195: ireturn
    //   196: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   199: aload_3
    //   200: aload_1
    //   201: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   204: aload_3
    //   205: iconst_1
    //   206: putfield 842	gnu/mapping/CallContext:pc	I
    //   209: iconst_0
    //   210: ireturn
    //   211: aload_3
    //   212: aload_2
    //   213: ldc_w 357
    //   216: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   219: dup
    //   220: invokestatic 854	gnu/math/Numeric:asNumericOrNull	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   223: ifnull +6 -> 229
    //   226: goto +7 -> 233
    //   229: ldc_w 851
    //   232: ireturn
    //   233: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   236: aload_3
    //   237: aload_1
    //   238: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   241: aload_3
    //   242: iconst_1
    //   243: putfield 842	gnu/mapping/CallContext:pc	I
    //   246: iconst_0
    //   247: ireturn
    //   248: aload_3
    //   249: aload_2
    //   250: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   253: aload_3
    //   254: aload_1
    //   255: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   258: aload_3
    //   259: iconst_1
    //   260: putfield 842	gnu/mapping/CallContext:pc	I
    //   263: iconst_0
    //   264: ireturn
    //   265: aload_3
    //   266: aload_2
    //   267: dup
    //   268: instanceof 29
    //   271: ifne +7 -> 278
    //   274: ldc_w 851
    //   277: ireturn
    //   278: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   281: aload_3
    //   282: aload_1
    //   283: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   286: aload_3
    //   287: iconst_1
    //   288: putfield 842	gnu/mapping/CallContext:pc	I
    //   291: iconst_0
    //   292: ireturn
    //   293: aload_3
    //   294: aload_2
    //   295: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   298: aload_3
    //   299: aload_1
    //   300: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   303: aload_3
    //   304: iconst_1
    //   305: putfield 842	gnu/mapping/CallContext:pc	I
    //   308: iconst_0
    //   309: ireturn
    //   310: aload_3
    //   311: aload_2
    //   312: ldc 43
    //   314: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   317: dup
    //   318: instanceof 43
    //   321: ifne +7 -> 328
    //   324: ldc_w 851
    //   327: ireturn
    //   328: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   331: aload_3
    //   332: aload_1
    //   333: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   336: aload_3
    //   337: iconst_1
    //   338: putfield 842	gnu/mapping/CallContext:pc	I
    //   341: iconst_0
    //   342: ireturn
    //   343: aload_3
    //   344: aload_2
    //   345: ldc 58
    //   347: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   350: dup
    //   351: instanceof 58
    //   354: ifeq +6 -> 360
    //   357: goto +7 -> 364
    //   360: ldc_w 851
    //   363: ireturn
    //   364: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   367: aload_3
    //   368: aload_1
    //   369: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   372: aload_3
    //   373: iconst_1
    //   374: putfield 842	gnu/mapping/CallContext:pc	I
    //   377: iconst_0
    //   378: ireturn
    //   379: aload_0
    //   380: aload_1
    //   381: aload_2
    //   382: aload_3
    //   383: invokespecial 858	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   386: ireturn
    // Line number table:
    //   Java source line #219	-> byte code offset #104
    //   Java source line #358	-> byte code offset #121
    //   Java source line #279	-> byte code offset #138
    //   Java source line #198	-> byte code offset #166
    //   Java source line #179	-> byte code offset #183
    //   Java source line #167	-> byte code offset #211
    //   Java source line #163	-> byte code offset #248
    //   Java source line #104	-> byte code offset #265
    //   Java source line #100	-> byte code offset #293
    //   Java source line #67	-> byte code offset #310
    //   Java source line #59	-> byte code offset #343
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 838	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+581->585, 71:+525->529, 72:+468->472, 73:+411->415, 77:+345->349, 79:+299->303, 85:+243->247, 89:+187->191, 90:+130->134, 93:+84->88
    //   88: aload 4
    //   90: aload_2
    //   91: ldc_w 267
    //   94: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   97: dup
    //   98: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   101: ifnull +6 -> 107
    //   104: goto +7 -> 111
    //   107: ldc_w 851
    //   110: ireturn
    //   111: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   114: aload 4
    //   116: aload_3
    //   117: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   120: aload 4
    //   122: aload_1
    //   123: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   126: aload 4
    //   128: iconst_2
    //   129: putfield 842	gnu/mapping/CallContext:pc	I
    //   132: iconst_0
    //   133: ireturn
    //   134: aload 4
    //   136: aload_2
    //   137: ldc_w 267
    //   140: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   143: dup
    //   144: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   147: ifnull +6 -> 153
    //   150: goto +7 -> 157
    //   153: ldc_w 851
    //   156: ireturn
    //   157: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   160: aload 4
    //   162: aload_3
    //   163: dup
    //   164: instanceof 29
    //   167: ifne +7 -> 174
    //   170: ldc_w 866
    //   173: ireturn
    //   174: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   177: aload 4
    //   179: aload_1
    //   180: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   183: aload 4
    //   185: iconst_2
    //   186: putfield 842	gnu/mapping/CallContext:pc	I
    //   189: iconst_0
    //   190: ireturn
    //   191: aload 4
    //   193: aload_2
    //   194: ldc -107
    //   196: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   199: dup
    //   200: invokestatic 869	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   203: ifnull +6 -> 209
    //   206: goto +7 -> 213
    //   209: ldc_w 851
    //   212: ireturn
    //   213: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   216: aload 4
    //   218: aload_3
    //   219: dup
    //   220: instanceof 29
    //   223: ifne +7 -> 230
    //   226: ldc_w 866
    //   229: ireturn
    //   230: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   233: aload 4
    //   235: aload_1
    //   236: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   239: aload 4
    //   241: iconst_2
    //   242: putfield 842	gnu/mapping/CallContext:pc	I
    //   245: iconst_0
    //   246: ireturn
    //   247: aload 4
    //   249: aload_2
    //   250: dup
    //   251: instanceof 29
    //   254: ifne +7 -> 261
    //   257: ldc_w 851
    //   260: ireturn
    //   261: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   264: aload 4
    //   266: aload_3
    //   267: ldc -107
    //   269: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   272: dup
    //   273: invokestatic 869	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   276: ifnull +6 -> 282
    //   279: goto +7 -> 286
    //   282: ldc_w 866
    //   285: ireturn
    //   286: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   289: aload 4
    //   291: aload_1
    //   292: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   295: aload 4
    //   297: iconst_2
    //   298: putfield 842	gnu/mapping/CallContext:pc	I
    //   301: iconst_0
    //   302: ireturn
    //   303: aload 4
    //   305: aload_2
    //   306: ldc_w 267
    //   309: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   312: dup
    //   313: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   316: ifnull +6 -> 322
    //   319: goto +7 -> 326
    //   322: ldc_w 851
    //   325: ireturn
    //   326: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   329: aload 4
    //   331: aload_3
    //   332: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   335: aload 4
    //   337: aload_1
    //   338: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   341: aload 4
    //   343: iconst_2
    //   344: putfield 842	gnu/mapping/CallContext:pc	I
    //   347: iconst_0
    //   348: ireturn
    //   349: aload 4
    //   351: aload_2
    //   352: ldc_w 357
    //   355: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   358: dup
    //   359: invokestatic 854	gnu/math/Numeric:asNumericOrNull	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   362: ifnull +6 -> 368
    //   365: goto +7 -> 372
    //   368: ldc_w 851
    //   371: ireturn
    //   372: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   375: aload 4
    //   377: aload_3
    //   378: ldc_w 357
    //   381: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   384: dup
    //   385: invokestatic 854	gnu/math/Numeric:asNumericOrNull	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   388: ifnull +6 -> 394
    //   391: goto +7 -> 398
    //   394: ldc_w 866
    //   397: ireturn
    //   398: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   401: aload 4
    //   403: aload_1
    //   404: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   407: aload 4
    //   409: iconst_2
    //   410: putfield 842	gnu/mapping/CallContext:pc	I
    //   413: iconst_0
    //   414: ireturn
    //   415: aload 4
    //   417: aload_2
    //   418: ldc_w 267
    //   421: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   424: dup
    //   425: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   428: ifnull +6 -> 434
    //   431: goto +7 -> 438
    //   434: ldc_w 851
    //   437: ireturn
    //   438: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   441: aload 4
    //   443: aload_3
    //   444: dup
    //   445: instanceof 29
    //   448: ifne +7 -> 455
    //   451: ldc_w 866
    //   454: ireturn
    //   455: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   458: aload 4
    //   460: aload_1
    //   461: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   464: aload 4
    //   466: iconst_2
    //   467: putfield 842	gnu/mapping/CallContext:pc	I
    //   470: iconst_0
    //   471: ireturn
    //   472: aload 4
    //   474: aload_2
    //   475: ldc_w 267
    //   478: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   481: dup
    //   482: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   485: ifnull +6 -> 491
    //   488: goto +7 -> 495
    //   491: ldc_w 851
    //   494: ireturn
    //   495: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   498: aload 4
    //   500: aload_3
    //   501: dup
    //   502: instanceof 29
    //   505: ifne +7 -> 512
    //   508: ldc_w 866
    //   511: ireturn
    //   512: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   515: aload 4
    //   517: aload_1
    //   518: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   521: aload 4
    //   523: iconst_2
    //   524: putfield 842	gnu/mapping/CallContext:pc	I
    //   527: iconst_0
    //   528: ireturn
    //   529: aload 4
    //   531: aload_2
    //   532: ldc -107
    //   534: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   537: dup
    //   538: invokestatic 869	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   541: ifnull +6 -> 547
    //   544: goto +7 -> 551
    //   547: ldc_w 851
    //   550: ireturn
    //   551: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   554: aload 4
    //   556: aload_3
    //   557: dup
    //   558: instanceof 29
    //   561: ifne +7 -> 568
    //   564: ldc_w 866
    //   567: ireturn
    //   568: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   571: aload 4
    //   573: aload_1
    //   574: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   577: aload 4
    //   579: iconst_2
    //   580: putfield 842	gnu/mapping/CallContext:pc	I
    //   583: iconst_0
    //   584: ireturn
    //   585: aload_0
    //   586: aload_1
    //   587: aload_2
    //   588: aload_3
    //   589: aload 4
    //   591: invokespecial 873	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   594: ireturn
    // Line number table:
    //   Java source line #322	-> byte code offset #88
    //   Java source line #304	-> byte code offset #134
    //   Java source line #295	-> byte code offset #191
    //   Java source line #272	-> byte code offset #247
    //   Java source line #173	-> byte code offset #303
    //   Java source line #167	-> byte code offset #349
    //   Java source line #142	-> byte code offset #415
    //   Java source line #134	-> byte code offset #472
    //   Java source line #125	-> byte code offset #529
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 838	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+156->160, 74:+92->96, 88:+28->32
    //   32: aload 5
    //   34: aload_2
    //   35: ldc_w 267
    //   38: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   41: dup
    //   42: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   45: ifnull +6 -> 51
    //   48: goto +7 -> 55
    //   51: ldc_w 851
    //   54: ireturn
    //   55: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   58: aload 5
    //   60: aload_3
    //   61: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   64: aload 5
    //   66: aload 4
    //   68: dup
    //   69: instanceof 29
    //   72: ifne +7 -> 79
    //   75: ldc_w 874
    //   78: ireturn
    //   79: putfield 877	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   82: aload 5
    //   84: aload_1
    //   85: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   88: aload 5
    //   90: iconst_3
    //   91: putfield 842	gnu/mapping/CallContext:pc	I
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 5
    //   98: aload_2
    //   99: ldc_w 267
    //   102: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   105: dup
    //   106: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   109: ifnull +6 -> 115
    //   112: goto +7 -> 119
    //   115: ldc_w 851
    //   118: ireturn
    //   119: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   122: aload 5
    //   124: aload_3
    //   125: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   128: aload 5
    //   130: aload 4
    //   132: dup
    //   133: instanceof 29
    //   136: ifne +7 -> 143
    //   139: ldc_w 874
    //   142: ireturn
    //   143: putfield 877	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   146: aload 5
    //   148: aload_1
    //   149: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   152: aload 5
    //   154: iconst_3
    //   155: putfield 842	gnu/mapping/CallContext:pc	I
    //   158: iconst_0
    //   159: ireturn
    //   160: aload_0
    //   161: aload_1
    //   162: aload_2
    //   163: aload_3
    //   164: aload 4
    //   166: aload 5
    //   168: invokespecial 881	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   171: ireturn
    // Line number table:
    //   Java source line #287	-> byte code offset #32
    //   Java source line #151	-> byte code offset #96
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 838	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 91
    //   6: if_icmpne +106 -> 112
    //   9: goto +3 -> 12
    //   12: aload 6
    //   14: aload_2
    //   15: ldc_w 267
    //   18: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   21: dup
    //   22: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   25: ifnull +6 -> 31
    //   28: goto +7 -> 35
    //   31: ldc_w 851
    //   34: ireturn
    //   35: putfield 850	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   38: aload 6
    //   40: aload_3
    //   41: ldc_w 267
    //   44: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   47: dup
    //   48: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   51: ifnull +6 -> 57
    //   54: goto +7 -> 61
    //   57: ldc_w 866
    //   60: ireturn
    //   61: putfield 865	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   64: aload 6
    //   66: aload 4
    //   68: ldc_w 267
    //   71: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   74: dup
    //   75: invokestatic 862	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   78: ifnull +6 -> 84
    //   81: goto +7 -> 88
    //   84: ldc_w 874
    //   87: ireturn
    //   88: putfield 877	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   91: aload 6
    //   93: aload 5
    //   95: putfield 884	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   98: aload 6
    //   100: aload_1
    //   101: putfield 839	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   104: aload 6
    //   106: iconst_4
    //   107: putfield 842	gnu/mapping/CallContext:pc	I
    //   110: iconst_0
    //   111: ireturn
    //   112: aload_0
    //   113: aload_1
    //   114: aload_2
    //   115: aload_3
    //   116: aload 4
    //   118: aload 5
    //   120: aload 6
    //   122: invokespecial 888	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   125: ireturn
    // Line number table:
    //   Java source line #313	-> byte code offset #12
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
    //   1: getfield 838	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+243->247, 71:+84->88, 72:+101->105, 73:+119->123, 77:+137->141, 79:+161->165, 85:+176->180, 89:+193->197, 90:+210->214, 93:+228->232
    //   88: aload_2
    //   89: ldc -107
    //   91: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   94: invokestatic 153	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   97: aload_3
    //   98: checkcast 29	gnu/kawa/slib/Stream
    //   101: invokestatic 968	gnu/kawa/slib/StreamsDerived:streamDrop	(Lgnu/math/IntNum;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
    //   104: areturn
    //   105: aload_2
    //   106: ldc_w 267
    //   109: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   112: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   115: aload_3
    //   116: checkcast 29	gnu/kawa/slib/Stream
    //   119: invokestatic 977	gnu/kawa/slib/StreamsDerived:streamDropWhile	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
    //   122: areturn
    //   123: aload_2
    //   124: ldc_w 267
    //   127: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   130: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   133: aload_3
    //   134: checkcast 29	gnu/kawa/slib/Stream
    //   137: invokestatic 982	gnu/kawa/slib/StreamsDerived:streamFilter	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
    //   140: areturn
    //   141: aload_2
    //   142: ldc_w 357
    //   145: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   148: invokestatic 361	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   151: aload_3
    //   152: ldc_w 357
    //   155: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   158: invokestatic 361	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   161: invokestatic 317	gnu/kawa/slib/StreamsDerived:streamFrom	(Lgnu/math/Numeric;Lgnu/math/Numeric;)Lgnu/kawa/slib/Stream;
    //   164: areturn
    //   165: aload_2
    //   166: ldc_w 267
    //   169: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   175: aload_3
    //   176: invokestatic 988	gnu/kawa/slib/StreamsDerived:streamIterate	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
    //   179: areturn
    //   180: aload_2
    //   181: checkcast 29	gnu/kawa/slib/Stream
    //   184: aload_3
    //   185: ldc -107
    //   187: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   190: invokestatic 153	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   193: invokestatic 993	gnu/kawa/slib/StreamsDerived:streamRef	(Lgnu/kawa/slib/Stream;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   196: areturn
    //   197: aload_2
    //   198: ldc -107
    //   200: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   203: invokestatic 153	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   206: aload_3
    //   207: checkcast 29	gnu/kawa/slib/Stream
    //   210: invokestatic 998	gnu/kawa/slib/StreamsDerived:streamTake	(Lgnu/math/IntNum;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
    //   213: areturn
    //   214: aload_2
    //   215: ldc_w 267
    //   218: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   221: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   224: aload_3
    //   225: checkcast 29	gnu/kawa/slib/Stream
    //   228: invokestatic 1003	gnu/kawa/slib/StreamsDerived:streamTakeWhile	(Lgnu/mapping/Procedure;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
    //   231: areturn
    //   232: aload_2
    //   233: ldc_w 267
    //   236: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   239: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   242: aload_3
    //   243: invokestatic 1008	gnu/kawa/slib/StreamsDerived:streamUnfolds	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: areturn
    //   247: aload_0
    //   248: aload_1
    //   249: aload_2
    //   250: aload_3
    //   251: invokespecial 1011	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: areturn
    //   255: new 78	gnu/mapping/WrongType
    //   258: dup_x1
    //   259: swap
    //   260: ldc_w 964
    //   263: iconst_1
    //   264: aload_2
    //   265: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   268: athrow
    //   269: new 78	gnu/mapping/WrongType
    //   272: dup_x1
    //   273: swap
    //   274: ldc_w 964
    //   277: iconst_2
    //   278: aload_3
    //   279: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   282: athrow
    //   283: new 78	gnu/mapping/WrongType
    //   286: dup_x1
    //   287: swap
    //   288: ldc_w 973
    //   291: iconst_1
    //   292: aload_2
    //   293: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: new 78	gnu/mapping/WrongType
    //   300: dup_x1
    //   301: swap
    //   302: ldc_w 973
    //   305: iconst_2
    //   306: aload_3
    //   307: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   310: athrow
    //   311: new 78	gnu/mapping/WrongType
    //   314: dup_x1
    //   315: swap
    //   316: ldc_w 979
    //   319: iconst_1
    //   320: aload_2
    //   321: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   324: athrow
    //   325: new 78	gnu/mapping/WrongType
    //   328: dup_x1
    //   329: swap
    //   330: ldc_w 979
    //   333: iconst_2
    //   334: aload_3
    //   335: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   338: athrow
    //   339: new 78	gnu/mapping/WrongType
    //   342: dup_x1
    //   343: swap
    //   344: ldc_w 936
    //   347: iconst_1
    //   348: aload_2
    //   349: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   352: athrow
    //   353: new 78	gnu/mapping/WrongType
    //   356: dup_x1
    //   357: swap
    //   358: ldc_w 936
    //   361: iconst_2
    //   362: aload_3
    //   363: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //   367: new 78	gnu/mapping/WrongType
    //   370: dup_x1
    //   371: swap
    //   372: ldc_w 984
    //   375: iconst_1
    //   376: aload_2
    //   377: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 78	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc_w 990
    //   389: iconst_1
    //   390: aload_2
    //   391: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: new 78	gnu/mapping/WrongType
    //   398: dup_x1
    //   399: swap
    //   400: ldc_w 990
    //   403: iconst_2
    //   404: aload_3
    //   405: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   408: athrow
    //   409: new 78	gnu/mapping/WrongType
    //   412: dup_x1
    //   413: swap
    //   414: ldc_w 995
    //   417: iconst_1
    //   418: aload_2
    //   419: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   422: athrow
    //   423: new 78	gnu/mapping/WrongType
    //   426: dup_x1
    //   427: swap
    //   428: ldc_w 995
    //   431: iconst_2
    //   432: aload_3
    //   433: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   436: athrow
    //   437: new 78	gnu/mapping/WrongType
    //   440: dup_x1
    //   441: swap
    //   442: ldc_w 1000
    //   445: iconst_1
    //   446: aload_2
    //   447: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   450: athrow
    //   451: new 78	gnu/mapping/WrongType
    //   454: dup_x1
    //   455: swap
    //   456: ldc_w 1000
    //   459: iconst_2
    //   460: aload_3
    //   461: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   464: athrow
    //   465: new 78	gnu/mapping/WrongType
    //   468: dup_x1
    //   469: swap
    //   470: ldc_w 1005
    //   473: iconst_1
    //   474: aload_2
    //   475: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   478: athrow
    // Line number table:
    //   Java source line #125	-> byte code offset #88
    //   Java source line #134	-> byte code offset #105
    //   Java source line #142	-> byte code offset #123
    //   Java source line #167	-> byte code offset #141
    //   Java source line #173	-> byte code offset #165
    //   Java source line #272	-> byte code offset #180
    //   Java source line #295	-> byte code offset #197
    //   Java source line #304	-> byte code offset #214
    //   Java source line #322	-> byte code offset #232
    //   Java source line #125	-> byte code offset #255
    //   Java source line #134	-> byte code offset #283
    //   Java source line #142	-> byte code offset #311
    //   Java source line #167	-> byte code offset #339
    //   Java source line #173	-> byte code offset #367
    //   Java source line #272	-> byte code offset #381
    //   Java source line #295	-> byte code offset #409
    //   Java source line #304	-> byte code offset #437
    //   Java source line #322	-> byte code offset #465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	StreamsDerived
    //   0	479	1	paramModuleMethod	ModuleMethod
    //   0	479	2	paramObject1	Object
    //   0	479	3	paramObject2	Object
    //   255	1	4	localClassCastException1	ClassCastException
    //   269	1	5	localClassCastException2	ClassCastException
    //   283	1	6	localClassCastException3	ClassCastException
    //   297	1	7	localClassCastException4	ClassCastException
    //   311	1	8	localClassCastException5	ClassCastException
    //   325	1	9	localClassCastException6	ClassCastException
    //   339	1	10	localClassCastException7	ClassCastException
    //   353	1	11	localClassCastException8	ClassCastException
    //   367	1	12	localClassCastException9	ClassCastException
    //   381	1	13	localClassCastException10	ClassCastException
    //   395	1	14	localClassCastException11	ClassCastException
    //   409	1	15	localClassCastException12	ClassCastException
    //   423	1	16	localClassCastException13	ClassCastException
    //   437	1	17	localClassCastException14	ClassCastException
    //   451	1	18	localClassCastException15	ClassCastException
    //   465	1	19	localClassCastException16	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   94	97	255	java/lang/ClassCastException
    //   98	101	269	java/lang/ClassCastException
    //   112	115	283	java/lang/ClassCastException
    //   116	119	297	java/lang/ClassCastException
    //   130	133	311	java/lang/ClassCastException
    //   134	137	325	java/lang/ClassCastException
    //   148	151	339	java/lang/ClassCastException
    //   158	161	353	java/lang/ClassCastException
    //   172	175	367	java/lang/ClassCastException
    //   181	184	381	java/lang/ClassCastException
    //   190	193	395	java/lang/ClassCastException
    //   203	206	409	java/lang/ClassCastException
    //   207	210	423	java/lang/ClassCastException
    //   221	224	437	java/lang/ClassCastException
    //   225	228	451	java/lang/ClassCastException
    //   239	242	465	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 838	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+68->72, 74:+28->32, 88:+48->52
    //   32: aload_2
    //   33: ldc_w 267
    //   36: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   42: aload_3
    //   43: aload 4
    //   45: checkcast 29	gnu/kawa/slib/Stream
    //   48: invokestatic 1017	gnu/kawa/slib/StreamsDerived:streamFold	(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/Stream;)Ljava/lang/Object;
    //   51: areturn
    //   52: aload_2
    //   53: ldc_w 267
    //   56: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   59: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   62: aload_3
    //   63: aload 4
    //   65: checkcast 29	gnu/kawa/slib/Stream
    //   68: invokestatic 1023	gnu/kawa/slib/StreamsDerived:streamScan	(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
    //   71: areturn
    //   72: aload_0
    //   73: aload_1
    //   74: aload_2
    //   75: aload_3
    //   76: aload 4
    //   78: invokespecial 1027	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: areturn
    //   82: new 78	gnu/mapping/WrongType
    //   85: dup_x1
    //   86: swap
    //   87: ldc_w 1013
    //   90: iconst_1
    //   91: aload_2
    //   92: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   95: athrow
    //   96: new 78	gnu/mapping/WrongType
    //   99: dup_x1
    //   100: swap
    //   101: ldc_w 1013
    //   104: iconst_3
    //   105: aload 4
    //   107: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    //   111: new 78	gnu/mapping/WrongType
    //   114: dup_x1
    //   115: swap
    //   116: ldc_w 1019
    //   119: iconst_1
    //   120: aload_2
    //   121: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   124: athrow
    //   125: new 78	gnu/mapping/WrongType
    //   128: dup_x1
    //   129: swap
    //   130: ldc_w 1019
    //   133: iconst_3
    //   134: aload 4
    //   136: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   139: athrow
    // Line number table:
    //   Java source line #151	-> byte code offset #32
    //   Java source line #287	-> byte code offset #52
    //   Java source line #151	-> byte code offset #82
    //   Java source line #287	-> byte code offset #111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	StreamsDerived
    //   0	140	1	paramModuleMethod	ModuleMethod
    //   0	140	2	paramObject1	Object
    //   0	140	3	paramObject2	Object
    //   0	140	4	paramObject3	Object
    //   82	1	5	localClassCastException1	ClassCastException
    //   96	1	6	localClassCastException2	ClassCastException
    //   111	1	7	localClassCastException3	ClassCastException
    //   125	1	8	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   39	42	82	java/lang/ClassCastException
    //   45	48	96	java/lang/ClassCastException
    //   59	62	111	java/lang/ClassCastException
    //   65	68	125	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 838	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 91
    //   6: if_icmpne +43 -> 49
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: ldc_w 267
    //   16: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   22: aload_3
    //   23: ldc_w 267
    //   26: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   32: aload 4
    //   34: ldc_w 267
    //   37: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   43: aload 5
    //   45: invokestatic 1033	gnu/kawa/slib/StreamsDerived:streamUnfold	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
    //   48: areturn
    //   49: aload_0
    //   50: aload_1
    //   51: aload_2
    //   52: aload_3
    //   53: aload 4
    //   55: aload 5
    //   57: invokespecial 1037	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   60: areturn
    //   61: new 78	gnu/mapping/WrongType
    //   64: dup_x1
    //   65: swap
    //   66: ldc_w 1029
    //   69: iconst_1
    //   70: aload_2
    //   71: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   74: athrow
    //   75: new 78	gnu/mapping/WrongType
    //   78: dup_x1
    //   79: swap
    //   80: ldc_w 1029
    //   83: iconst_2
    //   84: aload_3
    //   85: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    //   89: new 78	gnu/mapping/WrongType
    //   92: dup_x1
    //   93: swap
    //   94: ldc_w 1029
    //   97: iconst_3
    //   98: aload 4
    //   100: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   103: athrow
    // Line number table:
    //   Java source line #313	-> byte code offset #12
    //   Java source line #314	-> byte code offset #89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	StreamsDerived
    //   0	104	1	paramModuleMethod	ModuleMethod
    //   0	104	2	paramObject1	Object
    //   0	104	3	paramObject2	Object
    //   0	104	4	paramObject3	Object
    //   0	104	5	paramObject4	Object
    //   61	1	6	localClassCastException1	ClassCastException
    //   75	1	7	localClassCastException2	ClassCastException
    //   89	1	8	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	61	java/lang/ClassCastException
    //   29	32	75	java/lang/ClassCastException
    //   40	43	89	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 838	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+253->257, 66:+76->80, 68:+81->85, 70:+86->90, 76:+91->95, 82:+136->140, 84:+181->185, 92:+240->244, 95:+248->252
    //   80: aload_2
    //   81: invokestatic 1041	gnu/kawa/slib/StreamsDerived:stream$To$List$V	([Ljava/lang/Object;)Lgnu/lists/LList;
    //   84: areturn
    //   85: aload_2
    //   86: invokestatic 1045	gnu/kawa/slib/StreamsDerived:streamAppend$V	([Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
    //   89: areturn
    //   90: aload_2
    //   91: invokestatic 1049	gnu/kawa/slib/StreamsDerived:streamConstant$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   94: areturn
    //   95: aload_2
    //   96: iconst_0
    //   97: aaload
    //   98: ldc_w 267
    //   101: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   104: dup
    //   105: astore_3
    //   106: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   109: aload_2
    //   110: arraylength
    //   111: iconst_1
    //   112: isub
    //   113: istore_3
    //   114: iload_3
    //   115: anewarray 107	java/lang/Object
    //   118: goto +11 -> 129
    //   121: dup
    //   122: iload_3
    //   123: aload_2
    //   124: iload_3
    //   125: iconst_1
    //   126: iadd
    //   127: aaload
    //   128: aastore
    //   129: iinc 3 -1
    //   132: iload_3
    //   133: ifge -12 -> 121
    //   136: invokestatic 1055	gnu/kawa/slib/StreamsDerived:streamForEach$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   139: areturn
    //   140: aload_2
    //   141: iconst_0
    //   142: aaload
    //   143: ldc_w 267
    //   146: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   149: dup
    //   150: astore_3
    //   151: invokestatic 971	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   154: aload_2
    //   155: arraylength
    //   156: iconst_1
    //   157: isub
    //   158: istore_3
    //   159: iload_3
    //   160: anewarray 107	java/lang/Object
    //   163: goto +11 -> 174
    //   166: dup
    //   167: iload_3
    //   168: aload_2
    //   169: iload_3
    //   170: iconst_1
    //   171: iadd
    //   172: aaload
    //   173: aastore
    //   174: iinc 3 -1
    //   177: iload_3
    //   178: ifge -12 -> 166
    //   181: invokestatic 1061	gnu/kawa/slib/StreamsDerived:streamMap$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
    //   184: areturn
    //   185: aload_2
    //   186: iconst_0
    //   187: aaload
    //   188: ldc_w 357
    //   191: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   194: dup
    //   195: astore_3
    //   196: invokestatic 361	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   199: aload_2
    //   200: iconst_1
    //   201: aaload
    //   202: ldc_w 357
    //   205: invokestatic 133	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: dup
    //   209: astore_3
    //   210: invokestatic 361	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   213: aload_2
    //   214: arraylength
    //   215: iconst_2
    //   216: isub
    //   217: istore_3
    //   218: iload_3
    //   219: anewarray 107	java/lang/Object
    //   222: goto +11 -> 233
    //   225: dup
    //   226: iload_3
    //   227: aload_2
    //   228: iload_3
    //   229: iconst_2
    //   230: iadd
    //   231: aaload
    //   232: aastore
    //   233: iinc 3 -1
    //   236: iload_3
    //   237: ifge -12 -> 225
    //   240: invokestatic 1067	gnu/kawa/slib/StreamsDerived:streamRange$V	(Lgnu/math/Numeric;Lgnu/math/Numeric;[Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
    //   243: areturn
    //   244: aload_2
    //   245: invokestatic 1071	gnu/kawa/slib/StreamsDerived$frame33:lambda75$V	([Ljava/lang/Object;)I
    //   248: invokestatic 1077	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: areturn
    //   252: aload_2
    //   253: invokestatic 1080	gnu/kawa/slib/StreamsDerived:streamZip$V	([Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
    //   256: areturn
    //   257: aload_0
    //   258: aload_1
    //   259: aload_2
    //   260: invokespecial 1084	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   263: areturn
    //   264: new 78	gnu/mapping/WrongType
    //   267: dup_x1
    //   268: swap
    //   269: ldc_w 1051
    //   272: iconst_1
    //   273: aload_3
    //   274: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   277: athrow
    //   278: new 78	gnu/mapping/WrongType
    //   281: dup_x1
    //   282: swap
    //   283: ldc_w 1057
    //   286: iconst_1
    //   287: aload_3
    //   288: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   291: athrow
    //   292: new 78	gnu/mapping/WrongType
    //   295: dup_x1
    //   296: swap
    //   297: ldc_w 1063
    //   300: iconst_1
    //   301: aload_3
    //   302: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   305: athrow
    //   306: new 78	gnu/mapping/WrongType
    //   309: dup_x1
    //   310: swap
    //   311: ldc_w 1063
    //   314: iconst_2
    //   315: aload_3
    //   316: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   319: athrow
    // Line number table:
    //   Java source line #81	-> byte code offset #80
    //   Java source line #92	-> byte code offset #85
    //   Java source line #119	-> byte code offset #90
    //   Java source line #157	-> byte code offset #95
    //   Java source line #190	-> byte code offset #140
    //   Java source line #261	-> byte code offset #185
    //   Java source line #326	-> byte code offset #244
    //   Java source line #351	-> byte code offset #252
    //   Java source line #157	-> byte code offset #264
    //   Java source line #190	-> byte code offset #278
    //   Java source line #261	-> byte code offset #292
    // Exception table:
    //   from	to	target	type
    //   106	109	264	java/lang/ClassCastException
    //   151	154	278	java/lang/ClassCastException
    //   196	199	292	java/lang/ClassCastException
    //   210	213	306	java/lang/ClassCastException
  }
}
