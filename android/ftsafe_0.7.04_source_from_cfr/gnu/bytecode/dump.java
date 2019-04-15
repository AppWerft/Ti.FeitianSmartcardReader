/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassFileInput;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.ObjectType;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

public class dump
extends ClassFileInput {
    ClassTypeWriter writer;

    dump(InputStream str, ClassTypeWriter writer) throws IOException, ClassFormatError {
        super(str);
        this.ctype = new ClassType();
        this.readFormatVersion();
        this.readConstants();
        this.readClassInfo();
        this.readFields();
        this.readMethods();
        this.readAttributes(this.ctype);
        writer.print(this.ctype);
        writer.flush();
    }

    @Override
    public ConstantPool readConstants() throws IOException {
        this.ctype.constants = super.readConstants();
        return this.ctype.constants;
    }

    @Override
    public Attribute readAttribute(String name, int length, AttrContainer container) throws IOException {
        return super.readAttribute(name, length, container);
    }

    static int readMagic(InputStream in) throws IOException {
        int b;
        int magic = 0;
        for (int j = 0; j < 4 && (b = in.read()) >= 0; ++j) {
            magic = magic << 8 | b & 255;
        }
        return magic;
    }

    public static void process(InputStream in, String filename, OutputStream out, int flags) throws IOException {
        dump.process(in, filename, new ClassTypeWriter(null, out, flags));
    }

    public static void process(InputStream in, String filename, Writer out, int flags) throws IOException {
        dump.process(in, filename, new ClassTypeWriter(null, out, flags));
    }

    public static void process(InputStream in, String filename, ClassTypeWriter out) throws IOException {
        BufferedInputStream inp = new BufferedInputStream(in);
        ((InputStream)inp).mark(5);
        int magic = dump.readMagic(inp);
        if (magic == -889275714) {
            out.print("Reading .class from ");
            out.print(filename);
            out.println('.');
            new dump(inp, out);
        } else if (magic == 1347093252) {
            ZipEntry zent;
            ((InputStream)inp).reset();
            out.print("Reading classes from archive ");
            out.print(filename);
            out.println('.');
            ZipInputStream zin = new ZipInputStream(inp);
            while ((zent = zin.getNextEntry()) != null) {
                String name = zent.getName();
                if (zent.isDirectory()) {
                    out.print("Archive directory: ");
                    out.print(name);
                    out.println('.');
                    continue;
                }
                out.println();
                magic = dump.readMagic(zin);
                if (magic == -889275714) {
                    out.print("Reading class member: ");
                    out.print(name);
                    out.println('.');
                    new dump(zin, out);
                    continue;
                }
                out.print("Skipping non-class member: ");
                out.print(name);
                out.println('.');
            }
            System.exit(-1);
        } else {
            System.err.println("File " + filename + " is not a valid .class file");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        int alen = args.length;
        ClassTypeWriter out = new ClassTypeWriter(null, System.out, 0);
        if (alen == 0) {
            dump.usage(System.err);
        }
        for (int i = 0; i < alen; ++i) {
            String filename = args[i];
            if (filename.equals("-verbose") || filename.equals("--verbose")) {
                out.setFlags(15);
                continue;
            }
            boolean isURL = dump.uriSchemeSpecified(filename);
            try {
                InputStream in;
                if (isURL) {
                    String filepart;
                    boolean isJarURL = filename.startsWith("jar:");
                    if (isJarURL) {
                        int excl;
                        String part = filename.substring(4);
                        if (!dump.uriSchemeSpecified(part) && (excl = part.indexOf(33)) >= 0) {
                            filepart = part.substring(0, excl);
                            filepart = new File(filepart).toURI().toURL().toString();
                            filename = "jar:" + filepart + part.substring(excl);
                        }
                        if (part.indexOf("!/") < 0) {
                            excl = filename.lastIndexOf(33);
                            if (excl <= 0) {
                                isJarURL = false;
                            } else if (filename.indexOf(47, excl) < 0) {
                                part = filename.substring(excl + 1);
                                part = part.replace('.', '/');
                                filename = filename.substring(0, excl + 1) + '/' + part + ".class";
                            }
                        }
                    }
                    try {
                        URL url = new URL(filename);
                        try {
                            in = url.openConnection().getInputStream();
                        }
                        catch (ZipException e1) {
                            if (isJarURL) {
                                filepart = url.getFile();
                                int sl = filepart.lastIndexOf(33);
                                if (sl > 0) {
                                    filepart = filepart.substring(0, sl);
                                }
                                try {
                                    new URL(filepart).openConnection().getInputStream();
                                }
                                catch (FileNotFoundException e2) {
                                    System.err.print("Jar File for URL ");
                                    System.err.print(filepart);
                                    System.err.println(" not found.");
                                    System.exit(-1);
                                }
                            }
                            throw e1;
                        }
                    }
                    catch (FileNotFoundException e1) {
                        System.err.print("File for URL ");
                        System.err.print(filename);
                        System.err.println(" not found.");
                        System.exit(-1);
                        in = null;
                    }
                    catch (ZipException e1) {
                        System.err.print("Error opening zip archive ");
                        System.err.print(filename);
                        System.err.println(" not found.");
                        e1.printStackTrace();
                        if (e1.getCause() != null) {
                            e1.getCause().printStackTrace();
                        }
                        System.exit(-1);
                        in = null;
                    }
                } else {
                    try {
                        in = new FileInputStream(filename);
                    }
                    catch (FileNotFoundException e1) {
                        ClassLoader loader;
                        try {
                            Class clas = ObjectType.getContextClass(filename);
                            loader = clas.getClassLoader();
                        }
                        catch (NoClassDefFoundError e2) {
                            loader = ObjectType.getContextClassLoader();
                        }
                        catch (Throwable e2) {
                            System.err.print("File ");
                            System.err.print(filename);
                            System.err.println(" not found.");
                            System.exit(-1);
                            loader = null;
                            in = null;
                        }
                        String clfilename = filename.replace('.', '/') + ".class";
                        if (loader == null) {
                            loader = ClassLoader.getSystemClassLoader();
                        }
                        try {
                            URL resource = loader.getResource(clfilename);
                            in = resource.openConnection().getInputStream();
                            filename = resource.toString();
                        }
                        catch (Throwable ex) {
                            System.err.print("Can't find .class file for class ");
                            System.err.print(filename);
                            System.err.print(" - ");
                            System.err.println(ex);
                            System.exit(-1);
                            in = null;
                        }
                    }
                }
                dump.process(in, filename, out);
                continue;
            }
            catch (IOException e) {
                e.printStackTrace();
                System.err.println("caught ");
                System.err.print(e);
                System.exit(-1);
            }
        }
    }

    static int uriSchemeLength(String uri) {
        int len = uri.length();
        for (int i = 0; i < len; ++i) {
            char ch = uri.charAt(i);
            if (ch == ':') {
                return i;
            }
            if (!(i == 0 ? !Character.isLetter(ch) : !Character.isLetterOrDigit(ch) && ch != '+' && ch != '-' && ch != '.')) continue;
            return -1;
        }
        return -1;
    }

    static boolean uriSchemeSpecified(String name) {
        int ulen = dump.uriSchemeLength(name);
        if (ulen == 1 && File.separatorChar == '\\') {
            char drive = name.charAt(0);
            return !(drive >= 'a' && drive <= 'z' || drive >= 'A' && drive <= 'Z');
        }
        return ulen > 0;
    }

    public static void usage(PrintStream err) {
        err.println("Prints and dis-assembles the contents of JVM .class files.");
        err.println("Usage: [--verbose] class-or-jar ...");
        err.println("where a class-or-jar can be one of:");
        err.println("- a fully-qualified class name; or");
        err.println("- the name of a .class file, or a URL reference to one; or");
        err.println("- the name of a .jar or .zip archive file, or a URL reference to one.");
        err.println("If a .jar/.zip archive is named, all its.class file members are printed.");
        err.println();
        err.println("You can name a single .class member of an archive with a jar: URL,");
        err.println("which looks like: jar:jar-spec!/p1/p2/cl.class");
        err.println("The jar-spec can be a URL or the name of the .jar file.");
        err.println("You can also use the shorthand syntax: jar:jar-spec!p1.p2.cl");
        System.exit(-1);
    }
}

