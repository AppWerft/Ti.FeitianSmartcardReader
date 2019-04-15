/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.io.CheckConsole;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.mapping.Procedure;
import gnu.mapping.ThreadLocation;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Constructor;

public class TtyInPort
extends InPort {
    protected OutPort tie;
    protected Procedure prompter;
    boolean inDomTerm;
    public Runnable sigIntHandler;
    int prompt1Length = 0;
    protected boolean promptEmitted;

    public void setInDomTerm(boolean v) {
        this.inDomTerm = v;
    }

    public Procedure getPrompter() {
        return this.prompter;
    }

    public void setPrompter(Procedure prompter) {
        this.prompter = prompter;
    }

    public String promptTemplate1() {
        String str = CheckConsole.prompt1.get("");
        if (this.inDomTerm && !TtyInPort.haveDomTermEscapes(str)) {
            str = "%{\u001b[19u\u001b[16u%}\u25bc%{\u001b[17u\u001b[14u%}" + str + "%{\u001b[15u%}";
        }
        return str;
    }

    public String promptTemplate2() {
        String str = CheckConsole.prompt2.get("");
        if (this.inDomTerm && !TtyInPort.haveDomTermEscapes(str)) {
            str = "%{\u001b[24u%}" + str + "%{\u001b[18u\u001b[15u%}";
        }
        return str;
    }

    public String defaultPrompt() {
        if (this.readState == '\n') {
            return "";
        }
        int line = this.getLineNumber() + 1;
        if (this.readState == ' ') {
            String pattern = this.promptTemplate1();
            int[] width = new int[1];
            String str = this.expandPrompt(pattern, 0, line, "", width);
            this.prompt1Length = width[0];
            return str;
        }
        String pattern = this.promptTemplate2();
        String m = new String(new char[]{this.readState});
        return this.expandPrompt(pattern, this.prompt1Length, line, m, null);
    }

    public String expandPrompt(String pattern, int padToWidth, int line, String message, int[] width) {
        StringBuilder sb = new StringBuilder();
        int plen = pattern.length();
        int cols = 0;
        int padChar = -1;
        int padPos = -1;
        int escapeStartCol = -1;
        int i = 0;
        block8 : while (i < plen) {
            char ch;
            if ((ch = pattern.charAt(i++)) == '%' && i < plen) {
                ch = pattern.charAt(i++);
                int count = -1;
                while (ch >= '0' && ch <= '9') {
                    count = (count < 0 ? 0 : 10 * count) + (ch - 48);
                    ch = pattern.charAt(i++);
                }
                switch (ch) {
                    case '%': {
                        sb.append(ch);
                        ++cols;
                        break;
                    }
                    case 'N': {
                        int oldw = sb.length();
                        sb.append(line);
                        cols += sb.length() - oldw;
                        break;
                    }
                    case 'M': {
                        if (message == null) continue block8;
                        sb.append(message);
                        cols += message.length();
                        break;
                    }
                    case 'P': {
                        if (count >= 0) {
                            padToWidth = count;
                        }
                        if (i < plen) {
                            padChar = pattern.charAt(i++);
                        }
                        padPos = sb.length();
                        break;
                    }
                    case '{': {
                        escapeStartCol = cols;
                        break;
                    }
                    case '}': {
                        cols = escapeStartCol;
                        escapeStartCol = -1;
                        break;
                    }
                    default: {
                        --i;
                        break;
                    }
                }
                continue;
            }
            ++cols;
            if (Character.isLowSurrogate(ch)) {
                --cols;
            }
            sb.append(ch);
        }
        String str = sb.toString();
        if (padToWidth > cols) {
            int padCharCols = 1;
            int padCount = (padToWidth - cols) / padCharCols;
            cols += padCount;
            while (--padCount >= 0) {
                sb.insert(padPos, (char)padChar);
            }
            str = sb.toString();
        }
        if (width != null) {
            width[0] = cols;
        }
        return str;
    }

    public TtyInPort(InputStream in, Path name, OutPort tie) {
        super(in, name);
        this.setConvertCR(true);
        this.tie = tie;
    }

    public TtyInPort(Reader in, Path name, OutPort tie) {
        super(in, name);
        this.setConvertCR(true);
        this.tie = tie;
    }

    @Override
    protected int fill(int len) throws IOException {
        int count = this.in.read(this.buffer, this.pos, len);
        if (this.tie != null && count > 0) {
            this.tie.echo(this.buffer, this.pos, count);
        }
        return count;
    }

    protected void afterFill(int count) throws IOException {
        if (this.tie != null && count > 0) {
            this.tie.echo(this.buffer, this.pos, count);
        }
    }

    public void emitPrompt(String prompt) throws IOException {
        this.tie.print(prompt);
        this.tie.flush();
        this.tie.clearBuffer();
    }

    public String wrapPromptForAnsi(String prompt) {
        return "\u001b[38;5;120m" + prompt + "\u001b[39m";
    }

    public static boolean haveDomTermEscapes(String prompt) {
        int i = prompt.length();
        while (--i >= 4) {
            if (prompt.charAt(i) != 'u' || prompt.charAt(i - 4) != '\u001b' || prompt.charAt(i - 3) != '[') continue;
            return true;
        }
        return false;
    }

    @Override
    public void lineStart(boolean revisited) throws IOException {
        if (!revisited) {
            this.promptEmitted = false;
            if (this.prompter != null) {
                try {
                    String string;
                    String prompt;
                    String string2 = this.readState == '\n' ? null : (prompt = this.readState == ' ' ? this.prompter.apply1(this) : this.defaultPrompt());
                    if (prompt != null && (string = prompt.toString()) != null && string.length() > 0) {
                        if (this.tie != null) {
                            this.tie.freshLine();
                        }
                        this.emitPrompt(string);
                        this.promptEmitted = true;
                    }
                }
                catch (Throwable ex) {
                    throw new IOException("Error when evaluating prompt:" + ex);
                }
            }
            if (this.tie != null && !this.promptEmitted) {
                this.tie.flush();
                this.tie.clearBuffer();
            }
        }
    }

    @Override
    public int read() throws IOException {
        int ch;
        if (this.tie != null) {
            this.tie.flush();
        }
        if ((ch = super.read()) < 0 && this.promptEmitted & this.tie != null) {
            this.tie.println();
        }
        this.promptEmitted = false;
        return ch;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int count;
        if (this.tie != null) {
            this.tie.flush();
        }
        if ((count = super.read(cbuf, off, len)) < 0 && this.promptEmitted & this.tie != null) {
            this.tie.println();
        }
        this.promptEmitted = false;
        return count;
    }

    public static TtyInPort make(InputStream in, Path name, OutPort tie) {
        if (CheckConsole.useJLine() >= 0) {
            try {
                return (TtyInPort)Class.forName("gnu.kawa.io.JLineInPort").getConstructor(InputStream.class, Path.class, OutPort.class).newInstance(in, name, tie);
            }
            catch (Throwable ex) {
                // empty catch block
            }
        }
        return new TtyInPort(in, name, tie);
    }
}

