package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrappedException;
import kawa.lang.Syntax;









public class FieldLocation<T>
  extends ClassMemberLocation<T>
{
  Declaration decl;
  Object value;
  static final int SETUP_DONE = 1;
  static final int INDIRECT_LOCATION = 2;
  static final int CONSTANT = 4;
  static final int VALUE_SET = 8;
  public static final int PROCEDURE = 16;
  public static final int SYNTAX = 32;
  public static final int KIND_FLAGS_SET = 64;
  private int flags;
  
  public boolean isIndirectLocation()
  {
    return (flags & 0x2) != 0;
  }
  
  public void setProcedure() {
    flags |= 0x54;
  }
  
  public void setSyntax()
  {
    flags |= 0x64;
  }
  
  void setKindFlags()
  {
    String fname = getMemberName();
    gnu.bytecode.Field fld = getDeclaringClass().getDeclaredField(fname);
    if (fld == null) throw new RuntimeException("No field found for " + this);
    int fflags = fld.getModifiers();
    Type ftype = fld.getType();
    if (ftype.isSubtype(Compilation.typeLocation))
      flags |= 0x2;
    if ((fflags & 0x10) != 0)
    {
      if ((flags & 0x2) == 0)
      {
        flags |= 0x4;
        if (ftype.isSubtype(Compilation.typeProcedure))
          flags |= 0x10;
        if (((ftype instanceof ClassType)) && (((ClassType)ftype).isSubclass("kawa.lang.Syntax")))
        {
          flags |= 0x20;
        }
      }
      else {
        Location loc = (Location)getFieldValue();
        if ((loc instanceof FieldLocation))
        {
          FieldLocation<T> floc = (FieldLocation)loc;
          if ((flags & 0x40) == 0)
            floc.setKindFlags();
          flags |= flags & 0x34;
          if ((flags & 0x4) != 0)
          {
            if ((flags & 0x8) != 0)
            {
              value = value;
              flags |= 0x8;
            }
          }
          else
          {
            value = floc;
            flags |= 0x8;
          }
        }
        else if (loc.isConstant())
        {
          Object val = loc.get(null);
          
          if ((val instanceof Procedure))
            flags |= 0x10;
          if ((val instanceof Syntax))
            flags |= 0x20;
          flags |= 0xC;
          value = val;
        }
      }
    }
    flags |= 0x40;
  }
  
  public boolean isProcedureOrSyntax()
  {
    if ((flags & 0x40) == 0)
      setKindFlags();
    return (flags & 0x30) != 0;
  }
  
  public FieldLocation(Object instance, String cname, String fname)
  {
    super(instance, cname, fname);
  }
  
  public FieldLocation(Object instance, ClassType type, String mname)
  {
    super(instance, type, mname);
  }
  
  public FieldLocation(Object instance, java.lang.reflect.Field field)
  {
    super(instance, field);
  }
  
  public void setDeclaration(Declaration decl)
  {
    this.decl = decl;
  }
  
  public gnu.bytecode.Field getField()
  {
    return getDeclaringClass().getDeclaredField(mname);
  }
  

  public Type getFType()
  {
    return getField().getType();
  }
  
  public synchronized Declaration getDeclaration()
  {
    if ((flags & 0x40) == 0)
      setKindFlags();
    Declaration d = decl;
    if (d == null)
    {
      String fname = getMemberName();
      ClassType t = getDeclaringClass();
      gnu.bytecode.Field procField = t.getDeclaredField(fname);
      if (procField == null)
        return null;
      ModuleInfo info = ModuleInfo.find(t);
      ModuleExp mexp = info.getModuleExp();
      for (d = mexp.firstDecl(); d != null; d = d.nextDecl())
      {
        if ((field != null) && (field.getName().equals(fname)))
          break;
      }
      if (d == null)
        throw new RuntimeException("no field found for " + this);
      decl = d;
    }
    return d;
  }
  
  void setup()
  {
    synchronized (this)
    {
      if ((flags & 0x1) != 0)
        return;
      super.setup();
      if ((flags & 0x40) == 0)
        setKindFlags();
      flags |= 0x1;
    }
  }
  
  public T get() { return get(null, true); }
  
  public T get(T defaultValue) { return get(defaultValue, false); }
  
  T get(T defaultValue, boolean throwIfUnbound)
  {
    try
    {
      setup();
    }
    catch (Exception ex)
    {
      if (throwIfUnbound) throw new UnboundLocationException(this);
      return defaultValue;
    }
    Object v;
    if ((flags & 0x8) != 0)
    {
      Object v = value;
      if ((flags & 0x4) != 0) {
        return v;
      }
    }
    else {
      v = getFieldValue();
      if ((getDeclaringClass().getDeclaredField(mname).getModifiers() & 0x10) != 0)
      {
        flags |= 0x8;
        if ((flags & 0x2) == 0)
          flags |= 0x4;
        value = v;
      }
    }
    if ((flags & 0x2) != 0)
    {
      Location loc = (Location)v;
      if (throwIfUnbound) {
        v = loc.get();
      } else if (!loc.isBound())
        return defaultValue;
      if (loc.isConstant())
      {
        flags |= 0x4;
        value = v;
      }
    }
    return v;
  }
  
  private T getFieldValue()
  {
    super.setup();
    try
    {
      return rfield.get(instance);
    }
    catch (Exception ex)
    {
      throw WrappedException.rethrow(ex);
    }
  }
  
  public void set(Object newValue)
  {
    setup();
    if ((flags & 0x2) == 0)
    {
      try
      {
        rfield.set(instance, newValue);
      }
      catch (Exception ex)
      {
        throw WrappedException.wrapIfNeeded(ex);
      }
    }
    else {
      Object v;
      Object v;
      if ((flags & 0x8) != 0) {
        v = value;
      }
      else {
        flags |= 0x8;
        v = getFieldValue();
        value = v;
      }
      ((Location)v).set(newValue);
    }
  }
  
  public Object setWithSave(T newValue)
  {
    if ((flags & 0x40) == 0)
      setKindFlags();
    if ((flags & 0x2) == 0) {
      return super.setWithSave(newValue);
    }
    Object v;
    Object v;
    if ((flags & 0x8) != 0) {
      v = value;
    }
    else {
      flags |= 0x8;
      v = getFieldValue();
      value = v;
    }
    return ((Location)v).setWithSave(newValue);
  }
  

  public void setRestore(Object oldValue)
  {
    if ((flags & 0x2) == 0) {
      super.setRestore(oldValue);
    } else {
      ((Location)value).setRestore(oldValue);
    }
  }
  
  public boolean isConstant() {
    if ((flags & 0x40) == 0)
      setKindFlags();
    if ((flags & 0x4) != 0)
      return true;
    if (isIndirectLocation()) {
      Object v;
      Object v;
      if ((flags & 0x8) != 0) {
        v = value;
      }
      else
      {
        try {
          setup();
        }
        catch (Exception ex)
        {
          return false;
        }
        v = getFieldValue();
        flags |= 0x8;
        value = v;
      }
      return ((Location)v).isConstant();
    }
    return false;
  }
  
  public boolean isBound()
  {
    if ((flags & 0x40) == 0)
      setKindFlags();
    if (((flags & 0x4) != 0) || ((flags & 0x2) == 0))
      return true;
    Object v;
    Object v; if ((flags & 0x8) != 0) {
      v = value;
    }
    else
    {
      try {
        setup();
      }
      catch (Exception ex)
      {
        return false;
      }
      v = getFieldValue();
      flags |= 0x8;
      value = v;
    }
    return ((Location)v).isBound();
  }
  
  public static FieldLocation make(Object instance, Declaration decl)
  {
    gnu.bytecode.Field fld = field;
    ClassType ctype = fld.getDeclaringClass();
    FieldLocation loc = new FieldLocation(instance, ctype, fld.getName());
    loc.setDeclaration(decl);
    
    return loc;
  }
  
  public static FieldLocation make(Object instance, String cname, String fldName)
  {
    return new FieldLocation(instance, ClassType.make(cname), fldName);
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer();
    sbuf.append("FieldLocation[");
    if (instance != null)
    {
      sbuf.append(instance);
      sbuf.append(' ');
    }
    sbuf.append(getDeclaringClassname());
    sbuf.append('.');
    sbuf.append(mname);
    



    sbuf.append(']');
    return sbuf.toString();
  }
}
