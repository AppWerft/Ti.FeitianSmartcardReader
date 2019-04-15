/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.io.URLPath;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class FilePath
extends Path
implements Comparable<FilePath> {
    final File file;
    final String path;

    private FilePath(File file2) {
        this.file = file2;
        this.path = file2.toString();
    }

    private FilePath(File file2, String path) {
        this.file = file2;
        this.path = path;
    }

    public static FilePath valueOf(String str) {
        File f;
        String orig = str;
        if (str.startsWith("file:")) {
            try {
                f = new File(new URI(str));
            }
            catch (URISyntaxException ex) {
                throw new RuntimeException("bad file: URI syntax - " + str, ex);
            }
        } else {
            f = new File(str);
        }
        return new FilePath(f, orig);
    }

    public static FilePath valueOf(File file2) {
        return new FilePath(file2);
    }

    public static FilePath valueOf(URI uri) {
        if (uri.isAbsolute()) {
            return FilePath.valueOf(new File(uri));
        }
        String ustr = uri.toString();
        char sep = File.separatorChar;
        if (sep != '/') {
            ustr = ustr.replace('/', sep);
        }
        return new FilePath(new File(ustr));
    }

    public static FilePath coerceToFilePathOrNull(Object path) {
        if (path instanceof FilePath) {
            return (FilePath)path;
        }
        if (path instanceof URIPath) {
            path = ((URIPath)path).uri;
        }
        if (path instanceof URI) {
            return FilePath.valueOf((URI)path);
        }
        if (path instanceof File) {
            return FilePath.valueOf((File)path);
        }
        if (!(path instanceof CharSequence)) {
            return null;
        }
        String str = path.toString();
        return FilePath.valueOf(str);
    }

    public static FilePath makeFilePath(Object arg) {
        FilePath path = FilePath.coerceToFilePathOrNull(arg);
        if (path == null) {
            throw new WrongType((String)null, -4, arg, "filepath");
        }
        return path;
    }

    @Override
    public boolean isAbsolute() {
        return this == Path.userDirPath || this.file.isAbsolute();
    }

    @Override
    public boolean isDirectory() {
        char last;
        int len = this.path.length();
        if (len > 0 && ((last = this.path.charAt(len - 1)) == '/' || last == File.separatorChar)) {
            return true;
        }
        return this.toFile().isDirectory();
    }

    @Override
    public void deleteFile() throws IOException {
        if (!this.toFile().delete()) {
            throw new IOException("cannot delete - " + this);
        }
    }

    @Override
    public long getLastModified() {
        return this.toFile().lastModified();
    }

    @Override
    public boolean exists() {
        return this.toFile().exists();
    }

    @Override
    public long getContentLength() {
        File f = this.toFile();
        long length = f.length();
        return length == 0L && !f.exists() ? -1L : length;
    }

    @Override
    public String getPath() {
        return this.file.getPath();
    }

    @Override
    public String getLast() {
        return this.file.getName();
    }

    @Override
    public FilePath getParent() {
        File parent = this.file.getParentFile();
        if (parent == null) {
            return null;
        }
        return FilePath.valueOf(parent);
    }

    @Override
    public int compareTo(FilePath path) {
        return this.file.compareTo(path.file);
    }

    public boolean equals(Object obj) {
        return obj instanceof FilePath && this.file.equals(((FilePath)obj).file);
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    public String toString() {
        return this.path;
    }

    public File toFileRaw() {
        return this.file;
    }

    @Override
    public File toFile() {
        if (this.file.isAbsolute()) {
            return this.file;
        }
        Path cur = FilePath.currentPath();
        if (cur == userDirPath) {
            return this.file;
        }
        return ((FilePath)cur.resolve(this)).toFileRaw();
    }

    @Override
    public URL toURL() {
        if (!this.isAbsolute()) {
            return this.getAbsolute().toURL();
        }
        try {
            return this.file.toURI().toURL();
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    @Override
    public URI toUri() {
        try {
            int len;
            if (this.file.isAbsolute()) {
                return this.file.toURI();
            }
            String fname = this.path;
            char fileSep = File.separatorChar;
            if (fileSep != '/') {
                fname = fname.replace(fileSep, '/');
            }
            if ((len = fname.length()) > 0 && fname.charAt(len - 1) != '/' && this.isDirectory()) {
                fname = fname + '/';
            }
            return new URI(null, null, fname, null);
        }
        catch (Exception ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    @Override
    public InputStream openInputStream() throws IOException {
        return new FileInputStream(this.toFile());
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return new FileOutputStream(this.toFile());
    }

    public OutputStream openAppendStream() throws IOException {
        return new FileOutputStream(this.toFile(), true);
    }

    @Override
    public String getScheme() {
        return this.isAbsolute() ? "file" : null;
    }

    @Override
    public Path resolve(String relative) {
        if (Path.uriSchemeSpecified(relative)) {
            if (relative.startsWith("file:")) {
                return FilePath.valueOf(relative);
            }
            return URLPath.valueOf(relative);
        }
        if (relative.length() == 0) {
            return this;
        }
        File rfile = new File(relative);
        if (!rfile.isAbsolute()) {
            rfile = new File(this.isDirectory() ? this.file : this.file.getParentFile(), rfile.toString());
        }
        return new FilePath(rfile);
    }

    @Override
    public Path getCanonical() {
        try {
            File canon = this.file.getCanonicalFile();
            if (!canon.equals(this.file)) {
                return FilePath.valueOf(canon);
            }
        }
        catch (Exception ex) {
            // empty catch block
        }
        return this;
    }
}

