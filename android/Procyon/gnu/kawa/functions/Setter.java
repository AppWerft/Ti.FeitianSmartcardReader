// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.lists.Arrays;
import gnu.lists.AbstractSequence;
import gnu.lists.ComposedArray;
import gnu.mapping.ProcedureN;
import gnu.lists.Sequence;
import gnu.lists.Sequences;
import gnu.lists.FString;
import gnu.lists.Range;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.lists.SimpleVector;
import gnu.mapping.Values;
import gnu.bytecode.Type;
import gnu.mapping.Procedure2;
import gnu.expr.Language;
import gnu.lists.Array;
import java.util.List;
import gnu.mapping.Procedure;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure1;

public class Setter extends Procedure1 implements HasSetter
{
    public static final Setter setter;
    
    public static Object setter(final Procedure arg) {
        return arg.getSetter();
    }
    
    @Override
    public Object apply1(final Object arg) {
        if (!(arg instanceof Procedure)) {
            if (arg instanceof List) {
                return new SetList((List)arg);
            }
            if (arg instanceof Array) {
                return new SetGArray((Array)arg);
            }
            final Class cl = arg.getClass();
            if (cl.isArray()) {
                return new SetArray(arg, Language.getDefaultLanguage());
            }
        }
        return ((Procedure)arg).getSetter();
    }
    
    @Override
    public void set1(final Object arg1, final Object value) throws Throwable {
        ((Procedure)arg1).setSetter((Procedure)value);
    }
    
    static {
        (setter = new Setter()).setName("setter");
        Setter.setter.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateSetter");
    }
    
    public static class SetArray extends Procedure2
    {
        Object array;
        Type elementType;
        
        public SetArray(final Object array, final Language language) {
            final Class elementClass = array.getClass().getComponentType();
            this.elementType = language.getTypeFor(elementClass);
            this.array = array;
        }
        
        @Override
        public Object apply2(final Object index, Object value) {
            if (this.elementType != null) {
                value = this.elementType.coerceFromObject(value);
            }
            java.lang.reflect.Array.set(this.array, ((Number)index).intValue(), value);
            return Values.empty;
        }
    }
    
    public static class SetList extends Procedure2
    {
        List list;
        Type elementType;
        
        public SetList(final List list) {
            if (list instanceof SimpleVector) {
                final String tag = ((SimpleVector)list).getTag();
                final char tag2 = (tag == null || tag.length() == 0) ? '\0' : tag.charAt(0);
                Label_0233: {
                    switch (tag2) {
                        case 'c': {
                            if (tag.equals("c16")) {
                                this.elementType = LangPrimType.charType;
                                break;
                            }
                            if (tag.equals("c32")) {
                                this.elementType = LangPrimType.characterType;
                                break;
                            }
                            break;
                        }
                        case 'f': {
                            if (tag.equals("f32")) {
                                this.elementType = LangPrimType.floatType;
                                break;
                            }
                            if (tag.equals("f64")) {
                                this.elementType = LangPrimType.doubleType;
                                break;
                            }
                            break;
                        }
                        case 'u': {
                            if (tag.equals("u64")) {
                                this.elementType = LangPrimType.unsignedLongType;
                                break Label_0233;
                            }
                            if (tag.equals("u32")) {
                                this.elementType = LangPrimType.unsignedIntType;
                                break Label_0233;
                            }
                            if (tag.equals("u16")) {
                                this.elementType = LangPrimType.unsignedShortType;
                                break Label_0233;
                            }
                            if (tag.equals("u8")) {
                                this.elementType = LangPrimType.unsignedByteType;
                            }
                            break Label_0233;
                        }
                        case 's': {
                            if (tag.equals("s64")) {
                                this.elementType = LangPrimType.longType;
                                break;
                            }
                            if (tag.equals("s32")) {
                                this.elementType = LangPrimType.intType;
                                break;
                            }
                            if (tag.equals("s16")) {
                                this.elementType = LangPrimType.shortType;
                                break;
                            }
                            if (tag.equals("s8")) {
                                this.elementType = LangPrimType.byteType;
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            this.list = list;
        }
        
        @Override
        public Object apply2(final Object index, Object value) {
            if (index instanceof Range.IntRange) {
                final Range.IntRange range = (Range.IntRange)index;
                final int istart = range.getStartInt();
                final int size = range.size();
                if (range.getStepInt() != 1) {
                    throw new ClassCastException("step of index range must be 1");
                }
                if (this.list instanceof FString && value instanceof CharSequence) {
                    final CharSequence sval = (CharSequence)value;
                    ((FString)this.list).replace(sval, 0, sval.length(), istart, istart + size);
                }
                else {
                    Sequences.replace(this.list, istart, istart + size, Sequences.coerceToSequence(value));
                }
            }
            else {
                if (this.elementType != null) {
                    value = this.elementType.coerceToObject(value);
                }
                final int ind = ((Number)index).intValue();
                if (this.list instanceof Sequence) {
                    ((Sequence)this.list).set(ind, value);
                }
                else {
                    this.list.set(ind, value);
                }
            }
            return Values.empty;
        }
    }
    
    public static class SetGArray extends ProcedureN
    {
        Array array;
        
        public SetGArray(final Array array) {
            this.array = array;
        }
        
        @Override
        public Object applyN(final Object[] args) {
            final int dim = args.length - 1;
            final Array lhs = (Array)ComposedArray.generalIndex(this.array, true, 0, dim, args);
            final Object value = args[dim];
            if (lhs.rank() == 0 && !(value instanceof Array)) {
                lhs.set(AbstractSequence.noInts, value);
            }
            else {
                Arrays.copy(lhs, (Array<Object>)value);
            }
            return Values.empty;
        }
    }
}
