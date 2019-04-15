/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public abstract class AbstractFormat
extends Format {
    public boolean textIsCopied() {
        return false;
    }

    public boolean getReadableOutput() {
        return false;
    }

    protected void write(String str, Consumer out) {
        out.write(str);
    }

    public void write(int v, Consumer out) {
        out.write(v);
    }

    public void writeLong(long v, Consumer out) {
        out.writeLong(v);
    }

    public void writeInt(int i, Consumer out) {
        out.writeInt(i);
    }

    public void writeFloat(float v, Consumer out) {
        out.writeFloat(v);
    }

    public void writeDouble(double v, Consumer out) {
        out.writeDouble(v);
    }

    public void writeBoolean(boolean v, Consumer out) {
        out.writeBoolean(v);
    }

    public void startElement(Object type, Consumer out) {
        this.write("(", out);
        this.write(type.toString(), out);
        this.write(" ", out);
    }

    public void endElement(Consumer out) {
        this.write(")", out);
    }

    public void startAttribute(Object attrType, Consumer out) {
        this.write(attrType.toString(), out);
        this.write(": ", out);
    }

    public void endAttribute(Consumer out) {
        this.write(" ", out);
    }

    public abstract void writeObject(Object var1, Consumer var2);

    public PrintConsumer makeConsumer(Consumer next) {
        return new FormatConsumer(this, next);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void format(Object value, Consumer out) {
        if (out instanceof OutPort) {
            OutPort pout = (OutPort)out;
            Object saveFormat = pout.pushFormat(this);
            try {
                out.writeObject(value);
            }
            finally {
                pout.popFormat(saveFormat);
            }
        } else {
            this.writeObject(value, out);
        }
    }

    public final void writeObject(Object obj, PrintConsumer out) {
        this.writeObject(obj, (Consumer)out);
    }

    public final void writeObject(Object obj, Writer out) {
        if (out instanceof Consumer) {
            this.writeObject(obj, (Consumer)((Object)out));
        } else {
            OutPort port = new OutPort(out, false, true);
            this.writeObject(obj, (Consumer)((Object)out));
            port.closeThis();
        }
    }

    @Override
    public StringBuffer format(Object val, StringBuffer sbuf, FieldPosition fpos) {
        CharArrayOutPort out = new CharArrayOutPort();
        this.writeObject(val, out);
        sbuf.append(out.toCharArray());
        out.close();
        return sbuf;
    }

    @Override
    public Object parseObject(String text, ParsePosition status) {
        throw new Error(this.getClass().getName() + ".parseObject - not implemented");
    }

    public static class FormatConsumer
    extends PrintConsumer {
        AbstractFormat format;

        public FormatConsumer(AbstractFormat format, Consumer base2) {
            super(base2, false);
            this.format = format;
        }

        public AbstractFormat getFormat() {
            return this.format;
        }

        @Override
        public void write(String str) {
            this.format.write(str, this.base);
        }

        @Override
        public void write(int v) {
            this.format.write(v, this.base);
        }

        @Override
        public void writeInt(int v) {
            this.format.writeInt(v, this.base);
        }

        @Override
        public void writeLong(long v) {
            this.format.writeLong(v, this.base);
        }

        @Override
        public void writeFloat(float v) {
            this.format.writeFloat(v, this.base);
        }

        @Override
        public void writeDouble(double v) {
            this.format.writeDouble(v, this.base);
        }

        @Override
        public void writeObject(Object v) {
            this.format.writeObject(v, this.base);
        }

        @Override
        public void writeBoolean(boolean v) {
            this.format.writeBoolean(v, this.base);
        }

        @Override
        public void startElement(Object t) {
            this.format.startElement(t, this.base);
        }

        @Override
        public void endElement() {
            this.format.endElement(this.base);
        }

        @Override
        public void startAttribute(Object t) {
            this.format.startAttribute(t, this.base);
        }

        @Override
        public void endAttribute() {
            this.format.endAttribute(this.base);
        }

        public Consumer getBase() {
            return this.base;
        }
    }

}

