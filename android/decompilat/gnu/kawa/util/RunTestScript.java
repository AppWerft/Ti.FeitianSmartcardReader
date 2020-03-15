// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.io.File;
import java.util.regex.Matcher;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import gnu.expr.Language;

public class RunTestScript implements Runnable
{
    String filename;
    Language language;
    String lineComment;
    String startComment;
    String endComment;
    Pattern outPattern;
    Pattern outRegexPattern;
    Pattern errPattern;
    Pattern errRegexPattern;
    Pattern outBlockStart;
    Pattern errBlockStart;
    Pattern javaOptionsPattern;
    Pattern kawaOptionsPattern;
    boolean failed;
    List<String> expectedOut;
    List<String> expectedErr;
    String javaOptions;
    String kawaOptions;
    String[] commentSyntaxTable;
    
    public RunTestScript(final String filename, Language language) {
        this.expectedOut = new ArrayList<String>();
        this.expectedErr = new ArrayList<String>();
        this.javaOptions = null;
        this.kawaOptions = null;
        this.commentSyntaxTable = new String[] { "CommonLisp", ";;", "#|", "|#", "Scheme", ";;", "#|", "|#", "Q2", "#", null, null };
        this.filename = filename;
        this.language = language;
        Label_0208: {
            if (language != null) {
                final String langname = language.getName();
                for (int i = 0; i < this.commentSyntaxTable.length; i += 4) {
                    if (langname.equals(this.commentSyntaxTable[i])) {
                        this.lineComment = this.commentSyntaxTable[i + 1];
                        this.startComment = this.commentSyntaxTable[i + 2];
                        this.endComment = this.commentSyntaxTable[i + 3];
                        break Label_0208;
                    }
                }
                language = null;
            }
        }
        if (language == null) {
            this.error("unknown or unsupported language");
        }
        if (this.lineComment != null) {
            this.outPattern = Pattern.compile(Pattern.quote(this.lineComment) + ".*Output: *(.*) *$");
            this.outRegexPattern = Pattern.compile(Pattern.quote(this.lineComment) + ".*Output-pattern: *(.*) *$");
            this.errPattern = Pattern.compile(Pattern.quote(this.lineComment) + ".*Diagnostic: *(.*) *$");
            this.errRegexPattern = Pattern.compile(Pattern.quote(this.lineComment) + ".*Diagnostic-pattern: *(.*) *$");
            this.javaOptionsPattern = Pattern.compile(Pattern.quote(this.lineComment) + ".*Java-options: *(.*) *$");
            this.kawaOptionsPattern = Pattern.compile(Pattern.quote(this.lineComment) + ".*Kawa-options: *(.*) *$");
        }
        if (this.startComment != null) {
            this.outBlockStart = Pattern.compile(Pattern.quote(this.startComment) + ".*Output:.*$");
            this.errBlockStart = Pattern.compile(Pattern.quote(this.startComment) + ".*Diagnostic:.*$");
        }
    }
    
    public RunTestScript(final String filename) {
        this(filename, Language.getInstanceFromFilenameExtension(filename));
    }
    
    @Override
    public void run() {
        try {
            final BufferedReader file = new BufferedReader(new FileReader(this.filename));
            while (true) {
                String line = file.readLine();
                if (line == null) {
                    break;
                }
                if (this.lineComment != null) {
                    Matcher matcher = this.outPattern.matcher(line);
                    if (matcher.matches()) {
                        this.expectedOut.add(Pattern.quote(matcher.group(1)));
                    }
                    matcher = this.outRegexPattern.matcher(line);
                    if (matcher.matches()) {
                        this.expectedOut.add(matcher.group(1));
                    }
                    matcher = this.errPattern.matcher(line);
                    if (matcher.matches()) {
                        this.expectedErr.add(Pattern.quote(matcher.group(1)));
                    }
                    matcher = this.errRegexPattern.matcher(line);
                    if (matcher.matches()) {
                        this.expectedErr.add(matcher.group(1));
                    }
                    matcher = this.javaOptionsPattern.matcher(line);
                    if (matcher.matches()) {
                        this.javaOptions = matcher.group(1);
                    }
                    matcher = this.kawaOptionsPattern.matcher(line);
                    if (matcher.matches()) {
                        this.kawaOptions = matcher.group(1);
                    }
                }
                if (this.startComment == null) {
                    continue;
                }
                Matcher matcher = this.outBlockStart.matcher(line);
                if (matcher.matches()) {
                    while (true) {
                        line = file.readLine();
                        if (line == null) {
                            this.error("non-terminated output block comment");
                        }
                        if (line.trim().equals(this.endComment)) {
                            break;
                        }
                        this.expectedOut.add(Pattern.quote(line));
                    }
                }
                matcher = this.errBlockStart.matcher(line);
                if (!matcher.matches()) {
                    continue;
                }
                while (true) {
                    line = file.readLine();
                    if (line == null) {
                        this.error("non-terminated disagnostic block comment");
                    }
                    if (line.trim().equals(this.endComment)) {
                        break;
                    }
                    this.expectedErr.add(Pattern.quote(line));
                }
            }
            final List<String> args = new ArrayList<String>();
            args.add("java");
            if (this.javaOptions != null) {
                this.parseAddString(this.javaOptions, args);
            }
            args.add("kawa.repl");
            if (this.kawaOptions != null) {
                this.parseAddString(this.kawaOptions, args);
            }
            else {
                args.add("--diagnostic-strip-directories");
                args.add(this.filename);
            }
            final ProcessBuilder kawa = new ProcessBuilder(args);
            final Process process = kawa.start();
            final BufferedReader out = new BufferedReader(new InputStreamReader(process.getInputStream()));
            final BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            process.waitFor();
            this.checkOutput(err, this.expectedErr, "diagnostics");
            this.checkOutput(out, this.expectedOut, "output");
            System.err.println("# " + this.getTestName() + (this.failed ? " fails" : " passes"));
        }
        catch (Throwable ex) {
            System.err.println("caught " + ex);
            ex.printStackTrace();
            System.exit(-1);
        }
    }
    
    void checkOutput(final BufferedReader out, final List<String> expectedOut, final String source) throws Throwable {
        int i = 0;
        while (!this.failed) {
            final String line = out.readLine();
            if (line == null) {
                if (i < expectedOut.size()) {
                    this.fail("expected more " + source + ": " + expectedOut.get(i));
                    break;
                }
                break;
            }
            else {
                if (i >= expectedOut.size()) {
                    this.fail("more " + source + " than expected: '" + line + "'");
                }
                else if (!Pattern.matches(expectedOut.get(i), line)) {
                    this.fail(source + " line " + (i + 1) + ": expected: '" + expectedOut.get(i) + "' actual: '" + line + "'");
                }
                ++i;
            }
        }
    }
    
    void parseAddString(final String str, final List<String> out) {
        final int slen = str.length();
        final StringBuilder sbuf = new StringBuilder();
        int inQuote = -1;
        boolean inToken = false;
        int i = 0;
        while (true) {
            final int ch = (i == slen) ? -1 : str.charAt(i);
            if (ch < 0 || ((ch == 32 || ch == 9) && inQuote < 0)) {
                if (inToken) {
                    out.add(sbuf.toString());
                    sbuf.setLength(0);
                    inToken = false;
                }
                if (ch < 0) {
                    break;
                }
            }
            else if (ch == inQuote) {
                inQuote = -1;
            }
            else if (inQuote >= 0) {
                sbuf.append((char)ch);
            }
            else if (ch == 39 || ch == 34) {
                inQuote = ch;
                inToken = true;
            }
            else if (ch == 37 && i + 1 < slen) {
                ++i;
                final char c2 = str.charAt(i);
                if (c2 == 'F') {
                    sbuf.append(this.filename);
                }
                else {
                    sbuf.append(c2);
                }
                inToken = true;
            }
            else {
                inToken = true;
                sbuf.append((char)ch);
            }
            ++i;
        }
    }
    
    String getTestName() {
        return new File(this.filename).getName();
    }
    
    void fail(final String message) {
        System.err.println("FAIL " + this.getTestName() + ": " + message);
        this.failed = true;
    }
    
    void error(final String message) {
        System.err.println("ERROR " + this.getTestName() + ": " + message);
        System.exit(-1);
    }
    
    public static void main(final String[] args) {
        boolean failed = false;
        for (int i = 0; i < args.length; ++i) {
            final RunTestScript runner = new RunTestScript(args[i]);
            runner.run();
            failed = (failed || runner.failed);
        }
        if (failed) {
            System.exit(-1);
        }
    }
}
