// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import java.io.InputStream;
import java.io.OutputStream;
import gnu.kawa.io.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.RunnableClosure;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.FilePath;
import java.io.IOException;
import gnu.mapping.Values;
import gnu.mapping.Environment;
import gnu.expr.Language;
import java.net.Socket;
import gnu.mapping.Procedure0;

public class TelnetRepl extends Procedure0
{
    Socket socket;
    Language language;
    
    public TelnetRepl(final Language language, final Socket socket) {
        this.language = language;
        this.socket = socket;
    }
    
    @Override
    public Object apply0() {
        try {
            Shell.run(this.language, Environment.getCurrent());
            return Values.empty;
        }
        finally {
            try {
                this.socket.close();
            }
            catch (IOException ex) {}
        }
    }
    
    public static Thread serve(final Language language, final Socket client) throws IOException {
        final Telnet conn = new Telnet(client, true);
        final OutputStream sout = conn.getOutputStream();
        final InputStream sin = conn.getInputStream();
        final OutPort out = new OutPort(sout, FilePath.valueOf("/dev/stdout"));
        final TtyInPort in = new TtyInPort(sin, FilePath.valueOf("/dev/stdin"), out);
        final Runnable r = new RunnableClosure<Object>(new TelnetRepl(language, client), in, out, out);
        final Thread thread = new Thread(r);
        thread.start();
        return thread;
    }
}
