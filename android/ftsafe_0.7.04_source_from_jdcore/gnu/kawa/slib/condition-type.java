package gnu.kawa.slib;

import gnu.mapping.Promise;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lib.misc;































public class condition-type
{
  public Symbol name;
  public Object supertype;
  public Object fields;
  public Object all$Mnfields;
  
  public condition-type(Object arg1, Object arg2, Object arg3, Object arg4)
  {
    try
    {
      this.name = ((Symbol)(localObject = Promise.force(name, Symbol.class)));this.supertype = supertype;this.fields = fields;this.all$Mnfields = all$Mnfields;return; } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, null, -4, localObject);
    }
  }
  
  public String toString() {
    StringBuffer sbuf = new StringBuffer("#<condition-type ");
    sbuf.append(misc.symbol$To$String(name));
    sbuf.append(">");
    return sbuf.toString();
  }
}
