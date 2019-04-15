/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.servlet;

import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.kawa.servlet.ServletPrinter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

public abstract class HttpRequestContext {
    public static final int HTTP_OK = 200;
    public static final int HTTP_NOT_FOUND = 404;
    static final int STATUS_SENT = -999;
    public int statusCode = 200;
    public String statusReasonPhrase = null;
    public static int importServletDefinitions;
    protected static final ThreadLocal<HttpRequestContext> instance;
    ServletPrinter consumer;
    String scriptPath = "";
    String localPath = "";

    public static HttpRequestContext getInstance() {
        HttpRequestContext hctx = instance.get();
        if (hctx == null) {
            throw new UnsupportedOperationException("can only be called by http-server");
        }
        return hctx;
    }

    public static HttpRequestContext getInstance(String command) {
        HttpRequestContext hctx = instance.get();
        if (hctx == null) {
            throw new UnsupportedOperationException(command + " can only be called within http-server");
        }
        return hctx;
    }

    public static void setInstance(HttpRequestContext ctx) {
        instance.set(ctx);
    }

    public abstract InputStream getRequestStream();

    public InPort getRequestPort() {
        return new InPort(this.getRequestStream());
    }

    public String getRequestBodyChars() throws IOException {
        InputStream is = this.getRequestStream();
        InputStreamReader reader = new InputStreamReader(is);
        int buflen = 1024;
        char[] buf = new char[buflen];
        int pos = 0;
        do {
            int avail;
            int count;
            if ((avail = buflen - pos) <= 0) {
                char[] tmp = new char[2 * buflen];
                System.arraycopy(buf, 0, tmp, 0, buflen);
                buf = tmp;
                buflen += buflen;
            }
            if ((count = ((Reader)reader).read(buf, pos, avail)) < 0) break;
            pos += count;
        } while (true);
        ((Reader)reader).close();
        String str = new String(buf, 0, pos);
        return str;
    }

    public abstract OutputStream getResponseStream();

    public ServletPrinter getConsumer() throws IOException {
        if (this.consumer == null) {
            this.consumer = new ServletPrinter(this, 8192);
        }
        return this.consumer;
    }

    public abstract boolean reset(boolean var1);

    public String getRequestParameter(String name) {
        List<String> p = this.getRequestParameters().get(name);
        return p == null || p.isEmpty() ? null : p.get(0);
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

    public void setScriptAndLocalPath(String scriptPath, String localPath) {
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
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(this.getRequestScheme());
        sbuf.append("://");
        String host = this.getRequestHeader("Host");
        if (host != null) {
            sbuf.append(host);
        } else {
            sbuf.append(this.getLocalIPAddress());
            sbuf.append(':');
            sbuf.append(this.getLocalPort());
        }
        sbuf.append(this.getRequestPath());
        return sbuf;
    }

    public abstract String getQueryString();

    public abstract String getRequestMethod();

    public abstract String getRequestHeader(String var1);

    public abstract List<String> getRequestHeaders(String var1);

    public abstract Map<String, List<String>> getRequestHeaders();

    public abstract void setResponseHeader(String var1, String var2);

    public void setContentType(String type) {
        this.setResponseHeader("Content-Type", type);
    }

    protected String normalizeToContext(String path) {
        if ((path = path.length() > 0 && path.charAt(0) == '/' ? path.substring(1) : this.getScriptPath() + path).indexOf("..") >= 0 && (path = URI.create(path).normalize().toString()).startsWith("../")) {
            return null;
        }
        return path;
    }

    public abstract URL getResourceURL(String var1);

    public abstract Object getAttribute(String var1);

    public abstract void setAttribute(String var1, Object var2);

    public abstract void sendResponseHeaders(int var1, String var2, long var3) throws IOException;

    public void sendNotFound(String path) throws IOException {
        String msg = "The requested URL " + path + " was not found on this server.\r\n";
        byte[] bmsg = msg.getBytes();
        this.sendResponseHeaders(404, null, bmsg.length);
        OutputStream out = this.getResponseStream();
        try {
            out.write(bmsg);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public abstract void log(String var1);

    public abstract void log(String var1, Throwable var2);

    public static void handleStaticFile(HttpRequestContext hctx, Path absPath) throws IOException {
        String contentType = absPath.probeContentType();
        if (contentType != null) {
            hctx.setContentType(contentType);
        }
        OutputStream out = hctx.getResponseStream();
        try {
            int n;
            long len = absPath.getContentLength();
            InputStream in = absPath.openInputStream();
            hctx.sendResponseHeaders(200, null, len);
            byte[] buffer = new byte[4096];
            while ((n = in.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            out.close();
        }
        catch (Throwable ex) {
            String msg = "The requested URL " + hctx.getRequestPath() + " was not found on this server.\r\n - " + ex + "\r\n";
            byte[] bmsg = msg.getBytes();
            hctx.sendResponseHeaders(404, null, bmsg.length);
            try {
                out.write(bmsg);
            }
            catch (IOException ex2) {
                // empty catch block
            }
        }
    }

    static {
        instance = new ThreadLocal<T>();
    }
}

