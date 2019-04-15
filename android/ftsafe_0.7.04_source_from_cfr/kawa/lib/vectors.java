/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.MakeSplice;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.lists.SimpleVector;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;
import java.util.Iterator;
import java.util.List;
import kawa.lib.lists;
import kawa.lib.numbers;
import kawa.standard.Scheme;

public class vectors
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        vector$Mnref.setProperty(Lit0, vector$Mnset$Ex);
        ModuleMethod vector$Mnref = vector$Mnref$Fn1;
        ModuleMethod moduleMethod = vector$Mnref$Fn1;
        vectors.vector$Mnref.add(moduleMethod);
    }

    public static boolean isVector(Object x) {
        return x instanceof FVector;
    }

    public static FVector makeVector(int n) {
        return vectors.makeVector(n, null);
    }

    public static FVector makeVector(int k, Object fill) {
        return new FVector(k, fill);
    }

    public static int vectorLength(FVector x) {
        return x.size();
    }

    public static void vectorSet$Ex(FVector vector, int k, Object obj) {
        vector.setAt(k, obj);
    }

    public static Object vectorRef(FVector vector, int k) {
        return vector.get(k);
    }

    public static LList vector$To$List(FVector fVector) {
        return vectors.vector$To$List(fVector, 0);
    }

    public static LList vector$To$List(FVector fVector, int n) {
        return vectors.vector$To$List(fVector, n, fVector.size());
    }

    public static LList vector$To$List(FVector vec, int start, int end) {
        void i;
        int n = end;
        LList result = LList.Empty;
        while (--i >= start) {
            result = lists.cons(((Procedure)vector$Mnref).apply2(vec, (int)i), result);
        }
        return result;
    }

    public static FVector list$To$Vector(LList x) {
        return new FVector(x);
    }

    public static CharSequence vector$To$String(FVector fVector) {
        return vectors.vector$To$String(fVector, 0);
    }

    public static CharSequence vector$To$String(FVector fVector, int n) {
        return vectors.vector$To$String(fVector, n, fVector.size());
    }

    public static CharSequence vector$To$String(FVector vec, int start, int end) {
        void i;
        int n = start;
        StringBuilder result = new StringBuilder();
        while (++i < end) {
            Object ch = ((Procedure)vector$Mnref).apply2(vec, (int)i);
            if (ch instanceof Character) {
                result.append(((Character)Promise.force(ch, Character.class)).charValue());
                continue;
            }
            Char.print(((Char)Promise.force(ch, Char.class)).intValue(), result);
        }
        return new FString(result);
    }

    public static FVector string$To$Vector(CharSequence charSequence) {
        return vectors.string$To$Vector(charSequence, 0);
    }

    public static FVector string$To$Vector(CharSequence charSequence, int n) {
        return vectors.string$To$Vector(charSequence, n, charSequence.length());
    }

    public static FVector string$To$Vector(CharSequence str, int start, int end) {
        void i;
        boolean bl = false;
        int n = start;
        Object[] result = new Object[end - start];
        while (++i < end) {
            void j;
            char ch = str.charAt((int)i);
            result[j] = Char.make(ch);
            ++j;
        }
        return new FVector(result);
    }

    public static FVector vectorCopy(FVector fVector) {
        return vectors.vectorCopy(fVector, 0);
    }

    public static FVector vectorCopy(FVector fVector, int n) {
        return vectors.vectorCopy(fVector, n, fVector.size());
    }

    public static FVector vectorCopy(FVector vec, int start, int end) {
        FVector result = new FVector(end - start);
        FVector fVector = vec;
        result.copyFrom(0, fVector, start, end);
        return result;
    }

    public static void vectorCopy$Ex(FVector fVector, int n, FVector fVector2) {
        vectors.vectorCopy$Ex(fVector, n, fVector2, 0);
    }

    public static void vectorCopy$Ex(FVector fVector, int n, FVector fVector2, int n2) {
        vectors.vectorCopy$Ex(fVector, n, fVector2, n2, fVector2.size());
    }

    public static void vectorCopy$Ex(FVector to, int at, FVector from, int start, int end) {
        FVector fVector = from;
        to.copyFrom(at, fVector, start, end);
    }

    public static void vectorFill$Ex(FVector fVector, Object object2) {
        vectors.vectorFill$Ex(fVector, object2, 0);
    }

    public static void vectorFill$Ex(FVector fVector, Object object2, int n) {
        vectors.vectorFill$Ex(fVector, object2, n, fVector.size());
    }

    public static void vectorFill$Ex(FVector vec, Object fill, int start, int end) {
        vec.fill(start, end, fill);
    }

    public static /* varargs */ FVector vectorMap(Procedure proc, Object vec1, Object ... vecs) {
        FVector fVector;
        if (vecs.length == 0) {
            Procedure proc2;
            void vec;
            Procedure procedure;
            Object object2 = vec1;
            Procedure procedure2 = procedure = (proc2 = proc);
            void var7_10 = vec;
            Object object3 = Promise.force(var7_10, SimpleVector.class);
            if (object3 instanceof SimpleVector) {
                SimpleVector simpleVector;
                void vec2;
                SimpleVector simpleVector2 = simpleVector = (SimpleVector)object3;
                Procedure proc3 = procedure2;
                int len = vec2.size();
                Object[] r = new Object[len];
                for (int i2 = 0; i2 != len; ++i2) {
                    r[i2] = proc3.apply1(vec2.get(i2));
                }
                fVector = new FVector(r);
            } else {
                Object[] r = new Object[Sequences.getSize(vec)];
                Iterator it = Sequences.getIterator(vec);
                int i = 0;
                while (it.hasNext()) {
                    r[i] = proc2.apply1(it.next());
                    ++i;
                }
                fVector = new FVector(r);
            }
        } else {
            int i;
            int nargs = vecs.length + 1;
            Iterator[] iterators = new Iterator[nargs];
            Object[] elements = new Object[nargs];
            FVector result = vectors.makeVector(0);
            for (i = 0; i != nargs; ++i) {
                iterators[i] = Sequences.getIterator(i == 0 ? vec1 : vecs[i - 1]);
            }
            block3 : do {
                i = 0;
                do {
                    if (i == nargs) {
                        int vec2 = 0;
                        Object[] len = elements;
                        int r = MakeSplice.count(len);
                        vec2 = r + vec2;
                        Object[] arrobject = new Object[vec2];
                        int i2 = 0;
                        MakeSplice.copyTo(arrobject, i2, r, len);
                        i2 += r;
                        result.add(proc.applyN(arrobject));
                        continue block3;
                    }
                    if (!iterators[i].hasNext()) break block3;
                    elements[i] = iterators[i].next();
                    ++i;
                } while (true);
                break;
            } while (true);
            fVector = result;
        }
        return fVector;
    }

    public static /* varargs */ void vectorForEach(Procedure f, List vec, List ... vecs) {
        ModuleMethod vector$Mnfor$Mneach$Mngeneric = vector$Mnfor$Mneach$Mngeneric$Fn2;
        if (vecs.length == 0) {
            void vec2;
            List list = vec;
            Procedure f2 = f;
            int len = vec2.size();
            for (int i = 0; i != len; ++i) {
                f2.apply1(vec2.get(i));
            }
        } else {
            vectors.lambda1vectorForEachGeneric(f, vec, vecs);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Object lambda1vectorForEachGeneric(Procedure f, List vec, List ... vecs) {
        int len;
        LList ls;
        Object object2;
        block8 : {
            void i;
            int n = vecs.length - 1;
            int n2 = vec.size();
            ls = LList.Empty;
            while (i >= 0) {
                Object[] arrobject = new Object[2];
                arrobject[0] = len;
                List list = vecs[i];
                arrobject[1] = vectors.vectorLength((FVector)list);
                len = ((Number)Promise.force(numbers.min(arrobject))).intValue();
                ls = lists.cons(vecs[--i], ls);
            }
            break block8;
            catch (ClassCastException classCastException) {
                void i2;
                throw new WrongType(classCastException, "vector-length", 0, (Object)i2);
            }
        }
        int i2 = 0;
        while (i2 != len) {
            Object object3 = ls;
            LList lList = LList.Empty;
            Pair pair = null;
            while (object3 != LList.Empty) {
                Pair pair2;
                Pair pair3;
                block9 : {
                    block7 : {
                        pair3 = (Pair)Promise.force(object3, Pair.class);
                        Object object4 = pair3.getCar();
                        object2 = Promise.force(object4, List.class);
                        List v = (List)object2;
                        if (pair != null) break block7;
                        pair2 = new Pair(v.get(i2), LList.Empty);
                        break block9;
                    }
                    pair2 = lList;
                    pair.setCdr(lList);
                }
                pair = pair2;
                object3 = pair3.getCdr();
            }
            ((Procedure)Scheme.apply).apply3(f, vec.get(i2), lList);
            ++i2;
        }
        return Values.empty;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "v", -2, object2);
        }
    }

    public static {
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
        vectors vectors2 = $instance = new vectors();
        vector$Qu = new ModuleMethod(vectors2, 1, Lit1, 4097);
        make$Mnvector = new ModuleMethod(vectors2, 2, Lit2, 8193);
        vector$Mnlength = new ModuleMethod(vectors2, 4, Lit3, 4097);
        vector$Mnset$Ex = new ModuleMethod(vectors2, 5, Lit4, 12291);
        vector$Mnref = new GenericProc("vector-ref");
        vector$Mnref$Fn1 = new ModuleMethod(vectors2, 6, Lit5, 8194);
        vector$Mn$Grlist = new ModuleMethod(vectors2, 7, Lit6, 12289);
        list$Mn$Grvector = new ModuleMethod(vectors2, 10, Lit7, 4097);
        vector$Mn$Grstring = new ModuleMethod(vectors2, 11, Lit8, 12289);
        string$Mn$Grvector = new ModuleMethod(vectors2, 14, Lit9, 12289);
        vector$Mncopy = new ModuleMethod(vectors2, 17, Lit10, 12289);
        vector$Mncopy$Ex = new ModuleMethod(vectors2, 20, Lit11, 20483);
        vector$Mnfill$Ex = new ModuleMethod(vectors2, 23, Lit12, 16386);
        ModuleMethod moduleMethod = new ModuleMethod(vectors2, 26, Lit13, -4094);
        moduleMethod.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:vectorMapValidateApply");
        vector$Mnmap = moduleMethod;
        vector$Mnfor$Mneach$Mngeneric$Fn2 = new ModuleMethod(vectors2, 27, Lit14, -4094);
        ModuleMethod moduleMethod2 = new ModuleMethod(vectors2, 28, Lit15, -4094);
        moduleMethod2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:vectorForEachValidateApply");
        vector$Mnfor$Mneach = moduleMethod2;
        vectors.$runBody$();
    }

    public vectors() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 17: {
                Object object3 = Promise.force(object2, FVector.class);
                if (!(object3 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object4 = Promise.force(object2, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                Object object5 = Promise.force(object2, FVector.class);
                if (!(object5 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                Object object6 = Promise.force(object2, LList.class);
                if (!(object6 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                Object object7 = Promise.force(object2, FVector.class);
                if (!(object7 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object8 = Promise.force(object2, FVector.class);
                if (!(object8 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object8;
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
            case 23: {
                Object object4 = Promise.force(object2, FVector.class);
                if (!(object4 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 17: {
                Object object5 = Promise.force(object2, FVector.class);
                if (!(object5 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 14: {
                Object object6 = Promise.force(object2, CharSequence.class);
                if (!(object6 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 11: {
                Object object7 = Promise.force(object2, FVector.class);
                if (!(object7 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                Object object8 = Promise.force(object2, FVector.class);
                if (!(object8 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 6: {
                Object object9 = Promise.force(object2, FVector.class);
                if (!(object9 instanceof FVector)) {
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
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 23: {
                Object object5 = Promise.force(object2, FVector.class);
                if (!(object5 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 20: {
                Object object6 = Promise.force(object2, FVector.class);
                if (!(object6 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                Object object7 = Promise.force(object4, FVector.class);
                if (!(object7 instanceof FVector)) {
                    return -786429;
                }
                callContext.value3 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 17: {
                Object object8 = Promise.force(object2, FVector.class);
                if (!(object8 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 14: {
                Object object9 = Promise.force(object2, CharSequence.class);
                if (!(object9 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 11: {
                Object object10 = Promise.force(object2, FVector.class);
                if (!(object10 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 7: {
                Object object11 = Promise.force(object2, FVector.class);
                if (!(object11 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 5: {
                Object object12 = Promise.force(object2, FVector.class);
                if (!(object12 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 23: {
                Object object6 = Promise.force(object2, FVector.class);
                if (!(object6 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 20: {
                Object object7 = Promise.force(object2, FVector.class);
                if (!(object7 instanceof FVector)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = Promise.force(object3);
                Object object8 = Promise.force(object4, FVector.class);
                if (!(object8 instanceof FVector)) {
                    return -786429;
                }
                callContext.value3 = object8;
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
            case 28: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 27: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 26: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 20: {
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
                if (vectors.isVector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                return vectors.makeVector(((Number)Promise.force(object2)).intValue());
            }
            case 4: {
                return vectors.vectorLength((FVector)Promise.force(object2, FVector.class));
            }
            case 7: {
                return vectors.vector$To$List((FVector)Promise.force(object2, FVector.class));
            }
            case 10: {
                return vectors.list$To$Vector((LList)Promise.force(object2, LList.class));
            }
            case 11: {
                return vectors.vector$To$String((FVector)Promise.force(object2, FVector.class));
            }
            case 14: {
                return vectors.string$To$Vector((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 17: {
                return vectors.vectorCopy((FVector)Promise.force(object2, FVector.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "vector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "vector->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "vector->string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string->vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "vector-copy", 1, object2);
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

