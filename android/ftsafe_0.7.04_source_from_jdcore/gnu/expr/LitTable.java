package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.util.GeneralHashTable;
import gnu.kawa.util.HashUtils;
import gnu.lists.FString;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Table2D;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;


public class LitTable
  extends GeneralHashTable<Object, Object>
  implements ObjectOutput
{
  Compilation comp;
  ClassType mainClass;
  static Table2D staticTable = new Table2D(100);
  
  int literalsCount;
  
  Literal literalsChain;
  

  public LitTable(Compilation comp)
  {
    this.comp = comp;
    mainClass = mainClass;
  }
  
  private Object hashKeyCache = null;
  private int hashCodeCache;
  
  public int hash(Object key)
  {
    if (key == hashKeyCache)
      return hashCodeCache;
    int h = comp.immediate ? System.identityHashCode(key) : HashUtils.boundedHash(key);
    
    hashKeyCache = key;
    hashCodeCache = h;
    return h;
  }
  
  protected boolean matches(Object key1, Object key2)
  {
    if (comp.immediate)
      return key1 == key2;
    return litEquals.apply(key1, key2, null);
  }
  










  public void emit()
    throws IOException
  {
    for (Literal init = literalsChain; init != null; 
        init = next)
    {
      writeObject(value);
    }
    

    for (Literal init = literalsChain; init != null; 
        init = next)
    {
      emit(init, true);
    }
    

    clear();
    literalsCount = 0;
  }
  
  Object[] valueStack = new Object[20];
  Type[] typeStack = new Type[20];
  int stackPointer;
  
  void push(Object value, Type type)
  {
    if (stackPointer >= valueStack.length)
    {
      Object[] newValues = new Object[2 * valueStack.length];
      Type[] newTypes = new Type[2 * typeStack.length];
      System.arraycopy(valueStack, 0, newValues, 0, stackPointer);
      System.arraycopy(typeStack, 0, newTypes, 0, stackPointer);
      valueStack = newValues;
      typeStack = newTypes;
    }
    valueStack[stackPointer] = value;
    typeStack[stackPointer] = type;
    stackPointer += 1;
  }
  
  void error(String msg)
  {
    throw new Error(msg);
  }
  

  public void flush() {}
  

  public void close() {}
  

  public void write(int b)
    throws IOException
  {
    error("cannot handle call to write(int) when externalizing literal");
  }
  
  public void writeBytes(String s) throws IOException
  {
    error("cannot handle call to writeBytes(String) when externalizing literal");
  }
  
  public void write(byte[] b) throws IOException
  {
    error("cannot handle call to write(byte[]) when externalizing literal");
  }
  
  public void write(byte[] b, int off, int len) throws IOException
  {
    error("cannot handle call to write(byte[],int,int) when externalizing literal");
  }
  
  public void writeBoolean(boolean v)
  {
    push(new Boolean(v), Type.booleanType);
  }
  
  public void writeChar(int v)
  {
    push(new Character((char)v), Type.charType);
  }
  
  public void writeByte(int v)
  {
    push(new Byte((byte)v), Type.byteType);
  }
  
  public void writeShort(int v)
  {
    push(new Short((short)v), Type.shortType);
  }
  
  public void writeInt(int v)
  {
    push(new Integer(v), Type.intType);
  }
  
  public void writeLong(long v)
  {
    push(new Long(v), Type.longType);
  }
  
  public void writeFloat(float v)
  {
    push(new Float(v), Type.floatType);
  }
  
  public void writeDouble(double v)
  {
    push(new Double(v), Type.doubleType);
  }
  
  public void writeUTF(String v)
  {
    push(v, Type.string_type);
  }
  
  public void writeChars(String v)
  {
    push(v, Type.string_type);
  }
  
  public void writeObject(Object obj) throws IOException
  {
    Literal lit = findLiteral(obj);
    
    if ((flags & 0x3) != 0)
    {


      if ((field == null) && (obj != null) && (!(obj instanceof String)))
      {
        lit.assign(this); }
      if ((flags & 0x2) == 0) {
        flags |= 0x4;
      }
    }
    else {
      flags |= 0x1;
      int oldStack = stackPointer;
      if (((obj instanceof FString)) && (((FString)obj).size() < 65535))
      {

        push(obj.toString(), Type.string_type);
      }
      else if ((obj instanceof Externalizable))
      {
        ((Externalizable)obj).writeExternal(this);
      }
      else if ((obj instanceof Object[]))
      {
        Object[] arr = (Object[])obj;
        for (int i = 0; i < arr.length; i++)
        {
          writeObject(arr[i]);
        }
      }
      else if ((obj != null) && (!(obj instanceof String)) && (!(type instanceof ArrayType)))
      {



        if ((obj instanceof BigInteger))
        {
          writeChars(obj.toString());
        }
        else if ((obj instanceof BigDecimal))
        {
          BigDecimal dec = (BigDecimal)obj;
          
          writeObject(dec.unscaledValue());
          writeInt(dec.scale());



        }
        else if ((obj instanceof Integer)) {
          push(obj, Type.intType);
        } else if ((obj instanceof Short)) {
          push(obj, Type.shortType);
        } else if ((obj instanceof Byte)) {
          push(obj, Type.byteType);
        } else if ((obj instanceof Long)) {
          push(obj, Type.longType);
        } else if ((obj instanceof Double)) {
          push(obj, Type.doubleType);
        } else if ((obj instanceof Float)) {
          push(obj, Type.floatType);
        } else if ((obj instanceof Character)) {
          push(obj, Type.charType);
        } else if ((obj instanceof Class)) {
          push(obj, Type.java_lang_Class_type);
        }
        else if ((obj instanceof Pattern))
        {
          Pattern pat = (Pattern)obj;
          push(pat.pattern(), Type.string_type);
          push(Integer.valueOf(pat.flags()), Type.intType);
        }
        else
        {
          error(obj.getClass().getName() + " does not implement Externalizable"); } }
      int nargs = stackPointer - oldStack;
      if (nargs == 0)
      {
        argValues = Values.noArgs;
        argTypes = Type.typeArray0;
      }
      else
      {
        argValues = new Object[nargs];
        argTypes = new Type[nargs];
        System.arraycopy(valueStack, oldStack, argValues, 0, nargs);
        System.arraycopy(typeStack, oldStack, argTypes, 0, nargs);
        stackPointer = oldStack;
      }
      flags |= 0x2;
    }
    push(lit, type);
  }
  
  public Literal findLiteral(Object value)
  {
    if (value == null)
      return Literal.nullLiteral;
    Literal literal = (Literal)get(value);
    int valueHash = hash(value);
    if (literal != null)
      return literal;
    if (comp.immediate)
      return new Literal(value, this);
    Class valueClass = value.getClass();
    Type valueType = Type.make(valueClass);
    
    synchronized (staticTable)
    {
      literal = (Literal)staticTable.get(value, null, null);
      if (((literal == null) || (value != value)) && ((valueType instanceof ClassType)))
      {


        int needed_mod = 25;
        Class fldClass = valueClass;
        ClassType fldType = (ClassType)valueType;
        while (staticTable.get(fldClass, Boolean.TRUE, null) == null)
        {

          staticTable.put(fldClass, Boolean.TRUE, fldClass);
          for (gnu.bytecode.Field fld = fldType.getFields(); 
              fld != null; fld = fld.getNext())
          {
            if (((fld.getModifiers() & needed_mod) == needed_mod) && (!(fld.getType() instanceof PrimType)))
            {
              try
              {

                java.lang.reflect.Field rfld = fld.getReflectField();
                Object litValue = rfld.get(null);
                if ((litValue == null) || (fldClass.isInstance(litValue)))
                {

                  Literal lit = new Literal(litValue, fld, this);
                  staticTable.put(litValue, null, lit);
                  int litHash = hash(litValue);
                  if ((valueHash == litHash) && (matches(litValue, value)))
                  {
                    literal = lit;
                  }
                }
              } catch (Exception ex) {
                error("caught " + ex + " getting static field " + fld);
              }
            }
          }
          fldClass = fldClass.getSuperclass();
          if (fldClass == null)
            break;
          fldType = (ClassType)Type.make(fldClass);
        }
      }
    }
    
    if (literal == null)
      literal = new Literal(value, valueType, this);
    return literal;
  }
  

  Method getMethod(ClassType type, String name, Literal literal, boolean isStatic)
  {
    Type[] argTypes = argTypes;
    Method method = type.getDeclaredMethods();
    int argLength = argTypes.length;
    Method best = null;
    long bestArrayArgs = 0L;
    boolean ambiguous = false;
    Type[] bParameters = null;
    label474:
    for (; method != null; method = method.getNext())
    {
      if (name.equals(method.getName()))
      {
        boolean mstatic = method.getStaticFlag();
        if (isStatic == mstatic)
        {

          long arrayArgs = 0L;
          Type[] mParameters = method.getParameterTypes();
          int iarg = 0;int iparam = 0;
          for (;;)
          {
            if ((iarg == argLength) && (iparam == mParameters.length))
            {
              if ((best == null) || ((bestArrayArgs != 0L) && (arrayArgs == 0L)))
              {
                best = method;
                bParameters = mParameters;
                bestArrayArgs = arrayArgs; break;
              }
              if (arrayArgs != 0L) {
                break;
              }
              

              boolean not1 = false;
              
              boolean not2 = false;
              int j = argLength; for (;;) { j--; if (j < 0)
                  break;
                int c = bParameters[j].compare(mParameters[j]);
                if (c != 1)
                {
                  not2 = true;
                  if (not1) {
                    break;
                  }
                } else if (c != -1)
                {
                  not1 = true;
                  if (not2)
                    break;
                }
              }
              if (not1)
              {
                best = method;
                bParameters = mParameters;
              }
              ambiguous = (not1) && (not2);
              break;
            }
            
            if ((iarg == argLength) || (iparam == mParameters.length))
              break;
            Type aType = argTypes[iarg];
            Type pType = mParameters[iparam];
            if (!aType.isSubtype(pType))
            {
              if ((!(pType instanceof ArrayType)) || (iparam >= 64) || ((aType != Type.intType) && (aType != Type.shortType))) {
                break;
              }
              int count = ((Number)argValues[iarg]).intValue();
              if ((count < 0) && (type.getName().equals("gnu.math.IntNum")))
                count -= Integer.MIN_VALUE;
              Type elementType = ((ArrayType)pType).getComponentType();
              if ((count < 0) || (iarg + count >= argLength)) {
                break;
              }
              
              int j = count; for (;;) { j--; if (j < 0)
                  break;
                Type t = argTypes[(iarg + j + 1)];
                if ((elementType instanceof PrimType) ? elementType.getSignature() != t.getSignature() : !t.isSubtype(elementType)) {
                  break label474;
                }
              }
              
              iarg += count;
              arrayArgs |= 1 << iparam;
            }
            iarg++;iparam++;
          }
        }
      }
    }
    








































































    if (ambiguous)
      return null;
    if (bestArrayArgs != 0L)
    {
      Object[] args = new Object[bParameters.length];
      Type[] types = new Type[bParameters.length];
      int iarg = 0; for (int iparam = 0; 
          

          iarg != argLength; iparam++)
      {


        Type pType = bParameters[iparam];
        if ((bestArrayArgs & 1 << iparam) == 0L)
        {
          args[iparam] = argValues[iarg];
          types[iparam] = argTypes[iarg];
        }
        else
        {
          int count = ((Number)argValues[iarg]).intValue();
          boolean isIntNum = type.getName().equals("gnu.math.IntNum");
          if (isIntNum)
            count -= Integer.MIN_VALUE;
          Type elementType = ((ArrayType)pType).getComponentType();
          types[iparam] = pType;
          args[iparam] = Array.newInstance(elementType.getReflectClass(), count);
          
          Object[] argValues = argValues;
          if (isIntNum)
          {



            int[] arr = (int[])args[iparam];
            for (int j = count; j > 0; j--) {
              arr[(count - j)] = ((Integer)argValues[(iarg + j)]).intValue();
            }
          }
          else
          {
            int j = count; for (;;) { j--; if (j < 0) break;
              Array.set(args[iparam], j, argValues[(iarg + 1 + j)]);
            } }
          Literal arrayLiteral = new Literal(args[iparam], pType);
          if ((elementType instanceof ObjectType))
            argValues = ((Object[])args[iparam]);
          args[iparam] = arrayLiteral;
          iarg += count;
        }
        iarg++;
      }
      








































      argValues = args;
      argTypes = types;
    }
    return best;
  }
  
  void putArgs(Literal literal, CodeAttr code)
  {
    Type[] argTypes = argTypes;
    int len = argTypes.length;
    for (int i = 0; i < len; i++)
    {
      Object value = argValues[i];
      if ((value instanceof Literal)) {
        emit((Literal)value, false);
      } else {
        comp.compileConstant(value, new StackTarget(argTypes[i]));
      }
    }
  }
  
  private void store(Literal literal, boolean ignore, CodeAttr code) {
    if (field != null)
    {
      if (!ignore)
        code.emitDup(type);
      code.emitPutStatic(field);
    }
    flags |= 0x8;
  }
  
  void emit(Literal literal, boolean ignore)
  {
    CodeAttr code = comp.getCode();
    if (value == null)
    {
      if (!ignore) {
        code.emitPushNull();
      }
    } else if ((value instanceof String))
    {
      if (!ignore) {
        code.emitPushString(value.toString());
      }
    } else if ((flags & 0x8) != 0)
    {
      if (!ignore) {
        code.emitGetStatic(field);
      }
    } else if ((value instanceof Object[]))
    {
      int len = argValues.length;
      Type elementType = ((ArrayType)type).getComponentType();
      code.emitPushInt(len);
      code.emitNewArray(elementType);
      int numNonNull = 0;
      for (int i = 0; i < len; i++) {
        if (argValues[i]).value != null)
          numNonNull++;
      }
      if (numNonNull > 0)
        code.emitDup(type);
      store(literal, ignore, code);
      for (int i = 0; i < len; i++)
      {
        Literal el = (Literal)argValues[i];
        if (value != null)
        {
          numNonNull--; if (numNonNull > 0)
            code.emitDup(type);
          code.emitPushInt(i);
          emit(el, false);
          code.emitArrayStore(elementType);
        }
      }
    } else if ((type instanceof ArrayType))
    {
      code.emitPushPrimArray(value, (ArrayType)type);
      store(literal, ignore, code);
    }
    else if ((value instanceof Class))
    {
      Class clas = (Class)value;
      if (clas.isPrimitive())
      {
        String cname = clas.getName();
        if (cname.equals("int"))
          cname = "integer";
        cname = "java.lang." + Character.toUpperCase(cname.charAt(0)) + cname.substring(1);
        

        code.emitGetStatic(ClassType.make(cname).getDeclaredField("TYPE"));
      }
      else {
        comp.loadClassRef((ObjectType)Type.make(clas)); }
      store(literal, ignore, code);
    }
    else if (((value instanceof ClassType)) && (!((ClassType)value).isExisting()))
    {




      ClassType ct = (ClassType)value;
      boolean isPair = value instanceof PairClassType;
      ClassType typeType = isPair ? ClassType.make("gnu.expr.PairClassType") : Compilation.typeType;
      
      Type[] atypes = new Type[isPair ? 2 : 1];
      int i = atypes.length; for (;;) { i--; if (i < 0) break;
        atypes[i] = Type.javalangClassType; }
      Method meth = typeType.getDeclaredMethod("make", atypes);
      comp.loadClassRef(ct);
      if (isPair)
        comp.loadClassRef(instanceType);
      code.emitInvokeStatic(meth);
      code.emitCheckcast(Compilation.typeClassType);
      store(literal, ignore, code);
    }
    else
    {
      ClassType type = (ClassType)type;
      boolean useDefaultInit = (flags & 0x4) != 0;
      Method method = null;
      boolean makeStatic = false;
      if (!useDefaultInit)
      {



        if (!(value instanceof Symbol)) {
          method = getMethod(type, "valueOf", literal, true);
        } else if ((value instanceof SimpleSymbol))
          method = getMethod(Compilation.typeSymbol, "valueOf", literal, true);
        if ((method == null) && (!(value instanceof Values)))
        {


          String mname = "make";
          
          if ((value instanceof Pattern)) {
            mname = "compile";
          }
          method = getMethod(type, mname, literal, true);
        }
        
        if (method != null) {
          makeStatic = true;
        } else if (argTypes.length > 0) {
          method = getMethod(type, "<init>", literal, false);
        }
        if (method == null)
          useDefaultInit = true;
      }
      if (useDefaultInit)
      {
        method = getMethod(type, "init", literal, false);
        if (method == null) {
          method = getMethod(type, "set", literal, false);
        }
      }
      if ((method == null) && (argTypes.length > 0))
        error("no method to construct " + type);
      if (makeStatic)
      {
        putArgs(literal, code);
        code.emitInvokeStatic(method);
      }
      else if (useDefaultInit)
      {
        code.emitNew(type);
        code.emitDup(type);
        Method init0 = type.getDeclaredMethod("<init>", 0);
        code.emitInvokeSpecial(init0);
      }
      else
      {
        code.emitNew(type);
        code.emitDup(type);
        putArgs(literal, code);
        code.emitInvokeSpecial(method);
      }
      Method resolveMethod = (makeStatic) || ((value instanceof Values)) ? null : type.getDeclaredMethod("readResolve", 0);
      

      if (resolveMethod != null)
      {
        code.emitInvokeVirtual(resolveMethod);
        type.emitCoerceFromObject(code);
      }
      store(literal, (ignore) && ((!useDefaultInit) || (method == null)), code);
      if ((useDefaultInit) && (method != null))
      {
        if (!ignore)
          code.emitDup(type);
        putArgs(literal, code);
        code.emitInvokeVirtual(method);
      }
    }
  }
  

  static class LitEquals
    extends IsEqual
  {
    public LitEquals()
    {
      super("(equals-for-literals)");
    }
    
    public boolean apply(Object arg1, Object arg2, Map<Object, ArrayList<Object>> map) {
      if (arg1 == arg2)
        return true;
      if ((arg1 == null) || (arg2 == null) || ((arg1 instanceof Symbol)) || (arg1.getClass() != arg2.getClass()))
      {


        return false;
      }
      return super.apply(arg1, arg2, map);
    } }
  
  static final LitEquals litEquals = new LitEquals();
}
