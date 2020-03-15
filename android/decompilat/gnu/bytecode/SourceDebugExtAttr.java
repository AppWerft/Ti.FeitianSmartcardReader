// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class SourceDebugExtAttr extends Attribute
{
    byte[] data;
    int dlength;
    private String outputFileName;
    private String defaultStratumId;
    int fileCount;
    int[] fileIDs;
    String[] fileNames;
    int lineCount;
    int[] lines;
    int curLineIndex;
    int curFileIndex;
    int maxFileID;
    String curFileName;
    
    private int fixLine(final int sourceLine, final int index) {
        int sourceMin = this.lines[index];
        final int repeat = this.lines[index + 2];
        if (sourceLine < sourceMin) {
            if (index > 0) {
                return -1;
            }
            final int sourceMax = sourceMin + repeat - 1;
            this.lines[index] = sourceLine;
            this.lines[index + 2] = sourceMax - sourceLine + 1;
            this.lines[index + 3] = sourceLine;
            sourceMin = sourceLine;
        }
        final int delta = this.lines[index + 3] - sourceMin;
        if (sourceLine < sourceMin + repeat) {
            return sourceLine + delta;
        }
        if (index == 5 * (this.lineCount - 1) || (index == 0 && sourceLine < this.lines[8])) {
            this.lines[index + 2] = sourceLine - sourceMin + 1;
            return sourceLine + delta;
        }
        return -1;
    }
    
    int fixLine(int sourceLine) {
        if (this.curLineIndex >= 0) {
            final int outLine = this.fixLine(sourceLine, this.curLineIndex);
            if (outLine >= 0) {
                return outLine;
            }
        }
        int i5 = 0;
        final int findex = this.curFileIndex;
        for (int j = 0; j < this.lineCount; ++j) {
            if (i5 != this.curLineIndex && findex == this.lines[i5 + 1]) {
                final int outLine = this.fixLine(sourceLine, i5);
                if (outLine >= 0) {
                    this.curLineIndex = i5;
                    return outLine;
                }
            }
            i5 += 5;
        }
        if (this.lines == null) {
            this.lines = new int[20];
        }
        else if (i5 >= this.lines.length) {
            final int[] newLines = new int[2 * i5];
            System.arraycopy(this.lines, 0, newLines, 0, i5);
            this.lines = newLines;
        }
        final int inputStartLine = sourceLine;
        int outputStartLine;
        if (i5 == 0) {
            outputStartLine = sourceLine;
        }
        else {
            outputStartLine = this.lines[i5 - 5 + 3] + this.lines[i5 - 5 + 2];
            if (i5 == 5 && outputStartLine < 10000) {
                outputStartLine = 10000;
            }
            sourceLine = outputStartLine;
        }
        this.lines[i5] = inputStartLine;
        this.lines[i5 + 1] = findex;
        this.lines[i5 + 2] = 1;
        this.lines[i5 + 3] = outputStartLine;
        this.lines[i5 + 4] = 1;
        this.curLineIndex = i5;
        ++this.lineCount;
        return sourceLine;
    }
    
    void addFile(String fname) {
        if (this.curFileName == fname || (fname != null && fname.equals(this.curFileName))) {
            return;
        }
        this.curFileName = fname;
        fname = SourceFileAttr.fixSourceFile(fname);
        final int slash = fname.lastIndexOf(47);
        String fentry;
        if (slash >= 0) {
            final String fpath = fname;
            fname = fname.substring(slash + 1);
            fentry = fname + '\n' + fpath;
        }
        else {
            fentry = fname;
        }
        if (this.curFileIndex >= 0 && fentry.equals(this.fileNames[this.curFileIndex])) {
            return;
        }
        final int n = this.fileCount;
        for (int i = 0; i < n; ++i) {
            if (i != this.curFileIndex && fentry.equals(this.fileNames[i])) {
                this.curFileIndex = i;
                this.curLineIndex = -1;
                return;
            }
        }
        if (this.fileIDs == null) {
            this.fileIDs = new int[5];
            this.fileNames = new String[5];
        }
        else if (n >= this.fileIDs.length) {
            final int[] newIDs = new int[2 * n];
            final String[] newNames = new String[2 * n];
            System.arraycopy(this.fileIDs, 0, newIDs, 0, n);
            System.arraycopy(this.fileNames, 0, newNames, 0, n);
            this.fileIDs = newIDs;
            this.fileNames = newNames;
        }
        ++this.fileCount;
        int id = ++this.maxFileID;
        id <<= 1;
        if (slash >= 0) {
            ++id;
        }
        this.fileNames[n] = fentry;
        if (this.outputFileName == null) {
            this.outputFileName = fname;
        }
        this.fileIDs[n] = id;
        this.curFileIndex = n;
        this.curLineIndex = -1;
    }
    
    public void addStratum(final String name) {
        this.defaultStratumId = name;
    }
    
    public SourceDebugExtAttr(final ClassType cl) {
        super("SourceDebugExtension");
        this.curLineIndex = -1;
        this.curFileIndex = -1;
        this.addToFrontOf(cl);
    }
    
    void nonAsteriskString(final String str, final StringBuffer sbuf) {
        if (str == null || str.length() == 0 || str.charAt(0) == '*') {
            sbuf.append(' ');
        }
        sbuf.append(str);
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append("SMAP\n");
        this.nonAsteriskString(this.outputFileName, sbuf);
        sbuf.append('\n');
        final String stratum = (this.defaultStratumId == null) ? "Java" : this.defaultStratumId;
        this.nonAsteriskString(stratum, sbuf);
        sbuf.append('\n');
        sbuf.append("*S ");
        sbuf.append(stratum);
        sbuf.append('\n');
        sbuf.append("*F\n");
        for (int i = 0; i < this.fileCount; ++i) {
            int id = this.fileIDs[i];
            final boolean with_path = (id & 0x1) != 0x0;
            id >>= 1;
            if (with_path) {
                sbuf.append("+ ");
            }
            sbuf.append(id);
            sbuf.append(' ');
            sbuf.append(this.fileNames[i]);
            sbuf.append('\n');
        }
        if (this.lineCount > 0) {
            int prevFileID = 0;
            sbuf.append("*L\n");
            int j = 0;
            int i2 = 0;
            do {
                final int inputStartLine = this.lines[i2];
                final int lineFileID = this.fileIDs[this.lines[i2 + 1]] >> 1;
                final int repeatCount = this.lines[i2 + 2];
                final int outputStartLine = this.lines[i2 + 3];
                final int outputLineIncrement = this.lines[i2 + 4];
                sbuf.append(inputStartLine);
                if (lineFileID != prevFileID) {
                    sbuf.append('#');
                    sbuf.append(lineFileID);
                    prevFileID = lineFileID;
                }
                if (repeatCount != 1) {
                    sbuf.append(',');
                    sbuf.append(repeatCount);
                }
                sbuf.append(':');
                sbuf.append(outputStartLine);
                if (outputLineIncrement != 1) {
                    sbuf.append(',');
                    sbuf.append(outputLineIncrement);
                }
                sbuf.append('\n');
                i2 += 5;
            } while (++j < this.lineCount);
        }
        sbuf.append("*E\n");
        try {
            this.data = sbuf.toString().getBytes("UTF-8");
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
        this.dlength = this.data.length;
    }
    
    @Override
    public int getLength() {
        return this.dlength;
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.write(this.data, 0, this.dlength);
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.println(this.dlength);
        try {
            dst.print(new String(this.data, 0, this.dlength, "UTF-8"));
        }
        catch (Exception ex) {
            dst.print("(Caught ");
            dst.print(ex);
            dst.println(')');
        }
        if (this.dlength > 0 && this.data[this.dlength - 1] != 13 && this.data[this.dlength - 1] != 10) {
            dst.println();
        }
    }
}
