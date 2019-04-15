/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class Signals {
    private Signals() {
    }

    public static Object register(String name, Runnable handler) {
        return Signals.register(name, handler, handler.getClass().getClassLoader());
    }

    public static Object register(String name, final Runnable handler, ClassLoader loader) {
        try {
            Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
            Object signalHandler = Proxy.newProxyInstance(loader, new Class[]{signalHandlerClass}, new InvocationHandler(){

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    handler.run();
                    return null;
                }
            });
            return Signals.doRegister(name, signalHandler);
        }
        catch (Exception e) {
            return null;
        }
    }

    public static Object registerDefault(String name) {
        try {
            Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
            return Signals.doRegister(name, signalHandlerClass.getField("SIG_DFL").get(null));
        }
        catch (Exception e) {
            return null;
        }
    }

    public static Object registerIgnore(String name) {
        try {
            Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
            return Signals.doRegister(name, signalHandlerClass.getField("SIG_IGN").get(null));
        }
        catch (Exception e) {
            return null;
        }
    }

    public static void unregister(String name, Object previous) {
        try {
            if (previous != null) {
                Signals.doRegister(name, previous);
            }
        }
        catch (Exception e) {
            // empty catch block
        }
    }

    private static Object doRegister(String name, Object handler) throws Exception {
        Class<?> signalClass = Class.forName("sun.misc.Signal");
        Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
        Object signal = signalClass.getConstructor(String.class).newInstance(name);
        return signalClass.getMethod("handle", signalClass, signalHandlerClass).invoke(null, signal, handler);
    }

}

