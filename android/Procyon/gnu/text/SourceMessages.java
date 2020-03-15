// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

public class SourceMessages implements SourceLocator
{
    private int errorCount;
    SourceError firstError;
    SourceError lastError;
    SourceLocator locator;
    String current_filename;
    int current_line;
    int current_column;
    public static boolean stripDirectoriesDefault;
    public boolean stripDirectories;
    public static boolean debugStackTraceOnWarning;
    public static boolean debugStackTraceOnError;
    SourceError lastPrevFilename;
    public boolean sortMessages;
    
    public SourceMessages() {
        this.errorCount = 0;
        this.stripDirectories = SourceMessages.stripDirectoriesDefault;
        this.lastPrevFilename = null;
    }
    
    public SourceError getErrors() {
        return this.firstError;
    }
    
    public boolean seenErrors() {
        return this.errorCount > 0;
    }
    
    public boolean seenErrorsOrWarnings() {
        return this.firstError != null;
    }
    
    public int getErrorCount() {
        return this.errorCount;
    }
    
    public int getCount(final String severities) {
        int count = 0;
        for (SourceError err = this.firstError; err != null; err = err.next) {
            if (severities.indexOf(err.severity) >= 0) {
                ++count;
            }
        }
        return count;
    }
    
    public void clearErrors() {
        this.errorCount = 0;
    }
    
    public void clear() {
        final SourceError sourceError = null;
        this.lastError = sourceError;
        this.firstError = sourceError;
        this.errorCount = 0;
    }
    
    public void error(final SourceError error) {
        if (error.severity == 'f') {
            this.errorCount = 1000;
        }
        else if (error.severity != 'w' && error.severity != 'i') {
            ++this.errorCount;
        }
        if (error.fakeException == null && ((SourceMessages.debugStackTraceOnError && (error.severity == 'e' || error.severity == 'f')) || (SourceMessages.debugStackTraceOnWarning && error.severity == 'w'))) {
            error.fakeException = new Throwable();
        }
        if (this.lastError != null && this.lastError.filename != null && !this.lastError.filename.equals(error.filename)) {
            this.lastPrevFilename = this.lastError;
        }
        SourceError prev = this.lastPrevFilename;
        if (!this.sortMessages || error.severity == 'f') {
            prev = this.lastError;
        }
        else {
            while (true) {
                SourceError next;
                if (prev == null) {
                    next = this.firstError;
                }
                else {
                    next = prev.next;
                }
                if (next == null) {
                    break;
                }
                if (error.line != 0 && next.line != 0) {
                    if (error.line < next.line) {
                        break;
                    }
                    if (error.line == next.line && error.column != 0 && next.column != 0 && error.column < next.column) {
                        break;
                    }
                }
                prev = next;
            }
        }
        if (prev == null) {
            error.next = this.firstError;
            this.firstError = error;
        }
        else {
            error.next = prev.next;
            prev.next = error;
        }
        if (prev == this.lastError) {
            this.lastError = error;
        }
    }
    
    public void error(final char severity, final String filename, final int line, final int column, final String message) {
        this.error(new SourceError(severity, filename, line, column, message));
    }
    
    public void error(final char severity, final SourceLocator location, final String message) {
        this.error(new SourceError(severity, location, message));
    }
    
    public void error(final char severity, final String filename, final int line, final int column, final String message, final String code) {
        final SourceError err = new SourceError(severity, filename, line, column, message);
        err.code = code;
        this.error(err);
    }
    
    public void error(final char severity, final SourceLocator location, final String message, final String code) {
        final SourceError err = new SourceError(severity, location, message);
        err.code = code;
        this.error(err);
    }
    
    public void error(final char severity, final String message) {
        this.error(new SourceError(severity, this.current_filename, this.current_line, this.current_column, message));
    }
    
    public void error(final char severity, final String message, final Throwable exception) {
        final SourceError err = new SourceError(severity, this.current_filename, this.current_line, this.current_column, message);
        err.fakeException = exception;
        this.error(err);
    }
    
    public void error(final char severity, final String message, final String code) {
        final SourceError err = new SourceError(severity, this.current_filename, this.current_line, this.current_column, message);
        err.code = code;
        this.error(err);
    }
    
    public void printAll(final Appendable out, final int max) {
        final int errCount = this.getCount("ef");
        final int wrnCount = this.getCount("iw");
        int errLimit = (max >= 0 && errCount > max) ? max : errCount;
        int wrnLimit = (max >= 0 && errCount + wrnCount > max) ? (max - errLimit) : wrnCount;
        int skippedErrors = 0;
        int skippedWarnings = 0;
        int skippedInfo = 0;
        for (SourceError err = this.firstError; err != null; err = err.next) {
            if (err.severity == 'e' && --errLimit < 0) {
                ++skippedErrors;
            }
            else if (err.severity == 'w' && --wrnLimit < 0) {
                ++skippedWarnings;
            }
            else if (err.severity == 'i' && --wrnLimit < 0) {
                ++skippedInfo;
            }
            else {
                err.println(out, this.stripDirectories);
            }
        }
        if (skippedErrors + skippedWarnings + skippedInfo > 0) {
            final SourceError err = new SourceError('i', this.firstError.getFileName(), 0, 0, "skipped " + skippedErrors + " errors, " + skippedWarnings + " warnings, " + skippedInfo + " notes");
            err.println(out, this.stripDirectories);
        }
    }
    
    public String toString(int max) {
        if (this.firstError == null) {
            return null;
        }
        final StringBuilder buffer = new StringBuilder();
        for (SourceError err = this.firstError; err != null && --max >= 0; err = err.next) {
            err.appendTo(buffer, this.stripDirectories, "\n");
        }
        return buffer.toString();
    }
    
    public boolean checkErrors(final Appendable out, final int max) {
        if (this.firstError != null) {
            this.printAll(out, max);
            final SourceError sourceError = null;
            this.lastError = sourceError;
            this.firstError = sourceError;
            final int saveCount = this.errorCount;
            this.errorCount = 0;
            return saveCount > 0;
        }
        return false;
    }
    
    public final void setSourceLocator(final SourceLocator locator) {
        this.locator = ((locator == this) ? null : locator);
    }
    
    public final SourceLocator swapSourceLocator(final SourceLocator locator) {
        final SourceLocator save = this.locator;
        this.locator = locator;
        return save;
    }
    
    public final void setLocation(final SourceLocator locator) {
        this.locator = null;
        this.current_line = locator.getLineNumber();
        this.current_column = locator.getColumnNumber();
        this.current_filename = locator.getFileName();
    }
    
    @Override
    public String getPublicId() {
        return (this.locator == null) ? null : this.locator.getPublicId();
    }
    
    @Override
    public String getSystemId() {
        return (this.locator == null) ? this.current_filename : this.locator.getSystemId();
    }
    
    @Override
    public boolean isStableSourceLocation() {
        return false;
    }
    
    @Override
    public final String getFileName() {
        return this.current_filename;
    }
    
    @Override
    public final int getLineNumber() {
        return (this.locator == null) ? this.current_line : this.locator.getLineNumber();
    }
    
    @Override
    public final int getColumnNumber() {
        return (this.locator == null) ? this.current_column : this.locator.getColumnNumber();
    }
    
    public void setFile(final String filename) {
        this.current_filename = filename;
    }
    
    public void setLine(final int line) {
        this.current_line = line;
    }
    
    public void setColumn(final int column) {
        this.current_column = column;
    }
    
    public void setLine(final String filename, final int line, final int column) {
        this.current_filename = filename;
        this.current_line = line;
        this.current_column = column;
    }
    
    static {
        SourceMessages.stripDirectoriesDefault = false;
        SourceMessages.debugStackTraceOnWarning = false;
        SourceMessages.debugStackTraceOnError = false;
    }
}
