/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;

public class MakeList
extends ProcedureN
implements Inlineable {
    public static final MakeList list = new MakeList();

    public static Object list$V(Object[] args) {
        LList result = LList.Empty;
        int i = args.length;
        while (--i >= 0) {
            result = new Pair(args[i], result);
        }
        return result;
    }

    @Override
    public Object applyN(Object[] args) {
        return MakeList.list$V(args);
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        Expression[] args = exp.getArgs();
        MakeList.compile(args, 0, comp);
        target.compileFromStack(comp, exp.getType());
    }

    public static void compile(Expression[] args, int offset, Compilation comp) {
        int len = args.length - offset;
        CodeAttr code = comp.getCode();
        if (len == 0) {
            new QuoteExp(LList.Empty).compile(comp, Target.pushObject);
        } else if (len <= 4) {
            for (int i = 0; i < len; ++i) {
                args[offset + i].compile(comp, Target.pushObject);
            }
            Method method = Compilation.scmListType.getDeclaredMethod("list" + len, null);
            code.emitInvokeStatic(method);
        } else {
            args[offset].compile(comp, Target.pushObject);
            Method method = Compilation.scmListType.getDeclaredMethod("list1", null);
            code.emitInvokeStatic(method);
            code.emitDup(1);
            ++offset;
            --len;
            while (len >= 4) {
                args[offset].compile(comp, Target.pushObject);
                args[offset + 1].compile(comp, Target.pushObject);
                args[offset + 2].compile(comp, Target.pushObject);
                args[offset + 3].compile(comp, Target.pushObject);
                len -= 4;
                offset += 4;
                method = Compilation.scmListType.getDeclaredMethod("chain4", null);
                code.emitInvokeStatic(method);
            }
            while (len > 0) {
                args[offset].compile(comp, Target.pushObject);
                --len;
                ++offset;
                method = Compilation.scmListType.getDeclaredMethod("chain1", null);
                code.emitInvokeStatic(method);
            }
            code.emitPop(1);
        }
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return args.length > 0 ? Compilation.typePair : LangObjType.listType;
    }

    static {
        list.setName("list");
    }
}

