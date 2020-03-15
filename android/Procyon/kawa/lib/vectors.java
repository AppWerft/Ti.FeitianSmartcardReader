// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import java.util.List;
import gnu.lists.LList;
import gnu.lists.FVector;
import gnu.mapping.Procedure;
import gnu.lists.Consumer;
import gnu.mapping.MethodProc;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import gnu.expr.GenericProc;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class vectors extends ModuleBody
{
    public static final ModuleMethod vector$Qu;
    public static final ModuleMethod make$Mnvector;
    public static final ModuleMethod vector$Mnlength;
    public static final ModuleMethod vector$Mnset$Ex;
    public static final GenericProc vector$Mnref;
    public static final ModuleMethod vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grvector;
    public static final ModuleMethod vector$Mn$Grstring;
    public static final ModuleMethod string$Mn$Grvector;
    public static final ModuleMethod vector$Mncopy;
    public static final ModuleMethod vector$Mncopy$Ex;
    public static final ModuleMethod vector$Mnfill$Ex;
    public static final ModuleMethod vector$Mnmap;
    public static final ModuleMethod vector$Mnfor$Mneach;
    static final Keyword Lit0;
    static final ModuleMethod vector$Mnref$Fn1;
    static final ModuleMethod vector$Mnfor$Mneach$Mngeneric$Fn2;
    public static vectors $instance;
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
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        vectors.vector$Mnref.setProperty(vectors.Lit0, vectors.vector$Mnset$Ex);
        final GenericProc vector$Mnref2 = vectors.vector$Mnref;
        final Procedure vector$Mnref = vectors.vector$Mnref$Fn1;
        vector$Mnref2.add(vectors.vector$Mnref$Fn1);
    }
    
    public static boolean isVector(final Object x) {
        return x instanceof FVector;
    }
    
    public static FVector makeVector(final int k) {
        return makeVector(k, null);
    }
    
    public static FVector makeVector(final int k, final Object fill) {
        return new FVector(k, fill);
    }
    
    public static int vectorLength(final FVector x) {
        return x.size();
    }
    
    public static void vectorSet$Ex(final FVector vector, final int k, final Object obj) {
        vector.setAt(k, obj);
    }
    
    public static Object vectorRef(final FVector vector, final int k) {
        return vector.get(k);
    }
    
    public static LList vector$To$List(final FVector fVector) {
        return vector$To$List(fVector, 0);
    }
    
    public static LList vector$To$List(final FVector vec, final int start) {
        return vector$To$List(vec, start, vec.size());
    }
    
    public static LList vector$To$List(final FVector vec, final int start, final int end) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: iload_2         /* end */
        //     4: istore          4
        //     6: astore_3        /* result */
        //     7: iinc            i, -1
        //    10: iload           i
        //    12: iload_1         /* start */
        //    13: if_icmpge       20
        //    16: aload_3         /* result */
        //    17: goto            40
        //    20: getstatic       kawa/lib/vectors.vector$Mnref:Lgnu/expr/GenericProc;
        //    23: aload_0         /* vec */
        //    24: iload           i
        //    26: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    29: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    32: aload_3         /* result */
        //    33: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    36: astore_3        /* result */
        //    37: goto            7
        //    40: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static FVector list$To$Vector(final LList x) {
        return new FVector(x);
    }
    
    public static CharSequence vector$To$String(final FVector fVector) {
        return vector$To$String(fVector, 0);
    }
    
    public static CharSequence vector$To$String(final FVector vec, final int start) {
        return vector$To$String(vec, start, vec.size());
    }
    
    public static CharSequence vector$To$String(final FVector vec, final int start, final int end) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: iload_1         /* start */
        //     8: istore          4
        //    10: astore_3        /* result */
        //    11: iload           i
        //    13: iload_2         /* end */
        //    14: if_icmplt       28
        //    17: new             Lgnu/lists/FString;
        //    20: dup            
        //    21: aload_3         /* result */
        //    22: invokespecial   gnu/lists/FString.<init>:(Ljava/lang/StringBuilder;)V
        //    25: goto            94
        //    28: getstatic       kawa/lib/vectors.vector$Mnref:Lgnu/expr/GenericProc;
        //    31: aload_0         /* vec */
        //    32: iload           i
        //    34: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    37: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    40: astore          ch
        //    42: aload           ch
        //    44: instanceof      Ljava/lang/Character;
        //    47: ifeq            71
        //    50: aload_3         /* result */
        //    51: aload           ch
        //    53: ldc             Ljava/lang/Character;.class
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    58: checkcast       Ljava/lang/Character;
        //    61: invokevirtual   java/lang/Character.charValue:()C
        //    64: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    67: pop            
        //    68: goto            88
        //    71: aload           ch
        //    73: ldc             Lgnu/text/Char;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: checkcast       Lgnu/text/Char;
        //    81: invokevirtual   gnu/text/Char.intValue:()I
        //    84: aload_3         /* result */
        //    85: invokestatic    gnu/text/Char.print:(ILjava/lang/Appendable;)V
        //    88: iinc            i, 1
        //    91: goto            11
        //    94: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static FVector string$To$Vector(final CharSequence charSequence) {
        return string$To$Vector(charSequence, 0);
    }
    
    public static FVector string$To$Vector(final CharSequence str, final int start) {
        return string$To$Vector(str, start, str.length());
    }
    
    public static FVector string$To$Vector(final CharSequence str, final int start, final int end) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1         /* start */
        //     2: isub           
        //     3: anewarray       Ljava/lang/Object;
        //     6: iload_1         /* start */
        //     7: iconst_0       
        //     8: istore          5
        //    10: istore          4
        //    12: astore_3        /* result */
        //    13: iload           i
        //    15: iload_2         /* end */
        //    16: if_icmplt       30
        //    19: new             Lgnu/lists/FVector;
        //    22: dup            
        //    23: aload_3         /* result */
        //    24: invokespecial   gnu/lists/FVector.<init>:([Ljava/lang/Object;)V
        //    27: goto            58
        //    30: aload_0         /* str */
        //    31: iload           i
        //    33: invokeinterface java/lang/CharSequence.charAt:(I)C
        //    38: istore          ch
        //    40: aload_3         /* result */
        //    41: iload           j
        //    43: iload           ch
        //    45: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //    48: aastore        
        //    49: iinc            j, 1
        //    52: iinc            i, 1
        //    55: goto            13
        //    58: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static FVector vectorCopy(final FVector fVector) {
        return vectorCopy(fVector, 0);
    }
    
    public static FVector vectorCopy(final FVector vec, final int start) {
        return vectorCopy(vec, start, vec.size());
    }
    
    public static FVector vectorCopy(final FVector vec, final int start, final int end) {
        final FVector result = new FVector(end - start);
        result.copyFrom(0, vec, start, end);
        return result;
    }
    
    public static void vectorCopy$Ex(final FVector fVector, final int n, final FVector fVector2) {
        vectorCopy$Ex(fVector, n, fVector2, 0);
    }
    
    public static void vectorCopy$Ex(final FVector to, final int at, final FVector from, final int start) {
        vectorCopy$Ex(to, at, from, start, from.size());
    }
    
    public static void vectorCopy$Ex(final FVector to, final int at, final FVector from, final int start, final int end) {
        to.copyFrom(at, from, start, end);
    }
    
    public static void vectorFill$Ex(final FVector fVector, final Object o) {
        vectorFill$Ex(fVector, o, 0);
    }
    
    public static void vectorFill$Ex(final FVector vec, final Object fill, final int start) {
        vectorFill$Ex(vec, fill, start, vec.size());
    }
    
    public static void vectorFill$Ex(final FVector vec, final Object fill, final int start, final int end) {
        vec.fill(start, end, fill);
    }
    
    public static FVector vectorMap(final Procedure proc, final Object vec1, final Object... vecs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: ifne            180
        //     5: aload_0         /* proc */
        //     6: aload_1         /* vec1 */
        //     7: astore          4
        //     9: astore_3        /* proc */
        //    10: aload_3         /* proc */
        //    11: astore          5
        //    13: aload           5
        //    15: astore          6
        //    17: aload           vec
        //    19: astore          7
        //    21: aload           7
        //    23: ldc             Lgnu/lists/SimpleVector;.class
        //    25: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    28: astore          9
        //    30: aload           9
        //    32: instanceof      Lgnu/lists/SimpleVector;
        //    35: ifeq            116
        //    38: aload           9
        //    40: checkcast       Lgnu/lists/SimpleVector;
        //    43: astore          8
        //    45: aload           6
        //    47: aload           8
        //    49: astore          11
        //    51: astore          proc
        //    53: aload           vec
        //    55: invokeinterface java/util/List.size:()I
        //    60: istore          len
        //    62: iload           len
        //    64: anewarray       Ljava/lang/Object;
        //    67: astore          r
        //    69: iconst_0       
        //    70: istore          i
        //    72: iload           i
        //    74: iload           len
        //    76: if_icmpeq       104
        //    79: aload           r
        //    81: iload           i
        //    83: aload           proc
        //    85: aload           vec
        //    87: iload           i
        //    89: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    94: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    97: aastore        
        //    98: iinc            i, 1
        //   101: goto            72
        //   104: new             Lgnu/lists/FVector;
        //   107: dup            
        //   108: aload           r
        //   110: invokespecial   gnu/lists/FVector.<init>:([Ljava/lang/Object;)V
        //   113: goto            344
        //   116: aload           vec
        //   118: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //   121: anewarray       Ljava/lang/Object;
        //   124: astore          r
        //   126: aload           vec
        //   128: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   131: astore          it
        //   133: iconst_0       
        //   134: istore          i
        //   136: aload           it
        //   138: invokeinterface java/util/Iterator.hasNext:()Z
        //   143: ifeq            168
        //   146: aload           r
        //   148: iload           i
        //   150: aload_3         /* proc */
        //   151: aload           it
        //   153: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   158: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   161: aastore        
        //   162: iinc            i, 1
        //   165: goto            136
        //   168: new             Lgnu/lists/FVector;
        //   171: dup            
        //   172: aload           r
        //   174: invokespecial   gnu/lists/FVector.<init>:([Ljava/lang/Object;)V
        //   177: goto            344
        //   180: aload_2         /* vecs */
        //   181: arraylength    
        //   182: iconst_1       
        //   183: iadd           
        //   184: istore_3        /* nargs */
        //   185: iload_3         /* nargs */
        //   186: anewarray       Ljava/util/Iterator;
        //   189: astore          iterators
        //   191: iload_3         /* nargs */
        //   192: anewarray       Ljava/lang/Object;
        //   195: astore          elements
        //   197: iconst_0       
        //   198: invokestatic    kawa/lib/vectors.makeVector:(I)Lgnu/lists/FVector;
        //   201: astore          result
        //   203: iconst_0       
        //   204: istore          i
        //   206: iload           i
        //   208: iload_3         /* nargs */
        //   209: if_icmpeq       241
        //   212: aload           iterators
        //   214: iload           i
        //   216: iload           i
        //   218: ifne            225
        //   221: aload_1         /* vec1 */
        //   222: goto            231
        //   225: aload_2         /* vecs */
        //   226: iload           i
        //   228: iconst_1       
        //   229: isub           
        //   230: aaload         
        //   231: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   234: aastore        
        //   235: iinc            i, 1
        //   238: goto            206
        //   241: iconst_0       
        //   242: istore          i
        //   244: iload           i
        //   246: iload_3         /* nargs */
        //   247: if_icmpne       308
        //   250: aload           result
        //   252: aload_0         /* proc */
        //   253: iconst_0       
        //   254: istore          11
        //   256: aload           elements
        //   258: astore          12
        //   260: aload           12
        //   262: invokestatic    gnu/kawa/functions/MakeSplice.count:(Ljava/lang/Object;)I
        //   265: dup            
        //   266: istore          13
        //   268: iload           11
        //   270: iadd           
        //   271: istore          11
        //   273: iload           11
        //   275: anewarray       Ljava/lang/Object;
        //   278: dup            
        //   279: iconst_0       
        //   280: istore          14
        //   282: iload           14
        //   284: iload           13
        //   286: aload           12
        //   288: invokestatic    gnu/kawa/functions/MakeSplice.copyTo:([Ljava/lang/Object;IILjava/lang/Object;)V
        //   291: iload           14
        //   293: iload           13
        //   295: iadd           
        //   296: istore          14
        //   298: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
        //   301: invokevirtual   gnu/lists/FVector.add:(Ljava/lang/Object;)Z
        //   304: pop            
        //   305: goto            241
        //   308: aload           iterators
        //   310: iload           i
        //   312: aaload         
        //   313: invokeinterface java/util/Iterator.hasNext:()Z
        //   318: ifeq            342
        //   321: aload           elements
        //   323: iload           i
        //   325: aload           iterators
        //   327: iload           i
        //   329: aaload         
        //   330: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   335: aastore        
        //   336: iinc            i, 1
        //   339: goto            244
        //   342: aload           result
        //   344: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void vectorForEach(final Procedure f, final List vec, final List... vecs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_3        /* vector$Mnfor$Mneach$Mngeneric */
        //     4: aload_2         /* vecs */
        //     5: arraylength    
        //     6: ifne            55
        //     9: aload_0         /* f */
        //    10: aload_1         /* vec */
        //    11: astore          5
        //    13: astore          f
        //    15: aload           vec
        //    17: invokeinterface java/util/List.size:()I
        //    22: istore          len
        //    24: iconst_0       
        //    25: istore          i
        //    27: iload           i
        //    29: iload           len
        //    31: if_icmpeq       62
        //    34: aload           f
        //    36: aload           vec
        //    38: iload           i
        //    40: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    45: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    48: pop            
        //    49: iinc            i, 1
        //    52: goto            27
        //    55: aload_0         /* f */
        //    56: aload_1         /* vec */
        //    57: aload_2         /* vecs */
        //    58: invokestatic    kawa/lib/vectors.lambda1vectorForEachGeneric:(Lgnu/mapping/Procedure;Ljava/util/List;[Ljava/util/List;)Ljava/lang/Object;
        //    61: pop            
        //    62: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object lambda1vectorForEachGeneric(final Procedure f, final List vec, final List... vecs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1         /* vec */
        //     4: invokeinterface java/util/List.size:()I
        //     9: aload_2         /* vecs */
        //    10: arraylength    
        //    11: iconst_1       
        //    12: isub           
        //    13: istore          5
        //    15: istore          4
        //    17: astore_3        /* ls */
        //    18: iload           i
        //    20: iflt            83
        //    23: aload_2         /* vecs */
        //    24: iload           i
        //    26: aaload         
        //    27: aload_3         /* ls */
        //    28: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    31: iconst_2       
        //    32: anewarray       Ljava/lang/Object;
        //    35: dup            
        //    36: iconst_0       
        //    37: iload           len
        //    39: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    42: aastore        
        //    43: dup            
        //    44: iconst_1       
        //    45: aload_2         /* vecs */
        //    46: iload           i
        //    48: aaload         
        //    49: dup            
        //    50: astore          6
        //    52: checkcast       Lgnu/lists/FVector;
        //    55: invokestatic    kawa/lib/vectors.vectorLength:(Lgnu/lists/FVector;)I
        //    58: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    61: aastore        
        //    62: invokestatic    kawa/lib/numbers.min:([Ljava/lang/Object;)Ljava/lang/Object;
        //    65: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    68: checkcast       Ljava/lang/Number;
        //    71: invokevirtual   java/lang/Number.intValue:()I
        //    74: iinc            i, -1
        //    77: istore          len
        //    79: astore_3        /* ls */
        //    80: goto            18
        //    83: iconst_0       
        //    84: istore          i
        //    86: iload           i
        //    88: iload           len
        //    90: if_icmpeq       220
        //    93: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    96: aload_0         /* f */
        //    97: aload_1         /* vec */
        //    98: iload           i
        //   100: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   105: aload_3         /* ls */
        //   106: astore          7
        //   108: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   111: astore          8
        //   113: aconst_null    
        //   114: astore          9
        //   116: aload           7
        //   118: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   121: if_acmpeq       208
        //   124: aload           7
        //   126: ldc_w           Lgnu/lists/Pair;.class
        //   129: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   132: checkcast       Lgnu/lists/Pair;
        //   135: astore          10
        //   137: aload           10
        //   139: invokevirtual   gnu/lists/Pair.getCar:()Ljava/lang/Object;
        //   142: astore          11
        //   144: new             Lgnu/lists/Pair;
        //   147: dup            
        //   148: aload           11
        //   150: ldc             Ljava/util/List;.class
        //   152: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   155: dup            
        //   156: astore          14
        //   158: checkcast       Ljava/util/List;
        //   161: astore          v
        //   163: aload           v
        //   165: iload           i
        //   167: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   172: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   175: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   178: aload           9
        //   180: ifnonnull       189
        //   183: dup            
        //   184: astore          8
        //   186: goto            196
        //   189: aload           9
        //   191: swap           
        //   192: dup_x1         
        //   193: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   196: astore          9
        //   198: aload           10
        //   200: invokevirtual   gnu/lists/Pair.getCdr:()Ljava/lang/Object;
        //   203: astore          7
        //   205: goto            116
        //   208: aload           8
        //   210: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   213: pop            
        //   214: iinc            i, 1
        //   217: goto            86
        //   220: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   223: areturn        
        //   224: new             Lgnu/mapping/WrongType;
        //   227: dup_x1         
        //   228: swap           
        //   229: ldc             "vector-length"
        //   231: iconst_0       
        //   232: aload           6
        //   234: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   237: athrow         
        //   238: new             Lgnu/mapping/WrongType;
        //   241: dup_x1         
        //   242: swap           
        //   243: ldc_w           "v"
        //   246: bipush          -2
        //   248: aload           14
        //   250: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   253: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  52     55     224    238    Ljava/lang/ClassCastException;
        //  158    161    238    254    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        Lit15 = Symbol.valueOf("vector-for-each");
        Lit14 = Symbol.valueOf("vector-for-each-generic");
        Lit13 = Symbol.valueOf("vector-map");
        Lit12 = Symbol.valueOf("vector-fill!");
        Lit11 = Symbol.valueOf("vector-copy!");
        Lit10 = Symbol.valueOf("vector-copy");
        Lit9 = Symbol.valueOf("string->vector");
        Lit8 = Symbol.valueOf("vector->string");
        Lit7 = Symbol.valueOf("list->vector");
        Lit6 = Symbol.valueOf("vector->list");
        Lit5 = Symbol.valueOf("vector-ref");
        Lit4 = Symbol.valueOf("vector-set!");
        Lit3 = Symbol.valueOf("vector-length");
        Lit2 = Symbol.valueOf("make-vector");
        Lit1 = Symbol.valueOf("vector?");
        Lit0 = Keyword.make("setter");
        vectors.$instance = new vectors();
        final vectors $instance = vectors.$instance;
        vector$Qu = new ModuleMethod($instance, 1, vectors.Lit1, 4097);
        make$Mnvector = new ModuleMethod($instance, 2, vectors.Lit2, 8193);
        vector$Mnlength = new ModuleMethod($instance, 4, vectors.Lit3, 4097);
        vector$Mnset$Ex = new ModuleMethod($instance, 5, vectors.Lit4, 12291);
        vector$Mnref = new GenericProc("vector-ref");
        vector$Mnref$Fn1 = new ModuleMethod($instance, 6, vectors.Lit5, 8194);
        vector$Mn$Grlist = new ModuleMethod($instance, 7, vectors.Lit6, 12289);
        list$Mn$Grvector = new ModuleMethod($instance, 10, vectors.Lit7, 4097);
        vector$Mn$Grstring = new ModuleMethod($instance, 11, vectors.Lit8, 12289);
        string$Mn$Grvector = new ModuleMethod($instance, 14, vectors.Lit9, 12289);
        vector$Mncopy = new ModuleMethod($instance, 17, vectors.Lit10, 12289);
        vector$Mncopy$Ex = new ModuleMethod($instance, 20, vectors.Lit11, 20483);
        vector$Mnfill$Ex = new ModuleMethod($instance, 23, vectors.Lit12, 16386);
        final ModuleMethod vector$Mnmap2 = new ModuleMethod($instance, 26, vectors.Lit13, -4094);
        vector$Mnmap2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:vectorMapValidateApply");
        vector$Mnmap = vector$Mnmap2;
        vector$Mnfor$Mneach$Mngeneric$Fn2 = new ModuleMethod($instance, 27, vectors.Lit14, -4094);
        final ModuleMethod vector$Mnfor$Mneach2 = new ModuleMethod($instance, 28, vectors.Lit15, -4094);
        vector$Mnfor$Mneach2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:vectorForEachValidateApply");
        vector$Mnfor$Mneach = vector$Mnfor$Mneach2;
        $runBody$();
    }
    
    public vectors() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 17: {
                final Object force = Promise.force(arg1, FVector.class);
                if (force instanceof FVector) {
                    ctx.value1 = force;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force2 = Promise.force(arg1, CharSequence.class);
                if (force2 instanceof CharSequence) {
                    ctx.value1 = force2;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 11: {
                final Object force3 = Promise.force(arg1, FVector.class);
                if (force3 instanceof FVector) {
                    ctx.value1 = force3;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 10: {
                final Object force4 = Promise.force(arg1, LList.class);
                if (force4 instanceof LList) {
                    ctx.value1 = force4;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force5 = Promise.force(arg1, FVector.class);
                if (force5 instanceof FVector) {
                    ctx.value1 = force5;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 4: {
                final Object force6 = Promise.force(arg1, FVector.class);
                if (force6 instanceof FVector) {
                    ctx.value1 = force6;
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
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 23: {
                final Object force = Promise.force(o, FVector.class);
                if (force instanceof FVector) {
                    ctx.value1 = force;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 17: {
                final Object force2 = Promise.force(o, FVector.class);
                if (force2 instanceof FVector) {
                    ctx.value1 = force2;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force3 = Promise.force(o, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value1 = force3;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 11: {
                final Object force4 = Promise.force(o, FVector.class);
                if (force4 instanceof FVector) {
                    ctx.value1 = force4;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force5 = Promise.force(o, FVector.class);
                if (force5 instanceof FVector) {
                    ctx.value1 = force5;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 6: {
                final Object force6 = Promise.force(o, FVector.class);
                if (force6 instanceof FVector) {
                    ctx.value1 = force6;
                    ctx.value2 = Promise.force(o2);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                ctx.value1 = Promise.force(o);
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 23: {
                final Object force = Promise.force(o, FVector.class);
                if (force instanceof FVector) {
                    ctx.value1 = force;
                    ctx.value2 = o2;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 20: {
                final Object force2 = Promise.force(o, FVector.class);
                if (!(force2 instanceof FVector)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = Promise.force(o2);
                final Object force3 = Promise.force(o3, FVector.class);
                if (force3 instanceof FVector) {
                    ctx.value3 = force3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 17: {
                final Object force4 = Promise.force(o, FVector.class);
                if (force4 instanceof FVector) {
                    ctx.value1 = force4;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force5 = Promise.force(o, CharSequence.class);
                if (force5 instanceof CharSequence) {
                    ctx.value1 = force5;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 11: {
                final Object force6 = Promise.force(o, FVector.class);
                if (force6 instanceof FVector) {
                    ctx.value1 = force6;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force7 = Promise.force(o, FVector.class);
                if (force7 instanceof FVector) {
                    ctx.value1 = force7;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 5: {
                final Object force8 = Promise.force(o, FVector.class);
                if (force8 instanceof FVector) {
                    ctx.value1 = force8;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = o3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        switch (proc.selector) {
            case 23: {
                final Object force = Promise.force(arg1, FVector.class);
                if (force instanceof FVector) {
                    ctx.value1 = force;
                    ctx.value2 = arg2;
                    ctx.value3 = Promise.force(arg3);
                    ctx.value4 = Promise.force(arg4);
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786431;
            }
            case 20: {
                final Object force2 = Promise.force(arg1, FVector.class);
                if (!(force2 instanceof FVector)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = Promise.force(arg2);
                final Object force3 = Promise.force(arg3, FVector.class);
                if (force3 instanceof FVector) {
                    ctx.value3 = force3;
                    ctx.value4 = Promise.force(arg4);
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786429;
            }
            default: {
                return super.match4(proc, arg1, arg2, arg3, arg4, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 28: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 27: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 26: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 20: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(proc, args, ctx);
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
        //                2: 88
        //                3: 105
        //                4: 200
        //                5: 119
        //                6: 200
        //                7: 200
        //                8: 135
        //                9: 200
        //               10: 200
        //               11: 148
        //               12: 161
        //               13: 200
        //               14: 200
        //               15: 174
        //               16: 200
        //               17: 200
        //               18: 187
        //          default: 200
        //        }
        //    88: aload_2        
        //    89: invokestatic    kawa/lib/vectors.isVector:(Ljava/lang/Object;)Z
        //    92: ifeq            101
        //    95: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    98: goto            104
        //   101: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   104: areturn        
        //   105: aload_2        
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   109: checkcast       Ljava/lang/Number;
        //   112: invokevirtual   java/lang/Number.intValue:()I
        //   115: invokestatic    kawa/lib/vectors.makeVector:(I)Lgnu/lists/FVector;
        //   118: areturn        
        //   119: aload_2        
        //   120: ldc             Lgnu/lists/FVector;.class
        //   122: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   125: checkcast       Lgnu/lists/FVector;
        //   128: invokestatic    kawa/lib/vectors.vectorLength:(Lgnu/lists/FVector;)I
        //   131: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   134: areturn        
        //   135: aload_2        
        //   136: ldc             Lgnu/lists/FVector;.class
        //   138: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   141: checkcast       Lgnu/lists/FVector;
        //   144: invokestatic    kawa/lib/vectors.vector$To$List:(Lgnu/lists/FVector;)Lgnu/lists/LList;
        //   147: areturn        
        //   148: aload_2        
        //   149: ldc             Lgnu/lists/LList;.class
        //   151: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   154: checkcast       Lgnu/lists/LList;
        //   157: invokestatic    kawa/lib/vectors.list$To$Vector:(Lgnu/lists/LList;)Lgnu/lists/FVector;
        //   160: areturn        
        //   161: aload_2        
        //   162: ldc             Lgnu/lists/FVector;.class
        //   164: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   167: checkcast       Lgnu/lists/FVector;
        //   170: invokestatic    kawa/lib/vectors.vector$To$String:(Lgnu/lists/FVector;)Ljava/lang/CharSequence;
        //   173: areturn        
        //   174: aload_2        
        //   175: ldc             Ljava/lang/CharSequence;.class
        //   177: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   180: checkcast       Ljava/lang/CharSequence;
        //   183: invokestatic    kawa/lib/vectors.string$To$Vector:(Ljava/lang/CharSequence;)Lgnu/lists/FVector;
        //   186: areturn        
        //   187: aload_2        
        //   188: ldc             Lgnu/lists/FVector;.class
        //   190: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   193: checkcast       Lgnu/lists/FVector;
        //   196: invokestatic    kawa/lib/vectors.vectorCopy:(Lgnu/lists/FVector;)Lgnu/lists/FVector;
        //   199: areturn        
        //   200: aload_0        
        //   201: aload_1        
        //   202: aload_2        
        //   203: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   206: areturn        
        //   207: new             Lgnu/mapping/WrongType;
        //   210: dup_x1         
        //   211: swap           
        //   212: ldc_w           "make-vector"
        //   215: iconst_1       
        //   216: aload_2        
        //   217: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   220: athrow         
        //   221: new             Lgnu/mapping/WrongType;
        //   224: dup_x1         
        //   225: swap           
        //   226: ldc             "vector-length"
        //   228: iconst_1       
        //   229: aload_2        
        //   230: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   233: athrow         
        //   234: new             Lgnu/mapping/WrongType;
        //   237: dup_x1         
        //   238: swap           
        //   239: ldc_w           "vector->list"
        //   242: iconst_1       
        //   243: aload_2        
        //   244: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   247: athrow         
        //   248: new             Lgnu/mapping/WrongType;
        //   251: dup_x1         
        //   252: swap           
        //   253: ldc_w           "list->vector"
        //   256: iconst_1       
        //   257: aload_2        
        //   258: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   261: athrow         
        //   262: new             Lgnu/mapping/WrongType;
        //   265: dup_x1         
        //   266: swap           
        //   267: ldc_w           "vector->string"
        //   270: iconst_1       
        //   271: aload_2        
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //   276: new             Lgnu/mapping/WrongType;
        //   279: dup_x1         
        //   280: swap           
        //   281: ldc_w           "string->vector"
        //   284: iconst_1       
        //   285: aload_2        
        //   286: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   289: athrow         
        //   290: new             Lgnu/mapping/WrongType;
        //   293: dup_x1         
        //   294: swap           
        //   295: ldc_w           "vector-copy"
        //   298: iconst_1       
        //   299: aload_2        
        //   300: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   303: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  109    115    207    221    Ljava/lang/ClassCastException;
        //  125    128    221    234    Ljava/lang/ClassCastException;
        //  141    144    234    248    Ljava/lang/ClassCastException;
        //  154    157    248    262    Ljava/lang/ClassCastException;
        //  167    170    262    276    Ljava/lang/ClassCastException;
        //  180    183    276    290    Ljava/lang/ClassCastException;
        //  193    196    290    304    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 114 out of bounds for length 114
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
        //                2: 72
        //                6: 87
        //                7: 110
        //               11: 133
        //               14: 156
        //               17: 179
        //               23: 202
        //          default: 219
        //        }
        //    72: aload_2        
        //    73: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    76: checkcast       Ljava/lang/Number;
        //    79: invokevirtual   java/lang/Number.intValue:()I
        //    82: aload_3        
        //    83: invokestatic    kawa/lib/vectors.makeVector:(ILjava/lang/Object;)Lgnu/lists/FVector;
        //    86: areturn        
        //    87: aload_2        
        //    88: ldc             Lgnu/lists/FVector;.class
        //    90: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    93: checkcast       Lgnu/lists/FVector;
        //    96: aload_3        
        //    97: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   100: checkcast       Ljava/lang/Number;
        //   103: invokevirtual   java/lang/Number.intValue:()I
        //   106: invokestatic    kawa/lib/vectors.vectorRef:(Lgnu/lists/FVector;I)Ljava/lang/Object;
        //   109: areturn        
        //   110: aload_2        
        //   111: ldc             Lgnu/lists/FVector;.class
        //   113: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   116: checkcast       Lgnu/lists/FVector;
        //   119: aload_3        
        //   120: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   123: checkcast       Ljava/lang/Number;
        //   126: invokevirtual   java/lang/Number.intValue:()I
        //   129: invokestatic    kawa/lib/vectors.vector$To$List:(Lgnu/lists/FVector;I)Lgnu/lists/LList;
        //   132: areturn        
        //   133: aload_2        
        //   134: ldc             Lgnu/lists/FVector;.class
        //   136: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   139: checkcast       Lgnu/lists/FVector;
        //   142: aload_3        
        //   143: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   146: checkcast       Ljava/lang/Number;
        //   149: invokevirtual   java/lang/Number.intValue:()I
        //   152: invokestatic    kawa/lib/vectors.vector$To$String:(Lgnu/lists/FVector;I)Ljava/lang/CharSequence;
        //   155: areturn        
        //   156: aload_2        
        //   157: ldc             Ljava/lang/CharSequence;.class
        //   159: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   162: checkcast       Ljava/lang/CharSequence;
        //   165: aload_3        
        //   166: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   169: checkcast       Ljava/lang/Number;
        //   172: invokevirtual   java/lang/Number.intValue:()I
        //   175: invokestatic    kawa/lib/vectors.string$To$Vector:(Ljava/lang/CharSequence;I)Lgnu/lists/FVector;
        //   178: areturn        
        //   179: aload_2        
        //   180: ldc             Lgnu/lists/FVector;.class
        //   182: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   185: checkcast       Lgnu/lists/FVector;
        //   188: aload_3        
        //   189: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   192: checkcast       Ljava/lang/Number;
        //   195: invokevirtual   java/lang/Number.intValue:()I
        //   198: invokestatic    kawa/lib/vectors.vectorCopy:(Lgnu/lists/FVector;I)Lgnu/lists/FVector;
        //   201: areturn        
        //   202: aload_2        
        //   203: ldc             Lgnu/lists/FVector;.class
        //   205: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   208: checkcast       Lgnu/lists/FVector;
        //   211: aload_3        
        //   212: invokestatic    kawa/lib/vectors.vectorFill$Ex:(Lgnu/lists/FVector;Ljava/lang/Object;)V
        //   215: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   218: areturn        
        //   219: aload_0        
        //   220: aload_1        
        //   221: aload_2        
        //   222: aload_3        
        //   223: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   226: areturn        
        //   227: new             Lgnu/mapping/WrongType;
        //   230: dup_x1         
        //   231: swap           
        //   232: ldc_w           "make-vector"
        //   235: iconst_1       
        //   236: aload_2        
        //   237: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   240: athrow         
        //   241: new             Lgnu/mapping/WrongType;
        //   244: dup_x1         
        //   245: swap           
        //   246: ldc_w           "vector-ref"
        //   249: iconst_1       
        //   250: aload_2        
        //   251: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   254: athrow         
        //   255: new             Lgnu/mapping/WrongType;
        //   258: dup_x1         
        //   259: swap           
        //   260: ldc_w           "vector-ref"
        //   263: iconst_2       
        //   264: aload_3        
        //   265: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   268: athrow         
        //   269: new             Lgnu/mapping/WrongType;
        //   272: dup_x1         
        //   273: swap           
        //   274: ldc_w           "vector->list"
        //   277: iconst_1       
        //   278: aload_2        
        //   279: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   282: athrow         
        //   283: new             Lgnu/mapping/WrongType;
        //   286: dup_x1         
        //   287: swap           
        //   288: ldc_w           "vector->list"
        //   291: iconst_2       
        //   292: aload_3        
        //   293: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   296: athrow         
        //   297: new             Lgnu/mapping/WrongType;
        //   300: dup_x1         
        //   301: swap           
        //   302: ldc_w           "vector->string"
        //   305: iconst_1       
        //   306: aload_2        
        //   307: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   310: athrow         
        //   311: new             Lgnu/mapping/WrongType;
        //   314: dup_x1         
        //   315: swap           
        //   316: ldc_w           "vector->string"
        //   319: iconst_2       
        //   320: aload_3        
        //   321: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   324: athrow         
        //   325: new             Lgnu/mapping/WrongType;
        //   328: dup_x1         
        //   329: swap           
        //   330: ldc_w           "string->vector"
        //   333: iconst_1       
        //   334: aload_2        
        //   335: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   338: athrow         
        //   339: new             Lgnu/mapping/WrongType;
        //   342: dup_x1         
        //   343: swap           
        //   344: ldc_w           "string->vector"
        //   347: iconst_2       
        //   348: aload_3        
        //   349: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   352: athrow         
        //   353: new             Lgnu/mapping/WrongType;
        //   356: dup_x1         
        //   357: swap           
        //   358: ldc_w           "vector-copy"
        //   361: iconst_1       
        //   362: aload_2        
        //   363: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   366: athrow         
        //   367: new             Lgnu/mapping/WrongType;
        //   370: dup_x1         
        //   371: swap           
        //   372: ldc_w           "vector-copy"
        //   375: iconst_2       
        //   376: aload_3        
        //   377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   380: athrow         
        //   381: new             Lgnu/mapping/WrongType;
        //   384: dup_x1         
        //   385: swap           
        //   386: ldc_w           "vector-fill!"
        //   389: iconst_1       
        //   390: aload_2        
        //   391: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   394: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  76     82     227    241    Ljava/lang/ClassCastException;
        //  93     96     241    255    Ljava/lang/ClassCastException;
        //  100    106    255    269    Ljava/lang/ClassCastException;
        //  116    119    269    283    Ljava/lang/ClassCastException;
        //  123    129    283    297    Ljava/lang/ClassCastException;
        //  139    142    297    311    Ljava/lang/ClassCastException;
        //  146    152    311    325    Ljava/lang/ClassCastException;
        //  162    165    325    339    Ljava/lang/ClassCastException;
        //  169    175    339    353    Ljava/lang/ClassCastException;
        //  185    188    353    367    Ljava/lang/ClassCastException;
        //  192    198    367    381    Ljava/lang/ClassCastException;
        //  208    211    381    395    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 170 out of bounds for length 170
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
        //                5: 72
        //                7: 100
        //               11: 134
        //               14: 168
        //               17: 202
        //               20: 236
        //               23: 272
        //          default: 300
        //        }
        //    72: aload_2        
        //    73: ldc             Lgnu/lists/FVector;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: checkcast       Lgnu/lists/FVector;
        //    81: aload_3        
        //    82: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    85: checkcast       Ljava/lang/Number;
        //    88: invokevirtual   java/lang/Number.intValue:()I
        //    91: aload           4
        //    93: invokestatic    kawa/lib/vectors.vectorSet$Ex:(Lgnu/lists/FVector;ILjava/lang/Object;)V
        //    96: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    99: areturn        
        //   100: aload_2        
        //   101: ldc             Lgnu/lists/FVector;.class
        //   103: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   106: checkcast       Lgnu/lists/FVector;
        //   109: aload_3        
        //   110: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   113: checkcast       Ljava/lang/Number;
        //   116: invokevirtual   java/lang/Number.intValue:()I
        //   119: aload           4
        //   121: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   124: checkcast       Ljava/lang/Number;
        //   127: invokevirtual   java/lang/Number.intValue:()I
        //   130: invokestatic    kawa/lib/vectors.vector$To$List:(Lgnu/lists/FVector;II)Lgnu/lists/LList;
        //   133: areturn        
        //   134: aload_2        
        //   135: ldc             Lgnu/lists/FVector;.class
        //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   140: checkcast       Lgnu/lists/FVector;
        //   143: aload_3        
        //   144: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   147: checkcast       Ljava/lang/Number;
        //   150: invokevirtual   java/lang/Number.intValue:()I
        //   153: aload           4
        //   155: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   158: checkcast       Ljava/lang/Number;
        //   161: invokevirtual   java/lang/Number.intValue:()I
        //   164: invokestatic    kawa/lib/vectors.vector$To$String:(Lgnu/lists/FVector;II)Ljava/lang/CharSequence;
        //   167: areturn        
        //   168: aload_2        
        //   169: ldc             Ljava/lang/CharSequence;.class
        //   171: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   174: checkcast       Ljava/lang/CharSequence;
        //   177: aload_3        
        //   178: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   181: checkcast       Ljava/lang/Number;
        //   184: invokevirtual   java/lang/Number.intValue:()I
        //   187: aload           4
        //   189: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   192: checkcast       Ljava/lang/Number;
        //   195: invokevirtual   java/lang/Number.intValue:()I
        //   198: invokestatic    kawa/lib/vectors.string$To$Vector:(Ljava/lang/CharSequence;II)Lgnu/lists/FVector;
        //   201: areturn        
        //   202: aload_2        
        //   203: ldc             Lgnu/lists/FVector;.class
        //   205: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   208: checkcast       Lgnu/lists/FVector;
        //   211: aload_3        
        //   212: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   215: checkcast       Ljava/lang/Number;
        //   218: invokevirtual   java/lang/Number.intValue:()I
        //   221: aload           4
        //   223: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   226: checkcast       Ljava/lang/Number;
        //   229: invokevirtual   java/lang/Number.intValue:()I
        //   232: invokestatic    kawa/lib/vectors.vectorCopy:(Lgnu/lists/FVector;II)Lgnu/lists/FVector;
        //   235: areturn        
        //   236: aload_2        
        //   237: ldc             Lgnu/lists/FVector;.class
        //   239: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   242: checkcast       Lgnu/lists/FVector;
        //   245: aload_3        
        //   246: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   249: checkcast       Ljava/lang/Number;
        //   252: invokevirtual   java/lang/Number.intValue:()I
        //   255: aload           4
        //   257: ldc             Lgnu/lists/FVector;.class
        //   259: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   262: checkcast       Lgnu/lists/FVector;
        //   265: invokestatic    kawa/lib/vectors.vectorCopy$Ex:(Lgnu/lists/FVector;ILgnu/lists/FVector;)V
        //   268: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   271: areturn        
        //   272: aload_2        
        //   273: ldc             Lgnu/lists/FVector;.class
        //   275: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   278: checkcast       Lgnu/lists/FVector;
        //   281: aload_3        
        //   282: aload           4
        //   284: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   287: checkcast       Ljava/lang/Number;
        //   290: invokevirtual   java/lang/Number.intValue:()I
        //   293: invokestatic    kawa/lib/vectors.vectorFill$Ex:(Lgnu/lists/FVector;Ljava/lang/Object;I)V
        //   296: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   299: areturn        
        //   300: aload_0        
        //   301: aload_1        
        //   302: aload_2        
        //   303: aload_3        
        //   304: aload           4
        //   306: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   309: areturn        
        //   310: new             Lgnu/mapping/WrongType;
        //   313: dup_x1         
        //   314: swap           
        //   315: ldc_w           "vector-set!"
        //   318: iconst_1       
        //   319: aload_2        
        //   320: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   323: athrow         
        //   324: new             Lgnu/mapping/WrongType;
        //   327: dup_x1         
        //   328: swap           
        //   329: ldc_w           "vector-set!"
        //   332: iconst_2       
        //   333: aload_3        
        //   334: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   337: athrow         
        //   338: new             Lgnu/mapping/WrongType;
        //   341: dup_x1         
        //   342: swap           
        //   343: ldc_w           "vector->list"
        //   346: iconst_1       
        //   347: aload_2        
        //   348: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   351: athrow         
        //   352: new             Lgnu/mapping/WrongType;
        //   355: dup_x1         
        //   356: swap           
        //   357: ldc_w           "vector->list"
        //   360: iconst_2       
        //   361: aload_3        
        //   362: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   365: athrow         
        //   366: new             Lgnu/mapping/WrongType;
        //   369: dup_x1         
        //   370: swap           
        //   371: ldc_w           "vector->list"
        //   374: iconst_3       
        //   375: aload           4
        //   377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   380: athrow         
        //   381: new             Lgnu/mapping/WrongType;
        //   384: dup_x1         
        //   385: swap           
        //   386: ldc_w           "vector->string"
        //   389: iconst_1       
        //   390: aload_2        
        //   391: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   394: athrow         
        //   395: new             Lgnu/mapping/WrongType;
        //   398: dup_x1         
        //   399: swap           
        //   400: ldc_w           "vector->string"
        //   403: iconst_2       
        //   404: aload_3        
        //   405: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   408: athrow         
        //   409: new             Lgnu/mapping/WrongType;
        //   412: dup_x1         
        //   413: swap           
        //   414: ldc_w           "vector->string"
        //   417: iconst_3       
        //   418: aload           4
        //   420: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   423: athrow         
        //   424: new             Lgnu/mapping/WrongType;
        //   427: dup_x1         
        //   428: swap           
        //   429: ldc_w           "string->vector"
        //   432: iconst_1       
        //   433: aload_2        
        //   434: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   437: athrow         
        //   438: new             Lgnu/mapping/WrongType;
        //   441: dup_x1         
        //   442: swap           
        //   443: ldc_w           "string->vector"
        //   446: iconst_2       
        //   447: aload_3        
        //   448: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   451: athrow         
        //   452: new             Lgnu/mapping/WrongType;
        //   455: dup_x1         
        //   456: swap           
        //   457: ldc_w           "string->vector"
        //   460: iconst_3       
        //   461: aload           4
        //   463: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   466: athrow         
        //   467: new             Lgnu/mapping/WrongType;
        //   470: dup_x1         
        //   471: swap           
        //   472: ldc_w           "vector-copy"
        //   475: iconst_1       
        //   476: aload_2        
        //   477: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   480: athrow         
        //   481: new             Lgnu/mapping/WrongType;
        //   484: dup_x1         
        //   485: swap           
        //   486: ldc_w           "vector-copy"
        //   489: iconst_2       
        //   490: aload_3        
        //   491: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   494: athrow         
        //   495: new             Lgnu/mapping/WrongType;
        //   498: dup_x1         
        //   499: swap           
        //   500: ldc_w           "vector-copy"
        //   503: iconst_3       
        //   504: aload           4
        //   506: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   509: athrow         
        //   510: new             Lgnu/mapping/WrongType;
        //   513: dup_x1         
        //   514: swap           
        //   515: ldc_w           "vector-copy!"
        //   518: iconst_1       
        //   519: aload_2        
        //   520: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   523: athrow         
        //   524: new             Lgnu/mapping/WrongType;
        //   527: dup_x1         
        //   528: swap           
        //   529: ldc_w           "vector-copy!"
        //   532: iconst_2       
        //   533: aload_3        
        //   534: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   537: athrow         
        //   538: new             Lgnu/mapping/WrongType;
        //   541: dup_x1         
        //   542: swap           
        //   543: ldc_w           "vector-copy!"
        //   546: iconst_3       
        //   547: aload           4
        //   549: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   552: athrow         
        //   553: new             Lgnu/mapping/WrongType;
        //   556: dup_x1         
        //   557: swap           
        //   558: ldc_w           "vector-fill!"
        //   561: iconst_1       
        //   562: aload_2        
        //   563: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   566: athrow         
        //   567: new             Lgnu/mapping/WrongType;
        //   570: dup_x1         
        //   571: swap           
        //   572: ldc_w           "vector-fill!"
        //   575: iconst_3       
        //   576: aload           4
        //   578: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   581: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  78     81     310    324    Ljava/lang/ClassCastException;
        //  85     91     324    338    Ljava/lang/ClassCastException;
        //  106    109    338    352    Ljava/lang/ClassCastException;
        //  113    119    352    366    Ljava/lang/ClassCastException;
        //  124    130    366    381    Ljava/lang/ClassCastException;
        //  140    143    381    395    Ljava/lang/ClassCastException;
        //  147    153    395    409    Ljava/lang/ClassCastException;
        //  158    164    409    424    Ljava/lang/ClassCastException;
        //  174    177    424    438    Ljava/lang/ClassCastException;
        //  181    187    438    452    Ljava/lang/ClassCastException;
        //  192    198    452    467    Ljava/lang/ClassCastException;
        //  208    211    467    481    Ljava/lang/ClassCastException;
        //  215    221    481    495    Ljava/lang/ClassCastException;
        //  226    232    495    510    Ljava/lang/ClassCastException;
        //  242    245    510    524    Ljava/lang/ClassCastException;
        //  249    255    524    538    Ljava/lang/ClassCastException;
        //  262    265    538    553    Ljava/lang/ClassCastException;
        //  278    281    553    567    Ljava/lang/ClassCastException;
        //  287    293    567    582    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 257 out of bounds for length 257
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
        //     4: tableswitch {
        //               40: 36
        //               41: 122
        //               42: 122
        //               43: 83
        //          default: 122
        //        }
        //    36: aload_2        
        //    37: ldc             Lgnu/lists/FVector;.class
        //    39: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    42: checkcast       Lgnu/lists/FVector;
        //    45: aload_3        
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    49: checkcast       Ljava/lang/Number;
        //    52: invokevirtual   java/lang/Number.intValue:()I
        //    55: aload           4
        //    57: ldc             Lgnu/lists/FVector;.class
        //    59: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    62: checkcast       Lgnu/lists/FVector;
        //    65: aload           5
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    70: checkcast       Ljava/lang/Number;
        //    73: invokevirtual   java/lang/Number.intValue:()I
        //    76: invokestatic    kawa/lib/vectors.vectorCopy$Ex:(Lgnu/lists/FVector;ILgnu/lists/FVector;I)V
        //    79: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    82: areturn        
        //    83: aload_2        
        //    84: ldc             Lgnu/lists/FVector;.class
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    89: checkcast       Lgnu/lists/FVector;
        //    92: aload_3        
        //    93: aload           4
        //    95: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    98: checkcast       Ljava/lang/Number;
        //   101: invokevirtual   java/lang/Number.intValue:()I
        //   104: aload           5
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   109: checkcast       Ljava/lang/Number;
        //   112: invokevirtual   java/lang/Number.intValue:()I
        //   115: invokestatic    kawa/lib/vectors.vectorFill$Ex:(Lgnu/lists/FVector;Ljava/lang/Object;II)V
        //   118: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   121: areturn        
        //   122: aload_0        
        //   123: aload_1        
        //   124: aload_2        
        //   125: aload_3        
        //   126: aload           4
        //   128: aload           5
        //   130: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   133: areturn        
        //   134: new             Lgnu/mapping/WrongType;
        //   137: dup_x1         
        //   138: swap           
        //   139: ldc_w           "vector-copy!"
        //   142: iconst_1       
        //   143: aload_2        
        //   144: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   147: athrow         
        //   148: new             Lgnu/mapping/WrongType;
        //   151: dup_x1         
        //   152: swap           
        //   153: ldc_w           "vector-copy!"
        //   156: iconst_2       
        //   157: aload_3        
        //   158: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   161: athrow         
        //   162: new             Lgnu/mapping/WrongType;
        //   165: dup_x1         
        //   166: swap           
        //   167: ldc_w           "vector-copy!"
        //   170: iconst_3       
        //   171: aload           4
        //   173: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   176: athrow         
        //   177: new             Lgnu/mapping/WrongType;
        //   180: dup_x1         
        //   181: swap           
        //   182: ldc_w           "vector-copy!"
        //   185: iconst_4       
        //   186: aload           5
        //   188: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   191: athrow         
        //   192: new             Lgnu/mapping/WrongType;
        //   195: dup_x1         
        //   196: swap           
        //   197: ldc_w           "vector-fill!"
        //   200: iconst_1       
        //   201: aload_2        
        //   202: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   205: athrow         
        //   206: new             Lgnu/mapping/WrongType;
        //   209: dup_x1         
        //   210: swap           
        //   211: ldc_w           "vector-fill!"
        //   214: iconst_3       
        //   215: aload           4
        //   217: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   220: athrow         
        //   221: new             Lgnu/mapping/WrongType;
        //   224: dup_x1         
        //   225: swap           
        //   226: ldc_w           "vector-fill!"
        //   229: iconst_4       
        //   230: aload           5
        //   232: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   235: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     134    148    Ljava/lang/ClassCastException;
        //  49     55     148    162    Ljava/lang/ClassCastException;
        //  62     65     162    177    Ljava/lang/ClassCastException;
        //  70     76     177    192    Ljava/lang/ClassCastException;
        //  89     92     192    206    Ljava/lang/ClassCastException;
        //  98     104    206    221    Ljava/lang/ClassCastException;
        //  109    115    221    236    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 102 out of bounds for length 102
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
        //               40: 56
        //               41: 363
        //               42: 363
        //               43: 363
        //               44: 363
        //               45: 363
        //               46: 167
        //               47: 220
        //               48: 290
        //          default: 363
        //        }
        //    56: aload_2        
        //    57: arraylength    
        //    58: iconst_3       
        //    59: isub           
        //    60: istore_3       
        //    61: aload_2        
        //    62: iconst_0       
        //    63: aaload         
        //    64: ldc             Lgnu/lists/FVector;.class
        //    66: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    69: dup            
        //    70: astore          4
        //    72: checkcast       Lgnu/lists/FVector;
        //    75: aload_2        
        //    76: iconst_1       
        //    77: aaload         
        //    78: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    81: dup            
        //    82: astore          4
        //    84: checkcast       Ljava/lang/Number;
        //    87: invokevirtual   java/lang/Number.intValue:()I
        //    90: aload_2        
        //    91: iconst_2       
        //    92: aaload         
        //    93: ldc             Lgnu/lists/FVector;.class
        //    95: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    98: dup            
        //    99: astore          4
        //   101: checkcast       Lgnu/lists/FVector;
        //   104: iload_3        
        //   105: ifgt            114
        //   108: invokestatic    kawa/lib/vectors.vectorCopy$Ex:(Lgnu/lists/FVector;ILgnu/lists/FVector;)V
        //   111: goto            163
        //   114: iinc            3, -1
        //   117: aload_2        
        //   118: iconst_3       
        //   119: aaload         
        //   120: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   123: dup            
        //   124: astore          4
        //   126: checkcast       Ljava/lang/Number;
        //   129: invokevirtual   java/lang/Number.intValue:()I
        //   132: iload_3        
        //   133: ifgt            142
        //   136: invokestatic    kawa/lib/vectors.vectorCopy$Ex:(Lgnu/lists/FVector;ILgnu/lists/FVector;I)V
        //   139: goto            163
        //   142: iinc            3, -1
        //   145: aload_2        
        //   146: iconst_4       
        //   147: aaload         
        //   148: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   151: dup            
        //   152: astore          4
        //   154: checkcast       Ljava/lang/Number;
        //   157: invokevirtual   java/lang/Number.intValue:()I
        //   160: invokestatic    kawa/lib/vectors.vectorCopy$Ex:(Lgnu/lists/FVector;ILgnu/lists/FVector;II)V
        //   163: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   166: areturn        
        //   167: aload_2        
        //   168: iconst_0       
        //   169: aaload         
        //   170: ldc             Lgnu/mapping/Procedure;.class
        //   172: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   175: dup            
        //   176: astore          4
        //   178: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   181: aload_2        
        //   182: iconst_1       
        //   183: aaload         
        //   184: aload_2        
        //   185: arraylength    
        //   186: iconst_2       
        //   187: isub           
        //   188: istore          4
        //   190: iload           4
        //   192: anewarray       Ljava/lang/Object;
        //   195: goto            208
        //   198: dup            
        //   199: iload           4
        //   201: aload_2        
        //   202: iload           4
        //   204: iconst_2       
        //   205: iadd           
        //   206: aaload         
        //   207: aastore        
        //   208: iinc            4, -1
        //   211: iload           4
        //   213: ifge            198
        //   216: invokestatic    kawa/lib/vectors.vectorMap:(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FVector;
        //   219: areturn        
        //   220: aload_2        
        //   221: iconst_0       
        //   222: aaload         
        //   223: ldc             Lgnu/mapping/Procedure;.class
        //   225: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   228: dup            
        //   229: astore          4
        //   231: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   234: aload_2        
        //   235: iconst_1       
        //   236: aaload         
        //   237: ldc             Ljava/util/List;.class
        //   239: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   242: dup            
        //   243: astore          4
        //   245: checkcast       Ljava/util/List;
        //   248: aload_2        
        //   249: arraylength    
        //   250: iconst_2       
        //   251: isub           
        //   252: istore          4
        //   254: iload           4
        //   256: anewarray       Ljava/util/List;
        //   259: goto            278
        //   262: dup            
        //   263: iload           4
        //   265: aload_2        
        //   266: iload           4
        //   268: iconst_2       
        //   269: iadd           
        //   270: aaload         
        //   271: dup            
        //   272: astore          5
        //   274: checkcast       Ljava/util/List;
        //   277: aastore        
        //   278: iinc            4, -1
        //   281: iload           4
        //   283: ifge            262
        //   286: invokestatic    kawa/lib/vectors.lambda1vectorForEachGeneric:(Lgnu/mapping/Procedure;Ljava/util/List;[Ljava/util/List;)Ljava/lang/Object;
        //   289: areturn        
        //   290: aload_2        
        //   291: iconst_0       
        //   292: aaload         
        //   293: ldc             Lgnu/mapping/Procedure;.class
        //   295: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   298: dup            
        //   299: astore          4
        //   301: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   304: aload_2        
        //   305: iconst_1       
        //   306: aaload         
        //   307: ldc             Ljava/util/List;.class
        //   309: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   312: dup            
        //   313: astore          4
        //   315: checkcast       Ljava/util/List;
        //   318: aload_2        
        //   319: arraylength    
        //   320: iconst_2       
        //   321: isub           
        //   322: istore          4
        //   324: iload           4
        //   326: anewarray       Ljava/util/List;
        //   329: goto            348
        //   332: dup            
        //   333: iload           4
        //   335: aload_2        
        //   336: iload           4
        //   338: iconst_2       
        //   339: iadd           
        //   340: aaload         
        //   341: dup            
        //   342: astore          5
        //   344: checkcast       Ljava/util/List;
        //   347: aastore        
        //   348: iinc            4, -1
        //   351: iload           4
        //   353: ifge            332
        //   356: invokestatic    kawa/lib/vectors.vectorForEach:(Lgnu/mapping/Procedure;Ljava/util/List;[Ljava/util/List;)V
        //   359: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   362: areturn        
        //   363: aload_0        
        //   364: aload_1        
        //   365: aload_2        
        //   366: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   369: areturn        
        //   370: new             Lgnu/mapping/WrongType;
        //   373: dup_x1         
        //   374: swap           
        //   375: ldc_w           "vector-copy!"
        //   378: iconst_1       
        //   379: aload           4
        //   381: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   384: athrow         
        //   385: new             Lgnu/mapping/WrongType;
        //   388: dup_x1         
        //   389: swap           
        //   390: ldc_w           "vector-copy!"
        //   393: iconst_2       
        //   394: aload           4
        //   396: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   399: athrow         
        //   400: new             Lgnu/mapping/WrongType;
        //   403: dup_x1         
        //   404: swap           
        //   405: ldc_w           "vector-copy!"
        //   408: iconst_3       
        //   409: aload           4
        //   411: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   414: athrow         
        //   415: new             Lgnu/mapping/WrongType;
        //   418: dup_x1         
        //   419: swap           
        //   420: ldc_w           "vector-copy!"
        //   423: iconst_4       
        //   424: aload           4
        //   426: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   429: athrow         
        //   430: new             Lgnu/mapping/WrongType;
        //   433: dup_x1         
        //   434: swap           
        //   435: ldc_w           "vector-copy!"
        //   438: iconst_5       
        //   439: aload           4
        //   441: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   444: athrow         
        //   445: new             Lgnu/mapping/WrongType;
        //   448: dup_x1         
        //   449: swap           
        //   450: ldc_w           "vector-map"
        //   453: iconst_1       
        //   454: aload           4
        //   456: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   459: athrow         
        //   460: new             Lgnu/mapping/WrongType;
        //   463: dup_x1         
        //   464: swap           
        //   465: ldc_w           "vector-for-each-generic"
        //   468: iconst_1       
        //   469: aload           4
        //   471: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   474: athrow         
        //   475: new             Lgnu/mapping/WrongType;
        //   478: dup_x1         
        //   479: swap           
        //   480: ldc_w           "vector-for-each-generic"
        //   483: iconst_2       
        //   484: aload           4
        //   486: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   489: athrow         
        //   490: new             Lgnu/mapping/WrongType;
        //   493: dup_x1         
        //   494: swap           
        //   495: ldc_w           "vector-for-each-generic"
        //   498: iconst_0       
        //   499: aload           5
        //   501: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   504: athrow         
        //   505: new             Lgnu/mapping/WrongType;
        //   508: dup_x1         
        //   509: swap           
        //   510: ldc_w           "vector-for-each"
        //   513: iconst_1       
        //   514: aload           4
        //   516: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   519: athrow         
        //   520: new             Lgnu/mapping/WrongType;
        //   523: dup_x1         
        //   524: swap           
        //   525: ldc_w           "vector-for-each"
        //   528: iconst_2       
        //   529: aload           4
        //   531: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   534: athrow         
        //   535: new             Lgnu/mapping/WrongType;
        //   538: dup_x1         
        //   539: swap           
        //   540: ldc_w           "vector-for-each"
        //   543: iconst_0       
        //   544: aload           5
        //   546: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   549: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  72     75     370    385    Ljava/lang/ClassCastException;
        //  84     90     385    400    Ljava/lang/ClassCastException;
        //  101    104    400    415    Ljava/lang/ClassCastException;
        //  126    132    415    430    Ljava/lang/ClassCastException;
        //  154    160    430    445    Ljava/lang/ClassCastException;
        //  178    181    445    460    Ljava/lang/ClassCastException;
        //  231    234    460    475    Ljava/lang/ClassCastException;
        //  245    248    475    490    Ljava/lang/ClassCastException;
        //  274    277    490    505    Ljava/lang/ClassCastException;
        //  301    304    505    520    Ljava/lang/ClassCastException;
        //  315    318    520    535    Ljava/lang/ClassCastException;
        //  344    347    535    550    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 275 out of bounds for length 275
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
