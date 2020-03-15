// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import java.io.Writer;
import gnu.xml.XMLPrinter;
import gnu.mapping.WrappedException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import gnu.kawa.io.OutPort;

public class Debug
{
    public static String tracePrefix;
    public static OutPort tracePort;
    public static String traceFilename;
    public static boolean traceShouldFlush;
    public static boolean traceShouldAppend;
    
    public static synchronized Object trace(final Object value, final Object message) {
        OutPort out = Debug.tracePort;
        if (out == null) {
            try {
                out = new OutPort(new FileOutputStream(Debug.traceFilename, Debug.traceShouldAppend));
            }
            catch (Exception ex) {
                throw new WrappedException("Could not open '" + Debug.traceFilename + "' for fn:trace output", ex);
            }
            Debug.tracePort = out;
        }
        out.print(Debug.tracePrefix);
        out.print(message);
        out.print(' ');
        final XMLPrinter xout = new XMLPrinter((Writer)out, false);
        xout.writeObject(value);
        out.println();
        if (Debug.traceShouldFlush) {
            out.flush();
        }
        return value;
    }
    
    static {
        Debug.tracePrefix = "XQuery-trace: ";
        Debug.tracePort = null;
        Debug.traceFilename = "XQuery-trace.log";
        Debug.traceShouldFlush = true;
        Debug.traceShouldAppend = false;
    }
}
