// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.math.RatNum;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.math.BitOps;
import gnu.lists.FString;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.ModuleInfo;
import java.lang.reflect.Array;
import java.util.Arrays;
import gnu.mapping.Symbol;
import kawa.lib.lists;
import gnu.mapping.Values;
import gnu.kawa.functions.AddOp;
import gnu.text.Char;
import kawa.lib.strings;
import gnu.bytecode.Type;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.lists.LList;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.reflect.Invoke;
import kawa.SourceMethodType;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.kawa.functions.DivideOp;
import gnu.expr.KawaConvert;
import kawa.standard.Scheme;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.bytecode.ClassType;
import gnu.math.IntNum;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Procedure;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class srfi14 extends ModuleBody
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
    static final IntNum Lit1;
    static final IntNum Lit2;
    static final ClassType Lit3;
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
    static final SimpleSymbol Lit51;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        srfi14.char$Mnset$Mndiff$Plintersection$Ex = srfi14.char$Mnset$Mndiff$Plintersection;
    }
    
    public static boolean charSet$Eq(final CharSet... csets) {
        final boolean x = csets.length < 2;
        boolean b;
        if (x) {
            b = x;
        }
        else {
            int i = 1;
            while (true) {
                final boolean x2 = i == csets.length;
                if (x2) {
                    b = x2;
                    break;
                }
                if (!KawaConvert.isTrue(Scheme.isEqual.apply2(csets[0], csets[i]))) {
                    b = false;
                    break;
                }
                ++i;
            }
        }
        return b;
    }
    
    public static boolean charSet$Ls$Eq(final CharSet... csets) {
        final boolean x = csets.length < 2;
        boolean b;
        if (x) {
            b = x;
        }
        else {
            int i = 1;
            while (true) {
                final boolean x2 = i == csets.length;
                if (x2) {
                    b = x2;
                    break;
                }
                if (!csets[i - 1].isSubsetOf(csets[i])) {
                    b = false;
                    break;
                }
                ++i;
            }
        }
        return b;
    }
    
    public static int charSetHash(final CharSet cs) {
        return charSetHash(cs, 0);
    }
    
    public static int charSetHash(final CharSet cs, final int bound) {
        int natural$Mnhash = cs.hashCode();
        Label_0037: {
            if (natural$Mnhash >= 0) {
                break Label_0037;
            }
            final Object force = Promise.force(DivideOp.modulo.apply2(natural$Mnhash, Integer.MAX_VALUE));
            try {
                natural$Mnhash = ((Number)force).intValue();
                final boolean x = bound == 0;
                return (x ? x : (natural$Mnhash < bound)) ? natural$Mnhash : (natural$Mnhash % bound);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "natural-hash", -2, force);
            }
        }
    }
    
    public static int charSetCursor(final CharSet cset) {
        return cset.getCursor();
    }
    
    @SourceMethodType({ "character" })
    public static int charSetRef(final CharSet cset, final int cursor) {
        return cursor;
    }
    
    public static int charSetCursorNext(final CharSet cset, final int cursor) {
        return cset.cursorNext(cursor);
    }
    
    public static boolean isEndOfCharSet(final int cursor) {
        return cursor > 1114111;
    }
    
    public static Object charSetFold(final Procedure kons, final Object knil, final CharSet cs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi14.charSetCursor:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //     4: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //     7: aload_1         /* knil */
        //     8: astore          4
        //    10: astore_3        /* cursor */
        //    11: aload_3         /* cursor */
        //    12: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    15: dup            
        //    16: astore          5
        //    18: checkcast       Ljava/lang/Number;
        //    21: invokevirtual   java/lang/Number.intValue:()I
        //    24: invokestatic    gnu/kawa/slib/srfi14.isEndOfCharSet:(I)Z
        //    27: ifeq            35
        //    30: aload           answer
        //    32: goto            84
        //    35: aload_2         /* cs */
        //    36: aload_3         /* cursor */
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          5
        //    43: checkcast       Ljava/lang/Number;
        //    46: invokevirtual   java/lang/Number.intValue:()I
        //    49: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    52: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    55: aload_0         /* kons */
        //    56: aload_2         /* cs */
        //    57: aload_3         /* cursor */
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore          5
        //    64: checkcast       Ljava/lang/Number;
        //    67: invokevirtual   java/lang/Number.intValue:()I
        //    70: invokestatic    gnu/kawa/slib/srfi14.charSetRef:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    73: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    76: aload           answer
        //    78: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    81: goto            8
        //    84: areturn        
        //    85: new             Lgnu/mapping/WrongType;
        //    88: dup_x1         
        //    89: swap           
        //    90: ldc             "end-of-char-set?"
        //    92: iconst_0       
        //    93: aload           5
        //    95: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    98: athrow         
        //    99: new             Lgnu/mapping/WrongType;
        //   102: dup_x1         
        //   103: swap           
        //   104: ldc             "char-set-cursor-next"
        //   106: iconst_1       
        //   107: aload           5
        //   109: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   112: athrow         
        //   113: new             Lgnu/mapping/WrongType;
        //   116: dup_x1         
        //   117: swap           
        //   118: ldc             "char-set-ref"
        //   120: iconst_1       
        //   121: aload           5
        //   123: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   126: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     24     85     99     Ljava/lang/ClassCastException;
        //  43     49     99     113    Ljava/lang/ClassCastException;
        //  64     70     113    127    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static CharSet charSetUnfold(final Procedure p4, final Procedure f, final Procedure g, final Object seed) {
        return charSetUnfold(p4, f, g, seed, CharSet.empty);
    }
    
    public static CharSet charSetUnfold(final Procedure p, final Procedure f, final Procedure g, final Object seed, final CharSet base$Mncs) {
        return charSetUnfold$Ex(p, f, g, seed, charSetCopy(base$Mncs));
    }
    
    public static CharSet charSetUnfold$Ex(final Procedure p, final Procedure f, final Procedure g, final Object seed, final CharSet base$Mncs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload           base$Mncs
        //     3: astore          6
        //     5: astore          seed
        //     7: aload_0         /* p */
        //     8: aload           seed
        //    10: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    13: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    16: ifeq            24
        //    19: aload           cs
        //    21: goto            68
        //    24: aload_2         /* g */
        //    25: aload           seed
        //    27: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: aload           cs
        //    32: aload_1         /* f */
        //    33: aload           seed
        //    35: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    38: dup            
        //    39: instanceof      [I
        //    42: ifeq            51
        //    45: checkcast       [I
        //    48: goto            62
        //    51: iconst_1       
        //    52: newarray        I
        //    54: dup_x1         
        //    55: swap           
        //    56: iconst_0       
        //    57: swap           
        //    58: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //    61: iastore        
        //    62: invokestatic    gnu/kawa/slib/srfi14.charSetAdjoin$Ex:(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
        //    65: goto            3
        //    68: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static CharSet charSetCopy(final CharSet cs) {
        return cs.clone();
    }
    
    @SourceMethodType({ "", "", "character[]" })
    public static CharSet charSetAdjoin$Ex(final CharSet cs, final int... chars) {
        final int tmp = chars.length;
        switch (tmp) {
            case 0: {
                return cs;
            }
            case 1: {
                return cs.adjoin$Ex(chars[0]);
            }
        }
        final Invoke make = Invoke.make;
        final int count;
        final Object[] target = new Object[(count = MakeSplice.count(chars)) + 1];
        target[0] = CharSet.class;
        MakeSplice.copyTo(target, 1, count, chars);
        final Object force = Promise.force(make.applyN(target), CharSet.class);
        try {
            return cs.union$Ex((CharSet)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.kawa.slib.srfi14$CharSet.union$Ex(gnu.kawa.slib.srfi14$CharSet)", 2, force);
        }
    }
    
    public static Object charSetForEach(final Procedure proc, final CharSet cs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi14.charSetCursor:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //     4: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //     7: astore_2        /* cursor */
        //     8: aload_2         /* cursor */
        //     9: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    12: dup            
        //    13: astore_3       
        //    14: checkcast       Ljava/lang/Number;
        //    17: invokevirtual   java/lang/Number.intValue:()I
        //    20: invokestatic    gnu/kawa/slib/srfi14.isEndOfCharSet:(I)Z
        //    23: ifne            72
        //    26: aload_0         /* proc */
        //    27: aload_1         /* cs */
        //    28: aload_2         /* cursor */
        //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    32: dup            
        //    33: astore_3       
        //    34: checkcast       Ljava/lang/Number;
        //    37: invokevirtual   java/lang/Number.intValue:()I
        //    40: invokestatic    gnu/kawa/slib/srfi14.charSetRef:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    43: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    46: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    49: pop            
        //    50: aload_1         /* cs */
        //    51: aload_2         /* cursor */
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    55: dup            
        //    56: astore_3       
        //    57: checkcast       Ljava/lang/Number;
        //    60: invokevirtual   java/lang/Number.intValue:()I
        //    63: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    66: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    69: goto            7
        //    72: getstatic       gnu/kawa/slib/srfi14.Lit0:Lgnu/mapping/SimpleSymbol;
        //    75: areturn        
        //    76: new             Lgnu/mapping/WrongType;
        //    79: dup_x1         
        //    80: swap           
        //    81: ldc             "end-of-char-set?"
        //    83: iconst_0       
        //    84: aload_3        
        //    85: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    88: athrow         
        //    89: new             Lgnu/mapping/WrongType;
        //    92: dup_x1         
        //    93: swap           
        //    94: ldc             "char-set-ref"
        //    96: iconst_1       
        //    97: aload_3        
        //    98: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   101: athrow         
        //   102: new             Lgnu/mapping/WrongType;
        //   105: dup_x1         
        //   106: swap           
        //   107: ldc             "char-set-cursor-next"
        //   109: iconst_1       
        //   110: aload_3        
        //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   114: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  14     20     76     89     Ljava/lang/ClassCastException;
        //  34     40     89     102    Ljava/lang/ClassCastException;
        //  57     63     102    115    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 60 out of bounds for length 60
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
    
    public static CharSet charSetMap(final Procedure proc, final CharSet cs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi14.charSetCursor:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //     4: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //     7: getstatic       gnu/kawa/slib/srfi14$CharSet.empty:Lgnu/kawa/slib/srfi14$CharSet;
        //    10: invokestatic    gnu/kawa/slib/srfi14.charSetCopy:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //    13: astore_3       
        //    14: astore_2        /* cursor */
        //    15: aload_2         /* cursor */
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    19: dup            
        //    20: astore          4
        //    22: checkcast       Ljava/lang/Number;
        //    25: invokevirtual   java/lang/Number.intValue:()I
        //    28: invokestatic    gnu/kawa/slib/srfi14.isEndOfCharSet:(I)Z
        //    31: ifne            120
        //    34: aload_1         /* cs */
        //    35: aload_2         /* cursor */
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          4
        //    42: checkcast       Ljava/lang/Number;
        //    45: invokevirtual   java/lang/Number.intValue:()I
        //    48: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    51: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    54: aload_3         /* result$Mncs */
        //    55: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //    57: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    60: dup            
        //    61: astore          4
        //    63: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //    66: aload_0         /* proc */
        //    67: aload_1         /* cs */
        //    68: aload_2         /* cursor */
        //    69: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    72: dup            
        //    73: astore          4
        //    75: checkcast       Ljava/lang/Number;
        //    78: invokevirtual   java/lang/Number.intValue:()I
        //    81: invokestatic    gnu/kawa/slib/srfi14.charSetRef:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    84: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    87: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    90: dup            
        //    91: instanceof      [I
        //    94: ifeq            103
        //    97: checkcast       [I
        //   100: goto            114
        //   103: iconst_1       
        //   104: newarray        I
        //   106: dup_x1         
        //   107: swap           
        //   108: iconst_0       
        //   109: swap           
        //   110: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   113: iastore        
        //   114: invokestatic    gnu/kawa/slib/srfi14.charSetAdjoin$Ex:(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
        //   117: goto            13
        //   120: aload_3         /* result$Mncs */
        //   121: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   123: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   126: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   129: areturn        
        //   130: new             Lgnu/mapping/WrongType;
        //   133: dup_x1         
        //   134: swap           
        //   135: ldc             "end-of-char-set?"
        //   137: iconst_0       
        //   138: aload           4
        //   140: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   143: athrow         
        //   144: new             Lgnu/mapping/WrongType;
        //   147: dup_x1         
        //   148: swap           
        //   149: ldc             "char-set-cursor-next"
        //   151: iconst_1       
        //   152: aload           4
        //   154: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   157: athrow         
        //   158: new             Lgnu/mapping/WrongType;
        //   161: dup_x1         
        //   162: swap           
        //   163: ldc             "char-set-adjoin!"
        //   165: iconst_0       
        //   166: aload           4
        //   168: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   171: athrow         
        //   172: new             Lgnu/mapping/WrongType;
        //   175: dup_x1         
        //   176: swap           
        //   177: ldc             "char-set-ref"
        //   179: iconst_1       
        //   180: aload           4
        //   182: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   185: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  22     28     130    144    Ljava/lang/ClassCastException;
        //  42     48     144    158    Ljava/lang/ClassCastException;
        //  63     66     158    172    Ljava/lang/ClassCastException;
        //  75     81     172    186    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static CharSet list$To$CharSet(final LList char$Mnlist) {
        return list$To$CharSet(char$Mnlist, CharSet.empty);
    }
    
    public static CharSet list$To$CharSet(final LList char$Mnlist, final CharSet base$Mncs) {
        final Invoke make = Invoke.make;
        final int count;
        final Object[] target = new Object[(count = MakeSplice.count(char$Mnlist)) + 1];
        target[0] = CharSet.class;
        MakeSplice.copyTo(target, 1, count, char$Mnlist);
        final Object force = Promise.force(make.applyN(target), CharSet.class);
        try {
            final CharSet res$Mncs = (CharSet)force;
            return charSetUnion$Ex(res$Mncs, base$Mncs);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "res-cs", -2, force);
        }
    }
    
    public static CharSet charSetUnion$Ex(final CharSet... csets) {
        final int tmp = csets.length;
        CharSet empty = null;
        switch (tmp) {
            case 0: {
                empty = CharSet.empty;
                break;
            }
            case 1: {
                empty = csets[0];
                break;
            }
            default: {
                for (int i = 1; i != csets.length; ++i) {
                    csets[0].union$Ex(csets[i]);
                }
                empty = csets[0];
                break;
            }
        }
        return empty;
    }
    
    public static CharSet list$To$CharSet$Ex(final LList char$Mnlist, final CharSet base$Mncs) {
        final int count;
        final int[] array = new int[(count = MakeSplice.count(char$Mnlist)) + 0];
        MakeSplice.copyTo(array, 0, count, char$Mnlist, LangPrimType.characterType);
        return charSetAdjoin$Ex(base$Mncs, array);
    }
    
    public static CharSet string$To$CharSet(final String s) {
        return string$To$CharSet(s, CharSet.empty);
    }
    
    public static CharSet string$To$CharSet(final String s, final CharSet base$Mncs) {
        return list$To$CharSet(strings.string$To$List(s), base$Mncs);
    }
    
    public static CharSet string$To$CharSet$Ex(final String s, final CharSet base$Mncs) {
        return list$To$CharSet$Ex(strings.string$To$List(s), base$Mncs);
    }
    
    public static CharSet charSetFilter(final Procedure pred, final CharSet cs) {
        return charSetFilter(pred, cs, CharSet.empty);
    }
    
    public static CharSet charSetFilter(final Procedure pred, final CharSet cs, final CharSet base$Mncs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi14.charSetCursor:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //     4: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //     7: aload_2         /* base$Mncs */
        //     8: invokestatic    gnu/kawa/slib/srfi14.charSetCopy:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //    11: astore          4
        //    13: astore_3        /* cursor */
        //    14: aload_3         /* cursor */
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    18: dup            
        //    19: astore          5
        //    21: checkcast       Ljava/lang/Number;
        //    24: invokevirtual   java/lang/Number.intValue:()I
        //    27: invokestatic    gnu/kawa/slib/srfi14.isEndOfCharSet:(I)Z
        //    30: ifne            119
        //    33: aload_1         /* cs */
        //    34: aload_3         /* cursor */
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    38: dup            
        //    39: astore          5
        //    41: checkcast       Ljava/lang/Number;
        //    44: invokevirtual   java/lang/Number.intValue:()I
        //    47: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    50: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    53: aload_1         /* cs */
        //    54: aload_3         /* cursor */
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    58: dup            
        //    59: astore          6
        //    61: checkcast       Ljava/lang/Number;
        //    64: invokevirtual   java/lang/Number.intValue:()I
        //    67: invokestatic    gnu/kawa/slib/srfi14.charSetRef:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    70: istore          c
        //    72: aload_0         /* pred */
        //    73: iload           c
        //    75: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    78: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    81: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    84: ifeq            114
        //    87: aload           result$Mncs
        //    89: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //    91: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    94: dup            
        //    95: astore          6
        //    97: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   100: iconst_1       
        //   101: newarray        I
        //   103: dup            
        //   104: iconst_0       
        //   105: iload           c
        //   107: iastore        
        //   108: invokestatic    gnu/kawa/slib/srfi14.charSetAdjoin$Ex:(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
        //   111: goto            11
        //   114: aload           result$Mncs
        //   116: goto            11
        //   119: aload           result$Mncs
        //   121: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   123: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   126: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   129: areturn        
        //   130: new             Lgnu/mapping/WrongType;
        //   133: dup_x1         
        //   134: swap           
        //   135: ldc             "end-of-char-set?"
        //   137: iconst_0       
        //   138: aload           5
        //   140: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   143: athrow         
        //   144: new             Lgnu/mapping/WrongType;
        //   147: dup_x1         
        //   148: swap           
        //   149: ldc             "char-set-cursor-next"
        //   151: iconst_1       
        //   152: aload           5
        //   154: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   157: athrow         
        //   158: new             Lgnu/mapping/WrongType;
        //   161: dup_x1         
        //   162: swap           
        //   163: ldc             "char-set-ref"
        //   165: iconst_1       
        //   166: aload           6
        //   168: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   171: athrow         
        //   172: new             Lgnu/mapping/WrongType;
        //   175: dup_x1         
        //   176: swap           
        //   177: ldc             "char-set-adjoin!"
        //   179: iconst_0       
        //   180: aload           6
        //   182: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   185: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  21     27     130    144    Ljava/lang/ClassCastException;
        //  41     47     144    158    Ljava/lang/ClassCastException;
        //  61     67     158    172    Ljava/lang/ClassCastException;
        //  97     100    172    186    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static CharSet charSetFilter$Ex(final Procedure pred, final CharSet cs, final CharSet base$Mncs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi14.charSetCursor:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //     4: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //     7: aload_2         /* base$Mncs */
        //     8: astore          4
        //    10: astore_3        /* cursor */
        //    11: aload_3         /* cursor */
        //    12: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    15: dup            
        //    16: astore          5
        //    18: checkcast       Ljava/lang/Number;
        //    21: invokevirtual   java/lang/Number.intValue:()I
        //    24: invokestatic    gnu/kawa/slib/srfi14.isEndOfCharSet:(I)Z
        //    27: ifeq            43
        //    30: aload           base$Mncs
        //    32: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //    34: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    37: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //    40: goto            148
        //    43: aload_1         /* cs */
        //    44: aload_3         /* cursor */
        //    45: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    48: dup            
        //    49: astore          6
        //    51: checkcast       Ljava/lang/Number;
        //    54: invokevirtual   java/lang/Number.intValue:()I
        //    57: invokestatic    gnu/kawa/slib/srfi14.charSetRef:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    60: istore          c
        //    62: aload_0         /* pred */
        //    63: iload           c
        //    65: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    68: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    71: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    74: ifeq            124
        //    77: aload_1         /* cs */
        //    78: aload_3         /* cursor */
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    82: dup            
        //    83: astore          6
        //    85: checkcast       Ljava/lang/Number;
        //    88: invokevirtual   java/lang/Number.intValue:()I
        //    91: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    94: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    97: aload           base$Mncs
        //    99: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   101: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   104: dup            
        //   105: astore          6
        //   107: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   110: iconst_1       
        //   111: newarray        I
        //   113: dup            
        //   114: iconst_0       
        //   115: iload           c
        //   117: iastore        
        //   118: invokestatic    gnu/kawa/slib/srfi14.charSetAdjoin$Ex:(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
        //   121: goto            8
        //   124: aload_1         /* cs */
        //   125: aload_3         /* cursor */
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   129: dup            
        //   130: astore          6
        //   132: checkcast       Ljava/lang/Number;
        //   135: invokevirtual   java/lang/Number.intValue:()I
        //   138: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //   141: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   144: astore_3        /* cursor */
        //   145: goto            11
        //   148: areturn        
        //   149: new             Lgnu/mapping/WrongType;
        //   152: dup_x1         
        //   153: swap           
        //   154: ldc             "end-of-char-set?"
        //   156: iconst_0       
        //   157: aload           5
        //   159: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   162: athrow         
        //   163: new             Lgnu/mapping/WrongType;
        //   166: dup_x1         
        //   167: swap           
        //   168: ldc             "char-set-ref"
        //   170: iconst_1       
        //   171: aload           6
        //   173: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   176: athrow         
        //   177: new             Lgnu/mapping/WrongType;
        //   180: dup_x1         
        //   181: swap           
        //   182: ldc             "char-set-cursor-next"
        //   184: iconst_1       
        //   185: aload           6
        //   187: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   190: athrow         
        //   191: new             Lgnu/mapping/WrongType;
        //   194: dup_x1         
        //   195: swap           
        //   196: ldc             "char-set-adjoin!"
        //   198: iconst_0       
        //   199: aload           6
        //   201: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   204: athrow         
        //   205: new             Lgnu/mapping/WrongType;
        //   208: dup_x1         
        //   209: swap           
        //   210: ldc             "char-set-cursor-next"
        //   212: iconst_1       
        //   213: aload           6
        //   215: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   218: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     24     149    163    Ljava/lang/ClassCastException;
        //  51     57     163    177    Ljava/lang/ClassCastException;
        //  85     91     177    191    Ljava/lang/ClassCastException;
        //  107    110    191    205    Ljava/lang/ClassCastException;
        //  132    138    205    219    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static CharSet ucsRange$To$CharSet(final int n, final int n2) {
        return ucsRange$To$CharSet(n, n2, false);
    }
    
    public static CharSet ucsRange$To$CharSet(final int lower, final int upper, final boolean error$Qu) {
        return ucsRange$To$CharSet(lower, upper, error$Qu, CharSet.empty);
    }
    
    public static CharSet ucsRange$To$CharSet(final int lower, final int upper, final boolean error$Qu, final CharSet base$Mncs) {
        final CharSet set = new CharSet(new int[0]);
        set.inversion$Mnlist = new int[] { upper, lower };
        set.inversion$Mnlist$Mnsize = 2;
        final CharSet res$Mncs = set;
        return charSetUnion$Ex(res$Mncs, base$Mncs);
    }
    
    public static CharSet ucsRange$To$CharSet$Ex(final int lower, final int upper, final boolean error$Qu, final CharSet base$Mncs) {
        return base$Mncs.union$Ex(new int[] { upper, lower }, 2);
    }
    
    public static CharSet $To$CharSet(final Object x) {
        CharSet string$To$CharSet;
        if (strings.isString(x)) {
            final Object force = Promise.force(x, String.class);
            string$To$CharSet = string$To$CharSet((force == null) ? null : force.toString());
        }
        else if (x instanceof Char) {
            final CharSet set;
            string$To$CharSet = set;
            set = new CharSet((x instanceof int[]) ? x : new int[] { Char.castToCharacter(x) });
        }
        else {
            if (!(x instanceof CharSet)) {
                throw new ClassCastException("not converible to char-set");
            }
            string$To$CharSet = (CharSet)Promise.force(x, CharSet.class);
        }
        return string$To$CharSet;
    }
    
    public static int charSetSize(final CharSet cs) {
        return cs.size();
    }
    
    public static int charSetCount(final Procedure pred, final CharSet cs) {
        public class srfi14$frame extends ModuleBody
        {
            Procedure pred;
            final ModuleMethod lambda$Fn1;
            
            public srfi14$frame() {
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 8194);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi14.scm:737");
                this.lambda$Fn1 = lambda$Fn1;
            }
            
            Object lambda1(final Object x, final Object sum) {
                return KawaConvert.isTrue(this.pred.apply1(x)) ? AddOp.apply2(1, sum, srfi14.Lit1) : sum;
            }
            
            @Override
            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                if (moduleMethod.selector == 1) {
                    ctx.value1 = o;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return super.match2(moduleMethod, o, o2, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                if (method.selector == 1) {
                    return this.lambda1(o, o2);
                }
                return super.apply2(method, o, o2);
            }
        }
        final srfi14$frame $heapFrame = new srfi14$frame();
        $heapFrame.pred = pred;
        return ((Number)Promise.force(charSetFold($heapFrame.lambda$Fn1, srfi14.Lit2, cs))).intValue();
    }
    
    public static LList charSet$To$List(final CharSet cs) {
        return cs.toList();
    }
    
    public static String charSet$To$String(final CharSet cs) {
        final CharSequence list$To$String = strings.list$To$String(charSet$To$List(cs));
        return (list$To$String == null) ? null : list$To$String.toString();
    }
    
    @SourceMethodType({ "", "", "character" })
    public static boolean isCharSetContains(final CharSet cs, final int char) {
        return cs.isContains(char);
    }
    
    public static boolean charSetEvery(final Procedure pred, final CharSet cs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi14.charSetCursor:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //     4: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //     7: astore_2        /* cursor */
        //     8: aload_2         /* cursor */
        //     9: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    12: dup            
        //    13: astore          4
        //    15: checkcast       Ljava/lang/Number;
        //    18: invokevirtual   java/lang/Number.intValue:()I
        //    21: invokestatic    gnu/kawa/slib/srfi14.isEndOfCharSet:(I)Z
        //    24: istore_3        /* x */
        //    25: iload_3         /* x */
        //    26: ifeq            33
        //    29: iload_3         /* x */
        //    30: goto            87
        //    33: aload_0         /* pred */
        //    34: aload_1         /* cs */
        //    35: aload_2         /* cursor */
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          4
        //    42: checkcast       Ljava/lang/Number;
        //    45: invokevirtual   java/lang/Number.intValue:()I
        //    48: invokestatic    gnu/kawa/slib/srfi14.charSetRef:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    51: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    54: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    57: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    60: ifeq            86
        //    63: aload_1         /* cs */
        //    64: aload_2         /* cursor */
        //    65: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    68: dup            
        //    69: astore          4
        //    71: checkcast       Ljava/lang/Number;
        //    74: invokevirtual   java/lang/Number.intValue:()I
        //    77: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    80: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    83: goto            7
        //    86: iconst_0       
        //    87: ireturn        
        //    88: new             Lgnu/mapping/WrongType;
        //    91: dup_x1         
        //    92: swap           
        //    93: ldc             "end-of-char-set?"
        //    95: iconst_0       
        //    96: aload           4
        //    98: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   101: athrow         
        //   102: new             Lgnu/mapping/WrongType;
        //   105: dup_x1         
        //   106: swap           
        //   107: ldc             "char-set-ref"
        //   109: iconst_1       
        //   110: aload           4
        //   112: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   115: athrow         
        //   116: new             Lgnu/mapping/WrongType;
        //   119: dup_x1         
        //   120: swap           
        //   121: ldc             "char-set-cursor-next"
        //   123: iconst_1       
        //   124: aload           4
        //   126: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   129: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     21     88     102    Ljava/lang/ClassCastException;
        //  42     48     102    116    Ljava/lang/ClassCastException;
        //  71     77     116    130    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 65 out of bounds for length 65
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
    
    public static Object charSetAny(final Procedure pred, final CharSet cs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/srfi14.charSetCursor:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //     4: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //     7: astore_2        /* cursor */
        //     8: aload_2         /* cursor */
        //     9: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    12: dup            
        //    13: astore_3       
        //    14: checkcast       Ljava/lang/Number;
        //    17: invokevirtual   java/lang/Number.intValue:()I
        //    20: invokestatic    gnu/kawa/slib/srfi14.isEndOfCharSet:(I)Z
        //    23: ifeq            32
        //    26: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    29: goto            91
        //    32: aload_0         /* pred */
        //    33: aload_1         /* cs */
        //    34: aload_2         /* cursor */
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    38: dup            
        //    39: astore          4
        //    41: checkcast       Ljava/lang/Number;
        //    44: invokevirtual   java/lang/Number.intValue:()I
        //    47: invokestatic    gnu/kawa/slib/srfi14.charSetRef:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    50: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    53: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    56: astore_3        /* temp */
        //    57: aload_3         /* temp */
        //    58: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    61: ifeq            68
        //    64: aload_3         /* temp */
        //    65: goto            91
        //    68: aload_1         /* cs */
        //    69: aload_2         /* cursor */
        //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    73: dup            
        //    74: astore          4
        //    76: checkcast       Ljava/lang/Number;
        //    79: invokevirtual   java/lang/Number.intValue:()I
        //    82: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //    85: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    88: goto            7
        //    91: areturn        
        //    92: new             Lgnu/mapping/WrongType;
        //    95: dup_x1         
        //    96: swap           
        //    97: ldc             "end-of-char-set?"
        //    99: iconst_0       
        //   100: aload_3        
        //   101: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   104: athrow         
        //   105: new             Lgnu/mapping/WrongType;
        //   108: dup_x1         
        //   109: swap           
        //   110: ldc             "char-set-ref"
        //   112: iconst_1       
        //   113: aload           4
        //   115: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   118: athrow         
        //   119: new             Lgnu/mapping/WrongType;
        //   122: dup_x1         
        //   123: swap           
        //   124: ldc             "char-set-cursor-next"
        //   126: iconst_1       
        //   127: aload           4
        //   129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   132: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  14     20     92     105    Ljava/lang/ClassCastException;
        //  41     47     105    119    Ljava/lang/ClassCastException;
        //  76     82     119    133    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 66 out of bounds for length 66
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
    
    @SourceMethodType({ "", "", "character[]" })
    public static CharSet charSetAdjoin(final CharSet cs, final int... chars) {
        return charSetAdjoin$Ex(charSetCopy(cs), chars);
    }
    
    @SourceMethodType({ "", "", "character[]" })
    public static CharSet charSetDelete(final CharSet cs, final int... chars) {
        return charSetDelete$Ex(charSetCopy(cs), chars);
    }
    
    @SourceMethodType({ "", "", "character[]" })
    public static CharSet charSetDelete$Ex(final CharSet cs, final int... chars) {
        final int tmp = chars.length;
        switch (tmp) {
            case 0: {
                return cs;
            }
            case 1: {
                return cs.delete$Ex(chars[0]);
            }
        }
        final Invoke make = Invoke.make;
        final int count;
        final Object[] target = new Object[(count = MakeSplice.count(chars)) + 1];
        target[0] = CharSet.class;
        MakeSplice.copyTo(target, 1, count, chars);
        final Object force = Promise.force(make.applyN(target), CharSet.class);
        try {
            final CharSet to$Mnremove = (CharSet)force;
            return cs.intersection$Ex(to$Mnremove.complement$Ex());
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "to-remove", -2, force);
        }
    }
    
    public static CharSet charSetComplement(final CharSet cs) {
        return charSetComplement$Ex(charSetCopy(cs));
    }
    
    public static CharSet charSetComplement$Ex(final CharSet cs) {
        return cs.complement$Ex();
    }
    
    public static CharSet charSetUnion(final CharSet... csets) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_1        /* tmp */
        //     3: iload_1         /* tmp */
        //     4: tableswitch {
        //                0: 28
        //                1: 34
        //          default: 40
        //        }
        //    28: getstatic       gnu/kawa/slib/srfi14$CharSet.empty:Lgnu/kawa/slib/srfi14$CharSet;
        //    31: goto            73
        //    34: aload_0         /* csets */
        //    35: iconst_0       
        //    36: aaload         
        //    37: goto            73
        //    40: aload_0         /* csets */
        //    41: iconst_0       
        //    42: aaload         
        //    43: invokestatic    gnu/kawa/slib/srfi14.charSetCopy:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //    46: iconst_1       
        //    47: istore_3       
        //    48: astore_2        /* cs */
        //    49: iload_3         /* i */
        //    50: aload_0         /* csets */
        //    51: arraylength    
        //    52: if_icmpeq       69
        //    55: aload_2         /* cs */
        //    56: aload_0         /* csets */
        //    57: iload_3         /* i */
        //    58: aaload         
        //    59: invokevirtual   gnu/kawa/slib/srfi14$CharSet.union$Ex:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //    62: pop            
        //    63: iinc            i, 1
        //    66: goto            49
        //    69: aload_2         /* cs */
        //    70: goto            73
        //    73: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static CharSet charSetIntersection(final CharSet... csets) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_1        /* tmp */
        //     3: iload_1         /* tmp */
        //     4: tableswitch {
        //                0: 28
        //                1: 34
        //          default: 40
        //        }
        //    28: getstatic       gnu/kawa/slib/srfi14$CharSet.full:Lgnu/kawa/slib/srfi14$CharSet;
        //    31: goto            73
        //    34: aload_0         /* csets */
        //    35: iconst_0       
        //    36: aaload         
        //    37: goto            73
        //    40: aload_0         /* csets */
        //    41: iconst_0       
        //    42: aaload         
        //    43: invokestatic    gnu/kawa/slib/srfi14.charSetCopy:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //    46: iconst_1       
        //    47: istore_3       
        //    48: astore_2        /* cs */
        //    49: iload_3         /* i */
        //    50: aload_0         /* csets */
        //    51: arraylength    
        //    52: if_icmpeq       69
        //    55: aload_2         /* cs */
        //    56: aload_0         /* csets */
        //    57: iload_3         /* i */
        //    58: aaload         
        //    59: invokevirtual   gnu/kawa/slib/srfi14$CharSet.intersection$Ex:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //    62: pop            
        //    63: iinc            i, 1
        //    66: goto            49
        //    69: aload_2         /* cs */
        //    70: goto            73
        //    73: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static CharSet charSetDifference(final CharSet cs1, final CharSet... csets) {
        CharSet charSetIntersection;
        if (csets.length == 0) {
            charSetIntersection = cs1;
        }
        else {
            final CharSet rest = charSetUnion(csets);
            charSetIntersection = charSetIntersection(cs1, charSetComplement(rest));
        }
        return charSetIntersection;
    }
    
    public static CharSet charSetXor(final CharSet... csets) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_1        /* tmp */
        //     3: iload_1         /* tmp */
        //     4: tableswitch {
        //                0: 28
        //                1: 34
        //          default: 40
        //        }
        //    28: getstatic       gnu/kawa/slib/srfi14$CharSet.empty:Lgnu/kawa/slib/srfi14$CharSet;
        //    31: goto            73
        //    34: aload_0         /* csets */
        //    35: iconst_0       
        //    36: aaload         
        //    37: goto            73
        //    40: aload_0         /* csets */
        //    41: iconst_0       
        //    42: aaload         
        //    43: invokestatic    gnu/kawa/slib/srfi14.charSetCopy:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //    46: iconst_1       
        //    47: istore_3       
        //    48: astore_2        /* cs */
        //    49: iload_3         /* i */
        //    50: aload_0         /* csets */
        //    51: arraylength    
        //    52: if_icmpeq       69
        //    55: aload_2         /* cs */
        //    56: aload_0         /* csets */
        //    57: iload_3         /* i */
        //    58: aaload         
        //    59: invokevirtual   gnu/kawa/slib/srfi14$CharSet.xor$Ex:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //    62: pop            
        //    63: iinc            i, 1
        //    66: goto            49
        //    69: aload_2         /* cs */
        //    70: goto            73
        //    73: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values charSetDiff$PlIntersection(final CharSet cs1, final CharSet cs2, final CharSet... csets) {
        final int count;
        final CharSet[] array = new CharSet[(count = MakeSplice.count(csets)) + 1];
        array[0] = cs2;
        MakeSplice.copyTo(array, 1, count, csets, srfi14.Lit3);
        final CharSet union = charSetUnion(array);
        return Values.values2(charSetIntersection(cs1, charSetComplement(union)), charSetIntersection(cs1, union));
    }
    
    public static CharSet charSetIntersection$Ex(final CharSet... csets) {
        final int tmp = csets.length;
        CharSet full = null;
        switch (tmp) {
            case 0: {
                full = CharSet.full;
                break;
            }
            case 1: {
                full = csets[0];
                break;
            }
            default: {
                for (int i = 1; i != csets.length; ++i) {
                    csets[0].intersection$Ex(csets[i]);
                }
                full = csets[0];
                break;
            }
        }
        return full;
    }
    
    public static CharSet charSetDifference$Ex(final CharSet cs1, final CharSet... csets) {
        CharSet charSetIntersection$Ex;
        if (csets.length == 0) {
            charSetIntersection$Ex = cs1;
        }
        else {
            final CharSet rest = charSetUnion(csets);
            charSetIntersection$Ex = charSetIntersection$Ex(cs1, charSetComplement(rest));
        }
        return charSetIntersection$Ex;
    }
    
    public static CharSet charSetXor$Ex(final CharSet... csets) {
        final int tmp = csets.length;
        CharSet empty = null;
        switch (tmp) {
            case 0: {
                empty = CharSet.empty;
                break;
            }
            case 1: {
                empty = csets[0];
                break;
            }
            default: {
                for (int i = 1; i != csets.length; ++i) {
                    csets[0].xor$Ex(csets[i]);
                }
                empty = csets[0];
                break;
            }
        }
        return empty;
    }
    
    static LList $PcBoundaryPairsIntersection(final LList l1, final LList l2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: istore_2        /* x */
        //     5: iload_2         /* x */
        //     6: ifeq            16
        //     9: iload_2         /* x */
        //    10: ifeq            29
        //    13: goto            23
        //    16: aload_1         /* l2 */
        //    17: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    20: ifeq            29
        //    23: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    26: goto            503
        //    29: aload_0         /* l1 */
        //    30: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: aload_1         /* l2 */
        //    34: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    37: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    40: ifeq            70
        //    43: aload_0         /* l1 */
        //    44: dup            
        //    45: astore_3       
        //    46: checkcast       Lgnu/lists/Pair;
        //    49: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    52: ldc_w           Lgnu/lists/LList;.class
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    58: dup            
        //    59: astore_3       
        //    60: checkcast       Lgnu/lists/LList;
        //    63: aload_1         /* l2 */
        //    64: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsIntersection:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //    67: goto            503
        //    70: aload_1         /* l2 */
        //    71: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: aload_0         /* l1 */
        //    75: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    78: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    81: ifeq            111
        //    84: aload_0         /* l1 */
        //    85: aload_1         /* l2 */
        //    86: dup            
        //    87: astore_3       
        //    88: checkcast       Lgnu/lists/Pair;
        //    91: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    94: ldc_w           Lgnu/lists/LList;.class
        //    97: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   100: dup            
        //   101: astore_3       
        //   102: checkcast       Lgnu/lists/LList;
        //   105: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsIntersection:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   108: goto            503
        //   111: aload_0         /* l1 */
        //   112: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   118: dup            
        //   119: astore          4
        //   121: checkcast       Ljava/lang/Number;
        //   124: invokevirtual   java/lang/Number.intValue:()I
        //   127: istore_3       
        //   128: aload_0         /* l1 */
        //   129: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   132: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   135: dup            
        //   136: astore          5
        //   138: checkcast       Ljava/lang/Number;
        //   141: invokevirtual   java/lang/Number.intValue:()I
        //   144: istore          4
        //   146: aload_1         /* l2 */
        //   147: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   153: dup            
        //   154: astore          6
        //   156: checkcast       Ljava/lang/Number;
        //   159: invokevirtual   java/lang/Number.intValue:()I
        //   162: istore          5
        //   164: aload_1         /* l2 */
        //   165: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   168: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   171: dup            
        //   172: astore          7
        //   174: checkcast       Ljava/lang/Number;
        //   177: invokevirtual   java/lang/Number.intValue:()I
        //   180: istore          l2b
        //   182: iload_3         /* l1a */
        //   183: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   186: iload           l2a
        //   188: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   191: iload           l1b
        //   193: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   196: iconst_1       
        //   197: anewarray       Ljava/lang/Object;
        //   200: dup            
        //   201: iconst_0       
        //   202: iload           l2b
        //   204: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   207: aastore        
        //   208: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
        //   211: ifeq            337
        //   214: iconst_2       
        //   215: anewarray       Ljava/lang/Object;
        //   218: dup            
        //   219: iconst_0       
        //   220: iload           l2a
        //   222: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   225: aastore        
        //   226: dup            
        //   227: iconst_1       
        //   228: iload           l1b
        //   230: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   233: aastore        
        //   234: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   237: iconst_2       
        //   238: anewarray       Ljava/lang/Object;
        //   241: dup            
        //   242: iconst_0       
        //   243: iconst_2       
        //   244: anewarray       Ljava/lang/Object;
        //   247: dup            
        //   248: iconst_0       
        //   249: iload_3         /* l1a */
        //   250: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   253: aastore        
        //   254: dup            
        //   255: iconst_1       
        //   256: iload           l2a
        //   258: iconst_1       
        //   259: isub           
        //   260: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   263: aastore        
        //   264: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   267: iconst_2       
        //   268: anewarray       Ljava/lang/Object;
        //   271: dup            
        //   272: iconst_0       
        //   273: aload_0         /* l1 */
        //   274: dup            
        //   275: astore          7
        //   277: checkcast       Lgnu/lists/Pair;
        //   280: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   283: aastore        
        //   284: dup            
        //   285: iconst_1       
        //   286: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   289: aastore        
        //   290: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   293: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   296: aload_1         /* l2 */
        //   297: dup            
        //   298: astore          7
        //   300: checkcast       Lgnu/lists/Pair;
        //   303: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   306: ldc_w           Lgnu/lists/LList;.class
        //   309: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   312: dup            
        //   313: astore          7
        //   315: checkcast       Lgnu/lists/LList;
        //   318: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsIntersection:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   321: aastore        
        //   322: dup            
        //   323: iconst_1       
        //   324: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   327: aastore        
        //   328: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   331: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   334: goto            503
        //   337: iload_3         /* l1a */
        //   338: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   341: iload           l2a
        //   343: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   346: iload           l2b
        //   348: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   351: iconst_1       
        //   352: anewarray       Ljava/lang/Object;
        //   355: dup            
        //   356: iconst_0       
        //   357: iload           l1b
        //   359: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   362: aastore        
        //   363: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
        //   366: ifeq            498
        //   369: iconst_2       
        //   370: anewarray       Ljava/lang/Object;
        //   373: dup            
        //   374: iconst_0       
        //   375: aload_1         /* l2 */
        //   376: dup            
        //   377: astore          7
        //   379: checkcast       Lgnu/lists/Pair;
        //   382: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   385: aastore        
        //   386: dup            
        //   387: iconst_1       
        //   388: iconst_2       
        //   389: anewarray       Ljava/lang/Object;
        //   392: dup            
        //   393: iconst_0       
        //   394: iconst_2       
        //   395: anewarray       Ljava/lang/Object;
        //   398: dup            
        //   399: iconst_0       
        //   400: iload_3         /* l1a */
        //   401: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   404: aastore        
        //   405: dup            
        //   406: iconst_1       
        //   407: iload           l2a
        //   409: iconst_1       
        //   410: isub           
        //   411: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   414: aastore        
        //   415: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   418: iconst_2       
        //   419: anewarray       Ljava/lang/Object;
        //   422: dup            
        //   423: iconst_0       
        //   424: aload_0         /* l1 */
        //   425: dup            
        //   426: astore          7
        //   428: checkcast       Lgnu/lists/Pair;
        //   431: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   434: aastore        
        //   435: dup            
        //   436: iconst_1       
        //   437: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   440: aastore        
        //   441: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   444: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   447: aload_1         /* l2 */
        //   448: dup            
        //   449: astore          7
        //   451: checkcast       Lgnu/lists/Pair;
        //   454: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   457: ldc_w           Lgnu/lists/LList;.class
        //   460: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   463: dup            
        //   464: astore          7
        //   466: checkcast       Lgnu/lists/LList;
        //   469: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsIntersection:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   472: aastore        
        //   473: dup            
        //   474: iconst_1       
        //   475: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   478: aastore        
        //   479: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   482: aastore        
        //   483: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   486: ldc_w           Lgnu/lists/LList;.class
        //   489: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   492: checkcast       Lgnu/lists/LList;
        //   495: goto            503
        //   498: aload_1         /* l2 */
        //   499: aload_0         /* l1 */
        //   500: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsIntersection:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   503: areturn        
        //   504: new             Lgnu/mapping/WrongType;
        //   507: dup_x1         
        //   508: swap           
        //   509: ldc_w           "cdr"
        //   512: iconst_1       
        //   513: aload_3        
        //   514: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   517: athrow         
        //   518: new             Lgnu/mapping/WrongType;
        //   521: dup_x1         
        //   522: swap           
        //   523: ldc_w           "%boundary-pairs-intersection"
        //   526: iconst_0       
        //   527: aload_3        
        //   528: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   531: athrow         
        //   532: new             Lgnu/mapping/WrongType;
        //   535: dup_x1         
        //   536: swap           
        //   537: ldc_w           "cdr"
        //   540: iconst_1       
        //   541: aload_3        
        //   542: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   545: athrow         
        //   546: new             Lgnu/mapping/WrongType;
        //   549: dup_x1         
        //   550: swap           
        //   551: ldc_w           "%boundary-pairs-intersection"
        //   554: iconst_1       
        //   555: aload_3        
        //   556: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   559: athrow         
        //   560: new             Lgnu/mapping/WrongType;
        //   563: dup_x1         
        //   564: swap           
        //   565: ldc_w           "l1a"
        //   568: bipush          -2
        //   570: aload           4
        //   572: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   575: athrow         
        //   576: new             Lgnu/mapping/WrongType;
        //   579: dup_x1         
        //   580: swap           
        //   581: ldc_w           "l1b"
        //   584: bipush          -2
        //   586: aload           5
        //   588: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   591: athrow         
        //   592: new             Lgnu/mapping/WrongType;
        //   595: dup_x1         
        //   596: swap           
        //   597: ldc_w           "l2a"
        //   600: bipush          -2
        //   602: aload           6
        //   604: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   607: athrow         
        //   608: new             Lgnu/mapping/WrongType;
        //   611: dup_x1         
        //   612: swap           
        //   613: ldc_w           "l2b"
        //   616: bipush          -2
        //   618: aload           7
        //   620: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   623: athrow         
        //   624: new             Lgnu/mapping/WrongType;
        //   627: dup_x1         
        //   628: swap           
        //   629: ldc_w           "cdr"
        //   632: iconst_1       
        //   633: aload           7
        //   635: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   638: athrow         
        //   639: new             Lgnu/mapping/WrongType;
        //   642: dup_x1         
        //   643: swap           
        //   644: ldc_w           "cdr"
        //   647: iconst_1       
        //   648: aload           7
        //   650: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   653: athrow         
        //   654: new             Lgnu/mapping/WrongType;
        //   657: dup_x1         
        //   658: swap           
        //   659: ldc_w           "%boundary-pairs-intersection"
        //   662: iconst_1       
        //   663: aload           7
        //   665: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   668: athrow         
        //   669: new             Lgnu/mapping/WrongType;
        //   672: dup_x1         
        //   673: swap           
        //   674: ldc_w           "car"
        //   677: iconst_1       
        //   678: aload           7
        //   680: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   683: athrow         
        //   684: new             Lgnu/mapping/WrongType;
        //   687: dup_x1         
        //   688: swap           
        //   689: ldc_w           "cdr"
        //   692: iconst_1       
        //   693: aload           7
        //   695: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   698: athrow         
        //   699: new             Lgnu/mapping/WrongType;
        //   702: dup_x1         
        //   703: swap           
        //   704: ldc_w           "cdr"
        //   707: iconst_1       
        //   708: aload           7
        //   710: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   713: athrow         
        //   714: new             Lgnu/mapping/WrongType;
        //   717: dup_x1         
        //   718: swap           
        //   719: ldc_w           "%boundary-pairs-intersection"
        //   722: iconst_1       
        //   723: aload           7
        //   725: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   728: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  46     49     504    518    Ljava/lang/ClassCastException;
        //  60     63     518    532    Ljava/lang/ClassCastException;
        //  88     91     532    546    Ljava/lang/ClassCastException;
        //  102    105    546    560    Ljava/lang/ClassCastException;
        //  121    127    560    576    Ljava/lang/ClassCastException;
        //  138    144    576    592    Ljava/lang/ClassCastException;
        //  156    162    592    608    Ljava/lang/ClassCastException;
        //  174    180    608    624    Ljava/lang/ClassCastException;
        //  277    280    624    639    Ljava/lang/ClassCastException;
        //  300    303    639    654    Ljava/lang/ClassCastException;
        //  315    318    654    669    Ljava/lang/ClassCastException;
        //  379    382    669    684    Ljava/lang/ClassCastException;
        //  428    431    684    699    Ljava/lang/ClassCastException;
        //  451    454    699    714    Ljava/lang/ClassCastException;
        //  466    469    714    729    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static LList $PcBoundaryPairsUnion(final LList l1, final LList l2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            11
        //     7: aload_1         /* l2 */
        //     8: goto            447
        //    11: aload_1         /* l2 */
        //    12: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    15: ifeq            22
        //    18: aload_0         /* l1 */
        //    19: goto            447
        //    22: aload_1         /* l2 */
        //    23: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    26: aload_0         /* l1 */
        //    27: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    33: istore_2        /* x */
        //    34: iload_2         /* x */
        //    35: ifeq            45
        //    38: iload_2         /* x */
        //    39: ifeq            95
        //    42: goto            87
        //    45: aload_1         /* l2 */
        //    46: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    49: aload_0         /* l1 */
        //    50: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    53: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    56: ifeq            95
        //    59: aload_1         /* l2 */
        //    60: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    63: aload_0         /* l1 */
        //    64: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    67: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    70: ifeq            95
        //    73: aload_1         /* l2 */
        //    74: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: aload_0         /* l1 */
        //    78: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    81: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    84: ifeq            95
        //    87: aload_1         /* l2 */
        //    88: aload_0         /* l1 */
        //    89: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsUnion:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //    92: goto            447
        //    95: aload_0         /* l1 */
        //    96: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    99: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   102: dup            
        //   103: astore          4
        //   105: checkcast       Ljava/lang/Number;
        //   108: invokevirtual   java/lang/Number.intValue:()I
        //   111: istore_3        /* ending */
        //   112: aload_0         /* l1 */
        //   113: aload_1         /* l2 */
        //   114: astore          5
        //   116: astore          l1
        //   118: aload           l2
        //   120: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   123: ifeq            198
        //   126: iconst_2       
        //   127: anewarray       Ljava/lang/Object;
        //   130: dup            
        //   131: iconst_0       
        //   132: aload           l1
        //   134: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   137: aastore        
        //   138: dup            
        //   139: iconst_1       
        //   140: iload_3         /* ending */
        //   141: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   144: aastore        
        //   145: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   148: iconst_2       
        //   149: anewarray       Ljava/lang/Object;
        //   152: dup            
        //   153: iconst_0       
        //   154: aload           l1
        //   156: dup            
        //   157: astore          6
        //   159: checkcast       Lgnu/lists/Pair;
        //   162: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   165: ldc_w           Lgnu/lists/LList;.class
        //   168: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   171: dup            
        //   172: astore          6
        //   174: checkcast       Lgnu/lists/LList;
        //   177: aload           l2
        //   179: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsUnion:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   182: aastore        
        //   183: dup            
        //   184: iconst_1       
        //   185: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   188: aastore        
        //   189: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   192: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   195: goto            447
        //   198: aload           l2
        //   200: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   203: iconst_m1      
        //   204: aload           l1
        //   206: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   209: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   212: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   215: iconst_m1      
        //   216: aload           l2
        //   218: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   221: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   224: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   227: iconst_0       
        //   228: anewarray       Ljava/lang/Object;
        //   231: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
        //   234: ifeq            262
        //   237: aload           l2
        //   239: aload           l1
        //   241: dup            
        //   242: astore          6
        //   244: checkcast       Lgnu/lists/Pair;
        //   247: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   250: ldc_w           Lgnu/lists/LList;.class
        //   253: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   256: checkcast       Lgnu/lists/LList;
        //   259: goto            114
        //   262: aload           l2
        //   264: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   267: iconst_m1      
        //   268: aload           l1
        //   270: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   273: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   276: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   279: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   282: ifeq            378
        //   285: iconst_2       
        //   286: anewarray       Ljava/lang/Object;
        //   289: dup            
        //   290: iconst_0       
        //   291: aload           l1
        //   293: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   296: aastore        
        //   297: dup            
        //   298: iconst_1       
        //   299: iload_3         /* ending */
        //   300: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   303: aastore        
        //   304: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   307: iconst_2       
        //   308: anewarray       Ljava/lang/Object;
        //   311: dup            
        //   312: iconst_0       
        //   313: aload           l1
        //   315: dup            
        //   316: astore          6
        //   318: checkcast       Lgnu/lists/Pair;
        //   321: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   324: ldc_w           Lgnu/lists/LList;.class
        //   327: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   330: dup            
        //   331: astore          6
        //   333: checkcast       Lgnu/lists/LList;
        //   336: aload           l2
        //   338: dup            
        //   339: astore          6
        //   341: checkcast       Lgnu/lists/Pair;
        //   344: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   347: ldc_w           Lgnu/lists/LList;.class
        //   350: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   353: dup            
        //   354: astore          6
        //   356: checkcast       Lgnu/lists/LList;
        //   359: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsUnion:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   362: aastore        
        //   363: dup            
        //   364: iconst_1       
        //   365: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   368: aastore        
        //   369: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   372: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   375: goto            447
        //   378: iconst_2       
        //   379: anewarray       Ljava/lang/Object;
        //   382: dup            
        //   383: iconst_0       
        //   384: aload           l1
        //   386: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   389: aastore        
        //   390: dup            
        //   391: iconst_1       
        //   392: iload_3         /* ending */
        //   393: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   396: aastore        
        //   397: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   400: iconst_2       
        //   401: anewarray       Ljava/lang/Object;
        //   404: dup            
        //   405: iconst_0       
        //   406: aload           l1
        //   408: dup            
        //   409: astore          6
        //   411: checkcast       Lgnu/lists/Pair;
        //   414: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   417: ldc_w           Lgnu/lists/LList;.class
        //   420: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   423: dup            
        //   424: astore          6
        //   426: checkcast       Lgnu/lists/LList;
        //   429: aload           l2
        //   431: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsUnion:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   434: aastore        
        //   435: dup            
        //   436: iconst_1       
        //   437: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   440: aastore        
        //   441: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   444: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   447: areturn        
        //   448: new             Lgnu/mapping/WrongType;
        //   451: dup_x1         
        //   452: swap           
        //   453: ldc_w           "ending"
        //   456: bipush          -2
        //   458: aload           4
        //   460: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   463: athrow         
        //   464: new             Lgnu/mapping/WrongType;
        //   467: dup_x1         
        //   468: swap           
        //   469: ldc_w           "cdr"
        //   472: iconst_1       
        //   473: aload           6
        //   475: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   478: athrow         
        //   479: new             Lgnu/mapping/WrongType;
        //   482: dup_x1         
        //   483: swap           
        //   484: ldc_w           "%boundary-pairs-union"
        //   487: iconst_0       
        //   488: aload           6
        //   490: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   493: athrow         
        //   494: new             Lgnu/mapping/WrongType;
        //   497: dup_x1         
        //   498: swap           
        //   499: ldc_w           "cdr"
        //   502: iconst_1       
        //   503: aload           6
        //   505: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   508: athrow         
        //   509: new             Lgnu/mapping/WrongType;
        //   512: dup_x1         
        //   513: swap           
        //   514: ldc_w           "cdr"
        //   517: iconst_1       
        //   518: aload           6
        //   520: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   523: athrow         
        //   524: new             Lgnu/mapping/WrongType;
        //   527: dup_x1         
        //   528: swap           
        //   529: ldc_w           "%boundary-pairs-union"
        //   532: iconst_0       
        //   533: aload           6
        //   535: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   538: athrow         
        //   539: new             Lgnu/mapping/WrongType;
        //   542: dup_x1         
        //   543: swap           
        //   544: ldc_w           "cdr"
        //   547: iconst_1       
        //   548: aload           6
        //   550: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   553: athrow         
        //   554: new             Lgnu/mapping/WrongType;
        //   557: dup_x1         
        //   558: swap           
        //   559: ldc_w           "%boundary-pairs-union"
        //   562: iconst_1       
        //   563: aload           6
        //   565: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   568: athrow         
        //   569: new             Lgnu/mapping/WrongType;
        //   572: dup_x1         
        //   573: swap           
        //   574: ldc_w           "cdr"
        //   577: iconst_1       
        //   578: aload           6
        //   580: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   583: athrow         
        //   584: new             Lgnu/mapping/WrongType;
        //   587: dup_x1         
        //   588: swap           
        //   589: ldc_w           "%boundary-pairs-union"
        //   592: iconst_0       
        //   593: aload           6
        //   595: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   598: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  105    111    448    464    Ljava/lang/ClassCastException;
        //  159    162    464    479    Ljava/lang/ClassCastException;
        //  174    177    479    494    Ljava/lang/ClassCastException;
        //  244    247    494    509    Ljava/lang/ClassCastException;
        //  318    321    509    524    Ljava/lang/ClassCastException;
        //  333    336    524    539    Ljava/lang/ClassCastException;
        //  341    344    539    554    Ljava/lang/ClassCastException;
        //  356    359    554    569    Ljava/lang/ClassCastException;
        //  411    414    569    584    Ljava/lang/ClassCastException;
        //  426    429    584    599    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static LList $PcBoundaryPairsXor(final LList l1, final LList l2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            11
        //     7: aload_1         /* l2 */
        //     8: goto            821
        //    11: aload_1         /* l2 */
        //    12: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    15: ifeq            22
        //    18: aload_0         /* l1 */
        //    19: goto            821
        //    22: aload_0         /* l1 */
        //    23: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    26: iconst_1       
        //    27: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //    30: aload_1         /* l2 */
        //    31: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    34: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    37: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    40: ifeq            117
        //    43: iconst_2       
        //    44: anewarray       Ljava/lang/Object;
        //    47: dup            
        //    48: iconst_0       
        //    49: aload_0         /* l1 */
        //    50: dup            
        //    51: astore_2       
        //    52: checkcast       Lgnu/lists/Pair;
        //    55: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    58: aastore        
        //    59: dup            
        //    60: iconst_1       
        //    61: iconst_2       
        //    62: anewarray       Ljava/lang/Object;
        //    65: dup            
        //    66: iconst_0       
        //    67: aload_0         /* l1 */
        //    68: dup            
        //    69: astore_2       
        //    70: checkcast       Lgnu/lists/Pair;
        //    73: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    76: ldc_w           Lgnu/lists/LList;.class
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    82: dup            
        //    83: astore_2       
        //    84: checkcast       Lgnu/lists/LList;
        //    87: aload_1         /* l2 */
        //    88: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //    91: aastore        
        //    92: dup            
        //    93: iconst_1       
        //    94: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    97: aastore        
        //    98: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   101: aastore        
        //   102: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   105: ldc_w           Lgnu/lists/LList;.class
        //   108: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   111: checkcast       Lgnu/lists/LList;
        //   114: goto            821
        //   117: aload_1         /* l2 */
        //   118: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   121: iconst_1       
        //   122: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   125: aload_0         /* l1 */
        //   126: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   129: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   132: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   135: ifeq            212
        //   138: iconst_2       
        //   139: anewarray       Ljava/lang/Object;
        //   142: dup            
        //   143: iconst_0       
        //   144: aload_1         /* l2 */
        //   145: dup            
        //   146: astore_2       
        //   147: checkcast       Lgnu/lists/Pair;
        //   150: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   153: aastore        
        //   154: dup            
        //   155: iconst_1       
        //   156: iconst_2       
        //   157: anewarray       Ljava/lang/Object;
        //   160: dup            
        //   161: iconst_0       
        //   162: aload_0         /* l1 */
        //   163: aload_1         /* l2 */
        //   164: dup            
        //   165: astore_2       
        //   166: checkcast       Lgnu/lists/Pair;
        //   169: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   172: ldc_w           Lgnu/lists/LList;.class
        //   175: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   178: dup            
        //   179: astore_2       
        //   180: checkcast       Lgnu/lists/LList;
        //   183: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   186: aastore        
        //   187: dup            
        //   188: iconst_1       
        //   189: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   192: aastore        
        //   193: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   196: aastore        
        //   197: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   200: ldc_w           Lgnu/lists/LList;.class
        //   203: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   206: checkcast       Lgnu/lists/LList;
        //   209: goto            821
        //   212: aload_0         /* l1 */
        //   213: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   216: iconst_1       
        //   217: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   220: aload_1         /* l2 */
        //   221: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   224: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   227: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   230: ifeq            282
        //   233: aload_1         /* l2 */
        //   234: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   237: aload_0         /* l1 */
        //   238: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   241: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   244: aload_0         /* l1 */
        //   245: dup            
        //   246: astore_2       
        //   247: checkcast       Lgnu/lists/Pair;
        //   250: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   253: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   256: aload_1         /* l2 */
        //   257: dup            
        //   258: astore_2       
        //   259: checkcast       Lgnu/lists/Pair;
        //   262: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   265: ldc_w           Lgnu/lists/LList;.class
        //   268: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   271: dup            
        //   272: astore_2       
        //   273: checkcast       Lgnu/lists/LList;
        //   276: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   279: goto            821
        //   282: aload_1         /* l2 */
        //   283: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   286: iconst_1       
        //   287: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   290: aload_0         /* l1 */
        //   291: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   294: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   297: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   300: ifeq            352
        //   303: aload_0         /* l1 */
        //   304: dup            
        //   305: astore_2       
        //   306: checkcast       Lgnu/lists/Pair;
        //   309: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   312: ldc_w           Lgnu/lists/LList;.class
        //   315: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   318: dup            
        //   319: astore_2       
        //   320: checkcast       Lgnu/lists/LList;
        //   323: aload_0         /* l1 */
        //   324: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   327: aload_1         /* l2 */
        //   328: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   331: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   334: aload_1         /* l2 */
        //   335: dup            
        //   336: astore_2       
        //   337: checkcast       Lgnu/lists/Pair;
        //   340: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   343: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   346: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   349: goto            821
        //   352: aload_0         /* l1 */
        //   353: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   356: aload_1         /* l2 */
        //   357: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   360: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   363: ifeq            469
        //   366: iconst_2       
        //   367: anewarray       Ljava/lang/Object;
        //   370: dup            
        //   371: iconst_0       
        //   372: iconst_1       
        //   373: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   376: aload_1         /* l2 */
        //   377: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   380: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   383: aastore        
        //   384: dup            
        //   385: iconst_1       
        //   386: aload_0         /* l1 */
        //   387: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   390: aastore        
        //   391: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   394: iconst_2       
        //   395: anewarray       Ljava/lang/Object;
        //   398: dup            
        //   399: iconst_0       
        //   400: iconst_2       
        //   401: anewarray       Ljava/lang/Object;
        //   404: dup            
        //   405: iconst_0       
        //   406: aload_0         /* l1 */
        //   407: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   410: aastore        
        //   411: dup            
        //   412: iconst_1       
        //   413: aload_1         /* l2 */
        //   414: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   417: aastore        
        //   418: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   421: iconst_2       
        //   422: anewarray       Ljava/lang/Object;
        //   425: dup            
        //   426: iconst_0       
        //   427: aload_0         /* l1 */
        //   428: dup            
        //   429: astore_2       
        //   430: checkcast       Lgnu/lists/Pair;
        //   433: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   436: aastore        
        //   437: dup            
        //   438: iconst_1       
        //   439: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   442: aastore        
        //   443: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   446: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   449: aload_1         /* l2 */
        //   450: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   453: aastore        
        //   454: dup            
        //   455: iconst_1       
        //   456: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   459: aastore        
        //   460: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   463: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   466: goto            821
        //   469: aload_1         /* l2 */
        //   470: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   473: aload_0         /* l1 */
        //   474: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   477: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   480: ifeq            586
        //   483: iconst_2       
        //   484: anewarray       Ljava/lang/Object;
        //   487: dup            
        //   488: iconst_0       
        //   489: iconst_1       
        //   490: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   493: aload_0         /* l1 */
        //   494: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   497: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   500: aastore        
        //   501: dup            
        //   502: iconst_1       
        //   503: aload_1         /* l2 */
        //   504: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   507: aastore        
        //   508: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   511: iconst_2       
        //   512: anewarray       Ljava/lang/Object;
        //   515: dup            
        //   516: iconst_0       
        //   517: iconst_2       
        //   518: anewarray       Ljava/lang/Object;
        //   521: dup            
        //   522: iconst_0       
        //   523: aload_1         /* l2 */
        //   524: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   527: aastore        
        //   528: dup            
        //   529: iconst_1       
        //   530: aload_0         /* l1 */
        //   531: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   534: aastore        
        //   535: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   538: iconst_2       
        //   539: anewarray       Ljava/lang/Object;
        //   542: dup            
        //   543: iconst_0       
        //   544: aload_1         /* l2 */
        //   545: dup            
        //   546: astore_2       
        //   547: checkcast       Lgnu/lists/Pair;
        //   550: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   553: aastore        
        //   554: dup            
        //   555: iconst_1       
        //   556: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   559: aastore        
        //   560: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   563: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   566: aload_0         /* l1 */
        //   567: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   570: aastore        
        //   571: dup            
        //   572: iconst_1       
        //   573: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   576: aastore        
        //   577: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   580: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   583: goto            821
        //   586: aload_0         /* l1 */
        //   587: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   590: aload_1         /* l2 */
        //   591: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   594: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   597: ifeq            682
        //   600: aload_0         /* l1 */
        //   601: dup            
        //   602: astore_2       
        //   603: checkcast       Lgnu/lists/Pair;
        //   606: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   609: ldc_w           Lgnu/lists/LList;.class
        //   612: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   615: dup            
        //   616: astore_2       
        //   617: checkcast       Lgnu/lists/LList;
        //   620: iconst_2       
        //   621: anewarray       Ljava/lang/Object;
        //   624: dup            
        //   625: iconst_0       
        //   626: aload_1         /* l2 */
        //   627: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   630: aastore        
        //   631: dup            
        //   632: iconst_1       
        //   633: iconst_m1      
        //   634: aload_0         /* l1 */
        //   635: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   638: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   641: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   644: aastore        
        //   645: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   648: iconst_2       
        //   649: anewarray       Ljava/lang/Object;
        //   652: dup            
        //   653: iconst_0       
        //   654: aload_1         /* l2 */
        //   655: dup            
        //   656: astore_2       
        //   657: checkcast       Lgnu/lists/Pair;
        //   660: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   663: aastore        
        //   664: dup            
        //   665: iconst_1       
        //   666: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   669: aastore        
        //   670: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   673: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   676: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   679: goto            821
        //   682: aload_1         /* l2 */
        //   683: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   686: aload_0         /* l1 */
        //   687: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   690: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   693: ifeq            778
        //   696: aload_1         /* l2 */
        //   697: dup            
        //   698: astore_2       
        //   699: checkcast       Lgnu/lists/Pair;
        //   702: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   705: ldc_w           Lgnu/lists/LList;.class
        //   708: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   711: dup            
        //   712: astore_2       
        //   713: checkcast       Lgnu/lists/LList;
        //   716: iconst_2       
        //   717: anewarray       Ljava/lang/Object;
        //   720: dup            
        //   721: iconst_0       
        //   722: aload_0         /* l1 */
        //   723: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   726: aastore        
        //   727: dup            
        //   728: iconst_1       
        //   729: iconst_m1      
        //   730: aload_1         /* l2 */
        //   731: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   734: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //   737: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   740: aastore        
        //   741: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   744: iconst_2       
        //   745: anewarray       Ljava/lang/Object;
        //   748: dup            
        //   749: iconst_0       
        //   750: aload_0         /* l1 */
        //   751: dup            
        //   752: astore_2       
        //   753: checkcast       Lgnu/lists/Pair;
        //   756: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   759: aastore        
        //   760: dup            
        //   761: iconst_1       
        //   762: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   765: aastore        
        //   766: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   769: invokestatic    gnu/lists/Pair.make:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   772: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   775: goto            821
        //   778: aload_0         /* l1 */
        //   779: dup            
        //   780: astore_2       
        //   781: checkcast       Lgnu/lists/Pair;
        //   784: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   787: ldc_w           Lgnu/lists/LList;.class
        //   790: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   793: dup            
        //   794: astore_2       
        //   795: checkcast       Lgnu/lists/LList;
        //   798: aload_1         /* l2 */
        //   799: dup            
        //   800: astore_2       
        //   801: checkcast       Lgnu/lists/Pair;
        //   804: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   807: ldc_w           Lgnu/lists/LList;.class
        //   810: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   813: dup            
        //   814: astore_2       
        //   815: checkcast       Lgnu/lists/LList;
        //   818: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   821: areturn        
        //   822: new             Lgnu/mapping/WrongType;
        //   825: dup_x1         
        //   826: swap           
        //   827: ldc_w           "car"
        //   830: iconst_1       
        //   831: aload_2        
        //   832: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   835: athrow         
        //   836: new             Lgnu/mapping/WrongType;
        //   839: dup_x1         
        //   840: swap           
        //   841: ldc_w           "cdr"
        //   844: iconst_1       
        //   845: aload_2        
        //   846: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   849: athrow         
        //   850: new             Lgnu/mapping/WrongType;
        //   853: dup_x1         
        //   854: swap           
        //   855: ldc_w           "%boundary-pairs-xor"
        //   858: iconst_0       
        //   859: aload_2        
        //   860: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   863: athrow         
        //   864: new             Lgnu/mapping/WrongType;
        //   867: dup_x1         
        //   868: swap           
        //   869: ldc_w           "car"
        //   872: iconst_1       
        //   873: aload_2        
        //   874: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   877: athrow         
        //   878: new             Lgnu/mapping/WrongType;
        //   881: dup_x1         
        //   882: swap           
        //   883: ldc_w           "cdr"
        //   886: iconst_1       
        //   887: aload_2        
        //   888: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   891: athrow         
        //   892: new             Lgnu/mapping/WrongType;
        //   895: dup_x1         
        //   896: swap           
        //   897: ldc_w           "%boundary-pairs-xor"
        //   900: iconst_1       
        //   901: aload_2        
        //   902: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   905: athrow         
        //   906: new             Lgnu/mapping/WrongType;
        //   909: dup_x1         
        //   910: swap           
        //   911: ldc_w           "cdr"
        //   914: iconst_1       
        //   915: aload_2        
        //   916: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   919: athrow         
        //   920: new             Lgnu/mapping/WrongType;
        //   923: dup_x1         
        //   924: swap           
        //   925: ldc_w           "cdr"
        //   928: iconst_1       
        //   929: aload_2        
        //   930: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   933: athrow         
        //   934: new             Lgnu/mapping/WrongType;
        //   937: dup_x1         
        //   938: swap           
        //   939: ldc_w           "%boundary-pairs-xor"
        //   942: iconst_1       
        //   943: aload_2        
        //   944: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   947: athrow         
        //   948: new             Lgnu/mapping/WrongType;
        //   951: dup_x1         
        //   952: swap           
        //   953: ldc_w           "cdr"
        //   956: iconst_1       
        //   957: aload_2        
        //   958: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   961: athrow         
        //   962: new             Lgnu/mapping/WrongType;
        //   965: dup_x1         
        //   966: swap           
        //   967: ldc_w           "%boundary-pairs-xor"
        //   970: iconst_0       
        //   971: aload_2        
        //   972: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   975: athrow         
        //   976: new             Lgnu/mapping/WrongType;
        //   979: dup_x1         
        //   980: swap           
        //   981: ldc_w           "cdr"
        //   984: iconst_1       
        //   985: aload_2        
        //   986: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   989: athrow         
        //   990: new             Lgnu/mapping/WrongType;
        //   993: dup_x1         
        //   994: swap           
        //   995: ldc_w           "cdr"
        //   998: iconst_1       
        //   999: aload_2        
        //  1000: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1003: athrow         
        //  1004: new             Lgnu/mapping/WrongType;
        //  1007: dup_x1         
        //  1008: swap           
        //  1009: ldc_w           "cdr"
        //  1012: iconst_1       
        //  1013: aload_2        
        //  1014: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1017: athrow         
        //  1018: new             Lgnu/mapping/WrongType;
        //  1021: dup_x1         
        //  1022: swap           
        //  1023: ldc_w           "cdr"
        //  1026: iconst_1       
        //  1027: aload_2        
        //  1028: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1031: athrow         
        //  1032: new             Lgnu/mapping/WrongType;
        //  1035: dup_x1         
        //  1036: swap           
        //  1037: ldc_w           "%boundary-pairs-xor"
        //  1040: iconst_0       
        //  1041: aload_2        
        //  1042: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1045: athrow         
        //  1046: new             Lgnu/mapping/WrongType;
        //  1049: dup_x1         
        //  1050: swap           
        //  1051: ldc_w           "cdr"
        //  1054: iconst_1       
        //  1055: aload_2        
        //  1056: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1059: athrow         
        //  1060: new             Lgnu/mapping/WrongType;
        //  1063: dup_x1         
        //  1064: swap           
        //  1065: ldc_w           "cdr"
        //  1068: iconst_1       
        //  1069: aload_2        
        //  1070: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1073: athrow         
        //  1074: new             Lgnu/mapping/WrongType;
        //  1077: dup_x1         
        //  1078: swap           
        //  1079: ldc_w           "%boundary-pairs-xor"
        //  1082: iconst_0       
        //  1083: aload_2        
        //  1084: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1087: athrow         
        //  1088: new             Lgnu/mapping/WrongType;
        //  1091: dup_x1         
        //  1092: swap           
        //  1093: ldc_w           "cdr"
        //  1096: iconst_1       
        //  1097: aload_2        
        //  1098: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1101: athrow         
        //  1102: new             Lgnu/mapping/WrongType;
        //  1105: dup_x1         
        //  1106: swap           
        //  1107: ldc_w           "cdr"
        //  1110: iconst_1       
        //  1111: aload_2        
        //  1112: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1115: athrow         
        //  1116: new             Lgnu/mapping/WrongType;
        //  1119: dup_x1         
        //  1120: swap           
        //  1121: ldc_w           "%boundary-pairs-xor"
        //  1124: iconst_0       
        //  1125: aload_2        
        //  1126: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1129: athrow         
        //  1130: new             Lgnu/mapping/WrongType;
        //  1133: dup_x1         
        //  1134: swap           
        //  1135: ldc_w           "cdr"
        //  1138: iconst_1       
        //  1139: aload_2        
        //  1140: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1143: athrow         
        //  1144: new             Lgnu/mapping/WrongType;
        //  1147: dup_x1         
        //  1148: swap           
        //  1149: ldc_w           "%boundary-pairs-xor"
        //  1152: iconst_1       
        //  1153: aload_2        
        //  1154: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1157: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  52     55     822    836    Ljava/lang/ClassCastException;
        //  70     73     836    850    Ljava/lang/ClassCastException;
        //  84     87     850    864    Ljava/lang/ClassCastException;
        //  147    150    864    878    Ljava/lang/ClassCastException;
        //  166    169    878    892    Ljava/lang/ClassCastException;
        //  180    183    892    906    Ljava/lang/ClassCastException;
        //  247    250    906    920    Ljava/lang/ClassCastException;
        //  259    262    920    934    Ljava/lang/ClassCastException;
        //  273    276    934    948    Ljava/lang/ClassCastException;
        //  306    309    948    962    Ljava/lang/ClassCastException;
        //  320    323    962    976    Ljava/lang/ClassCastException;
        //  337    340    976    990    Ljava/lang/ClassCastException;
        //  430    433    990    1004   Ljava/lang/ClassCastException;
        //  547    550    1004   1018   Ljava/lang/ClassCastException;
        //  603    606    1018   1032   Ljava/lang/ClassCastException;
        //  617    620    1032   1046   Ljava/lang/ClassCastException;
        //  657    660    1046   1060   Ljava/lang/ClassCastException;
        //  699    702    1060   1074   Ljava/lang/ClassCastException;
        //  713    716    1074   1088   Ljava/lang/ClassCastException;
        //  753    756    1088   1102   Ljava/lang/ClassCastException;
        //  781    784    1102   1116   Ljava/lang/ClassCastException;
        //  795    798    1116   1130   Ljava/lang/ClassCastException;
        //  801    804    1130   1144   Ljava/lang/ClassCastException;
        //  815    818    1144   1158   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 616 out of bounds for length 616
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
    
    static CharSet $PcMakeBuiltin(final Object nm, final int[] arr) {
        final CharSet set = new CharSet(new int[0]);
        set.inversion$Mnlist = arr;
        set.inversion$Mnlist$Mnsize = arr.length;
        final Object force = Promise.force(nm, String.class);
        set.name = ((force == null) ? null : force.toString());
        set.immutable$Qu = true;
        return set;
    }
    
    static LList $PcMakeBoundaryPairs(final int[] arr, final int len) {
        public class srfi14$frame0 extends ModuleBody
        {
            int[] arr;
            int len;
            
            public LList lambda2makePairs(final int i) {
                return (i == this.len) ? LList.Empty : lists.cons(lists.cons(this.arr[1 + i], this.arr[i] - 1), this.lambda2makePairs(i + 2));
            }
        }
        final srfi14$frame0 $heapFrame = new srfi14$frame0();
        $heapFrame.arr = arr;
        $heapFrame.len = len;
        return ($heapFrame.len == 0) ? LList.Empty : ((1 - ($heapFrame.len & 0x1) != 0) ? $heapFrame.lambda2makePairs(0) : lists.cons(lists.cons($heapFrame.arr[0], srfi14.Lit4), $heapFrame.lambda2makePairs(1)));
    }
    
    static int $PcBoundaryPairsLength(final LList l) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: istore_2       
        //     3: astore_1        /* l */
        //     4: aload_1         /* l */
        //     5: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     8: ifeq            15
        //    11: iload_2         /* size */
        //    12: goto            78
        //    15: getstatic       gnu/kawa/slib/srfi14.Lit4:Ljava/lang/Integer;
        //    18: aload_1         /* l */
        //    19: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    22: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    25: ifeq            53
        //    28: aload_1         /* l */
        //    29: dup            
        //    30: astore_3       
        //    31: checkcast       Lgnu/lists/Pair;
        //    34: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    37: ldc_w           Lgnu/lists/LList;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: checkcast       Lgnu/lists/LList;
        //    46: iinc            size, 1
        //    49: astore_1        /* l */
        //    50: goto            4
        //    53: aload_1         /* l */
        //    54: dup            
        //    55: astore_3       
        //    56: checkcast       Lgnu/lists/Pair;
        //    59: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    62: ldc_w           Lgnu/lists/LList;.class
        //    65: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    68: checkcast       Lgnu/lists/LList;
        //    71: iinc            size, 2
        //    74: astore_1        /* l */
        //    75: goto            4
        //    78: ireturn        
        //    79: new             Lgnu/mapping/WrongType;
        //    82: dup_x1         
        //    83: swap           
        //    84: ldc_w           "cdr"
        //    87: iconst_1       
        //    88: aload_3        
        //    89: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    92: athrow         
        //    93: new             Lgnu/mapping/WrongType;
        //    96: dup_x1         
        //    97: swap           
        //    98: ldc_w           "cdr"
        //   101: iconst_1       
        //   102: aload_3        
        //   103: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   106: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  31     34     79     93     Ljava/lang/ClassCastException;
        //  56     59     93     107    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object $PcWriteInversionList(final int[] arr, final LList l, final int len) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifle            142
        //     4: getstatic       gnu/kawa/slib/srfi14.Lit4:Ljava/lang/Integer;
        //     7: aload_1         /* l */
        //     8: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    11: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    14: ifeq            137
        //    17: aload_0         /* arr */
        //    18: iconst_0       
        //    19: aload_1         /* l */
        //    20: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    23: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    26: checkcast       Ljava/lang/Number;
        //    29: invokevirtual   java/lang/Number.intValue:()I
        //    32: iastore        
        //    33: iconst_1       
        //    34: aload_1         /* l */
        //    35: dup            
        //    36: astore_3       
        //    37: checkcast       Lgnu/lists/Pair;
        //    40: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    43: ldc_w           Lgnu/lists/LList;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: checkcast       Lgnu/lists/LList;
        //    52: astore          4
        //    54: istore_3        /* i */
        //    55: iload_3         /* i */
        //    56: iload_2         /* len */
        //    57: if_icmpge       131
        //    60: aload_0         /* arr */
        //    61: iload_3         /* i */
        //    62: iconst_1       
        //    63: getstatic       gnu/kawa/slib/srfi14.Lit1:Lgnu/math/IntNum;
        //    66: aload           l
        //    68: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    71: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: checkcast       Ljava/lang/Number;
        //    80: invokevirtual   java/lang/Number.intValue:()I
        //    83: iastore        
        //    84: aload_0         /* arr */
        //    85: iload_3         /* i */
        //    86: iconst_1       
        //    87: iadd           
        //    88: aload           l
        //    90: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    96: checkcast       Ljava/lang/Number;
        //    99: invokevirtual   java/lang/Number.intValue:()I
        //   102: iastore        
        //   103: aload           l
        //   105: dup            
        //   106: astore          5
        //   108: checkcast       Lgnu/lists/Pair;
        //   111: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   114: ldc_w           Lgnu/lists/LList;.class
        //   117: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   120: checkcast       Lgnu/lists/LList;
        //   123: astore          l
        //   125: iinc            i, 2
        //   128: goto            55
        //   131: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   134: goto            145
        //   137: iconst_0       
        //   138: aload_1         /* l */
        //   139: goto            52
        //   142: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   145: areturn        
        //   146: new             Lgnu/mapping/WrongType;
        //   149: dup_x1         
        //   150: swap           
        //   151: ldc_w           "cdr"
        //   154: iconst_1       
        //   155: aload_3        
        //   156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   159: athrow         
        //   160: new             Lgnu/mapping/WrongType;
        //   163: dup_x1         
        //   164: swap           
        //   165: ldc_w           "cdr"
        //   168: iconst_1       
        //   169: aload           5
        //   171: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   174: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  37     40     146    160    Ljava/lang/ClassCastException;
        //  108    111    160    175    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0131:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    static {
        Lit51 = Symbol.valueOf("%boundary-pairs-xor");
        Lit50 = Symbol.valueOf("%boundary-pairs-union");
        Lit49 = Symbol.valueOf("%boundary-pairs-intersection");
        Lit48 = Symbol.valueOf("char-set-xor!");
        Lit47 = Symbol.valueOf("char-set-difference!");
        Lit46 = Symbol.valueOf("char-set-intersection!");
        Lit45 = Symbol.valueOf("char-set-union!");
        Lit44 = Symbol.valueOf("char-set-complement!");
        Lit43 = Symbol.valueOf("char-set-diff+intersection");
        Lit42 = Symbol.valueOf("char-set-xor");
        Lit41 = Symbol.valueOf("char-set-difference");
        Lit40 = Symbol.valueOf("char-set-intersection");
        Lit39 = Symbol.valueOf("char-set-union");
        Lit38 = Symbol.valueOf("char-set-complement");
        Lit37 = Symbol.valueOf("char-set-delete!");
        Lit36 = Symbol.valueOf("char-set-adjoin!");
        Lit35 = Symbol.valueOf("char-set-delete");
        Lit34 = Symbol.valueOf("char-set-adjoin");
        Lit33 = Symbol.valueOf("char-set-any");
        Lit32 = Symbol.valueOf("char-set-every");
        Lit31 = Symbol.valueOf("char-set-contains?");
        Lit30 = Symbol.valueOf("char-set->string");
        Lit29 = Symbol.valueOf("char-set->list");
        Lit28 = Symbol.valueOf("char-set-count");
        Lit27 = Symbol.valueOf("char-set-size");
        Lit26 = Symbol.valueOf("->char-set");
        Lit25 = Symbol.valueOf("ucs-range->char-set!");
        Lit24 = Symbol.valueOf("ucs-range->char-set");
        Lit23 = Symbol.valueOf("char-set-filter!");
        Lit22 = Symbol.valueOf("char-set-filter");
        Lit21 = Symbol.valueOf("string->char-set!");
        Lit20 = Symbol.valueOf("string->char-set");
        Lit19 = Symbol.valueOf("list->char-set!");
        Lit18 = Symbol.valueOf("list->char-set");
        Lit17 = Symbol.valueOf("char-set-copy");
        Lit16 = Symbol.valueOf("char-set-map");
        Lit15 = Symbol.valueOf("char-set-for-each");
        Lit14 = Symbol.valueOf("char-set-unfold!");
        Lit13 = Symbol.valueOf("char-set-unfold");
        Lit12 = Symbol.valueOf("char-set-fold");
        Lit11 = Symbol.valueOf("end-of-char-set?");
        Lit10 = Symbol.valueOf("char-set-cursor-next");
        Lit9 = Symbol.valueOf("char-set-ref");
        Lit8 = Symbol.valueOf("char-set-cursor");
        Lit7 = Symbol.valueOf("char-set-hash");
        Lit6 = Symbol.valueOf("char-set<=");
        Lit5 = Symbol.valueOf("char-set=");
        Lit4 = 1114111;
        Lit3 = (ClassType)Type.make(CharSet.class);
        Lit2 = IntNum.valueOf(0);
        Lit1 = IntNum.valueOf(1);
        Lit0 = Symbol.valueOf("done");
        $Prvt$Arrays = Arrays.class;
        $Prvt$reflectArray = Array.class;
        srfi14.$instance = new srfi14();
        $Pctitle$Mncase = new int[] { 8189, 8188, 8141, 8140, 8125, 8124, 8112, 8104, 8096, 8088, 8080, 8072, 499, 498, 460, 459, 457, 456, 454, 453 };
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
        $Pcprinting = new int[] { 195102, 194560, 178206, 177984, 177973, 173824, 173783, 131072, 128884, 128768, 128710, 128640, 128592, 128581, 128577, 128507, 128360, 128336, 128324, 128320, 128318, 128256, 128253, 128249, 128248, 128066, 128065, 128064, 128063, 128000, 127985, 127968, 127947, 127942, 127941, 127904, 127892, 127872, 127869, 127799, 127798, 127792, 127777, 127744, 127570, 127568, 127561, 127552, 127547, 127504, 127491, 127462, 127387, 127344, 127340, 127280, 127279, 127248, 127200, 127185, 127184, 127169, 127167, 127153, 127151, 127136, 127124, 127024, 127020, 126976, 126706, 126704, 126652, 126635, 126634, 126629, 126628, 126625, 126620, 126603, 126602, 126592, 126591, 126590, 126589, 126585, 126584, 126580, 126579, 126572, 126571, 126567, 126565, 126564, 126563, 126561, 126560, 126559, 126558, 126557, 126556, 126555, 126554, 126553, 126552, 126551, 126549, 126548, 126547, 126545, 126544, 126541, 126540, 126539, 126538, 126537, 126536, 126535, 126531, 126530, 126524, 126523, 126522, 126521, 126520, 126516, 126515, 126505, 126504, 126503, 126501, 126500, 126499, 126497, 126496, 126469, 126468, 126464, 120832, 120782, 120780, 120488, 120486, 120146, 120145, 120138, 120135, 120134, 120133, 120128, 120127, 120123, 120122, 120094, 120093, 120086, 120085, 120077, 120075, 120071, 120070, 120005, 120004, 119997, 119996, 119995, 119994, 119982, 119981, 119977, 119975, 119973, 119971, 119970, 119968, 119966, 119965, 119894, 119893, 119808, 119639, 119552, 119366, 119365, 119362, 119296, 119262, 119214, 119210, 119180, 119173, 119171, 119149, 119146, 119141, 119081, 119079, 119040, 119030, 118784, 110594, 110592, 94112, 94099, 94033, 94032, 94021, 93952, 92729, 92160, 78895, 77824, 74868, 74864, 74607, 73728, 71370, 71360, 71339, 71296, 70106, 70096, 70089, 70081, 70067, 70019, 69956, 69942, 69927, 69891, 69882, 69872, 69865, 69840, 69826, 69822, 69821, 69819, 69808, 69763, 69744, 69734, 69710, 69703, 69688, 69635, 68681, 68608, 68467, 68448, 68438, 68409, 68406, 68352, 68224, 68223, 68221, 68192, 68185, 68176, 68148, 68121, 68120, 68117, 68116, 68112, 68097, 68096, 68032, 68030, 68024, 67968, 67904, 67903, 67898, 67871, 67862, 67840, 67672, 67671, 67670, 67647, 67645, 67644, 67641, 67639, 67638, 67594, 67593, 67592, 67590, 67584, 66730, 66720, 66718, 66560, 66513, 66504, 66500, 66463, 66462, 66432, 66378, 66370, 66369, 66352, 66335, 66304, 66257, 66208, 66205, 66176, 66045, 66000, 65948, 65936, 65930, 65913, 65856, 65847, 65795, 65792, 65787, 65664, 65630, 65616, 65614, 65599, 65598, 65596, 65595, 65576, 65575, 65549, 65548, 65536, 65534, 65532, 65519, 65512, 65511, 65504, 65501, 65498, 65496, 65490, 65488, 65482, 65480, 65474, 65471, 65281, 65277, 65142, 65141, 65136, 65132, 65128, 65127, 65108, 65107, 65072, 65050, 65040, 65022, 65008, 64968, 64914, 64912, 64848, 64832, 64467, 64450, 64326, 64325, 64323, 64322, 64320, 64319, 64318, 64317, 64312, 64311, 64287, 64286, 64285, 64280, 64275, 64263, 64256, 64218, 64112, 64110, 63744, 55292, 55243, 55239, 55216, 55204, 44032, 44026, 44016, 44012, 44011, 44003, 43968, 43823, 43816, 43815, 43808, 43799, 43793, 43791, 43785, 43783, 43777, 43765, 43760, 43755, 43739, 43715, 43714, 43713, 43712, 43710, 43705, 43703, 43701, 43698, 43697, 43696, 43648, 43643, 43612, 43610, 43600, 43596, 43588, 43587, 43584, 43561, 43520, 43488, 43486, 43482, 43471, 43470, 43457, 43443, 43396, 43389, 43359, 43335, 43310, 43302, 43264, 43260, 43250, 43226, 43214, 43188, 43138, 43128, 43072, 43066, 43062, 43052, 43048, 43043, 43020, 43019, 43015, 43014, 43011, 43010, 43000, 42923, 42912, 42900, 42896, 42895, 42752, 42744, 42738, 42726, 42656, 42648, 42622, 42612, 42611, 42607, 42560, 42540, 42192, 42183, 42128, 42125, 40960, 40909, 19904, 19894, 13056, 13055, 12992, 12977, 12938, 12928, 12896, 12881, 12880, 12872, 12842, 12831, 12784, 12772, 12736, 12731, 12694, 12690, 12688, 12687, 12593, 12590, 12549, 12544, 12443, 12439, 12353, 12352, 12347, 12344, 12336, 12321, 12296, 12295, 12288, 12284, 12272, 12246, 12032, 12020, 11931, 11930, 11904, 11836, 11776, 11743, 11736, 11735, 11728, 11727, 11720, 11719, 11712, 11711, 11704, 11703, 11696, 11695, 11688, 11687, 11680, 11671, 11648, 11633, 11631, 11624, 11568, 11566, 11565, 11560, 11559, 11558, 11518, 11517, 11513, 11508, 11506, 11503, 11360, 11359, 11312, 11311, 11264, 11098, 11088, 11085, 10132, 10102, 9985, 9984, 9472, 9450, 9372, 9291, 9280, 9255, 9216, 9204, 8592, 8581, 8579, 8528, 8448, 8379, 8352, 8349, 8336, 8335, 8330, 8320, 8314, 8306, 8305, 8288, 8239, 8234, 8208, 8203, 8192, 8191, 8182, 8181, 8178, 8176, 8157, 8156, 8150, 8148, 8134, 8133, 8118, 8117, 8064, 8062, 8031, 8030, 8029, 8028, 8027, 8026, 8025, 8024, 8016, 8014, 8008, 8006, 7968, 7966, 7960, 7958, 7680, 7616, 7424, 7415, 7413, 7410, 7406, 7405, 7401, 7380, 7379, 7368, 7360, 7296, 7245, 7242, 7227, 7204, 7164, 7142, 7086, 7073, 7043, 7037, 7028, 7019, 6992, 6988, 6981, 6964, 6917, 6830, 6816, 6810, 6800, 6794, 6784, 6741, 6686, 6679, 6622, 6618, 6608, 6600, 6593, 6572, 6528, 6517, 6512, 6510, 6468, 6465, 6464, 6429, 6400, 6390, 6320, 6315, 6314, 6313, 6272, 6264, 6176, 6170, 6160, 6159, 6158, 6155, 6144, 6122, 6112, 6109, 6100, 6068, 6016, 6001, 5998, 5997, 5984, 5970, 5952, 5943, 5941, 5938, 5920, 5906, 5902, 5901, 5888, 5870, 5792, 5789, 5120, 5109, 5024, 5018, 4992, 4969, 4960, 4955, 4888, 4886, 4882, 4881, 4824, 4823, 4808, 4806, 4802, 4801, 4800, 4799, 4792, 4790, 4786, 4785, 4752, 4750, 4746, 4745, 4704, 4702, 4698, 4697, 4696, 4695, 4688, 4686, 4682, 4681, 4304, 4302, 4301, 4296, 4295, 4294, 4254, 4250, 4240, 4239, 4238, 4226, 4213, 4209, 4206, 4199, 4197, 4194, 4193, 4190, 4186, 4182, 4159, 4139, 4096, 4059, 4046, 4045, 4039, 4038, 4030, 3981, 3976, 3974, 3973, 3949, 3913, 3912, 3904, 3902, 3898, 3897, 3896, 3895, 3894, 3893, 3892, 3882, 3866, 3864, 3840, 3808, 3804, 3802, 3792, 3783, 3782, 3781, 3776, 3774, 3773, 3764, 3762, 3761, 3757, 3756, 3754, 3752, 3751, 3750, 3749, 3748, 3745, 3744, 3737, 3736, 3732, 3726, 3725, 3723, 3722, 3721, 3719, 3717, 3716, 3715, 3713, 3676, 3663, 3655, 3647, 3636, 3634, 3633, 3585, 3573, 3572, 3527, 3520, 3518, 3517, 3516, 3507, 3506, 3482, 3479, 3461, 3456, 3449, 3440, 3430, 3426, 3424, 3407, 3406, 3390, 3389, 3387, 3346, 3345, 3342, 3341, 3333, 3315, 3313, 3312, 3302, 3298, 3296, 3295, 3294, 3262, 3261, 3258, 3253, 3252, 3242, 3241, 3218, 3217, 3214, 3213, 3205, 3200, 3199, 3184, 3174, 3170, 3168, 3162, 3160, 3134, 3133, 3130, 3125, 3124, 3114, 3113, 3090, 3089, 3086, 3085, 3077, 3067, 3059, 3056, 3046, 3025, 3024, 3002, 2990, 2987, 2984, 2981, 2979, 2976, 2974, 2973, 2972, 2971, 2969, 2966, 2962, 2961, 2958, 2955, 2949, 2948, 2947, 2930, 2918, 2914, 2911, 2910, 2908, 2878, 2877, 2874, 2869, 2868, 2866, 2865, 2858, 2857, 2835, 2833, 2831, 2829, 2821, 2802, 2790, 2786, 2784, 2769, 2768, 2750, 2749, 2746, 2741, 2740, 2738, 2737, 2730, 2729, 2707, 2706, 2703, 2702, 2693, 2677, 2674, 2672, 2662, 2655, 2654, 2653, 2649, 2618, 2616, 2615, 2613, 2612, 2610, 2609, 2602, 2601, 2579, 2577, 2575, 2571, 2565, 2556, 2554, 2548, 2534, 2530, 2527, 2526, 2524, 2511, 2510, 2494, 2493, 2490, 2486, 2483, 2482, 2481, 2474, 2473, 2451, 2449, 2447, 2445, 2437, 2432, 2425, 2424, 2404, 2402, 2392, 2385, 2384, 2366, 2365, 2362, 2308, 2221, 2210, 2209, 2208, 2143, 2142, 2137, 2112, 2111, 2096, 2089, 2088, 2085, 2084, 2075, 2074, 2070, 2048, 2043, 2036, 2027, 1984, 1970, 1969, 1958, 1869, 1840, 1810, 1809, 1808, 1806, 1774, 1770, 1769, 1767, 1765, 1759, 1758, 1750, 1649, 1648, 1632, 1611, 1566, 1564, 1563, 1552, 1542, 1525, 1520, 1515, 1488, 1479, 1478, 1476, 1475, 1473, 1472, 1471, 1470, 1424, 1423, 1419, 1417, 1416, 1377, 1376, 1369, 1367, 1329, 1320, 1162, 1155, 931, 930, 910, 909, 908, 907, 900, 895, 890, 888, 880, 768, 191, 188, 186, 185, 180, 178, 174, 173, 160, 127, 32, 14, 9 };
        final srfi14 $instance = srfi14.$instance;
        char$Mnset$Eq = new ModuleMethod($instance, 2, srfi14.Lit5, -4096);
        char$Mnset$Ls$Eq = new ModuleMethod($instance, 3, srfi14.Lit6, -4096);
        char$Mnset$Mnhash = new ModuleMethod($instance, 4, srfi14.Lit7, 8193);
        char$Mnset$Mncursor = new ModuleMethod($instance, 6, srfi14.Lit8, 4097);
        char$Mnset$Mnref = new ModuleMethod($instance, 7, srfi14.Lit9, 8194);
        char$Mnset$Mncursor$Mnnext = new ModuleMethod($instance, 8, srfi14.Lit10, 8194);
        end$Mnof$Mnchar$Mnset$Qu = new ModuleMethod($instance, 9, srfi14.Lit11, 4097);
        char$Mnset$Mnfold = new ModuleMethod($instance, 10, srfi14.Lit12, 12291);
        char$Mnset$Mnunfold = new ModuleMethod($instance, 11, srfi14.Lit13, 20484);
        char$Mnset$Mnunfold$Ex = new ModuleMethod($instance, 13, srfi14.Lit14, 20485);
        char$Mnset$Mnfor$Mneach = new ModuleMethod($instance, 14, srfi14.Lit15, 8194);
        char$Mnset$Mnmap = new ModuleMethod($instance, 15, srfi14.Lit16, 8194);
        char$Mnset$Mncopy = new ModuleMethod($instance, 16, srfi14.Lit17, 4097);
        char$Mnset = CharSet.class;
        list$Mn$Grchar$Mnset = new ModuleMethod($instance, 17, srfi14.Lit18, 8193);
        list$Mn$Grchar$Mnset$Ex = new ModuleMethod($instance, 19, srfi14.Lit19, 8194);
        string$Mn$Grchar$Mnset = new ModuleMethod($instance, 20, srfi14.Lit20, 8193);
        string$Mn$Grchar$Mnset$Ex = new ModuleMethod($instance, 22, srfi14.Lit21, 8194);
        char$Mnset$Mnfilter = new ModuleMethod($instance, 23, srfi14.Lit22, 12290);
        char$Mnset$Mnfilter$Ex = new ModuleMethod($instance, 25, srfi14.Lit23, 12291);
        ucs$Mnrange$Mn$Grchar$Mnset = new ModuleMethod($instance, 26, srfi14.Lit24, 16386);
        ucs$Mnrange$Mn$Grchar$Mnset$Ex = new ModuleMethod($instance, 29, srfi14.Lit25, 16388);
        $Mn$Grchar$Mnset = new ModuleMethod($instance, 30, srfi14.Lit26, 4097);
        char$Mnset$Mnsize = new ModuleMethod($instance, 31, srfi14.Lit27, 4097);
        char$Mnset$Mncount = new ModuleMethod($instance, 32, srfi14.Lit28, 8194);
        char$Mnset$Mn$Grlist = new ModuleMethod($instance, 33, srfi14.Lit29, 4097);
        char$Mnset$Mn$Grstring = new ModuleMethod($instance, 34, srfi14.Lit30, 4097);
        char$Mnset$Mncontains$Qu = new ModuleMethod($instance, 35, srfi14.Lit31, 8194);
        char$Mnset$Mnevery = new ModuleMethod($instance, 36, srfi14.Lit32, 8194);
        char$Mnset$Mnany = new ModuleMethod($instance, 37, srfi14.Lit33, 8194);
        char$Mnset$Mnadjoin = new ModuleMethod($instance, 38, srfi14.Lit34, -4095);
        char$Mnset$Mndelete = new ModuleMethod($instance, 39, srfi14.Lit35, -4095);
        char$Mnset$Mnadjoin$Ex = new ModuleMethod($instance, 40, srfi14.Lit36, -4095);
        char$Mnset$Mndelete$Ex = new ModuleMethod($instance, 41, srfi14.Lit37, -4095);
        char$Mnset$Mncomplement = new ModuleMethod($instance, 42, srfi14.Lit38, 4097);
        char$Mnset$Mnunion = new ModuleMethod($instance, 43, srfi14.Lit39, -4096);
        char$Mnset$Mnintersection = new ModuleMethod($instance, 44, srfi14.Lit40, -4096);
        char$Mnset$Mndifference = new ModuleMethod($instance, 45, srfi14.Lit41, -4095);
        char$Mnset$Mnxor = new ModuleMethod($instance, 46, srfi14.Lit42, -4096);
        char$Mnset$Mndiff$Plintersection = new ModuleMethod($instance, 47, srfi14.Lit43, -4094);
        char$Mnset$Mncomplement$Ex = new ModuleMethod($instance, 48, srfi14.Lit44, 4097);
        char$Mnset$Mnunion$Ex = new ModuleMethod($instance, 49, srfi14.Lit45, -4096);
        char$Mnset$Mnintersection$Ex = new ModuleMethod($instance, 50, srfi14.Lit46, -4096);
        char$Mnset$Mndifference$Ex = new ModuleMethod($instance, 51, srfi14.Lit47, -4095);
        char$Mnset$Mnxor$Ex = new ModuleMethod($instance, 52, srfi14.Lit48, -4096);
        $Pcboundary$Mnpairs$Mnintersection = new ModuleMethod($instance, 53, srfi14.Lit49, 8194);
        $Pcboundary$Mnpairs$Mnunion = new ModuleMethod($instance, 54, srfi14.Lit50, 8194);
        $Pcboundary$Mnpairs$Mnxor = new ModuleMethod($instance, 55, srfi14.Lit51, 8194);
        $runBody$();
    }
    
    public srfi14() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 48: {
                final Object force = Promise.force(arg1, CharSet.class);
                if (!(force instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 42: {
                final Object force2 = Promise.force(arg1, CharSet.class);
                if (!(force2 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 34: {
                final Object force3 = Promise.force(arg1, CharSet.class);
                if (!(force3 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 33: {
                final Object force4 = Promise.force(arg1, CharSet.class);
                if (!(force4 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 31: {
                final Object force5 = Promise.force(arg1, CharSet.class);
                if (!(force5 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 30: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 20: {
                ctx.value1 = Promise.force(arg1, String.class);
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
            case 16: {
                final Object force7 = Promise.force(arg1, CharSet.class);
                if (!(force7 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 9: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                final Object force8 = Promise.force(arg1, CharSet.class);
                if (!(force8 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                final Object force9 = Promise.force(arg1, CharSet.class);
                if (!(force9 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force9;
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
            case 55: {
                final Object force = Promise.force(arg1, LList.class);
                if (!(force instanceof LList)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, LList.class);
                if (force2 instanceof LList) {
                    ctx.value2 = force2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 54: {
                final Object force3 = Promise.force(arg1, LList.class);
                if (!(force3 instanceof LList)) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(arg2, LList.class);
                if (force4 instanceof LList) {
                    ctx.value2 = force4;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 53: {
                final Object force5 = Promise.force(arg1, LList.class);
                if (!(force5 instanceof LList)) {
                    return -786431;
                }
                ctx.value1 = force5;
                final Object force6 = Promise.force(arg2, LList.class);
                if (force6 instanceof LList) {
                    ctx.value2 = force6;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 37: {
                final Object force7 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force7) == null) {
                    return -786431;
                }
                ctx.value1 = force7;
                final Object force8 = Promise.force(arg2, CharSet.class);
                if (!(force8 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force8;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 36: {
                final Object force9 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force9) == null) {
                    return -786431;
                }
                ctx.value1 = force9;
                final Object force10 = Promise.force(arg2, CharSet.class);
                if (!(force10 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force10;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 35: {
                final Object force11 = Promise.force(arg1, CharSet.class);
                if (!(force11 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force11;
                final Object force12 = Promise.force(arg2);
                if (Char.checkCharOrEof(force12) >= 0) {
                    ctx.value2 = force12;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 32: {
                final Object force13 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force13) == null) {
                    return -786431;
                }
                ctx.value1 = force13;
                final Object force14 = Promise.force(arg2, CharSet.class);
                if (!(force14 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force14;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 26: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 23: {
                final Object force15 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force15) == null) {
                    return -786431;
                }
                ctx.value1 = force15;
                final Object force16 = Promise.force(arg2, CharSet.class);
                if (!(force16 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force16;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 22: {
                ctx.value1 = Promise.force(arg1, String.class);
                final Object force17 = Promise.force(arg2, CharSet.class);
                if (!(force17 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force17;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 20: {
                ctx.value1 = Promise.force(arg1, String.class);
                final Object force18 = Promise.force(arg2, CharSet.class);
                if (!(force18 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force18;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 19: {
                final Object force19 = Promise.force(arg1, LList.class);
                if (!(force19 instanceof LList)) {
                    return -786431;
                }
                ctx.value1 = force19;
                final Object force20 = Promise.force(arg2, CharSet.class);
                if (!(force20 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force20;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 17: {
                final Object force21 = Promise.force(arg1, LList.class);
                if (!(force21 instanceof LList)) {
                    return -786431;
                }
                ctx.value1 = force21;
                final Object force22 = Promise.force(arg2, CharSet.class);
                if (!(force22 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force22;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 15: {
                final Object force23 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force23) == null) {
                    return -786431;
                }
                ctx.value1 = force23;
                final Object force24 = Promise.force(arg2, CharSet.class);
                if (!(force24 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force24;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 14: {
                final Object force25 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force25) == null) {
                    return -786431;
                }
                ctx.value1 = force25;
                final Object force26 = Promise.force(arg2, CharSet.class);
                if (!(force26 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force26;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 8: {
                final Object force27 = Promise.force(arg1, CharSet.class);
                if (!(force27 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force27;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 7: {
                final Object force28 = Promise.force(arg1, CharSet.class);
                if (!(force28 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force28;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 4: {
                final Object force29 = Promise.force(arg1, CharSet.class);
                if (!(force29 instanceof CharSet)) {
                    return -786431;
                }
                ctx.value1 = force29;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 26: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                final Object force = Promise.force(arg3);
                if (force instanceof Boolean) {
                    ctx.value3 = force;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 25: {
                final Object force2 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) == null) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(arg2, CharSet.class);
                if (!(force3 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force3;
                final Object force4 = Promise.force(arg3, CharSet.class);
                if (!(force4 instanceof CharSet)) {
                    return -786429;
                }
                ctx.value3 = force4;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 23: {
                final Object force5 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force5) == null) {
                    return -786431;
                }
                ctx.value1 = force5;
                final Object force6 = Promise.force(arg2, CharSet.class);
                if (!(force6 instanceof CharSet)) {
                    return -786430;
                }
                ctx.value2 = force6;
                final Object force7 = Promise.force(arg3, CharSet.class);
                if (!(force7 instanceof CharSet)) {
                    return -786429;
                }
                ctx.value3 = force7;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 10: {
                final Object force8 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force8) == null) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.value2 = arg2;
                final Object force9 = Promise.force(arg3, CharSet.class);
                if (!(force9 instanceof CharSet)) {
                    return -786429;
                }
                ctx.value3 = force9;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 29: {
                ctx.value1 = Promise.force(o);
                ctx.value2 = Promise.force(o2);
                final Object force = Promise.force(o3);
                if (!(force instanceof Boolean)) {
                    return -786429;
                }
                ctx.value3 = force;
                final Object force2 = Promise.force(o4, CharSet.class);
                if (!(force2 instanceof CharSet)) {
                    return -786428;
                }
                ctx.value4 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 26: {
                ctx.value1 = Promise.force(o);
                ctx.value2 = Promise.force(o2);
                final Object force3 = Promise.force(o3);
                if (!(force3 instanceof Boolean)) {
                    return -786429;
                }
                ctx.value3 = force3;
                final Object force4 = Promise.force(o4, CharSet.class);
                if (!(force4 instanceof CharSet)) {
                    return -786428;
                }
                ctx.value4 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 11: {
                final Object force5 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force5) == null) {
                    return -786431;
                }
                ctx.value1 = force5;
                final Object force6 = Promise.force(o2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force6) == null) {
                    return -786430;
                }
                ctx.value2 = force6;
                final Object force7 = Promise.force(o3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force7) != null) {
                    ctx.value3 = force7;
                    ctx.value4 = o4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 4;
                    return 0;
                }
                return -786429;
            }
            default: {
                return super.match4(moduleMethod, o, o2, o3, o4, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 52: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 51: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 50: {
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
            case 13: {
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
            case 3: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 2: {
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
        //                4: 112
        //                6: 128
        //                9: 144
        //               16: 170
        //               17: 183
        //               20: 197
        //               30: 219
        //               31: 224
        //               33: 240
        //               34: 253
        //               42: 266
        //               48: 279
        //          default: 292
        //        }
        //   112: aload_2        
        //   113: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   118: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   121: invokestatic    gnu/kawa/slib/srfi14.charSetHash:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //   124: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   127: areturn        
        //   128: aload_2        
        //   129: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   134: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   137: invokestatic    gnu/kawa/slib/srfi14.charSetCursor:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //   140: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   143: areturn        
        //   144: aload_2        
        //   145: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   148: checkcast       Ljava/lang/Number;
        //   151: invokevirtual   java/lang/Number.intValue:()I
        //   154: invokestatic    gnu/kawa/slib/srfi14.isEndOfCharSet:(I)Z
        //   157: ifeq            166
        //   160: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   163: goto            169
        //   166: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   169: areturn        
        //   170: aload_2        
        //   171: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   176: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   179: invokestatic    gnu/kawa/slib/srfi14.charSetCopy:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   182: areturn        
        //   183: aload_2        
        //   184: ldc_w           Lgnu/lists/LList;.class
        //   187: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   190: checkcast       Lgnu/lists/LList;
        //   193: invokestatic    gnu/kawa/slib/srfi14.list$To$CharSet:(Lgnu/lists/LList;)Lgnu/kawa/slib/srfi14$CharSet;
        //   196: areturn        
        //   197: aload_2        
        //   198: ldc             Ljava/lang/String;.class
        //   200: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   203: dup            
        //   204: ifnonnull       212
        //   207: pop            
        //   208: aconst_null    
        //   209: goto            215
        //   212: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   215: invokestatic    gnu/kawa/slib/srfi14.string$To$CharSet:(Ljava/lang/String;)Lgnu/kawa/slib/srfi14$CharSet;
        //   218: areturn        
        //   219: aload_2        
        //   220: invokestatic    gnu/kawa/slib/srfi14.$To$CharSet:(Ljava/lang/Object;)Lgnu/kawa/slib/srfi14$CharSet;
        //   223: areturn        
        //   224: aload_2        
        //   225: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   227: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   230: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   233: invokestatic    gnu/kawa/slib/srfi14.charSetSize:(Lgnu/kawa/slib/srfi14$CharSet;)I
        //   236: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   239: areturn        
        //   240: aload_2        
        //   241: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   243: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   246: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   249: invokestatic    gnu/kawa/slib/srfi14.charSet$To$List:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/lists/LList;
        //   252: areturn        
        //   253: aload_2        
        //   254: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   256: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   259: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   262: invokestatic    gnu/kawa/slib/srfi14.charSet$To$String:(Lgnu/kawa/slib/srfi14$CharSet;)Ljava/lang/String;
        //   265: areturn        
        //   266: aload_2        
        //   267: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   269: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   272: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   275: invokestatic    gnu/kawa/slib/srfi14.charSetComplement:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   278: areturn        
        //   279: aload_2        
        //   280: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   282: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   285: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   288: invokestatic    gnu/kawa/slib/srfi14.charSetComplement$Ex:(Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   291: areturn        
        //   292: aload_0        
        //   293: aload_1        
        //   294: aload_2        
        //   295: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   298: areturn        
        //   299: new             Lgnu/mapping/WrongType;
        //   302: dup_x1         
        //   303: swap           
        //   304: ldc_w           "char-set-hash"
        //   307: iconst_1       
        //   308: aload_2        
        //   309: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   312: athrow         
        //   313: new             Lgnu/mapping/WrongType;
        //   316: dup_x1         
        //   317: swap           
        //   318: ldc_w           "char-set-cursor"
        //   321: iconst_1       
        //   322: aload_2        
        //   323: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   326: athrow         
        //   327: new             Lgnu/mapping/WrongType;
        //   330: dup_x1         
        //   331: swap           
        //   332: ldc             "end-of-char-set?"
        //   334: iconst_1       
        //   335: aload_2        
        //   336: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   339: athrow         
        //   340: new             Lgnu/mapping/WrongType;
        //   343: dup_x1         
        //   344: swap           
        //   345: ldc_w           "char-set-copy"
        //   348: iconst_1       
        //   349: aload_2        
        //   350: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   353: athrow         
        //   354: new             Lgnu/mapping/WrongType;
        //   357: dup_x1         
        //   358: swap           
        //   359: ldc_w           "list->char-set"
        //   362: iconst_1       
        //   363: aload_2        
        //   364: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   367: athrow         
        //   368: new             Lgnu/mapping/WrongType;
        //   371: dup_x1         
        //   372: swap           
        //   373: ldc_w           "char-set-size"
        //   376: iconst_1       
        //   377: aload_2        
        //   378: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   381: athrow         
        //   382: new             Lgnu/mapping/WrongType;
        //   385: dup_x1         
        //   386: swap           
        //   387: ldc_w           "char-set->list"
        //   390: iconst_1       
        //   391: aload_2        
        //   392: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   395: athrow         
        //   396: new             Lgnu/mapping/WrongType;
        //   399: dup_x1         
        //   400: swap           
        //   401: ldc_w           "char-set->string"
        //   404: iconst_1       
        //   405: aload_2        
        //   406: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   409: athrow         
        //   410: new             Lgnu/mapping/WrongType;
        //   413: dup_x1         
        //   414: swap           
        //   415: ldc_w           "char-set-complement"
        //   418: iconst_1       
        //   419: aload_2        
        //   420: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   423: athrow         
        //   424: new             Lgnu/mapping/WrongType;
        //   427: dup_x1         
        //   428: swap           
        //   429: ldc_w           "char-set-complement!"
        //   432: iconst_1       
        //   433: aload_2        
        //   434: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   437: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  118    121    299    313    Ljava/lang/ClassCastException;
        //  134    137    313    327    Ljava/lang/ClassCastException;
        //  148    154    327    340    Ljava/lang/ClassCastException;
        //  176    179    340    354    Ljava/lang/ClassCastException;
        //  190    193    354    368    Ljava/lang/ClassCastException;
        //  230    233    368    382    Ljava/lang/ClassCastException;
        //  246    249    382    396    Ljava/lang/ClassCastException;
        //  259    262    396    410    Ljava/lang/ClassCastException;
        //  272    275    410    424    Ljava/lang/ClassCastException;
        //  285    288    424    438    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 169 out of bounds for length 169
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
        //                4: 160
        //                7: 186
        //                8: 212
        //               14: 238
        //               15: 260
        //               17: 282
        //               19: 305
        //               20: 328
        //               22: 359
        //               23: 390
        //               26: 412
        //               32: 436
        //               35: 461
        //               36: 493
        //               37: 527
        //               53: 549
        //               54: 573
        //               55: 597
        //          default: 621
        //        }
        //   160: aload_2        
        //   161: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   163: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   166: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   169: aload_3        
        //   170: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   173: checkcast       Ljava/lang/Number;
        //   176: invokevirtual   java/lang/Number.intValue:()I
        //   179: invokestatic    gnu/kawa/slib/srfi14.charSetHash:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //   182: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   185: areturn        
        //   186: aload_2        
        //   187: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   189: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   192: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   195: aload_3        
        //   196: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   199: checkcast       Ljava/lang/Number;
        //   202: invokevirtual   java/lang/Number.intValue:()I
        //   205: invokestatic    gnu/kawa/slib/srfi14.charSetRef:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //   208: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   211: areturn        
        //   212: aload_2        
        //   213: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   215: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   218: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   221: aload_3        
        //   222: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   225: checkcast       Ljava/lang/Number;
        //   228: invokevirtual   java/lang/Number.intValue:()I
        //   231: invokestatic    gnu/kawa/slib/srfi14.charSetCursorNext:(Lgnu/kawa/slib/srfi14$CharSet;I)I
        //   234: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   237: areturn        
        //   238: aload_2        
        //   239: ldc             Lgnu/mapping/Procedure;.class
        //   241: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   244: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   247: aload_3        
        //   248: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   250: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   253: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   256: invokestatic    gnu/kawa/slib/srfi14.charSetForEach:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Ljava/lang/Object;
        //   259: areturn        
        //   260: aload_2        
        //   261: ldc             Lgnu/mapping/Procedure;.class
        //   263: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   266: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   269: aload_3        
        //   270: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   272: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   275: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   278: invokestatic    gnu/kawa/slib/srfi14.charSetMap:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   281: areturn        
        //   282: aload_2        
        //   283: ldc_w           Lgnu/lists/LList;.class
        //   286: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   289: checkcast       Lgnu/lists/LList;
        //   292: aload_3        
        //   293: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   295: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   298: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   301: invokestatic    gnu/kawa/slib/srfi14.list$To$CharSet:(Lgnu/lists/LList;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   304: areturn        
        //   305: aload_2        
        //   306: ldc_w           Lgnu/lists/LList;.class
        //   309: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   312: checkcast       Lgnu/lists/LList;
        //   315: aload_3        
        //   316: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   318: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   321: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   324: invokestatic    gnu/kawa/slib/srfi14.list$To$CharSet$Ex:(Lgnu/lists/LList;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   327: areturn        
        //   328: aload_2        
        //   329: ldc             Ljava/lang/String;.class
        //   331: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   334: dup            
        //   335: ifnonnull       343
        //   338: pop            
        //   339: aconst_null    
        //   340: goto            346
        //   343: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   346: aload_3        
        //   347: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   349: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   352: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   355: invokestatic    gnu/kawa/slib/srfi14.string$To$CharSet:(Ljava/lang/String;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   358: areturn        
        //   359: aload_2        
        //   360: ldc             Ljava/lang/String;.class
        //   362: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   365: dup            
        //   366: ifnonnull       374
        //   369: pop            
        //   370: aconst_null    
        //   371: goto            377
        //   374: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   377: aload_3        
        //   378: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   380: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   383: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   386: invokestatic    gnu/kawa/slib/srfi14.string$To$CharSet$Ex:(Ljava/lang/String;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   389: areturn        
        //   390: aload_2        
        //   391: ldc             Lgnu/mapping/Procedure;.class
        //   393: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   396: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   399: aload_3        
        //   400: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   402: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   405: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   408: invokestatic    gnu/kawa/slib/srfi14.charSetFilter:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   411: areturn        
        //   412: aload_2        
        //   413: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   416: checkcast       Ljava/lang/Number;
        //   419: invokevirtual   java/lang/Number.intValue:()I
        //   422: aload_3        
        //   423: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   426: checkcast       Ljava/lang/Number;
        //   429: invokevirtual   java/lang/Number.intValue:()I
        //   432: invokestatic    gnu/kawa/slib/srfi14.ucsRange$To$CharSet:(II)Lgnu/kawa/slib/srfi14$CharSet;
        //   435: areturn        
        //   436: aload_2        
        //   437: ldc             Lgnu/mapping/Procedure;.class
        //   439: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   442: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   445: aload_3        
        //   446: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   448: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   451: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   454: invokestatic    gnu/kawa/slib/srfi14.charSetCount:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)I
        //   457: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   460: areturn        
        //   461: aload_2        
        //   462: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   464: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   467: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   470: aload_3        
        //   471: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   474: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   477: invokestatic    gnu/kawa/slib/srfi14.isCharSetContains:(Lgnu/kawa/slib/srfi14$CharSet;I)Z
        //   480: ifeq            489
        //   483: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   486: goto            492
        //   489: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   492: areturn        
        //   493: aload_2        
        //   494: ldc             Lgnu/mapping/Procedure;.class
        //   496: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   499: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   502: aload_3        
        //   503: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   505: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   508: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   511: invokestatic    gnu/kawa/slib/srfi14.charSetEvery:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Z
        //   514: ifeq            523
        //   517: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   520: goto            526
        //   523: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   526: areturn        
        //   527: aload_2        
        //   528: ldc             Lgnu/mapping/Procedure;.class
        //   530: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   533: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   536: aload_3        
        //   537: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   539: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   542: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   545: invokestatic    gnu/kawa/slib/srfi14.charSetAny:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;)Ljava/lang/Object;
        //   548: areturn        
        //   549: aload_2        
        //   550: ldc_w           Lgnu/lists/LList;.class
        //   553: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   556: checkcast       Lgnu/lists/LList;
        //   559: aload_3        
        //   560: ldc_w           Lgnu/lists/LList;.class
        //   563: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   566: checkcast       Lgnu/lists/LList;
        //   569: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsIntersection:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   572: areturn        
        //   573: aload_2        
        //   574: ldc_w           Lgnu/lists/LList;.class
        //   577: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   580: checkcast       Lgnu/lists/LList;
        //   583: aload_3        
        //   584: ldc_w           Lgnu/lists/LList;.class
        //   587: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   590: checkcast       Lgnu/lists/LList;
        //   593: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsUnion:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   596: areturn        
        //   597: aload_2        
        //   598: ldc_w           Lgnu/lists/LList;.class
        //   601: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   604: checkcast       Lgnu/lists/LList;
        //   607: aload_3        
        //   608: ldc_w           Lgnu/lists/LList;.class
        //   611: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   614: checkcast       Lgnu/lists/LList;
        //   617: invokestatic    gnu/kawa/slib/srfi14.$PcBoundaryPairsXor:(Lgnu/lists/LList;Lgnu/lists/LList;)Lgnu/lists/LList;
        //   620: areturn        
        //   621: aload_0        
        //   622: aload_1        
        //   623: aload_2        
        //   624: aload_3        
        //   625: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   628: areturn        
        //   629: new             Lgnu/mapping/WrongType;
        //   632: dup_x1         
        //   633: swap           
        //   634: ldc_w           "char-set-hash"
        //   637: iconst_1       
        //   638: aload_2        
        //   639: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   642: athrow         
        //   643: new             Lgnu/mapping/WrongType;
        //   646: dup_x1         
        //   647: swap           
        //   648: ldc_w           "char-set-hash"
        //   651: iconst_2       
        //   652: aload_3        
        //   653: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   656: athrow         
        //   657: new             Lgnu/mapping/WrongType;
        //   660: dup_x1         
        //   661: swap           
        //   662: ldc             "char-set-ref"
        //   664: iconst_1       
        //   665: aload_2        
        //   666: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   669: athrow         
        //   670: new             Lgnu/mapping/WrongType;
        //   673: dup_x1         
        //   674: swap           
        //   675: ldc             "char-set-ref"
        //   677: iconst_2       
        //   678: aload_3        
        //   679: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   682: athrow         
        //   683: new             Lgnu/mapping/WrongType;
        //   686: dup_x1         
        //   687: swap           
        //   688: ldc             "char-set-cursor-next"
        //   690: iconst_1       
        //   691: aload_2        
        //   692: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   695: athrow         
        //   696: new             Lgnu/mapping/WrongType;
        //   699: dup_x1         
        //   700: swap           
        //   701: ldc             "char-set-cursor-next"
        //   703: iconst_2       
        //   704: aload_3        
        //   705: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   708: athrow         
        //   709: new             Lgnu/mapping/WrongType;
        //   712: dup_x1         
        //   713: swap           
        //   714: ldc_w           "char-set-for-each"
        //   717: iconst_1       
        //   718: aload_2        
        //   719: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   722: athrow         
        //   723: new             Lgnu/mapping/WrongType;
        //   726: dup_x1         
        //   727: swap           
        //   728: ldc_w           "char-set-for-each"
        //   731: iconst_2       
        //   732: aload_3        
        //   733: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   736: athrow         
        //   737: new             Lgnu/mapping/WrongType;
        //   740: dup_x1         
        //   741: swap           
        //   742: ldc_w           "char-set-map"
        //   745: iconst_1       
        //   746: aload_2        
        //   747: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   750: athrow         
        //   751: new             Lgnu/mapping/WrongType;
        //   754: dup_x1         
        //   755: swap           
        //   756: ldc_w           "char-set-map"
        //   759: iconst_2       
        //   760: aload_3        
        //   761: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   764: athrow         
        //   765: new             Lgnu/mapping/WrongType;
        //   768: dup_x1         
        //   769: swap           
        //   770: ldc_w           "list->char-set"
        //   773: iconst_1       
        //   774: aload_2        
        //   775: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   778: athrow         
        //   779: new             Lgnu/mapping/WrongType;
        //   782: dup_x1         
        //   783: swap           
        //   784: ldc_w           "list->char-set"
        //   787: iconst_2       
        //   788: aload_3        
        //   789: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   792: athrow         
        //   793: new             Lgnu/mapping/WrongType;
        //   796: dup_x1         
        //   797: swap           
        //   798: ldc_w           "list->char-set!"
        //   801: iconst_1       
        //   802: aload_2        
        //   803: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   806: athrow         
        //   807: new             Lgnu/mapping/WrongType;
        //   810: dup_x1         
        //   811: swap           
        //   812: ldc_w           "list->char-set!"
        //   815: iconst_2       
        //   816: aload_3        
        //   817: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   820: athrow         
        //   821: new             Lgnu/mapping/WrongType;
        //   824: dup_x1         
        //   825: swap           
        //   826: ldc_w           "string->char-set"
        //   829: iconst_2       
        //   830: aload_3        
        //   831: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   834: athrow         
        //   835: new             Lgnu/mapping/WrongType;
        //   838: dup_x1         
        //   839: swap           
        //   840: ldc_w           "string->char-set!"
        //   843: iconst_2       
        //   844: aload_3        
        //   845: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   848: athrow         
        //   849: new             Lgnu/mapping/WrongType;
        //   852: dup_x1         
        //   853: swap           
        //   854: ldc_w           "char-set-filter"
        //   857: iconst_1       
        //   858: aload_2        
        //   859: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   862: athrow         
        //   863: new             Lgnu/mapping/WrongType;
        //   866: dup_x1         
        //   867: swap           
        //   868: ldc_w           "char-set-filter"
        //   871: iconst_2       
        //   872: aload_3        
        //   873: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   876: athrow         
        //   877: new             Lgnu/mapping/WrongType;
        //   880: dup_x1         
        //   881: swap           
        //   882: ldc_w           "ucs-range->char-set"
        //   885: iconst_1       
        //   886: aload_2        
        //   887: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   890: athrow         
        //   891: new             Lgnu/mapping/WrongType;
        //   894: dup_x1         
        //   895: swap           
        //   896: ldc_w           "ucs-range->char-set"
        //   899: iconst_2       
        //   900: aload_3        
        //   901: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   904: athrow         
        //   905: new             Lgnu/mapping/WrongType;
        //   908: dup_x1         
        //   909: swap           
        //   910: ldc_w           "char-set-count"
        //   913: iconst_1       
        //   914: aload_2        
        //   915: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   918: athrow         
        //   919: new             Lgnu/mapping/WrongType;
        //   922: dup_x1         
        //   923: swap           
        //   924: ldc_w           "char-set-count"
        //   927: iconst_2       
        //   928: aload_3        
        //   929: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   932: athrow         
        //   933: new             Lgnu/mapping/WrongType;
        //   936: dup_x1         
        //   937: swap           
        //   938: ldc_w           "char-set-contains?"
        //   941: iconst_1       
        //   942: aload_2        
        //   943: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   946: athrow         
        //   947: new             Lgnu/mapping/WrongType;
        //   950: dup_x1         
        //   951: swap           
        //   952: ldc_w           "char-set-contains?"
        //   955: iconst_2       
        //   956: aload_3        
        //   957: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   960: athrow         
        //   961: new             Lgnu/mapping/WrongType;
        //   964: dup_x1         
        //   965: swap           
        //   966: ldc_w           "char-set-every"
        //   969: iconst_1       
        //   970: aload_2        
        //   971: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   974: athrow         
        //   975: new             Lgnu/mapping/WrongType;
        //   978: dup_x1         
        //   979: swap           
        //   980: ldc_w           "char-set-every"
        //   983: iconst_2       
        //   984: aload_3        
        //   985: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   988: athrow         
        //   989: new             Lgnu/mapping/WrongType;
        //   992: dup_x1         
        //   993: swap           
        //   994: ldc_w           "char-set-any"
        //   997: iconst_1       
        //   998: aload_2        
        //   999: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1002: athrow         
        //  1003: new             Lgnu/mapping/WrongType;
        //  1006: dup_x1         
        //  1007: swap           
        //  1008: ldc_w           "char-set-any"
        //  1011: iconst_2       
        //  1012: aload_3        
        //  1013: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1016: athrow         
        //  1017: new             Lgnu/mapping/WrongType;
        //  1020: dup_x1         
        //  1021: swap           
        //  1022: ldc_w           "%boundary-pairs-intersection"
        //  1025: iconst_1       
        //  1026: aload_2        
        //  1027: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1030: athrow         
        //  1031: new             Lgnu/mapping/WrongType;
        //  1034: dup_x1         
        //  1035: swap           
        //  1036: ldc_w           "%boundary-pairs-intersection"
        //  1039: iconst_2       
        //  1040: aload_3        
        //  1041: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1044: athrow         
        //  1045: new             Lgnu/mapping/WrongType;
        //  1048: dup_x1         
        //  1049: swap           
        //  1050: ldc_w           "%boundary-pairs-union"
        //  1053: iconst_1       
        //  1054: aload_2        
        //  1055: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1058: athrow         
        //  1059: new             Lgnu/mapping/WrongType;
        //  1062: dup_x1         
        //  1063: swap           
        //  1064: ldc_w           "%boundary-pairs-union"
        //  1067: iconst_2       
        //  1068: aload_3        
        //  1069: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1072: athrow         
        //  1073: new             Lgnu/mapping/WrongType;
        //  1076: dup_x1         
        //  1077: swap           
        //  1078: ldc_w           "%boundary-pairs-xor"
        //  1081: iconst_1       
        //  1082: aload_2        
        //  1083: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1086: athrow         
        //  1087: new             Lgnu/mapping/WrongType;
        //  1090: dup_x1         
        //  1091: swap           
        //  1092: ldc_w           "%boundary-pairs-xor"
        //  1095: iconst_2       
        //  1096: aload_3        
        //  1097: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1100: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  166    169    629    643    Ljava/lang/ClassCastException;
        //  173    179    643    657    Ljava/lang/ClassCastException;
        //  192    195    657    670    Ljava/lang/ClassCastException;
        //  199    205    670    683    Ljava/lang/ClassCastException;
        //  218    221    683    696    Ljava/lang/ClassCastException;
        //  225    231    696    709    Ljava/lang/ClassCastException;
        //  244    247    709    723    Ljava/lang/ClassCastException;
        //  253    256    723    737    Ljava/lang/ClassCastException;
        //  266    269    737    751    Ljava/lang/ClassCastException;
        //  275    278    751    765    Ljava/lang/ClassCastException;
        //  289    292    765    779    Ljava/lang/ClassCastException;
        //  298    301    779    793    Ljava/lang/ClassCastException;
        //  312    315    793    807    Ljava/lang/ClassCastException;
        //  321    324    807    821    Ljava/lang/ClassCastException;
        //  352    355    821    835    Ljava/lang/ClassCastException;
        //  383    386    835    849    Ljava/lang/ClassCastException;
        //  396    399    849    863    Ljava/lang/ClassCastException;
        //  405    408    863    877    Ljava/lang/ClassCastException;
        //  416    422    877    891    Ljava/lang/ClassCastException;
        //  426    432    891    905    Ljava/lang/ClassCastException;
        //  442    445    905    919    Ljava/lang/ClassCastException;
        //  451    454    919    933    Ljava/lang/ClassCastException;
        //  467    470    933    947    Ljava/lang/ClassCastException;
        //  474    477    947    961    Ljava/lang/ClassCastException;
        //  499    502    961    975    Ljava/lang/ClassCastException;
        //  508    511    975    989    Ljava/lang/ClassCastException;
        //  533    536    989    1003   Ljava/lang/ClassCastException;
        //  542    545    1003   1017   Ljava/lang/ClassCastException;
        //  556    559    1017   1031   Ljava/lang/ClassCastException;
        //  566    569    1031   1045   Ljava/lang/ClassCastException;
        //  580    583    1045   1059   Ljava/lang/ClassCastException;
        //  590    593    1059   1073   Ljava/lang/ClassCastException;
        //  604    607    1073   1087   Ljava/lang/ClassCastException;
        //  614    617    1087   1101   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 482 out of bounds for length 482
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
        //               10: 48
        //               23: 72
        //               25: 104
        //               26: 136
        //          default: 176
        //        }
        //    48: aload_2        
        //    49: ldc             Lgnu/mapping/Procedure;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    57: aload_3        
        //    58: aload           4
        //    60: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    65: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //    68: invokestatic    gnu/kawa/slib/srfi14.charSetFold:(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/srfi14$CharSet;)Ljava/lang/Object;
        //    71: areturn        
        //    72: aload_2        
        //    73: ldc             Lgnu/mapping/Procedure;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    81: aload_3        
        //    82: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //    84: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    87: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //    90: aload           4
        //    92: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //    94: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    97: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   100: invokestatic    gnu/kawa/slib/srfi14.charSetFilter:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   103: areturn        
        //   104: aload_2        
        //   105: ldc             Lgnu/mapping/Procedure;.class
        //   107: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   110: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   113: aload_3        
        //   114: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   119: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   122: aload           4
        //   124: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   129: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   132: invokestatic    gnu/kawa/slib/srfi14.charSetFilter$Ex:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/srfi14$CharSet;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   135: areturn        
        //   136: aload_2        
        //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   140: checkcast       Ljava/lang/Number;
        //   143: invokevirtual   java/lang/Number.intValue:()I
        //   146: aload_3        
        //   147: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: checkcast       Ljava/lang/Number;
        //   153: invokevirtual   java/lang/Number.intValue:()I
        //   156: aload           4
        //   158: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   161: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   164: ifeq            171
        //   167: iconst_1       
        //   168: goto            172
        //   171: iconst_0       
        //   172: invokestatic    gnu/kawa/slib/srfi14.ucsRange$To$CharSet:(IIZ)Lgnu/kawa/slib/srfi14$CharSet;
        //   175: areturn        
        //   176: aload_0        
        //   177: aload_1        
        //   178: aload_2        
        //   179: aload_3        
        //   180: aload           4
        //   182: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   185: areturn        
        //   186: new             Lgnu/mapping/WrongType;
        //   189: dup_x1         
        //   190: swap           
        //   191: ldc_w           "char-set-fold"
        //   194: iconst_1       
        //   195: aload_2        
        //   196: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   199: athrow         
        //   200: new             Lgnu/mapping/WrongType;
        //   203: dup_x1         
        //   204: swap           
        //   205: ldc_w           "char-set-fold"
        //   208: iconst_3       
        //   209: aload           4
        //   211: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   214: athrow         
        //   215: new             Lgnu/mapping/WrongType;
        //   218: dup_x1         
        //   219: swap           
        //   220: ldc_w           "char-set-filter"
        //   223: iconst_1       
        //   224: aload_2        
        //   225: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   228: athrow         
        //   229: new             Lgnu/mapping/WrongType;
        //   232: dup_x1         
        //   233: swap           
        //   234: ldc_w           "char-set-filter"
        //   237: iconst_2       
        //   238: aload_3        
        //   239: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   242: athrow         
        //   243: new             Lgnu/mapping/WrongType;
        //   246: dup_x1         
        //   247: swap           
        //   248: ldc_w           "char-set-filter"
        //   251: iconst_3       
        //   252: aload           4
        //   254: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   257: athrow         
        //   258: new             Lgnu/mapping/WrongType;
        //   261: dup_x1         
        //   262: swap           
        //   263: ldc_w           "char-set-filter!"
        //   266: iconst_1       
        //   267: aload_2        
        //   268: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   271: athrow         
        //   272: new             Lgnu/mapping/WrongType;
        //   275: dup_x1         
        //   276: swap           
        //   277: ldc_w           "char-set-filter!"
        //   280: iconst_2       
        //   281: aload_3        
        //   282: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   285: athrow         
        //   286: new             Lgnu/mapping/WrongType;
        //   289: dup_x1         
        //   290: swap           
        //   291: ldc_w           "char-set-filter!"
        //   294: iconst_3       
        //   295: aload           4
        //   297: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   300: athrow         
        //   301: new             Lgnu/mapping/WrongType;
        //   304: dup_x1         
        //   305: swap           
        //   306: ldc_w           "ucs-range->char-set"
        //   309: iconst_1       
        //   310: aload_2        
        //   311: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   314: athrow         
        //   315: new             Lgnu/mapping/WrongType;
        //   318: dup_x1         
        //   319: swap           
        //   320: ldc_w           "ucs-range->char-set"
        //   323: iconst_2       
        //   324: aload_3        
        //   325: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   328: athrow         
        //   329: new             Lgnu/mapping/WrongType;
        //   332: dup_x1         
        //   333: swap           
        //   334: ldc_w           "ucs-range->char-set"
        //   337: iconst_3       
        //   338: aload           4
        //   340: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   343: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  54     57     186    200    Ljava/lang/ClassCastException;
        //  65     68     200    215    Ljava/lang/ClassCastException;
        //  78     81     215    229    Ljava/lang/ClassCastException;
        //  87     90     229    243    Ljava/lang/ClassCastException;
        //  97     100    243    258    Ljava/lang/ClassCastException;
        //  110    113    258    272    Ljava/lang/ClassCastException;
        //  119    122    272    286    Ljava/lang/ClassCastException;
        //  129    132    286    301    Ljava/lang/ClassCastException;
        //  140    146    301    315    Ljava/lang/ClassCastException;
        //  150    156    315    329    Ljava/lang/ClassCastException;
        //  161    172    329    344    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 154 out of bounds for length 154
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
        //               11: 40
        //               26: 74
        //               29: 124
        //          default: 174
        //        }
        //    40: aload_2        
        //    41: ldc             Lgnu/mapping/Procedure;.class
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    46: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    49: aload_3        
        //    50: ldc             Lgnu/mapping/Procedure;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    58: aload           4
        //    60: ldc             Lgnu/mapping/Procedure;.class
        //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    65: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    68: aload           5
        //    70: invokestatic    gnu/kawa/slib/srfi14.charSetUnfold:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Lgnu/kawa/slib/srfi14$CharSet;
        //    73: areturn        
        //    74: aload_2        
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    78: checkcast       Ljava/lang/Number;
        //    81: invokevirtual   java/lang/Number.intValue:()I
        //    84: aload_3        
        //    85: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    88: checkcast       Ljava/lang/Number;
        //    91: invokevirtual   java/lang/Number.intValue:()I
        //    94: aload           4
        //    96: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    99: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   102: ifeq            109
        //   105: iconst_1       
        //   106: goto            110
        //   109: iconst_0       
        //   110: aload           5
        //   112: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   120: invokestatic    gnu/kawa/slib/srfi14.ucsRange$To$CharSet:(IIZLgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   123: areturn        
        //   124: aload_2        
        //   125: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   128: checkcast       Ljava/lang/Number;
        //   131: invokevirtual   java/lang/Number.intValue:()I
        //   134: aload_3        
        //   135: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   138: checkcast       Ljava/lang/Number;
        //   141: invokevirtual   java/lang/Number.intValue:()I
        //   144: aload           4
        //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   149: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   152: ifeq            159
        //   155: iconst_1       
        //   156: goto            160
        //   159: iconst_0       
        //   160: aload           5
        //   162: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   164: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   167: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   170: invokestatic    gnu/kawa/slib/srfi14.ucsRange$To$CharSet$Ex:(IIZLgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   173: areturn        
        //   174: aload_0        
        //   175: aload_1        
        //   176: aload_2        
        //   177: aload_3        
        //   178: aload           4
        //   180: aload           5
        //   182: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   185: areturn        
        //   186: new             Lgnu/mapping/WrongType;
        //   189: dup_x1         
        //   190: swap           
        //   191: ldc_w           "char-set-unfold"
        //   194: iconst_1       
        //   195: aload_2        
        //   196: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   199: athrow         
        //   200: new             Lgnu/mapping/WrongType;
        //   203: dup_x1         
        //   204: swap           
        //   205: ldc_w           "char-set-unfold"
        //   208: iconst_2       
        //   209: aload_3        
        //   210: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   213: athrow         
        //   214: new             Lgnu/mapping/WrongType;
        //   217: dup_x1         
        //   218: swap           
        //   219: ldc_w           "char-set-unfold"
        //   222: iconst_3       
        //   223: aload           4
        //   225: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   228: athrow         
        //   229: new             Lgnu/mapping/WrongType;
        //   232: dup_x1         
        //   233: swap           
        //   234: ldc_w           "ucs-range->char-set"
        //   237: iconst_1       
        //   238: aload_2        
        //   239: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   242: athrow         
        //   243: new             Lgnu/mapping/WrongType;
        //   246: dup_x1         
        //   247: swap           
        //   248: ldc_w           "ucs-range->char-set"
        //   251: iconst_2       
        //   252: aload_3        
        //   253: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   256: athrow         
        //   257: new             Lgnu/mapping/WrongType;
        //   260: dup_x1         
        //   261: swap           
        //   262: ldc_w           "ucs-range->char-set"
        //   265: iconst_3       
        //   266: aload           4
        //   268: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   271: athrow         
        //   272: new             Lgnu/mapping/WrongType;
        //   275: dup_x1         
        //   276: swap           
        //   277: ldc_w           "ucs-range->char-set"
        //   280: iconst_4       
        //   281: aload           5
        //   283: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   286: athrow         
        //   287: new             Lgnu/mapping/WrongType;
        //   290: dup_x1         
        //   291: swap           
        //   292: ldc_w           "ucs-range->char-set!"
        //   295: iconst_1       
        //   296: aload_2        
        //   297: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   300: athrow         
        //   301: new             Lgnu/mapping/WrongType;
        //   304: dup_x1         
        //   305: swap           
        //   306: ldc_w           "ucs-range->char-set!"
        //   309: iconst_2       
        //   310: aload_3        
        //   311: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   314: athrow         
        //   315: new             Lgnu/mapping/WrongType;
        //   318: dup_x1         
        //   319: swap           
        //   320: ldc_w           "ucs-range->char-set!"
        //   323: iconst_3       
        //   324: aload           4
        //   326: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   329: athrow         
        //   330: new             Lgnu/mapping/WrongType;
        //   333: dup_x1         
        //   334: swap           
        //   335: ldc_w           "ucs-range->char-set!"
        //   338: iconst_4       
        //   339: aload           5
        //   341: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   344: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  46     49     186    200    Ljava/lang/ClassCastException;
        //  55     58     200    214    Ljava/lang/ClassCastException;
        //  65     68     214    229    Ljava/lang/ClassCastException;
        //  78     84     229    243    Ljava/lang/ClassCastException;
        //  88     94     243    257    Ljava/lang/ClassCastException;
        //  99     110    257    272    Ljava/lang/ClassCastException;
        //  117    120    272    287    Ljava/lang/ClassCastException;
        //  128    134    287    301    Ljava/lang/ClassCastException;
        //  138    144    301    315    Ljava/lang/ClassCastException;
        //  149    160    315    330    Ljava/lang/ClassCastException;
        //  167    170    330    345    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 156 out of bounds for length 156
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
        //     4: lookupswitch {
        //                2: 152
        //                3: 197
        //               11: 242
        //               13: 323
        //               38: 386
        //               39: 441
        //               40: 496
        //               41: 551
        //               43: 606
        //               44: 644
        //               45: 682
        //               46: 738
        //               47: 776
        //               49: 846
        //               50: 884
        //               51: 922
        //               52: 978
        //          default: 1016
        //        }
        //   152: aload_2        
        //   153: arraylength    
        //   154: istore_3       
        //   155: iload_3        
        //   156: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   159: goto            174
        //   162: dup            
        //   163: iload_3        
        //   164: aload_2        
        //   165: iload_3        
        //   166: aaload         
        //   167: dup            
        //   168: astore          4
        //   170: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   173: aastore        
        //   174: iinc            3, -1
        //   177: iload_3        
        //   178: ifge            162
        //   181: invokestatic    gnu/kawa/slib/srfi14.charSet$Eq:([Lgnu/kawa/slib/srfi14$CharSet;)Z
        //   184: ifeq            193
        //   187: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   190: goto            196
        //   193: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   196: areturn        
        //   197: aload_2        
        //   198: arraylength    
        //   199: istore_3       
        //   200: iload_3        
        //   201: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   204: goto            219
        //   207: dup            
        //   208: iload_3        
        //   209: aload_2        
        //   210: iload_3        
        //   211: aaload         
        //   212: dup            
        //   213: astore          4
        //   215: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   218: aastore        
        //   219: iinc            3, -1
        //   222: iload_3        
        //   223: ifge            207
        //   226: invokestatic    gnu/kawa/slib/srfi14.charSet$Ls$Eq:([Lgnu/kawa/slib/srfi14$CharSet;)Z
        //   229: ifeq            238
        //   232: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   235: goto            241
        //   238: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   241: areturn        
        //   242: aload_2        
        //   243: arraylength    
        //   244: iconst_4       
        //   245: isub           
        //   246: istore_3       
        //   247: aload_2        
        //   248: iconst_0       
        //   249: aaload         
        //   250: ldc             Lgnu/mapping/Procedure;.class
        //   252: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   255: dup            
        //   256: astore          4
        //   258: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   261: aload_2        
        //   262: iconst_1       
        //   263: aaload         
        //   264: ldc             Lgnu/mapping/Procedure;.class
        //   266: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   269: dup            
        //   270: astore          4
        //   272: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   275: aload_2        
        //   276: iconst_2       
        //   277: aaload         
        //   278: ldc             Lgnu/mapping/Procedure;.class
        //   280: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   283: dup            
        //   284: astore          4
        //   286: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   289: aload_2        
        //   290: iconst_3       
        //   291: aaload         
        //   292: iload_3        
        //   293: ifgt            302
        //   296: invokestatic    gnu/kawa/slib/srfi14.charSetUnfold:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Lgnu/kawa/slib/srfi14$CharSet;
        //   299: goto            322
        //   302: iinc            3, -1
        //   305: aload_2        
        //   306: iconst_4       
        //   307: aaload         
        //   308: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   310: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   313: dup            
        //   314: astore          4
        //   316: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   319: invokestatic    gnu/kawa/slib/srfi14.charSetUnfold:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   322: areturn        
        //   323: aload_2        
        //   324: iconst_0       
        //   325: aaload         
        //   326: ldc             Lgnu/mapping/Procedure;.class
        //   328: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   331: dup            
        //   332: astore          4
        //   334: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   337: aload_2        
        //   338: iconst_1       
        //   339: aaload         
        //   340: ldc             Lgnu/mapping/Procedure;.class
        //   342: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   345: dup            
        //   346: astore          4
        //   348: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   351: aload_2        
        //   352: iconst_2       
        //   353: aaload         
        //   354: ldc             Lgnu/mapping/Procedure;.class
        //   356: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   359: dup            
        //   360: astore          4
        //   362: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   365: aload_2        
        //   366: iconst_3       
        //   367: aaload         
        //   368: aload_2        
        //   369: iconst_4       
        //   370: aaload         
        //   371: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   373: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   376: dup            
        //   377: astore          4
        //   379: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   382: invokestatic    gnu/kawa/slib/srfi14.charSetUnfold$Ex:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   385: areturn        
        //   386: aload_2        
        //   387: iconst_0       
        //   388: aaload         
        //   389: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   391: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   394: dup            
        //   395: astore          4
        //   397: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   400: aload_2        
        //   401: arraylength    
        //   402: iconst_1       
        //   403: isub           
        //   404: istore          4
        //   406: iload           4
        //   408: newarray        I
        //   410: goto            429
        //   413: dup            
        //   414: iload           4
        //   416: aload_2        
        //   417: iload           4
        //   419: iconst_1       
        //   420: iadd           
        //   421: aaload         
        //   422: dup            
        //   423: astore          5
        //   425: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   428: iastore        
        //   429: iinc            4, -1
        //   432: iload           4
        //   434: ifge            413
        //   437: invokestatic    gnu/kawa/slib/srfi14.charSetAdjoin:(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
        //   440: areturn        
        //   441: aload_2        
        //   442: iconst_0       
        //   443: aaload         
        //   444: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   446: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   449: dup            
        //   450: astore          4
        //   452: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   455: aload_2        
        //   456: arraylength    
        //   457: iconst_1       
        //   458: isub           
        //   459: istore          4
        //   461: iload           4
        //   463: newarray        I
        //   465: goto            484
        //   468: dup            
        //   469: iload           4
        //   471: aload_2        
        //   472: iload           4
        //   474: iconst_1       
        //   475: iadd           
        //   476: aaload         
        //   477: dup            
        //   478: astore          5
        //   480: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   483: iastore        
        //   484: iinc            4, -1
        //   487: iload           4
        //   489: ifge            468
        //   492: invokestatic    gnu/kawa/slib/srfi14.charSetDelete:(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
        //   495: areturn        
        //   496: aload_2        
        //   497: iconst_0       
        //   498: aaload         
        //   499: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   501: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   504: dup            
        //   505: astore          4
        //   507: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   510: aload_2        
        //   511: arraylength    
        //   512: iconst_1       
        //   513: isub           
        //   514: istore          4
        //   516: iload           4
        //   518: newarray        I
        //   520: goto            539
        //   523: dup            
        //   524: iload           4
        //   526: aload_2        
        //   527: iload           4
        //   529: iconst_1       
        //   530: iadd           
        //   531: aaload         
        //   532: dup            
        //   533: astore          5
        //   535: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   538: iastore        
        //   539: iinc            4, -1
        //   542: iload           4
        //   544: ifge            523
        //   547: invokestatic    gnu/kawa/slib/srfi14.charSetAdjoin$Ex:(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
        //   550: areturn        
        //   551: aload_2        
        //   552: iconst_0       
        //   553: aaload         
        //   554: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   556: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   559: dup            
        //   560: astore          4
        //   562: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   565: aload_2        
        //   566: arraylength    
        //   567: iconst_1       
        //   568: isub           
        //   569: istore          4
        //   571: iload           4
        //   573: newarray        I
        //   575: goto            594
        //   578: dup            
        //   579: iload           4
        //   581: aload_2        
        //   582: iload           4
        //   584: iconst_1       
        //   585: iadd           
        //   586: aaload         
        //   587: dup            
        //   588: astore          5
        //   590: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   593: iastore        
        //   594: iinc            4, -1
        //   597: iload           4
        //   599: ifge            578
        //   602: invokestatic    gnu/kawa/slib/srfi14.charSetDelete$Ex:(Lgnu/kawa/slib/srfi14$CharSet;[I)Lgnu/kawa/slib/srfi14$CharSet;
        //   605: areturn        
        //   606: aload_2        
        //   607: arraylength    
        //   608: istore          4
        //   610: iload           4
        //   612: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   615: goto            632
        //   618: dup            
        //   619: iload           4
        //   621: aload_2        
        //   622: iload           4
        //   624: aaload         
        //   625: dup            
        //   626: astore          5
        //   628: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   631: aastore        
        //   632: iinc            4, -1
        //   635: iload           4
        //   637: ifge            618
        //   640: invokestatic    gnu/kawa/slib/srfi14.charSetUnion:([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   643: areturn        
        //   644: aload_2        
        //   645: arraylength    
        //   646: istore          4
        //   648: iload           4
        //   650: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   653: goto            670
        //   656: dup            
        //   657: iload           4
        //   659: aload_2        
        //   660: iload           4
        //   662: aaload         
        //   663: dup            
        //   664: astore          5
        //   666: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   669: aastore        
        //   670: iinc            4, -1
        //   673: iload           4
        //   675: ifge            656
        //   678: invokestatic    gnu/kawa/slib/srfi14.charSetIntersection:([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   681: areturn        
        //   682: aload_2        
        //   683: iconst_0       
        //   684: aaload         
        //   685: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   687: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   690: dup            
        //   691: astore          4
        //   693: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   696: aload_2        
        //   697: arraylength    
        //   698: iconst_1       
        //   699: isub           
        //   700: istore          4
        //   702: iload           4
        //   704: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   707: goto            726
        //   710: dup            
        //   711: iload           4
        //   713: aload_2        
        //   714: iload           4
        //   716: iconst_1       
        //   717: iadd           
        //   718: aaload         
        //   719: dup            
        //   720: astore          5
        //   722: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   725: aastore        
        //   726: iinc            4, -1
        //   729: iload           4
        //   731: ifge            710
        //   734: invokestatic    gnu/kawa/slib/srfi14.charSetDifference:(Lgnu/kawa/slib/srfi14$CharSet;[Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   737: areturn        
        //   738: aload_2        
        //   739: arraylength    
        //   740: istore          4
        //   742: iload           4
        //   744: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   747: goto            764
        //   750: dup            
        //   751: iload           4
        //   753: aload_2        
        //   754: iload           4
        //   756: aaload         
        //   757: dup            
        //   758: astore          5
        //   760: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   763: aastore        
        //   764: iinc            4, -1
        //   767: iload           4
        //   769: ifge            750
        //   772: invokestatic    gnu/kawa/slib/srfi14.charSetXor:([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   775: areturn        
        //   776: aload_2        
        //   777: iconst_0       
        //   778: aaload         
        //   779: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   781: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   784: dup            
        //   785: astore          4
        //   787: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   790: aload_2        
        //   791: iconst_1       
        //   792: aaload         
        //   793: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   795: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   798: dup            
        //   799: astore          4
        //   801: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   804: aload_2        
        //   805: arraylength    
        //   806: iconst_2       
        //   807: isub           
        //   808: istore          4
        //   810: iload           4
        //   812: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   815: goto            834
        //   818: dup            
        //   819: iload           4
        //   821: aload_2        
        //   822: iload           4
        //   824: iconst_2       
        //   825: iadd           
        //   826: aaload         
        //   827: dup            
        //   828: astore          5
        //   830: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   833: aastore        
        //   834: iinc            4, -1
        //   837: iload           4
        //   839: ifge            818
        //   842: invokestatic    gnu/kawa/slib/srfi14.charSetDiff$PlIntersection:(Lgnu/kawa/slib/srfi14$CharSet;Lgnu/kawa/slib/srfi14$CharSet;[Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/mapping/Values;
        //   845: areturn        
        //   846: aload_2        
        //   847: arraylength    
        //   848: istore          4
        //   850: iload           4
        //   852: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   855: goto            872
        //   858: dup            
        //   859: iload           4
        //   861: aload_2        
        //   862: iload           4
        //   864: aaload         
        //   865: dup            
        //   866: astore          5
        //   868: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   871: aastore        
        //   872: iinc            4, -1
        //   875: iload           4
        //   877: ifge            858
        //   880: invokestatic    gnu/kawa/slib/srfi14.charSetUnion$Ex:([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   883: areturn        
        //   884: aload_2        
        //   885: arraylength    
        //   886: istore          4
        //   888: iload           4
        //   890: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   893: goto            910
        //   896: dup            
        //   897: iload           4
        //   899: aload_2        
        //   900: iload           4
        //   902: aaload         
        //   903: dup            
        //   904: astore          5
        //   906: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   909: aastore        
        //   910: iinc            4, -1
        //   913: iload           4
        //   915: ifge            896
        //   918: invokestatic    gnu/kawa/slib/srfi14.charSetIntersection$Ex:([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   921: areturn        
        //   922: aload_2        
        //   923: iconst_0       
        //   924: aaload         
        //   925: ldc             Lgnu/kawa/slib/srfi14$CharSet;.class
        //   927: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   930: dup            
        //   931: astore          4
        //   933: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   936: aload_2        
        //   937: arraylength    
        //   938: iconst_1       
        //   939: isub           
        //   940: istore          4
        //   942: iload           4
        //   944: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   947: goto            966
        //   950: dup            
        //   951: iload           4
        //   953: aload_2        
        //   954: iload           4
        //   956: iconst_1       
        //   957: iadd           
        //   958: aaload         
        //   959: dup            
        //   960: astore          5
        //   962: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //   965: aastore        
        //   966: iinc            4, -1
        //   969: iload           4
        //   971: ifge            950
        //   974: invokestatic    gnu/kawa/slib/srfi14.charSetDifference$Ex:(Lgnu/kawa/slib/srfi14$CharSet;[Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //   977: areturn        
        //   978: aload_2        
        //   979: arraylength    
        //   980: istore          4
        //   982: iload           4
        //   984: anewarray       Lgnu/kawa/slib/srfi14$CharSet;
        //   987: goto            1004
        //   990: dup            
        //   991: iload           4
        //   993: aload_2        
        //   994: iload           4
        //   996: aaload         
        //   997: dup            
        //   998: astore          5
        //  1000: checkcast       Lgnu/kawa/slib/srfi14$CharSet;
        //  1003: aastore        
        //  1004: iinc            4, -1
        //  1007: iload           4
        //  1009: ifge            990
        //  1012: invokestatic    gnu/kawa/slib/srfi14.charSetXor$Ex:([Lgnu/kawa/slib/srfi14$CharSet;)Lgnu/kawa/slib/srfi14$CharSet;
        //  1015: areturn        
        //  1016: aload_0        
        //  1017: aload_1        
        //  1018: aload_2        
        //  1019: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //  1022: areturn        
        //  1023: new             Lgnu/mapping/WrongType;
        //  1026: dup_x1         
        //  1027: swap           
        //  1028: ldc_w           "char-set="
        //  1031: iconst_0       
        //  1032: aload           4
        //  1034: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1037: athrow         
        //  1038: new             Lgnu/mapping/WrongType;
        //  1041: dup_x1         
        //  1042: swap           
        //  1043: ldc_w           "char-set<="
        //  1046: iconst_0       
        //  1047: aload           4
        //  1049: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1052: athrow         
        //  1053: new             Lgnu/mapping/WrongType;
        //  1056: dup_x1         
        //  1057: swap           
        //  1058: ldc_w           "char-set-unfold"
        //  1061: iconst_1       
        //  1062: aload           4
        //  1064: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1067: athrow         
        //  1068: new             Lgnu/mapping/WrongType;
        //  1071: dup_x1         
        //  1072: swap           
        //  1073: ldc_w           "char-set-unfold"
        //  1076: iconst_2       
        //  1077: aload           4
        //  1079: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1082: athrow         
        //  1083: new             Lgnu/mapping/WrongType;
        //  1086: dup_x1         
        //  1087: swap           
        //  1088: ldc_w           "char-set-unfold"
        //  1091: iconst_3       
        //  1092: aload           4
        //  1094: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1097: athrow         
        //  1098: new             Lgnu/mapping/WrongType;
        //  1101: dup_x1         
        //  1102: swap           
        //  1103: ldc_w           "char-set-unfold"
        //  1106: iconst_5       
        //  1107: aload           4
        //  1109: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1112: athrow         
        //  1113: new             Lgnu/mapping/WrongType;
        //  1116: dup_x1         
        //  1117: swap           
        //  1118: ldc_w           "char-set-unfold!"
        //  1121: iconst_1       
        //  1122: aload           4
        //  1124: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1127: athrow         
        //  1128: new             Lgnu/mapping/WrongType;
        //  1131: dup_x1         
        //  1132: swap           
        //  1133: ldc_w           "char-set-unfold!"
        //  1136: iconst_2       
        //  1137: aload           4
        //  1139: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1142: athrow         
        //  1143: new             Lgnu/mapping/WrongType;
        //  1146: dup_x1         
        //  1147: swap           
        //  1148: ldc_w           "char-set-unfold!"
        //  1151: iconst_3       
        //  1152: aload           4
        //  1154: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1157: athrow         
        //  1158: new             Lgnu/mapping/WrongType;
        //  1161: dup_x1         
        //  1162: swap           
        //  1163: ldc_w           "char-set-unfold!"
        //  1166: iconst_5       
        //  1167: aload           4
        //  1169: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1172: athrow         
        //  1173: new             Lgnu/mapping/WrongType;
        //  1176: dup_x1         
        //  1177: swap           
        //  1178: ldc_w           "char-set-adjoin"
        //  1181: iconst_1       
        //  1182: aload           4
        //  1184: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1187: athrow         
        //  1188: new             Lgnu/mapping/WrongType;
        //  1191: dup_x1         
        //  1192: swap           
        //  1193: ldc_w           "char-set-adjoin"
        //  1196: iconst_0       
        //  1197: aload           5
        //  1199: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1202: athrow         
        //  1203: new             Lgnu/mapping/WrongType;
        //  1206: dup_x1         
        //  1207: swap           
        //  1208: ldc_w           "char-set-delete"
        //  1211: iconst_1       
        //  1212: aload           4
        //  1214: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1217: athrow         
        //  1218: new             Lgnu/mapping/WrongType;
        //  1221: dup_x1         
        //  1222: swap           
        //  1223: ldc_w           "char-set-delete"
        //  1226: iconst_0       
        //  1227: aload           5
        //  1229: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1232: athrow         
        //  1233: new             Lgnu/mapping/WrongType;
        //  1236: dup_x1         
        //  1237: swap           
        //  1238: ldc             "char-set-adjoin!"
        //  1240: iconst_1       
        //  1241: aload           4
        //  1243: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1246: athrow         
        //  1247: new             Lgnu/mapping/WrongType;
        //  1250: dup_x1         
        //  1251: swap           
        //  1252: ldc             "char-set-adjoin!"
        //  1254: iconst_0       
        //  1255: aload           5
        //  1257: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1260: athrow         
        //  1261: new             Lgnu/mapping/WrongType;
        //  1264: dup_x1         
        //  1265: swap           
        //  1266: ldc_w           "char-set-delete!"
        //  1269: iconst_1       
        //  1270: aload           4
        //  1272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1275: athrow         
        //  1276: new             Lgnu/mapping/WrongType;
        //  1279: dup_x1         
        //  1280: swap           
        //  1281: ldc_w           "char-set-delete!"
        //  1284: iconst_0       
        //  1285: aload           5
        //  1287: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1290: athrow         
        //  1291: new             Lgnu/mapping/WrongType;
        //  1294: dup_x1         
        //  1295: swap           
        //  1296: ldc_w           "char-set-union"
        //  1299: iconst_0       
        //  1300: aload           5
        //  1302: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1305: athrow         
        //  1306: new             Lgnu/mapping/WrongType;
        //  1309: dup_x1         
        //  1310: swap           
        //  1311: ldc_w           "char-set-intersection"
        //  1314: iconst_0       
        //  1315: aload           5
        //  1317: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1320: athrow         
        //  1321: new             Lgnu/mapping/WrongType;
        //  1324: dup_x1         
        //  1325: swap           
        //  1326: ldc_w           "char-set-difference"
        //  1329: iconst_1       
        //  1330: aload           4
        //  1332: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1335: athrow         
        //  1336: new             Lgnu/mapping/WrongType;
        //  1339: dup_x1         
        //  1340: swap           
        //  1341: ldc_w           "char-set-difference"
        //  1344: iconst_0       
        //  1345: aload           5
        //  1347: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1350: athrow         
        //  1351: new             Lgnu/mapping/WrongType;
        //  1354: dup_x1         
        //  1355: swap           
        //  1356: ldc_w           "char-set-xor"
        //  1359: iconst_0       
        //  1360: aload           5
        //  1362: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1365: athrow         
        //  1366: new             Lgnu/mapping/WrongType;
        //  1369: dup_x1         
        //  1370: swap           
        //  1371: ldc_w           "char-set-diff+intersection"
        //  1374: iconst_1       
        //  1375: aload           4
        //  1377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1380: athrow         
        //  1381: new             Lgnu/mapping/WrongType;
        //  1384: dup_x1         
        //  1385: swap           
        //  1386: ldc_w           "char-set-diff+intersection"
        //  1389: iconst_2       
        //  1390: aload           4
        //  1392: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1395: athrow         
        //  1396: new             Lgnu/mapping/WrongType;
        //  1399: dup_x1         
        //  1400: swap           
        //  1401: ldc_w           "char-set-diff+intersection"
        //  1404: iconst_0       
        //  1405: aload           5
        //  1407: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1410: athrow         
        //  1411: new             Lgnu/mapping/WrongType;
        //  1414: dup_x1         
        //  1415: swap           
        //  1416: ldc_w           "char-set-union!"
        //  1419: iconst_0       
        //  1420: aload           5
        //  1422: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1425: athrow         
        //  1426: new             Lgnu/mapping/WrongType;
        //  1429: dup_x1         
        //  1430: swap           
        //  1431: ldc_w           "char-set-intersection!"
        //  1434: iconst_0       
        //  1435: aload           5
        //  1437: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1440: athrow         
        //  1441: new             Lgnu/mapping/WrongType;
        //  1444: dup_x1         
        //  1445: swap           
        //  1446: ldc_w           "char-set-difference!"
        //  1449: iconst_1       
        //  1450: aload           4
        //  1452: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1455: athrow         
        //  1456: new             Lgnu/mapping/WrongType;
        //  1459: dup_x1         
        //  1460: swap           
        //  1461: ldc_w           "char-set-difference!"
        //  1464: iconst_0       
        //  1465: aload           5
        //  1467: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1470: athrow         
        //  1471: new             Lgnu/mapping/WrongType;
        //  1474: dup_x1         
        //  1475: swap           
        //  1476: ldc_w           "char-set-xor!"
        //  1479: iconst_0       
        //  1480: aload           5
        //  1482: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1485: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  170    173    1023   1038   Ljava/lang/ClassCastException;
        //  215    218    1038   1053   Ljava/lang/ClassCastException;
        //  258    261    1053   1068   Ljava/lang/ClassCastException;
        //  272    275    1068   1083   Ljava/lang/ClassCastException;
        //  286    289    1083   1098   Ljava/lang/ClassCastException;
        //  316    319    1098   1113   Ljava/lang/ClassCastException;
        //  334    337    1113   1128   Ljava/lang/ClassCastException;
        //  348    351    1128   1143   Ljava/lang/ClassCastException;
        //  362    365    1143   1158   Ljava/lang/ClassCastException;
        //  379    382    1158   1173   Ljava/lang/ClassCastException;
        //  397    400    1173   1188   Ljava/lang/ClassCastException;
        //  425    428    1188   1203   Ljava/lang/ClassCastException;
        //  452    455    1203   1218   Ljava/lang/ClassCastException;
        //  480    483    1218   1233   Ljava/lang/ClassCastException;
        //  507    510    1233   1247   Ljava/lang/ClassCastException;
        //  535    538    1247   1261   Ljava/lang/ClassCastException;
        //  562    565    1261   1276   Ljava/lang/ClassCastException;
        //  590    593    1276   1291   Ljava/lang/ClassCastException;
        //  628    631    1291   1306   Ljava/lang/ClassCastException;
        //  666    669    1306   1321   Ljava/lang/ClassCastException;
        //  693    696    1321   1336   Ljava/lang/ClassCastException;
        //  722    725    1336   1351   Ljava/lang/ClassCastException;
        //  760    763    1351   1366   Ljava/lang/ClassCastException;
        //  787    790    1366   1381   Ljava/lang/ClassCastException;
        //  801    804    1381   1396   Ljava/lang/ClassCastException;
        //  830    833    1396   1411   Ljava/lang/ClassCastException;
        //  868    871    1411   1426   Ljava/lang/ClassCastException;
        //  906    909    1426   1441   Ljava/lang/ClassCastException;
        //  933    936    1441   1456   Ljava/lang/ClassCastException;
        //  962    965    1456   1471   Ljava/lang/ClassCastException;
        //  1000   1003   1471   1486   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 740 out of bounds for length 740
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
    
    public class CharSet implements Cloneable
    {
        public static CharSet empty;
        public static CharSet full;
        public static CharSet ascii;
        public static CharSet title$Mncase;
        public static CharSet whitespace;
        public static CharSet blank;
        public static CharSet lower$Mncase;
        public static CharSet upper$Mncase;
        public static CharSet letter;
        public static CharSet digit;
        public static CharSet punctuation;
        public static CharSet symbol;
        public static CharSet letter$Pldigit;
        public static CharSet graphic;
        public static CharSet printing;
        public static CharSet hex$Mndigit;
        public static CharSet iso$Mncontrol;
        public int[] inversion$Mnlist;
        public int inversion$Mnlist$Mnsize;
        public boolean immutable$Qu;
        public String name;
        
        static {
            final CharSet empty = new CharSet(new int[0]);
            empty.name = "char-set:empty";
            empty.immutable$Qu = true;
            CharSet.empty = empty;
            final CharSet full = new CharSet(new int[0]);
            full.inversion$Mnlist = new int[] { 0 };
            full.inversion$Mnlist$Mnsize = 1;
            full.name = "char-set:full";
            full.immutable$Qu = true;
            CharSet.full = full;
            final CharSet ascii = new CharSet(new int[0]);
            ascii.inversion$Mnlist = new int[] { 128, 0 };
            ascii.inversion$Mnlist$Mnsize = 2;
            ascii.name = "char-set:ascii";
            ascii.immutable$Qu = true;
            CharSet.ascii = ascii;
            CharSet.title$Mncase = srfi14.$PcMakeBuiltin("char-set:title-case", srfi14.$Pctitle$Mncase);
            CharSet.whitespace = srfi14.$PcMakeBuiltin("char-set:whitespace", srfi14.$Pcwhitespace);
            CharSet.blank = srfi14.$PcMakeBuiltin("char-set:blank", srfi14.$Pcblank);
            CharSet.lower$Mncase = srfi14.$PcMakeBuiltin("char-set:lower-case", srfi14.$Pclower$Mncase);
            CharSet.upper$Mncase = srfi14.$PcMakeBuiltin("char-set:upper-case", srfi14.$Pcupper$Mncase);
            CharSet.letter = srfi14.$PcMakeBuiltin("char-set:letter", srfi14.$Pcletter);
            CharSet.digit = srfi14.$PcMakeBuiltin("char-set:digit", srfi14.$Pcdigit);
            CharSet.punctuation = srfi14.$PcMakeBuiltin("char-set:punctuation", srfi14.$Pcpunctuation);
            CharSet.symbol = srfi14.$PcMakeBuiltin("char-set:symbol", srfi14.$Pcsymbol);
            CharSet.letter$Pldigit = srfi14.$PcMakeBuiltin("char-set:letter+digit", srfi14.$Pcletter$Pldigit);
            CharSet.graphic = srfi14.$PcMakeBuiltin("char-set:graphic", srfi14.$Pcgraphic);
            CharSet.printing = srfi14.$PcMakeBuiltin("char-set:printing", srfi14.$Pcprinting);
            final CharSet hex$Mndigit = new CharSet(new int[0]);
            hex$Mndigit.inversion$Mnlist = new int[] { 103, 97, 71, 65, 58, 48, 0 };
            hex$Mndigit.inversion$Mnlist$Mnsize = 6;
            hex$Mndigit.name = "char-set:hex-digit";
            hex$Mndigit.immutable$Qu = true;
            CharSet.hex$Mndigit = hex$Mndigit;
            final CharSet iso$Mncontrol = new CharSet(new int[0]);
            iso$Mncontrol.inversion$Mnlist = new int[] { 160, 127, 32, 0 };
            iso$Mncontrol.inversion$Mnlist$Mnsize = 4;
            iso$Mncontrol.name = "char-set:iso-control";
            iso$Mncontrol.immutable$Qu = true;
            CharSet.iso$Mncontrol = iso$Mncontrol;
        }
        
        private void $finit$() {
            this.inversion$Mnlist = new int[] { 0 };
            this.inversion$Mnlist$Mnsize = 0;
            this.immutable$Qu = false;
            this.name = null;
        }
        
        @SourceMethodType({ "", "character[]" })
        public CharSet(final int... characters) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: invokespecial   java/lang/Object.<init>:()V
            //     4: aload_0         /* this */
            //     5: invokespecial   gnu/kawa/slib/srfi14$CharSet.$finit$:()V
            //     8: aload_1         /* characters */
            //     9: arraylength    
            //    10: ifle            260
            //    13: aload_1         /* characters */
            //    14: aload_1         /* characters */
            //    15: arraylength    
            //    16: invokestatic    java/util/Arrays.copyOf:([II)[I
            //    19: checkcast       [I
            //    22: astore_2        /* chars */
            //    23: aload_2         /* chars */
            //    24: invokestatic    java/util/Arrays.sort:([I)V
            //    27: aload_2         /* chars */
            //    28: iconst_0       
            //    29: iaload         
            //    30: istore_3        /* first$Mnpt */
            //    31: iconst_1       
            //    32: iconst_1       
            //    33: iload_3         /* first$Mnpt */
            //    34: iadd           
            //    35: iconst_2       
            //    36: anewarray       Ljava/lang/Object;
            //    39: dup            
            //    40: iconst_0       
            //    41: iload_3         /* first$Mnpt */
            //    42: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //    45: aastore        
            //    46: dup            
            //    47: iconst_1       
            //    48: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
            //    51: aastore        
            //    52: invokestatic    kawa/lang/Quote.consX$V:([Ljava/lang/Object;)Ljava/lang/Object;
            //    55: ldc             Lgnu/lists/LList;.class
            //    57: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
            //    60: checkcast       Lgnu/lists/LList;
            //    63: astore          6
            //    65: istore          5
            //    67: istore          index
            //    69: iload           index
            //    71: aload_2         /* chars */
            //    72: arraylength    
            //    73: if_icmpne       186
            //    76: iload           pt
            //    78: ldc             1114111
            //    80: if_icmpeq       95
            //    83: iload           pt
            //    85: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //    88: aload           inv$Mnls
            //    90: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
            //    93: astore          inv$Mnls
            //    95: aload           inv$Mnls
            //    97: invokevirtual   gnu/lists/LList.size:()I
            //   100: istore          len
            //   102: aload_0         /* this */
            //   103: iconst_1       
            //   104: iload           len
            //   106: iadd           
            //   107: newarray        I
            //   109: putfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //   112: aload_0         /* this */
            //   113: iload           len
            //   115: putfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist$Mnsize:I
            //   118: iconst_0       
            //   119: aload           inv$Mnls
            //   121: astore          9
            //   123: istore          i
            //   125: iload           i
            //   127: iload           len
            //   129: if_icmpeq       260
            //   132: aload_0         /* this */
            //   133: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //   136: iload           i
            //   138: aload           inv$Mnls
            //   140: dup            
            //   141: astore          10
            //   143: checkcast       Lgnu/lists/Pair;
            //   146: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
            //   149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
            //   152: checkcast       Ljava/lang/Number;
            //   155: invokevirtual   java/lang/Number.intValue:()I
            //   158: iastore        
            //   159: aload           inv$Mnls
            //   161: dup            
            //   162: astore          10
            //   164: checkcast       Lgnu/lists/Pair;
            //   167: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
            //   170: ldc             Lgnu/lists/LList;.class
            //   172: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
            //   175: checkcast       Lgnu/lists/LList;
            //   178: astore          inv$Mnls
            //   180: iinc            i, 1
            //   183: goto            125
            //   186: aload_2         /* chars */
            //   187: iload           index
            //   189: iaload         
            //   190: istore          next$Mnchar$Mnpt
            //   192: iload           pt
            //   194: iload           next$Mnchar$Mnpt
            //   196: if_icmpge       231
            //   199: iconst_1       
            //   200: iload           next$Mnchar$Mnpt
            //   202: iadd           
            //   203: iload           next$Mnchar$Mnpt
            //   205: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //   208: iload           pt
            //   210: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //   213: aload           inv$Mnls
            //   215: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
            //   218: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
            //   221: astore          inv$Mnls
            //   223: istore          pt
            //   225: iinc            index, 1
            //   228: goto            69
            //   231: iload           pt
            //   233: iload           next$Mnchar$Mnpt
            //   235: if_icmpne       247
            //   238: iinc            pt, 1
            //   241: iinc            index, 1
            //   244: goto            69
            //   247: iload           pt
            //   249: iload           next$Mnchar$Mnpt
            //   251: if_icmple       260
            //   254: iinc            index, 1
            //   257: goto            69
            //   260: return         
            //   261: new             Lgnu/mapping/WrongType;
            //   264: dup_x1         
            //   265: swap           
            //   266: ldc             "car"
            //   268: iconst_1       
            //   269: aload           10
            //   271: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
            //   274: athrow         
            //   275: new             Lgnu/mapping/WrongType;
            //   278: dup_x1         
            //   279: swap           
            //   280: ldc             "cdr"
            //   282: iconst_1       
            //   283: aload           10
            //   285: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
            //   288: athrow         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                          
            //  -----  -----  -----  -----  ------------------------------
            //  143    146    261    275    Ljava/lang/ClassCastException;
            //  164    167    275    289    Ljava/lang/ClassCastException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0186:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        public CharSet clone() {
            final Object force = Promise.force(super.clone(), CharSet.class);
            try {
                final CharSet copy = (CharSet)force;
                copy.inversion$Mnlist = Arrays.copyOf(this.inversion$Mnlist, this.inversion$Mnlist$Mnsize);
                copy.immutable$Qu = false;
                copy.name = null;
                return copy;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "copy", -2, force);
            }
        }
        
        @Override
        public int hashCode() {
            int hash = 0;
            for (int i = this.inversion$Mnlist$Mnsize - 1; i != -1; --i) {
                hash = 31 * hash + this.inversion$Mnlist[i];
            }
            return hash;
        }
        
        @Override
        public String toString() {
            final String s = super.toString();
            String s2;
            if (this.name == null) {
                s2 = s;
            }
            else {
                final FString stringAppend = strings.stringAppend(s, ": (", this.name, ")");
                s2 = ((stringAppend == null) ? null : stringAppend.toString());
            }
            return s2;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b;
            if (o instanceof CharSet) {
                final CharSet other = (CharSet)Promise.force(o, CharSet.class);
                if (other.inversion$Mnlist$Mnsize == this.inversion$Mnlist$Mnsize) {
                    int i = 0;
                    while (true) {
                        final boolean x = i == this.inversion$Mnlist$Mnsize;
                        if (x) {
                            b = x;
                            break;
                        }
                        if (other.inversion$Mnlist[i] != this.inversion$Mnlist[i]) {
                            b = false;
                            break;
                        }
                        ++i;
                    }
                }
                else {
                    b = false;
                }
            }
            else {
                b = false;
            }
            return b;
        }
        
        public boolean isSubsetOf(final CharSet cs) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist$Mnsize:I
            //     4: iconst_1       
            //     5: isub           
            //     6: aload_1         /* cs */
            //     7: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist$Mnsize:I
            //    10: iconst_1       
            //    11: isub           
            //    12: istore_3       
            //    13: istore_2        /* ai */
            //    14: iload_2         /* ai */
            //    15: iconst_m1      
            //    16: if_icmpne       23
            //    19: iconst_1       
            //    20: goto            144
            //    23: iload_3         /* bi */
            //    24: iconst_m1      
            //    25: if_icmpne       32
            //    28: iconst_0       
            //    29: goto            144
            //    32: aload_0         /* this */
            //    33: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //    36: iload_2         /* ai */
            //    37: iaload         
            //    38: aload_1         /* cs */
            //    39: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //    42: iload_3         /* bi */
            //    43: iaload         
            //    44: if_icmpge       51
            //    47: iconst_0       
            //    48: goto            144
            //    51: iload_3         /* bi */
            //    52: ifne            59
            //    55: iconst_1       
            //    56: goto            144
            //    59: iload_2         /* ai */
            //    60: ifne            67
            //    63: iconst_0       
            //    64: goto            144
            //    67: aload_0         /* this */
            //    68: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //    71: iload_2         /* ai */
            //    72: iconst_1       
            //    73: isub           
            //    74: iaload         
            //    75: aload_1         /* cs */
            //    76: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //    79: iload_3         /* bi */
            //    80: iconst_1       
            //    81: isub           
            //    82: iaload         
            //    83: if_icmpge       92
            //    86: iinc            ai, -2
            //    89: goto            14
            //    92: aload_0         /* this */
            //    93: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //    96: iload_2         /* ai */
            //    97: iconst_1       
            //    98: isub           
            //    99: iaload         
            //   100: aload_1         /* cs */
            //   101: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //   104: iload_3         /* bi */
            //   105: iconst_1       
            //   106: isub           
            //   107: iaload         
            //   108: if_icmpne       120
            //   111: iinc            bi, -2
            //   114: iinc            ai, -2
            //   117: goto            14
            //   120: aload_0         /* this */
            //   121: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //   124: iload_2         /* ai */
            //   125: iaload         
            //   126: aload_1         /* cs */
            //   127: getfield        gnu/kawa/slib/srfi14$CharSet.inversion$Mnlist:[I
            //   130: iload_3         /* bi */
            //   131: iconst_1       
            //   132: isub           
            //   133: iaload         
            //   134: if_icmple       143
            //   137: iinc            bi, -2
            //   140: goto            14
            //   143: iconst_0       
            //   144: ireturn        
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @SourceMethodType({ "", "character" })
        public boolean isContains(final int char) {
            int n2;
            if (this.inversion$Mnlist$Mnsize != 0) {
                final int charnum = char;
                final int n = 0;
                final int inversion$Mnlist$Mnsize = this.inversion$Mnlist$Mnsize;
                int low = n;
                while (true) {
                    int high = 0;
                    final int mid = BitOps.shift(low + high, -1);
                    if (low == high) {
                        n2 = (false ? 1 : 0);
                        break;
                    }
                    if (charnum < this.inversion$Mnlist[mid] && mid < this.inversion$Mnlist$Mnsize - 1) {
                        low = mid;
                    }
                    else {
                        if (mid <= 0 || charnum < this.inversion$Mnlist[mid - 1]) {
                            n2 = ((high == this.inversion$Mnlist$Mnsize && mid == this.inversion$Mnlist$Mnsize - 1) ? ((charnum >= this.inversion$Mnlist[mid]) ? 1 : 0) : (this.inversion$Mnlist$Mnsize - mid & 0x1));
                            break;
                        }
                        high = mid;
                    }
                }
            }
            else {
                n2 = (false ? 1 : 0);
            }
            return n2 != 0;
        }
        
        public int size() {
            int num = 0;
            for (int i = this.inversion$Mnlist$Mnsize - 1; i != -1; i -= 2) {
                if (i == 0) {
                    return num + (1114111 - this.inversion$Mnlist[i]) + 1;
                }
                num += this.inversion$Mnlist[i - 1] - this.inversion$Mnlist[i];
            }
            return num;
        }
        
        public LList toList() {
            return (LList)Promise.force(srfi14.charSetFold(lists.cons, LList.Empty, this), LList.class);
        }
        
        public int getCursor() {
            return (this.inversion$Mnlist$Mnsize == 0) ? 1114112 : this.inversion$Mnlist[this.inversion$Mnlist$Mnsize - 1];
        }
        
        public int cursorNext(final int cursor) {
            final boolean x = this.inversion$Mnlist$Mnsize == 0;
            Label_0053: {
                if (x) {
                    if (!x) {
                        break Label_0053;
                    }
                }
                else if (1 - (this.inversion$Mnlist$Mnsize & 0x1) == 0 || cursor + 1 < this.inversion$Mnlist[0]) {
                    break Label_0053;
                }
                return 1114112;
            }
            final int cursor2 = cursor + 1;
            final int n2 = 0;
            final int inversion$Mnlist$Mnsize = this.inversion$Mnlist$Mnsize;
            int low = n2;
            int n;
            while (true) {
                int high = 0;
                final int mid = BitOps.shift(low + high, -1);
                if (low == high) {
                    n = this.inversion$Mnlist[low];
                    break;
                }
                if (cursor2 < this.inversion$Mnlist[mid]) {
                    low = mid;
                }
                else {
                    if (mid <= 0 || cursor2 < this.inversion$Mnlist[mid - 1]) {
                        n = (((this.inversion$Mnlist$Mnsize - mid & 0x1) != 0x0) ? cursor2 : this.inversion$Mnlist[mid - 1]);
                        break;
                    }
                    high = mid;
                }
            }
            return n;
        }
        
        public CharSet complement$Ex() {
            if (this.immutable$Qu) {
                exceptions.error("attempted to modify an immutable char-set", this);
                throw Special.reachedUnexpected;
            }
            if (this.inversion$Mnlist$Mnsize > 0 && this.inversion$Mnlist[this.inversion$Mnlist$Mnsize - 1] == 0) {
                --this.inversion$Mnlist$Mnsize;
            }
            else if (this.inversion$Mnlist$Mnsize < this.inversion$Mnlist.length) {
                this.inversion$Mnlist[this.inversion$Mnlist$Mnsize] = 0;
                ++this.inversion$Mnlist$Mnsize;
            }
            else {
                this.inversion$Mnlist = Arrays.copyOf(this.inversion$Mnlist, 1 + this.inversion$Mnlist$Mnsize * 2);
                ++this.inversion$Mnlist$Mnsize;
            }
            return this;
        }
        
        @SourceMethodType({ "", "character" })
        public CharSet adjoin$Ex(final int c) {
            final int i = c;
            return this.union$Ex(new int[] { i + 1, i }, 2);
        }
        
        @SourceMethodType({ "", "character" })
        public CharSet delete$Ex(final int c) {
            final int i = c;
            return this.intersection$Ex(new int[] { i + 1, i, 0 }, 3);
        }
        
        private CharSet combine$Ex(final int[] arr, final int arr$Mnsize, final Procedure proc) {
            if (this.immutable$Qu) {
                exceptions.error("attempted to modify an immutable char-set", this);
                throw Special.reachedUnexpected;
            }
            final LList l1 = srfi14.$PcMakeBoundaryPairs(this.inversion$Mnlist, this.inversion$Mnlist$Mnsize);
            final LList l2 = srfi14.$PcMakeBoundaryPairs(arr, arr$Mnsize);
            final Object force = Promise.force(proc.apply2(l1, l2), LList.class);
            try {
                final LList combo$Mnpairs = (LList)force;
                final int new$Mnlength = srfi14.$PcBoundaryPairsLength(combo$Mnpairs);
                final boolean x = new$Mnlength > this.inversion$Mnlist.length;
                Label_0141: {
                    if (x) {
                        if (!x) {
                            break Label_0141;
                        }
                    }
                    else if (new$Mnlength >= RatNum.make(IntNum.make(this.inversion$Mnlist.length), IntNum.make(2)).doubleValue()) {
                        break Label_0141;
                    }
                    this.inversion$Mnlist = new int[new$Mnlength * 2];
                }
                srfi14.$PcWriteInversionList(this.inversion$Mnlist, combo$Mnpairs, new$Mnlength);
                this.inversion$Mnlist$Mnsize = new$Mnlength;
                return this;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "combo-pairs", -2, force);
            }
        }
        
        public CharSet intersection$Ex(final CharSet cs) {
            return this.intersection$Ex(cs.inversion$Mnlist, cs.inversion$Mnlist$Mnsize);
        }
        
        public CharSet intersection$Ex(final int[] arr, final int arr$Mnsize) {
            return this.combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnintersection);
        }
        
        public CharSet union$Ex(final CharSet cs) {
            return this.union$Ex(cs.inversion$Mnlist, cs.inversion$Mnlist$Mnsize);
        }
        
        public CharSet union$Ex(final int[] arr, final int arr$Mnsize) {
            return this.combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnunion);
        }
        
        public CharSet xor$Ex(final CharSet cs) {
            return this.xor$Ex(cs.inversion$Mnlist, cs.inversion$Mnlist$Mnsize);
        }
        
        public CharSet xor$Ex(final int[] arr, final int arr$Mnsize) {
            return this.combine$Ex(arr, arr$Mnsize, srfi14.$Pcboundary$Mnpairs$Mnxor);
        }
    }
}
