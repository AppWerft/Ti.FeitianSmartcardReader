/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipLoader
extends ClassLoader {
    ZipFile zar;
    int size;
    private String zipname;
    private Vector<Object> loadedClasses;

    public ZipLoader(String name) throws IOException {
        this.zipname = name;
        this.zar = new ZipFile(name);
        this.size = 0;
        Enumeration<? extends ZipEntry> e = this.zar.entries();
        while (e.hasMoreElements()) {
            ZipEntry ent = e.nextElement();
            if (ent.isDirectory()) continue;
            ++this.size;
        }
        this.loadedClasses = new Vector(this.size);
    }

    public Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clas;
        int index = this.loadedClasses.indexOf(name);
        if (index >= 0) {
            clas = (Class<?>)this.loadedClasses.elementAt(index + 1);
        } else if (this.zar == null && this.loadedClasses.size() == 2 * this.size) {
            clas = Class.forName(name);
        } else {
            ZipEntry member;
            boolean reopened = false;
            String member_name = name.replace('.', '/') + ".class";
            if (this.zar == null) {
                try {
                    this.zar = new ZipFile(this.zipname);
                    reopened = true;
                }
                catch (IOException ex) {
                    throw new ClassNotFoundException("IOException while loading " + member_name + " from ziparchive \"" + name + "\": " + ex.toString());
                }
            }
            if ((member = this.zar.getEntry(member_name)) == null) {
                if (reopened) {
                    try {
                        this.close();
                    }
                    catch (IOException e) {
                        throw new RuntimeException("failed to close \"" + this.zipname + "\"");
                    }
                }
                clas = Class.forName(name);
            } else {
                try {
                    int member_size = (int)member.getSize();
                    InputStream strm = this.zar.getInputStream(member);
                    byte[] bytes = new byte[member_size];
                    new DataInputStream(strm).readFully(bytes);
                    clas = this.defineClass(name, bytes, 0, member_size);
                    this.loadedClasses.addElement(name);
                    this.loadedClasses.addElement(clas);
                    if (2 * this.size == this.loadedClasses.size()) {
                        this.close();
                    }
                }
                catch (IOException ex) {
                    throw new ClassNotFoundException("IOException while loading " + member_name + " from ziparchive \"" + name + "\": " + ex.toString());
                }
            }
        }
        if (resolve) {
            this.resolveClass(clas);
        }
        return clas;
    }

    public Class loadAllClasses() throws IOException {
        Enumeration<? extends ZipEntry> e = this.zar.entries();
        Class<?> mainClass = null;
        while (e.hasMoreElements()) {
            ZipEntry member = e.nextElement();
            String name = member.getName().replace('/', '.');
            name = name.substring(0, name.length() - "/class".length());
            int member_size = (int)member.getSize();
            InputStream strm = this.zar.getInputStream(member);
            byte[] bytes = new byte[member_size];
            new DataInputStream(strm).readFully(bytes);
            if (this.loadedClasses.contains(name)) continue;
            Class<?> clas = this.defineClass(name, bytes, 0, member_size);
            if (mainClass == null) {
                mainClass = clas;
            }
            this.loadedClasses.addElement(name);
            this.loadedClasses.addElement(clas);
        }
        this.close();
        return mainClass;
    }

    public void close() throws IOException {
        if (this.zar != null) {
            this.zar.close();
        }
        this.zar = null;
    }
}

