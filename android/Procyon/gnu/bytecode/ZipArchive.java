// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.PrintStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class ZipArchive
{
    private static void usage() {
        System.err.println("zipfile [ptxq] archive [file ...]");
        System.exit(-1);
    }
    
    public static long copy(final InputStream in, final OutputStream out, final byte[] buffer) throws IOException {
        long total = 0L;
        while (true) {
            final int count = in.read(buffer);
            if (count <= 0) {
                break;
            }
            out.write(buffer, 0, count);
            total += count;
        }
        return total;
    }
    
    public static void copy(final InputStream in, final String name, final byte[] buffer) throws IOException {
        final File f = new File(name);
        final String dir_name = f.getParent();
        if (dir_name != null) {
            final File dir = new File(dir_name);
            if (!dir.exists()) {
                System.err.println("mkdirs:" + dir.mkdirs());
            }
        }
        if (name.charAt(name.length() - 1) != '/') {
            final OutputStream out = new BufferedOutputStream(new FileOutputStream(f));
            copy(in, out, buffer);
            out.close();
        }
    }
    
    public static void main(final String[] args) throws IOException {
        if (args.length < 2) {
            usage();
        }
        final String command = args[0];
        final String archive_name = args[1];
        try {
            if (command.equals("t") || command.equals("p") || command.equals("x")) {
                final PrintStream out = System.out;
                final byte[] buf = new byte[1024];
                if (args.length == 2) {
                    final BufferedInputStream in = new BufferedInputStream(new FileInputStream(archive_name));
                    final ZipInputStream zin = new ZipInputStream(in);
                    ZipEntry zent;
                    while ((zent = zin.getNextEntry()) != null) {
                        final String name = zent.getName();
                        if (command.equals("t")) {
                            out.print(name);
                            out.print(" size: ");
                            out.println(zent.getSize());
                        }
                        else if (command.equals("p")) {
                            copy(zin, out, buf);
                        }
                        else {
                            copy(zin, name, buf);
                        }
                    }
                }
                else {
                    final ZipFile zar = new ZipFile(archive_name);
                    for (int i = 2; i < args.length; ++i) {
                        final String name2 = args[i];
                        final ZipEntry zent2 = zar.getEntry(name2);
                        if (zent2 == null) {
                            System.err.println("zipfile " + archive_name + ":" + args[i] + " - not found");
                            System.exit(-1);
                        }
                        else if (command.equals("t")) {
                            out.print(name2);
                            out.print(" size: ");
                            out.println(zent2.getSize());
                        }
                        else if (command.equals("p")) {
                            copy(zar.getInputStream(zent2), out, buf);
                        }
                        else {
                            copy(zar.getInputStream(zent2), name2, buf);
                        }
                    }
                }
            }
            else if (command.equals("q")) {
                final ZipOutputStream zar2 = new ZipOutputStream(new FileOutputStream(archive_name));
                for (int j = 2; j < args.length; ++j) {
                    final File in2 = new File(args[j]);
                    if (!in2.exists()) {
                        throw new IOException(args[j] + " - not found");
                    }
                    if (!in2.canRead()) {
                        throw new IOException(args[j] + " - not readable");
                    }
                    final int size = (int)in2.length();
                    final FileInputStream fin = new FileInputStream(in2);
                    final byte[] contents = new byte[size];
                    if (fin.read(contents) != size) {
                        throw new IOException(args[j] + " - read error");
                    }
                    fin.close();
                    final ZipEntry ze = new ZipEntry(args[j]);
                    ze.setSize(size);
                    ze.setTime(in2.lastModified());
                    zar2.putNextEntry(ze);
                    zar2.write(contents, 0, size);
                }
                zar2.close();
            }
            else {
                usage();
            }
        }
        catch (IOException ex) {
            System.err.println("I/O Exception:  " + ex);
        }
    }
}
