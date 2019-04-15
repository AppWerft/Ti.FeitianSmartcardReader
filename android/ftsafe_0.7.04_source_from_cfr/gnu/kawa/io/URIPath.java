/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.FilePath;
import gnu.kawa.io.Path;
import gnu.kawa.io.URIStringPath;
import gnu.kawa.io.URLPath;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URIPath
extends Path
implements Comparable<URIPath> {
    final URI uri;

    URIPath(URI uri) {
        this.uri = uri;
    }

    public static URIPath coerceToURIPathOrNull(Object path) {
        if (path instanceof URIPath) {
            return (URIPath)path;
        }
        if (path instanceof URL) {
            return URLPath.valueOf((URL)path);
        }
        if (path instanceof URI) {
            return URIPath.valueOf((URI)path);
        }
        if (!(path instanceof CharSequence || path instanceof File || path instanceof Path)) {
            return null;
        }
        String str = path.toString();
        return URIPath.valueOf(str);
    }

    public static URIPath makeURI(Object arg) {
        URIPath path = URIPath.coerceToURIPathOrNull(arg);
        if (path == null) {
            throw new WrongType((String)null, -4, arg, "URI");
        }
        return path;
    }

    public static URIPath valueOf(URI uri) {
        return new URIPath(uri);
    }

    public static URIPath valueOf(String uri) {
        try {
            return new URIStringPath(new URI(URIPath.encodeForUri(uri, 'I')), uri);
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    @Override
    public boolean isAbsolute() {
        return this.uri.isAbsolute();
    }

    @Override
    public boolean exists() {
        try {
            URLConnection conn = this.toURL().openConnection();
            if (conn instanceof HttpURLConnection) {
                return ((HttpURLConnection)conn).getResponseCode() == 200;
            }
            return conn.getLastModified() != 0L;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public long getLastModified() {
        return URLPath.getLastModified(this.toURL());
    }

    @Override
    public long getContentLength() {
        return URLPath.getContentLength(this.toURL());
    }

    @Override
    public URI toUri() {
        return this.uri;
    }

    @Override
    public String toURIString() {
        return this.uri.toString();
    }

    @Override
    public Path resolve(String rstr) {
        char fileSep = File.separatorChar;
        if (fileSep != '/') {
            if (rstr.length() >= 2 && (rstr.charAt(1) == ':' && Character.isLetter(rstr.charAt(0)) || rstr.charAt(0) == fileSep && rstr.charAt(1) == fileSep)) {
                return FilePath.valueOf(new File(rstr));
            }
            rstr = rstr.replace(fileSep, '/');
        }
        return URIPath.valueOf(this.resolveToUri(rstr));
    }

    public URI resolveToUri(String rstr) {
        try {
            String tPath;
            String tQuery;
            String tAuthority;
            URI r = new URI(rstr);
            if (this.uri.isOpaque()) {
                return r;
            }
            String bScheme = this.getScheme();
            String bAuthority = this.getAuthority();
            String bPath = this.getPath();
            String bQuery = this.getQuery();
            String bFragment = this.getFragment();
            String rScheme = r.getScheme();
            String rAuthority = r.getAuthority();
            String rPath = r.getPath();
            String rQuery = r.getQuery();
            String rFragment = r.getFragment();
            String tScheme = rScheme != null ? rScheme : bScheme;
            boolean removeDotsNeeded = true;
            if (rScheme != null || rAuthority != null) {
                tAuthority = rAuthority;
                tPath = rPath;
                tQuery = rQuery;
            } else {
                tAuthority = bAuthority;
                if (rPath == null || rPath.length() == 0) {
                    tPath = bPath;
                    removeDotsNeeded = false;
                    tQuery = rQuery != null ? rQuery : bQuery;
                } else {
                    int bSlash;
                    tPath = rPath.charAt(0) == '/' ? rPath : (bAuthority != null && bPath.length() == 0 ? "/" + rPath : ((bSlash = bPath.lastIndexOf(47)) >= 0 ? bPath.substring(0, bSlash + 1) + rPath : rPath));
                    tQuery = rQuery;
                }
            }
            int len = tPath.length();
            if (removeDotsNeeded && len > 0) {
                StringBuilder pbuf = new StringBuilder();
                int ch0 = tPath.charAt(0);
                int i = 1;
                block2 : while (ch0 >= 0) {
                    if (ch0 == 46 && i + 1 < len && tPath.charAt(i) == '.' && tPath.charAt(i + 1) == '/') {
                        if (tScheme != null) {
                            ch0 = i + 2 < len ? (int)tPath.charAt(i + 2) : -1;
                            i += 3;
                            continue;
                        }
                        pbuf.append("..");
                        ch0 = 47;
                        i += 2;
                        continue;
                    }
                    if (ch0 == 46 && i < len && tPath.charAt(i) == '/') {
                        ch0 = i + 1 < len ? (int)tPath.charAt(i + 1) : -1;
                        i += 2;
                        continue;
                    }
                    if (ch0 == 47 && i < len && tPath.charAt(i) == '.' && (i + 1 == len || tPath.charAt(i + 1) == '/')) {
                        ch0 = 47;
                        i = i + 1 == len ? len : i + 2;
                        continue;
                    }
                    if (ch0 == 47 && i + 1 < len && tPath.charAt(i) == '.' && tPath.charAt(i + 1) == '.' && (i + 2 == len || tPath.charAt(i + 2) == '/')) {
                        ch0 = 47;
                        i = i + 2 == len ? len : i + 3;
                        int plen = pbuf.length();
                        while (plen > 0 && pbuf.charAt(--plen) != '/') {
                        }
                        pbuf.setLength(plen);
                        continue;
                    }
                    if (ch0 == 46 && (i == len || i + 1 == len && tPath.charAt(i) == '.')) {
                        ch0 = -1;
                        continue;
                    }
                    do {
                        pbuf.append((char)ch0);
                        if (i != len) continue;
                        ch0 = -1;
                        continue block2;
                    } while ((ch0 = (int)tPath.charAt(i++)) != 47);
                }
                tPath = pbuf.toString();
            }
            return new URI(tScheme, tAuthority, tPath, tQuery, rFragment);
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    @Override
    public int compareTo(URIPath path) {
        return this.uri.compareTo(path.uri);
    }

    public boolean equals(Object obj) {
        return obj instanceof URIPath && this.uri.equals(((URIPath)obj).uri);
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return this.toURIString();
    }

    @Override
    public URL toURL() {
        return Path.toURL(this.uri.toString());
    }

    @Override
    public File toFile() {
        return FilePath.valueOf(this.toURIString()).toFile();
    }

    @Override
    public InputStream openInputStream() throws IOException {
        return URLPath.openInputStream(this.toURL());
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return URLPath.openOutputStream(this.toURL());
    }

    @Override
    public String getScheme() {
        return this.uri.getScheme();
    }

    @Override
    public String getHost() {
        return this.uri.getHost();
    }

    @Override
    public String getAuthority() {
        return this.uri.getAuthority();
    }

    @Override
    public String getUserInfo() {
        return this.uri.getUserInfo();
    }

    @Override
    public int getPort() {
        return this.uri.getPort();
    }

    @Override
    public String getPath() {
        return this.uri.getPath();
    }

    @Override
    public String getQuery() {
        return this.uri.getQuery();
    }

    @Override
    public String getFragment() {
        return this.uri.getFragment();
    }

    @Override
    public Path getCanonical() {
        if (this.isAbsolute()) {
            URI norm = this.uri.normalize();
            if (norm == this.uri) {
                return this;
            }
            return URIPath.valueOf(norm);
        }
        return this.getAbsolute().getCanonical();
    }

    public static String encodeForUri(String str, char mode) {
        StringBuffer sbuf = new StringBuffer();
        int len = str.length();
        int i = 0;
        while (i < len) {
            int ch;
            if ((ch = str.charAt(i++)) >= 55296 && ch < 56320 && i < len) {
                ch = (ch - 55296) * 1024 + (str.charAt(i++) - 56320) + 65536;
            }
            if (mode == 'H' ? ch >= 32 && ch <= 126 : ch >= 97 && ch <= 122 || ch >= 65 && ch <= 90 || ch >= 48 && ch <= 57 || ch == 45 || ch == 95 || ch == 46 || ch == 126 || mode == 'I' && (ch == 59 || ch == 47 || ch == 63 || ch == 58 || ch == 42 || ch == 39 || ch == 40 || ch == 41 || ch == 64 || ch == 38 || ch == 61 || ch == 43 || ch == 36 || ch == 44 || ch == 91 || ch == 93 || ch == 35 || ch == 33 || ch == 37)) {
                sbuf.append((char)ch);
                continue;
            }
            int pos = sbuf.length();
            int nbytes = 0;
            int needed = ch < 128 ? 1 : (ch < 2048 ? 2 : (ch < 65536 ? 3 : 4));
            do {
                int b;
                int availbits;
                int n = availbits = nbytes == 0 ? 7 : 6 - nbytes;
                if (ch < 1 << availbits) {
                    b = ch;
                    if (nbytes > 0) {
                        b |= 65408 >> nbytes & 255;
                    }
                    ch = 0;
                } else {
                    b = 128 | ch & 63;
                    ch >>= 6;
                }
                ++nbytes;
                for (int j = 0; j <= 1; ++j) {
                    int hex = b & 15;
                    sbuf.insert(pos, (char)(hex <= 9 ? hex + 48 : hex - 10 + 65));
                    b >>= 4;
                }
                sbuf.insert(pos, '%');
            } while (ch != 0);
        }
        return sbuf.toString();
    }
}

