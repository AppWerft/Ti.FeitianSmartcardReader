/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ArithOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.BitwiseOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.Procedure;
import gnu.math.IntNum;

public class CompileArith
implements Inlineable {
    int op;
    Procedure proc;
    public static CompileArith $Pl = new CompileArith(AddOp.$Pl, 1);
    public static CompileArith $Mn = new CompileArith(AddOp.$Mn, 2);

    CompileArith(Object proc, int op) {
        this.proc = (Procedure)proc;
        this.op = op;
    }

    public static CompileArith forMul(Object proc) {
        return new CompileArith(proc, 3);
    }

    public static CompileArith forDiv(Object proc) {
        return new CompileArith(proc, ((DivideOp)proc).op);
    }

    public static CompileArith forBitwise(Object proc) {
        return new CompileArith(proc, ((BitwiseOp)proc).op);
    }

    public static boolean appropriateIntConstant(Expression[] args, int iarg, InlineCalls visitor) {
        QuoteExp exp = visitor.fixIntValue(args[iarg]);
        if (exp != null) {
            args[iarg] = exp;
            return true;
        }
        return false;
    }

    public static boolean appropriateLongConstant(Expression[] args, int iarg, InlineCalls visitor) {
        QuoteExp exp = visitor.fixLongValue(args[iarg]);
        if (exp != null) {
            args[iarg] = exp;
            return true;
        }
        return false;
    }

    public static Type combineType(Type t1, Type t2) {
        int kind1 = Arithmetic.classifyType(t1);
        int kind2 = Arithmetic.classifyType(t2);
        return Arithmetic.kindType(CompileArith.getReturnKind2(kind1, kind2));
    }

    public static Expression validateApplyArithOp(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression folded;
        ArithOp aproc = (ArithOp)proc;
        int op = aproc.op;
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        if (args.length > 2) {
            return CompileArith.pairwise(proc, exp.getFunction(), args, visitor);
        }
        int rkind = 0;
        if (args.length == 2 || args.length == 1) {
            int kind1 = Arithmetic.classifyType(args[0].getType());
            if (args.length == 2 && (op < 9 || op > 12)) {
                int kind2 = Arithmetic.classifyType(args[1].getType());
                rkind = CompileArith.getReturnKind(kind1, kind2, op);
                if (rkind == 6) {
                    if (kind1 == 1 && CompileArith.appropriateIntConstant(args, 1, visitor)) {
                        rkind = 1;
                    } else if (kind2 == 1 && CompileArith.appropriateIntConstant(args, 0, visitor)) {
                        rkind = 1;
                    } else if (kind1 == 3 && CompileArith.appropriateLongConstant(args, 1, visitor)) {
                        rkind = 3;
                    } else if (kind2 == 3 && CompileArith.appropriateLongConstant(args, 0, visitor)) {
                        rkind = 3;
                    }
                }
            } else {
                rkind = kind1;
            }
            rkind = CompileArith.adjustReturnKind(rkind, op);
            exp.setType(Arithmetic.kindType(rkind));
        }
        if ((folded = exp.inlineIfConstant(proc, visitor)) != exp) {
            return folded;
        }
        if (!visitor.getCompilation().mustCompile) {
            return exp;
        }
        switch (op) {
            case 1: 
            case 2: {
                return CompileArith.validateApplyAdd((AddOp)proc, exp, visitor);
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return CompileArith.validateApplyDiv((DivideOp)proc, exp, visitor);
            }
            case 16: {
                if (rkind <= 0) break;
                return CompileArith.validateApplyNot(exp, rkind, visitor);
            }
        }
        return exp;
    }

    public void compileGeneric(ApplyExp exp, Compilation comp, Target target) {
        Expression[] args = exp.getArgs();
        int len = args.length;
        CodeAttr code = comp.getCode();
        if (len == 2) {
            switch (this.op) {
                case 1: 
                case 2: {
                    code.emitPushInt(this.op == 1 ? 1 : -1);
                    args[0].compile(comp, Target.pushObject);
                    args[1].compile(comp, Target.pushObject);
                    code.emitInvoke(ClassType.make("gnu.kawa.functions.AddOp").getDeclaredMethod("apply2", 3));
                    target.compileFromStack(comp, Type.objectType);
                    return;
                }
            }
        }
        ApplyExp.compile(exp, comp, target);
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        Type wtype;
        Expression[] args = exp.getArgs();
        int len = args.length;
        if (len == 0) {
            comp.compileConstant(((ArithOp)this.proc).defaultResult(), target);
            return;
        }
        if (len == 1 || target instanceof IgnoreTarget) {
            this.compileGeneric(exp, comp, target);
            return;
        }
        int kind1 = Arithmetic.classifyType(args[0].getType());
        int kind2 = Arithmetic.classifyType(args[1].getType());
        int kind = CompileArith.getReturnKind(kind1, kind2, this.op);
        Type type = Arithmetic.kindType(kind);
        if (kind == 0 || len != 2) {
            this.compileGeneric(exp, comp, target);
            return;
        }
        Type targetType = target.getType();
        int tkind = Arithmetic.classifyType(targetType);
        if (tkind >= 1 && tkind <= 4 && kind >= 1 && kind <= 6) {
            kind = tkind;
            wtype = Arithmetic.kindType(tkind);
        } else if ((tkind == 10 || tkind == 9) && kind > 4 && kind <= 12) {
            kind = tkind;
            wtype = tkind == 9 ? LangPrimType.floatType : LangPrimType.doubleType;
        } else if (kind == 9) {
            wtype = LangPrimType.floatType;
        } else if (kind == 10 || kind == 11) {
            kind = 10;
            wtype = LangPrimType.doubleType;
        } else {
            wtype = type;
        }
        if (this.op >= 4 && this.op <= 8) {
            DivideOp dproc = (DivideOp)this.proc;
            if (dproc.op != 4 || kind > 6 && kind < 8 && kind > 11) {
                if (dproc.op == 5 && kind <= 12 && kind != 9 || dproc.op == 4 && kind == 12) {
                    kind = 10;
                } else if ((dproc.op != 7 && (dproc.op != 6 || kind > 6) || dproc.getRoundingMode() != 3 && kind != 6 && kind != 9 && kind != 10) && (dproc.op != 8 || dproc.getRoundingMode() != 3 && kind != 6)) {
                    this.compileGeneric(exp, comp, target);
                    return;
                }
            }
        }
        if (this.op == 4 && kind <= 12 && kind != 10 && kind != 9) {
            Method meth;
            if (kind == 8 || kind > 6) {
                LangObjType ctype = kind == 8 ? Arithmetic.typeRatNum : Arithmetic.typeRealNum;
                wtype = ctype;
                meth = ctype.getDeclaredMethod("divide", 2);
            } else {
                wtype = Arithmetic.typeIntNum;
                meth = Arithmetic.typeRatNum.getDeclaredMethod("make", 2);
            }
            Target wtarget = StackTarget.getInstance(wtype);
            args[0].compile(comp, wtarget);
            args[1].compile(comp, wtarget);
            comp.getCode().emitInvokeStatic(meth);
        } else if (kind == 6 && (this.op == 1 || this.op == 3 || this.op == 2 || this.op == 13 || this.op == 14 || this.op == 15 || this.op == 7 || this.op == 8 || this.op >= 9 && this.op <= 11)) {
            this.compileIntNum(args[0], args[1], kind1, kind2, comp);
        } else if (kind == 1 || kind == 3 || (kind == 2 || kind == 4) && (this.op == 1 || this.op == 2 || this.op == 3 || this.op >= 9 && this.op <= 12 || this.op == 13 || this.op == 14 || this.op == 15) || (kind == 9 || kind == 10) && (this.op <= 8 || this.op >= 13)) {
            Target wtarget = StackTarget.getInstance(wtype);
            CodeAttr code = comp.getCode();
            for (int i = 0; i < len; ++i) {
                if (i == 1 && this.op >= 9 && this.op <= 12) {
                    wtarget = StackTarget.getInstance(Type.intType);
                }
                args[i].compile(comp, wtarget);
                if (i == 0) continue;
                if (this.op == 9) {
                    String mname;
                    switch (kind) {
                        case 1: 
                        case 3: {
                            mname = "shift";
                            break;
                        }
                        case 2: 
                        case 4: {
                            mname = "shiftUnsigned";
                            break;
                        }
                        default: {
                            mname = null;
                        }
                    }
                    Type[] margs = new Type[]{wtype, Type.intType};
                    Method method = ClassType.make("gnu.math.BitOps").getDeclaredMethod(mname, margs);
                    code.emitInvokeStatic(method);
                    continue;
                }
                switch (kind) {
                    case 2: 
                    case 4: {
                        if (this.op == 11) {
                            this.op = 12;
                        }
                    }
                    case 1: 
                    case 3: 
                    case 9: 
                    case 10: {
                        code.emitBinop(this.primitiveOpcode(), (PrimType)wtype.getImplementationType());
                    }
                }
            }
        } else {
            this.compileGeneric(exp, comp, target);
            return;
        }
        target.compileFromStack(comp, wtype);
    }

    public boolean compileIntNum(Expression arg1, Expression arg2, int kind1, int kind2, Compilation comp) {
        Type type1;
        boolean addOrMul;
        Type type2;
        boolean swap;
        if (this.op == 2 && arg2 instanceof QuoteExp) {
            boolean negateOk;
            long lval;
            Object val = arg2.valueIfConstant();
            if (kind2 <= 4) {
                lval = ((Number)val).longValue();
                negateOk = (kind2 == 4 ? lval >= 0L : lval > Integer.MIN_VALUE) && lval <= Integer.MAX_VALUE;
            } else if (val instanceof IntNum) {
                IntNum ival = (IntNum)val;
                lval = ival.longValue();
                negateOk = ival.inRange(-2147483647L, Integer.MAX_VALUE);
            } else {
                negateOk = false;
                lval = 0L;
            }
            if (negateOk) {
                return $Pl.compileIntNum(arg1, QuoteExp.getInstance((int)(-lval)), kind1, 1, comp);
            }
        }
        boolean bl = addOrMul = this.op == 1 || this.op == 3;
        if (addOrMul) {
            if (InlineCalls.checkIntValue(arg1) != null) {
                kind1 = 1;
            }
            if (InlineCalls.checkIntValue(arg2) != null) {
                kind2 = 1;
            }
            boolean bl2 = swap = kind1 == 1 && kind2 != 1;
            if (!(!swap || arg1.side_effects() && arg2.side_effects())) {
                return this.compileIntNum(arg2, arg1, kind2, kind1, comp);
            }
            type1 = kind1 == 1 ? Type.intType : Arithmetic.typeIntNum;
            type2 = kind2 == 1 ? Type.intType : Arithmetic.typeIntNum;
        } else if (this.op >= 9 && this.op <= 12) {
            type1 = Arithmetic.typeIntNum;
            type2 = Type.intType;
            swap = false;
        } else {
            type1 = type2 = Arithmetic.typeIntNum;
            swap = false;
        }
        arg1.compile(comp, type1);
        arg2.compile(comp, type2);
        CodeAttr code = comp.getCode();
        if (swap) {
            code.emitSwap();
            type1 = Arithmetic.typeIntNum;
            type2 = LangPrimType.intType;
        }
        String mname = null;
        Type[] argTypes = null;
        ObjectType mclass = Arithmetic.typeIntNum;
        switch (this.op) {
            case 1: {
                mname = "add";
                break;
            }
            case 2: {
                mname = "sub";
                break;
            }
            case 3: {
                mname = "times";
                break;
            }
            case 13: {
                mname = "and";
            }
            case 14: {
                if (mname == null) {
                    mname = "ior";
                }
            }
            case 15: {
                if (mname == null) {
                    mname = "xor";
                }
                mclass = ClassType.make("gnu.math.BitOps");
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                mname = this.op == 8 ? "remainder" : "quotient";
                DivideOp dproc = (DivideOp)this.proc;
                if (this.op == 8 && dproc.rounding_mode == 1) {
                    mname = "modulo";
                    break;
                }
                if (dproc.rounding_mode == 3) break;
                code.emitPushInt(dproc.rounding_mode);
                argTypes = new Type[]{type1, type2, Type.intType};
                break;
            }
            case 10: 
            case 11: {
                mname = this.op == 10 ? "shiftLeft" : "shiftRight";
                mclass = ClassType.make("gnu.kawa.functions.BitwiseOp");
                break;
            }
            case 9: {
                mname = "shift";
                break;
            }
            default: {
                throw new Error();
            }
        }
        if (argTypes == null) {
            argTypes = new Type[]{type1, type2};
        }
        Method meth = mclass.getMethod(mname, argTypes);
        code.emitInvokeStatic(meth);
        return true;
    }

    public static int getReturnKind(int kind1, int kind2, int op) {
        if (op >= 9 && op <= 12) {
            return kind1;
        }
        return CompileArith.getReturnKind2(kind1, kind2);
    }

    private static int getReturnKind2(int kind1, int kind2) {
        return kind1 <= 0 || kind1 > kind2 && kind2 > 0 ? kind1 : kind2;
    }

    public int getReturnKind(Expression[] args) {
        int len = args.length;
        if (len == 0) {
            return 6;
        }
        ClassType type = Type.pointer_type;
        int kindr = 0;
        for (int i = 0; i < len; ++i) {
            Expression arg = args[i];
            int kind = Arithmetic.classifyType(arg.getType());
            if (i != 0 && kind != 0 && kind <= kindr) continue;
            kindr = kind;
        }
        return kindr;
    }

    public Type getReturnType(Expression[] args) {
        return Arithmetic.kindType(CompileArith.adjustReturnKind(this.getReturnKind(args), this.op));
    }

    static int adjustReturnKind(int rkind, int op) {
        if (op >= 4 && op <= 7 && rkind > 0) {
            switch (op) {
                case 4: {
                    if (rkind > 6) break;
                    rkind = 8;
                    break;
                }
                case 5: {
                    if (rkind > 12 || rkind == 9) break;
                    rkind = 10;
                    break;
                }
                case 7: {
                    if (rkind > 12) break;
                    rkind = 6;
                }
            }
        }
        return rkind;
    }

    public static Expression validateApplyAdd(AddOp proc, ApplyExp exp, InlineCalls visitor) {
        Type type0;
        Expression[] args = exp.getArgs();
        if (args.length == 1 && proc.plusOrMinus < 0 && (type0 = args[0].getType()) instanceof PrimType) {
            char sig0 = type0.getSignature().charAt(0);
            PrimType type = null;
            int opcode = 0;
            if (sig0 != 'V' && sig0 != 'Z' && sig0 != 'C') {
                if (sig0 == 'D') {
                    opcode = 119;
                    type = LangPrimType.doubleType;
                } else if (sig0 == 'F') {
                    opcode = 118;
                    type = LangPrimType.floatType;
                } else if (sig0 == 'J') {
                    opcode = 117;
                    type = LangPrimType.longType;
                } else {
                    opcode = 116;
                    type = LangPrimType.intType;
                }
            }
            if (type != null) {
                PrimProcedure prim = PrimProcedure.makeBuiltinUnary(opcode, type);
                return new ApplyExp(prim, args);
            }
        }
        return exp;
    }

    public static Expression validateApplyDiv(DivideOp proc, ApplyExp exp, InlineCalls visitor) {
        Expression[] args = exp.getArgs();
        if (args.length == 1) {
            args = new Expression[]{QuoteExp.getInstance(IntNum.one()), args[0]};
            exp = new ApplyExp(exp.getFunction(), args);
        }
        return exp;
    }

    public static Expression validateApplyNot(ApplyExp exp, int kind, InlineCalls visitor) {
        if (exp.getArgCount() == 1) {
            Expression arg = exp.getArg(0);
            if (kind == 1 || kind == 3) {
                Expression[] args = new Expression[]{arg, QuoteExp.getInstance(IntNum.minusOne())};
                return visitor.visitApplyOnly(new ApplyExp(BitwiseOp.xor, args), null);
            }
            String cname = kind == 6 ? "gnu.math.BitOps" : (kind == 5 ? "java.meth.BigInteger" : null);
            if (cname != null) {
                return new ApplyExp(ClassType.make(cname).getDeclaredMethod("not", 1), exp.getArgs());
            }
        }
        return exp;
    }

    public int primitiveOpcode() {
        switch (this.op) {
            case 1: {
                return 96;
            }
            case 2: {
                return 100;
            }
            case 3: {
                return 104;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                return 108;
            }
            case 8: {
                return 112;
            }
            case 10: {
                return 120;
            }
            case 11: {
                return 122;
            }
            case 12: {
                return 124;
            }
            case 13: {
                return 126;
            }
            case 14: {
                return 128;
            }
            case 15: {
                return 130;
            }
        }
        return -1;
    }

    public static Expression pairwise(Procedure proc, Expression rproc, Expression[] args, InlineCalls visitor) {
        int len = args.length;
        Expression prev = args[0];
        for (int i = 1; i < len; ++i) {
            Expression[] args2 = new Expression[]{prev, args[i]};
            ApplyExp next = new ApplyExp(rproc, args2);
            Expression inlined = visitor.maybeInline(next, null, proc);
            prev = inlined != null ? inlined : next;
        }
        return prev;
    }
}

