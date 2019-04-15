package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;





















































































































































































































































































































class MethodFilter
  implements Filter
{
  String name;
  int nlen;
  int modifiers;
  int modmask;
  ClassType caller;
  ObjectType receiver;
  
  public MethodFilter(String name, int modifiers, int modmask, ClassType caller, ObjectType receiver)
  {
    this.name = name;
    nlen = name.length();
    this.modifiers = modifiers;
    this.modmask = modmask;
    this.caller = caller;
    this.receiver = receiver;
  }
  
  public boolean select(Object value)
  {
    Method method = (Method)value;
    String mname = method.getName();
    int mmods = method.getModifiers();
    if (((mmods & modmask) != modifiers) || ((mmods & 0x1000) != 0) || (!mname.startsWith(name)))
    {

      return false; }
    int mlen = mname.length();
    char c;
    if ((mlen != nlen) && ((mlen != nlen + 2) || (mname.charAt(nlen) != '$') || (((c = mname.charAt(nlen + 1)) != 'V') && (c != 'X'))) && ((mlen != nlen + 4) || (!mname.endsWith("$V$X"))))
    {




      return false; }
    ClassType declaring = (receiver instanceof ClassType) ? (ClassType)receiver : method.getDeclaringClass();
    
    return (caller == null) || (caller.isAccessible(declaring, receiver, method.getModifiers()));
  }
}
