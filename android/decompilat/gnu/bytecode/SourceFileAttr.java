// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class SourceFileAttr extends Attribute
{
    String filename;
    int filename_index;
    
    public String getSourceFile() {
        return this.filename;
    }
    
    public void setSourceFile(final String filename) {
        this.filename = filename;
        this.filename_index = 0;
    }
    
    public static String fixSourceFile(String fname) {
        final String fsep = System.getProperty("file.separator", "/");
        if (fsep != null && fsep.length() == 1) {
            final char fsep2 = fsep.charAt(0);
            if (fsep2 != '/') {
                fname = fname.replace(fsep2, '/');
            }
        }
        return fname;
    }
    
    public static void setSourceFile(final ClassType cl, final String filename) {
        final Attribute attr = Attribute.get(cl, "SourceFile");
        if (attr != null && attr instanceof SourceFileAttr) {
            ((SourceFileAttr)attr).setSourceFile(filename);
        }
        else {
            final SourceFileAttr sattr = new SourceFileAttr(filename);
            sattr.addToFrontOf(cl);
        }
    }
    
    public SourceFileAttr(final String filename) {
        super("SourceFile");
        this.filename = filename;
    }
    
    public SourceFileAttr(final int index, final ClassType ctype) {
        super("SourceFile");
        final CpoolUtf8 filenameConstant = (CpoolUtf8)ctype.constants.getForced(index, 1);
        this.filename = filenameConstant.string;
        this.filename_index = index;
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        if (this.filename_index == 0) {
            this.filename_index = cl.getConstants().addUtf8(this.filename).getIndex();
        }
    }
    
    @Override
    public final int getLength() {
        return 2;
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.filename_index);
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", ");
        dst.printOptionalIndex(this.filename_index);
        dst.print('\"');
        dst.print(this.getSourceFile());
        dst.println('\"');
    }
}
