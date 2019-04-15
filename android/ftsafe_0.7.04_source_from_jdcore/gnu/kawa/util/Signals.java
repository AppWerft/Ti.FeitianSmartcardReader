package gnu.kawa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;





























public final class Signals
{
  private Signals() {}
  
  public static Object register(String name, Runnable handler)
  {
    return register(name, handler, handler.getClass().getClassLoader());
  }
  
  public static Object register(String name, Runnable handler, ClassLoader loader) {
    try {
      Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
      
      Object signalHandler = Proxy.newProxyInstance(loader, new Class[] { signalHandlerClass }, new InvocationHandler()
      {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
          val$handler.run();
          return null;
        }
      });
      return doRegister(name, signalHandler);
    }
    catch (Exception e) {}
    return null;
  }
  
  public static Object registerDefault(String name)
  {
    try {
      Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
      return doRegister(name, signalHandlerClass.getField("SIG_DFL").get(null));
    }
    catch (Exception e) {}
    return null;
  }
  
  public static Object registerIgnore(String name)
  {
    try {
      Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
      return doRegister(name, signalHandlerClass.getField("SIG_IGN").get(null));
    }
    catch (Exception e) {}
    return null;
  }
  
  public static void unregister(String name, Object previous)
  {
    try
    {
      if (previous != null) {
        doRegister(name, previous);
      }
    }
    catch (Exception e) {}
  }
  
  private static Object doRegister(String name, Object handler) throws Exception
  {
    Class<?> signalClass = Class.forName("sun.misc.Signal");
    Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
    Object signal = signalClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { name });
    return signalClass.getMethod("handle", new Class[] { signalClass, signalHandlerClass }).invoke(null, new Object[] { signal, handler });
  }
}
