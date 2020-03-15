// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.net.URLConnection;
import java.net.URISyntaxException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.Reader;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.net.URI;
import java.net.URL;

public abstract class Path
{
    public static final FilePath userDirPath;
    public static final ThreadLocal<Path> pathLocation;
    public static final Object PATH_CURRENT;
    public static final Object PATH_RELATIVE;
    
    protected Path() {
    }
    
    public static Path currentPath() {
        return Path.pathLocation.get();
    }
    
    public static void setCurrentPath(final Path path) {
        Path.pathLocation.set(path);
    }
    
    public static Path coerceToPathOrNull(final Object path) {
        if (path instanceof Path) {
            return (Path)path;
        }
        if (path instanceof URL) {
            return URLPath.valueOf((URL)path);
        }
        if (path instanceof URI) {
            return URIPath.valueOf((URI)path);
        }
        if (path instanceof File) {
            return FilePath.valueOf((File)path);
        }
        if (!(path instanceof CharSequence)) {
            return null;
        }
        final String str = path.toString();
        final char ch0;
        if (str.startsWith("file:") || (File.separatorChar == '\\' && str.length() >= 2 && str.charAt(1) == ':' && Character.isLetter(str.charAt(0))) || (str.length() > 0 && ((ch0 = str.charAt(0)) == '.' || ch0 == File.separatorChar))) {
            return FilePath.valueOf(str);
        }
        return URIPath.valueOf(str);
    }
    
    public static Path valueOf(final Object arg) {
        final Path path = coerceToPathOrNull(arg);
        if (path == null) {
            throw new WrongType((String)null, -4, arg, "path");
        }
        return path;
    }
    
    public static URL toURL(String str) {
        try {
            if (!uriSchemeSpecified(str)) {
                final Path cur = currentPath();
                final Path path = cur.resolve(str);
                if (path.isAbsolute()) {
                    return path.toURL();
                }
                str = path.toString();
            }
            return new URL(str);
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }
    
    public static int uriSchemeLength(final String uri) {
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
    
    public static boolean uriSchemeSpecified(final String name) {
        final int ulen = uriSchemeLength(name);
        if (ulen == 1 && File.separatorChar == '\\') {
            final char drive = name.charAt(0);
            return (drive < 'a' || drive > 'z') && (drive < 'A' || drive > 'Z');
        }
        return ulen > 0;
    }
    
    public abstract boolean isAbsolute();
    
    public boolean isDirectory() {
        final String str = this.toString();
        final int len = str.length();
        if (len > 0) {
            final char last = str.charAt(len - 1);
            if (last == '/' || last == File.separatorChar) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isPlainFile() {
        final File file = this.toFile();
        if (file != null) {
            return file.isFile();
        }
        return !this.isDirectory() && this.getPath() != null;
    }
    
    public boolean delete() {
        try {
            this.deleteFile();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public void deleteFile() throws IOException {
        throw new UnsupportedOperationException();
    }
    
    public boolean exists() {
        return this.getLastModified() != 0L;
    }
    
    public abstract long getLastModified();
    
    public long getContentLength() {
        return -1L;
    }
    
    public abstract String getScheme();
    
    public String getAuthority() {
        return null;
    }
    
    public String getUserInfo() {
        return null;
    }
    
    public String getHost() {
        return null;
    }
    
    public abstract String getPath();
    
    public Path getDirectory() {
        if (this.isDirectory()) {
            return this;
        }
        return this.resolve(".");
    }
    
    public Path getParent() {
        return this.resolve(this.isDirectory() ? ".." : ".");
    }
    
    public String getLast() {
        final String p = this.getPath();
        if (p == null) {
            return null;
        }
        int end;
        int i;
        final int len = i = (end = p.length());
        while (--i > 0) {
            final char c = p.charAt(i);
            if (c == '/') {
                if (i + 1 != len) {
                    return p.substring(i + 1, end);
                }
                end = i;
            }
        }
        return (end == len) ? p : p.substring(0, end);
    }
    
    public String getExtension() {
        final String p = this.getPath();
        if (p == null) {
            return null;
        }
        int i;
        final int len = i = p.length();
        while (--i > 0) {
            char c = p.charAt(i);
            boolean sawDot = false;
            if (c == '.') {
                c = p.charAt(i - 1);
                sawDot = true;
            }
            if (c == '/' || (this instanceof FilePath && c == File.separatorChar)) {
                return null;
            }
            if (sawDot) {
                return p.substring(i + 1);
            }
        }
        return null;
    }
    
    public int getPort() {
        return -1;
    }
    
    public String getQuery() {
        return null;
    }
    
    public String getFragment() {
        return null;
    }
    
    public abstract URL toURL();
    
    public abstract URI toUri();
    
    public final URI toURI() {
        return this.toUri();
    }
    
    public String toURIString() {
        return this.toUri().toString();
    }
    
    public Path resolve(final Path relative) {
        if (relative.isAbsolute()) {
            return relative;
        }
        return this.resolve(relative.toString());
    }
    
    public abstract Path resolve(final String p0);
    
    public static InputStream openInputStream(final Object uri) throws IOException {
        return valueOf(uri).openInputStream();
    }
    
    public abstract InputStream openInputStream() throws IOException;
    
    public abstract OutputStream openOutputStream() throws IOException;
    
    public Reader openReader(final boolean ignoreEncodingErrors) throws IOException {
        throw new UnsupportedOperationException();
    }
    
    public Writer openWriter() throws IOException {
        return new OutputStreamWriter(this.openOutputStream());
    }
    
    public CharSequence getCharContent(final boolean ignoreEncodingErrors) throws IOException {
        final byte[] bytes = this.readAllBytes();
        return new String(bytes, System.getProperty("sun.jnu.encoding", "UTF-8"));
    }
    
    public byte[] readAllBytes() throws IOException {
        final long len = this.getContentLength();
        if (len > 2147483639L) {
            throw new Error("path contents too big");
        }
        final int ilen = (int)len;
        byte[] buffer = new byte[(ilen < 0) ? 8192 : ilen];
        int sofar = 0;
        final InputStream in = this.openInputStream();
        while (sofar < ilen || ilen < 0) {
            if (sofar == buffer.length) {
                final byte[] tmp = new byte[sofar * 3 >> 1];
                System.arraycopy(buffer, 0, tmp, 0, sofar);
                buffer = tmp;
            }
            final int cnt = in.read(buffer, sofar, buffer.length - sofar);
            if (cnt <= 0) {
                if (ilen < 0) {
                    break;
                }
                throw new IOException("unable to read enture file");
            }
            else {
                sofar += cnt;
            }
        }
        return buffer;
    }
    
    public static String relativize(final String in, final String base) throws URISyntaxException, IOException {
        String baseStr = base;
        String inStr = in;
        baseStr = new URI(baseStr).normalize().toString();
        inStr = URIPath.valueOf(in).toURI().normalize().toString();
        int baseLen = baseStr.length();
        final int inLen = inStr.length();
        int i = 0;
        int sl = 0;
        int colon = 0;
        while (i < baseLen && i < inLen) {
            final char cb = baseStr.charAt(i);
            final char ci = inStr.charAt(i);
            if (cb != ci) {
                break;
            }
            if (cb == '/') {
                sl = i;
            }
            if (cb == ':') {
                colon = i;
            }
            ++i;
        }
        if (colon > 0 && (sl > colon + 2 || baseLen <= colon + 2 || baseStr.charAt(colon + 2) != '/')) {
            baseStr = baseStr.substring(sl + 1);
            inStr = inStr.substring(sl + 1);
            final StringBuilder sbuf = new StringBuilder();
            sl = 0;
            baseLen = (i = baseStr.length());
            while (--i >= 0) {
                if (baseStr.charAt(i) == '/') {
                    sbuf.append("../");
                }
            }
            sbuf.append(inStr);
            return sbuf.toString();
        }
        return in;
    }
    
    public String getName() {
        return this.toString();
    }
    
    public Path getAbsolute() {
        if (this == Path.userDirPath) {
            return this.resolve(".");
        }
        return currentPath().resolve(this);
    }
    
    public Path getCanonical() {
        return this.getAbsolute();
    }
    
    public File toFile() {
        return null;
    }
    
    public String probeContentType() {
        String contentType = null;
        if (contentType == null) {
            String p = this.getPath();
            if (p == null) {
                p = this.toString();
            }
            if (p.startsWith("jar:")) {
                final int bang = p.indexOf(33);
                if (bang > 0) {
                    p = p.substring(bang + 1);
                }
            }
            contentType = URLConnection.guessContentTypeFromName(p);
            if (contentType == null) {
                if (p.endsWith(".xhtml")) {
                    contentType = "application/xhtml+xml";
                }
                else if (p.endsWith(".css")) {
                    contentType = "text/css";
                }
                else if (p.endsWith(".js")) {
                    contentType = "application/javascript";
                }
            }
        }
        return contentType;
    }
    
    public static Object[] search(final Object[] searchPath, final String filename, final String base) {
        int i = 0;
        while (i < searchPath.length) {
            Object spath = searchPath[i];
            if (spath == Path.PATH_RELATIVE) {
                final String tpath = base;
                if (tpath == null || tpath.startsWith("/dev/")) {
                    spath = Path.PATH_CURRENT;
                }
                else {
                    spath = tpath;
                }
            }
            Path path;
            if (spath == Path.PATH_CURRENT) {
                path = currentPath();
            }
            else {
                path = valueOf(spath);
            }
            try {
                final InputStream istrm = path.resolve(filename).openInputStream();
                return new Object[] { istrm, path };
            }
            catch (Exception ex) {
                ++i;
                continue;
            }
            break;
        }
        return null;
    }
    
    static {
        userDirPath = FilePath.valueOf(System.getProperty("user.dir"));
        pathLocation = new InheritableThreadLocal<Path>() {
            @Override
            protected Path initialValue() {
                return Path.userDirPath;
            }
            
            @Override
            public void set(Path path) {
                if (path == null) {
                    super.remove();
                }
                else {
                    if (!path.isAbsolute()) {
                        path = path.getAbsolute();
                    }
                    super.set(path);
                }
            }
        };
        PATH_CURRENT = new String("<current>");
        PATH_RELATIVE = new String("<relative>");
    }
}
