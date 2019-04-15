/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.lists.AbstractSequence;
import gnu.lists.Array;
import gnu.lists.Arrays;
import gnu.lists.ComposedArray;
import gnu.lists.FString;
import gnu.lists.Range;
import gnu.lists.Sequence;
import gnu.lists.Sequences;
import gnu.lists.SimpleVector;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Procedure2;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import java.util.List;

public class Setter
extends Procedure1
implements HasSetter {
    public static final Setter setter = new Setter();

    public static Object setter(Procedure arg) {
        return arg.getSetter();
    }

    @Override
    public Object apply1(Object arg) {
        if (!(arg instanceof Procedure)) {
            if (arg instanceof List) {
                return new SetList((List)arg);
            }
            if (arg instanceof Array) {
                return new SetGArray((Array)arg);
            }
            Class<?> cl = arg.getClass();
            if (cl.isArray()) {
                return new SetArray(arg, Language.getDefaultLanguage());
            }
        }
        return ((Procedure)arg).getSetter();
    }

    @Override
    public void set1(Object arg1, Object value) throws Throwable {
        ((Procedure)arg1).setSetter((Procedure)value);
    }

    static {
        setter.setName("setter");
        setter.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateSetter");
    }

    public static class SetGArray
    extends ProcedureN {
        Array array;

        public SetGArray(Array array) {
            this.array = array;
        }

        @Override
        public Object applyN(Object[] args) {
            int dim = args.length - 1;
            Array lhs = (Array)ComposedArray.generalIndex(this.array, true, 0, dim, args);
            Object value = args[dim];
            if (lhs.rank() == 0 && !(value instanceof Array)) {
                lhs.set(AbstractSequence.noInts, value);
            } else {
                Arrays.copy(lhs, (Array)value);
            }
            return Values.empty;
        }
    }

    public static class SetList
    extends Procedure2 {
        List list;
        Type elementType;

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public SetList(List list) {
            block12 : {
                super();
                if (!(list instanceof SimpleVector)) break block12;
                tag = ((SimpleVector)list).getTag();
                tag0 = tag == null || tag.length() == 0 ? 0 : (int)tag.charAt(0);
                switch (tag0) {
                    case 99: {
                        if (tag.equals("c16")) {
                            this.elementType = LangPrimType.charType;
                            break;
                        }
                        if (!tag.equals("c32")) break;
                        this.elementType = LangPrimType.characterType;
                        break;
                    }
                    case 102: {
                        if (tag.equals("f32")) {
                            this.elementType = LangPrimType.floatType;
                            break;
                        }
                        if (!tag.equals("f64")) break;
                        this.elementType = LangPrimType.doubleType;
                        break;
                    }
                    case 117: {
                        if (!tag.equals("u64")) ** GOTO lbl24
                        this.elementType = LangPrimType.unsignedLongType;
                        ** GOTO lbl32
lbl24: // 1 sources:
                        if (!tag.equals("u32")) ** GOTO lbl27
                        this.elementType = LangPrimType.unsignedIntType;
                        ** GOTO lbl32
lbl27: // 1 sources:
                        if (!tag.equals("u16")) ** GOTO lbl30
                        this.elementType = LangPrimType.unsignedShortType;
                        ** GOTO lbl32
lbl30: // 1 sources:
                        if (tag.equals("u8")) {
                            this.elementType = LangPrimType.unsignedByteType;
                        }
                    }
lbl32: // 7 sources:
                    case 115: {
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
                        if (!tag.equals("s8")) break;
                        this.elementType = LangPrimType.byteType;
                    }
                }
            }
            this.list = list;
        }

        @Override
        public Object apply2(Object index, Object value) {
            if (index instanceof Range.IntRange) {
                Range.IntRange range = (Range.IntRange)index;
                int istart = range.getStartInt();
                int size = range.size();
                if (range.getStepInt() != 1) {
                    throw new ClassCastException("step of index range must be 1");
                }
                if (this.list instanceof FString && value instanceof CharSequence) {
                    CharSequence sval = (CharSequence)value;
                    ((FString)this.list).replace(sval, 0, sval.length(), istart, istart + size);
                } else {
                    Sequences.replace(this.list, istart, istart + size, Sequences.coerceToSequence(value));
                }
            } else {
                if (this.elementType != null) {
                    value = this.elementType.coerceToObject(value);
                }
                int ind = ((Number)index).intValue();
                if (this.list instanceof Sequence) {
                    ((Sequence)this.list).set(ind, value);
                } else {
                    this.list.set(ind, value);
                }
            }
            return Values.empty;
        }
    }

    public static class SetArray
    extends Procedure2 {
        Object array;
        Type elementType;

        public SetArray(Object array, Language language) {
            Class<?> elementClass = array.getClass().getComponentType();
            this.elementType = language.getTypeFor(elementClass);
            this.array = array;
        }

        @Override
        public Object apply2(Object index, Object value) {
            if (this.elementType != null) {
                value = this.elementType.coerceFromObject(value);
            }
            java.lang.reflect.Array.set(this.array, ((Number)index).intValue(), value);
            return Values.empty;
        }
    }

}

