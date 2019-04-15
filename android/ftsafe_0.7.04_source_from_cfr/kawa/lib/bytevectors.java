/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.ByteVector;
import gnu.lists.Consumer;
import gnu.lists.U8Vector;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;

public class bytevectors
extends ModuleBody {
    public static final ModuleMethod bytevector$Qu;
    public static final ModuleMethod make$Mnbytevector;
    public static final ModuleMethod bytevector$Mnlength;
    public static final ModuleMethod bytevector$Mnu8$Mnref;
    public static final ModuleMethod bytevector$Mnu8$Mnset$Ex;
    public static final ModuleMethod bytevector$Mncopy;
    public static final ModuleMethod bytevector$Mncopy$Ex;
    public static final ModuleMethod bytevector$Mnappend;
    public static final ModuleMethod utf8$Mn$Grstring;
    public static final ModuleMethod string$Mn$Grutf8;
    public static bytevectors $instance;
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

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean isBytevector(Object x) {
        return x instanceof U8Vector;
    }

    public static U8Vector makeBytevector(int n) {
        return bytevectors.makeBytevector(n, 0);
    }

    public static U8Vector makeBytevector(int n, int init) {
        return new U8Vector(n, (byte)init);
    }

    public static int bytevectorLength(U8Vector v) {
        return v.size();
    }

    public static int bytevectorU8Ref(U8Vector v, int i) {
        return v.getInt(i);
    }

    public static void bytevectorU8Set$Ex(U8Vector v, int i, int x) {
        v.setByte(i, (byte)x);
    }

    public static U8Vector bytevectorCopy(U8Vector u8Vector) {
        return bytevectors.bytevectorCopy(u8Vector, 0);
    }

    public static U8Vector bytevectorCopy(U8Vector u8Vector, int n) {
        return bytevectors.bytevectorCopy(u8Vector, n, u8Vector.size());
    }

    public static U8Vector bytevectorCopy(U8Vector v, int start, int end) {
        U8Vector result = new U8Vector(end - start);
        result.copyFrom(0, v, start, end);
        return result;
    }

    public static void bytevectorCopy$Ex(U8Vector u8Vector, int n, U8Vector u8Vector2) {
        bytevectors.bytevectorCopy$Ex(u8Vector, n, u8Vector2, 0);
    }

    public static void bytevectorCopy$Ex(U8Vector u8Vector, int n, U8Vector u8Vector2, int n2) {
        bytevectors.bytevectorCopy$Ex(u8Vector, n, u8Vector2, n2, u8Vector2.size());
    }

    public static void bytevectorCopy$Ex(U8Vector to, int at, U8Vector from, int start, int end) {
        to.copyFrom(at, from, start, end);
    }

    public static /* varargs */ Object bytevectorAppend(U8Vector ... bvs) {
        void sz;
        int nbvs = bvs.length;
        boolean bl = false;
        for (int i = 0; i < nbvs; ++i) {
            sz += bvs[i].size();
        }
        void size = sz;
        U8Vector result = new U8Vector((int)size);
        boolean bl2 = false;
        for (int i = 0; i < nbvs; ++i) {
            void off;
            U8Vector bv = bvs[i];
            int bvlength = bv.size();
            result.copyFrom((int)off, bv, 0, bvlength);
            off += bvlength;
        }
        return result;
    }

    public static CharSequence utf8$To$String(U8Vector u8Vector) {
        return bytevectors.utf8$To$String(u8Vector, 0);
    }

    public static CharSequence utf8$To$String(U8Vector u8Vector, int n) {
        return bytevectors.utf8$To$String(u8Vector, n, u8Vector.size());
    }

    public static CharSequence utf8$To$String(U8Vector v, int start, int end) {
        return v.toUtf8(start, end - start);
    }

    public static U8Vector string$To$Utf8(CharSequence charSequence) {
        return bytevectors.string$To$Utf8(charSequence, 0);
    }

    public static U8Vector string$To$Utf8(CharSequence charSequence, int n) {
        return bytevectors.string$To$Utf8(charSequence, n, charSequence.length());
    }

    public static U8Vector string$To$Utf8(CharSequence v, int start, int end) {
        return new U8Vector(v.toString().substring(start, end).getBytes("UTF-8"));
    }

    public static {
        Lit9 = Symbol.valueOf("string->utf8");
        Lit8 = Symbol.valueOf("utf8->string");
        Lit7 = Symbol.valueOf("bytevector-append");
        Lit6 = Symbol.valueOf("bytevector-copy!");
        Lit5 = Symbol.valueOf("bytevector-copy");
        Lit4 = Symbol.valueOf("bytevector-u8-set!");
        Lit3 = Symbol.valueOf("bytevector-u8-ref");
        Lit2 = Symbol.valueOf("bytevector-length");
        Lit1 = Symbol.valueOf("make-bytevector");
        Lit0 = Symbol.valueOf("bytevector?");
        bytevectors bytevectors2 = $instance = new bytevectors();
        bytevector$Qu = new ModuleMethod(bytevectors2, 1, Lit0, 4097);
        make$Mnbytevector = new ModuleMethod(bytevectors2, 2, Lit1, 8193);
        bytevector$Mnlength = new ModuleMethod(bytevectors2, 4, Lit2, 4097);
        bytevector$Mnu8$Mnref = new ModuleMethod(bytevectors2, 5, Lit3, 8194);
        bytevector$Mnu8$Mnset$Ex = new ModuleMethod(bytevectors2, 6, Lit4, 12291);
        bytevector$Mncopy = new ModuleMethod(bytevectors2, 7, Lit5, 12289);
        bytevector$Mncopy$Ex = new ModuleMethod(bytevectors2, 10, Lit6, 20483);
        bytevector$Mnappend = new ModuleMethod(bytevectors2, 13, Lit7, -4096);
        utf8$Mn$Grstring = new ModuleMethod(bytevectors2, 14, Lit8, 12289);
        string$Mn$Grutf8 = new ModuleMethod(bytevectors2, 17, Lit9, 12289);
        bytevectors.$runBody$();
    }

    public bytevectors() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 17: {
                Object object3 = Promise.force(object2, CharSequence.class);
                if (!(object3 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object4 = Promise.force(object2, U8Vector.class);
                if (!(object4 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                Object object5 = Promise.force(object2, U8Vector.class);
                if (!(object5 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object6 = Promise.force(object2, U8Vector.class);
                if (!(object6 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object6;
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
            case 17: {
                Object object4 = Promise.force(object2, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 14: {
                Object object5 = Promise.force(object2, U8Vector.class);
                if (!(object5 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                Object object6 = Promise.force(object2, U8Vector.class);
                if (!(object6 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 5: {
                Object object7 = Promise.force(object2, U8Vector.class);
                if (!(object7 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object7;
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
            case 17: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 14: {
                Object object6 = Promise.force(object2, U8Vector.class);
                if (!(object6 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 10: {
                Object object7 = Promise.force(object2, U8Vector.class);
                if (!(object7 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = Promise.force(object3);
                Object object8 = Promise.force(object4, U8Vector.class);
                if (!(object8 instanceof U8Vector)) {
                    return -786429;
                }
                callContext.value3 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 7: {
                Object object9 = Promise.force(object2, U8Vector.class);
                if (!(object9 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 6: {
                Object object10 = Promise.force(object2, U8Vector.class);
                if (!(object10 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        if (moduleMethod.selector == 10) {
            Object object6 = Promise.force(object2, U8Vector.class);
            if (!(object6 instanceof U8Vector)) {
                return -786431;
            }
            callContext.value1 = object6;
            callContext.value2 = Promise.force(object3);
            Object object7 = Promise.force(object4, U8Vector.class);
            if (!(object7 instanceof U8Vector)) {
                return -786429;
            }
            callContext.value3 = object7;
            callContext.value4 = Promise.force(object5);
            callContext.proc = moduleMethod;
            callContext.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 13: {
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
                if (bytevectors.isBytevector(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                return bytevectors.makeBytevector(((Number)Promise.force(object2)).intValue());
            }
            case 4: {
                return bytevectors.bytevectorLength(LangObjType.coerceToU8Vector(Promise.force(object2, U8Vector.class)));
            }
            case 7: {
                return bytevectors.bytevectorCopy(LangObjType.coerceToU8Vector(Promise.force(object2, U8Vector.class)));
            }
            case 14: {
                return bytevectors.utf8$To$String(LangObjType.coerceToU8Vector(Promise.force(object2, U8Vector.class)));
            }
            case 17: {
                return bytevectors.string$To$Utf8((CharSequence)Promise.force(object2, CharSequence.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-bytevector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "bytevector-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "bytevector-copy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "utf8->string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string->utf8", 1, object2);
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object applyN(ModuleMethod var1_1, Object[] var2_2) {
        switch (var1_1.selector) {
            case 10: {
                var3_3 = var2_2.length - 3;
                var4_4 = Promise.force(var2_2[0], U8Vector.class);
                v0 = LangObjType.coerceToU8Vector(var4_4);
                var4_4 = Promise.force(var2_2[1]);
                v1 = ((Number)var4_4).intValue();
                var4_4 = Promise.force(var2_2[2], U8Vector.class);
                v2 = LangObjType.coerceToU8Vector(var4_4);
                if (var3_3 > 0) ** GOTO lbl16
                bytevectors.bytevectorCopy$Ex(v0, v1, v2);
                return Values.empty;
lbl16: // 1 sources:
                --var3_3;
                var4_4 = Promise.force(var2_2[3]);
                v3 = ((Number)var4_4).intValue();
                if (var3_3 > 0) ** GOTO lbl23
                bytevectors.bytevectorCopy$Ex(v0, v1, v2, v3);
                return Values.empty;
lbl23: // 1 sources:
                --var3_3;
                var4_4 = Promise.force(var2_2[4]);
                bytevectors.bytevectorCopy$Ex(v0, v1, v2, v3, ((Number)var4_4).intValue());
                return Values.empty;
            }
            case 13: {
                var4_5 = var2_2.length;
                v4 = new U8Vector[var4_5];
                do {
                    if (--var4_5 < 0) {
                        return bytevectors.bytevectorAppend(v4);
                    }
                    v4 = v4;
                    var5_6 = var2_2[var4_5];
                    v4[var4_5] = LangObjType.coerceToU8Vector(var5_6);
                    continue;
                    break;
                } while (true);
            }
        }
        return super.applyN(var1_1, var2_2);
        catch (ClassCastException v5) {
            throw new WrongType(v5, "bytevector-copy!", 1, var4_4);
        }
        catch (ClassCastException v6) {
            throw new WrongType(v6, "bytevector-copy!", 2, var4_4);
        }
        catch (ClassCastException v7) {
            throw new WrongType(v7, "bytevector-copy!", 3, var4_4);
        }
        catch (ClassCastException v8) {
            throw new WrongType(v8, "bytevector-copy!", 4, var4_4);
        }
        catch (ClassCastException v9) {
            throw new WrongType(v9, "bytevector-copy!", 5, var4_4);
        }
        catch (ClassCastException v10) {
            throw new WrongType(v10, "bytevector-append", 0, var5_6);
        }
    }
}

