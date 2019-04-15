/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.Type;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.ArrayPrint;
import gnu.kawa.functions.Arrays;
import gnu.kawa.functions.Format;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.AVector;
import gnu.lists.Array;
import gnu.lists.ComposedArray;
import gnu.lists.Consumer;
import gnu.lists.FVector;
import gnu.lists.FlattenedArray;
import gnu.lists.GeneralArray;
import gnu.lists.Range;
import gnu.lists.SimpleVector;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lib.exceptions;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class arrays
extends ModuleBody {
    public static final Class $Lsarray$Gr;
    public static final ModuleMethod array$Qu;
    public static final ModuleMethod shape;
    public static final ModuleMethod make$Mnarray;
    public static final ModuleMethod array;
    public static final ModuleMethod array$Mnrank;
    public static final ModuleMethod array$Mnsize;
    public static final ModuleMethod array$Mnstart;
    public static final ModuleMethod array$Mnend;
    public static final ModuleMethod share$Mnarray;
    public static final ModuleMethod array$Mnindex$Mnref;
    public static final ModuleMethod array$Mnindex$Mnshare;
    public static final ModuleMethod array$Mnflatten;
    public static final ModuleMethod array$Mn$Grvector;
    public static final ModuleMethod index$Mnarray;
    public static final ModuleMethod array$Mncopy$Ex;
    public static final ModuleMethod array$Mnfill$Ex;
    public static final ModuleMethod array$Mntransform;
    public static final ModuleMethod build$Mnarray;
    public static final ModuleMethod array$Mnreshape;
    public static final ModuleMethod format$Mnarray;
    public static arrays $instance;
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

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean isArray(Object x) {
        return x instanceof Array;
    }

    public static /* varargs */ Array shape(Object ... args) {
        return Arrays.shape(args);
    }

    public static /* varargs */ Array makeArray(Array shape, Object ... obj) {
        return Arrays.makeFromValues(shape, obj);
    }

    public static /* varargs */ Array array(Array shape, Object ... vals) {
        return Arrays.makeSimple(shape, new FVector(vals));
    }

    public static int arrayRank(Array array) {
        return array.rank();
    }

    public static int arraySize(Array arr) {
        return arr.getSize();
    }

    public static int arrayStart(Array array, int k) {
        return array.getLowBound(k);
    }

    public static int arrayEnd(Array array, int k) {
        return array.getLowBound(k) + array.getSize(k);
    }

    public static Array shareArray(Array array, Array shape, Procedure mapper) {
        return Arrays.shareArray(array, shape, mapper);
    }

    public static /* varargs */ Object arrayIndexRef(Array arr, Object ... indexes) {
        return ComposedArray.generalIndex(arr, false, indexes);
    }

    public static /* varargs */ Object arrayIndexShare(Array arr, Object ... indexes) {
        return ComposedArray.generalIndex(arr, true, indexes);
    }

    public static SimpleVector<Object> arrayFlatten(Array arr) {
        Array array = arr;
        return gnu.lists.Arrays.flattenCopy(array, true);
    }

    public static AVector<Object> array$To$Vector(Array arr) {
        Array array = arr;
        return FlattenedArray.flatten(array);
    }

    public static Array indexArray(Array shape) {
        GeneralArray arr = Arrays.allocateArray(shape);
        Range.IntRange intRange = Range.zeroAndUp;
        arr.setBase(intRange);
        return arr;
    }

    public static void arrayCopy$Ex(Array dst, Array src) {
        Array array = dst;
        Array array2 = array;
        array2 = src;
        gnu.lists.Arrays.copy(array, array2);
    }

    public static void arrayFill$Ex(Array arr, Object value) {
        Array array = arr;
        gnu.lists.Arrays.fill(array, value);
    }

    public static Array arrayTransform(Array arr, Array shape, Procedure mapper) {
        Array array = arr;
        return Arrays.getTransformed(array, mapper, shape);
    }

    public static Array buildArray(Array shape, Procedure proc) {
        return Arrays.getBuiltArray(shape, proc);
    }

    public static Array arrayReshape(Array arr, Array shape) {
        GeneralArray result = Arrays.allocateArray(shape);
        Array array = arr;
        AVector vec = FlattenedArray.flatten(array);
        int vsz = vec.size();
        int sz = result.getSize();
        if (sz != vsz) {
            Type.NeverReturns neverReturns = exceptions.error(Format.formatToString(0, "shape requires ~d elements but argument has ~d", sz, vsz));
            throw Special.reachedUnexpected;
        }
        result.setBase(vec);
        return result;
    }

    public static CharSequence formatArray(Object object2) {
        return arrays.formatArray(object2, null);
    }

    public static CharSequence formatArray(Object value, CharSequence elementFormat) {
        CharSequence charSequence = elementFormat;
        return ArrayPrint.print(value, (String)(charSequence == null ? null : ((Object)charSequence).toString()));
    }

    public static {
        Lit19 = Symbol.valueOf("format-array");
        Lit18 = Symbol.valueOf("array-reshape");
        Lit17 = Symbol.valueOf("build-array");
        Lit16 = Symbol.valueOf("array-transform");
        Lit15 = Symbol.valueOf("array-fill!");
        Lit14 = Symbol.valueOf("array-copy!");
        Lit13 = Symbol.valueOf("index-array");
        Lit12 = Symbol.valueOf("array->vector");
        Lit11 = Symbol.valueOf("array-flatten");
        Lit10 = Symbol.valueOf("array-index-share");
        Lit9 = Symbol.valueOf("array-index-ref");
        Lit8 = Symbol.valueOf("share-array");
        Lit7 = Symbol.valueOf("array-end");
        Lit6 = Symbol.valueOf("array-start");
        Lit5 = Symbol.valueOf("array-size");
        Lit4 = Symbol.valueOf("array-rank");
        Lit3 = Symbol.valueOf("array");
        Lit2 = Symbol.valueOf("make-array");
        Lit1 = Symbol.valueOf("shape");
        Lit0 = Symbol.valueOf("array?");
        $Lsarray$Gr = Array.class;
        arrays arrays2 = $instance = new arrays();
        array$Qu = new ModuleMethod(arrays2, 1, Lit0, 4097);
        shape = new ModuleMethod(arrays2, 2, Lit1, -4096);
        make$Mnarray = new ModuleMethod(arrays2, 3, Lit2, -4095);
        array = new ModuleMethod(arrays2, 4, Lit3, -4095);
        array$Mnrank = new ModuleMethod(arrays2, 5, Lit4, 4097);
        array$Mnsize = new ModuleMethod(arrays2, 6, Lit5, 4097);
        array$Mnstart = new ModuleMethod(arrays2, 7, Lit6, 8194);
        array$Mnend = new ModuleMethod(arrays2, 8, Lit7, 8194);
        share$Mnarray = new ModuleMethod(arrays2, 9, Lit8, 12291);
        array$Mnindex$Mnref = new ModuleMethod(arrays2, 10, Lit9, -4095);
        array$Mnindex$Mnshare = new ModuleMethod(arrays2, 11, Lit10, -4095);
        array$Mnflatten = new ModuleMethod(arrays2, 12, Lit11, 4097);
        array$Mn$Grvector = new ModuleMethod(arrays2, 13, Lit12, 4097);
        index$Mnarray = new ModuleMethod(arrays2, 14, Lit13, 4097);
        array$Mncopy$Ex = new ModuleMethod(arrays2, 15, Lit14, 8194);
        array$Mnfill$Ex = new ModuleMethod(arrays2, 16, Lit15, 8194);
        array$Mntransform = new ModuleMethod(arrays2, 17, Lit16, 12291);
        build$Mnarray = new ModuleMethod(arrays2, 18, Lit17, 8194);
        array$Mnreshape = new ModuleMethod(arrays2, 19, Lit18, 8194);
        format$Mnarray = new ModuleMethod(arrays2, 20, Lit19, 8193);
        arrays.$runBody$();
    }

    public arrays() {
        ModuleInfo.register(this);
    }

    @Override
    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 20: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object3 = Promise.force(object2, Array.class);
                if (!(object3 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
                Object object4 = Promise.force(object2, Array.class);
                if (!(object4 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                Object object5 = Promise.force(object2, Array.class);
                if (!(object5 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                Object object6 = Promise.force(object2, Array.class);
                if (!(object6 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                Object object7 = Promise.force(object2, Array.class);
                if (!(object7 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object7;
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

    @Override
    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 20: {
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
            case 19: {
                Object object5 = Promise.force(object2, Array.class);
                if (!(object5 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3, Array.class);
                if (!(object6 instanceof Array)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 18: {
                Object object7 = Promise.force(object2, Array.class);
                if (!(object7 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object8) == null) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 16: {
                Object object9 = Promise.force(object2, Array.class);
                if (!(object9 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                Object object10 = Promise.force(object2, Array.class);
                if (!(object10 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object10;
                Object object11 = Promise.force(object3, Array.class);
                if (!(object11 instanceof Array)) {
                    return -786430;
                }
                callContext.value2 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 8: {
                Object object12 = Promise.force(object2, Array.class);
                if (!(object12 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                Object object13 = Promise.force(object2, Array.class);
                if (!(object13 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    @Override
    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 17: {
                Object object5 = Promise.force(object2, Array.class);
                if (!(object5 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3, Array.class);
                if (!(object6 instanceof Array)) {
                    return -786430;
                }
                callContext.value2 = object6;
                Object object7 = Promise.force(object4, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                    return -786429;
                }
                callContext.value3 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 9: {
                Object object8 = Promise.force(object2, Array.class);
                if (!(object8 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3, Array.class);
                if (!(object9 instanceof Array)) {
                    return -786430;
                }
                callContext.value2 = object9;
                Object object10 = Promise.force(object4, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object10) == null) {
                    return -786429;
                }
                callContext.value3 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    @Override
    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
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
            case 4: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 3: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 2: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    @Override
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
    @Override
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                Boolean bl;
                if (arrays.isArray(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 5: {
                return arrays.arrayRank((Array)Promise.force(object2, Array.class));
            }
            case 6: {
                return arrays.arraySize((Array)Promise.force(object2, Array.class));
            }
            case 12: {
                return arrays.arrayFlatten((Array)Promise.force(object2, Array.class));
            }
            case 13: {
                return arrays.array$To$Vector((Array)Promise.force(object2, Array.class));
            }
            case 14: {
                return arrays.indexArray((Array)Promise.force(object2, Array.class));
            }
            case 20: {
                return arrays.formatArray(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "array-rank", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "array-size", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "array-flatten", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "array->vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "index-array", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    @Override
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
    @Override
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

    @Override
    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 2: {
                return arrays.shape(arrobject);
            }
            case 3: {
                Object object2 = Promise.force(arrobject[0], Array.class);
                int n = arrobject.length - 1;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 1];
                }
                return arrays.makeArray((Array)object2, arrobject2);
            }
            case 4: {
                Object object3 = Promise.force(arrobject[0], Array.class);
                int n = arrobject.length - 1;
                Object[] arrobject3 = new Object[n];
                while (--n >= 0) {
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 1];
                }
                return arrays.array((Array)object3, arrobject3);
            }
            case 10: {
                Object object4 = Promise.force(arrobject[0], Array.class);
                int n = arrobject.length - 1;
                Object[] arrobject4 = new Object[n];
                while (--n >= 0) {
                    arrobject4 = arrobject4;
                    arrobject4[n] = arrobject[n + 1];
                }
                return arrays.arrayIndexRef((Array)object4, arrobject4);
            }
            case 11: {
                Object object5 = Promise.force(arrobject[0], Array.class);
                int n = arrobject.length - 1;
                Object[] arrobject5 = new Object[n];
                while (--n >= 0) {
                    arrobject5 = arrobject5;
                    arrobject5[n] = arrobject[n + 1];
                }
                return arrays.arrayIndexShare((Array)object5, arrobject5);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

