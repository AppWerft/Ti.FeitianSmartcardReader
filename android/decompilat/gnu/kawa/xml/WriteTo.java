// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.io.InputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import java.io.Writer;
import gnu.xml.XMLPrinter;
import gnu.kawa.io.OutPort;
import java.io.OutputStream;
import gnu.kawa.io.Path;
import gnu.mapping.Procedure2;

public class WriteTo extends Procedure2
{
    boolean ifChanged;
    public static final WriteTo writeTo;
    public static final WriteTo writeToIfChanged;
    
    public static void writeTo(final Object value, final Path ppath, final OutputStream outs) throws Throwable {
        final OutPort out = new OutPort(outs, ppath);
        final XMLPrinter consumer = new XMLPrinter((Writer)out, false);
        final String extension = ppath.getExtension();
        if ("html".equals(extension)) {
            consumer.setStyle("html");
        }
        Values.writeValues(value, consumer);
        out.close();
    }
    
    public static void writeTo(final Object value, final Object path) throws Throwable {
        final Path ppath = Path.valueOf(path);
        final OutputStream outs = ppath.openOutputStream();
        writeTo(value, ppath, outs);
    }
    
    public static void writeToIfChanged(final Object value, final Object path) throws Throwable {
        final Path ppath = Path.valueOf(path);
        final ByteArrayOutputStream bout = new ByteArrayOutputStream();
        writeTo(value, ppath, bout);
        final byte[] bbuf = bout.toByteArray();
        try {
            final InputStream ins = new BufferedInputStream(ppath.openInputStream());
            int i = 0;
            while (true) {
                final int b = ins.read();
                final boolean atend = i == bbuf.length;
                if (b < 0) {
                    if (!atend) {
                        break;
                    }
                    ins.close();
                    return;
                }
                else {
                    if (atend) {
                        break;
                    }
                    if (bbuf[i++] != b) {
                        break;
                    }
                    continue;
                }
            }
            ins.close();
        }
        catch (Exception ex) {}
        final OutputStream fout = new BufferedOutputStream(ppath.openOutputStream());
        fout.write(bbuf);
        fout.close();
    }
    
    @Override
    public Object apply2(final Object value, final Object fileName) throws Throwable {
        if (this.ifChanged) {
            writeToIfChanged(value, fileName.toString());
        }
        else {
            writeTo(value, fileName.toString());
        }
        return Values.empty;
    }
    
    static {
        writeTo = new WriteTo();
        writeToIfChanged = new WriteTo();
        WriteTo.writeToIfChanged.ifChanged = true;
    }
}
