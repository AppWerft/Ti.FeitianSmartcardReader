// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLStreamHandler;

public class ResourceStreamHandler extends URLStreamHandler
{
    public static final String CLASS_RESOURCE_URI_PREFIX = "class-resource:/";
    public static final int CLASS_RESOURCE_URI_PREFIX_LENGTH = 16;
    ClassLoader cloader;
    Class clas;
    
    public ResourceStreamHandler(final Class clas) {
        this.clas = clas;
        this.cloader = clas.getClassLoader();
    }
    
    public ResourceStreamHandler(final ClassLoader cloader) {
        this.cloader = cloader;
    }
    
    public static URL makeURL(final Class clas) throws MalformedURLException {
        String cname = clas.getName();
        final int dot = cname.lastIndexOf(46);
        final StringBuilder sbuf = new StringBuilder();
        sbuf.append("class-resource:/");
        if (dot >= 0) {
            sbuf.append(cname.substring(0, dot));
            sbuf.append('/');
            cname = cname.substring(dot + 1);
        }
        sbuf.append(cname);
        final String str = sbuf.toString();
        return new URL(null, str, new ResourceStreamHandler(clas));
    }
    
    public URLConnection openConnection(final URL u) throws IOException {
        final String ustr = u.toString();
        String rstr = ustr.substring(16);
        final int sl = rstr.indexOf(47);
        if (sl > 0) {
            rstr = rstr.substring(0, sl).replace('.', '/') + rstr.substring(sl);
        }
        URL url = this.cloader.getResource(rstr);
        if (url == null && this.clas != null) {
            final String clasName = this.clas.getName().replace('.', '/');
            url = this.cloader.getResource(clasName + ".class");
            final StringBuilder adjusted = new StringBuilder();
            int i = clasName.length();
            while (--i >= 0) {
                if (clasName.charAt(i) == '/') {
                    adjusted.append("../");
                }
            }
            adjusted.append(rstr);
            url = new URL(url, adjusted.toString());
        }
        if (url == null) {
            throw new FileNotFoundException(ustr);
        }
        return url.openConnection();
    }
}
