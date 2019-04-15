/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.expr.Compilation;
import gnu.lists.TreePosition;
import gnu.math.IntNum;

public final class Focus
extends TreePosition {
    static ThreadLocal current = new ThreadLocal();
    public long position;
    IntNum contextPosition;
    public static final ClassType TYPE = ClassType.make("gnu.kawa.xml.Focus");
    static final Method getCurrentFocusMethod = TYPE.getDeclaredMethod("getCurrent", 0);

    public static Focus getCurrent() {
        Object obj = current.get();
        if (obj == null) {
            obj = new Focus();
            current.set(obj);
        }
        return (Focus)obj;
    }

    public static void compileGetCurrent(Compilation comp) {
        CodeAttr code = comp.getCode();
        code.emitInvoke(getCurrentFocusMethod);
    }
}

