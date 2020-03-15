// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.expr.Keyword;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.lists.F64Vector;
import gnu.lists.F32Vector;
import gnu.lists.U64Vector;
import gnu.lists.S64Vector;
import gnu.lists.U32Vector;
import gnu.lists.S32Vector;
import gnu.lists.U16Vector;
import gnu.lists.S16Vector;
import kawa.SourceMethodType;
import gnu.lists.U8Vector;
import java.util.List;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.lists.S8Vector;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class uniform extends ModuleBody
{
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$let$St;
    public static final ModuleMethod s8vector$Qu;
    public static final ModuleMethod make$Mns8vector;
    public static final ModuleMethod s8vector;
    public static final ModuleMethod s8vector$Mnlength;
    public static final ModuleMethod s8vector$Mnref;
    public static final ModuleMethod s8vector$Mnset$Ex;
    public static final ModuleMethod s8vector$Mn$Grlist;
    public static final Macro $Pclist$Mn$Grarray;
    public static final ModuleMethod list$Mn$Grs8vector;
    public static final ModuleMethod u8vector$Qu;
    public static final ModuleMethod make$Mnu8vector;
    public static final ModuleMethod u8vector;
    public static final ModuleMethod u8vector$Mnlength;
    public static final ModuleMethod u8vector$Mnref;
    public static final ModuleMethod u8vector$Mnset$Ex;
    public static final ModuleMethod u8vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Gru8vector;
    public static final ModuleMethod s16vector$Qu;
    public static final ModuleMethod make$Mns16vector;
    public static final ModuleMethod s16vector;
    public static final ModuleMethod s16vector$Mnlength;
    public static final ModuleMethod s16vector$Mnref;
    public static final ModuleMethod s16vector$Mnset$Ex;
    public static final ModuleMethod s16vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grs16vector;
    public static final ModuleMethod u16vector$Qu;
    public static final ModuleMethod make$Mnu16vector;
    public static final ModuleMethod u16vector;
    public static final ModuleMethod u16vector$Mnlength;
    public static final ModuleMethod u16vector$Mnref;
    public static final ModuleMethod u16vector$Mnset$Ex;
    public static final ModuleMethod u16vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Gru16vector;
    public static final ModuleMethod s32vector$Qu;
    public static final ModuleMethod make$Mns32vector;
    public static final ModuleMethod s32vector;
    public static final ModuleMethod s32vector$Mnlength;
    public static final ModuleMethod s32vector$Mnref;
    public static final ModuleMethod s32vector$Mnset$Ex;
    public static final ModuleMethod s32vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grs32vector;
    public static final ModuleMethod u32vector$Qu;
    public static final ModuleMethod make$Mnu32vector;
    public static final ModuleMethod u32vector;
    public static final ModuleMethod u32vector$Mnlength;
    public static final ModuleMethod u32vector$Mnref;
    public static final ModuleMethod u32vector$Mnset$Ex;
    public static final ModuleMethod u32vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Gru32vector;
    public static final ModuleMethod s64vector$Qu;
    public static final ModuleMethod make$Mns64vector;
    public static final ModuleMethod s64vector;
    public static final ModuleMethod s64vector$Mnlength;
    public static final ModuleMethod s64vector$Mnref;
    public static final ModuleMethod s64vector$Mnset$Ex;
    public static final ModuleMethod s64vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grs64vector;
    public static final ModuleMethod u64vector$Qu;
    public static final ModuleMethod make$Mnu64vector;
    public static final ModuleMethod u64vector;
    public static final ModuleMethod u64vector$Mnlength;
    public static final ModuleMethod u64vector$Mnref;
    public static final ModuleMethod u64vector$Mnset$Ex;
    public static final ModuleMethod u64vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Gru64vector;
    public static final ModuleMethod f32vector$Qu;
    public static final ModuleMethod make$Mnf32vector;
    public static final ModuleMethod f32vector;
    public static final ModuleMethod f32vector$Mnlength;
    public static final ModuleMethod f32vector$Mnref;
    public static final ModuleMethod f32vector$Mnset$Ex;
    public static final ModuleMethod f32vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grf32vector;
    public static final ModuleMethod f64vector$Qu;
    public static final ModuleMethod make$Mnf64vector;
    public static final ModuleMethod f64vector;
    public static final ModuleMethod f64vector$Mnlength;
    public static final ModuleMethod f64vector$Mnref;
    public static final ModuleMethod f64vector$Mnset$Ex;
    public static final ModuleMethod f64vector$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grf64vector;
    static final IntNum Lit0;
    public static uniform $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
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
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final SimpleSymbol Lit82;
    static final Object[] Lit83;
    static final SimpleSymbol Lit84;
    static final SimpleSymbol Lit85;
    static final SimpleSymbol Lit86;
    static final SimpleSymbol Lit87;
    static final PairWithPosition Lit88;
    static final SimpleSymbol Lit89;
    static final SimpleSymbol Lit90;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean isS8vector(final Object x) {
        return x instanceof S8Vector;
    }
    
    public static S8Vector makeS8vector(final int n) {
        return makeS8vector(n, 0);
    }
    
    public static S8Vector makeS8vector(final int n, final int init) {
        return new S8Vector(n, (byte)init);
    }
    
    public static S8Vector s8vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$S8vector(values);
    }
    
    public static S8Vector list$To$S8vector(final LList l) {
        final int n = l.size();
        final byte[] arr = new byte[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final byte[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = (byte)((Number)force).intValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new S8Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int s8vectorLength(final S8Vector v) {
        return v.size();
    }
    
    public static byte s8vectorRef(final S8Vector v, final int i) {
        return v.getByte(i);
    }
    
    public static void s8vectorSet$Ex(final S8Vector v, final int i, final byte x) {
        v.setByte(i, x);
    }
    
    public static LList s8vector$To$List(final S8Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isU8vector(final Object x) {
        return x instanceof U8Vector;
    }
    
    public static U8Vector makeU8vector(final int n) {
        return makeU8vector(n, 0);
    }
    
    public static U8Vector makeU8vector(final int n, final int init) {
        return new U8Vector(n, (byte)init);
    }
    
    public static U8Vector u8vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$U8vector(values);
    }
    
    public static U8Vector list$To$U8vector(final LList l) {
        final int n = l.size();
        final byte[] arr = new byte[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final byte[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = (byte)((Number)force).intValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new U8Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int u8vectorLength(final U8Vector v) {
        return v.size();
    }
    
    @SourceMethodType({ "ubyte" })
    public static int u8vectorRef(final U8Vector v, final int i) {
        return v.getByte(i);
    }
    
    @SourceMethodType({ "", "", "", "ubyte" })
    public static void u8vectorSet$Ex(final U8Vector v, final int i, final int x) {
        v.setByte(i, (byte)x);
    }
    
    public static LList u8vector$To$List(final U8Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isS16vector(final Object x) {
        return x instanceof S16Vector;
    }
    
    public static S16Vector makeS16vector(final int n) {
        return makeS16vector(n, 0);
    }
    
    public static S16Vector makeS16vector(final int n, final int init) {
        return new S16Vector(n, (short)init);
    }
    
    public static S16Vector s16vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$S16vector(values);
    }
    
    public static S16Vector list$To$S16vector(final LList l) {
        final int n = l.size();
        final short[] arr = new short[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final short[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = (short)((Number)force).intValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new S16Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int s16vectorLength(final S16Vector v) {
        return v.size();
    }
    
    public static short s16vectorRef(final S16Vector v, final int i) {
        return v.getShort(i);
    }
    
    public static void s16vectorSet$Ex(final S16Vector v, final int i, final short x) {
        v.setShort(i, x);
    }
    
    public static LList s16vector$To$List(final S16Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isU16vector(final Object x) {
        return x instanceof U16Vector;
    }
    
    public static U16Vector makeU16vector(final int n) {
        return makeU16vector(n, 0);
    }
    
    public static U16Vector makeU16vector(final int n, final int init) {
        return new U16Vector(n, (short)init);
    }
    
    public static U16Vector u16vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$U16vector(values);
    }
    
    public static U16Vector list$To$U16vector(final LList l) {
        final int n = l.size();
        final short[] arr = new short[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final short[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = (short)((Number)force).intValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new U16Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int u16vectorLength(final U16Vector v) {
        return v.size();
    }
    
    @SourceMethodType({ "ushort" })
    public static int u16vectorRef(final U16Vector v, final int i) {
        return v.getShort(i);
    }
    
    @SourceMethodType({ "", "", "", "ushort" })
    public static void u16vectorSet$Ex(final U16Vector v, final int i, final int x) {
        v.setShort(i, (short)x);
    }
    
    public static LList u16vector$To$List(final U16Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isS32vector(final Object x) {
        return x instanceof S32Vector;
    }
    
    public static S32Vector makeS32vector(final int n) {
        return makeS32vector(n, 0);
    }
    
    public static S32Vector makeS32vector(final int n, final int init) {
        return new S32Vector(n, init);
    }
    
    public static S32Vector s32vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$S32vector(values);
    }
    
    public static S32Vector list$To$S32vector(final LList l) {
        final int n = l.size();
        final int[] arr = new int[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final int[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = ((Number)force).intValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new S32Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int s32vectorLength(final S32Vector v) {
        return v.size();
    }
    
    public static int s32vectorRef(final S32Vector v, final int i) {
        return v.getInt(i);
    }
    
    public static void s32vectorSet$Ex(final S32Vector v, final int i, final int x) {
        v.setInt(i, x);
    }
    
    public static LList s32vector$To$List(final S32Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isU32vector(final Object x) {
        return x instanceof U32Vector;
    }
    
    public static U32Vector makeU32vector(final int n) {
        return makeU32vector(n, 0L);
    }
    
    public static U32Vector makeU32vector(final int n, final long init) {
        return new U32Vector(n, (int)init);
    }
    
    public static U32Vector u32vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$U32vector(values);
    }
    
    public static U32Vector list$To$U32vector(final LList l) {
        final int n = l.size();
        final int[] arr = new int[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final int[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = ((Number)force).intValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new U32Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int u32vectorLength(final U32Vector v) {
        return v.size();
    }
    
    @SourceMethodType({ "uint" })
    public static int u32vectorRef(final U32Vector v, final int i) {
        return v.getInt(i);
    }
    
    @SourceMethodType({ "", "", "", "uint" })
    public static void u32vectorSet$Ex(final U32Vector v, final int i, final int x) {
        v.setInt(i, x);
    }
    
    public static LList u32vector$To$List(final U32Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isS64vector(final Object x) {
        return x instanceof S64Vector;
    }
    
    public static S64Vector makeS64vector(final int n) {
        return makeS64vector(n, 0L);
    }
    
    public static S64Vector makeS64vector(final int n, final long init) {
        return new S64Vector(n, init);
    }
    
    public static S64Vector s64vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$S64vector(values);
    }
    
    public static S64Vector list$To$S64vector(final LList l) {
        final int n = l.size();
        final long[] arr = new long[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final long[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = ((Number)force).longValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new S64Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int s64vectorLength(final S64Vector v) {
        return v.size();
    }
    
    public static long s64vectorRef(final S64Vector v, final int i) {
        return v.getLong(i);
    }
    
    public static void s64vectorSet$Ex(final S64Vector v, final int i, final long x) {
        v.setLong(i, x);
    }
    
    public static LList s64vector$To$List(final S64Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isU64vector(final Object x) {
        return x instanceof U64Vector;
    }
    
    public static U64Vector makeU64vector(final int n) {
        return makeU64vector(n, uniform.Lit0);
    }
    
    public static U64Vector makeU64vector(final int n, final IntNum init) {
        try {
            return new U64Vector(n, init.longValue());
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.lists.U64Vector.<init>(int,long)", 2, init);
        }
    }
    
    public static U64Vector u64vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$U64vector(values);
    }
    
    public static U64Vector list$To$U64vector(final LList l) {
        final int n = l.size();
        final long[] arr = new long[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final long[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = ((Number)force).longValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new U64Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int u64vectorLength(final U64Vector v) {
        return v.size();
    }
    
    @SourceMethodType({ "ulong" })
    public static long u64vectorRef(final U64Vector v, final int i) {
        return v.getLong(i);
    }
    
    @SourceMethodType({ "", "", "", "ulong" })
    public static void u64vectorSet$Ex(final U64Vector v, final int i, final long x) {
        v.setLong(i, x);
    }
    
    public static LList u64vector$To$List(final U64Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isF32vector(final Object x) {
        return x instanceof F32Vector;
    }
    
    public static F32Vector makeF32vector(final int n) {
        return makeF32vector(n, 0.0f);
    }
    
    public static F32Vector makeF32vector(final int n, final float init) {
        return new F32Vector(n, init);
    }
    
    public static F32Vector f32vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$F32vector(values);
    }
    
    public static F32Vector list$To$F32vector(final LList l) {
        final int n = l.size();
        final float[] arr = new float[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final float[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = ((Number)force).floatValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new F32Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int f32vectorLength(final F32Vector v) {
        return v.size();
    }
    
    public static float f32vectorRef(final F32Vector v, final int i) {
        return v.getFloat(i);
    }
    
    public static void f32vectorSet$Ex(final F32Vector v, final int i, final float x) {
        v.setFloat(i, x);
    }
    
    public static LList f32vector$To$List(final F32Vector v) {
        return LList.makeList(v);
    }
    
    public static boolean isF64vector(final Object x) {
        return x instanceof F64Vector;
    }
    
    public static F64Vector makeF64vector(final int n) {
        return makeF64vector(n, 0.0);
    }
    
    public static F64Vector makeF64vector(final int n, final double init) {
        return new F64Vector(n, init);
    }
    
    public static F64Vector f64vector$V(final Object[] argsArray) {
        final LList values = LList.makeList(argsArray, 0);
        return list$To$F64vector(values);
    }
    
    public static F64Vector list$To$F64vector(final LList l) {
        final int n = l.size();
        final double[] arr = new double[n];
        int i = 0;
        Object cdr = l;
        while (true) {
            Label_0073: {
                if (cdr == LList.Empty) {
                    break Label_0073;
                }
                final Pair pair = (Pair)Promise.force(cdr, Pair.class);
                final Object car = pair.getCar();
                final double[] array = arr;
                final int n2 = i;
                final Object force = Promise.force(car);
                try {
                    array[n2] = ((Number)force).doubleValue();
                    ++i;
                    cdr = pair.getCdr();
                    continue;
                    return new F64Vector(arr);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "v", -2, force);
                }
            }
        }
    }
    
    public static int f64vectorLength(final F64Vector v) {
        return v.size();
    }
    
    public static double f64vectorRef(final F64Vector v, final int i) {
        return v.getDouble(i);
    }
    
    public static void f64vectorSet$Ex(final F64Vector v, final int i, final double x) {
        v.setDouble(i, x);
    }
    
    public static LList f64vector$To$List(final F64Vector v) {
        return LList.makeList(v);
    }
    
    static {
        Lit90 = Symbol.valueOf("set!");
        Lit89 = Symbol.valueOf("v");
        Lit88 = PairWithPosition.make(Symbol.valueOf("x"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 139290);
        Lit87 = Symbol.valueOf("::");
        Lit86 = Symbol.valueOf("i");
        Lit85 = Symbol.valueOf("arr");
        Lit84 = Symbol.valueOf("n");
        Lit83 = new Object[0];
        Lit82 = Symbol.valueOf("list->f64vector");
        Lit81 = Symbol.valueOf("f64vector->list");
        Lit80 = Symbol.valueOf("f64vector-set!");
        Lit79 = Symbol.valueOf("f64vector-ref");
        Lit78 = Symbol.valueOf("f64vector-length");
        Lit77 = Symbol.valueOf("f64vector");
        Lit76 = Symbol.valueOf("make-f64vector");
        Lit75 = Symbol.valueOf("f64vector?");
        Lit74 = Symbol.valueOf("list->f32vector");
        Lit73 = Symbol.valueOf("f32vector->list");
        Lit72 = Symbol.valueOf("f32vector-set!");
        Lit71 = Symbol.valueOf("f32vector-ref");
        Lit70 = Symbol.valueOf("f32vector-length");
        Lit69 = Symbol.valueOf("f32vector");
        Lit68 = Symbol.valueOf("make-f32vector");
        Lit67 = Symbol.valueOf("f32vector?");
        Lit66 = Symbol.valueOf("list->u64vector");
        Lit65 = Symbol.valueOf("u64vector->list");
        Lit64 = Symbol.valueOf("u64vector-set!");
        Lit63 = Symbol.valueOf("u64vector-ref");
        Lit62 = Symbol.valueOf("u64vector-length");
        Lit61 = Symbol.valueOf("u64vector");
        Lit60 = Symbol.valueOf("make-u64vector");
        Lit59 = Symbol.valueOf("u64vector?");
        Lit58 = Symbol.valueOf("list->s64vector");
        Lit57 = Symbol.valueOf("s64vector->list");
        Lit56 = Symbol.valueOf("s64vector-set!");
        Lit55 = Symbol.valueOf("s64vector-ref");
        Lit54 = Symbol.valueOf("s64vector-length");
        Lit53 = Symbol.valueOf("s64vector");
        Lit52 = Symbol.valueOf("make-s64vector");
        Lit51 = Symbol.valueOf("s64vector?");
        Lit50 = Symbol.valueOf("list->u32vector");
        Lit49 = Symbol.valueOf("u32vector->list");
        Lit48 = Symbol.valueOf("u32vector-set!");
        Lit47 = Symbol.valueOf("u32vector-ref");
        Lit46 = Symbol.valueOf("u32vector-length");
        Lit45 = Symbol.valueOf("u32vector");
        Lit44 = Symbol.valueOf("make-u32vector");
        Lit43 = Symbol.valueOf("u32vector?");
        Lit42 = Symbol.valueOf("list->s32vector");
        Lit41 = Symbol.valueOf("s32vector->list");
        Lit40 = Symbol.valueOf("s32vector-set!");
        Lit39 = Symbol.valueOf("s32vector-ref");
        Lit38 = Symbol.valueOf("s32vector-length");
        Lit37 = Symbol.valueOf("s32vector");
        Lit36 = Symbol.valueOf("make-s32vector");
        Lit35 = Symbol.valueOf("s32vector?");
        Lit34 = Symbol.valueOf("list->u16vector");
        Lit33 = Symbol.valueOf("u16vector->list");
        Lit32 = Symbol.valueOf("u16vector-set!");
        Lit31 = Symbol.valueOf("u16vector-ref");
        Lit30 = Symbol.valueOf("u16vector-length");
        Lit29 = Symbol.valueOf("u16vector");
        Lit28 = Symbol.valueOf("make-u16vector");
        Lit27 = Symbol.valueOf("u16vector?");
        Lit26 = Symbol.valueOf("list->s16vector");
        Lit25 = Symbol.valueOf("s16vector->list");
        Lit24 = Symbol.valueOf("s16vector-set!");
        Lit23 = Symbol.valueOf("s16vector-ref");
        Lit22 = Symbol.valueOf("s16vector-length");
        Lit21 = Symbol.valueOf("s16vector");
        Lit20 = Symbol.valueOf("make-s16vector");
        Lit19 = Symbol.valueOf("s16vector?");
        Lit18 = Symbol.valueOf("list->u8vector");
        Lit17 = Symbol.valueOf("u8vector->list");
        Lit16 = Symbol.valueOf("u8vector-set!");
        Lit15 = Symbol.valueOf("u8vector-ref");
        Lit14 = Symbol.valueOf("u8vector-length");
        Lit13 = Symbol.valueOf("u8vector");
        Lit12 = Symbol.valueOf("make-u8vector");
        Lit11 = Symbol.valueOf("u8vector?");
        Lit10 = Symbol.valueOf("list->s8vector");
        Lit9 = new SyntaxRules(uniform.Lit83, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", uniform.Lit83, 3, "uniform.scm:30"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u00c9I\u0011\u0018\f\b\u0011\u0018\u0014\b\u0003a\u0011\u0018\u001c\b)\u0011\u0018$\b\u0013\u0018,\u00184\u0139\u0011\u0018<\u0109\u0011\u0018D\u0011\u0018L\u00c1\u0011\u0018T\u0011\u0018\\\b\u0011\u0018dY\b\u0011\u0018l\u0011\u0018t\t\u000b\u0018|\u0018\u0084\u0018\u008c\b\u0003\u0018\u0094", new Object[] { Symbol.valueOf("let*"), uniform.Lit84, Symbol.valueOf("length"), uniform.Lit85, Symbol.valueOf("$bracket-apply$"), PairWithPosition.make(Keyword.make("length"), PairWithPosition.make(uniform.Lit84, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 131113), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 131105), PairWithPosition.make(PairWithPosition.make(uniform.Lit86, PairWithPosition.make(uniform.Lit87, PairWithPosition.make(Symbol.valueOf("int"), PairWithPosition.make(Lit0 = IntNum.valueOf(0), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135190), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135186), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135184), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135181), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135181), Symbol.valueOf("for-each"), Symbol.valueOf("lambda"), uniform.Lit88, uniform.Lit90, PairWithPosition.make(uniform.Lit85, PairWithPosition.make(uniform.Lit86, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 143391), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 143386), Symbol.valueOf("let"), uniform.Lit89, uniform.Lit87, uniform.Lit88, PairWithPosition.make(uniform.Lit89, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 143418), PairWithPosition.make(PairWithPosition.make(uniform.Lit90, PairWithPosition.make(uniform.Lit86, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("+"), PairWithPosition.make(uniform.Lit86, PairWithPosition.make(IntNum.valueOf(1), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147489), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147487), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147484), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147484), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147482), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147476), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147476), PairWithPosition.make(uniform.Lit85, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 155656) }, 0) }, 3, Lit8 = Symbol.valueOf("%list->array"));
        Lit7 = Symbol.valueOf("s8vector->list");
        Lit6 = Symbol.valueOf("s8vector-set!");
        Lit5 = Symbol.valueOf("s8vector-ref");
        Lit4 = Symbol.valueOf("s8vector-length");
        Lit3 = Symbol.valueOf("s8vector");
        Lit2 = Symbol.valueOf("make-s8vector");
        Lit1 = Symbol.valueOf("s8vector?");
        uniform.$instance = new uniform();
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
        final uniform $instance = uniform.$instance;
        s8vector$Qu = new ModuleMethod($instance, 1, uniform.Lit1, 4097);
        make$Mns8vector = new ModuleMethod($instance, 2, uniform.Lit2, 8193);
        s8vector = new ModuleMethod($instance, 4, uniform.Lit3, -4096);
        s8vector$Mnlength = new ModuleMethod($instance, 5, uniform.Lit4, 4097);
        s8vector$Mnref = new ModuleMethod($instance, 6, uniform.Lit5, 8194);
        s8vector$Mnset$Ex = new ModuleMethod($instance, 7, uniform.Lit6, 12291);
        s8vector$Mn$Grlist = new ModuleMethod($instance, 8, uniform.Lit7, 4097);
        $Pclist$Mn$Grarray = Macro.make(uniform.Lit8, uniform.Lit9, "kawa.lib.uniform");
        list$Mn$Grs8vector = new ModuleMethod($instance, 9, uniform.Lit10, 4097);
        u8vector$Qu = new ModuleMethod($instance, 10, uniform.Lit11, 4097);
        make$Mnu8vector = new ModuleMethod($instance, 11, uniform.Lit12, 8193);
        u8vector = new ModuleMethod($instance, 13, uniform.Lit13, -4096);
        u8vector$Mnlength = new ModuleMethod($instance, 14, uniform.Lit14, 4097);
        u8vector$Mnref = new ModuleMethod($instance, 15, uniform.Lit15, 8194);
        u8vector$Mnset$Ex = new ModuleMethod($instance, 16, uniform.Lit16, 12291);
        u8vector$Mn$Grlist = new ModuleMethod($instance, 17, uniform.Lit17, 4097);
        list$Mn$Gru8vector = new ModuleMethod($instance, 18, uniform.Lit18, 4097);
        s16vector$Qu = new ModuleMethod($instance, 19, uniform.Lit19, 4097);
        make$Mns16vector = new ModuleMethod($instance, 20, uniform.Lit20, 8193);
        s16vector = new ModuleMethod($instance, 22, uniform.Lit21, -4096);
        s16vector$Mnlength = new ModuleMethod($instance, 23, uniform.Lit22, 4097);
        s16vector$Mnref = new ModuleMethod($instance, 24, uniform.Lit23, 8194);
        s16vector$Mnset$Ex = new ModuleMethod($instance, 25, uniform.Lit24, 12291);
        s16vector$Mn$Grlist = new ModuleMethod($instance, 26, uniform.Lit25, 4097);
        list$Mn$Grs16vector = new ModuleMethod($instance, 27, uniform.Lit26, 4097);
        u16vector$Qu = new ModuleMethod($instance, 28, uniform.Lit27, 4097);
        make$Mnu16vector = new ModuleMethod($instance, 29, uniform.Lit28, 8193);
        u16vector = new ModuleMethod($instance, 31, uniform.Lit29, -4096);
        u16vector$Mnlength = new ModuleMethod($instance, 32, uniform.Lit30, 4097);
        u16vector$Mnref = new ModuleMethod($instance, 33, uniform.Lit31, 8194);
        u16vector$Mnset$Ex = new ModuleMethod($instance, 34, uniform.Lit32, 12291);
        u16vector$Mn$Grlist = new ModuleMethod($instance, 35, uniform.Lit33, 4097);
        list$Mn$Gru16vector = new ModuleMethod($instance, 36, uniform.Lit34, 4097);
        s32vector$Qu = new ModuleMethod($instance, 37, uniform.Lit35, 4097);
        make$Mns32vector = new ModuleMethod($instance, 38, uniform.Lit36, 8193);
        s32vector = new ModuleMethod($instance, 40, uniform.Lit37, -4096);
        s32vector$Mnlength = new ModuleMethod($instance, 41, uniform.Lit38, 4097);
        s32vector$Mnref = new ModuleMethod($instance, 42, uniform.Lit39, 8194);
        s32vector$Mnset$Ex = new ModuleMethod($instance, 43, uniform.Lit40, 12291);
        s32vector$Mn$Grlist = new ModuleMethod($instance, 44, uniform.Lit41, 4097);
        list$Mn$Grs32vector = new ModuleMethod($instance, 45, uniform.Lit42, 4097);
        u32vector$Qu = new ModuleMethod($instance, 46, uniform.Lit43, 4097);
        make$Mnu32vector = new ModuleMethod($instance, 47, uniform.Lit44, 8193);
        u32vector = new ModuleMethod($instance, 49, uniform.Lit45, -4096);
        u32vector$Mnlength = new ModuleMethod($instance, 50, uniform.Lit46, 4097);
        u32vector$Mnref = new ModuleMethod($instance, 51, uniform.Lit47, 8194);
        u32vector$Mnset$Ex = new ModuleMethod($instance, 52, uniform.Lit48, 12291);
        u32vector$Mn$Grlist = new ModuleMethod($instance, 53, uniform.Lit49, 4097);
        list$Mn$Gru32vector = new ModuleMethod($instance, 54, uniform.Lit50, 4097);
        s64vector$Qu = new ModuleMethod($instance, 55, uniform.Lit51, 4097);
        make$Mns64vector = new ModuleMethod($instance, 56, uniform.Lit52, 8193);
        s64vector = new ModuleMethod($instance, 58, uniform.Lit53, -4096);
        s64vector$Mnlength = new ModuleMethod($instance, 59, uniform.Lit54, 4097);
        s64vector$Mnref = new ModuleMethod($instance, 60, uniform.Lit55, 8194);
        s64vector$Mnset$Ex = new ModuleMethod($instance, 61, uniform.Lit56, 12291);
        s64vector$Mn$Grlist = new ModuleMethod($instance, 62, uniform.Lit57, 4097);
        list$Mn$Grs64vector = new ModuleMethod($instance, 63, uniform.Lit58, 4097);
        u64vector$Qu = new ModuleMethod($instance, 64, uniform.Lit59, 4097);
        make$Mnu64vector = new ModuleMethod($instance, 65, uniform.Lit60, 8193);
        u64vector = new ModuleMethod($instance, 67, uniform.Lit61, -4096);
        u64vector$Mnlength = new ModuleMethod($instance, 68, uniform.Lit62, 4097);
        u64vector$Mnref = new ModuleMethod($instance, 69, uniform.Lit63, 8194);
        u64vector$Mnset$Ex = new ModuleMethod($instance, 70, uniform.Lit64, 12291);
        u64vector$Mn$Grlist = new ModuleMethod($instance, 71, uniform.Lit65, 4097);
        list$Mn$Gru64vector = new ModuleMethod($instance, 72, uniform.Lit66, 4097);
        f32vector$Qu = new ModuleMethod($instance, 73, uniform.Lit67, 4097);
        make$Mnf32vector = new ModuleMethod($instance, 74, uniform.Lit68, 8193);
        f32vector = new ModuleMethod($instance, 76, uniform.Lit69, -4096);
        f32vector$Mnlength = new ModuleMethod($instance, 77, uniform.Lit70, 4097);
        f32vector$Mnref = new ModuleMethod($instance, 78, uniform.Lit71, 8194);
        f32vector$Mnset$Ex = new ModuleMethod($instance, 79, uniform.Lit72, 12291);
        f32vector$Mn$Grlist = new ModuleMethod($instance, 80, uniform.Lit73, 4097);
        list$Mn$Grf32vector = new ModuleMethod($instance, 81, uniform.Lit74, 4097);
        f64vector$Qu = new ModuleMethod($instance, 82, uniform.Lit75, 4097);
        make$Mnf64vector = new ModuleMethod($instance, 83, uniform.Lit76, 8193);
        f64vector = new ModuleMethod($instance, 85, uniform.Lit77, -4096);
        f64vector$Mnlength = new ModuleMethod($instance, 86, uniform.Lit78, 4097);
        f64vector$Mnref = new ModuleMethod($instance, 87, uniform.Lit79, 8194);
        f64vector$Mnset$Ex = new ModuleMethod($instance, 88, uniform.Lit80, 12291);
        f64vector$Mn$Grlist = new ModuleMethod($instance, 89, uniform.Lit81, 4097);
        list$Mn$Grf64vector = new ModuleMethod($instance, 90, uniform.Lit82, 4097);
        $runBody$();
    }
    
    public uniform() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 90: {
                final Object force = Promise.force(arg1, LList.class);
                if (force instanceof LList) {
                    ctx.value1 = force;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 89: {
                final Object force2 = Promise.force(arg1, F64Vector.class);
                if (!(force2 instanceof F64Vector)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 86: {
                final Object force3 = Promise.force(arg1, F64Vector.class);
                if (!(force3 instanceof F64Vector)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 83: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 82: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 81: {
                final Object force4 = Promise.force(arg1, LList.class);
                if (force4 instanceof LList) {
                    ctx.value1 = force4;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 80: {
                final Object force5 = Promise.force(arg1, F32Vector.class);
                if (!(force5 instanceof F32Vector)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 77: {
                final Object force6 = Promise.force(arg1, F32Vector.class);
                if (!(force6 instanceof F32Vector)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 74: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 73: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 72: {
                final Object force7 = Promise.force(arg1, LList.class);
                if (force7 instanceof LList) {
                    ctx.value1 = force7;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 71: {
                final Object force8 = Promise.force(arg1, U64Vector.class);
                if (!(force8 instanceof U64Vector)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 68: {
                final Object force9 = Promise.force(arg1, U64Vector.class);
                if (!(force9 instanceof U64Vector)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 65: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 64: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 63: {
                final Object force10 = Promise.force(arg1, LList.class);
                if (force10 instanceof LList) {
                    ctx.value1 = force10;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 62: {
                final Object force11 = Promise.force(arg1, S64Vector.class);
                if (!(force11 instanceof S64Vector)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 59: {
                final Object force12 = Promise.force(arg1, S64Vector.class);
                if (!(force12 instanceof S64Vector)) {
                    return -786431;
                }
                ctx.value1 = force12;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 56: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 55: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 54: {
                final Object force13 = Promise.force(arg1, LList.class);
                if (force13 instanceof LList) {
                    ctx.value1 = force13;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 53: {
                final Object force14 = Promise.force(arg1, U32Vector.class);
                if (!(force14 instanceof U32Vector)) {
                    return -786431;
                }
                ctx.value1 = force14;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 50: {
                final Object force15 = Promise.force(arg1, U32Vector.class);
                if (!(force15 instanceof U32Vector)) {
                    return -786431;
                }
                ctx.value1 = force15;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 47: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 46: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 45: {
                final Object force16 = Promise.force(arg1, LList.class);
                if (force16 instanceof LList) {
                    ctx.value1 = force16;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 44: {
                final Object force17 = Promise.force(arg1, S32Vector.class);
                if (!(force17 instanceof S32Vector)) {
                    return -786431;
                }
                ctx.value1 = force17;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 41: {
                final Object force18 = Promise.force(arg1, S32Vector.class);
                if (!(force18 instanceof S32Vector)) {
                    return -786431;
                }
                ctx.value1 = force18;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 38: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 37: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 36: {
                final Object force19 = Promise.force(arg1, LList.class);
                if (force19 instanceof LList) {
                    ctx.value1 = force19;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 35: {
                final Object force20 = Promise.force(arg1, U16Vector.class);
                if (!(force20 instanceof U16Vector)) {
                    return -786431;
                }
                ctx.value1 = force20;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 32: {
                final Object force21 = Promise.force(arg1, U16Vector.class);
                if (!(force21 instanceof U16Vector)) {
                    return -786431;
                }
                ctx.value1 = force21;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 29: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 28: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 27: {
                final Object force22 = Promise.force(arg1, LList.class);
                if (force22 instanceof LList) {
                    ctx.value1 = force22;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 26: {
                final Object force23 = Promise.force(arg1, S16Vector.class);
                if (!(force23 instanceof S16Vector)) {
                    return -786431;
                }
                ctx.value1 = force23;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 23: {
                final Object force24 = Promise.force(arg1, S16Vector.class);
                if (!(force24 instanceof S16Vector)) {
                    return -786431;
                }
                ctx.value1 = force24;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 20: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 19: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
                final Object force25 = Promise.force(arg1, LList.class);
                if (force25 instanceof LList) {
                    ctx.value1 = force25;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 17: {
                final Object force26 = Promise.force(arg1, U8Vector.class);
                if (!(force26 instanceof U8Vector)) {
                    return -786431;
                }
                ctx.value1 = force26;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                final Object force27 = Promise.force(arg1, U8Vector.class);
                if (!(force27 instanceof U8Vector)) {
                    return -786431;
                }
                ctx.value1 = force27;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 11: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 10: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 9: {
                final Object force28 = Promise.force(arg1, LList.class);
                if (force28 instanceof LList) {
                    ctx.value1 = force28;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 8: {
                final Object force29 = Promise.force(arg1, S8Vector.class);
                if (!(force29 instanceof S8Vector)) {
                    return -786431;
                }
                ctx.value1 = force29;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                final Object force30 = Promise.force(arg1, S8Vector.class);
                if (!(force30 instanceof S8Vector)) {
                    return -786431;
                }
                ctx.value1 = force30;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
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
            case 87: {
                final Object force = Promise.force(arg1, F64Vector.class);
                if (!(force instanceof F64Vector)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 83: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 78: {
                final Object force2 = Promise.force(arg1, F32Vector.class);
                if (!(force2 instanceof F32Vector)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 74: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 69: {
                final Object force3 = Promise.force(arg1, U64Vector.class);
                if (!(force3 instanceof U64Vector)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 65: {
                ctx.value1 = Promise.force(arg1);
                final Object force4 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force4) != null) {
                    ctx.value2 = force4;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 60: {
                final Object force5 = Promise.force(arg1, S64Vector.class);
                if (!(force5 instanceof S64Vector)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 56: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 51: {
                final Object force6 = Promise.force(arg1, U32Vector.class);
                if (!(force6 instanceof U32Vector)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 47: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 42: {
                final Object force7 = Promise.force(arg1, S32Vector.class);
                if (!(force7 instanceof S32Vector)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 38: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 33: {
                final Object force8 = Promise.force(arg1, U16Vector.class);
                if (!(force8 instanceof U16Vector)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 29: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 24: {
                final Object force9 = Promise.force(arg1, S16Vector.class);
                if (!(force9 instanceof S16Vector)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 20: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 15: {
                final Object force10 = Promise.force(arg1, U8Vector.class);
                if (!(force10 instanceof U8Vector)) {
                    return -786431;
                }
                ctx.value1 = force10;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 11: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 6: {
                final Object force11 = Promise.force(arg1, S8Vector.class);
                if (!(force11 instanceof S8Vector)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 2: {
                ctx.value1 = Promise.force(arg1);
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
            case 88: {
                final Object force = Promise.force(arg1, F64Vector.class);
                if (!(force instanceof F64Vector)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 79: {
                final Object force2 = Promise.force(arg1, F32Vector.class);
                if (!(force2 instanceof F32Vector)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 70: {
                final Object force3 = Promise.force(arg1, U64Vector.class);
                if (!(force3 instanceof U64Vector)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = Promise.force(arg2);
                final Object force4 = Promise.force(arg3);
                if (force4 instanceof Number) {
                    ctx.value3 = force4;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 61: {
                final Object force5 = Promise.force(arg1, S64Vector.class);
                if (!(force5 instanceof S64Vector)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 52: {
                final Object force6 = Promise.force(arg1, U32Vector.class);
                if (!(force6 instanceof U32Vector)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.value2 = Promise.force(arg2);
                final Object force7 = Promise.force(arg3);
                if (force7 instanceof Number) {
                    ctx.value3 = force7;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 43: {
                final Object force8 = Promise.force(arg1, S32Vector.class);
                if (!(force8 instanceof S32Vector)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 34: {
                final Object force9 = Promise.force(arg1, U16Vector.class);
                if (!(force9 instanceof U16Vector)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.value2 = Promise.force(arg2);
                final Object force10 = Promise.force(arg3);
                if (force10 instanceof Number) {
                    ctx.value3 = force10;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 25: {
                final Object force11 = Promise.force(arg1, S16Vector.class);
                if (!(force11 instanceof S16Vector)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 16: {
                final Object force12 = Promise.force(arg1, U8Vector.class);
                if (!(force12 instanceof U8Vector)) {
                    return -786431;
                }
                ctx.value1 = force12;
                ctx.value2 = Promise.force(arg2);
                final Object force13 = Promise.force(arg3);
                if (force13 instanceof Number) {
                    ctx.value3 = force13;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 7: {
                final Object force14 = Promise.force(arg1, S8Vector.class);
                if (!(force14 instanceof S8Vector)) {
                    return -786431;
                }
                ctx.value1 = force14;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
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
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 85: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 76: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 67: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 58: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 49: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 40: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 31: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 22: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 13: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 4: {
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
        //                2: 380
        //                3: 397
        //                4: 1112
        //                5: 1112
        //                6: 411
        //                7: 1112
        //                8: 1112
        //                9: 427
        //               10: 440
        //               11: 453
        //               12: 470
        //               13: 1112
        //               14: 1112
        //               15: 484
        //               16: 1112
        //               17: 1112
        //               18: 500
        //               19: 513
        //               20: 526
        //               21: 543
        //               22: 1112
        //               23: 1112
        //               24: 557
        //               25: 1112
        //               26: 1112
        //               27: 573
        //               28: 586
        //               29: 599
        //               30: 616
        //               31: 1112
        //               32: 1112
        //               33: 630
        //               34: 1112
        //               35: 1112
        //               36: 646
        //               37: 659
        //               38: 672
        //               39: 689
        //               40: 1112
        //               41: 1112
        //               42: 703
        //               43: 1112
        //               44: 1112
        //               45: 719
        //               46: 732
        //               47: 745
        //               48: 762
        //               49: 1112
        //               50: 1112
        //               51: 776
        //               52: 1112
        //               53: 1112
        //               54: 792
        //               55: 805
        //               56: 818
        //               57: 835
        //               58: 1112
        //               59: 1112
        //               60: 849
        //               61: 1112
        //               62: 1112
        //               63: 865
        //               64: 878
        //               65: 891
        //               66: 908
        //               67: 1112
        //               68: 1112
        //               69: 922
        //               70: 1112
        //               71: 1112
        //               72: 938
        //               73: 951
        //               74: 964
        //               75: 981
        //               76: 1112
        //               77: 1112
        //               78: 995
        //               79: 1112
        //               80: 1112
        //               81: 1011
        //               82: 1024
        //               83: 1037
        //               84: 1054
        //               85: 1112
        //               86: 1112
        //               87: 1068
        //               88: 1112
        //               89: 1112
        //               90: 1085
        //               91: 1099
        //          default: 1112
        //        }
        //   380: aload_2        
        //   381: invokestatic    kawa/lib/uniform.isS8vector:(Ljava/lang/Object;)Z
        //   384: ifeq            393
        //   387: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   390: goto            396
        //   393: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   396: areturn        
        //   397: aload_2        
        //   398: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   401: checkcast       Ljava/lang/Number;
        //   404: invokevirtual   java/lang/Number.intValue:()I
        //   407: invokestatic    kawa/lib/uniform.makeS8vector:(I)Lgnu/lists/S8Vector;
        //   410: areturn        
        //   411: aload_2        
        //   412: ldc             Lgnu/lists/S8Vector;.class
        //   414: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   417: checkcast       Lgnu/lists/S8Vector;
        //   420: invokestatic    kawa/lib/uniform.s8vectorLength:(Lgnu/lists/S8Vector;)I
        //   423: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   426: areturn        
        //   427: aload_2        
        //   428: ldc             Lgnu/lists/S8Vector;.class
        //   430: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   433: checkcast       Lgnu/lists/S8Vector;
        //   436: invokestatic    kawa/lib/uniform.s8vector$To$List:(Lgnu/lists/S8Vector;)Lgnu/lists/LList;
        //   439: areturn        
        //   440: aload_2        
        //   441: ldc             Lgnu/lists/LList;.class
        //   443: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   446: checkcast       Lgnu/lists/LList;
        //   449: invokestatic    kawa/lib/uniform.list$To$S8vector:(Lgnu/lists/LList;)Lgnu/lists/S8Vector;
        //   452: areturn        
        //   453: aload_2        
        //   454: invokestatic    kawa/lib/uniform.isU8vector:(Ljava/lang/Object;)Z
        //   457: ifeq            466
        //   460: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   463: goto            469
        //   466: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   469: areturn        
        //   470: aload_2        
        //   471: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   474: checkcast       Ljava/lang/Number;
        //   477: invokevirtual   java/lang/Number.intValue:()I
        //   480: invokestatic    kawa/lib/uniform.makeU8vector:(I)Lgnu/lists/U8Vector;
        //   483: areturn        
        //   484: aload_2        
        //   485: ldc             Lgnu/lists/U8Vector;.class
        //   487: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   490: checkcast       Lgnu/lists/U8Vector;
        //   493: invokestatic    kawa/lib/uniform.u8vectorLength:(Lgnu/lists/U8Vector;)I
        //   496: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   499: areturn        
        //   500: aload_2        
        //   501: ldc             Lgnu/lists/U8Vector;.class
        //   503: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   506: checkcast       Lgnu/lists/U8Vector;
        //   509: invokestatic    kawa/lib/uniform.u8vector$To$List:(Lgnu/lists/U8Vector;)Lgnu/lists/LList;
        //   512: areturn        
        //   513: aload_2        
        //   514: ldc             Lgnu/lists/LList;.class
        //   516: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   519: checkcast       Lgnu/lists/LList;
        //   522: invokestatic    kawa/lib/uniform.list$To$U8vector:(Lgnu/lists/LList;)Lgnu/lists/U8Vector;
        //   525: areturn        
        //   526: aload_2        
        //   527: invokestatic    kawa/lib/uniform.isS16vector:(Ljava/lang/Object;)Z
        //   530: ifeq            539
        //   533: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   536: goto            542
        //   539: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   542: areturn        
        //   543: aload_2        
        //   544: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   547: checkcast       Ljava/lang/Number;
        //   550: invokevirtual   java/lang/Number.intValue:()I
        //   553: invokestatic    kawa/lib/uniform.makeS16vector:(I)Lgnu/lists/S16Vector;
        //   556: areturn        
        //   557: aload_2        
        //   558: ldc             Lgnu/lists/S16Vector;.class
        //   560: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   563: checkcast       Lgnu/lists/S16Vector;
        //   566: invokestatic    kawa/lib/uniform.s16vectorLength:(Lgnu/lists/S16Vector;)I
        //   569: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   572: areturn        
        //   573: aload_2        
        //   574: ldc             Lgnu/lists/S16Vector;.class
        //   576: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   579: checkcast       Lgnu/lists/S16Vector;
        //   582: invokestatic    kawa/lib/uniform.s16vector$To$List:(Lgnu/lists/S16Vector;)Lgnu/lists/LList;
        //   585: areturn        
        //   586: aload_2        
        //   587: ldc             Lgnu/lists/LList;.class
        //   589: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   592: checkcast       Lgnu/lists/LList;
        //   595: invokestatic    kawa/lib/uniform.list$To$S16vector:(Lgnu/lists/LList;)Lgnu/lists/S16Vector;
        //   598: areturn        
        //   599: aload_2        
        //   600: invokestatic    kawa/lib/uniform.isU16vector:(Ljava/lang/Object;)Z
        //   603: ifeq            612
        //   606: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   609: goto            615
        //   612: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   615: areturn        
        //   616: aload_2        
        //   617: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   620: checkcast       Ljava/lang/Number;
        //   623: invokevirtual   java/lang/Number.intValue:()I
        //   626: invokestatic    kawa/lib/uniform.makeU16vector:(I)Lgnu/lists/U16Vector;
        //   629: areturn        
        //   630: aload_2        
        //   631: ldc             Lgnu/lists/U16Vector;.class
        //   633: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   636: checkcast       Lgnu/lists/U16Vector;
        //   639: invokestatic    kawa/lib/uniform.u16vectorLength:(Lgnu/lists/U16Vector;)I
        //   642: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   645: areturn        
        //   646: aload_2        
        //   647: ldc             Lgnu/lists/U16Vector;.class
        //   649: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   652: checkcast       Lgnu/lists/U16Vector;
        //   655: invokestatic    kawa/lib/uniform.u16vector$To$List:(Lgnu/lists/U16Vector;)Lgnu/lists/LList;
        //   658: areturn        
        //   659: aload_2        
        //   660: ldc             Lgnu/lists/LList;.class
        //   662: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   665: checkcast       Lgnu/lists/LList;
        //   668: invokestatic    kawa/lib/uniform.list$To$U16vector:(Lgnu/lists/LList;)Lgnu/lists/U16Vector;
        //   671: areturn        
        //   672: aload_2        
        //   673: invokestatic    kawa/lib/uniform.isS32vector:(Ljava/lang/Object;)Z
        //   676: ifeq            685
        //   679: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   682: goto            688
        //   685: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   688: areturn        
        //   689: aload_2        
        //   690: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   693: checkcast       Ljava/lang/Number;
        //   696: invokevirtual   java/lang/Number.intValue:()I
        //   699: invokestatic    kawa/lib/uniform.makeS32vector:(I)Lgnu/lists/S32Vector;
        //   702: areturn        
        //   703: aload_2        
        //   704: ldc             Lgnu/lists/S32Vector;.class
        //   706: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   709: checkcast       Lgnu/lists/S32Vector;
        //   712: invokestatic    kawa/lib/uniform.s32vectorLength:(Lgnu/lists/S32Vector;)I
        //   715: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   718: areturn        
        //   719: aload_2        
        //   720: ldc             Lgnu/lists/S32Vector;.class
        //   722: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   725: checkcast       Lgnu/lists/S32Vector;
        //   728: invokestatic    kawa/lib/uniform.s32vector$To$List:(Lgnu/lists/S32Vector;)Lgnu/lists/LList;
        //   731: areturn        
        //   732: aload_2        
        //   733: ldc             Lgnu/lists/LList;.class
        //   735: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   738: checkcast       Lgnu/lists/LList;
        //   741: invokestatic    kawa/lib/uniform.list$To$S32vector:(Lgnu/lists/LList;)Lgnu/lists/S32Vector;
        //   744: areturn        
        //   745: aload_2        
        //   746: invokestatic    kawa/lib/uniform.isU32vector:(Ljava/lang/Object;)Z
        //   749: ifeq            758
        //   752: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   755: goto            761
        //   758: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   761: areturn        
        //   762: aload_2        
        //   763: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   766: checkcast       Ljava/lang/Number;
        //   769: invokevirtual   java/lang/Number.intValue:()I
        //   772: invokestatic    kawa/lib/uniform.makeU32vector:(I)Lgnu/lists/U32Vector;
        //   775: areturn        
        //   776: aload_2        
        //   777: ldc             Lgnu/lists/U32Vector;.class
        //   779: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   782: checkcast       Lgnu/lists/U32Vector;
        //   785: invokestatic    kawa/lib/uniform.u32vectorLength:(Lgnu/lists/U32Vector;)I
        //   788: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   791: areturn        
        //   792: aload_2        
        //   793: ldc             Lgnu/lists/U32Vector;.class
        //   795: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   798: checkcast       Lgnu/lists/U32Vector;
        //   801: invokestatic    kawa/lib/uniform.u32vector$To$List:(Lgnu/lists/U32Vector;)Lgnu/lists/LList;
        //   804: areturn        
        //   805: aload_2        
        //   806: ldc             Lgnu/lists/LList;.class
        //   808: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   811: checkcast       Lgnu/lists/LList;
        //   814: invokestatic    kawa/lib/uniform.list$To$U32vector:(Lgnu/lists/LList;)Lgnu/lists/U32Vector;
        //   817: areturn        
        //   818: aload_2        
        //   819: invokestatic    kawa/lib/uniform.isS64vector:(Ljava/lang/Object;)Z
        //   822: ifeq            831
        //   825: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   828: goto            834
        //   831: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   834: areturn        
        //   835: aload_2        
        //   836: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   839: checkcast       Ljava/lang/Number;
        //   842: invokevirtual   java/lang/Number.intValue:()I
        //   845: invokestatic    kawa/lib/uniform.makeS64vector:(I)Lgnu/lists/S64Vector;
        //   848: areturn        
        //   849: aload_2        
        //   850: ldc             Lgnu/lists/S64Vector;.class
        //   852: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   855: checkcast       Lgnu/lists/S64Vector;
        //   858: invokestatic    kawa/lib/uniform.s64vectorLength:(Lgnu/lists/S64Vector;)I
        //   861: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   864: areturn        
        //   865: aload_2        
        //   866: ldc             Lgnu/lists/S64Vector;.class
        //   868: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   871: checkcast       Lgnu/lists/S64Vector;
        //   874: invokestatic    kawa/lib/uniform.s64vector$To$List:(Lgnu/lists/S64Vector;)Lgnu/lists/LList;
        //   877: areturn        
        //   878: aload_2        
        //   879: ldc             Lgnu/lists/LList;.class
        //   881: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   884: checkcast       Lgnu/lists/LList;
        //   887: invokestatic    kawa/lib/uniform.list$To$S64vector:(Lgnu/lists/LList;)Lgnu/lists/S64Vector;
        //   890: areturn        
        //   891: aload_2        
        //   892: invokestatic    kawa/lib/uniform.isU64vector:(Ljava/lang/Object;)Z
        //   895: ifeq            904
        //   898: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   901: goto            907
        //   904: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   907: areturn        
        //   908: aload_2        
        //   909: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   912: checkcast       Ljava/lang/Number;
        //   915: invokevirtual   java/lang/Number.intValue:()I
        //   918: invokestatic    kawa/lib/uniform.makeU64vector:(I)Lgnu/lists/U64Vector;
        //   921: areturn        
        //   922: aload_2        
        //   923: ldc             Lgnu/lists/U64Vector;.class
        //   925: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   928: checkcast       Lgnu/lists/U64Vector;
        //   931: invokestatic    kawa/lib/uniform.u64vectorLength:(Lgnu/lists/U64Vector;)I
        //   934: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   937: areturn        
        //   938: aload_2        
        //   939: ldc             Lgnu/lists/U64Vector;.class
        //   941: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   944: checkcast       Lgnu/lists/U64Vector;
        //   947: invokestatic    kawa/lib/uniform.u64vector$To$List:(Lgnu/lists/U64Vector;)Lgnu/lists/LList;
        //   950: areturn        
        //   951: aload_2        
        //   952: ldc             Lgnu/lists/LList;.class
        //   954: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   957: checkcast       Lgnu/lists/LList;
        //   960: invokestatic    kawa/lib/uniform.list$To$U64vector:(Lgnu/lists/LList;)Lgnu/lists/U64Vector;
        //   963: areturn        
        //   964: aload_2        
        //   965: invokestatic    kawa/lib/uniform.isF32vector:(Ljava/lang/Object;)Z
        //   968: ifeq            977
        //   971: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   974: goto            980
        //   977: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   980: areturn        
        //   981: aload_2        
        //   982: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   985: checkcast       Ljava/lang/Number;
        //   988: invokevirtual   java/lang/Number.intValue:()I
        //   991: invokestatic    kawa/lib/uniform.makeF32vector:(I)Lgnu/lists/F32Vector;
        //   994: areturn        
        //   995: aload_2        
        //   996: ldc             Lgnu/lists/F32Vector;.class
        //   998: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1001: checkcast       Lgnu/lists/F32Vector;
        //  1004: invokestatic    kawa/lib/uniform.f32vectorLength:(Lgnu/lists/F32Vector;)I
        //  1007: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1010: areturn        
        //  1011: aload_2        
        //  1012: ldc             Lgnu/lists/F32Vector;.class
        //  1014: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1017: checkcast       Lgnu/lists/F32Vector;
        //  1020: invokestatic    kawa/lib/uniform.f32vector$To$List:(Lgnu/lists/F32Vector;)Lgnu/lists/LList;
        //  1023: areturn        
        //  1024: aload_2        
        //  1025: ldc             Lgnu/lists/LList;.class
        //  1027: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1030: checkcast       Lgnu/lists/LList;
        //  1033: invokestatic    kawa/lib/uniform.list$To$F32vector:(Lgnu/lists/LList;)Lgnu/lists/F32Vector;
        //  1036: areturn        
        //  1037: aload_2        
        //  1038: invokestatic    kawa/lib/uniform.isF64vector:(Ljava/lang/Object;)Z
        //  1041: ifeq            1050
        //  1044: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1047: goto            1053
        //  1050: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1053: areturn        
        //  1054: aload_2        
        //  1055: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1058: checkcast       Ljava/lang/Number;
        //  1061: invokevirtual   java/lang/Number.intValue:()I
        //  1064: invokestatic    kawa/lib/uniform.makeF64vector:(I)Lgnu/lists/F64Vector;
        //  1067: areturn        
        //  1068: aload_2        
        //  1069: ldc_w           Lgnu/lists/F64Vector;.class
        //  1072: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1075: checkcast       Lgnu/lists/F64Vector;
        //  1078: invokestatic    kawa/lib/uniform.f64vectorLength:(Lgnu/lists/F64Vector;)I
        //  1081: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1084: areturn        
        //  1085: aload_2        
        //  1086: ldc_w           Lgnu/lists/F64Vector;.class
        //  1089: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1092: checkcast       Lgnu/lists/F64Vector;
        //  1095: invokestatic    kawa/lib/uniform.f64vector$To$List:(Lgnu/lists/F64Vector;)Lgnu/lists/LList;
        //  1098: areturn        
        //  1099: aload_2        
        //  1100: ldc             Lgnu/lists/LList;.class
        //  1102: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1105: checkcast       Lgnu/lists/LList;
        //  1108: invokestatic    kawa/lib/uniform.list$To$F64vector:(Lgnu/lists/LList;)Lgnu/lists/F64Vector;
        //  1111: areturn        
        //  1112: aload_0        
        //  1113: aload_1        
        //  1114: aload_2        
        //  1115: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //  1118: areturn        
        //  1119: new             Lgnu/mapping/WrongType;
        //  1122: dup_x1         
        //  1123: swap           
        //  1124: ldc_w           "make-s8vector"
        //  1127: iconst_1       
        //  1128: aload_2        
        //  1129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1132: athrow         
        //  1133: new             Lgnu/mapping/WrongType;
        //  1136: dup_x1         
        //  1137: swap           
        //  1138: ldc_w           "s8vector-length"
        //  1141: iconst_1       
        //  1142: aload_2        
        //  1143: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1146: athrow         
        //  1147: new             Lgnu/mapping/WrongType;
        //  1150: dup_x1         
        //  1151: swap           
        //  1152: ldc_w           "s8vector->list"
        //  1155: iconst_1       
        //  1156: aload_2        
        //  1157: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1160: athrow         
        //  1161: new             Lgnu/mapping/WrongType;
        //  1164: dup_x1         
        //  1165: swap           
        //  1166: ldc_w           "list->s8vector"
        //  1169: iconst_1       
        //  1170: aload_2        
        //  1171: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1174: athrow         
        //  1175: new             Lgnu/mapping/WrongType;
        //  1178: dup_x1         
        //  1179: swap           
        //  1180: ldc_w           "make-u8vector"
        //  1183: iconst_1       
        //  1184: aload_2        
        //  1185: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1188: athrow         
        //  1189: new             Lgnu/mapping/WrongType;
        //  1192: dup_x1         
        //  1193: swap           
        //  1194: ldc_w           "u8vector-length"
        //  1197: iconst_1       
        //  1198: aload_2        
        //  1199: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1202: athrow         
        //  1203: new             Lgnu/mapping/WrongType;
        //  1206: dup_x1         
        //  1207: swap           
        //  1208: ldc_w           "u8vector->list"
        //  1211: iconst_1       
        //  1212: aload_2        
        //  1213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1216: athrow         
        //  1217: new             Lgnu/mapping/WrongType;
        //  1220: dup_x1         
        //  1221: swap           
        //  1222: ldc_w           "list->u8vector"
        //  1225: iconst_1       
        //  1226: aload_2        
        //  1227: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1230: athrow         
        //  1231: new             Lgnu/mapping/WrongType;
        //  1234: dup_x1         
        //  1235: swap           
        //  1236: ldc_w           "make-s16vector"
        //  1239: iconst_1       
        //  1240: aload_2        
        //  1241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1244: athrow         
        //  1245: new             Lgnu/mapping/WrongType;
        //  1248: dup_x1         
        //  1249: swap           
        //  1250: ldc_w           "s16vector-length"
        //  1253: iconst_1       
        //  1254: aload_2        
        //  1255: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1258: athrow         
        //  1259: new             Lgnu/mapping/WrongType;
        //  1262: dup_x1         
        //  1263: swap           
        //  1264: ldc_w           "s16vector->list"
        //  1267: iconst_1       
        //  1268: aload_2        
        //  1269: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1272: athrow         
        //  1273: new             Lgnu/mapping/WrongType;
        //  1276: dup_x1         
        //  1277: swap           
        //  1278: ldc_w           "list->s16vector"
        //  1281: iconst_1       
        //  1282: aload_2        
        //  1283: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1286: athrow         
        //  1287: new             Lgnu/mapping/WrongType;
        //  1290: dup_x1         
        //  1291: swap           
        //  1292: ldc_w           "make-u16vector"
        //  1295: iconst_1       
        //  1296: aload_2        
        //  1297: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1300: athrow         
        //  1301: new             Lgnu/mapping/WrongType;
        //  1304: dup_x1         
        //  1305: swap           
        //  1306: ldc_w           "u16vector-length"
        //  1309: iconst_1       
        //  1310: aload_2        
        //  1311: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1314: athrow         
        //  1315: new             Lgnu/mapping/WrongType;
        //  1318: dup_x1         
        //  1319: swap           
        //  1320: ldc_w           "u16vector->list"
        //  1323: iconst_1       
        //  1324: aload_2        
        //  1325: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1328: athrow         
        //  1329: new             Lgnu/mapping/WrongType;
        //  1332: dup_x1         
        //  1333: swap           
        //  1334: ldc_w           "list->u16vector"
        //  1337: iconst_1       
        //  1338: aload_2        
        //  1339: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1342: athrow         
        //  1343: new             Lgnu/mapping/WrongType;
        //  1346: dup_x1         
        //  1347: swap           
        //  1348: ldc_w           "make-s32vector"
        //  1351: iconst_1       
        //  1352: aload_2        
        //  1353: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1356: athrow         
        //  1357: new             Lgnu/mapping/WrongType;
        //  1360: dup_x1         
        //  1361: swap           
        //  1362: ldc_w           "s32vector-length"
        //  1365: iconst_1       
        //  1366: aload_2        
        //  1367: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1370: athrow         
        //  1371: new             Lgnu/mapping/WrongType;
        //  1374: dup_x1         
        //  1375: swap           
        //  1376: ldc_w           "s32vector->list"
        //  1379: iconst_1       
        //  1380: aload_2        
        //  1381: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1384: athrow         
        //  1385: new             Lgnu/mapping/WrongType;
        //  1388: dup_x1         
        //  1389: swap           
        //  1390: ldc_w           "list->s32vector"
        //  1393: iconst_1       
        //  1394: aload_2        
        //  1395: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1398: athrow         
        //  1399: new             Lgnu/mapping/WrongType;
        //  1402: dup_x1         
        //  1403: swap           
        //  1404: ldc_w           "make-u32vector"
        //  1407: iconst_1       
        //  1408: aload_2        
        //  1409: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1412: athrow         
        //  1413: new             Lgnu/mapping/WrongType;
        //  1416: dup_x1         
        //  1417: swap           
        //  1418: ldc_w           "u32vector-length"
        //  1421: iconst_1       
        //  1422: aload_2        
        //  1423: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1426: athrow         
        //  1427: new             Lgnu/mapping/WrongType;
        //  1430: dup_x1         
        //  1431: swap           
        //  1432: ldc_w           "u32vector->list"
        //  1435: iconst_1       
        //  1436: aload_2        
        //  1437: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1440: athrow         
        //  1441: new             Lgnu/mapping/WrongType;
        //  1444: dup_x1         
        //  1445: swap           
        //  1446: ldc_w           "list->u32vector"
        //  1449: iconst_1       
        //  1450: aload_2        
        //  1451: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1454: athrow         
        //  1455: new             Lgnu/mapping/WrongType;
        //  1458: dup_x1         
        //  1459: swap           
        //  1460: ldc_w           "make-s64vector"
        //  1463: iconst_1       
        //  1464: aload_2        
        //  1465: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1468: athrow         
        //  1469: new             Lgnu/mapping/WrongType;
        //  1472: dup_x1         
        //  1473: swap           
        //  1474: ldc_w           "s64vector-length"
        //  1477: iconst_1       
        //  1478: aload_2        
        //  1479: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1482: athrow         
        //  1483: new             Lgnu/mapping/WrongType;
        //  1486: dup_x1         
        //  1487: swap           
        //  1488: ldc_w           "s64vector->list"
        //  1491: iconst_1       
        //  1492: aload_2        
        //  1493: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1496: athrow         
        //  1497: new             Lgnu/mapping/WrongType;
        //  1500: dup_x1         
        //  1501: swap           
        //  1502: ldc_w           "list->s64vector"
        //  1505: iconst_1       
        //  1506: aload_2        
        //  1507: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1510: athrow         
        //  1511: new             Lgnu/mapping/WrongType;
        //  1514: dup_x1         
        //  1515: swap           
        //  1516: ldc_w           "make-u64vector"
        //  1519: iconst_1       
        //  1520: aload_2        
        //  1521: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1524: athrow         
        //  1525: new             Lgnu/mapping/WrongType;
        //  1528: dup_x1         
        //  1529: swap           
        //  1530: ldc_w           "u64vector-length"
        //  1533: iconst_1       
        //  1534: aload_2        
        //  1535: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1538: athrow         
        //  1539: new             Lgnu/mapping/WrongType;
        //  1542: dup_x1         
        //  1543: swap           
        //  1544: ldc_w           "u64vector->list"
        //  1547: iconst_1       
        //  1548: aload_2        
        //  1549: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1552: athrow         
        //  1553: new             Lgnu/mapping/WrongType;
        //  1556: dup_x1         
        //  1557: swap           
        //  1558: ldc_w           "list->u64vector"
        //  1561: iconst_1       
        //  1562: aload_2        
        //  1563: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1566: athrow         
        //  1567: new             Lgnu/mapping/WrongType;
        //  1570: dup_x1         
        //  1571: swap           
        //  1572: ldc_w           "make-f32vector"
        //  1575: iconst_1       
        //  1576: aload_2        
        //  1577: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1580: athrow         
        //  1581: new             Lgnu/mapping/WrongType;
        //  1584: dup_x1         
        //  1585: swap           
        //  1586: ldc_w           "f32vector-length"
        //  1589: iconst_1       
        //  1590: aload_2        
        //  1591: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1594: athrow         
        //  1595: new             Lgnu/mapping/WrongType;
        //  1598: dup_x1         
        //  1599: swap           
        //  1600: ldc_w           "f32vector->list"
        //  1603: iconst_1       
        //  1604: aload_2        
        //  1605: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1608: athrow         
        //  1609: new             Lgnu/mapping/WrongType;
        //  1612: dup_x1         
        //  1613: swap           
        //  1614: ldc_w           "list->f32vector"
        //  1617: iconst_1       
        //  1618: aload_2        
        //  1619: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1622: athrow         
        //  1623: new             Lgnu/mapping/WrongType;
        //  1626: dup_x1         
        //  1627: swap           
        //  1628: ldc_w           "make-f64vector"
        //  1631: iconst_1       
        //  1632: aload_2        
        //  1633: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1636: athrow         
        //  1637: new             Lgnu/mapping/WrongType;
        //  1640: dup_x1         
        //  1641: swap           
        //  1642: ldc_w           "f64vector-length"
        //  1645: iconst_1       
        //  1646: aload_2        
        //  1647: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1650: athrow         
        //  1651: new             Lgnu/mapping/WrongType;
        //  1654: dup_x1         
        //  1655: swap           
        //  1656: ldc_w           "f64vector->list"
        //  1659: iconst_1       
        //  1660: aload_2        
        //  1661: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1664: athrow         
        //  1665: new             Lgnu/mapping/WrongType;
        //  1668: dup_x1         
        //  1669: swap           
        //  1670: ldc_w           "list->f64vector"
        //  1673: iconst_1       
        //  1674: aload_2        
        //  1675: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1678: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  401    407    1119   1133   Ljava/lang/ClassCastException;
        //  417    420    1133   1147   Ljava/lang/ClassCastException;
        //  433    436    1147   1161   Ljava/lang/ClassCastException;
        //  446    449    1161   1175   Ljava/lang/ClassCastException;
        //  474    480    1175   1189   Ljava/lang/ClassCastException;
        //  490    493    1189   1203   Ljava/lang/ClassCastException;
        //  506    509    1203   1217   Ljava/lang/ClassCastException;
        //  519    522    1217   1231   Ljava/lang/ClassCastException;
        //  547    553    1231   1245   Ljava/lang/ClassCastException;
        //  563    566    1245   1259   Ljava/lang/ClassCastException;
        //  579    582    1259   1273   Ljava/lang/ClassCastException;
        //  592    595    1273   1287   Ljava/lang/ClassCastException;
        //  620    626    1287   1301   Ljava/lang/ClassCastException;
        //  636    639    1301   1315   Ljava/lang/ClassCastException;
        //  652    655    1315   1329   Ljava/lang/ClassCastException;
        //  665    668    1329   1343   Ljava/lang/ClassCastException;
        //  693    699    1343   1357   Ljava/lang/ClassCastException;
        //  709    712    1357   1371   Ljava/lang/ClassCastException;
        //  725    728    1371   1385   Ljava/lang/ClassCastException;
        //  738    741    1385   1399   Ljava/lang/ClassCastException;
        //  766    772    1399   1413   Ljava/lang/ClassCastException;
        //  782    785    1413   1427   Ljava/lang/ClassCastException;
        //  798    801    1427   1441   Ljava/lang/ClassCastException;
        //  811    814    1441   1455   Ljava/lang/ClassCastException;
        //  839    845    1455   1469   Ljava/lang/ClassCastException;
        //  855    858    1469   1483   Ljava/lang/ClassCastException;
        //  871    874    1483   1497   Ljava/lang/ClassCastException;
        //  884    887    1497   1511   Ljava/lang/ClassCastException;
        //  912    918    1511   1525   Ljava/lang/ClassCastException;
        //  928    931    1525   1539   Ljava/lang/ClassCastException;
        //  944    947    1539   1553   Ljava/lang/ClassCastException;
        //  957    960    1553   1567   Ljava/lang/ClassCastException;
        //  985    991    1567   1581   Ljava/lang/ClassCastException;
        //  1001   1004   1581   1595   Ljava/lang/ClassCastException;
        //  1017   1020   1595   1609   Ljava/lang/ClassCastException;
        //  1030   1033   1609   1623   Ljava/lang/ClassCastException;
        //  1058   1064   1623   1637   Ljava/lang/ClassCastException;
        //  1075   1078   1637   1651   Ljava/lang/ClassCastException;
        //  1092   1095   1651   1665   Ljava/lang/ClassCastException;
        //  1105   1108   1665   1679   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 648 out of bounds for length 648
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
        //                2: 176
        //                6: 200
        //               11: 226
        //               15: 250
        //               20: 276
        //               24: 300
        //               29: 326
        //               33: 350
        //               38: 376
        //               42: 400
        //               47: 426
        //               51: 450
        //               56: 476
        //               60: 500
        //               65: 526
        //               69: 550
        //               74: 576
        //               78: 600
        //               83: 626
        //               87: 650
        //          default: 677
        //        }
        //   176: aload_2        
        //   177: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   180: checkcast       Ljava/lang/Number;
        //   183: invokevirtual   java/lang/Number.intValue:()I
        //   186: aload_3        
        //   187: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   190: checkcast       Ljava/lang/Number;
        //   193: invokevirtual   java/lang/Number.intValue:()I
        //   196: invokestatic    kawa/lib/uniform.makeS8vector:(II)Lgnu/lists/S8Vector;
        //   199: areturn        
        //   200: aload_2        
        //   201: ldc             Lgnu/lists/S8Vector;.class
        //   203: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   206: checkcast       Lgnu/lists/S8Vector;
        //   209: aload_3        
        //   210: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   213: checkcast       Ljava/lang/Number;
        //   216: invokevirtual   java/lang/Number.intValue:()I
        //   219: invokestatic    kawa/lib/uniform.s8vectorRef:(Lgnu/lists/S8Vector;I)B
        //   222: invokestatic    java/lang/Byte.valueOf:(B)Ljava/lang/Byte;
        //   225: areturn        
        //   226: aload_2        
        //   227: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   230: checkcast       Ljava/lang/Number;
        //   233: invokevirtual   java/lang/Number.intValue:()I
        //   236: aload_3        
        //   237: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   240: checkcast       Ljava/lang/Number;
        //   243: invokevirtual   java/lang/Number.intValue:()I
        //   246: invokestatic    kawa/lib/uniform.makeU8vector:(II)Lgnu/lists/U8Vector;
        //   249: areturn        
        //   250: aload_2        
        //   251: ldc             Lgnu/lists/U8Vector;.class
        //   253: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   256: checkcast       Lgnu/lists/U8Vector;
        //   259: aload_3        
        //   260: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   263: checkcast       Ljava/lang/Number;
        //   266: invokevirtual   java/lang/Number.intValue:()I
        //   269: invokestatic    kawa/lib/uniform.u8vectorRef:(Lgnu/lists/U8Vector;I)I
        //   272: invokestatic    gnu/math/UByte.valueOf:(B)Lgnu/math/UByte;
        //   275: areturn        
        //   276: aload_2        
        //   277: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   280: checkcast       Ljava/lang/Number;
        //   283: invokevirtual   java/lang/Number.intValue:()I
        //   286: aload_3        
        //   287: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   290: checkcast       Ljava/lang/Number;
        //   293: invokevirtual   java/lang/Number.intValue:()I
        //   296: invokestatic    kawa/lib/uniform.makeS16vector:(II)Lgnu/lists/S16Vector;
        //   299: areturn        
        //   300: aload_2        
        //   301: ldc             Lgnu/lists/S16Vector;.class
        //   303: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   306: checkcast       Lgnu/lists/S16Vector;
        //   309: aload_3        
        //   310: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   313: checkcast       Ljava/lang/Number;
        //   316: invokevirtual   java/lang/Number.intValue:()I
        //   319: invokestatic    kawa/lib/uniform.s16vectorRef:(Lgnu/lists/S16Vector;I)S
        //   322: invokestatic    java/lang/Short.valueOf:(S)Ljava/lang/Short;
        //   325: areturn        
        //   326: aload_2        
        //   327: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   330: checkcast       Ljava/lang/Number;
        //   333: invokevirtual   java/lang/Number.intValue:()I
        //   336: aload_3        
        //   337: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   340: checkcast       Ljava/lang/Number;
        //   343: invokevirtual   java/lang/Number.intValue:()I
        //   346: invokestatic    kawa/lib/uniform.makeU16vector:(II)Lgnu/lists/U16Vector;
        //   349: areturn        
        //   350: aload_2        
        //   351: ldc             Lgnu/lists/U16Vector;.class
        //   353: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   356: checkcast       Lgnu/lists/U16Vector;
        //   359: aload_3        
        //   360: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   363: checkcast       Ljava/lang/Number;
        //   366: invokevirtual   java/lang/Number.intValue:()I
        //   369: invokestatic    kawa/lib/uniform.u16vectorRef:(Lgnu/lists/U16Vector;I)I
        //   372: invokestatic    gnu/math/UShort.valueOf:(S)Lgnu/math/UShort;
        //   375: areturn        
        //   376: aload_2        
        //   377: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   380: checkcast       Ljava/lang/Number;
        //   383: invokevirtual   java/lang/Number.intValue:()I
        //   386: aload_3        
        //   387: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   390: checkcast       Ljava/lang/Number;
        //   393: invokevirtual   java/lang/Number.intValue:()I
        //   396: invokestatic    kawa/lib/uniform.makeS32vector:(II)Lgnu/lists/S32Vector;
        //   399: areturn        
        //   400: aload_2        
        //   401: ldc             Lgnu/lists/S32Vector;.class
        //   403: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   406: checkcast       Lgnu/lists/S32Vector;
        //   409: aload_3        
        //   410: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   413: checkcast       Ljava/lang/Number;
        //   416: invokevirtual   java/lang/Number.intValue:()I
        //   419: invokestatic    kawa/lib/uniform.s32vectorRef:(Lgnu/lists/S32Vector;I)I
        //   422: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   425: areturn        
        //   426: aload_2        
        //   427: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   430: checkcast       Ljava/lang/Number;
        //   433: invokevirtual   java/lang/Number.intValue:()I
        //   436: aload_3        
        //   437: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   440: checkcast       Ljava/lang/Number;
        //   443: invokevirtual   java/lang/Number.longValue:()J
        //   446: invokestatic    kawa/lib/uniform.makeU32vector:(IJ)Lgnu/lists/U32Vector;
        //   449: areturn        
        //   450: aload_2        
        //   451: ldc             Lgnu/lists/U32Vector;.class
        //   453: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   456: checkcast       Lgnu/lists/U32Vector;
        //   459: aload_3        
        //   460: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   463: checkcast       Ljava/lang/Number;
        //   466: invokevirtual   java/lang/Number.intValue:()I
        //   469: invokestatic    kawa/lib/uniform.u32vectorRef:(Lgnu/lists/U32Vector;I)I
        //   472: invokestatic    gnu/math/UInt.valueOf:(I)Lgnu/math/UInt;
        //   475: areturn        
        //   476: aload_2        
        //   477: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   480: checkcast       Ljava/lang/Number;
        //   483: invokevirtual   java/lang/Number.intValue:()I
        //   486: aload_3        
        //   487: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   490: checkcast       Ljava/lang/Number;
        //   493: invokevirtual   java/lang/Number.longValue:()J
        //   496: invokestatic    kawa/lib/uniform.makeS64vector:(IJ)Lgnu/lists/S64Vector;
        //   499: areturn        
        //   500: aload_2        
        //   501: ldc             Lgnu/lists/S64Vector;.class
        //   503: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   506: checkcast       Lgnu/lists/S64Vector;
        //   509: aload_3        
        //   510: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   513: checkcast       Ljava/lang/Number;
        //   516: invokevirtual   java/lang/Number.intValue:()I
        //   519: invokestatic    kawa/lib/uniform.s64vectorRef:(Lgnu/lists/S64Vector;I)J
        //   522: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   525: areturn        
        //   526: aload_2        
        //   527: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   530: checkcast       Ljava/lang/Number;
        //   533: invokevirtual   java/lang/Number.intValue:()I
        //   536: aload_3        
        //   537: ldc_w           Lgnu/math/IntNum;.class
        //   540: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   543: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   546: invokestatic    kawa/lib/uniform.makeU64vector:(ILgnu/math/IntNum;)Lgnu/lists/U64Vector;
        //   549: areturn        
        //   550: aload_2        
        //   551: ldc             Lgnu/lists/U64Vector;.class
        //   553: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   556: checkcast       Lgnu/lists/U64Vector;
        //   559: aload_3        
        //   560: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   563: checkcast       Ljava/lang/Number;
        //   566: invokevirtual   java/lang/Number.intValue:()I
        //   569: invokestatic    kawa/lib/uniform.u64vectorRef:(Lgnu/lists/U64Vector;I)J
        //   572: invokestatic    gnu/math/ULong.valueOf:(J)Lgnu/math/ULong;
        //   575: areturn        
        //   576: aload_2        
        //   577: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   580: checkcast       Ljava/lang/Number;
        //   583: invokevirtual   java/lang/Number.intValue:()I
        //   586: aload_3        
        //   587: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   590: checkcast       Ljava/lang/Number;
        //   593: invokevirtual   java/lang/Number.floatValue:()F
        //   596: invokestatic    kawa/lib/uniform.makeF32vector:(IF)Lgnu/lists/F32Vector;
        //   599: areturn        
        //   600: aload_2        
        //   601: ldc             Lgnu/lists/F32Vector;.class
        //   603: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   606: checkcast       Lgnu/lists/F32Vector;
        //   609: aload_3        
        //   610: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   613: checkcast       Ljava/lang/Number;
        //   616: invokevirtual   java/lang/Number.intValue:()I
        //   619: invokestatic    kawa/lib/uniform.f32vectorRef:(Lgnu/lists/F32Vector;I)F
        //   622: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
        //   625: areturn        
        //   626: aload_2        
        //   627: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   630: checkcast       Ljava/lang/Number;
        //   633: invokevirtual   java/lang/Number.intValue:()I
        //   636: aload_3        
        //   637: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   640: checkcast       Ljava/lang/Number;
        //   643: invokevirtual   java/lang/Number.doubleValue:()D
        //   646: invokestatic    kawa/lib/uniform.makeF64vector:(ID)Lgnu/lists/F64Vector;
        //   649: areturn        
        //   650: aload_2        
        //   651: ldc_w           Lgnu/lists/F64Vector;.class
        //   654: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   657: checkcast       Lgnu/lists/F64Vector;
        //   660: aload_3        
        //   661: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   664: checkcast       Ljava/lang/Number;
        //   667: invokevirtual   java/lang/Number.intValue:()I
        //   670: invokestatic    kawa/lib/uniform.f64vectorRef:(Lgnu/lists/F64Vector;I)D
        //   673: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   676: areturn        
        //   677: aload_0        
        //   678: aload_1        
        //   679: aload_2        
        //   680: aload_3        
        //   681: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   684: areturn        
        //   685: new             Lgnu/mapping/WrongType;
        //   688: dup_x1         
        //   689: swap           
        //   690: ldc_w           "make-s8vector"
        //   693: iconst_1       
        //   694: aload_2        
        //   695: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   698: athrow         
        //   699: new             Lgnu/mapping/WrongType;
        //   702: dup_x1         
        //   703: swap           
        //   704: ldc_w           "make-s8vector"
        //   707: iconst_2       
        //   708: aload_3        
        //   709: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   712: athrow         
        //   713: new             Lgnu/mapping/WrongType;
        //   716: dup_x1         
        //   717: swap           
        //   718: ldc_w           "s8vector-ref"
        //   721: iconst_1       
        //   722: aload_2        
        //   723: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   726: athrow         
        //   727: new             Lgnu/mapping/WrongType;
        //   730: dup_x1         
        //   731: swap           
        //   732: ldc_w           "s8vector-ref"
        //   735: iconst_2       
        //   736: aload_3        
        //   737: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   740: athrow         
        //   741: new             Lgnu/mapping/WrongType;
        //   744: dup_x1         
        //   745: swap           
        //   746: ldc_w           "make-u8vector"
        //   749: iconst_1       
        //   750: aload_2        
        //   751: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   754: athrow         
        //   755: new             Lgnu/mapping/WrongType;
        //   758: dup_x1         
        //   759: swap           
        //   760: ldc_w           "make-u8vector"
        //   763: iconst_2       
        //   764: aload_3        
        //   765: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   768: athrow         
        //   769: new             Lgnu/mapping/WrongType;
        //   772: dup_x1         
        //   773: swap           
        //   774: ldc_w           "u8vector-ref"
        //   777: iconst_1       
        //   778: aload_2        
        //   779: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   782: athrow         
        //   783: new             Lgnu/mapping/WrongType;
        //   786: dup_x1         
        //   787: swap           
        //   788: ldc_w           "u8vector-ref"
        //   791: iconst_2       
        //   792: aload_3        
        //   793: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   796: athrow         
        //   797: new             Lgnu/mapping/WrongType;
        //   800: dup_x1         
        //   801: swap           
        //   802: ldc_w           "make-s16vector"
        //   805: iconst_1       
        //   806: aload_2        
        //   807: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   810: athrow         
        //   811: new             Lgnu/mapping/WrongType;
        //   814: dup_x1         
        //   815: swap           
        //   816: ldc_w           "make-s16vector"
        //   819: iconst_2       
        //   820: aload_3        
        //   821: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   824: athrow         
        //   825: new             Lgnu/mapping/WrongType;
        //   828: dup_x1         
        //   829: swap           
        //   830: ldc_w           "s16vector-ref"
        //   833: iconst_1       
        //   834: aload_2        
        //   835: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   838: athrow         
        //   839: new             Lgnu/mapping/WrongType;
        //   842: dup_x1         
        //   843: swap           
        //   844: ldc_w           "s16vector-ref"
        //   847: iconst_2       
        //   848: aload_3        
        //   849: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   852: athrow         
        //   853: new             Lgnu/mapping/WrongType;
        //   856: dup_x1         
        //   857: swap           
        //   858: ldc_w           "make-u16vector"
        //   861: iconst_1       
        //   862: aload_2        
        //   863: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   866: athrow         
        //   867: new             Lgnu/mapping/WrongType;
        //   870: dup_x1         
        //   871: swap           
        //   872: ldc_w           "make-u16vector"
        //   875: iconst_2       
        //   876: aload_3        
        //   877: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   880: athrow         
        //   881: new             Lgnu/mapping/WrongType;
        //   884: dup_x1         
        //   885: swap           
        //   886: ldc_w           "u16vector-ref"
        //   889: iconst_1       
        //   890: aload_2        
        //   891: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   894: athrow         
        //   895: new             Lgnu/mapping/WrongType;
        //   898: dup_x1         
        //   899: swap           
        //   900: ldc_w           "u16vector-ref"
        //   903: iconst_2       
        //   904: aload_3        
        //   905: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   908: athrow         
        //   909: new             Lgnu/mapping/WrongType;
        //   912: dup_x1         
        //   913: swap           
        //   914: ldc_w           "make-s32vector"
        //   917: iconst_1       
        //   918: aload_2        
        //   919: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   922: athrow         
        //   923: new             Lgnu/mapping/WrongType;
        //   926: dup_x1         
        //   927: swap           
        //   928: ldc_w           "make-s32vector"
        //   931: iconst_2       
        //   932: aload_3        
        //   933: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   936: athrow         
        //   937: new             Lgnu/mapping/WrongType;
        //   940: dup_x1         
        //   941: swap           
        //   942: ldc_w           "s32vector-ref"
        //   945: iconst_1       
        //   946: aload_2        
        //   947: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   950: athrow         
        //   951: new             Lgnu/mapping/WrongType;
        //   954: dup_x1         
        //   955: swap           
        //   956: ldc_w           "s32vector-ref"
        //   959: iconst_2       
        //   960: aload_3        
        //   961: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   964: athrow         
        //   965: new             Lgnu/mapping/WrongType;
        //   968: dup_x1         
        //   969: swap           
        //   970: ldc_w           "make-u32vector"
        //   973: iconst_1       
        //   974: aload_2        
        //   975: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   978: athrow         
        //   979: new             Lgnu/mapping/WrongType;
        //   982: dup_x1         
        //   983: swap           
        //   984: ldc_w           "make-u32vector"
        //   987: iconst_2       
        //   988: aload_3        
        //   989: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   992: athrow         
        //   993: new             Lgnu/mapping/WrongType;
        //   996: dup_x1         
        //   997: swap           
        //   998: ldc_w           "u32vector-ref"
        //  1001: iconst_1       
        //  1002: aload_2        
        //  1003: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1006: athrow         
        //  1007: new             Lgnu/mapping/WrongType;
        //  1010: dup_x1         
        //  1011: swap           
        //  1012: ldc_w           "u32vector-ref"
        //  1015: iconst_2       
        //  1016: aload_3        
        //  1017: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1020: athrow         
        //  1021: new             Lgnu/mapping/WrongType;
        //  1024: dup_x1         
        //  1025: swap           
        //  1026: ldc_w           "make-s64vector"
        //  1029: iconst_1       
        //  1030: aload_2        
        //  1031: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1034: athrow         
        //  1035: new             Lgnu/mapping/WrongType;
        //  1038: dup_x1         
        //  1039: swap           
        //  1040: ldc_w           "make-s64vector"
        //  1043: iconst_2       
        //  1044: aload_3        
        //  1045: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1048: athrow         
        //  1049: new             Lgnu/mapping/WrongType;
        //  1052: dup_x1         
        //  1053: swap           
        //  1054: ldc_w           "s64vector-ref"
        //  1057: iconst_1       
        //  1058: aload_2        
        //  1059: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1062: athrow         
        //  1063: new             Lgnu/mapping/WrongType;
        //  1066: dup_x1         
        //  1067: swap           
        //  1068: ldc_w           "s64vector-ref"
        //  1071: iconst_2       
        //  1072: aload_3        
        //  1073: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1076: athrow         
        //  1077: new             Lgnu/mapping/WrongType;
        //  1080: dup_x1         
        //  1081: swap           
        //  1082: ldc_w           "make-u64vector"
        //  1085: iconst_1       
        //  1086: aload_2        
        //  1087: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1090: athrow         
        //  1091: new             Lgnu/mapping/WrongType;
        //  1094: dup_x1         
        //  1095: swap           
        //  1096: ldc_w           "make-u64vector"
        //  1099: iconst_2       
        //  1100: aload_3        
        //  1101: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1104: athrow         
        //  1105: new             Lgnu/mapping/WrongType;
        //  1108: dup_x1         
        //  1109: swap           
        //  1110: ldc_w           "u64vector-ref"
        //  1113: iconst_1       
        //  1114: aload_2        
        //  1115: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1118: athrow         
        //  1119: new             Lgnu/mapping/WrongType;
        //  1122: dup_x1         
        //  1123: swap           
        //  1124: ldc_w           "u64vector-ref"
        //  1127: iconst_2       
        //  1128: aload_3        
        //  1129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1132: athrow         
        //  1133: new             Lgnu/mapping/WrongType;
        //  1136: dup_x1         
        //  1137: swap           
        //  1138: ldc_w           "make-f32vector"
        //  1141: iconst_1       
        //  1142: aload_2        
        //  1143: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1146: athrow         
        //  1147: new             Lgnu/mapping/WrongType;
        //  1150: dup_x1         
        //  1151: swap           
        //  1152: ldc_w           "make-f32vector"
        //  1155: iconst_2       
        //  1156: aload_3        
        //  1157: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1160: athrow         
        //  1161: new             Lgnu/mapping/WrongType;
        //  1164: dup_x1         
        //  1165: swap           
        //  1166: ldc_w           "f32vector-ref"
        //  1169: iconst_1       
        //  1170: aload_2        
        //  1171: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1174: athrow         
        //  1175: new             Lgnu/mapping/WrongType;
        //  1178: dup_x1         
        //  1179: swap           
        //  1180: ldc_w           "f32vector-ref"
        //  1183: iconst_2       
        //  1184: aload_3        
        //  1185: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1188: athrow         
        //  1189: new             Lgnu/mapping/WrongType;
        //  1192: dup_x1         
        //  1193: swap           
        //  1194: ldc_w           "make-f64vector"
        //  1197: iconst_1       
        //  1198: aload_2        
        //  1199: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1202: athrow         
        //  1203: new             Lgnu/mapping/WrongType;
        //  1206: dup_x1         
        //  1207: swap           
        //  1208: ldc_w           "make-f64vector"
        //  1211: iconst_2       
        //  1212: aload_3        
        //  1213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1216: athrow         
        //  1217: new             Lgnu/mapping/WrongType;
        //  1220: dup_x1         
        //  1221: swap           
        //  1222: ldc_w           "f64vector-ref"
        //  1225: iconst_1       
        //  1226: aload_2        
        //  1227: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1230: athrow         
        //  1231: new             Lgnu/mapping/WrongType;
        //  1234: dup_x1         
        //  1235: swap           
        //  1236: ldc_w           "f64vector-ref"
        //  1239: iconst_2       
        //  1240: aload_3        
        //  1241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1244: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  180    186    685    699    Ljava/lang/ClassCastException;
        //  190    196    699    713    Ljava/lang/ClassCastException;
        //  206    209    713    727    Ljava/lang/ClassCastException;
        //  213    219    727    741    Ljava/lang/ClassCastException;
        //  230    236    741    755    Ljava/lang/ClassCastException;
        //  240    246    755    769    Ljava/lang/ClassCastException;
        //  256    259    769    783    Ljava/lang/ClassCastException;
        //  263    269    783    797    Ljava/lang/ClassCastException;
        //  280    286    797    811    Ljava/lang/ClassCastException;
        //  290    296    811    825    Ljava/lang/ClassCastException;
        //  306    309    825    839    Ljava/lang/ClassCastException;
        //  313    319    839    853    Ljava/lang/ClassCastException;
        //  330    336    853    867    Ljava/lang/ClassCastException;
        //  340    346    867    881    Ljava/lang/ClassCastException;
        //  356    359    881    895    Ljava/lang/ClassCastException;
        //  363    369    895    909    Ljava/lang/ClassCastException;
        //  380    386    909    923    Ljava/lang/ClassCastException;
        //  390    396    923    937    Ljava/lang/ClassCastException;
        //  406    409    937    951    Ljava/lang/ClassCastException;
        //  413    419    951    965    Ljava/lang/ClassCastException;
        //  430    436    965    979    Ljava/lang/ClassCastException;
        //  440    446    979    993    Ljava/lang/ClassCastException;
        //  456    459    993    1007   Ljava/lang/ClassCastException;
        //  463    469    1007   1021   Ljava/lang/ClassCastException;
        //  480    486    1021   1035   Ljava/lang/ClassCastException;
        //  490    496    1035   1049   Ljava/lang/ClassCastException;
        //  506    509    1049   1063   Ljava/lang/ClassCastException;
        //  513    519    1063   1077   Ljava/lang/ClassCastException;
        //  530    536    1077   1091   Ljava/lang/ClassCastException;
        //  543    546    1091   1105   Ljava/lang/ClassCastException;
        //  556    559    1105   1119   Ljava/lang/ClassCastException;
        //  563    569    1119   1133   Ljava/lang/ClassCastException;
        //  580    586    1133   1147   Ljava/lang/ClassCastException;
        //  590    596    1147   1161   Ljava/lang/ClassCastException;
        //  606    609    1161   1175   Ljava/lang/ClassCastException;
        //  613    619    1175   1189   Ljava/lang/ClassCastException;
        //  630    636    1189   1203   Ljava/lang/ClassCastException;
        //  640    646    1203   1217   Ljava/lang/ClassCastException;
        //  657    660    1217   1231   Ljava/lang/ClassCastException;
        //  664    670    1231   1245   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 539 out of bounds for length 539
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
        //                7: 96
        //               16: 133
        //               25: 170
        //               34: 207
        //               43: 244
        //               52: 281
        //               61: 318
        //               70: 355
        //               79: 392
        //               88: 429
        //          default: 467
        //        }
        //    96: aload_2        
        //    97: ldc             Lgnu/lists/S8Vector;.class
        //    99: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   102: checkcast       Lgnu/lists/S8Vector;
        //   105: aload_3        
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   109: checkcast       Ljava/lang/Number;
        //   112: invokevirtual   java/lang/Number.intValue:()I
        //   115: aload           4
        //   117: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   120: checkcast       Ljava/lang/Number;
        //   123: invokevirtual   java/lang/Number.intValue:()I
        //   126: invokestatic    kawa/lib/uniform.s8vectorSet$Ex:(Lgnu/lists/S8Vector;IB)V
        //   129: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   132: areturn        
        //   133: aload_2        
        //   134: ldc             Lgnu/lists/U8Vector;.class
        //   136: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   139: checkcast       Lgnu/lists/U8Vector;
        //   142: aload_3        
        //   143: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   146: checkcast       Ljava/lang/Number;
        //   149: invokevirtual   java/lang/Number.intValue:()I
        //   152: aload           4
        //   154: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   157: checkcast       Ljava/lang/Number;
        //   160: invokevirtual   java/lang/Number.intValue:()I
        //   163: invokestatic    kawa/lib/uniform.u8vectorSet$Ex:(Lgnu/lists/U8Vector;II)V
        //   166: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   169: areturn        
        //   170: aload_2        
        //   171: ldc             Lgnu/lists/S16Vector;.class
        //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   176: checkcast       Lgnu/lists/S16Vector;
        //   179: aload_3        
        //   180: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   183: checkcast       Ljava/lang/Number;
        //   186: invokevirtual   java/lang/Number.intValue:()I
        //   189: aload           4
        //   191: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   194: checkcast       Ljava/lang/Number;
        //   197: invokevirtual   java/lang/Number.intValue:()I
        //   200: invokestatic    kawa/lib/uniform.s16vectorSet$Ex:(Lgnu/lists/S16Vector;IS)V
        //   203: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   206: areturn        
        //   207: aload_2        
        //   208: ldc             Lgnu/lists/U16Vector;.class
        //   210: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   213: checkcast       Lgnu/lists/U16Vector;
        //   216: aload_3        
        //   217: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   220: checkcast       Ljava/lang/Number;
        //   223: invokevirtual   java/lang/Number.intValue:()I
        //   226: aload           4
        //   228: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   231: checkcast       Ljava/lang/Number;
        //   234: invokevirtual   java/lang/Number.intValue:()I
        //   237: invokestatic    kawa/lib/uniform.u16vectorSet$Ex:(Lgnu/lists/U16Vector;II)V
        //   240: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   243: areturn        
        //   244: aload_2        
        //   245: ldc             Lgnu/lists/S32Vector;.class
        //   247: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   250: checkcast       Lgnu/lists/S32Vector;
        //   253: aload_3        
        //   254: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   257: checkcast       Ljava/lang/Number;
        //   260: invokevirtual   java/lang/Number.intValue:()I
        //   263: aload           4
        //   265: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   268: checkcast       Ljava/lang/Number;
        //   271: invokevirtual   java/lang/Number.intValue:()I
        //   274: invokestatic    kawa/lib/uniform.s32vectorSet$Ex:(Lgnu/lists/S32Vector;II)V
        //   277: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   280: areturn        
        //   281: aload_2        
        //   282: ldc             Lgnu/lists/U32Vector;.class
        //   284: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   287: checkcast       Lgnu/lists/U32Vector;
        //   290: aload_3        
        //   291: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   294: checkcast       Ljava/lang/Number;
        //   297: invokevirtual   java/lang/Number.intValue:()I
        //   300: aload           4
        //   302: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   305: checkcast       Ljava/lang/Number;
        //   308: invokevirtual   java/lang/Number.intValue:()I
        //   311: invokestatic    kawa/lib/uniform.u32vectorSet$Ex:(Lgnu/lists/U32Vector;II)V
        //   314: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   317: areturn        
        //   318: aload_2        
        //   319: ldc             Lgnu/lists/S64Vector;.class
        //   321: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   324: checkcast       Lgnu/lists/S64Vector;
        //   327: aload_3        
        //   328: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   331: checkcast       Ljava/lang/Number;
        //   334: invokevirtual   java/lang/Number.intValue:()I
        //   337: aload           4
        //   339: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   342: checkcast       Ljava/lang/Number;
        //   345: invokevirtual   java/lang/Number.longValue:()J
        //   348: invokestatic    kawa/lib/uniform.s64vectorSet$Ex:(Lgnu/lists/S64Vector;IJ)V
        //   351: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   354: areturn        
        //   355: aload_2        
        //   356: ldc             Lgnu/lists/U64Vector;.class
        //   358: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   361: checkcast       Lgnu/lists/U64Vector;
        //   364: aload_3        
        //   365: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   368: checkcast       Ljava/lang/Number;
        //   371: invokevirtual   java/lang/Number.intValue:()I
        //   374: aload           4
        //   376: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   379: checkcast       Ljava/lang/Number;
        //   382: invokevirtual   java/lang/Number.longValue:()J
        //   385: invokestatic    kawa/lib/uniform.u64vectorSet$Ex:(Lgnu/lists/U64Vector;IJ)V
        //   388: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   391: areturn        
        //   392: aload_2        
        //   393: ldc             Lgnu/lists/F32Vector;.class
        //   395: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   398: checkcast       Lgnu/lists/F32Vector;
        //   401: aload_3        
        //   402: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   405: checkcast       Ljava/lang/Number;
        //   408: invokevirtual   java/lang/Number.intValue:()I
        //   411: aload           4
        //   413: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   416: checkcast       Ljava/lang/Number;
        //   419: invokevirtual   java/lang/Number.floatValue:()F
        //   422: invokestatic    kawa/lib/uniform.f32vectorSet$Ex:(Lgnu/lists/F32Vector;IF)V
        //   425: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   428: areturn        
        //   429: aload_2        
        //   430: ldc_w           Lgnu/lists/F64Vector;.class
        //   433: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   436: checkcast       Lgnu/lists/F64Vector;
        //   439: aload_3        
        //   440: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   443: checkcast       Ljava/lang/Number;
        //   446: invokevirtual   java/lang/Number.intValue:()I
        //   449: aload           4
        //   451: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   454: checkcast       Ljava/lang/Number;
        //   457: invokevirtual   java/lang/Number.doubleValue:()D
        //   460: invokestatic    kawa/lib/uniform.f64vectorSet$Ex:(Lgnu/lists/F64Vector;ID)V
        //   463: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   466: areturn        
        //   467: aload_0        
        //   468: aload_1        
        //   469: aload_2        
        //   470: aload_3        
        //   471: aload           4
        //   473: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   476: areturn        
        //   477: new             Lgnu/mapping/WrongType;
        //   480: dup_x1         
        //   481: swap           
        //   482: ldc_w           "s8vector-set!"
        //   485: iconst_1       
        //   486: aload_2        
        //   487: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   490: athrow         
        //   491: new             Lgnu/mapping/WrongType;
        //   494: dup_x1         
        //   495: swap           
        //   496: ldc_w           "s8vector-set!"
        //   499: iconst_2       
        //   500: aload_3        
        //   501: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   504: athrow         
        //   505: new             Lgnu/mapping/WrongType;
        //   508: dup_x1         
        //   509: swap           
        //   510: ldc_w           "s8vector-set!"
        //   513: iconst_3       
        //   514: aload           4
        //   516: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   519: athrow         
        //   520: new             Lgnu/mapping/WrongType;
        //   523: dup_x1         
        //   524: swap           
        //   525: ldc_w           "u8vector-set!"
        //   528: iconst_1       
        //   529: aload_2        
        //   530: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   533: athrow         
        //   534: new             Lgnu/mapping/WrongType;
        //   537: dup_x1         
        //   538: swap           
        //   539: ldc_w           "u8vector-set!"
        //   542: iconst_2       
        //   543: aload_3        
        //   544: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   547: athrow         
        //   548: new             Lgnu/mapping/WrongType;
        //   551: dup_x1         
        //   552: swap           
        //   553: ldc_w           "u8vector-set!"
        //   556: iconst_3       
        //   557: aload           4
        //   559: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   562: athrow         
        //   563: new             Lgnu/mapping/WrongType;
        //   566: dup_x1         
        //   567: swap           
        //   568: ldc_w           "s16vector-set!"
        //   571: iconst_1       
        //   572: aload_2        
        //   573: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   576: athrow         
        //   577: new             Lgnu/mapping/WrongType;
        //   580: dup_x1         
        //   581: swap           
        //   582: ldc_w           "s16vector-set!"
        //   585: iconst_2       
        //   586: aload_3        
        //   587: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   590: athrow         
        //   591: new             Lgnu/mapping/WrongType;
        //   594: dup_x1         
        //   595: swap           
        //   596: ldc_w           "s16vector-set!"
        //   599: iconst_3       
        //   600: aload           4
        //   602: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   605: athrow         
        //   606: new             Lgnu/mapping/WrongType;
        //   609: dup_x1         
        //   610: swap           
        //   611: ldc_w           "u16vector-set!"
        //   614: iconst_1       
        //   615: aload_2        
        //   616: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   619: athrow         
        //   620: new             Lgnu/mapping/WrongType;
        //   623: dup_x1         
        //   624: swap           
        //   625: ldc_w           "u16vector-set!"
        //   628: iconst_2       
        //   629: aload_3        
        //   630: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   633: athrow         
        //   634: new             Lgnu/mapping/WrongType;
        //   637: dup_x1         
        //   638: swap           
        //   639: ldc_w           "u16vector-set!"
        //   642: iconst_3       
        //   643: aload           4
        //   645: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   648: athrow         
        //   649: new             Lgnu/mapping/WrongType;
        //   652: dup_x1         
        //   653: swap           
        //   654: ldc_w           "s32vector-set!"
        //   657: iconst_1       
        //   658: aload_2        
        //   659: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   662: athrow         
        //   663: new             Lgnu/mapping/WrongType;
        //   666: dup_x1         
        //   667: swap           
        //   668: ldc_w           "s32vector-set!"
        //   671: iconst_2       
        //   672: aload_3        
        //   673: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   676: athrow         
        //   677: new             Lgnu/mapping/WrongType;
        //   680: dup_x1         
        //   681: swap           
        //   682: ldc_w           "s32vector-set!"
        //   685: iconst_3       
        //   686: aload           4
        //   688: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   691: athrow         
        //   692: new             Lgnu/mapping/WrongType;
        //   695: dup_x1         
        //   696: swap           
        //   697: ldc_w           "u32vector-set!"
        //   700: iconst_1       
        //   701: aload_2        
        //   702: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   705: athrow         
        //   706: new             Lgnu/mapping/WrongType;
        //   709: dup_x1         
        //   710: swap           
        //   711: ldc_w           "u32vector-set!"
        //   714: iconst_2       
        //   715: aload_3        
        //   716: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   719: athrow         
        //   720: new             Lgnu/mapping/WrongType;
        //   723: dup_x1         
        //   724: swap           
        //   725: ldc_w           "u32vector-set!"
        //   728: iconst_3       
        //   729: aload           4
        //   731: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   734: athrow         
        //   735: new             Lgnu/mapping/WrongType;
        //   738: dup_x1         
        //   739: swap           
        //   740: ldc_w           "s64vector-set!"
        //   743: iconst_1       
        //   744: aload_2        
        //   745: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   748: athrow         
        //   749: new             Lgnu/mapping/WrongType;
        //   752: dup_x1         
        //   753: swap           
        //   754: ldc_w           "s64vector-set!"
        //   757: iconst_2       
        //   758: aload_3        
        //   759: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   762: athrow         
        //   763: new             Lgnu/mapping/WrongType;
        //   766: dup_x1         
        //   767: swap           
        //   768: ldc_w           "s64vector-set!"
        //   771: iconst_3       
        //   772: aload           4
        //   774: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   777: athrow         
        //   778: new             Lgnu/mapping/WrongType;
        //   781: dup_x1         
        //   782: swap           
        //   783: ldc_w           "u64vector-set!"
        //   786: iconst_1       
        //   787: aload_2        
        //   788: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   791: athrow         
        //   792: new             Lgnu/mapping/WrongType;
        //   795: dup_x1         
        //   796: swap           
        //   797: ldc_w           "u64vector-set!"
        //   800: iconst_2       
        //   801: aload_3        
        //   802: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   805: athrow         
        //   806: new             Lgnu/mapping/WrongType;
        //   809: dup_x1         
        //   810: swap           
        //   811: ldc_w           "u64vector-set!"
        //   814: iconst_3       
        //   815: aload           4
        //   817: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   820: athrow         
        //   821: new             Lgnu/mapping/WrongType;
        //   824: dup_x1         
        //   825: swap           
        //   826: ldc_w           "f32vector-set!"
        //   829: iconst_1       
        //   830: aload_2        
        //   831: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   834: athrow         
        //   835: new             Lgnu/mapping/WrongType;
        //   838: dup_x1         
        //   839: swap           
        //   840: ldc_w           "f32vector-set!"
        //   843: iconst_2       
        //   844: aload_3        
        //   845: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   848: athrow         
        //   849: new             Lgnu/mapping/WrongType;
        //   852: dup_x1         
        //   853: swap           
        //   854: ldc_w           "f32vector-set!"
        //   857: iconst_3       
        //   858: aload           4
        //   860: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   863: athrow         
        //   864: new             Lgnu/mapping/WrongType;
        //   867: dup_x1         
        //   868: swap           
        //   869: ldc_w           "f64vector-set!"
        //   872: iconst_1       
        //   873: aload_2        
        //   874: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   877: athrow         
        //   878: new             Lgnu/mapping/WrongType;
        //   881: dup_x1         
        //   882: swap           
        //   883: ldc_w           "f64vector-set!"
        //   886: iconst_2       
        //   887: aload_3        
        //   888: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   891: athrow         
        //   892: new             Lgnu/mapping/WrongType;
        //   895: dup_x1         
        //   896: swap           
        //   897: ldc_w           "f64vector-set!"
        //   900: iconst_3       
        //   901: aload           4
        //   903: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   906: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  102    105    477    491    Ljava/lang/ClassCastException;
        //  109    115    491    505    Ljava/lang/ClassCastException;
        //  120    126    505    520    Ljava/lang/ClassCastException;
        //  139    142    520    534    Ljava/lang/ClassCastException;
        //  146    152    534    548    Ljava/lang/ClassCastException;
        //  157    163    548    563    Ljava/lang/ClassCastException;
        //  176    179    563    577    Ljava/lang/ClassCastException;
        //  183    189    577    591    Ljava/lang/ClassCastException;
        //  194    200    591    606    Ljava/lang/ClassCastException;
        //  213    216    606    620    Ljava/lang/ClassCastException;
        //  220    226    620    634    Ljava/lang/ClassCastException;
        //  231    237    634    649    Ljava/lang/ClassCastException;
        //  250    253    649    663    Ljava/lang/ClassCastException;
        //  257    263    663    677    Ljava/lang/ClassCastException;
        //  268    274    677    692    Ljava/lang/ClassCastException;
        //  287    290    692    706    Ljava/lang/ClassCastException;
        //  294    300    706    720    Ljava/lang/ClassCastException;
        //  305    311    720    735    Ljava/lang/ClassCastException;
        //  324    327    735    749    Ljava/lang/ClassCastException;
        //  331    337    749    763    Ljava/lang/ClassCastException;
        //  342    348    763    778    Ljava/lang/ClassCastException;
        //  361    364    778    792    Ljava/lang/ClassCastException;
        //  368    374    792    806    Ljava/lang/ClassCastException;
        //  379    385    806    821    Ljava/lang/ClassCastException;
        //  398    401    821    835    Ljava/lang/ClassCastException;
        //  405    411    835    849    Ljava/lang/ClassCastException;
        //  416    422    849    864    Ljava/lang/ClassCastException;
        //  436    439    864    878    Ljava/lang/ClassCastException;
        //  443    449    878    892    Ljava/lang/ClassCastException;
        //  454    460    892    907    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 400 out of bounds for length 400
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
    public Object applyN(final ModuleMethod method, final Object[] args) {
        switch (method.selector) {
            case 4: {
                return s8vector$V(args);
            }
            case 13: {
                return u8vector$V(args);
            }
            case 22: {
                return s16vector$V(args);
            }
            case 31: {
                return u16vector$V(args);
            }
            case 40: {
                return s32vector$V(args);
            }
            case 49: {
                return u32vector$V(args);
            }
            case 58: {
                return s64vector$V(args);
            }
            case 67: {
                return u64vector$V(args);
            }
            case 76: {
                return f32vector$V(args);
            }
            case 85: {
                return f64vector$V(args);
            }
            default: {
                return super.applyN(method, args);
            }
        }
    }
}
