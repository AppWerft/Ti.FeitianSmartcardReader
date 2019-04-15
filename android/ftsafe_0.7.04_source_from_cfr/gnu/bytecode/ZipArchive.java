/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipArchive {
    private static void usage() {
        System.err.println("zipfile [ptxq] archive [file ...]");
        System.exit(-1);
    }

    public static long copy(InputStream in, OutputStream out, byte[] buffer) throws IOException {
        long total = 0L;
        int count;
        while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
            total += (long)count;
        }
        return total;
    }

    public static void copy(InputStream in, String name, byte[] buffer) throws IOException {
        File dir;
        File f = new File(name);
        String dir_name = f.getParent();
        if (dir_name != null && !(dir = new File(dir_name)).exists()) {
            System.err.println("mkdirs:" + dir.mkdirs());
        }
        if (name.charAt(name.length() - 1) != '/') {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
            ZipArchive.copy(in, out, buffer);
            ((OutputStream)out).close();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            ZipArchive.usage();
        }
        String command = args[0];
        String archive_name = args[1];
        try {
            if (command.equals("t") || command.equals("p") || command.equals("x")) {
                PrintStream out = System.out;
                byte[] buf = new byte[1024];
                if (args.length == 2) {
                    ZipEntry zent;
                    BufferedInputStream in = new BufferedInputStream(new FileInputStream(archive_name));
                    ZipInputStream zin = new ZipInputStream(in);
                    while ((zent = zin.getNextEntry()) != null) {
                        String name = zent.getName();
                        if (command.equals("t")) {
                            out.print(name);
                            out.print(" size: ");
                            out.println(zent.getSize());
                            continue;
                        }
                        if (command.equals("p")) {
                            ZipArchive.copy((InputStream)zin, out, buf);
                            continue;
                        }
                        ZipArchive.copy((InputStream)zin, name, buf);
                    }
                } else {
                    ZipFile zar = new ZipFile(archive_name);
                    for (int i = 2; i < args.length; ++i) {
                        String name = args[i];
                        ZipEntry zent = zar.getEntry(name);
                        if (zent == null) {
                            System.err.println("zipfile " + archive_name + ":" + args[i] + " - not found");
                            System.exit(-1);
                            continue;
                        }
                        if (command.equals("t")) {
                            out.print(name);
                            out.print(" size: ");
                            out.println(zent.getSize());
                            continue;
                        }
                        if (command.equals("p")) {
                            ZipArchive.copy(zar.getInputStream(zent), out, buf);
                            continue;
                        }
                        ZipArchive.copy(zar.getInputStream(zent), name, buf);
                    }
                }
            } else if (command.equals("q")) {
                ZipOutputStream zar = new ZipOutputStream(new FileOutputStream(archive_name));
                for (int i = 2; i < args.length; ++i) {
                    File in = new File(args[i]);
                    if (!in.exists()) {
                        throw new IOException(args[i] + " - not found");
                    }
                    if (!in.canRead()) {
                        throw new IOException(args[i] + " - not readable");
                    }
                    FileInputStream fin = new FileInputStream(in);
                    int size = (int)in.length();
                    byte[] contents = new byte[size];
                    if (fin.read(contents) != size) {
                        throw new IOException(args[i] + " - read error");
                    }
                    fin.close();
                    ZipEntry ze = new ZipEntry(args[i]);
                    ze.setSize(size);
                    ze.setTime(in.lastModified());
                    zar.putNextEntry(ze);
                    zar.write(contents, 0, size);
                }
                zar.close();
            } else {
                ZipArchive.usage();
            }
        }
        catch (IOException ex) {
            System.err.println("I/O Exception:  " + ex);
        }
    }
}

