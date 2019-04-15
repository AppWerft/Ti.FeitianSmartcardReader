package gnu.kawa.reflect;

import gnu.mapping.Procedure;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProceduralProxy implements java.lang.reflect.InvocationHandler
{
  Procedure proc;
  
  public ProceduralProxy(Procedure proc)
  {
    this.proc = proc;
  }
  

  public Object invoke(Object proxy, Method method, Object[] args)
    throws Throwable
  {
    if (method.getDeclaringClass() == Object.class) {
      try {
        return method.invoke(proxy, args);
      } catch (InvocationTargetException ex) {
        Throwable cause = ex.getCause();
        throw (cause != null ? cause : ex);
      }
    }
    return proc.applyN(args);
  }
  
  public static Object makeProxy(Class iface, Procedure proc) {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    return makeProxy(iface, proc, loader);
  }
  
  public static Object makeProxy(Class iface, Procedure proc, ClassLoader loader) {
    return java.lang.reflect.Proxy.newProxyInstance(iface.getClassLoader(), new Class[] { iface }, new ProceduralProxy(proc));
  }
}
