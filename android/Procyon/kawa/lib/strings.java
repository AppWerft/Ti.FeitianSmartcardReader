// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.kawa.functions.ApplyToArgs;
import gnu.mapping.WrongType;
import gnu.kawa.functions.MakeSplice;
import kawa.standard.Scheme;
import kawa.lib.kawa.string-cursors;
import gnu.kawa.functions.UnicodeUtils;
import gnu.lists.LList;
import gnu.lists.CharSeq;
import gnu.lists.Strings;
import gnu.mapping.Promise;
import gnu.text.Char;
import kawa.SourceMethodType;
import gnu.lists.FString;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Location;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class strings extends ModuleBody
{
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
    
    public static boolean isString$Eq(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompare2(str1, str2) == 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompare2(prev, next) != 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean isString(final Object x) {
        return x instanceof CharSequence;
    }
    
    public static FString makeString(final int n) {
        return makeString(n, 32);
    }
    
    @SourceMethodType({ "", "", "character" })
    public static FString makeString(final int n, final int ch) {
        return new FString(n, ch);
    }
    
    public static CharSequence $make$string$(final Object... args) {
        final int n = args.length;
        final FString str = FString.alloc(n);
        for (int i = 0; i < n; ++i) {
            str.appendCharacter(((Char)Promise.force(args[i], Char.class)).intValue());
        }
        return str;
    }
    
    public static int stringLength(final CharSequence str) {
        return Strings.sizeInCodePoints(str);
    }
    
    @SourceMethodType({ "character" })
    public static int stringRef(final CharSequence str, final int k) {
        return Character.codePointAt(str, Character.offsetByCodePoints(str, 0, k));
    }
    
    @SourceMethodType({ "", "", "", "character" })
    public static void stringSet$Ex(final CharSeq str, final int k, final int char) {
        str.setCharacterAt(Character.offsetByCodePoints(str, 0, k), char);
    }
    
    public static boolean isString$Ls(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompare2(str1, str2) < 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompare2(prev, next) >= 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    static int $PcStringCompare2(final CharSequence str1, final CharSequence str2) {
        return str1.toString().compareTo(str2.toString());
    }
    
    public static boolean isString$Gr(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompare2(str1, str2) > 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompare2(prev, next) <= 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isString$Ls$Eq(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompare2(str1, str2) <= 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompare2(prev, next) > 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isString$Gr$Eq(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompare2(str1, str2) >= 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompare2(prev, next) < 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static CharSequence substring(final CharSequence str, final int start, final int end) {
        final int istart = Character.offsetByCodePoints(str, 0, start);
        int n;
        if (end == -1) {
            n = str.length();
        }
        else {
            if (end < start) {
                throw new StringIndexOutOfBoundsException();
            }
            n = Character.offsetByCodePoints(str, istart, end - start);
        }
        final int iend = n;
        return new FString(str, istart, iend - istart);
    }
    
    public static LList string$To$List(final CharSequence str) {
        return string$To$List(str, 0, -1);
    }
    
    public static LList string$To$List(final CharSequence str, final int start) {
        return string$To$List(str, start, -1);
    }
    
    public static LList string$To$List(final CharSequence str, final int start, final int end) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: iload_1         /* start */
        //     3: invokestatic    java/lang/Character.offsetByCodePoints:(Ljava/lang/CharSequence;II)I
        //     6: istore_3        /* cstart */
        //     7: iload_2         /* end */
        //     8: iconst_m1      
        //     9: if_icmpne       21
        //    12: aload_0         /* str */
        //    13: invokeinterface java/lang/CharSequence.length:()I
        //    18: goto            42
        //    21: iload_2         /* end */
        //    22: iload_1         /* start */
        //    23: if_icmpge       34
        //    26: new             Ljava/lang/StringIndexOutOfBoundsException;
        //    29: dup            
        //    30: invokespecial   java/lang/StringIndexOutOfBoundsException.<init>:()V
        //    33: athrow         
        //    34: aload_0         /* str */
        //    35: iload_3         /* cstart */
        //    36: iload_2         /* end */
        //    37: iload_1         /* start */
        //    38: isub           
        //    39: invokestatic    java/lang/Character.offsetByCodePoints:(Ljava/lang/CharSequence;II)I
        //    42: istore          cend
        //    44: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    47: iload           cend
        //    49: istore          6
        //    51: astore          result
        //    53: iload           i
        //    55: iload_1         /* start */
        //    56: invokestatic    kawa/lib/kawa/string-cursors.isStringCursor$Ls$Eq:(II)Z
        //    59: ifeq            67
        //    62: aload           result
        //    64: goto            98
        //    67: aload_0         /* str */
        //    68: iload           i
        //    70: invokestatic    kawa/lib/kawa/string-cursors.stringCursorPrev:(Ljava/lang/CharSequence;I)I
        //    73: istore          prev
        //    75: new             Lgnu/lists/Pair;
        //    78: dup            
        //    79: aload_0         /* str */
        //    80: iload           prev
        //    82: invokestatic    kawa/lib/kawa/string-cursors.stringCursorRef:(Ljava/lang/CharSequence;I)I
        //    85: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    88: aload           result
        //    90: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    93: iload           prev
        //    95: goto            49
        //    98: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static CharSequence list$To$String(final LList lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   gnu/lists/LList.size:()I
        //     4: istore_1        /* len */
        //     5: new             Lgnu/lists/FString;
        //     8: dup            
        //     9: iload_1         /* len */
        //    10: invokespecial   gnu/lists/FString.<init>:(I)V
        //    13: astore_2        /* result */
        //    14: iconst_0       
        //    15: istore_3        /* i */
        //    16: iload_3         /* i */
        //    17: iload_1         /* len */
        //    18: if_icmpge       72
        //    21: aload_0         /* lst */
        //    22: dup            
        //    23: astore          5
        //    25: checkcast       Lgnu/lists/Pair;
        //    28: astore          pair
        //    30: aload_2         /* result */
        //    31: iload_3         /* i */
        //    32: aload           pair
        //    34: invokevirtual   gnu/lists/Pair.getCar:()Ljava/lang/Object;
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          5
        //    43: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    46: invokestatic    kawa/lib/strings.stringSet$Ex:(Lgnu/lists/CharSeq;II)V
        //    49: aload           pair
        //    51: invokevirtual   gnu/lists/Pair.getCdr:()Ljava/lang/Object;
        //    54: ldc             Lgnu/lists/LList;.class
        //    56: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    59: dup            
        //    60: astore          5
        //    62: checkcast       Lgnu/lists/LList;
        //    65: astore_0        /* lst */
        //    66: iinc            i, 1
        //    69: goto            16
        //    72: aload_2         /* result */
        //    73: areturn        
        //    74: new             Lgnu/mapping/WrongType;
        //    77: dup_x1         
        //    78: swap           
        //    79: ldc             "pair"
        //    81: bipush          -2
        //    83: aload           5
        //    85: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    88: athrow         
        //    89: new             Lgnu/mapping/WrongType;
        //    92: dup_x1         
        //    93: swap           
        //    94: ldc             "string-set!"
        //    96: iconst_2       
        //    97: aload           5
        //    99: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   102: athrow         
        //   103: new             Lgnu/mapping/WrongType;
        //   106: dup_x1         
        //   107: swap           
        //   108: ldc             "lst"
        //   110: bipush          -2
        //   112: aload           5
        //   114: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   117: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     28     74     89     Ljava/lang/ClassCastException;
        //  43     46     89     103    Ljava/lang/ClassCastException;
        //  62     65     103    118    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 63 out of bounds for length 63
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
    
    public static FString stringCopy(final CharSequence str) {
        return stringCopy(str, 0, -1);
    }
    
    public static FString stringCopy(final CharSequence str, final int start) {
        return stringCopy(str, start, -1);
    }
    
    public static FString stringCopy(final CharSequence str, final int start, final int end) {
        final int istart = Character.offsetByCodePoints(str, 0, start);
        int n;
        if (end == -1) {
            n = str.length();
        }
        else {
            if (end < start) {
                throw new StringIndexOutOfBoundsException();
            }
            n = Character.offsetByCodePoints(str, istart, end - start);
        }
        final int iend = n;
        return new FString(str, istart, iend - istart);
    }
    
    public static void stringCopy$Ex(final FString fString, final int n, final CharSequence charSequence) {
        stringCopy$Ex(fString, n, charSequence, 0);
    }
    
    public static void stringCopy$Ex(final FString to, final int at, final CharSequence charSequence, final int start) {
        stringCopy$Ex(to, at, charSequence, start, Strings.sizeInCodePoints(charSequence));
    }
    
    public static void stringCopy$Ex(final FString to, final int at, final CharSequence from, final int start, final int end) {
        stringReplace$Ex(to, at, at + (end - start), from, start, end);
    }
    
    public static void stringReplace$Ex(final FString dst, final int dstart, final int dend, final CharSequence src) {
        stringReplace$Ex(dst, dstart, dend, src, 0, -1);
    }
    
    public static void stringReplace$Ex(final FString dst, final int dstart, final int dend, final CharSequence src, final int sstart) {
        stringReplace$Ex(dst, dstart, dend, src, sstart, -1);
    }
    
    public static void stringReplace$Ex(final FString dst, final int dstart, final int dend, final CharSequence src, final int sstart, final int send) {
        final int csstart = Character.offsetByCodePoints(src, 0, sstart);
        int n;
        if (send == -1) {
            n = src.length();
        }
        else {
            if (send < sstart) {
                throw new StringIndexOutOfBoundsException();
            }
            n = Character.offsetByCodePoints(src, csstart, send - sstart);
        }
        final int csend = n;
        final int cdstart = Character.offsetByCodePoints(dst, 0, dstart);
        int n2;
        if (dend == -1) {
            n2 = dst.length();
        }
        else {
            if (dend < dstart) {
                throw new StringIndexOutOfBoundsException();
            }
            n2 = Character.offsetByCodePoints(dst, cdstart, dend - dstart);
        }
        final int cdend = n2;
        dst.replace(src, csstart, csend, cdstart, cdend);
    }
    
    @SourceMethodType({ "", "", "character" })
    public static void stringFill$Ex(final CharSeq str, final int ch) {
        stringFill$Ex(str, ch, 0, -1);
    }
    
    @SourceMethodType({ "", "", "character" })
    public static void stringFill$Ex(final CharSeq str, final int ch, final int start) {
        stringFill$Ex(str, ch, start, -1);
    }
    
    @SourceMethodType({ "", "", "character" })
    public static void stringFill$Ex(final CharSeq str, final int ch, final int start, final int end) {
        final int cstart = Character.offsetByCodePoints(str, 0, start);
        final int send = (end >= 0) ? end : Strings.sizeInCodePoints(str);
        if (str instanceof FString) {
            final FString fString = (FString)str;
            final int cend = (end < 0) ? fString.length() : Character.offsetByCodePoints(str, 0, end);
            fString.delete(cstart, cend);
            fString.insertRepeated(cstart, ch, send - start);
        }
        else {
            final int width = (ch > 65535) ? 2 : 1;
            for (int to$Mndo = send - start; to$Mndo > 0; --to$Mndo) {
                final int pos;
                str.setCharacterAt(pos, ch);
                pos += width;
            }
        }
    }
    
    public static CharSequence stringUpcase$Ex(final CharSeq str) {
        Strings.makeUpperCase(str);
        return str;
    }
    
    public static CharSequence stringDowncase$Ex(final CharSeq str) {
        Strings.makeLowerCase(str);
        return str;
    }
    
    public static CharSequence stringCapitalize$Ex(final CharSeq str) {
        Strings.makeCapitalize(str);
        return str;
    }
    
    public static CharSequence stringCapitalize(final CharSequence str) {
        final FString copy = stringCopy(str);
        Strings.makeCapitalize(copy);
        return copy;
    }
    
    public static FString stringAppend(final Object... args) {
        final FString str = new FString();
        str.addAllStrings(args, 0);
        return str;
    }
    
    public static boolean isStringCi$Ls(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompareCi2(str1, str2) < 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompareCi2(prev, next) >= 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    static int $PcStringCompareCi2(final CharSequence str1, final CharSequence str2) {
        return UnicodeUtils.foldCase(str1).toString().compareTo(UnicodeUtils.foldCase(str2).toString());
    }
    
    public static boolean isStringCi$Eq(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompareCi2(str1, str2) == 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompareCi2(prev, next) != 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isStringCi$Gr(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompareCi2(str1, str2) > 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompareCi2(prev, next) <= 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isStringCi$Ls$Eq(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompareCi2(str1, str2) <= 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompareCi2(prev, next) > 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isStringCi$Gr$Eq(final CharSequence str1, final CharSequence str2, final CharSequence... strs) {
        boolean b;
        if ($PcStringCompareCi2(str1, str2) >= 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final CharSequence next = strs[i];
                final CharSequence prev;
                if ($PcStringCompareCi2(prev, next) < 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isChar$Eq(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompare(str1, str2) == 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompare(prev, next) != 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character" })
    static int $PcCharCompare(final int c1, final int c2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/characters.char$To$Integer:(I)I
        //     4: istore_2       
        //     5: iload_1         /* c2 */
        //     6: invokestatic    kawa/lib/characters.char$To$Integer:(I)I
        //     9: istore_3        /* i2 */
        //    10: iload_2         /* i1 */
        //    11: iload_3         /* i2 */
        //    12: if_icmple       19
        //    15: iconst_1       
        //    16: goto            29
        //    19: iload_2         /* i1 */
        //    20: iload_3         /* i2 */
        //    21: if_icmpge       28
        //    24: iconst_m1      
        //    25: goto            29
        //    28: iconst_0       
        //    29: ireturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isChar$Ls(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompare(str1, str2) < 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompare(prev, next) >= 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isChar$Gr(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompare(str1, str2) > 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompare(prev, next) <= 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isChar$Ls$Eq(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompare(str1, str2) <= 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompare(prev, next) > 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isChar$Gr$Eq(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompare(str1, str2) >= 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompare(prev, next) < 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isCharCi$Eq(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompareCi(str1, str2) == 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompareCi(prev, next) != 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character" })
    static int $PcCharCompareCi(final int c1, final int c2) {
        return Character.toUpperCase(characters.char$To$Integer(c1)) - Character.toUpperCase(characters.char$To$Integer(c2));
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isCharCi$Ls(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompareCi(str1, str2) < 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompareCi(prev, next) >= 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isCharCi$Gr(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompareCi(str1, str2) > 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompareCi(prev, next) <= 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isCharCi$Ls$Eq(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompareCi(str1, str2) <= 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompareCi(prev, next) > 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    @SourceMethodType({ "", "character", "character", "character[]" })
    public static boolean isCharCi$Gr$Eq(final int str1, final int str2, final int... strs) {
        boolean b;
        if ($PcCharCompareCi(str1, str2) >= 0) {
            final int n = strs.length;
            int i = 0;
            while (true) {
                final boolean x = i == n;
                if (x) {
                    b = x;
                    break;
                }
                final int next = strs[i];
                final int prev;
                if ($PcCharCompareCi(prev, next) < 0) {
                    b = false;
                    break;
                }
                prev = next;
                ++i;
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static void srfi$Mn13StringForEach(final Object proc, final CharSequence str) {
        srfi$Mn13StringForEach(proc, str, 0, -1);
    }
    
    public static void srfi$Mn13StringForEach(final Object proc, final CharSequence str, final int start) {
        srfi$Mn13StringForEach(proc, str, start, -1);
    }
    
    public static void srfi$Mn13StringForEach(final Object proc, final CharSequence str, final int start, final int end) {
        final int cstart = string-cursors.stringCursorNext(str, 0, start);
        final int cend = (end == -1) ? str.length() : string-cursors.stringCursorNext(str, cstart, end - start);
        string-cursors.stringCursorForEach(proc, str, cstart, cend);
    }
    
    public static void stringForEach(final Object proc, final CharSequence str1, final Object... rst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_3        /* nrst */
        //     3: iload_3         /* nrst */
        //     4: ifne            15
        //     7: aload_0         /* proc */
        //     8: aload_1         /* str1 */
        //     9: invokestatic    kawa/lib/kawa/string-cursors.stringCursorForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;)V
        //    12: goto            325
        //    15: iload_3         /* nrst */
        //    16: iconst_3       
        //    17: if_icmpge       76
        //    20: aload_2         /* rst */
        //    21: iconst_0       
        //    22: aaload         
        //    23: instanceof      Ljava/lang/CharSequence;
        //    26: ifne            76
        //    29: aload_0         /* proc */
        //    30: aload_1         /* str1 */
        //    31: aload_2         /* rst */
        //    32: iconst_0       
        //    33: aaload         
        //    34: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    37: dup            
        //    38: astore          4
        //    40: checkcast       Ljava/lang/Number;
        //    43: invokevirtual   java/lang/Number.intValue:()I
        //    46: iload_3         /* nrst */
        //    47: iconst_2       
        //    48: if_icmpne       69
        //    51: aload_2         /* rst */
        //    52: iconst_1       
        //    53: aaload         
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          4
        //    60: checkcast       Ljava/lang/Number;
        //    63: invokevirtual   java/lang/Number.intValue:()I
        //    66: goto            70
        //    69: iconst_m1      
        //    70: invokestatic    kawa/lib/strings.srfi$Mn13StringForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;II)V
        //    73: goto            325
        //    76: iload_3         /* nrst */
        //    77: iconst_1       
        //    78: iadd           
        //    79: istore          n
        //    81: iload           n
        //    83: newarray        I
        //    85: astore          cursors
        //    87: iload           n
        //    89: newarray        I
        //    91: astore          ends
        //    93: iload           n
        //    95: anewarray       Lgnu/text/Char;
        //    98: astore          chs
        //   100: aload           cursors
        //   102: iconst_0       
        //   103: aload_1         /* str1 */
        //   104: invokestatic    kawa/lib/kawa/string-cursors.stringCursorStart:(Ljava/lang/CharSequence;)I
        //   107: iastore        
        //   108: aload           ends
        //   110: iconst_0       
        //   111: aload_1         /* str1 */
        //   112: invokestatic    kawa/lib/kawa/string-cursors.stringCursorEnd:(Ljava/lang/CharSequence;)I
        //   115: iastore        
        //   116: iconst_1       
        //   117: istore          i
        //   119: iload           i
        //   121: iload           n
        //   123: if_icmpge       171
        //   126: aload_2         /* rst */
        //   127: iload           i
        //   129: iconst_1       
        //   130: isub           
        //   131: aaload         
        //   132: ldc             Ljava/lang/CharSequence;.class
        //   134: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   137: dup            
        //   138: astore          10
        //   140: checkcast       Ljava/lang/CharSequence;
        //   143: astore          str
        //   145: aload           cursors
        //   147: iload           i
        //   149: aload           str
        //   151: invokestatic    kawa/lib/kawa/string-cursors.stringCursorStart:(Ljava/lang/CharSequence;)I
        //   154: iastore        
        //   155: aload           ends
        //   157: iload           i
        //   159: aload           str
        //   161: invokestatic    kawa/lib/kawa/string-cursors.stringCursorEnd:(Ljava/lang/CharSequence;)I
        //   164: iastore        
        //   165: iinc            i, 1
        //   168: goto            119
        //   171: iconst_0       
        //   172: istore          i
        //   174: iload           i
        //   176: iload           n
        //   178: if_icmpne       240
        //   181: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   184: iconst_1       
        //   185: istore          9
        //   187: aload           chs
        //   189: astore          10
        //   191: aload           10
        //   193: invokestatic    gnu/kawa/functions/MakeSplice.count:(Ljava/lang/Object;)I
        //   196: dup            
        //   197: istore          11
        //   199: iload           9
        //   201: iadd           
        //   202: istore          9
        //   204: iload           9
        //   206: anewarray       Ljava/lang/Object;
        //   209: dup            
        //   210: iconst_0       
        //   211: aload_0         /* proc */
        //   212: aastore        
        //   213: dup            
        //   214: iconst_1       
        //   215: istore          12
        //   217: iload           12
        //   219: iload           11
        //   221: aload           10
        //   223: invokestatic    gnu/kawa/functions/MakeSplice.copyTo:([Ljava/lang/Object;IILjava/lang/Object;)V
        //   226: iload           12
        //   228: iload           11
        //   230: iadd           
        //   231: istore          12
        //   233: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
        //   236: pop            
        //   237: goto            171
        //   240: aload           cursors
        //   242: iload           i
        //   244: iaload         
        //   245: istore          curs$Mni
        //   247: aload           ends
        //   249: iload           i
        //   251: iaload         
        //   252: istore          end$Mni
        //   254: iload           i
        //   256: ifne            263
        //   259: aload_1         /* str1 */
        //   260: goto            280
        //   263: aload_2         /* rst */
        //   264: iload           i
        //   266: iconst_1       
        //   267: isub           
        //   268: aaload         
        //   269: ldc             Ljava/lang/CharSequence;.class
        //   271: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   274: dup            
        //   275: astore          12
        //   277: checkcast       Ljava/lang/CharSequence;
        //   280: astore          str
        //   282: iload           curs$Mni
        //   284: iload           end$Mni
        //   286: invokestatic    kawa/lib/kawa/string-cursors.isStringCursor$Ls:(II)Z
        //   289: ifeq            325
        //   292: aload           chs
        //   294: iload           i
        //   296: aload           str
        //   298: iload           curs$Mni
        //   300: invokestatic    kawa/lib/kawa/string-cursors.stringCursorRef:(Ljava/lang/CharSequence;I)I
        //   303: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   306: aastore        
        //   307: aload           cursors
        //   309: iload           i
        //   311: aload           str
        //   313: iload           curs$Mni
        //   315: invokestatic    kawa/lib/kawa/string-cursors.stringCursorNext:(Ljava/lang/CharSequence;I)I
        //   318: iastore        
        //   319: iinc            i, 1
        //   322: goto            174
        //   325: return         
        //   326: new             Lgnu/mapping/WrongType;
        //   329: dup_x1         
        //   330: swap           
        //   331: ldc             "srfi-13-string-for-each"
        //   333: iconst_2       
        //   334: aload           4
        //   336: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   339: athrow         
        //   340: new             Lgnu/mapping/WrongType;
        //   343: dup_x1         
        //   344: swap           
        //   345: ldc             "srfi-13-string-for-each"
        //   347: iconst_3       
        //   348: aload           4
        //   350: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   353: athrow         
        //   354: new             Lgnu/mapping/WrongType;
        //   357: dup_x1         
        //   358: swap           
        //   359: ldc             "str"
        //   361: bipush          -2
        //   363: aload           10
        //   365: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   368: athrow         
        //   369: new             Lgnu/mapping/WrongType;
        //   372: dup_x1         
        //   373: swap           
        //   374: ldc             "str"
        //   376: bipush          -2
        //   378: aload           12
        //   380: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   383: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  40     46     326    340    Ljava/lang/ClassCastException;
        //  60     66     340    354    Ljava/lang/ClassCastException;
        //  140    143    354    369    Ljava/lang/ClassCastException;
        //  277    280    369    384    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 205 out of bounds for length 205
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
    
    public static CharSequence stringMap(final Object proc, final CharSequence str1, final CharSequence... rst) {
        final int nrst = rst.length;
        final int n = nrst + 1;
        final int[] cursors = new int[n];
        final int[] ends = new int[n];
        final Char[] chs = new Char[n];
        final int len1 = str1.length();
        final FString result = FString.alloc(len1);
        ends[cursors[0] = 0] = len1;
        for (int i = 1; i < n; ++i) {
            final CharSequence str2 = rst[i - 1];
            cursors[i] = 0;
            ends[i] = str2.length();
        }
        while (true) {
            int i = 0;
            while (true) {
                Label_0182: {
                    if (i != n) {
                        break Label_0182;
                    }
                    final ApplyToArgs applyToArgs = Scheme.applyToArgs;
                    final int n2 = 1;
                    final Char[] array = chs;
                    final int count;
                    final Object[] target = new Object[(count = MakeSplice.count(array)) + n2];
                    target[0] = proc;
                    MakeSplice.copyTo(target, 1, count, array);
                    final Object force = Promise.force(applyToArgs.applyN(target));
                    try {
                        final int ch = Char.castToCharacter(force);
                        result.appendCharacter(ch);
                        break;
                        Label_0256: {
                            return result;
                        }
                        final int curs$Mni = cursors[i];
                        final int end$Mni = ends[i];
                        final CharSequence str3 = (i == 0) ? str1 : rst[i - 1];
                        // iftrue(Label_0256:, !string-cursors.isStringCursor$Ls(curs$Mni, end$Mni))
                        chs[i] = Char.make(string-cursors.stringCursorRef(str3, curs$Mni));
                        cursors[i] = string-cursors.stringCursorNext(str3, curs$Mni);
                        ++i;
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "ch", -2, force);
                    }
                }
            }
        }
    }
    
    public static void stringAppend$Ex(final FString str, final Object... args) {
        for (int len = args.length, i = 0; i < len; ++i) {
            str.append(args[i]);
        }
    }
    
    static {
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
        strings.$instance = new strings();
        $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
        $Prvt$cond = StaticFieldLocation.make("kawa.lib.std_syntax", "cond");
        $Prvt$and = StaticFieldLocation.make("kawa.lib.std_syntax", "and");
        $Prvt$or = StaticFieldLocation.make("kawa.lib.std_syntax", "or");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
        $Prvt$else = StaticFieldLocation.make("kawa.lib.std_syntax", "else");
        $Prvt$length = StaticFieldLocation.make("kawa.lib.lists", "length");
        final strings $instance = strings.$instance;
        string$Qu = new ModuleMethod($instance, 1, strings.Lit0, 4097);
        make$Mnstring = new ModuleMethod($instance, 2, strings.Lit1, 8193);
        $make$string$ = new ModuleMethod($instance, 4, strings.Lit2, -4096);
        string$Mnlength = new ModuleMethod($instance, 5, strings.Lit3, 4097);
        string$Mnref = new ModuleMethod($instance, 6, strings.Lit4, 8194);
        string$Mnset$Ex = new ModuleMethod($instance, 7, strings.Lit5, 12291);
        string$Ls$Qu = new ModuleMethod($instance, 8, strings.Lit6, -4094);
        string$Eq$Qu = new ModuleMethod($instance, 9, strings.Lit7, -4094);
        string$Gr$Qu = new ModuleMethod($instance, 10, strings.Lit8, -4094);
        string$Ls$Eq$Qu = new ModuleMethod($instance, 11, strings.Lit9, -4094);
        string$Gr$Eq$Qu = new ModuleMethod($instance, 12, strings.Lit10, -4094);
        substring = new ModuleMethod($instance, 13, strings.Lit11, 12291);
        string$Mn$Grlist = new ModuleMethod($instance, 14, strings.Lit12, 12289);
        list$Mn$Grstring = new ModuleMethod($instance, 17, strings.Lit13, 4097);
        string$Mncopy = new ModuleMethod($instance, 18, strings.Lit14, 12289);
        string$Mncopy$Ex = new ModuleMethod($instance, 21, strings.Lit15, 20483);
        string$Mnreplace$Ex = new ModuleMethod($instance, 24, strings.Lit16, 24580);
        string$Mnfill$Ex = new ModuleMethod($instance, 27, strings.Lit17, 16386);
        string$Mnupcase$Ex = new ModuleMethod($instance, 30, strings.Lit18, 4097);
        string$Mndowncase$Ex = new ModuleMethod($instance, 31, strings.Lit19, 4097);
        string$Mncapitalize$Ex = new ModuleMethod($instance, 32, strings.Lit20, 4097);
        string$Mncapitalize = new ModuleMethod($instance, 33, strings.Lit21, 4097);
        string$Mnappend = new ModuleMethod($instance, 34, strings.Lit22, -4096);
        string$Mnci$Ls$Qu = new ModuleMethod($instance, 35, strings.Lit23, -4094);
        string$Mnci$Eq$Qu = new ModuleMethod($instance, 36, strings.Lit24, -4094);
        string$Mnci$Gr$Qu = new ModuleMethod($instance, 37, strings.Lit25, -4094);
        string$Mnci$Ls$Eq$Qu = new ModuleMethod($instance, 38, strings.Lit26, -4094);
        string$Mnci$Gr$Eq$Qu = new ModuleMethod($instance, 39, strings.Lit27, -4094);
        final ModuleMethod char$Eq$Qu2 = new ModuleMethod($instance, 40, strings.Lit28, -4094);
        char$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Eq$Qu = char$Eq$Qu2;
        final ModuleMethod char$Ls$Qu2 = new ModuleMethod($instance, 41, strings.Lit29, -4094);
        char$Ls$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Ls$Qu = char$Ls$Qu2;
        final ModuleMethod char$Gr$Qu2 = new ModuleMethod($instance, 42, strings.Lit30, -4094);
        char$Gr$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Gr$Qu = char$Gr$Qu2;
        final ModuleMethod char$Ls$Eq$Qu2 = new ModuleMethod($instance, 43, strings.Lit31, -4094);
        char$Ls$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Ls$Eq$Qu = char$Ls$Eq$Qu2;
        final ModuleMethod char$Gr$Eq$Qu2 = new ModuleMethod($instance, 44, strings.Lit32, -4094);
        char$Gr$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Gr$Eq$Qu = char$Gr$Eq$Qu2;
        final ModuleMethod char$Mnci$Eq$Qu2 = new ModuleMethod($instance, 45, strings.Lit33, -4094);
        char$Mnci$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Eq$Qu = char$Mnci$Eq$Qu2;
        final ModuleMethod char$Mnci$Ls$Qu2 = new ModuleMethod($instance, 46, strings.Lit34, -4094);
        char$Mnci$Ls$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Ls$Qu = char$Mnci$Ls$Qu2;
        final ModuleMethod char$Mnci$Gr$Qu2 = new ModuleMethod($instance, 47, strings.Lit35, -4094);
        char$Mnci$Gr$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Gr$Qu = char$Mnci$Gr$Qu2;
        final ModuleMethod char$Mnci$Ls$Eq$Qu2 = new ModuleMethod($instance, 48, strings.Lit36, -4094);
        char$Mnci$Ls$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Ls$Eq$Qu = char$Mnci$Ls$Eq$Qu2;
        final ModuleMethod char$Mnci$Gr$Eq$Qu2 = new ModuleMethod($instance, 49, strings.Lit37, -4094);
        char$Mnci$Gr$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charCompareValidateApply");
        char$Mnci$Gr$Eq$Qu = char$Mnci$Gr$Eq$Qu2;
        final ModuleMethod srfi$Mn13$Mnstring$Mnfor$Mneach2 = new ModuleMethod($instance, 50, strings.Lit38, 16386);
        srfi$Mn13$Mnstring$Mnfor$Mneach2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:stringForEach1ValidateApply");
        srfi$Mn13$Mnstring$Mnfor$Mneach = srfi$Mn13$Mnstring$Mnfor$Mneach2;
        final ModuleMethod string$Mnfor$Mneach2 = new ModuleMethod($instance, 53, strings.Lit39, -4094);
        string$Mnfor$Mneach2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:stringForEachValidateApply");
        string$Mnfor$Mneach = string$Mnfor$Mneach2;
        string$Mnmap = new ModuleMethod($instance, 54, strings.Lit40, -4094);
        final ModuleMethod string$Mnappend$Ex2 = new ModuleMethod($instance, 55, strings.Lit41, -4095);
        string$Mnappend$Ex2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringAppendToValidateApply");
        string$Mnappend$Ex = string$Mnappend$Ex2;
        $runBody$();
    }
    
    public strings() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 33: {
                final Object force = Promise.force(arg1, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 32: {
                final Object force2 = Promise.force(arg1, CharSeq.class);
                if (!(force2 instanceof CharSeq)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 31: {
                final Object force3 = Promise.force(arg1, CharSeq.class);
                if (!(force3 instanceof CharSeq)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 30: {
                final Object force4 = Promise.force(arg1, CharSeq.class);
                if (!(force4 instanceof CharSeq)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
                final Object force5 = Promise.force(arg1, CharSequence.class);
                if (!(force5 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 17: {
                final Object force6 = Promise.force(arg1, LList.class);
                if (force6 instanceof LList) {
                    ctx.value1 = force6;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force7 = Promise.force(arg1, CharSequence.class);
                if (force7 instanceof CharSequence) {
                    ctx.value1 = force7;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 5: {
                final Object force8 = Promise.force(arg1, CharSequence.class);
                if (force8 instanceof CharSequence) {
                    ctx.value1 = force8;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(proc, arg1, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 50: {
                ctx.value1 = arg1;
                final Object force = Promise.force(arg2, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value2 = force;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 27: {
                final Object force2 = Promise.force(arg1, CharSeq.class);
                if (!(force2 instanceof CharSeq)) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(arg2);
                if (Char.checkCharOrEof(force3) >= 0) {
                    ctx.value2 = force3;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 18: {
                final Object force4 = Promise.force(arg1, CharSequence.class);
                if (!(force4 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 14: {
                final Object force5 = Promise.force(arg1, CharSequence.class);
                if (force5 instanceof CharSequence) {
                    ctx.value1 = force5;
                    ctx.value2 = Promise.force(arg2);
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 6: {
                final Object force6 = Promise.force(arg1, CharSequence.class);
                if (!(force6 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 2: {
                ctx.value1 = Promise.force(arg1);
                final Object force7 = Promise.force(arg2);
                if (Char.checkCharOrEof(force7) >= 0) {
                    ctx.value2 = force7;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 50: {
                ctx.value1 = o;
                final Object force = Promise.force(o2, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value2 = force;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 27: {
                final Object force2 = Promise.force(o, CharSeq.class);
                if (!(force2 instanceof CharSeq)) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(o2);
                if (Char.checkCharOrEof(force3) >= 0) {
                    ctx.value2 = force3;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 21: {
                final Object force4 = Promise.force(o, FString.class);
                if (!(force4 instanceof FString)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = Promise.force(o2);
                final Object force5 = Promise.force(o3, CharSequence.class);
                if (!(force5 instanceof CharSequence)) {
                    return -786429;
                }
                ctx.value3 = force5;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 18: {
                final Object force6 = Promise.force(o, CharSequence.class);
                if (!(force6 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.value2 = Promise.force(o2);
                ctx.value3 = Promise.force(o3);
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 14: {
                final Object force7 = Promise.force(o, CharSequence.class);
                if (force7 instanceof CharSequence) {
                    ctx.value1 = force7;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 13: {
                final Object force8 = Promise.force(o, CharSequence.class);
                if (force8 instanceof CharSequence) {
                    ctx.value1 = force8;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force9 = Promise.force(o, CharSeq.class);
                if (!(force9 instanceof CharSeq)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.value2 = Promise.force(o2);
                final Object force10 = Promise.force(o3);
                if (Char.checkCharOrEof(force10) >= 0) {
                    ctx.value3 = force10;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        switch (proc.selector) {
            case 50: {
                ctx.value1 = arg1;
                final Object force = Promise.force(arg2, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value2 = force;
                    ctx.value3 = Promise.force(arg3);
                    ctx.value4 = Promise.force(arg4);
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786430;
            }
            case 27: {
                final Object force2 = Promise.force(arg1, CharSeq.class);
                if (!(force2 instanceof CharSeq)) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(arg2);
                if (Char.checkCharOrEof(force3) >= 0) {
                    ctx.value2 = force3;
                    ctx.value3 = Promise.force(arg3);
                    ctx.value4 = Promise.force(arg4);
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786430;
            }
            case 24: {
                final Object force4 = Promise.force(arg1, FString.class);
                if (!(force4 instanceof FString)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
                final Object force5 = Promise.force(arg4, CharSequence.class);
                if (!(force5 instanceof CharSequence)) {
                    return -786428;
                }
                ctx.value4 = force5;
                ctx.proc = proc;
                ctx.pc = 4;
                return 0;
            }
            case 21: {
                final Object force6 = Promise.force(arg1, FString.class);
                if (!(force6 instanceof FString)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.value2 = Promise.force(arg2);
                final Object force7 = Promise.force(arg3, CharSequence.class);
                if (!(force7 instanceof CharSequence)) {
                    return -786429;
                }
                ctx.value3 = force7;
                ctx.value4 = Promise.force(arg4);
                ctx.proc = proc;
                ctx.pc = 4;
                return 0;
            }
            default: {
                return super.match4(proc, arg1, arg2, arg3, arg4, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 55: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 54: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 53: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 49: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 48: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 47: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 46: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 45: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 44: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 43: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 42: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 41: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 40: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 39: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 38: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 37: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 36: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 35: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 34: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 24: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 21: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 12: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 11: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 10: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 9: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 8: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 4: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(moduleMethod, array, ctx);
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
        //     4: lookupswitch {
        //                1: 96
        //                2: 113
        //                5: 127
        //               14: 143
        //               17: 156
        //               18: 169
        //               30: 182
        //               31: 195
        //               32: 208
        //               33: 221
        //          default: 234
        //        }
        //    96: aload_2        
        //    97: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
        //   100: ifeq            109
        //   103: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   106: goto            112
        //   109: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   112: areturn        
        //   113: aload_2        
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   117: checkcast       Ljava/lang/Number;
        //   120: invokevirtual   java/lang/Number.intValue:()I
        //   123: invokestatic    kawa/lib/strings.makeString:(I)Lgnu/lists/FString;
        //   126: areturn        
        //   127: aload_2        
        //   128: ldc             Ljava/lang/CharSequence;.class
        //   130: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   133: checkcast       Ljava/lang/CharSequence;
        //   136: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //   139: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   142: areturn        
        //   143: aload_2        
        //   144: ldc             Ljava/lang/CharSequence;.class
        //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   149: checkcast       Ljava/lang/CharSequence;
        //   152: invokestatic    kawa/lib/strings.string$To$List:(Ljava/lang/CharSequence;)Lgnu/lists/LList;
        //   155: areturn        
        //   156: aload_2        
        //   157: ldc             Lgnu/lists/LList;.class
        //   159: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   162: checkcast       Lgnu/lists/LList;
        //   165: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   168: areturn        
        //   169: aload_2        
        //   170: ldc             Ljava/lang/CharSequence;.class
        //   172: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   175: checkcast       Ljava/lang/CharSequence;
        //   178: invokestatic    kawa/lib/strings.stringCopy:(Ljava/lang/CharSequence;)Lgnu/lists/FString;
        //   181: areturn        
        //   182: aload_2        
        //   183: ldc             Lgnu/lists/CharSeq;.class
        //   185: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   188: checkcast       Lgnu/lists/CharSeq;
        //   191: invokestatic    kawa/lib/strings.stringUpcase$Ex:(Lgnu/lists/CharSeq;)Ljava/lang/CharSequence;
        //   194: areturn        
        //   195: aload_2        
        //   196: ldc             Lgnu/lists/CharSeq;.class
        //   198: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   201: checkcast       Lgnu/lists/CharSeq;
        //   204: invokestatic    kawa/lib/strings.stringDowncase$Ex:(Lgnu/lists/CharSeq;)Ljava/lang/CharSequence;
        //   207: areturn        
        //   208: aload_2        
        //   209: ldc             Lgnu/lists/CharSeq;.class
        //   211: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   214: checkcast       Lgnu/lists/CharSeq;
        //   217: invokestatic    kawa/lib/strings.stringCapitalize$Ex:(Lgnu/lists/CharSeq;)Ljava/lang/CharSequence;
        //   220: areturn        
        //   221: aload_2        
        //   222: ldc             Ljava/lang/CharSequence;.class
        //   224: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   227: checkcast       Ljava/lang/CharSequence;
        //   230: invokestatic    kawa/lib/strings.stringCapitalize:(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //   233: areturn        
        //   234: aload_0        
        //   235: aload_1        
        //   236: aload_2        
        //   237: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   240: areturn        
        //   241: new             Lgnu/mapping/WrongType;
        //   244: dup_x1         
        //   245: swap           
        //   246: ldc_w           "make-string"
        //   249: iconst_1       
        //   250: aload_2        
        //   251: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   254: athrow         
        //   255: new             Lgnu/mapping/WrongType;
        //   258: dup_x1         
        //   259: swap           
        //   260: ldc_w           "string-length"
        //   263: iconst_1       
        //   264: aload_2        
        //   265: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   268: athrow         
        //   269: new             Lgnu/mapping/WrongType;
        //   272: dup_x1         
        //   273: swap           
        //   274: ldc_w           "string->list"
        //   277: iconst_1       
        //   278: aload_2        
        //   279: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   282: athrow         
        //   283: new             Lgnu/mapping/WrongType;
        //   286: dup_x1         
        //   287: swap           
        //   288: ldc_w           "list->string"
        //   291: iconst_1       
        //   292: aload_2        
        //   293: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   296: athrow         
        //   297: new             Lgnu/mapping/WrongType;
        //   300: dup_x1         
        //   301: swap           
        //   302: ldc_w           "string-copy"
        //   305: iconst_1       
        //   306: aload_2        
        //   307: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   310: athrow         
        //   311: new             Lgnu/mapping/WrongType;
        //   314: dup_x1         
        //   315: swap           
        //   316: ldc_w           "string-upcase!"
        //   319: iconst_1       
        //   320: aload_2        
        //   321: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   324: athrow         
        //   325: new             Lgnu/mapping/WrongType;
        //   328: dup_x1         
        //   329: swap           
        //   330: ldc_w           "string-downcase!"
        //   333: iconst_1       
        //   334: aload_2        
        //   335: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   338: athrow         
        //   339: new             Lgnu/mapping/WrongType;
        //   342: dup_x1         
        //   343: swap           
        //   344: ldc_w           "string-capitalize!"
        //   347: iconst_1       
        //   348: aload_2        
        //   349: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   352: athrow         
        //   353: new             Lgnu/mapping/WrongType;
        //   356: dup_x1         
        //   357: swap           
        //   358: ldc_w           "string-capitalize"
        //   361: iconst_1       
        //   362: aload_2        
        //   363: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   366: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  117    123    241    255    Ljava/lang/ClassCastException;
        //  133    136    255    269    Ljava/lang/ClassCastException;
        //  149    152    269    283    Ljava/lang/ClassCastException;
        //  162    165    283    297    Ljava/lang/ClassCastException;
        //  175    178    297    311    Ljava/lang/ClassCastException;
        //  188    191    311    325    Ljava/lang/ClassCastException;
        //  201    204    325    339    Ljava/lang/ClassCastException;
        //  214    217    339    353    Ljava/lang/ClassCastException;
        //  227    230    353    367    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 142 out of bounds for length 142
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
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                2: 64
        //                6: 85
        //               14: 111
        //               18: 134
        //               27: 157
        //               50: 180
        //          default: 197
        //        }
        //    64: aload_2        
        //    65: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    68: checkcast       Ljava/lang/Number;
        //    71: invokevirtual   java/lang/Number.intValue:()I
        //    74: aload_3        
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    78: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    81: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
        //    84: areturn        
        //    85: aload_2        
        //    86: ldc             Ljava/lang/CharSequence;.class
        //    88: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    91: checkcast       Ljava/lang/CharSequence;
        //    94: aload_3        
        //    95: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    98: checkcast       Ljava/lang/Number;
        //   101: invokevirtual   java/lang/Number.intValue:()I
        //   104: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   107: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   110: areturn        
        //   111: aload_2        
        //   112: ldc             Ljava/lang/CharSequence;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: checkcast       Ljava/lang/CharSequence;
        //   120: aload_3        
        //   121: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   124: checkcast       Ljava/lang/Number;
        //   127: invokevirtual   java/lang/Number.intValue:()I
        //   130: invokestatic    kawa/lib/strings.string$To$List:(Ljava/lang/CharSequence;I)Lgnu/lists/LList;
        //   133: areturn        
        //   134: aload_2        
        //   135: ldc             Ljava/lang/CharSequence;.class
        //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   140: checkcast       Ljava/lang/CharSequence;
        //   143: aload_3        
        //   144: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   147: checkcast       Ljava/lang/Number;
        //   150: invokevirtual   java/lang/Number.intValue:()I
        //   153: invokestatic    kawa/lib/strings.stringCopy:(Ljava/lang/CharSequence;I)Lgnu/lists/FString;
        //   156: areturn        
        //   157: aload_2        
        //   158: ldc             Lgnu/lists/CharSeq;.class
        //   160: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   163: checkcast       Lgnu/lists/CharSeq;
        //   166: aload_3        
        //   167: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   170: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   173: invokestatic    kawa/lib/strings.stringFill$Ex:(Lgnu/lists/CharSeq;I)V
        //   176: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   179: areturn        
        //   180: aload_2        
        //   181: aload_3        
        //   182: ldc             Ljava/lang/CharSequence;.class
        //   184: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   187: checkcast       Ljava/lang/CharSequence;
        //   190: invokestatic    kawa/lib/strings.srfi$Mn13StringForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;)V
        //   193: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   196: areturn        
        //   197: aload_0        
        //   198: aload_1        
        //   199: aload_2        
        //   200: aload_3        
        //   201: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   204: areturn        
        //   205: new             Lgnu/mapping/WrongType;
        //   208: dup_x1         
        //   209: swap           
        //   210: ldc_w           "make-string"
        //   213: iconst_1       
        //   214: aload_2        
        //   215: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   218: athrow         
        //   219: new             Lgnu/mapping/WrongType;
        //   222: dup_x1         
        //   223: swap           
        //   224: ldc_w           "make-string"
        //   227: iconst_2       
        //   228: aload_3        
        //   229: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   232: athrow         
        //   233: new             Lgnu/mapping/WrongType;
        //   236: dup_x1         
        //   237: swap           
        //   238: ldc_w           "string-ref"
        //   241: iconst_1       
        //   242: aload_2        
        //   243: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   246: athrow         
        //   247: new             Lgnu/mapping/WrongType;
        //   250: dup_x1         
        //   251: swap           
        //   252: ldc_w           "string-ref"
        //   255: iconst_2       
        //   256: aload_3        
        //   257: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   260: athrow         
        //   261: new             Lgnu/mapping/WrongType;
        //   264: dup_x1         
        //   265: swap           
        //   266: ldc_w           "string->list"
        //   269: iconst_1       
        //   270: aload_2        
        //   271: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   274: athrow         
        //   275: new             Lgnu/mapping/WrongType;
        //   278: dup_x1         
        //   279: swap           
        //   280: ldc_w           "string->list"
        //   283: iconst_2       
        //   284: aload_3        
        //   285: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   288: athrow         
        //   289: new             Lgnu/mapping/WrongType;
        //   292: dup_x1         
        //   293: swap           
        //   294: ldc_w           "string-copy"
        //   297: iconst_1       
        //   298: aload_2        
        //   299: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   302: athrow         
        //   303: new             Lgnu/mapping/WrongType;
        //   306: dup_x1         
        //   307: swap           
        //   308: ldc_w           "string-copy"
        //   311: iconst_2       
        //   312: aload_3        
        //   313: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   316: athrow         
        //   317: new             Lgnu/mapping/WrongType;
        //   320: dup_x1         
        //   321: swap           
        //   322: ldc_w           "string-fill!"
        //   325: iconst_1       
        //   326: aload_2        
        //   327: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   330: athrow         
        //   331: new             Lgnu/mapping/WrongType;
        //   334: dup_x1         
        //   335: swap           
        //   336: ldc_w           "string-fill!"
        //   339: iconst_2       
        //   340: aload_3        
        //   341: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   344: athrow         
        //   345: new             Lgnu/mapping/WrongType;
        //   348: dup_x1         
        //   349: swap           
        //   350: ldc             "srfi-13-string-for-each"
        //   352: iconst_2       
        //   353: aload_3        
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  68     74     205    219    Ljava/lang/ClassCastException;
        //  78     81     219    233    Ljava/lang/ClassCastException;
        //  91     94     233    247    Ljava/lang/ClassCastException;
        //  98     104    247    261    Ljava/lang/ClassCastException;
        //  117    120    261    275    Ljava/lang/ClassCastException;
        //  124    130    275    289    Ljava/lang/ClassCastException;
        //  140    143    289    303    Ljava/lang/ClassCastException;
        //  147    153    303    317    Ljava/lang/ClassCastException;
        //  163    166    317    331    Ljava/lang/ClassCastException;
        //  170    173    331    345    Ljava/lang/ClassCastException;
        //  187    190    345    358    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 155 out of bounds for length 155
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
    
    @Override
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                7: 72
        //               13: 106
        //               14: 140
        //               18: 174
        //               21: 208
        //               27: 244
        //               50: 278
        //          default: 306
        //        }
        //    72: aload_2        
        //    73: ldc             Lgnu/lists/CharSeq;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: checkcast       Lgnu/lists/CharSeq;
        //    81: aload_3        
        //    82: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    85: checkcast       Ljava/lang/Number;
        //    88: invokevirtual   java/lang/Number.intValue:()I
        //    91: aload           4
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    96: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    99: invokestatic    kawa/lib/strings.stringSet$Ex:(Lgnu/lists/CharSeq;II)V
        //   102: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   105: areturn        
        //   106: aload_2        
        //   107: ldc             Ljava/lang/CharSequence;.class
        //   109: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   112: checkcast       Ljava/lang/CharSequence;
        //   115: aload_3        
        //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   119: checkcast       Ljava/lang/Number;
        //   122: invokevirtual   java/lang/Number.intValue:()I
        //   125: aload           4
        //   127: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   130: checkcast       Ljava/lang/Number;
        //   133: invokevirtual   java/lang/Number.intValue:()I
        //   136: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   139: areturn        
        //   140: aload_2        
        //   141: ldc             Ljava/lang/CharSequence;.class
        //   143: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   146: checkcast       Ljava/lang/CharSequence;
        //   149: aload_3        
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   153: checkcast       Ljava/lang/Number;
        //   156: invokevirtual   java/lang/Number.intValue:()I
        //   159: aload           4
        //   161: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   164: checkcast       Ljava/lang/Number;
        //   167: invokevirtual   java/lang/Number.intValue:()I
        //   170: invokestatic    kawa/lib/strings.string$To$List:(Ljava/lang/CharSequence;II)Lgnu/lists/LList;
        //   173: areturn        
        //   174: aload_2        
        //   175: ldc             Ljava/lang/CharSequence;.class
        //   177: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   180: checkcast       Ljava/lang/CharSequence;
        //   183: aload_3        
        //   184: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   187: checkcast       Ljava/lang/Number;
        //   190: invokevirtual   java/lang/Number.intValue:()I
        //   193: aload           4
        //   195: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   198: checkcast       Ljava/lang/Number;
        //   201: invokevirtual   java/lang/Number.intValue:()I
        //   204: invokestatic    kawa/lib/strings.stringCopy:(Ljava/lang/CharSequence;II)Lgnu/lists/FString;
        //   207: areturn        
        //   208: aload_2        
        //   209: ldc             Lgnu/lists/FString;.class
        //   211: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   214: checkcast       Lgnu/lists/FString;
        //   217: aload_3        
        //   218: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   221: checkcast       Ljava/lang/Number;
        //   224: invokevirtual   java/lang/Number.intValue:()I
        //   227: aload           4
        //   229: ldc             Ljava/lang/CharSequence;.class
        //   231: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   234: checkcast       Ljava/lang/CharSequence;
        //   237: invokestatic    kawa/lib/strings.stringCopy$Ex:(Lgnu/lists/FString;ILjava/lang/CharSequence;)V
        //   240: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   243: areturn        
        //   244: aload_2        
        //   245: ldc             Lgnu/lists/CharSeq;.class
        //   247: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   250: checkcast       Lgnu/lists/CharSeq;
        //   253: aload_3        
        //   254: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   257: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   260: aload           4
        //   262: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   265: checkcast       Ljava/lang/Number;
        //   268: invokevirtual   java/lang/Number.intValue:()I
        //   271: invokestatic    kawa/lib/strings.stringFill$Ex:(Lgnu/lists/CharSeq;II)V
        //   274: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   277: areturn        
        //   278: aload_2        
        //   279: aload_3        
        //   280: ldc             Ljava/lang/CharSequence;.class
        //   282: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   285: checkcast       Ljava/lang/CharSequence;
        //   288: aload           4
        //   290: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   293: checkcast       Ljava/lang/Number;
        //   296: invokevirtual   java/lang/Number.intValue:()I
        //   299: invokestatic    kawa/lib/strings.srfi$Mn13StringForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;I)V
        //   302: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   305: areturn        
        //   306: aload_0        
        //   307: aload_1        
        //   308: aload_2        
        //   309: aload_3        
        //   310: aload           4
        //   312: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   315: areturn        
        //   316: new             Lgnu/mapping/WrongType;
        //   319: dup_x1         
        //   320: swap           
        //   321: ldc             "string-set!"
        //   323: iconst_1       
        //   324: aload_2        
        //   325: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   328: athrow         
        //   329: new             Lgnu/mapping/WrongType;
        //   332: dup_x1         
        //   333: swap           
        //   334: ldc             "string-set!"
        //   336: iconst_2       
        //   337: aload_3        
        //   338: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   341: athrow         
        //   342: new             Lgnu/mapping/WrongType;
        //   345: dup_x1         
        //   346: swap           
        //   347: ldc             "string-set!"
        //   349: iconst_3       
        //   350: aload           4
        //   352: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   355: athrow         
        //   356: new             Lgnu/mapping/WrongType;
        //   359: dup_x1         
        //   360: swap           
        //   361: ldc_w           "substring"
        //   364: iconst_1       
        //   365: aload_2        
        //   366: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   369: athrow         
        //   370: new             Lgnu/mapping/WrongType;
        //   373: dup_x1         
        //   374: swap           
        //   375: ldc_w           "substring"
        //   378: iconst_2       
        //   379: aload_3        
        //   380: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   383: athrow         
        //   384: new             Lgnu/mapping/WrongType;
        //   387: dup_x1         
        //   388: swap           
        //   389: ldc_w           "substring"
        //   392: iconst_3       
        //   393: aload           4
        //   395: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   398: athrow         
        //   399: new             Lgnu/mapping/WrongType;
        //   402: dup_x1         
        //   403: swap           
        //   404: ldc_w           "string->list"
        //   407: iconst_1       
        //   408: aload_2        
        //   409: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   412: athrow         
        //   413: new             Lgnu/mapping/WrongType;
        //   416: dup_x1         
        //   417: swap           
        //   418: ldc_w           "string->list"
        //   421: iconst_2       
        //   422: aload_3        
        //   423: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   426: athrow         
        //   427: new             Lgnu/mapping/WrongType;
        //   430: dup_x1         
        //   431: swap           
        //   432: ldc_w           "string->list"
        //   435: iconst_3       
        //   436: aload           4
        //   438: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   441: athrow         
        //   442: new             Lgnu/mapping/WrongType;
        //   445: dup_x1         
        //   446: swap           
        //   447: ldc_w           "string-copy"
        //   450: iconst_1       
        //   451: aload_2        
        //   452: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   455: athrow         
        //   456: new             Lgnu/mapping/WrongType;
        //   459: dup_x1         
        //   460: swap           
        //   461: ldc_w           "string-copy"
        //   464: iconst_2       
        //   465: aload_3        
        //   466: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   469: athrow         
        //   470: new             Lgnu/mapping/WrongType;
        //   473: dup_x1         
        //   474: swap           
        //   475: ldc_w           "string-copy"
        //   478: iconst_3       
        //   479: aload           4
        //   481: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   484: athrow         
        //   485: new             Lgnu/mapping/WrongType;
        //   488: dup_x1         
        //   489: swap           
        //   490: ldc_w           "string-copy!"
        //   493: iconst_1       
        //   494: aload_2        
        //   495: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   498: athrow         
        //   499: new             Lgnu/mapping/WrongType;
        //   502: dup_x1         
        //   503: swap           
        //   504: ldc_w           "string-copy!"
        //   507: iconst_2       
        //   508: aload_3        
        //   509: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   512: athrow         
        //   513: new             Lgnu/mapping/WrongType;
        //   516: dup_x1         
        //   517: swap           
        //   518: ldc_w           "string-copy!"
        //   521: iconst_3       
        //   522: aload           4
        //   524: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   527: athrow         
        //   528: new             Lgnu/mapping/WrongType;
        //   531: dup_x1         
        //   532: swap           
        //   533: ldc_w           "string-fill!"
        //   536: iconst_1       
        //   537: aload_2        
        //   538: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   541: athrow         
        //   542: new             Lgnu/mapping/WrongType;
        //   545: dup_x1         
        //   546: swap           
        //   547: ldc_w           "string-fill!"
        //   550: iconst_2       
        //   551: aload_3        
        //   552: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   555: athrow         
        //   556: new             Lgnu/mapping/WrongType;
        //   559: dup_x1         
        //   560: swap           
        //   561: ldc_w           "string-fill!"
        //   564: iconst_3       
        //   565: aload           4
        //   567: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   570: athrow         
        //   571: new             Lgnu/mapping/WrongType;
        //   574: dup_x1         
        //   575: swap           
        //   576: ldc             "srfi-13-string-for-each"
        //   578: iconst_2       
        //   579: aload_3        
        //   580: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   583: athrow         
        //   584: new             Lgnu/mapping/WrongType;
        //   587: dup_x1         
        //   588: swap           
        //   589: ldc             "srfi-13-string-for-each"
        //   591: iconst_3       
        //   592: aload           4
        //   594: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   597: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  78     81     316    329    Ljava/lang/ClassCastException;
        //  85     91     329    342    Ljava/lang/ClassCastException;
        //  96     99     342    356    Ljava/lang/ClassCastException;
        //  112    115    356    370    Ljava/lang/ClassCastException;
        //  119    125    370    384    Ljava/lang/ClassCastException;
        //  130    136    384    399    Ljava/lang/ClassCastException;
        //  146    149    399    413    Ljava/lang/ClassCastException;
        //  153    159    413    427    Ljava/lang/ClassCastException;
        //  164    170    427    442    Ljava/lang/ClassCastException;
        //  180    183    442    456    Ljava/lang/ClassCastException;
        //  187    193    456    470    Ljava/lang/ClassCastException;
        //  198    204    470    485    Ljava/lang/ClassCastException;
        //  214    217    485    499    Ljava/lang/ClassCastException;
        //  221    227    499    513    Ljava/lang/ClassCastException;
        //  234    237    513    528    Ljava/lang/ClassCastException;
        //  250    253    528    542    Ljava/lang/ClassCastException;
        //  257    260    542    556    Ljava/lang/ClassCastException;
        //  265    271    556    571    Ljava/lang/ClassCastException;
        //  285    288    571    584    Ljava/lang/ClassCastException;
        //  293    299    584    598    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 267 out of bounds for length 267
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
    
    @Override
    public Object apply4(final ModuleMethod p0, final Object p1, final Object p2, final Object p3, final Object p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               21: 48
        //               24: 95
        //               27: 142
        //               50: 187
        //          default: 226
        //        }
        //    48: aload_2        
        //    49: ldc             Lgnu/lists/FString;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: checkcast       Lgnu/lists/FString;
        //    57: aload_3        
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    61: checkcast       Ljava/lang/Number;
        //    64: invokevirtual   java/lang/Number.intValue:()I
        //    67: aload           4
        //    69: ldc             Ljava/lang/CharSequence;.class
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    74: checkcast       Ljava/lang/CharSequence;
        //    77: aload           5
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    82: checkcast       Ljava/lang/Number;
        //    85: invokevirtual   java/lang/Number.intValue:()I
        //    88: invokestatic    kawa/lib/strings.stringCopy$Ex:(Lgnu/lists/FString;ILjava/lang/CharSequence;I)V
        //    91: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    94: areturn        
        //    95: aload_2        
        //    96: ldc             Lgnu/lists/FString;.class
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   101: checkcast       Lgnu/lists/FString;
        //   104: aload_3        
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   108: checkcast       Ljava/lang/Number;
        //   111: invokevirtual   java/lang/Number.intValue:()I
        //   114: aload           4
        //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   119: checkcast       Ljava/lang/Number;
        //   122: invokevirtual   java/lang/Number.intValue:()I
        //   125: aload           5
        //   127: ldc             Ljava/lang/CharSequence;.class
        //   129: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   132: checkcast       Ljava/lang/CharSequence;
        //   135: invokestatic    kawa/lib/strings.stringReplace$Ex:(Lgnu/lists/FString;IILjava/lang/CharSequence;)V
        //   138: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   141: areturn        
        //   142: aload_2        
        //   143: ldc             Lgnu/lists/CharSeq;.class
        //   145: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   148: checkcast       Lgnu/lists/CharSeq;
        //   151: aload_3        
        //   152: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   155: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   158: aload           4
        //   160: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   163: checkcast       Ljava/lang/Number;
        //   166: invokevirtual   java/lang/Number.intValue:()I
        //   169: aload           5
        //   171: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   174: checkcast       Ljava/lang/Number;
        //   177: invokevirtual   java/lang/Number.intValue:()I
        //   180: invokestatic    kawa/lib/strings.stringFill$Ex:(Lgnu/lists/CharSeq;III)V
        //   183: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   186: areturn        
        //   187: aload_2        
        //   188: aload_3        
        //   189: ldc             Ljava/lang/CharSequence;.class
        //   191: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   194: checkcast       Ljava/lang/CharSequence;
        //   197: aload           4
        //   199: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   202: checkcast       Ljava/lang/Number;
        //   205: invokevirtual   java/lang/Number.intValue:()I
        //   208: aload           5
        //   210: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   213: checkcast       Ljava/lang/Number;
        //   216: invokevirtual   java/lang/Number.intValue:()I
        //   219: invokestatic    kawa/lib/strings.srfi$Mn13StringForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;II)V
        //   222: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   225: areturn        
        //   226: aload_0        
        //   227: aload_1        
        //   228: aload_2        
        //   229: aload_3        
        //   230: aload           4
        //   232: aload           5
        //   234: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   237: areturn        
        //   238: new             Lgnu/mapping/WrongType;
        //   241: dup_x1         
        //   242: swap           
        //   243: ldc_w           "string-copy!"
        //   246: iconst_1       
        //   247: aload_2        
        //   248: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   251: athrow         
        //   252: new             Lgnu/mapping/WrongType;
        //   255: dup_x1         
        //   256: swap           
        //   257: ldc_w           "string-copy!"
        //   260: iconst_2       
        //   261: aload_3        
        //   262: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   265: athrow         
        //   266: new             Lgnu/mapping/WrongType;
        //   269: dup_x1         
        //   270: swap           
        //   271: ldc_w           "string-copy!"
        //   274: iconst_3       
        //   275: aload           4
        //   277: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   280: athrow         
        //   281: new             Lgnu/mapping/WrongType;
        //   284: dup_x1         
        //   285: swap           
        //   286: ldc_w           "string-copy!"
        //   289: iconst_4       
        //   290: aload           5
        //   292: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   295: athrow         
        //   296: new             Lgnu/mapping/WrongType;
        //   299: dup_x1         
        //   300: swap           
        //   301: ldc_w           "string-replace!"
        //   304: iconst_1       
        //   305: aload_2        
        //   306: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   309: athrow         
        //   310: new             Lgnu/mapping/WrongType;
        //   313: dup_x1         
        //   314: swap           
        //   315: ldc_w           "string-replace!"
        //   318: iconst_2       
        //   319: aload_3        
        //   320: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   323: athrow         
        //   324: new             Lgnu/mapping/WrongType;
        //   327: dup_x1         
        //   328: swap           
        //   329: ldc_w           "string-replace!"
        //   332: iconst_3       
        //   333: aload           4
        //   335: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   338: athrow         
        //   339: new             Lgnu/mapping/WrongType;
        //   342: dup_x1         
        //   343: swap           
        //   344: ldc_w           "string-replace!"
        //   347: iconst_4       
        //   348: aload           5
        //   350: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   353: athrow         
        //   354: new             Lgnu/mapping/WrongType;
        //   357: dup_x1         
        //   358: swap           
        //   359: ldc_w           "string-fill!"
        //   362: iconst_1       
        //   363: aload_2        
        //   364: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   367: athrow         
        //   368: new             Lgnu/mapping/WrongType;
        //   371: dup_x1         
        //   372: swap           
        //   373: ldc_w           "string-fill!"
        //   376: iconst_2       
        //   377: aload_3        
        //   378: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   381: athrow         
        //   382: new             Lgnu/mapping/WrongType;
        //   385: dup_x1         
        //   386: swap           
        //   387: ldc_w           "string-fill!"
        //   390: iconst_3       
        //   391: aload           4
        //   393: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   396: athrow         
        //   397: new             Lgnu/mapping/WrongType;
        //   400: dup_x1         
        //   401: swap           
        //   402: ldc_w           "string-fill!"
        //   405: iconst_4       
        //   406: aload           5
        //   408: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   411: athrow         
        //   412: new             Lgnu/mapping/WrongType;
        //   415: dup_x1         
        //   416: swap           
        //   417: ldc             "srfi-13-string-for-each"
        //   419: iconst_2       
        //   420: aload_3        
        //   421: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   424: athrow         
        //   425: new             Lgnu/mapping/WrongType;
        //   428: dup_x1         
        //   429: swap           
        //   430: ldc             "srfi-13-string-for-each"
        //   432: iconst_3       
        //   433: aload           4
        //   435: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   438: athrow         
        //   439: new             Lgnu/mapping/WrongType;
        //   442: dup_x1         
        //   443: swap           
        //   444: ldc             "srfi-13-string-for-each"
        //   446: iconst_4       
        //   447: aload           5
        //   449: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   452: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  54     57     238    252    Ljava/lang/ClassCastException;
        //  61     67     252    266    Ljava/lang/ClassCastException;
        //  74     77     266    281    Ljava/lang/ClassCastException;
        //  82     88     281    296    Ljava/lang/ClassCastException;
        //  101    104    296    310    Ljava/lang/ClassCastException;
        //  108    114    310    324    Ljava/lang/ClassCastException;
        //  119    125    324    339    Ljava/lang/ClassCastException;
        //  132    135    339    354    Ljava/lang/ClassCastException;
        //  148    151    354    368    Ljava/lang/ClassCastException;
        //  155    158    368    382    Ljava/lang/ClassCastException;
        //  163    169    382    397    Ljava/lang/ClassCastException;
        //  174    180    397    412    Ljava/lang/ClassCastException;
        //  194    197    412    425    Ljava/lang/ClassCastException;
        //  202    208    425    439    Ljava/lang/ClassCastException;
        //  213    219    439    453    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 203 out of bounds for length 203
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
    
    @Override
    public Object applyN(final ModuleMethod p0, final Object[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                8: 228
        //                9: 2201
        //               10: 2201
        //               11: 2201
        //               12: 233
        //               13: 308
        //               14: 383
        //               15: 458
        //               16: 533
        //               17: 2201
        //               18: 2201
        //               19: 2201
        //               20: 2201
        //               21: 2201
        //               22: 2201
        //               23: 2201
        //               24: 2201
        //               25: 608
        //               26: 2201
        //               27: 2201
        //               28: 719
        //               29: 2201
        //               30: 2201
        //               31: 2201
        //               32: 2201
        //               33: 2201
        //               34: 2201
        //               35: 2201
        //               36: 2201
        //               37: 2201
        //               38: 848
        //               39: 853
        //               40: 935
        //               41: 1017
        //               42: 1099
        //               43: 1181
        //               44: 1263
        //               45: 1340
        //               46: 1417
        //               47: 1494
        //               48: 1571
        //               49: 1648
        //               50: 1725
        //               51: 1802
        //               52: 1879
        //               53: 1956
        //               54: 2201
        //               55: 2201
        //               56: 2201
        //               57: 2033
        //               58: 2089
        //               59: 2148
        //          default: 2201
        //        }
        //   228: aload_2        
        //   229: invokestatic    kawa/lib/strings.$make$string$:([Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   232: areturn        
        //   233: aload_2        
        //   234: iconst_0       
        //   235: aaload         
        //   236: ldc             Ljava/lang/CharSequence;.class
        //   238: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   241: dup            
        //   242: astore_3       
        //   243: checkcast       Ljava/lang/CharSequence;
        //   246: aload_2        
        //   247: iconst_1       
        //   248: aaload         
        //   249: ldc             Ljava/lang/CharSequence;.class
        //   251: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   254: dup            
        //   255: astore_3       
        //   256: checkcast       Ljava/lang/CharSequence;
        //   259: aload_2        
        //   260: arraylength    
        //   261: iconst_2       
        //   262: isub           
        //   263: istore_3       
        //   264: iload_3        
        //   265: anewarray       Ljava/lang/CharSequence;
        //   268: goto            285
        //   271: dup            
        //   272: iload_3        
        //   273: aload_2        
        //   274: iload_3        
        //   275: iconst_2       
        //   276: iadd           
        //   277: aaload         
        //   278: dup            
        //   279: astore          4
        //   281: checkcast       Ljava/lang/CharSequence;
        //   284: aastore        
        //   285: iinc            3, -1
        //   288: iload_3        
        //   289: ifge            271
        //   292: invokestatic    kawa/lib/strings.isString$Ls:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //   295: ifeq            304
        //   298: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   301: goto            307
        //   304: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   307: areturn        
        //   308: aload_2        
        //   309: iconst_0       
        //   310: aaload         
        //   311: ldc             Ljava/lang/CharSequence;.class
        //   313: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   316: dup            
        //   317: astore_3       
        //   318: checkcast       Ljava/lang/CharSequence;
        //   321: aload_2        
        //   322: iconst_1       
        //   323: aaload         
        //   324: ldc             Ljava/lang/CharSequence;.class
        //   326: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   329: dup            
        //   330: astore_3       
        //   331: checkcast       Ljava/lang/CharSequence;
        //   334: aload_2        
        //   335: arraylength    
        //   336: iconst_2       
        //   337: isub           
        //   338: istore_3       
        //   339: iload_3        
        //   340: anewarray       Ljava/lang/CharSequence;
        //   343: goto            360
        //   346: dup            
        //   347: iload_3        
        //   348: aload_2        
        //   349: iload_3        
        //   350: iconst_2       
        //   351: iadd           
        //   352: aaload         
        //   353: dup            
        //   354: astore          4
        //   356: checkcast       Ljava/lang/CharSequence;
        //   359: aastore        
        //   360: iinc            3, -1
        //   363: iload_3        
        //   364: ifge            346
        //   367: invokestatic    kawa/lib/strings.isString$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //   370: ifeq            379
        //   373: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   376: goto            382
        //   379: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   382: areturn        
        //   383: aload_2        
        //   384: iconst_0       
        //   385: aaload         
        //   386: ldc             Ljava/lang/CharSequence;.class
        //   388: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   391: dup            
        //   392: astore_3       
        //   393: checkcast       Ljava/lang/CharSequence;
        //   396: aload_2        
        //   397: iconst_1       
        //   398: aaload         
        //   399: ldc             Ljava/lang/CharSequence;.class
        //   401: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   404: dup            
        //   405: astore_3       
        //   406: checkcast       Ljava/lang/CharSequence;
        //   409: aload_2        
        //   410: arraylength    
        //   411: iconst_2       
        //   412: isub           
        //   413: istore_3       
        //   414: iload_3        
        //   415: anewarray       Ljava/lang/CharSequence;
        //   418: goto            435
        //   421: dup            
        //   422: iload_3        
        //   423: aload_2        
        //   424: iload_3        
        //   425: iconst_2       
        //   426: iadd           
        //   427: aaload         
        //   428: dup            
        //   429: astore          4
        //   431: checkcast       Ljava/lang/CharSequence;
        //   434: aastore        
        //   435: iinc            3, -1
        //   438: iload_3        
        //   439: ifge            421
        //   442: invokestatic    kawa/lib/strings.isString$Gr:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //   445: ifeq            454
        //   448: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   451: goto            457
        //   454: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   457: areturn        
        //   458: aload_2        
        //   459: iconst_0       
        //   460: aaload         
        //   461: ldc             Ljava/lang/CharSequence;.class
        //   463: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   466: dup            
        //   467: astore_3       
        //   468: checkcast       Ljava/lang/CharSequence;
        //   471: aload_2        
        //   472: iconst_1       
        //   473: aaload         
        //   474: ldc             Ljava/lang/CharSequence;.class
        //   476: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   479: dup            
        //   480: astore_3       
        //   481: checkcast       Ljava/lang/CharSequence;
        //   484: aload_2        
        //   485: arraylength    
        //   486: iconst_2       
        //   487: isub           
        //   488: istore_3       
        //   489: iload_3        
        //   490: anewarray       Ljava/lang/CharSequence;
        //   493: goto            510
        //   496: dup            
        //   497: iload_3        
        //   498: aload_2        
        //   499: iload_3        
        //   500: iconst_2       
        //   501: iadd           
        //   502: aaload         
        //   503: dup            
        //   504: astore          4
        //   506: checkcast       Ljava/lang/CharSequence;
        //   509: aastore        
        //   510: iinc            3, -1
        //   513: iload_3        
        //   514: ifge            496
        //   517: invokestatic    kawa/lib/strings.isString$Ls$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //   520: ifeq            529
        //   523: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   526: goto            532
        //   529: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   532: areturn        
        //   533: aload_2        
        //   534: iconst_0       
        //   535: aaload         
        //   536: ldc             Ljava/lang/CharSequence;.class
        //   538: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   541: dup            
        //   542: astore_3       
        //   543: checkcast       Ljava/lang/CharSequence;
        //   546: aload_2        
        //   547: iconst_1       
        //   548: aaload         
        //   549: ldc             Ljava/lang/CharSequence;.class
        //   551: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   554: dup            
        //   555: astore_3       
        //   556: checkcast       Ljava/lang/CharSequence;
        //   559: aload_2        
        //   560: arraylength    
        //   561: iconst_2       
        //   562: isub           
        //   563: istore_3       
        //   564: iload_3        
        //   565: anewarray       Ljava/lang/CharSequence;
        //   568: goto            585
        //   571: dup            
        //   572: iload_3        
        //   573: aload_2        
        //   574: iload_3        
        //   575: iconst_2       
        //   576: iadd           
        //   577: aaload         
        //   578: dup            
        //   579: astore          4
        //   581: checkcast       Ljava/lang/CharSequence;
        //   584: aastore        
        //   585: iinc            3, -1
        //   588: iload_3        
        //   589: ifge            571
        //   592: invokestatic    kawa/lib/strings.isString$Gr$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //   595: ifeq            604
        //   598: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   601: goto            607
        //   604: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   607: areturn        
        //   608: aload_2        
        //   609: arraylength    
        //   610: iconst_3       
        //   611: isub           
        //   612: istore_3       
        //   613: aload_2        
        //   614: iconst_0       
        //   615: aaload         
        //   616: ldc             Lgnu/lists/FString;.class
        //   618: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   621: dup            
        //   622: astore          4
        //   624: checkcast       Lgnu/lists/FString;
        //   627: aload_2        
        //   628: iconst_1       
        //   629: aaload         
        //   630: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   633: dup            
        //   634: astore          4
        //   636: checkcast       Ljava/lang/Number;
        //   639: invokevirtual   java/lang/Number.intValue:()I
        //   642: aload_2        
        //   643: iconst_2       
        //   644: aaload         
        //   645: ldc             Ljava/lang/CharSequence;.class
        //   647: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   650: dup            
        //   651: astore          4
        //   653: checkcast       Ljava/lang/CharSequence;
        //   656: iload_3        
        //   657: ifgt            666
        //   660: invokestatic    kawa/lib/strings.stringCopy$Ex:(Lgnu/lists/FString;ILjava/lang/CharSequence;)V
        //   663: goto            715
        //   666: iinc            3, -1
        //   669: aload_2        
        //   670: iconst_3       
        //   671: aaload         
        //   672: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   675: dup            
        //   676: astore          4
        //   678: checkcast       Ljava/lang/Number;
        //   681: invokevirtual   java/lang/Number.intValue:()I
        //   684: iload_3        
        //   685: ifgt            694
        //   688: invokestatic    kawa/lib/strings.stringCopy$Ex:(Lgnu/lists/FString;ILjava/lang/CharSequence;I)V
        //   691: goto            715
        //   694: iinc            3, -1
        //   697: aload_2        
        //   698: iconst_4       
        //   699: aaload         
        //   700: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   703: dup            
        //   704: astore          4
        //   706: checkcast       Ljava/lang/Number;
        //   709: invokevirtual   java/lang/Number.intValue:()I
        //   712: invokestatic    kawa/lib/strings.stringCopy$Ex:(Lgnu/lists/FString;ILjava/lang/CharSequence;II)V
        //   715: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   718: areturn        
        //   719: aload_2        
        //   720: arraylength    
        //   721: iconst_4       
        //   722: isub           
        //   723: istore          4
        //   725: aload_2        
        //   726: iconst_0       
        //   727: aaload         
        //   728: ldc             Lgnu/lists/FString;.class
        //   730: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   733: dup            
        //   734: astore          5
        //   736: checkcast       Lgnu/lists/FString;
        //   739: aload_2        
        //   740: iconst_1       
        //   741: aaload         
        //   742: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   745: dup            
        //   746: astore          5
        //   748: checkcast       Ljava/lang/Number;
        //   751: invokevirtual   java/lang/Number.intValue:()I
        //   754: aload_2        
        //   755: iconst_2       
        //   756: aaload         
        //   757: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   760: dup            
        //   761: astore          5
        //   763: checkcast       Ljava/lang/Number;
        //   766: invokevirtual   java/lang/Number.intValue:()I
        //   769: aload_2        
        //   770: iconst_3       
        //   771: aaload         
        //   772: ldc             Ljava/lang/CharSequence;.class
        //   774: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   777: dup            
        //   778: astore          5
        //   780: checkcast       Ljava/lang/CharSequence;
        //   783: iload           4
        //   785: ifgt            794
        //   788: invokestatic    kawa/lib/strings.stringReplace$Ex:(Lgnu/lists/FString;IILjava/lang/CharSequence;)V
        //   791: goto            844
        //   794: iinc            4, -1
        //   797: aload_2        
        //   798: iconst_4       
        //   799: aaload         
        //   800: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   803: dup            
        //   804: astore          5
        //   806: checkcast       Ljava/lang/Number;
        //   809: invokevirtual   java/lang/Number.intValue:()I
        //   812: iload           4
        //   814: ifgt            823
        //   817: invokestatic    kawa/lib/strings.stringReplace$Ex:(Lgnu/lists/FString;IILjava/lang/CharSequence;I)V
        //   820: goto            844
        //   823: iinc            4, -1
        //   826: aload_2        
        //   827: iconst_5       
        //   828: aaload         
        //   829: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   832: dup            
        //   833: astore          5
        //   835: checkcast       Ljava/lang/Number;
        //   838: invokevirtual   java/lang/Number.intValue:()I
        //   841: invokestatic    kawa/lib/strings.stringReplace$Ex:(Lgnu/lists/FString;IILjava/lang/CharSequence;II)V
        //   844: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   847: areturn        
        //   848: aload_2        
        //   849: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   852: areturn        
        //   853: aload_2        
        //   854: iconst_0       
        //   855: aaload         
        //   856: ldc             Ljava/lang/CharSequence;.class
        //   858: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   861: dup            
        //   862: astore          5
        //   864: checkcast       Ljava/lang/CharSequence;
        //   867: aload_2        
        //   868: iconst_1       
        //   869: aaload         
        //   870: ldc             Ljava/lang/CharSequence;.class
        //   872: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   875: dup            
        //   876: astore          5
        //   878: checkcast       Ljava/lang/CharSequence;
        //   881: aload_2        
        //   882: arraylength    
        //   883: iconst_2       
        //   884: isub           
        //   885: istore          5
        //   887: iload           5
        //   889: anewarray       Ljava/lang/CharSequence;
        //   892: goto            911
        //   895: dup            
        //   896: iload           5
        //   898: aload_2        
        //   899: iload           5
        //   901: iconst_2       
        //   902: iadd           
        //   903: aaload         
        //   904: dup            
        //   905: astore          6
        //   907: checkcast       Ljava/lang/CharSequence;
        //   910: aastore        
        //   911: iinc            5, -1
        //   914: iload           5
        //   916: ifge            895
        //   919: invokestatic    kawa/lib/strings.isStringCi$Ls:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //   922: ifeq            931
        //   925: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   928: goto            934
        //   931: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   934: areturn        
        //   935: aload_2        
        //   936: iconst_0       
        //   937: aaload         
        //   938: ldc             Ljava/lang/CharSequence;.class
        //   940: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   943: dup            
        //   944: astore          5
        //   946: checkcast       Ljava/lang/CharSequence;
        //   949: aload_2        
        //   950: iconst_1       
        //   951: aaload         
        //   952: ldc             Ljava/lang/CharSequence;.class
        //   954: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   957: dup            
        //   958: astore          5
        //   960: checkcast       Ljava/lang/CharSequence;
        //   963: aload_2        
        //   964: arraylength    
        //   965: iconst_2       
        //   966: isub           
        //   967: istore          5
        //   969: iload           5
        //   971: anewarray       Ljava/lang/CharSequence;
        //   974: goto            993
        //   977: dup            
        //   978: iload           5
        //   980: aload_2        
        //   981: iload           5
        //   983: iconst_2       
        //   984: iadd           
        //   985: aaload         
        //   986: dup            
        //   987: astore          6
        //   989: checkcast       Ljava/lang/CharSequence;
        //   992: aastore        
        //   993: iinc            5, -1
        //   996: iload           5
        //   998: ifge            977
        //  1001: invokestatic    kawa/lib/strings.isStringCi$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //  1004: ifeq            1013
        //  1007: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1010: goto            1016
        //  1013: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1016: areturn        
        //  1017: aload_2        
        //  1018: iconst_0       
        //  1019: aaload         
        //  1020: ldc             Ljava/lang/CharSequence;.class
        //  1022: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1025: dup            
        //  1026: astore          5
        //  1028: checkcast       Ljava/lang/CharSequence;
        //  1031: aload_2        
        //  1032: iconst_1       
        //  1033: aaload         
        //  1034: ldc             Ljava/lang/CharSequence;.class
        //  1036: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1039: dup            
        //  1040: astore          5
        //  1042: checkcast       Ljava/lang/CharSequence;
        //  1045: aload_2        
        //  1046: arraylength    
        //  1047: iconst_2       
        //  1048: isub           
        //  1049: istore          5
        //  1051: iload           5
        //  1053: anewarray       Ljava/lang/CharSequence;
        //  1056: goto            1075
        //  1059: dup            
        //  1060: iload           5
        //  1062: aload_2        
        //  1063: iload           5
        //  1065: iconst_2       
        //  1066: iadd           
        //  1067: aaload         
        //  1068: dup            
        //  1069: astore          6
        //  1071: checkcast       Ljava/lang/CharSequence;
        //  1074: aastore        
        //  1075: iinc            5, -1
        //  1078: iload           5
        //  1080: ifge            1059
        //  1083: invokestatic    kawa/lib/strings.isStringCi$Gr:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //  1086: ifeq            1095
        //  1089: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1092: goto            1098
        //  1095: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1098: areturn        
        //  1099: aload_2        
        //  1100: iconst_0       
        //  1101: aaload         
        //  1102: ldc             Ljava/lang/CharSequence;.class
        //  1104: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1107: dup            
        //  1108: astore          5
        //  1110: checkcast       Ljava/lang/CharSequence;
        //  1113: aload_2        
        //  1114: iconst_1       
        //  1115: aaload         
        //  1116: ldc             Ljava/lang/CharSequence;.class
        //  1118: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1121: dup            
        //  1122: astore          5
        //  1124: checkcast       Ljava/lang/CharSequence;
        //  1127: aload_2        
        //  1128: arraylength    
        //  1129: iconst_2       
        //  1130: isub           
        //  1131: istore          5
        //  1133: iload           5
        //  1135: anewarray       Ljava/lang/CharSequence;
        //  1138: goto            1157
        //  1141: dup            
        //  1142: iload           5
        //  1144: aload_2        
        //  1145: iload           5
        //  1147: iconst_2       
        //  1148: iadd           
        //  1149: aaload         
        //  1150: dup            
        //  1151: astore          6
        //  1153: checkcast       Ljava/lang/CharSequence;
        //  1156: aastore        
        //  1157: iinc            5, -1
        //  1160: iload           5
        //  1162: ifge            1141
        //  1165: invokestatic    kawa/lib/strings.isStringCi$Ls$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //  1168: ifeq            1177
        //  1171: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1174: goto            1180
        //  1177: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1180: areturn        
        //  1181: aload_2        
        //  1182: iconst_0       
        //  1183: aaload         
        //  1184: ldc             Ljava/lang/CharSequence;.class
        //  1186: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1189: dup            
        //  1190: astore          5
        //  1192: checkcast       Ljava/lang/CharSequence;
        //  1195: aload_2        
        //  1196: iconst_1       
        //  1197: aaload         
        //  1198: ldc             Ljava/lang/CharSequence;.class
        //  1200: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1203: dup            
        //  1204: astore          5
        //  1206: checkcast       Ljava/lang/CharSequence;
        //  1209: aload_2        
        //  1210: arraylength    
        //  1211: iconst_2       
        //  1212: isub           
        //  1213: istore          5
        //  1215: iload           5
        //  1217: anewarray       Ljava/lang/CharSequence;
        //  1220: goto            1239
        //  1223: dup            
        //  1224: iload           5
        //  1226: aload_2        
        //  1227: iload           5
        //  1229: iconst_2       
        //  1230: iadd           
        //  1231: aaload         
        //  1232: dup            
        //  1233: astore          6
        //  1235: checkcast       Ljava/lang/CharSequence;
        //  1238: aastore        
        //  1239: iinc            5, -1
        //  1242: iload           5
        //  1244: ifge            1223
        //  1247: invokestatic    kawa/lib/strings.isStringCi$Gr$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //  1250: ifeq            1259
        //  1253: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1256: goto            1262
        //  1259: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1262: areturn        
        //  1263: aload_2        
        //  1264: iconst_0       
        //  1265: aaload         
        //  1266: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1269: dup            
        //  1270: astore          5
        //  1272: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1275: aload_2        
        //  1276: iconst_1       
        //  1277: aaload         
        //  1278: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1281: dup            
        //  1282: astore          5
        //  1284: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1287: aload_2        
        //  1288: arraylength    
        //  1289: iconst_2       
        //  1290: isub           
        //  1291: istore          5
        //  1293: iload           5
        //  1295: newarray        I
        //  1297: goto            1316
        //  1300: dup            
        //  1301: iload           5
        //  1303: aload_2        
        //  1304: iload           5
        //  1306: iconst_2       
        //  1307: iadd           
        //  1308: aaload         
        //  1309: dup            
        //  1310: astore          6
        //  1312: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1315: iastore        
        //  1316: iinc            5, -1
        //  1319: iload           5
        //  1321: ifge            1300
        //  1324: invokestatic    kawa/lib/strings.isChar$Eq:(II[I)Z
        //  1327: ifeq            1336
        //  1330: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1333: goto            1339
        //  1336: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1339: areturn        
        //  1340: aload_2        
        //  1341: iconst_0       
        //  1342: aaload         
        //  1343: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1346: dup            
        //  1347: astore          5
        //  1349: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1352: aload_2        
        //  1353: iconst_1       
        //  1354: aaload         
        //  1355: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1358: dup            
        //  1359: astore          5
        //  1361: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1364: aload_2        
        //  1365: arraylength    
        //  1366: iconst_2       
        //  1367: isub           
        //  1368: istore          5
        //  1370: iload           5
        //  1372: newarray        I
        //  1374: goto            1393
        //  1377: dup            
        //  1378: iload           5
        //  1380: aload_2        
        //  1381: iload           5
        //  1383: iconst_2       
        //  1384: iadd           
        //  1385: aaload         
        //  1386: dup            
        //  1387: astore          6
        //  1389: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1392: iastore        
        //  1393: iinc            5, -1
        //  1396: iload           5
        //  1398: ifge            1377
        //  1401: invokestatic    kawa/lib/strings.isChar$Ls:(II[I)Z
        //  1404: ifeq            1413
        //  1407: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1410: goto            1416
        //  1413: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1416: areturn        
        //  1417: aload_2        
        //  1418: iconst_0       
        //  1419: aaload         
        //  1420: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1423: dup            
        //  1424: astore          5
        //  1426: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1429: aload_2        
        //  1430: iconst_1       
        //  1431: aaload         
        //  1432: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1435: dup            
        //  1436: astore          5
        //  1438: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1441: aload_2        
        //  1442: arraylength    
        //  1443: iconst_2       
        //  1444: isub           
        //  1445: istore          5
        //  1447: iload           5
        //  1449: newarray        I
        //  1451: goto            1470
        //  1454: dup            
        //  1455: iload           5
        //  1457: aload_2        
        //  1458: iload           5
        //  1460: iconst_2       
        //  1461: iadd           
        //  1462: aaload         
        //  1463: dup            
        //  1464: astore          6
        //  1466: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1469: iastore        
        //  1470: iinc            5, -1
        //  1473: iload           5
        //  1475: ifge            1454
        //  1478: invokestatic    kawa/lib/strings.isChar$Gr:(II[I)Z
        //  1481: ifeq            1490
        //  1484: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1487: goto            1493
        //  1490: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1493: areturn        
        //  1494: aload_2        
        //  1495: iconst_0       
        //  1496: aaload         
        //  1497: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1500: dup            
        //  1501: astore          5
        //  1503: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1506: aload_2        
        //  1507: iconst_1       
        //  1508: aaload         
        //  1509: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1512: dup            
        //  1513: astore          5
        //  1515: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1518: aload_2        
        //  1519: arraylength    
        //  1520: iconst_2       
        //  1521: isub           
        //  1522: istore          5
        //  1524: iload           5
        //  1526: newarray        I
        //  1528: goto            1547
        //  1531: dup            
        //  1532: iload           5
        //  1534: aload_2        
        //  1535: iload           5
        //  1537: iconst_2       
        //  1538: iadd           
        //  1539: aaload         
        //  1540: dup            
        //  1541: astore          6
        //  1543: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1546: iastore        
        //  1547: iinc            5, -1
        //  1550: iload           5
        //  1552: ifge            1531
        //  1555: invokestatic    kawa/lib/strings.isChar$Ls$Eq:(II[I)Z
        //  1558: ifeq            1567
        //  1561: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1564: goto            1570
        //  1567: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1570: areturn        
        //  1571: aload_2        
        //  1572: iconst_0       
        //  1573: aaload         
        //  1574: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1577: dup            
        //  1578: astore          5
        //  1580: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1583: aload_2        
        //  1584: iconst_1       
        //  1585: aaload         
        //  1586: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1589: dup            
        //  1590: astore          5
        //  1592: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1595: aload_2        
        //  1596: arraylength    
        //  1597: iconst_2       
        //  1598: isub           
        //  1599: istore          5
        //  1601: iload           5
        //  1603: newarray        I
        //  1605: goto            1624
        //  1608: dup            
        //  1609: iload           5
        //  1611: aload_2        
        //  1612: iload           5
        //  1614: iconst_2       
        //  1615: iadd           
        //  1616: aaload         
        //  1617: dup            
        //  1618: astore          6
        //  1620: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1623: iastore        
        //  1624: iinc            5, -1
        //  1627: iload           5
        //  1629: ifge            1608
        //  1632: invokestatic    kawa/lib/strings.isChar$Gr$Eq:(II[I)Z
        //  1635: ifeq            1644
        //  1638: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1641: goto            1647
        //  1644: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1647: areturn        
        //  1648: aload_2        
        //  1649: iconst_0       
        //  1650: aaload         
        //  1651: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1654: dup            
        //  1655: astore          5
        //  1657: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1660: aload_2        
        //  1661: iconst_1       
        //  1662: aaload         
        //  1663: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1666: dup            
        //  1667: astore          5
        //  1669: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1672: aload_2        
        //  1673: arraylength    
        //  1674: iconst_2       
        //  1675: isub           
        //  1676: istore          5
        //  1678: iload           5
        //  1680: newarray        I
        //  1682: goto            1701
        //  1685: dup            
        //  1686: iload           5
        //  1688: aload_2        
        //  1689: iload           5
        //  1691: iconst_2       
        //  1692: iadd           
        //  1693: aaload         
        //  1694: dup            
        //  1695: astore          6
        //  1697: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1700: iastore        
        //  1701: iinc            5, -1
        //  1704: iload           5
        //  1706: ifge            1685
        //  1709: invokestatic    kawa/lib/strings.isCharCi$Eq:(II[I)Z
        //  1712: ifeq            1721
        //  1715: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1718: goto            1724
        //  1721: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1724: areturn        
        //  1725: aload_2        
        //  1726: iconst_0       
        //  1727: aaload         
        //  1728: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1731: dup            
        //  1732: astore          5
        //  1734: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1737: aload_2        
        //  1738: iconst_1       
        //  1739: aaload         
        //  1740: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1743: dup            
        //  1744: astore          5
        //  1746: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1749: aload_2        
        //  1750: arraylength    
        //  1751: iconst_2       
        //  1752: isub           
        //  1753: istore          5
        //  1755: iload           5
        //  1757: newarray        I
        //  1759: goto            1778
        //  1762: dup            
        //  1763: iload           5
        //  1765: aload_2        
        //  1766: iload           5
        //  1768: iconst_2       
        //  1769: iadd           
        //  1770: aaload         
        //  1771: dup            
        //  1772: astore          6
        //  1774: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1777: iastore        
        //  1778: iinc            5, -1
        //  1781: iload           5
        //  1783: ifge            1762
        //  1786: invokestatic    kawa/lib/strings.isCharCi$Ls:(II[I)Z
        //  1789: ifeq            1798
        //  1792: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1795: goto            1801
        //  1798: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1801: areturn        
        //  1802: aload_2        
        //  1803: iconst_0       
        //  1804: aaload         
        //  1805: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1808: dup            
        //  1809: astore          5
        //  1811: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1814: aload_2        
        //  1815: iconst_1       
        //  1816: aaload         
        //  1817: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1820: dup            
        //  1821: astore          5
        //  1823: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1826: aload_2        
        //  1827: arraylength    
        //  1828: iconst_2       
        //  1829: isub           
        //  1830: istore          5
        //  1832: iload           5
        //  1834: newarray        I
        //  1836: goto            1855
        //  1839: dup            
        //  1840: iload           5
        //  1842: aload_2        
        //  1843: iload           5
        //  1845: iconst_2       
        //  1846: iadd           
        //  1847: aaload         
        //  1848: dup            
        //  1849: astore          6
        //  1851: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1854: iastore        
        //  1855: iinc            5, -1
        //  1858: iload           5
        //  1860: ifge            1839
        //  1863: invokestatic    kawa/lib/strings.isCharCi$Gr:(II[I)Z
        //  1866: ifeq            1875
        //  1869: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1872: goto            1878
        //  1875: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1878: areturn        
        //  1879: aload_2        
        //  1880: iconst_0       
        //  1881: aaload         
        //  1882: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1885: dup            
        //  1886: astore          5
        //  1888: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1891: aload_2        
        //  1892: iconst_1       
        //  1893: aaload         
        //  1894: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1897: dup            
        //  1898: astore          5
        //  1900: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1903: aload_2        
        //  1904: arraylength    
        //  1905: iconst_2       
        //  1906: isub           
        //  1907: istore          5
        //  1909: iload           5
        //  1911: newarray        I
        //  1913: goto            1932
        //  1916: dup            
        //  1917: iload           5
        //  1919: aload_2        
        //  1920: iload           5
        //  1922: iconst_2       
        //  1923: iadd           
        //  1924: aaload         
        //  1925: dup            
        //  1926: astore          6
        //  1928: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1931: iastore        
        //  1932: iinc            5, -1
        //  1935: iload           5
        //  1937: ifge            1916
        //  1940: invokestatic    kawa/lib/strings.isCharCi$Ls$Eq:(II[I)Z
        //  1943: ifeq            1952
        //  1946: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1949: goto            1955
        //  1952: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1955: areturn        
        //  1956: aload_2        
        //  1957: iconst_0       
        //  1958: aaload         
        //  1959: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1962: dup            
        //  1963: astore          5
        //  1965: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1968: aload_2        
        //  1969: iconst_1       
        //  1970: aaload         
        //  1971: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1974: dup            
        //  1975: astore          5
        //  1977: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1980: aload_2        
        //  1981: arraylength    
        //  1982: iconst_2       
        //  1983: isub           
        //  1984: istore          5
        //  1986: iload           5
        //  1988: newarray        I
        //  1990: goto            2009
        //  1993: dup            
        //  1994: iload           5
        //  1996: aload_2        
        //  1997: iload           5
        //  1999: iconst_2       
        //  2000: iadd           
        //  2001: aaload         
        //  2002: dup            
        //  2003: astore          6
        //  2005: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  2008: iastore        
        //  2009: iinc            5, -1
        //  2012: iload           5
        //  2014: ifge            1993
        //  2017: invokestatic    kawa/lib/strings.isCharCi$Gr$Eq:(II[I)Z
        //  2020: ifeq            2029
        //  2023: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  2026: goto            2032
        //  2029: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  2032: areturn        
        //  2033: aload_2        
        //  2034: iconst_0       
        //  2035: aaload         
        //  2036: aload_2        
        //  2037: iconst_1       
        //  2038: aaload         
        //  2039: ldc             Ljava/lang/CharSequence;.class
        //  2041: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2044: dup            
        //  2045: astore          5
        //  2047: checkcast       Ljava/lang/CharSequence;
        //  2050: aload_2        
        //  2051: arraylength    
        //  2052: iconst_2       
        //  2053: isub           
        //  2054: istore          5
        //  2056: iload           5
        //  2058: anewarray       Ljava/lang/Object;
        //  2061: goto            2074
        //  2064: dup            
        //  2065: iload           5
        //  2067: aload_2        
        //  2068: iload           5
        //  2070: iconst_2       
        //  2071: iadd           
        //  2072: aaload         
        //  2073: aastore        
        //  2074: iinc            5, -1
        //  2077: iload           5
        //  2079: ifge            2064
        //  2082: invokestatic    kawa/lib/strings.stringForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;[Ljava/lang/Object;)V
        //  2085: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //  2088: areturn        
        //  2089: aload_2        
        //  2090: iconst_0       
        //  2091: aaload         
        //  2092: aload_2        
        //  2093: iconst_1       
        //  2094: aaload         
        //  2095: ldc             Ljava/lang/CharSequence;.class
        //  2097: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2100: dup            
        //  2101: astore          5
        //  2103: checkcast       Ljava/lang/CharSequence;
        //  2106: aload_2        
        //  2107: arraylength    
        //  2108: iconst_2       
        //  2109: isub           
        //  2110: istore          5
        //  2112: iload           5
        //  2114: anewarray       Ljava/lang/CharSequence;
        //  2117: goto            2136
        //  2120: dup            
        //  2121: iload           5
        //  2123: aload_2        
        //  2124: iload           5
        //  2126: iconst_2       
        //  2127: iadd           
        //  2128: aaload         
        //  2129: dup            
        //  2130: astore          6
        //  2132: checkcast       Ljava/lang/CharSequence;
        //  2135: aastore        
        //  2136: iinc            5, -1
        //  2139: iload           5
        //  2141: ifge            2120
        //  2144: invokestatic    kawa/lib/strings.stringMap:(Ljava/lang/Object;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
        //  2147: areturn        
        //  2148: aload_2        
        //  2149: iconst_0       
        //  2150: aaload         
        //  2151: ldc             Lgnu/lists/FString;.class
        //  2153: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2156: dup            
        //  2157: astore          5
        //  2159: checkcast       Lgnu/lists/FString;
        //  2162: aload_2        
        //  2163: arraylength    
        //  2164: iconst_1       
        //  2165: isub           
        //  2166: istore          5
        //  2168: iload           5
        //  2170: anewarray       Ljava/lang/Object;
        //  2173: goto            2186
        //  2176: dup            
        //  2177: iload           5
        //  2179: aload_2        
        //  2180: iload           5
        //  2182: iconst_1       
        //  2183: iadd           
        //  2184: aaload         
        //  2185: aastore        
        //  2186: iinc            5, -1
        //  2189: iload           5
        //  2191: ifge            2176
        //  2194: invokestatic    kawa/lib/strings.stringAppend$Ex:(Lgnu/lists/FString;[Ljava/lang/Object;)V
        //  2197: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //  2200: areturn        
        //  2201: aload_0        
        //  2202: aload_1        
        //  2203: aload_2        
        //  2204: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //  2207: areturn        
        //  2208: new             Lgnu/mapping/WrongType;
        //  2211: dup_x1         
        //  2212: swap           
        //  2213: ldc_w           "string<?"
        //  2216: iconst_1       
        //  2217: aload_3        
        //  2218: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2221: athrow         
        //  2222: new             Lgnu/mapping/WrongType;
        //  2225: dup_x1         
        //  2226: swap           
        //  2227: ldc_w           "string<?"
        //  2230: iconst_2       
        //  2231: aload_3        
        //  2232: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2235: athrow         
        //  2236: new             Lgnu/mapping/WrongType;
        //  2239: dup_x1         
        //  2240: swap           
        //  2241: ldc_w           "string<?"
        //  2244: iconst_0       
        //  2245: aload           4
        //  2247: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2250: athrow         
        //  2251: new             Lgnu/mapping/WrongType;
        //  2254: dup_x1         
        //  2255: swap           
        //  2256: ldc_w           "string=?"
        //  2259: iconst_1       
        //  2260: aload_3        
        //  2261: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2264: athrow         
        //  2265: new             Lgnu/mapping/WrongType;
        //  2268: dup_x1         
        //  2269: swap           
        //  2270: ldc_w           "string=?"
        //  2273: iconst_2       
        //  2274: aload_3        
        //  2275: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2278: athrow         
        //  2279: new             Lgnu/mapping/WrongType;
        //  2282: dup_x1         
        //  2283: swap           
        //  2284: ldc_w           "string=?"
        //  2287: iconst_0       
        //  2288: aload           4
        //  2290: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2293: athrow         
        //  2294: new             Lgnu/mapping/WrongType;
        //  2297: dup_x1         
        //  2298: swap           
        //  2299: ldc_w           "string>?"
        //  2302: iconst_1       
        //  2303: aload_3        
        //  2304: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2307: athrow         
        //  2308: new             Lgnu/mapping/WrongType;
        //  2311: dup_x1         
        //  2312: swap           
        //  2313: ldc_w           "string>?"
        //  2316: iconst_2       
        //  2317: aload_3        
        //  2318: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2321: athrow         
        //  2322: new             Lgnu/mapping/WrongType;
        //  2325: dup_x1         
        //  2326: swap           
        //  2327: ldc_w           "string>?"
        //  2330: iconst_0       
        //  2331: aload           4
        //  2333: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2336: athrow         
        //  2337: new             Lgnu/mapping/WrongType;
        //  2340: dup_x1         
        //  2341: swap           
        //  2342: ldc_w           "string<=?"
        //  2345: iconst_1       
        //  2346: aload_3        
        //  2347: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2350: athrow         
        //  2351: new             Lgnu/mapping/WrongType;
        //  2354: dup_x1         
        //  2355: swap           
        //  2356: ldc_w           "string<=?"
        //  2359: iconst_2       
        //  2360: aload_3        
        //  2361: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2364: athrow         
        //  2365: new             Lgnu/mapping/WrongType;
        //  2368: dup_x1         
        //  2369: swap           
        //  2370: ldc_w           "string<=?"
        //  2373: iconst_0       
        //  2374: aload           4
        //  2376: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2379: athrow         
        //  2380: new             Lgnu/mapping/WrongType;
        //  2383: dup_x1         
        //  2384: swap           
        //  2385: ldc_w           "string>=?"
        //  2388: iconst_1       
        //  2389: aload_3        
        //  2390: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2393: athrow         
        //  2394: new             Lgnu/mapping/WrongType;
        //  2397: dup_x1         
        //  2398: swap           
        //  2399: ldc_w           "string>=?"
        //  2402: iconst_2       
        //  2403: aload_3        
        //  2404: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2407: athrow         
        //  2408: new             Lgnu/mapping/WrongType;
        //  2411: dup_x1         
        //  2412: swap           
        //  2413: ldc_w           "string>=?"
        //  2416: iconst_0       
        //  2417: aload           4
        //  2419: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2422: athrow         
        //  2423: new             Lgnu/mapping/WrongType;
        //  2426: dup_x1         
        //  2427: swap           
        //  2428: ldc_w           "string-copy!"
        //  2431: iconst_1       
        //  2432: aload           4
        //  2434: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2437: athrow         
        //  2438: new             Lgnu/mapping/WrongType;
        //  2441: dup_x1         
        //  2442: swap           
        //  2443: ldc_w           "string-copy!"
        //  2446: iconst_2       
        //  2447: aload           4
        //  2449: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2452: athrow         
        //  2453: new             Lgnu/mapping/WrongType;
        //  2456: dup_x1         
        //  2457: swap           
        //  2458: ldc_w           "string-copy!"
        //  2461: iconst_3       
        //  2462: aload           4
        //  2464: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2467: athrow         
        //  2468: new             Lgnu/mapping/WrongType;
        //  2471: dup_x1         
        //  2472: swap           
        //  2473: ldc_w           "string-copy!"
        //  2476: iconst_4       
        //  2477: aload           4
        //  2479: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2482: athrow         
        //  2483: new             Lgnu/mapping/WrongType;
        //  2486: dup_x1         
        //  2487: swap           
        //  2488: ldc_w           "string-copy!"
        //  2491: iconst_5       
        //  2492: aload           4
        //  2494: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2497: athrow         
        //  2498: new             Lgnu/mapping/WrongType;
        //  2501: dup_x1         
        //  2502: swap           
        //  2503: ldc_w           "string-replace!"
        //  2506: iconst_1       
        //  2507: aload           5
        //  2509: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2512: athrow         
        //  2513: new             Lgnu/mapping/WrongType;
        //  2516: dup_x1         
        //  2517: swap           
        //  2518: ldc_w           "string-replace!"
        //  2521: iconst_2       
        //  2522: aload           5
        //  2524: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2527: athrow         
        //  2528: new             Lgnu/mapping/WrongType;
        //  2531: dup_x1         
        //  2532: swap           
        //  2533: ldc_w           "string-replace!"
        //  2536: iconst_3       
        //  2537: aload           5
        //  2539: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2542: athrow         
        //  2543: new             Lgnu/mapping/WrongType;
        //  2546: dup_x1         
        //  2547: swap           
        //  2548: ldc_w           "string-replace!"
        //  2551: iconst_4       
        //  2552: aload           5
        //  2554: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2557: athrow         
        //  2558: new             Lgnu/mapping/WrongType;
        //  2561: dup_x1         
        //  2562: swap           
        //  2563: ldc_w           "string-replace!"
        //  2566: iconst_5       
        //  2567: aload           5
        //  2569: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2572: athrow         
        //  2573: new             Lgnu/mapping/WrongType;
        //  2576: dup_x1         
        //  2577: swap           
        //  2578: ldc_w           "string-replace!"
        //  2581: bipush          6
        //  2583: aload           5
        //  2585: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2588: athrow         
        //  2589: new             Lgnu/mapping/WrongType;
        //  2592: dup_x1         
        //  2593: swap           
        //  2594: ldc_w           "string-ci<?"
        //  2597: iconst_1       
        //  2598: aload           5
        //  2600: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2603: athrow         
        //  2604: new             Lgnu/mapping/WrongType;
        //  2607: dup_x1         
        //  2608: swap           
        //  2609: ldc_w           "string-ci<?"
        //  2612: iconst_2       
        //  2613: aload           5
        //  2615: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2618: athrow         
        //  2619: new             Lgnu/mapping/WrongType;
        //  2622: dup_x1         
        //  2623: swap           
        //  2624: ldc_w           "string-ci<?"
        //  2627: iconst_0       
        //  2628: aload           6
        //  2630: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2633: athrow         
        //  2634: new             Lgnu/mapping/WrongType;
        //  2637: dup_x1         
        //  2638: swap           
        //  2639: ldc_w           "string-ci=?"
        //  2642: iconst_1       
        //  2643: aload           5
        //  2645: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2648: athrow         
        //  2649: new             Lgnu/mapping/WrongType;
        //  2652: dup_x1         
        //  2653: swap           
        //  2654: ldc_w           "string-ci=?"
        //  2657: iconst_2       
        //  2658: aload           5
        //  2660: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2663: athrow         
        //  2664: new             Lgnu/mapping/WrongType;
        //  2667: dup_x1         
        //  2668: swap           
        //  2669: ldc_w           "string-ci=?"
        //  2672: iconst_0       
        //  2673: aload           6
        //  2675: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2678: athrow         
        //  2679: new             Lgnu/mapping/WrongType;
        //  2682: dup_x1         
        //  2683: swap           
        //  2684: ldc_w           "string-ci>?"
        //  2687: iconst_1       
        //  2688: aload           5
        //  2690: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2693: athrow         
        //  2694: new             Lgnu/mapping/WrongType;
        //  2697: dup_x1         
        //  2698: swap           
        //  2699: ldc_w           "string-ci>?"
        //  2702: iconst_2       
        //  2703: aload           5
        //  2705: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2708: athrow         
        //  2709: new             Lgnu/mapping/WrongType;
        //  2712: dup_x1         
        //  2713: swap           
        //  2714: ldc_w           "string-ci>?"
        //  2717: iconst_0       
        //  2718: aload           6
        //  2720: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2723: athrow         
        //  2724: new             Lgnu/mapping/WrongType;
        //  2727: dup_x1         
        //  2728: swap           
        //  2729: ldc_w           "string-ci<=?"
        //  2732: iconst_1       
        //  2733: aload           5
        //  2735: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2738: athrow         
        //  2739: new             Lgnu/mapping/WrongType;
        //  2742: dup_x1         
        //  2743: swap           
        //  2744: ldc_w           "string-ci<=?"
        //  2747: iconst_2       
        //  2748: aload           5
        //  2750: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2753: athrow         
        //  2754: new             Lgnu/mapping/WrongType;
        //  2757: dup_x1         
        //  2758: swap           
        //  2759: ldc_w           "string-ci<=?"
        //  2762: iconst_0       
        //  2763: aload           6
        //  2765: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2768: athrow         
        //  2769: new             Lgnu/mapping/WrongType;
        //  2772: dup_x1         
        //  2773: swap           
        //  2774: ldc_w           "string-ci>=?"
        //  2777: iconst_1       
        //  2778: aload           5
        //  2780: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2783: athrow         
        //  2784: new             Lgnu/mapping/WrongType;
        //  2787: dup_x1         
        //  2788: swap           
        //  2789: ldc_w           "string-ci>=?"
        //  2792: iconst_2       
        //  2793: aload           5
        //  2795: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2798: athrow         
        //  2799: new             Lgnu/mapping/WrongType;
        //  2802: dup_x1         
        //  2803: swap           
        //  2804: ldc_w           "string-ci>=?"
        //  2807: iconst_0       
        //  2808: aload           6
        //  2810: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2813: athrow         
        //  2814: new             Lgnu/mapping/WrongType;
        //  2817: dup_x1         
        //  2818: swap           
        //  2819: ldc_w           "char=?"
        //  2822: iconst_1       
        //  2823: aload           5
        //  2825: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2828: athrow         
        //  2829: new             Lgnu/mapping/WrongType;
        //  2832: dup_x1         
        //  2833: swap           
        //  2834: ldc_w           "char=?"
        //  2837: iconst_2       
        //  2838: aload           5
        //  2840: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2843: athrow         
        //  2844: new             Lgnu/mapping/WrongType;
        //  2847: dup_x1         
        //  2848: swap           
        //  2849: ldc_w           "char=?"
        //  2852: iconst_0       
        //  2853: aload           6
        //  2855: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2858: athrow         
        //  2859: new             Lgnu/mapping/WrongType;
        //  2862: dup_x1         
        //  2863: swap           
        //  2864: ldc_w           "char<?"
        //  2867: iconst_1       
        //  2868: aload           5
        //  2870: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2873: athrow         
        //  2874: new             Lgnu/mapping/WrongType;
        //  2877: dup_x1         
        //  2878: swap           
        //  2879: ldc_w           "char<?"
        //  2882: iconst_2       
        //  2883: aload           5
        //  2885: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2888: athrow         
        //  2889: new             Lgnu/mapping/WrongType;
        //  2892: dup_x1         
        //  2893: swap           
        //  2894: ldc_w           "char<?"
        //  2897: iconst_0       
        //  2898: aload           6
        //  2900: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2903: athrow         
        //  2904: new             Lgnu/mapping/WrongType;
        //  2907: dup_x1         
        //  2908: swap           
        //  2909: ldc_w           "char>?"
        //  2912: iconst_1       
        //  2913: aload           5
        //  2915: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2918: athrow         
        //  2919: new             Lgnu/mapping/WrongType;
        //  2922: dup_x1         
        //  2923: swap           
        //  2924: ldc_w           "char>?"
        //  2927: iconst_2       
        //  2928: aload           5
        //  2930: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2933: athrow         
        //  2934: new             Lgnu/mapping/WrongType;
        //  2937: dup_x1         
        //  2938: swap           
        //  2939: ldc_w           "char>?"
        //  2942: iconst_0       
        //  2943: aload           6
        //  2945: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2948: athrow         
        //  2949: new             Lgnu/mapping/WrongType;
        //  2952: dup_x1         
        //  2953: swap           
        //  2954: ldc_w           "char<=?"
        //  2957: iconst_1       
        //  2958: aload           5
        //  2960: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2963: athrow         
        //  2964: new             Lgnu/mapping/WrongType;
        //  2967: dup_x1         
        //  2968: swap           
        //  2969: ldc_w           "char<=?"
        //  2972: iconst_2       
        //  2973: aload           5
        //  2975: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2978: athrow         
        //  2979: new             Lgnu/mapping/WrongType;
        //  2982: dup_x1         
        //  2983: swap           
        //  2984: ldc_w           "char<=?"
        //  2987: iconst_0       
        //  2988: aload           6
        //  2990: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2993: athrow         
        //  2994: new             Lgnu/mapping/WrongType;
        //  2997: dup_x1         
        //  2998: swap           
        //  2999: ldc_w           "char>=?"
        //  3002: iconst_1       
        //  3003: aload           5
        //  3005: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3008: athrow         
        //  3009: new             Lgnu/mapping/WrongType;
        //  3012: dup_x1         
        //  3013: swap           
        //  3014: ldc_w           "char>=?"
        //  3017: iconst_2       
        //  3018: aload           5
        //  3020: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3023: athrow         
        //  3024: new             Lgnu/mapping/WrongType;
        //  3027: dup_x1         
        //  3028: swap           
        //  3029: ldc_w           "char>=?"
        //  3032: iconst_0       
        //  3033: aload           6
        //  3035: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3038: athrow         
        //  3039: new             Lgnu/mapping/WrongType;
        //  3042: dup_x1         
        //  3043: swap           
        //  3044: ldc_w           "char-ci=?"
        //  3047: iconst_1       
        //  3048: aload           5
        //  3050: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3053: athrow         
        //  3054: new             Lgnu/mapping/WrongType;
        //  3057: dup_x1         
        //  3058: swap           
        //  3059: ldc_w           "char-ci=?"
        //  3062: iconst_2       
        //  3063: aload           5
        //  3065: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3068: athrow         
        //  3069: new             Lgnu/mapping/WrongType;
        //  3072: dup_x1         
        //  3073: swap           
        //  3074: ldc_w           "char-ci=?"
        //  3077: iconst_0       
        //  3078: aload           6
        //  3080: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3083: athrow         
        //  3084: new             Lgnu/mapping/WrongType;
        //  3087: dup_x1         
        //  3088: swap           
        //  3089: ldc_w           "char-ci<?"
        //  3092: iconst_1       
        //  3093: aload           5
        //  3095: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3098: athrow         
        //  3099: new             Lgnu/mapping/WrongType;
        //  3102: dup_x1         
        //  3103: swap           
        //  3104: ldc_w           "char-ci<?"
        //  3107: iconst_2       
        //  3108: aload           5
        //  3110: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3113: athrow         
        //  3114: new             Lgnu/mapping/WrongType;
        //  3117: dup_x1         
        //  3118: swap           
        //  3119: ldc_w           "char-ci<?"
        //  3122: iconst_0       
        //  3123: aload           6
        //  3125: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3128: athrow         
        //  3129: new             Lgnu/mapping/WrongType;
        //  3132: dup_x1         
        //  3133: swap           
        //  3134: ldc_w           "char-ci>?"
        //  3137: iconst_1       
        //  3138: aload           5
        //  3140: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3143: athrow         
        //  3144: new             Lgnu/mapping/WrongType;
        //  3147: dup_x1         
        //  3148: swap           
        //  3149: ldc_w           "char-ci>?"
        //  3152: iconst_2       
        //  3153: aload           5
        //  3155: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3158: athrow         
        //  3159: new             Lgnu/mapping/WrongType;
        //  3162: dup_x1         
        //  3163: swap           
        //  3164: ldc_w           "char-ci>?"
        //  3167: iconst_0       
        //  3168: aload           6
        //  3170: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3173: athrow         
        //  3174: new             Lgnu/mapping/WrongType;
        //  3177: dup_x1         
        //  3178: swap           
        //  3179: ldc_w           "char-ci<=?"
        //  3182: iconst_1       
        //  3183: aload           5
        //  3185: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3188: athrow         
        //  3189: new             Lgnu/mapping/WrongType;
        //  3192: dup_x1         
        //  3193: swap           
        //  3194: ldc_w           "char-ci<=?"
        //  3197: iconst_2       
        //  3198: aload           5
        //  3200: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3203: athrow         
        //  3204: new             Lgnu/mapping/WrongType;
        //  3207: dup_x1         
        //  3208: swap           
        //  3209: ldc_w           "char-ci<=?"
        //  3212: iconst_0       
        //  3213: aload           6
        //  3215: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3218: athrow         
        //  3219: new             Lgnu/mapping/WrongType;
        //  3222: dup_x1         
        //  3223: swap           
        //  3224: ldc_w           "char-ci>=?"
        //  3227: iconst_1       
        //  3228: aload           5
        //  3230: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3233: athrow         
        //  3234: new             Lgnu/mapping/WrongType;
        //  3237: dup_x1         
        //  3238: swap           
        //  3239: ldc_w           "char-ci>=?"
        //  3242: iconst_2       
        //  3243: aload           5
        //  3245: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3248: athrow         
        //  3249: new             Lgnu/mapping/WrongType;
        //  3252: dup_x1         
        //  3253: swap           
        //  3254: ldc_w           "char-ci>=?"
        //  3257: iconst_0       
        //  3258: aload           6
        //  3260: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3263: athrow         
        //  3264: new             Lgnu/mapping/WrongType;
        //  3267: dup_x1         
        //  3268: swap           
        //  3269: ldc_w           "string-for-each"
        //  3272: iconst_2       
        //  3273: aload           5
        //  3275: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3278: athrow         
        //  3279: new             Lgnu/mapping/WrongType;
        //  3282: dup_x1         
        //  3283: swap           
        //  3284: ldc_w           "string-map"
        //  3287: iconst_2       
        //  3288: aload           5
        //  3290: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3293: athrow         
        //  3294: new             Lgnu/mapping/WrongType;
        //  3297: dup_x1         
        //  3298: swap           
        //  3299: ldc_w           "string-map"
        //  3302: iconst_0       
        //  3303: aload           6
        //  3305: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3308: athrow         
        //  3309: new             Lgnu/mapping/WrongType;
        //  3312: dup_x1         
        //  3313: swap           
        //  3314: ldc_w           "string-append!"
        //  3317: iconst_1       
        //  3318: aload           5
        //  3320: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3323: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  243    246    2208   2222   Ljava/lang/ClassCastException;
        //  256    259    2222   2236   Ljava/lang/ClassCastException;
        //  281    284    2236   2251   Ljava/lang/ClassCastException;
        //  318    321    2251   2265   Ljava/lang/ClassCastException;
        //  331    334    2265   2279   Ljava/lang/ClassCastException;
        //  356    359    2279   2294   Ljava/lang/ClassCastException;
        //  393    396    2294   2308   Ljava/lang/ClassCastException;
        //  406    409    2308   2322   Ljava/lang/ClassCastException;
        //  431    434    2322   2337   Ljava/lang/ClassCastException;
        //  468    471    2337   2351   Ljava/lang/ClassCastException;
        //  481    484    2351   2365   Ljava/lang/ClassCastException;
        //  506    509    2365   2380   Ljava/lang/ClassCastException;
        //  543    546    2380   2394   Ljava/lang/ClassCastException;
        //  556    559    2394   2408   Ljava/lang/ClassCastException;
        //  581    584    2408   2423   Ljava/lang/ClassCastException;
        //  624    627    2423   2438   Ljava/lang/ClassCastException;
        //  636    642    2438   2453   Ljava/lang/ClassCastException;
        //  653    656    2453   2468   Ljava/lang/ClassCastException;
        //  678    684    2468   2483   Ljava/lang/ClassCastException;
        //  706    712    2483   2498   Ljava/lang/ClassCastException;
        //  736    739    2498   2513   Ljava/lang/ClassCastException;
        //  748    754    2513   2528   Ljava/lang/ClassCastException;
        //  763    769    2528   2543   Ljava/lang/ClassCastException;
        //  780    783    2543   2558   Ljava/lang/ClassCastException;
        //  806    812    2558   2573   Ljava/lang/ClassCastException;
        //  835    841    2573   2589   Ljava/lang/ClassCastException;
        //  864    867    2589   2604   Ljava/lang/ClassCastException;
        //  878    881    2604   2619   Ljava/lang/ClassCastException;
        //  907    910    2619   2634   Ljava/lang/ClassCastException;
        //  946    949    2634   2649   Ljava/lang/ClassCastException;
        //  960    963    2649   2664   Ljava/lang/ClassCastException;
        //  989    992    2664   2679   Ljava/lang/ClassCastException;
        //  1028   1031   2679   2694   Ljava/lang/ClassCastException;
        //  1042   1045   2694   2709   Ljava/lang/ClassCastException;
        //  1071   1074   2709   2724   Ljava/lang/ClassCastException;
        //  1110   1113   2724   2739   Ljava/lang/ClassCastException;
        //  1124   1127   2739   2754   Ljava/lang/ClassCastException;
        //  1153   1156   2754   2769   Ljava/lang/ClassCastException;
        //  1192   1195   2769   2784   Ljava/lang/ClassCastException;
        //  1206   1209   2784   2799   Ljava/lang/ClassCastException;
        //  1235   1238   2799   2814   Ljava/lang/ClassCastException;
        //  1272   1275   2814   2829   Ljava/lang/ClassCastException;
        //  1284   1287   2829   2844   Ljava/lang/ClassCastException;
        //  1312   1315   2844   2859   Ljava/lang/ClassCastException;
        //  1349   1352   2859   2874   Ljava/lang/ClassCastException;
        //  1361   1364   2874   2889   Ljava/lang/ClassCastException;
        //  1389   1392   2889   2904   Ljava/lang/ClassCastException;
        //  1426   1429   2904   2919   Ljava/lang/ClassCastException;
        //  1438   1441   2919   2934   Ljava/lang/ClassCastException;
        //  1466   1469   2934   2949   Ljava/lang/ClassCastException;
        //  1503   1506   2949   2964   Ljava/lang/ClassCastException;
        //  1515   1518   2964   2979   Ljava/lang/ClassCastException;
        //  1543   1546   2979   2994   Ljava/lang/ClassCastException;
        //  1580   1583   2994   3009   Ljava/lang/ClassCastException;
        //  1592   1595   3009   3024   Ljava/lang/ClassCastException;
        //  1620   1623   3024   3039   Ljava/lang/ClassCastException;
        //  1657   1660   3039   3054   Ljava/lang/ClassCastException;
        //  1669   1672   3054   3069   Ljava/lang/ClassCastException;
        //  1697   1700   3069   3084   Ljava/lang/ClassCastException;
        //  1734   1737   3084   3099   Ljava/lang/ClassCastException;
        //  1746   1749   3099   3114   Ljava/lang/ClassCastException;
        //  1774   1777   3114   3129   Ljava/lang/ClassCastException;
        //  1811   1814   3129   3144   Ljava/lang/ClassCastException;
        //  1823   1826   3144   3159   Ljava/lang/ClassCastException;
        //  1851   1854   3159   3174   Ljava/lang/ClassCastException;
        //  1888   1891   3174   3189   Ljava/lang/ClassCastException;
        //  1900   1903   3189   3204   Ljava/lang/ClassCastException;
        //  1928   1931   3204   3219   Ljava/lang/ClassCastException;
        //  1965   1968   3219   3234   Ljava/lang/ClassCastException;
        //  1977   1980   3234   3249   Ljava/lang/ClassCastException;
        //  2005   2008   3249   3264   Ljava/lang/ClassCastException;
        //  2047   2050   3264   3279   Ljava/lang/ClassCastException;
        //  2103   2106   3279   3294   Ljava/lang/ClassCastException;
        //  2132   2135   3294   3309   Ljava/lang/ClassCastException;
        //  2159   2162   3309   3324   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 1696 out of bounds for length 1696
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
