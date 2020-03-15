// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import java.io.IOException;
import java.io.Reader;
import java.io.InputStream;
import gnu.mapping.Procedure;

public class TtyInPort extends InPort
{
    protected OutPort tie;
    protected Procedure prompter;
    boolean inDomTerm;
    public Runnable sigIntHandler;
    int prompt1Length;
    protected boolean promptEmitted;
    
    public void setInDomTerm(final boolean v) {
        this.inDomTerm = v;
    }
    
    public Procedure getPrompter() {
        return this.prompter;
    }
    
    public void setPrompter(final Procedure prompter) {
        this.prompter = prompter;
    }
    
    public String promptTemplate1() {
        String str = CheckConsole.prompt1.get("");
        if (this.inDomTerm && !haveDomTermEscapes(str)) {
            str = "%{\u001b[19u\u001b[16u%}\u25bc%{\u001b[17u\u001b[14u%}" + str + "%{\u001b[15u%}";
        }
        return str;
    }
    
    public String promptTemplate2() {
        String str = CheckConsole.prompt2.get("");
        if (this.inDomTerm && !haveDomTermEscapes(str)) {
            str = "%{\u001b[24u%}" + str + "%{\u001b[18u\u001b[15u%}";
        }
        return str;
    }
    
    public String defaultPrompt() {
        if (this.readState == '\n') {
            return "";
        }
        final int line = this.getLineNumber() + 1;
        if (this.readState == ' ') {
            final String pattern = this.promptTemplate1();
            final int[] width = { 0 };
            final String str = this.expandPrompt(pattern, 0, line, "", width);
            this.prompt1Length = width[0];
            return str;
        }
        final String pattern = this.promptTemplate2();
        final String m = new String(new char[] { this.readState });
        return this.expandPrompt(pattern, this.prompt1Length, line, m, null);
    }
    
    public String expandPrompt(final String pattern, int padToWidth, final int line, final String message, final int[] width) {
        final StringBuilder sb = new StringBuilder();
        final int plen = pattern.length();
        int cols = 0;
        int padChar = -1;
        int padPos = -1;
        int escapeStartCol = -1;
        int i = 0;
        while (i < plen) {
            char ch = pattern.charAt(i++);
            if (ch == '%' && i < plen) {
                ch = pattern.charAt(i++);
                int count = -1;
                while (ch >= '0' && ch <= '9') {
                    count = ((count < 0) ? 0 : (10 * count)) + (ch - '0');
                    ch = pattern.charAt(i++);
                }
                switch (ch) {
                    case '%': {
                        sb.append(ch);
                        ++cols;
                        continue;
                    }
                    case 'N': {
                        final int oldw = sb.length();
                        sb.append(line);
                        cols += sb.length() - oldw;
                        continue;
                    }
                    case 'M': {
                        if (message != null) {
                            sb.append(message);
                            cols += message.length();
                            continue;
                        }
                        continue;
                    }
                    case 'P': {
                        if (count >= 0) {
                            padToWidth = count;
                        }
                        if (i < plen) {
                            padChar = pattern.charAt(i++);
                        }
                        padPos = sb.length();
                        continue;
                    }
                    case '{': {
                        escapeStartCol = cols;
                        continue;
                    }
                    case '}': {
                        cols = escapeStartCol;
                        escapeStartCol = -1;
                        continue;
                    }
                    default: {
                        --i;
                        continue;
                    }
                }
            }
            else {
                ++cols;
                if (Character.isLowSurrogate(ch)) {
                    --cols;
                }
                sb.append(ch);
            }
        }
        String str = sb.toString();
        if (padToWidth > cols) {
            final int padCharCols = 1;
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
    
    public TtyInPort(final InputStream in, final Path name, final OutPort tie) {
        super(in, name);
        this.prompt1Length = 0;
        this.setConvertCR(true);
        this.tie = tie;
    }
    
    public TtyInPort(final Reader in, final Path name, final OutPort tie) {
        super(in, name);
        this.prompt1Length = 0;
        this.setConvertCR(true);
        this.tie = tie;
    }
    
    @Override
    protected int fill(final int len) throws IOException {
        final int count = this.in.read(this.buffer, this.pos, len);
        if (this.tie != null && count > 0) {
            this.tie.echo(this.buffer, this.pos, count);
        }
        return count;
    }
    
    protected void afterFill(final int count) throws IOException {
        if (this.tie != null && count > 0) {
            this.tie.echo(this.buffer, this.pos, count);
        }
    }
    
    public void emitPrompt(final String prompt) throws IOException {
        this.tie.print(prompt);
        this.tie.flush();
        this.tie.clearBuffer();
    }
    
    public String wrapPromptForAnsi(final String prompt) {
        return "\u001b[38;5;120m" + prompt + "\u001b[39m";
    }
    
    public static boolean haveDomTermEscapes(final String prompt) {
        int i = prompt.length();
        while (--i >= 4) {
            if (prompt.charAt(i) == 'u' && prompt.charAt(i - 4) == '\u001b' && prompt.charAt(i - 3) == '[') {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void lineStart(final boolean revisited) throws IOException {
        if (!revisited) {
            this.promptEmitted = false;
            if (this.prompter != null) {
                try {
                    final Object prompt = (this.readState == '\n') ? null : ((this.readState == ' ') ? this.prompter.apply1(this) : this.defaultPrompt());
                    if (prompt != null) {
                        final String string = prompt.toString();
                        if (string != null && string.length() > 0) {
                            if (this.tie != null) {
                                this.tie.freshLine();
                            }
                            this.emitPrompt(string);
                            this.promptEmitted = true;
                        }
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
        if (this.tie != null) {
            this.tie.flush();
        }
        final int ch = super.read();
        if (ch < 0 && (this.promptEmitted & this.tie != null)) {
            this.tie.println();
        }
        this.promptEmitted = false;
        return ch;
    }
    
    @Override
    public int read(final char[] cbuf, final int off, final int len) throws IOException {
        if (this.tie != null) {
            this.tie.flush();
        }
        final int count = super.read(cbuf, off, len);
        if (count < 0 && (this.promptEmitted & this.tie != null)) {
            this.tie.println();
        }
        this.promptEmitted = false;
        return count;
    }
    
    public static TtyInPort make(final InputStream in, final Path name, final OutPort tie) {
        if (CheckConsole.useJLine() >= 0) {
            try {
                return (TtyInPort)Class.forName("gnu.kawa.io.JLineInPort").getConstructor(InputStream.class, Path.class, OutPort.class).newInstance(in, name, tie);
            }
            catch (Throwable t) {}
        }
        return new TtyInPort(in, name, tie);
    }
}
