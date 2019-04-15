/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import gnu.text.SourceError;
import gnu.text.SourceLocator;

public class SourceMessages
implements SourceLocator {
    private int errorCount = 0;
    SourceError firstError;
    SourceError lastError;
    SourceLocator locator;
    String current_filename;
    int current_line;
    int current_column;
    public static boolean stripDirectoriesDefault = false;
    public boolean stripDirectories = stripDirectoriesDefault;
    public static boolean debugStackTraceOnWarning = false;
    public static boolean debugStackTraceOnError = false;
    SourceError lastPrevFilename = null;
    public boolean sortMessages;

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

    public int getCount(String severities) {
        int count = 0;
        SourceError err = this.firstError;
        while (err != null) {
            if (severities.indexOf(err.severity) >= 0) {
                ++count;
            }
            err = err.next;
        }
        return count;
    }

    public void clearErrors() {
        this.errorCount = 0;
    }

    public void clear() {
        this.lastError = null;
        this.firstError = null;
        this.errorCount = 0;
    }

    public void error(SourceError error) {
        if (error.severity == 'f') {
            this.errorCount = 1000;
        } else if (error.severity != 'w' && error.severity != 'i') {
            ++this.errorCount;
        }
        if (error.fakeException == null && (debugStackTraceOnError && (error.severity == 'e' || error.severity == 'f') || debugStackTraceOnWarning && error.severity == 'w')) {
            error.fakeException = new Throwable();
        }
        if (this.lastError != null && this.lastError.filename != null && !this.lastError.filename.equals(error.filename)) {
            this.lastPrevFilename = this.lastError;
        }
        SourceError prev = this.lastPrevFilename;
        if (!this.sortMessages || error.severity == 'f') {
            prev = this.lastError;
        } else {
            SourceError next;
            while ((next = prev == null ? this.firstError : prev.next) != null && (error.line == 0 || next.line == 0 || error.line >= next.line && (error.line != next.line || error.column == 0 || next.column == 0 || error.column >= next.column))) {
                prev = next;
            }
        }
        if (prev == null) {
            error.next = this.firstError;
            this.firstError = error;
        } else {
            error.next = prev.next;
            prev.next = error;
        }
        if (prev == this.lastError) {
            this.lastError = error;
        }
    }

    public void error(char severity, String filename, int line, int column, String message) {
        this.error(new SourceError(severity, filename, line, column, message));
    }

    public void error(char severity, SourceLocator location2, String message) {
        this.error(new SourceError(severity, location2, message));
    }

    public void error(char severity, String filename, int line, int column, String message, String code) {
        SourceError err = new SourceError(severity, filename, line, column, message);
        err.code = code;
        this.error(err);
    }

    public void error(char severity, SourceLocator location2, String message, String code) {
        SourceError err = new SourceError(severity, location2, message);
        err.code = code;
        this.error(err);
    }

    public void error(char severity, String message) {
        this.error(new SourceError(severity, this.current_filename, this.current_line, this.current_column, message));
    }

    public void error(char severity, String message, Throwable exception) {
        SourceError err = new SourceError(severity, this.current_filename, this.current_line, this.current_column, message);
        err.fakeException = exception;
        this.error(err);
    }

    public void error(char severity, String message, String code) {
        SourceError err = new SourceError(severity, this.current_filename, this.current_line, this.current_column, message);
        err.code = code;
        this.error(err);
    }

    public void printAll(Appendable out, int max) {
        int errCount = this.getCount("ef");
        int wrnCount = this.getCount("iw");
        int errLimit = max >= 0 && errCount > max ? max : errCount;
        int wrnLimit = max >= 0 && errCount + wrnCount > max ? max - errLimit : wrnCount;
        int skippedErrors = 0;
        int skippedWarnings = 0;
        int skippedInfo = 0;
        SourceError err = this.firstError;
        while (err != null) {
            if (err.severity == 'e' && --errLimit < 0) {
                ++skippedErrors;
            } else if (err.severity == 'w' && --wrnLimit < 0) {
                ++skippedWarnings;
            } else if (err.severity == 'i' && --wrnLimit < 0) {
                ++skippedInfo;
            } else {
                err.println(out, this.stripDirectories);
            }
            err = err.next;
        }
        if (skippedErrors + skippedWarnings + skippedInfo > 0) {
            err = new SourceError('i', this.firstError.getFileName(), 0, 0, "skipped " + skippedErrors + " errors, " + skippedWarnings + " warnings, " + skippedInfo + " notes");
            err.println(out, this.stripDirectories);
        }
    }

    public String toString(int max) {
        if (this.firstError == null) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        SourceError err = this.firstError;
        while (err != null && --max >= 0) {
            err.appendTo(buffer, this.stripDirectories, "\n");
            err = err.next;
        }
        return buffer.toString();
    }

    public boolean checkErrors(Appendable out, int max) {
        if (this.firstError != null) {
            this.printAll(out, max);
            this.lastError = null;
            this.firstError = null;
            int saveCount = this.errorCount;
            this.errorCount = 0;
            return saveCount > 0;
        }
        return false;
    }

    public final void setSourceLocator(SourceLocator locator) {
        this.locator = locator == this ? null : locator;
    }

    public final SourceLocator swapSourceLocator(SourceLocator locator) {
        SourceLocator save = this.locator;
        this.locator = locator;
        return save;
    }

    public final void setLocation(SourceLocator locator) {
        this.locator = null;
        this.current_line = locator.getLineNumber();
        this.current_column = locator.getColumnNumber();
        this.current_filename = locator.getFileName();
    }

    @Override
    public String getPublicId() {
        return this.locator == null ? null : this.locator.getPublicId();
    }

    @Override
    public String getSystemId() {
        return this.locator == null ? this.current_filename : this.locator.getSystemId();
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
        return this.locator == null ? this.current_line : this.locator.getLineNumber();
    }

    @Override
    public final int getColumnNumber() {
        return this.locator == null ? this.current_column : this.locator.getColumnNumber();
    }

    public void setFile(String filename) {
        this.current_filename = filename;
    }

    public void setLine(int line) {
        this.current_line = line;
    }

    public void setColumn(int column) {
        this.current_column = column;
    }

    public void setLine(String filename, int line, int column) {
        this.current_filename = filename;
        this.current_line = line;
        this.current_column = column;
    }
}

