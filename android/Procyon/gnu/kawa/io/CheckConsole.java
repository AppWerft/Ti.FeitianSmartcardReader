// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import gnu.lists.Consumer;
import gnu.text.Options;
import gnu.mapping.ThreadLocation;

public class CheckConsole
{
    private static int haveConsole;
    public static final ThreadLocation<String> prompt1;
    public static final ThreadLocation<String> prompt2;
    public static final ThreadLocation useJLine;
    public static final ThreadLocation useJLineMouse;
    public static String consoleTypeDefault;
    public static final ThreadLocation consoleType;
    static String domtermProperty;
    static String domtermEnv;
    static String versionInfoDomTerm;
    
    public static void setHaveConsole(final boolean value) {
        CheckConsole.haveConsole = (value ? 1 : -1);
        setDomTermVersionInfo();
    }
    
    public static boolean haveConsole() {
        return CheckConsole.haveConsole > 0 || CheckConsole.haveConsole >= 0;
    }
    
    public static int useJLine() {
        return getBoolean(CheckConsole.useJLine);
    }
    
    public static int useJLineMouse() {
        return getBoolean(CheckConsole.useJLineMouse);
    }
    
    public static String consoleType() {
        final Object val = CheckConsole.consoleType.get(null);
        return (val == null) ? CheckConsole.consoleTypeDefault : val.toString();
    }
    
    private static int getBoolean(final ThreadLocation loc) {
        final Object val = loc.get(null);
        if (val == null) {
            return 0;
        }
        final String sval = val.toString();
        final Boolean bval = Options.booleanValue(val.toString());
        return (bval == null) ? 0 : (bval ? 1 : -1);
    }
    
    public static boolean forDomTerm(final Consumer out) {
        return out instanceof OutPort && ((OutPort)out).isDomTerm();
    }
    
    public static String getDomTermVersionInfo() {
        return CheckConsole.versionInfoDomTerm;
    }
    
    private static void setDomTermVersionInfo() {
        String version = CheckConsole.domtermProperty;
        if (version == null && haveConsole()) {
            version = CheckConsole.domtermEnv;
        }
        if (version != null) {
            version = version.trim();
            if (version.length() > 0) {
                CheckConsole.versionInfoDomTerm = version;
            }
        }
    }
    
    static {
        prompt1 = new ThreadLocation<String>("prompt1");
        prompt2 = new ThreadLocation<String>("prompt2");
        useJLine = new ThreadLocation("use-jline");
        useJLineMouse = new ThreadLocation("jline-mouse");
        CheckConsole.consoleTypeDefault = "google-chrome;browser;javafx;swing;console";
        consoleType = new ThreadLocation("type");
        try {
            CheckConsole.domtermProperty = System.getProperty("org.domterm");
            CheckConsole.domtermEnv = System.getenv("DOMTERM");
            setDomTermVersionInfo();
        }
        catch (Throwable t) {}
    }
}
