package gnu.kawa.servlet;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleContext;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Hashtable;


public class KawaAutoHandler
{
  static final String MODULE_MAP_ATTRIBUTE = "gnu.kawa.module-map";
  
  public KawaAutoHandler() {}
  
  public static void run(HttpRequestContext hctx, CallContext ctx)
    throws Throwable
  {
    boolean saveClass = hctx.getRequestParameter("qexo-save-class") != null;
    Object mod = getModule(hctx, ctx, saveClass);
    
    if ((mod instanceof ModuleBody)) {
      ((ModuleBody)mod).run(ctx);
    }
  }
  
  public static Object getModule(HttpRequestContext hctx, CallContext ctx, boolean saveClass) throws Exception
  {
    String path = hctx.getRequestPath();
    
    path = path.substring(hctx.getContextPath().length());
    Hashtable mmap = (Hashtable)hctx.getAttribute("gnu.kawa.module-map");
    
    if (mmap == null)
    {
      mmap = new Hashtable();
      hctx.setAttribute("gnu.kawa.module-map", mmap);
    }
    
    ModuleContext mcontext = (ModuleContext)hctx.getAttribute("gnu.kawa.module-context");
    
    if (mcontext == null)
      mcontext = ModuleContext.getContext();
    mcontext.addFlags(ModuleContext.IN_HTTP_SERVER);
    if (hctx.getClass().getName().endsWith("KawaServlet$Context"))
      mcontext.addFlags(ModuleContext.IN_SERVLET);
    Object[] cached = (Object[])mmap.get(path);
    
    String scriptPath = "";
    ModuleInfo minfo; if (cached != null) {
      ModuleInfo minfo = (ModuleInfo)cached[0];
      scriptPath = (String)cached[1];
    } else {
      minfo = null;
      scriptPath = path;
    }
    long now = System.currentTimeMillis();
    ModuleManager mmanager = mcontext.getManager();
    
    if ((minfo != null) && (now - lastCheckedTime < lastModifiedCacheTime))
    {
      if (path.startsWith(scriptPath)) {
        hctx.setScriptAndLocalPath(scriptPath, path.substring(scriptPath.length()));
      }
      else
        hctx.setScriptAndLocalPath("", path);
      return mcontext.findInstance(minfo);
    }
    
    int plen = path.length();
    
    hctx.setScriptAndLocalPath("", "");
    
    URL url = (plen == 0) || (path.charAt(plen - 1) == '/') ? null : hctx.getResourceURL(path);
    
    Path absPath = url == null ? null : Path.valueOf(url);
    String upath = path;
    if ((url == null) || (absPath.isDirectory()))
    {
      if (url != null)
        upath = path += '/';
      String xpath = path;
      for (;;)
      {
        int sl = xpath.lastIndexOf('/');
        xpath = sl < 0 ? "." : xpath.substring(0, sl);
        upath = xpath + "/+default+";
        url = hctx.getResourceURL(upath);
        if (url != null)
        {
          scriptPath = path.substring(0, sl + 1);
          hctx.setScriptAndLocalPath(scriptPath, path.substring(sl + 1));
          absPath = Path.valueOf(url);
        }
        else {
          if (sl < 0) {
            break;
          }
        }
      }
    } else {
      scriptPath = path;
      hctx.setScriptAndLocalPath(path, "");
    }
    
    if ((absPath == null) || (absPath.isDirectory()))
    {

      String msg = "The requested URL " + path + " was not found on this server. " + hctx.getResourceURL("/") + "\r\n";
      
      byte[] bmsg = msg.getBytes();
      hctx.sendResponseHeaders(404, null, bmsg.length);
      OutputStream out = hctx.getResponseStream();
      try
      {
        out.write(bmsg);
      }
      catch (IOException ex)
      {
        throw new RuntimeException(ex);
      }
      return null;
    }
    
    String urlString = url.toExternalForm();
    if ((minfo == null) || (!urlString.equals(minfo.getSourceAbsPathname())))
      minfo = mmanager.findWithURL(url);
    if (minfo.checkCurrent(mmanager, now)) {
      return mcontext.findInstance(minfo);
    }
    InputStream resourceStream = absPath.openInputStream();
    if (!(resourceStream instanceof BufferedInputStream))
    {

      resourceStream = new BufferedInputStream(resourceStream);
    }
    Language language = Language.getInstanceFromFilenameExtension(path);
    
    if (language != null) {
      hctx.log("Compile " + path + " - a " + language.getName() + " source file (based on extension)");
    }
    else
    {
      language = Language.detect(resourceStream);
      if (language != null) {
        hctx.log("Compile " + path + " - a " + language.getName() + " source file (detected from content)");
      }
      else {
        if (path != upath)
        {
          String msg = "The requested URL " + path + " was not found on this server." + " upath=" + upath + ".\r\n";
          
          byte[] bmsg = msg.getBytes();
          hctx.sendResponseHeaders(404, null, bmsg.length);
          OutputStream out = hctx.getResponseStream();
          try
          {
            out.write(bmsg);
          }
          catch (IOException ex)
          {
            throw new RuntimeException(ex);
          }
          return null;
        }
        HttpRequestContext.handleStaticFile(hctx, absPath);
        return null;
      }
    }
    InPort port = new InPort(resourceStream, absPath);
    Language.setCurrentLanguage(language);
    SourceMessages messages = new SourceMessages();
    
    Compilation comp;
    try
    {
      comp = language.parse(port, messages, 9, minfo);





    }
    catch (SyntaxException ex)
    {





      if (ex.getMessages() != messages) {
        throw ex;
      }
      comp = null;
    }
    
    Class cl = null;
    if (!messages.seenErrors())
    {
      ModuleExp mexp = comp.getModule();
      
      Environment env = Environment.getCurrent();
      cl = (Class)ModuleExp.evalModule1(env, comp, url, null);
    }
    
    if (messages.seenErrors())
    {




      String msg = "script syntax error:\n" + messages.toString(20);
      ((ServletPrinter)consumer).addHeader("Content-type", "text/plain");
      hctx.sendResponseHeaders(500, "Syntax errors", -1L);
      consumer.write(msg);
      minfo.cleanupAfterCompilation();
      return null;
    }
    
    minfo.setModuleClass(cl);
    mmap.put(path, new Object[] { minfo, scriptPath });
    



    return mcontext.findInstance(minfo);
  }
}
