package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;



















public class Literal
{
  Literal next;
  public Field field;
  Object value;
  int index;
  public Type type;
  public int flags;
  static final int WRITING = 1;
  static final int WRITTEN = 2;
  static final int CYCLIC = 4;
  static final int EMITTED = 8;
  Object[] argValues;
  Type[] argTypes;
  public static final Literal nullLiteral = new Literal(null, Type.nullType);
  
  public final Object getValue() {
    return value;
  }
  
  void assign(LitTable litTable) { assign((String)null, litTable); }
  


  void assign(String name, LitTable litTable)
  {
    int flags = comp.immediate ? 9 : 24;
    
    if (name == null) {
      index = (literalsCount++);
      name = "Lit" + index;
    } else {
      flags |= 0x1; }
    assign(mainClass.addField(name, type, flags), litTable);
  }
  
  void assign(Field field, LitTable litTable) {
    next = literalsChain;
    literalsChain = this;
    this.field = field;
  }
  
  public Literal(Object value, LitTable litTable)
  {
    this(value, (String)null, litTable);
  }
  
  public Literal(Object value, String name, LitTable litTable) {
    this(value, Type.make(value.getClass()));
    litTable.put(value, this);
    assign(name, litTable);
  }
  

  public Literal(Object value, Field field, LitTable litTable)
  {
    this(value, field.getType());
    litTable.put(value, this);
    this.field = field;
    flags = 10;
  }
  
  public Literal(Object value, Type type, LitTable litTable) {
    this(value, type);
    litTable.put(value, this);
  }
  
  Literal(Object value, Type type) {
    this.value = value;
    this.type = type;
  }
}
