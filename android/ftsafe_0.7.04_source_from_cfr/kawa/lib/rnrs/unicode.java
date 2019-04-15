/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.rnrs;

import gnu.bytecode.Type;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.UnicodeUtils;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import java.util.Locale;
import kawa.SourceMethodType;
import kawa.lib.exceptions;

public class unicode
extends ModuleBody {
    public static final ModuleMethod char$Mnupcase;
    public static final ModuleMethod char$Mndowncase;
    public static final ModuleMethod char$Mntitlecase;
    public static final ModuleMethod char$Mnfoldcase;
    public static final ModuleMethod char$Mnalphabetic$Qu;
    public static final ModuleMethod char$Mnnumeric$Qu;
    public static final ModuleMethod char$Mnwhitespace$Qu;
    public static final ModuleMethod char$Mnupper$Mncase$Qu;
    public static final ModuleMethod char$Mnlower$Mncase$Qu;
    public static final ModuleMethod char$Mntitle$Mncase$Qu;
    public static final ModuleMethod char$Mngeneral$Mncategory;
    public static final ModuleMethod string$Mnupcase;
    public static final ModuleMethod string$Mndowncase;
    public static final ModuleMethod string$Mntitlecase;
    public static final ModuleMethod string$Mnfoldcase;
    public static final ModuleMethod string$Mnnormalize$Mnnfd;
    public static final ModuleMethod string$Mnnormalize$Mnnfkd;
    public static final ModuleMethod string$Mnnormalize$Mnnfc;
    public static final ModuleMethod string$Mnnormalize$Mnnfkc;
    public static unicode $instance;
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

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    @SourceMethodType(value={"character", "character"})
    public static int charUpcase(int ch) {
        return Character.toUpperCase(ch);
    }

    @SourceMethodType(value={"character", "character"})
    public static int charDowncase(int ch) {
        return Character.toLowerCase(ch);
    }

    @SourceMethodType(value={"character", "character"})
    public static int charTitlecase(int ch) {
        return Character.toTitleCase(ch);
    }

    @SourceMethodType(value={"", "character"})
    public static boolean isCharAlphabetic(int ch) {
        return Character.isLetter(ch);
    }

    @SourceMethodType(value={"", "character"})
    public static boolean isCharNumeric(int ch) {
        return Character.isDigit(ch);
    }

    @SourceMethodType(value={"", "character"})
    public static boolean isCharWhitespace(int ch) {
        return UnicodeUtils.isWhitespace(ch);
    }

    @SourceMethodType(value={"", "character"})
    public static boolean isCharUpperCase(int ch) {
        return Character.isUpperCase(ch);
    }

    @SourceMethodType(value={"", "character"})
    public static boolean isCharLowerCase(int ch) {
        return Character.isLowerCase(ch);
    }

    @SourceMethodType(value={"", "character"})
    public static boolean isCharTitleCase(int ch) {
        return Character.isTitleCase(ch);
    }

    @SourceMethodType(value={"character", "character"})
    public static int charFoldcase(int ch) {
        boolean x;
        int val = ch;
        boolean bl = x = val == 304;
        return (x ? x : val == 305) ? ch : Character.toLowerCase(Character.toUpperCase(val));
    }

    @SourceMethodType(value={"", "character"})
    public static Symbol charGeneralCategory(int ch) {
        return UnicodeUtils.generalCategory(ch);
    }

    public static CharSequence stringUpcase(CharSequence str) {
        return new FString((CharSequence)str.toString().toUpperCase(Locale.ENGLISH));
    }

    public static CharSequence stringDowncase(CharSequence str) {
        return new FString((CharSequence)str.toString().toLowerCase(Locale.ENGLISH));
    }

    public static CharSequence stringTitlecase(CharSequence str) {
        CharSequence charSequence = str;
        return new FString((CharSequence)UnicodeUtils.capitalize((String)(charSequence == null ? null : ((Object)charSequence).toString())));
    }

    public static CharSequence stringFoldcase(CharSequence str) {
        return new FString(UnicodeUtils.foldCase(str));
    }

    public static CharSequence stringNormalizeNfd(CharSequence str) {
        Type.NeverReturns neverReturns = exceptions.error("unicode string normalization not available");
        throw Special.reachedUnexpected;
    }

    public static CharSequence stringNormalizeNfkd(CharSequence str) {
        Type.NeverReturns neverReturns = exceptions.error("unicode string normalization not available");
        throw Special.reachedUnexpected;
    }

    public static CharSequence stringNormalizeNfc(CharSequence str) {
        Type.NeverReturns neverReturns = exceptions.error("unicode string normalization not available");
        throw Special.reachedUnexpected;
    }

    public static CharSequence stringNormalizeNfkc(CharSequence str) {
        Type.NeverReturns neverReturns = exceptions.error("unicode string normalization not available");
        throw Special.reachedUnexpected;
    }

    public static {
        Lit18 = Symbol.valueOf("string-normalize-nfkc");
        Lit17 = Symbol.valueOf("string-normalize-nfc");
        Lit16 = Symbol.valueOf("string-normalize-nfkd");
        Lit15 = Symbol.valueOf("string-normalize-nfd");
        Lit14 = Symbol.valueOf("string-foldcase");
        Lit13 = Symbol.valueOf("string-titlecase");
        Lit12 = Symbol.valueOf("string-downcase");
        Lit11 = Symbol.valueOf("string-upcase");
        Lit10 = Symbol.valueOf("char-general-category");
        Lit9 = Symbol.valueOf("char-foldcase");
        Lit8 = Symbol.valueOf("char-title-case?");
        Lit7 = Symbol.valueOf("char-lower-case?");
        Lit6 = Symbol.valueOf("char-upper-case?");
        Lit5 = Symbol.valueOf("char-whitespace?");
        Lit4 = Symbol.valueOf("char-numeric?");
        Lit3 = Symbol.valueOf("char-alphabetic?");
        Lit2 = Symbol.valueOf("char-titlecase");
        Lit1 = Symbol.valueOf("char-downcase");
        Lit0 = Symbol.valueOf("char-upcase");
        unicode unicode2 = $instance = new unicode();
        char$Mnupcase = new ModuleMethod(unicode2, 1, Lit0, 4097);
        char$Mndowncase = new ModuleMethod(unicode2, 2, Lit1, 4097);
        char$Mntitlecase = new ModuleMethod(unicode2, 3, Lit2, 4097);
        char$Mnalphabetic$Qu = new ModuleMethod(unicode2, 4, Lit3, 4097);
        char$Mnnumeric$Qu = new ModuleMethod(unicode2, 5, Lit4, 4097);
        char$Mnwhitespace$Qu = new ModuleMethod(unicode2, 6, Lit5, 4097);
        char$Mnupper$Mncase$Qu = new ModuleMethod(unicode2, 7, Lit6, 4097);
        char$Mnlower$Mncase$Qu = new ModuleMethod(unicode2, 8, Lit7, 4097);
        char$Mntitle$Mncase$Qu = new ModuleMethod(unicode2, 9, Lit8, 4097);
        char$Mnfoldcase = new ModuleMethod(unicode2, 10, Lit9, 4097);
        char$Mngeneral$Mncategory = new ModuleMethod(unicode2, 11, Lit10, 4097);
        string$Mnupcase = new ModuleMethod(unicode2, 12, Lit11, 4097);
        string$Mndowncase = new ModuleMethod(unicode2, 13, Lit12, 4097);
        string$Mntitlecase = new ModuleMethod(unicode2, 14, Lit13, 4097);
        string$Mnfoldcase = new ModuleMethod(unicode2, 15, Lit14, 4097);
        string$Mnnormalize$Mnnfd = new ModuleMethod(unicode2, 16, Lit15, 4097);
        string$Mnnormalize$Mnnfkd = new ModuleMethod(unicode2, 17, Lit16, 4097);
        string$Mnnormalize$Mnnfc = new ModuleMethod(unicode2, 18, Lit17, 4097);
        string$Mnnormalize$Mnnfkc = new ModuleMethod(unicode2, 19, Lit18, 4097);
        unicode.$runBody$();
    }

    public unicode() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 19: {
                Object object3 = Promise.force(object2, CharSequence.class);
                if (!(object3 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                Object object4 = Promise.force(object2, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                Object object6 = Promise.force(object2, CharSequence.class);
                if (!(object6 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
                Object object7 = Promise.force(object2, CharSequence.class);
                if (!(object7 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object8 = Promise.force(object2, CharSequence.class);
                if (!(object8 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
                Object object9 = Promise.force(object2, CharSequence.class);
                if (!(object9 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                Object object10 = Promise.force(object2, CharSequence.class);
                if (!(object10 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                Object object11 = Promise.force(object2);
                if (Char.checkCharOrEof(object11) < 0) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                Object object12 = Promise.force(object2);
                if (Char.checkCharOrEof(object12) < 0) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                Object object13 = Promise.force(object2);
                if (Char.checkCharOrEof(object13) < 0) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 8: {
                Object object14 = Promise.force(object2);
                if (Char.checkCharOrEof(object14) < 0) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                Object object15 = Promise.force(object2);
                if (Char.checkCharOrEof(object15) < 0) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                Object object16 = Promise.force(object2);
                if (Char.checkCharOrEof(object16) < 0) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                Object object17 = Promise.force(object2);
                if (Char.checkCharOrEof(object17) < 0) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object18 = Promise.force(object2);
                if (Char.checkCharOrEof(object18) < 0) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                Object object19 = Promise.force(object2);
                if (Char.checkCharOrEof(object19) < 0) {
                    return -786431;
                }
                callContext.value1 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                Object object20 = Promise.force(object2);
                if (Char.checkCharOrEof(object20) < 0) {
                    return -786431;
                }
                callContext.value1 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                Object object21 = Promise.force(object2);
                if (Char.checkCharOrEof(object21) < 0) {
                    return -786431;
                }
                callContext.value1 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
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
                return Char.make(unicode.charUpcase(Char.castToCharacter(Promise.force(object2))));
            }
            case 2: {
                return Char.make(unicode.charDowncase(Char.castToCharacter(Promise.force(object2))));
            }
            case 3: {
                return Char.make(unicode.charTitlecase(Char.castToCharacter(Promise.force(object2))));
            }
            case 4: {
                Boolean bl;
                if (unicode.isCharAlphabetic(Char.castToCharacter(Promise.force(object2)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 5: {
                Boolean bl;
                if (unicode.isCharNumeric(Char.castToCharacter(Promise.force(object2)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 6: {
                Boolean bl;
                if (unicode.isCharWhitespace(Char.castToCharacter(Promise.force(object2)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 7: {
                Boolean bl;
                if (unicode.isCharUpperCase(Char.castToCharacter(Promise.force(object2)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 8: {
                Boolean bl;
                if (unicode.isCharLowerCase(Char.castToCharacter(Promise.force(object2)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 9: {
                Boolean bl;
                if (unicode.isCharTitleCase(Char.castToCharacter(Promise.force(object2)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 10: {
                return Char.make(unicode.charFoldcase(Char.castToCharacter(Promise.force(object2))));
            }
            case 11: {
                return unicode.charGeneralCategory(Char.castToCharacter(Promise.force(object2)));
            }
            case 12: {
                return unicode.stringUpcase((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 13: {
                return unicode.stringDowncase((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 14: {
                return unicode.stringTitlecase((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 15: {
                return unicode.stringFoldcase((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 16: {
                return unicode.stringNormalizeNfd((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 17: {
                return unicode.stringNormalizeNfkd((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 18: {
                return unicode.stringNormalizeNfc((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 19: {
                return unicode.stringNormalizeNfkc((CharSequence)Promise.force(object2, CharSequence.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-upcase", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-downcase", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-titlecase", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-alphabetic?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-numeric?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-whitespace?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-upper-case?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-lower-case?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-title-case?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-foldcase", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-general-category", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-upcase", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-downcase", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-titlecase", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-foldcase", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-normalize-nfd", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-normalize-nfkd", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-normalize-nfc", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-normalize-nfkc", 1, object2);
        }
    }
}

