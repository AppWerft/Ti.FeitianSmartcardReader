// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;

public class ArrayClassLoader extends ClassLoader
{
    Hashtable map;
    Hashtable cmap;
    URL context;
    
    public ArrayClassLoader() {
        this.map = new Hashtable(100);
        this.cmap = new Hashtable(100);
    }
    
    public ArrayClassLoader(final ClassLoader parent) {
        super(parent);
        this.map = new Hashtable(100);
        this.cmap = new Hashtable(100);
    }
    
    public URL getResourceContext() {
        return this.context;
    }
    
    public void setResourceContext(final URL context) {
        this.context = context;
    }
    
    public ArrayClassLoader(final byte[][] classBytes) {
        this.map = new Hashtable(100);
        this.cmap = new Hashtable(100);
        int i = classBytes.length;
        while (--i >= 0) {
            this.addClass("lambda" + i, classBytes[i]);
        }
    }
    
    public ArrayClassLoader(final String[] classNames, final byte[][] classBytes) {
        this.map = new Hashtable(100);
        this.cmap = new Hashtable(100);
        int i = classBytes.length;
        while (--i >= 0) {
            this.addClass(classNames[i], classBytes[i]);
        }
    }
    
    public void addClass(final Class clas) {
        this.cmap.put(clas.getName(), clas);
    }
    
    public void addClass(final String name, final byte[] bytes) {
        this.map.put(name, bytes);
    }
    
    public void addClass(final ClassType ctype) {
        this.map.put(ctype.getName(), ctype);
    }
    
    @Override
    public InputStream getResourceAsStream(final String name) {
        final InputStream in = super.getResourceAsStream(name);
        if (in == null && name.endsWith(".class")) {
            final String cname = name.substring(0, name.length() - 6).replace('/', '.');
            final Object r = this.map.get(cname);
            if (r instanceof byte[]) {
                return new ByteArrayInputStream((byte[])r);
            }
        }
        return in;
    }
    
    @Override
    protected URL findResource(final String name) {
        if (this.context != null) {
            try {
                final URL url = new URL(this.context, name);
                url.openConnection().connect();
                return url;
            }
            catch (Exception ex) {}
        }
        return super.findResource(name);
    }
    
    public Class loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
        final Class clas = this.loadClass(name);
        if (resolve) {
            this.resolveClass(clas);
        }
        return clas;
    }
    
    @Override
    public Class loadClass(final String name) throws ClassNotFoundException {
        Object r = this.cmap.get(name);
        if (r != null) {
            return (Class)r;
        }
        synchronized (this) {
            r = this.map.get(name);
            if (r instanceof ClassType) {
                final ClassType ctype = (ClassType)r;
                if (ctype.isExisting()) {
                    r = ctype.reflectClass;
                }
                else {
                    r = ctype.writeToArray();
                }
            }
            if (r instanceof byte[]) {
                final byte[] bytes = (byte[])r;
                final Class clas = this.defineClass(name, bytes, 0, bytes.length);
                this.cmap.put(name, clas);
                return clas;
            }
            if (r == null) {
                return this.getParent().loadClass(name);
            }
            return (Class)r;
        }
    }
    
    public static Package getContextPackage(final String cname) {
        try {
            final ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader instanceof ArrayClassLoader) {
                return ((ArrayClassLoader)loader).getPackage(cname);
            }
        }
        catch (SecurityException ex) {}
        return Package.getPackage(cname);
    }
}
