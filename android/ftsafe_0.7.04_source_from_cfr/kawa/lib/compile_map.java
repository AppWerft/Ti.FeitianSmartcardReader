/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.Invoke;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import java.util.List;
import java.util.RandomAccess;
import kawa.lib.ArrayScanner;
import kawa.lib.IterableScanner;
import kawa.lib.ListMapHelper;
import kawa.lib.ListScanner;
import kawa.lib.MapHelper;
import kawa.lib.ScanHelper;
import kawa.lib.StringScanner;
import kawa.lib.VectorScanner;
import kawa.lib.kawa.expressions;
import kawa.lib.kawa.string-cursors;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class compile_map
extends ModuleBody {
    public static final Class Convert;
    public static final Class FVector;
    public static final Class ScanHelper;
    public static final ModuleMethod scanner$Mnfor;
    public static final Class MapHelper;
    public static final ModuleMethod stringCursorForEachValidateApply;
    public static final ModuleMethod stringForEach1ValidateApply;
    public static final Class StringScanner;
    public static final ModuleMethod stringForEachValidateApply;
    public static final Class IterableScanner;
    public static final Class ListScanner;
    public static final Class ListMapHelper;
    public static final ModuleMethod listForEachValidateApply;
    public static final ModuleMethod listMapValidateApply;
    public static final Class ArrayScanner;
    public static final Class VectorScanner;
    public static final ModuleMethod vectorForEachValidateApply;
    public static final ModuleMethod vectorMapValidateApply;
    public static final ModuleMethod validate$Mngeneric$Mnfor$Mneach;
    static final Class Lit0;
    static final Class Lit1;
    static final Class Lit2;
    static final Class Lit3;
    static final IntNum Lit4;
    static final IntNum Lit5;
    static final IntNum Lit6;
    static final IntNum Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final Class Lit11;
    static final SimpleSymbol Lit12;
    static final ClassType Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final Class Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final ClassType Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    public static compile_map $instance;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static ScanHelper scannerFor(Expression exp, Type etype, Compilation comp) {
        ScanHelper scanHelper;
        Type stype = exp.getType();
        if (stype.isSubtype(LangObjType.listType)) {
            scanHelper = new ListScanner();
            new ListScanner().comp = comp;
        } else {
            Type type = stype;
            if (type instanceof ArrayType) {
                ArrayType arrayType = (ArrayType)type;
                Type etype2 = arrayType.getComponentType();
                new ArrayScanner().comp = comp;
                scanHelper = new ArrayScanner();
                new ArrayScanner().elementType = etype2;
            } else if (stype.isSubtype(Type.make(Lit0))) {
                scanHelper = new StringScanner();
                new StringScanner().comp = comp;
            } else if (stype.isSubtype(Type.make(Lit1)) && stype.isSubtype(Type.make(Lit2))) {
                scanHelper = new VectorScanner();
                new VectorScanner().comp = comp;
            } else if (stype.isSubtype(Type.make(Lit3))) {
                new IterableScanner().comp = comp;
                scanHelper = new IterableScanner();
                new IterableScanner().useGeneric = false;
            } else {
                new IterableScanner().comp = comp;
                scanHelper = new IterableScanner();
                new IterableScanner().useGeneric = true;
            }
        }
        return scanHelper;
    }

    public static Expression stringCursorForEachValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression ex;
        Expression expression;
        Expression expression2;
        if (exp.isSimple(2, 4)) {
            void comp;
            Compilation compilation = expressions.getCompilation();
            Expression func = exp.getArg(0);
            comp.letStart();
            Declaration seqDecl = comp.letVariable(null, LangObjType.stringType, exp.getArg(1));
            Declaration idxDecl = comp.letVariable(null, LangPrimType.stringCursorType, exp.getArgCount() > 2 ? exp.getArg(2) : expressions.applyExp$V(Convert.as, new Object[]{LangPrimType.stringCursorType, Lit4}));
            Declaration endDecl = comp.letVariable(null, LangPrimType.stringCursorType, exp.getArgCount() > 3 ? exp.getArg(3) : expressions.applyExp$V(string-cursors.string$Mncursor$Mnend, new Object[]{seqDecl}));
            comp.letEnter();
            LambdaExp loopLambda = comp.loopStart();
            comp.loopEnter();
            comp.letStart();
            Declaration chDecl = comp.letVariable(null, LangPrimType.characterType, expressions.applyExp$V(string-cursors.string$Mncursor$Mnref, new Object[]{seqDecl, idxDecl}));
            comp.letEnter();
            expression = comp.letDone(comp.loopDone(expressions.ifExp(expressions.applyExp$V(string-cursors.string$Mncursor$Ls$Qu, new Object[]{idxDecl, endDecl}), comp.letDone(expressions.beginExp$V(new Object[]{expressions.applyExp$V(func, new Object[]{chDecl}), expressions.setExp(idxDecl, expressions.applyExp$V(Convert.as, new Object[]{LangPrimType.stringCursorType, expressions.applyExp$V(AddOp.$Pl, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Type.int_type, idxDecl}), expressions.ifExp(expressions.applyExp$V(Scheme.numGrt, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Type.int_type, chDecl}), Lit5}), Lit6, Lit7)})})), comp.loopRepeat(loopLambda, new Expression[0])})))));
        } else {
            expression = ex = null;
        }
        if (ex == null) {
            expression2 = null;
        } else if (ex == exp) {
            exp.visitArgs(visitor);
            expression2 = exp;
        } else {
            expression2 = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return expression2;
    }

    public static Expression stringForEach1ValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        Expression expression2;
        ApplyExp ex;
        if (exp.isSimple(2, 2)) {
            expression = expressions.applyExp$V(string-cursors.string$Mncursor$Mnfor$Mneach, new Object[]{exp.getArg(0), exp.getArg(1)});
        } else if (exp.isSimple(3, 4)) {
            Compilation comp = expressions.getCompilation();
            comp.letStart();
            Declaration decl1 = comp.letVariable(null, LangObjType.stringType, exp.getArg(1));
            Declaration decl2 = comp.letVariable(null, Type.int_type, exp.getArg(2));
            comp.letEnter();
            Object[] arrobject = new Object[4];
            arrobject[0] = exp.getArg(0);
            arrobject[1] = decl1;
            arrobject[2] = expressions.applyExp$V(string-cursors.string$Mncursor$Mnnext, new Object[]{decl1, expressions.applyExp$V(Convert.as, new Object[]{LangPrimType.stringCursorType, Lit4}), decl2});
            arrobject[3] = exp.getArgCount() < 4 ? expressions.applyExp$V(string-cursors.string$Mncursor$Mnend, new Object[]{decl1}) : expressions.applyExp$V(string-cursors.string$Mncursor$Mnnext, new Object[]{decl1, expressions.applyExp$V(Convert.as, new Object[]{LangPrimType.stringCursorType, Lit4}), exp.getArg(3)});
            expression = comp.letDone(expressions.applyExp$V(string-cursors.string$Mncursor$Mnfor$Mneach, arrobject));
        } else {
            expression = ex = null;
        }
        if (ex == null) {
            expression2 = null;
        } else if (ex == exp) {
            exp.visitArgs(visitor);
            expression2 = exp;
        } else {
            expression2 = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return expression2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Expression stringForEachValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        if (!exp.isSimple(3, 4)) ** GOTO lbl-1000
        e2 = expressions.visitExp(exp.getArg(2));
        exp.setArg(2, e2);
        t2 = e2.getType();
        integer$Mncompat = LangObjType.integerType.isCompatibleWithValue(t2);
        v0 = x = integer$Mncompat > 0;
        if (x != false ? x != false : integer$Mncompat >= 0 && LangObjType.stringType.isCompatibleWithValue(t2) < 0) {
            var9_12 = 4;
            var10_15 = exp.getArg(0);
            var11_17 = exp.getArg(1);
            var12_18 = exp.getArg(2);
            var13_19 = exp.getArgCount() == 4 ? FVector.makeConstant(new Object[]{exp.getArg(3)}) : FVector.makeConstant(new Object[0]);
            var14_20 = MakeSplice.count(var13_19);
            var9_12 = var14_20 + var9_12;
            v1 = new Object[var9_12];
            v1[0] = strings.srfi$Mn13$Mnstring$Mnfor$Mneach;
            v1[1] = var10_15;
            v1[2] = var11_17;
            v1[3] = var12_18;
            var15_21 = 4;
            MakeSplice.copyTo(v1, var15_21, var14_20, var13_19);
            var15_21 += var14_20;
            var9_13 = Promise.force(expressions.apply$Mnexp.applyN(v1), Expression.class);
            v2 = (Expression)var9_13;
        } else lbl-1000: // 2 sources:
        {
            if (exp.isSimple(2) == false) return null;
            v3 = x = exp.getArgCount() == 2;
            if (x) {
                if (x == false) return null;
            } else {
                v4 = x = exp.getArgCount() > 4;
                if (x) {
                    if (x == false) return null;
                } else {
                    e2 = expressions.visitExp(exp.getArg(2));
                    exp.setArg(2, e2);
                    t2 = e2.getType();
                    string$Mncompat = LangObjType.stringType.isCompatibleWithValue(t2);
                    v5 = x = string$Mncompat > 0;
                    if (x) {
                        if (x == false) return null;
                    } else {
                        if (string$Mncompat < 0) return null;
                        if (LangObjType.integerType.isCompatibleWithValue(t2) >= 0) return null;
                    }
                }
            }
            exp.getArgCount();
            expressions.getCompilation();
            v2 = compile_map.validateGenericForEach(exp, required, new 0());
        }
        ex = v2;
        if (ex == null) {
            return null;
        }
        if (ex == exp) {
            exp.visitArgs(visitor);
            v6 /* !! */  = exp;
            return v6 /* !! */ ;
        }
        v6 /* !! */  = visitor.visit(ex.maybeSetLine(exp), required);
        return v6 /* !! */ ;
        catch (ClassCastException v7) {
            throw new WrongType(v7, "ex", -2, (Object)string$Mncompat);
        }
    }

    public static LetExp validateGenericForEach(ApplyExp exp, Type required, MapHelper helper) {
        Object arg;
        int i;
        void n;
        void comp;
        public class Frame
        extends ModuleBody {
            Expression func;
            MapHelper helper;

            /*
             * Exception decompiling
             */
            public Object lambda1loop(Object loopLambda, Object comp, Object n, int i, Object chlist) {
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
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                // org.benf.cfr.reader.Main.main(Main.java:48)
                throw new IllegalStateException("Decompilation failed");
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.helper = helper;
        int n2 = exp.getArgCount() - 1;
        Compilation compilation = expressions.getCompilation();
        $heapFrame.func = exp.getArg(0);
        comp.letStart();
        $heapFrame.helper.comp = comp;
        $heapFrame.helper.scanners = new ScanHelper[n];
        for (i = 0; i != n; ++i) {
            $heapFrame.helper.scanners[i] = $heapFrame.helper.makeScanner(exp.getArg(i + 1), null);
        }
        if ($heapFrame.func.side_effects()) {
            $heapFrame.func = new ReferenceExp(comp.letVariable(null, null, $heapFrame.func));
        }
        for (i = 1; i <= n; ++i) {
            arg = expressions.visitExp(exp.getArg(i));
            exp.setArg(i, (Expression)arg);
            $heapFrame.helper.scanners[i - 1].init((Expression)arg);
        }
        $heapFrame.helper.initialize(exp, (Compilation)comp);
        comp.letEnter();
        LambdaExp loopLambda = comp.loopStart();
        comp.loopEnter();
        arg = Promise.force($heapFrame.lambda1loop(loopLambda, comp, (int)n, 0, LList.Empty), Expression.class);
        try {
            return comp.letDone($heapFrame.helper.collectResult(comp.loopDone((Expression)arg)));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Compilation.loopDone(gnu.expr.Expression)", 2, arg);
        }
    }

    public static Expression listForEachValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        LetExp ex;
        LetExp letExp = ex = exp.isSimple(2) ? compile_map.validateGenericForEach(exp, required, new ListMapHelper()) : null;
        if (ex == null) {
            expression = null;
        } else if (ex == exp) {
            exp.visitArgs(visitor);
            expression = exp;
        } else {
            expression = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return expression;
    }

    public static Expression listMapValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        LetExp letExp;
        Expression expression;
        LetExp ex;
        if (exp.isSimple(2)) {
            new ListMapHelper().collecting = true;
            letExp = compile_map.validateGenericForEach(exp, required, new ListMapHelper());
        } else {
            letExp = ex = null;
        }
        if (ex == null) {
            expression = null;
        } else if (ex == exp) {
            exp.visitArgs(visitor);
            expression = exp;
        } else {
            expression = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return expression;
    }

    public static Expression vectorForEachValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        LetExp ex;
        public class Kawa_lib_compile_map$1
        extends MapHelper {
            public ScanHelper makeScanner(Expression exp, Type etype) {
                new VectorScanner().comp = this.comp;
                return new VectorScanner();
            }
        }
        LetExp letExp = ex = exp.isSimple(2) ? compile_map.validateGenericForEach(exp, required, new Kawa_lib_compile_map$1()) : null;
        if (ex == null) {
            expression = null;
        } else if (ex == exp) {
            exp.visitArgs(visitor);
            expression = exp;
        } else {
            expression = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return expression;
    }

    public static Expression vectorMapValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        LetExp ex;
        public class Kawa_lib_compile_map$2
        extends MapHelper {
            public Declaration idxDecl;
            public Declaration resultDecl;

            public ScanHelper makeScanner(Expression exp, Type etype) {
                return compile_map.scannerFor(exp, etype, this.comp);
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void initialize(ApplyExp exp, Compilation comp) {
                Object object3;
                Object object2;
                if (this.scanners.length == 1 && (object3 = this.scanners[0]) instanceof VectorScanner) {
                    VectorScanner vectorScanner = (VectorScanner)object3;
                    this.idxDecl = vectorScanner.idxDecl;
                    object2 = Promise.force(expressions.applyToArgsExp$V(compile_map.FVector, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Type.int_type, vectorScanner.endDecl})}), Expression.class);
                    this.resultDecl = comp.letVariable(null, Type.make(compile_map.FVector), (Expression)object2);
                    return;
                }
                object3 = Promise.force(expressions.applyToArgsExp$V(compile_map.FVector, new Object[0]), Expression.class);
                try {
                    this.resultDecl = comp.letVariable(null, Type.make(compile_map.FVector), (Expression)object3);
                    return;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "gnu.expr.Compilation.letVariable(java.lang.Object,type,gnu.expr.Expression)", 4, object3);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "gnu.expr.Compilation.letVariable(java.lang.Object,type,gnu.expr.Expression)", 4, object2);
                }
            }

            public Expression doCollect(Expression value) {
                return this.idxDecl != null ? expressions.applyExp$V(Invoke.invoke, new Object[]{this.resultDecl, compile_map.Lit8, this.idxDecl, value}) : expressions.applyExp$V(Invoke.invoke, new Object[]{this.resultDecl, compile_map.Lit9, value});
            }

            public Expression collectResult(Expression result) {
                return expressions.beginExp$V(new Object[]{result, this.resultDecl});
            }
        }
        LetExp letExp = ex = exp.isSimple(2) ? compile_map.validateGenericForEach(exp, required, new Kawa_lib_compile_map$2()) : null;
        if (ex == null) {
            expression = null;
        } else if (ex == exp) {
            exp.visitArgs(visitor);
            expression = exp;
        } else {
            expression = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return expression;
    }

    public static {
        Lit32 = Symbol.valueOf("validate-generic-for-each");
        Lit31 = Symbol.valueOf("vectorMapValidateApply");
        Lit30 = Symbol.valueOf("vectorForEachValidateApply");
        Lit29 = Symbol.valueOf("listMapValidateApply");
        Lit28 = Symbol.valueOf("listForEachValidateApply");
        Lit27 = Symbol.valueOf("stringForEachValidateApply");
        Lit26 = Symbol.valueOf("stringForEach1ValidateApply");
        Lit25 = Symbol.valueOf("stringCursorForEachValidateApply");
        Lit24 = Symbol.valueOf("scanner-for");
        Lit23 = Symbol.valueOf("get");
        Lit22 = Symbol.valueOf("size");
        Lit21 = Symbol.valueOf("setCdr");
        Lit20 = ClassType.make("gnu.lists.Pair");
        Lit19 = Symbol.valueOf("getCdr");
        Lit18 = Symbol.valueOf("getCar");
        Lit17 = Pair.class;
        Lit16 = Symbol.valueOf("next");
        Lit15 = Symbol.valueOf("hasNext");
        Lit14 = Symbol.valueOf("iterator");
        Lit13 = ClassType.make("java.util.Iterator");
        Lit12 = Symbol.valueOf("getIterator");
        Lit11 = Sequences.class;
        Lit10 = Symbol.valueOf("length");
        Lit9 = Symbol.valueOf("add");
        Lit8 = Symbol.valueOf("set");
        Lit7 = IntNum.valueOf(1);
        Lit6 = IntNum.valueOf(2);
        Lit5 = IntNum.valueOf(65535);
        Lit4 = IntNum.valueOf(0);
        Lit3 = Iterable.class;
        Lit2 = RandomAccess.class;
        Lit1 = List.class;
        Lit0 = CharSequence.class;
        FVector = FVector.class;
        Convert = Convert.class;
        $instance = new compile_map();
        ScanHelper = ScanHelper.class;
        compile_map compile_map2 = $instance;
        scanner$Mnfor = new ModuleMethod(compile_map2, 1, Lit24, 12291);
        MapHelper = MapHelper.class;
        stringCursorForEachValidateApply = new ModuleMethod(compile_map2, 2, Lit25, 16388);
        stringForEach1ValidateApply = new ModuleMethod(compile_map2, 3, Lit26, 16388);
        StringScanner = StringScanner.class;
        stringForEachValidateApply = new ModuleMethod(compile_map2, 4, Lit27, 16388);
        IterableScanner = IterableScanner.class;
        ListScanner = ListScanner.class;
        ListMapHelper = ListMapHelper.class;
        listForEachValidateApply = new ModuleMethod(compile_map2, 5, Lit28, 16388);
        listMapValidateApply = new ModuleMethod(compile_map2, 6, Lit29, 16388);
        ArrayScanner = ArrayScanner.class;
        VectorScanner = VectorScanner.class;
        vectorForEachValidateApply = new ModuleMethod(compile_map2, 7, Lit30, 16388);
        vectorMapValidateApply = new ModuleMethod(compile_map2, 8, Lit31, 16388);
        validate$Mngeneric$Mnfor$Mneach = new ModuleMethod(compile_map2, 9, Lit32, 12291);
        compile_map.$runBody$();
    }

    public compile_map() {
        ModuleInfo.register(this);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 9: {
                Object object5 = Promise.force(object2, ApplyExp.class);
                if (!(object5 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3, Type.class);
                if (!(object6 instanceof Type)) {
                    return -786430;
                }
                callContext.value2 = object6;
                Object object7 = Promise.force(object4, MapHelper.class);
                if (!(object7 instanceof MapHelper)) {
                    return -786429;
                }
                callContext.value3 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 1: {
                Object object8 = Promise.force(object2, Expression.class);
                if (!(object8 instanceof Expression)) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3, Type.class);
                if (LangObjType.coerceToTypeOrNull(object9) == null) {
                    return -786430;
                }
                callContext.value2 = object9;
                Object object10 = Promise.force(object4, Compilation.class);
                if (!(object10 instanceof Compilation)) {
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

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 8: {
                Object object6 = Promise.force(object2, ApplyExp.class);
                if (!(object6 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, InlineCalls.class);
                if (!(object7 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object7;
                Object object8 = Promise.force(object4, Type.class);
                if (!(object8 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object8;
                Object object9 = Promise.force(object5, Procedure.class);
                if (!(object9 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 7: {
                Object object10 = Promise.force(object2, ApplyExp.class);
                if (!(object10 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object10;
                Object object11 = Promise.force(object3, InlineCalls.class);
                if (!(object11 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object11;
                Object object12 = Promise.force(object4, Type.class);
                if (!(object12 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object12;
                Object object13 = Promise.force(object5, Procedure.class);
                if (!(object13 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 6: {
                Object object14 = Promise.force(object2, ApplyExp.class);
                if (!(object14 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object14;
                Object object15 = Promise.force(object3, InlineCalls.class);
                if (!(object15 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object15;
                Object object16 = Promise.force(object4, Type.class);
                if (!(object16 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object16;
                Object object17 = Promise.force(object5, Procedure.class);
                if (!(object17 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 5: {
                Object object18 = Promise.force(object2, ApplyExp.class);
                if (!(object18 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object18;
                Object object19 = Promise.force(object3, InlineCalls.class);
                if (!(object19 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object19;
                Object object20 = Promise.force(object4, Type.class);
                if (!(object20 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object20;
                Object object21 = Promise.force(object5, Procedure.class);
                if (!(object21 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 4: {
                Object object22 = Promise.force(object2, ApplyExp.class);
                if (!(object22 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object22;
                Object object23 = Promise.force(object3, InlineCalls.class);
                if (!(object23 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object23;
                Object object24 = Promise.force(object4, Type.class);
                if (!(object24 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object24;
                Object object25 = Promise.force(object5, Procedure.class);
                if (!(object25 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 3: {
                Object object26 = Promise.force(object2, ApplyExp.class);
                if (!(object26 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object26;
                Object object27 = Promise.force(object3, InlineCalls.class);
                if (!(object27 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object27;
                Object object28 = Promise.force(object4, Type.class);
                if (!(object28 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object28;
                Object object29 = Promise.force(object5, Procedure.class);
                if (!(object29 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object29;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 2: {
                Object object30 = Promise.force(object2, ApplyExp.class);
                if (!(object30 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object30;
                Object object31 = Promise.force(object3, InlineCalls.class);
                if (!(object31 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object31;
                Object object32 = Promise.force(object4, Type.class);
                if (!(object32 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object32;
                Object object33 = Promise.force(object5, Procedure.class);
                if (!(object33 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object33;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
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

}

