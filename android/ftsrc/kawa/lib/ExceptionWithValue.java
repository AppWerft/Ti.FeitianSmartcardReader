package kawa.lib;

import gnu.mapping.Promise;

























public class ExceptionWithValue
  extends RuntimeException
{
  public Object payload;
  
  public String getMessage() { return payload.toString(); }
  
  public static Throwable wrap(Object value) { void tmp26_23 = new ExceptionWithValue();2623payload = ((value instanceof Throwable) ? (Throwable)Promise.force(value, Throwable.class) : value);return tmp26_23; }
  
  public static Object unwrap(Object ex) { return (ex instanceof ExceptionWithValue) ? forcepayload : ex; }
  
  public ExceptionWithValue() {}
}
