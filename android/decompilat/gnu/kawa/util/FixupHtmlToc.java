// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.io.File;

public class FixupHtmlToc
{
    static FileInfo[] argFiles;
    
    public static void main(final String[] args) {
        try {
            FixupHtmlToc.argFiles = new FileInfo[args.length];
            for (int i = 0; i < args.length; ++i) {
                final FileInfo info = FileInfo.find(new File(args[i]));
                info.writeNeeded = true;
                FixupHtmlToc.argFiles[i] = info;
            }
            for (int i = 0; i < args.length; ++i) {
                FixupHtmlToc.argFiles[i].scan();
                FixupHtmlToc.argFiles[i].write();
            }
        }
        catch (Throwable ex) {
            System.err.println("caught " + ex);
            ex.printStackTrace();
        }
    }
}
