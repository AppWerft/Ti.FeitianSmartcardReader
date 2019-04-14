package gnu.kawa.io;

import gnu.lists.Consumer;
import gnu.mapping.ThreadLocation;
import gnu.text.Options;








public class CheckConsole
{
  private static int haveConsole;
  
  public CheckConsole() {}
  
  public static void setHaveConsole(boolean value)
  {
    haveConsole = value ? 1 : -1;
    setDomTermVersionInfo();
  }
  
  public static boolean haveConsole() {
    if (haveConsole > 0)
      return true;
    if (haveConsole < 0) {
      return false;
    }
    

    return true;
  }
  

  public static final ThreadLocation<String> prompt1 = new ThreadLocation("prompt1");
  

  public static final ThreadLocation<String> prompt2 = new ThreadLocation("prompt2");
  

  public static final ThreadLocation useJLine = new ThreadLocation("use-jline");
  

  public static final ThreadLocation useJLineMouse = new ThreadLocation("jline-mouse");
  

  public static String consoleTypeDefault = "google-chrome;browser;javafx;swing;console";
  public static final ThreadLocation consoleType = new ThreadLocation("type");
  static String domtermProperty;
  
  public static int useJLine() { return getBoolean(useJLine); }
  public static int useJLineMouse() { return getBoolean(useJLineMouse); }
  
  public static String consoleType() {
    Object val = consoleType.get(null);
    return val == null ? consoleTypeDefault : val.toString();
  }
  
  private static int getBoolean(ThreadLocation loc) {
    Object val = loc.get(null);
    if (val == null)
      return 0;
    String sval = val.toString();
    Boolean bval = Options.booleanValue(val.toString());
    return bval.booleanValue() ? 1 : bval == null ? 0 : -1;
  }
  

  public static boolean forDomTerm(Consumer out)
  {
    return ((out instanceof OutPort)) && (((OutPort)out).isDomTerm());
  }
  

  static String domtermEnv;
  
  static String versionInfoDomTerm;
  public static String getDomTermVersionInfo()
  {
    return versionInfoDomTerm;
  }
  
  private static void setDomTermVersionInfo() {
    String version = domtermProperty;
    if ((version == null) && (haveConsole()))
      version = domtermEnv;
    if (version != null) {
      version = version.trim();
      if (version.length() > 0) {
        versionInfoDomTerm = version;
      }
    }
  }
  
  static
  {
    try
    {
      domtermProperty = System.getProperty("org.domterm");
      domtermEnv = System.getenv("DOMTERM");
      setDomTermVersionInfo();
    }
    catch (Throwable ex) {}
  }
}
