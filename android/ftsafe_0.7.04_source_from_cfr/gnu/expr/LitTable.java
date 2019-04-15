/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.Literal;
import gnu.expr.PairClassType;
import gnu.expr.StackTarget;
import gnu.expr.Target;
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
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

public class LitTable
extends GeneralHashTable<Object, Object>
implements ObjectOutput {
    Compilation comp;
    ClassType mainClass;
    static Table2D staticTable = new Table2D(100);
    int literalsCount;
    Literal literalsChain;
    private Object hashKeyCache = null;
    private int hashCodeCache;
    Object[] valueStack = new Object[20];
    Type[] typeStack = new Type[20];
    int stackPointer;
    static final LitEquals litEquals = new LitEquals();

    public LitTable(Compilation comp) {
        this.comp = comp;
        this.mainClass = comp.mainClass;
    }

    @Override
    public int hash(Object key) {
        if (key == this.hashKeyCache) {
            return this.hashCodeCache;
        }
        int h = this.comp.immediate ? System.identityHashCode(key) : HashUtils.boundedHash(key);
        this.hashKeyCache = key;
        this.hashCodeCache = h;
        return h;
    }

    @Override
    protected boolean matches(Object key1, Object key2) {
        if (this.comp.immediate) {
            return key1 == key2;
        }
        return litEquals.apply(key1, key2, null);
    }

    public void emit() throws IOException {
        Literal init = this.literalsChain;
        while (init != null) {
            this.writeObject(init.value);
            init = init.next;
        }
        init = this.literalsChain;
        while (init != null) {
            this.emit(init, true);
            init = init.next;
        }
        this.clear();
        this.literalsCount = 0;
    }

    void push(Object value, Type type) {
        if (this.stackPointer >= this.valueStack.length) {
            Object[] newValues = new Object[2 * this.valueStack.length];
            Type[] newTypes = new Type[2 * this.typeStack.length];
            System.arraycopy(this.valueStack, 0, newValues, 0, this.stackPointer);
            System.arraycopy(this.typeStack, 0, newTypes, 0, this.stackPointer);
            this.valueStack = newValues;
            this.typeStack = newTypes;
        }
        this.valueStack[this.stackPointer] = value;
        this.typeStack[this.stackPointer] = type;
        ++this.stackPointer;
    }

    void error(String msg) {
        throw new Error(msg);
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
    }

    @Override
    public void write(int b) throws IOException {
        this.error("cannot handle call to write(int) when externalizing literal");
    }

    @Override
    public void writeBytes(String s) throws IOException {
        this.error("cannot handle call to writeBytes(String) when externalizing literal");
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.error("cannot handle call to write(byte[]) when externalizing literal");
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.error("cannot handle call to write(byte[],int,int) when externalizing literal");
    }

    @Override
    public void writeBoolean(boolean v) {
        this.push(new Boolean(v), Type.booleanType);
    }

    @Override
    public void writeChar(int v) {
        this.push(new Character((char)v), Type.charType);
    }

    @Override
    public void writeByte(int v) {
        this.push(new Byte((byte)v), Type.byteType);
    }

    @Override
    public void writeShort(int v) {
        this.push(new Short((short)v), Type.shortType);
    }

    @Override
    public void writeInt(int v) {
        this.push(new Integer(v), Type.intType);
    }

    @Override
    public void writeLong(long v) {
        this.push(new Long(v), Type.longType);
    }

    @Override
    public void writeFloat(float v) {
        this.push(new Float(v), Type.floatType);
    }

    @Override
    public void writeDouble(double v) {
        this.push(new Double(v), Type.doubleType);
    }

    @Override
    public void writeUTF(String v) {
        this.push(v, Type.string_type);
    }

    @Override
    public void writeChars(String v) {
        this.push(v, Type.string_type);
    }

    @Override
    public void writeObject(Object obj) throws IOException {
        Literal lit = this.findLiteral(obj);
        if ((lit.flags & 3) != 0) {
            if (lit.field == null && obj != null && !(obj instanceof String)) {
                lit.assign(this);
            }
            if ((lit.flags & 2) == 0) {
                lit.flags |= 4;
            }
        } else {
            lit.flags |= 1;
            int oldStack = this.stackPointer;
            if (obj instanceof FString && ((FString)obj).size() < 65535) {
                this.push(obj.toString(), Type.string_type);
            } else if (obj instanceof Externalizable) {
                ((Externalizable)obj).writeExternal(this);
            } else if (obj instanceof Object[]) {
                Object[] arr = (Object[])obj;
                for (int i = 0; i < arr.length; ++i) {
                    this.writeObject(arr[i]);
                }
            } else if (obj != null && !(obj instanceof String) && !(lit.type instanceof ArrayType)) {
                if (obj instanceof BigInteger) {
                    this.writeChars(obj.toString());
                } else if (obj instanceof BigDecimal) {
                    BigDecimal dec = (BigDecimal)obj;
                    this.writeObject(dec.unscaledValue());
                    this.writeInt(dec.scale());
                } else if (obj instanceof Integer) {
                    this.push(obj, Type.intType);
                } else if (obj instanceof Short) {
                    this.push(obj, Type.shortType);
                } else if (obj instanceof Byte) {
                    this.push(obj, Type.byteType);
                } else if (obj instanceof Long) {
                    this.push(obj, Type.longType);
                } else if (obj instanceof Double) {
                    this.push(obj, Type.doubleType);
                } else if (obj instanceof Float) {
                    this.push(obj, Type.floatType);
                } else if (obj instanceof Character) {
                    this.push(obj, Type.charType);
                } else if (obj instanceof Class) {
                    this.push(obj, Type.java_lang_Class_type);
                } else if (obj instanceof Pattern) {
                    Pattern pat = (Pattern)obj;
                    this.push(pat.pattern(), Type.string_type);
                    this.push(pat.flags(), Type.intType);
                } else {
                    this.error(obj.getClass().getName() + " does not implement Externalizable");
                }
            }
            int nargs = this.stackPointer - oldStack;
            if (nargs == 0) {
                lit.argValues = Values.noArgs;
                lit.argTypes = Type.typeArray0;
            } else {
                lit.argValues = new Object[nargs];
                lit.argTypes = new Type[nargs];
                System.arraycopy(this.valueStack, oldStack, lit.argValues, 0, nargs);
                System.arraycopy(this.typeStack, oldStack, lit.argTypes, 0, nargs);
                this.stackPointer = oldStack;
            }
            lit.flags |= 2;
        }
        this.push(lit, lit.type);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Literal findLiteral(Object value) {
        if (value == null) {
            return Literal.nullLiteral;
        }
        Literal literal = (Literal)this.get(value);
        int valueHash = this.hash(value);
        if (literal != null) {
            return literal;
        }
        if (this.comp.immediate) {
            return new Literal(value, this);
        }
        Class<?> valueClass = value.getClass();
        Type valueType = Type.make(valueClass);
        Table2D table2D = staticTable;
        synchronized (table2D) {
            literal = (Literal)staticTable.get(value, null, null);
            if ((literal == null || literal.value != value) && valueType instanceof ClassType) {
                int needed_mod = 25;
                Class<?> fldClass = valueClass;
                ClassType fldType = (ClassType)valueType;
                while (staticTable.get(fldClass, Boolean.TRUE, null) == null) {
                    staticTable.put(fldClass, Boolean.TRUE, fldClass);
                    for (gnu.bytecode.Field fld = fldType.getFields(); fld != null; fld = fld.getNext()) {
                        if ((fld.getModifiers() & needed_mod) != needed_mod || fld.getType() instanceof PrimType) continue;
                        try {
                            Field rfld = fld.getReflectField();
                            Object litValue = rfld.get(null);
                            if (litValue == null || !fldClass.isInstance(litValue)) continue;
                            Literal lit = new Literal(litValue, fld, this);
                            staticTable.put(litValue, null, lit);
                            int litHash = this.hash(litValue);
                            if (valueHash != litHash || !this.matches(litValue, value)) continue;
                            literal = lit;
                            continue;
                        }
                        catch (Exception ex) {
                            this.error("caught " + ex + " getting static field " + fld);
                        }
                    }
                    if ((fldClass = fldClass.getSuperclass()) == null) break;
                    fldType = (ClassType)Type.make(fldClass);
                }
            }
        }
        if (literal == null) {
            literal = new Literal(value, valueType, this);
        }
        return literal;
    }

    Method getMethod(ClassType type, String name, Literal literal, boolean isStatic) {
        int j;
        Type[] argTypes = literal.argTypes;
        int argLength = argTypes.length;
        Method best = null;
        long bestArrayArgs = 0L;
        boolean ambiguous = false;
        Type[] bParameters = null;
        block0 : for (Method method = type.getDeclaredMethods(); method != null; method = method.getNext()) {
            boolean mstatic;
            if (!name.equals(method.getName()) || isStatic != (mstatic = method.getStaticFlag())) continue;
            long arrayArgs = 0L;
            Type[] mParameters = method.getParameterTypes();
            int iarg = 0;
            int iparam = 0;
            do {
                if (iarg == argLength && iparam == mParameters.length) {
                    if (best == null || bestArrayArgs != 0L && arrayArgs == 0L) {
                        best = method;
                        bParameters = mParameters;
                        bestArrayArgs = arrayArgs;
                        continue block0;
                    }
                    if (arrayArgs != 0L) continue block0;
                    boolean not1 = false;
                    boolean not2 = false;
                    int j2 = argLength;
                    while (--j2 >= 0) {
                        int c = bParameters[j2].compare(mParameters[j2]);
                        if (c != 1) {
                            not2 = true;
                            if (not1) break;
                        }
                        if (c == -1) continue;
                        not1 = true;
                        if (!not2) continue;
                        break;
                    }
                    if (not1) {
                        best = method;
                        bParameters = mParameters;
                    }
                    ambiguous = not1 && not2;
                    continue block0;
                }
                if (iarg == argLength || iparam == mParameters.length) continue block0;
                Type aType = argTypes[iarg];
                Type pType = mParameters[iparam];
                if (!aType.isSubtype(pType)) {
                    if (!(pType instanceof ArrayType) || iparam >= 64 || aType != Type.intType && aType != Type.shortType) continue block0;
                    int count = ((Number)literal.argValues[iarg]).intValue();
                    if (count < 0 && type.getName().equals("gnu.math.IntNum")) {
                        count -= Integer.MIN_VALUE;
                    }
                    Type elementType = ((ArrayType)pType).getComponentType();
                    if (count < 0 || iarg + count >= argLength) continue block0;
                    j = count;
                    while (--j >= 0) {
                        Type t = argTypes[iarg + j + 1];
                        if (!(elementType instanceof PrimType ? elementType.getSignature() != t.getSignature() : !t.isSubtype(elementType))) continue;
                        continue block0;
                    }
                    iarg += count;
                    arrayArgs |= (long)(1 << iparam);
                }
                ++iarg;
                ++iparam;
            } while (true);
        }
        if (ambiguous) {
            return null;
        }
        if (bestArrayArgs != 0L) {
            Object[] args = new Object[bParameters.length];
            Type[] types = new Type[bParameters.length];
            int iarg = 0;
            int iparam = 0;
            while (iarg != argLength) {
                void pType = bParameters[iparam];
                if ((bestArrayArgs & (long)(1 << iparam)) == 0L) {
                    args[iparam] = literal.argValues[iarg];
                    types[iparam] = literal.argTypes[iarg];
                } else {
                    int count = ((Number)literal.argValues[iarg]).intValue();
                    boolean isIntNum = type.getName().equals("gnu.math.IntNum");
                    if (isIntNum) {
                        count -= Integer.MIN_VALUE;
                    }
                    Type elementType = ((ArrayType)pType).getComponentType();
                    types[iparam] = pType;
                    args[iparam] = Array.newInstance(elementType.getReflectClass(), count);
                    Object[] argValues = literal.argValues;
                    if (isIntNum) {
                        int[] arr = (int[])args[iparam];
                        for (j = count; j > 0; --j) {
                            arr[count - j] = (Integer)argValues[iarg + j];
                        }
                    } else {
                        int j3 = count;
                        while (--j3 >= 0) {
                            Array.set(args[iparam], j3, argValues[iarg + 1 + j3]);
                        }
                    }
                    Literal arrayLiteral = new Literal(args[iparam], (Type)pType);
                    if (elementType instanceof ObjectType) {
                        arrayLiteral.argValues = (Object[])args[iparam];
                    }
                    args[iparam] = arrayLiteral;
                    iarg += count;
                }
                ++iarg;
                ++iparam;
            }
            literal.argValues = args;
            literal.argTypes = types;
        }
        return best;
    }

    void putArgs(Literal literal, CodeAttr code) {
        Type[] argTypes = literal.argTypes;
        int len = argTypes.length;
        for (int i = 0; i < len; ++i) {
            Object value = literal.argValues[i];
            if (value instanceof Literal) {
                this.emit((Literal)value, false);
                continue;
            }
            this.comp.compileConstant(value, new StackTarget(argTypes[i]));
        }
    }

    private void store(Literal literal, boolean ignore, CodeAttr code) {
        if (literal.field != null) {
            if (!ignore) {
                code.emitDup(literal.type);
            }
            code.emitPutStatic(literal.field);
        }
        literal.flags |= 8;
    }

    void emit(Literal literal, boolean ignore) {
        CodeAttr code = this.comp.getCode();
        if (literal.value == null) {
            if (!ignore) {
                code.emitPushNull();
            }
        } else if (literal.value instanceof String) {
            if (!ignore) {
                code.emitPushString(literal.value.toString());
            }
        } else if ((literal.flags & 8) != 0) {
            if (!ignore) {
                code.emitGetStatic(literal.field);
            }
        } else if (literal.value instanceof Object[]) {
            int i;
            int len = literal.argValues.length;
            Type elementType = ((ArrayType)literal.type).getComponentType();
            code.emitPushInt(len);
            code.emitNewArray(elementType);
            int numNonNull = 0;
            for (i = 0; i < len; ++i) {
                if (((Literal)literal.argValues[i]).value == null) continue;
                ++numNonNull;
            }
            if (numNonNull > 0) {
                code.emitDup(literal.type);
            }
            this.store(literal, ignore, code);
            for (i = 0; i < len; ++i) {
                Literal el = (Literal)literal.argValues[i];
                if (el.value == null) continue;
                if (--numNonNull > 0) {
                    code.emitDup(literal.type);
                }
                code.emitPushInt(i);
                this.emit(el, false);
                code.emitArrayStore(elementType);
            }
        } else if (literal.type instanceof ArrayType) {
            code.emitPushPrimArray(literal.value, (ArrayType)literal.type);
            this.store(literal, ignore, code);
        } else if (literal.value instanceof Class) {
            Class clas = (Class)literal.value;
            if (clas.isPrimitive()) {
                String cname = clas.getName();
                if (cname.equals("int")) {
                    cname = "integer";
                }
                cname = "java.lang." + Character.toUpperCase(cname.charAt(0)) + cname.substring(1);
                code.emitGetStatic(ClassType.make(cname).getDeclaredField("TYPE"));
            } else {
                this.comp.loadClassRef((ObjectType)Type.make(clas));
            }
            this.store(literal, ignore, code);
        } else if (literal.value instanceof ClassType && !((ClassType)literal.value).isExisting()) {
            ClassType ct = (ClassType)literal.value;
            boolean isPair = literal.value instanceof PairClassType;
            ClassType typeType = isPair ? ClassType.make("gnu.expr.PairClassType") : Compilation.typeType;
            Type[] atypes = new Type[isPair ? 2 : 1];
            int i = atypes.length;
            while (--i >= 0) {
                atypes[i] = Type.javalangClassType;
            }
            Method meth = typeType.getDeclaredMethod("make", atypes);
            this.comp.loadClassRef(ct);
            if (isPair) {
                this.comp.loadClassRef(((PairClassType)ct).instanceType);
            }
            code.emitInvokeStatic(meth);
            code.emitCheckcast(Compilation.typeClassType);
            this.store(literal, ignore, code);
        } else {
            Method resolveMethod;
            ClassType type = (ClassType)literal.type;
            boolean useDefaultInit = (literal.flags & 4) != 0;
            Method method = null;
            boolean makeStatic = false;
            if (!useDefaultInit) {
                if (!(literal.value instanceof Symbol)) {
                    method = this.getMethod(type, "valueOf", literal, true);
                } else if (literal.value instanceof SimpleSymbol) {
                    method = this.getMethod(Compilation.typeSymbol, "valueOf", literal, true);
                }
                if (method == null && !(literal.value instanceof Values)) {
                    String mname = "make";
                    if (literal.value instanceof Pattern) {
                        mname = "compile";
                    }
                    method = this.getMethod(type, mname, literal, true);
                }
                if (method != null) {
                    makeStatic = true;
                } else if (literal.argTypes.length > 0) {
                    method = this.getMethod(type, "<init>", literal, false);
                }
                if (method == null) {
                    useDefaultInit = true;
                }
            }
            if (useDefaultInit && (method = this.getMethod(type, "init", literal, false)) == null) {
                method = this.getMethod(type, "set", literal, false);
            }
            if (method == null && literal.argTypes.length > 0) {
                this.error("no method to construct " + literal.type);
            }
            if (makeStatic) {
                this.putArgs(literal, code);
                code.emitInvokeStatic(method);
            } else if (useDefaultInit) {
                code.emitNew(type);
                code.emitDup(type);
                Method init0 = type.getDeclaredMethod("<init>", 0);
                code.emitInvokeSpecial(init0);
            } else {
                code.emitNew(type);
                code.emitDup(type);
                this.putArgs(literal, code);
                code.emitInvokeSpecial(method);
            }
            Method method2 = resolveMethod = makeStatic || literal.value instanceof Values ? null : type.getDeclaredMethod("readResolve", 0);
            if (resolveMethod != null) {
                code.emitInvokeVirtual(resolveMethod);
                type.emitCoerceFromObject(code);
            }
            this.store(literal, ignore && (!useDefaultInit || method == null), code);
            if (useDefaultInit && method != null) {
                if (!ignore) {
                    code.emitDup(type);
                }
                this.putArgs(literal, code);
                code.emitInvokeVirtual(method);
            }
        }
    }

    static class LitEquals
    extends IsEqual {
        public LitEquals() {
            super(null, "(equals-for-literals)");
        }

        @Override
        public boolean apply(Object arg1, Object arg2, Map<Object, ArrayList<Object>> map) {
            if (arg1 == arg2) {
                return true;
            }
            if (arg1 == null || arg2 == null || arg1 instanceof Symbol || arg1.getClass() != arg2.getClass()) {
                return false;
            }
            return super.apply(arg1, arg2, map);
        }
    }

}

