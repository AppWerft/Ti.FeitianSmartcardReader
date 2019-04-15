/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassFileInput;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ListCodeSize {
    public static void usage() {
        System.err.println("Usage: class methodname ...");
        System.exit(-1);
    }

    static void print(Method method) {
        System.out.print(method);
        CodeAttr code = method.getCode();
        if (code == null) {
            System.out.print(": no code");
        } else {
            System.out.print(": ");
            System.out.print(code.getPC());
            System.out.print(" bytes");
        }
        System.out.println();
    }

    public static final void main(String[] args) {
        if (args.length == 0) {
            ListCodeSize.usage();
        }
        String filename = args[0];
        try {
            FileInputStream inp = new FileInputStream(filename);
            ClassType ctype = new ClassType();
            new ClassFileInput(ctype, inp);
            if (args.length == 1) {
                for (Method method = ctype.getMethods(); method != null; method = method.getNext()) {
                    ListCodeSize.print(method);
                }
            } else {
                for (int i = 1; i < args.length; ++i) {
                    for (Method method = ctype.getMethods(); method != null; method = method.getNext()) {
                        StringBuffer sbuf = new StringBuffer();
                        sbuf.append(method.getName());
                        method.listParameters(sbuf);
                        sbuf.append(method.getReturnType().getName());
                        if (!sbuf.toString().startsWith(args[i])) continue;
                        ListCodeSize.print(method);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File " + filename + " not found");
            System.exit(-1);
        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

