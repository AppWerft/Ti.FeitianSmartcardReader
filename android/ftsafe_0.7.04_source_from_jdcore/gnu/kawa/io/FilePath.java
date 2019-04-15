package gnu.kawa.io;

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
  implements Comparable<FilePath>
{
  final File file;
  final String path;
  
  private FilePath(File file)
  {
    this.file = file;
    path = file.toString();
  }
  
  private FilePath(File file, String path)
  {
    this.file = file;
    this.path = path;
  }
  
  public static FilePath valueOf(String str) {
    String orig = str;
    







    File f;
    






    if (str.startsWith("file:")) {
      try {
        f = new File(new URI(str));
      } catch (URISyntaxException ex) {
        throw new RuntimeException("bad file: URI syntax - " + str, ex);
      }
    } else
      f = new File(str);
    return new FilePath(f, orig);
  }
  
  public static FilePath valueOf(File file) {
    return new FilePath(file);
  }
  
  public static FilePath valueOf(URI uri) {
    if (uri.isAbsolute())
      return valueOf(new File(uri));
    String ustr = uri.toString();
    char sep = File.separatorChar;
    if (sep != '/')
      ustr = ustr.replace('/', sep);
    return new FilePath(new File(ustr));
  }
  
  public static FilePath coerceToFilePathOrNull(Object path) {
    if ((path instanceof FilePath))
      return (FilePath)path;
    if ((path instanceof URIPath))
      path = uri;
    if ((path instanceof URI))
      return valueOf((URI)path);
    if ((path instanceof File))
      return valueOf((File)path);
    String str;
    if ((path instanceof CharSequence)) {
      str = path.toString();
    } else
      return null;
    String str; return valueOf(str);
  }
  
  public static FilePath makeFilePath(Object arg) {
    FilePath path = coerceToFilePathOrNull(arg);
    if (path == null) {
      throw new WrongType((String)null, -4, arg, "filepath");
    }
    return path;
  }
  
  public boolean isAbsolute() {
    return (this == Path.userDirPath) || (file.isAbsolute());
  }
  




  public boolean isDirectory()
  {
    int len = path.length();
    if (len > 0) {
      char last = path.charAt(len - 1);
      if ((last == '/') || (last == File.separatorChar))
        return true;
    }
    return toFile().isDirectory();
  }
  


  public void deleteFile()
    throws IOException
  {
    if (!toFile().delete()) {
      throw new IOException("cannot delete - " + this);
    }
  }
  
  public long getLastModified()
  {
    return toFile().lastModified();
  }
  
  public boolean exists()
  {
    return toFile().exists();
  }
  
  public long getContentLength()
  {
    File f = toFile();
    long length = f.length();
    return (length == 0L) && (!f.exists()) ? -1L : length;
  }
  
  public String getPath()
  {
    return file.getPath();
  }
  
  public String getLast()
  {
    return file.getName();
  }
  






  public FilePath getParent()
  {
    File parent = file.getParentFile();
    if (parent == null) {
      return null;
    }
    return valueOf(parent);
  }
  
  public int compareTo(FilePath path)
  {
    return file.compareTo(file);
  }
  







  public boolean equals(Object obj)
  {
    return ((obj instanceof FilePath)) && (file.equals(file));
  }
  
  public int hashCode()
  {
    return file.hashCode();
  }
  
  public String toString()
  {
    return path;
  }
  
  public File toFileRaw()
  {
    return file;
  }
  
  public File toFile() {
    if (file.isAbsolute())
      return file;
    Path cur = currentPath();
    if (cur == userDirPath)
      return file;
    return ((FilePath)cur.resolve(this)).toFileRaw();
  }
  
  public URL toURL()
  {
    if (!isAbsolute()) {
      return getAbsolute().toURL();
    }
    try {
      return file.toURI().toURL();
    }
    catch (Exception ex)
    {
      throw WrappedException.wrapIfNeeded(ex);
    }
  }
  
  public URI toUri() {
    try {
      if (file.isAbsolute()) {
        return file.toURI();
      }
      
      String fname = path;
      char fileSep = File.separatorChar;
      if (fileSep != '/')
        fname = fname.replace(fileSep, '/');
      int len = fname.length();
      if ((len > 0) && (fname.charAt(len - 1) != '/') && (isDirectory()))
      {
        fname = fname + '/'; }
      return new URI(null, null, fname, null);
    } catch (Exception ex) {
      throw WrappedException.wrapIfNeeded(ex);
    }
  }
  
  public InputStream openInputStream() throws IOException {
    return new FileInputStream(toFile());
  }
  
  public OutputStream openOutputStream() throws IOException {
    return new FileOutputStream(toFile());
  }
  
  public OutputStream openAppendStream() throws IOException {
    return new FileOutputStream(toFile(), true);
  }
  
  public String getScheme() {
    return isAbsolute() ? "file" : null;
  }
  
  public Path resolve(String relative) {
    if (Path.uriSchemeSpecified(relative)) {
      if (relative.startsWith("file:")) {
        return valueOf(relative);
      }
      return URLPath.valueOf(relative);
    }
    if (relative.length() == 0)
      return this;
    File rfile = new File(relative);
    if (!rfile.isAbsolute()) {
      rfile = new File(isDirectory() ? file : file.getParentFile(), rfile.toString());
    }
    return new FilePath(rfile);
  }
  
  public Path getCanonical()
  {
    try
    {
      File canon = file.getCanonicalFile();
      if (!canon.equals(file)) {
        return valueOf(canon);
      }
    }
    catch (Exception ex) {}
    
    return this;
  }
}
