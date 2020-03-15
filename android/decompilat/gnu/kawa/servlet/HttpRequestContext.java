// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.servlet;

import gnu.kawa.io.Path;
import java.net.URL;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;
import java.util.List;
import java.io.OutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import gnu.kawa.io.InPort;
import java.io.InputStream;

public abstract class HttpRequestContext
{
    public static final int HTTP_OK = 200;
    public static final int HTTP_NOT_FOUND = 404;
    static final int STATUS_SENT = -999;
    public int statusCode;
    public String statusReasonPhrase;
    public static int importServletDefinitions;
    protected static final ThreadLocal<HttpRequestContext> instance;
    ServletPrinter consumer;
    String scriptPath;
    String localPath;
    
    public HttpRequestContext() {
        this.statusCode = 200;
        this.statusReasonPhrase = null;
        this.scriptPath = "";
        this.localPath = "";
    }
    
    public static HttpRequestContext getInstance() {
        final HttpRequestContext hctx = HttpRequestContext.instance.get();
        if (hctx == null) {
            throw new UnsupportedOperationException("can only be called by http-server");
        }
        return hctx;
    }
    
    public static HttpRequestContext getInstance(final String command) {
        final HttpRequestContext hctx = HttpRequestContext.instance.get();
        if (hctx == null) {
            throw new UnsupportedOperationException(command + " can only be called within http-server");
        }
        return hctx;
    }
    
    public static void setInstance(final HttpRequestContext ctx) {
        HttpRequestContext.instance.set(ctx);
    }
    
    public abstract InputStream getRequestStream();
    
    public InPort getRequestPort() {
        return new InPort(this.getRequestStream());
    }
    
    public String getRequestBodyChars() throws IOException {
        final InputStream is = this.getRequestStream();
        final Reader reader = new InputStreamReader(is);
        int buflen = 1024;
        char[] buf = new char[buflen];
        int pos = 0;
        while (true) {
            final int avail = buflen - pos;
            if (avail <= 0) {
                final char[] tmp = new char[2 * buflen];
                System.arraycopy(buf, 0, tmp, 0, buflen);
                buf = tmp;
                buflen += buflen;
            }
            final int count = reader.read(buf, pos, avail);
            if (count < 0) {
                break;
            }
            pos += count;
        }
        reader.close();
        final String str = new String(buf, 0, pos);
        return str;
    }
    
    public abstract OutputStream getResponseStream();
    
    public ServletPrinter getConsumer() throws IOException {
        if (this.consumer == null) {
            this.consumer = new ServletPrinter(this, 8192);
        }
        return this.consumer;
    }
    
    public abstract boolean reset(final boolean p0);
    
    public String getRequestParameter(final String name) {
        final List<String> p = this.getRequestParameters().get(name);
        return (p == null || p.isEmpty()) ? null : p.get(0);
    }
    
    public abstract Map<String, List<String>> getRequestParameters();
    
    public abstract URI getRequestURI();
    
    public abstract String getContextPath();
    
    public String getScriptPath() {
        return this.scriptPath;
    }
    
    public String getLocalPath() {
        return this.localPath;
    }
    
    public void setScriptAndLocalPath(final String scriptPath, final String localPath) {
        this.scriptPath = scriptPath;
        this.localPath = localPath;
    }
    
    public abstract String getPathTranslated();
    
    public String getRequestPath() {
        return this.getRequestURI().getPath();
    }
    
    public String getRequestScheme() {
        return "http";
    }
    
    public InetSocketAddress getLocalSocketAddress() {
        return new InetSocketAddress(this.getLocalHost(), this.getLocalPort());
    }
    
    public String getLocalIPAddress() {
        return this.getLocalHost().getHostAddress();
    }
    
    public InetAddress getLocalHost() {
        try {
            return InetAddress.getLocalHost();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public abstract int getLocalPort();
    
    public InetSocketAddress getRemoteSocketAddress() {
        return new InetSocketAddress(this.getRemoteHost(), this.getRemotePort());
    }
    
    public abstract InetAddress getRemoteHost();
    
    public abstract String getRemoteIPAddress();
    
    public abstract int getRemotePort();
    
    public StringBuffer getRequestURLBuffer() {
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append(this.getRequestScheme());
        sbuf.append("://");
        final String host = this.getRequestHeader("Host");
        if (host != null) {
            sbuf.append(host);
        }
        else {
            sbuf.append(this.getLocalIPAddress());
            sbuf.append(':');
            sbuf.append(this.getLocalPort());
        }
        sbuf.append(this.getRequestPath());
        return sbuf;
    }
    
    public abstract String getQueryString();
    
    public abstract String getRequestMethod();
    
    public abstract String getRequestHeader(final String p0);
    
    public abstract List<String> getRequestHeaders(final String p0);
    
    public abstract Map<String, List<String>> getRequestHeaders();
    
    public abstract void setResponseHeader(final String p0, final String p1);
    
    public void setContentType(final String type) {
        this.setResponseHeader("Content-Type", type);
    }
    
    protected String normalizeToContext(String path) {
        if (path.length() > 0 && path.charAt(0) == '/') {
            path = path.substring(1);
        }
        else {
            path = this.getScriptPath() + path;
        }
        if (path.indexOf("..") >= 0) {
            path = URI.create(path).normalize().toString();
            if (path.startsWith("../")) {
                return null;
            }
        }
        return path;
    }
    
    public abstract URL getResourceURL(final String p0);
    
    public abstract Object getAttribute(final String p0);
    
    public abstract void setAttribute(final String p0, final Object p1);
    
    public abstract void sendResponseHeaders(final int p0, final String p1, final long p2) throws IOException;
    
    public void sendNotFound(final String path) throws IOException {
        final String msg = "The requested URL " + path + " was not found on this server.\r\n";
        final byte[] bmsg = msg.getBytes();
        this.sendResponseHeaders(404, null, bmsg.length);
        final OutputStream out = this.getResponseStream();
        try {
            out.write(bmsg);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public abstract void log(final String p0);
    
    public abstract void log(final String p0, final Throwable p1);
    
    public static void handleStaticFile(final HttpRequestContext hctx, final Path absPath) throws IOException {
        final String contentType = absPath.probeContentType();
        if (contentType != null) {
            hctx.setContentType(contentType);
        }
        final OutputStream out = hctx.getResponseStream();
        try {
            final long len = absPath.getContentLength();
            final InputStream in = absPath.openInputStream();
            hctx.sendResponseHeaders(200, null, len);
            final byte[] buffer = new byte[4096];
            while (true) {
                final int n = in.read(buffer);
                if (n < 0) {
                    break;
                }
                out.write(buffer, 0, n);
            }
            out.close();
        }
        catch (Throwable ex) {
            final String msg = "The requested URL " + hctx.getRequestPath() + " was not found on this server.\r\n - " + ex + "\r\n";
            final byte[] bmsg = msg.getBytes();
            hctx.sendResponseHeaders(404, null, bmsg.length);
            try {
                out.write(bmsg);
            }
            catch (IOException ex2) {}
        }
    }
    
    static {
        instance = new ThreadLocal<HttpRequestContext>();
    }
}
