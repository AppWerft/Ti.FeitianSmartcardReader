/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.mapping.Procedure;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProceduralProxy
implements InvocationHandler {
    Procedure proc;

    public ProceduralProxy(Procedure proc) {
        this.proc = proc;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            try {
                return method.invoke(proxy, args);
            }
            catch (InvocationTargetException ex) {
                Throwable cause = ex.getCause();
                throw cause != null ? cause : ex;
            }
        }
        return this.proc.applyN(args);
    }

    public static Object makeProxy(Class iface, Procedure proc) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return ProceduralProxy.makeProxy(iface, proc, loader);
    }

    public static Object makeProxy(Class iface, Procedure proc, ClassLoader loader) {
        return Proxy.newProxyInstance(iface.getClassLoader(), new Class[]{iface}, new ProceduralProxy(proc));
    }
}

