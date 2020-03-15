// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.net.URLConnection;
import java.io.FileOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import gnu.mapping.WrappedException;
import java.net.URI;
import java.net.URL;

public class URLPath extends URIPath
{
    final URL url;
    
    URLPath(final URL url) {
        super(toUri(url));
        this.url = url;
    }
    
    public static URLPath valueOf(final URL url) {
        return new URLPath(url);
    }
    
    @Override
    public boolean isAbsolute() {
        return true;
    }
    
    @Override
    public long getLastModified() {
        return getLastModified(this.url);
    }
    
    public static long getLastModified(final URL url) {
        try {
            return url.openConnection().getLastModified();
        }
        catch (Exception ex) {
            return 0L;
        }
    }
    
    @Override
    public long getContentLength() {
        return getContentLength(this.url);
    }
    
    public static int getContentLength(final URL url) {
        try {
            return url.openConnection().getContentLength();
        }
        catch (Exception ex) {
            return -1;
        }
    }
    
    @Override
    public URL toURL() {
        return this.url;
    }
    
    public static URI toUri(final URL url) {
        try {
            return url.toURI();
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }
    
    @Override
    public URI toUri() {
        return toUri(this.url);
    }
    
    @Override
    public String toURIString() {
        return this.url.toString();
    }
    
    @Override
    public Path resolve(final String relative) {
        try {
            return valueOf(this.resolveToUri(relative).toURL());
        }
        catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static InputStream openInputStream(final URL url) throws IOException {
        return url.openConnection().getInputStream();
    }
    
    @Override
    public InputStream openInputStream() throws IOException {
        return openInputStream(this.url);
    }
    
    public static OutputStream openOutputStream(final URL url) throws IOException {
        final String str = url.toString();
        if (str.startsWith("file:")) {
            try {
                return new FileOutputStream(new File(new URI(str)));
            }
            catch (Exception ex) {}
        }
        final URLConnection conn = url.openConnection();
        conn.setDoInput(false);
        conn.setDoOutput(true);
        return conn.getOutputStream();
    }
    
    @Override
    public OutputStream openOutputStream() throws IOException {
        return openOutputStream(this.url);
    }
}
