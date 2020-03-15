// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.servlet;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.net.URLDecoder;
import java.net.InetAddress;
import com.sun.net.httpserver.HttpsServer;
import java.util.LinkedHashMap;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import com.sun.net.httpserver.Headers;
import java.net.URI;
import java.util.concurrent.Executor;
import java.net.InetSocketAddress;
import java.io.PrintStream;
import com.sun.net.httpserver.HttpContext;
import java.io.IOException;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import gnu.kawa.io.Path;
import com.sun.net.httpserver.HttpHandler;

public class KawaHttpHandler implements HttpHandler
{
    int counter;
    Path resourceRoot;
    public static HttpServer serverInstance;
    public static int serverBacklog;
    static int handlerCount;
    
    public KawaHttpHandler(final String resourceRoot) {
        this.resourceRoot = Path.valueOf(resourceRoot);
    }
    
    public KawaHttpHandler(final Path resourceRoot) {
        this.resourceRoot = resourceRoot;
    }
    
    @Override
    public void handle(final HttpExchange t) throws IOException {
        final HttpRequestContext tctx = HttpRequestContext.instance.get();
        Context hctx;
        if (tctx instanceof Context) {
            hctx = (Context)tctx;
        }
        else {
            hctx = new Context();
            HttpRequestContext.setInstance(hctx);
        }
        hctx.setExchange(t, this);
        final CallContext ctx = CallContext.getInstance();
        final Consumer saveConsumer = ctx.consumer;
        final ServletPrinter consumer = hctx.getConsumer();
        try {
            (ctx.consumer = consumer).startDocument();
            KawaAutoHandler.run(hctx, ctx);
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex2) {
            hctx.log("Caught an exception: ", ex2);
            hctx.reset(true);
            hctx.setContentType("text/plain");
            if (hctx.statusCode != -999) {
                hctx.statusCode = 500;
            }
            ctx.consumer.write("internal exception: ");
            ctx.consumer.writeObject(ex2);
            ctx.consumer.write("\nSee logs for specifics.");
        }
        finally {
            ctx.consumer.endDocument();
            ctx.consumer = saveConsumer;
            t.close();
        }
    }
    
    public static HttpServer getServerInstance() throws IOException {
        if (KawaHttpHandler.serverInstance == null) {
            KawaHttpHandler.serverInstance = HttpServer.create();
        }
        return KawaHttpHandler.serverInstance;
    }
    
    public static void maybeStopServer() {
        if (KawaHttpHandler.serverInstance != null && --KawaHttpHandler.handlerCount <= 0) {
            KawaHttpHandler.serverInstance.stop(0);
        }
    }
    
    public static void addAutoHandler(String uriRoot, String resourceRoot) throws IOException {
        final HttpServer server = getServerInstance();
        final int rlen = resourceRoot.length();
        if (rlen > 0 && resourceRoot.charAt(rlen - 1) != '/') {
            resourceRoot += "/";
        }
        if (uriRoot.length() == 0 || uriRoot.charAt(0) != '/') {
            uriRoot = "/" + uriRoot;
        }
        server.createContext(uriRoot, new KawaHttpHandler(resourceRoot));
    }
    
    public static HttpContext addHandler(String uriRoot, final HttpHandler handler) throws IOException {
        final HttpServer server = getServerInstance();
        if (uriRoot.length() == 0 || uriRoot.charAt(0) != '/') {
            uriRoot = "/" + uriRoot;
        }
        return server.createContext(uriRoot, handler);
    }
    
    public static void addStaticFileHandler(final String uriRoot, final String pathPrefix, final String defaultUrl, final boolean exitOnClose) throws IOException {
        final StaticFileHandler handler = new StaticFileHandler(pathPrefix, defaultUrl);
        final HttpContext context = addHandler(uriRoot, handler);
        if (exitOnClose) {
            ++KawaHttpHandler.handlerCount;
            handler.httpContext = context;
        }
    }
    
    public static HttpServer startServer(int port, final PrintStream printPortHere) throws IOException {
        final HttpServer server = getServerInstance();
        server.bind(new InetSocketAddress(port), KawaHttpHandler.serverBacklog);
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
        KawaHttpHandler.serverBacklog = 0;
        KawaHttpHandler.handlerCount = 0;
    }
    
    public static class StaticFileHandler implements HttpHandler
    {
        String defaultUrl;
        String pathPrefix;
        HttpContext httpContext;
        
        public StaticFileHandler(final String pathPrefix, final String defaultUrl) {
            this.defaultUrl = defaultUrl;
            this.pathPrefix = pathPrefix;
        }
        
        public void windowClosed() {
            if (this.httpContext != null) {
                try {
                    final HttpServer server = this.httpContext.getServer();
                    server.removeContext(this.httpContext);
                    if (server == KawaHttpHandler.serverInstance) {
                        KawaHttpHandler.maybeStopServer();
                    }
                }
                catch (Throwable t) {}
            }
        }
        
        @Override
        public void handle(final HttpExchange exchange) throws IOException {
            final Context hctx = new Context();
            hctx.setExchange(exchange, null);
            final URI requestURI = hctx.getRequestURI();
            String requestStr = requestURI.toString();
            final String contextPath = hctx.getContextPath();
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
    
    public static class Context extends HttpRequestContext
    {
        KawaHttpHandler httpHandler;
        HttpExchange exchange;
        Headers requestHeaders;
        Headers responseHeaders;
        HttpContext context;
        Map<String, Object> attributes;
        URI requestURI;
        Map<String, List<String>> requestParameters;
        
        public void setExchange(final HttpExchange exchange, final KawaHttpHandler httpHandler) {
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
                final String p = path;
                final Path root = this.httpHandler.resourceRoot;
                path = this.normalizeToContext(path);
                if (path == null) {
                    return null;
                }
                final Path rpath = root.resolve(path);
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
        public boolean reset(final boolean headersAlso) {
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
                    parseQuery(this.requestURI.getRawQuery(), this.requestParameters);
                    parsePostParameters(this.exchange, this.requestParameters);
                }
                catch (Exception ex) {
                    this.log("caught " + ex + " in " + this.getClass().getName() + ".getRequestParameters");
                }
            }
            return this.requestParameters;
        }
        
        @Override
        public String getRequestHeader(final String name) {
            return this.requestHeaders.getFirst(name);
        }
        
        @Override
        public List<String> getRequestHeaders(final String name) {
            return this.requestHeaders.get((Object)name);
        }
        
        @Override
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
            final Path root = this.httpHandler.resourceRoot;
            return root + path;
        }
        
        @Override
        public String getRequestScheme() {
            return (this.context.getServer() instanceof HttpsServer) ? "https" : "http";
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
        public void setResponseHeader(final String name, final String value) {
            this.responseHeaders.set(name, value);
        }
        
        @Override
        public void setContentType(final String type) {
            this.setResponseHeader("Content-Type", type);
        }
        
        @Override
        public Object getAttribute(final String name) {
            if (this.attributes == null) {
                this.attributes = this.context.getAttributes();
            }
            return this.attributes.get(name);
        }
        
        @Override
        public void setAttribute(final String name, final Object value) {
            if (this.attributes == null) {
                this.attributes = this.context.getAttributes();
            }
            this.attributes.put(name, value);
        }
        
        @Override
        public void sendResponseHeaders(final int reasonCode, final String reasonPhrase, long responseLength) throws IOException {
            if (responseLength <= 0L) {
                responseLength = ((responseLength < 0L) ? 0L : -1L);
            }
            this.exchange.sendResponseHeaders(reasonCode, responseLength);
            this.statusCode = -999;
        }
        
        public static void parseQuery(final String query, final Map<String, List<String>> parameters) throws UnsupportedEncodingException {
            if (query != null) {
                final String[] arr$;
                final String[] pairs = arr$ = query.split("[&]");
                for (final String pair : arr$) {
                    final String[] param = pair.split("[=]");
                    String key = null;
                    String value = null;
                    if (param.length > 0) {
                        key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
                    }
                    if (param.length > 1) {
                        value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
                    }
                    final List<String> values = parameters.get(key);
                    if (values != null) {
                        values.add(value);
                    }
                    else {
                        final ArrayList<String> list = new ArrayList<String>(1);
                        list.add(value);
                        parameters.put(key, list);
                    }
                }
            }
        }
        
        public static void parsePostParameters(final HttpExchange exchange, final Map<String, List<String>> parameters) throws IOException {
            if ("post".equalsIgnoreCase(exchange.getRequestMethod())) {
                final InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                final BufferedReader br = new BufferedReader(isr);
                final String query = br.readLine();
                parseQuery(query, parameters);
            }
        }
        
        @Override
        public void log(final String message) {
            System.err.println(message);
        }
        
        @Override
        public void log(final String message, final Throwable ex) {
            System.err.println(message);
            ex.printStackTrace(System.err);
        }
    }
}
