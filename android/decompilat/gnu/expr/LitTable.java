// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.functions.IsEqual;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ObjectType;
import java.lang.reflect.Array;
import gnu.bytecode.Method;
import gnu.bytecode.Field;
import gnu.bytecode.PrimType;
import gnu.mapping.Values;
import java.util.regex.Pattern;
import java.math.BigDecimal;
import java.math.BigInteger;
import gnu.bytecode.ArrayType;
import java.io.Externalizable;
import gnu.lists.FString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import gnu.kawa.util.HashUtils;
import gnu.bytecode.Type;
import gnu.mapping.Table2D;
import gnu.bytecode.ClassType;
import java.io.ObjectOutput;
import gnu.kawa.util.GeneralHashTable;

public class LitTable extends GeneralHashTable<Object, Object> implements ObjectOutput
{
    Compilation comp;
    ClassType mainClass;
    static Table2D staticTable;
    int literalsCount;
    Literal literalsChain;
    private Object hashKeyCache;
    private int hashCodeCache;
    Object[] valueStack;
    Type[] typeStack;
    int stackPointer;
    static final LitEquals litEquals;
    
    public LitTable(final Compilation comp) {
        this.hashKeyCache = null;
        this.valueStack = new Object[20];
        this.typeStack = new Type[20];
        this.comp = comp;
        this.mainClass = comp.mainClass;
    }
    
    @Override
    public int hash(final Object key) {
        if (key == this.hashKeyCache) {
            return this.hashCodeCache;
        }
        final int h = this.comp.immediate ? System.identityHashCode(key) : HashUtils.boundedHash(key);
        this.hashKeyCache = key;
        return this.hashCodeCache = h;
    }
    
    @Override
    protected boolean matches(final Object key1, final Object key2) {
        if (this.comp.immediate) {
            return key1 == key2;
        }
        return LitTable.litEquals.apply(key1, key2, null);
    }
    
    public void emit() throws IOException {
        for (Literal init = this.literalsChain; init != null; init = init.next) {
            this.writeObject(init.value);
        }
        for (Literal init = this.literalsChain; init != null; init = init.next) {
            this.emit(init, true);
        }
        this.clear();
        this.literalsCount = 0;
    }
    
    void push(final Object value, final Type type) {
        if (this.stackPointer >= this.valueStack.length) {
            final Object[] newValues = new Object[2 * this.valueStack.length];
            final Type[] newTypes = new Type[2 * this.typeStack.length];
            System.arraycopy(this.valueStack, 0, newValues, 0, this.stackPointer);
            System.arraycopy(this.typeStack, 0, newTypes, 0, this.stackPointer);
            this.valueStack = newValues;
            this.typeStack = newTypes;
        }
        this.valueStack[this.stackPointer] = value;
        this.typeStack[this.stackPointer] = type;
        ++this.stackPointer;
    }
    
    void error(final String msg) {
        throw new Error(msg);
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public void write(final int b) throws IOException {
        this.error("cannot handle call to write(int) when externalizing literal");
    }
    
    @Override
    public void writeBytes(final String s) throws IOException {
        this.error("cannot handle call to writeBytes(String) when externalizing literal");
    }
    
    @Override
    public void write(final byte[] b) throws IOException {
        this.error("cannot handle call to write(byte[]) when externalizing literal");
    }
    
    @Override
    public void write(final byte[] b, final int off, final int len) throws IOException {
        this.error("cannot handle call to write(byte[],int,int) when externalizing literal");
    }
    
    @Override
    public void writeBoolean(final boolean v) {
        this.push(new Boolean(v), Type.booleanType);
    }
    
    @Override
    public void writeChar(final int v) {
        this.push(new Character((char)v), Type.charType);
    }
    
    @Override
    public void writeByte(final int v) {
        this.push(new Byte((byte)v), Type.byteType);
    }
    
    @Override
    public void writeShort(final int v) {
        this.push(new Short((short)v), Type.shortType);
    }
    
    @Override
    public void writeInt(final int v) {
        this.push(new Integer(v), Type.intType);
    }
    
    @Override
    public void writeLong(final long v) {
        this.push(new Long(v), Type.longType);
    }
    
    @Override
    public void writeFloat(final float v) {
        this.push(new Float(v), Type.floatType);
    }
    
    @Override
    public void writeDouble(final double v) {
        this.push(new Double(v), Type.doubleType);
    }
    
    @Override
    public void writeUTF(final String v) {
        this.push(v, Type.string_type);
    }
    
    @Override
    public void writeChars(final String v) {
        this.push(v, Type.string_type);
    }
    
    @Override
    public void writeObject(final Object obj) throws IOException {
        final Literal lit = this.findLiteral(obj);
        if ((lit.flags & 0x3) != 0x0) {
            if (lit.field == null && obj != null && !(obj instanceof String)) {
                lit.assign(this);
            }
            if ((lit.flags & 0x2) == 0x0) {
                final Literal literal = lit;
                literal.flags |= 0x4;
            }
        }
        else {
            final Literal literal2 = lit;
            literal2.flags |= 0x1;
            final int oldStack = this.stackPointer;
            if (obj instanceof FString && ((FString)obj).size() < 65535) {
                this.push(obj.toString(), Type.string_type);
            }
            else if (obj instanceof Externalizable) {
                ((Externalizable)obj).writeExternal(this);
            }
            else if (obj instanceof Object[]) {
                final Object[] arr = (Object[])obj;
                for (int i = 0; i < arr.length; ++i) {
                    this.writeObject(arr[i]);
                }
            }
            else if (obj != null && !(obj instanceof String)) {
                if (!(lit.type instanceof ArrayType)) {
                    if (obj instanceof BigInteger) {
                        this.writeChars(obj.toString());
                    }
                    else if (obj instanceof BigDecimal) {
                        final BigDecimal dec = (BigDecimal)obj;
                        this.writeObject(dec.unscaledValue());
                        this.writeInt(dec.scale());
                    }
                    else if (obj instanceof Integer) {
                        this.push(obj, Type.intType);
                    }
                    else if (obj instanceof Short) {
                        this.push(obj, Type.shortType);
                    }
                    else if (obj instanceof Byte) {
                        this.push(obj, Type.byteType);
                    }
                    else if (obj instanceof Long) {
                        this.push(obj, Type.longType);
                    }
                    else if (obj instanceof Double) {
                        this.push(obj, Type.doubleType);
                    }
                    else if (obj instanceof Float) {
                        this.push(obj, Type.floatType);
                    }
                    else if (obj instanceof Character) {
                        this.push(obj, Type.charType);
                    }
                    else if (obj instanceof Class) {
                        this.push(obj, Type.java_lang_Class_type);
                    }
                    else if (obj instanceof Pattern) {
                        final Pattern pat = (Pattern)obj;
                        this.push(pat.pattern(), Type.string_type);
                        this.push(pat.flags(), Type.intType);
                    }
                    else {
                        this.error(obj.getClass().getName() + " does not implement Externalizable");
                    }
                }
            }
            final int nargs = this.stackPointer - oldStack;
            if (nargs == 0) {
                lit.argValues = Values.noArgs;
                lit.argTypes = Type.typeArray0;
            }
            else {
                lit.argValues = new Object[nargs];
                lit.argTypes = new Type[nargs];
                System.arraycopy(this.valueStack, oldStack, lit.argValues, 0, nargs);
                System.arraycopy(this.typeStack, oldStack, lit.argTypes, 0, nargs);
                this.stackPointer = oldStack;
            }
            final Literal literal3 = lit;
            literal3.flags |= 0x2;
        }
        this.push(lit, lit.type);
    }
    
    public Literal findLiteral(final Object value) {
        if (value == null) {
            return Literal.nullLiteral;
        }
        Literal literal = ((AbstractHashTable<Entry, K, Literal>)this).get(value);
        final int valueHash = this.hash(value);
        if (literal != null) {
            return literal;
        }
        if (this.comp.immediate) {
            return new Literal(value, this);
        }
        final Class valueClass = value.getClass();
        final Type valueType = Type.make(valueClass);
        synchronized (LitTable.staticTable) {
            literal = (Literal)LitTable.staticTable.get(value, null, null);
            if ((literal == null || literal.value != value) && valueType instanceof ClassType) {
                final int needed_mod = 25;
                Class fldClass = valueClass;
                ClassType fldType = (ClassType)valueType;
                while (LitTable.staticTable.get(fldClass, Boolean.TRUE, null) == null) {
                    LitTable.staticTable.put(fldClass, Boolean.TRUE, fldClass);
                    for (Field fld = fldType.getFields(); fld != null; fld = fld.getNext()) {
                        if ((fld.getModifiers() & needed_mod) == needed_mod && !(fld.getType() instanceof PrimType)) {
                            try {
                                final java.lang.reflect.Field rfld = fld.getReflectField();
                                final Object litValue = rfld.get(null);
                                if (litValue != null && fldClass.isInstance(litValue)) {
                                    final Literal lit = new Literal(litValue, fld, this);
                                    LitTable.staticTable.put(litValue, null, lit);
                                    final int litHash = this.hash(litValue);
                                    if (valueHash == litHash && this.matches(litValue, value)) {
                                        literal = lit;
                                    }
                                }
                            }
                            catch (Exception ex) {
                                this.error("caught " + ex + " getting static field " + fld);
                            }
                        }
                    }
                    fldClass = fldClass.getSuperclass();
                    if (fldClass == null) {
                        break;
                    }
                    fldType = (ClassType)Type.make(fldClass);
                }
            }
        }
        if (literal == null) {
            literal = new Literal(value, valueType, this);
        }
        return literal;
    }
    
    Method getMethod(final ClassType type, final String name, final Literal literal, final boolean isStatic) {
        final Type[] argTypes = literal.argTypes;
        Method method = type.getDeclaredMethods();
        final int argLength = argTypes.length;
        Method best = null;
        long bestArrayArgs = 0L;
        boolean ambiguous = false;
        Type[] bParameters = null;
        while (method != null) {
            Label_0474: {
                if (name.equals(method.getName())) {
                    final boolean mstatic = method.getStaticFlag();
                    if (isStatic == mstatic) {
                        long arrayArgs = 0L;
                        final Type[] mParameters = method.getParameterTypes();
                        for (int iarg = 0, iparam = 0; iarg != argLength || iparam != mParameters.length; ++iarg, ++iparam) {
                            if (iarg == argLength) {
                                break Label_0474;
                            }
                            if (iparam == mParameters.length) {
                                break Label_0474;
                            }
                            final Type aType = argTypes[iarg];
                            final Type pType = mParameters[iparam];
                            if (!aType.isSubtype(pType)) {
                                if (!(pType instanceof ArrayType) || iparam >= 64 || (aType != Type.intType && aType != Type.shortType)) {
                                    break Label_0474;
                                }
                                int count = ((Number)literal.argValues[iarg]).intValue();
                                if (count < 0 && type.getName().equals("gnu.math.IntNum")) {
                                    count -= Integer.MIN_VALUE;
                                }
                                final Type elementType = ((ArrayType)pType).getComponentType();
                                if (count < 0) {
                                    break Label_0474;
                                }
                                if (iarg + count >= argLength) {
                                    break Label_0474;
                                }
                                int j = count;
                                while (--j >= 0) {
                                    final Type t = argTypes[iarg + j + 1];
                                    if (elementType instanceof PrimType) {
                                        if (elementType.getSignature() != t.getSignature()) {
                                            break Label_0474;
                                        }
                                        continue;
                                    }
                                    else {
                                        if (!t.isSubtype(elementType)) {
                                            break Label_0474;
                                        }
                                        continue;
                                    }
                                }
                                iarg += count;
                                arrayArgs |= 1 << iparam;
                            }
                        }
                        if (best == null || (bestArrayArgs != 0L && arrayArgs == 0L)) {
                            best = method;
                            bParameters = mParameters;
                            bestArrayArgs = arrayArgs;
                        }
                        else if (arrayArgs == 0L) {
                            boolean not1 = false;
                            boolean not2 = false;
                            int i = argLength;
                            while (--i >= 0) {
                                final int c = bParameters[i].compare(mParameters[i]);
                                if (c != 1) {
                                    not2 = true;
                                    if (not1) {
                                        break;
                                    }
                                }
                                if (c != -1) {
                                    not1 = true;
                                    if (not2) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                            if (not1) {
                                best = method;
                                bParameters = mParameters;
                            }
                            ambiguous = (not1 && not2);
                        }
                    }
                }
            }
            method = method.getNext();
        }
        if (ambiguous) {
            return null;
        }
        if (bestArrayArgs != 0L) {
            final Object[] args = new Object[bParameters.length];
            final Type[] types = new Type[bParameters.length];
            for (int iarg2 = 0, iparam2 = 0; iarg2 != argLength; ++iarg2, ++iparam2) {
                final Type pType2 = bParameters[iparam2];
                if ((bestArrayArgs & (long)(1 << iparam2)) == 0x0L) {
                    args[iparam2] = literal.argValues[iarg2];
                    types[iparam2] = literal.argTypes[iarg2];
                }
                else {
                    int count2 = ((Number)literal.argValues[iarg2]).intValue();
                    final boolean isIntNum = type.getName().equals("gnu.math.IntNum");
                    if (isIntNum) {
                        count2 -= Integer.MIN_VALUE;
                    }
                    final Type elementType2 = ((ArrayType)pType2).getComponentType();
                    types[iparam2] = pType2;
                    args[iparam2] = Array.newInstance(elementType2.getReflectClass(), count2);
                    final Object[] argValues = literal.argValues;
                    if (isIntNum) {
                        final int[] arr = (int[])args[iparam2];
                        for (int j = count2; j > 0; --j) {
                            arr[count2 - j] = (int)argValues[iarg2 + j];
                        }
                    }
                    else {
                        int k = count2;
                        while (--k >= 0) {
                            Array.set(args[iparam2], k, argValues[iarg2 + 1 + k]);
                        }
                    }
                    final Literal arrayLiteral = new Literal(args[iparam2], pType2);
                    if (elementType2 instanceof ObjectType) {
                        arrayLiteral.argValues = (Object[])args[iparam2];
                    }
                    args[iparam2] = arrayLiteral;
                    iarg2 += count2;
                }
            }
            literal.argValues = args;
            literal.argTypes = types;
        }
        return best;
    }
    
    void putArgs(final Literal literal, final CodeAttr code) {
        final Type[] argTypes = literal.argTypes;
        for (int len = argTypes.length, i = 0; i < len; ++i) {
            final Object value = literal.argValues[i];
            if (value instanceof Literal) {
                this.emit((Literal)value, false);
            }
            else {
                this.comp.compileConstant(value, new StackTarget(argTypes[i]));
            }
        }
    }
    
    private void store(final Literal literal, final boolean ignore, final CodeAttr code) {
        if (literal.field != null) {
            if (!ignore) {
                code.emitDup(literal.type);
            }
            code.emitPutStatic(literal.field);
        }
        literal.flags |= 0x8;
    }
    
    void emit(final Literal literal, final boolean ignore) {
        final CodeAttr code = this.comp.getCode();
        if (literal.value == null) {
            if (!ignore) {
                code.emitPushNull();
            }
        }
        else if (literal.value instanceof String) {
            if (!ignore) {
                code.emitPushString(literal.value.toString());
            }
        }
        else if ((literal.flags & 0x8) != 0x0) {
            if (!ignore) {
                code.emitGetStatic(literal.field);
            }
        }
        else if (literal.value instanceof Object[]) {
            final int len = literal.argValues.length;
            final Type elementType = ((ArrayType)literal.type).getComponentType();
            code.emitPushInt(len);
            code.emitNewArray(elementType);
            int numNonNull = 0;
            for (int i = 0; i < len; ++i) {
                if (((Literal)literal.argValues[i]).value != null) {
                    ++numNonNull;
                }
            }
            if (numNonNull > 0) {
                code.emitDup(literal.type);
            }
            this.store(literal, ignore, code);
            for (int i = 0; i < len; ++i) {
                final Literal el = (Literal)literal.argValues[i];
                if (el.value != null) {
                    if (--numNonNull > 0) {
                        code.emitDup(literal.type);
                    }
                    code.emitPushInt(i);
                    this.emit(el, false);
                    code.emitArrayStore(elementType);
                }
            }
        }
        else if (literal.type instanceof ArrayType) {
            code.emitPushPrimArray(literal.value, (ArrayType)literal.type);
            this.store(literal, ignore, code);
        }
        else if (literal.value instanceof Class) {
            final Class clas = (Class)literal.value;
            if (clas.isPrimitive()) {
                String cname = clas.getName();
                if (cname.equals("int")) {
                    cname = "integer";
                }
                cname = "java.lang." + Character.toUpperCase(cname.charAt(0)) + cname.substring(1);
                code.emitGetStatic(ClassType.make(cname).getDeclaredField("TYPE"));
            }
            else {
                this.comp.loadClassRef((ObjectType)Type.make(clas));
            }
            this.store(literal, ignore, code);
        }
        else if (literal.value instanceof ClassType && !((ClassType)literal.value).isExisting()) {
            final ClassType ct = (ClassType)literal.value;
            final boolean isPair = literal.value instanceof PairClassType;
            final ClassType typeType = isPair ? ClassType.make("gnu.expr.PairClassType") : Compilation.typeType;
            final Type[] atypes = new Type[isPair ? 2 : 1];
            int j = atypes.length;
            while (--j >= 0) {
                atypes[j] = Type.javalangClassType;
            }
            final Method meth = typeType.getDeclaredMethod("make", atypes);
            this.comp.loadClassRef(ct);
            if (isPair) {
                this.comp.loadClassRef(((PairClassType)ct).instanceType);
            }
            code.emitInvokeStatic(meth);
            code.emitCheckcast(Compilation.typeClassType);
            this.store(literal, ignore, code);
        }
        else {
            final ClassType type = (ClassType)literal.type;
            boolean useDefaultInit = (literal.flags & 0x4) != 0x0;
            Method method = null;
            boolean makeStatic = false;
            if (!useDefaultInit) {
                if (!(literal.value instanceof Symbol)) {
                    method = this.getMethod(type, "valueOf", literal, true);
                }
                else if (literal.value instanceof SimpleSymbol) {
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
                }
                else if (literal.argTypes.length > 0) {
                    method = this.getMethod(type, "<init>", literal, false);
                }
                if (method == null) {
                    useDefaultInit = true;
                }
            }
            if (useDefaultInit) {
                method = this.getMethod(type, "init", literal, false);
                if (method == null) {
                    method = this.getMethod(type, "set", literal, false);
                }
            }
            if (method == null && literal.argTypes.length > 0) {
                this.error("no method to construct " + literal.type);
            }
            if (makeStatic) {
                this.putArgs(literal, code);
                code.emitInvokeStatic(method);
            }
            else if (useDefaultInit) {
                code.emitNew(type);
                code.emitDup(type);
                final Method init0 = type.getDeclaredMethod("<init>", 0);
                code.emitInvokeSpecial(init0);
            }
            else {
                code.emitNew(type);
                code.emitDup(type);
                this.putArgs(literal, code);
                code.emitInvokeSpecial(method);
            }
            final Method resolveMethod = (makeStatic || literal.value instanceof Values) ? null : type.getDeclaredMethod("readResolve", 0);
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
    
    static {
        LitTable.staticTable = new Table2D(100);
        litEquals = new LitEquals();
    }
    
    static class LitEquals extends IsEqual
    {
        public LitEquals() {
            super(null, "(equals-for-literals)");
        }
        
        @Override
        public boolean apply(final Object arg1, final Object arg2, final Map<Object, ArrayList<Object>> map) {
            return arg1 == arg2 || (arg1 != null && arg2 != null && !(arg1 instanceof Symbol) && arg1.getClass() == arg2.getClass() && super.apply(arg1, arg2, map));
        }
    }
}
