// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import java.io.IOException;
import java.io.File;
import gnu.kawa.io.InPort;

public class SourceError implements SourceLocator
{
    public SourceError next;
    public char severity;
    public String filename;
    public String code;
    public int line;
    public int column;
    public String message;
    public Throwable fakeException;
    
    public SourceError(final char severity, final String filename, final int line, final int column, final String message) {
        this.severity = severity;
        this.filename = filename;
        this.line = line;
        this.column = column;
        this.message = message;
    }
    
    public SourceError(final char severity, final SourceLocator location, final String message) {
        this(severity, location.getFileName(), location.getLineNumber(), location.getColumnNumber(), message);
    }
    
    public SourceError(final InPort port, final char severity, final String message) {
        this(severity, port.getName(), port.getLineNumber() + 1, port.getColumnNumber(), message);
        if (this.column >= 0) {
            ++this.column;
        }
    }
    
    @Override
    public String toString() {
        return this.toString(false);
    }
    
    public String toString(final boolean stripDirectories) {
        final StringBuilder buffer = new StringBuilder();
        this.appendTo(buffer, stripDirectories, null);
        return buffer.toString();
    }
    
    public void appendTo(final Appendable out, final boolean stripDirectories, final String newLine) {
        try {
            String fname;
            if (this.filename == null) {
                fname = "<unknown>";
            }
            else {
                fname = this.filename;
                if (stripDirectories) {
                    fname = new File(fname).getName();
                }
            }
            out.append(fname);
            if (this.line > 0 || this.column > 0) {
                out.append(':');
                out.append(Integer.toString(this.line));
                if (this.column > 0) {
                    out.append(':');
                    out.append(Integer.toString(this.column));
                }
            }
            out.append(": ");
            if (this.severity == 'w') {
                out.append("warning - ");
            }
            else if (this.severity == 'i') {
                out.append("note - ");
            }
            out.append(this.message);
            if (this.code != null) {
                out.append(" [");
                out.append(this.code);
                out.append("]");
            }
            if (this.fakeException != null) {
                final StackTraceElement[] stackTrace = this.fakeException.getStackTrace();
                for (int i = 0; i < stackTrace.length; ++i) {
                    out.append((newLine != null) ? newLine : "\n");
                    out.append("    ");
                    out.append(stackTrace[i].toString());
                }
            }
            if (newLine != null) {
                out.append(newLine);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void print(final Appendable out) {
        this.appendTo(out, false, null);
    }
    
    public void println(final Appendable out, final boolean stripDirectories) {
        this.appendTo(out, stripDirectories, System.getProperty("line.separator", "\n"));
    }
    
    @Override
    public int getLineNumber() {
        return (this.line == 0) ? -1 : this.line;
    }
    
    @Override
    public int getColumnNumber() {
        return (this.column == 0) ? -1 : this.column;
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
    public String getFileName() {
        return this.filename;
    }
    
    @Override
    public boolean isStableSourceLocation() {
        return true;
    }
}
