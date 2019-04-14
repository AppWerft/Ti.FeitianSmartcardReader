package gnu.mapping;

import gnu.bytecode.Type;
import gnu.expr.Language;



























public class WrongType
  extends WrappedException
{
  public int number;
  public static final int ARG_UNKNOWN = -1;
  public static final int ARG_VARNAME = -2;
  public static final int ARG_DESCRIPTION = -3;
  public static final int ARG_CAST = -4;
  public String procname;
  public Procedure proc;
  public Object argValue;
  public Object expectedType;
  
  public WrongType(String name, int n, String u)
  {
    super(null, null);
    procname = name;
    number = n;
    expectedType = u;
  }
  
  public WrongType(Procedure proc, int n, ClassCastException ex)
  {
    super(ex);
    this.proc = proc;
    procname = proc.getName();
    number = n;
  }
  

  public WrongType(ClassCastException ex, Procedure proc, int n, Object argValue)
  {
    this(proc, n, ex);
    this.argValue = argValue;
  }
  
  public WrongType(Procedure proc, int n, Object argValue)
  {
    this.proc = proc;
    procname = proc.getName();
    number = n;
    this.argValue = argValue;
  }
  
  public WrongType(Procedure proc, int n, Object argValue, Type expectedType)
  {
    this.proc = proc;
    procname = proc.getName();
    number = n;
    this.argValue = argValue;
    this.expectedType = expectedType;
  }
  
  public WrongType(int n, Object argValue, Type expectedType)
  {
    number = n;
    this.argValue = argValue;
    this.expectedType = expectedType;
  }
  
  public WrongType(Procedure proc, int n, Object argValue, String expectedType)
  {
    this(proc.getName(), n, argValue, expectedType);
    this.proc = proc;
  }
  
  public WrongType(String procName, int n, Object argValue, String expectedType)
  {
    procname = procName;
    number = n;
    this.argValue = argValue;
    this.expectedType = expectedType;
  }
  
  public WrongType(String procname, int n, ClassCastException ex)
  {
    super(ex);
    this.procname = procname;
    number = n;
  }
  

  public WrongType(ClassCastException ex, String procname, int n, Object argValue)
  {
    this(procname, n, ex);
    this.argValue = argValue;
  }
  
  @Deprecated
  public static WrongType make(ClassCastException ex, Procedure proc, int n)
  {
    return new WrongType(proc, n, ex);
  }
  
  @Deprecated
  public static WrongType make(ClassCastException ex, String procname, int n)
  {
    return new WrongType(procname, n, ex);
  }
  


  public static WrongType make(ClassCastException ex, Procedure proc, int n, Object argValue)
  {
    WrongType wex = new WrongType(proc, n, ex);
    argValue = argValue;
    return wex;
  }
  


  public static WrongType make(ClassCastException ex, String procname, int n, Object argValue)
  {
    WrongType wex = new WrongType(procname, n, ex);
    argValue = argValue;
    return wex;
  }
  

  public String getMessage()
  {
    StringBuffer sbuf = new StringBuffer(100);
    if (number == -3)
    {
      sbuf.append(procname);
    }
    else if ((number == -4) || (number == -2))
    {
      sbuf.append("Value");
    }
    else
    {
      sbuf.append("Argument ");
      if (number > 0)
      {
        sbuf.append('#');
        sbuf.append(number);
      }
    }
    if (argValue != null)
    {
      sbuf.append(" '");
      String argString = argValue.toString();
      if (argString.length() > 50)
      {
        sbuf.append(argString.substring(0, 47));
        sbuf.append("...");
      }
      else {
        sbuf.append(argString); }
      sbuf.append("'");
    }
    if ((procname != null) && (number != -3))
    {
      sbuf.append(number == -2 ? " for variable '" : " to '");
      sbuf.append(procname);
      sbuf.append("'");
    }
    sbuf.append(" has wrong type");
    if (argValue != null)
    {
      sbuf.append(" (");
      Class wrongClass = argValue.getClass();
      Language currentLang = Language.getDefaultLanguage();
      String wrongClassname = currentLang == null ? wrongClass.getName() : currentLang.formatType(currentLang.getTypeFor(wrongClass));
      
      sbuf.append(wrongClassname);
      sbuf.append(")");
    }
    Object expectType = expectedType;
    if ((expectType == null) && (number > 0) && ((proc instanceof MethodProc)))
      expectType = ((MethodProc)proc).getParameterType(number - 1);
    if ((expectType != null) && (expectType != Type.pointer_type))
    {
      sbuf.append(" (expected: ");
      if ((expectType instanceof Type)) {
        expectType = ((Type)expectType).getName();
      } else if ((expectType instanceof Class))
        expectType = ((Class)expectType).getName();
      sbuf.append(expectType);
      sbuf.append(")");
    }
    Throwable ex = getCause();
    if (ex != null)
    {
      String msg = ex.getMessage();
      if (msg != null)
      {
        sbuf.append(" (");
        sbuf.append(msg);
        sbuf.append(')');
      }
    }
    return sbuf.toString();
  }
}
