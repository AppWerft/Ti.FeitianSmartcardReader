// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.Vector;
import java.util.zip.ZipFile;

public class ZipLoader extends ClassLoader
{
    ZipFile zar;
    int size;
    private String zipname;
    private Vector<Object> loadedClasses;
    
    public ZipLoader(final String name) throws IOException {
        this.zipname = name;
        this.zar = new ZipFile(name);
        this.size = 0;
        final Enumeration e = this.zar.entries();
        while (e.hasMoreElements()) {
            final ZipEntry ent = e.nextElement();
            if (!ent.isDirectory()) {
                ++this.size;
            }
        }
        this.loadedClasses = new Vector<Object>(this.size);
    }
    
    public Class loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
        final int index = this.loadedClasses.indexOf(name);
        Class clas;
        if (index >= 0) {
            clas = this.loadedClasses.elementAt(index + 1);
        }
        else if (this.zar == null && this.loadedClasses.size() == 2 * this.size) {
            clas = Class.forName(name);
        }
        else {
            boolean reopened = false;
            final String member_name = name.replace('.', '/') + ".class";
            if (this.zar == null) {
                try {
                    this.zar = new ZipFile(this.zipname);
                    reopened = true;
                }
                catch (IOException ex) {
                    throw new ClassNotFoundException("IOException while loading " + member_name + " from ziparchive \"" + name + "\": " + ex.toString());
                }
            }
            final ZipEntry member = this.zar.getEntry(member_name);
            if (member == null) {
                if (reopened) {
                    try {
                        this.close();
                    }
                    catch (IOException e) {
                        throw new RuntimeException("failed to close \"" + this.zipname + "\"");
                    }
                }
                clas = Class.forName(name);
            }
            else {
                try {
                    final int member_size = (int)member.getSize();
                    final InputStream strm = this.zar.getInputStream(member);
                    final byte[] bytes = new byte[member_size];
                    new DataInputStream(strm).readFully(bytes);
                    clas = this.defineClass(name, bytes, 0, member_size);
                    this.loadedClasses.addElement(name);
                    this.loadedClasses.addElement(clas);
                    if (2 * this.size == this.loadedClasses.size()) {
                        this.close();
                    }
                }
                catch (IOException ex2) {
                    throw new ClassNotFoundException("IOException while loading " + member_name + " from ziparchive \"" + name + "\": " + ex2.toString());
                }
            }
        }
        if (resolve) {
            this.resolveClass(clas);
        }
        return clas;
    }
    
    public Class loadAllClasses() throws IOException {
        final Enumeration e = this.zar.entries();
        Class mainClass = null;
        while (e.hasMoreElements()) {
            final ZipEntry member = e.nextElement();
            String name = member.getName().replace('/', '.');
            name = name.substring(0, name.length() - "/class".length());
            final int member_size = (int)member.getSize();
            final InputStream strm = this.zar.getInputStream(member);
            final byte[] bytes = new byte[member_size];
            new DataInputStream(strm).readFully(bytes);
            if (!this.loadedClasses.contains(name)) {
                final Class clas = this.defineClass(name, bytes, 0, member_size);
                if (mainClass == null) {
                    mainClass = clas;
                }
                this.loadedClasses.addElement(name);
                this.loadedClasses.addElement(clas);
            }
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
