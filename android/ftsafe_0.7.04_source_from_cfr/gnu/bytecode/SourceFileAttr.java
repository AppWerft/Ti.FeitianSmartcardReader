/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import java.io.DataOutputStream;
import java.io.IOException;

public class SourceFileAttr
extends Attribute {
    String filename;
    int filename_index;

    public String getSourceFile() {
        return this.filename;
    }

    public void setSourceFile(String filename) {
        this.filename = filename;
        this.filename_index = 0;
    }

    public static String fixSourceFile(String fname) {
        char fsep0;
        String fsep = System.getProperty("file.separator", "/");
        if (fsep != null && fsep.length() == 1 && (fsep0 = fsep.charAt(0)) != '/') {
            fname = fname.replace(fsep0, '/');
        }
        return fname;
    }

    public static void setSourceFile(ClassType cl, String filename) {
        Attribute attr = Attribute.get(cl, "SourceFile");
        if (attr != null && attr instanceof SourceFileAttr) {
            ((SourceFileAttr)attr).setSourceFile(filename);
        } else {
            SourceFileAttr sattr = new SourceFileAttr(filename);
            sattr.addToFrontOf(cl);
        }
    }

    public SourceFileAttr(String filename) {
        super("SourceFile");
        this.filename = filename;
    }

    public SourceFileAttr(int index, ClassType ctype) {
        super("SourceFile");
        CpoolUtf8 filenameConstant = (CpoolUtf8)ctype.constants.getForced(index, 1);
        this.filename = filenameConstant.string;
        this.filename_index = index;
    }

    @Override
    public void assignConstants(ClassType cl) {
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
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.filename_index);
    }

    @Override
    public void print(ClassTypeWriter dst) {
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

