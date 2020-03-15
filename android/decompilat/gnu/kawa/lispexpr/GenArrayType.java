// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.bytecode.CodeAttr;
import gnu.expr.Declaration;
import gnu.kawa.reflect.InstanceOf;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.bytecode.Variable;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.mapping.Procedure;
import gnu.expr.Expression;
import gnu.bytecode.PrimType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.TypeValue;
import gnu.bytecode.ParameterizedType;

public class GenArrayType extends ParameterizedType implements TypeValue
{
    int rank;
    Type implementationType;
    public static final ClassType typeArray;
    public static final GenArrayType generalInstance;
    
    public GenArrayType(final int rank, final Type elementType) {
        super(GenArrayType.typeArray, new Type[] { elementType });
        this.rank = rank;
        Type elementImplementation = elementType.getImplementationType();
        if (elementImplementation instanceof PrimType) {
            elementImplementation = ((PrimType)elementImplementation).boxedType();
        }
        if (elementImplementation == elementType) {
            this.implementationType = this;
        }
        else {
            this.implementationType = new ParameterizedType(GenArrayType.typeArray, new Type[] { elementImplementation });
        }
    }
    
    @Override
    public Type getImplementationType() {
        return this.implementationType;
    }
    
    public int rank() {
        return this.rank;
    }
    
    public Type getComponentType() {
        return this.getTypeArgumentType(0);
    }
    
    @Override
    public int compare(final Type other) {
        if (!(other instanceof GenArrayType)) {
            final int r = GenArrayType.typeArray.compare(other);
            return (r == 0 || r == -1) ? -1 : ((r == -3) ? -3 : -2);
        }
        final GenArrayType aother = (GenArrayType)other;
        final int elcomp = this.getComponentType().compare(aother.getComponentType());
        if (this.rank == aother.rank) {
            return elcomp;
        }
        if (this.rank != -1 && aother.rank != -1) {
            return -3;
        }
        final int rcomp = (this.rank == -1) ? 1 : -1;
        if (rcomp == elcomp) {
            return elcomp;
        }
        return -2;
    }
    
    @Override
    public Expression convertValue(final Expression value) {
        return null;
    }
    
    @Override
    public Procedure getConstructor() {
        if (this.rank < 0 && this.getComponentType() == Type.objectType) {
            return new PrimProcedure("kawa.lib.arrays", "array", 2);
        }
        return null;
    }
    
    @Override
    public String encodeType(final Language language) {
        final StringBuilder sb = new StringBuilder("array");
        if (this.rank >= 0) {
            sb.append(this.rank);
        }
        final Type elementType = this.getComponentType();
        if (elementType != Type.objectType && elementType != null) {
            sb.append('[');
            final String el = language.encodeType(elementType);
            sb.append((el != null) ? el : elementType.getName());
            sb.append(']');
        }
        return sb.toString();
    }
    
    @Override
    public void emitIsInstance(final Variable incoming, final Compilation comp, final Target target) {
        InstanceOf.emitIsInstance(this, incoming, comp, target);
    }
    
    @Override
    public void emitTestIf(final Variable incoming, final Declaration decl, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        this.implementationType.emitIsInstance(code);
        code.emitIfIntNotZero();
        if (decl != null) {
            code.emitLoad(incoming);
            this.emitCoerceFromObject(code);
            decl.compileStore(comp);
        }
    }
    
    static {
        typeArray = ClassType.make("gnu.lists.Array");
        generalInstance = new GenArrayType(-1, Type.objectType);
    }
}
