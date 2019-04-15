package gnu.kawa.util;

import gnu.expr.Language;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;










































public class RunTestScript
  implements Runnable
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
  List<String> expectedOut = new ArrayList();
  List<String> expectedErr = new ArrayList();
  
  String javaOptions = null;
  String kawaOptions = null;
  
  String[] commentSyntaxTable = { "CommonLisp", ";;", "#|", "|#", "Scheme", ";;", "#|", "|#", "Q2", "#", null, null };
  



  public RunTestScript(String filename, Language language)
  {
    this.filename = filename;
    this.language = language;
    if (language != null)
    {
      String langname = language.getName();
      for (int i = 0;; i += 4)
      {
        if (i >= commentSyntaxTable.length)
        {
          language = null;
          break;
        }
        if (langname.equals(commentSyntaxTable[i]))
        {
          lineComment = commentSyntaxTable[(i + 1)];
          startComment = commentSyntaxTable[(i + 2)];
          endComment = commentSyntaxTable[(i + 3)];
          break;
        }
      }
    }
    if (language == null)
      error("unknown or unsupported language");
    if (lineComment != null)
    {
      outPattern = Pattern.compile(Pattern.quote(lineComment) + ".*Output: *(.*) *$");
      outRegexPattern = Pattern.compile(Pattern.quote(lineComment) + ".*Output-pattern: *(.*) *$");
      errPattern = Pattern.compile(Pattern.quote(lineComment) + ".*Diagnostic: *(.*) *$");
      errRegexPattern = Pattern.compile(Pattern.quote(lineComment) + ".*Diagnostic-pattern: *(.*) *$");
      javaOptionsPattern = Pattern.compile(Pattern.quote(lineComment) + ".*Java-options: *(.*) *$");
      kawaOptionsPattern = Pattern.compile(Pattern.quote(lineComment) + ".*Kawa-options: *(.*) *$");
    }
    if (startComment != null)
    {
      outBlockStart = Pattern.compile(Pattern.quote(startComment) + ".*Output:.*$");
      errBlockStart = Pattern.compile(Pattern.quote(startComment) + ".*Diagnostic:.*$");
    }
  }
  
  public RunTestScript(String filename)
  {
    this(filename, Language.getInstanceFromFilenameExtension(filename));
  }
  
  public void run()
  {
    try
    {
      BufferedReader file = new BufferedReader(new FileReader(filename));
      for (;;)
      {
        String line = file.readLine();
        if (line == null) {
          break;
        }
        if (lineComment != null)
        {
          Matcher matcher = outPattern.matcher(line);
          if (matcher.matches())
            expectedOut.add(Pattern.quote(matcher.group(1)));
          matcher = outRegexPattern.matcher(line);
          if (matcher.matches())
            expectedOut.add(matcher.group(1));
          matcher = errPattern.matcher(line);
          if (matcher.matches())
            expectedErr.add(Pattern.quote(matcher.group(1)));
          matcher = errRegexPattern.matcher(line);
          if (matcher.matches())
            expectedErr.add(matcher.group(1));
          matcher = javaOptionsPattern.matcher(line);
          if (matcher.matches())
            javaOptions = matcher.group(1);
          matcher = kawaOptionsPattern.matcher(line);
          if (matcher.matches())
            kawaOptions = matcher.group(1);
        }
        if (startComment != null)
        {
          Matcher matcher = outBlockStart.matcher(line);
          if (matcher.matches())
          {
            for (;;)
            {
              line = file.readLine();
              if (line == null)
                error("non-terminated output block comment");
              if (line.trim().equals(endComment))
                break;
              expectedOut.add(Pattern.quote(line));
            }
          }
          matcher = errBlockStart.matcher(line);
          if (matcher.matches())
          {
            for (;;)
            {
              line = file.readLine();
              if (line == null)
                error("non-terminated disagnostic block comment");
              if (line.trim().equals(endComment))
                break;
              expectedErr.add(Pattern.quote(line));
            }
          }
        }
      }
      
      List<String> args = new ArrayList();
      args.add("java");
      if (javaOptions != null)
        parseAddString(javaOptions, args);
      args.add("kawa.repl");
      if (kawaOptions != null) {
        parseAddString(kawaOptions, args);
      } else {
        args.add("--diagnostic-strip-directories");
        args.add(filename);
      }
      ProcessBuilder kawa = new ProcessBuilder(args);
      Process process = kawa.start();
      BufferedReader out = new BufferedReader(new InputStreamReader(process.getInputStream()));
      BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
      process.waitFor();
      checkOutput(err, expectedErr, "diagnostics");
      checkOutput(out, expectedOut, "output");
      System.err.println("# " + getTestName() + (failed ? " fails" : " passes"));
    }
    catch (Throwable ex)
    {
      System.err.println("caught " + ex);
      ex.printStackTrace();
      System.exit(-1);
    }
  }
  
  void checkOutput(BufferedReader out, List<String> expectedOut, String source)
    throws Throwable
  {
    int i = 0;
    while (!failed)
    {
      String line = out.readLine();
      if (line == null)
      {
        if (i >= expectedOut.size()) break;
        fail("expected more " + source + ": " + (String)expectedOut.get(i)); break;
      }
      
      if (i >= expectedOut.size()) {
        fail("more " + source + " than expected: '" + line + "'");
      } else if (!Pattern.matches((String)expectedOut.get(i), line)) {
        fail(source + " line " + (i + 1) + ": expected: '" + (String)expectedOut.get(i) + "' actual: '" + line + "'");
      }
      i++;
    }
  }
  
  void parseAddString(String str, List<String> out) {
    int slen = str.length();
    StringBuilder sbuf = new StringBuilder();
    int inQuote = -1;
    boolean inToken = false;
    for (int i = 0;; i++) {
      int ch = i == slen ? '￿' : str.charAt(i);
      if ((ch < 0) || (((ch == 32) || (ch == 9)) && (inQuote < 0))) {
        if (inToken) {
          out.add(sbuf.toString());
          sbuf.setLength(0);
          inToken = false;
        }
        if (ch < 0)
          break;
      } else if (ch == inQuote) {
        inQuote = -1;
      }
      else if (inQuote >= 0) {
        sbuf.append((char)ch);
      }
      else if ((ch == 39) || (ch == 34)) {
        inQuote = ch;
        inToken = true;
      }
      else if ((ch == 37) && (i + 1 < slen)) {
        i++;
        char c2 = str.charAt(i);
        if (c2 == 'F') {
          sbuf.append(filename);
        } else
          sbuf.append(c2);
        inToken = true;
      }
      else {
        inToken = true;
        sbuf.append((char)ch);
      }
    }
  }
  
  String getTestName()
  {
    return new File(filename).getName();
  }
  
  void fail(String message)
  {
    System.err.println("FAIL " + getTestName() + ": " + message);
    failed = true;
  }
  
  void error(String message)
  {
    System.err.println("ERROR " + getTestName() + ": " + message);
    System.exit(-1);
  }
  
  public static void main(String[] args)
  {
    boolean failed = false;
    for (int i = 0; i < args.length; i++)
    {
      RunTestScript runner = new RunTestScript(args[i]);
      runner.run();
      failed = (failed) || (failed);
    }
    if (failed) {
      System.exit(-1);
    }
  }
}
