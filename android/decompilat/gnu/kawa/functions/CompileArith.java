// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.expr.PrimProcedure;
import gnu.bytecode.ObjectType;
import gnu.math.IntNum;
import gnu.expr.QuoteExp;
import gnu.bytecode.Method;
import gnu.kawa.lispexpr.LangObjType;
import gnu.bytecode.PrimType;
import gnu.expr.StackTarget;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.expr.IgnoreTarget;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ClassType;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.expr.Inlineable;

public class CompileArith implements Inlineable
{
    int op;
    Procedure proc;
    public static CompileArith $Pl;
    public static CompileArith $Mn;
    
    CompileArith(final Object proc, final int op) {
        this.proc = (Procedure)proc;
        this.op = op;
    }
    
    public static CompileArith forMul(final Object proc) {
        return new CompileArith(proc, 3);
    }
    
    public static CompileArith forDiv(final Object proc) {
        return new CompileArith(proc, ((DivideOp)proc).op);
    }
    
    public static CompileArith forBitwise(final Object proc) {
        return new CompileArith(proc, ((BitwiseOp)proc).op);
    }
    
    public static boolean appropriateIntConstant(final Expression[] args, final int iarg, final InlineCalls visitor) {
        final Expression exp = visitor.fixIntValue(args[iarg]);
        if (exp != null) {
            args[iarg] = exp;
            return true;
        }
        return false;
    }
    
    public static boolean appropriateLongConstant(final Expression[] args, final int iarg, final InlineCalls visitor) {
        final Expression exp = visitor.fixLongValue(args[iarg]);
        if (exp != null) {
            args[iarg] = exp;
            return true;
        }
        return false;
    }
    
    public static Type combineType(final Type t1, final Type t2) {
        final int kind1 = Arithmetic.classifyType(t1);
        final int kind2 = Arithmetic.classifyType(t2);
        return Arithmetic.kindType(getReturnKind2(kind1, kind2));
    }
    
    public static Expression validateApplyArithOp(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final ArithOp aproc = (ArithOp)proc;
        final int op = aproc.op;
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        if (args.length > 2) {
            return pairwise(proc, exp.getFunction(), args, visitor);
        }
        int rkind = 0;
        if (args.length == 2 || args.length == 1) {
            final int kind1 = Arithmetic.classifyType(args[0].getType());
            if (args.length == 2 && (op < 9 || op > 12)) {
                final int kind2 = Arithmetic.classifyType(args[1].getType());
                rkind = getReturnKind(kind1, kind2, op);
                if (rkind == 6) {
                    if (kind1 == 1 && appropriateIntConstant(args, 1, visitor)) {
                        rkind = 1;
                    }
                    else if (kind2 == 1 && appropriateIntConstant(args, 0, visitor)) {
                        rkind = 1;
                    }
                    else if (kind1 == 3 && appropriateLongConstant(args, 1, visitor)) {
                        rkind = 3;
                    }
                    else if (kind2 == 3 && appropriateLongConstant(args, 0, visitor)) {
                        rkind = 3;
                    }
                }
            }
            else {
                rkind = kind1;
            }
            rkind = adjustReturnKind(rkind, op);
            exp.setType(Arithmetic.kindType(rkind));
        }
        final Expression folded = exp.inlineIfConstant(proc, visitor);
        if (folded != exp) {
            return folded;
        }
        if (!visitor.getCompilation().mustCompile) {
            return exp;
        }
        switch (op) {
            case 1:
            case 2: {
                return validateApplyAdd((AddOp)proc, exp, visitor);
            }
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: {
                return validateApplyDiv((DivideOp)proc, exp, visitor);
            }
            case 16: {
                if (rkind > 0) {
                    return validateApplyNot(exp, rkind, visitor);
                }
                break;
            }
        }
        return exp;
    }
    
    public void compileGeneric(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final int len = args.length;
        final CodeAttr code = comp.getCode();
        if (len == 2) {
            switch (this.op) {
                case 1:
                case 2: {
                    code.emitPushInt((this.op == 1) ? 1 : -1);
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
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final int len = args.length;
        if (len == 0) {
            comp.compileConstant(((ArithOp)this.proc).defaultResult(), target);
            return;
        }
        if (len == 1 || target instanceof IgnoreTarget) {
            this.compileGeneric(exp, comp, target);
            return;
        }
        final int kind1 = Arithmetic.classifyType(args[0].getType());
        final int kind2 = Arithmetic.classifyType(args[1].getType());
        int kind3 = getReturnKind(kind1, kind2, this.op);
        final Type type = Arithmetic.kindType(kind3);
        if (kind3 == 0 || len != 2) {
            this.compileGeneric(exp, comp, target);
            return;
        }
        final Type targetType = target.getType();
        final int tkind = Arithmetic.classifyType(targetType);
        Type wtype;
        if (tkind >= 1 && tkind <= 4 && kind3 >= 1 && kind3 <= 6) {
            kind3 = tkind;
            wtype = Arithmetic.kindType(tkind);
        }
        else if ((tkind == 10 || tkind == 9) && kind3 > 4 && kind3 <= 12) {
            kind3 = tkind;
            wtype = ((tkind == 9) ? LangPrimType.floatType : LangPrimType.doubleType);
        }
        else if (kind3 == 9) {
            wtype = LangPrimType.floatType;
        }
        else if (kind3 == 10 || kind3 == 11) {
            kind3 = 10;
            wtype = LangPrimType.doubleType;
        }
        else {
            wtype = type;
        }
        Label_0467: {
            if (this.op >= 4 && this.op <= 8) {
                final DivideOp dproc = (DivideOp)this.proc;
                if (dproc.op == 4) {
                    if (kind3 <= 6 || kind3 >= 8) {
                        break Label_0467;
                    }
                    if (kind3 <= 11) {
                        break Label_0467;
                    }
                }
                if ((dproc.op != 5 || kind3 > 12 || kind3 == 9) && (dproc.op != 4 || kind3 != 12)) {
                    if (dproc.op == 7 || (dproc.op == 6 && kind3 <= 6)) {
                        if (dproc.getRoundingMode() == 3 || kind3 == 6 || kind3 == 9) {
                            break Label_0467;
                        }
                        if (kind3 == 10) {
                            break Label_0467;
                        }
                    }
                    if (dproc.op == 8) {
                        if (dproc.getRoundingMode() == 3) {
                            break Label_0467;
                        }
                        if (kind3 == 6) {
                            break Label_0467;
                        }
                    }
                    this.compileGeneric(exp, comp, target);
                    return;
                }
                kind3 = 10;
            }
        }
        if (this.op == 4 && kind3 <= 12 && kind3 != 10 && kind3 != 9) {
            Method meth;
            if (kind3 == 8 || kind3 > 6) {
                final LangObjType ctype = (LangObjType)(wtype = ((kind3 == 8) ? Arithmetic.typeRatNum : Arithmetic.typeRealNum));
                meth = ctype.getDeclaredMethod("divide", 2);
            }
            else {
                wtype = Arithmetic.typeIntNum;
                meth = Arithmetic.typeRatNum.getDeclaredMethod("make", 2);
            }
            final Target wtarget = StackTarget.getInstance(wtype);
            args[0].compile(comp, wtarget);
            args[1].compile(comp, wtarget);
            comp.getCode().emitInvokeStatic(meth);
        }
        else if (kind3 == 6 && (this.op == 1 || this.op == 3 || this.op == 2 || this.op == 13 || this.op == 14 || this.op == 15 || this.op == 7 || this.op == 8 || (this.op >= 9 && this.op <= 11))) {
            this.compileIntNum(args[0], args[1], kind1, kind2, comp);
        }
        else {
            if (kind3 != 1 && kind3 != 3 && ((kind3 != 2 && kind3 != 4) || (this.op != 1 && this.op != 2 && this.op != 3 && (this.op < 9 || this.op > 12) && this.op != 13 && this.op != 14 && this.op != 15)) && ((kind3 != 9 && kind3 != 10) || (this.op > 8 && this.op < 13))) {
                this.compileGeneric(exp, comp, target);
                return;
            }
            Target wtarget2 = StackTarget.getInstance(wtype);
            final CodeAttr code = comp.getCode();
            for (int i = 0; i < len; ++i) {
                if (i == 1 && this.op >= 9 && this.op <= 12) {
                    wtarget2 = StackTarget.getInstance(Type.intType);
                }
                args[i].compile(comp, wtarget2);
                if (i != 0) {
                    if (this.op == 9) {
                        String mname = null;
                        switch (kind3) {
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
                                break;
                            }
                        }
                        final Type[] margs = { wtype, Type.intType };
                        final Method method = ClassType.make("gnu.math.BitOps").getDeclaredMethod(mname, margs);
                        code.emitInvokeStatic(method);
                    }
                    else {
                        switch (kind3) {
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
                                code.emitBinop(this.primitiveOpcode(), wtype.getImplementationType());
                                break;
                            }
                        }
                    }
                }
            }
        }
        target.compileFromStack(comp, wtype);
    }
    
    public boolean compileIntNum(final Expression arg1, final Expression arg2, int kind1, int kind2, final Compilation comp) {
        if (this.op == 2 && arg2 instanceof QuoteExp) {
            final Object val = arg2.valueIfConstant();
            long lval;
            boolean negateOk;
            if (kind2 <= 4) {
                lval = ((Number)val).longValue();
                boolean b = false;
                Label_0076: {
                    Label_0075: {
                        if (kind2 == 4) {
                            if (lval < 0L) {
                                break Label_0075;
                            }
                        }
                        else if (lval <= -2147483648L) {
                            break Label_0075;
                        }
                        if (lval <= 2147483647L) {
                            b = true;
                            break Label_0076;
                        }
                    }
                    b = false;
                }
                negateOk = b;
            }
            else if (val instanceof IntNum) {
                final IntNum ival = (IntNum)val;
                lval = ival.longValue();
                negateOk = ival.inRange(-2147483647L, 2147483647L);
            }
            else {
                negateOk = false;
                lval = 0L;
            }
            if (negateOk) {
                return CompileArith.$Pl.compileIntNum(arg1, QuoteExp.getInstance((int)(-lval)), kind1, 1, comp);
            }
        }
        final boolean addOrMul = this.op == 1 || this.op == 3;
        boolean swap;
        Type type1;
        Type type2;
        if (addOrMul) {
            if (InlineCalls.checkIntValue(arg1) != null) {
                kind1 = 1;
            }
            if (InlineCalls.checkIntValue(arg2) != null) {
                kind2 = 1;
            }
            swap = (kind1 == 1 && kind2 != 1);
            if (swap && (!arg1.side_effects() || !arg2.side_effects())) {
                return this.compileIntNum(arg2, arg1, kind2, kind1, comp);
            }
            type1 = ((kind1 == 1) ? Type.intType : Arithmetic.typeIntNum);
            type2 = ((kind2 == 1) ? Type.intType : Arithmetic.typeIntNum);
        }
        else if (this.op >= 9 && this.op <= 12) {
            type1 = Arithmetic.typeIntNum;
            type2 = Type.intType;
            swap = false;
        }
        else {
            type2 = (type1 = Arithmetic.typeIntNum);
            swap = false;
        }
        arg1.compile(comp, type1);
        arg2.compile(comp, type2);
        final CodeAttr code = comp.getCode();
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
                mname = ((this.op == 8) ? "remainder" : "quotient");
                final DivideOp dproc = (DivideOp)this.proc;
                if (this.op == 8 && dproc.rounding_mode == 1) {
                    mname = "modulo";
                    break;
                }
                if (dproc.rounding_mode != 3) {
                    code.emitPushInt(dproc.rounding_mode);
                    argTypes = new Type[] { type1, type2, Type.intType };
                    break;
                }
                break;
            }
            case 10:
            case 11: {
                mname = ((this.op == 10) ? "shiftLeft" : "shiftRight");
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
            argTypes = new Type[] { type1, type2 };
        }
        final Method meth = mclass.getMethod(mname, argTypes);
        code.emitInvokeStatic(meth);
        return true;
    }
    
    public static int getReturnKind(final int kind1, final int kind2, final int op) {
        if (op >= 9 && op <= 12) {
            return kind1;
        }
        return getReturnKind2(kind1, kind2);
    }
    
    private static int getReturnKind2(final int kind1, final int kind2) {
        return (kind1 <= 0 || (kind1 > kind2 && kind2 > 0)) ? kind1 : kind2;
    }
    
    public int getReturnKind(final Expression[] args) {
        final int len = args.length;
        if (len == 0) {
            return 6;
        }
        final Type type = Type.pointer_type;
        int kindr = 0;
        for (int i = 0; i < len; ++i) {
            final Expression arg = args[i];
            final int kind = Arithmetic.classifyType(arg.getType());
            if (i == 0 || kind == 0 || kind > kindr) {
                kindr = kind;
            }
        }
        return kindr;
    }
    
    public Type getReturnType(final Expression[] args) {
        return Arithmetic.kindType(adjustReturnKind(this.getReturnKind(args), this.op));
    }
    
    static int adjustReturnKind(int rkind, final int op) {
        if (op >= 4 && op <= 7 && rkind > 0) {
            switch (op) {
                case 4: {
                    if (rkind <= 6) {
                        rkind = 8;
                        break;
                    }
                    break;
                }
                case 5: {
                    if (rkind <= 12 && rkind != 9) {
                        rkind = 10;
                        break;
                    }
                    break;
                }
                case 7: {
                    if (rkind <= 12) {
                        rkind = 6;
                        break;
                    }
                    break;
                }
            }
        }
        return rkind;
    }
    
    public static Expression validateApplyAdd(final AddOp proc, final ApplyExp exp, final InlineCalls visitor) {
        final Expression[] args = exp.getArgs();
        if (args.length == 1 && proc.plusOrMinus < 0) {
            final Type type0 = args[0].getType();
            if (type0 instanceof PrimType) {
                final char sig0 = type0.getSignature().charAt(0);
                Type type2 = null;
                int opcode = 0;
                if (sig0 != 'V' && sig0 != 'Z') {
                    if (sig0 != 'C') {
                        if (sig0 == 'D') {
                            opcode = 119;
                            type2 = LangPrimType.doubleType;
                        }
                        else if (sig0 == 'F') {
                            opcode = 118;
                            type2 = LangPrimType.floatType;
                        }
                        else if (sig0 == 'J') {
                            opcode = 117;
                            type2 = LangPrimType.longType;
                        }
                        else {
                            opcode = 116;
                            type2 = LangPrimType.intType;
                        }
                    }
                }
                if (type2 != null) {
                    final PrimProcedure prim = PrimProcedure.makeBuiltinUnary(opcode, type2);
                    return new ApplyExp(prim, args);
                }
            }
        }
        return exp;
    }
    
    public static Expression validateApplyDiv(final DivideOp proc, ApplyExp exp, final InlineCalls visitor) {
        Expression[] args = exp.getArgs();
        if (args.length == 1) {
            args = new Expression[] { QuoteExp.getInstance(IntNum.one()), args[0] };
            exp = new ApplyExp(exp.getFunction(), args);
        }
        return exp;
    }
    
    public static Expression validateApplyNot(final ApplyExp exp, final int kind, final InlineCalls visitor) {
        if (exp.getArgCount() == 1) {
            final Expression arg = exp.getArg(0);
            if (kind == 1 || kind == 3) {
                final Expression[] args = { arg, QuoteExp.getInstance(IntNum.minusOne()) };
                return visitor.visitApplyOnly(new ApplyExp(BitwiseOp.xor, args), null);
            }
            String cname;
            if (kind == 6) {
                cname = "gnu.math.BitOps";
            }
            else if (kind == 5) {
                cname = "java.meth.BigInteger";
            }
            else {
                cname = null;
            }
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
            default: {
                return -1;
            }
        }
    }
    
    public static Expression pairwise(final Procedure proc, final Expression rproc, final Expression[] args, final InlineCalls visitor) {
        final int len = args.length;
        Expression prev = args[0];
        for (int i = 1; i < len; ++i) {
            final Expression[] args2 = { prev, args[i] };
            final ApplyExp next = new ApplyExp(rproc, args2);
            final Expression inlined = visitor.maybeInline(next, null, proc);
            prev = ((inlined != null) ? inlined : next);
        }
        return prev;
    }
    
    static {
        CompileArith.$Pl = new CompileArith(AddOp.$Pl, 1);
        CompileArith.$Mn = new CompileArith(AddOp.$Mn, 2);
    }
}
