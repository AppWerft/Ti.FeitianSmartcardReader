// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ModuleInfo;
import gnu.lists.FString;
import java.util.List;
import gnu.lists.Sequences;
import gnu.mapping.Symbol;
import gnu.kawa.reflect.SlotGet;
import gnu.bytecode.ArrayType;
import gnu.expr.PrimProcedure;
import gnu.expr.Target;
import gnu.kawa.reflect.Throw;
import gnu.kawa.reflect.MultValuesType;
import gnu.kawa.reflect.OccurrenceType;
import gnu.expr.QuoteExp;
import gnu.lists.EmptyList;
import gnu.expr.Declaration;
import gnu.expr.Compilation;
import gnu.kawa.functions.MakeSplice;
import gnu.mapping.Values;
import gnu.lists.LList;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.functions.NumberCompare;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.kawa.reflect.Invoke;
import gnu.lists.EofClass;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.LazyType;
import kawa.standard.Scheme;
import gnu.kawa.functions.Convert;
import kawa.lib.kawa.expressions;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.bytecode.ClassType;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.expr.Keyword;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class compile_misc extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Expression pipeProcessValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   gnu/expr/ApplyExp.getArgCount:()I
        //     4: iconst_2       
        //     5: if_icmpne       165
        //     8: aload_0         /* exp */
        //     9: invokestatic    kawa/lib/kawa/expressions.getVisitor:()Lgnu/expr/InlineCalls;
        //    12: invokevirtual   gnu/expr/ApplyExp.visitArgs:(Lgnu/expr/InlineCalls;)V
        //    15: aload_0         /* exp */
        //    16: iconst_0       
        //    17: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //    20: astore          5
        //    22: aload_0         /* exp */
        //    23: iconst_1       
        //    24: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //    27: astore          6
        //    29: invokestatic    kawa/lib/kawa/expressions.getVisitor:()Lgnu/expr/InlineCalls;
        //    32: astore          visitor
        //    34: aload           e1
        //    36: astore          8
        //    38: aload           8
        //    40: instanceof      Lgnu/expr/ApplyExp;
        //    43: ifeq            151
        //    46: aload           8
        //    48: checkcast       Lgnu/expr/ApplyExp;
        //    51: astore          9
        //    53: aload           9
        //    55: invokevirtual   gnu/expr/ApplyExp.getFunction:()Lgnu/expr/Expression;
        //    58: invokevirtual   gnu/expr/Expression.valueIfConstant:()Ljava/lang/Object;
        //    61: getstatic       gnu/kawa/functions/RunProcess.instance:Lgnu/kawa/functions/RunProcess;
        //    64: if_acmpne       151
        //    67: aload           e1
        //    69: dup            
        //    70: astore          11
        //    72: checkcast       Lgnu/expr/ApplyExp;
        //    75: astore          ae1
        //    77: aload           ae1
        //    79: invokevirtual   gnu/expr/ApplyExp.getArgs:()[Lgnu/expr/Expression;
        //    82: astore          aeargs
        //    84: aload           ae1
        //    86: invokevirtual   gnu/expr/ApplyExp.getFunction:()Lgnu/expr/Expression;
        //    89: iconst_2       
        //    90: istore          12
        //    92: aload           aeargs
        //    94: astore          13
        //    96: aload           13
        //    98: invokestatic    gnu/kawa/functions/MakeSplice.count:(Ljava/lang/Object;)I
        //   101: dup            
        //   102: istore          14
        //   104: iload           12
        //   106: iadd           
        //   107: istore          12
        //   109: iload           12
        //   111: anewarray       Ljava/lang/Object;
        //   114: dup            
        //   115: iconst_0       
        //   116: getstatic       kawa/lib/compile_misc.Lit0:Lgnu/expr/Keyword;
        //   119: aastore        
        //   120: dup            
        //   121: iconst_1       
        //   122: aload           e0
        //   124: aastore        
        //   125: dup            
        //   126: iconst_2       
        //   127: istore          15
        //   129: iload           15
        //   131: iload           14
        //   133: aload           13
        //   135: invokestatic    gnu/kawa/functions/MakeSplice.copyTo:([Ljava/lang/Object;IILjava/lang/Object;)V
        //   138: iload           15
        //   140: iload           14
        //   142: iadd           
        //   143: istore          15
        //   145: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   148: goto            166
        //   151: aload           visitor
        //   153: bipush          101
        //   155: ldc             "pipe-process arg not run-process"
        //   157: aload           e1
        //   159: invokevirtual   gnu/expr/InlineCalls.error:(CLjava/lang/String;Lgnu/text/SourceLocator;)Lgnu/expr/ErrorExp;
        //   162: goto            166
        //   165: aconst_null    
        //   166: astore          ex
        //   168: aload           ex
        //   170: ifnonnull       177
        //   173: aconst_null    
        //   174: goto            203
        //   177: aload           ex
        //   179: aload_0         /* exp */
        //   180: if_acmpne       192
        //   183: aload_0         /* exp */
        //   184: aload_1         /* visitor */
        //   185: invokevirtual   gnu/expr/ApplyExp.visitArgs:(Lgnu/expr/InlineCalls;)V
        //   188: aload_0         /* exp */
        //   189: goto            203
        //   192: aload_1         /* visitor */
        //   193: aload           ex
        //   195: aload_0         /* exp */
        //   196: invokevirtual   gnu/expr/Expression.maybeSetLine:(Lgnu/expr/Expression;)Lgnu/expr/Expression;
        //   199: aload_2         /* required */
        //   200: invokevirtual   gnu/expr/InlineCalls.visit:(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
        //   203: areturn        
        //   204: new             Lgnu/mapping/WrongType;
        //   207: dup_x1         
        //   208: swap           
        //   209: ldc             "ae1"
        //   211: bipush          -2
        //   213: aload           11
        //   215: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   218: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  72     75     204    219    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Expression charToIntegerValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Expression applyExp$V;
        if (exp.isSimple(1, 1)) {
            final Expression e0 = expressions.visitExp(exp.getArg(0), LangPrimType.characterType);
            applyExp$V = expressions.applyExp$V(Convert.as, new Object[] { Type.int_type, expressions.applyExp$V(Convert.cast, new Object[] { LangPrimType.characterType, e0 }) });
        }
        else {
            applyExp$V = null;
        }
        final Expression ex = applyExp$V;
        Expression visit;
        if (ex == null) {
            visit = null;
        }
        else if (ex == exp) {
            exp.visitArgs(visitor);
            visit = exp;
        }
        else {
            visit = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return visit;
    }
    
    public static Expression integerToCharValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression ex = exp.isSimple(1, 1) ? expressions.applyExp$V(Convert.as, new Object[] { LangPrimType.characterType, expressions.applyExp$V(Convert.cast, new Object[] { Type.int_type, exp.getArg(0) }) }) : null;
        Expression visit;
        if (ex == null) {
            visit = null;
        }
        else if (ex == exp) {
            exp.visitArgs(visitor);
            visit = exp;
        }
        else {
            visit = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return visit;
    }
    
    public static Expression isEofValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Expression expression;
        if (exp.isSimple(1, 1)) {
            exp.visitArgs(visitor);
            final Expression e0 = exp.getArg(0);
            final Type t0 = e0.getType();
            final boolean x = t0 == LangPrimType.characterType;
            expression = ((x ? x : (t0 == LangPrimType.characterOrEofType)) ? expressions.applyExp$V(Scheme.numEqu, new Object[] { expressions.applyExp$V(Convert.as, new Object[] { Type.int_type, e0 }), compile_misc.Lit1 }) : (LazyType.maybeLazy(t0) ? expressions.applyExp$V(Scheme.isEq, new Object[] { expressions.applyExp$V(GetNamedPart.getNamedPart.apply2(compile_misc.Lit2, compile_misc.Lit3), new Object[] { e0 }), EofClass.eofValue }) : null));
        }
        else {
            expression = null;
        }
        final Expression ex = expression;
        Expression visit;
        if (ex == null) {
            visit = null;
        }
        else if (ex == exp) {
            exp.visitArgs(visitor);
            visit = exp;
        }
        else {
            visit = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return visit;
    }
    
    public static Expression charCompareValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Label_0380: {
            if (!exp.isSimple()) {
                break Label_0380;
            }
            final String name = proc.getName();
            final int n = exp.getArgCount();
            final boolean x = strings.isString$Eq(name, "char=?", new CharSequence[0]);
            NumberCompare numberCompare = null;
            Label_0250: {
                Label_0065: {
                    if (x) {
                        if (!x) {
                            break Label_0065;
                        }
                    }
                    else if (!strings.isString$Eq(name, "char-ci=?", new CharSequence[0])) {
                        break Label_0065;
                    }
                    numberCompare = Scheme.numEqu;
                    break Label_0250;
                }
                final boolean x2 = strings.isString$Eq(name, "char<?", new CharSequence[0]);
                Label_0111: {
                    if (x2) {
                        if (!x2) {
                            break Label_0111;
                        }
                    }
                    else if (!strings.isString$Eq(name, "char-ci<?", new CharSequence[0])) {
                        break Label_0111;
                    }
                    numberCompare = Scheme.numLss;
                    break Label_0250;
                }
                final boolean x3 = strings.isString$Eq(name, "char>?", new CharSequence[0]);
                Label_0157: {
                    if (x3) {
                        if (!x3) {
                            break Label_0157;
                        }
                    }
                    else if (!strings.isString$Eq(name, "char-ci>?", new CharSequence[0])) {
                        break Label_0157;
                    }
                    numberCompare = Scheme.numGrt;
                    break Label_0250;
                }
                final boolean x4 = strings.isString$Eq(name, "char<=?", new CharSequence[0]);
                Label_0203: {
                    if (x4) {
                        if (!x4) {
                            break Label_0203;
                        }
                    }
                    else if (!strings.isString$Eq(name, "char-ci<=?", new CharSequence[0])) {
                        break Label_0203;
                    }
                    numberCompare = Scheme.numLEq;
                    break Label_0250;
                }
                final boolean x5 = strings.isString$Eq(name, "char>=?", new CharSequence[0]);
                numberCompare = ((x5 ? x5 : strings.isString$Eq(name, "char-ci>=?", new CharSequence[0])) ? Scheme.numGEq : null);
            }
            final NumberCompare num$Mnop = numberCompare;
        Label_0281_Outer:
            while (true) {
                if (num$Mnop == null) {
                    final Expression applyExp$V = exp;
                    break Label_0381;
                }
                final boolean ci = name.indexOf("ci") > 0;
                int i = 0;
                while (true) {
                    Label_0368: {
                        if (i == n) {
                            break Label_0368;
                        }
                        Object e = expressions.applyExp$V(characters.char$Mn$Grinteger, new Object[] { exp.getArg(i) });
                        if (ci) {
                            e = expressions.applyExp$V(Invoke.invokeStatic, new Object[] { compile_misc.Lit4, compile_misc.Lit5, e });
                        }
                        final int j = i;
                        final Object force = Promise.force(e, Expression.class);
                        try {
                            exp.setArg(j, (Expression)force);
                            ++i;
                            continue;
                            Label_0392: {
                                exp.visitArgs(visitor);
                            }
                            // iftrue(Label_0407:, ex != exp)
                            return exp;
                            Expression applyExp$V = null;
                            final Expression ex = applyExp$V;
                            // iftrue(Label_0392:, ex != null)
                            return null;
                            applyExp$V = expressions.applyExp$V(num$Mnop, exp.getArgs());
                            continue Label_0281_Outer;
                            applyExp$V = null;
                            continue Label_0281_Outer;
                            visit = null;
                            return visit;
                            Label_0407: {
                                visit = visitor.visit(ex.maybeSetLine(exp), required);
                            }
                            return visit;
                        }
                        catch (ClassCastException ex2) {
                            throw new WrongType(ex2, "gnu.expr.ApplyExp.setArg(int,gnu.expr.Expression)", 3, force);
                        }
                    }
                    break;
                }
                break;
            }
        }
    }
    
    public static Expression stringCursorCompareValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Expression applyExp$V;
        if (exp.isSimple(2, 2)) {
            final String name = proc.getName();
            final int n = exp.getArgCount();
            final NumberCompare num$Mnop = strings.isString$Eq(name, "string-cursor=?", new CharSequence[0]) ? Scheme.numEqu : (strings.isString$Eq(name, "string-cursor<?", new CharSequence[0]) ? Scheme.numLss : (strings.isString$Eq(name, "string-cursor>?", new CharSequence[0]) ? Scheme.numGrt : (strings.isString$Eq(name, "string-cursor<=?", new CharSequence[0]) ? Scheme.numLEq : (strings.isString$Eq(name, "string-cursor>=?", new CharSequence[0]) ? Scheme.numGEq : null))));
            if (num$Mnop == null) {
                applyExp$V = null;
            }
            else {
                for (int i = 0; i != n; ++i) {
                    final ApplyExp e = expressions.applyExp$V(Convert.as, new Object[] { Type.int_type, exp.getArg(i) });
                    exp.setArg(i, e);
                }
                applyExp$V = expressions.applyExp$V(num$Mnop, exp.getArgs());
            }
        }
        else {
            applyExp$V = null;
        }
        final Expression ex = applyExp$V;
        Expression visit;
        if (ex == null) {
            visit = null;
        }
        else if (ex == exp) {
            exp.visitArgs(visitor);
            visit = exp;
        }
        else {
            visit = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return visit;
    }
    
    public static Expression stringAppendToValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Expression letDone;
        if (exp.isSimple(2, 2)) {
            exp.visitArgs(expressions.getVisitor());
            final Expression e0 = exp.getArg(0);
            final Expression e2 = exp.getArg(1);
            final Type t1 = e2.getType();
            final int compat$Mncharacter = LangPrimType.characterType.isCompatibleWithValue(t1);
            final int compat$Mnchar = LangPrimType.charType.isCompatibleWithValue(t1);
            final int compat$Mnstring = LangObjType.stringType.isCompatibleWithValue(t1);
            letDone = ((compat$Mncharacter > 0 && compat$Mnstring <= 0) ? expressions.applyExp$V(Invoke.invoke, new Object[] { expressions.applyExp$V(Convert.as, new Object[] { compile_misc.Lit6, e0 }), compile_misc.Lit7, expressions.applyExp$V(characters.char$Mn$Grinteger, new Object[] { e2 }) }) : ((compat$Mnchar > 0 && compat$Mnstring <= 0) ? expressions.applyExp$V(Invoke.invoke, new Object[] { expressions.applyExp$V(Convert.as, new Object[] { compile_misc.Lit6, e0 }), compile_misc.Lit8, expressions.applyExp$V(Convert.as, new Object[] { LangPrimType.charType, e2 }) }) : ((compat$Mnstring > 0 && compat$Mncharacter < 0) ? expressions.applyExp$V(Invoke.invoke, new Object[] { expressions.applyExp$V(Convert.as, new Object[] { compile_misc.Lit6, e0 }), compile_misc.Lit8, expressions.applyExp$V(Convert.as, new Object[] { compile_misc.Lit9, e2 }) }) : expressions.applyExp$V(Invoke.invoke, new Object[] { expressions.applyExp$V(Convert.as, new Object[] { compile_misc.Lit6, e0 }), compile_misc.Lit8, e2 }))));
        }
        else if (exp.isSimple(3)) {
            final Compilation comp = expressions.getCompilation();
            comp.letStart();
            final Declaration seqDecl = comp.letVariable(null, compile_misc.Lit10, exp.getArg(0));
            final int nargs = exp.getArgCount();
            comp.letEnter();
            final Compilation compilation = comp;
            final int n = 0;
            final int n2 = 1;
            final EmptyList empty = LList.Empty;
            Object stmts = null;
            for (int i = n2; i != nargs; ++i) {
                stmts = lists.cons(expressions.applyExp$V(strings.string$Mnappend$Ex, new Object[] { seqDecl, exp.getArg(i) }), stmts);
            }
            final LList reverse = lists.reverse(lists.cons(Values.empty, stmts));
            final int count;
            final Object[] array = new Object[(count = MakeSplice.count(reverse)) + n];
            MakeSplice.copyTo(array, 0, count, reverse);
            letDone = compilation.letDone(expressions.beginExp$V(array));
        }
        else {
            letDone = null;
        }
        final Expression ex = letDone;
        Expression visit;
        if (ex == null) {
            visit = null;
        }
        else if (ex == exp) {
            exp.visitArgs(visitor);
            visit = exp;
        }
        else {
            visit = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return visit;
    }
    
    public static Expression valuesValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
    Label_0097_Outer:
        while (true) {
            if (exp.isSimple(1, 1)) {
                final Expression expression = expressions.visitExp(exp.getArg(0), required);
                break Label_0179;
            }
            if (exp.isSimple(0, 0)) {
                final Expression expression = expressions.visitExp(QuoteExp.voidObjectExp, required);
                break Label_0179;
            }
            Label_0178: {
                if (!exp.isSimple()) {
                    break Label_0178;
                }
                final Expression[] args = exp.getArgs();
                final int arg$Mncount = args.length;
                final boolean arg$Mncount$Mnok = gnu.kawa.reflect.OccurrenceType.compatibleWithCount(required, arg$Mncount) == 0;
                Label_0096: {
                    if (!arg$Mncount$Mnok || !(required instanceof MultValuesType)) {
                        break Label_0096;
                    }
                    try {
                        MultValuesType multValuesType = (MultValuesType)required;
                        while (true) {
                            final MultValuesType rmult = multValuesType;
                            final Type[] rtypes = new Type[arg$Mncount];
                            for (int i = 0; i != arg$Mncount; ++i) {
                                final Expression e = expressions.visitExp(args[i], (rmult == null) ? null : rmult.getValueType(i));
                                rtypes[i] = e.getType();
                                args[i] = e;
                            }
                            exp.setType(gnu.kawa.reflect.MultValuesType.create(rtypes));
                            final Expression expression = exp;
                            final Expression ex = expression;
                            Expression visit;
                            if (ex == null) {
                                visit = null;
                            }
                            else if (ex == exp) {
                                exp.visitArgs(visitor);
                                visit = exp;
                            }
                            else {
                                visit = visitor.visit(ex.maybeSetLine(exp), required);
                            }
                            return visit;
                            multValuesType = null;
                            continue;
                        }
                        final Expression expression = null;
                        continue Label_0097_Outer;
                    }
                    catch (ClassCastException ex2) {
                        throw new WrongType(ex2, "rmult", -2, required);
                    }
                }
            }
            break;
        }
    }
    
    public static Expression raiseValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression ex = exp.isSimple(1, 1) ? expressions.applyExp$V(Throw.primitiveThrow, new Object[] { expressions.applyExp$V(Invoke.invokeStatic, new Object[] { ExceptionWithValue.class, compile_misc.Lit11, exp.getArg(0) }) }) : null;
        Expression visit;
        if (ex == null) {
            visit = null;
        }
        else if (ex == exp) {
            exp.visitArgs(visitor);
            visit = exp;
        }
        else {
            visit = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return visit;
    }
    
    public static boolean valuesCompile(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        final PrimProcedure pproc = exp.isSimple(2, 2) ? new PrimProcedure(Compilation.typeValues.getDeclaredMethod("values2", 2), exp.getType(), new Type[] { Type.pointer_type, Type.pointer_type }) : new PrimProcedure(Compilation.typeValues.getDeclaredMethod("makeFromArray", 1));
        pproc.setReturnType(exp.getType());
        final ApplyExp ae = expressions.applyExp$V(pproc, exp.getArgs());
        ae.compile(comp, target);
        return true;
    }
    
    public static Expression lengthValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Expression expression;
        if (exp.isSimple(1, 1)) {
            final Expression arg = exp.getArg(0);
            final Type atype = arg.getType();
            expression = (atype.isSubtype(Type.make(compile_misc.Lit12)) ? expressions.applyExp$V(Invoke.invoke, new Object[] { arg, compile_misc.Lit13 }) : (atype.isSubtype(Type.make(compile_misc.Lit9)) ? expressions.applyExp$V(Invoke.invoke, new Object[] { arg, compile_misc.Lit14 }) : ((atype instanceof ArrayType) ? expressions.applyExp$V(SlotGet.field, new Object[] { arg, compile_misc.Lit14 }) : expressions.applyExp$V(GetNamedPart.getNamedPart.apply2(compile_misc.Lit15, compile_misc.Lit16), new Object[] { arg }))));
        }
        else {
            expression = null;
        }
        final Expression ex = expression;
        Expression visit;
        if (ex == null) {
            visit = null;
        }
        else if (ex == exp) {
            exp.visitArgs(visitor);
            visit = exp;
        }
        else {
            visit = visitor.visit(ex.maybeSetLine(exp), required);
        }
        return visit;
    }
    
    static {
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
        compile_misc.$instance = new compile_misc();
        final compile_misc $instance = compile_misc.$instance;
        pipeProcessValidateApply = new ModuleMethod($instance, 1, compile_misc.Lit17, 16388);
        charToIntegerValidateApply = new ModuleMethod($instance, 2, compile_misc.Lit18, 16388);
        integerToCharValidateApply = new ModuleMethod($instance, 3, compile_misc.Lit19, 16388);
        isEofValidateApply = new ModuleMethod($instance, 4, compile_misc.Lit20, 16388);
        charCompareValidateApply = new ModuleMethod($instance, 5, compile_misc.Lit21, 16388);
        stringCursorCompareValidateApply = new ModuleMethod($instance, 6, compile_misc.Lit22, 16388);
        stringAppendToValidateApply = new ModuleMethod($instance, 7, compile_misc.Lit23, 16388);
        valuesValidateApply = new ModuleMethod($instance, 8, compile_misc.Lit24, 16388);
        raiseValidateApply = new ModuleMethod($instance, 9, compile_misc.Lit25, 16388);
        valuesCompile = new ModuleMethod($instance, 10, compile_misc.Lit26, 16388);
        lengthValidateApply = new ModuleMethod($instance, 11, compile_misc.Lit27, 16388);
        $runBody$();
    }
    
    public compile_misc() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 11: {
                final Object force = Promise.force(o, ApplyExp.class);
                if (!(force instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(o2, InlineCalls.class);
                if (!(force2 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force2;
                final Object force3 = Promise.force(o3, Type.class);
                if (!(force3 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force3;
                final Object force4 = Promise.force(o4, Procedure.class);
                if (!(force4 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 10: {
                final Object force5 = Promise.force(o, ApplyExp.class);
                if (!(force5 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force5;
                final Object force6 = Promise.force(o2, Compilation.class);
                if (!(force6 instanceof Compilation)) {
                    return -786430;
                }
                ctx.value2 = force6;
                final Object force7 = Promise.force(o3, Target.class);
                if (!(force7 instanceof Target)) {
                    return -786429;
                }
                ctx.value3 = force7;
                final Object force8 = Promise.force(o4, Procedure.class);
                if (!(force8 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force8;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 9: {
                final Object force9 = Promise.force(o, ApplyExp.class);
                if (!(force9 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force9;
                final Object force10 = Promise.force(o2, InlineCalls.class);
                if (!(force10 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force10;
                final Object force11 = Promise.force(o3, Type.class);
                if (!(force11 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force11;
                final Object force12 = Promise.force(o4, Procedure.class);
                if (!(force12 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force12;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 8: {
                final Object force13 = Promise.force(o, ApplyExp.class);
                if (!(force13 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force13;
                final Object force14 = Promise.force(o2, InlineCalls.class);
                if (!(force14 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force14;
                final Object force15 = Promise.force(o3, Type.class);
                if (!(force15 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force15;
                final Object force16 = Promise.force(o4, Procedure.class);
                if (!(force16 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force16;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 7: {
                final Object force17 = Promise.force(o, ApplyExp.class);
                if (!(force17 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force17;
                final Object force18 = Promise.force(o2, InlineCalls.class);
                if (!(force18 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force18;
                final Object force19 = Promise.force(o3, Type.class);
                if (!(force19 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force19;
                final Object force20 = Promise.force(o4, Procedure.class);
                if (!(force20 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force20;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 6: {
                final Object force21 = Promise.force(o, ApplyExp.class);
                if (!(force21 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force21;
                final Object force22 = Promise.force(o2, InlineCalls.class);
                if (!(force22 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force22;
                final Object force23 = Promise.force(o3, Type.class);
                if (!(force23 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force23;
                final Object force24 = Promise.force(o4, Procedure.class);
                if (!(force24 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force24;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 5: {
                final Object force25 = Promise.force(o, ApplyExp.class);
                if (!(force25 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force25;
                final Object force26 = Promise.force(o2, InlineCalls.class);
                if (!(force26 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force26;
                final Object force27 = Promise.force(o3, Type.class);
                if (!(force27 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force27;
                final Object force28 = Promise.force(o4, Procedure.class);
                if (!(force28 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force28;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 4: {
                final Object force29 = Promise.force(o, ApplyExp.class);
                if (!(force29 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force29;
                final Object force30 = Promise.force(o2, InlineCalls.class);
                if (!(force30 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force30;
                final Object force31 = Promise.force(o3, Type.class);
                if (!(force31 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force31;
                final Object force32 = Promise.force(o4, Procedure.class);
                if (!(force32 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force32;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 3: {
                final Object force33 = Promise.force(o, ApplyExp.class);
                if (!(force33 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force33;
                final Object force34 = Promise.force(o2, InlineCalls.class);
                if (!(force34 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force34;
                final Object force35 = Promise.force(o3, Type.class);
                if (!(force35 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force35;
                final Object force36 = Promise.force(o4, Procedure.class);
                if (!(force36 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force36;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 2: {
                final Object force37 = Promise.force(o, ApplyExp.class);
                if (!(force37 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force37;
                final Object force38 = Promise.force(o2, InlineCalls.class);
                if (!(force38 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force38;
                final Object force39 = Promise.force(o3, Type.class);
                if (!(force39 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force39;
                final Object force40 = Promise.force(o4, Procedure.class);
                if (!(force40 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force40;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 1: {
                final Object force41 = Promise.force(o, ApplyExp.class);
                if (!(force41 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force41;
                final Object force42 = Promise.force(o2, InlineCalls.class);
                if (!(force42 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force42;
                final Object force43 = Promise.force(o3, Type.class);
                if (!(force43 instanceof Type)) {
                    return -786429;
                }
                ctx.value3 = force43;
                final Object force44 = Promise.force(o4, Procedure.class);
                if (!(force44 instanceof Procedure)) {
                    return -786428;
                }
                ctx.value4 = force44;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            default: {
                return super.match4(moduleMethod, o, o2, o3, o4, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
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
        //                2: 64
        //                3: 106
        //                4: 148
        //                5: 190
        //                6: 232
        //                7: 274
        //                8: 316
        //                9: 358
        //               10: 400
        //               11: 442
        //               12: 498
        //          default: 540
        //        }
        //    64: aload_2        
        //    65: ldc             Lgnu/expr/ApplyExp;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: checkcast       Lgnu/expr/ApplyExp;
        //    73: aload_3        
        //    74: ldc             Lgnu/expr/InlineCalls;.class
        //    76: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    79: checkcast       Lgnu/expr/InlineCalls;
        //    82: aload           4
        //    84: ldc             Lgnu/bytecode/Type;.class
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    89: checkcast       Lgnu/bytecode/Type;
        //    92: aload           5
        //    94: ldc             Lgnu/mapping/Procedure;.class
        //    96: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    99: checkcast       Lgnu/mapping/Procedure;
        //   102: invokestatic    kawa/lib/compile_misc.pipeProcessValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   105: areturn        
        //   106: aload_2        
        //   107: ldc             Lgnu/expr/ApplyExp;.class
        //   109: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   112: checkcast       Lgnu/expr/ApplyExp;
        //   115: aload_3        
        //   116: ldc             Lgnu/expr/InlineCalls;.class
        //   118: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   121: checkcast       Lgnu/expr/InlineCalls;
        //   124: aload           4
        //   126: ldc             Lgnu/bytecode/Type;.class
        //   128: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   131: checkcast       Lgnu/bytecode/Type;
        //   134: aload           5
        //   136: ldc             Lgnu/mapping/Procedure;.class
        //   138: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   141: checkcast       Lgnu/mapping/Procedure;
        //   144: invokestatic    kawa/lib/compile_misc.charToIntegerValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   147: areturn        
        //   148: aload_2        
        //   149: ldc             Lgnu/expr/ApplyExp;.class
        //   151: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   154: checkcast       Lgnu/expr/ApplyExp;
        //   157: aload_3        
        //   158: ldc             Lgnu/expr/InlineCalls;.class
        //   160: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   163: checkcast       Lgnu/expr/InlineCalls;
        //   166: aload           4
        //   168: ldc             Lgnu/bytecode/Type;.class
        //   170: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   173: checkcast       Lgnu/bytecode/Type;
        //   176: aload           5
        //   178: ldc             Lgnu/mapping/Procedure;.class
        //   180: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   183: checkcast       Lgnu/mapping/Procedure;
        //   186: invokestatic    kawa/lib/compile_misc.integerToCharValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   189: areturn        
        //   190: aload_2        
        //   191: ldc             Lgnu/expr/ApplyExp;.class
        //   193: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   196: checkcast       Lgnu/expr/ApplyExp;
        //   199: aload_3        
        //   200: ldc             Lgnu/expr/InlineCalls;.class
        //   202: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   205: checkcast       Lgnu/expr/InlineCalls;
        //   208: aload           4
        //   210: ldc             Lgnu/bytecode/Type;.class
        //   212: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   215: checkcast       Lgnu/bytecode/Type;
        //   218: aload           5
        //   220: ldc             Lgnu/mapping/Procedure;.class
        //   222: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   225: checkcast       Lgnu/mapping/Procedure;
        //   228: invokestatic    kawa/lib/compile_misc.isEofValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   231: areturn        
        //   232: aload_2        
        //   233: ldc             Lgnu/expr/ApplyExp;.class
        //   235: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   238: checkcast       Lgnu/expr/ApplyExp;
        //   241: aload_3        
        //   242: ldc             Lgnu/expr/InlineCalls;.class
        //   244: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   247: checkcast       Lgnu/expr/InlineCalls;
        //   250: aload           4
        //   252: ldc             Lgnu/bytecode/Type;.class
        //   254: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   257: checkcast       Lgnu/bytecode/Type;
        //   260: aload           5
        //   262: ldc             Lgnu/mapping/Procedure;.class
        //   264: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   267: checkcast       Lgnu/mapping/Procedure;
        //   270: invokestatic    kawa/lib/compile_misc.charCompareValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   273: areturn        
        //   274: aload_2        
        //   275: ldc             Lgnu/expr/ApplyExp;.class
        //   277: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   280: checkcast       Lgnu/expr/ApplyExp;
        //   283: aload_3        
        //   284: ldc             Lgnu/expr/InlineCalls;.class
        //   286: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   289: checkcast       Lgnu/expr/InlineCalls;
        //   292: aload           4
        //   294: ldc             Lgnu/bytecode/Type;.class
        //   296: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   299: checkcast       Lgnu/bytecode/Type;
        //   302: aload           5
        //   304: ldc             Lgnu/mapping/Procedure;.class
        //   306: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   309: checkcast       Lgnu/mapping/Procedure;
        //   312: invokestatic    kawa/lib/compile_misc.stringCursorCompareValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   315: areturn        
        //   316: aload_2        
        //   317: ldc             Lgnu/expr/ApplyExp;.class
        //   319: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   322: checkcast       Lgnu/expr/ApplyExp;
        //   325: aload_3        
        //   326: ldc             Lgnu/expr/InlineCalls;.class
        //   328: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   331: checkcast       Lgnu/expr/InlineCalls;
        //   334: aload           4
        //   336: ldc             Lgnu/bytecode/Type;.class
        //   338: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   341: checkcast       Lgnu/bytecode/Type;
        //   344: aload           5
        //   346: ldc             Lgnu/mapping/Procedure;.class
        //   348: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   351: checkcast       Lgnu/mapping/Procedure;
        //   354: invokestatic    kawa/lib/compile_misc.stringAppendToValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   357: areturn        
        //   358: aload_2        
        //   359: ldc             Lgnu/expr/ApplyExp;.class
        //   361: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   364: checkcast       Lgnu/expr/ApplyExp;
        //   367: aload_3        
        //   368: ldc             Lgnu/expr/InlineCalls;.class
        //   370: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   373: checkcast       Lgnu/expr/InlineCalls;
        //   376: aload           4
        //   378: ldc             Lgnu/bytecode/Type;.class
        //   380: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   383: checkcast       Lgnu/bytecode/Type;
        //   386: aload           5
        //   388: ldc             Lgnu/mapping/Procedure;.class
        //   390: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   393: checkcast       Lgnu/mapping/Procedure;
        //   396: invokestatic    kawa/lib/compile_misc.valuesValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   399: areturn        
        //   400: aload_2        
        //   401: ldc             Lgnu/expr/ApplyExp;.class
        //   403: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   406: checkcast       Lgnu/expr/ApplyExp;
        //   409: aload_3        
        //   410: ldc             Lgnu/expr/InlineCalls;.class
        //   412: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   415: checkcast       Lgnu/expr/InlineCalls;
        //   418: aload           4
        //   420: ldc             Lgnu/bytecode/Type;.class
        //   422: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   425: checkcast       Lgnu/bytecode/Type;
        //   428: aload           5
        //   430: ldc             Lgnu/mapping/Procedure;.class
        //   432: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   435: checkcast       Lgnu/mapping/Procedure;
        //   438: invokestatic    kawa/lib/compile_misc.raiseValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   441: areturn        
        //   442: aload_2        
        //   443: ldc             Lgnu/expr/ApplyExp;.class
        //   445: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   448: checkcast       Lgnu/expr/ApplyExp;
        //   451: aload_3        
        //   452: ldc_w           Lgnu/expr/Compilation;.class
        //   455: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   458: checkcast       Lgnu/expr/Compilation;
        //   461: aload           4
        //   463: ldc_w           Lgnu/expr/Target;.class
        //   466: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   469: checkcast       Lgnu/expr/Target;
        //   472: aload           5
        //   474: ldc             Lgnu/mapping/Procedure;.class
        //   476: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   479: checkcast       Lgnu/mapping/Procedure;
        //   482: invokestatic    kawa/lib/compile_misc.valuesCompile:(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;Lgnu/mapping/Procedure;)Z
        //   485: ifeq            494
        //   488: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   491: goto            497
        //   494: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   497: areturn        
        //   498: aload_2        
        //   499: ldc             Lgnu/expr/ApplyExp;.class
        //   501: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   504: checkcast       Lgnu/expr/ApplyExp;
        //   507: aload_3        
        //   508: ldc             Lgnu/expr/InlineCalls;.class
        //   510: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   513: checkcast       Lgnu/expr/InlineCalls;
        //   516: aload           4
        //   518: ldc             Lgnu/bytecode/Type;.class
        //   520: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   523: checkcast       Lgnu/bytecode/Type;
        //   526: aload           5
        //   528: ldc             Lgnu/mapping/Procedure;.class
        //   530: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   533: checkcast       Lgnu/mapping/Procedure;
        //   536: invokestatic    kawa/lib/compile_misc.lengthValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   539: areturn        
        //   540: aload_0        
        //   541: aload_1        
        //   542: aload_2        
        //   543: aload_3        
        //   544: aload           4
        //   546: aload           5
        //   548: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   551: areturn        
        //   552: new             Lgnu/mapping/WrongType;
        //   555: dup_x1         
        //   556: swap           
        //   557: ldc_w           "pipeProcessValidateApply"
        //   560: iconst_1       
        //   561: aload_2        
        //   562: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   565: athrow         
        //   566: new             Lgnu/mapping/WrongType;
        //   569: dup_x1         
        //   570: swap           
        //   571: ldc_w           "pipeProcessValidateApply"
        //   574: iconst_2       
        //   575: aload_3        
        //   576: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   579: athrow         
        //   580: new             Lgnu/mapping/WrongType;
        //   583: dup_x1         
        //   584: swap           
        //   585: ldc_w           "pipeProcessValidateApply"
        //   588: iconst_3       
        //   589: aload           4
        //   591: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   594: athrow         
        //   595: new             Lgnu/mapping/WrongType;
        //   598: dup_x1         
        //   599: swap           
        //   600: ldc_w           "pipeProcessValidateApply"
        //   603: iconst_4       
        //   604: aload           5
        //   606: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   609: athrow         
        //   610: new             Lgnu/mapping/WrongType;
        //   613: dup_x1         
        //   614: swap           
        //   615: ldc_w           "charToIntegerValidateApply"
        //   618: iconst_1       
        //   619: aload_2        
        //   620: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   623: athrow         
        //   624: new             Lgnu/mapping/WrongType;
        //   627: dup_x1         
        //   628: swap           
        //   629: ldc_w           "charToIntegerValidateApply"
        //   632: iconst_2       
        //   633: aload_3        
        //   634: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   637: athrow         
        //   638: new             Lgnu/mapping/WrongType;
        //   641: dup_x1         
        //   642: swap           
        //   643: ldc_w           "charToIntegerValidateApply"
        //   646: iconst_3       
        //   647: aload           4
        //   649: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   652: athrow         
        //   653: new             Lgnu/mapping/WrongType;
        //   656: dup_x1         
        //   657: swap           
        //   658: ldc_w           "charToIntegerValidateApply"
        //   661: iconst_4       
        //   662: aload           5
        //   664: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   667: athrow         
        //   668: new             Lgnu/mapping/WrongType;
        //   671: dup_x1         
        //   672: swap           
        //   673: ldc_w           "integerToCharValidateApply"
        //   676: iconst_1       
        //   677: aload_2        
        //   678: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   681: athrow         
        //   682: new             Lgnu/mapping/WrongType;
        //   685: dup_x1         
        //   686: swap           
        //   687: ldc_w           "integerToCharValidateApply"
        //   690: iconst_2       
        //   691: aload_3        
        //   692: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   695: athrow         
        //   696: new             Lgnu/mapping/WrongType;
        //   699: dup_x1         
        //   700: swap           
        //   701: ldc_w           "integerToCharValidateApply"
        //   704: iconst_3       
        //   705: aload           4
        //   707: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   710: athrow         
        //   711: new             Lgnu/mapping/WrongType;
        //   714: dup_x1         
        //   715: swap           
        //   716: ldc_w           "integerToCharValidateApply"
        //   719: iconst_4       
        //   720: aload           5
        //   722: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   725: athrow         
        //   726: new             Lgnu/mapping/WrongType;
        //   729: dup_x1         
        //   730: swap           
        //   731: ldc_w           "isEofValidateApply"
        //   734: iconst_1       
        //   735: aload_2        
        //   736: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   739: athrow         
        //   740: new             Lgnu/mapping/WrongType;
        //   743: dup_x1         
        //   744: swap           
        //   745: ldc_w           "isEofValidateApply"
        //   748: iconst_2       
        //   749: aload_3        
        //   750: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   753: athrow         
        //   754: new             Lgnu/mapping/WrongType;
        //   757: dup_x1         
        //   758: swap           
        //   759: ldc_w           "isEofValidateApply"
        //   762: iconst_3       
        //   763: aload           4
        //   765: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   768: athrow         
        //   769: new             Lgnu/mapping/WrongType;
        //   772: dup_x1         
        //   773: swap           
        //   774: ldc_w           "isEofValidateApply"
        //   777: iconst_4       
        //   778: aload           5
        //   780: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   783: athrow         
        //   784: new             Lgnu/mapping/WrongType;
        //   787: dup_x1         
        //   788: swap           
        //   789: ldc_w           "charCompareValidateApply"
        //   792: iconst_1       
        //   793: aload_2        
        //   794: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   797: athrow         
        //   798: new             Lgnu/mapping/WrongType;
        //   801: dup_x1         
        //   802: swap           
        //   803: ldc_w           "charCompareValidateApply"
        //   806: iconst_2       
        //   807: aload_3        
        //   808: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   811: athrow         
        //   812: new             Lgnu/mapping/WrongType;
        //   815: dup_x1         
        //   816: swap           
        //   817: ldc_w           "charCompareValidateApply"
        //   820: iconst_3       
        //   821: aload           4
        //   823: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   826: athrow         
        //   827: new             Lgnu/mapping/WrongType;
        //   830: dup_x1         
        //   831: swap           
        //   832: ldc_w           "charCompareValidateApply"
        //   835: iconst_4       
        //   836: aload           5
        //   838: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   841: athrow         
        //   842: new             Lgnu/mapping/WrongType;
        //   845: dup_x1         
        //   846: swap           
        //   847: ldc_w           "stringCursorCompareValidateApply"
        //   850: iconst_1       
        //   851: aload_2        
        //   852: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   855: athrow         
        //   856: new             Lgnu/mapping/WrongType;
        //   859: dup_x1         
        //   860: swap           
        //   861: ldc_w           "stringCursorCompareValidateApply"
        //   864: iconst_2       
        //   865: aload_3        
        //   866: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   869: athrow         
        //   870: new             Lgnu/mapping/WrongType;
        //   873: dup_x1         
        //   874: swap           
        //   875: ldc_w           "stringCursorCompareValidateApply"
        //   878: iconst_3       
        //   879: aload           4
        //   881: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   884: athrow         
        //   885: new             Lgnu/mapping/WrongType;
        //   888: dup_x1         
        //   889: swap           
        //   890: ldc_w           "stringCursorCompareValidateApply"
        //   893: iconst_4       
        //   894: aload           5
        //   896: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   899: athrow         
        //   900: new             Lgnu/mapping/WrongType;
        //   903: dup_x1         
        //   904: swap           
        //   905: ldc_w           "stringAppendToValidateApply"
        //   908: iconst_1       
        //   909: aload_2        
        //   910: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   913: athrow         
        //   914: new             Lgnu/mapping/WrongType;
        //   917: dup_x1         
        //   918: swap           
        //   919: ldc_w           "stringAppendToValidateApply"
        //   922: iconst_2       
        //   923: aload_3        
        //   924: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   927: athrow         
        //   928: new             Lgnu/mapping/WrongType;
        //   931: dup_x1         
        //   932: swap           
        //   933: ldc_w           "stringAppendToValidateApply"
        //   936: iconst_3       
        //   937: aload           4
        //   939: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   942: athrow         
        //   943: new             Lgnu/mapping/WrongType;
        //   946: dup_x1         
        //   947: swap           
        //   948: ldc_w           "stringAppendToValidateApply"
        //   951: iconst_4       
        //   952: aload           5
        //   954: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   957: athrow         
        //   958: new             Lgnu/mapping/WrongType;
        //   961: dup_x1         
        //   962: swap           
        //   963: ldc_w           "valuesValidateApply"
        //   966: iconst_1       
        //   967: aload_2        
        //   968: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   971: athrow         
        //   972: new             Lgnu/mapping/WrongType;
        //   975: dup_x1         
        //   976: swap           
        //   977: ldc_w           "valuesValidateApply"
        //   980: iconst_2       
        //   981: aload_3        
        //   982: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   985: athrow         
        //   986: new             Lgnu/mapping/WrongType;
        //   989: dup_x1         
        //   990: swap           
        //   991: ldc_w           "valuesValidateApply"
        //   994: iconst_3       
        //   995: aload           4
        //   997: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1000: athrow         
        //  1001: new             Lgnu/mapping/WrongType;
        //  1004: dup_x1         
        //  1005: swap           
        //  1006: ldc_w           "valuesValidateApply"
        //  1009: iconst_4       
        //  1010: aload           5
        //  1012: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1015: athrow         
        //  1016: new             Lgnu/mapping/WrongType;
        //  1019: dup_x1         
        //  1020: swap           
        //  1021: ldc_w           "raiseValidateApply"
        //  1024: iconst_1       
        //  1025: aload_2        
        //  1026: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1029: athrow         
        //  1030: new             Lgnu/mapping/WrongType;
        //  1033: dup_x1         
        //  1034: swap           
        //  1035: ldc_w           "raiseValidateApply"
        //  1038: iconst_2       
        //  1039: aload_3        
        //  1040: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1043: athrow         
        //  1044: new             Lgnu/mapping/WrongType;
        //  1047: dup_x1         
        //  1048: swap           
        //  1049: ldc_w           "raiseValidateApply"
        //  1052: iconst_3       
        //  1053: aload           4
        //  1055: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1058: athrow         
        //  1059: new             Lgnu/mapping/WrongType;
        //  1062: dup_x1         
        //  1063: swap           
        //  1064: ldc_w           "raiseValidateApply"
        //  1067: iconst_4       
        //  1068: aload           5
        //  1070: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1073: athrow         
        //  1074: new             Lgnu/mapping/WrongType;
        //  1077: dup_x1         
        //  1078: swap           
        //  1079: ldc_w           "valuesCompile"
        //  1082: iconst_1       
        //  1083: aload_2        
        //  1084: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1087: athrow         
        //  1088: new             Lgnu/mapping/WrongType;
        //  1091: dup_x1         
        //  1092: swap           
        //  1093: ldc_w           "valuesCompile"
        //  1096: iconst_2       
        //  1097: aload_3        
        //  1098: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1101: athrow         
        //  1102: new             Lgnu/mapping/WrongType;
        //  1105: dup_x1         
        //  1106: swap           
        //  1107: ldc_w           "valuesCompile"
        //  1110: iconst_3       
        //  1111: aload           4
        //  1113: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1116: athrow         
        //  1117: new             Lgnu/mapping/WrongType;
        //  1120: dup_x1         
        //  1121: swap           
        //  1122: ldc_w           "valuesCompile"
        //  1125: iconst_4       
        //  1126: aload           5
        //  1128: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1131: athrow         
        //  1132: new             Lgnu/mapping/WrongType;
        //  1135: dup_x1         
        //  1136: swap           
        //  1137: ldc_w           "lengthValidateApply"
        //  1140: iconst_1       
        //  1141: aload_2        
        //  1142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1145: athrow         
        //  1146: new             Lgnu/mapping/WrongType;
        //  1149: dup_x1         
        //  1150: swap           
        //  1151: ldc_w           "lengthValidateApply"
        //  1154: iconst_2       
        //  1155: aload_3        
        //  1156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1159: athrow         
        //  1160: new             Lgnu/mapping/WrongType;
        //  1163: dup_x1         
        //  1164: swap           
        //  1165: ldc_w           "lengthValidateApply"
        //  1168: iconst_3       
        //  1169: aload           4
        //  1171: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1174: athrow         
        //  1175: new             Lgnu/mapping/WrongType;
        //  1178: dup_x1         
        //  1179: swap           
        //  1180: ldc_w           "lengthValidateApply"
        //  1183: iconst_4       
        //  1184: aload           5
        //  1186: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1189: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  70     73     552    566    Ljava/lang/ClassCastException;
        //  79     82     566    580    Ljava/lang/ClassCastException;
        //  89     92     580    595    Ljava/lang/ClassCastException;
        //  99     102    595    610    Ljava/lang/ClassCastException;
        //  112    115    610    624    Ljava/lang/ClassCastException;
        //  121    124    624    638    Ljava/lang/ClassCastException;
        //  131    134    638    653    Ljava/lang/ClassCastException;
        //  141    144    653    668    Ljava/lang/ClassCastException;
        //  154    157    668    682    Ljava/lang/ClassCastException;
        //  163    166    682    696    Ljava/lang/ClassCastException;
        //  173    176    696    711    Ljava/lang/ClassCastException;
        //  183    186    711    726    Ljava/lang/ClassCastException;
        //  196    199    726    740    Ljava/lang/ClassCastException;
        //  205    208    740    754    Ljava/lang/ClassCastException;
        //  215    218    754    769    Ljava/lang/ClassCastException;
        //  225    228    769    784    Ljava/lang/ClassCastException;
        //  238    241    784    798    Ljava/lang/ClassCastException;
        //  247    250    798    812    Ljava/lang/ClassCastException;
        //  257    260    812    827    Ljava/lang/ClassCastException;
        //  267    270    827    842    Ljava/lang/ClassCastException;
        //  280    283    842    856    Ljava/lang/ClassCastException;
        //  289    292    856    870    Ljava/lang/ClassCastException;
        //  299    302    870    885    Ljava/lang/ClassCastException;
        //  309    312    885    900    Ljava/lang/ClassCastException;
        //  322    325    900    914    Ljava/lang/ClassCastException;
        //  331    334    914    928    Ljava/lang/ClassCastException;
        //  341    344    928    943    Ljava/lang/ClassCastException;
        //  351    354    943    958    Ljava/lang/ClassCastException;
        //  364    367    958    972    Ljava/lang/ClassCastException;
        //  373    376    972    986    Ljava/lang/ClassCastException;
        //  383    386    986    1001   Ljava/lang/ClassCastException;
        //  393    396    1001   1016   Ljava/lang/ClassCastException;
        //  406    409    1016   1030   Ljava/lang/ClassCastException;
        //  415    418    1030   1044   Ljava/lang/ClassCastException;
        //  425    428    1044   1059   Ljava/lang/ClassCastException;
        //  435    438    1059   1074   Ljava/lang/ClassCastException;
        //  448    451    1074   1088   Ljava/lang/ClassCastException;
        //  458    461    1088   1102   Ljava/lang/ClassCastException;
        //  469    472    1102   1117   Ljava/lang/ClassCastException;
        //  479    482    1117   1132   Ljava/lang/ClassCastException;
        //  504    507    1132   1146   Ljava/lang/ClassCastException;
        //  513    516    1146   1160   Ljava/lang/ClassCastException;
        //  523    526    1160   1175   Ljava/lang/ClassCastException;
        //  533    536    1175   1190   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 565 out of bounds for length 565
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
