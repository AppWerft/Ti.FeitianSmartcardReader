// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.bytecode.CodeAttr;
import gnu.expr.Compilation;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.math.IntNum;
import gnu.lists.TreePosition;

public final class Focus extends TreePosition
{
    static ThreadLocal current;
    public long position;
    IntNum contextPosition;
    public static final ClassType TYPE;
    static final Method getCurrentFocusMethod;
    
    public static Focus getCurrent() {
        Object obj = Focus.current.get();
        if (obj == null) {
            obj = new Focus();
            Focus.current.set(obj);
        }
        return (Focus)obj;
    }
    
    public static void compileGetCurrent(final Compilation comp) {
        final CodeAttr code = comp.getCode();
        code.emitInvoke(Focus.getCurrentFocusMethod);
    }
    
    static {
        Focus.current = new ThreadLocal();
        TYPE = ClassType.make("gnu.kawa.xml.Focus");
        getCurrentFocusMethod = Focus.TYPE.getDeclaredMethod("getCurrent", 0);
    }
}
