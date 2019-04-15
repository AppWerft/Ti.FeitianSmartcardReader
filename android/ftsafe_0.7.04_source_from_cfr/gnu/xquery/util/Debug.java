/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.io.OutPort;
import gnu.mapping.WrappedException;
import gnu.xml.XMLPrinter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;

public class Debug {
    public static String tracePrefix = "XQuery-trace: ";
    public static OutPort tracePort = null;
    public static String traceFilename = "XQuery-trace.log";
    public static boolean traceShouldFlush = true;
    public static boolean traceShouldAppend = false;

    public static synchronized Object trace(Object value, Object message) {
        OutPort out = tracePort;
        if (out == null) {
            try {
                out = new OutPort(new FileOutputStream(traceFilename, traceShouldAppend));
            }
            catch (Exception ex) {
                throw new WrappedException("Could not open '" + traceFilename + "' for fn:trace output", ex);
            }
            tracePort = out;
        }
        out.print(tracePrefix);
        out.print(message);
        out.print(' ');
        XMLPrinter xout = new XMLPrinter(out, false);
        xout.writeObject(value);
        out.println();
        if (traceShouldFlush) {
            out.flush();
        }
        return value;
    }
}

