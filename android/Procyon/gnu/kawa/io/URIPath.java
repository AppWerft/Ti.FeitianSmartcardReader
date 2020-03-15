// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.net.URL;
import java.net.URI;

public class URIPath extends Path implements Comparable<URIPath>
{
    final URI uri;
    
    URIPath(final URI uri) {
        this.uri = uri;
    }
    
    public static URIPath coerceToURIPathOrNull(final Object path) {
        if (path instanceof URIPath) {
            return (URIPath)path;
        }
        if (path instanceof URL) {
            return URLPath.valueOf((URL)path);
        }
        if (path instanceof URI) {
            return valueOf((URI)path);
        }
        if (path instanceof CharSequence || path instanceof File || path instanceof Path) {
            final String str = path.toString();
            return valueOf(str);
        }
        return null;
    }
    
    public static URIPath makeURI(final Object arg) {
        final URIPath path = coerceToURIPathOrNull(arg);
        if (path == null) {
            throw new WrongType((String)null, -4, arg, "URI");
        }
        return path;
    }
    
    public static URIPath valueOf(final URI uri) {
        return new URIPath(uri);
    }
    
    public static URIPath valueOf(final String uri) {
        try {
            return new URIStringPath(new URI(encodeForUri(uri, 'I')), uri);
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
            final URLConnection conn = this.toURL().openConnection();
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
        final char fileSep = File.separatorChar;
        if (fileSep != '/') {
            if (rstr.length() >= 2 && ((rstr.charAt(1) == ':' && Character.isLetter(rstr.charAt(0))) || (rstr.charAt(0) == fileSep && rstr.charAt(1) == fileSep))) {
                return FilePath.valueOf(new File(rstr));
            }
            rstr = rstr.replace(fileSep, '/');
        }
        return valueOf(this.resolveToUri(rstr));
    }
    
    public URI resolveToUri(final String rstr) {
        try {
            final URI r = new URI(rstr);
            if (this.uri.isOpaque()) {
                return r;
            }
            final String bScheme = this.getScheme();
            final String bAuthority = this.getAuthority();
            final String bPath = this.getPath();
            final String bQuery = this.getQuery();
            final String bFragment = this.getFragment();
            final String rScheme = r.getScheme();
            final String rAuthority = r.getAuthority();
            final String rPath = r.getPath();
            final String rQuery = r.getQuery();
            final String rFragment = r.getFragment();
            final String tScheme = (rScheme != null) ? rScheme : bScheme;
            boolean removeDotsNeeded = true;
            String tAuthority;
            String tPath;
            String tQuery;
            if (rScheme != null || rAuthority != null) {
                tAuthority = rAuthority;
                tPath = rPath;
                tQuery = rQuery;
            }
            else {
                tAuthority = bAuthority;
                if (rPath == null || rPath.length() == 0) {
                    tPath = bPath;
                    removeDotsNeeded = false;
                    tQuery = ((rQuery != null) ? rQuery : bQuery);
                }
                else {
                    if (rPath.charAt(0) == '/') {
                        tPath = rPath;
                    }
                    else if (bAuthority != null && bPath.length() == 0) {
                        tPath = "/" + rPath;
                    }
                    else {
                        final int bSlash = bPath.lastIndexOf(47);
                        if (bSlash >= 0) {
                            tPath = bPath.substring(0, bSlash + 1) + rPath;
                        }
                        else {
                            tPath = rPath;
                        }
                    }
                    tQuery = rQuery;
                }
            }
            final int len = tPath.length();
            if (removeDotsNeeded && len > 0) {
                final StringBuilder pbuf = new StringBuilder();
                int ch0 = tPath.charAt(0);
                int i = 1;
                while (ch0 >= 0) {
                    if (ch0 == 46 && i + 1 < len && tPath.charAt(i) == '.' && tPath.charAt(i + 1) == '/') {
                        if (tScheme != null) {
                            ch0 = ((i + 2 < len) ? tPath.charAt(i + 2) : -1);
                            i += 3;
                        }
                        else {
                            pbuf.append("..");
                            ch0 = 47;
                            i += 2;
                        }
                    }
                    else if (ch0 == 46 && i < len && tPath.charAt(i) == '/') {
                        ch0 = ((i + 1 < len) ? tPath.charAt(i + 1) : -1);
                        i += 2;
                    }
                    else if (ch0 == 47 && i < len && tPath.charAt(i) == '.' && (i + 1 == len || tPath.charAt(i + 1) == '/')) {
                        ch0 = 47;
                        i = ((i + 1 == len) ? len : (i + 2));
                    }
                    else if (ch0 == 47 && i + 1 < len && tPath.charAt(i) == '.' && tPath.charAt(i + 1) == '.' && (i + 2 == len || tPath.charAt(i + 2) == '/')) {
                        ch0 = 47;
                        i = ((i + 2 == len) ? len : (i + 3));
                        int plen = pbuf.length();
                        while (plen > 0 && pbuf.charAt(--plen) != '/') {}
                        pbuf.setLength(plen);
                    }
                    else if (ch0 == 46 && (i == len || (i + 1 == len && tPath.charAt(i) == '.'))) {
                        ch0 = -1;
                    }
                    else {
                        do {
                            pbuf.append((char)ch0);
                            if (i == len) {
                                ch0 = -1;
                                break;
                            }
                            ch0 = tPath.charAt(i++);
                        } while (ch0 != 47);
                    }
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
    public int compareTo(final URIPath path) {
        return this.uri.compareTo(path.uri);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof URIPath && this.uri.equals(((URIPath)obj).uri);
    }
    
    @Override
    public int hashCode() {
        return this.uri.hashCode();
    }
    
    @Override
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
        if (!this.isAbsolute()) {
            return this.getAbsolute().getCanonical();
        }
        final URI norm = this.uri.normalize();
        if (norm == this.uri) {
            return this;
        }
        return valueOf(norm);
    }
    
    public static String encodeForUri(final String str, final char mode) {
        final StringBuffer sbuf = new StringBuffer();
        final int len = str.length();
        int i = 0;
        while (i < len) {
            int ch = str.charAt(i++);
            if (ch >= 55296 && ch < 56320 && i < len) {
                ch = (ch - 55296) * 1024 + (str.charAt(i++) - '\udc00') + 65536;
            }
            Label_0323: {
                if (mode == 'H') {
                    if (ch < 32 || ch > 126) {
                        break Label_0323;
                    }
                }
                else if ((ch < 97 || ch > 122) && (ch < 65 || ch > 90) && (ch < 48 || ch > 57) && ch != 45 && ch != 95 && ch != 46 && ch != 126 && (mode != 'I' || (ch != 59 && ch != 47 && ch != 63 && ch != 58 && ch != 42 && ch != 39 && ch != 40 && ch != 41 && ch != 64 && ch != 38 && ch != 61 && ch != 43 && ch != 36 && ch != 44 && ch != 91 && ch != 93 && ch != 35 && ch != 33 && ch != 37))) {
                    break Label_0323;
                }
                sbuf.append((char)ch);
                continue;
            }
            final int pos = sbuf.length();
            int nbytes = 0;
            final int needed = (ch < 128) ? 1 : ((ch < 2048) ? 2 : ((ch < 65536) ? 3 : 4));
            do {
                final int availbits = (nbytes == 0) ? 7 : (6 - nbytes);
                int b;
                if (ch < 1 << availbits) {
                    b = ch;
                    if (nbytes > 0) {
                        b |= (65408 >> nbytes & 0xFF);
                    }
                    ch = 0;
                }
                else {
                    b = (0x80 | (ch & 0x3F));
                    ch >>= 6;
                }
                ++nbytes;
                for (int j = 0; j <= 1; ++j) {
                    final int hex = b & 0xF;
                    sbuf.insert(pos, (char)((hex <= 9) ? (hex + 48) : (hex - 10 + 65)));
                    b >>= 4;
                }
                sbuf.insert(pos, '%');
            } while (ch != 0);
        }
        return sbuf.toString();
    }
}
