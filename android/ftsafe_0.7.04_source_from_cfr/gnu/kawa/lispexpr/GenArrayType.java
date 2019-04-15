/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.reflect.InstanceOf;
import gnu.mapping.Procedure;

public class GenArrayType
extends ParameterizedType
implements TypeValue {
    int rank;
    Type implementationType;
    public static final ClassType typeArray = ClassType.make("gnu.lists.Array");
    public static final GenArrayType generalInstance = new GenArrayType(-1, Type.objectType);

    public GenArrayType(int rank, Type elementType) {
        super(typeArray, elementType);
        this.rank = rank;
        Type elementImplementation = elementType.getImplementationType();
        if (elementImplementation instanceof PrimType) {
            elementImplementation = ((PrimType)elementImplementation).boxedType();
        }
        this.implementationType = elementImplementation == elementType ? this : new ParameterizedType(typeArray, elementImplementation);
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
    public int compare(Type other) {
        if (other instanceof GenArrayType) {
            int rcomp;
            GenArrayType aother = (GenArrayType)other;
            int elcomp = this.getComponentType().compare(aother.getComponentType());
            if (this.rank == aother.rank) {
                return elcomp;
            }
            if (this.rank != -1 && aother.rank != -1) {
                return -3;
            }
            int n = rcomp = this.rank == -1 ? 1 : -1;
            if (rcomp == elcomp) {
                return elcomp;
            }
            return -2;
        }
        int r = typeArray.compare(other);
        return r == 0 || r == -1 ? -1 : (r == -3 ? -3 : -2);
    }

    @Override
    public Expression convertValue(Expression value) {
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
    public String encodeType(Language language) {
        Type elementType;
        StringBuilder sb = new StringBuilder("array");
        if (this.rank >= 0) {
            sb.append(this.rank);
        }
        if ((elementType = this.getComponentType()) != Type.objectType && elementType != null) {
            sb.append('[');
            String el = language.encodeType(elementType);
            sb.append(el != null ? el : elementType.getName());
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public void emitIsInstance(Variable incoming, Compilation comp, Target target) {
        InstanceOf.emitIsInstance(this, incoming, comp, target);
    }

    @Override
    public void emitTestIf(Variable incoming, Declaration decl, Compilation comp) {
        CodeAttr code = comp.getCode();
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
}

