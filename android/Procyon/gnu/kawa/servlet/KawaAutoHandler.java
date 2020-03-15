// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.servlet;

import gnu.expr.Compilation;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import gnu.expr.ModuleManager;
import gnu.kawa.io.OutPort;
import gnu.expr.ModuleExp;
import gnu.mapping.Environment;
import gnu.text.SyntaxException;
import gnu.text.SourceMessages;
import gnu.kawa.io.InPort;
import gnu.expr.Language;
import java.io.BufferedInputStream;
import java.io.IOException;
import gnu.kawa.io.Path;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleContext;
import java.util.Hashtable;
import gnu.expr.ModuleBody;
import gnu.mapping.CallContext;

public class KawaAutoHandler
{
    static final String MODULE_MAP_ATTRIBUTE = "gnu.kawa.module-map";
    
    public static void run(final HttpRequestContext hctx, final CallContext ctx) throws Throwable {
        final boolean saveClass = hctx.getRequestParameter("qexo-save-class") != null;
        final Object mod = getModule(hctx, ctx, saveClass);
        if (mod instanceof ModuleBody) {
            ((ModuleBody)mod).run(ctx);
        }
    }
    
    public static Object getModule(final HttpRequestContext hctx, final CallContext ctx, final boolean saveClass) throws Exception {
        String path = hctx.getRequestPath();
        path = path.substring(hctx.getContextPath().length());
        Hashtable mmap = (Hashtable)hctx.getAttribute("gnu.kawa.module-map");
        if (mmap == null) {
            mmap = new Hashtable();
            hctx.setAttribute("gnu.kawa.module-map", mmap);
        }
        ModuleContext mcontext = (ModuleContext)hctx.getAttribute("gnu.kawa.module-context");
        if (mcontext == null) {
            mcontext = ModuleContext.getContext();
        }
        mcontext.addFlags(ModuleContext.IN_HTTP_SERVER);
        if (hctx.getClass().getName().endsWith("KawaServlet$Context")) {
            mcontext.addFlags(ModuleContext.IN_SERVLET);
        }
        final Object[] cached = mmap.get(path);
        String scriptPath = "";
        ModuleInfo minfo;
        if (cached != null) {
            minfo = (ModuleInfo)cached[0];
            scriptPath = (String)cached[1];
        }
        else {
            minfo = null;
            scriptPath = path;
        }
        final long now = System.currentTimeMillis();
        final ModuleManager mmanager = mcontext.getManager();
        if (minfo != null && now - minfo.lastCheckedTime < mmanager.lastModifiedCacheTime) {
            if (path.startsWith(scriptPath)) {
                hctx.setScriptAndLocalPath(scriptPath, path.substring(scriptPath.length()));
            }
            else {
                hctx.setScriptAndLocalPath("", path);
            }
            return mcontext.findInstance(minfo);
        }
        final int plen = path.length();
        hctx.setScriptAndLocalPath("", "");
        URL url = (plen == 0 || path.charAt(plen - 1) == '/') ? null : hctx.getResourceURL(path);
        Path absPath = (url == null) ? null : Path.valueOf(url);
        String upath = path;
        if (url == null || absPath.isDirectory()) {
            if (url != null) {
                path = (upath = path + '/');
            }
            String xpath = path;
            int sl;
            do {
                sl = xpath.lastIndexOf(47);
                xpath = ((sl < 0) ? "." : xpath.substring(0, sl));
                upath = xpath + "/+default+";
                url = hctx.getResourceURL(upath);
                if (url != null) {
                    scriptPath = path.substring(0, sl + 1);
                    hctx.setScriptAndLocalPath(scriptPath, path.substring(sl + 1));
                    absPath = Path.valueOf(url);
                    break;
                }
            } while (sl >= 0);
        }
        else {
            scriptPath = path;
            hctx.setScriptAndLocalPath(path, "");
        }
        if (absPath == null || absPath.isDirectory()) {
            final String msg = "The requested URL " + path + " was not found on this server. " + hctx.getResourceURL("/") + "\r\n";
            final byte[] bmsg = msg.getBytes();
            hctx.sendResponseHeaders(404, null, bmsg.length);
            final OutputStream out = hctx.getResponseStream();
            try {
                out.write(bmsg);
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
        final String urlString = url.toExternalForm();
        if (minfo == null || !urlString.equals(minfo.getSourceAbsPathname())) {
            minfo = mmanager.findWithURL(url);
        }
        if (minfo.checkCurrent(mmanager, now)) {
            return mcontext.findInstance(minfo);
        }
        InputStream resourceStream = absPath.openInputStream();
        if (!(resourceStream instanceof BufferedInputStream)) {
            resourceStream = new BufferedInputStream(resourceStream);
        }
        Language language = Language.getInstanceFromFilenameExtension(path);
        if (language != null) {
            hctx.log("Compile " + path + " - a " + language.getName() + " source file (based on extension)");
        }
        else {
            language = Language.detect(resourceStream);
            if (language != null) {
                hctx.log("Compile " + path + " - a " + language.getName() + " source file (detected from content)");
            }
            else {
                if (path != upath) {
                    final String msg2 = "The requested URL " + path + " was not found on this server." + " upath=" + upath + ".\r\n";
                    final byte[] bmsg2 = msg2.getBytes();
                    hctx.sendResponseHeaders(404, null, bmsg2.length);
                    final OutputStream out2 = hctx.getResponseStream();
                    try {
                        out2.write(bmsg2);
                    }
                    catch (IOException ex2) {
                        throw new RuntimeException(ex2);
                    }
                    return null;
                }
                HttpRequestContext.handleStaticFile(hctx, absPath);
                return null;
            }
        }
        final InPort port = new InPort(resourceStream, absPath);
        Language.setCurrentLanguage(language);
        final SourceMessages messages = new SourceMessages();
        Compilation comp;
        try {
            comp = language.parse(port, messages, 9, minfo);
        }
        catch (SyntaxException ex3) {
            if (ex3.getMessages() != messages) {
                throw ex3;
            }
            comp = null;
        }
        Class cl = null;
        if (!messages.seenErrors()) {
            final ModuleExp mexp = comp.getModule();
            final Environment env = Environment.getCurrent();
            cl = (Class)ModuleExp.evalModule1(env, comp, url, null);
        }
        if (messages.seenErrors()) {
            final String msg3 = "script syntax error:\n" + messages.toString(20);
            ((ServletPrinter)ctx.consumer).addHeader("Content-type", "text/plain");
            hctx.sendResponseHeaders(500, "Syntax errors", -1L);
            ctx.consumer.write(msg3);
            minfo.cleanupAfterCompilation();
            return null;
        }
        minfo.setModuleClass(cl);
        mmap.put(path, new Object[] { minfo, scriptPath });
        return mcontext.findInstance(minfo);
    }
}
