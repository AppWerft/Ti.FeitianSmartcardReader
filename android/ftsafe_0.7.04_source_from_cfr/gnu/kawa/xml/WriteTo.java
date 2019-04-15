/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import gnu.xml.XMLPrinter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

public class WriteTo
extends Procedure2 {
    boolean ifChanged;
    public static final WriteTo writeTo = new WriteTo();
    public static final WriteTo writeToIfChanged = new WriteTo();

    public static void writeTo(Object value, Path ppath, OutputStream outs) throws Throwable {
        OutPort out = new OutPort(outs, ppath);
        XMLPrinter consumer = new XMLPrinter(out, false);
        String extension = ppath.getExtension();
        if ("html".equals(extension)) {
            consumer.setStyle("html");
        }
        Values.writeValues(value, consumer);
        out.close();
    }

    public static void writeTo(Object value, Object path) throws Throwable {
        Path ppath = Path.valueOf(path);
        OutputStream outs = ppath.openOutputStream();
        WriteTo.writeTo(value, ppath, outs);
    }

    public static void writeToIfChanged(Object value, Object path) throws Throwable {
        Path ppath = Path.valueOf(path);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        WriteTo.writeTo(value, ppath, bout);
        byte[] bbuf = bout.toByteArray();
        try {
            int b;
            boolean atend;
            BufferedInputStream ins = new BufferedInputStream(ppath.openInputStream());
            int i = 0;
            do {
                b = ((InputStream)ins).read();
                boolean bl = atend = i == bbuf.length;
                if (b >= 0) continue;
                if (atend) {
                    ((InputStream)ins).close();
                    return;
                }
                break;
            } while (!atend && bbuf[i++] == b);
            ((InputStream)ins).close();
        }
        catch (Exception ex) {
            // empty catch block
        }
        BufferedOutputStream fout = new BufferedOutputStream(ppath.openOutputStream());
        ((OutputStream)fout).write(bbuf);
        ((OutputStream)fout).close();
    }

    @Override
    public Object apply2(Object value, Object fileName) throws Throwable {
        if (this.ifChanged) {
            WriteTo.writeToIfChanged(value, fileName.toString());
        } else {
            WriteTo.writeTo(value, fileName.toString());
        }
        return Values.empty;
    }

    static {
        WriteTo.writeToIfChanged.ifChanged = true;
    }
}

