/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Language;
import gnu.lists.FVector;
import gnu.mapping.Environment;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class ApplicationMainSupport {
    public static boolean processCommandLinePropertyAssignments;
    public static String[] commandLineArgArray;
    public static FVector commandLineArguments;
    public static ThreadLocation<String> commandName;
    static String[][] propertyFields;

    public static void processSetProperties() {
        String[] args = commandLineArgArray;
        if (args == null) {
            processCommandLinePropertyAssignments = true;
        } else {
            int iarg;
            for (iarg = 0; iarg < args.length && ApplicationMainSupport.processSetProperty(args[iarg]); ++iarg) {
            }
            if (iarg != 0) {
                ApplicationMainSupport.setArgs(args, iarg);
            }
        }
    }

    public static void processArgs(String[] args) {
        int iarg;
        if (processCommandLinePropertyAssignments) {
            for (iarg = 0; iarg < args.length && ApplicationMainSupport.processSetProperty(args[iarg]); ++iarg) {
            }
        }
        ApplicationMainSupport.setArgs(args, iarg);
    }

    public static void setArgs(String[] args, int arg_start) {
        ApplicationMainSupport.setArgs(args, arg_start, args.length - arg_start);
    }

    public static void setArgs(String[] args, int arg_start, int nargs) {
        if (commandName.get(null) == null) {
            try {
                String name = System.getProperty("kawa.command.name");
                if (name != null) {
                    commandName.set(name);
                }
            }
            catch (Exception ex) {
                // empty catch block
            }
        }
        if (arg_start == 0) {
            commandLineArgArray = args;
        } else {
            String[] strings2 = new String[nargs];
            int i = nargs;
            while (--i >= 0) {
                strings2[i] = args[i + arg_start];
            }
            commandLineArgArray = strings2;
        }
        Object[] array = new Object[nargs];
        System.arraycopy(args, arg_start, array, 0, nargs);
        commandLineArguments = FVector.makeConstant(array);
    }

    public static boolean processSetProperty(String arg) {
        String[] propertyField;
        int ci = arg.indexOf(61);
        if (ci <= 0) {
            return false;
        }
        String key = arg.substring(0, ci);
        String value = arg.substring(ci + 1);
        int i = 0;
        while ((propertyField = propertyFields[i]) != null) {
            if (key.equals(propertyField[0])) {
                String cname = propertyField[1];
                String fname = propertyField[2];
                try {
                    Class<?> clas = Class.forName(cname);
                    ThreadLocation loc = (ThreadLocation)clas.getDeclaredField(fname).get(null);
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
        Symbol symbol = Symbol.parse(key);
        Language.getDefaultLanguage();
        Environment current = Environment.getCurrent();
        current.define(symbol, null, value);
        return true;
    }

    static {
        commandName = new ThreadLocation("command-name");
        propertyFields = new String[][]{{"out:doctype-system", "gnu.xml.XMLPrinter", "doctypeSystem"}, {"out:doctype-public", "gnu.xml.XMLPrinter", "doctypePublic"}, {"out:base", "gnu.kawa.functions.DisplayFormat", "outBase"}, {"out:radix", "gnu.kawa.functions.DisplayFormat", "outRadix"}, {"out:line-length", "gnu.kawa.io.PrettyWriter", "lineLengthLoc"}, {"out:right-margin", "gnu.kawa.io.PrettyWriter", "lineLengthLoc"}, {"out:miser-width", "gnu.kawa.io.PrettyWriter", "miserWidthLoc"}, {"out:print-circle", "gnu.kawa.io.PrettyWriter", "isSharing"}, {"out:xml-indent", "gnu.xml.XMLPrinter", "indentLoc"}, {"display:toolkit", "gnu.kawa.models.Display", "myDisplay"}, {"console:prompt1", "gnu.kawa.io.CheckConsole", "prompt1"}, {"console:prompt2", "gnu.kawa.io.CheckConsole", "prompt2"}, {"console:use-jline", "gnu.kawa.io.CheckConsole", "useJLine"}, {"console:jline-mouse", "gnu.kawa.io.CheckConsole", "useJLineMouse"}, {"console:type", "gnu.kawa.io.CheckConsole", "consoleType"}, null};
    }
}

