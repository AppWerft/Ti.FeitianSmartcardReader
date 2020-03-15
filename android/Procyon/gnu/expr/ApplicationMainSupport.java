// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.Environment;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.lists.FVector;

public class ApplicationMainSupport
{
    public static boolean processCommandLinePropertyAssignments;
    public static String[] commandLineArgArray;
    public static FVector commandLineArguments;
    public static ThreadLocation<String> commandName;
    static String[][] propertyFields;
    
    public static void processSetProperties() {
        final String[] args = ApplicationMainSupport.commandLineArgArray;
        if (args == null) {
            ApplicationMainSupport.processCommandLinePropertyAssignments = true;
        }
        else {
            int iarg;
            for (iarg = 0; iarg < args.length && processSetProperty(args[iarg]); ++iarg) {}
            if (iarg != 0) {
                setArgs(args, iarg);
            }
        }
    }
    
    public static void processArgs(final String[] args) {
        int iarg = 0;
        if (ApplicationMainSupport.processCommandLinePropertyAssignments) {
            while (iarg < args.length && processSetProperty(args[iarg])) {
                ++iarg;
            }
        }
        setArgs(args, iarg);
    }
    
    public static void setArgs(final String[] args, final int arg_start) {
        setArgs(args, arg_start, args.length - arg_start);
    }
    
    public static void setArgs(final String[] args, final int arg_start, final int nargs) {
        if (ApplicationMainSupport.commandName.get(null) == null) {
            try {
                final String name = System.getProperty("kawa.command.name");
                if (name != null) {
                    ApplicationMainSupport.commandName.set(name);
                }
            }
            catch (Exception ex) {}
        }
        if (arg_start == 0) {
            ApplicationMainSupport.commandLineArgArray = args;
        }
        else {
            final String[] strings = new String[nargs];
            int i = nargs;
            while (--i >= 0) {
                strings[i] = args[i + arg_start];
            }
            ApplicationMainSupport.commandLineArgArray = strings;
        }
        final Object[] array = new Object[nargs];
        System.arraycopy(args, arg_start, array, 0, nargs);
        ApplicationMainSupport.commandLineArguments = FVector.makeConstant(array);
    }
    
    public static boolean processSetProperty(final String arg) {
        final int ci = arg.indexOf(61);
        if (ci <= 0) {
            return false;
        }
        final String key = arg.substring(0, ci);
        final String value = arg.substring(ci + 1);
        int i = 0;
        while (true) {
            final String[] propertyField = ApplicationMainSupport.propertyFields[i];
            if (propertyField == null) {
                break;
            }
            if (key.equals(propertyField[0])) {
                final String cname = propertyField[1];
                final String fname = propertyField[2];
                try {
                    final Class clas = Class.forName(cname);
                    final ThreadLocation loc = (ThreadLocation)clas.getDeclaredField(fname).get(null);
                    loc.setGlobal(value);
                    break;
                }
                catch (Exception ex) {
                    System.err.println("error setting property " + key + " field " + cname + '.' + fname + ": " + ex);
                    System.exit(-1);
                }
            }
            ++i;
        }
        final Symbol symbol = Symbol.parse(key);
        Language.getDefaultLanguage();
        final Environment current = Environment.getCurrent();
        current.define(symbol, null, value);
        return true;
    }
    
    static {
        ApplicationMainSupport.commandName = new ThreadLocation<String>("command-name");
        ApplicationMainSupport.propertyFields = new String[][] { { "out:doctype-system", "gnu.xml.XMLPrinter", "doctypeSystem" }, { "out:doctype-public", "gnu.xml.XMLPrinter", "doctypePublic" }, { "out:base", "gnu.kawa.functions.DisplayFormat", "outBase" }, { "out:radix", "gnu.kawa.functions.DisplayFormat", "outRadix" }, { "out:line-length", "gnu.kawa.io.PrettyWriter", "lineLengthLoc" }, { "out:right-margin", "gnu.kawa.io.PrettyWriter", "lineLengthLoc" }, { "out:miser-width", "gnu.kawa.io.PrettyWriter", "miserWidthLoc" }, { "out:print-circle", "gnu.kawa.io.PrettyWriter", "isSharing" }, { "out:xml-indent", "gnu.xml.XMLPrinter", "indentLoc" }, { "display:toolkit", "gnu.kawa.models.Display", "myDisplay" }, { "console:prompt1", "gnu.kawa.io.CheckConsole", "prompt1" }, { "console:prompt2", "gnu.kawa.io.CheckConsole", "prompt2" }, { "console:use-jline", "gnu.kawa.io.CheckConsole", "useJLine" }, { "console:jline-mouse", "gnu.kawa.io.CheckConsole", "useJLineMouse" }, { "console:type", "gnu.kawa.io.CheckConsole", "consoleType" }, null };
    }
}
