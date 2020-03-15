// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

public class ExitCalled extends Error
{
    private static ThreadLocal<Integer> isHandlingExitCalled;
    private static volatile ExitCalled instance;
    int exitCode;
    
    public static void push() {
        final Integer oldCount = ExitCalled.isHandlingExitCalled.get();
        final Integer newCount = (oldCount == null) ? 1 : (oldCount + 1);
        ExitCalled.isHandlingExitCalled.set(newCount);
    }
    
    public static int pop() {
        final Integer oldCount = ExitCalled.isHandlingExitCalled.get();
        final int newCount = (oldCount == null) ? 0 : (oldCount - 1);
        ExitCalled.isHandlingExitCalled.set(newCount);
        final ExitCalled ex = ExitCalled.instance;
        if (newCount <= 0 && ex != null) {
            System.exit(ex.getExitCode());
        }
        return newCount;
    }
    
    public static int nesting() {
        final Integer count = ExitCalled.isHandlingExitCalled.get();
        return (count == null) ? 0 : count;
    }
    
    public int getExitCode() {
        return this.exitCode;
    }
    
    public ExitCalled(final int exitCode) {
        super("(exit-called)");
        this.exitCode = exitCode;
    }
    
    public static void doExit(final int exitCode) {
        if (nesting() > 0) {
            final ExitCalled ex = new ExitCalled(exitCode);
            throw ExitCalled.instance = ex;
        }
        System.exit(exitCode);
    }
    
    static {
        ExitCalled.isHandlingExitCalled = new ThreadLocal<Integer>();
    }
}
