// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.rnrs;

import gnu.text.Char;
import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.lists.FString;
import java.util.Locale;
import gnu.mapping.Symbol;
import gnu.kawa.functions.UnicodeUtils;
import kawa.SourceMethodType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class unicode extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    @SourceMethodType({ "character", "character" })
    public static int charUpcase(final int ch) {
        return Character.toUpperCase(ch);
    }
    
    @SourceMethodType({ "character", "character" })
    public static int charDowncase(final int ch) {
        return Character.toLowerCase(ch);
    }
    
    @SourceMethodType({ "character", "character" })
    public static int charTitlecase(final int ch) {
        return Character.toTitleCase(ch);
    }
    
    @SourceMethodType({ "", "character" })
    public static boolean isCharAlphabetic(final int ch) {
        return Character.isLetter(ch);
    }
    
    @SourceMethodType({ "", "character" })
    public static boolean isCharNumeric(final int ch) {
        return Character.isDigit(ch);
    }
    
    @SourceMethodType({ "", "character" })
    public static boolean isCharWhitespace(final int ch) {
        return UnicodeUtils.isWhitespace(ch);
    }
    
    @SourceMethodType({ "", "character" })
    public static boolean isCharUpperCase(final int ch) {
        return Character.isUpperCase(ch);
    }
    
    @SourceMethodType({ "", "character" })
    public static boolean isCharLowerCase(final int ch) {
        return Character.isLowerCase(ch);
    }
    
    @SourceMethodType({ "", "character" })
    public static boolean isCharTitleCase(final int ch) {
        return Character.isTitleCase(ch);
    }
    
    @SourceMethodType({ "character", "character" })
    public static int charFoldcase(final int ch) {
        final int val = ch;
        final boolean x = val == 304;
        return (x ? x : (val == 305)) ? ch : Character.toLowerCase(Character.toUpperCase(val));
    }
    
    @SourceMethodType({ "", "character" })
    public static Symbol charGeneralCategory(final int ch) {
        return UnicodeUtils.generalCategory(ch);
    }
    
    public static CharSequence stringUpcase(final CharSequence str) {
        return new FString((CharSequence)str.toString().toUpperCase(Locale.ENGLISH));
    }
    
    public static CharSequence stringDowncase(final CharSequence str) {
        return new FString((CharSequence)str.toString().toLowerCase(Locale.ENGLISH));
    }
    
    public static CharSequence stringTitlecase(final CharSequence str) {
        return new FString((CharSequence)UnicodeUtils.capitalize((str == null) ? null : str.toString()));
    }
    
    public static CharSequence stringFoldcase(final CharSequence str) {
        return new FString(UnicodeUtils.foldCase(str));
    }
    
    public static CharSequence stringNormalizeNfd(final CharSequence str) {
        exceptions.error("unicode string normalization not available");
        throw Special.reachedUnexpected;
    }
    
    public static CharSequence stringNormalizeNfkd(final CharSequence str) {
        exceptions.error("unicode string normalization not available");
        throw Special.reachedUnexpected;
    }
    
    public static CharSequence stringNormalizeNfc(final CharSequence str) {
        exceptions.error("unicode string normalization not available");
        throw Special.reachedUnexpected;
    }
    
    public static CharSequence stringNormalizeNfkc(final CharSequence str) {
        exceptions.error("unicode string normalization not available");
        throw Special.reachedUnexpected;
    }
    
    static {
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
        unicode.$instance = new unicode();
        final unicode $instance = unicode.$instance;
        char$Mnupcase = new ModuleMethod($instance, 1, unicode.Lit0, 4097);
        char$Mndowncase = new ModuleMethod($instance, 2, unicode.Lit1, 4097);
        char$Mntitlecase = new ModuleMethod($instance, 3, unicode.Lit2, 4097);
        char$Mnalphabetic$Qu = new ModuleMethod($instance, 4, unicode.Lit3, 4097);
        char$Mnnumeric$Qu = new ModuleMethod($instance, 5, unicode.Lit4, 4097);
        char$Mnwhitespace$Qu = new ModuleMethod($instance, 6, unicode.Lit5, 4097);
        char$Mnupper$Mncase$Qu = new ModuleMethod($instance, 7, unicode.Lit6, 4097);
        char$Mnlower$Mncase$Qu = new ModuleMethod($instance, 8, unicode.Lit7, 4097);
        char$Mntitle$Mncase$Qu = new ModuleMethod($instance, 9, unicode.Lit8, 4097);
        char$Mnfoldcase = new ModuleMethod($instance, 10, unicode.Lit9, 4097);
        char$Mngeneral$Mncategory = new ModuleMethod($instance, 11, unicode.Lit10, 4097);
        string$Mnupcase = new ModuleMethod($instance, 12, unicode.Lit11, 4097);
        string$Mndowncase = new ModuleMethod($instance, 13, unicode.Lit12, 4097);
        string$Mntitlecase = new ModuleMethod($instance, 14, unicode.Lit13, 4097);
        string$Mnfoldcase = new ModuleMethod($instance, 15, unicode.Lit14, 4097);
        string$Mnnormalize$Mnnfd = new ModuleMethod($instance, 16, unicode.Lit15, 4097);
        string$Mnnormalize$Mnnfkd = new ModuleMethod($instance, 17, unicode.Lit16, 4097);
        string$Mnnormalize$Mnnfc = new ModuleMethod($instance, 18, unicode.Lit17, 4097);
        string$Mnnormalize$Mnnfkc = new ModuleMethod($instance, 19, unicode.Lit18, 4097);
        $runBody$();
    }
    
    public unicode() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 19: {
                final Object force = Promise.force(o, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 18: {
                final Object force2 = Promise.force(o, CharSequence.class);
                if (force2 instanceof CharSequence) {
                    ctx.value1 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 17: {
                final Object force3 = Promise.force(o, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value1 = force3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 16: {
                final Object force4 = Promise.force(o, CharSequence.class);
                if (force4 instanceof CharSequence) {
                    ctx.value1 = force4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 15: {
                final Object force5 = Promise.force(o, CharSequence.class);
                if (force5 instanceof CharSequence) {
                    ctx.value1 = force5;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force6 = Promise.force(o, CharSequence.class);
                if (force6 instanceof CharSequence) {
                    ctx.value1 = force6;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 13: {
                final Object force7 = Promise.force(o, CharSequence.class);
                if (force7 instanceof CharSequence) {
                    ctx.value1 = force7;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 12: {
                final Object force8 = Promise.force(o, CharSequence.class);
                if (force8 instanceof CharSequence) {
                    ctx.value1 = force8;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 11: {
                final Object force9 = Promise.force(o);
                if (Char.checkCharOrEof(force9) >= 0) {
                    ctx.value1 = force9;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 10: {
                final Object force10 = Promise.force(o);
                if (Char.checkCharOrEof(force10) >= 0) {
                    ctx.value1 = force10;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 9: {
                final Object force11 = Promise.force(o);
                if (Char.checkCharOrEof(force11) >= 0) {
                    ctx.value1 = force11;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 8: {
                final Object force12 = Promise.force(o);
                if (Char.checkCharOrEof(force12) >= 0) {
                    ctx.value1 = force12;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force13 = Promise.force(o);
                if (Char.checkCharOrEof(force13) >= 0) {
                    ctx.value1 = force13;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 6: {
                final Object force14 = Promise.force(o);
                if (Char.checkCharOrEof(force14) >= 0) {
                    ctx.value1 = force14;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 5: {
                final Object force15 = Promise.force(o);
                if (Char.checkCharOrEof(force15) >= 0) {
                    ctx.value1 = force15;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 4: {
                final Object force16 = Promise.force(o);
                if (Char.checkCharOrEof(force16) >= 0) {
                    ctx.value1 = force16;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 3: {
                final Object force17 = Promise.force(o);
                if (Char.checkCharOrEof(force17) >= 0) {
                    ctx.value1 = force17;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                final Object force18 = Promise.force(o);
                if (Char.checkCharOrEof(force18) >= 0) {
                    ctx.value1 = force18;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 1: {
                final Object force19 = Promise.force(o);
                if (Char.checkCharOrEof(force19) >= 0) {
                    ctx.value1 = force19;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                2: 96
        //                3: 110
        //                4: 124
        //                5: 138
        //                6: 161
        //                7: 184
        //                8: 207
        //                9: 230
        //               10: 253
        //               11: 276
        //               12: 290
        //               13: 301
        //               14: 314
        //               15: 327
        //               16: 340
        //               17: 353
        //               18: 366
        //               19: 379
        //               20: 392
        //          default: 405
        //        }
        //    96: aload_2        
        //    97: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   100: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   103: invokestatic    kawa/lib/rnrs/unicode.charUpcase:(I)I
        //   106: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   109: areturn        
        //   110: aload_2        
        //   111: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   114: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   117: invokestatic    kawa/lib/rnrs/unicode.charDowncase:(I)I
        //   120: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   123: areturn        
        //   124: aload_2        
        //   125: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   128: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   131: invokestatic    kawa/lib/rnrs/unicode.charTitlecase:(I)I
        //   134: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   137: areturn        
        //   138: aload_2        
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   142: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   145: invokestatic    kawa/lib/rnrs/unicode.isCharAlphabetic:(I)Z
        //   148: ifeq            157
        //   151: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   154: goto            160
        //   157: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   160: areturn        
        //   161: aload_2        
        //   162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   165: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   168: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //   171: ifeq            180
        //   174: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   177: goto            183
        //   180: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   183: areturn        
        //   184: aload_2        
        //   185: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   188: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   191: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
        //   194: ifeq            203
        //   197: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   200: goto            206
        //   203: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   206: areturn        
        //   207: aload_2        
        //   208: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   211: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   214: invokestatic    kawa/lib/rnrs/unicode.isCharUpperCase:(I)Z
        //   217: ifeq            226
        //   220: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   223: goto            229
        //   226: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   229: areturn        
        //   230: aload_2        
        //   231: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   234: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   237: invokestatic    kawa/lib/rnrs/unicode.isCharLowerCase:(I)Z
        //   240: ifeq            249
        //   243: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   246: goto            252
        //   249: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   252: areturn        
        //   253: aload_2        
        //   254: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   257: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   260: invokestatic    kawa/lib/rnrs/unicode.isCharTitleCase:(I)Z
        //   263: ifeq            272
        //   266: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   269: goto            275
        //   272: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   275: areturn        
        //   276: aload_2        
        //   277: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   280: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   283: invokestatic    kawa/lib/rnrs/unicode.charFoldcase:(I)I
        //   286: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   289: areturn        
        //   290: aload_2        
        //   291: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   294: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   297: invokestatic    kawa/lib/rnrs/unicode.charGeneralCategory:(I)Lgnu/mapping/Symbol;
        //   300: areturn        
        //   301: aload_2        
        //   302: ldc             Ljava/lang/CharSequence;.class
        //   304: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   307: checkcast       Ljava/lang/CharSequence;
        //   310: invokestatic    kawa/lib/rnrs/unicode.stringUpcase:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   313: areturn        
        //   314: aload_2        
        //   315: ldc             Ljava/lang/CharSequence;.class
        //   317: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   320: checkcast       Ljava/lang/CharSequence;
        //   323: invokestatic    kawa/lib/rnrs/unicode.stringDowncase:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   326: areturn        
        //   327: aload_2        
        //   328: ldc             Ljava/lang/CharSequence;.class
        //   330: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   333: checkcast       Ljava/lang/CharSequence;
        //   336: invokestatic    kawa/lib/rnrs/unicode.stringTitlecase:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   339: areturn        
        //   340: aload_2        
        //   341: ldc             Ljava/lang/CharSequence;.class
        //   343: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   346: checkcast       Ljava/lang/CharSequence;
        //   349: invokestatic    kawa/lib/rnrs/unicode.stringFoldcase:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   352: areturn        
        //   353: aload_2        
        //   354: ldc             Ljava/lang/CharSequence;.class
        //   356: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   359: checkcast       Ljava/lang/CharSequence;
        //   362: invokestatic    kawa/lib/rnrs/unicode.stringNormalizeNfd:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   365: areturn        
        //   366: aload_2        
        //   367: ldc             Ljava/lang/CharSequence;.class
        //   369: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   372: checkcast       Ljava/lang/CharSequence;
        //   375: invokestatic    kawa/lib/rnrs/unicode.stringNormalizeNfkd:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   378: areturn        
        //   379: aload_2        
        //   380: ldc             Ljava/lang/CharSequence;.class
        //   382: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   385: checkcast       Ljava/lang/CharSequence;
        //   388: invokestatic    kawa/lib/rnrs/unicode.stringNormalizeNfc:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   391: areturn        
        //   392: aload_2        
        //   393: ldc             Ljava/lang/CharSequence;.class
        //   395: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   398: checkcast       Ljava/lang/CharSequence;
        //   401: invokestatic    kawa/lib/rnrs/unicode.stringNormalizeNfkc:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   404: areturn        
        //   405: aload_0        
        //   406: aload_1        
        //   407: aload_2        
        //   408: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   411: areturn        
        //   412: new             Lgnu/mapping/WrongType;
        //   415: dup_x1         
        //   416: swap           
        //   417: ldc_w           "char-upcase"
        //   420: iconst_1       
        //   421: aload_2        
        //   422: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   425: athrow         
        //   426: new             Lgnu/mapping/WrongType;
        //   429: dup_x1         
        //   430: swap           
        //   431: ldc_w           "char-downcase"
        //   434: iconst_1       
        //   435: aload_2        
        //   436: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   439: athrow         
        //   440: new             Lgnu/mapping/WrongType;
        //   443: dup_x1         
        //   444: swap           
        //   445: ldc_w           "char-titlecase"
        //   448: iconst_1       
        //   449: aload_2        
        //   450: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   453: athrow         
        //   454: new             Lgnu/mapping/WrongType;
        //   457: dup_x1         
        //   458: swap           
        //   459: ldc_w           "char-alphabetic?"
        //   462: iconst_1       
        //   463: aload_2        
        //   464: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   467: athrow         
        //   468: new             Lgnu/mapping/WrongType;
        //   471: dup_x1         
        //   472: swap           
        //   473: ldc_w           "char-numeric?"
        //   476: iconst_1       
        //   477: aload_2        
        //   478: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   481: athrow         
        //   482: new             Lgnu/mapping/WrongType;
        //   485: dup_x1         
        //   486: swap           
        //   487: ldc_w           "char-whitespace?"
        //   490: iconst_1       
        //   491: aload_2        
        //   492: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   495: athrow         
        //   496: new             Lgnu/mapping/WrongType;
        //   499: dup_x1         
        //   500: swap           
        //   501: ldc_w           "char-upper-case?"
        //   504: iconst_1       
        //   505: aload_2        
        //   506: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   509: athrow         
        //   510: new             Lgnu/mapping/WrongType;
        //   513: dup_x1         
        //   514: swap           
        //   515: ldc_w           "char-lower-case?"
        //   518: iconst_1       
        //   519: aload_2        
        //   520: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   523: athrow         
        //   524: new             Lgnu/mapping/WrongType;
        //   527: dup_x1         
        //   528: swap           
        //   529: ldc_w           "char-title-case?"
        //   532: iconst_1       
        //   533: aload_2        
        //   534: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   537: athrow         
        //   538: new             Lgnu/mapping/WrongType;
        //   541: dup_x1         
        //   542: swap           
        //   543: ldc_w           "char-foldcase"
        //   546: iconst_1       
        //   547: aload_2        
        //   548: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   551: athrow         
        //   552: new             Lgnu/mapping/WrongType;
        //   555: dup_x1         
        //   556: swap           
        //   557: ldc_w           "char-general-category"
        //   560: iconst_1       
        //   561: aload_2        
        //   562: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   565: athrow         
        //   566: new             Lgnu/mapping/WrongType;
        //   569: dup_x1         
        //   570: swap           
        //   571: ldc_w           "string-upcase"
        //   574: iconst_1       
        //   575: aload_2        
        //   576: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   579: athrow         
        //   580: new             Lgnu/mapping/WrongType;
        //   583: dup_x1         
        //   584: swap           
        //   585: ldc_w           "string-downcase"
        //   588: iconst_1       
        //   589: aload_2        
        //   590: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   593: athrow         
        //   594: new             Lgnu/mapping/WrongType;
        //   597: dup_x1         
        //   598: swap           
        //   599: ldc_w           "string-titlecase"
        //   602: iconst_1       
        //   603: aload_2        
        //   604: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   607: athrow         
        //   608: new             Lgnu/mapping/WrongType;
        //   611: dup_x1         
        //   612: swap           
        //   613: ldc_w           "string-foldcase"
        //   616: iconst_1       
        //   617: aload_2        
        //   618: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   621: athrow         
        //   622: new             Lgnu/mapping/WrongType;
        //   625: dup_x1         
        //   626: swap           
        //   627: ldc_w           "string-normalize-nfd"
        //   630: iconst_1       
        //   631: aload_2        
        //   632: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   635: athrow         
        //   636: new             Lgnu/mapping/WrongType;
        //   639: dup_x1         
        //   640: swap           
        //   641: ldc_w           "string-normalize-nfkd"
        //   644: iconst_1       
        //   645: aload_2        
        //   646: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   649: athrow         
        //   650: new             Lgnu/mapping/WrongType;
        //   653: dup_x1         
        //   654: swap           
        //   655: ldc_w           "string-normalize-nfc"
        //   658: iconst_1       
        //   659: aload_2        
        //   660: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   663: athrow         
        //   664: new             Lgnu/mapping/WrongType;
        //   667: dup_x1         
        //   668: swap           
        //   669: ldc_w           "string-normalize-nfkc"
        //   672: iconst_1       
        //   673: aload_2        
        //   674: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   677: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  100    103    412    426    Ljava/lang/ClassCastException;
        //  114    117    426    440    Ljava/lang/ClassCastException;
        //  128    131    440    454    Ljava/lang/ClassCastException;
        //  142    145    454    468    Ljava/lang/ClassCastException;
        //  165    168    468    482    Ljava/lang/ClassCastException;
        //  188    191    482    496    Ljava/lang/ClassCastException;
        //  211    214    496    510    Ljava/lang/ClassCastException;
        //  234    237    510    524    Ljava/lang/ClassCastException;
        //  257    260    524    538    Ljava/lang/ClassCastException;
        //  280    283    538    552    Ljava/lang/ClassCastException;
        //  294    297    552    566    Ljava/lang/ClassCastException;
        //  307    310    566    580    Ljava/lang/ClassCastException;
        //  320    323    580    594    Ljava/lang/ClassCastException;
        //  333    336    594    608    Ljava/lang/ClassCastException;
        //  346    349    608    622    Ljava/lang/ClassCastException;
        //  359    362    622    636    Ljava/lang/ClassCastException;
        //  372    375    636    650    Ljava/lang/ClassCastException;
        //  385    388    650    664    Ljava/lang/ClassCastException;
        //  398    401    664    678    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 291 out of bounds for length 291
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
