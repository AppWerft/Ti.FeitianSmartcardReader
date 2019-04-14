package kawa.lib; import gnu.expr.ModuleMethod;

public class strings extends gnu.expr.ModuleBody { public static final ModuleMethod string$Qu; public static final ModuleMethod make$Mnstring; public static final ModuleMethod $make$string$; public static final ModuleMethod string$Mnlength; public static final ModuleMethod string$Mnref; public static final ModuleMethod string$Mnset$Ex; public static final ModuleMethod char$Eq$Qu; public static final ModuleMethod char$Ls$Qu; public static final ModuleMethod char$Gr$Qu; public static final ModuleMethod char$Ls$Eq$Qu; public static final ModuleMethod char$Gr$Eq$Qu; public static final ModuleMethod char$Mnci$Eq$Qu; public static final ModuleMethod char$Mnci$Ls$Qu; public static final ModuleMethod char$Mnci$Gr$Qu; public static final ModuleMethod char$Mnci$Ls$Eq$Qu; public static final ModuleMethod char$Mnci$Gr$Eq$Qu; public static final ModuleMethod string$Eq$Qu; public static final ModuleMethod string$Ls$Qu; public static final ModuleMethod string$Gr$Qu; public static final ModuleMethod string$Ls$Eq$Qu; public static final ModuleMethod string$Gr$Eq$Qu; public static final ModuleMethod string$Mnci$Eq$Qu; public static final ModuleMethod string$Mnci$Ls$Qu; public static final ModuleMethod string$Mnci$Gr$Qu; public static final ModuleMethod string$Mnci$Ls$Eq$Qu; public static final ModuleMethod string$Mnci$Gr$Eq$Qu; public static final ModuleMethod substring; public static final ModuleMethod string$Mn$Grlist; public static final ModuleMethod list$Mn$Grstring; public static final ModuleMethod string$Mncopy; public static final ModuleMethod string$Mncopy$Ex; public static final ModuleMethod string$Mnfill$Ex; public static final ModuleMethod string$Mnupcase$Ex; public static final ModuleMethod string$Mndowncase$Ex; public static final ModuleMethod string$Mncapitalize; public static final ModuleMethod string$Mncapitalize$Ex; public static final ModuleMethod string$Mnappend; public static final ModuleMethod string$Mnappend$Ex; public static final ModuleMethod string$Mnreplace$Ex; public static final ModuleMethod string$Mnmap; public static final ModuleMethod string$Mnfor$Mneach; public static final ModuleMethod srfi$Mn13$Mnstring$Mnfor$Mneach; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$define; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$cond; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$and; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$or; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$let; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$let$St; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$else; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$length; public static gnu.mapping.Location $Prvt$prev; public static strings $instance; static final gnu.mapping.SimpleSymbol Lit0; static final gnu.mapping.SimpleSymbol Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  static final gnu.mapping.SimpleSymbol Lit6;
  static final gnu.mapping.SimpleSymbol Lit7;
  static final gnu.mapping.SimpleSymbol Lit8;
  static final gnu.mapping.SimpleSymbol Lit9;
  static final gnu.mapping.SimpleSymbol Lit10;
  static final gnu.mapping.SimpleSymbol Lit11;
  static final gnu.mapping.SimpleSymbol Lit12;
  static final gnu.mapping.SimpleSymbol Lit13;
  static final gnu.mapping.SimpleSymbol Lit14;
  static final gnu.mapping.SimpleSymbol Lit15;
  static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final gnu.mapping.SimpleSymbol Lit19; static final gnu.mapping.SimpleSymbol Lit20; static final gnu.mapping.SimpleSymbol Lit21; static final gnu.mapping.SimpleSymbol Lit22; static final gnu.mapping.SimpleSymbol Lit23; static final gnu.mapping.SimpleSymbol Lit24; static final gnu.mapping.SimpleSymbol Lit25; static final gnu.mapping.SimpleSymbol Lit26; static final gnu.mapping.SimpleSymbol Lit27; static final gnu.mapping.SimpleSymbol Lit28; static final gnu.mapping.SimpleSymbol Lit29; static final gnu.mapping.SimpleSymbol Lit30; static final gnu.mapping.SimpleSymbol Lit31; static final gnu.mapping.SimpleSymbol Lit32; static final gnu.mapping.SimpleSymbol Lit33; static final gnu.mapping.SimpleSymbol Lit34; static final gnu.mapping.SimpleSymbol Lit35; static final gnu.mapping.SimpleSymbol Lit36; static final gnu.mapping.SimpleSymbol Lit37; static final gnu.mapping.SimpleSymbol Lit38; static final gnu.mapping.SimpleSymbol Lit39; static final gnu.mapping.SimpleSymbol Lit40; static final gnu.mapping.SimpleSymbol Lit41 = gnu.mapping.Symbol.valueOf("string-append!"); static { Lit40 = gnu.mapping.Symbol.valueOf("string-map");Lit39 = gnu.mapping.Symbol.valueOf("string-for-each");Lit38 = gnu.mapping.Symbol.valueOf("srfi-13-string-for-each");Lit37 = gnu.mapping.Symbol.valueOf("char-ci>=?");Lit36 = gnu.mapping.Symbol.valueOf("char-ci<=?");Lit35 = gnu.mapping.Symbol.valueOf("char-ci>?");Lit34 = gnu.mapping.Symbol.valueOf("char-ci<?");Lit33 = gnu.mapping.Symbol.valueOf("char-ci=?");Lit32 = gnu.mapping.Symbol.valueOf("char>=?");Lit31 = gnu.mapping.Symbol.valueOf("char<=?");Lit30 = gnu.mapping.Symbol.valueOf("char>?");Lit29 = gnu.mapping.Symbol.valueOf("char<?");Lit28 = gnu.mapping.Symbol.valueOf("char=?");Lit27 = gnu.mapping.Symbol.valueOf("string-ci>=?");Lit26 = gnu.mapping.Symbol.valueOf("string-ci<=?");Lit25 = gnu.mapping.Symbol.valueOf("string-ci>?");Lit24 = gnu.mapping.Symbol.valueOf("string-ci=?");Lit23 = gnu.mapping.Symbol.valueOf("string-ci<?");Lit22 = gnu.mapping.Symbol.valueOf("string-append");Lit21 = gnu.mapping.Symbol.valueOf("string-capitalize");Lit20 = gnu.mapping.Symbol.valueOf("string-capitalize!");Lit19 = gnu.mapping.Symbol.valueOf("string-downcase!");Lit18 = gnu.mapping.Symbol.valueOf("string-upcase!");Lit17 = gnu.mapping.Symbol.valueOf("string-fill!");Lit16 = gnu.mapping.Symbol.valueOf("string-replace!");Lit15 = gnu.mapping.Symbol.valueOf("string-copy!");Lit14 = gnu.mapping.Symbol.valueOf("string-copy");Lit13 = gnu.mapping.Symbol.valueOf("list->string");Lit12 = gnu.mapping.Symbol.valueOf("string->list");Lit11 = gnu.mapping.Symbol.valueOf("substring");Lit10 = gnu.mapping.Symbol.valueOf("string>=?");Lit9 = gnu.mapping.Symbol.valueOf("string<=?");Lit8 = gnu.mapping.Symbol.valueOf("string>?");Lit7 = gnu.mapping.Symbol.valueOf("string=?");Lit6 = gnu.mapping.Symbol.valueOf("string<?");Lit5 = gnu.mapping.Symbol.valueOf("string-set!");Lit4 = gnu.mapping.Symbol.valueOf("string-ref");Lit3 = gnu.mapping.Symbol.valueOf("string-length");Lit2 = gnu.mapping.Symbol.valueOf("$make$string$");Lit1 = gnu.mapping.Symbol.valueOf("make-string");Lit0 = gnu.mapping.Symbol.valueOf("string?");$instance = new strings();$Prvt$define = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
    $Prvt$cond = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "cond");$Prvt$and = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "and");$Prvt$or = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "or");$Prvt$let = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "let");$Prvt$let$St = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");$Prvt$else = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "else");
    
    $Prvt$length = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.lists", "length");strings localStrings = $instance;string$Qu = new ModuleMethod(localStrings, 1, Lit0, 4097);make$Mnstring = new ModuleMethod(localStrings, 2, Lit1, 8193);$make$string$ = new ModuleMethod(localStrings, 4, Lit2, 61440);string$Mnlength = new ModuleMethod(localStrings, 5, Lit3, 4097);string$Mnref = new ModuleMethod(localStrings, 6, Lit4, 8194);string$Mnset$Ex = new ModuleMethod(localStrings, 7, Lit5, 12291);string$Ls$Qu = new ModuleMethod(localStrings, 8, Lit6, 61442);string$Eq$Qu = new ModuleMethod(localStrings, 9, Lit7, 61442);string$Gr$Qu = new ModuleMethod(localStrings, 10, Lit8, 61442);string$Ls$Eq$Qu = new ModuleMethod(localStrings, 11, Lit9, 61442);string$Gr$Eq$Qu = new ModuleMethod(localStrings, 12, Lit10, 61442);substring = new ModuleMethod(localStrings, 13, Lit11, 12291);string$Mn$Grlist = new ModuleMethod(localStrings, 14, Lit12, 12289);list$Mn$Grstring = new ModuleMethod(localStrings, 17, Lit13, 4097);string$Mncopy = new ModuleMethod(localStrings, 18, Lit14, 12289);string$Mncopy$Ex = new ModuleMethod(localStrings, 21, Lit15, 20483);string$Mnreplace$Ex = new ModuleMethod(localStrings, 24, Lit16, 24580);string$Mnfill$Ex = new ModuleMethod(localStrings, 27, Lit17, 16386);string$Mnupcase$Ex = new ModuleMethod(localStrings, 30, Lit18, 4097);string$Mndowncase$Ex = new ModuleMethod(localStrings, 31, Lit19, 4097);string$Mncapitalize$Ex = new ModuleMethod(localStrings, 32, Lit20, 4097);string$Mncapitalize = new ModuleMethod(localStrings, 33, Lit21, 4097);string$Mnappend = new ModuleMethod(localStrings, 34, Lit22, 61440);string$Mnci$Ls$Qu = new ModuleMethod(localStrings, 35, Lit23, 61442);string$Mnci$Eq$Qu = new ModuleMethod(localStrings, 36, Lit24, 61442);string$Mnci$Gr$Qu = new ModuleMethod(localStrings, 37, Lit25, 61442);string$Mnci$Ls$Eq$Qu = new ModuleMethod(localStrings, 38, Lit26, 61442);string$Mnci$Gr$Eq$Qu = new ModuleMethod(localStrings, 39, Lit27, 61442); void tmp1030_1027 = new ModuleMethod(localStrings, 40, Lit28, 61442);tmp1030_1027.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Eq$Qu = tmp1030_1027; void tmp1059_1056 = new ModuleMethod(localStrings, 41, Lit29, 61442);tmp1059_1056.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Ls$Qu = tmp1059_1056; void tmp1088_1085 = new ModuleMethod(localStrings, 42, Lit30, 61442);tmp1088_1085.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Gr$Qu = tmp1088_1085; void tmp1117_1114 = new ModuleMethod(localStrings, 43, Lit31, 61442);tmp1117_1114.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Ls$Eq$Qu = tmp1117_1114; void tmp1146_1143 = new ModuleMethod(localStrings, 44, Lit32, 61442);tmp1146_1143.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Gr$Eq$Qu = tmp1146_1143; void tmp1175_1172 = new ModuleMethod(localStrings, 45, Lit33, 61442);tmp1175_1172.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Mnci$Eq$Qu = tmp1175_1172; void tmp1204_1201 = new ModuleMethod(localStrings, 46, Lit34, 61442);tmp1204_1201.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Mnci$Ls$Qu = tmp1204_1201; void tmp1233_1230 = new ModuleMethod(localStrings, 47, Lit35, 61442);tmp1233_1230.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Mnci$Gr$Qu = tmp1233_1230; void tmp1262_1259 = new ModuleMethod(localStrings, 48, Lit36, 61442);tmp1262_1259.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Mnci$Ls$Eq$Qu = tmp1262_1259; void tmp1291_1288 = new ModuleMethod(localStrings, 49, Lit37, 61442);tmp1291_1288.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");char$Mnci$Gr$Eq$Qu = tmp1291_1288; void tmp1320_1317 = new ModuleMethod(localStrings, 50, Lit38, 16386);tmp1320_1317.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_map:stringForEach1ValidateApply");srfi$Mn13$Mnstring$Mnfor$Mneach = tmp1320_1317; void tmp1349_1346 = new ModuleMethod(localStrings, 53, Lit39, 61442);tmp1349_1346.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_map:stringForEachValidateApply");string$Mnfor$Mneach = tmp1349_1346;string$Mnmap = new ModuleMethod(localStrings, 54, Lit40, 61442); void tmp1397_1394 = new ModuleMethod(localStrings, 55, Lit41, 61441);tmp1397_1394.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:stringAppendToValidateApply");string$Mnappend$Ex = tmp1397_1394;$runBody$();
  }
  



























  public static boolean isString(Object x)
  {
    return x instanceof CharSequence;
  }
  
  @kawa.SourceMethodType({"", "", "character"})
  public static gnu.lists.FString makeString(int n, int ch) { return new gnu.lists.FString(n, ch); }
  

























































































































































































































































  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 55:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 54: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 53: 
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
    case 38: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 37: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 36: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 35: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 34: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 24: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 21: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 12: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 11: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 10: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 9: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 8: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 4: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); }
  public static CharSequence $make$string$(Object... args) { int n = args.length;
    gnu.lists.FString str = gnu.lists.FString.alloc(n);
    for (int i = 0; i < n; 
        

        i++) { str.appendCharacter(((gnu.text.Char)gnu.mapping.Promise.force(args[i], gnu.text.Char.class)).intValue());
    }
    return str;
  }
  
  public static int stringLength(CharSequence str)
  {
    return gnu.lists.Strings.sizeInCodePoints(str);
  }
  
  @kawa.SourceMethodType({"character"})
  public static int stringRef(CharSequence str, int k) {
    return Character.codePointAt(str, Character.offsetByCodePoints(str, 0, k));
  }
  
  @kawa.SourceMethodType({"", "", "", "character"})
  public static void stringSet$Ex(gnu.lists.CharSeq str, int k, int char)
  {
    str.setCharacterAt(Character.offsetByCodePoints(str, 0, k), char);
  }
  
  static int $PcStringCompare2(CharSequence str1, CharSequence str2) { return str1.toString().compareTo(str2.toString());
  }
  
  public static boolean isString$Ls(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    


















































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompare2(prev, next) >= 0) break;
      CharSequence prev = next;i++; } return $PcStringCompare2(str1, str2) < 0 ? false : 
    













































      x ? x : false;
  }
  
  public static boolean isString$Eq(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    



















































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompare2(prev, next) != 0) break;
      CharSequence prev = next;i++; } return $PcStringCompare2(str1, str2) == 0 ? false : 
    














































      x ? x : false;
  }
  
  public static boolean isString$Gr(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    




















































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompare2(prev, next) <= 0) break;
      CharSequence prev = next;i++; } return $PcStringCompare2(str1, str2) > 0 ? false : 
    















































      x ? x : false;
  }
  
  public static boolean isString$Ls$Eq(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    





















































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompare2(prev, next) > 0) break;
      CharSequence prev = next;i++; } return $PcStringCompare2(str1, str2) <= 0 ? false : 
    
















































      x ? x : false;
  }
  
  public static boolean isString$Gr$Eq(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    






















































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompare2(prev, next) < 0) break;
      CharSequence prev = next;i++; } return $PcStringCompare2(str1, str2) >= 0 ? false : 
    

















































      x ? x : false;
  }
  
  public static CharSequence substring(CharSequence str, int start, int end) {
    int istart = Character.offsetByCodePoints(str, 0, start); if (end < start) {
      throw new StringIndexOutOfBoundsException();
    }
    












































    int iend = end == -1 ? str.length() : Character.offsetByCodePoints(str, istart, end - start);
    return new gnu.lists.FString(str, istart, iend - istart);
  }
  

  public static gnu.lists.LList string$To$List(CharSequence str, int start, int end)
  {
    int cstart = Character.offsetByCodePoints(str, 0, start); if (end < start) {
      throw new StringIndexOutOfBoundsException();
    }
    



















































    int cend = end == -1 ? str.length() : Character.offsetByCodePoints(str, cstart, end - start);
    for (;;) {
      int i = cend;gnu.lists.LList result = gnu.lists.LList.Empty;
      
      int i;
      int prev = kawa.lib.kawa.string-cursors.stringCursorPrev(str, i);
      tmpTernaryOp = (kawa.lib.kawa.string-cursors.isStringCursor$Ls$Eq(i, start) ? result : prev; } return new gnu.lists.Pair(gnu.text.Char.make(kawa.lib.kawa.string-cursors.stringCursorRef(str, prev)), result);
  }
  
  public static CharSequence list$To$String(gnu.lists.LList lst) { int len = lst.size();
    gnu.lists.CharSeq result = new gnu.lists.FString(len);
    int i = 0; for (;;) { Object localObject; if (i < len)
      {
        localObject = lst; } try { pair = (gnu.lists.Pair)lst; } catch (ClassCastException localClassCastException1) { gnu.lists.Pair pair; throw new gnu.mapping.WrongType(localClassCastException1, "pair", -2, localObject); }
      try { stringSet$Ex(result, i, gnu.text.Char.castToCharacter(localObject = gnu.mapping.Promise.force(pair.getCar()))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "string-set!", 2, localObject); }
      try { lst = (gnu.lists.LList)(localObject = gnu.mapping.Promise.force(pair.getCdr(), gnu.lists.LList.class));i++; } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "lst", -2, localObject);
      }
    }
    return result;
  }
  





  public static gnu.lists.FString stringCopy(CharSequence str, int start, int end)
  {
    int istart = Character.offsetByCodePoints(str, 0, start); if (end < start) {
      throw new StringIndexOutOfBoundsException();
    }
    









































































    int iend = end == -1 ? str.length() : Character.offsetByCodePoints(str, istart, end - start);
    return new gnu.lists.FString(str, istart, iend - istart);
  }
  




  public static void stringCopy$Ex(gnu.lists.FString paramFString, int paramInt1, CharSequence paramCharSequence, int paramInt2) { stringCopy$Ex(paramFString, paramInt1, paramCharSequence, paramInt2, gnu.lists.Strings.sizeInCodePoints(paramCharSequence)); }
  
  public static void stringCopy$Ex(gnu.lists.FString to, int at, CharSequence from, int start, int end) { stringReplace$Ex(to, at, at + (end - start), from, start, end); }
  







  public static void stringReplace$Ex(gnu.lists.FString dst, int dstart, int dend, CharSequence src, int sstart, int send)
  {
    int csstart = Character.offsetByCodePoints(src, 0, sstart); if (send < sstart) {
      throw new StringIndexOutOfBoundsException();
    }
    






























































































    int csend = send == -1 ? src.length() : Character.offsetByCodePoints(src, csstart, send - sstart);
    
    int cdstart = Character.offsetByCodePoints(dst, 0, dstart); if (dend < dstart) {
      throw new StringIndexOutOfBoundsException();
    }
    
































































































    int cdend = dend == -1 ? dst.length() : Character.offsetByCodePoints(dst, cdstart, dend - dstart);
    dst.replace(src, csstart, csend, cdstart, cdend);
  }
  

  @kawa.SourceMethodType({"", "", "character"})
  public static void stringFill$Ex(gnu.lists.CharSeq str, int ch, int start, int end)
  {
    int cstart = Character.offsetByCodePoints(str, 0, start);
    int send = end >= 0 ? end : gnu.lists.Strings.sizeInCodePoints(str);
    gnu.lists.CharSeq localCharSeq = str; if ((localCharSeq instanceof gnu.lists.FString)) { gnu.lists.FString localFString = (gnu.lists.FString)localCharSeq;
      
      int cend = end < 0 ? localFString.length() : Character.offsetByCodePoints(str, 0, end);
      localFString.delete(cstart, cend);
      localFString.insertRepeated(cstart, ch, send - start);
    }
    else {
      int width = ch > 65535 ? 2 : 1;
      int i = cstart; int pos; for (int to$Mndo = send - start; to$Mndo > 0; 
          to$Mndo--)
      {
        str.setCharacterAt(pos, ch);pos += width;
      } } }
  
  public static CharSequence stringUpcase$Ex(gnu.lists.CharSeq str) { gnu.lists.Strings.makeUpperCase(str);
    return str;
  }
  
  public static CharSequence stringDowncase$Ex(gnu.lists.CharSeq str) { gnu.lists.Strings.makeLowerCase(str);
    return str;
  }
  
  public static CharSequence stringCapitalize$Ex(gnu.lists.CharSeq str) { gnu.lists.Strings.makeCapitalize(str);
    return str;
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isString(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    try {
      return makeString(((Number)gnu.mapping.Promise.force(paramObject)).intValue()); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      


























































































































        localClassCastException1, "make-string", 1, paramObject);
    }
    try
    {
      return Integer.valueOf(stringLength((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "string-length", 1, paramObject);
    }
    























    try
    {
      return string$To$List((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "string->list", 1, paramObject);
    }
    







    try
    {
      return list$To$String((gnu.lists.LList)gnu.mapping.Promise.force(paramObject, gnu.lists.LList.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "list->string", 1, paramObject);
    }
    




    try
    {
      return stringCopy((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "string-copy", 1, paramObject);
    }
    














































    try
    {
      return stringUpcase$Ex((gnu.lists.CharSeq)gnu.mapping.Promise.force(paramObject, gnu.lists.CharSeq.class)); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "string-upcase!", 1, paramObject);
    }
    try
    {
      return stringDowncase$Ex((gnu.lists.CharSeq)gnu.mapping.Promise.force(paramObject, gnu.lists.CharSeq.class)); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "string-downcase!", 1, paramObject);
    }
    try
    {
      return stringCapitalize$Ex((gnu.lists.CharSeq)gnu.mapping.Promise.force(paramObject, gnu.lists.CharSeq.class)); } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "string-capitalize!", 1, paramObject);
    }
    try
    {
      return stringCapitalize((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException9) { throw new gnu.mapping.WrongType(localClassCastException9, "string-capitalize", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static CharSequence stringCapitalize(CharSequence str) { gnu.lists.FString copy = stringCopy(str);
    gnu.lists.Strings.makeCapitalize(copy);
    return copy;
  }
  
  public static gnu.lists.FString stringAppend(Object... args) { gnu.lists.FString str = new gnu.lists.FString();
    str.addAllStrings(args, 0);
    return str;
  }
  


  static int $PcStringCompareCi2(CharSequence str1, CharSequence str2)
  {
    return gnu.kawa.functions.UnicodeUtils.foldCase(str1).toString().compareTo(gnu.kawa.functions.UnicodeUtils.foldCase(str2).toString());
  }
  
  public static boolean isStringCi$Ls(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    


































































































































































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompareCi2(prev, next) >= 0) break;
      CharSequence prev = next;i++; } return $PcStringCompareCi2(str1, str2) < 0 ? false : 
    





























































































































































      x ? x : false;
  }
  
  public static boolean isStringCi$Eq(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    



































































































































































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompareCi2(prev, next) != 0) break;
      CharSequence prev = next;i++; } return $PcStringCompareCi2(str1, str2) == 0 ? false : 
    






























































































































































      x ? x : false;
  }
  
  public static boolean isStringCi$Gr(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    




































































































































































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompareCi2(prev, next) <= 0) break;
      CharSequence prev = next;i++; } return $PcStringCompareCi2(str1, str2) > 0 ? false : 
    































































































































































      x ? x : false;
  }
  
  public static boolean isStringCi$Ls$Eq(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    





































































































































































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompareCi2(prev, next) > 0) break;
      CharSequence prev = next;i++; } return $PcStringCompareCi2(str1, str2) <= 0 ? false : 
    
































































































































































      x ? x : false;
  }
  
  public static boolean isStringCi$Gr$Eq(CharSequence str1, CharSequence str2, CharSequence... strs)
  {
    int n = strs.length;
    






































































































































































    CharSequence localCharSequence1 = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      CharSequence next = strs[i];
      if ($PcStringCompareCi2(prev, next) < 0) break;
      CharSequence prev = next;i++; } return $PcStringCompareCi2(str1, str2) >= 0 ? false : 
    

































































































































































      x ? x : false; }
  
  @kawa.SourceMethodType({"", "character", "character"})
  static int $PcCharCompare(int c1, int c2) { int i = characters.char$To$Integer(c1);int i2 = characters.char$To$Integer(c2);
    int i1; return i1 < i2 ? -1 : i1 > i2 ? 1 : 0;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isChar$Eq(int str1, int str2, int... strs)
  {
    int n = strs.length;
    












































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompare(prev, next) != 0) break;
      int prev = next;i++; } return $PcCharCompare(str1, str2) == 0 ? false : 
    







































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isChar$Ls(int str1, int str2, int... strs)
  {
    int n = strs.length;
    














































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompare(prev, next) >= 0) break;
      int prev = next;i++; } return $PcCharCompare(str1, str2) < 0 ? false : 
    









































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isChar$Gr(int str1, int str2, int... strs)
  {
    int n = strs.length;
    
















































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompare(prev, next) <= 0) break;
      int prev = next;i++; } return $PcCharCompare(str1, str2) > 0 ? false : 
    











































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isChar$Ls$Eq(int str1, int str2, int... strs)
  {
    int n = strs.length;
    


















































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompare(prev, next) > 0) break;
      int prev = next;i++; } return $PcCharCompare(str1, str2) <= 0 ? false : 
    













































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isChar$Gr$Eq(int str1, int str2, int... strs)
  {
    int n = strs.length;
    




















































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompare(prev, next) < 0) break;
      int prev = next;i++; } return $PcCharCompare(str1, str2) >= 0 ? false : 
    















































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character"})
  static int $PcCharCompareCi(int c1, int c2) {
    return Character.toUpperCase(characters.char$To$Integer(c1)) - Character.toUpperCase(characters.char$To$Integer(c2));
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isCharCi$Eq(int str1, int str2, int... strs)
  {
    int n = strs.length;
    



























































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompareCi(prev, next) != 0) break;
      int prev = next;i++; } return $PcCharCompareCi(str1, str2) == 0 ? false : 
    






















































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isCharCi$Ls(int str1, int str2, int... strs)
  {
    int n = strs.length;
    





























































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompareCi(prev, next) >= 0) break;
      int prev = next;i++; } return $PcCharCompareCi(str1, str2) < 0 ? false : 
    
























































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isCharCi$Gr(int str1, int str2, int... strs)
  {
    int n = strs.length;
    































































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompareCi(prev, next) <= 0) break;
      int prev = next;i++; } return $PcCharCompareCi(str1, str2) > 0 ? false : 
    


























































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isCharCi$Ls$Eq(int str1, int str2, int... strs)
  {
    int n = strs.length;
    

































































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompareCi(prev, next) > 0) break;
      int prev = next;i++; } return $PcCharCompareCi(str1, str2) <= 0 ? false : 
    




























































































































































































      x ? x : false;
  }
  
  @kawa.SourceMethodType({"", "character", "character", "character[]"})
  public static boolean isCharCi$Gr$Eq(int str1, int str2, int... strs)
  {
    int n = strs.length;
    



































































































































































































    int i = str2;int i = 0;
    for (;;)
    {
      boolean x = i == n;
      int next = strs[i];
      if ($PcCharCompareCi(prev, next) < 0) break;
      int prev = next;i++; } return $PcCharCompareCi(str1, str2) >= 0 ? false : 
    






























































































































































































      x ? x : false;
  }
  







  public static void srfi$Mn13StringForEach(Object proc, CharSequence str, int start, int end)
  {
    int cstart = kawa.lib.kawa.string-cursors.stringCursorNext(str, 0, start);
    

    int cend = end == -1 ? str.length() : kawa.lib.kawa.string-cursors.stringCursorNext(str, cstart, end - start);
    kawa.lib.kawa.string-cursors.stringCursorForEach(proc, str, cstart, cend);
  }
  
  public static void stringForEach(Object proc, CharSequence str1, Object... rst) {
    int nrst = rst.length;
    if (nrst == 0) {
      kawa.lib.kawa.string-cursors.stringCursorForEach(proc, str1); } else { if ((nrst < 3) && (!(rst[0] instanceof CharSequence))) {}
      for (;;) {
        try {
          if (nrst != 2) {}
        }
        catch (ClassCastException localClassCastException4)
        {
          try
          {
            Object localObject1;
            
            int[] cursors;
            
            int[] ends;
            
            gnu.text.Char[] chs;
            int i;
            Object localObject2;
            CharSequence str;
            int i;
            int i;
            int j;
            int curs$Mni;
            CharSequence str = (CharSequence)(localObject3 = gnu.mapping.Promise.force(rst[(i - 1)], CharSequence.class));
            if (kawa.lib.kawa.string-cursors.isStringCursor$Ls(curs$Mni, end$Mni)) {
              chs[i] = gnu.text.Char.make(kawa.lib.kawa.string-cursors.stringCursorRef(str, curs$Mni));cursors[i] = 
                kawa.lib.kawa.string-cursors.stringCursorNext(str, curs$Mni);
              i++; continue;
            }
            return;
          }
          catch (ClassCastException localClassCastException4)
          {
            int n;
            int end$Mni;
            Object localObject3;
            throw new gnu.mapping.WrongType(localClassCastException4, "str", -2, localObject3);
          }
          throw new gnu.mapping.WrongType(
          























            localClassCastException1, "srfi-13-string-for-each", 2, n);
        }
        try
        {
          tmpTernaryOp = ((Number)(localObject1 = gnu.mapping.Promise.force(rst[1]))).intValue();srfi$Mn13StringForEach(proc, str1, ((Number)(localObject1 = gnu.mapping.Promise.force(rst[0]))).intValue(), -1); continue;
          
          n = nrst + 1;
          cursors = new int[n];
          ends = new int[n];
          chs = new gnu.text.Char[n];cursors[0] = 
            kawa.lib.kawa.string-cursors.stringCursorStart(str1);ends[0] = 
            kawa.lib.kawa.string-cursors.stringCursorEnd(str1);
          i = 1; if (i >= n) {}
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new gnu.mapping.WrongType(localClassCastException2, "srfi-13-string-for-each", 3, n);
        }
        




        try
        {
          str = (CharSequence)(localObject2 = gnu.mapping.Promise.force(rst[(i - 1)], CharSequence.class));
          cursors[i] = kawa.lib.kawa.string-cursors.stringCursorStart(str);ends[i] = 
            kawa.lib.kawa.string-cursors.stringCursorEnd(str);i++;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new gnu.mapping.WrongType(localClassCastException3, "str", -2, end$Mni);
        }
        

        i = 0;
        if (i != n) continue;
        str = 1;localObject2 = chs;str = (i = gnu.kawa.functions.MakeSplice.count(localObject2)) + str;j = 1;gnu.kawa.functions.MakeSplice.copyTo(new Object[] { proc }, j, i, localObject2);j += i;kawa.standard.Scheme.applyToArgs.applyN(tmp213_209);
      }
      
      curs$Mni = cursors[i];
      end$Mni = ends[i];
      if (i == 0) { tmpTernaryOp = str1;
      }
    }
  }
  
  public static CharSequence stringMap(Object proc, CharSequence str1, CharSequence... rst)
  {
    int nrst = rst.length;
    int n = nrst + 1;
    int[] cursors = new int[n];
    int[] ends = new int[n];
    gnu.text.Char[] chs = new gnu.text.Char[n];
    int len1 = str1.length();
    gnu.lists.FString result = gnu.lists.FString.alloc(len1);cursors[0] = 0;ends[0] = len1;
    

    for (int i = 1; i < n; 
        

        i++)
    {
      CharSequence str = rst[(i - 1)];
      cursors[i] = 0;ends[i] = 
        str.length();
    }
    int i = 0;
    for (;;) { if (i == n) {
        int i = 1;gnu.text.Char[] arrayOfChar1 = chs; int j; i = (j = gnu.kawa.functions.MakeSplice.count(arrayOfChar1)) + i;int k = 1;gnu.kawa.functions.MakeSplice.copyTo(new Object[] { proc }, k, j, arrayOfChar1);k += j; } try { Object localObject; int ch = gnu.text.Char.castToCharacter(localObject = gnu.mapping.Promise.force(kawa.standard.Scheme.applyToArgs.applyN(tmp137_133)));
        result.appendCharacter(ch);
      }
      catch (ClassCastException localClassCastException)
      {
        int curs$Mni;
        int end$Mni;
        CharSequence str;
        throw new gnu.mapping.WrongType(
        









          localClassCastException, "ch", -2, end$Mni);
      }
      curs$Mni = cursors[i];
      end$Mni = ends[i];
      str = i == 0 ? str1 : rst[(i - 1)];
      if (!kawa.lib.kawa.string-cursors.isStringCursor$Ls(curs$Mni, end$Mni)) break label256;
      chs[i] = gnu.text.Char.make(kawa.lib.kawa.string-cursors.stringCursorRef(str, curs$Mni));cursors[i] = 
        kawa.lib.kawa.string-cursors.stringCursorNext(str, curs$Mni);
      i++; }
    label256: return result;
  }
  
  public static void stringAppend$Ex(gnu.lists.FString str, Object... args) {
    int len = args.length;
    for (int i = 0; i < len; 
        
        i++) str.append(args[i]);
  }
  
  public static gnu.lists.FString makeString(int paramInt)
  {
    return makeString(paramInt, 32);
  }
  
  public static gnu.lists.LList string$To$List(CharSequence paramCharSequence)
  {
    return string$To$List(paramCharSequence, 0, -1);
  }
  
  public static gnu.lists.LList string$To$List(CharSequence paramCharSequence, int paramInt)
  {
    return string$To$List(paramCharSequence, paramInt, -1);
  }
  
  public static gnu.lists.FString stringCopy(CharSequence paramCharSequence)
  {
    return stringCopy(paramCharSequence, 0, -1);
  }
  
  public static gnu.lists.FString stringCopy(CharSequence paramCharSequence, int paramInt)
  {
    return stringCopy(paramCharSequence, paramInt, -1);
  }
  
  public static void stringCopy$Ex(gnu.lists.FString paramFString, int paramInt, CharSequence paramCharSequence)
  {
    stringCopy$Ex(paramFString, paramInt, paramCharSequence, 0);
  }
  
  public static void stringReplace$Ex(gnu.lists.FString paramFString, int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    stringReplace$Ex(paramFString, paramInt1, paramInt2, paramCharSequence, 0, -1);
  }
  
  public static void stringReplace$Ex(gnu.lists.FString paramFString, int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    stringReplace$Ex(paramFString, paramInt1, paramInt2, paramCharSequence, paramInt3, -1);
  }
  
  @kawa.SourceMethodType({"", "", "character"})
  public static void stringFill$Ex(gnu.lists.CharSeq paramCharSeq, int paramInt)
  {
    stringFill$Ex(paramCharSeq, paramInt, 0, -1);
  }
  
  @kawa.SourceMethodType({"", "", "character"})
  public static void stringFill$Ex(gnu.lists.CharSeq paramCharSeq, int paramInt1, int paramInt2)
  {
    stringFill$Ex(paramCharSeq, paramInt1, paramInt2, -1);
  }
  
  public static void srfi$Mn13StringForEach(Object paramObject, CharSequence paramCharSequence)
  {
    srfi$Mn13StringForEach(paramObject, paramCharSequence, 0, -1);
  }
  
  public static void srfi$Mn13StringForEach(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    srfi$Mn13StringForEach(paramObject, paramCharSequence, paramInt, -1);
  }
  
  public strings()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 640	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+405->409, 1:+388->392, 2:+368->372, 5:+332->336, 14:+296->300, 17:+260->264, 18:+227->231, 30:+194->198, 31:+161->165, 32:+128->132, 33:+92->96
    //   96: aload_3
    //   97: aload_2
    //   98: ldc 12
    //   100: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   103: dup
    //   104: instanceof 12
    //   107: ifeq +6 -> 113
    //   110: goto +7 -> 117
    //   113: ldc_w 641
    //   116: ireturn
    //   117: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   120: aload_3
    //   121: aload_1
    //   122: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   125: aload_3
    //   126: iconst_1
    //   127: putfield 652	gnu/mapping/CallContext:pc	I
    //   130: iconst_0
    //   131: ireturn
    //   132: aload_3
    //   133: aload_2
    //   134: ldc 61
    //   136: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   139: dup
    //   140: instanceof 61
    //   143: ifne +7 -> 150
    //   146: ldc_w 641
    //   149: ireturn
    //   150: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   153: aload_3
    //   154: aload_1
    //   155: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   158: aload_3
    //   159: iconst_1
    //   160: putfield 652	gnu/mapping/CallContext:pc	I
    //   163: iconst_0
    //   164: ireturn
    //   165: aload_3
    //   166: aload_2
    //   167: ldc 61
    //   169: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: dup
    //   173: instanceof 61
    //   176: ifne +7 -> 183
    //   179: ldc_w 641
    //   182: ireturn
    //   183: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   186: aload_3
    //   187: aload_1
    //   188: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   191: aload_3
    //   192: iconst_1
    //   193: putfield 652	gnu/mapping/CallContext:pc	I
    //   196: iconst_0
    //   197: ireturn
    //   198: aload_3
    //   199: aload_2
    //   200: ldc 61
    //   202: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   205: dup
    //   206: instanceof 61
    //   209: ifne +7 -> 216
    //   212: ldc_w 641
    //   215: ireturn
    //   216: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   219: aload_3
    //   220: aload_1
    //   221: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   224: aload_3
    //   225: iconst_1
    //   226: putfield 652	gnu/mapping/CallContext:pc	I
    //   229: iconst_0
    //   230: ireturn
    //   231: aload_3
    //   232: aload_2
    //   233: ldc 12
    //   235: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   238: dup
    //   239: instanceof 12
    //   242: ifne +7 -> 249
    //   245: ldc_w 641
    //   248: ireturn
    //   249: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   252: aload_3
    //   253: aload_1
    //   254: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   257: aload_3
    //   258: iconst_1
    //   259: putfield 652	gnu/mapping/CallContext:pc	I
    //   262: iconst_0
    //   263: ireturn
    //   264: aload_3
    //   265: aload_2
    //   266: ldc 85
    //   268: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   271: dup
    //   272: instanceof 85
    //   275: ifeq +6 -> 281
    //   278: goto +7 -> 285
    //   281: ldc_w 641
    //   284: ireturn
    //   285: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   288: aload_3
    //   289: aload_1
    //   290: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   293: aload_3
    //   294: iconst_1
    //   295: putfield 652	gnu/mapping/CallContext:pc	I
    //   298: iconst_0
    //   299: ireturn
    //   300: aload_3
    //   301: aload_2
    //   302: ldc 12
    //   304: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   307: dup
    //   308: instanceof 12
    //   311: ifeq +6 -> 317
    //   314: goto +7 -> 321
    //   317: ldc_w 641
    //   320: ireturn
    //   321: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   324: aload_3
    //   325: aload_1
    //   326: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   329: aload_3
    //   330: iconst_1
    //   331: putfield 652	gnu/mapping/CallContext:pc	I
    //   334: iconst_0
    //   335: ireturn
    //   336: aload_3
    //   337: aload_2
    //   338: ldc 12
    //   340: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   343: dup
    //   344: instanceof 12
    //   347: ifeq +6 -> 353
    //   350: goto +7 -> 357
    //   353: ldc_w 641
    //   356: ireturn
    //   357: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   360: aload_3
    //   361: aload_1
    //   362: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   365: aload_3
    //   366: iconst_1
    //   367: putfield 652	gnu/mapping/CallContext:pc	I
    //   370: iconst_0
    //   371: ireturn
    //   372: aload_3
    //   373: aload_2
    //   374: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   377: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   380: aload_3
    //   381: aload_1
    //   382: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   385: aload_3
    //   386: iconst_1
    //   387: putfield 652	gnu/mapping/CallContext:pc	I
    //   390: iconst_0
    //   391: ireturn
    //   392: aload_3
    //   393: aload_2
    //   394: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   397: aload_3
    //   398: aload_1
    //   399: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   402: aload_3
    //   403: iconst_1
    //   404: putfield 652	gnu/mapping/CallContext:pc	I
    //   407: iconst_0
    //   408: ireturn
    //   409: aload_0
    //   410: aload_1
    //   411: aload_2
    //   412: aload_3
    //   413: invokespecial 656	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   416: ireturn
    // Line number table:
    //   Java source line #174	-> byte code offset #96
    //   Java source line #170	-> byte code offset #132
    //   Java source line #166	-> byte code offset #165
    //   Java source line #162	-> byte code offset #198
    //   Java source line #111	-> byte code offset #231
    //   Java source line #102	-> byte code offset #264
    //   Java source line #90	-> byte code offset #300
    //   Java source line #62	-> byte code offset #336
    //   Java source line #50	-> byte code offset #372
    //   Java source line #47	-> byte code offset #392
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 640	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+348->352, 2:+302->306, 6:+257->261, 14:+209->213, 18:+164->168, 27:+105->109, 50:+60->64
    //   64: aload 4
    //   66: aload_2
    //   67: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   70: aload 4
    //   72: aload_3
    //   73: ldc 12
    //   75: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: dup
    //   79: instanceof 12
    //   82: ifeq +6 -> 88
    //   85: goto +7 -> 92
    //   88: ldc_w 657
    //   91: ireturn
    //   92: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   95: aload 4
    //   97: aload_1
    //   98: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   101: aload 4
    //   103: iconst_2
    //   104: putfield 652	gnu/mapping/CallContext:pc	I
    //   107: iconst_0
    //   108: ireturn
    //   109: aload 4
    //   111: aload_2
    //   112: ldc 61
    //   114: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: dup
    //   118: instanceof 61
    //   121: ifne +7 -> 128
    //   124: ldc_w 641
    //   127: ireturn
    //   128: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   131: aload 4
    //   133: aload_3
    //   134: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   137: dup
    //   138: invokestatic 663	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   141: iflt +6 -> 147
    //   144: goto +7 -> 151
    //   147: ldc_w 657
    //   150: ireturn
    //   151: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   154: aload 4
    //   156: aload_1
    //   157: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   160: aload 4
    //   162: iconst_2
    //   163: putfield 652	gnu/mapping/CallContext:pc	I
    //   166: iconst_0
    //   167: ireturn
    //   168: aload 4
    //   170: aload_2
    //   171: ldc 12
    //   173: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   176: dup
    //   177: instanceof 12
    //   180: ifne +7 -> 187
    //   183: ldc_w 641
    //   186: ireturn
    //   187: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   190: aload 4
    //   192: aload_3
    //   193: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   199: aload 4
    //   201: aload_1
    //   202: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   205: aload 4
    //   207: iconst_2
    //   208: putfield 652	gnu/mapping/CallContext:pc	I
    //   211: iconst_0
    //   212: ireturn
    //   213: aload 4
    //   215: aload_2
    //   216: ldc 12
    //   218: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   221: dup
    //   222: instanceof 12
    //   225: ifeq +6 -> 231
    //   228: goto +7 -> 235
    //   231: ldc_w 641
    //   234: ireturn
    //   235: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   238: aload 4
    //   240: aload_3
    //   241: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   247: aload 4
    //   249: aload_1
    //   250: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   253: aload 4
    //   255: iconst_2
    //   256: putfield 652	gnu/mapping/CallContext:pc	I
    //   259: iconst_0
    //   260: ireturn
    //   261: aload 4
    //   263: aload_2
    //   264: ldc 12
    //   266: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   269: dup
    //   270: instanceof 12
    //   273: ifne +7 -> 280
    //   276: ldc_w 641
    //   279: ireturn
    //   280: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   283: aload 4
    //   285: aload_3
    //   286: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   289: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   292: aload 4
    //   294: aload_1
    //   295: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   298: aload 4
    //   300: iconst_2
    //   301: putfield 652	gnu/mapping/CallContext:pc	I
    //   304: iconst_0
    //   305: ireturn
    //   306: aload 4
    //   308: aload_2
    //   309: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   312: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   315: aload 4
    //   317: aload_3
    //   318: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   321: dup
    //   322: invokestatic 663	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   325: iflt +6 -> 331
    //   328: goto +7 -> 335
    //   331: ldc_w 657
    //   334: ireturn
    //   335: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   338: aload 4
    //   340: aload_1
    //   341: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   344: aload 4
    //   346: iconst_2
    //   347: putfield 652	gnu/mapping/CallContext:pc	I
    //   350: iconst_0
    //   351: ireturn
    //   352: aload_0
    //   353: aload_1
    //   354: aload_2
    //   355: aload_3
    //   356: aload 4
    //   358: invokespecial 667	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   361: ireturn
    // Line number table:
    //   Java source line #229	-> byte code offset #64
    //   Java source line #142	-> byte code offset #109
    //   Java source line #111	-> byte code offset #168
    //   Java source line #90	-> byte code offset #213
    //   Java source line #65	-> byte code offset #261
    //   Java source line #50	-> byte code offset #306
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 640	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+500->504, 7:+431->435, 13:+373->377, 14:+315->319, 18:+260->264, 21:+192->196, 27:+123->127, 50:+68->72
    //   72: aload 5
    //   74: aload_2
    //   75: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   78: aload 5
    //   80: aload_3
    //   81: ldc 12
    //   83: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   86: dup
    //   87: instanceof 12
    //   90: ifeq +6 -> 96
    //   93: goto +7 -> 100
    //   96: ldc_w 657
    //   99: ireturn
    //   100: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   103: aload 5
    //   105: aload 4
    //   107: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   110: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   113: aload 5
    //   115: aload_1
    //   116: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   119: aload 5
    //   121: iconst_3
    //   122: putfield 652	gnu/mapping/CallContext:pc	I
    //   125: iconst_0
    //   126: ireturn
    //   127: aload 5
    //   129: aload_2
    //   130: ldc 61
    //   132: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   135: dup
    //   136: instanceof 61
    //   139: ifne +7 -> 146
    //   142: ldc_w 641
    //   145: ireturn
    //   146: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   149: aload 5
    //   151: aload_3
    //   152: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: dup
    //   156: invokestatic 663	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   159: iflt +6 -> 165
    //   162: goto +7 -> 169
    //   165: ldc_w 657
    //   168: ireturn
    //   169: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   172: aload 5
    //   174: aload 4
    //   176: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   179: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   182: aload 5
    //   184: aload_1
    //   185: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   188: aload 5
    //   190: iconst_3
    //   191: putfield 652	gnu/mapping/CallContext:pc	I
    //   194: iconst_0
    //   195: ireturn
    //   196: aload 5
    //   198: aload_2
    //   199: ldc 20
    //   201: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   204: dup
    //   205: instanceof 20
    //   208: ifne +7 -> 215
    //   211: ldc_w 641
    //   214: ireturn
    //   215: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   218: aload 5
    //   220: aload_3
    //   221: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   224: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   227: aload 5
    //   229: aload 4
    //   231: ldc 12
    //   233: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   236: dup
    //   237: instanceof 12
    //   240: ifne +7 -> 247
    //   243: ldc_w 671
    //   246: ireturn
    //   247: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   250: aload 5
    //   252: aload_1
    //   253: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   256: aload 5
    //   258: iconst_3
    //   259: putfield 652	gnu/mapping/CallContext:pc	I
    //   262: iconst_0
    //   263: ireturn
    //   264: aload 5
    //   266: aload_2
    //   267: ldc 12
    //   269: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   272: dup
    //   273: instanceof 12
    //   276: ifne +7 -> 283
    //   279: ldc_w 641
    //   282: ireturn
    //   283: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   286: aload 5
    //   288: aload_3
    //   289: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   292: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   295: aload 5
    //   297: aload 4
    //   299: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   305: aload 5
    //   307: aload_1
    //   308: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   311: aload 5
    //   313: iconst_3
    //   314: putfield 652	gnu/mapping/CallContext:pc	I
    //   317: iconst_0
    //   318: ireturn
    //   319: aload 5
    //   321: aload_2
    //   322: ldc 12
    //   324: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   327: dup
    //   328: instanceof 12
    //   331: ifeq +6 -> 337
    //   334: goto +7 -> 341
    //   337: ldc_w 641
    //   340: ireturn
    //   341: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   344: aload 5
    //   346: aload_3
    //   347: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   350: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   353: aload 5
    //   355: aload 4
    //   357: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   363: aload 5
    //   365: aload_1
    //   366: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   369: aload 5
    //   371: iconst_3
    //   372: putfield 652	gnu/mapping/CallContext:pc	I
    //   375: iconst_0
    //   376: ireturn
    //   377: aload 5
    //   379: aload_2
    //   380: ldc 12
    //   382: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   385: dup
    //   386: instanceof 12
    //   389: ifeq +6 -> 395
    //   392: goto +7 -> 399
    //   395: ldc_w 641
    //   398: ireturn
    //   399: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   402: aload 5
    //   404: aload_3
    //   405: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   408: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   411: aload 5
    //   413: aload 4
    //   415: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   418: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   421: aload 5
    //   423: aload_1
    //   424: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   427: aload 5
    //   429: iconst_3
    //   430: putfield 652	gnu/mapping/CallContext:pc	I
    //   433: iconst_0
    //   434: ireturn
    //   435: aload 5
    //   437: aload_2
    //   438: ldc 61
    //   440: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   443: dup
    //   444: instanceof 61
    //   447: ifne +7 -> 454
    //   450: ldc_w 641
    //   453: ireturn
    //   454: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   457: aload 5
    //   459: aload_3
    //   460: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   463: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   466: aload 5
    //   468: aload 4
    //   470: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   473: dup
    //   474: invokestatic 663	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   477: iflt +6 -> 483
    //   480: goto +7 -> 487
    //   483: ldc_w 671
    //   486: ireturn
    //   487: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   490: aload 5
    //   492: aload_1
    //   493: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   496: aload 5
    //   498: iconst_3
    //   499: putfield 652	gnu/mapping/CallContext:pc	I
    //   502: iconst_0
    //   503: ireturn
    //   504: aload_0
    //   505: aload_1
    //   506: aload_2
    //   507: aload_3
    //   508: aload 4
    //   510: aload 5
    //   512: invokespecial 675	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   515: ireturn
    // Line number table:
    //   Java source line #229	-> byte code offset #72
    //   Java source line #142	-> byte code offset #127
    //   Java source line #119	-> byte code offset #196
    //   Java source line #111	-> byte code offset #264
    //   Java source line #90	-> byte code offset #319
    //   Java source line #85	-> byte code offset #377
    //   Java source line #70	-> byte code offset #435
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 640	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+344->348, 21:+266->270, 24:+188->192, 27:+109->113, 50:+44->48
    //   48: aload 6
    //   50: aload_2
    //   51: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   54: aload 6
    //   56: aload_3
    //   57: ldc 12
    //   59: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: dup
    //   63: instanceof 12
    //   66: ifeq +6 -> 72
    //   69: goto +7 -> 76
    //   72: ldc_w 657
    //   75: ireturn
    //   76: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   79: aload 6
    //   81: aload 4
    //   83: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   89: aload 6
    //   91: aload 5
    //   93: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: putfield 678	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   99: aload 6
    //   101: aload_1
    //   102: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   105: aload 6
    //   107: iconst_4
    //   108: putfield 652	gnu/mapping/CallContext:pc	I
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 6
    //   115: aload_2
    //   116: ldc 61
    //   118: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   121: dup
    //   122: instanceof 61
    //   125: ifne +7 -> 132
    //   128: ldc_w 641
    //   131: ireturn
    //   132: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   135: aload 6
    //   137: aload_3
    //   138: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   141: dup
    //   142: invokestatic 663	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   145: iflt +6 -> 151
    //   148: goto +7 -> 155
    //   151: ldc_w 657
    //   154: ireturn
    //   155: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   158: aload 6
    //   160: aload 4
    //   162: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   168: aload 6
    //   170: aload 5
    //   172: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: putfield 678	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   178: aload 6
    //   180: aload_1
    //   181: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   184: aload 6
    //   186: iconst_4
    //   187: putfield 652	gnu/mapping/CallContext:pc	I
    //   190: iconst_0
    //   191: ireturn
    //   192: aload 6
    //   194: aload_2
    //   195: ldc 20
    //   197: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   200: dup
    //   201: instanceof 20
    //   204: ifne +7 -> 211
    //   207: ldc_w 641
    //   210: ireturn
    //   211: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   214: aload 6
    //   216: aload_3
    //   217: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   220: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   223: aload 6
    //   225: aload 4
    //   227: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   230: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   233: aload 6
    //   235: aload 5
    //   237: ldc 12
    //   239: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   242: dup
    //   243: instanceof 12
    //   246: ifne +7 -> 253
    //   249: ldc_w 679
    //   252: ireturn
    //   253: putfield 678	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   256: aload 6
    //   258: aload_1
    //   259: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   262: aload 6
    //   264: iconst_4
    //   265: putfield 652	gnu/mapping/CallContext:pc	I
    //   268: iconst_0
    //   269: ireturn
    //   270: aload 6
    //   272: aload_2
    //   273: ldc 20
    //   275: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   278: dup
    //   279: instanceof 20
    //   282: ifne +7 -> 289
    //   285: ldc_w 641
    //   288: ireturn
    //   289: putfield 645	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   292: aload 6
    //   294: aload_3
    //   295: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   298: putfield 660	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   301: aload 6
    //   303: aload 4
    //   305: ldc 12
    //   307: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   310: dup
    //   311: instanceof 12
    //   314: ifne +7 -> 321
    //   317: ldc_w 671
    //   320: ireturn
    //   321: putfield 670	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   324: aload 6
    //   326: aload 5
    //   328: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: putfield 678	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   334: aload 6
    //   336: aload_1
    //   337: putfield 649	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   340: aload 6
    //   342: iconst_4
    //   343: putfield 652	gnu/mapping/CallContext:pc	I
    //   346: iconst_0
    //   347: ireturn
    //   348: aload_0
    //   349: aload_1
    //   350: aload_2
    //   351: aload_3
    //   352: aload 4
    //   354: aload 5
    //   356: aload 6
    //   358: invokespecial 683	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   361: ireturn
    // Line number table:
    //   Java source line #229	-> byte code offset #48
    //   Java source line #142	-> byte code offset #113
    //   Java source line #128	-> byte code offset #192
    //   Java source line #119	-> byte code offset #270
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
    //   1: getfield 640	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+193->197, 2:+60->64, 6:+81->85, 14:+107->111, 18:+130->134, 27:+153->157, 50:+176->180
    //   64: aload_2
    //   65: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 222	java/lang/Number
    //   71: invokevirtual 223	java/lang/Number:intValue	()I
    //   74: aload_3
    //   75: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   81: invokestatic 18	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   84: areturn
    //   85: aload_2
    //   86: ldc 12
    //   88: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   91: checkcast 12	java/lang/CharSequence
    //   94: aload_3
    //   95: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 222	java/lang/Number
    //   101: invokevirtual 223	java/lang/Number:intValue	()I
    //   104: invokestatic 765	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   107: invokestatic 107	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   110: areturn
    //   111: aload_2
    //   112: ldc 12
    //   114: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: checkcast 12	java/lang/CharSequence
    //   120: aload_3
    //   121: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 222	java/lang/Number
    //   127: invokevirtual 223	java/lang/Number:intValue	()I
    //   130: invokestatic 768	kawa/lib/strings:string$To$List	(Ljava/lang/CharSequence;I)Lgnu/lists/LList;
    //   133: areturn
    //   134: aload_2
    //   135: ldc 12
    //   137: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   140: checkcast 12	java/lang/CharSequence
    //   143: aload_3
    //   144: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 222	java/lang/Number
    //   150: invokevirtual 223	java/lang/Number:intValue	()I
    //   153: invokestatic 771	kawa/lib/strings:stringCopy	(Ljava/lang/CharSequence;I)Lgnu/lists/FString;
    //   156: areturn
    //   157: aload_2
    //   158: ldc 61
    //   160: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   163: checkcast 61	gnu/lists/CharSeq
    //   166: aload_3
    //   167: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   170: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   173: invokestatic 776	kawa/lib/strings:stringFill$Ex	(Lgnu/lists/CharSeq;I)V
    //   176: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   179: areturn
    //   180: aload_2
    //   181: aload_3
    //   182: ldc 12
    //   184: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: checkcast 12	java/lang/CharSequence
    //   190: invokestatic 784	kawa/lib/strings:srfi$Mn13StringForEach	(Ljava/lang/Object;Ljava/lang/CharSequence;)V
    //   193: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   196: areturn
    //   197: aload_0
    //   198: aload_1
    //   199: aload_2
    //   200: aload_3
    //   201: invokespecial 788	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: areturn
    //   205: new 120	gnu/mapping/WrongType
    //   208: dup_x1
    //   209: swap
    //   210: ldc_w 709
    //   213: iconst_1
    //   214: aload_2
    //   215: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   218: athrow
    //   219: new 120	gnu/mapping/WrongType
    //   222: dup_x1
    //   223: swap
    //   224: ldc_w 709
    //   227: iconst_2
    //   228: aload_3
    //   229: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: new 120	gnu/mapping/WrongType
    //   236: dup_x1
    //   237: swap
    //   238: ldc_w 762
    //   241: iconst_1
    //   242: aload_2
    //   243: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: new 120	gnu/mapping/WrongType
    //   250: dup_x1
    //   251: swap
    //   252: ldc_w 762
    //   255: iconst_2
    //   256: aload_3
    //   257: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   260: athrow
    //   261: new 120	gnu/mapping/WrongType
    //   264: dup_x1
    //   265: swap
    //   266: ldc_w 724
    //   269: iconst_1
    //   270: aload_2
    //   271: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   274: athrow
    //   275: new 120	gnu/mapping/WrongType
    //   278: dup_x1
    //   279: swap
    //   280: ldc_w 724
    //   283: iconst_2
    //   284: aload_3
    //   285: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   288: athrow
    //   289: new 120	gnu/mapping/WrongType
    //   292: dup_x1
    //   293: swap
    //   294: ldc_w 735
    //   297: iconst_1
    //   298: aload_2
    //   299: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   302: athrow
    //   303: new 120	gnu/mapping/WrongType
    //   306: dup_x1
    //   307: swap
    //   308: ldc_w 735
    //   311: iconst_2
    //   312: aload_3
    //   313: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   316: athrow
    //   317: new 120	gnu/mapping/WrongType
    //   320: dup_x1
    //   321: swap
    //   322: ldc_w 773
    //   325: iconst_1
    //   326: aload_2
    //   327: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   330: athrow
    //   331: new 120	gnu/mapping/WrongType
    //   334: dup_x1
    //   335: swap
    //   336: ldc_w 773
    //   339: iconst_2
    //   340: aload_3
    //   341: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   344: athrow
    //   345: new 120	gnu/mapping/WrongType
    //   348: dup_x1
    //   349: swap
    //   350: ldc -31
    //   352: iconst_2
    //   353: aload_3
    //   354: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    // Line number table:
    //   Java source line #50	-> byte code offset #64
    //   Java source line #65	-> byte code offset #85
    //   Java source line #90	-> byte code offset #111
    //   Java source line #111	-> byte code offset #134
    //   Java source line #142	-> byte code offset #157
    //   Java source line #229	-> byte code offset #180
    //   Java source line #50	-> byte code offset #205
    //   Java source line #65	-> byte code offset #233
    //   Java source line #90	-> byte code offset #261
    //   Java source line #91	-> byte code offset #275
    //   Java source line #111	-> byte code offset #289
    //   Java source line #113	-> byte code offset #303
    //   Java source line #142	-> byte code offset #317
    //   Java source line #229	-> byte code offset #345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	strings
    //   0	358	1	paramModuleMethod	ModuleMethod
    //   0	358	2	paramObject1	Object
    //   0	358	3	paramObject2	Object
    //   205	1	4	localClassCastException1	ClassCastException
    //   219	1	5	localClassCastException2	ClassCastException
    //   233	1	6	localClassCastException3	ClassCastException
    //   247	1	7	localClassCastException4	ClassCastException
    //   261	1	8	localClassCastException5	ClassCastException
    //   275	1	9	localClassCastException6	ClassCastException
    //   289	1	10	localClassCastException7	ClassCastException
    //   303	1	11	localClassCastException8	ClassCastException
    //   317	1	12	localClassCastException9	ClassCastException
    //   331	1	13	localClassCastException10	ClassCastException
    //   345	1	14	localClassCastException11	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   68	74	205	java/lang/ClassCastException
    //   78	81	219	java/lang/ClassCastException
    //   91	94	233	java/lang/ClassCastException
    //   98	104	247	java/lang/ClassCastException
    //   117	120	261	java/lang/ClassCastException
    //   124	130	275	java/lang/ClassCastException
    //   140	143	289	java/lang/ClassCastException
    //   147	153	303	java/lang/ClassCastException
    //   163	166	317	java/lang/ClassCastException
    //   170	173	331	java/lang/ClassCastException
    //   187	190	345	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 640	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+302->306, 7:+68->72, 13:+102->106, 14:+136->140, 18:+170->174, 21:+204->208, 27:+240->244, 50:+274->278
    //   72: aload_2
    //   73: ldc 61
    //   75: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: checkcast 61	gnu/lists/CharSeq
    //   81: aload_3
    //   82: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: checkcast 222	java/lang/Number
    //   88: invokevirtual 223	java/lang/Number:intValue	()I
    //   91: aload 4
    //   93: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   99: invokestatic 142	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   102: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   105: areturn
    //   106: aload_2
    //   107: ldc 12
    //   109: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   112: checkcast 12	java/lang/CharSequence
    //   115: aload_3
    //   116: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 222	java/lang/Number
    //   122: invokevirtual 223	java/lang/Number:intValue	()I
    //   125: aload 4
    //   127: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 222	java/lang/Number
    //   133: invokevirtual 223	java/lang/Number:intValue	()I
    //   136: invokestatic 792	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   139: areturn
    //   140: aload_2
    //   141: ldc 12
    //   143: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   146: checkcast 12	java/lang/CharSequence
    //   149: aload_3
    //   150: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: checkcast 222	java/lang/Number
    //   156: invokevirtual 223	java/lang/Number:intValue	()I
    //   159: aload 4
    //   161: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast 222	java/lang/Number
    //   167: invokevirtual 223	java/lang/Number:intValue	()I
    //   170: invokestatic 83	kawa/lib/strings:string$To$List	(Ljava/lang/CharSequence;II)Lgnu/lists/LList;
    //   173: areturn
    //   174: aload_2
    //   175: ldc 12
    //   177: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   180: checkcast 12	java/lang/CharSequence
    //   183: aload_3
    //   184: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 222	java/lang/Number
    //   190: invokevirtual 223	java/lang/Number:intValue	()I
    //   193: aload 4
    //   195: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: checkcast 222	java/lang/Number
    //   201: invokevirtual 223	java/lang/Number:intValue	()I
    //   204: invokestatic 151	kawa/lib/strings:stringCopy	(Ljava/lang/CharSequence;II)Lgnu/lists/FString;
    //   207: areturn
    //   208: aload_2
    //   209: ldc 20
    //   211: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   214: checkcast 20	gnu/lists/FString
    //   217: aload_3
    //   218: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: checkcast 222	java/lang/Number
    //   224: invokevirtual 223	java/lang/Number:intValue	()I
    //   227: aload 4
    //   229: ldc 12
    //   231: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   234: checkcast 12	java/lang/CharSequence
    //   237: invokestatic 797	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;)V
    //   240: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   243: areturn
    //   244: aload_2
    //   245: ldc 61
    //   247: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   250: checkcast 61	gnu/lists/CharSeq
    //   253: aload_3
    //   254: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   260: aload 4
    //   262: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   265: checkcast 222	java/lang/Number
    //   268: invokevirtual 223	java/lang/Number:intValue	()I
    //   271: invokestatic 799	kawa/lib/strings:stringFill$Ex	(Lgnu/lists/CharSeq;II)V
    //   274: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   277: areturn
    //   278: aload_2
    //   279: aload_3
    //   280: ldc 12
    //   282: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   285: checkcast 12	java/lang/CharSequence
    //   288: aload 4
    //   290: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   293: checkcast 222	java/lang/Number
    //   296: invokevirtual 223	java/lang/Number:intValue	()I
    //   299: invokestatic 802	kawa/lib/strings:srfi$Mn13StringForEach	(Ljava/lang/Object;Ljava/lang/CharSequence;I)V
    //   302: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   305: areturn
    //   306: aload_0
    //   307: aload_1
    //   308: aload_2
    //   309: aload_3
    //   310: aload 4
    //   312: invokespecial 806	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   315: areturn
    //   316: new 120	gnu/mapping/WrongType
    //   319: dup_x1
    //   320: swap
    //   321: ldc -118
    //   323: iconst_1
    //   324: aload_2
    //   325: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   328: athrow
    //   329: new 120	gnu/mapping/WrongType
    //   332: dup_x1
    //   333: swap
    //   334: ldc -118
    //   336: iconst_2
    //   337: aload_3
    //   338: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   341: athrow
    //   342: new 120	gnu/mapping/WrongType
    //   345: dup_x1
    //   346: swap
    //   347: ldc -118
    //   349: iconst_3
    //   350: aload 4
    //   352: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   355: athrow
    //   356: new 120	gnu/mapping/WrongType
    //   359: dup_x1
    //   360: swap
    //   361: ldc_w 789
    //   364: iconst_1
    //   365: aload_2
    //   366: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   369: athrow
    //   370: new 120	gnu/mapping/WrongType
    //   373: dup_x1
    //   374: swap
    //   375: ldc_w 789
    //   378: iconst_2
    //   379: aload_3
    //   380: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   383: athrow
    //   384: new 120	gnu/mapping/WrongType
    //   387: dup_x1
    //   388: swap
    //   389: ldc_w 789
    //   392: iconst_3
    //   393: aload 4
    //   395: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   398: athrow
    //   399: new 120	gnu/mapping/WrongType
    //   402: dup_x1
    //   403: swap
    //   404: ldc_w 724
    //   407: iconst_1
    //   408: aload_2
    //   409: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   412: athrow
    //   413: new 120	gnu/mapping/WrongType
    //   416: dup_x1
    //   417: swap
    //   418: ldc_w 724
    //   421: iconst_2
    //   422: aload_3
    //   423: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   426: athrow
    //   427: new 120	gnu/mapping/WrongType
    //   430: dup_x1
    //   431: swap
    //   432: ldc_w 724
    //   435: iconst_3
    //   436: aload 4
    //   438: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   441: athrow
    //   442: new 120	gnu/mapping/WrongType
    //   445: dup_x1
    //   446: swap
    //   447: ldc_w 735
    //   450: iconst_1
    //   451: aload_2
    //   452: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   455: athrow
    //   456: new 120	gnu/mapping/WrongType
    //   459: dup_x1
    //   460: swap
    //   461: ldc_w 735
    //   464: iconst_2
    //   465: aload_3
    //   466: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   469: athrow
    //   470: new 120	gnu/mapping/WrongType
    //   473: dup_x1
    //   474: swap
    //   475: ldc_w 735
    //   478: iconst_3
    //   479: aload 4
    //   481: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   484: athrow
    //   485: new 120	gnu/mapping/WrongType
    //   488: dup_x1
    //   489: swap
    //   490: ldc_w 794
    //   493: iconst_1
    //   494: aload_2
    //   495: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   498: athrow
    //   499: new 120	gnu/mapping/WrongType
    //   502: dup_x1
    //   503: swap
    //   504: ldc_w 794
    //   507: iconst_2
    //   508: aload_3
    //   509: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   512: athrow
    //   513: new 120	gnu/mapping/WrongType
    //   516: dup_x1
    //   517: swap
    //   518: ldc_w 794
    //   521: iconst_3
    //   522: aload 4
    //   524: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   527: athrow
    //   528: new 120	gnu/mapping/WrongType
    //   531: dup_x1
    //   532: swap
    //   533: ldc_w 773
    //   536: iconst_1
    //   537: aload_2
    //   538: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   541: athrow
    //   542: new 120	gnu/mapping/WrongType
    //   545: dup_x1
    //   546: swap
    //   547: ldc_w 773
    //   550: iconst_2
    //   551: aload_3
    //   552: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   555: athrow
    //   556: new 120	gnu/mapping/WrongType
    //   559: dup_x1
    //   560: swap
    //   561: ldc_w 773
    //   564: iconst_3
    //   565: aload 4
    //   567: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   570: athrow
    //   571: new 120	gnu/mapping/WrongType
    //   574: dup_x1
    //   575: swap
    //   576: ldc -31
    //   578: iconst_2
    //   579: aload_3
    //   580: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   583: athrow
    //   584: new 120	gnu/mapping/WrongType
    //   587: dup_x1
    //   588: swap
    //   589: ldc -31
    //   591: iconst_3
    //   592: aload 4
    //   594: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   597: athrow
    // Line number table:
    //   Java source line #70	-> byte code offset #72
    //   Java source line #85	-> byte code offset #106
    //   Java source line #90	-> byte code offset #140
    //   Java source line #111	-> byte code offset #174
    //   Java source line #119	-> byte code offset #208
    //   Java source line #142	-> byte code offset #244
    //   Java source line #229	-> byte code offset #278
    //   Java source line #70	-> byte code offset #316
    //   Java source line #85	-> byte code offset #356
    //   Java source line #90	-> byte code offset #399
    //   Java source line #91	-> byte code offset #413
    //   Java source line #111	-> byte code offset #442
    //   Java source line #113	-> byte code offset #456
    //   Java source line #114	-> byte code offset #470
    //   Java source line #119	-> byte code offset #485
    //   Java source line #120	-> byte code offset #499
    //   Java source line #121	-> byte code offset #513
    //   Java source line #142	-> byte code offset #528
    //   Java source line #144	-> byte code offset #556
    //   Java source line #229	-> byte code offset #571
    //   Java source line #230	-> byte code offset #584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	this	strings
    //   0	598	1	paramModuleMethod	ModuleMethod
    //   0	598	2	paramObject1	Object
    //   0	598	3	paramObject2	Object
    //   0	598	4	paramObject3	Object
    //   316	1	5	localClassCastException1	ClassCastException
    //   329	1	6	localClassCastException2	ClassCastException
    //   342	1	7	localClassCastException3	ClassCastException
    //   356	1	8	localClassCastException4	ClassCastException
    //   370	1	9	localClassCastException5	ClassCastException
    //   384	1	10	localClassCastException6	ClassCastException
    //   399	1	11	localClassCastException7	ClassCastException
    //   413	1	12	localClassCastException8	ClassCastException
    //   427	1	13	localClassCastException9	ClassCastException
    //   442	1	14	localClassCastException10	ClassCastException
    //   456	1	15	localClassCastException11	ClassCastException
    //   470	1	16	localClassCastException12	ClassCastException
    //   485	1	17	localClassCastException13	ClassCastException
    //   499	1	18	localClassCastException14	ClassCastException
    //   513	1	19	localClassCastException15	ClassCastException
    //   528	1	20	localClassCastException16	ClassCastException
    //   542	1	21	localClassCastException17	ClassCastException
    //   556	1	22	localClassCastException18	ClassCastException
    //   571	1	23	localClassCastException19	ClassCastException
    //   584	1	24	localClassCastException20	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   78	81	316	java/lang/ClassCastException
    //   85	91	329	java/lang/ClassCastException
    //   96	99	342	java/lang/ClassCastException
    //   112	115	356	java/lang/ClassCastException
    //   119	125	370	java/lang/ClassCastException
    //   130	136	384	java/lang/ClassCastException
    //   146	149	399	java/lang/ClassCastException
    //   153	159	413	java/lang/ClassCastException
    //   164	170	427	java/lang/ClassCastException
    //   180	183	442	java/lang/ClassCastException
    //   187	193	456	java/lang/ClassCastException
    //   198	204	470	java/lang/ClassCastException
    //   214	217	485	java/lang/ClassCastException
    //   221	227	499	java/lang/ClassCastException
    //   234	237	513	java/lang/ClassCastException
    //   250	253	528	java/lang/ClassCastException
    //   257	260	542	java/lang/ClassCastException
    //   265	271	556	java/lang/ClassCastException
    //   285	288	571	java/lang/ClassCastException
    //   293	299	584	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 640	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+222->226, 21:+44->48, 24:+91->95, 27:+138->142, 50:+183->187
    //   48: aload_2
    //   49: ldc 20
    //   51: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: checkcast 20	gnu/lists/FString
    //   57: aload_3
    //   58: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 222	java/lang/Number
    //   64: invokevirtual 223	java/lang/Number:intValue	()I
    //   67: aload 4
    //   69: ldc 12
    //   71: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   74: checkcast 12	java/lang/CharSequence
    //   77: aload 5
    //   79: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 222	java/lang/Number
    //   85: invokevirtual 223	java/lang/Number:intValue	()I
    //   88: invokestatic 155	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;I)V
    //   91: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   94: areturn
    //   95: aload_2
    //   96: ldc 20
    //   98: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   101: checkcast 20	gnu/lists/FString
    //   104: aload_3
    //   105: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   108: checkcast 222	java/lang/Number
    //   111: invokevirtual 223	java/lang/Number:intValue	()I
    //   114: aload 4
    //   116: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 222	java/lang/Number
    //   122: invokevirtual 223	java/lang/Number:intValue	()I
    //   125: aload 5
    //   127: ldc 12
    //   129: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   132: checkcast 12	java/lang/CharSequence
    //   135: invokestatic 811	kawa/lib/strings:stringReplace$Ex	(Lgnu/lists/FString;IILjava/lang/CharSequence;)V
    //   138: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   141: areturn
    //   142: aload_2
    //   143: ldc 61
    //   145: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   148: checkcast 61	gnu/lists/CharSeq
    //   151: aload_3
    //   152: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   158: aload 4
    //   160: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: checkcast 222	java/lang/Number
    //   166: invokevirtual 223	java/lang/Number:intValue	()I
    //   169: aload 5
    //   171: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: checkcast 222	java/lang/Number
    //   177: invokevirtual 223	java/lang/Number:intValue	()I
    //   180: invokestatic 171	kawa/lib/strings:stringFill$Ex	(Lgnu/lists/CharSeq;III)V
    //   183: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   186: areturn
    //   187: aload_2
    //   188: aload_3
    //   189: ldc 12
    //   191: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   194: checkcast 12	java/lang/CharSequence
    //   197: aload 4
    //   199: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   202: checkcast 222	java/lang/Number
    //   205: invokevirtual 223	java/lang/Number:intValue	()I
    //   208: aload 5
    //   210: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: checkcast 222	java/lang/Number
    //   216: invokevirtual 223	java/lang/Number:intValue	()I
    //   219: invokestatic 211	kawa/lib/strings:srfi$Mn13StringForEach	(Ljava/lang/Object;Ljava/lang/CharSequence;II)V
    //   222: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   225: areturn
    //   226: aload_0
    //   227: aload_1
    //   228: aload_2
    //   229: aload_3
    //   230: aload 4
    //   232: aload 5
    //   234: invokespecial 815	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: areturn
    //   238: new 120	gnu/mapping/WrongType
    //   241: dup_x1
    //   242: swap
    //   243: ldc_w 794
    //   246: iconst_1
    //   247: aload_2
    //   248: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   251: athrow
    //   252: new 120	gnu/mapping/WrongType
    //   255: dup_x1
    //   256: swap
    //   257: ldc_w 794
    //   260: iconst_2
    //   261: aload_3
    //   262: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   265: athrow
    //   266: new 120	gnu/mapping/WrongType
    //   269: dup_x1
    //   270: swap
    //   271: ldc_w 794
    //   274: iconst_3
    //   275: aload 4
    //   277: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: new 120	gnu/mapping/WrongType
    //   284: dup_x1
    //   285: swap
    //   286: ldc_w 794
    //   289: iconst_4
    //   290: aload 5
    //   292: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: new 120	gnu/mapping/WrongType
    //   299: dup_x1
    //   300: swap
    //   301: ldc_w 808
    //   304: iconst_1
    //   305: aload_2
    //   306: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   309: athrow
    //   310: new 120	gnu/mapping/WrongType
    //   313: dup_x1
    //   314: swap
    //   315: ldc_w 808
    //   318: iconst_2
    //   319: aload_3
    //   320: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   323: athrow
    //   324: new 120	gnu/mapping/WrongType
    //   327: dup_x1
    //   328: swap
    //   329: ldc_w 808
    //   332: iconst_3
    //   333: aload 4
    //   335: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   338: athrow
    //   339: new 120	gnu/mapping/WrongType
    //   342: dup_x1
    //   343: swap
    //   344: ldc_w 808
    //   347: iconst_4
    //   348: aload 5
    //   350: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   353: athrow
    //   354: new 120	gnu/mapping/WrongType
    //   357: dup_x1
    //   358: swap
    //   359: ldc_w 773
    //   362: iconst_1
    //   363: aload_2
    //   364: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   367: athrow
    //   368: new 120	gnu/mapping/WrongType
    //   371: dup_x1
    //   372: swap
    //   373: ldc_w 773
    //   376: iconst_2
    //   377: aload_3
    //   378: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //   382: new 120	gnu/mapping/WrongType
    //   385: dup_x1
    //   386: swap
    //   387: ldc_w 773
    //   390: iconst_3
    //   391: aload 4
    //   393: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   396: athrow
    //   397: new 120	gnu/mapping/WrongType
    //   400: dup_x1
    //   401: swap
    //   402: ldc_w 773
    //   405: iconst_4
    //   406: aload 5
    //   408: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   411: athrow
    //   412: new 120	gnu/mapping/WrongType
    //   415: dup_x1
    //   416: swap
    //   417: ldc -31
    //   419: iconst_2
    //   420: aload_3
    //   421: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   424: athrow
    //   425: new 120	gnu/mapping/WrongType
    //   428: dup_x1
    //   429: swap
    //   430: ldc -31
    //   432: iconst_3
    //   433: aload 4
    //   435: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   438: athrow
    //   439: new 120	gnu/mapping/WrongType
    //   442: dup_x1
    //   443: swap
    //   444: ldc -31
    //   446: iconst_4
    //   447: aload 5
    //   449: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   452: athrow
    // Line number table:
    //   Java source line #119	-> byte code offset #48
    //   Java source line #128	-> byte code offset #95
    //   Java source line #142	-> byte code offset #142
    //   Java source line #229	-> byte code offset #187
    //   Java source line #119	-> byte code offset #238
    //   Java source line #120	-> byte code offset #252
    //   Java source line #121	-> byte code offset #266
    //   Java source line #123	-> byte code offset #281
    //   Java source line #128	-> byte code offset #296
    //   Java source line #129	-> byte code offset #310
    //   Java source line #130	-> byte code offset #324
    //   Java source line #131	-> byte code offset #339
    //   Java source line #142	-> byte code offset #354
    //   Java source line #144	-> byte code offset #382
    //   Java source line #145	-> byte code offset #397
    //   Java source line #229	-> byte code offset #412
    //   Java source line #230	-> byte code offset #425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	this	strings
    //   0	453	1	paramModuleMethod	ModuleMethod
    //   0	453	2	paramObject1	Object
    //   0	453	3	paramObject2	Object
    //   0	453	4	paramObject3	Object
    //   0	453	5	paramObject4	Object
    //   238	1	6	localClassCastException1	ClassCastException
    //   252	1	7	localClassCastException2	ClassCastException
    //   266	1	8	localClassCastException3	ClassCastException
    //   281	1	9	localClassCastException4	ClassCastException
    //   296	1	10	localClassCastException5	ClassCastException
    //   310	1	11	localClassCastException6	ClassCastException
    //   324	1	12	localClassCastException7	ClassCastException
    //   339	1	13	localClassCastException8	ClassCastException
    //   354	1	14	localClassCastException9	ClassCastException
    //   368	1	15	localClassCastException10	ClassCastException
    //   382	1	16	localClassCastException11	ClassCastException
    //   397	1	17	localClassCastException12	ClassCastException
    //   412	1	18	localClassCastException13	ClassCastException
    //   425	1	19	localClassCastException14	ClassCastException
    //   439	1	20	localClassCastException15	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   54	57	238	java/lang/ClassCastException
    //   61	67	252	java/lang/ClassCastException
    //   74	77	266	java/lang/ClassCastException
    //   82	88	281	java/lang/ClassCastException
    //   101	104	296	java/lang/ClassCastException
    //   108	114	310	java/lang/ClassCastException
    //   119	125	324	java/lang/ClassCastException
    //   132	135	339	java/lang/ClassCastException
    //   148	151	354	java/lang/ClassCastException
    //   155	158	368	java/lang/ClassCastException
    //   163	169	382	java/lang/ClassCastException
    //   174	180	397	java/lang/ClassCastException
    //   194	197	412	java/lang/ClassCastException
    //   202	208	425	java/lang/ClassCastException
    //   213	219	439	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 640	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+2197->2201, 4:+224->228, 5:+2197->2201, 6:+2197->2201, 7:+2197->2201, 8:+229->233, 9:+304->308, 10:+379->383, 11:+454->458, 12:+529->533, 13:+2197->2201, 14:+2197->2201, 15:+2197->2201, 16:+2197->2201, 17:+2197->2201, 18:+2197->2201, 19:+2197->2201, 20:+2197->2201, 21:+604->608, 22:+2197->2201, 23:+2197->2201, 24:+715->719, 25:+2197->2201, 26:+2197->2201, 27:+2197->2201, 28:+2197->2201, 29:+2197->2201, 30:+2197->2201, 31:+2197->2201, 32:+2197->2201, 33:+2197->2201, 34:+844->848, 35:+849->853, 36:+931->935, 37:+1013->1017, 38:+1095->1099, 39:+1177->1181, 40:+1259->1263, 41:+1336->1340, 42:+1413->1417, 43:+1490->1494, 44:+1567->1571, 45:+1644->1648, 46:+1721->1725, 47:+1798->1802, 48:+1875->1879, 49:+1952->1956, 50:+2197->2201, 51:+2197->2201, 52:+2197->2201, 53:+2029->2033, 54:+2085->2089, 55:+2144->2148
    //   228: aload_2
    //   229: invokestatic 818	kawa/lib/strings:$make$string$	([Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   232: areturn
    //   233: aload_2
    //   234: iconst_0
    //   235: aaload
    //   236: ldc 12
    //   238: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   241: dup
    //   242: astore_3
    //   243: checkcast 12	java/lang/CharSequence
    //   246: aload_2
    //   247: iconst_1
    //   248: aaload
    //   249: ldc 12
    //   251: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   254: dup
    //   255: astore_3
    //   256: checkcast 12	java/lang/CharSequence
    //   259: aload_2
    //   260: arraylength
    //   261: iconst_2
    //   262: isub
    //   263: istore_3
    //   264: iload_3
    //   265: anewarray 12	java/lang/CharSequence
    //   268: goto +17 -> 285
    //   271: dup
    //   272: iload_3
    //   273: aload_2
    //   274: iload_3
    //   275: iconst_2
    //   276: iadd
    //   277: aaload
    //   278: dup
    //   279: astore 4
    //   281: checkcast 12	java/lang/CharSequence
    //   284: aastore
    //   285: iinc 3 -1
    //   288: iload_3
    //   289: ifge -18 -> 271
    //   292: invokestatic 824	kawa/lib/strings:isString$Ls	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   295: ifeq +9 -> 304
    //   298: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   301: goto +6 -> 307
    //   304: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   307: areturn
    //   308: aload_2
    //   309: iconst_0
    //   310: aaload
    //   311: ldc 12
    //   313: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   316: dup
    //   317: astore_3
    //   318: checkcast 12	java/lang/CharSequence
    //   321: aload_2
    //   322: iconst_1
    //   323: aaload
    //   324: ldc 12
    //   326: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   329: dup
    //   330: astore_3
    //   331: checkcast 12	java/lang/CharSequence
    //   334: aload_2
    //   335: arraylength
    //   336: iconst_2
    //   337: isub
    //   338: istore_3
    //   339: iload_3
    //   340: anewarray 12	java/lang/CharSequence
    //   343: goto +17 -> 360
    //   346: dup
    //   347: iload_3
    //   348: aload_2
    //   349: iload_3
    //   350: iconst_2
    //   351: iadd
    //   352: aaload
    //   353: dup
    //   354: astore 4
    //   356: checkcast 12	java/lang/CharSequence
    //   359: aastore
    //   360: iinc 3 -1
    //   363: iload_3
    //   364: ifge -18 -> 346
    //   367: invokestatic 829	kawa/lib/strings:isString$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   370: ifeq +9 -> 379
    //   373: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   376: goto +6 -> 382
    //   379: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   382: areturn
    //   383: aload_2
    //   384: iconst_0
    //   385: aaload
    //   386: ldc 12
    //   388: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   391: dup
    //   392: astore_3
    //   393: checkcast 12	java/lang/CharSequence
    //   396: aload_2
    //   397: iconst_1
    //   398: aaload
    //   399: ldc 12
    //   401: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   404: dup
    //   405: astore_3
    //   406: checkcast 12	java/lang/CharSequence
    //   409: aload_2
    //   410: arraylength
    //   411: iconst_2
    //   412: isub
    //   413: istore_3
    //   414: iload_3
    //   415: anewarray 12	java/lang/CharSequence
    //   418: goto +17 -> 435
    //   421: dup
    //   422: iload_3
    //   423: aload_2
    //   424: iload_3
    //   425: iconst_2
    //   426: iadd
    //   427: aaload
    //   428: dup
    //   429: astore 4
    //   431: checkcast 12	java/lang/CharSequence
    //   434: aastore
    //   435: iinc 3 -1
    //   438: iload_3
    //   439: ifge -18 -> 421
    //   442: invokestatic 834	kawa/lib/strings:isString$Gr	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   445: ifeq +9 -> 454
    //   448: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   451: goto +6 -> 457
    //   454: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   457: areturn
    //   458: aload_2
    //   459: iconst_0
    //   460: aaload
    //   461: ldc 12
    //   463: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   466: dup
    //   467: astore_3
    //   468: checkcast 12	java/lang/CharSequence
    //   471: aload_2
    //   472: iconst_1
    //   473: aaload
    //   474: ldc 12
    //   476: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   479: dup
    //   480: astore_3
    //   481: checkcast 12	java/lang/CharSequence
    //   484: aload_2
    //   485: arraylength
    //   486: iconst_2
    //   487: isub
    //   488: istore_3
    //   489: iload_3
    //   490: anewarray 12	java/lang/CharSequence
    //   493: goto +17 -> 510
    //   496: dup
    //   497: iload_3
    //   498: aload_2
    //   499: iload_3
    //   500: iconst_2
    //   501: iadd
    //   502: aaload
    //   503: dup
    //   504: astore 4
    //   506: checkcast 12	java/lang/CharSequence
    //   509: aastore
    //   510: iinc 3 -1
    //   513: iload_3
    //   514: ifge -18 -> 496
    //   517: invokestatic 839	kawa/lib/strings:isString$Ls$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   520: ifeq +9 -> 529
    //   523: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   526: goto +6 -> 532
    //   529: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   532: areturn
    //   533: aload_2
    //   534: iconst_0
    //   535: aaload
    //   536: ldc 12
    //   538: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   541: dup
    //   542: astore_3
    //   543: checkcast 12	java/lang/CharSequence
    //   546: aload_2
    //   547: iconst_1
    //   548: aaload
    //   549: ldc 12
    //   551: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   554: dup
    //   555: astore_3
    //   556: checkcast 12	java/lang/CharSequence
    //   559: aload_2
    //   560: arraylength
    //   561: iconst_2
    //   562: isub
    //   563: istore_3
    //   564: iload_3
    //   565: anewarray 12	java/lang/CharSequence
    //   568: goto +17 -> 585
    //   571: dup
    //   572: iload_3
    //   573: aload_2
    //   574: iload_3
    //   575: iconst_2
    //   576: iadd
    //   577: aaload
    //   578: dup
    //   579: astore 4
    //   581: checkcast 12	java/lang/CharSequence
    //   584: aastore
    //   585: iinc 3 -1
    //   588: iload_3
    //   589: ifge -18 -> 571
    //   592: invokestatic 844	kawa/lib/strings:isString$Gr$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   595: ifeq +9 -> 604
    //   598: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   601: goto +6 -> 607
    //   604: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   607: areturn
    //   608: aload_2
    //   609: arraylength
    //   610: iconst_3
    //   611: isub
    //   612: istore_3
    //   613: aload_2
    //   614: iconst_0
    //   615: aaload
    //   616: ldc 20
    //   618: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   621: dup
    //   622: astore 4
    //   624: checkcast 20	gnu/lists/FString
    //   627: aload_2
    //   628: iconst_1
    //   629: aaload
    //   630: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   633: dup
    //   634: astore 4
    //   636: checkcast 222	java/lang/Number
    //   639: invokevirtual 223	java/lang/Number:intValue	()I
    //   642: aload_2
    //   643: iconst_2
    //   644: aaload
    //   645: ldc 12
    //   647: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   650: dup
    //   651: astore 4
    //   653: checkcast 12	java/lang/CharSequence
    //   656: iload_3
    //   657: ifgt +9 -> 666
    //   660: invokestatic 797	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;)V
    //   663: goto +52 -> 715
    //   666: iinc 3 -1
    //   669: aload_2
    //   670: iconst_3
    //   671: aaload
    //   672: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   675: dup
    //   676: astore 4
    //   678: checkcast 222	java/lang/Number
    //   681: invokevirtual 223	java/lang/Number:intValue	()I
    //   684: iload_3
    //   685: ifgt +9 -> 694
    //   688: invokestatic 155	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;I)V
    //   691: goto +24 -> 715
    //   694: iinc 3 -1
    //   697: aload_2
    //   698: iconst_4
    //   699: aaload
    //   700: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   703: dup
    //   704: astore 4
    //   706: checkcast 222	java/lang/Number
    //   709: invokevirtual 223	java/lang/Number:intValue	()I
    //   712: invokestatic 158	kawa/lib/strings:stringCopy$Ex	(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
    //   715: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   718: areturn
    //   719: aload_2
    //   720: arraylength
    //   721: iconst_4
    //   722: isub
    //   723: istore 4
    //   725: aload_2
    //   726: iconst_0
    //   727: aaload
    //   728: ldc 20
    //   730: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   733: dup
    //   734: astore 5
    //   736: checkcast 20	gnu/lists/FString
    //   739: aload_2
    //   740: iconst_1
    //   741: aaload
    //   742: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   745: dup
    //   746: astore 5
    //   748: checkcast 222	java/lang/Number
    //   751: invokevirtual 223	java/lang/Number:intValue	()I
    //   754: aload_2
    //   755: iconst_2
    //   756: aaload
    //   757: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   760: dup
    //   761: astore 5
    //   763: checkcast 222	java/lang/Number
    //   766: invokevirtual 223	java/lang/Number:intValue	()I
    //   769: aload_2
    //   770: iconst_3
    //   771: aaload
    //   772: ldc 12
    //   774: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   777: dup
    //   778: astore 5
    //   780: checkcast 12	java/lang/CharSequence
    //   783: iload 4
    //   785: ifgt +9 -> 794
    //   788: invokestatic 811	kawa/lib/strings:stringReplace$Ex	(Lgnu/lists/FString;IILjava/lang/CharSequence;)V
    //   791: goto +53 -> 844
    //   794: iinc 4 -1
    //   797: aload_2
    //   798: iconst_4
    //   799: aaload
    //   800: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   803: dup
    //   804: astore 5
    //   806: checkcast 222	java/lang/Number
    //   809: invokevirtual 223	java/lang/Number:intValue	()I
    //   812: iload 4
    //   814: ifgt +9 -> 823
    //   817: invokestatic 847	kawa/lib/strings:stringReplace$Ex	(Lgnu/lists/FString;IILjava/lang/CharSequence;I)V
    //   820: goto +24 -> 844
    //   823: iinc 4 -1
    //   826: aload_2
    //   827: iconst_5
    //   828: aaload
    //   829: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   832: dup
    //   833: astore 5
    //   835: checkcast 222	java/lang/Number
    //   838: invokevirtual 223	java/lang/Number:intValue	()I
    //   841: invokestatic 162	kawa/lib/strings:stringReplace$Ex	(Lgnu/lists/FString;IILjava/lang/CharSequence;II)V
    //   844: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   847: areturn
    //   848: aload_2
    //   849: invokestatic 851	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   852: areturn
    //   853: aload_2
    //   854: iconst_0
    //   855: aaload
    //   856: ldc 12
    //   858: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   861: dup
    //   862: astore 5
    //   864: checkcast 12	java/lang/CharSequence
    //   867: aload_2
    //   868: iconst_1
    //   869: aaload
    //   870: ldc 12
    //   872: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   875: dup
    //   876: astore 5
    //   878: checkcast 12	java/lang/CharSequence
    //   881: aload_2
    //   882: arraylength
    //   883: iconst_2
    //   884: isub
    //   885: istore 5
    //   887: iload 5
    //   889: anewarray 12	java/lang/CharSequence
    //   892: goto +19 -> 911
    //   895: dup
    //   896: iload 5
    //   898: aload_2
    //   899: iload 5
    //   901: iconst_2
    //   902: iadd
    //   903: aaload
    //   904: dup
    //   905: astore 6
    //   907: checkcast 12	java/lang/CharSequence
    //   910: aastore
    //   911: iinc 5 -1
    //   914: iload 5
    //   916: ifge -21 -> 895
    //   919: invokestatic 856	kawa/lib/strings:isStringCi$Ls	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   922: ifeq +9 -> 931
    //   925: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   928: goto +6 -> 934
    //   931: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   934: areturn
    //   935: aload_2
    //   936: iconst_0
    //   937: aaload
    //   938: ldc 12
    //   940: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   943: dup
    //   944: astore 5
    //   946: checkcast 12	java/lang/CharSequence
    //   949: aload_2
    //   950: iconst_1
    //   951: aaload
    //   952: ldc 12
    //   954: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   957: dup
    //   958: astore 5
    //   960: checkcast 12	java/lang/CharSequence
    //   963: aload_2
    //   964: arraylength
    //   965: iconst_2
    //   966: isub
    //   967: istore 5
    //   969: iload 5
    //   971: anewarray 12	java/lang/CharSequence
    //   974: goto +19 -> 993
    //   977: dup
    //   978: iload 5
    //   980: aload_2
    //   981: iload 5
    //   983: iconst_2
    //   984: iadd
    //   985: aaload
    //   986: dup
    //   987: astore 6
    //   989: checkcast 12	java/lang/CharSequence
    //   992: aastore
    //   993: iinc 5 -1
    //   996: iload 5
    //   998: ifge -21 -> 977
    //   1001: invokestatic 861	kawa/lib/strings:isStringCi$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   1004: ifeq +9 -> 1013
    //   1007: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1010: goto +6 -> 1016
    //   1013: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1016: areturn
    //   1017: aload_2
    //   1018: iconst_0
    //   1019: aaload
    //   1020: ldc 12
    //   1022: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1025: dup
    //   1026: astore 5
    //   1028: checkcast 12	java/lang/CharSequence
    //   1031: aload_2
    //   1032: iconst_1
    //   1033: aaload
    //   1034: ldc 12
    //   1036: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1039: dup
    //   1040: astore 5
    //   1042: checkcast 12	java/lang/CharSequence
    //   1045: aload_2
    //   1046: arraylength
    //   1047: iconst_2
    //   1048: isub
    //   1049: istore 5
    //   1051: iload 5
    //   1053: anewarray 12	java/lang/CharSequence
    //   1056: goto +19 -> 1075
    //   1059: dup
    //   1060: iload 5
    //   1062: aload_2
    //   1063: iload 5
    //   1065: iconst_2
    //   1066: iadd
    //   1067: aaload
    //   1068: dup
    //   1069: astore 6
    //   1071: checkcast 12	java/lang/CharSequence
    //   1074: aastore
    //   1075: iinc 5 -1
    //   1078: iload 5
    //   1080: ifge -21 -> 1059
    //   1083: invokestatic 866	kawa/lib/strings:isStringCi$Gr	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   1086: ifeq +9 -> 1095
    //   1089: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1092: goto +6 -> 1098
    //   1095: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1098: areturn
    //   1099: aload_2
    //   1100: iconst_0
    //   1101: aaload
    //   1102: ldc 12
    //   1104: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1107: dup
    //   1108: astore 5
    //   1110: checkcast 12	java/lang/CharSequence
    //   1113: aload_2
    //   1114: iconst_1
    //   1115: aaload
    //   1116: ldc 12
    //   1118: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1121: dup
    //   1122: astore 5
    //   1124: checkcast 12	java/lang/CharSequence
    //   1127: aload_2
    //   1128: arraylength
    //   1129: iconst_2
    //   1130: isub
    //   1131: istore 5
    //   1133: iload 5
    //   1135: anewarray 12	java/lang/CharSequence
    //   1138: goto +19 -> 1157
    //   1141: dup
    //   1142: iload 5
    //   1144: aload_2
    //   1145: iload 5
    //   1147: iconst_2
    //   1148: iadd
    //   1149: aaload
    //   1150: dup
    //   1151: astore 6
    //   1153: checkcast 12	java/lang/CharSequence
    //   1156: aastore
    //   1157: iinc 5 -1
    //   1160: iload 5
    //   1162: ifge -21 -> 1141
    //   1165: invokestatic 871	kawa/lib/strings:isStringCi$Ls$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   1168: ifeq +9 -> 1177
    //   1171: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1174: goto +6 -> 1180
    //   1177: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1180: areturn
    //   1181: aload_2
    //   1182: iconst_0
    //   1183: aaload
    //   1184: ldc 12
    //   1186: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1189: dup
    //   1190: astore 5
    //   1192: checkcast 12	java/lang/CharSequence
    //   1195: aload_2
    //   1196: iconst_1
    //   1197: aaload
    //   1198: ldc 12
    //   1200: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1203: dup
    //   1204: astore 5
    //   1206: checkcast 12	java/lang/CharSequence
    //   1209: aload_2
    //   1210: arraylength
    //   1211: iconst_2
    //   1212: isub
    //   1213: istore 5
    //   1215: iload 5
    //   1217: anewarray 12	java/lang/CharSequence
    //   1220: goto +19 -> 1239
    //   1223: dup
    //   1224: iload 5
    //   1226: aload_2
    //   1227: iload 5
    //   1229: iconst_2
    //   1230: iadd
    //   1231: aaload
    //   1232: dup
    //   1233: astore 6
    //   1235: checkcast 12	java/lang/CharSequence
    //   1238: aastore
    //   1239: iinc 5 -1
    //   1242: iload 5
    //   1244: ifge -21 -> 1223
    //   1247: invokestatic 876	kawa/lib/strings:isStringCi$Gr$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    //   1250: ifeq +9 -> 1259
    //   1253: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1256: goto +6 -> 1262
    //   1259: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1262: areturn
    //   1263: aload_2
    //   1264: iconst_0
    //   1265: aaload
    //   1266: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1269: dup
    //   1270: astore 5
    //   1272: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1275: aload_2
    //   1276: iconst_1
    //   1277: aaload
    //   1278: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1281: dup
    //   1282: astore 5
    //   1284: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1287: aload_2
    //   1288: arraylength
    //   1289: iconst_2
    //   1290: isub
    //   1291: istore 5
    //   1293: iload 5
    //   1295: newarray int
    //   1297: goto +19 -> 1316
    //   1300: dup
    //   1301: iload 5
    //   1303: aload_2
    //   1304: iload 5
    //   1306: iconst_2
    //   1307: iadd
    //   1308: aaload
    //   1309: dup
    //   1310: astore 6
    //   1312: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1315: iastore
    //   1316: iinc 5 -1
    //   1319: iload 5
    //   1321: ifge -21 -> 1300
    //   1324: invokestatic 882	kawa/lib/strings:isChar$Eq	(II[I)Z
    //   1327: ifeq +9 -> 1336
    //   1330: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1333: goto +6 -> 1339
    //   1336: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1339: areturn
    //   1340: aload_2
    //   1341: iconst_0
    //   1342: aaload
    //   1343: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1346: dup
    //   1347: astore 5
    //   1349: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1352: aload_2
    //   1353: iconst_1
    //   1354: aaload
    //   1355: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1358: dup
    //   1359: astore 5
    //   1361: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1364: aload_2
    //   1365: arraylength
    //   1366: iconst_2
    //   1367: isub
    //   1368: istore 5
    //   1370: iload 5
    //   1372: newarray int
    //   1374: goto +19 -> 1393
    //   1377: dup
    //   1378: iload 5
    //   1380: aload_2
    //   1381: iload 5
    //   1383: iconst_2
    //   1384: iadd
    //   1385: aaload
    //   1386: dup
    //   1387: astore 6
    //   1389: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1392: iastore
    //   1393: iinc 5 -1
    //   1396: iload 5
    //   1398: ifge -21 -> 1377
    //   1401: invokestatic 887	kawa/lib/strings:isChar$Ls	(II[I)Z
    //   1404: ifeq +9 -> 1413
    //   1407: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1410: goto +6 -> 1416
    //   1413: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1416: areturn
    //   1417: aload_2
    //   1418: iconst_0
    //   1419: aaload
    //   1420: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1423: dup
    //   1424: astore 5
    //   1426: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1429: aload_2
    //   1430: iconst_1
    //   1431: aaload
    //   1432: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1435: dup
    //   1436: astore 5
    //   1438: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1441: aload_2
    //   1442: arraylength
    //   1443: iconst_2
    //   1444: isub
    //   1445: istore 5
    //   1447: iload 5
    //   1449: newarray int
    //   1451: goto +19 -> 1470
    //   1454: dup
    //   1455: iload 5
    //   1457: aload_2
    //   1458: iload 5
    //   1460: iconst_2
    //   1461: iadd
    //   1462: aaload
    //   1463: dup
    //   1464: astore 6
    //   1466: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1469: iastore
    //   1470: iinc 5 -1
    //   1473: iload 5
    //   1475: ifge -21 -> 1454
    //   1478: invokestatic 892	kawa/lib/strings:isChar$Gr	(II[I)Z
    //   1481: ifeq +9 -> 1490
    //   1484: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1487: goto +6 -> 1493
    //   1490: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1493: areturn
    //   1494: aload_2
    //   1495: iconst_0
    //   1496: aaload
    //   1497: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1500: dup
    //   1501: astore 5
    //   1503: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1506: aload_2
    //   1507: iconst_1
    //   1508: aaload
    //   1509: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1512: dup
    //   1513: astore 5
    //   1515: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1518: aload_2
    //   1519: arraylength
    //   1520: iconst_2
    //   1521: isub
    //   1522: istore 5
    //   1524: iload 5
    //   1526: newarray int
    //   1528: goto +19 -> 1547
    //   1531: dup
    //   1532: iload 5
    //   1534: aload_2
    //   1535: iload 5
    //   1537: iconst_2
    //   1538: iadd
    //   1539: aaload
    //   1540: dup
    //   1541: astore 6
    //   1543: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1546: iastore
    //   1547: iinc 5 -1
    //   1550: iload 5
    //   1552: ifge -21 -> 1531
    //   1555: invokestatic 897	kawa/lib/strings:isChar$Ls$Eq	(II[I)Z
    //   1558: ifeq +9 -> 1567
    //   1561: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1564: goto +6 -> 1570
    //   1567: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1570: areturn
    //   1571: aload_2
    //   1572: iconst_0
    //   1573: aaload
    //   1574: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1577: dup
    //   1578: astore 5
    //   1580: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1583: aload_2
    //   1584: iconst_1
    //   1585: aaload
    //   1586: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1589: dup
    //   1590: astore 5
    //   1592: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1595: aload_2
    //   1596: arraylength
    //   1597: iconst_2
    //   1598: isub
    //   1599: istore 5
    //   1601: iload 5
    //   1603: newarray int
    //   1605: goto +19 -> 1624
    //   1608: dup
    //   1609: iload 5
    //   1611: aload_2
    //   1612: iload 5
    //   1614: iconst_2
    //   1615: iadd
    //   1616: aaload
    //   1617: dup
    //   1618: astore 6
    //   1620: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1623: iastore
    //   1624: iinc 5 -1
    //   1627: iload 5
    //   1629: ifge -21 -> 1608
    //   1632: invokestatic 902	kawa/lib/strings:isChar$Gr$Eq	(II[I)Z
    //   1635: ifeq +9 -> 1644
    //   1638: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1641: goto +6 -> 1647
    //   1644: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1647: areturn
    //   1648: aload_2
    //   1649: iconst_0
    //   1650: aaload
    //   1651: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1654: dup
    //   1655: astore 5
    //   1657: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1660: aload_2
    //   1661: iconst_1
    //   1662: aaload
    //   1663: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1666: dup
    //   1667: astore 5
    //   1669: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1672: aload_2
    //   1673: arraylength
    //   1674: iconst_2
    //   1675: isub
    //   1676: istore 5
    //   1678: iload 5
    //   1680: newarray int
    //   1682: goto +19 -> 1701
    //   1685: dup
    //   1686: iload 5
    //   1688: aload_2
    //   1689: iload 5
    //   1691: iconst_2
    //   1692: iadd
    //   1693: aaload
    //   1694: dup
    //   1695: astore 6
    //   1697: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1700: iastore
    //   1701: iinc 5 -1
    //   1704: iload 5
    //   1706: ifge -21 -> 1685
    //   1709: invokestatic 907	kawa/lib/strings:isCharCi$Eq	(II[I)Z
    //   1712: ifeq +9 -> 1721
    //   1715: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1718: goto +6 -> 1724
    //   1721: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1724: areturn
    //   1725: aload_2
    //   1726: iconst_0
    //   1727: aaload
    //   1728: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1731: dup
    //   1732: astore 5
    //   1734: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1737: aload_2
    //   1738: iconst_1
    //   1739: aaload
    //   1740: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1743: dup
    //   1744: astore 5
    //   1746: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1749: aload_2
    //   1750: arraylength
    //   1751: iconst_2
    //   1752: isub
    //   1753: istore 5
    //   1755: iload 5
    //   1757: newarray int
    //   1759: goto +19 -> 1778
    //   1762: dup
    //   1763: iload 5
    //   1765: aload_2
    //   1766: iload 5
    //   1768: iconst_2
    //   1769: iadd
    //   1770: aaload
    //   1771: dup
    //   1772: astore 6
    //   1774: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1777: iastore
    //   1778: iinc 5 -1
    //   1781: iload 5
    //   1783: ifge -21 -> 1762
    //   1786: invokestatic 912	kawa/lib/strings:isCharCi$Ls	(II[I)Z
    //   1789: ifeq +9 -> 1798
    //   1792: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1795: goto +6 -> 1801
    //   1798: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1801: areturn
    //   1802: aload_2
    //   1803: iconst_0
    //   1804: aaload
    //   1805: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1808: dup
    //   1809: astore 5
    //   1811: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1814: aload_2
    //   1815: iconst_1
    //   1816: aaload
    //   1817: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1820: dup
    //   1821: astore 5
    //   1823: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1826: aload_2
    //   1827: arraylength
    //   1828: iconst_2
    //   1829: isub
    //   1830: istore 5
    //   1832: iload 5
    //   1834: newarray int
    //   1836: goto +19 -> 1855
    //   1839: dup
    //   1840: iload 5
    //   1842: aload_2
    //   1843: iload 5
    //   1845: iconst_2
    //   1846: iadd
    //   1847: aaload
    //   1848: dup
    //   1849: astore 6
    //   1851: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1854: iastore
    //   1855: iinc 5 -1
    //   1858: iload 5
    //   1860: ifge -21 -> 1839
    //   1863: invokestatic 917	kawa/lib/strings:isCharCi$Gr	(II[I)Z
    //   1866: ifeq +9 -> 1875
    //   1869: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1872: goto +6 -> 1878
    //   1875: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1878: areturn
    //   1879: aload_2
    //   1880: iconst_0
    //   1881: aaload
    //   1882: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1885: dup
    //   1886: astore 5
    //   1888: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1891: aload_2
    //   1892: iconst_1
    //   1893: aaload
    //   1894: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1897: dup
    //   1898: astore 5
    //   1900: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1903: aload_2
    //   1904: arraylength
    //   1905: iconst_2
    //   1906: isub
    //   1907: istore 5
    //   1909: iload 5
    //   1911: newarray int
    //   1913: goto +19 -> 1932
    //   1916: dup
    //   1917: iload 5
    //   1919: aload_2
    //   1920: iload 5
    //   1922: iconst_2
    //   1923: iadd
    //   1924: aaload
    //   1925: dup
    //   1926: astore 6
    //   1928: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1931: iastore
    //   1932: iinc 5 -1
    //   1935: iload 5
    //   1937: ifge -21 -> 1916
    //   1940: invokestatic 922	kawa/lib/strings:isCharCi$Ls$Eq	(II[I)Z
    //   1943: ifeq +9 -> 1952
    //   1946: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1949: goto +6 -> 1955
    //   1952: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1955: areturn
    //   1956: aload_2
    //   1957: iconst_0
    //   1958: aaload
    //   1959: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1962: dup
    //   1963: astore 5
    //   1965: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1968: aload_2
    //   1969: iconst_1
    //   1970: aaload
    //   1971: invokestatic 132	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1974: dup
    //   1975: astore 5
    //   1977: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1980: aload_2
    //   1981: arraylength
    //   1982: iconst_2
    //   1983: isub
    //   1984: istore 5
    //   1986: iload 5
    //   1988: newarray int
    //   1990: goto +19 -> 2009
    //   1993: dup
    //   1994: iload 5
    //   1996: aload_2
    //   1997: iload 5
    //   1999: iconst_2
    //   2000: iadd
    //   2001: aaload
    //   2002: dup
    //   2003: astore 6
    //   2005: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   2008: iastore
    //   2009: iinc 5 -1
    //   2012: iload 5
    //   2014: ifge -21 -> 1993
    //   2017: invokestatic 927	kawa/lib/strings:isCharCi$Gr$Eq	(II[I)Z
    //   2020: ifeq +9 -> 2029
    //   2023: getstatic 704	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2026: goto +6 -> 2032
    //   2029: getstatic 707	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2032: areturn
    //   2033: aload_2
    //   2034: iconst_0
    //   2035: aaload
    //   2036: aload_2
    //   2037: iconst_1
    //   2038: aaload
    //   2039: ldc 12
    //   2041: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2044: dup
    //   2045: astore 5
    //   2047: checkcast 12	java/lang/CharSequence
    //   2050: aload_2
    //   2051: arraylength
    //   2052: iconst_2
    //   2053: isub
    //   2054: istore 5
    //   2056: iload 5
    //   2058: anewarray 246	java/lang/Object
    //   2061: goto +13 -> 2074
    //   2064: dup
    //   2065: iload 5
    //   2067: aload_2
    //   2068: iload 5
    //   2070: iconst_2
    //   2071: iadd
    //   2072: aaload
    //   2073: aastore
    //   2074: iinc 5 -1
    //   2077: iload 5
    //   2079: ifge -15 -> 2064
    //   2082: invokestatic 933	kawa/lib/strings:stringForEach	(Ljava/lang/Object;Ljava/lang/CharSequence;[Ljava/lang/Object;)V
    //   2085: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   2088: areturn
    //   2089: aload_2
    //   2090: iconst_0
    //   2091: aaload
    //   2092: aload_2
    //   2093: iconst_1
    //   2094: aaload
    //   2095: ldc 12
    //   2097: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2100: dup
    //   2101: astore 5
    //   2103: checkcast 12	java/lang/CharSequence
    //   2106: aload_2
    //   2107: arraylength
    //   2108: iconst_2
    //   2109: isub
    //   2110: istore 5
    //   2112: iload 5
    //   2114: anewarray 12	java/lang/CharSequence
    //   2117: goto +19 -> 2136
    //   2120: dup
    //   2121: iload 5
    //   2123: aload_2
    //   2124: iload 5
    //   2126: iconst_2
    //   2127: iadd
    //   2128: aaload
    //   2129: dup
    //   2130: astore 6
    //   2132: checkcast 12	java/lang/CharSequence
    //   2135: aastore
    //   2136: iinc 5 -1
    //   2139: iload 5
    //   2141: ifge -21 -> 2120
    //   2144: invokestatic 939	kawa/lib/strings:stringMap	(Ljava/lang/Object;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   2147: areturn
    //   2148: aload_2
    //   2149: iconst_0
    //   2150: aaload
    //   2151: ldc 20
    //   2153: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2156: dup
    //   2157: astore 5
    //   2159: checkcast 20	gnu/lists/FString
    //   2162: aload_2
    //   2163: arraylength
    //   2164: iconst_1
    //   2165: isub
    //   2166: istore 5
    //   2168: iload 5
    //   2170: anewarray 246	java/lang/Object
    //   2173: goto +13 -> 2186
    //   2176: dup
    //   2177: iload 5
    //   2179: aload_2
    //   2180: iload 5
    //   2182: iconst_1
    //   2183: iadd
    //   2184: aaload
    //   2185: aastore
    //   2186: iinc 5 -1
    //   2189: iload 5
    //   2191: ifge -15 -> 2176
    //   2194: invokestatic 945	kawa/lib/strings:stringAppend$Ex	(Lgnu/lists/FString;[Ljava/lang/Object;)V
    //   2197: getstatic 782	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   2200: areturn
    //   2201: aload_0
    //   2202: aload_1
    //   2203: aload_2
    //   2204: invokespecial 948	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2207: areturn
    //   2208: new 120	gnu/mapping/WrongType
    //   2211: dup_x1
    //   2212: swap
    //   2213: ldc_w 820
    //   2216: iconst_1
    //   2217: aload_3
    //   2218: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2221: athrow
    //   2222: new 120	gnu/mapping/WrongType
    //   2225: dup_x1
    //   2226: swap
    //   2227: ldc_w 820
    //   2230: iconst_2
    //   2231: aload_3
    //   2232: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2235: athrow
    //   2236: new 120	gnu/mapping/WrongType
    //   2239: dup_x1
    //   2240: swap
    //   2241: ldc_w 820
    //   2244: iconst_0
    //   2245: aload 4
    //   2247: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2250: athrow
    //   2251: new 120	gnu/mapping/WrongType
    //   2254: dup_x1
    //   2255: swap
    //   2256: ldc_w 826
    //   2259: iconst_1
    //   2260: aload_3
    //   2261: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2264: athrow
    //   2265: new 120	gnu/mapping/WrongType
    //   2268: dup_x1
    //   2269: swap
    //   2270: ldc_w 826
    //   2273: iconst_2
    //   2274: aload_3
    //   2275: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2278: athrow
    //   2279: new 120	gnu/mapping/WrongType
    //   2282: dup_x1
    //   2283: swap
    //   2284: ldc_w 826
    //   2287: iconst_0
    //   2288: aload 4
    //   2290: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2293: athrow
    //   2294: new 120	gnu/mapping/WrongType
    //   2297: dup_x1
    //   2298: swap
    //   2299: ldc_w 831
    //   2302: iconst_1
    //   2303: aload_3
    //   2304: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2307: athrow
    //   2308: new 120	gnu/mapping/WrongType
    //   2311: dup_x1
    //   2312: swap
    //   2313: ldc_w 831
    //   2316: iconst_2
    //   2317: aload_3
    //   2318: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2321: athrow
    //   2322: new 120	gnu/mapping/WrongType
    //   2325: dup_x1
    //   2326: swap
    //   2327: ldc_w 831
    //   2330: iconst_0
    //   2331: aload 4
    //   2333: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2336: athrow
    //   2337: new 120	gnu/mapping/WrongType
    //   2340: dup_x1
    //   2341: swap
    //   2342: ldc_w 836
    //   2345: iconst_1
    //   2346: aload_3
    //   2347: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2350: athrow
    //   2351: new 120	gnu/mapping/WrongType
    //   2354: dup_x1
    //   2355: swap
    //   2356: ldc_w 836
    //   2359: iconst_2
    //   2360: aload_3
    //   2361: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2364: athrow
    //   2365: new 120	gnu/mapping/WrongType
    //   2368: dup_x1
    //   2369: swap
    //   2370: ldc_w 836
    //   2373: iconst_0
    //   2374: aload 4
    //   2376: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2379: athrow
    //   2380: new 120	gnu/mapping/WrongType
    //   2383: dup_x1
    //   2384: swap
    //   2385: ldc_w 841
    //   2388: iconst_1
    //   2389: aload_3
    //   2390: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2393: athrow
    //   2394: new 120	gnu/mapping/WrongType
    //   2397: dup_x1
    //   2398: swap
    //   2399: ldc_w 841
    //   2402: iconst_2
    //   2403: aload_3
    //   2404: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2407: athrow
    //   2408: new 120	gnu/mapping/WrongType
    //   2411: dup_x1
    //   2412: swap
    //   2413: ldc_w 841
    //   2416: iconst_0
    //   2417: aload 4
    //   2419: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2422: athrow
    //   2423: new 120	gnu/mapping/WrongType
    //   2426: dup_x1
    //   2427: swap
    //   2428: ldc_w 794
    //   2431: iconst_1
    //   2432: aload 4
    //   2434: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2437: athrow
    //   2438: new 120	gnu/mapping/WrongType
    //   2441: dup_x1
    //   2442: swap
    //   2443: ldc_w 794
    //   2446: iconst_2
    //   2447: aload 4
    //   2449: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2452: athrow
    //   2453: new 120	gnu/mapping/WrongType
    //   2456: dup_x1
    //   2457: swap
    //   2458: ldc_w 794
    //   2461: iconst_3
    //   2462: aload 4
    //   2464: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2467: athrow
    //   2468: new 120	gnu/mapping/WrongType
    //   2471: dup_x1
    //   2472: swap
    //   2473: ldc_w 794
    //   2476: iconst_4
    //   2477: aload 4
    //   2479: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2482: athrow
    //   2483: new 120	gnu/mapping/WrongType
    //   2486: dup_x1
    //   2487: swap
    //   2488: ldc_w 794
    //   2491: iconst_5
    //   2492: aload 4
    //   2494: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2497: athrow
    //   2498: new 120	gnu/mapping/WrongType
    //   2501: dup_x1
    //   2502: swap
    //   2503: ldc_w 808
    //   2506: iconst_1
    //   2507: aload 5
    //   2509: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2512: athrow
    //   2513: new 120	gnu/mapping/WrongType
    //   2516: dup_x1
    //   2517: swap
    //   2518: ldc_w 808
    //   2521: iconst_2
    //   2522: aload 5
    //   2524: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2527: athrow
    //   2528: new 120	gnu/mapping/WrongType
    //   2531: dup_x1
    //   2532: swap
    //   2533: ldc_w 808
    //   2536: iconst_3
    //   2537: aload 5
    //   2539: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2542: athrow
    //   2543: new 120	gnu/mapping/WrongType
    //   2546: dup_x1
    //   2547: swap
    //   2548: ldc_w 808
    //   2551: iconst_4
    //   2552: aload 5
    //   2554: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2557: athrow
    //   2558: new 120	gnu/mapping/WrongType
    //   2561: dup_x1
    //   2562: swap
    //   2563: ldc_w 808
    //   2566: iconst_5
    //   2567: aload 5
    //   2569: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2572: athrow
    //   2573: new 120	gnu/mapping/WrongType
    //   2576: dup_x1
    //   2577: swap
    //   2578: ldc_w 808
    //   2581: bipush 6
    //   2583: aload 5
    //   2585: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2588: athrow
    //   2589: new 120	gnu/mapping/WrongType
    //   2592: dup_x1
    //   2593: swap
    //   2594: ldc_w 853
    //   2597: iconst_1
    //   2598: aload 5
    //   2600: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2603: athrow
    //   2604: new 120	gnu/mapping/WrongType
    //   2607: dup_x1
    //   2608: swap
    //   2609: ldc_w 853
    //   2612: iconst_2
    //   2613: aload 5
    //   2615: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2618: athrow
    //   2619: new 120	gnu/mapping/WrongType
    //   2622: dup_x1
    //   2623: swap
    //   2624: ldc_w 853
    //   2627: iconst_0
    //   2628: aload 6
    //   2630: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2633: athrow
    //   2634: new 120	gnu/mapping/WrongType
    //   2637: dup_x1
    //   2638: swap
    //   2639: ldc_w 858
    //   2642: iconst_1
    //   2643: aload 5
    //   2645: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2648: athrow
    //   2649: new 120	gnu/mapping/WrongType
    //   2652: dup_x1
    //   2653: swap
    //   2654: ldc_w 858
    //   2657: iconst_2
    //   2658: aload 5
    //   2660: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2663: athrow
    //   2664: new 120	gnu/mapping/WrongType
    //   2667: dup_x1
    //   2668: swap
    //   2669: ldc_w 858
    //   2672: iconst_0
    //   2673: aload 6
    //   2675: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2678: athrow
    //   2679: new 120	gnu/mapping/WrongType
    //   2682: dup_x1
    //   2683: swap
    //   2684: ldc_w 863
    //   2687: iconst_1
    //   2688: aload 5
    //   2690: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2693: athrow
    //   2694: new 120	gnu/mapping/WrongType
    //   2697: dup_x1
    //   2698: swap
    //   2699: ldc_w 863
    //   2702: iconst_2
    //   2703: aload 5
    //   2705: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2708: athrow
    //   2709: new 120	gnu/mapping/WrongType
    //   2712: dup_x1
    //   2713: swap
    //   2714: ldc_w 863
    //   2717: iconst_0
    //   2718: aload 6
    //   2720: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2723: athrow
    //   2724: new 120	gnu/mapping/WrongType
    //   2727: dup_x1
    //   2728: swap
    //   2729: ldc_w 868
    //   2732: iconst_1
    //   2733: aload 5
    //   2735: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2738: athrow
    //   2739: new 120	gnu/mapping/WrongType
    //   2742: dup_x1
    //   2743: swap
    //   2744: ldc_w 868
    //   2747: iconst_2
    //   2748: aload 5
    //   2750: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2753: athrow
    //   2754: new 120	gnu/mapping/WrongType
    //   2757: dup_x1
    //   2758: swap
    //   2759: ldc_w 868
    //   2762: iconst_0
    //   2763: aload 6
    //   2765: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2768: athrow
    //   2769: new 120	gnu/mapping/WrongType
    //   2772: dup_x1
    //   2773: swap
    //   2774: ldc_w 873
    //   2777: iconst_1
    //   2778: aload 5
    //   2780: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2783: athrow
    //   2784: new 120	gnu/mapping/WrongType
    //   2787: dup_x1
    //   2788: swap
    //   2789: ldc_w 873
    //   2792: iconst_2
    //   2793: aload 5
    //   2795: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2798: athrow
    //   2799: new 120	gnu/mapping/WrongType
    //   2802: dup_x1
    //   2803: swap
    //   2804: ldc_w 873
    //   2807: iconst_0
    //   2808: aload 6
    //   2810: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2813: athrow
    //   2814: new 120	gnu/mapping/WrongType
    //   2817: dup_x1
    //   2818: swap
    //   2819: ldc_w 878
    //   2822: iconst_1
    //   2823: aload 5
    //   2825: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2828: athrow
    //   2829: new 120	gnu/mapping/WrongType
    //   2832: dup_x1
    //   2833: swap
    //   2834: ldc_w 878
    //   2837: iconst_2
    //   2838: aload 5
    //   2840: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2843: athrow
    //   2844: new 120	gnu/mapping/WrongType
    //   2847: dup_x1
    //   2848: swap
    //   2849: ldc_w 878
    //   2852: iconst_0
    //   2853: aload 6
    //   2855: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2858: athrow
    //   2859: new 120	gnu/mapping/WrongType
    //   2862: dup_x1
    //   2863: swap
    //   2864: ldc_w 884
    //   2867: iconst_1
    //   2868: aload 5
    //   2870: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2873: athrow
    //   2874: new 120	gnu/mapping/WrongType
    //   2877: dup_x1
    //   2878: swap
    //   2879: ldc_w 884
    //   2882: iconst_2
    //   2883: aload 5
    //   2885: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2888: athrow
    //   2889: new 120	gnu/mapping/WrongType
    //   2892: dup_x1
    //   2893: swap
    //   2894: ldc_w 884
    //   2897: iconst_0
    //   2898: aload 6
    //   2900: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2903: athrow
    //   2904: new 120	gnu/mapping/WrongType
    //   2907: dup_x1
    //   2908: swap
    //   2909: ldc_w 889
    //   2912: iconst_1
    //   2913: aload 5
    //   2915: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2918: athrow
    //   2919: new 120	gnu/mapping/WrongType
    //   2922: dup_x1
    //   2923: swap
    //   2924: ldc_w 889
    //   2927: iconst_2
    //   2928: aload 5
    //   2930: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2933: athrow
    //   2934: new 120	gnu/mapping/WrongType
    //   2937: dup_x1
    //   2938: swap
    //   2939: ldc_w 889
    //   2942: iconst_0
    //   2943: aload 6
    //   2945: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2948: athrow
    //   2949: new 120	gnu/mapping/WrongType
    //   2952: dup_x1
    //   2953: swap
    //   2954: ldc_w 894
    //   2957: iconst_1
    //   2958: aload 5
    //   2960: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2963: athrow
    //   2964: new 120	gnu/mapping/WrongType
    //   2967: dup_x1
    //   2968: swap
    //   2969: ldc_w 894
    //   2972: iconst_2
    //   2973: aload 5
    //   2975: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2978: athrow
    //   2979: new 120	gnu/mapping/WrongType
    //   2982: dup_x1
    //   2983: swap
    //   2984: ldc_w 894
    //   2987: iconst_0
    //   2988: aload 6
    //   2990: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2993: athrow
    //   2994: new 120	gnu/mapping/WrongType
    //   2997: dup_x1
    //   2998: swap
    //   2999: ldc_w 899
    //   3002: iconst_1
    //   3003: aload 5
    //   3005: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3008: athrow
    //   3009: new 120	gnu/mapping/WrongType
    //   3012: dup_x1
    //   3013: swap
    //   3014: ldc_w 899
    //   3017: iconst_2
    //   3018: aload 5
    //   3020: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3023: athrow
    //   3024: new 120	gnu/mapping/WrongType
    //   3027: dup_x1
    //   3028: swap
    //   3029: ldc_w 899
    //   3032: iconst_0
    //   3033: aload 6
    //   3035: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3038: athrow
    //   3039: new 120	gnu/mapping/WrongType
    //   3042: dup_x1
    //   3043: swap
    //   3044: ldc_w 904
    //   3047: iconst_1
    //   3048: aload 5
    //   3050: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3053: athrow
    //   3054: new 120	gnu/mapping/WrongType
    //   3057: dup_x1
    //   3058: swap
    //   3059: ldc_w 904
    //   3062: iconst_2
    //   3063: aload 5
    //   3065: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3068: athrow
    //   3069: new 120	gnu/mapping/WrongType
    //   3072: dup_x1
    //   3073: swap
    //   3074: ldc_w 904
    //   3077: iconst_0
    //   3078: aload 6
    //   3080: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3083: athrow
    //   3084: new 120	gnu/mapping/WrongType
    //   3087: dup_x1
    //   3088: swap
    //   3089: ldc_w 909
    //   3092: iconst_1
    //   3093: aload 5
    //   3095: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3098: athrow
    //   3099: new 120	gnu/mapping/WrongType
    //   3102: dup_x1
    //   3103: swap
    //   3104: ldc_w 909
    //   3107: iconst_2
    //   3108: aload 5
    //   3110: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3113: athrow
    //   3114: new 120	gnu/mapping/WrongType
    //   3117: dup_x1
    //   3118: swap
    //   3119: ldc_w 909
    //   3122: iconst_0
    //   3123: aload 6
    //   3125: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3128: athrow
    //   3129: new 120	gnu/mapping/WrongType
    //   3132: dup_x1
    //   3133: swap
    //   3134: ldc_w 914
    //   3137: iconst_1
    //   3138: aload 5
    //   3140: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3143: athrow
    //   3144: new 120	gnu/mapping/WrongType
    //   3147: dup_x1
    //   3148: swap
    //   3149: ldc_w 914
    //   3152: iconst_2
    //   3153: aload 5
    //   3155: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3158: athrow
    //   3159: new 120	gnu/mapping/WrongType
    //   3162: dup_x1
    //   3163: swap
    //   3164: ldc_w 914
    //   3167: iconst_0
    //   3168: aload 6
    //   3170: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3173: athrow
    //   3174: new 120	gnu/mapping/WrongType
    //   3177: dup_x1
    //   3178: swap
    //   3179: ldc_w 919
    //   3182: iconst_1
    //   3183: aload 5
    //   3185: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3188: athrow
    //   3189: new 120	gnu/mapping/WrongType
    //   3192: dup_x1
    //   3193: swap
    //   3194: ldc_w 919
    //   3197: iconst_2
    //   3198: aload 5
    //   3200: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3203: athrow
    //   3204: new 120	gnu/mapping/WrongType
    //   3207: dup_x1
    //   3208: swap
    //   3209: ldc_w 919
    //   3212: iconst_0
    //   3213: aload 6
    //   3215: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3218: athrow
    //   3219: new 120	gnu/mapping/WrongType
    //   3222: dup_x1
    //   3223: swap
    //   3224: ldc_w 924
    //   3227: iconst_1
    //   3228: aload 5
    //   3230: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3233: athrow
    //   3234: new 120	gnu/mapping/WrongType
    //   3237: dup_x1
    //   3238: swap
    //   3239: ldc_w 924
    //   3242: iconst_2
    //   3243: aload 5
    //   3245: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3248: athrow
    //   3249: new 120	gnu/mapping/WrongType
    //   3252: dup_x1
    //   3253: swap
    //   3254: ldc_w 924
    //   3257: iconst_0
    //   3258: aload 6
    //   3260: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3263: athrow
    //   3264: new 120	gnu/mapping/WrongType
    //   3267: dup_x1
    //   3268: swap
    //   3269: ldc_w 929
    //   3272: iconst_2
    //   3273: aload 5
    //   3275: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3278: athrow
    //   3279: new 120	gnu/mapping/WrongType
    //   3282: dup_x1
    //   3283: swap
    //   3284: ldc_w 935
    //   3287: iconst_2
    //   3288: aload 5
    //   3290: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3293: athrow
    //   3294: new 120	gnu/mapping/WrongType
    //   3297: dup_x1
    //   3298: swap
    //   3299: ldc_w 935
    //   3302: iconst_0
    //   3303: aload 6
    //   3305: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3308: athrow
    //   3309: new 120	gnu/mapping/WrongType
    //   3312: dup_x1
    //   3313: swap
    //   3314: ldc_w 941
    //   3317: iconst_1
    //   3318: aload 5
    //   3320: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3323: athrow
    // Line number table:
    //   Java source line #54	-> byte code offset #228
    //   Java source line #79	-> byte code offset #233
    //   Java source line #80	-> byte code offset #308
    //   Java source line #81	-> byte code offset #383
    //   Java source line #82	-> byte code offset #458
    //   Java source line #83	-> byte code offset #533
    //   Java source line #119	-> byte code offset #608
    //   Java source line #128	-> byte code offset #719
    //   Java source line #179	-> byte code offset #848
    //   Java source line #191	-> byte code offset #853
    //   Java source line #192	-> byte code offset #935
    //   Java source line #193	-> byte code offset #1017
    //   Java source line #194	-> byte code offset #1099
    //   Java source line #195	-> byte code offset #1181
    //   Java source line #201	-> byte code offset #1263
    //   Java source line #203	-> byte code offset #1340
    //   Java source line #205	-> byte code offset #1417
    //   Java source line #207	-> byte code offset #1494
    //   Java source line #209	-> byte code offset #1571
    //   Java source line #216	-> byte code offset #1648
    //   Java source line #218	-> byte code offset #1725
    //   Java source line #220	-> byte code offset #1802
    //   Java source line #222	-> byte code offset #1879
    //   Java source line #224	-> byte code offset #1956
    //   Java source line #242	-> byte code offset #2033
    //   Java source line #275	-> byte code offset #2089
    //   Java source line #305	-> byte code offset #2148
    //   Java source line #79	-> byte code offset #2236
    //   Java source line #80	-> byte code offset #2279
    //   Java source line #81	-> byte code offset #2322
    //   Java source line #82	-> byte code offset #2365
    //   Java source line #83	-> byte code offset #2408
    //   Java source line #119	-> byte code offset #2423
    //   Java source line #120	-> byte code offset #2438
    //   Java source line #121	-> byte code offset #2453
    //   Java source line #123	-> byte code offset #2468
    //   Java source line #124	-> byte code offset #2483
    //   Java source line #128	-> byte code offset #2498
    //   Java source line #129	-> byte code offset #2513
    //   Java source line #130	-> byte code offset #2528
    //   Java source line #131	-> byte code offset #2543
    //   Java source line #133	-> byte code offset #2558
    //   Java source line #134	-> byte code offset #2573
    //   Java source line #191	-> byte code offset #2619
    //   Java source line #192	-> byte code offset #2664
    //   Java source line #193	-> byte code offset #2709
    //   Java source line #194	-> byte code offset #2754
    //   Java source line #195	-> byte code offset #2799
    //   Java source line #201	-> byte code offset #2844
    //   Java source line #203	-> byte code offset #2889
    //   Java source line #205	-> byte code offset #2934
    //   Java source line #207	-> byte code offset #2979
    //   Java source line #209	-> byte code offset #3024
    //   Java source line #216	-> byte code offset #3069
    //   Java source line #218	-> byte code offset #3114
    //   Java source line #220	-> byte code offset #3159
    //   Java source line #222	-> byte code offset #3204
    //   Java source line #224	-> byte code offset #3249
    //   Java source line #242	-> byte code offset #3264
    //   Java source line #275	-> byte code offset #3279
    //   Java source line #305	-> byte code offset #3309
    // Exception table:
    //   from	to	target	type
    //   243	246	2208	java/lang/ClassCastException
    //   256	259	2222	java/lang/ClassCastException
    //   281	284	2236	java/lang/ClassCastException
    //   318	321	2251	java/lang/ClassCastException
    //   331	334	2265	java/lang/ClassCastException
    //   356	359	2279	java/lang/ClassCastException
    //   393	396	2294	java/lang/ClassCastException
    //   406	409	2308	java/lang/ClassCastException
    //   431	434	2322	java/lang/ClassCastException
    //   468	471	2337	java/lang/ClassCastException
    //   481	484	2351	java/lang/ClassCastException
    //   506	509	2365	java/lang/ClassCastException
    //   543	546	2380	java/lang/ClassCastException
    //   556	559	2394	java/lang/ClassCastException
    //   581	584	2408	java/lang/ClassCastException
    //   624	627	2423	java/lang/ClassCastException
    //   636	642	2438	java/lang/ClassCastException
    //   653	656	2453	java/lang/ClassCastException
    //   678	684	2468	java/lang/ClassCastException
    //   706	712	2483	java/lang/ClassCastException
    //   736	739	2498	java/lang/ClassCastException
    //   748	754	2513	java/lang/ClassCastException
    //   763	769	2528	java/lang/ClassCastException
    //   780	783	2543	java/lang/ClassCastException
    //   806	812	2558	java/lang/ClassCastException
    //   835	841	2573	java/lang/ClassCastException
    //   864	867	2589	java/lang/ClassCastException
    //   878	881	2604	java/lang/ClassCastException
    //   907	910	2619	java/lang/ClassCastException
    //   946	949	2634	java/lang/ClassCastException
    //   960	963	2649	java/lang/ClassCastException
    //   989	992	2664	java/lang/ClassCastException
    //   1028	1031	2679	java/lang/ClassCastException
    //   1042	1045	2694	java/lang/ClassCastException
    //   1071	1074	2709	java/lang/ClassCastException
    //   1110	1113	2724	java/lang/ClassCastException
    //   1124	1127	2739	java/lang/ClassCastException
    //   1153	1156	2754	java/lang/ClassCastException
    //   1192	1195	2769	java/lang/ClassCastException
    //   1206	1209	2784	java/lang/ClassCastException
    //   1235	1238	2799	java/lang/ClassCastException
    //   1272	1275	2814	java/lang/ClassCastException
    //   1284	1287	2829	java/lang/ClassCastException
    //   1312	1315	2844	java/lang/ClassCastException
    //   1349	1352	2859	java/lang/ClassCastException
    //   1361	1364	2874	java/lang/ClassCastException
    //   1389	1392	2889	java/lang/ClassCastException
    //   1426	1429	2904	java/lang/ClassCastException
    //   1438	1441	2919	java/lang/ClassCastException
    //   1466	1469	2934	java/lang/ClassCastException
    //   1503	1506	2949	java/lang/ClassCastException
    //   1515	1518	2964	java/lang/ClassCastException
    //   1543	1546	2979	java/lang/ClassCastException
    //   1580	1583	2994	java/lang/ClassCastException
    //   1592	1595	3009	java/lang/ClassCastException
    //   1620	1623	3024	java/lang/ClassCastException
    //   1657	1660	3039	java/lang/ClassCastException
    //   1669	1672	3054	java/lang/ClassCastException
    //   1697	1700	3069	java/lang/ClassCastException
    //   1734	1737	3084	java/lang/ClassCastException
    //   1746	1749	3099	java/lang/ClassCastException
    //   1774	1777	3114	java/lang/ClassCastException
    //   1811	1814	3129	java/lang/ClassCastException
    //   1823	1826	3144	java/lang/ClassCastException
    //   1851	1854	3159	java/lang/ClassCastException
    //   1888	1891	3174	java/lang/ClassCastException
    //   1900	1903	3189	java/lang/ClassCastException
    //   1928	1931	3204	java/lang/ClassCastException
    //   1965	1968	3219	java/lang/ClassCastException
    //   1977	1980	3234	java/lang/ClassCastException
    //   2005	2008	3249	java/lang/ClassCastException
    //   2047	2050	3264	java/lang/ClassCastException
    //   2103	2106	3279	java/lang/ClassCastException
    //   2132	2135	3294	java/lang/ClassCastException
    //   2159	2162	3309	java/lang/ClassCastException
  }
}
