package gnu.kawa.format;

import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import java.io.Writer;

public abstract class AbstractFormat extends java.text.Format
{
  public AbstractFormat() {}
  
  public boolean textIsCopied()
  {
    return false;
  }
  
  public boolean getReadableOutput()
  {
    return false;
  }
  
  protected void write(String str, Consumer out) {
    out.write(str);
  }
  
  public void write(int v, Consumer out)
  {
    out.write(v);
  }
  

  public void writeLong(long v, Consumer out)
  {
    out.writeLong(v);
  }
  
  public void writeInt(int i, Consumer out)
  {
    out.writeInt(i);
  }
  
  public void writeFloat(float v, Consumer out) {
    out.writeFloat(v);
  }
  
  public void writeDouble(double v, Consumer out) {
    out.writeDouble(v);
  }
  
  public void writeBoolean(boolean v, Consumer out)
  {
    out.writeBoolean(v);
  }
  
  public void startElement(Object type, Consumer out)
  {
    write("(", out);
    write(type.toString(), out);
    write(" ", out);
  }
  
  public void endElement(Consumer out)
  {
    write(")", out);
  }
  
  public void startAttribute(Object attrType, Consumer out)
  {
    write(attrType.toString(), out);
    write(": ", out);
  }
  
  public void endAttribute(Consumer out)
  {
    write(" ", out);
  }
  
  public abstract void writeObject(Object paramObject, Consumer paramConsumer);
  
  public static class FormatConsumer extends PrintConsumer {
    AbstractFormat format;
    
    public FormatConsumer(AbstractFormat format, Consumer base) {
      super(false);
      this.format = format; }
    
    public AbstractFormat getFormat() { return format; }
    
    public void write(String str) { format.write(str, base); }
    public void write(int v) { format.write(v, base); }
    public void writeInt(int v) { format.writeInt(v, base); }
    public void writeLong(long v) { format.writeLong(v, base); }
    public void writeFloat(float v) { format.writeFloat(v, base); }
    public void writeDouble(double v) { format.writeDouble(v, base); }
    public void writeObject(Object v) { format.writeObject(v, base); }
    public void writeBoolean(boolean v) { format.writeBoolean(v, base); }
    public void startElement(Object t) { format.startElement(t, base); }
    public void endElement() { format.endElement(base); }
    public void startAttribute(Object t) { format.startAttribute(t, base); }
    public void endAttribute() { format.endAttribute(base); }
    public Consumer getBase() { return base; }
  }
  
  public PrintConsumer makeConsumer(Consumer next) {
    return new FormatConsumer(this, next);
  }
  
  public void format(Object value, Consumer out)
  {
    if ((out instanceof OutPort))
    {
      OutPort pout = (OutPort)out;
      Object saveFormat = pout.pushFormat(this);
      try
      {
        out.writeObject(value);
      }
      finally
      {
        pout.popFormat(saveFormat);
      }
    }
    else {
      writeObject(value, out);
    }
  }
  
  public final void writeObject(Object obj, PrintConsumer out) {
    writeObject(obj, out);
  }
  
  public final void writeObject(Object obj, Writer out)
  {
    if ((out instanceof Consumer)) {
      writeObject(obj, (Consumer)out);
    }
    else {
      OutPort port = new OutPort(out, false, true);
      writeObject(obj, (Consumer)out);
      port.closeThis();
    }
  }
  
  public StringBuffer format(Object val, StringBuffer sbuf, java.text.FieldPosition fpos)
  {
    CharArrayOutPort out = new CharArrayOutPort();
    writeObject(val, out);
    sbuf.append(out.toCharArray());
    out.close();
    return sbuf;
  }
  
  public Object parseObject(String text, java.text.ParsePosition status)
  {
    throw new Error(getClass().getName() + ".parseObject - not implemented");
  }
}
