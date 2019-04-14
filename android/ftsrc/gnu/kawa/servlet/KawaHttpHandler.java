package gnu.kawa.servlet;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import gnu.kawa.io.Path;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class KawaHttpHandler implements com.sun.net.httpserver.HttpHandler
{
  int counter;
  Path resourceRoot;
  public static HttpServer serverInstance;
  
  static
  {
    if (HttpRequestContext.importServletDefinitions == 0) {
      HttpRequestContext.importServletDefinitions = 1;
    }
  }
  
  public KawaHttpHandler(String resourceRoot) {
    this.resourceRoot = Path.valueOf(resourceRoot);
  }
  
  public KawaHttpHandler(Path resourceRoot)
  {
    this.resourceRoot = resourceRoot;
  }
  
  public void handle(HttpExchange t)
    throws IOException
  {
    HttpRequestContext tctx = (HttpRequestContext)HttpRequestContext.instance.get();
    Context hctx; Context hctx; if ((tctx instanceof Context))
    {
      hctx = (Context)tctx;
    }
    else
    {
      hctx = new Context();
      HttpRequestContext.setInstance(hctx);
    }
    hctx.setExchange(t, this);
    
    CallContext ctx = CallContext.getInstance();
    Consumer saveConsumer = consumer;
    ServletPrinter consumer = hctx.getConsumer();
    try
    {
      consumer = consumer;
      consumer.startDocument();
      
      KawaAutoHandler.run(hctx, ctx);
    }
    catch (Error ex)
    {
      throw ex;
    }
    catch (Throwable ex)
    {
      hctx.log("Caught an exception: ", ex);
      hctx.reset(true);
      hctx.setContentType("text/plain");
      if (statusCode != 64537)
        statusCode = 500;
      consumer.write("internal exception: ");
      consumer.writeObject(ex);
      consumer.write("\nSee logs for specifics.");
    }
    finally
    {
      consumer.endDocument();
      consumer = saveConsumer;
      t.close();
    }
  }
  

  public static int serverBacklog = 0;
  static int handlerCount = 0;
  
  public static HttpServer getServerInstance() throws IOException {
    if (serverInstance == null)
      serverInstance = HttpServer.create();
    return serverInstance;
  }
  
  public static void maybeStopServer() { if ((serverInstance != null) && (--handlerCount <= 0)) {
      serverInstance.stop(0);
    }
  }
  
  public static void addAutoHandler(String uriRoot, String resourceRoot) throws IOException
  {
    HttpServer server = getServerInstance();
    int rlen = resourceRoot.length();
    if ((rlen > 0) && (resourceRoot.charAt(rlen - 1) != '/'))
      resourceRoot = resourceRoot + "/";
    if ((uriRoot.length() == 0) || (uriRoot.charAt(0) != '/'))
      uriRoot = "/" + uriRoot;
    server.createContext(uriRoot, new KawaHttpHandler(resourceRoot));
  }
  
  public static HttpContext addHandler(String uriRoot, com.sun.net.httpserver.HttpHandler handler) throws IOException
  {
    HttpServer server = getServerInstance();
    if ((uriRoot.length() == 0) || (uriRoot.charAt(0) != '/'))
      uriRoot = "/" + uriRoot;
    return server.createContext(uriRoot, handler);
  }
  
  public static void addStaticFileHandler(String uriRoot, String pathPrefix, String defaultUrl, boolean exitOnClose) throws IOException {
    StaticFileHandler handler = new StaticFileHandler(pathPrefix, defaultUrl);
    HttpContext context = addHandler(uriRoot, handler);
    if (exitOnClose) {
      handlerCount += 1;
      httpContext = context;
    }
  }
  
  public static HttpServer startServer(int port, java.io.PrintStream printPortHere)
    throws IOException
  {
    HttpServer server = getServerInstance();
    server.bind(new InetSocketAddress(port), serverBacklog);
    server.setExecutor(null);
    server.start();
    port = server.getAddress().getPort();
    if (printPortHere != null) {
      printPortHere.println("Started web server on port " + port + ".  Browse http://127.0.0.1:" + port + "/");
    }
    return server;
  }
  
  public static class StaticFileHandler implements com.sun.net.httpserver.HttpHandler {
    String defaultUrl;
    String pathPrefix;
    HttpContext httpContext;
    
    public StaticFileHandler(String pathPrefix, String defaultUrl) {
      this.defaultUrl = defaultUrl;
      this.pathPrefix = pathPrefix;
    }
    
    public void windowClosed() { if (httpContext != null) {
        try {
          HttpServer server = httpContext.getServer();
          server.removeContext(httpContext);
          if (server == KawaHttpHandler.serverInstance) {
            KawaHttpHandler.maybeStopServer();
          }
        } catch (Throwable ex) {}
      }
    }
    
    public void handle(HttpExchange exchange) throws IOException {
      KawaHttpHandler.Context hctx = new KawaHttpHandler.Context();
      hctx.setExchange(exchange, null);
      URI requestURI = hctx.getRequestURI();
      String requestStr = requestURI.toString();
      String contextPath = hctx.getContextPath();
      if (requestStr.startsWith(contextPath)) {
        requestStr = requestStr.substring(contextPath.length() - 1);
      }
      if ("/".equals(requestStr)) {
        requestStr = defaultUrl;
        hctx.setResponseHeader("Location", requestStr);
        hctx.sendResponseHeaders(301, null, -1L);
        return;
      }
      if (requestStr.endsWith("/(WINDOW-CLOSED)")) {
        windowClosed();
        return;
      }
      HttpRequestContext.handleStaticFile(hctx, Path.valueOf(pathPrefix + requestStr));
    }
  }
  
  public static class Context extends HttpRequestContext {
    KawaHttpHandler httpHandler;
    HttpExchange exchange;
    Headers requestHeaders;
    Headers responseHeaders;
    HttpContext context;
    Map<String, Object> attributes;
    URI requestURI;
    Map<String, List<String>> requestParameters;
    
    public Context() {}
    
    public void setExchange(HttpExchange exchange, KawaHttpHandler httpHandler) {
      statusCode = 200;
      statusReasonPhrase = null;
      this.exchange = exchange;
      requestHeaders = exchange.getRequestHeaders();
      responseHeaders = exchange.getResponseHeaders();
      context = exchange.getHttpContext();
      requestURI = exchange.getRequestURI();
      requestParameters = null;
      this.httpHandler = httpHandler;
      consumer = null;
    }
    
    public java.net.URL getResourceURL(String path)
    {
      try
      {
        String p = path;
        Path root = httpHandler.resourceRoot;
        path = normalizeToContext(path);
        if (path == null)
          return null;
        Path rpath = root.resolve(path);
        if (!rpath.exists())
          return null;
        return rpath.toURL();
      }
      catch (Exception ex) {}
      
      return null;
    }
    

    public java.io.InputStream getRequestStream()
    {
      return exchange.getRequestBody();
    }
    
    public java.io.OutputStream getResponseStream()
    {
      return exchange.getResponseBody();
    }
    
    public boolean reset(boolean headersAlso)
    {
      if (statusCode == 64537)
        return false;
      if (headersAlso)
        responseHeaders.clear();
      return (consumer == null) || (consumer.reset(headersAlso));
    }
    
    public Map<String, List<String>> getRequestParameters()
    {
      if (requestParameters == null)
      {
        requestParameters = new java.util.LinkedHashMap();
        try
        {
          parseQuery(requestURI.getRawQuery(), requestParameters);
          parsePostParameters(exchange, requestParameters);
        }
        catch (Exception ex)
        {
          log("caught " + ex + " in " + getClass().getName() + ".getRequestParameters");
        }
      }
      return requestParameters;
    }
    
    public String getRequestHeader(String name)
    {
      return requestHeaders.getFirst(name);
    }
    
    public List<String> getRequestHeaders(String name)
    {
      return requestHeaders.get(name);
    }
    
    public Headers getRequestHeaders()
    {
      return requestHeaders;
    }
    
    public URI getRequestURI()
    {
      return requestURI;
    }
    
    public String getContextPath()
    {
      return context.getPath();
    }
    
    public String getPathTranslated()
    {
      String path = getRequestPath();
      int npath = path.length();
      if ((npath > 0) && (path.charAt(npath - 1) == '/'))
        path = path.substring(0, --npath);
      if ((npath > 0) && (path.charAt(0) == '/'))
        path = path.substring(1);
      Path root = httpHandler.resourceRoot;
      return root + path;
    }
    
    public String getRequestScheme()
    {
      return (context.getServer() instanceof com.sun.net.httpserver.HttpsServer) ? "https" : "http";
    }
    
    public InetSocketAddress getLocalSocketAddress()
    {
      return exchange.getLocalAddress();
    }
    
    public java.net.InetAddress getLocalHost()
    {
      return exchange.getLocalAddress().getAddress();
    }
    
    public int getLocalPort()
    {
      return exchange.getLocalAddress().getPort();
    }
    
    public InetSocketAddress getRemoteSocketAddress()
    {
      return exchange.getRemoteAddress();
    }
    
    public String getRemoteIPAddress()
    {
      return getRemoteHost().getHostAddress();
    }
    
    public java.net.InetAddress getRemoteHost()
    {
      return exchange.getRemoteAddress().getAddress();
    }
    
    public int getRemotePort()
    {
      return exchange.getRemoteAddress().getPort();
    }
    
    public String getRequestMethod()
    {
      return exchange.getRequestMethod();
    }
    
    public String getQueryString()
    {
      return requestURI.getQuery();
    }
    

    public void setResponseHeader(String name, String value)
    {
      responseHeaders.set(name, value);
    }
    
    public void setContentType(String type)
    {
      setResponseHeader("Content-Type", type);
    }
    
    public Object getAttribute(String name)
    {
      if (attributes == null)
        attributes = context.getAttributes();
      return attributes.get(name);
    }
    
    public void setAttribute(String name, Object value)
    {
      if (attributes == null)
        attributes = context.getAttributes();
      attributes.put(name, value);
    }
    
    public void sendResponseHeaders(int reasonCode, String reasonPhrase, long responseLength)
      throws IOException
    {
      if (responseLength <= 0L)
        responseLength = responseLength < 0L ? 0L : -1L;
      exchange.sendResponseHeaders(reasonCode, responseLength);
      statusCode = 64537;
    }
    









    public static void parseQuery(String query, Map<String, List<String>> parameters)
      throws java.io.UnsupportedEncodingException
    {
      if (query != null)
      {
        String[] pairs = query.split("[&]");
        
        for (String pair : pairs)
        {
          String[] param = pair.split("[=]");
          
          String key = null;
          String value = null;
          if (param.length > 0) {
            key = java.net.URLDecoder.decode(param[0], System.getProperty("file.encoding"));
          }
          
          if (param.length > 1) {
            value = java.net.URLDecoder.decode(param[1], System.getProperty("file.encoding"));
          }
          
          List<String> values = (List)parameters.get(key);
          if (values != null)
          {
            values.add(value);
          }
          else
          {
            java.util.ArrayList<String> list = new java.util.ArrayList(1);
            list.add(value);
            parameters.put(key, list);
          }
        }
      }
    }
    


    public static void parsePostParameters(HttpExchange exchange, Map<String, List<String>> parameters)
      throws IOException
    {
      if ("post".equalsIgnoreCase(exchange.getRequestMethod()))
      {

        java.io.InputStreamReader isr = new java.io.InputStreamReader(exchange.getRequestBody(), "utf-8");
        
        java.io.BufferedReader br = new java.io.BufferedReader(isr);
        String query = br.readLine();
        parseQuery(query, parameters);
      }
    }
    
    public void log(String message)
    {
      System.err.println(message);
    }
    
    public void log(String message, Throwable ex)
    {
      System.err.println(message);
      ex.printStackTrace(System.err);
    }
  }
}
