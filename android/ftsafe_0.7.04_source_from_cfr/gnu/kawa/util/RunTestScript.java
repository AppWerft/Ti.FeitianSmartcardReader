/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import gnu.expr.Language;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunTestScript
implements Runnable {
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
    List<String> expectedOut = new ArrayList<String>();
    List<String> expectedErr = new ArrayList<String>();
    String javaOptions = null;
    String kawaOptions = null;
    String[] commentSyntaxTable = new String[]{"CommonLisp", ";;", "#|", "|#", "Scheme", ";;", "#|", "|#", "Q2", "#", null, null};

    public RunTestScript(String filename, Language language) {
        this.filename = filename;
        this.language = language;
        if (language != null) {
            String langname = language.getName();
            int i = 0;
            do {
                if (i >= this.commentSyntaxTable.length) {
                    language = null;
                    break;
                }
                if (langname.equals(this.commentSyntaxTable[i])) {
                    this.lineComment = this.commentSyntaxTable[i + 1];
                    this.startComment = this.commentSyntaxTable[i + 2];
                    this.endComment = this.commentSyntaxTable[i + 3];
                    break;
                }
                i += 4;
            } while (true);
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

    public RunTestScript(String filename) {
        this(filename, Language.getInstanceFromFilenameExtension(filename));
    }

    @Override
    public void run() {
        try {
            String line;
            BufferedReader file2 = new BufferedReader(new FileReader(this.filename));
            block2 : while ((line = file2.readLine()) != null) {
                Matcher matcher;
                if (this.lineComment != null) {
                    matcher = this.outPattern.matcher(line);
                    if (matcher.matches()) {
                        this.expectedOut.add(Pattern.quote(matcher.group(1)));
                    }
                    if ((matcher = this.outRegexPattern.matcher(line)).matches()) {
                        this.expectedOut.add(matcher.group(1));
                    }
                    if ((matcher = this.errPattern.matcher(line)).matches()) {
                        this.expectedErr.add(Pattern.quote(matcher.group(1)));
                    }
                    if ((matcher = this.errRegexPattern.matcher(line)).matches()) {
                        this.expectedErr.add(matcher.group(1));
                    }
                    if ((matcher = this.javaOptionsPattern.matcher(line)).matches()) {
                        this.javaOptions = matcher.group(1);
                    }
                    if ((matcher = this.kawaOptionsPattern.matcher(line)).matches()) {
                        this.kawaOptions = matcher.group(1);
                    }
                }
                if (this.startComment == null) continue;
                matcher = this.outBlockStart.matcher(line);
                if (matcher.matches()) {
                    do {
                        if ((line = file2.readLine()) == null) {
                            this.error("non-terminated output block comment");
                        }
                        if (line.trim().equals(this.endComment)) break;
                        this.expectedOut.add(Pattern.quote(line));
                    } while (true);
                }
                if (!(matcher = this.errBlockStart.matcher(line)).matches()) continue;
                do {
                    if ((line = file2.readLine()) == null) {
                        this.error("non-terminated disagnostic block comment");
                    }
                    if (line.trim().equals(this.endComment)) continue block2;
                    this.expectedErr.add(Pattern.quote(line));
                } while (true);
            }
            ArrayList<String> args = new ArrayList<String>();
            args.add("java");
            if (this.javaOptions != null) {
                this.parseAddString(this.javaOptions, args);
            }
            args.add("kawa.repl");
            if (this.kawaOptions != null) {
                this.parseAddString(this.kawaOptions, args);
            } else {
                args.add("--diagnostic-strip-directories");
                args.add(this.filename);
            }
            ProcessBuilder kawa = new ProcessBuilder(args);
            Process process = kawa.start();
            BufferedReader out = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
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

    void checkOutput(BufferedReader out, List<String> expectedOut, String source) throws Throwable {
        int i = 0;
        while (!this.failed) {
            String line = out.readLine();
            if (line == null) {
                if (i >= expectedOut.size()) break;
                this.fail("expected more " + source + ": " + expectedOut.get(i));
                break;
            }
            if (i >= expectedOut.size()) {
                this.fail("more " + source + " than expected: '" + line + "'");
            } else if (!Pattern.matches(expectedOut.get(i), line)) {
                this.fail(source + " line " + (i + 1) + ": expected: '" + expectedOut.get(i) + "' actual: '" + line + "'");
            }
            ++i;
        }
    }

    void parseAddString(String str, List<String> out) {
        int slen = str.length();
        StringBuilder sbuf = new StringBuilder();
        int inQuote = -1;
        boolean inToken = false;
        int i = 0;
        do {
            int ch;
            int n = ch = i == slen ? -1 : (int)str.charAt(i);
            if (ch < 0 || (ch == 32 || ch == 9) && inQuote < 0) {
                if (inToken) {
                    out.add(sbuf.toString());
                    sbuf.setLength(0);
                    inToken = false;
                }
                if (ch < 0) {
                    break;
                }
            } else if (ch == inQuote) {
                inQuote = -1;
            } else if (inQuote >= 0) {
                sbuf.append((char)ch);
            } else if (ch == 39 || ch == 34) {
                inQuote = ch;
                inToken = true;
            } else if (ch == 37 && i + 1 < slen) {
                char c2;
                if ((c2 = str.charAt(++i)) == 'F') {
                    sbuf.append(this.filename);
                } else {
                    sbuf.append(c2);
                }
                inToken = true;
            } else {
                inToken = true;
                sbuf.append((char)ch);
            }
            ++i;
        } while (true);
    }

    String getTestName() {
        return new File(this.filename).getName();
    }

    void fail(String message) {
        System.err.println("FAIL " + this.getTestName() + ": " + message);
        this.failed = true;
    }

    void error(String message) {
        System.err.println("ERROR " + this.getTestName() + ": " + message);
        System.exit(-1);
    }

    public static void main(String[] args) {
        boolean failed = false;
        for (int i = 0; i < args.length; ++i) {
            RunTestScript runner = new RunTestScript(args[i]);
            runner.run();
            failed = failed || runner.failed;
        }
        if (failed) {
            System.exit(-1);
        }
    }
}

