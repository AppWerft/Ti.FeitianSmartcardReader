/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.servlet;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsServer;
import gnu.kawa.io.Path;
import gnu.kawa.servlet.HttpRequestContext;
import gnu.kawa.servlet.KawaAutoHandler;
import gnu.kawa.servlet.ServletPrinter;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class KawaHttpHandler
implements HttpHandler {
    int counter;
    Path resourceRoot;
    public static HttpServer serverInstance;
    public static int serverBacklog;
    static int handlerCount;

    public KawaHttpHandler(String resourceRoot) {
        this.resourceRoot = Path.valueOf(resourceRoot);
    }

    public KawaHttpHandler(Path resourceRoot) {
        this.resourceRoot = resourceRoot;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void handle(HttpExchange t) throws IOException {
        Context hctx;
        HttpRequestContext tctx = HttpRequestContext.instance.get();
        if (tctx instanceof Context) {
            hctx = (Context)tctx;
        } else {
            hctx = new Context();
            HttpRequestContext.setInstance(hctx);
        }
        hctx.setExchange(t, this);
        CallContext ctx = CallContext.getInstance();
        Consumer saveConsumer = ctx.consumer;
        ServletPrinter consumer = hctx.getConsumer();
        try {
            ctx.consumer = consumer;
            ctx.consumer.startDocument();
            KawaAutoHandler.run(hctx, ctx);
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex) {
            hctx.log("Caught an exception: ", ex);
            hctx.reset(true);
            hctx.setContentType("text/plain");
            if (hctx.statusCode != -999) {
                hctx.statusCode = 500;
            }
            ctx.consumer.write("internal exception: ");
            ctx.consumer.writeObject(ex);
            ctx.consumer.write("\nSee logs for specifics.");
        }
        finally {
            ctx.consumer.endDocument();
            ctx.consumer = saveConsumer;
            t.close();
        }
    }

    public static HttpServer getServerInstance() throws IOException {
        if (serverInstance == null) {
            serverInstance = HttpServer.create();
        }
        return serverInstance;
    }

    public static void maybeStopServer() {
        if (serverInstance != null && --handlerCount <= 0) {
            serverInstance.stop(0);
        }
    }

    public static void addAutoHandler(String uriRoot, String resourceRoot) throws IOException {
        HttpServer server = KawaHttpHandler.getServerInstance();
        int rlen = resourceRoot.length();
        if (rlen > 0 && resourceRoot.charAt(rlen - 1) != '/') {
            resourceRoot = resourceRoot + "/";
        }
        if (uriRoot.length() == 0 || uriRoot.charAt(0) != '/') {
            uriRoot = "/" + uriRoot;
        }
        server.createContext(uriRoot, new KawaHttpHandler(resourceRoot));
    }

    public static HttpContext addHandler(String uriRoot, HttpHandler handler) throws IOException {
        HttpServer server = KawaHttpHandler.getServerInstance();
        if (uriRoot.length() == 0 || uriRoot.charAt(0) != '/') {
            uriRoot = "/" + uriRoot;
        }
        return server.createContext(uriRoot, handler);
    }

    public static void addStaticFileHandler(String uriRoot, String pathPrefix, String defaultUrl, boolean exitOnClose) throws IOException {
        StaticFileHandler handler = new StaticFileHandler(pathPrefix, defaultUrl);
        HttpContext context = KawaHttpHandler.addHandler(uriRoot, handler);
        if (exitOnClose) {
            ++handlerCount;
            handler.httpContext = context;
        }
    }

    public static HttpServer startServer(int port, PrintStream printPortHere) throws IOException {
        HttpServer server = KawaHttpHandler.getServerInstance();
        server.bind(new InetSocketAddress(port), serverBacklog);
        server.setExecutor(null);
        server.start();
        port = server.getAddress().getPort();
        if (printPortHere != null) {
            printPortHere.println("Started web server on port " + port + ".  Browse http://127.0.0.1:" + port + "/");
        }
        return server;
    }

    static {
        if (HttpRequestContext.importServletDefinitions == 0) {
            HttpRequestContext.importServletDefinitions = 1;
        }
        serverBacklog = 0;
        handlerCount = 0;
    }

    public static class Context
    extends HttpRequestContext {
        KawaHttpHandler httpHandler;
        HttpExchange exchange;
        Headers requestHeaders;
        Headers responseHeaders;
        HttpContext context;
        Map<String, Object> attributes;
        URI requestURI;
        Map<String, List<String>> requestParameters;

        public void setExchange(HttpExchange exchange, KawaHttpHandler httpHandler) {
            this.statusCode = 200;
            this.statusReasonPhrase = null;
            this.exchange = exchange;
            this.requestHeaders = exchange.getRequestHeaders();
            this.responseHeaders = exchange.getResponseHeaders();
            this.context = exchange.getHttpContext();
            this.requestURI = exchange.getRequestURI();
            this.requestParameters = null;
            this.httpHandler = httpHandler;
            this.consumer = null;
        }

        @Override
        public URL getResourceURL(String path) {
            try {
                String p = path;
                Path root = this.httpHandler.resourceRoot;
                path = this.normalizeToContext(path);
                if (path == null) {
                    return null;
                }
                Path rpath = root.resolve(path);
                if (!rpath.exists()) {
                    return null;
                }
                return rpath.toURL();
            }
            catch (Exception ex) {
                return null;
            }
        }

        @Override
        public InputStream getRequestStream() {
            return this.exchange.getRequestBody();
        }

        @Override
        public OutputStream getResponseStream() {
            return this.exchange.getResponseBody();
        }

        @Override
        public boolean reset(boolean headersAlso) {
            if (this.statusCode == -999) {
                return false;
            }
            if (headersAlso) {
                this.responseHeaders.clear();
            }
            return this.consumer == null || this.consumer.reset(headersAlso);
        }

        @Override
        public Map<String, List<String>> getRequestParameters() {
            if (this.requestParameters == null) {
                this.requestParameters = new LinkedHashMap<String, List<String>>();
                try {
                    Context.parseQuery(this.requestURI.getRawQuery(), this.requestParameters);
                    Context.parsePostParameters(this.exchange, this.requestParameters);
                }
                catch (Exception ex) {
                    this.log("caught " + ex + " in " + this.getClass().getName() + ".getRequestParameters");
                }
            }
            return this.requestParameters;
        }

        @Override
        public String getRequestHeader(String name) {
            return this.requestHeaders.getFirst(name);
        }

        @Override
        public List<String> getRequestHeaders(String name) {
            return this.requestHeaders.get(name);
        }

        public Headers getRequestHeaders() {
            return this.requestHeaders;
        }

        @Override
        public URI getRequestURI() {
            return this.requestURI;
        }

        @Override
        public String getContextPath() {
            return this.context.getPath();
        }

        @Override
        public String getPathTranslated() {
            String path = this.getRequestPath();
            int npath = path.length();
            if (npath > 0 && path.charAt(npath - 1) == '/') {
                path = path.substring(0, --npath);
            }
            if (npath > 0 && path.charAt(0) == '/') {
                path = path.substring(1);
            }
            Path root = this.httpHandler.resourceRoot;
            return root + path;
        }

        @Override
        public String getRequestScheme() {
            return this.context.getServer() instanceof HttpsServer ? "https" : "http";
        }

        @Override
        public InetSocketAddress getLocalSocketAddress() {
            return this.exchange.getLocalAddress();
        }

        @Override
        public InetAddress getLocalHost() {
            return this.exchange.getLocalAddress().getAddress();
        }

        @Override
        public int getLocalPort() {
            return this.exchange.getLocalAddress().getPort();
        }

        @Override
        public InetSocketAddress getRemoteSocketAddress() {
            return this.exchange.getRemoteAddress();
        }

        @Override
        public String getRemoteIPAddress() {
            return this.getRemoteHost().getHostAddress();
        }

        @Override
        public InetAddress getRemoteHost() {
            return this.exchange.getRemoteAddress().getAddress();
        }

        @Override
        public int getRemotePort() {
            return this.exchange.getRemoteAddress().getPort();
        }

        @Override
        public String getRequestMethod() {
            return this.exchange.getRequestMethod();
        }

        @Override
        public String getQueryString() {
            return this.requestURI.getQuery();
        }

        @Override
        public void setResponseHeader(String name, String value) {
            this.responseHeaders.set(name, value);
        }

        @Override
        public void setContentType(String type) {
            this.setResponseHeader("Content-Type", type);
        }

        @Override
        public Object getAttribute(String name) {
            if (this.attributes == null) {
                this.attributes = this.context.getAttributes();
            }
            return this.attributes.get(name);
        }

        @Override
        public void setAttribute(String name, Object value) {
            if (this.attributes == null) {
                this.attributes = this.context.getAttributes();
            }
            this.attributes.put(name, value);
        }

        @Override
        public void sendResponseHeaders(int reasonCode, String reasonPhrase, long responseLength) throws IOException {
            if (responseLength <= 0L) {
                responseLength = responseLength < 0L ? 0L : -1L;
            }
            this.exchange.sendResponseHeaders(reasonCode, responseLength);
            this.statusCode = -999;
        }

        public static void parseQuery(String query, Map<String, List<String>> parameters2) throws UnsupportedEncodingException {
            if (query != null) {
                String[] pairs;
                for (String pair : pairs = query.split("[&]")) {
                    List<String> values;
                    String[] param = pair.split("[=]");
                    String key = null;
                    String value = null;
                    if (param.length > 0) {
                        key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
                    }
                    if (param.length > 1) {
                        value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
                    }
                    if ((values = parameters2.get(key)) != null) {
                        values.add(value);
                        continue;
                    }
                    ArrayList<String> list = new ArrayList<String>(1);
                    list.add(value);
                    parameters2.put(key, list);
                }
            }
        }

        public static void parsePostParameters(HttpExchange exchange, Map<String, List<String>> parameters2) throws IOException {
            if ("post".equalsIgnoreCase(exchange.getRequestMethod())) {
                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String query = br.readLine();
                Context.parseQuery(query, parameters2);
            }
        }

        @Override
        public void log(String message) {
            System.err.println(message);
        }

        @Override
        public void log(String message, Throwable ex) {
            System.err.println(message);
            ex.printStackTrace(System.err);
        }
    }

    public static class StaticFileHandler
    implements HttpHandler {
        String defaultUrl;
        String pathPrefix;
        HttpContext httpContext;

        public StaticFileHandler(String pathPrefix, String defaultUrl) {
            this.defaultUrl = defaultUrl;
            this.pathPrefix = pathPrefix;
        }

        public void windowClosed() {
            if (this.httpContext != null) {
                try {
                    HttpServer server = this.httpContext.getServer();
                    server.removeContext(this.httpContext);
                    if (server == KawaHttpHandler.serverInstance) {
                        KawaHttpHandler.maybeStopServer();
                    }
                }
                catch (Throwable ex) {
                    // empty catch block
                }
            }
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Context hctx = new Context();
            hctx.setExchange(exchange, null);
            URI requestURI = hctx.getRequestURI();
            String requestStr = requestURI.toString();
            String contextPath = hctx.getContextPath();
            if (requestStr.startsWith(contextPath)) {
                requestStr = requestStr.substring(contextPath.length() - 1);
            }
            if ("/".equals(requestStr)) {
                requestStr = this.defaultUrl;
                hctx.setResponseHeader("Location", requestStr);
                hctx.sendResponseHeaders(301, null, -1L);
                return;
            }
            if (requestStr.endsWith("/(WINDOW-CLOSED)")) {
                this.windowClosed();
                return;
            }
            HttpRequestContext.handleStaticFile(hctx, Path.valueOf(this.pathPrefix + requestStr));
        }
    }

}

