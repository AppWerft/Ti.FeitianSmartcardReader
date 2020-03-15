// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ModuleInfo;
import java.util.List;
import java.util.RandomAccess;
import gnu.lists.Sequences;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import gnu.kawa.reflect.Invoke;
import gnu.expr.LetExp;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.kawa.functions.MakeSplice;
import gnu.lists.FVector;
import gnu.expr.Declaration;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.functions.Convert;
import kawa.lib.kawa.expressions;
import kawa.lib.kawa.string-cursors;
import gnu.mapping.Procedure;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;
import gnu.bytecode.ArrayType;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.Compilation;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.bytecode.ClassType;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class compile_map extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static ScanHelper scannerFor(final Expression exp, final Type etype, final Compilation comp) {
        final Type stype = exp.getType();
        ScanHelper scanHelper;
        if (stype.isSubtype(LangObjType.listType)) {
            (scanHelper = new ListScanner()).comp = comp;
        }
        else {
            final Type type = stype;
            if (type instanceof ArrayType) {
                final Type etype2 = ((ArrayType)type).getComponentType();
                final ArrayScanner arrayScanner = (ArrayScanner)(scanHelper = new ArrayScanner());
                arrayScanner.comp = comp;
                arrayScanner.elementType = etype2;
            }
            else if (stype.isSubtype(Type.make(compile_map.Lit0))) {
                (scanHelper = new StringScanner()).comp = comp;
            }
            else if (stype.isSubtype(Type.make(compile_map.Lit1)) && stype.isSubtype(Type.make(compile_map.Lit2))) {
                (scanHelper = new VectorScanner()).comp = comp;
            }
            else if (stype.isSubtype(Type.make(compile_map.Lit3))) {
                final IterableScanner iterableScanner = (IterableScanner)(scanHelper = new IterableScanner());
                iterableScanner.comp = comp;
                iterableScanner.useGeneric = false;
            }
            else {
                final IterableScanner iterableScanner2 = (IterableScanner)(scanHelper = new IterableScanner());
                iterableScanner2.comp = comp;
                iterableScanner2.useGeneric = true;
            }
        }
        return scanHelper;
    }
    
    public static Expression stringCursorForEachValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_2       
        //     2: iconst_4       
        //     3: invokevirtual   gnu/expr/ApplyExp.isSimple:(II)Z
        //     6: ifeq            383
        //     9: invokestatic    kawa/lib/kawa/expressions.getCompilation:()Lgnu/expr/Compilation;
        //    12: astore          5
        //    14: aload_0         /* exp */
        //    15: iconst_0       
        //    16: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //    19: astore          func
        //    21: aload           comp
        //    23: invokevirtual   gnu/expr/Compilation.letStart:()V
        //    26: aload           comp
        //    28: aconst_null    
        //    29: getstatic       gnu/kawa/lispexpr/LangObjType.stringType:Lgnu/kawa/lispexpr/LangObjType;
        //    32: aload_0         /* exp */
        //    33: iconst_1       
        //    34: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //    37: invokevirtual   gnu/expr/Compilation.letVariable:(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
        //    40: astore          seqDecl
        //    42: aload           comp
        //    44: aconst_null    
        //    45: getstatic       gnu/kawa/lispexpr/LangPrimType.stringCursorType:Lgnu/kawa/lispexpr/LangPrimType;
        //    48: aload_0         /* exp */
        //    49: invokevirtual   gnu/expr/ApplyExp.getArgCount:()I
        //    52: iconst_2       
        //    53: if_icmple       64
        //    56: aload_0         /* exp */
        //    57: iconst_2       
        //    58: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //    61: goto            86
        //    64: getstatic       gnu/kawa/functions/Convert.as:Lgnu/kawa/functions/Convert;
        //    67: iconst_2       
        //    68: anewarray       Ljava/lang/Object;
        //    71: dup            
        //    72: iconst_0       
        //    73: getstatic       gnu/kawa/lispexpr/LangPrimType.stringCursorType:Lgnu/kawa/lispexpr/LangPrimType;
        //    76: aastore        
        //    77: dup            
        //    78: iconst_1       
        //    79: getstatic       kawa/lib/compile_map.Lit4:Lgnu/math/IntNum;
        //    82: aastore        
        //    83: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //    86: invokevirtual   gnu/expr/Compilation.letVariable:(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
        //    89: astore          idxDecl
        //    91: aload           comp
        //    93: aconst_null    
        //    94: getstatic       gnu/kawa/lispexpr/LangPrimType.stringCursorType:Lgnu/kawa/lispexpr/LangPrimType;
        //    97: aload_0         /* exp */
        //    98: invokevirtual   gnu/expr/ApplyExp.getArgCount:()I
        //   101: iconst_3       
        //   102: if_icmple       113
        //   105: aload_0         /* exp */
        //   106: iconst_3       
        //   107: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //   110: goto            128
        //   113: getstatic       kawa/lib/kawa/string-cursors.string$Mncursor$Mnend:Lgnu/expr/ModuleMethod;
        //   116: iconst_1       
        //   117: anewarray       Ljava/lang/Object;
        //   120: dup            
        //   121: iconst_0       
        //   122: aload           seqDecl
        //   124: aastore        
        //   125: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   128: invokevirtual   gnu/expr/Compilation.letVariable:(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
        //   131: astore          endDecl
        //   133: aload           comp
        //   135: invokevirtual   gnu/expr/Compilation.letEnter:()V
        //   138: aload           comp
        //   140: aload           comp
        //   142: invokevirtual   gnu/expr/Compilation.loopStart:()Lgnu/expr/LambdaExp;
        //   145: astore          loopLambda
        //   147: aload           comp
        //   149: invokevirtual   gnu/expr/Compilation.loopEnter:()V
        //   152: aload           comp
        //   154: getstatic       kawa/lib/kawa/string-cursors.string$Mncursor$Ls$Qu:Lgnu/expr/ModuleMethod;
        //   157: iconst_2       
        //   158: anewarray       Ljava/lang/Object;
        //   161: dup            
        //   162: iconst_0       
        //   163: aload           idxDecl
        //   165: aastore        
        //   166: dup            
        //   167: iconst_1       
        //   168: aload           endDecl
        //   170: aastore        
        //   171: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   174: aload           comp
        //   176: invokevirtual   gnu/expr/Compilation.letStart:()V
        //   179: aload           comp
        //   181: aconst_null    
        //   182: getstatic       gnu/kawa/lispexpr/LangPrimType.characterType:Lgnu/kawa/lispexpr/LangPrimType;
        //   185: getstatic       kawa/lib/kawa/string-cursors.string$Mncursor$Mnref:Lgnu/expr/ModuleMethod;
        //   188: iconst_2       
        //   189: anewarray       Ljava/lang/Object;
        //   192: dup            
        //   193: iconst_0       
        //   194: aload           seqDecl
        //   196: aastore        
        //   197: dup            
        //   198: iconst_1       
        //   199: aload           idxDecl
        //   201: aastore        
        //   202: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   205: invokevirtual   gnu/expr/Compilation.letVariable:(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
        //   208: astore          chDecl
        //   210: aload           comp
        //   212: invokevirtual   gnu/expr/Compilation.letEnter:()V
        //   215: aload           comp
        //   217: iconst_3       
        //   218: anewarray       Ljava/lang/Object;
        //   221: dup            
        //   222: iconst_0       
        //   223: aload           func
        //   225: iconst_1       
        //   226: anewarray       Ljava/lang/Object;
        //   229: dup            
        //   230: iconst_0       
        //   231: aload           chDecl
        //   233: aastore        
        //   234: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   237: aastore        
        //   238: dup            
        //   239: iconst_1       
        //   240: aload           idxDecl
        //   242: getstatic       gnu/kawa/functions/Convert.as:Lgnu/kawa/functions/Convert;
        //   245: iconst_2       
        //   246: anewarray       Ljava/lang/Object;
        //   249: dup            
        //   250: iconst_0       
        //   251: getstatic       gnu/kawa/lispexpr/LangPrimType.stringCursorType:Lgnu/kawa/lispexpr/LangPrimType;
        //   254: aastore        
        //   255: dup            
        //   256: iconst_1       
        //   257: getstatic       gnu/kawa/functions/AddOp.$Pl:Lgnu/kawa/functions/AddOp;
        //   260: iconst_2       
        //   261: anewarray       Ljava/lang/Object;
        //   264: dup            
        //   265: iconst_0       
        //   266: getstatic       gnu/kawa/functions/Convert.as:Lgnu/kawa/functions/Convert;
        //   269: iconst_2       
        //   270: anewarray       Ljava/lang/Object;
        //   273: dup            
        //   274: iconst_0       
        //   275: getstatic       gnu/bytecode/Type.int_type:Lgnu/bytecode/PrimType;
        //   278: aastore        
        //   279: dup            
        //   280: iconst_1       
        //   281: aload           idxDecl
        //   283: aastore        
        //   284: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   287: aastore        
        //   288: dup            
        //   289: iconst_1       
        //   290: getstatic       kawa/standard/Scheme.numGrt:Lgnu/kawa/functions/NumberCompare;
        //   293: iconst_2       
        //   294: anewarray       Ljava/lang/Object;
        //   297: dup            
        //   298: iconst_0       
        //   299: getstatic       gnu/kawa/functions/Convert.as:Lgnu/kawa/functions/Convert;
        //   302: iconst_2       
        //   303: anewarray       Ljava/lang/Object;
        //   306: dup            
        //   307: iconst_0       
        //   308: getstatic       gnu/bytecode/Type.int_type:Lgnu/bytecode/PrimType;
        //   311: aastore        
        //   312: dup            
        //   313: iconst_1       
        //   314: aload           chDecl
        //   316: aastore        
        //   317: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   320: aastore        
        //   321: dup            
        //   322: iconst_1       
        //   323: getstatic       kawa/lib/compile_map.Lit5:Lgnu/math/IntNum;
        //   326: aastore        
        //   327: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   330: getstatic       kawa/lib/compile_map.Lit6:Lgnu/math/IntNum;
        //   333: getstatic       kawa/lib/compile_map.Lit7:Lgnu/math/IntNum;
        //   336: invokestatic    kawa/lib/kawa/expressions.ifExp:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/IfExp;
        //   339: aastore        
        //   340: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   343: aastore        
        //   344: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
        //   347: invokestatic    kawa/lib/kawa/expressions.setExp:(Lgnu/expr/Declaration;Ljava/lang/Object;)Lgnu/expr/SetExp;
        //   350: aastore        
        //   351: dup            
        //   352: iconst_2       
        //   353: aload           comp
        //   355: aload           loopLambda
        //   357: iconst_0       
        //   358: anewarray       Lgnu/expr/Expression;
        //   361: invokevirtual   gnu/expr/Compilation.loopRepeat:(Lgnu/expr/LambdaExp;[Lgnu/expr/Expression;)Lgnu/expr/Expression;
        //   364: aastore        
        //   365: invokestatic    kawa/lib/kawa/expressions.beginExp$V:([Ljava/lang/Object;)Lgnu/expr/BeginExp;
        //   368: invokevirtual   gnu/expr/Compilation.letDone:(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
        //   371: invokestatic    kawa/lib/kawa/expressions.ifExp:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/IfExp;
        //   374: invokevirtual   gnu/expr/Compilation.loopDone:(Lgnu/expr/Expression;)Lgnu/expr/Expression;
        //   377: invokevirtual   gnu/expr/Compilation.letDone:(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
        //   380: goto            384
        //   383: aconst_null    
        //   384: astore          ex
        //   386: aload           ex
        //   388: ifnonnull       395
        //   391: aconst_null    
        //   392: goto            421
        //   395: aload           ex
        //   397: aload_0         /* exp */
        //   398: if_acmpne       410
        //   401: aload_0         /* exp */
        //   402: aload_1         /* visitor */
        //   403: invokevirtual   gnu/expr/ApplyExp.visitArgs:(Lgnu/expr/InlineCalls;)V
        //   406: aload_0         /* exp */
        //   407: goto            421
        //   410: aload_1         /* visitor */
        //   411: aload           ex
        //   413: aload_0         /* exp */
        //   414: invokevirtual   gnu/expr/Expression.maybeSetLine:(Lgnu/expr/Expression;)Lgnu/expr/Expression;
        //   417: aload_2         /* required */
        //   418: invokevirtual   gnu/expr/InlineCalls.visit:(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
        //   421: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Expression stringForEach1ValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Expression expression;
        if (exp.isSimple(2, 2)) {
            expression = expressions.applyExp$V(string-cursors.string$Mncursor$Mnfor$Mneach, new Object[] { exp.getArg(0), exp.getArg(1) });
        }
        else if (exp.isSimple(3, 4)) {
            final Compilation comp = expressions.getCompilation();
            comp.letStart();
            final Declaration decl1 = comp.letVariable(null, LangObjType.stringType, exp.getArg(1));
            final Declaration decl2 = comp.letVariable(null, Type.int_type, exp.getArg(2));
            comp.letEnter();
            expression = comp.letDone(expressions.applyExp$V(string-cursors.string$Mncursor$Mnfor$Mneach, new Object[] { exp.getArg(0), decl1, expressions.applyExp$V(string-cursors.string$Mncursor$Mnnext, new Object[] { decl1, expressions.applyExp$V(gnu.kawa.functions.Convert.as, new Object[] { LangPrimType.stringCursorType, compile_map.Lit4 }), decl2 }), (exp.getArgCount() < 4) ? expressions.applyExp$V(string-cursors.string$Mncursor$Mnend, new Object[] { decl1 }) : expressions.applyExp$V(string-cursors.string$Mncursor$Mnnext, new Object[] { decl1, expressions.applyExp$V(gnu.kawa.functions.Convert.as, new Object[] { LangPrimType.stringCursorType, compile_map.Lit4 }), exp.getArg(3) }) }));
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
    
    public static Expression stringForEachValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Label_0222: {
            if (!exp.isSimple(3, 4)) {
                break Label_0222;
            }
            final Expression e2 = expressions.visitExp(exp.getArg(2));
            exp.setArg(2, e2);
            final Type t2 = e2.getType();
            final int integer$Mncompat = LangObjType.integerType.isCompatibleWithValue(t2);
            final boolean x = integer$Mncompat > 0;
            if (x) {
                if (!x) {
                    break Label_0222;
                }
            }
            else if (integer$Mncompat < 0 || LangObjType.stringType.isCompatibleWithValue(t2) >= 0) {
                break Label_0222;
            }
            final ModuleMethod apply$Mnexp = expressions.apply$Mnexp;
            final int n = 4;
            final Expression arg = exp.getArg(0);
            final Expression arg2 = exp.getArg(1);
            final Expression arg3 = exp.getArg(2);
            final FVector<Object> fVector = (exp.getArgCount() == 4) ? gnu.lists.FVector.makeConstant(exp.getArg(3)) : gnu.lists.FVector.makeConstant(new Object[0]);
            final int count;
            final Object[] target = new Object[(count = MakeSplice.count(fVector)) + n];
            target[0] = strings.srfi$Mn13$Mnstring$Mnfor$Mneach;
            target[1] = arg;
            target[2] = arg2;
            target[3] = arg3;
            MakeSplice.copyTo(target, 4, count, fVector);
            final Object force = Promise.force(apply$Mnexp.applyN(target), Expression.class);
            try {
                Expression validateGenericForEach = (Expression)force;
                Expression ex;
                Expression visit;
                boolean x2;
                boolean x3;
                boolean x4;
                int string$Mncompat;
                Type t3;
                Expression e3;
                public class compile_map$0 extends MapHelper
                {
                    @Override
                    public ScanHelper makeScanner(final Expression exp, final Type etype) {
                        final StringScanner stringScanner = new StringScanner();
                        stringScanner.comp = super.comp;
                        return stringScanner;
                    }
                }
                Block_11_Outer:Block_9_Outer:Block_15_Outer:Block_17_Outer:
                while (true) {
                    ex = validateGenericForEach;
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
                    Block_18: {
                        while (true) {
                            Block_12: {
                                while (true) {
                                    while (true) {
                                        while (true) {
                                            while (true) {
                                                break Block_12;
                                                Label_0385: {
                                                    validateGenericForEach = null;
                                                }
                                                continue Block_11_Outer;
                                                x2 = (exp.getArgCount() == 2);
                                                continue Block_9_Outer;
                                            }
                                            break Block_18;
                                            continue Block_15_Outer;
                                        }
                                        break Block_18;
                                        continue Block_17_Outer;
                                    }
                                    Label_0258: {
                                        x4 = (exp.getArgCount() > 4);
                                    }
                                    continue;
                                }
                            }
                            break Block_18;
                            Label_0345: {
                                break Block_18;
                            }
                            Label_0286:
                            e3 = expressions.visitExp(exp.getArg(2));
                            exp.setArg(2, e3);
                            t3 = e3.getType();
                            string$Mncompat = LangObjType.stringType.isCompatibleWithValue(t3);
                            x3 = (string$Mncompat > 0);
                            continue;
                        }
                    }
                    exp.getArgCount();
                    expressions.getCompilation();
                    validateGenericForEach = validateGenericForEach(exp, required, new compile_map$0());
                    continue Block_11_Outer;
                }
            }
            // iftrue(Label_0385:, !x2)
            // iftrue(Label_0258:, !x2)
            // iftrue(Label_0385:, !exp.isSimple(2))
            // iftrue(Label_0385:, !x3)
            // iftrue(Label_0385:, !x4)
            // iftrue(Label_0286:, !x4)
            // iftrue(Label_0385:, string$Mncompat < 0 || LangObjType.integerType.isCompatibleWithValue(t3) >= 0)
            // iftrue(Label_0345:, !x3)
            catch (ClassCastException ex2) {
                throw new WrongType(ex2, "ex", -2, force);
            }
        }
    }
    
    public static LetExp validateGenericForEach(final ApplyExp exp, final Type required, final MapHelper helper) {
        public class compile_map$frame extends ModuleBody
        {
            Expression func;
            MapHelper helper;
            
            public Object lambda1loop(final Object loopLambda, final Object comp, final Object n, final int i, final Object chlist) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     2: aload_3         /* n */
                //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //     6: checkcast       Ljava/lang/Number;
                //     9: invokevirtual   java/lang/Number.intValue:()I
                //    12: if_icmpne       253
                //    15: getstatic       kawa/lib/kawa/expressions.begin$Mnexp:Lgnu/expr/ModuleMethod;
                //    18: iconst_2       
                //    19: istore          6
                //    21: aload_0         /* this */
                //    22: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
                //    25: aload_0         /* this */
                //    26: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
                //    29: aload_0         /* this */
                //    30: getfield        kawa/lib/compile_map$frame.func:Lgnu/expr/Expression;
                //    33: aload           chlist
                //    35: ldc             Lgnu/lists/LList;.class
                //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    40: dup            
                //    41: astore          7
                //    43: checkcast       Lgnu/lists/LList;
                //    46: invokestatic    kawa/lib/lists.reverse:(Lgnu/lists/LList;)Lgnu/lists/LList;
                //    49: invokevirtual   kawa/lib/MapHelper.applyFunction:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/Expression;
                //    52: invokevirtual   kawa/lib/MapHelper.doCollect:(Lgnu/expr/Expression;)Lgnu/expr/Expression;
                //    55: astore          7
                //    57: aload_3         /* n */
                //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    61: checkcast       Ljava/lang/Number;
                //    64: invokevirtual   java/lang/Number.intValue:()I
                //    67: aload           chlist
                //    69: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //    72: astore          10
                //    74: astore          9
                //    76: istore          j
                //    78: iload           j
                //    80: ifne            88
                //    83: aload           incrs
                //    85: goto            164
                //    88: iload           j
                //    90: iconst_1       
                //    91: isub           
                //    92: istore          j1
                //    94: aload_0         /* this */
                //    95: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
                //    98: getfield        kawa/lib/MapHelper.scanners:[Lkawa/lib/ScanHelper;
                //   101: iload           j1
                //   103: aaload         
                //   104: astore          scanner
                //   106: iload           j1
                //   108: aload           chlist
                //   110: ldc             Lgnu/lists/Pair;.class
                //   112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   115: dup            
                //   116: astore          13
                //   118: checkcast       Lgnu/lists/Pair;
                //   121: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   124: aload           scanner
                //   126: aload           chlist
                //   128: ldc             Lgnu/lists/Pair;.class
                //   130: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   133: dup            
                //   134: astore          13
                //   136: checkcast       Lgnu/lists/Pair;
                //   139: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   142: ldc             Lgnu/expr/Declaration;.class
                //   144: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   147: dup            
                //   148: astore          13
                //   150: checkcast       Lgnu/expr/Declaration;
                //   153: invokevirtual   kawa/lib/ScanHelper.incr:(Lgnu/expr/Declaration;)Lgnu/expr/Expression;
                //   156: aload           incrs
                //   158: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   161: goto            72
                //   164: astore          null
                //   166: aload           8
                //   168: invokestatic    gnu/kawa/functions/MakeSplice.count:(Ljava/lang/Object;)I
                //   171: dup            
                //   172: istore          9
                //   174: iload           6
                //   176: iadd           
                //   177: istore          6
                //   179: iload           6
                //   181: anewarray       Ljava/lang/Object;
                //   184: dup            
                //   185: iconst_0       
                //   186: aload           7
                //   188: aastore        
                //   189: dup            
                //   190: iconst_1       
                //   191: istore          10
                //   193: iload           10
                //   195: iload           9
                //   197: aload           8
                //   199: invokestatic    gnu/kawa/functions/MakeSplice.copyTo:([Ljava/lang/Object;IILjava/lang/Object;)V
                //   202: iload           10
                //   204: iload           9
                //   206: iadd           
                //   207: istore          10
                //   209: dup            
                //   210: iload           10
                //   212: aload_2         /* comp */
                //   213: ldc             Lgnu/expr/Compilation;.class
                //   215: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   218: dup            
                //   219: astore          11
                //   221: checkcast       Lgnu/expr/Compilation;
                //   224: aload_1         /* loopLambda */
                //   225: ldc             Lgnu/expr/LambdaExp;.class
                //   227: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   230: dup            
                //   231: astore          11
                //   233: checkcast       Lgnu/expr/LambdaExp;
                //   236: iconst_0       
                //   237: anewarray       Lgnu/expr/Expression;
                //   240: invokevirtual   gnu/expr/Compilation.loopRepeat:(Lgnu/expr/LambdaExp;[Lgnu/expr/Expression;)Lgnu/expr/Expression;
                //   243: aastore        
                //   244: iinc            10, 1
                //   247: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
                //   250: goto            358
                //   253: aload_0         /* this */
                //   254: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
                //   257: getfield        kawa/lib/MapHelper.scanners:[Lkawa/lib/ScanHelper;
                //   260: iload           i
                //   262: aaload         
                //   263: invokevirtual   kawa/lib/ScanHelper.test:()Lgnu/expr/Expression;
                //   266: aload_2         /* comp */
                //   267: ldc             Lgnu/expr/Compilation;.class
                //   269: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   272: dup            
                //   273: astore          6
                //   275: checkcast       Lgnu/expr/Compilation;
                //   278: invokevirtual   gnu/expr/Compilation.letStart:()V
                //   281: aload_0         /* this */
                //   282: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
                //   285: getfield        kawa/lib/MapHelper.scanners:[Lkawa/lib/ScanHelper;
                //   288: iload           i
                //   290: aaload         
                //   291: invokevirtual   kawa/lib/ScanHelper.eval:()Lgnu/expr/Declaration;
                //   294: astore          chValue
                //   296: aload_2         /* comp */
                //   297: ldc             Lgnu/expr/Compilation;.class
                //   299: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   302: dup            
                //   303: astore          7
                //   305: checkcast       Lgnu/expr/Compilation;
                //   308: invokevirtual   gnu/expr/Compilation.letEnter:()V
                //   311: aload_2         /* comp */
                //   312: ldc             Lgnu/expr/Compilation;.class
                //   314: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   317: dup            
                //   318: astore          7
                //   320: checkcast       Lgnu/expr/Compilation;
                //   323: aload_0         /* this */
                //   324: aload_1         /* loopLambda */
                //   325: aload_2         /* comp */
                //   326: aload_3         /* n */
                //   327: iload           i
                //   329: iconst_1       
                //   330: iadd           
                //   331: aload           chValue
                //   333: aload           chlist
                //   335: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   338: invokevirtual   kawa/lib/compile_map$frame.lambda1loop:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
                //   341: ldc             Lgnu/expr/Expression;.class
                //   343: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   346: dup            
                //   347: astore          7
                //   349: checkcast       Lgnu/expr/Expression;
                //   352: invokevirtual   gnu/expr/Compilation.letDone:(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
                //   355: invokestatic    kawa/lib/kawa/expressions.ifExp:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/IfExp;
                //   358: areturn        
                //   359: new             Lgnu/mapping/WrongType;
                //   362: dup_x1         
                //   363: swap           
                //   364: ldc             "reverse"
                //   366: iconst_1       
                //   367: aload           7
                //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   372: athrow         
                //   373: new             Lgnu/mapping/WrongType;
                //   376: dup_x1         
                //   377: swap           
                //   378: ldc             "cdr"
                //   380: iconst_1       
                //   381: aload           13
                //   383: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   386: athrow         
                //   387: new             Lgnu/mapping/WrongType;
                //   390: dup_x1         
                //   391: swap           
                //   392: ldc             "car"
                //   394: iconst_1       
                //   395: aload           13
                //   397: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   400: athrow         
                //   401: new             Lgnu/mapping/WrongType;
                //   404: dup_x1         
                //   405: swap           
                //   406: ldc             "kawa.lib.ScanHelper.incr(gnu.expr.Declaration)"
                //   408: iconst_2       
                //   409: aload           13
                //   411: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   414: athrow         
                //   415: new             Lgnu/mapping/WrongType;
                //   418: dup_x1         
                //   419: swap           
                //   420: ldc             "gnu.expr.Compilation.loopRepeat(gnu.expr.LambdaExp,gnu.expr.Expression[])"
                //   422: iconst_1       
                //   423: aload           11
                //   425: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   428: athrow         
                //   429: new             Lgnu/mapping/WrongType;
                //   432: dup_x1         
                //   433: swap           
                //   434: ldc             "gnu.expr.Compilation.loopRepeat(gnu.expr.LambdaExp,gnu.expr.Expression[])"
                //   436: iconst_2       
                //   437: aload           11
                //   439: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   442: athrow         
                //   443: new             Lgnu/mapping/WrongType;
                //   446: dup_x1         
                //   447: swap           
                //   448: ldc             "gnu.expr.Compilation.letStart()"
                //   450: iconst_1       
                //   451: aload           6
                //   453: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   456: athrow         
                //   457: new             Lgnu/mapping/WrongType;
                //   460: dup_x1         
                //   461: swap           
                //   462: ldc             "gnu.expr.Compilation.letEnter()"
                //   464: iconst_1       
                //   465: aload           7
                //   467: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   470: athrow         
                //   471: new             Lgnu/mapping/WrongType;
                //   474: dup_x1         
                //   475: swap           
                //   476: ldc             "gnu.expr.Compilation.letDone(gnu.expr.Expression)"
                //   478: iconst_1       
                //   479: aload           7
                //   481: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   484: athrow         
                //   485: new             Lgnu/mapping/WrongType;
                //   488: dup_x1         
                //   489: swap           
                //   490: ldc             "gnu.expr.Compilation.letDone(gnu.expr.Expression)"
                //   492: iconst_2       
                //   493: aload           7
                //   495: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   498: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  43     46     359    373    Ljava/lang/ClassCastException;
                //  118    121    373    387    Ljava/lang/ClassCastException;
                //  136    139    387    401    Ljava/lang/ClassCastException;
                //  150    153    401    415    Ljava/lang/ClassCastException;
                //  221    224    415    429    Ljava/lang/ClassCastException;
                //  233    236    429    443    Ljava/lang/ClassCastException;
                //  275    278    443    457    Ljava/lang/ClassCastException;
                //  305    308    457    471    Ljava/lang/ClassCastException;
                //  320    323    471    485    Ljava/lang/ClassCastException;
                //  349    352    485    499    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   kawa/lib/compile_map$frame.<init>:()V
        //     7: astore_3        /* $heapFrame */
        //     8: aload_3         /* $heapFrame */
        //     9: aload_2         /* helper */
        //    10: putfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
        //    13: aload_0         /* exp */
        //    14: invokevirtual   gnu/expr/ApplyExp.getArgCount:()I
        //    17: iconst_1       
        //    18: isub           
        //    19: istore          4
        //    21: invokestatic    kawa/lib/kawa/expressions.getCompilation:()Lgnu/expr/Compilation;
        //    24: astore          5
        //    26: aload_0         /* exp */
        //    27: iconst_0       
        //    28: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //    31: aload_3         /* $heapFrame */
        //    32: swap           
        //    33: putfield        kawa/lib/compile_map$frame.func:Lgnu/expr/Expression;
        //    36: aload           comp
        //    38: invokevirtual   gnu/expr/Compilation.letStart:()V
        //    41: aload_3         /* $heapFrame */
        //    42: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
        //    45: aload           comp
        //    47: putfield        kawa/lib/MapHelper.comp:Lgnu/expr/Compilation;
        //    50: aload_3         /* $heapFrame */
        //    51: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
        //    54: iload           n
        //    56: anewarray       Lkawa/lib/ScanHelper;
        //    59: putfield        kawa/lib/MapHelper.scanners:[Lkawa/lib/ScanHelper;
        //    62: iconst_0       
        //    63: istore          i
        //    65: iload           i
        //    67: iload           n
        //    69: if_icmpeq       104
        //    72: aload_3         /* $heapFrame */
        //    73: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
        //    76: getfield        kawa/lib/MapHelper.scanners:[Lkawa/lib/ScanHelper;
        //    79: iload           i
        //    81: aload_3         /* $heapFrame */
        //    82: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
        //    85: aload_0         /* exp */
        //    86: iload           i
        //    88: iconst_1       
        //    89: iadd           
        //    90: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //    93: aconst_null    
        //    94: invokevirtual   kawa/lib/MapHelper.makeScanner:(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lkawa/lib/ScanHelper;
        //    97: aastore        
        //    98: iinc            i, 1
        //   101: goto            65
        //   104: aload_3         /* $heapFrame */
        //   105: getfield        kawa/lib/compile_map$frame.func:Lgnu/expr/Expression;
        //   108: invokevirtual   gnu/expr/Expression.side_effects:()Z
        //   111: ifeq            136
        //   114: aload_3         /* $heapFrame */
        //   115: new             Lgnu/expr/ReferenceExp;
        //   118: dup            
        //   119: aload           comp
        //   121: aconst_null    
        //   122: aconst_null    
        //   123: aload_3         /* $heapFrame */
        //   124: getfield        kawa/lib/compile_map$frame.func:Lgnu/expr/Expression;
        //   127: invokevirtual   gnu/expr/Compilation.letVariable:(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
        //   130: invokespecial   gnu/expr/ReferenceExp.<init>:(Lgnu/expr/Declaration;)V
        //   133: putfield        kawa/lib/compile_map$frame.func:Lgnu/expr/Expression;
        //   136: iconst_1       
        //   137: istore          i
        //   139: iload           i
        //   141: iload           n
        //   143: if_icmpgt       188
        //   146: aload_0         /* exp */
        //   147: iload           i
        //   149: invokevirtual   gnu/expr/ApplyExp.getArg:(I)Lgnu/expr/Expression;
        //   152: invokestatic    kawa/lib/kawa/expressions.visitExp:(Lgnu/expr/Expression;)Lgnu/expr/Expression;
        //   155: astore          arg
        //   157: aload_0         /* exp */
        //   158: iload           i
        //   160: aload           arg
        //   162: invokevirtual   gnu/expr/ApplyExp.setArg:(ILgnu/expr/Expression;)V
        //   165: aload_3         /* $heapFrame */
        //   166: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
        //   169: getfield        kawa/lib/MapHelper.scanners:[Lkawa/lib/ScanHelper;
        //   172: iload           i
        //   174: iconst_1       
        //   175: isub           
        //   176: aaload         
        //   177: aload           arg
        //   179: invokevirtual   kawa/lib/ScanHelper.init:(Lgnu/expr/Expression;)V
        //   182: iinc            i, 1
        //   185: goto            139
        //   188: aload_3         /* $heapFrame */
        //   189: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
        //   192: aload_0         /* exp */
        //   193: aload           comp
        //   195: invokevirtual   kawa/lib/MapHelper.initialize:(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;)V
        //   198: aload           comp
        //   200: invokevirtual   gnu/expr/Compilation.letEnter:()V
        //   203: aload           comp
        //   205: aload           comp
        //   207: invokevirtual   gnu/expr/Compilation.loopStart:()Lgnu/expr/LambdaExp;
        //   210: astore          loopLambda
        //   212: aload           comp
        //   214: invokevirtual   gnu/expr/Compilation.loopEnter:()V
        //   217: aload_3         /* $heapFrame */
        //   218: getfield        kawa/lib/compile_map$frame.helper:Lkawa/lib/MapHelper;
        //   221: aload           comp
        //   223: aload_3         /* $heapFrame */
        //   224: aload           loopLambda
        //   226: aload           comp
        //   228: iload           n
        //   230: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   233: iconst_0       
        //   234: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   237: invokevirtual   kawa/lib/compile_map$frame.lambda1loop:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
        //   240: ldc             Lgnu/expr/Expression;.class
        //   242: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   245: dup            
        //   246: astore          7
        //   248: checkcast       Lgnu/expr/Expression;
        //   251: invokevirtual   gnu/expr/Compilation.loopDone:(Lgnu/expr/Expression;)Lgnu/expr/Expression;
        //   254: invokevirtual   kawa/lib/MapHelper.collectResult:(Lgnu/expr/Expression;)Lgnu/expr/Expression;
        //   257: invokevirtual   gnu/expr/Compilation.letDone:(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
        //   260: areturn        
        //   261: new             Lgnu/mapping/WrongType;
        //   264: dup_x1         
        //   265: swap           
        //   266: ldc_w           "gnu.expr.Compilation.loopDone(gnu.expr.Expression)"
        //   269: iconst_2       
        //   270: aload           7
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  248    251    261    276    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Expression listForEachValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression ex = exp.isSimple(2) ? validateGenericForEach(exp, required, new ListMapHelper()) : null;
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
    
    public static Expression listMapValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        Expression validateGenericForEach;
        if (exp.isSimple(2)) {
            final ListMapHelper helper = new ListMapHelper();
            helper.collecting = true;
            validateGenericForEach = validateGenericForEach(exp, required, helper);
        }
        else {
            validateGenericForEach = null;
        }
        final Expression ex = validateGenericForEach;
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
    
    public static Expression vectorForEachValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        public class compile_map$1 extends MapHelper
        {
            @Override
            public ScanHelper makeScanner(final Expression exp, final Type etype) {
                final VectorScanner vectorScanner = new VectorScanner();
                vectorScanner.comp = super.comp;
                return vectorScanner;
            }
        }
        final Expression ex = exp.isSimple(2) ? validateGenericForEach(exp, required, new compile_map$1()) : null;
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
    
    public static Expression vectorMapValidateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        public class compile_map$2 extends MapHelper
        {
            public Declaration idxDecl;
            public Declaration resultDecl;
            
            @Override
            public ScanHelper makeScanner(final Expression exp, final Type etype) {
                return compile_map.scannerFor(exp, etype, super.comp);
            }
            
            @Override
            public void initialize(final ApplyExp exp, final Compilation comp) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getfield        kawa/lib/MapHelper.scanners:[Lkawa/lib/ScanHelper;
                //     4: arraylength    
                //     5: iconst_1       
                //     6: if_icmpne       104
                //     9: aload_0         /* this */
                //    10: getfield        kawa/lib/MapHelper.scanners:[Lkawa/lib/ScanHelper;
                //    13: iconst_0       
                //    14: aaload         
                //    15: astore_3       
                //    16: aload_3        
                //    17: instanceof      Lkawa/lib/VectorScanner;
                //    20: ifeq            104
                //    23: aload_3        
                //    24: checkcast       Lkawa/lib/VectorScanner;
                //    27: astore          4
                //    29: aload_0         /* this */
                //    30: aload           4
                //    32: getfield        kawa/lib/VectorScanner.idxDecl:Lgnu/expr/Declaration;
                //    35: putfield        kawa/lib/compile_map$2.idxDecl:Lgnu/expr/Declaration;
                //    38: aload_0         /* this */
                //    39: aload_2         /* comp */
                //    40: aconst_null    
                //    41: getstatic       kawa/lib/compile_map.FVector:Ljava/lang/Class;
                //    44: invokestatic    gnu/bytecode/Type.make:(Ljava/lang/Class;)Lgnu/bytecode/Type;
                //    47: getstatic       kawa/lib/compile_map.FVector:Ljava/lang/Class;
                //    50: iconst_1       
                //    51: anewarray       Ljava/lang/Object;
                //    54: dup            
                //    55: iconst_0       
                //    56: getstatic       gnu/kawa/functions/Convert.as:Lgnu/kawa/functions/Convert;
                //    59: iconst_2       
                //    60: anewarray       Ljava/lang/Object;
                //    63: dup            
                //    64: iconst_0       
                //    65: getstatic       gnu/bytecode/Type.int_type:Lgnu/bytecode/PrimType;
                //    68: aastore        
                //    69: dup            
                //    70: iconst_1       
                //    71: aload           4
                //    73: getfield        kawa/lib/VectorScanner.endDecl:Lgnu/expr/Declaration;
                //    76: aastore        
                //    77: invokestatic    kawa/lib/kawa/expressions.applyExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
                //    80: aastore        
                //    81: invokestatic    kawa/lib/kawa/expressions.applyToArgsExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //    84: ldc             Lgnu/expr/Expression;.class
                //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    89: dup            
                //    90: astore          5
                //    92: checkcast       Lgnu/expr/Expression;
                //    95: invokevirtual   gnu/expr/Compilation.letVariable:(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
                //    98: putfield        kawa/lib/compile_map$2.resultDecl:Lgnu/expr/Declaration;
                //   101: goto            139
                //   104: aload_0         /* this */
                //   105: aload_2         /* comp */
                //   106: aconst_null    
                //   107: getstatic       kawa/lib/compile_map.FVector:Ljava/lang/Class;
                //   110: invokestatic    gnu/bytecode/Type.make:(Ljava/lang/Class;)Lgnu/bytecode/Type;
                //   113: getstatic       kawa/lib/compile_map.FVector:Ljava/lang/Class;
                //   116: iconst_0       
                //   117: anewarray       Ljava/lang/Object;
                //   120: invokestatic    kawa/lib/kawa/expressions.applyToArgsExp$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //   123: ldc             Lgnu/expr/Expression;.class
                //   125: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   128: dup            
                //   129: astore_3       
                //   130: checkcast       Lgnu/expr/Expression;
                //   133: invokevirtual   gnu/expr/Compilation.letVariable:(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
                //   136: putfield        kawa/lib/compile_map$2.resultDecl:Lgnu/expr/Declaration;
                //   139: return         
                //   140: new             Lgnu/mapping/WrongType;
                //   143: dup_x1         
                //   144: swap           
                //   145: ldc             "gnu.expr.Compilation.letVariable(java.lang.Object,type,gnu.expr.Expression)"
                //   147: iconst_4       
                //   148: aload           5
                //   150: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   153: athrow         
                //   154: new             Lgnu/mapping/WrongType;
                //   157: dup_x1         
                //   158: swap           
                //   159: ldc             "gnu.expr.Compilation.letVariable(java.lang.Object,type,gnu.expr.Expression)"
                //   161: iconst_4       
                //   162: aload_3        
                //   163: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   166: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  92     95     140    154    Ljava/lang/ClassCastException;
                //  130    133    154    167    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0139:
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            public Expression doCollect(final Expression value) {
                return (this.idxDecl != null) ? expressions.applyExp$V(Invoke.invoke, new Object[] { this.resultDecl, compile_map.Lit8, this.idxDecl, value }) : expressions.applyExp$V(Invoke.invoke, new Object[] { this.resultDecl, compile_map.Lit9, value });
            }
            
            @Override
            public Expression collectResult(final Expression result) {
                return expressions.beginExp$V(new Object[] { result, this.resultDecl });
            }
        }
        final Expression ex = exp.isSimple(2) ? validateGenericForEach(exp, required, new compile_map$2()) : null;
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
        compile_map.$instance = new compile_map();
        ScanHelper = ScanHelper.class;
        final compile_map $instance = compile_map.$instance;
        scanner$Mnfor = new ModuleMethod($instance, 1, compile_map.Lit24, 12291);
        MapHelper = MapHelper.class;
        stringCursorForEachValidateApply = new ModuleMethod($instance, 2, compile_map.Lit25, 16388);
        stringForEach1ValidateApply = new ModuleMethod($instance, 3, compile_map.Lit26, 16388);
        StringScanner = StringScanner.class;
        stringForEachValidateApply = new ModuleMethod($instance, 4, compile_map.Lit27, 16388);
        IterableScanner = IterableScanner.class;
        ListScanner = ListScanner.class;
        ListMapHelper = ListMapHelper.class;
        listForEachValidateApply = new ModuleMethod($instance, 5, compile_map.Lit28, 16388);
        listMapValidateApply = new ModuleMethod($instance, 6, compile_map.Lit29, 16388);
        ArrayScanner = ArrayScanner.class;
        VectorScanner = VectorScanner.class;
        vectorForEachValidateApply = new ModuleMethod($instance, 7, compile_map.Lit30, 16388);
        vectorMapValidateApply = new ModuleMethod($instance, 8, compile_map.Lit31, 16388);
        validate$Mngeneric$Mnfor$Mneach = new ModuleMethod($instance, 9, compile_map.Lit32, 12291);
        $runBody$();
    }
    
    public compile_map() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 9: {
                final Object force = Promise.force(arg1, ApplyExp.class);
                if (!(force instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, Type.class);
                if (!(force2 instanceof Type)) {
                    return -786430;
                }
                ctx.value2 = force2;
                final Object force3 = Promise.force(arg3, MapHelper.class);
                if (!(force3 instanceof MapHelper)) {
                    return -786429;
                }
                ctx.value3 = force3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 1: {
                final Object force4 = Promise.force(arg1, Expression.class);
                if (!(force4 instanceof Expression)) {
                    return -786431;
                }
                ctx.value1 = force4;
                final Object force5 = Promise.force(arg2, Type.class);
                if (LangObjType.coerceToTypeOrNull(force5) == null) {
                    return -786430;
                }
                ctx.value2 = force5;
                final Object force6 = Promise.force(arg3, Compilation.class);
                if (!(force6 instanceof Compilation)) {
                    return -786429;
                }
                ctx.value3 = force6;
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
            case 8: {
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
            case 7: {
                final Object force5 = Promise.force(o, ApplyExp.class);
                if (!(force5 instanceof ApplyExp)) {
                    return -786431;
                }
                ctx.value1 = force5;
                final Object force6 = Promise.force(o2, InlineCalls.class);
                if (!(force6 instanceof InlineCalls)) {
                    return -786430;
                }
                ctx.value2 = force6;
                final Object force7 = Promise.force(o3, Type.class);
                if (!(force7 instanceof Type)) {
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
            case 6: {
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
            case 5: {
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
            case 4: {
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
            case 3: {
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
            case 2: {
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
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                1: 32
        //                9: 64
        //          default: 97
        //        }
        //    32: aload_2        
        //    33: ldc             Lgnu/expr/Expression;.class
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    38: checkcast       Lgnu/expr/Expression;
        //    41: aload_3        
        //    42: ldc             Lgnu/bytecode/Type;.class
        //    44: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    47: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToType:(Ljava/lang/Object;)Lgnu/bytecode/Type;
        //    50: aload           4
        //    52: ldc             Lgnu/expr/Compilation;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: checkcast       Lgnu/expr/Compilation;
        //    60: invokestatic    kawa/lib/compile_map.scannerFor:(Lgnu/expr/Expression;Lgnu/bytecode/Type;Lgnu/expr/Compilation;)Lkawa/lib/ScanHelper;
        //    63: areturn        
        //    64: aload_2        
        //    65: ldc             Lgnu/expr/ApplyExp;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: checkcast       Lgnu/expr/ApplyExp;
        //    73: aload_3        
        //    74: ldc             Lgnu/bytecode/Type;.class
        //    76: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    79: checkcast       Lgnu/bytecode/Type;
        //    82: aload           4
        //    84: ldc_w           Lkawa/lib/MapHelper;.class
        //    87: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    90: checkcast       Lkawa/lib/MapHelper;
        //    93: invokestatic    kawa/lib/compile_map.validateGenericForEach:(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;Lkawa/lib/MapHelper;)Lgnu/expr/LetExp;
        //    96: areturn        
        //    97: aload_0        
        //    98: aload_1        
        //    99: aload_2        
        //   100: aload_3        
        //   101: aload           4
        //   103: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   106: areturn        
        //   107: new             Lgnu/mapping/WrongType;
        //   110: dup_x1         
        //   111: swap           
        //   112: ldc_w           "scanner-for"
        //   115: iconst_1       
        //   116: aload_2        
        //   117: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   120: athrow         
        //   121: new             Lgnu/mapping/WrongType;
        //   124: dup_x1         
        //   125: swap           
        //   126: ldc_w           "scanner-for"
        //   129: iconst_2       
        //   130: aload_3        
        //   131: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   134: athrow         
        //   135: new             Lgnu/mapping/WrongType;
        //   138: dup_x1         
        //   139: swap           
        //   140: ldc_w           "scanner-for"
        //   143: iconst_3       
        //   144: aload           4
        //   146: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   149: athrow         
        //   150: new             Lgnu/mapping/WrongType;
        //   153: dup_x1         
        //   154: swap           
        //   155: ldc_w           "validate-generic-for-each"
        //   158: iconst_1       
        //   159: aload_2        
        //   160: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   163: athrow         
        //   164: new             Lgnu/mapping/WrongType;
        //   167: dup_x1         
        //   168: swap           
        //   169: ldc_w           "validate-generic-for-each"
        //   172: iconst_2       
        //   173: aload_3        
        //   174: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   177: athrow         
        //   178: new             Lgnu/mapping/WrongType;
        //   181: dup_x1         
        //   182: swap           
        //   183: ldc_w           "validate-generic-for-each"
        //   186: iconst_3       
        //   187: aload           4
        //   189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   192: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  38     41     107    121    Ljava/lang/ClassCastException;
        //  47     50     121    135    Ljava/lang/ClassCastException;
        //  57     60     135    150    Ljava/lang/ClassCastException;
        //  70     73     150    164    Ljava/lang/ClassCastException;
        //  79     82     164    178    Ljava/lang/ClassCastException;
        //  90     93     178    193    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 86 out of bounds for length 86
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
        //                4: 48
        //                5: 91
        //                6: 134
        //                7: 177
        //                8: 220
        //                9: 263
        //               10: 306
        //          default: 349
        //        }
        //    48: aload_2        
        //    49: ldc             Lgnu/expr/ApplyExp;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: checkcast       Lgnu/expr/ApplyExp;
        //    57: aload_3        
        //    58: ldc             Lgnu/expr/InlineCalls;.class
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    63: checkcast       Lgnu/expr/InlineCalls;
        //    66: aload           4
        //    68: ldc             Lgnu/bytecode/Type;.class
        //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    73: checkcast       Lgnu/bytecode/Type;
        //    76: aload           5
        //    78: ldc_w           Lgnu/mapping/Procedure;.class
        //    81: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    84: checkcast       Lgnu/mapping/Procedure;
        //    87: invokestatic    kawa/lib/compile_map.stringCursorForEachValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //    90: areturn        
        //    91: aload_2        
        //    92: ldc             Lgnu/expr/ApplyExp;.class
        //    94: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    97: checkcast       Lgnu/expr/ApplyExp;
        //   100: aload_3        
        //   101: ldc             Lgnu/expr/InlineCalls;.class
        //   103: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   106: checkcast       Lgnu/expr/InlineCalls;
        //   109: aload           4
        //   111: ldc             Lgnu/bytecode/Type;.class
        //   113: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   116: checkcast       Lgnu/bytecode/Type;
        //   119: aload           5
        //   121: ldc_w           Lgnu/mapping/Procedure;.class
        //   124: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   127: checkcast       Lgnu/mapping/Procedure;
        //   130: invokestatic    kawa/lib/compile_map.stringForEach1ValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   133: areturn        
        //   134: aload_2        
        //   135: ldc             Lgnu/expr/ApplyExp;.class
        //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   140: checkcast       Lgnu/expr/ApplyExp;
        //   143: aload_3        
        //   144: ldc             Lgnu/expr/InlineCalls;.class
        //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   149: checkcast       Lgnu/expr/InlineCalls;
        //   152: aload           4
        //   154: ldc             Lgnu/bytecode/Type;.class
        //   156: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   159: checkcast       Lgnu/bytecode/Type;
        //   162: aload           5
        //   164: ldc_w           Lgnu/mapping/Procedure;.class
        //   167: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   170: checkcast       Lgnu/mapping/Procedure;
        //   173: invokestatic    kawa/lib/compile_map.stringForEachValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   176: areturn        
        //   177: aload_2        
        //   178: ldc             Lgnu/expr/ApplyExp;.class
        //   180: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   183: checkcast       Lgnu/expr/ApplyExp;
        //   186: aload_3        
        //   187: ldc             Lgnu/expr/InlineCalls;.class
        //   189: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   192: checkcast       Lgnu/expr/InlineCalls;
        //   195: aload           4
        //   197: ldc             Lgnu/bytecode/Type;.class
        //   199: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   202: checkcast       Lgnu/bytecode/Type;
        //   205: aload           5
        //   207: ldc_w           Lgnu/mapping/Procedure;.class
        //   210: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   213: checkcast       Lgnu/mapping/Procedure;
        //   216: invokestatic    kawa/lib/compile_map.listForEachValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   219: areturn        
        //   220: aload_2        
        //   221: ldc             Lgnu/expr/ApplyExp;.class
        //   223: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   226: checkcast       Lgnu/expr/ApplyExp;
        //   229: aload_3        
        //   230: ldc             Lgnu/expr/InlineCalls;.class
        //   232: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   235: checkcast       Lgnu/expr/InlineCalls;
        //   238: aload           4
        //   240: ldc             Lgnu/bytecode/Type;.class
        //   242: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   245: checkcast       Lgnu/bytecode/Type;
        //   248: aload           5
        //   250: ldc_w           Lgnu/mapping/Procedure;.class
        //   253: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   256: checkcast       Lgnu/mapping/Procedure;
        //   259: invokestatic    kawa/lib/compile_map.listMapValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   262: areturn        
        //   263: aload_2        
        //   264: ldc             Lgnu/expr/ApplyExp;.class
        //   266: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   269: checkcast       Lgnu/expr/ApplyExp;
        //   272: aload_3        
        //   273: ldc             Lgnu/expr/InlineCalls;.class
        //   275: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   278: checkcast       Lgnu/expr/InlineCalls;
        //   281: aload           4
        //   283: ldc             Lgnu/bytecode/Type;.class
        //   285: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   288: checkcast       Lgnu/bytecode/Type;
        //   291: aload           5
        //   293: ldc_w           Lgnu/mapping/Procedure;.class
        //   296: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   299: checkcast       Lgnu/mapping/Procedure;
        //   302: invokestatic    kawa/lib/compile_map.vectorForEachValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   305: areturn        
        //   306: aload_2        
        //   307: ldc             Lgnu/expr/ApplyExp;.class
        //   309: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   312: checkcast       Lgnu/expr/ApplyExp;
        //   315: aload_3        
        //   316: ldc             Lgnu/expr/InlineCalls;.class
        //   318: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   321: checkcast       Lgnu/expr/InlineCalls;
        //   324: aload           4
        //   326: ldc             Lgnu/bytecode/Type;.class
        //   328: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   331: checkcast       Lgnu/bytecode/Type;
        //   334: aload           5
        //   336: ldc_w           Lgnu/mapping/Procedure;.class
        //   339: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   342: checkcast       Lgnu/mapping/Procedure;
        //   345: invokestatic    kawa/lib/compile_map.vectorMapValidateApply:(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
        //   348: areturn        
        //   349: aload_0        
        //   350: aload_1        
        //   351: aload_2        
        //   352: aload_3        
        //   353: aload           4
        //   355: aload           5
        //   357: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   360: areturn        
        //   361: new             Lgnu/mapping/WrongType;
        //   364: dup_x1         
        //   365: swap           
        //   366: ldc_w           "stringCursorForEachValidateApply"
        //   369: iconst_1       
        //   370: aload_2        
        //   371: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   374: athrow         
        //   375: new             Lgnu/mapping/WrongType;
        //   378: dup_x1         
        //   379: swap           
        //   380: ldc_w           "stringCursorForEachValidateApply"
        //   383: iconst_2       
        //   384: aload_3        
        //   385: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   388: athrow         
        //   389: new             Lgnu/mapping/WrongType;
        //   392: dup_x1         
        //   393: swap           
        //   394: ldc_w           "stringCursorForEachValidateApply"
        //   397: iconst_3       
        //   398: aload           4
        //   400: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   403: athrow         
        //   404: new             Lgnu/mapping/WrongType;
        //   407: dup_x1         
        //   408: swap           
        //   409: ldc_w           "stringCursorForEachValidateApply"
        //   412: iconst_4       
        //   413: aload           5
        //   415: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   418: athrow         
        //   419: new             Lgnu/mapping/WrongType;
        //   422: dup_x1         
        //   423: swap           
        //   424: ldc_w           "stringForEach1ValidateApply"
        //   427: iconst_1       
        //   428: aload_2        
        //   429: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   432: athrow         
        //   433: new             Lgnu/mapping/WrongType;
        //   436: dup_x1         
        //   437: swap           
        //   438: ldc_w           "stringForEach1ValidateApply"
        //   441: iconst_2       
        //   442: aload_3        
        //   443: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   446: athrow         
        //   447: new             Lgnu/mapping/WrongType;
        //   450: dup_x1         
        //   451: swap           
        //   452: ldc_w           "stringForEach1ValidateApply"
        //   455: iconst_3       
        //   456: aload           4
        //   458: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   461: athrow         
        //   462: new             Lgnu/mapping/WrongType;
        //   465: dup_x1         
        //   466: swap           
        //   467: ldc_w           "stringForEach1ValidateApply"
        //   470: iconst_4       
        //   471: aload           5
        //   473: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   476: athrow         
        //   477: new             Lgnu/mapping/WrongType;
        //   480: dup_x1         
        //   481: swap           
        //   482: ldc_w           "stringForEachValidateApply"
        //   485: iconst_1       
        //   486: aload_2        
        //   487: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   490: athrow         
        //   491: new             Lgnu/mapping/WrongType;
        //   494: dup_x1         
        //   495: swap           
        //   496: ldc_w           "stringForEachValidateApply"
        //   499: iconst_2       
        //   500: aload_3        
        //   501: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   504: athrow         
        //   505: new             Lgnu/mapping/WrongType;
        //   508: dup_x1         
        //   509: swap           
        //   510: ldc_w           "stringForEachValidateApply"
        //   513: iconst_3       
        //   514: aload           4
        //   516: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   519: athrow         
        //   520: new             Lgnu/mapping/WrongType;
        //   523: dup_x1         
        //   524: swap           
        //   525: ldc_w           "stringForEachValidateApply"
        //   528: iconst_4       
        //   529: aload           5
        //   531: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   534: athrow         
        //   535: new             Lgnu/mapping/WrongType;
        //   538: dup_x1         
        //   539: swap           
        //   540: ldc_w           "listForEachValidateApply"
        //   543: iconst_1       
        //   544: aload_2        
        //   545: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   548: athrow         
        //   549: new             Lgnu/mapping/WrongType;
        //   552: dup_x1         
        //   553: swap           
        //   554: ldc_w           "listForEachValidateApply"
        //   557: iconst_2       
        //   558: aload_3        
        //   559: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   562: athrow         
        //   563: new             Lgnu/mapping/WrongType;
        //   566: dup_x1         
        //   567: swap           
        //   568: ldc_w           "listForEachValidateApply"
        //   571: iconst_3       
        //   572: aload           4
        //   574: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   577: athrow         
        //   578: new             Lgnu/mapping/WrongType;
        //   581: dup_x1         
        //   582: swap           
        //   583: ldc_w           "listForEachValidateApply"
        //   586: iconst_4       
        //   587: aload           5
        //   589: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   592: athrow         
        //   593: new             Lgnu/mapping/WrongType;
        //   596: dup_x1         
        //   597: swap           
        //   598: ldc_w           "listMapValidateApply"
        //   601: iconst_1       
        //   602: aload_2        
        //   603: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   606: athrow         
        //   607: new             Lgnu/mapping/WrongType;
        //   610: dup_x1         
        //   611: swap           
        //   612: ldc_w           "listMapValidateApply"
        //   615: iconst_2       
        //   616: aload_3        
        //   617: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   620: athrow         
        //   621: new             Lgnu/mapping/WrongType;
        //   624: dup_x1         
        //   625: swap           
        //   626: ldc_w           "listMapValidateApply"
        //   629: iconst_3       
        //   630: aload           4
        //   632: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   635: athrow         
        //   636: new             Lgnu/mapping/WrongType;
        //   639: dup_x1         
        //   640: swap           
        //   641: ldc_w           "listMapValidateApply"
        //   644: iconst_4       
        //   645: aload           5
        //   647: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   650: athrow         
        //   651: new             Lgnu/mapping/WrongType;
        //   654: dup_x1         
        //   655: swap           
        //   656: ldc_w           "vectorForEachValidateApply"
        //   659: iconst_1       
        //   660: aload_2        
        //   661: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   664: athrow         
        //   665: new             Lgnu/mapping/WrongType;
        //   668: dup_x1         
        //   669: swap           
        //   670: ldc_w           "vectorForEachValidateApply"
        //   673: iconst_2       
        //   674: aload_3        
        //   675: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   678: athrow         
        //   679: new             Lgnu/mapping/WrongType;
        //   682: dup_x1         
        //   683: swap           
        //   684: ldc_w           "vectorForEachValidateApply"
        //   687: iconst_3       
        //   688: aload           4
        //   690: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   693: athrow         
        //   694: new             Lgnu/mapping/WrongType;
        //   697: dup_x1         
        //   698: swap           
        //   699: ldc_w           "vectorForEachValidateApply"
        //   702: iconst_4       
        //   703: aload           5
        //   705: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   708: athrow         
        //   709: new             Lgnu/mapping/WrongType;
        //   712: dup_x1         
        //   713: swap           
        //   714: ldc_w           "vectorMapValidateApply"
        //   717: iconst_1       
        //   718: aload_2        
        //   719: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   722: athrow         
        //   723: new             Lgnu/mapping/WrongType;
        //   726: dup_x1         
        //   727: swap           
        //   728: ldc_w           "vectorMapValidateApply"
        //   731: iconst_2       
        //   732: aload_3        
        //   733: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   736: athrow         
        //   737: new             Lgnu/mapping/WrongType;
        //   740: dup_x1         
        //   741: swap           
        //   742: ldc_w           "vectorMapValidateApply"
        //   745: iconst_3       
        //   746: aload           4
        //   748: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   751: athrow         
        //   752: new             Lgnu/mapping/WrongType;
        //   755: dup_x1         
        //   756: swap           
        //   757: ldc_w           "vectorMapValidateApply"
        //   760: iconst_4       
        //   761: aload           5
        //   763: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   766: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  54     57     361    375    Ljava/lang/ClassCastException;
        //  63     66     375    389    Ljava/lang/ClassCastException;
        //  73     76     389    404    Ljava/lang/ClassCastException;
        //  84     87     404    419    Ljava/lang/ClassCastException;
        //  97     100    419    433    Ljava/lang/ClassCastException;
        //  106    109    433    447    Ljava/lang/ClassCastException;
        //  116    119    447    462    Ljava/lang/ClassCastException;
        //  127    130    462    477    Ljava/lang/ClassCastException;
        //  140    143    477    491    Ljava/lang/ClassCastException;
        //  149    152    491    505    Ljava/lang/ClassCastException;
        //  159    162    505    520    Ljava/lang/ClassCastException;
        //  170    173    520    535    Ljava/lang/ClassCastException;
        //  183    186    535    549    Ljava/lang/ClassCastException;
        //  192    195    549    563    Ljava/lang/ClassCastException;
        //  202    205    563    578    Ljava/lang/ClassCastException;
        //  213    216    578    593    Ljava/lang/ClassCastException;
        //  226    229    593    607    Ljava/lang/ClassCastException;
        //  235    238    607    621    Ljava/lang/ClassCastException;
        //  245    248    621    636    Ljava/lang/ClassCastException;
        //  256    259    636    651    Ljava/lang/ClassCastException;
        //  269    272    651    665    Ljava/lang/ClassCastException;
        //  278    281    665    679    Ljava/lang/ClassCastException;
        //  288    291    679    694    Ljava/lang/ClassCastException;
        //  299    302    694    709    Ljava/lang/ClassCastException;
        //  312    315    709    723    Ljava/lang/ClassCastException;
        //  321    324    723    737    Ljava/lang/ClassCastException;
        //  331    334    737    752    Ljava/lang/ClassCastException;
        //  342    345    752    767    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 361 out of bounds for length 361
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
