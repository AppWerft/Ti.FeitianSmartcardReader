// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import java.text.ParsePosition;
import gnu.kawa.io.CharArrayOutPort;
import java.text.FieldPosition;
import java.io.Writer;
import gnu.kawa.io.OutPort;
import gnu.lists.PrintConsumer;
import gnu.lists.Consumer;
import java.text.Format;

public abstract class AbstractFormat extends Format
{
    public boolean textIsCopied() {
        return false;
    }
    
    public boolean getReadableOutput() {
        return false;
    }
    
    protected void write(final String str, final Consumer out) {
        out.write(str);
    }
    
    public void write(final int v, final Consumer out) {
        out.write(v);
    }
    
    public void writeLong(final long v, final Consumer out) {
        out.writeLong(v);
    }
    
    public void writeInt(final int i, final Consumer out) {
        out.writeInt(i);
    }
    
    public void writeFloat(final float v, final Consumer out) {
        out.writeFloat(v);
    }
    
    public void writeDouble(final double v, final Consumer out) {
        out.writeDouble(v);
    }
    
    public void writeBoolean(final boolean v, final Consumer out) {
        out.writeBoolean(v);
    }
    
    public void startElement(final Object type, final Consumer out) {
        this.write("(", out);
        this.write(type.toString(), out);
        this.write(" ", out);
    }
    
    public void endElement(final Consumer out) {
        this.write(")", out);
    }
    
    public void startAttribute(final Object attrType, final Consumer out) {
        this.write(attrType.toString(), out);
        this.write(": ", out);
    }
    
    public void endAttribute(final Consumer out) {
        this.write(" ", out);
    }
    
    public abstract void writeObject(final Object p0, final Consumer p1);
    
    public PrintConsumer makeConsumer(final Consumer next) {
        return new FormatConsumer(this, next);
    }
    
    public void format(final Object value, final Consumer out) {
        if (out instanceof OutPort) {
            final OutPort pout = (OutPort)out;
            final Object saveFormat = pout.pushFormat(this);
            try {
                out.writeObject(value);
            }
            finally {
                pout.popFormat(saveFormat);
            }
        }
        else {
            this.writeObject(value, out);
        }
    }
    
    public final void writeObject(final Object obj, final PrintConsumer out) {
        this.writeObject(obj, (Consumer)out);
    }
    
    public final void writeObject(final Object obj, final Writer out) {
        if (out instanceof Consumer) {
            this.writeObject(obj, (Consumer)out);
        }
        else {
            final OutPort port = new OutPort(out, false, true);
            this.writeObject(obj, (Consumer)out);
            port.closeThis();
        }
    }
    
    @Override
    public StringBuffer format(final Object val, final StringBuffer sbuf, final FieldPosition fpos) {
        final CharArrayOutPort out = new CharArrayOutPort();
        this.writeObject(val, out);
        sbuf.append(out.toCharArray());
        out.close();
        return sbuf;
    }
    
    @Override
    public Object parseObject(final String text, final ParsePosition status) {
        throw new Error(this.getClass().getName() + ".parseObject - not implemented");
    }
    
    public static class FormatConsumer extends PrintConsumer
    {
        AbstractFormat format;
        
        public FormatConsumer(final AbstractFormat format, final Consumer base) {
            super(base, false);
            this.format = format;
        }
        
        public AbstractFormat getFormat() {
            return this.format;
        }
        
        @Override
        public void write(final String str) {
            this.format.write(str, this.base);
        }
        
        @Override
        public void write(final int v) {
            this.format.write(v, this.base);
        }
        
        @Override
        public void writeInt(final int v) {
            this.format.writeInt(v, this.base);
        }
        
        @Override
        public void writeLong(final long v) {
            this.format.writeLong(v, this.base);
        }
        
        @Override
        public void writeFloat(final float v) {
            this.format.writeFloat(v, this.base);
        }
        
        @Override
        public void writeDouble(final double v) {
            this.format.writeDouble(v, this.base);
        }
        
        @Override
        public void writeObject(final Object v) {
            this.format.writeObject(v, this.base);
        }
        
        @Override
        public void writeBoolean(final boolean v) {
            this.format.writeBoolean(v, this.base);
        }
        
        @Override
        public void startElement(final Object t) {
            this.format.startElement(t, this.base);
        }
        
        @Override
        public void endElement() {
            this.format.endElement(this.base);
        }
        
        @Override
        public void startAttribute(final Object t) {
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
