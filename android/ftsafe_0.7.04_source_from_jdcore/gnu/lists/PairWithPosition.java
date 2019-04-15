package gnu.lists;

import gnu.text.SourceLocator;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PairWithPosition
  extends ImmutablePair
  implements SourceLocator
{
  String filename;
  int position;
  
  public final void setFile(String filename)
  {
    this.filename = filename;
  }
  
  public final void setLine(int lineno, int colno)
  {
    if (lineno < 0)
      lineno = 0;
    if (colno < 0)
      colno = 0;
    position = ((lineno << 12) + colno);
  }
  
  public final void setLine(int lineno)
  {
    setLine(lineno, 0);
  }
  
  public final String getFileName()
  {
    return filename;
  }
  
  public String getPublicId()
  {
    return null;
  }
  
  public String getSystemId()
  {
    return filename;
  }
  


  public final int getLineNumber()
  {
    int line = position >> 12;
    return line == 0 ? -1 : line;
  }
  
  public final int getColumnNumber()
  {
    int column = position & 0xFFF;
    return column == 0 ? -1 : column;
  }
  
  public boolean isStableSourceLocation() { return true; }
  


  public PairWithPosition() {}
  


  public PairWithPosition(SourceLocator where, Object car, Object cdr)
  {
    super(car, cdr);
    filename = where.getFileName();
    setLine(where.getLineNumber(), where.getColumnNumber());
  }
  
  public PairWithPosition(Object car, Object cdr)
  {
    super(car, cdr);
  }
  

  public static PairWithPosition make(Object car, Object cdr, String filename, int line, int column)
  {
    PairWithPosition pair = new PairWithPosition(car, cdr);
    filename = filename;
    pair.setLine(line, column);
    return pair;
  }
  

  public static PairWithPosition make(Object car, Object cdr, String filename, int position)
  {
    PairWithPosition pair = new PairWithPosition(car, cdr);
    filename = filename;
    position = position;
    return pair;
  }
  

  public void init(Object car, Object cdr, String filename, int position)
  {
    this.car = car;
    this.cdr = cdr;
    this.filename = filename;
    this.position = position;
  }
  




  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(car);
    out.writeObject(cdr);
    out.writeObject(filename);
    out.writeInt(position);
  }
  
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
  {
    Object car = in.readObject();
    Object cdr = in.readObject();
    String filename = (String)in.readObject();
    int position = in.readInt();
    init(car, cdr, filename, position);
  }
}
