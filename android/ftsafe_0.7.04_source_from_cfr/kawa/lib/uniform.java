/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.U16Vector;
import gnu.lists.U32Vector;
import gnu.lists.U64Vector;
import gnu.lists.U8Vector;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.SourceMethodType;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class uniform
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean isS8vector(Object x) {
        return x instanceof S8Vector;
    }

    public static S8Vector makeS8vector(int n) {
        return uniform.makeS8vector(n, 0);
    }

    public static S8Vector makeS8vector(int n, int init) {
        return new S8Vector(n, (byte)init);
    }

    public static S8Vector s8vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$S8vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static S8Vector list$To$S8vector(LList l) {
        n = l.size();
        arr = new byte[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrby = arr;
                return new S8Vector(arrby);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).intValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int s8vectorLength(S8Vector v) {
        return v.size();
    }

    public static byte s8vectorRef(S8Vector v, int i) {
        return v.getByte(i);
    }

    public static void s8vectorSet$Ex(S8Vector v, int i, byte x) {
        v.setByte(i, x);
    }

    public static LList s8vector$To$List(S8Vector v) {
        return LList.makeList(v);
    }

    public static boolean isU8vector(Object x) {
        return x instanceof U8Vector;
    }

    public static U8Vector makeU8vector(int n) {
        return uniform.makeU8vector(n, 0);
    }

    public static U8Vector makeU8vector(int n, int init) {
        return new U8Vector(n, (byte)init);
    }

    public static U8Vector u8vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$U8vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static U8Vector list$To$U8vector(LList l) {
        n = l.size();
        arr = new byte[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrby = arr;
                return new U8Vector(arrby);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).intValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int u8vectorLength(U8Vector v) {
        return v.size();
    }

    @SourceMethodType(value={"ubyte"})
    public static int u8vectorRef(U8Vector v, int i) {
        return v.getByte(i);
    }

    @SourceMethodType(value={"", "", "", "ubyte"})
    public static void u8vectorSet$Ex(U8Vector v, int i, int x) {
        v.setByte(i, (byte)x);
    }

    public static LList u8vector$To$List(U8Vector v) {
        return LList.makeList(v);
    }

    public static boolean isS16vector(Object x) {
        return x instanceof S16Vector;
    }

    public static S16Vector makeS16vector(int n) {
        return uniform.makeS16vector(n, 0);
    }

    public static S16Vector makeS16vector(int n, int init) {
        return new S16Vector(n, (short)init);
    }

    public static S16Vector s16vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$S16vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static S16Vector list$To$S16vector(LList l) {
        n = l.size();
        arr = new short[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrs = arr;
                return new S16Vector(arrs);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).intValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int s16vectorLength(S16Vector v) {
        return v.size();
    }

    public static short s16vectorRef(S16Vector v, int i) {
        return v.getShort(i);
    }

    public static void s16vectorSet$Ex(S16Vector v, int i, short x) {
        v.setShort(i, x);
    }

    public static LList s16vector$To$List(S16Vector v) {
        return LList.makeList(v);
    }

    public static boolean isU16vector(Object x) {
        return x instanceof U16Vector;
    }

    public static U16Vector makeU16vector(int n) {
        return uniform.makeU16vector(n, 0);
    }

    public static U16Vector makeU16vector(int n, int init) {
        return new U16Vector(n, (short)init);
    }

    public static U16Vector u16vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$U16vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static U16Vector list$To$U16vector(LList l) {
        n = l.size();
        arr = new short[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrs = arr;
                return new U16Vector(arrs);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).intValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int u16vectorLength(U16Vector v) {
        return v.size();
    }

    @SourceMethodType(value={"ushort"})
    public static int u16vectorRef(U16Vector v, int i) {
        return v.getShort(i);
    }

    @SourceMethodType(value={"", "", "", "ushort"})
    public static void u16vectorSet$Ex(U16Vector v, int i, int x) {
        v.setShort(i, (short)x);
    }

    public static LList u16vector$To$List(U16Vector v) {
        return LList.makeList(v);
    }

    public static boolean isS32vector(Object x) {
        return x instanceof S32Vector;
    }

    public static S32Vector makeS32vector(int n) {
        return uniform.makeS32vector(n, 0);
    }

    public static S32Vector makeS32vector(int n, int init) {
        return new S32Vector(n, init);
    }

    public static S32Vector s32vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$S32vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static S32Vector list$To$S32vector(LList l) {
        n = l.size();
        arr = new int[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrn = arr;
                return new S32Vector(arrn);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).intValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int s32vectorLength(S32Vector v) {
        return v.size();
    }

    public static int s32vectorRef(S32Vector v, int i) {
        return v.getInt(i);
    }

    public static void s32vectorSet$Ex(S32Vector v, int i, int x) {
        v.setInt(i, x);
    }

    public static LList s32vector$To$List(S32Vector v) {
        return LList.makeList(v);
    }

    public static boolean isU32vector(Object x) {
        return x instanceof U32Vector;
    }

    public static U32Vector makeU32vector(int n) {
        return uniform.makeU32vector(n, 0L);
    }

    public static U32Vector makeU32vector(int n, long init) {
        return new U32Vector(n, (int)init);
    }

    public static U32Vector u32vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$U32vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static U32Vector list$To$U32vector(LList l) {
        n = l.size();
        arr = new int[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrn = arr;
                return new U32Vector(arrn);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).intValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int u32vectorLength(U32Vector v) {
        return v.size();
    }

    @SourceMethodType(value={"uint"})
    public static int u32vectorRef(U32Vector v, int i) {
        return v.getInt(i);
    }

    @SourceMethodType(value={"", "", "", "uint"})
    public static void u32vectorSet$Ex(U32Vector v, int i, int x) {
        v.setInt(i, x);
    }

    public static LList u32vector$To$List(U32Vector v) {
        return LList.makeList(v);
    }

    public static boolean isS64vector(Object x) {
        return x instanceof S64Vector;
    }

    public static S64Vector makeS64vector(int n) {
        return uniform.makeS64vector(n, 0L);
    }

    public static S64Vector makeS64vector(int n, long init) {
        return new S64Vector(n, init);
    }

    public static S64Vector s64vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$S64vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static S64Vector list$To$S64vector(LList l) {
        n = l.size();
        arr = new long[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrl = arr;
                return new S64Vector(arrl);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).longValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int s64vectorLength(S64Vector v) {
        return v.size();
    }

    public static long s64vectorRef(S64Vector v, int i) {
        return v.getLong(i);
    }

    public static void s64vectorSet$Ex(S64Vector v, int i, long x) {
        v.setLong(i, x);
    }

    public static LList s64vector$To$List(S64Vector v) {
        return LList.makeList(v);
    }

    public static boolean isU64vector(Object x) {
        return x instanceof U64Vector;
    }

    public static U64Vector makeU64vector(int n) {
        return uniform.makeU64vector(n, Lit0);
    }

    public static U64Vector makeU64vector(int n, IntNum init) {
        IntNum intNum = init;
        try {
            return new U64Vector(n, ((Number)intNum).longValue());
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.lists.U64Vector.<init>(int,long)", 2, (Object)intNum);
        }
    }

    public static U64Vector u64vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$U64vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static U64Vector list$To$U64vector(LList l) {
        n = l.size();
        arr = new long[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrl = arr;
                return new U64Vector(arrl);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).longValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int u64vectorLength(U64Vector v) {
        return v.size();
    }

    @SourceMethodType(value={"ulong"})
    public static long u64vectorRef(U64Vector v, int i) {
        return v.getLong(i);
    }

    @SourceMethodType(value={"", "", "", "ulong"})
    public static void u64vectorSet$Ex(U64Vector v, int i, long x) {
        v.setLong(i, x);
    }

    public static LList u64vector$To$List(U64Vector v) {
        return LList.makeList(v);
    }

    public static boolean isF32vector(Object x) {
        return x instanceof F32Vector;
    }

    public static F32Vector makeF32vector(int n) {
        return uniform.makeF32vector(n, 0.0f);
    }

    public static F32Vector makeF32vector(int n, float init) {
        return new F32Vector(n, init);
    }

    public static F32Vector f32vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$F32vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static F32Vector list$To$F32vector(LList l) {
        n = l.size();
        arr = new float[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrf = arr;
                return new F32Vector(arrf);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).floatValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int f32vectorLength(F32Vector v) {
        return v.size();
    }

    public static float f32vectorRef(F32Vector v, int i) {
        return v.getFloat(i);
    }

    public static void f32vectorSet$Ex(F32Vector v, int i, float x) {
        v.setFloat(i, x);
    }

    public static LList f32vector$To$List(F32Vector v) {
        return LList.makeList(v);
    }

    public static boolean isF64vector(Object x) {
        return x instanceof F64Vector;
    }

    public static F64Vector makeF64vector(int n) {
        return uniform.makeF64vector(n, 0.0);
    }

    public static F64Vector makeF64vector(int n, double init) {
        return new F64Vector(n, init);
    }

    public static F64Vector f64vector$V(Object[] argsArray) {
        LList lList;
        LList values = lList = LList.makeList(argsArray, 0);
        return uniform.list$To$F64vector(values);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static F64Vector list$To$F64vector(LList l) {
        n = l.size();
        arr = new double[n];
        i = 0;
        object3 = l;
        do lbl-1000: // 2 sources:
        {
            if (object3 == LList.Empty) {
                arrd = arr;
                return new F64Vector(arrd);
            }
            pair = (Pair)Promise.force(object3, Pair.class);
            object4 = pair.getCar();
            object2 = Promise.force(object4);
            arr[i] = ((Number)object2).doubleValue();
            ++i;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "v", -2, object2);
        }
        {
            object3 = pair.getCdr();
            ** while (true)
        }
    }

    public static int f64vectorLength(F64Vector v) {
        return v.size();
    }

    public static double f64vectorRef(F64Vector v, int i) {
        return v.getDouble(i);
    }

    public static void f64vectorSet$Ex(F64Vector v, int i, double x) {
        v.setDouble(i, x);
    }

    public static LList f64vector$To$List(F64Vector v) {
        return LList.makeList(v);
    }

    public static {
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
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[19];
        arrobject[0] = Symbol.valueOf("let*");
        arrobject[1] = Lit84;
        arrobject[2] = Symbol.valueOf("length");
        arrobject[3] = Lit85;
        arrobject[4] = Symbol.valueOf("$bracket-apply$");
        arrobject[5] = PairWithPosition.make(Keyword.make("length"), PairWithPosition.make(Lit84, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 131113), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 131105);
        Lit0 = IntNum.valueOf(0);
        arrobject[6] = PairWithPosition.make(PairWithPosition.make(Lit86, PairWithPosition.make(Lit87, PairWithPosition.make(Symbol.valueOf("int"), PairWithPosition.make(Lit0, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135190), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135186), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135184), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135181), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 135181);
        arrobject[7] = Symbol.valueOf("for-each");
        arrobject[8] = Symbol.valueOf("lambda");
        arrobject[9] = Lit88;
        arrobject[10] = Lit90;
        arrobject[11] = PairWithPosition.make(Lit85, PairWithPosition.make(Lit86, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 143391), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 143386);
        arrobject[12] = Symbol.valueOf("let");
        arrobject[13] = Lit89;
        arrobject[14] = Lit87;
        arrobject[15] = Lit88;
        arrobject[16] = PairWithPosition.make(Lit89, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 143418);
        arrobject[17] = PairWithPosition.make(PairWithPosition.make(Lit90, PairWithPosition.make(Lit86, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("+"), PairWithPosition.make(Lit86, PairWithPosition.make(IntNum.valueOf(1), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147489), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147487), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147484), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147484), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147482), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147476), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 147476);
        arrobject[18] = PairWithPosition.make(Lit85, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/uniform.scm", 155656);
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit83, 3, "uniform.scm:30"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u00c9I\u0011\u0018\f\b\u0011\u0018\u0014\b\u0003a\u0011\u0018\u001c\b)\u0011\u0018$\b\u0013\u0018,\u00184\u0139\u0011\u0018<\u0109\u0011\u0018D\u0011\u0018L\u00c1\u0011\u0018T\u0011\u0018\\\b\u0011\u0018dY\b\u0011\u0018l\u0011\u0018t\t\u000b\u0018|\u0018\u0084\u0018\u008c\b\u0003\u0018\u0094", arrobject, 0);
        Lit8 = Symbol.valueOf("%list->array");
        Lit9 = new SyntaxRules(Lit83, arrsyntaxRule, 3, Lit8);
        Lit7 = Symbol.valueOf("s8vector->list");
        Lit6 = Symbol.valueOf("s8vector-set!");
        Lit5 = Symbol.valueOf("s8vector-ref");
        Lit4 = Symbol.valueOf("s8vector-length");
        Lit3 = Symbol.valueOf("s8vector");
        Lit2 = Symbol.valueOf("make-s8vector");
        Lit1 = Symbol.valueOf("s8vector?");
        $instance = new uniform();
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
        uniform uniform2 = $instance;
        s8vector$Qu = new ModuleMethod(uniform2, 1, Lit1, 4097);
        make$Mns8vector = new ModuleMethod(uniform2, 2, Lit2, 8193);
        s8vector = new ModuleMethod(uniform2, 4, Lit3, -4096);
        s8vector$Mnlength = new ModuleMethod(uniform2, 5, Lit4, 4097);
        s8vector$Mnref = new ModuleMethod(uniform2, 6, Lit5, 8194);
        s8vector$Mnset$Ex = new ModuleMethod(uniform2, 7, Lit6, 12291);
        s8vector$Mn$Grlist = new ModuleMethod(uniform2, 8, Lit7, 4097);
        $Pclist$Mn$Grarray = Macro.make(Lit8, Lit9, "kawa.lib.uniform");
        list$Mn$Grs8vector = new ModuleMethod(uniform2, 9, Lit10, 4097);
        u8vector$Qu = new ModuleMethod(uniform2, 10, Lit11, 4097);
        make$Mnu8vector = new ModuleMethod(uniform2, 11, Lit12, 8193);
        u8vector = new ModuleMethod(uniform2, 13, Lit13, -4096);
        u8vector$Mnlength = new ModuleMethod(uniform2, 14, Lit14, 4097);
        u8vector$Mnref = new ModuleMethod(uniform2, 15, Lit15, 8194);
        u8vector$Mnset$Ex = new ModuleMethod(uniform2, 16, Lit16, 12291);
        u8vector$Mn$Grlist = new ModuleMethod(uniform2, 17, Lit17, 4097);
        list$Mn$Gru8vector = new ModuleMethod(uniform2, 18, Lit18, 4097);
        s16vector$Qu = new ModuleMethod(uniform2, 19, Lit19, 4097);
        make$Mns16vector = new ModuleMethod(uniform2, 20, Lit20, 8193);
        s16vector = new ModuleMethod(uniform2, 22, Lit21, -4096);
        s16vector$Mnlength = new ModuleMethod(uniform2, 23, Lit22, 4097);
        s16vector$Mnref = new ModuleMethod(uniform2, 24, Lit23, 8194);
        s16vector$Mnset$Ex = new ModuleMethod(uniform2, 25, Lit24, 12291);
        s16vector$Mn$Grlist = new ModuleMethod(uniform2, 26, Lit25, 4097);
        list$Mn$Grs16vector = new ModuleMethod(uniform2, 27, Lit26, 4097);
        u16vector$Qu = new ModuleMethod(uniform2, 28, Lit27, 4097);
        make$Mnu16vector = new ModuleMethod(uniform2, 29, Lit28, 8193);
        u16vector = new ModuleMethod(uniform2, 31, Lit29, -4096);
        u16vector$Mnlength = new ModuleMethod(uniform2, 32, Lit30, 4097);
        u16vector$Mnref = new ModuleMethod(uniform2, 33, Lit31, 8194);
        u16vector$Mnset$Ex = new ModuleMethod(uniform2, 34, Lit32, 12291);
        u16vector$Mn$Grlist = new ModuleMethod(uniform2, 35, Lit33, 4097);
        list$Mn$Gru16vector = new ModuleMethod(uniform2, 36, Lit34, 4097);
        s32vector$Qu = new ModuleMethod(uniform2, 37, Lit35, 4097);
        make$Mns32vector = new ModuleMethod(uniform2, 38, Lit36, 8193);
        s32vector = new ModuleMethod(uniform2, 40, Lit37, -4096);
        s32vector$Mnlength = new ModuleMethod(uniform2, 41, Lit38, 4097);
        s32vector$Mnref = new ModuleMethod(uniform2, 42, Lit39, 8194);
        s32vector$Mnset$Ex = new ModuleMethod(uniform2, 43, Lit40, 12291);
        s32vector$Mn$Grlist = new ModuleMethod(uniform2, 44, Lit41, 4097);
        list$Mn$Grs32vector = new ModuleMethod(uniform2, 45, Lit42, 4097);
        u32vector$Qu = new ModuleMethod(uniform2, 46, Lit43, 4097);
        make$Mnu32vector = new ModuleMethod(uniform2, 47, Lit44, 8193);
        u32vector = new ModuleMethod(uniform2, 49, Lit45, -4096);
        u32vector$Mnlength = new ModuleMethod(uniform2, 50, Lit46, 4097);
        u32vector$Mnref = new ModuleMethod(uniform2, 51, Lit47, 8194);
        u32vector$Mnset$Ex = new ModuleMethod(uniform2, 52, Lit48, 12291);
        u32vector$Mn$Grlist = new ModuleMethod(uniform2, 53, Lit49, 4097);
        list$Mn$Gru32vector = new ModuleMethod(uniform2, 54, Lit50, 4097);
        s64vector$Qu = new ModuleMethod(uniform2, 55, Lit51, 4097);
        make$Mns64vector = new ModuleMethod(uniform2, 56, Lit52, 8193);
        s64vector = new ModuleMethod(uniform2, 58, Lit53, -4096);
        s64vector$Mnlength = new ModuleMethod(uniform2, 59, Lit54, 4097);
        s64vector$Mnref = new ModuleMethod(uniform2, 60, Lit55, 8194);
        s64vector$Mnset$Ex = new ModuleMethod(uniform2, 61, Lit56, 12291);
        s64vector$Mn$Grlist = new ModuleMethod(uniform2, 62, Lit57, 4097);
        list$Mn$Grs64vector = new ModuleMethod(uniform2, 63, Lit58, 4097);
        u64vector$Qu = new ModuleMethod(uniform2, 64, Lit59, 4097);
        make$Mnu64vector = new ModuleMethod(uniform2, 65, Lit60, 8193);
        u64vector = new ModuleMethod(uniform2, 67, Lit61, -4096);
        u64vector$Mnlength = new ModuleMethod(uniform2, 68, Lit62, 4097);
        u64vector$Mnref = new ModuleMethod(uniform2, 69, Lit63, 8194);
        u64vector$Mnset$Ex = new ModuleMethod(uniform2, 70, Lit64, 12291);
        u64vector$Mn$Grlist = new ModuleMethod(uniform2, 71, Lit65, 4097);
        list$Mn$Gru64vector = new ModuleMethod(uniform2, 72, Lit66, 4097);
        f32vector$Qu = new ModuleMethod(uniform2, 73, Lit67, 4097);
        make$Mnf32vector = new ModuleMethod(uniform2, 74, Lit68, 8193);
        f32vector = new ModuleMethod(uniform2, 76, Lit69, -4096);
        f32vector$Mnlength = new ModuleMethod(uniform2, 77, Lit70, 4097);
        f32vector$Mnref = new ModuleMethod(uniform2, 78, Lit71, 8194);
        f32vector$Mnset$Ex = new ModuleMethod(uniform2, 79, Lit72, 12291);
        f32vector$Mn$Grlist = new ModuleMethod(uniform2, 80, Lit73, 4097);
        list$Mn$Grf32vector = new ModuleMethod(uniform2, 81, Lit74, 4097);
        f64vector$Qu = new ModuleMethod(uniform2, 82, Lit75, 4097);
        make$Mnf64vector = new ModuleMethod(uniform2, 83, Lit76, 8193);
        f64vector = new ModuleMethod(uniform2, 85, Lit77, -4096);
        f64vector$Mnlength = new ModuleMethod(uniform2, 86, Lit78, 4097);
        f64vector$Mnref = new ModuleMethod(uniform2, 87, Lit79, 8194);
        f64vector$Mnset$Ex = new ModuleMethod(uniform2, 88, Lit80, 12291);
        f64vector$Mn$Grlist = new ModuleMethod(uniform2, 89, Lit81, 4097);
        list$Mn$Grf64vector = new ModuleMethod(uniform2, 90, Lit82, 4097);
        uniform.$runBody$();
    }

    public uniform() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 90: {
                Object object3 = Promise.force(object2, LList.class);
                if (!(object3 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 89: {
                Object object4 = Promise.force(object2, F64Vector.class);
                if (!(object4 instanceof F64Vector)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 86: {
                Object object5 = Promise.force(object2, F64Vector.class);
                if (!(object5 instanceof F64Vector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 83: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 82: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 81: {
                Object object6 = Promise.force(object2, LList.class);
                if (!(object6 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 80: {
                Object object7 = Promise.force(object2, F32Vector.class);
                if (!(object7 instanceof F32Vector)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 77: {
                Object object8 = Promise.force(object2, F32Vector.class);
                if (!(object8 instanceof F32Vector)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 74: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 73: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 72: {
                Object object9 = Promise.force(object2, LList.class);
                if (!(object9 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 71: {
                Object object10 = Promise.force(object2, U64Vector.class);
                if (!(object10 instanceof U64Vector)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 68: {
                Object object11 = Promise.force(object2, U64Vector.class);
                if (!(object11 instanceof U64Vector)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 65: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 64: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 63: {
                Object object12 = Promise.force(object2, LList.class);
                if (!(object12 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 62: {
                Object object13 = Promise.force(object2, S64Vector.class);
                if (!(object13 instanceof S64Vector)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 59: {
                Object object14 = Promise.force(object2, S64Vector.class);
                if (!(object14 instanceof S64Vector)) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 56: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 55: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 54: {
                Object object15 = Promise.force(object2, LList.class);
                if (!(object15 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 53: {
                Object object16 = Promise.force(object2, U32Vector.class);
                if (!(object16 instanceof U32Vector)) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 50: {
                Object object17 = Promise.force(object2, U32Vector.class);
                if (!(object17 instanceof U32Vector)) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 47: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 46: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 45: {
                Object object18 = Promise.force(object2, LList.class);
                if (!(object18 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 44: {
                Object object19 = Promise.force(object2, S32Vector.class);
                if (!(object19 instanceof S32Vector)) {
                    return -786431;
                }
                callContext.value1 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 41: {
                Object object20 = Promise.force(object2, S32Vector.class);
                if (!(object20 instanceof S32Vector)) {
                    return -786431;
                }
                callContext.value1 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 38: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 37: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 36: {
                Object object21 = Promise.force(object2, LList.class);
                if (!(object21 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 35: {
                Object object22 = Promise.force(object2, U16Vector.class);
                if (!(object22 instanceof U16Vector)) {
                    return -786431;
                }
                callContext.value1 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                Object object23 = Promise.force(object2, U16Vector.class);
                if (!(object23 instanceof U16Vector)) {
                    return -786431;
                }
                callContext.value1 = object23;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 29: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 28: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 27: {
                Object object24 = Promise.force(object2, LList.class);
                if (!(object24 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object24;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 26: {
                Object object25 = Promise.force(object2, S16Vector.class);
                if (!(object25 instanceof S16Vector)) {
                    return -786431;
                }
                callContext.value1 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 23: {
                Object object26 = Promise.force(object2, S16Vector.class);
                if (!(object26 instanceof S16Vector)) {
                    return -786431;
                }
                callContext.value1 = object26;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 20: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 19: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                Object object27 = Promise.force(object2, LList.class);
                if (!(object27 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object27;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                Object object28 = Promise.force(object2, U8Vector.class);
                if (!(object28 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object28;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object29 = Promise.force(object2, U8Vector.class);
                if (!(object29 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object29;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                Object object30 = Promise.force(object2, LList.class);
                if (!(object30 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object30;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 8: {
                Object object31 = Promise.force(object2, S8Vector.class);
                if (!(object31 instanceof S8Vector)) {
                    return -786431;
                }
                callContext.value1 = object31;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                Object object32 = Promise.force(object2, S8Vector.class);
                if (!(object32 instanceof S8Vector)) {
                    return -786431;
                }
                callContext.value1 = object32;
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
            case 87: {
                Object object4 = Promise.force(object2, F64Vector.class);
                if (!(object4 instanceof F64Vector)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 83: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 78: {
                Object object5 = Promise.force(object2, F32Vector.class);
                if (!(object5 instanceof F32Vector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 74: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 69: {
                Object object6 = Promise.force(object2, U64Vector.class);
                if (!(object6 instanceof U64Vector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 65: {
                callContext.value1 = Promise.force(object2);
                Object object7 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object7) == null) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 60: {
                Object object8 = Promise.force(object2, S64Vector.class);
                if (!(object8 instanceof S64Vector)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 56: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 51: {
                Object object9 = Promise.force(object2, U32Vector.class);
                if (!(object9 instanceof U32Vector)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 47: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 42: {
                Object object10 = Promise.force(object2, S32Vector.class);
                if (!(object10 instanceof S32Vector)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 38: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 33: {
                Object object11 = Promise.force(object2, U16Vector.class);
                if (!(object11 instanceof U16Vector)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 29: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 24: {
                Object object12 = Promise.force(object2, S16Vector.class);
                if (!(object12 instanceof S16Vector)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 20: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                Object object13 = Promise.force(object2, U8Vector.class);
                if (!(object13 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 11: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 6: {
                Object object14 = Promise.force(object2, S8Vector.class);
                if (!(object14 instanceof S8Vector)) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 2: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 88: {
                Object object5 = Promise.force(object2, F64Vector.class);
                if (!(object5 instanceof F64Vector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 79: {
                Object object6 = Promise.force(object2, F32Vector.class);
                if (!(object6 instanceof F32Vector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 70: {
                Object object7 = Promise.force(object2, U64Vector.class);
                if (!(object7 instanceof U64Vector)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = Promise.force(object3);
                Object object8 = Promise.force(object4);
                if (!(object8 instanceof Number)) {
                    return -786429;
                }
                callContext.value3 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 61: {
                Object object9 = Promise.force(object2, S64Vector.class);
                if (!(object9 instanceof S64Vector)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 52: {
                Object object10 = Promise.force(object2, U32Vector.class);
                if (!(object10 instanceof U32Vector)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = Promise.force(object3);
                Object object11 = Promise.force(object4);
                if (!(object11 instanceof Number)) {
                    return -786429;
                }
                callContext.value3 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 43: {
                Object object12 = Promise.force(object2, S32Vector.class);
                if (!(object12 instanceof S32Vector)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 34: {
                Object object13 = Promise.force(object2, U16Vector.class);
                if (!(object13 instanceof U16Vector)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.value2 = Promise.force(object3);
                Object object14 = Promise.force(object4);
                if (!(object14 instanceof Number)) {
                    return -786429;
                }
                callContext.value3 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 25: {
                Object object15 = Promise.force(object2, S16Vector.class);
                if (!(object15 instanceof S16Vector)) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 16: {
                Object object16 = Promise.force(object2, U8Vector.class);
                if (!(object16 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.value2 = Promise.force(object3);
                Object object17 = Promise.force(object4);
                if (!(object17 instanceof Number)) {
                    return -786429;
                }
                callContext.value3 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 7: {
                Object object18 = Promise.force(object2, S8Vector.class);
                if (!(object18 instanceof S8Vector)) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 85: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 76: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 67: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 58: {
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
            case 40: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 31: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 22: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 13: {
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
                if (uniform.isS8vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                return uniform.makeS8vector(((Number)Promise.force(object2)).intValue());
            }
            case 5: {
                return uniform.s8vectorLength((S8Vector)Promise.force(object2, S8Vector.class));
            }
            case 8: {
                return uniform.s8vector$To$List((S8Vector)Promise.force(object2, S8Vector.class));
            }
            case 9: {
                return uniform.list$To$S8vector((LList)Promise.force(object2, LList.class));
            }
            case 10: {
                Boolean bl;
                if (uniform.isU8vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 11: {
                return uniform.makeU8vector(((Number)Promise.force(object2)).intValue());
            }
            case 14: {
                return uniform.u8vectorLength((U8Vector)Promise.force(object2, U8Vector.class));
            }
            case 17: {
                return uniform.u8vector$To$List((U8Vector)Promise.force(object2, U8Vector.class));
            }
            case 18: {
                return uniform.list$To$U8vector((LList)Promise.force(object2, LList.class));
            }
            case 19: {
                Boolean bl;
                if (uniform.isS16vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 20: {
                return uniform.makeS16vector(((Number)Promise.force(object2)).intValue());
            }
            case 23: {
                return uniform.s16vectorLength((S16Vector)Promise.force(object2, S16Vector.class));
            }
            case 26: {
                return uniform.s16vector$To$List((S16Vector)Promise.force(object2, S16Vector.class));
            }
            case 27: {
                return uniform.list$To$S16vector((LList)Promise.force(object2, LList.class));
            }
            case 28: {
                Boolean bl;
                if (uniform.isU16vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 29: {
                return uniform.makeU16vector(((Number)Promise.force(object2)).intValue());
            }
            case 32: {
                return uniform.u16vectorLength((U16Vector)Promise.force(object2, U16Vector.class));
            }
            case 35: {
                return uniform.u16vector$To$List((U16Vector)Promise.force(object2, U16Vector.class));
            }
            case 36: {
                return uniform.list$To$U16vector((LList)Promise.force(object2, LList.class));
            }
            case 37: {
                Boolean bl;
                if (uniform.isS32vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 38: {
                return uniform.makeS32vector(((Number)Promise.force(object2)).intValue());
            }
            case 41: {
                return uniform.s32vectorLength((S32Vector)Promise.force(object2, S32Vector.class));
            }
            case 44: {
                return uniform.s32vector$To$List((S32Vector)Promise.force(object2, S32Vector.class));
            }
            case 45: {
                return uniform.list$To$S32vector((LList)Promise.force(object2, LList.class));
            }
            case 46: {
                Boolean bl;
                if (uniform.isU32vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 47: {
                return uniform.makeU32vector(((Number)Promise.force(object2)).intValue());
            }
            case 50: {
                return uniform.u32vectorLength((U32Vector)Promise.force(object2, U32Vector.class));
            }
            case 53: {
                return uniform.u32vector$To$List((U32Vector)Promise.force(object2, U32Vector.class));
            }
            case 54: {
                return uniform.list$To$U32vector((LList)Promise.force(object2, LList.class));
            }
            case 55: {
                Boolean bl;
                if (uniform.isS64vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 56: {
                return uniform.makeS64vector(((Number)Promise.force(object2)).intValue());
            }
            case 59: {
                return uniform.s64vectorLength((S64Vector)Promise.force(object2, S64Vector.class));
            }
            case 62: {
                return uniform.s64vector$To$List((S64Vector)Promise.force(object2, S64Vector.class));
            }
            case 63: {
                return uniform.list$To$S64vector((LList)Promise.force(object2, LList.class));
            }
            case 64: {
                Boolean bl;
                if (uniform.isU64vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 65: {
                return uniform.makeU64vector(((Number)Promise.force(object2)).intValue());
            }
            case 68: {
                return uniform.u64vectorLength((U64Vector)Promise.force(object2, U64Vector.class));
            }
            case 71: {
                return uniform.u64vector$To$List((U64Vector)Promise.force(object2, U64Vector.class));
            }
            case 72: {
                return uniform.list$To$U64vector((LList)Promise.force(object2, LList.class));
            }
            case 73: {
                Boolean bl;
                if (uniform.isF32vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 74: {
                return uniform.makeF32vector(((Number)Promise.force(object2)).intValue());
            }
            case 77: {
                return uniform.f32vectorLength((F32Vector)Promise.force(object2, F32Vector.class));
            }
            case 80: {
                return uniform.f32vector$To$List((F32Vector)Promise.force(object2, F32Vector.class));
            }
            case 81: {
                return uniform.list$To$F32vector((LList)Promise.force(object2, LList.class));
            }
            case 82: {
                Boolean bl;
                if (uniform.isF64vector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 83: {
                return uniform.makeF64vector(((Number)Promise.force(object2)).intValue());
            }
            case 86: {
                return uniform.f64vectorLength((F64Vector)Promise.force(object2, F64Vector.class));
            }
            case 89: {
                return uniform.f64vector$To$List((F64Vector)Promise.force(object2, F64Vector.class));
            }
            case 90: {
                return uniform.list$To$F64vector((LList)Promise.force(object2, LList.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-s8vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "s8vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "s8vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->s8vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-u8vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u8vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u8vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->u8vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-s16vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "s16vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "s16vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->s16vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-u16vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u16vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u16vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->u16vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-s32vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "s32vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "s32vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->s32vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-u32vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u32vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u32vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->u32vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-s64vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "s64vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "s64vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->s64vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-u64vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u64vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u64vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->u64vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-f32vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "f32vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "f32vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->f32vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-f64vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "f64vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "f64vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->f64vector", 1, object2);
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

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 4: {
                return uniform.s8vector$V(arrobject);
            }
            case 13: {
                return uniform.u8vector$V(arrobject);
            }
            case 22: {
                return uniform.s16vector$V(arrobject);
            }
            case 31: {
                return uniform.u16vector$V(arrobject);
            }
            case 40: {
                return uniform.s32vector$V(arrobject);
            }
            case 49: {
                return uniform.u32vector$V(arrobject);
            }
            case 58: {
                return uniform.s64vector$V(arrobject);
            }
            case 67: {
                return uniform.u64vector$V(arrobject);
            }
            case 76: {
                return uniform.f32vector$V(arrobject);
            }
            case 85: {
                return uniform.f64vector$V(arrobject);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

