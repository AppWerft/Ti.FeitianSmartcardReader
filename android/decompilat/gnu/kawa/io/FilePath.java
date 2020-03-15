// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import gnu.mapping.WrappedException;
import java.net.URL;
import java.io.IOException;
import gnu.mapping.WrongType;
import java.net.URISyntaxException;
import java.net.URI;
import java.io.File;

public class FilePath extends Path implements Comparable<FilePath>
{
    final File file;
    final String path;
    
    private FilePath(final File file) {
        this.file = file;
        this.path = file.toString();
    }
    
    private FilePath(final File file, final String path) {
        this.file = file;
        this.path = path;
    }
    
    public static FilePath valueOf(final String str) {
        final String orig = str;
        if (str.startsWith("file:")) {
            try {
                final File f = new File(new URI(str));
                return new FilePath(f, orig);
            }
            catch (URISyntaxException ex) {
                throw new RuntimeException("bad file: URI syntax - " + str, ex);
            }
        }
        final File f = new File(str);
        return new FilePath(f, orig);
    }
    
    public static FilePath valueOf(final File file) {
        return new FilePath(file);
    }
    
    public static FilePath valueOf(final URI uri) {
        if (uri.isAbsolute()) {
            return valueOf(new File(uri));
        }
        String ustr = uri.toString();
        final char sep = File.separatorChar;
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
            return valueOf((URI)path);
        }
        if (path instanceof File) {
            return valueOf((File)path);
        }
        if (path instanceof CharSequence) {
            final String str = path.toString();
            return valueOf(str);
        }
        return null;
    }
    
    public static FilePath makeFilePath(final Object arg) {
        final FilePath path = coerceToFilePathOrNull(arg);
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
        final int len = this.path.length();
        if (len > 0) {
            final char last = this.path.charAt(len - 1);
            if (last == '/' || last == File.separatorChar) {
                return true;
            }
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
        final File f = this.toFile();
        final long length = f.length();
        return (length == 0L && !f.exists()) ? -1L : length;
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
        final File parent = this.file.getParentFile();
        if (parent == null) {
            return null;
        }
        return valueOf(parent);
    }
    
    @Override
    public int compareTo(final FilePath path) {
        return this.file.compareTo(path.file);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof FilePath && this.file.equals(((FilePath)obj).file);
    }
    
    @Override
    public int hashCode() {
        return this.file.hashCode();
    }
    
    @Override
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
        final Path cur = Path.currentPath();
        if (cur == FilePath.userDirPath) {
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
            if (this.file.isAbsolute()) {
                return this.file.toURI();
            }
            String fname = this.path;
            final char fileSep = File.separatorChar;
            if (fileSep != '/') {
                fname = fname.replace(fileSep, '/');
            }
            final int len = fname.length();
            if (len > 0 && fname.charAt(len - 1) != '/' && this.isDirectory()) {
                fname += '/';
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
    public Path resolve(final String relative) {
        if (Path.uriSchemeSpecified(relative)) {
            if (relative.startsWith("file:")) {
                return valueOf(relative);
            }
            return URIPath.valueOf(relative);
        }
        else {
            if (relative.length() == 0) {
                return this;
            }
            File rfile = new File(relative);
            if (!rfile.isAbsolute()) {
                rfile = new File(this.isDirectory() ? this.file : this.file.getParentFile(), rfile.toString());
            }
            return new FilePath(rfile);
        }
    }
    
    @Override
    public Path getCanonical() {
        try {
            final File canon = this.file.getCanonicalFile();
            if (!canon.equals(this.file)) {
                return valueOf(canon);
            }
        }
        catch (Exception ex) {}
        return this;
    }
}
