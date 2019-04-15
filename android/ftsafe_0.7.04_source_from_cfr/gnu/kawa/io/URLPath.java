/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.mapping.WrappedException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URLPath
extends URIPath {
    final URL url;

    URLPath(URL url) {
        super(URLPath.toUri(url));
        this.url = url;
    }

    public static URLPath valueOf(URL url) {
        return new URLPath(url);
    }

    @Override
    public boolean isAbsolute() {
        return true;
    }

    @Override
    public long getLastModified() {
        return URLPath.getLastModified(this.url);
    }

    public static long getLastModified(URL url) {
        try {
            return url.openConnection().getLastModified();
        }
        catch (Exception ex) {
            return 0L;
        }
    }

    @Override
    public long getContentLength() {
        return URLPath.getContentLength(this.url);
    }

    public static int getContentLength(URL url) {
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

    public static URI toUri(URL url) {
        try {
            return url.toURI();
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    @Override
    public URI toUri() {
        return URLPath.toUri(this.url);
    }

    @Override
    public String toURIString() {
        return this.url.toString();
    }

    @Override
    public Path resolve(String relative) {
        try {
            return URLPath.valueOf(this.resolveToUri(relative).toURL());
        }
        catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static InputStream openInputStream(URL url) throws IOException {
        return url.openConnection().getInputStream();
    }

    @Override
    public InputStream openInputStream() throws IOException {
        return URLPath.openInputStream(this.url);
    }

    public static OutputStream openOutputStream(URL url) throws IOException {
        String str = url.toString();
        if (str.startsWith("file:")) {
            try {
                return new FileOutputStream(new File(new URI(str)));
            }
            catch (Exception ex) {
                // empty catch block
            }
        }
        URLConnection conn = url.openConnection();
        conn.setDoInput(false);
        conn.setDoOutput(true);
        return conn.getOutputStream();
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return URLPath.openOutputStream(this.url);
    }
}

