/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.functions.UnicodeUtils;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.CharSeq;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Strings;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.SourceMethodType;
import kawa.lib.characters;
import kawa.lib.kawa.string-cursors;
import kawa.standard.Scheme;

public class strings
extends ModuleBody {
    public static final ModuleMethod string$Qu;
    public static final ModuleMethod make$Mnstring;
    public static final ModuleMethod $make$string$;
    public static final ModuleMethod string$Mnlength;
    public static final ModuleMethod string$Mnref;
    public static final ModuleMethod string$Mnset$Ex;
    public static final ModuleMethod char$Eq$Qu;
    public static final ModuleMethod char$Ls$Qu;
    public static final ModuleMethod char$Gr$Qu;
    public static final ModuleMethod char$Ls$Eq$Qu;
    public static final ModuleMethod char$Gr$Eq$Qu;
    public static final ModuleMethod char$Mnci$Eq$Qu;
    public static final ModuleMethod char$Mnci$Ls$Qu;
    public static final ModuleMethod char$Mnci$Gr$Qu;
    public static final ModuleMethod char$Mnci$Ls$Eq$Qu;
    public static final ModuleMethod char$Mnci$Gr$Eq$Qu;
    public static final ModuleMethod string$Eq$Qu;
    public static final ModuleMethod string$Ls$Qu;
    public static final ModuleMethod string$Gr$Qu;
    public static final ModuleMethod string$Ls$Eq$Qu;
    public static final ModuleMethod string$Gr$Eq$Qu;
    public static final ModuleMethod string$Mnci$Eq$Qu;
    public static final ModuleMethod string$Mnci$Ls$Qu;
    public static final ModuleMethod string$Mnci$Gr$Qu;
    public static final ModuleMethod string$Mnci$Ls$Eq$Qu;
    public static final ModuleMethod string$Mnci$Gr$Eq$Qu;
    public static final ModuleMethod substring;
    public static final ModuleMethod string$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grstring;
    public static final ModuleMethod string$Mncopy;
    public static final ModuleMethod string$Mncopy$Ex;
    public static final ModuleMethod string$Mnfill$Ex;
    public static final ModuleMethod string$Mnupcase$Ex;
    public static final ModuleMethod string$Mndowncase$Ex;
    public static final ModuleMethod string$Mncapitalize;
    public static final ModuleMethod string$Mncapitalize$Ex;
    public static final ModuleMethod string$Mnappend;
    public static final ModuleMethod string$Mnappend$Ex;
    public static final ModuleMethod string$Mnreplace$Ex;
    public static final ModuleMethod string$Mnmap;
    public static final ModuleMethod string$Mnfor$Mneach;
    public static final ModuleMethod srfi$Mn13$Mnstring$Mnfor$Mneach;
    public static final StaticFieldLocation $Prvt$define;
    public static final StaticFieldLocation $Prvt$cond;
    public static final StaticFieldLocation $Prvt$and;
    public static final StaticFieldLocation $Prvt$or;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$let$St;
    public static final StaticFieldLocation $Prvt$else;
    public static final StaticFieldLocation $Prvt$length;
    public static Location $Prvt$prev;
    public static strings $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
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

    public static /* varargs */ boolean isString$Eq(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompare2(str1, str2) == 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompare2(prev, next) != 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean isString(Object x) {
        return x instanceof CharSequence;
    }

    public static FString makeString(int n) {
        return strings.makeString(n, 32);
    }

    @SourceMethodType(value={"", "", "character"})
    public static FString makeString(int n, int ch) {
        return new FString(n, ch);
    }

    public static /* varargs */ CharSequence $make$string$(Object ... args) {
        int n = args.length;
        FString str = FString.alloc(n);
        for (int i = 0; i < n; ++i) {
            str.appendCharacter(((Char)Promise.force(args[i], Char.class)).intValue());
        }
        return str;
    }

    public static int stringLength(CharSequence str) {
        return Strings.sizeInCodePoints(str);
    }

    @SourceMethodType(value={"character"})
    public static int stringRef(CharSequence str, int k) {
        return Character.codePointAt(str, Character.offsetByCodePoints(str, 0, k));
    }

    @SourceMethodType(value={"", "", "", "character"})
    public static void stringSet$Ex(CharSeq str, int k, int n) {
        str.setCharacterAt(Character.offsetByCodePoints(str, 0, k), n);
    }

    public static /* varargs */ boolean isString$Ls(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompare2(str1, str2) < 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompare2(prev, next) >= 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    static int $PcStringCompare2(CharSequence str1, CharSequence str2) {
        return str1.toString().compareTo(str2.toString());
    }

    public static /* varargs */ boolean isString$Gr(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompare2(str1, str2) > 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompare2(prev, next) <= 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    public static /* varargs */ boolean isString$Ls$Eq(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompare2(str1, str2) <= 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompare2(prev, next) > 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    public static /* varargs */ boolean isString$Gr$Eq(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompare2(str1, str2) >= 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompare2(prev, next) < 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    public static CharSequence substring(CharSequence str, int start, int end) {
        int n;
        int istart = Character.offsetByCodePoints(str, 0, start);
        if (end == -1) {
            n = str.length();
        } else {
            if (end < start) {
                throw new StringIndexOutOfBoundsException();
            }
            n = Character.offsetByCodePoints(str, istart, end - start);
        }
        int iend = n;
        return new FString(str, istart, iend - istart);
    }

    public static LList string$To$List(CharSequence charSequence) {
        return strings.string$To$List(charSequence, 0, -1);
    }

    public static LList string$To$List(CharSequence charSequence, int n) {
        return strings.string$To$List(charSequence, n, -1);
    }

    public static LList string$To$List(CharSequence str, int start, int end) {
        EmptyList result;
        int n;
        int cstart = Character.offsetByCodePoints(str, 0, start);
        if (end == -1) {
            n = str.length();
        } else {
            if (end < start) {
                throw new StringIndexOutOfBoundsException();
            }
            n = Character.offsetByCodePoints(str, cstart, end - start);
        }
        int cend = n;
        LList lList = LList.Empty;
        int n2 = cend;
        do {
            void i;
            int n3 = n2;
            result = lList;
            if (string-cursors.isStringCursor$Ls$Eq((int)i, start)) break;
            int prev = string-cursors.stringCursorPrev(str, (int)i);
            lList = new Pair(Char.make(string-cursors.stringCursorRef(str, prev)), result);
            n2 = prev;
        } while (true);
        return result;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static CharSequence list$To$String(LList lst) {
        Object object2;
        int len = lst.size();
        FString result = new FString(len);
        int i = 0;
        while (i < len) {
            object2 = lst;
            Pair pair = (Pair)object2;
            object2 = Promise.force(pair.getCar());
            strings.stringSet$Ex(result, i, Char.castToCharacter(object2));
            object2 = Promise.force(pair.getCdr(), LList.class);
            lst = (LList)object2;
            ++i;
        }
        return result;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "pair", -2, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-set!", 2, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lst", -2, object2);
        }
    }

    public static FString stringCopy(CharSequence charSequence) {
        return strings.stringCopy(charSequence, 0, -1);
    }

    public static FString stringCopy(CharSequence charSequence, int n) {
        return strings.stringCopy(charSequence, n, -1);
    }

    public static FString stringCopy(CharSequence str, int start, int end) {
        int n;
        int istart = Character.offsetByCodePoints(str, 0, start);
        if (end == -1) {
            n = str.length();
        } else {
            if (end < start) {
                throw new StringIndexOutOfBoundsException();
            }
            n = Character.offsetByCodePoints(str, istart, end - start);
        }
        int iend = n;
        return new FString(str, istart, iend - istart);
    }

    public static void stringCopy$Ex(FString fString, int n, CharSequence charSequence) {
        strings.stringCopy$Ex(fString, n, charSequence, 0);
    }

    public static void stringCopy$Ex(FString fString, int n, CharSequence charSequence, int n2) {
        strings.stringCopy$Ex(fString, n, charSequence, n2, Strings.sizeInCodePoints(charSequence));
    }

    public static void stringCopy$Ex(FString to, int at, CharSequence from, int start, int end) {
        strings.stringReplace$Ex(to, at, at + (end - start), from, start, end);
    }

    public static void stringReplace$Ex(FString fString, int n, int n2, CharSequence charSequence) {
        strings.stringReplace$Ex(fString, n, n2, charSequence, 0, -1);
    }

    public static void stringReplace$Ex(FString fString, int n, int n2, CharSequence charSequence, int n3) {
        strings.stringReplace$Ex(fString, n, n2, charSequence, n3, -1);
    }

    public static void stringReplace$Ex(FString dst, int dstart, int dend, CharSequence src, int sstart, int send) {
        int n;
        int n2;
        int csstart = Character.offsetByCodePoints(src, 0, sstart);
        if (send == -1) {
            n = src.length();
        } else {
            if (send < sstart) {
                throw new StringIndexOutOfBoundsException();
            }
            n = Character.offsetByCodePoints(src, csstart, send - sstart);
        }
        int csend = n;
        int cdstart = Character.offsetByCodePoints(dst, 0, dstart);
        if (dend == -1) {
            n2 = dst.length();
        } else {
            if (dend < dstart) {
                throw new StringIndexOutOfBoundsException();
            }
            n2 = Character.offsetByCodePoints(dst, cdstart, dend - dstart);
        }
        int cdend = n2;
        dst.replace(src, csstart, csend, cdstart, cdend);
    }

    @SourceMethodType(value={"", "", "character"})
    public static void stringFill$Ex(CharSeq charSeq, int n) {
        strings.stringFill$Ex(charSeq, n, 0, -1);
    }

    @SourceMethodType(value={"", "", "character"})
    public static void stringFill$Ex(CharSeq charSeq, int n, int n2) {
        strings.stringFill$Ex(charSeq, n, n2, -1);
    }

    @SourceMethodType(value={"", "", "character"})
    public static void stringFill$Ex(CharSeq str, int ch, int start, int end) {
        int cstart = Character.offsetByCodePoints(str, 0, start);
        int send = end >= 0 ? end : Strings.sizeInCodePoints(str);
        CharSeq charSeq = str;
        if (charSeq instanceof FString) {
            FString fString = (FString)charSeq;
            int cend = end < 0 ? fString.length() : Character.offsetByCodePoints(str, 0, end);
            fString.delete(cstart, cend);
            fString.insertRepeated(cstart, ch, send - start);
        } else {
            int width = ch > 65535 ? 2 : 1;
            int n = cstart;
            for (int to$Mndo = send - start; to$Mndo > 0; --to$Mndo) {
                void pos;
                str.setCharacterAt((int)pos, ch);
                pos += width;
            }
        }
    }

    public static CharSequence stringUpcase$Ex(CharSeq str) {
        Strings.makeUpperCase(str);
        return str;
    }

    public static CharSequence stringDowncase$Ex(CharSeq str) {
        Strings.makeLowerCase(str);
        return str;
    }

    public static CharSequence stringCapitalize$Ex(CharSeq str) {
        Strings.makeCapitalize(str);
        return str;
    }

    public static CharSequence stringCapitalize(CharSequence str) {
        FString copy = strings.stringCopy(str);
        Strings.makeCapitalize(copy);
        return copy;
    }

    public static /* varargs */ FString stringAppend(Object ... args) {
        FString str = new FString();
        str.addAllStrings(args, 0);
        return str;
    }

    public static /* varargs */ boolean isStringCi$Ls(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompareCi2(str1, str2) < 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompareCi2(prev, next) >= 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    static int $PcStringCompareCi2(CharSequence str1, CharSequence str2) {
        return UnicodeUtils.foldCase(str1).toString().compareTo(UnicodeUtils.foldCase(str2).toString());
    }

    public static /* varargs */ boolean isStringCi$Eq(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompareCi2(str1, str2) == 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompareCi2(prev, next) != 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    public static /* varargs */ boolean isStringCi$Gr(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompareCi2(str1, str2) > 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompareCi2(prev, next) <= 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    public static /* varargs */ boolean isStringCi$Ls$Eq(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompareCi2(str1, str2) <= 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompareCi2(prev, next) > 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    public static /* varargs */ boolean isStringCi$Gr$Eq(CharSequence str1, CharSequence str2, CharSequence ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcStringCompareCi2(str1, str2) >= 0) {
                int n = strs.length;
                CharSequence charSequence = str2;
                int i = 0;
                do {
                    CharSequence prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    CharSequence next = strs[i];
                    if (strings.$PcStringCompareCi2(prev, next) < 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isChar$Eq(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompare(str1, str2) == 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompare(prev, next) != 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character"})
    static int $PcCharCompare(int c1, int c2) {
        void i1;
        int n = characters.char$To$Integer(c1);
        int i2 = characters.char$To$Integer(c2);
        return i1 > i2 ? 1 : (i1 < i2 ? -1 : 0);
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isChar$Ls(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompare(str1, str2) < 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompare(prev, next) >= 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isChar$Gr(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompare(str1, str2) > 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompare(prev, next) <= 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isChar$Ls$Eq(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompare(str1, str2) <= 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompare(prev, next) > 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isChar$Gr$Eq(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompare(str1, str2) >= 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompare(prev, next) < 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isCharCi$Eq(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompareCi(str1, str2) == 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompareCi(prev, next) != 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character"})
    static int $PcCharCompareCi(int c1, int c2) {
        return Character.toUpperCase(characters.char$To$Integer(c1)) - Character.toUpperCase(characters.char$To$Integer(c2));
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isCharCi$Ls(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompareCi(str1, str2) < 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompareCi(prev, next) >= 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isCharCi$Gr(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompareCi(str1, str2) > 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompareCi(prev, next) <= 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isCharCi$Ls$Eq(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompareCi(str1, str2) <= 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompareCi(prev, next) > 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    @SourceMethodType(value={"", "character", "character", "character[]"})
    public static /* varargs */ boolean isCharCi$Gr$Eq(int str1, int str2, int ... strs) {
        boolean bl;
        block4 : {
            if (strings.$PcCharCompareCi(str1, str2) >= 0) {
                int n = strs.length;
                int n2 = str2;
                int i = 0;
                do {
                    int prev;
                    boolean x;
                    boolean bl2 = x = i == n;
                    if (x) {
                        bl = x;
                        break block4;
                    }
                    int next = strs[i];
                    if (strings.$PcCharCompareCi(prev, next) < 0) break;
                    prev = next;
                    ++i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    public static void srfi$Mn13StringForEach(Object object2, CharSequence charSequence) {
        strings.srfi$Mn13StringForEach(object2, charSequence, 0, -1);
    }

    public static void srfi$Mn13StringForEach(Object object2, CharSequence charSequence, int n) {
        strings.srfi$Mn13StringForEach(object2, charSequence, n, -1);
    }

    public static void srfi$Mn13StringForEach(Object proc, CharSequence str, int start, int end) {
        int cstart = string-cursors.stringCursorNext(str, 0, start);
        int cend = end == -1 ? str.length() : string-cursors.stringCursorNext(str, cstart, end - start);
        string-cursors.stringCursorForEach(proc, str, cstart, cend);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ void stringForEach(Object proc, CharSequence str1, Object ... rst) {
        block15 : {
            block16 : {
                nrst = rst.length;
                if (nrst == 0) {
                    string-cursors.stringCursorForEach(proc, str1);
                    return;
                }
                if (nrst >= 3 || rst[0] instanceof CharSequence) break block15;
                var4_4 = Promise.force(rst[0]);
                if (nrst != 2) break block16;
                var4_4 = Promise.force(rst[1]);
                try {
                    v0 = ((Number)var4_4).intValue();
                    ** GOTO lbl-1000
                }
                catch (ClassCastException v1) {
                    throw new WrongType(v1, "srfi-13-string-for-each", 3, (Object)n);
                }
            }
            v0 = -1;
lbl-1000: // 2 sources:
            {
                strings.srfi$Mn13StringForEach(proc, str1, ((Number)var4_4).intValue(), v0);
            }
            return;
        }
        n = nrst + 1;
        cursors = new int[n];
        ends = new int[n];
        chs = new Char[n];
        cursors[0] = string-cursors.stringCursorStart(str1);
        ends[0] = string-cursors.stringCursorEnd(str1);
        for (i = 1; i < n; ++i) {
            var10_13 = Promise.force(rst[i - 1], CharSequence.class);
            try {
                str = (CharSequence)var10_13;
            }
            catch (ClassCastException v2) {
                throw new WrongType(v2, "str", -2, (Object)end$Mni);
            }
            cursors[i] = string-cursors.stringCursorStart(str);
            ends[i] = string-cursors.stringCursorEnd(str);
        }
        block9 : do {
            i = 0;
            do {
                if (i == n) {
                    str = 1;
                    var10_13 = chs;
                    var11_15 = MakeSplice.count(var10_13);
                    str = var11_15 + str;
                    v3 = new Object[str];
                    v3[0] = proc;
                    var12_17 = 1;
                    MakeSplice.copyTo(v3, var12_17, var11_15, var10_13);
                    var12_17 += var11_15;
                    Scheme.applyToArgs.applyN(v3);
                    continue block9;
                }
                curs$Mni = cursors[i];
                end$Mni = ends[i];
                if (i == 0) {
                    v4 = str1;
                } else {
                    var12_18 = Promise.force(rst[i - 1], CharSequence.class);
                    v4 = (CharSequence)var12_18;
                }
                str = v4;
                if (string-cursors.isStringCursor$Ls(curs$Mni, end$Mni) == false) return;
                chs[i] = Char.make(string-cursors.stringCursorRef(str, curs$Mni));
                cursors[i] = string-cursors.stringCursorNext(str, curs$Mni);
                ++i;
            } while (true);
            break;
        } while (true);
        catch (ClassCastException v5) {
            throw new WrongType(v5, "str", -2, var12_18);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ CharSequence stringMap(Object proc, CharSequence str1, CharSequence ... rst) {
        int i;
        int nrst = rst.length;
        int n = nrst + 1;
        int[] cursors = new int[n];
        int[] ends = new int[n];
        Char[] chs = new Char[n];
        int len1 = str1.length();
        FString result = FString.alloc(len1);
        cursors[0] = 0;
        ends[0] = len1;
        for (i = 1; i < n; ++i) {
            CharSequence str = rst[i - 1];
            cursors[i] = 0;
            ends[i] = str.length();
        }
        block3 : do {
            i = 0;
            do {
                if (i == n) {
                    int n2 = 1;
                    Char[] arrchar = chs;
                    int n3 = MakeSplice.count(arrchar);
                    n2 = n3 + n2;
                    Object[] arrobject = new Object[n2];
                    arrobject[0] = proc;
                    int n4 = 1;
                    MakeSplice.copyTo(arrobject, n4, n3, arrchar);
                    n4 += n3;
                    Object object2 = Promise.force(((Procedure)Scheme.applyToArgs).applyN(arrobject));
                    int ch = Char.castToCharacter(object2);
                    result.appendCharacter(ch);
                    continue block3;
                }
                int curs$Mni = cursors[i];
                int end$Mni = ends[i];
                CharSequence str = i == 0 ? str1 : rst[i - 1];
                if (!string-cursors.isStringCursor$Ls(curs$Mni, end$Mni)) return result;
                chs[i] = Char.make(string-cursors.stringCursorRef(str, curs$Mni));
                cursors[i] = string-cursors.stringCursorNext(str, curs$Mni);
                ++i;
            } while (true);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            void end$Mni;
            throw new WrongType(classCastException, "ch", -2, (Object)end$Mni);
        }
    }

    public static /* varargs */ void stringAppend$Ex(FString str, Object ... args) {
        int len = args.length;
        for (int i = 0; i < len; ++i) {
            str.append(args[i]);
        }
    }

    public static {
        Lit41 = Symbol.valueOf("string-append!");
        Lit40 = Symbol.valueOf("string-map");
        Lit39 = Symbol.valueOf("string-for-each");
        Lit38 = Symbol.valueOf("srfi-13-string-for-each");
        Lit37 = Symbol.valueOf("char-ci>=?");
        Lit36 = Symbol.valueOf("char-ci<=?");
        Lit35 = Symbol.valueOf("char-ci>?");
        Lit34 = Symbol.valueOf("char-ci<?");
        Lit33 = Symbol.valueOf("char-ci=?");
        Lit32 = Symbol.valueOf("char>=?");
        Lit31 = Symbol.valueOf("char<=?");
        Lit30 = Symbol.valueOf("char>?");
        Lit29 = Symbol.valueOf("char<?");
        Lit28 = Symbol.valueOf("char=?");
        Lit27 = Symbol.valueOf("string-ci>=?");
        Lit26 = Symbol.valueOf("string-ci<=?");
        Lit25 = Symbol.valueOf("string-ci>?");
        Lit24 = Symbol.valueOf("string-ci=?");
        Lit23 = Symbol.valueOf("string-ci<?");
        Lit22 = Symbol.valueOf("string-append");
        Lit21 = Symbol.valueOf("string-capitalize");
        Lit20 = Symbol.valueOf("string-capitalize!");
        Lit19 = Symbol.valueOf("string-downcase!");
        Lit18 = Symbol.valueOf("string-upcase!");
        Lit17 = Symbol.valueOf("string-fill!");
        Lit16 = Symbol.valueOf("string-replace!");
        Lit15 = Symbol.valueOf("string-copy!");
        Lit14 = Symbol.valueOf("string-copy");
        Lit13 = Symbol.valueOf("list->string");
        Lit12 = Symbol.valueOf("string->list");
        Lit11 = Symbol.valueOf("substring");
        Lit10 = Symbol.valueOf("string>=?");
        Lit9 = Symbol.valueOf("string<=?");
        Lit8 = Symbol.valueOf("string>?");
        Lit7 = Symbol.valueOf("string=?");
        Lit6 = Symbol.valueOf("string<?");
        Lit5 = Symbol.valueOf("string-set!");
        Lit4 = Symbol.valueOf("string-ref");
        Lit3 = Symbol.valueOf("string-length");
        Lit2 = Symbol.valueOf("$make$string$");
        Lit1 = Symbol.valueOf("make-string");
        Lit0 = Symbol.valueOf("string?");
        $instance = new strings();
        $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
        $Prvt$cond = StaticFieldLocation.make("kawa.lib.std_syntax", "cond");
        $Prvt$and = StaticFieldLocation.make("kawa.lib.std_syntax", "and");
        $Prvt$or = StaticFieldLocation.make("kawa.lib.std_syntax", "or");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
        $Prvt$else = StaticFieldLocation.make("kawa.lib.std_syntax", "else");
        $Prvt$length = StaticFieldLocation.make("kawa.lib.lists", "length");
        strings strings2 = $instance;
        string$Qu = new ModuleMethod(strings2, 1, Lit0, 4097);
        make$Mnstring = new ModuleMethod(strings2, 2, Lit1, 8193);
        $make$string$ = new ModuleMethod(strings2, 4, Lit2, -4096);
        string$Mnlength = new ModuleMethod(strings2, 5, Lit3, 4097);
        string$Mnref = new ModuleMethod(strings2, 6, Lit4, 8194);
        string$Mnset$Ex = new ModuleMethod(strings2, 7, Lit5, 12291);
        string$Ls$Qu = new ModuleMethod(strings2, 8, Lit6, -4094);
        string$Eq$Qu = new ModuleMethod(strings2, 9, Lit7, -4094);
        string$Gr$Qu = new ModuleMethod(strings2, 10, Lit8, -4094);
        string$Ls$Eq$Qu = new ModuleMethod(strings2, 11, Lit9, -4094);
        string$Gr$Eq$Qu = new ModuleMethod(strings2, 12, Lit10, -4094);
        substring = new ModuleMethod(strings2, 13, Lit11, 12291);
        string$Mn$Grlist = new ModuleMethod(strings2, 14, Lit12, 12289);
        list$Mn$Grstring = new ModuleMethod(strings2, 17, Lit13, 4097);
        string$Mncopy = new ModuleMethod(strings2, 18, Lit14, 12289);
        string$Mncopy$Ex = new ModuleMethod(strings2, 21, Lit15, 20483);
        string$Mnreplace$Ex = new ModuleMethod(strings2, 24, Lit16, 24580);
        string$Mnfill$Ex = new ModuleMethod(strings2, 27, Lit17, 16386);
        string$Mnupcase$Ex = new ModuleMethod(strings2, 30, Lit18, 4097);
        string$Mndowncase$Ex = new ModuleMethod(strings2, 31, Lit19, 4097);
        string$Mncapitalize$Ex = new ModuleMethod(strings2, 32, Lit20, 4097);
        string$Mncapitalize = new ModuleMethod(strings2, 33, Lit21, 4097);
        string$Mnappend = new ModuleMethod(strings2, 34, Lit22, -4096);
        string$Mnci$Ls$Qu = new ModuleMethod(strings2, 35, Lit23, -4094);
        string$Mnci$Eq$Qu = new ModuleMethod(strings2, 36, Lit24, -4094);
        string$Mnci$Gr$Qu = new ModuleMethod(strings2, 37, Lit25, -4094);
        string$Mnci$Ls$Eq$Qu = new ModuleMethod(strings2, 38, Lit26, -4094);
        string$Mnci$Gr$Eq$Qu = new ModuleMethod(strings2, 39, Lit27, -4094);
        ModuleMethod moduleMethod = new ModuleMethod(strings2, 40, Lit28, -4094);
        moduleMethod.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Eq$Qu = moduleMethod;
        ModuleMethod moduleMethod2 = new ModuleMethod(strings2, 41, Lit29, -4094);
        moduleMethod2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Ls$Qu = moduleMethod2;
        ModuleMethod moduleMethod3 = new ModuleMethod(strings2, 42, Lit30, -4094);
        moduleMethod3.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Gr$Qu = moduleMethod3;
        ModuleMethod moduleMethod4 = new ModuleMethod(strings2, 43, Lit31, -4094);
        moduleMethod4.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Ls$Eq$Qu = moduleMethod4;
        ModuleMethod moduleMethod5 = new ModuleMethod(strings2, 44, Lit32, -4094);
        moduleMethod5.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Gr$Eq$Qu = moduleMethod5;
        ModuleMethod moduleMethod6 = new ModuleMethod(strings2, 45, Lit33, -4094);
        moduleMethod6.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Eq$Qu = moduleMethod6;
        ModuleMethod moduleMethod7 = new ModuleMethod(strings2, 46, Lit34, -4094);
        moduleMethod7.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Ls$Qu = moduleMethod7;
        ModuleMethod moduleMethod8 = new ModuleMethod(strings2, 47, Lit35, -4094);
        moduleMethod8.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Gr$Qu = moduleMethod8;
        ModuleMethod moduleMethod9 = new ModuleMethod(strings2, 48, Lit36, -4094);
        moduleMethod9.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Ls$Eq$Qu = moduleMethod9;
        ModuleMethod moduleMethod10 = new ModuleMethod(strings2, 49, Lit37, -4094);
        moduleMethod10.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Gr$Eq$Qu = moduleMethod10;
        ModuleMethod moduleMethod11 = new ModuleMethod(strings2, 50, Lit38, 16386);
        moduleMethod11.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:stringForEach1ValidateApply");
        srfi$Mn13$Mnstring$Mnfor$Mneach = moduleMethod11;
        ModuleMethod moduleMethod12 = new ModuleMethod(strings2, 53, Lit39, -4094);
        moduleMethod12.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:stringForEachValidateApply");
        string$Mnfor$Mneach = moduleMethod12;
        string$Mnmap = new ModuleMethod(strings2, 54, Lit40, -4094);
        ModuleMethod moduleMethod13 = new ModuleMethod(strings2, 55, Lit41, -4095);
        moduleMethod13.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringAppendToValidateApply");
        string$Mnappend$Ex = moduleMethod13;
        strings.$runBody$();
    }

    public strings() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 33: {
                Object object3 = Promise.force(object2, CharSequence.class);
                if (!(object3 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                Object object4 = Promise.force(object2, CharSeq.class);
                if (!(object4 instanceof CharSeq)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 31: {
                Object object5 = Promise.force(object2, CharSeq.class);
                if (!(object5 instanceof CharSeq)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 30: {
                Object object6 = Promise.force(object2, CharSeq.class);
                if (!(object6 instanceof CharSeq)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                Object object7 = Promise.force(object2, CharSequence.class);
                if (!(object7 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                Object object8 = Promise.force(object2, LList.class);
                if (!(object8 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object9 = Promise.force(object2, CharSequence.class);
                if (!(object9 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                Object object10 = Promise.force(object2, CharSequence.class);
                if (!(object10 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 50: {
                callContext.value1 = object2;
                Object object4 = Promise.force(object3, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 27: {
                Object object5 = Promise.force(object2, CharSeq.class);
                if (!(object5 instanceof CharSeq)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3);
                if (Char.checkCharOrEof(object6) < 0) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 18: {
                Object object7 = Promise.force(object2, CharSequence.class);
                if (!(object7 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 14: {
                Object object8 = Promise.force(object2, CharSequence.class);
                if (!(object8 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 6: {
                Object object9 = Promise.force(object2, CharSequence.class);
                if (!(object9 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 2: {
                callContext.value1 = Promise.force(object2);
                Object object10 = Promise.force(object3);
                if (Char.checkCharOrEof(object10) < 0) {
                    return -786430;
                }
                callContext.value2 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 50: {
                callContext.value1 = object2;
                Object object5 = Promise.force(object3, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 27: {
                Object object6 = Promise.force(object2, CharSeq.class);
                if (!(object6 instanceof CharSeq)) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3);
                if (Char.checkCharOrEof(object7) < 0) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 21: {
                Object object8 = Promise.force(object2, FString.class);
                if (!(object8 instanceof FString)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = Promise.force(object3);
                Object object9 = Promise.force(object4, CharSequence.class);
                if (!(object9 instanceof CharSequence)) {
                    return -786429;
                }
                callContext.value3 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 18: {
                Object object10 = Promise.force(object2, CharSequence.class);
                if (!(object10 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 14: {
                Object object11 = Promise.force(object2, CharSequence.class);
                if (!(object11 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 13: {
                Object object12 = Promise.force(object2, CharSequence.class);
                if (!(object12 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 7: {
                Object object13 = Promise.force(object2, CharSeq.class);
                if (!(object13 instanceof CharSeq)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.value2 = Promise.force(object3);
                Object object14 = Promise.force(object4);
                if (Char.checkCharOrEof(object14) < 0) {
                    return -786429;
                }
                callContext.value3 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 50: {
                callContext.value1 = object2;
                Object object6 = Promise.force(object3, CharSequence.class);
                if (!(object6 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 27: {
                Object object7 = Promise.force(object2, CharSeq.class);
                if (!(object7 instanceof CharSeq)) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = Promise.force(object3);
                if (Char.checkCharOrEof(object8) < 0) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 24: {
                Object object9 = Promise.force(object2, FString.class);
                if (!(object9 instanceof FString)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                Object object10 = Promise.force(object5, CharSequence.class);
                if (!(object10 instanceof CharSequence)) {
                    return -786428;
                }
                callContext.value4 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 21: {
                Object object11 = Promise.force(object2, FString.class);
                if (!(object11 instanceof FString)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = Promise.force(object3);
                Object object12 = Promise.force(object4, CharSequence.class);
                if (!(object12 instanceof CharSequence)) {
                    return -786429;
                }
                callContext.value3 = object12;
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 55: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 54: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 53: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 49: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 48: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 47: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 46: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 45: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 44: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 43: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 42: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 41: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 40: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 39: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 38: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 37: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 36: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 35: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 34: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 24: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 21: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 12: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 11: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 10: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 9: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 8: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 4: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                Boolean bl;
                if (strings.isString(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                return strings.makeString(((Number)Promise.force(object2)).intValue());
            }
            case 5: {
                return strings.stringLength((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 14: {
                return strings.string$To$List((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 17: {
                return strings.list$To$String((LList)Promise.force(object2, LList.class));
            }
            case 18: {
                return strings.stringCopy((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 30: {
                return strings.stringUpcase$Ex((CharSeq)Promise.force(object2, CharSeq.class));
            }
            case 31: {
                return strings.stringDowncase$Ex((CharSeq)Promise.force(object2, CharSeq.class));
            }
            case 32: {
                return strings.stringCapitalize$Ex((CharSeq)Promise.force(object2, CharSeq.class));
            }
            case 33: {
                return strings.stringCapitalize((CharSequence)Promise.force(object2, CharSequence.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-copy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-upcase!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-downcase!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-capitalize!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-capitalize", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object applyN(ModuleMethod var1_1, Object[] var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }
}

