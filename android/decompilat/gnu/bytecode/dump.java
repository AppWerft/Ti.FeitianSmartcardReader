// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.PrintStream;
import java.io.FileInputStream;
import java.util.zip.ZipException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.BufferedInputStream;
import java.io.Writer;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;

public class dump extends ClassFileInput
{
    ClassTypeWriter writer;
    
    dump(final InputStream str, final ClassTypeWriter writer) throws IOException, ClassFormatError {
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
        return this.ctype.constants = super.readConstants();
    }
    
    @Override
    public Attribute readAttribute(final String name, final int length, final AttrContainer container) throws IOException {
        return super.readAttribute(name, length, container);
    }
    
    static int readMagic(final InputStream in) throws IOException {
        int magic = 0;
        for (int j = 0; j < 4; ++j) {
            final int b = in.read();
            if (b < 0) {
                break;
            }
            magic = (magic << 8 | (b & 0xFF));
        }
        return magic;
    }
    
    public static void process(final InputStream in, final String filename, final OutputStream out, final int flags) throws IOException {
        process(in, filename, new ClassTypeWriter(null, out, flags));
    }
    
    public static void process(final InputStream in, final String filename, final Writer out, final int flags) throws IOException {
        process(in, filename, new ClassTypeWriter(null, out, flags));
    }
    
    public static void process(final InputStream in, final String filename, final ClassTypeWriter out) throws IOException {
        final InputStream inp = new BufferedInputStream(in);
        inp.mark(5);
        int magic = readMagic(inp);
        if (magic == -889275714) {
            out.print("Reading .class from ");
            out.print(filename);
            out.println('.');
            new dump(inp, out);
        }
        else if (magic == 1347093252) {
            inp.reset();
            out.print("Reading classes from archive ");
            out.print(filename);
            out.println('.');
            final ZipInputStream zin = new ZipInputStream(inp);
            ZipEntry zent;
            while ((zent = zin.getNextEntry()) != null) {
                final String name = zent.getName();
                if (zent.isDirectory()) {
                    out.print("Archive directory: ");
                    out.print(name);
                    out.println('.');
                }
                else {
                    out.println();
                    magic = readMagic(zin);
                    if (magic == -889275714) {
                        out.print("Reading class member: ");
                        out.print(name);
                        out.println('.');
                        new dump(zin, out);
                    }
                    else {
                        out.print("Skipping non-class member: ");
                        out.print(name);
                        out.println('.');
                    }
                }
            }
            System.exit(-1);
        }
        else {
            System.err.println("File " + filename + " is not a valid .class file");
            System.exit(-1);
        }
    }
    
    public static void main(final String[] args) {
        final int alen = args.length;
        final ClassTypeWriter out = new ClassTypeWriter(null, System.out, 0);
        if (alen == 0) {
            usage(System.err);
        }
        for (String filename : args) {
            if (filename.equals("-verbose") || filename.equals("--verbose")) {
                out.setFlags(15);
            }
            else {
                final boolean isURL = uriSchemeSpecified(filename);
                try {
                    InputStream in;
                    if (isURL) {
                        boolean isJarURL = filename.startsWith("jar:");
                        if (isJarURL) {
                            String part = filename.substring(4);
                            if (!uriSchemeSpecified(part)) {
                                final int excl = part.indexOf(33);
                                if (excl >= 0) {
                                    String filepart = part.substring(0, excl);
                                    filepart = new File(filepart).toURI().toURL().toString();
                                    filename = "jar:" + filepart + part.substring(excl);
                                }
                            }
                            if (part.indexOf("!/") < 0) {
                                final int excl = filename.lastIndexOf(33);
                                if (excl <= 0) {
                                    isJarURL = false;
                                }
                                else if (filename.indexOf(47, excl) < 0) {
                                    part = filename.substring(excl + 1);
                                    part = part.replace('.', '/');
                                    filename = filename.substring(0, excl + 1) + '/' + part + ".class";
                                }
                            }
                        }
                        try {
                            final URL url = new URL(filename);
                            try {
                                in = url.openConnection().getInputStream();
                            }
                            catch (ZipException e1) {
                                if (isJarURL) {
                                    String filepart = url.getFile();
                                    final int sl = filepart.lastIndexOf(33);
                                    if (sl > 0) {
                                        filepart = filepart.substring(0, sl);
                                    }
                                    try {
                                        new URL(filepart).openConnection().getInputStream();
                                    }
                                    catch (FileNotFoundException e4) {
                                        System.err.print("Jar File for URL ");
                                        System.err.print(filepart);
                                        System.err.println(" not found.");
                                        System.exit(-1);
                                    }
                                }
                                throw e1;
                            }
                        }
                        catch (FileNotFoundException e5) {
                            System.err.print("File for URL ");
                            System.err.print(filename);
                            System.err.println(" not found.");
                            System.exit(-1);
                            in = null;
                        }
                        catch (ZipException e2) {
                            System.err.print("Error opening zip archive ");
                            System.err.print(filename);
                            System.err.println(" not found.");
                            e2.printStackTrace();
                            if (e2.getCause() != null) {
                                e2.getCause().printStackTrace();
                            }
                            System.exit(-1);
                            in = null;
                        }
                    }
                    else {
                        try {
                            in = new FileInputStream(filename);
                        }
                        catch (FileNotFoundException e6) {
                            ClassLoader loader;
                            try {
                                final Class clas = ObjectType.getContextClass(filename);
                                loader = clas.getClassLoader();
                            }
                            catch (NoClassDefFoundError e7) {
                                loader = ObjectType.getContextClassLoader();
                            }
                            catch (Throwable e8) {
                                System.err.print("File ");
                                System.err.print(filename);
                                System.err.println(" not found.");
                                System.exit(-1);
                                loader = null;
                                in = null;
                            }
                            final String clfilename = filename.replace('.', '/') + ".class";
                            if (loader == null) {
                                loader = ClassLoader.getSystemClassLoader();
                            }
                            try {
                                final URL resource = loader.getResource(clfilename);
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
                    process(in, filename, out);
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                    System.err.println("caught ");
                    System.err.print(e3);
                    System.exit(-1);
                }
            }
        }
    }
    
    static int uriSchemeLength(final String uri) {
        for (int len = uri.length(), i = 0; i < len; ++i) {
            final char ch = uri.charAt(i);
            if (ch == ':') {
                return i;
            }
            if (i == 0) {
                if (!Character.isLetter(ch)) {
                    return -1;
                }
            }
            else if (!Character.isLetterOrDigit(ch) && ch != '+' && ch != '-' && ch != '.') {
                return -1;
            }
        }
        return -1;
    }
    
    static boolean uriSchemeSpecified(final String name) {
        final int ulen = uriSchemeLength(name);
        if (ulen == 1 && File.separatorChar == '\\') {
            final char drive = name.charAt(0);
            return (drive < 'a' || drive > 'z') && (drive < 'A' || drive > 'Z');
        }
        return ulen > 0;
    }
    
    public static void usage(final PrintStream err) {
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
