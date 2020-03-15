// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

public final class Signals
{
    private Signals() {
    }
    
    public static Object register(final String name, final Runnable handler) {
        return register(name, handler, handler.getClass().getClassLoader());
    }
    
    public static Object register(final String name, final Runnable handler, final ClassLoader loader) {
        try {
            final Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
            final Object signalHandler = Proxy.newProxyInstance(loader, new Class[] { signalHandlerClass }, new InvocationHandler() {
                @Override
                public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                    handler.run();
                    return null;
                }
            });
            return doRegister(name, signalHandler);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static Object registerDefault(final String name) {
        try {
            final Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
            return doRegister(name, signalHandlerClass.getField("SIG_DFL").get(null));
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static Object registerIgnore(final String name) {
        try {
            final Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
            return doRegister(name, signalHandlerClass.getField("SIG_IGN").get(null));
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static void unregister(final String name, final Object previous) {
        try {
            if (previous != null) {
                doRegister(name, previous);
            }
        }
        catch (Exception ex) {}
    }
    
    private static Object doRegister(final String name, final Object handler) throws Exception {
        final Class<?> signalClass = Class.forName("sun.misc.Signal");
        final Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
        final Object signal = signalClass.getConstructor(String.class).newInstance(name);
        return signalClass.getMethod("handle", signalClass, signalHandlerClass).invoke(null, signal, handler);
    }
}
