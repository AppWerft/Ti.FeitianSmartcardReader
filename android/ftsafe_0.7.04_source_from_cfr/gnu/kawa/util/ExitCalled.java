/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

public class ExitCalled
extends Error {
    private static ThreadLocal<Integer> isHandlingExitCalled = new ThreadLocal();
    private static volatile ExitCalled instance;
    int exitCode;

    public static void push() {
        Integer oldCount = isHandlingExitCalled.get();
        Integer newCount = oldCount == null ? 1 : oldCount + 1;
        isHandlingExitCalled.set(newCount);
    }

    public static int pop() {
        Integer oldCount = isHandlingExitCalled.get();
        int newCount = oldCount == null ? 0 : oldCount - 1;
        isHandlingExitCalled.set(newCount);
        ExitCalled ex = instance;
        if (newCount <= 0 && ex != null) {
            System.exit(ex.getExitCode());
        }
        return newCount;
    }

    public static int nesting() {
        Integer count = isHandlingExitCalled.get();
        return count == null ? 0 : count;
    }

    public int getExitCode() {
        return this.exitCode;
    }

    public ExitCalled(int exitCode) {
        super("(exit-called)");
        this.exitCode = exitCode;
    }

    public static void doExit(int exitCode) {
        if (ExitCalled.nesting() > 0) {
            ExitCalled ex;
            instance = ex = new ExitCalled(exitCode);
            throw ex;
        }
        System.exit(exitCode);
    }
}

