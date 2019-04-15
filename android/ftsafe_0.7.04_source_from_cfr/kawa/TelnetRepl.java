/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.expr.Language;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TtyInPort;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure0;
import gnu.mapping.RunnableClosure;
import gnu.mapping.Values;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kawa.Shell;
import kawa.Telnet;
import kawa.TelnetInputStream;
import kawa.TelnetOutputStream;

public class TelnetRepl
extends Procedure0 {
    Socket socket;
    Language language;

    public TelnetRepl(Language language, Socket socket) {
        this.language = language;
        this.socket = socket;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object apply0() {
        try {
            Shell.run(this.language, Environment.getCurrent());
            Values values = Values.empty;
            return values;
        }
        finally {
            try {
                this.socket.close();
            }
            catch (IOException ex) {}
        }
    }

    public static Thread serve(Language language, Socket client) throws IOException {
        Telnet conn = new Telnet(client, true);
        TelnetOutputStream sout = conn.getOutputStream();
        TelnetInputStream sin = conn.getInputStream();
        OutPort out = new OutPort(sout, (Path)FilePath.valueOf("/dev/stdout"));
        TtyInPort in = new TtyInPort(sin, (Path)FilePath.valueOf("/dev/stdin"), out);
        RunnableClosure r = new RunnableClosure(new TelnetRepl(language, client), in, out, out);
        Thread thread2 = new Thread(r);
        thread2.start();
        return thread2;
    }
}

