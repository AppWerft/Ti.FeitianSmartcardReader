/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.LetExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.RunProcess;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.LazyType;
import gnu.kawa.reflect.MultValuesType;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.Throw;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.EofClass;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.SourceLocator;
import java.util.List;
import kawa.lib.ExceptionWithValue;
import kawa.lib.characters;
import kawa.lib.kawa.expressions;
import kawa.lib.lists;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class compile_misc
extends ModuleBody {
    public static final Class MultValuesType;
    public static final Class OccurrenceType;
    public static final ModuleMethod pipeProcessValidateApply;
    public static final ModuleMethod charToIntegerValidateApply;
    public static final ModuleMethod integerToCharValidateApply;
    public static final ModuleMethod isEofValidateApply;
    public static final ModuleMethod charCompareValidateApply;
    public static final ModuleMethod stringCursorCompareValidateApply;
    public static final ModuleMethod stringAppendToValidateApply;
    public static final ModuleMethod valuesValidateApply;
    public static final ModuleMethod raiseValidateApply;
    public static final ModuleMethod valuesCompile;
    public static final ModuleMethod lengthValidateApply;
    static final Keyword Lit0;
    static final IntNum Lit1;
    static final Class Lit2;
    static final SimpleSymbol Lit3;
    static final Class Lit4;
    static final SimpleSymbol Lit5;
    static final Class Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final Class Lit9;
    static final ClassType Lit10;
    static final SimpleSymbol Lit11;
    static final Class Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final Class Lit15;
    static final SimpleSymbol Lit16;
    public static compile_misc $instance;
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

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Expression pipeProcessValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        void e1;
        ApplyExp applyExp;
        Expression expression;
        Expression expression2;
        Expression[] aeargs;
        if (exp.getArgCount() != 2) return null;
        exp.visitArgs(expressions.getVisitor());
        Expression expression3 = exp.getArg(0);
        Expression expression4 = exp.getArg(1);
        InlineCalls visitor2 = expressions.getVisitor();
        void var8_7 = e1;
        if (var8_7 instanceof ApplyExp && (applyExp = (ApplyExp)var8_7).getFunction().valueIfConstant() == RunProcess.instance) {
            void e0;
            void var11_9 = e1;
            ApplyExp ae1 = (ApplyExp)var11_9;
            aeargs = ae1.getArgs();
            int n = 2;
            Expression[] arrexpression = aeargs;
            int n2 = MakeSplice.count(arrexpression);
            n = n2 + n;
            Object[] arrobject = new Object[n];
            arrobject[0] = Lit0;
            arrobject[1] = e0;
            int n3 = 2;
            MakeSplice.copyTo(arrobject, n3, n2, arrexpression);
            n3 += n2;
            expression2 = expressions.applyExp$V(ae1.getFunction(), arrobject);
        } else {
            expression2 = visitor2.error('e', "pipe-process arg not run-process", (SourceLocator)e1);
        }
        Expression ex = expression2;
        if (ex == null) {
            return null;
        }
        if (ex == exp) {
            exp.visitArgs(visitor);
            expression = exp;
            return expression;
        }
        expression = visitor.visit(ex.maybeSetLine(exp), required);
        return expression;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "ae1", -2, (Object)aeargs);
        }
    }

    public static Expression charToIntegerValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        Expression expression2;
        Expression ex;
        if (exp.isSimple(1, 1)) {
            Expression e0 = expressions.visitExp(exp.getArg(0), LangPrimType.characterType);
            expression = expressions.applyExp$V(Convert.as, new Object[]{Type.int_type, expressions.applyExp$V(Convert.cast, new Object[]{LangPrimType.characterType, e0})});
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

    public static Expression integerToCharValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        Expression ex;
        Expression expression2 = exp.isSimple(1, 1) ? expressions.applyExp$V(Convert.as, new Object[]{LangPrimType.characterType, expressions.applyExp$V(Convert.cast, new Object[]{Type.int_type, exp.getArg(0)})}) : (ex = null);
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

    public static Expression isEofValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        Expression expression2;
        Expression ex;
        if (exp.isSimple(1, 1)) {
            boolean x;
            exp.visitArgs(visitor);
            Expression e0 = exp.getArg(0);
            Type t0 = e0.getType();
            boolean bl = x = t0 == LangPrimType.characterType;
            expression2 = (x ? x : t0 == LangPrimType.characterOrEofType) ? expressions.applyExp$V(Scheme.numEqu, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Type.int_type, e0}), Lit1}) : (LazyType.maybeLazy(t0) ? expressions.applyExp$V(Scheme.isEq, new Object[]{expressions.applyExp$V(((Procedure)GetNamedPart.getNamedPart).apply2(Lit2, Lit3), new Object[]{e0}), EofClass.eofValue}) : null);
        } else {
            expression2 = ex = null;
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Expression charCompareValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        NumberCompare num$Mnop;
        Expression ex;
        boolean x22222222;
        boolean x5;
        Expression expression;
        Expression expression2;
        Object x22222222;
        boolean x4;
        boolean x3;
        if (!exp.isSimple()) return null;
        String name = proc.getName();
        int n = exp.getArgCount();
        boolean x6 = strings.isString$Eq(name, "char=?", new CharSequence[0]);
        NumberCompare numberCompare = (x6 ? x6 : strings.isString$Eq(name, "char-ci=?", new CharSequence[0])) ? Scheme.numEqu : (((x3 = strings.isString$Eq(name, "char<?", new CharSequence[0])) ? x3 : strings.isString$Eq(name, "char-ci<?", new CharSequence[0])) ? Scheme.numLss : (((x5 = strings.isString$Eq(name, "char>?", new CharSequence[0])) ? x5 : strings.isString$Eq(name, "char-ci>?", new CharSequence[0])) ? Scheme.numGrt : (((x22222222 = strings.isString$Eq(name, "char<=?", new CharSequence[0])) ? x22222222 : strings.isString$Eq(name, "char-ci<=?", new CharSequence[0])) ? Scheme.numLEq : (((x4 = strings.isString$Eq(name, "char>=?", new CharSequence[0])) ? x4 : strings.isString$Eq(name, "char-ci>=?", new CharSequence[0])) ? Scheme.numGEq : (num$Mnop = null)))));
        if (num$Mnop == null) {
            expression2 = exp;
        } else {
            boolean ci = name.indexOf("ci") > 0;
            for (int i = 0; i != n; ++i) {
                ApplyExp e = expressions.applyExp$V(characters.char$Mn$Grinteger, new Object[]{exp.getArg(i)});
                if (ci) {
                    e = expressions.applyExp$V(Invoke.invokeStatic, new Object[]{Lit4, Lit5, e});
                }
                x22222222 = Promise.force(e, Expression.class);
                exp.setArg(i, (Expression)x22222222);
                continue;
            }
            expression2 = ex = expressions.applyExp$V(num$Mnop, exp.getArgs());
        }
        if (ex == null) {
            return null;
        }
        if (ex == exp) {
            exp.visitArgs(visitor);
            expression = exp;
            return expression;
        }
        expression = visitor.visit(ex.maybeSetLine(exp), required);
        return expression;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.ApplyExp.setArg(int,gnu.expr.Expression)", 3, x22222222);
        }
    }

    public static Expression stringCursorCompareValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        Expression expression2;
        Expression ex;
        if (exp.isSimple(2, 2)) {
            NumberCompare num$Mnop;
            String name = proc.getName();
            int n = exp.getArgCount();
            NumberCompare numberCompare = strings.isString$Eq(name, "string-cursor=?", new CharSequence[0]) ? Scheme.numEqu : (strings.isString$Eq(name, "string-cursor<?", new CharSequence[0]) ? Scheme.numLss : (strings.isString$Eq(name, "string-cursor>?", new CharSequence[0]) ? Scheme.numGrt : (strings.isString$Eq(name, "string-cursor<=?", new CharSequence[0]) ? Scheme.numLEq : (num$Mnop = strings.isString$Eq(name, "string-cursor>=?", new CharSequence[0]) ? Scheme.numGEq : null))));
            if (num$Mnop == null) {
                expression2 = null;
            } else {
                for (int i = 0; i != n; ++i) {
                    ApplyExp e = expressions.applyExp$V(Convert.as, new Object[]{Type.int_type, exp.getArg(i)});
                    exp.setArg(i, e);
                }
                expression2 = expressions.applyExp$V(num$Mnop, exp.getArgs());
            }
        } else {
            expression2 = ex = null;
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

    public static Expression stringAppendToValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression ex;
        int compat$Mncharacter;
        Expression expression;
        Expression expression2;
        if (exp.isSimple(2, 2)) {
            exp.visitArgs(expressions.getVisitor());
            Expression e0 = exp.getArg(0);
            Expression e1 = exp.getArg(1);
            Type t1 = e1.getType();
            compat$Mncharacter = LangPrimType.characterType.isCompatibleWithValue(t1);
            int compat$Mnchar = LangPrimType.charType.isCompatibleWithValue(t1);
            int compat$Mnstring = LangObjType.stringType.isCompatibleWithValue(t1);
            expression = compat$Mncharacter > 0 && compat$Mnstring <= 0 ? expressions.applyExp$V(Invoke.invoke, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Lit6, e0}), Lit7, expressions.applyExp$V(characters.char$Mn$Grinteger, new Object[]{e1})}) : (compat$Mnchar > 0 && compat$Mnstring <= 0 ? expressions.applyExp$V(Invoke.invoke, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Lit6, e0}), Lit8, expressions.applyExp$V(Convert.as, new Object[]{LangPrimType.charType, e1})}) : (compat$Mnstring > 0 && compat$Mncharacter < 0 ? expressions.applyExp$V(Invoke.invoke, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Lit6, e0}), Lit8, expressions.applyExp$V(Convert.as, new Object[]{Lit9, e1})}) : expressions.applyExp$V(Invoke.invoke, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Lit6, e0}), Lit8, e1})));
        } else if (exp.isSimple(3)) {
            Pair stmts22;
            Compilation comp = expressions.getCompilation();
            comp.letStart();
            Declaration seqDecl = comp.letVariable(null, Lit10, exp.getArg(0));
            int nargs = exp.getArgCount();
            comp.letEnter();
            compat$Mncharacter = 0;
            EmptyList compat$Mnstring = LList.Empty;
            for (int i = 1; i != nargs; ++i) {
                stmts22 = lists.cons(expressions.applyExp$V(strings.string$Mnappend$Ex, new Object[]{seqDecl, exp.getArg(i)}), stmts22);
            }
            LList i = lists.reverse(lists.cons(Values.empty, stmts22));
            int stmts22 = MakeSplice.count(i);
            compat$Mncharacter = stmts22 + compat$Mncharacter;
            Object[] arrobject = new Object[compat$Mncharacter];
            int n = 0;
            MakeSplice.copyTo(arrobject, n, stmts22, i);
            n += stmts22;
            expression = comp.letDone(expressions.beginExp$V(arrobject));
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
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Expression valuesValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression ex;
        Expression expression;
        block7 : {
            Type[] rtypes;
            Expression[] args;
            Expression expression2;
            MultValuesType rmult;
            int arg$Mncount;
            block9 : {
                boolean arg$Mncount$Mnok;
                MultValuesType multValuesType;
                block8 : {
                    block6 : {
                        if (!exp.isSimple(1, 1)) break block6;
                        expression2 = expressions.visitExp(exp.getArg(0), required);
                        break block7;
                    }
                    if (!exp.isSimple(0, 0)) break block8;
                    expression2 = expressions.visitExp(QuoteExp.voidObjectExp, required);
                    break block7;
                }
                if (!exp.isSimple()) return null;
                args = exp.getArgs();
                arg$Mncount = args.length;
                boolean bl = arg$Mncount$Mnok = OccurrenceType.compatibleWithCount(required, arg$Mncount) == 0;
                if (arg$Mncount$Mnok && required instanceof MultValuesType) {
                    Type type = required;
                    multValuesType = (MultValuesType)type;
                }
                multValuesType = null;
                rmult = multValuesType;
                rtypes = new Type[arg$Mncount];
                break block9;
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "rmult", -2, (Object)rtypes);
                }
            }
            for (int i = 0; i != arg$Mncount; ++i) {
                Expression e = expressions.visitExp(args[i], rmult == null ? null : rmult.getValueType(i));
                rtypes[i] = e.getType();
                args[i] = e;
            }
            exp.setType(MultValuesType.create(rtypes));
            expression2 = ex = exp;
        }
        if (ex == null) {
            return null;
        }
        if (ex == exp) {
            exp.visitArgs(visitor);
            expression = exp;
            return expression;
        }
        expression = visitor.visit(ex.maybeSetLine(exp), required);
        return expression;
    }

    public static Expression raiseValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        Expression ex;
        Expression expression2 = exp.isSimple(1, 1) ? expressions.applyExp$V(Throw.primitiveThrow, new Object[]{expressions.applyExp$V(Invoke.invokeStatic, new Object[]{ExceptionWithValue.class, Lit11, exp.getArg(0)})}) : (ex = null);
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

    public static boolean valuesCompile(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        PrimProcedure pproc = exp.isSimple(2, 2) ? new PrimProcedure(Compilation.typeValues.getDeclaredMethod("values2", 2), exp.getType(), new Type[]{Type.pointer_type, Type.pointer_type}) : new PrimProcedure(Compilation.typeValues.getDeclaredMethod("makeFromArray", 1));
        pproc.setReturnType(exp.getType());
        ApplyExp ae = expressions.applyExp$V(pproc, exp.getArgs());
        ae.compile(comp, target);
        return true;
    }

    public static Expression lengthValidateApply(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression expression;
        Expression arg;
        Type atype;
        Expression ex;
        Expression expression2 = exp.isSimple(1, 1) ? ((atype = (arg = exp.getArg(0)).getType()).isSubtype(Type.make(Lit12)) ? expressions.applyExp$V(Invoke.invoke, new Object[]{arg, Lit13}) : (atype.isSubtype(Type.make(Lit9)) ? expressions.applyExp$V(Invoke.invoke, new Object[]{arg, Lit14}) : (atype instanceof ArrayType ? expressions.applyExp$V(SlotGet.field, new Object[]{arg, Lit14}) : expressions.applyExp$V(((Procedure)GetNamedPart.getNamedPart).apply2(Lit15, Lit16), new Object[]{arg})))) : (ex = null);
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
        Lit27 = Symbol.valueOf("lengthValidateApply");
        Lit26 = Symbol.valueOf("valuesCompile");
        Lit25 = Symbol.valueOf("raiseValidateApply");
        Lit24 = Symbol.valueOf("valuesValidateApply");
        Lit23 = Symbol.valueOf("stringAppendToValidateApply");
        Lit22 = Symbol.valueOf("stringCursorCompareValidateApply");
        Lit21 = Symbol.valueOf("charCompareValidateApply");
        Lit20 = Symbol.valueOf("isEofValidateApply");
        Lit19 = Symbol.valueOf("integerToCharValidateApply");
        Lit18 = Symbol.valueOf("charToIntegerValidateApply");
        Lit17 = Symbol.valueOf("pipeProcessValidateApply");
        Lit16 = Symbol.valueOf("getSize");
        Lit15 = Sequences.class;
        Lit14 = Symbol.valueOf("length");
        Lit13 = Symbol.valueOf("size");
        Lit12 = List.class;
        Lit11 = Symbol.valueOf("wrap");
        Lit10 = ClassType.make("gnu.lists.FString");
        Lit9 = CharSequence.class;
        Lit8 = Symbol.valueOf("append");
        Lit7 = Symbol.valueOf("appendCharacter");
        Lit6 = FString.class;
        Lit5 = Symbol.valueOf("toUpperCase");
        Lit4 = Character.class;
        Lit3 = Symbol.valueOf("force");
        Lit2 = Promise.class;
        Lit1 = IntNum.valueOf(-1);
        Lit0 = Keyword.make("in");
        OccurrenceType = OccurrenceType.class;
        MultValuesType = MultValuesType.class;
        compile_misc compile_misc2 = $instance = new compile_misc();
        pipeProcessValidateApply = new ModuleMethod(compile_misc2, 1, Lit17, 16388);
        charToIntegerValidateApply = new ModuleMethod(compile_misc2, 2, Lit18, 16388);
        integerToCharValidateApply = new ModuleMethod(compile_misc2, 3, Lit19, 16388);
        isEofValidateApply = new ModuleMethod(compile_misc2, 4, Lit20, 16388);
        charCompareValidateApply = new ModuleMethod(compile_misc2, 5, Lit21, 16388);
        stringCursorCompareValidateApply = new ModuleMethod(compile_misc2, 6, Lit22, 16388);
        stringAppendToValidateApply = new ModuleMethod(compile_misc2, 7, Lit23, 16388);
        valuesValidateApply = new ModuleMethod(compile_misc2, 8, Lit24, 16388);
        raiseValidateApply = new ModuleMethod(compile_misc2, 9, Lit25, 16388);
        valuesCompile = new ModuleMethod(compile_misc2, 10, Lit26, 16388);
        lengthValidateApply = new ModuleMethod(compile_misc2, 11, Lit27, 16388);
        compile_misc.$runBody$();
    }

    public compile_misc() {
        ModuleInfo.register(this);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 11: {
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
            case 10: {
                Object object10 = Promise.force(object2, ApplyExp.class);
                if (!(object10 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object10;
                Object object11 = Promise.force(object3, Compilation.class);
                if (!(object11 instanceof Compilation)) {
                    return -786430;
                }
                callContext.value2 = object11;
                Object object12 = Promise.force(object4, Target.class);
                if (!(object12 instanceof Target)) {
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
            case 9: {
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
            case 8: {
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
            case 7: {
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
            case 6: {
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
            case 5: {
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
            case 4: {
                Object object34 = Promise.force(object2, ApplyExp.class);
                if (!(object34 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object34;
                Object object35 = Promise.force(object3, InlineCalls.class);
                if (!(object35 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object35;
                Object object36 = Promise.force(object4, Type.class);
                if (!(object36 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object36;
                Object object37 = Promise.force(object5, Procedure.class);
                if (!(object37 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object37;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 3: {
                Object object38 = Promise.force(object2, ApplyExp.class);
                if (!(object38 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object38;
                Object object39 = Promise.force(object3, InlineCalls.class);
                if (!(object39 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object39;
                Object object40 = Promise.force(object4, Type.class);
                if (!(object40 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object40;
                Object object41 = Promise.force(object5, Procedure.class);
                if (!(object41 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object41;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 2: {
                Object object42 = Promise.force(object2, ApplyExp.class);
                if (!(object42 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object42;
                Object object43 = Promise.force(object3, InlineCalls.class);
                if (!(object43 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object43;
                Object object44 = Promise.force(object4, Type.class);
                if (!(object44 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object44;
                Object object45 = Promise.force(object5, Procedure.class);
                if (!(object45 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object45;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 1: {
                Object object46 = Promise.force(object2, ApplyExp.class);
                if (!(object46 instanceof ApplyExp)) {
                    return -786431;
                }
                callContext.value1 = object46;
                Object object47 = Promise.force(object3, InlineCalls.class);
                if (!(object47 instanceof InlineCalls)) {
                    return -786430;
                }
                callContext.value2 = object47;
                Object object48 = Promise.force(object4, Type.class);
                if (!(object48 instanceof Type)) {
                    return -786429;
                }
                callContext.value3 = object48;
                Object object49 = Promise.force(object5, Procedure.class);
                if (!(object49 instanceof Procedure)) {
                    return -786428;
                }
                callContext.value4 = object49;
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

