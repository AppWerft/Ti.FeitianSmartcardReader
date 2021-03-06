/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.ImmutablePair;
import gnu.text.SourceLocator;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PairWithPosition
extends ImmutablePair
implements SourceLocator {
    String filename;
    int position;

    public final void setFile(String filename) {
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

    public final void setLine(int lineno) {
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
        int line = this.position >> 12;
        return line == 0 ? -1 : line;
    }

    @Override
    public final int getColumnNumber() {
        int column = this.position & 4095;
        return column == 0 ? -1 : column;
    }

    @Override
    public boolean isStableSourceLocation() {
        return true;
    }

    public PairWithPosition() {
    }

    public PairWithPosition(SourceLocator where, Object car, Object cdr) {
        super(car, cdr);
        this.filename = where.getFileName();
        this.setLine(where.getLineNumber(), where.getColumnNumber());
    }

    public PairWithPosition(Object car, Object cdr) {
        super(car, cdr);
    }

    public static PairWithPosition make(Object car, Object cdr, String filename, int line, int column) {
        PairWithPosition pair = new PairWithPosition(car, cdr);
        pair.filename = filename;
        pair.setLine(line, column);
        return pair;
    }

    public static PairWithPosition make(Object car, Object cdr, String filename, int position) {
        PairWithPosition pair = new PairWithPosition(car, cdr);
        pair.filename = filename;
        pair.position = position;
        return pair;
    }

    public void init(Object car, Object cdr, String filename, int position) {
        this.car = car;
        this.cdr = cdr;
        this.filename = filename;
        this.position = position;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.car);
        out.writeObject(this.cdr);
        out.writeObject(this.filename);
        out.writeInt(this.position);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Object car = in.readObject();
        Object cdr = in.readObject();
        String filename = (String)in.readObject();
        int position = in.readInt();
        this.init(car, cdr, filename, position);
    }
}

