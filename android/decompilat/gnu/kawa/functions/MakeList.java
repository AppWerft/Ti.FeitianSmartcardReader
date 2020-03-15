// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.kawa.lispexpr.LangObjType;
import gnu.bytecode.Method;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.expr.Inlineable;
import gnu.mapping.ProcedureN;

public class MakeList extends ProcedureN implements Inlineable
{
    public static final MakeList list;
    
    public static Object list$V(final Object[] args) {
        Object result = LList.Empty;
        int i = args.length;
        while (--i >= 0) {
            result = new Pair(args[i], result);
        }
        return result;
    }
    
    @Override
    public Object applyN(final Object[] args) {
        return list$V(args);
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        compile(args, 0, comp);
        target.compileFromStack(comp, exp.getType());
    }
    
    public static void compile(final Expression[] args, int offset, final Compilation comp) {
        int len = args.length - offset;
        final CodeAttr code = comp.getCode();
        if (len == 0) {
            new QuoteExp(LList.Empty).compile(comp, Target.pushObject);
        }
        else if (len <= 4) {
            for (int i = 0; i < len; ++i) {
                args[offset + i].compile(comp, Target.pushObject);
            }
            final Method method = Compilation.scmListType.getDeclaredMethod("list" + len, null);
            code.emitInvokeStatic(method);
        }
        else {
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
    public Type getReturnType(final Expression[] args) {
        return (args.length > 0) ? Compilation.typePair : LangObjType.listType;
    }
    
    static {
        (list = new MakeList()).setName("list");
    }
}
