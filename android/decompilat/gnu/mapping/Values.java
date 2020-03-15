// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.lists.SeqPosition;
import gnu.lists.TreePosition;
import gnu.lists.ItemPredicate;
import gnu.lists.PositionConsumer;
import java.util.ArrayList;
import java.io.ObjectInput;
import java.io.ObjectStreamException;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import java.util.List;
import java.io.Externalizable;
import gnu.lists.Consumable;
import gnu.lists.AbstractSequence;

public abstract class Values<E> extends AbstractSequence<E> implements Consumable, Externalizable
{
    public static final Object[] noArgs;
    public static final Values empty;
    
    protected Values() {
    }
    
    public Object[] getValues() {
        final int sz = this.size();
        final Object[] arr = new Object[sz];
        int it = 0;
        int i = 0;
        while ((it = this.nextPos(it)) != 0) {
            arr[i++] = this.getPosPrevious(it);
        }
        return arr;
    }
    
    public static Object values(final Object... vals) {
        return make(vals);
    }
    
    public static <E, V1 extends E, V2 extends E> Values2<E, V1, V2> values2(final V1 val1, final V2 val2) {
        return new Values2<E, V1, V2>(val1, val2);
    }
    
    public static Values make() {
        return new FromTreeList();
    }
    
    public static <E> Object make(final E[] vals) {
        if (vals.length == 1) {
            return vals[0];
        }
        if (vals.length == 0) {
            return Values.empty;
        }
        return new FromArray(vals);
    }
    
    public static <E> Values<E> makeFromArray(final E... vals) {
        return new FromArray<E>(vals);
    }
    
    public static <E> Object make(final List<E> seq) {
        final int count = (seq == null) ? 0 : seq.size();
        if (count == 0) {
            return Values.empty;
        }
        if (count == 1) {
            return seq.get(0);
        }
        return new FromList((List<Object>)seq);
    }
    
    public static Object make(final TreeList list, final int startPosition, final int endPosition) {
        final int next;
        if (startPosition == endPosition || (next = list.nextDataIndex(startPosition)) <= 0) {
            return Values.empty;
        }
        if (next == endPosition || list.nextDataIndex(next) < 0) {
            return list.getPosNext(startPosition << 1);
        }
        final FromTreeList vals = new FromTreeList();
        list.consumeIRange(startPosition, endPosition, vals.buffer);
        return vals;
    }
    
    public Object canonicalize() {
        final int sz = this.size();
        if (sz == 0) {
            return Values.empty;
        }
        if (sz == 1) {
            return this.get(0);
        }
        return this;
    }
    
    public Object call_with(final Procedure proc) throws Throwable {
        return proc.applyN(this.getValues());
    }
    
    public void check_with(final Procedure proc, final CallContext ctx) {
        proc.checkN(this.getValues(), ctx);
    }
    
    public void print(final Consumer out) {
        if (this == Values.empty) {
            out.write("#!void");
            return;
        }
        final boolean readable = true;
        if (readable) {
            out.write("#<values");
        }
        int it = 0;
        while ((it = this.nextPos(it)) != 0) {
            out.write(32);
            final Object val = this.getPosPrevious(it);
            if (val instanceof Printable) {
                ((Printable)val).print(out);
            }
            else {
                out.writeObject(val);
            }
        }
        if (readable) {
            out.write(62);
        }
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeInt(this.size());
        int it = 0;
        final int i = 0;
        while ((it = this.nextPos(it)) != 0) {
            out.writeObject(this.getPosPrevious(it));
        }
    }
    
    public Object readResolve() throws ObjectStreamException {
        return this.canonicalize();
    }
    
    public static int incrPos(final Object values, final int pos) {
        if (values instanceof Values) {
            return ((Values)values).nextPos(pos);
        }
        return 1 - pos;
    }
    
    public static Object getFromPos(final Object values, final int pos) {
        if (pos == 0) {
            throw new IndexOutOfBoundsException("not enough values");
        }
        if (values instanceof Values) {
            return ((Values)values).getPosPrevious(pos);
        }
        return values;
    }
    
    public static Object getFromPosFinal(final Object values, final int pos) {
        final Object r = getFromPos(values, pos);
        checkFinalPos(values, pos);
        return r;
    }
    
    public static void checkFinalPos(final Object values, final int pos) {
        if (incrPos(values, pos) != 0) {
            throw new IndexOutOfBoundsException("too many values");
        }
    }
    
    public static int nextIndex(final Object values, int curIndex) {
        if (values instanceof Values) {
            if (curIndex == Integer.MAX_VALUE) {
                curIndex = -1;
            }
            final int next = ((Values)values).nextPos(curIndex);
            return (next == 0) ? -1 : ((next == -1) ? Integer.MAX_VALUE : next);
        }
        return (curIndex == 0) ? 1 : -1;
    }
    
    public static Object nextValue(final Object values, int curIndex) {
        if (values instanceof Values) {
            if (curIndex == Integer.MAX_VALUE) {
                curIndex = -1;
            }
            return ((Values)values).getPosNext(curIndex);
        }
        return values;
    }
    
    @Override
    protected int nextIndex(final int ipos) {
        if (ipos == -1) {
            return this.size();
        }
        return ipos >>> 1;
    }
    
    public static void writeValues(final Object value, final Consumer out) {
        if (value instanceof Values) {
            ((Values)value).consume(out);
        }
        else {
            out.writeObject(value);
        }
    }
    
    public static int countValues(final Object value) {
        return (value instanceof Values) ? ((Values)value).size() : 1;
    }
    
    static {
        noArgs = new Object[0];
        empty = new FromArray(Values.noArgs);
    }
    
    public static class FromArray<E> extends Values<E>
    {
        E[] data;
        
        public FromArray(final E[] data) {
            this.data = data;
        }
        
        @Override
        public int size() {
            return this.data.length;
        }
        
        @Override
        public E get(final int index) {
            return this.data[index];
        }
        
        @Override
        public Object[] getValues() {
            return this.data;
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            final int len = in.readInt();
            final E[] arr = (E[])new Object[len];
            for (int i = 0; i < len; ++i) {
                arr[i] = (E)in.readObject();
            }
            this.data = arr;
        }
    }
    
    public static class FromList<E> extends Values<E>
    {
        private List<E> list;
        
        public FromList(final List<E> list) {
            this.list = list;
        }
        
        @Override
        public int size() {
            return this.list.size();
        }
        
        @Override
        public E get(final int index) {
            return this.list.get(index);
        }
        
        @Override
        public Object[] getValues() {
            return this.list.toArray();
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            final int len = in.readInt();
            final ArrayList<E> lst = new ArrayList<E>(len);
            for (int i = 0; i < len; ++i) {
                lst.add((E)in.readObject());
            }
            this.list = lst;
        }
    }
    
    public static class Values2<E, V1 extends E, V2 extends E> extends Values<E>
    {
        V1 value1;
        V2 value2;
        
        public Values2(final V1 value1, final V2 value2) {
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
        public Object call_with(final Procedure proc) throws Throwable {
            return proc.apply2(this.value1, this.value2);
        }
        
        @Override
        public void check_with(final Procedure proc, final CallContext ctx) {
            proc.check2(this.value1, this.value2, ctx);
        }
        
        @Override
        public int size() {
            return 2;
        }
        
        @Override
        public E get(final int index) {
            if (index == 0) {
                return this.value1;
            }
            if (index == 1) {
                return this.value2;
            }
            throw new IndexOutOfBoundsException();
        }
        
        @Override
        public Object[] getValues() {
            return new Object[] { this.value1, this.value2 };
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            final int len = in.readInt();
            if (len != 2) {
                throw new IOException("inconsistent readExternal");
            }
            this.value1 = (V1)in.readObject();
            this.value2 = (V2)in.readObject();
        }
        
        @Override
        public Object canonicalize() {
            return this;
        }
    }
    
    public static class FromTreeList extends Values<Object> implements Printable, Consumer, PositionConsumer
    {
        protected final TreeList buffer;
        
        public FromTreeList(final Object[] values) {
            this();
            for (int i = 0; i < values.length; ++i) {
                this.buffer.writeObject(values[i]);
            }
        }
        
        public FromTreeList() {
            this.buffer = new TreeList();
        }
        
        public FromTreeList(final TreeList list) {
            this.buffer = list;
        }
        
        @Override
        public int size() {
            return this.buffer.size();
        }
        
        @Override
        public Object get(final int index) {
            return this.buffer.get(index);
        }
        
        @Override
        public int createPos(final int index, final boolean isAfter) {
            return this.buffer.createPos(index, isAfter);
        }
        
        @Override
        public Object canonicalize() {
            if (this.buffer.gapEnd == this.buffer.data.length) {
                if (this.buffer.gapStart == 0) {
                    return FromTreeList.empty;
                }
                if (this.buffer.nextDataIndex(0) == this.buffer.gapStart) {
                    return this.buffer.getPosNext(0);
                }
            }
            return this;
        }
        
        @Override
        public Object[] getValues() {
            return this.buffer.isEmpty() ? FromTreeList.noArgs : this.buffer.toArray();
        }
        
        @Override
        public int nextMatching(final int startPos, final ItemPredicate type, final int endPos, final boolean descend) {
            return this.buffer.nextMatching(startPos, type, endPos, descend);
        }
        
        @Override
        public void clear() {
            this.buffer.clear();
        }
        
        @Override
        public int createRelativePos(final int pos, final int delta, final boolean isAfter) {
            return this.buffer.createRelativePos(pos, delta, isAfter);
        }
        
        @Override
        protected int nextIndex(final int ipos) {
            return this.buffer.nextIndex(ipos);
        }
        
        @Override
        public boolean hasNext(final int ipos) {
            return this.buffer.hasNext(ipos);
        }
        
        @Override
        public int getNextKind(final int ipos) {
            return this.buffer.getNextKind(ipos);
        }
        
        @Override
        public Object getNextTypeObject(final int ipos) {
            return this.buffer.getNextTypeObject(ipos);
        }
        
        @Override
        public int nextPos(final int ipos) {
            return this.buffer.nextPos(ipos);
        }
        
        @Override
        public int firstChildPos(final int ipos) {
            return this.buffer.firstChildPos(ipos);
        }
        
        @Override
        public int firstAttributePos(final int ipos) {
            return this.buffer.firstAttributePos(ipos);
        }
        
        @Override
        public int parentPos(final int ipos) {
            return this.buffer.parentPos(ipos);
        }
        
        public boolean gotoAttributesStart(final TreePosition pos) {
            return this.buffer.gotoAttributesStart(pos);
        }
        
        @Override
        public Object getPosNext(final int ipos) {
            return this.buffer.getPosNext(ipos);
        }
        
        @Override
        public Object getPosPrevious(final int ipos) {
            return this.buffer.getPosPrevious(ipos);
        }
        
        @Override
        public int compare(final int ipos1, final int ipos2) {
            return this.buffer.compare(ipos1, ipos2);
        }
        
        @Override
        public int hashCode() {
            return this.buffer.hashCode();
        }
        
        @Override
        public boolean consumeNext(final int ipos, final Consumer out) {
            return this.buffer.consumeNext(ipos, out);
        }
        
        @Override
        public void consumePosRange(final int startPos, final int endPos, final Consumer out) {
            this.buffer.consumePosRange(startPos, endPos, out);
        }
        
        @Override
        public void consume(final Consumer out) {
            this.buffer.consume(out);
        }
        
        @Override
        public void toString(final String sep, final StringBuffer sbuf) {
            this.buffer.toString(sep, sbuf);
        }
        
        @Override
        public void writeBoolean(final boolean v) {
            this.buffer.writeBoolean(v);
        }
        
        @Override
        public void writeFloat(final float v) {
            this.buffer.writeFloat(v);
        }
        
        @Override
        public void writeDouble(final double v) {
            this.buffer.writeDouble(v);
        }
        
        @Override
        public void writeInt(final int v) {
            this.buffer.writeInt(v);
        }
        
        @Override
        public void writeLong(final long v) {
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
        public void startElement(final Object type) {
            this.buffer.startElement(type);
        }
        
        @Override
        public void endElement() {
            this.buffer.endElement();
        }
        
        @Override
        public void startAttribute(final Object t) {
            this.buffer.startAttribute(t);
        }
        
        @Override
        public void endAttribute() {
            this.buffer.endAttribute();
        }
        
        @Override
        public void writeObject(final Object v) {
            this.buffer.writeObject(v);
        }
        
        @Override
        public boolean ignoring() {
            return this.buffer.ignoring();
        }
        
        @Override
        public void write(final int ch) {
            this.buffer.write(ch);
        }
        
        @Override
        public void write(final String string) {
            this.buffer.write(string);
        }
        
        @Override
        public void write(final CharSequence s, final int i, final int l) {
            this.buffer.write(s, i, l);
        }
        
        @Override
        public void write(final char[] b, final int s, final int l) {
            this.buffer.write(b, s, l);
        }
        
        @Override
        public Consumer append(final char c) {
            return this.buffer.append(c);
        }
        
        @Override
        public Consumer append(final CharSequence csq) {
            return this.buffer.append(csq);
        }
        
        @Override
        public Consumer append(final CharSequence csq, final int start, final int end) {
            return this.buffer.append(csq, start, end);
        }
        
        @Override
        public void writePosition(final SeqPosition spos) {
            this.buffer.writePosition(spos);
        }
        
        @Override
        public void writePosition(final AbstractSequence seq, final int ipos) {
            this.buffer.writePosition(seq, ipos);
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            for (int len = in.readInt(), i = 0; i < len; ++i) {
                this.writeObject(in.readObject());
            }
        }
    }
}
