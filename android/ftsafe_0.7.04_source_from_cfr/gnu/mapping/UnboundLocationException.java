/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Location;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;

public class UnboundLocationException
extends RuntimeException {
    public Object symbol;
    Location location;
    String filename;
    int line;
    int column;

    public UnboundLocationException() {
    }

    public UnboundLocationException(Object symbol) {
        this.symbol = symbol;
    }

    public UnboundLocationException(Object symbol, String filename, int line, int column) {
        this.symbol = symbol;
        this.filename = filename;
        this.line = line;
        this.column = column;
    }

    public UnboundLocationException(Object symbol, SourceLocator location2) {
        this.symbol = symbol;
        if (location2 != null) {
            this.filename = location2.getFileName();
            this.line = location2.getLineNumber();
            this.column = location2.getColumnNumber();
        }
    }

    public UnboundLocationException(Location loc) {
        this.location = loc;
    }

    public UnboundLocationException(Object symbol, String message) {
        super(message);
        this.symbol = symbol;
    }

    public void setLine(String filename, int line, int column) {
        this.filename = filename;
        this.line = line;
        this.column = column;
    }

    @Override
    public String getMessage() {
        Symbol name;
        String msg = super.getMessage();
        if (msg != null) {
            return msg;
        }
        StringBuffer sbuf = new StringBuffer();
        if (this.filename != null || this.line > 0) {
            if (this.filename != null) {
                sbuf.append(this.filename);
            }
            if (this.line >= 0) {
                sbuf.append(':');
                sbuf.append(this.line);
                if (this.column > 0) {
                    sbuf.append(':');
                    sbuf.append(this.column);
                }
            }
            sbuf.append(": ");
        }
        Symbol symbol = name = this.location == null ? null : this.location.getKeySymbol();
        if (name != null) {
            sbuf.append("unbound location: ");
            sbuf.append(name);
            Object property = this.location.getKeyProperty();
            if (property != null) {
                sbuf.append(" (property ");
                sbuf.append(property);
                sbuf.append(')');
            }
        } else if (this.symbol != null) {
            sbuf.append("unbound location: ");
            sbuf.append(this.symbol);
        } else {
            sbuf.append("unbound location");
        }
        return sbuf.toString();
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}

