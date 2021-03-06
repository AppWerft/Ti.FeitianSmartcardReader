package gnu.kawa.lispexpr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Language;

public class GenArrayType extends ParameterizedType implements gnu.expr.TypeValue
{
  int rank;
  Type implementationType;
  public static final gnu.bytecode.ClassType typeArray = gnu.bytecode.ClassType.make("gnu.lists.Array");
  

  public static final GenArrayType generalInstance = new GenArrayType(-1, Type.objectType);
  
  public GenArrayType(int rank, Type elementType)
  {
    super(typeArray, new Type[] { elementType });
    this.rank = rank;
    Type elementImplementation = elementType.getImplementationType();
    if ((elementImplementation instanceof PrimType))
      elementImplementation = ((PrimType)elementImplementation).boxedType();
    if (elementImplementation == elementType) {
      implementationType = this;
    } else {
      implementationType = new ParameterizedType(typeArray, new Type[] { elementImplementation });
    }
  }
  
  public Type getImplementationType() {
    return implementationType;
  }
  
  public int rank() { return rank; }
  
  public Type getComponentType() {
    return getTypeArgumentType(0);
  }
  
  public int compare(Type other)
  {
    if ((other instanceof GenArrayType)) {
      GenArrayType aother = (GenArrayType)other;
      int elcomp = getComponentType().compare(aother.getComponentType());
      if (rank == rank)
        return elcomp;
      if ((rank != -1) && (rank != -1))
        return -3;
      int rcomp = rank == -1 ? 1 : -1;
      if (rcomp == elcomp)
        return elcomp;
      return -2;
    }
    int r = typeArray.compare(other);
    return r == -3 ? -3 : (r == 0) || (r == -1) ? -1 : -2;
  }
  
  public gnu.expr.Expression convertValue(gnu.expr.Expression value)
  {
    return null;
  }
  
  public gnu.mapping.Procedure getConstructor()
  {
    if ((rank < 0) && (getComponentType() == Type.objectType))
      return new gnu.expr.PrimProcedure("kawa.lib.arrays", "array", 2);
    return null;
  }
  
  public String encodeType(Language language)
  {
    StringBuilder sb = new StringBuilder("array");
    if (rank >= 0)
      sb.append(rank);
    Type elementType = getComponentType();
    if ((elementType != Type.objectType) && (elementType != null)) {
      sb.append('[');
      String el = language.encodeType(elementType);
      sb.append(el != null ? el : elementType.getName());
      sb.append(']');
    }
    return sb.toString();
  }
  
  public void emitIsInstance(Variable incoming, Compilation comp, gnu.expr.Target target)
  {
    gnu.kawa.reflect.InstanceOf.emitIsInstance(this, incoming, comp, target);
  }
  
  public void emitTestIf(Variable incoming, Declaration decl, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    if (incoming != null)
      code.emitLoad(incoming);
    implementationType.emitIsInstance(code);
    code.emitIfIntNotZero();
    if (decl != null) {
      code.emitLoad(incoming);
      emitCoerceFromObject(code);
      decl.compileStore(comp);
    }
  }
}
