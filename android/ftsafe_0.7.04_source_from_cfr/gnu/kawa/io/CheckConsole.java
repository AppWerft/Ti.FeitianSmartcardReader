/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.mapping.ThreadLocation;
import gnu.text.Options;

public class CheckConsole {
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

    public static void setHaveConsole(boolean value) {
        haveConsole = value ? 1 : -1;
        CheckConsole.setDomTermVersionInfo();
    }

    public static boolean haveConsole() {
        if (haveConsole > 0) {
            return true;
        }
        return haveConsole >= 0;
    }

    public static int useJLine() {
        return CheckConsole.getBoolean(useJLine);
    }

    public static int useJLineMouse() {
        return CheckConsole.getBoolean(useJLineMouse);
    }

    public static String consoleType() {
        Object val = consoleType.get(null);
        return val == null ? consoleTypeDefault : val.toString();
    }

    private static int getBoolean(ThreadLocation loc) {
        Object val = loc.get(null);
        if (val == null) {
            return 0;
        }
        String sval = val.toString();
        Boolean bval = Options.booleanValue(val.toString());
        return bval == null ? 0 : (bval != false ? 1 : -1);
    }

    public static boolean forDomTerm(Consumer out) {
        return out instanceof OutPort && ((OutPort)out).isDomTerm();
    }

    public static String getDomTermVersionInfo() {
        return versionInfoDomTerm;
    }

    private static void setDomTermVersionInfo() {
        String version = domtermProperty;
        if (version == null && CheckConsole.haveConsole()) {
            version = domtermEnv;
        }
        if (version != null && (version = version.trim()).length() > 0) {
            versionInfoDomTerm = version;
        }
    }

    static {
        prompt1 = new ThreadLocation("prompt1");
        prompt2 = new ThreadLocation("prompt2");
        useJLine = new ThreadLocation("use-jline");
        useJLineMouse = new ThreadLocation("jline-mouse");
        consoleTypeDefault = "google-chrome;browser;javafx;swing;console";
        consoleType = new ThreadLocation("type");
        try {
            domtermProperty = System.getProperty("org.domterm");
            domtermEnv = System.getenv("DOMTERM");
            CheckConsole.setDomTermVersionInfo();
        }
        catch (Throwable ex) {
            // empty catch block
        }
    }
}

