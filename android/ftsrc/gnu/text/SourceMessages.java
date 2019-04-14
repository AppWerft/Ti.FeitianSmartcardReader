package gnu.text;











public class SourceMessages
  implements SourceLocator
{
  private int errorCount = 0;
  SourceError firstError;
  SourceError lastError;
  SourceLocator locator;
  
  public SourceMessages() {}
  
  public SourceError getErrors() { return firstError; }
  

  String current_filename;
  
  int current_line;
  
  int current_column;
  public static boolean stripDirectoriesDefault = false;
  public boolean stripDirectories = stripDirectoriesDefault;
  

  public static boolean debugStackTraceOnWarning = false;
  

  public static boolean debugStackTraceOnError = false;
  


  public boolean seenErrors() { return errorCount > 0; }
  
  public boolean seenErrorsOrWarnings() { return firstError != null; }
  
  public int getErrorCount() {
    return errorCount;
  }
  
  public int getCount(String severities) {
    int count = 0;
    for (SourceError err = firstError; err != null; err = next)
    {
      if (severities.indexOf(severity) >= 0)
        count++;
    }
    return count;
  }
  
  public void clearErrors() {
    errorCount = 0;
  }
  
  public void clear() {
    firstError = (this.lastError = null);
    errorCount = 0;
  }
  

  SourceError lastPrevFilename = null;
  
  public boolean sortMessages;
  

  public void error(SourceError error)
  {
    if (severity == 'f') {
      errorCount = 1000;
    } else if ((severity != 'w') && (severity != 'i'))
      errorCount += 1;
    if ((fakeException == null) && (((debugStackTraceOnError) && ((severity == 'e') || (severity == 'f'))) || ((debugStackTraceOnWarning) && (severity == 'w'))))
    {



      fakeException = new Throwable();
    }
    

    if ((lastError != null) && (lastError.filename != null) && (!lastError.filename.equals(filename)))
    {
      lastPrevFilename = lastError; }
    SourceError prev = lastPrevFilename;
    if ((!sortMessages) || (severity == 'f'))
      prev = lastError; else {
      for (;;) {
        SourceError next;
        SourceError next;
        if (prev == null) {
          next = firstError;
        } else
          next = next;
        if (next == null)
          break;
        if ((line != 0) && (line != 0)) {
          if (line < line)
            break;
          if ((line == line) && (column != 0) && (column != 0) && 
          
            (column < column)) {
            break;
          }
        }
        prev = next;
      }
    }
    if (prev == null) {
      next = firstError;
      firstError = error;
    } else {
      next = next;
      next = error;
    }
    if (prev == lastError) {
      lastError = error;
    }
  }
  







  public void error(char severity, String filename, int line, int column, String message)
  {
    error(new SourceError(severity, filename, line, column, message));
  }
  
  public void error(char severity, SourceLocator location, String message) {
    error(new SourceError(severity, location, message));
  }
  
  public void error(char severity, String filename, int line, int column, String message, String code)
  {
    SourceError err = new SourceError(severity, filename, line, column, message);
    
    code = code;
    error(err);
  }
  
  public void error(char severity, SourceLocator location, String message, String code)
  {
    SourceError err = new SourceError(severity, location, message);
    code = code;
    error(err);
  }
  




  public void error(char severity, String message)
  {
    error(new SourceError(severity, current_filename, current_line, current_column, message));
  }
  
  public void error(char severity, String message, Throwable exception)
  {
    SourceError err = new SourceError(severity, current_filename, current_line, current_column, message);
    
    fakeException = exception;
    error(err);
  }
  
  public void error(char severity, String message, String code) {
    SourceError err = new SourceError(severity, current_filename, current_line, current_column, message);
    
    code = code;
    error(err);
  }
  
  public void printAll(Appendable out, int max)
  {
    int errCount = getCount("ef");
    int wrnCount = getCount("iw");
    int errLimit = (max >= 0) && (errCount > max) ? max : errCount;
    int wrnLimit = (max >= 0) && (errCount + wrnCount > max) ? max - errLimit : wrnCount;
    
    int skippedErrors = 0;
    int skippedWarnings = 0;
    int skippedInfo = 0;
    for (SourceError err = firstError; err != null; err = next) {
      if (severity == 'e') { errLimit--; if (errLimit < 0) {
          skippedErrors++; continue; } }
      if (severity == 'w') { wrnLimit--; if (wrnLimit < 0) {
          skippedWarnings++; continue; } }
      if (severity == 'i') { wrnLimit--; if (wrnLimit < 0) {
          skippedInfo++; continue;
        } }
      err.println(out, stripDirectories);
    }
    if (skippedErrors + skippedWarnings + skippedInfo > 0) {
      SourceError err = new SourceError('i', firstError.getFileName(), 0, 0, "skipped " + skippedErrors + " errors, " + skippedWarnings + " warnings, " + skippedInfo + " notes");
      



      err.println(out, stripDirectories);
    }
  }
  



  public String toString(int max)
  {
    if (firstError == null)
      return null;
    StringBuilder buffer = new StringBuilder();
    for (SourceError err = firstError; 
        err != null; err = next) { max--; if (max < 0) break;
      err.appendTo(buffer, stripDirectories, "\n");
    }
    return buffer.toString();
  }
  



  public boolean checkErrors(Appendable out, int max)
  {
    if (firstError != null) {
      printAll(out, max);
      firstError = (this.lastError = null);
      int saveCount = errorCount;
      errorCount = 0;
      return saveCount > 0;
    }
    return false;
  }
  
  public final void setSourceLocator(SourceLocator locator)
  {
    this.locator = (locator == this ? null : locator);
  }
  
  public final SourceLocator swapSourceLocator(SourceLocator locator) {
    SourceLocator save = this.locator;
    this.locator = locator;
    return save;
  }
  
  public final void setLocation(SourceLocator locator)
  {
    this.locator = null;
    current_line = locator.getLineNumber();
    current_column = locator.getColumnNumber();
    current_filename = locator.getFileName();
  }
  
  public String getPublicId() {
    return locator == null ? null : locator.getPublicId();
  }
  
  public String getSystemId() { return locator == null ? current_filename : locator.getSystemId(); }
  
  public boolean isStableSourceLocation() {
    return false;
  }
  
  public final String getFileName() { return current_filename; }
  
  public final int getLineNumber()
  {
    return locator == null ? current_line : locator.getLineNumber();
  }
  
  public final int getColumnNumber()
  {
    return locator == null ? current_column : locator.getColumnNumber();
  }
  

  public void setFile(String filename) { current_filename = filename; }
  
  public void setLine(int line) { current_line = line; }
  
  public void setColumn(int column) { current_column = column; }
  
  public void setLine(String filename, int line, int column)
  {
    current_filename = filename;
    current_line = line;
    current_column = column;
  }
}
