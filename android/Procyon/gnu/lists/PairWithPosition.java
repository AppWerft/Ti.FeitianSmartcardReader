// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.text.SourceLocator;

public class PairWithPosition extends ImmutablePair implements SourceLocator
{
    String filename;
    int position;
    
    public final void setFile(final String filename) {
        this.filename = filename;
    }
    
    public final void setLine(int lineno, int colno) {
        if (lineno < 0) {
            lineno = 0;
        }
        if (colno < 0) {
            colno = 0;
        }
        this.position = (lineno << 12) + colno;
    }
    
    public final void setLine(final int lineno) {
        this.setLine(lineno, 0);
    }
    
    @Override
    public final String getFileName() {
        return this.filename;
    }
    
    @Override
    public String getPublicId() {
        return null;
    }
    
    @Override
    public String getSystemId() {
        return this.filename;
    }
    
    @Override
    public final int getLineNumber() {
        final int line = this.position >> 12;
        return (line == 0) ? -1 : line;
    }
    
    @Override
    public final int getColumnNumber() {
        final int column = this.position & 0xFFF;
        return (column == 0) ? -1 : column;
    }
    
    @Override
    public boolean isStableSourceLocation() {
        return true;
    }
    
    public PairWithPosition() {
    }
    
    public PairWithPosition(final SourceLocator where, final Object car, final Object cdr) {
        super(car, cdr);
        this.filename = where.getFileName();
        this.setLine(where.getLineNumber(), where.getColumnNumber());
    }
    
    public PairWithPosition(final Object car, final Object cdr) {
        super(car, cdr);
    }
    
    public static PairWithPosition make(final Object car, final Object cdr, final String filename, final int line, final int column) {
        final PairWithPosition pair = new PairWithPosition(car, cdr);
        pair.filename = filename;
        pair.setLine(line, column);
        return pair;
    }
    
    public static PairWithPosition make(final Object car, final Object cdr, final String filename, final int position) {
        final PairWithPosition pair = new PairWithPosition(car, cdr);
        pair.filename = filename;
        pair.position = position;
        return pair;
    }
    
    public void init(final Object car, final Object cdr, final String filename, final int position) {
        this.car = car;
        this.cdr = cdr;
        this.filename = filename;
        this.position = position;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.car);
        out.writeObject(this.cdr);
        out.writeObject(this.filename);
        out.writeInt(this.position);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        final Object car = in.readObject();
        final Object cdr = in.readObject();
        final String filename = (String)in.readObject();
        final int position = in.readInt();
        this.init(car, cdr, filename, position);
    }
}
