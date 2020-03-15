// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import gnu.mapping.Procedure;
import java.lang.reflect.InvocationHandler;

public class ProceduralProxy implements InvocationHandler
{
    Procedure proc;
    
    public ProceduralProxy(final Procedure proc) {
        this.proc = proc;
    }
    
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            try {
                return method.invoke(proxy, args);
            }
            catch (InvocationTargetException ex) {
                final Throwable cause = ex.getCause();
                throw (cause != null) ? cause : ex;
            }
        }
        return this.proc.applyN(args);
    }
    
    public static Object makeProxy(final Class iface, final Procedure proc) {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return makeProxy(iface, proc, loader);
    }
    
    public static Object makeProxy(final Class iface, final Procedure proc, final ClassLoader loader) {
        return Proxy.newProxyInstance(iface.getClassLoader(), new Class[] { iface }, new ProceduralProxy(proc));
    }
}
