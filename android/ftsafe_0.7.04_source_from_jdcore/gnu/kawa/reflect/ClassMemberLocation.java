package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.expr.SourceName;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import java.lang.reflect.Field;


public abstract class ClassMemberLocation<T>
  extends Location<T>
{
  Object instance;
  private String cname;
  private ClassType type;
  String mname;
  Field rfield;
  
  public final Object getInstance() { return instance; }
  public final void setInstance(Object obj) { instance = obj; }
  
  public ClassMemberLocation(Object instance, String cname, String mname)
  {
    this.instance = instance;
    this.cname = cname;
    this.mname = mname;
  }
  
  public ClassMemberLocation(Object instance, ClassType type, String mname)
  {
    this.instance = instance;
    this.type = type;
    this.mname = mname;
  }
  
  public ClassMemberLocation(Object instance, Class clas, String mname)
  {
    this.instance = instance;
    type = ((ClassType)Type.make(clas));
    this.mname = mname;
  }
  
  public ClassMemberLocation(Object instance, Field field)
  {
    this.instance = instance;
    rfield = field;
    type = ((ClassType)Type.make(field.getDeclaringClass()));
    mname = field.getName();
  }
  
  public String getMemberName()
  {
    return mname;
  }
  
  public ClassType getDeclaringClass() {
    if (type == null)
      type = ClassType.make(cname);
    return type;
  }
  
  public String getDeclaringClassname() { return type == null ? "()" : cname != null ? cname : type.getName(); }
  

  void setup()
  {
    if (rfield == null)
    {
      Class clas;
      try
      {
        clas = getDeclaringClass().getReflectClass();
      }
      catch (RuntimeException ex)
      {
        RuntimeException uex = new gnu.mapping.UnboundLocationException(null, "Unbound location - " + ex.toString());
        


        uex.initCause(ex);
        
        throw uex;
      }
      try
      {
        rfield = clas.getField(mname);
      }
      catch (NoSuchFieldException ex)
      {
        RuntimeException uex = new gnu.mapping.UnboundLocationException(null, "Unbound location  - no field " + mname + " in " + type.getName());
        



        uex.initCause(ex);
        
        throw uex;
      }
    }
  }
  
  public Field getRField()
  {
    Field rfld = rfield;
    if (rfld == null)
    {
      Class clas = null;
      
      try
      {
        clas = getDeclaringClass().getReflectClass();
        rfld = clas.getField(mname);
        rfield = rfld;
      }
      catch (Exception ex)
      {
        return null;
      }
    }
    return rfld;
  }
  


  public Class getRClass()
  {
    Field rfld = rfield;
    if (rfld != null) {
      return rfld.getDeclaringClass();
    }
    try {
      return getDeclaringClass().getReflectClass();
    }
    catch (Exception ex) {}
    
    return null;
  }
  

  public T get(T defaultValue)
  {
    Field rfld = getRField();
    if (rfld == null) {
      return defaultValue;
    }
    try
    {
      return rfld.get(instance);
    }
    catch (IllegalAccessException ex)
    {
      throw gnu.mapping.WrappedException.wrapIfNeeded(ex);
    }
  }
  
  public boolean isConstant()
  {
    Field rfld = getRField();
    return (rfld != null) && ((rfield.getModifiers() & 0x10) != 0);
  }
  
  public boolean isBound()
  {
    Field rfld = getRField();
    return rfld != null;
  }
  
  public void set(T value)
  {
    setup();
    try
    {
      rfield.set(instance, value);
      return;
    }
    catch (IllegalAccessException ex)
    {
      throw gnu.mapping.WrappedException.wrapIfNeeded(ex);
    }
  }
  



  static final ClassType typeProcedure = ClassType.make("gnu.mapping.Procedure");
  
  static final ClassType typeLocation = ClassType.make("gnu.mapping.Location");
  


  public static void define(Object instance, Field rfield, String uri, Language language, gnu.mapping.Environment env)
    throws IllegalAccessException
  {
    Object fvalue = rfield.get(instance);
    Type ftype = Type.make(rfield.getType());
    boolean isAlias = ftype.isSubtype(typeLocation);
    boolean isProcedure = ftype.isSubtype(typeProcedure);
    int rModifiers = rfield.getModifiers();
    boolean isFinal = (rModifiers & 0x10) != 0;
    Object fdname = (isFinal) && ((fvalue instanceof gnu.mapping.Named)) && (!isAlias) ? ((gnu.mapping.Named)fvalue).getSymbol() : gnu.expr.Mangling.demangleName(rfield.getName(), true);
    
    try
    {
      SourceName sourceName = (SourceName)rfield.getAnnotation(SourceName.class);
      if (sourceName != null) {
        fdname = Symbol.valueOf(sourceName.name(), sourceName.uri(), sourceName.prefix());
      }
    } catch (Exception ex) {}
    Symbol sym;
    Symbol sym;
    if ((fdname instanceof Symbol)) {
      sym = (Symbol)fdname;
    }
    else {
      sym = Symbol.make(uri == null ? "" : uri, fdname.toString().intern());
    }
    

    Object property = null;
    Location loc; Location loc; if ((isAlias) && (isFinal))
    {
      loc = (Location)fvalue;
    }
    else
    {
      if (isFinal)
        property = language.getEnvPropertyFor(rfield, fvalue);
      boolean isStatic = (rModifiers & 0x8) != 0;
      Location loc; if (isStatic) {
        loc = new StaticFieldLocation(rfield);
      } else {
        loc = new FieldLocation(instance, rfield);
      }
    }
    env.addLocation(sym, property, loc);
  }
  

  public static void defineAll(Object instance, Language language, gnu.mapping.Environment env)
    throws IllegalAccessException
  {
    Class clas = instance.getClass();
    Field[] fields = clas.getFields();
    int i = fields.length; for (;;) { i--; if (i < 0)
        break;
      Field field = fields[i];
      String fname = field.getName();
      if ((!fname.startsWith("$Prvt$")) && (!fname.endsWith("$instance")))
      {

        define(instance, field, null, language, env);
      }
    }
  }
}
