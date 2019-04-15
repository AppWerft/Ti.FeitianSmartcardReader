/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import gnu.kawa.util.FileInfo;
import java.io.File;
import java.io.PrintStream;

public class FixupHtmlToc {
    static FileInfo[] argFiles;

    public static void main(String[] args) {
        try {
            int i;
            argFiles = new FileInfo[args.length];
            for (i = 0; i < args.length; ++i) {
                FileInfo info = FileInfo.find(new File(args[i]));
                info.writeNeeded = true;
                FixupHtmlToc.argFiles[i] = info;
            }
            for (i = 0; i < args.length; ++i) {
                argFiles[i].scan();
                argFiles[i].write();
            }
        }
        catch (Throwable ex) {
            System.err.println("caught " + ex);
            ex.printStackTrace();
        }
    }
}

