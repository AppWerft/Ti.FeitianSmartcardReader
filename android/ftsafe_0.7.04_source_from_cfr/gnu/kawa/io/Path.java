/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.FilePath;
import gnu.kawa.io.URIPath;
import gnu.kawa.io.URLPath;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public abstract class Path {
    public static final FilePath userDirPath = FilePath.valueOf(System.getProperty("user.dir"));
    public static final ThreadLocal<Path> pathLocation = new InheritableThreadLocal<Path>(){

        @Override
        protected Path initialValue() {
            return Path.userDirPath;
        }

        @Override
        public void set(Path path) {
            if (path == null) {
                super.remove();
            } else {
                if (!path.isAbsolute()) {
                    path = path.getAbsolute();
                }
                super.set(path);
            }
        }
    };
    public static final Object PATH_CURRENT = new String("<current>");
    public static final Object PATH_RELATIVE = new String("<relative>");

    protected Path() {
    }

    public static Path currentPath() {
        return pathLocation.get();
    }

    public static void setCurrentPath(Path path) {
        pathLocation.set(path);
    }

    public static Path coerceToPathOrNull(Object path) {
        char ch0;
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
        String str = path.toString();
        if (str.startsWith("file:") || File.separatorChar == '\\' && str.length() >= 2 && str.charAt(1) == ':' && Character.isLetter(str.charAt(0)) || str.length() > 0 && ((ch0 = str.charAt(0)) == '.' || ch0 == File.separatorChar)) {
            return FilePath.valueOf(str);
        }
        return URIPath.valueOf(str);
    }

    public static Path valueOf(Object arg) {
        Path path = Path.coerceToPathOrNull(arg);
        if (path == null) {
            throw new WrongType((String)null, -4, arg, "path");
        }
        return path;
    }

    public static URL toURL(String str) {
        try {
            if (!Path.uriSchemeSpecified(str)) {
                Path cur = Path.currentPath();
                Path path = cur.resolve(str);
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

    public static int uriSchemeLength(String uri) {
        int len = uri.length();
        for (int i = 0; i < len; ++i) {
            char ch = uri.charAt(i);
            if (ch == ':') {
                return i;
            }
            if (!(i == 0 ? !Character.isLetter(ch) : !Character.isLetterOrDigit(ch) && ch != '+' && ch != '-' && ch != '.')) continue;
            return -1;
        }
        return -1;
    }

    public static boolean uriSchemeSpecified(String name) {
        int ulen = Path.uriSchemeLength(name);
        if (ulen == 1 && File.separatorChar == '\\') {
            char drive = name.charAt(0);
            return !(drive >= 'a' && drive <= 'z' || drive >= 'A' && drive <= 'Z');
        }
        return ulen > 0;
    }

    public abstract boolean isAbsolute();

    public boolean isDirectory() {
        char last;
        String str = this.toString();
        int len = str.length();
        return len > 0 && ((last = str.charAt(len - 1)) == '/' || last == File.separatorChar);
    }

    public boolean isPlainFile() {
        File file2 = this.toFile();
        if (file2 != null) {
            return file2.isFile();
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
        int len;
        String p = this.getPath();
        if (p == null) {
            return null;
        }
        int end = len = p.length();
        int i = len;
        do {
            if (--i <= 0) {
                return end == len ? p : p.substring(0, end);
            }
            char c = p.charAt(i);
            if (c != '/') continue;
            if (i + 1 != len) break;
            end = i;
        } while (true);
        return p.substring(i + 1, end);
    }

    public String getExtension() {
        int len;
        boolean sawDot;
        String p = this.getPath();
        if (p == null) {
            return null;
        }
        int i = len = p.length();
        do {
            if (--i <= 0) {
                return null;
            }
            char c = p.charAt(i);
            sawDot = false;
            if (c == '.') {
                c = p.charAt(i - 1);
                sawDot = true;
            }
            if (c != '/' && (!(this instanceof FilePath) || c != File.separatorChar)) continue;
            return null;
        } while (!sawDot);
        return p.substring(i + 1);
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

    public Path resolve(Path relative) {
        if (relative.isAbsolute()) {
            return relative;
        }
        return this.resolve(relative.toString());
    }

    public abstract Path resolve(String var1);

    public static InputStream openInputStream(Object uri) throws IOException {
        return Path.valueOf(uri).openInputStream();
    }

    public abstract InputStream openInputStream() throws IOException;

    public abstract OutputStream openOutputStream() throws IOException;

    public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
        throw new UnsupportedOperationException();
    }

    public Writer openWriter() throws IOException {
        return new OutputStreamWriter(this.openOutputStream());
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        byte[] bytes = this.readAllBytes();
        return new String(bytes, System.getProperty("sun.jnu.encoding", "UTF-8"));
    }

    public byte[] readAllBytes() throws IOException {
        int cnt;
        long len = this.getContentLength();
        if (len > 0x7FFFFFF7L) {
            throw new Error("path contents too big");
        }
        int ilen = (int)len;
        byte[] buffer = new byte[ilen < 0 ? 8192 : ilen];
        InputStream in = this.openInputStream();
        for (int sofar = 0; sofar < ilen || ilen < 0; sofar += cnt) {
            if (sofar == buffer.length) {
                byte[] tmp = new byte[sofar * 3 >> 1];
                System.arraycopy(buffer, 0, tmp, 0, sofar);
                buffer = tmp;
            }
            if ((cnt = in.read(buffer, sofar, buffer.length - sofar)) > 0) continue;
            if (ilen < 0) break;
            throw new IOException("unable to read enture file");
        }
        return buffer;
    }

    public static String relativize(String in, String base2) throws URISyntaxException, IOException {
        int i;
        char cb;
        char ci;
        String baseStr = base2;
        String inStr = in;
        baseStr = new URI(baseStr).normalize().toString();
        inStr = URLPath.valueOf(in).toURI().normalize().toString();
        int baseLen = baseStr.length();
        int inLen = inStr.length();
        int sl = 0;
        int colon = 0;
        for (i = 0; i < baseLen && i < inLen && (cb = baseStr.charAt(i)) == (ci = inStr.charAt(i)); ++i) {
            if (cb == '/') {
                sl = i;
            }
            if (cb != ':') continue;
            colon = i;
        }
        if (colon <= 0 || sl <= colon + 2 && baseLen > colon + 2 && baseStr.charAt(colon + 2) == '/') {
            return in;
        }
        baseStr = baseStr.substring(sl + 1);
        inStr = inStr.substring(sl + 1);
        StringBuilder sbuf = new StringBuilder();
        sl = 0;
        i = baseLen = baseStr.length();
        while (--i >= 0) {
            if (baseStr.charAt(i) != '/') continue;
            sbuf.append("../");
        }
        sbuf.append(inStr);
        return sbuf.toString();
    }

    public String getName() {
        return this.toString();
    }

    public Path getAbsolute() {
        if (this == userDirPath) {
            return this.resolve(".");
        }
        return Path.currentPath().resolve(this);
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
            int bang;
            String p = this.getPath();
            if (p == null) {
                p = this.toString();
            }
            if (p.startsWith("jar:") && (bang = p.indexOf(33)) > 0) {
                p = p.substring(bang + 1);
            }
            if ((contentType = URLConnection.guessContentTypeFromName(p)) == null) {
                if (p.endsWith(".xhtml")) {
                    contentType = "application/xhtml+xml";
                } else if (p.endsWith(".css")) {
                    contentType = "text/css";
                } else if (p.endsWith(".js")) {
                    contentType = "application/javascript";
                }
            }
        }
        return contentType;
    }

    public static Object[] search(Object[] searchPath, String filename, String base2) {
        for (int i = 0; i < searchPath.length; ++i) {
            Object spath = searchPath[i];
            if (spath == PATH_RELATIVE) {
                String tpath = base2;
                spath = tpath == null || tpath.startsWith("/dev/") ? PATH_CURRENT : tpath;
            }
            Path path = spath == PATH_CURRENT ? Path.currentPath() : Path.valueOf(spath);
            try {
                InputStream istrm = path.resolve(filename).openInputStream();
                return new Object[]{istrm, path};
            }
            catch (Exception ex) {
                continue;
            }
        }
        return null;
    }

}

