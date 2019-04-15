package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.lists.Sequence;
import gnu.math.IntNum;
import gnu.text.Char;

public class LangPrimType extends PrimType implements gnu.expr.TypeValue
{
  Language language;
  PrimType implementationType;
  boolean isUnsigned;
  public static final PrimType byteType = Type.byteType;
  public static final PrimType shortType = Type.shortType;
  public static final PrimType intType = Type.intType;
  public static final PrimType longType = Type.longType;
  public static final PrimType floatType = Type.floatType;
  public static final PrimType doubleType = Type.doubleType;
  public static final LangPrimType charType = new LangPrimType(Type.charType);
  
  public static final PrimType voidType = Type.voidType;
  
  static final ClassType scmCharType = ClassType.make("gnu.text.Char");
  static final ClassType boxedStringCursorType = ClassType.make("gnu.text.StringCursor");
  

  public static final LangPrimType characterType = new LangPrimType(Type.intType);
  public static final LangPrimType characterOrEofType; public static final LangPrimType unsignedLongType; static final ClassType boxedULongType;
  static { characterType.setName("character");
    characterOrEofType = new LangPrimType(Type.intType);
    
    characterOrEofType.setName("character-or-eof");
    
    unsignedLongType = new LangPrimType(Type.longType);
    
    unsignedLongType.setName("ulong");
    unsignedLongTypeisUnsigned = true;
    boxedULongType = ClassType.make("gnu.math.ULong");
    
    unsignedIntType = new LangPrimType(Type.intType);
    
    unsignedIntType.setName("uint");
    unsignedIntTypeisUnsigned = true;
    boxedUIntType = ClassType.make("gnu.math.UInt");
    
    unsignedShortType = new LangPrimType(Type.shortType);
    
    unsignedShortType.setName("ushort");
    unsignedShortTypeisUnsigned = true;
    boxedUShortType = ClassType.make("gnu.math.UShort");
    
    unsignedByteType = new LangPrimType(Type.byteType);
    
    unsignedByteType.setName("ubyte");
    unsignedByteTypeisUnsigned = true;
    boxedUByteType = ClassType.make("gnu.math.UByte");
    
    stringCursorType = new LangPrimType(Type.intType);
    
    stringCursorType.setName("string-cursor"); }
  
  public static final LangPrimType unsignedIntType;
  public LangPrimType(PrimType type) { super(type);
    implementationType = type; }
  
  static final ClassType boxedUIntType;
  
  public LangPrimType(PrimType type, Language language) { super(type);
    this.language = language;
    implementationType = type; }
  
  public static final LangPrimType unsignedShortType;
  
  public LangPrimType(String nam, String sig, int siz, Class reflectClass) { super(nam, sig, siz, reflectClass); }
  
  static final ClassType boxedUShortType;
  
  public LangPrimType(String nam, String sig, int siz, Class reflectClass, Language language) {
    this(nam, sig, siz, reflectClass);
    implementationType = Type.signatureToPrimitive(sig.charAt(0));
    this.language = language; }
  
  public static final LangPrimType unsignedByteType;
  
  public Type getImplementationType() { return implementationType; }
  
  public boolean isUnsigned() {
    return isUnsigned; }
  
  static final ClassType boxedUByteType;
  public static final LangPrimType stringCursorType;
  public ClassType boxedType() { if (this == characterType)
      return scmCharType;
    if (this == stringCursorType)
      return boxedStringCursorType;
    if (this == characterOrEofType)
      return Type.objectType;
    if (this == unsignedLongType)
      return boxedULongType;
    if (this == unsignedIntType)
      return boxedUIntType;
    if (this == unsignedShortType)
      return boxedUShortType;
    if (this == unsignedByteType)
      return boxedUByteType;
    return super.boxedType();
  }
  
  public Object coerceFromObject(Object obj)
  {
    if (obj.getClass() == reflectClass)
      return obj;
    char sig1 = getSignature().charAt(0);
    switch (sig1) {
    case 'J': 
      if (isUnsigned())
        return gnu.math.ULong.valueOf(((Number)obj).longValue());
      break;
    case 'I': 
      if ((this == characterType) || (this == characterOrEofType))
      {
        if ((obj instanceof Integer))
          return obj;
        int ival; int ival; if ((obj instanceof Char)) {
          ival = ((Char)obj).intValue(); } else { int ival;
          if ((obj == Sequence.eofValue) && (this == characterOrEofType)) {
            ival = -1;
          } else
            ival = ((Character)obj).charValue(); }
        return Integer.valueOf(ival);
      }
      if (isUnsigned())
        return gnu.math.UInt.valueOf(((Number)obj).intValue());
      break;
    case 'S': 
      if (isUnsigned())
        return gnu.math.UShort.valueOf(((Number)obj).shortValue());
      break;
    case 'B': 
      if (isUnsigned())
        return gnu.math.UByte.valueOf(((Number)obj).byteValue());
      break;
    case 'Z': 
      return language.isTrue(obj) ? Boolean.TRUE : Boolean.FALSE;
    case 'C': 
      return new Character(((Char)obj).charValue());
    case 'V': 
      return gnu.mapping.Values.empty;
    }
    return super.coerceFromObject(obj);
  }
  
  public char charValue(Object value) {
    if ((value instanceof Character))
      return ((Character)value).charValue();
    return ((Char)value).charValue();
  }
  
  public void emitIsInstance(CodeAttr code) {
    char sig1 = getSignature().charAt(0);
    switch (sig1) {
    case 'I': 
      String mname = this == characterOrEofType ? "isCharOrEof" : this == characterType ? "isChar" : null;
      
      if (mname != null) {
        code.emitInvokeStatic(scmCharType.getDeclaredMethod(mname, 1)); return;
      }
      
      break;
    case 'C': 
      ClassType scmCharType = ClassType.make("gnu.text.Char");
      code.emitInvokeStatic(scmCharType.getDeclaredMethod("isChar", 1));
      return;
    }
    super.emitIsInstance(code);
  }
  
  public void emitCoerceFromObject(CodeAttr code) {
    char sig1 = getSignature().charAt(0);
    switch (sig1) {
    case 'I': 
      if ((this == characterType) || (this == characterOrEofType)) {
        Type top = code.topType();
        if (top == javalangCharacterType) {
          code.emitInvokeVirtual(javalangCharacterType.getDeclaredMethod("charValue", 0));
          return;
        }
        if (top == scmCharType) {
          code.emitInvokeVirtual(scmCharType.getDeclaredMethod("intValue", 0));
          return;
        }
      }
      if (this == stringCursorType) {
        boxedStringCursorType.emitCoerceFromObject(code);
        code.emitInvoke(boxedStringCursorType.getDeclaredMethod("getValue", 0));
        
        return;
      }
      String mname = this == characterOrEofType ? "castToCharacterOrEof" : this == characterType ? "castToCharacter" : null;
      
      if (mname != null) {
        code.emitInvokeStatic(scmCharType.getDeclaredMethod(mname, 1)); return;
      }
      
      break;
    case 'Z': 
      Compilation.getCurrent().emitCoerceToBoolean();
      return;
    case 'C': 
      if (code.topType() == javalangCharacterType) {
        code.emitInvokeVirtual(javalangCharacterType.getDeclaredMethod("charValue", 0));
        return;
      }
      Method charValueMethod = scmCharType.getDeclaredMethod("castToChar", 1);
      code.emitInvokeStatic(charValueMethod);
      return;
    }
    super.emitCoerceFromObject(code);
  }
  
  public Object coerceToObject(Object obj) {
    char sig1 = getSignature().charAt(0);
    switch (sig1) {
    case 'I': 
      if ((this == characterType) || (this == characterOrEofType)) {
        if ((obj instanceof Integer)) {
          int ival = ((Integer)obj).intValue();
          if (ival >= 0)
            return Char.make(ival);
          if ((ival == -1) && (this == characterOrEofType))
            return Sequence.eofValue;
        }
        if (((obj instanceof Char)) && (obj == Sequence.eofValue) && (this == characterOrEofType))
        {
          return obj; }
      }
      break;
    case 'Z': 
      return language.booleanObject(((Boolean)obj).booleanValue());
    case 'C': 
      if ((obj instanceof Char))
        return obj;
      return Char.make(((Character)obj).charValue());
    
    case 'V': 
      return gnu.mapping.Values.empty;
    }
    return super.coerceToObject(obj);
  }
  
  public Object convertToRaw(Object obj)
  {
    if ((this == characterType) || (this == characterOrEofType)) {
      if ((obj instanceof Char))
        return Integer.valueOf(((Char)obj).intValue());
      if ((obj == Sequence.eofValue) && (this == characterOrEofType))
        return Integer.valueOf(-1);
    }
    return obj;
  }
  
  public void emitCoerceToObject(CodeAttr code) {
    char sig1 = getSignature().charAt(0);
    Type argType = null;
    String cname = null;
    switch (sig1) {
    case 'I': 
      String mname = this == characterOrEofType ? "makeOrEof" : this == characterType ? "make" : null;
      
      if (mname != null) {
        Method makeCharMethod = scmCharType.getDeclaredMethod(mname, 1);
        code.emitInvokeStatic(makeCharMethod);
      } else {
        super.emitCoerceToObject(code); }
      break;
    case 'Z': 
      Compilation comp = Compilation.getCurrent();
      code.emitIfIntNotZero();
      comp.emitPushBoolean(true);
      code.emitElse();
      comp.emitPushBoolean(false);
      code.emitFi();
      break;
    case 'C': 
      ClassType scmCharType = ClassType.make("gnu.text.Char");
      Method makeCharMethod = scmCharType.getDeclaredMethod("make", 1);
      code.emitInvokeStatic(makeCharMethod);
      break;
    default: 
      super.emitCoerceToObject(code);
    }
    if (cname != null) {
      ClassType clas = ClassType.make(cname);
      Type[] args = { argType };
      code.emitInvokeStatic(clas.getDeclaredMethod("make", args));
    }
  }
  
  public int compare(Type other)
  {
    if ((other instanceof gnu.kawa.reflect.LazyType))
      other = ((gnu.kawa.reflect.LazyType)other).getValueType();
    char sig1 = getSignature().charAt(0);
    char sig2 = other.getSignature().charAt(0);
    if (sig1 == 'Z')
      return implementationType.compare(other);
    if (this == other)
      return 0;
    if (this == stringCursorType)
      return other == Type.objectType ? -1 : -3;
    if (this == charType) {
      if ((other == characterType) || (other == characterOrEofType) || (other == scmCharType))
      {
        return -1; }
      return getImplementationType().compare(other);
    }
    if (this == characterType) {
      if (other == characterOrEofType)
        return -1;
      if ((other == charType) || (sig2 == 'C'))
        return 1;
      return scmCharType.compare(other);
    }
    if (this == characterOrEofType) {
      if ((other == characterType) || (other == ClassType.make("gnu.lists.EofClass")) || (other == charType) || (other == scmCharType) || (sig2 == 'C'))
      {

        return 1; }
      return other == Type.objectType ? -1 : -3;
    }
    if ((other instanceof PrimType)) {
      return getImplementationType().compare(other);
    }
    if (sig1 == 'V')
      return 1;
    if ((other instanceof LangObjType))
      return swappedCompareResult(other.compare(this));
    return super.compare(other);
  }
  
  public int isCompatibleWithValue(Type valueType)
  {
    if ((this == charType) && (valueType == Type.charType))
      return 2;
    int r = super.isCompatibleWithValue(valueType);
    if ((r < 0) && (getSignature().charAt(0) == 'Z'))
      r = 0;
    return r;
  }
  
  public void emitTestIf(Variable incoming, Declaration decl, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    char sig1 = getSignature().charAt(0);
    if (incoming != null)
      code.emitLoad(incoming);
    switch (sig1) {
    case 'Z': 
      Type.javalangBooleanType.emitIsInstance(code);
      code.emitIfIntNotZero();
      if (decl != null) {
        code.emitLoad(incoming);
        super.emitCoerceFromObject(code);
        decl.compileStore(comp);
      }
      return;
    }
    if ((this == characterType) || (this == characterOrEofType) || (this == charType))
    {
      code.emitInvokeStatic(scmCharType.getDeclaredMethod("checkCharOrEof", 1));
    }
    else if (this == stringCursorType) {
      code.emitInvokeStatic(boxedStringCursorType.getDeclaredMethod("checkStringCursor", 1));
    }
    
    if (decl != null) {
      code.emitDup();
      decl.compileStore(comp);
    }
    if ((this == characterType) || (this == stringCursorType)) {
      code.emitIfIntGEqZero();
    } else if (this == charType) {
      code.emitPushInt(16);
      code.emitUshr();
      code.emitIfIntEqZero();
    } else if (this == characterOrEofType) {
      code.emitPushInt(-1);
      code.emitIfIntGEq();
    } else {
      emitIsInstance(code);
      code.emitIfIntNotZero();
    }
  }
  
  public Expression convertValue(Expression value) {
    return null;
  }
  
  public void emitIsInstance(Variable incoming, Compilation comp, gnu.expr.Target target)
  {
    gnu.kawa.reflect.InstanceOf.emitIsInstance(this, incoming, comp, target);
  }
  
  public gnu.mapping.Procedure getConstructor() {
    return null;
  }
  
  public static Object convertIntegerLiteral(IntNum ivalue, PrimType type, boolean nativeValue) {
    boolean unsigned;
    switch (type.getSignature().charAt(0)) {
    case 'B': 
      unsigned = type == unsignedByteType;
      if (unsigned ? ivalue.inRange(0L, 255L) : ivalue.inRange(-128L, 127L))
      {
        byte i = ivalue.byteValue();
        return (unsigned) && (!nativeValue) ? gnu.math.UByte.valueOf(i) : Byte.valueOf(i);
      }
      
      break;
    case 'S': 
      unsigned = type == unsignedShortType;
      if (unsigned ? ivalue.inRange(0L, 65535L) : ivalue.inRange(-32768L, 32767L))
      {
        short i = ivalue.shortValue();
        return (unsigned) && (!nativeValue) ? gnu.math.UShort.valueOf(i) : Short.valueOf(i);
      }
      
      break;
    case 'I': 
      unsigned = type == unsignedIntType;
      if (unsigned ? ivalue.inRange(0L, 4294967295L) : ivalue.inRange(-2147483648L, 2147483647L))
      {
        int i = ivalue.intValue();
        return (unsigned) && (!nativeValue) ? gnu.math.UInt.valueOf(i) : Integer.valueOf(i);
      }
      
      break;
    case 'J': 
      unsigned = type == unsignedLongType;
      if (unsigned ? (IntNum.compare(ivalue, 0L) >= 0) && (IntNum.compare(ivalue, IntNum.valueOfUnsigned(-1)) <= 0) : ivalue.inRange(Long.MIN_VALUE, Long.MAX_VALUE))
      {


        long i = ivalue.longValue();
        return (unsigned) && (!nativeValue) ? gnu.math.ULong.valueOf(i) : Long.valueOf(i);
      }
      break;
    }
    
    return null;
  }
  
  public String encodeType(Language language) {
    if (this == characterType) return "character";
    if (this == characterOrEofType) return "character-or-eof";
    if (this == stringCursorType) return "string-cursor";
    if (this == unsignedLongType) return "ulong";
    if (this == unsignedIntType) return "uint";
    if (this == unsignedShortType) return "ushort";
    if (this == unsignedByteType) return "ubyte";
    return null;
  }
}
