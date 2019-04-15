package gnu.kawa.io;

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





public abstract class Path
{
  public static final FilePath userDirPath = FilePath.valueOf(System.getProperty("user.dir"));
  






  public static final ThreadLocal<Path> pathLocation = new InheritableThreadLocal()
  {
    protected Path initialValue() {
      return Path.userDirPath;
    }
    
    public void set(Path path) {
      if (path == null) {
        super.remove();
      } else {
        if (!path.isAbsolute())
          path = path.getAbsolute();
        super.set(path);
      }
    }
  };
  
  protected Path() {}
  
  public static Path currentPath()
  {
    return (Path)pathLocation.get();
  }
  
  public static void setCurrentPath(Path path) {
    pathLocation.set(path);
  }
  
  public static Path coerceToPathOrNull(Object path) {
    if ((path instanceof Path))
      return (Path)path;
    if ((path instanceof URL)) {
      return URLPath.valueOf((URL)path);
    }
    if ((path instanceof URI)) {
      return URIPath.valueOf((URI)path);
    }
    if ((path instanceof File))
      return FilePath.valueOf((File)path);
    String str;
    if ((path instanceof CharSequence)) {
      str = path.toString();
    } else
      return null;
    String str;
    char ch0; if ((str.startsWith("file:")) || ((File.separatorChar == '\\') && (str.length() >= 2) && (str.charAt(1) == ':') && (Character.isLetter(str.charAt(0)))) || ((str.length() > 0) && (((ch0 = str.charAt(0)) == '.') || (ch0 == File.separatorChar))))
    {






      return FilePath.valueOf(str);
    }
    return URIPath.valueOf(str);
  }
  
  public static Path valueOf(Object arg) {
    Path path = coerceToPathOrNull(arg);
    if (path == null)
      throw new WrongType((String)null, -4, arg, "path");
    return path;
  }
  
  public static URL toURL(String str) {
    try {
      if (!uriSchemeSpecified(str)) {
        Path cur = currentPath();
        Path path = cur.resolve(str);
        if (path.isAbsolute())
          return path.toURL();
        str = path.toString();
      }
      return new URL(str);
    } catch (Exception ex) {
      throw WrappedException.wrapIfNeeded(ex);
    }
  }
  





  public static int uriSchemeLength(String uri)
  {
    int len = uri.length();
    for (int i = 0; i < len; i++) {
      char ch = uri.charAt(i);
      if (ch == ':')
        return i;
      if (i == 0 ? !Character.isLetter(ch) : (!Character.isLetterOrDigit(ch)) && (ch != '+') && (ch != '-') && (ch != '.'))
      {

        return -1; }
    }
    return -1;
  }
  


  public static boolean uriSchemeSpecified(String name)
  {
    int ulen = uriSchemeLength(name);
    if ((ulen == 1) && (File.separatorChar == '\\')) {
      char drive = name.charAt(0);
      return ((drive < 'a') || (drive > 'z')) && ((drive < 'A') || (drive > 'Z'));
    }
    
    return ulen > 0;
  }
  


  public abstract boolean isAbsolute();
  

  public boolean isDirectory()
  {
    String str = toString();
    int len = str.length();
    if (len > 0) {
      char last = str.charAt(len - 1);
      if ((last == '/') || (last == File.separatorChar))
        return true;
    }
    return false;
  }
  
  public boolean isPlainFile() {
    File file = toFile();
    if (file != null) {
      return file.isFile();
    }
    return (!isDirectory()) && (getPath() != null);
  }
  
  public boolean delete()
  {
    try {
      deleteFile();
      return true;
    } catch (Exception ex) {}
    return false;
  }
  
  public void deleteFile()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean exists() {
    return getLastModified() != 0L;
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
    if (isDirectory()) {
      return this;
    }
    return resolve(".");
  }
  
  public Path getParent() {
    return resolve(isDirectory() ? ".." : ".");
  }
  
  public String getLast() {
    String p = getPath();
    if (p == null)
      return null;
    int len = p.length();
    int end = len;
    int i = len;
    for (;;) { i--; if (i <= 0)
        return end == len ? p : p.substring(0, end);
      char c = p.charAt(i);
      if (c == '/') {
        if (i + 1 == len) {
          end = i;
        } else
          return p.substring(i + 1, end);
      }
    }
  }
  
  public String getExtension() {
    String p = getPath();
    if (p == null)
      return null;
    int len = p.length();
    int i = len;
    for (;;) { i--; if (i <= 0)
        return null;
      char c = p.charAt(i);
      boolean sawDot = false;
      if (c == '.') {
        c = p.charAt(i - 1);
        sawDot = true;
      }
      if ((c == '/') || (((this instanceof FilePath)) && (c == File.separatorChar)))
      {

        return null; }
      if (sawDot)
        return p.substring(i + 1);
    }
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
    return toUri();
  }
  



  public String toURIString() { return toUri().toString(); }
  
  public Path resolve(Path relative) {
    if (relative.isAbsolute())
      return relative;
    return resolve(relative.toString());
  }
  
  public abstract Path resolve(String paramString);
  
  public static InputStream openInputStream(Object uri) throws IOException {
    return valueOf(uri).openInputStream();
  }
  
  public abstract InputStream openInputStream() throws IOException;
  
  public abstract OutputStream openOutputStream() throws IOException;
  
  public Reader openReader(boolean ignoreEncodingErrors) throws IOException { throw new UnsupportedOperationException(); }
  
  public Writer openWriter() throws IOException
  {
    return new OutputStreamWriter(openOutputStream());
  }
  
  public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException
  {
    byte[] bytes = readAllBytes();
    


    return new String(bytes, System.getProperty("sun.jnu.encoding", "UTF-8"));
  }
  


  public byte[] readAllBytes()
    throws IOException
  {
    long len = getContentLength();
    
    if (len > 2147483639L)
      throw new Error("path contents too big");
    int ilen = (int)len;
    byte[] buffer = new byte[ilen < 0 ? 8192 : ilen];
    int sofar = 0;
    InputStream in = openInputStream();
    while ((sofar < ilen) || (ilen < 0)) {
      if (sofar == buffer.length) {
        byte[] tmp = new byte[sofar * 3 >> 1];
        System.arraycopy(buffer, 0, tmp, 0, sofar);
        buffer = tmp;
      }
      int cnt = in.read(buffer, sofar, buffer.length - sofar);
      if (cnt <= 0) {
        if (ilen < 0)
          break;
        throw new IOException("unable to read enture file");
      }
      sofar += cnt;
    }
    return buffer;
  }
  



  public static String relativize(String in, String base)
    throws URISyntaxException, IOException
  {
    String baseStr = base;
    String inStr = in;
    
    baseStr = new URI(baseStr).normalize().toString();
    inStr = URLPath.valueOf(in).toURI().normalize().toString();
    
    int baseLen = baseStr.length();
    int inLen = inStr.length();
    int i = 0;
    int sl = 0;
    int colon = 0;
    for (; (i < baseLen) && (i < inLen); i++) {
      char cb = baseStr.charAt(i);
      char ci = inStr.charAt(i);
      if (cb != ci)
        break;
      if (cb == '/')
        sl = i;
      if (cb == ':')
        colon = i;
    }
    if ((colon > 0) && ((sl > colon + 2) || (baseLen <= colon + 2) || (baseStr.charAt(colon + 2) != '/')))
    {






      baseStr = baseStr.substring(sl + 1);
      inStr = inStr.substring(sl + 1);
    }
    else {
      return in;
    }
    StringBuilder sbuf = new StringBuilder();
    


    sl = 0;
    i = baseLen = baseStr.length(); for (;;) { i--; if (i < 0) break;
      if (baseStr.charAt(i) == '/')
        sbuf.append("../"); }
    sbuf.append(inStr);
    return sbuf.toString();
  }
  
  public String getName() {
    return toString();
  }
  
  public Path getAbsolute() {
    if (this == userDirPath) {
      return resolve(".");
    }
    return currentPath().resolve(this);
  }
  
  public Path getCanonical() {
    return getAbsolute();
  }
  
















  public File toFile()
  {
    return null;
  }
  







  public String probeContentType()
  {
    String contentType = null;
    
    if (contentType == null) {
      String p = getPath();
      if (p == null)
        p = toString();
      if (p.startsWith("jar:")) {
        int bang = p.indexOf('!');
        if (bang > 0)
          p = p.substring(bang + 1);
      }
      contentType = URLConnection.guessContentTypeFromName(p);
      if (contentType == null)
      {
        if (p.endsWith(".xhtml")) {
          contentType = "application/xhtml+xml";
        } else if (p.endsWith(".css")) {
          contentType = "text/css";
        } else if (p.endsWith(".js"))
          contentType = "application/javascript";
      }
    }
    return contentType;
  }
  

  public static final Object PATH_CURRENT = new String("<current>");
  

  public static final Object PATH_RELATIVE = new String("<relative>");
  









  public static Object[] search(Object[] searchPath, String filename, String base)
  {
    for (int i = 0; i < searchPath.length; i++) {
      Object spath = searchPath[i];
      if (spath == PATH_RELATIVE) {
        String tpath = base;
        if ((tpath == null) || (tpath.startsWith("/dev/"))) {
          spath = PATH_CURRENT;
        } else
          spath = tpath; }
      Path path;
      Path path;
      if (spath == PATH_CURRENT) {
        path = currentPath();
      } else
        path = valueOf(spath);
      try {
        InputStream istrm = path.resolve(filename).openInputStream();
        return new Object[] { istrm, path };
      }
      catch (Exception ex) {}
    }
    return null;
  }
}
