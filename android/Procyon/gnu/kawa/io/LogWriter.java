// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.FilterWriter;

public class LogWriter extends FilterWriter
{
    private Writer log;
    
    public LogWriter(final Writer out) {
        super(out);
    }
    
    public final Writer getLogFile() {
        return this.log;
    }
    
    public void setLogFile(final Writer log) {
        this.log = log;
    }
    
    public void setLogFile(final String name) throws IOException {
        this.log = new PrintWriter(new BufferedWriter(new FileWriter(name)));
    }
    
    public void closeLogFile() throws IOException {
        if (this.log != null) {
            this.log.close();
        }
        this.log = null;
    }
    
    @Override
    public void write(final int c) throws IOException {
        if (this.log != null) {
            this.log.write(c);
        }
        super.write(c);
    }
    
    public void echo(final char[] buf, final int off, final int len) throws IOException {
        if (this.log != null) {
            this.log.write(buf, off, len);
        }
    }
    
    @Override
    public void write(final char[] buf, final int off, final int len) throws IOException {
        if (this.log != null) {
            this.log.write(buf, off, len);
        }
        super.write(buf, off, len);
    }
    
    @Override
    public void write(final String str, final int off, final int len) throws IOException {
        if (this.log != null) {
            this.log.write(str, off, len);
        }
        super.write(str, off, len);
    }
    
    @Override
    public void flush() throws IOException {
        if (this.log != null) {
            this.log.flush();
        }
        super.flush();
    }
    
    @Override
    public void close() throws IOException {
        if (this.log != null) {
            this.log.close();
        }
        super.close();
    }
}
