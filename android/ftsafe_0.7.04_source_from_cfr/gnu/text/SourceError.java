/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import gnu.kawa.io.InPort;
import gnu.text.SourceLocator;
import java.io.File;
import java.io.IOException;

public class SourceError
implements SourceLocator {
    public SourceError next;
    public char severity;
    public String filename;
    public String code;
    public int line;
    public int column;
    public String message;
    public Throwable fakeException;

    public SourceError(char severity, String filename, int line, int column, String message) {
        this.severity = severity;
        this.filename = filename;
        this.line = line;
        this.column = column;
        this.message = message;
    }

    public SourceError(char severity, SourceLocator location2, String message) {
        this(severity, location2.getFileName(), location2.getLineNumber(), location2.getColumnNumber(), message);
    }

    public SourceError(InPort port, char severity, String message) {
        this(severity, port.getName(), port.getLineNumber() + 1, port.getColumnNumber(), message);
        if (this.column >= 0) {
            ++this.column;
        }
    }

    public String toString() {
        return this.toString(false);
    }

    public String toString(boolean stripDirectories) {
        StringBuilder buffer = new StringBuilder();
        this.appendTo(buffer, stripDirectories, null);
        return buffer.toString();
    }

    public void appendTo(Appendable out, boolean stripDirectories, String newLine) {
        try {
            String fname;
            if (this.filename == null) {
                fname = "<unknown>";
            } else {
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
            } else if (this.severity == 'i') {
                out.append("note - ");
            }
            out.append(this.message);
            if (this.code != null) {
                out.append(" [");
                out.append(this.code);
                out.append("]");
            }
            if (this.fakeException != null) {
                StackTraceElement[] stackTrace = this.fakeException.getStackTrace();
                for (int i = 0; i < stackTrace.length; ++i) {
                    out.append(newLine != null ? newLine : "\n");
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

    public void print(Appendable out) {
        this.appendTo(out, false, null);
    }

    public void println(Appendable out, boolean stripDirectories) {
        this.appendTo(out, stripDirectories, System.getProperty("line.separator", "\n"));
    }

    @Override
    public int getLineNumber() {
        return this.line == 0 ? -1 : this.line;
    }

    @Override
    public int getColumnNumber() {
        return this.column == 0 ? -1 : this.column;
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

