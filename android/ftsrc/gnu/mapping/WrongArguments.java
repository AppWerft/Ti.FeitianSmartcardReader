package gnu.mapping;



public class WrongArguments
  extends IllegalArgumentException
{
  public int number;
  

  public String usage;
  

  public String procname;
  
  Procedure proc;
  

  public static String checkArgCount(Procedure proc, int argCount, boolean hasSplices)
  {
    int num = proc.numArgs();
    int min = num & 0xFFF;
    int max = num >> 12;
    String pname = proc.getName();
    if (pname == null)
      pname = proc.getClass().getName();
    return checkArgCount(pname, hasSplices ? 0 : min, max, argCount);
  }
  
  public static String checkArgCount(String pname, int min, int max, int argCount)
  {
    boolean tooMany;
    if (argCount < min) {
      tooMany = false; } else { boolean tooMany;
      if ((max >= 0) && (argCount > max)) {
        tooMany = true;
      } else
        return null; }
    boolean tooMany; StringBuffer buf = new StringBuffer(100);
    buf.append("call to ");
    if (pname == null) {
      buf.append("unnamed procedure");
    }
    else {
      buf.append('\'');
      buf.append(pname);
      buf.append('\'');
    }
    buf.append(tooMany ? " has too many" : " has too few");
    buf.append(" arguments (");
    buf.append(argCount);
    if (min == max)
    {
      buf.append("; must be ");
      buf.append(min);
    }
    else
    {
      buf.append("; min=");
      buf.append(min);
      if (max >= 0)
      {
        buf.append(", max=");
        buf.append(max);
      }
    }
    buf.append(')');
    return buf.toString();
  }
  
  public String getMessage()
  {
    if (proc != null)
    {
      String msg = checkArgCount(proc, number, false);
      if (msg != null)
        return msg;
    }
    return super.getMessage();
  }
  
  public WrongArguments(Procedure proc, int argCount)
  {
    this.proc = proc;
    number = argCount;
  }
  
  public WrongArguments(String name, int n, String u) {
    procname = name;
    number = n;
    usage = u;
  }
}
