/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.kawa.format.Printable;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.ItemPredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.lists.TreePosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

public abstract class Values<E>
extends AbstractSequence<E>
implements Consumable,
Externalizable {
    public static final Object[] noArgs = new Object[0];
    public static final Values empty = new FromArray<Object>(noArgs);

    protected Values() {
    }

    public Object[] getValues() {
        int sz = this.size();
        Object[] arr = new Object[sz];
        int it = 0;
        int i = 0;
        while ((it = this.nextPos(it)) != 0) {
            arr[i++] = this.getPosPrevious(it);
        }
        return arr;
    }

    public static /* varargs */ Object values(Object ... vals) {
        return Values.make(vals);
    }

    public static <E, V1 extends E, V2 extends E> Values2<E, V1, V2> values2(V1 val1, V2 val2) {
        return new Values2(val1, val2);
    }

    public static Values make() {
        return new FromTreeList();
    }

    public static <E> Object make(E[] vals) {
        if (vals.length == 1) {
            return vals[0];
        }
        if (vals.length == 0) {
            return empty;
        }
        return new FromArray<E>(vals);
    }

    public static /* varargs */ <E> Values<E> makeFromArray(E ... vals) {
        return new FromArray<E>(vals);
    }

    public static <E> Object make(List<E> seq) {
        int count;
        int n = count = seq == null ? 0 : seq.size();
        if (count == 0) {
            return empty;
        }
        if (count == 1) {
            return seq.get(0);
        }
        return new FromList<E>(seq);
    }

    public static Object make(TreeList list, int startPosition, int endPosition) {
        int next;
        if (startPosition == endPosition || (next = list.nextDataIndex(startPosition)) <= 0) {
            return empty;
        }
        if (next == endPosition || list.nextDataIndex(next) < 0) {
            return list.getPosNext(startPosition << 1);
        }
        FromTreeList vals = new FromTreeList();
        list.consumeIRange(startPosition, endPosition, vals.buffer);
        return vals;
    }

    public Object canonicalize() {
        int sz = this.size();
        if (sz == 0) {
            return empty;
        }
        if (sz == 1) {
            return this.get(0);
        }
        return this;
    }

    public Object call_with(Procedure proc) throws Throwable {
        return proc.applyN(this.getValues());
    }

    public void check_with(Procedure proc, CallContext ctx) {
        proc.checkN(this.getValues(), ctx);
    }

    public void print(Consumer out) {
        if (this == empty) {
            out.write("#!void");
            return;
        }
        boolean readable = true;
        if (readable) {
            out.write("#<values");
        }
        int it = 0;
        while ((it = this.nextPos(it)) != 0) {
            out.write(32);
            Object val = this.getPosPrevious(it);
            if (val instanceof Printable) {
                ((Printable)val).print(out);
                continue;
            }
            out.writeObject(val);
        }
        if (readable) {
            out.write(62);
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.size());
        int it = 0;
        boolean i = false;
        while ((it = this.nextPos(it)) != 0) {
            out.writeObject(this.getPosPrevious(it));
        }
    }

    public Object readResolve() throws ObjectStreamException {
        return this.canonicalize();
    }

    public static int incrPos(Object values, int pos) {
        if (values instanceof Values) {
            return ((Values)values).nextPos(pos);
        }
        return 1 - pos;
    }

    public static Object getFromPos(Object values, int pos) {
        if (pos == 0) {
            throw new IndexOutOfBoundsException("not enough values");
        }
        if (values instanceof Values) {
            return ((Values)values).getPosPrevious(pos);
        }
        return values;
    }

    public static Object getFromPosFinal(Object values, int pos) {
        Object r = Values.getFromPos(values, pos);
        Values.checkFinalPos(values, pos);
        return r;
    }

    public static void checkFinalPos(Object values, int pos) {
        if (Values.incrPos(values, pos) != 0) {
            throw new IndexOutOfBoundsException("too many values");
        }
    }

    public static int nextIndex(Object values, int curIndex) {
        if (values instanceof Values) {
            int next;
            if (curIndex == Integer.MAX_VALUE) {
                curIndex = -1;
            }
            return (next = ((Values)values).nextPos(curIndex)) == 0 ? -1 : (next == -1 ? Integer.MAX_VALUE : next);
        }
        return curIndex == 0 ? 1 : -1;
    }

    public static Object nextValue(Object values, int curIndex) {
        if (values instanceof Values) {
            if (curIndex == Integer.MAX_VALUE) {
                curIndex = -1;
            }
            return ((Values)values).getPosNext(curIndex);
        }
        return values;
    }

    @Override
    protected int nextIndex(int ipos) {
        if (ipos == -1) {
            return this.size();
        }
        return ipos >>> 1;
    }

    public static void writeValues(Object value, Consumer out) {
        if (value instanceof Values) {
            ((Values)value).consume(out);
        } else {
            out.writeObject(value);
        }
    }

    public static int countValues(Object value) {
        return value instanceof Values ? ((Values)value).size() : 1;
    }

    public static class FromTreeList
    extends Values<Object>
    implements Printable,
    Consumer,
    PositionConsumer {
        protected final TreeList buffer;

        public FromTreeList(Object[] values) {
            this();
            for (int i = 0; i < values.length; ++i) {
                this.buffer.writeObject(values[i]);
            }
        }

        public FromTreeList() {
            this.buffer = new TreeList();
        }

        public FromTreeList(TreeList list) {
            this.buffer = list;
        }

        @Override
        public int size() {
            return this.buffer.size();
        }

        @Override
        public Object get(int index) {
            return this.buffer.get(index);
        }

        @Override
        public int createPos(int index, boolean isAfter) {
            return this.buffer.createPos(index, isAfter);
        }

        @Override
        public Object canonicalize() {
            if (this.buffer.gapEnd == this.buffer.data.length) {
                if (this.buffer.gapStart == 0) {
                    return empty;
                }
                if (this.buffer.nextDataIndex(0) == this.buffer.gapStart) {
                    return this.buffer.getPosNext(0);
                }
            }
            return this;
        }

        @Override
        public Object[] getValues() {
            return this.buffer.isEmpty() ? noArgs : this.buffer.toArray();
        }

        @Override
        public int nextMatching(int startPos, ItemPredicate type, int endPos, boolean descend) {
            return this.buffer.nextMatching(startPos, type, endPos, descend);
        }

        @Override
        public void clear() {
            this.buffer.clear();
        }

        @Override
        public int createRelativePos(int pos, int delta, boolean isAfter) {
            return this.buffer.createRelativePos(pos, delta, isAfter);
        }

        @Override
        protected int nextIndex(int ipos) {
            return this.buffer.nextIndex(ipos);
        }

        @Override
        public boolean hasNext(int ipos) {
            return this.buffer.hasNext(ipos);
        }

        @Override
        public int getNextKind(int ipos) {
            return this.buffer.getNextKind(ipos);
        }

        @Override
        public Object getNextTypeObject(int ipos) {
            return this.buffer.getNextTypeObject(ipos);
        }

        @Override
        public int nextPos(int ipos) {
            return this.buffer.nextPos(ipos);
        }

        @Override
        public int firstChildPos(int ipos) {
            return this.buffer.firstChildPos(ipos);
        }

        @Override
        public int firstAttributePos(int ipos) {
            return this.buffer.firstAttributePos(ipos);
        }

        @Override
        public int parentPos(int ipos) {
            return this.buffer.parentPos(ipos);
        }

        @Override
        public boolean gotoAttributesStart(TreePosition pos) {
            return this.buffer.gotoAttributesStart(pos);
        }

        @Override
        public Object getPosNext(int ipos) {
            return this.buffer.getPosNext(ipos);
        }

        @Override
        public Object getPosPrevious(int ipos) {
            return this.buffer.getPosPrevious(ipos);
        }

        @Override
        public int compare(int ipos1, int ipos2) {
            return this.buffer.compare(ipos1, ipos2);
        }

        @Override
        public int hashCode() {
            return this.buffer.hashCode();
        }

        @Override
        public boolean consumeNext(int ipos, Consumer out) {
            return this.buffer.consumeNext(ipos, out);
        }

        @Override
        public void consumePosRange(int startPos, int endPos, Consumer out) {
            this.buffer.consumePosRange(startPos, endPos, out);
        }

        @Override
        public void consume(Consumer out) {
            this.buffer.consume(out);
        }

        @Override
        public void toString(String sep, StringBuffer sbuf) {
            this.buffer.toString(sep, sbuf);
        }

        @Override
        public void writeBoolean(boolean v) {
            this.buffer.writeBoolean(v);
        }

        @Override
        public void writeFloat(float v) {
            this.buffer.writeFloat(v);
        }

        @Override
        public void writeDouble(double v) {
            this.buffer.writeDouble(v);
        }

        @Override
        public void writeInt(int v) {
            this.buffer.writeInt(v);
        }

        @Override
        public void writeLong(long v) {
            this.buffer.writeLong(v);
        }

        @Override
        public void startDocument() {
            this.buffer.startDocument();
        }

        @Override
        public void endDocument() {
            this.buffer.endDocument();
        }

        @Override
        public void startElement(Object type) {
            this.buffer.startElement(type);
        }

        @Override
        public void endElement() {
            this.buffer.endElement();
        }

        @Override
        public void startAttribute(Object t) {
            this.buffer.startAttribute(t);
        }

        @Override
        public void endAttribute() {
            this.buffer.endAttribute();
        }

        @Override
        public void writeObject(Object v) {
            this.buffer.writeObject(v);
        }

        @Override
        public boolean ignoring() {
            return this.buffer.ignoring();
        }

        @Override
        public void write(int ch) {
            this.buffer.write(ch);
        }

        @Override
        public void write(String string) {
            this.buffer.write(string);
        }

        @Override
        public void write(CharSequence s, int i, int l) {
            this.buffer.write(s, i, l);
        }

        @Override
        public void write(char[] b, int s, int l) {
            this.buffer.write(b, s, l);
        }

        @Override
        public Consumer append(char c) {
            return this.buffer.append(c);
        }

        @Override
        public Consumer append(CharSequence csq) {
            return this.buffer.append(csq);
        }

        @Override
        public Consumer append(CharSequence csq, int start, int end) {
            return this.buffer.append(csq, start, end);
        }

        @Override
        public void writePosition(SeqPosition spos) {
            this.buffer.writePosition(spos);
        }

        @Override
        public void writePosition(AbstractSequence seq, int ipos) {
            this.buffer.writePosition(seq, ipos);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            int len = in.readInt();
            for (int i = 0; i < len; ++i) {
                this.writeObject(in.readObject());
            }
        }
    }

    public static class Values2<E, V1 extends E, V2 extends E>
    extends Values<E> {
        V1 value1;
        V2 value2;

        public Values2(V1 value1, V2 value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        public V1 getValue1() {
            return this.value1;
        }

        public V2 getValue2() {
            return this.value2;
        }

        @Override
        public Object call_with(Procedure proc) throws Throwable {
            return proc.apply2(this.value1, this.value2);
        }

        @Override
        public void check_with(Procedure proc, CallContext ctx) {
            proc.check2(this.value1, this.value2, ctx);
        }

        @Override
        public int size() {
            return 2;
        }

        @Override
        public E get(int index) {
            if (index == 0) {
                return (E)this.value1;
            }
            if (index == 1) {
                return (E)this.value2;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public Object[] getValues() {
            return new Object[]{this.value1, this.value2};
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            int len = in.readInt();
            if (len != 2) {
                throw new IOException("inconsistent readExternal");
            }
            this.value1 = in.readObject();
            this.value2 = in.readObject();
        }

        @Override
        public Object canonicalize() {
            return this;
        }
    }

    public static class FromList<E>
    extends Values<E> {
        private List<E> list;

        public FromList(List<E> list) {
            this.list = list;
        }

        @Override
        public int size() {
            return this.list.size();
        }

        @Override
        public E get(int index) {
            return this.list.get(index);
        }

        @Override
        public Object[] getValues() {
            return this.list.toArray();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            int len = in.readInt();
            ArrayList<Object> lst = new ArrayList<Object>(len);
            for (int i = 0; i < len; ++i) {
                lst.add(in.readObject());
            }
            this.list = lst;
        }
    }

    public static class FromArray<E>
    extends Values<E> {
        E[] data;

        public FromArray(E[] data) {
            this.data = data;
        }

        @Override
        public int size() {
            return this.data.length;
        }

        @Override
        public E get(int index) {
            return this.data[index];
        }

        @Override
        public Object[] getValues() {
            return this.data;
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            int len = in.readInt();
            Object[] arr = new Object[len];
            for (int i = 0; i < len; ++i) {
                arr[i] = in.readObject();
            }
            this.data = arr;
        }
    }

}

