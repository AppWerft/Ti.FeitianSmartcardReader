/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;

public class ArrayClassLoader
extends ClassLoader {
    Hashtable map = new Hashtable(100);
    Hashtable cmap = new Hashtable(100);
    URL context;

    public ArrayClassLoader() {
    }

    public ArrayClassLoader(ClassLoader parent) {
        super(parent);
    }

    public URL getResourceContext() {
        return this.context;
    }

    public void setResourceContext(URL context) {
        this.context = context;
    }

    public ArrayClassLoader(byte[][] classBytes) {
        int i = classBytes.length;
        while (--i >= 0) {
            this.addClass("lambda" + i, classBytes[i]);
        }
    }

    public ArrayClassLoader(String[] classNames, byte[][] classBytes) {
        int i = classBytes.length;
        while (--i >= 0) {
            this.addClass(classNames[i], classBytes[i]);
        }
    }

    public void addClass(Class clas) {
        this.cmap.put(clas.getName(), clas);
    }

    public void addClass(String name, byte[] bytes) {
        this.map.put(name, bytes);
    }

    public void addClass(ClassType ctype) {
        this.map.put(ctype.getName(), ctype);
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        Object r;
        String cname;
        InputStream in = super.getResourceAsStream(name);
        if (in == null && name.endsWith(".class") && (r = this.map.get(cname = name.substring(0, name.length() - 6).replace('/', '.'))) instanceof byte[]) {
            return new ByteArrayInputStream((byte[])r);
        }
        return in;
    }

    @Override
    protected URL findResource(String name) {
        if (this.context != null) {
            try {
                URL url = new URL(this.context, name);
                url.openConnection().connect();
                return url;
            }
            catch (Exception ex) {
                // empty catch block
            }
        }
        return super.findResource(name);
    }

    public Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class clas = this.loadClass(name);
        if (resolve) {
            this.resolveClass(clas);
        }
        return clas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Class loadClass(String name) throws ClassNotFoundException {
        Object r = this.cmap.get(name);
        if (r != null) {
            return (Class)r;
        }
        ArrayClassLoader arrayClassLoader = this;
        synchronized (arrayClassLoader) {
            r = this.map.get(name);
            if (r instanceof ClassType) {
                ClassType ctype = (ClassType)r;
                r = ctype.isExisting() ? ctype.reflectClass : ctype.writeToArray();
            }
            if (r instanceof byte[]) {
                byte[] bytes = (byte[])r;
                Class<?> clas = this.defineClass(name, bytes, 0, bytes.length);
                this.cmap.put(name, clas);
                return clas;
            }
            if (r == null) {
                return this.getParent().loadClass(name);
            }
            return (Class)r;
        }
    }

    public static Package getContextPackage(String cname) {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader instanceof ArrayClassLoader) {
                return ((ArrayClassLoader)loader).getPackage(cname);
            }
        }
        catch (SecurityException ex) {
            // empty catch block
        }
        return Package.getPackage(cname);
    }
}

