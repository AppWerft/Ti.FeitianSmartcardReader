package gnu.kawa.util;
















public class ExitCalled
  extends Error
{
  private static ThreadLocal<Integer> isHandlingExitCalled = new ThreadLocal();
  private static volatile ExitCalled instance;
  int exitCode;
  
  public static void push()
  {
    Integer oldCount = (Integer)isHandlingExitCalled.get();
    Integer newCount = Integer.valueOf(oldCount == null ? 1 : oldCount.intValue() + 1);
    
    isHandlingExitCalled.set(newCount);
  }
  
  public static int pop() {
    Integer oldCount = (Integer)isHandlingExitCalled.get();
    int newCount = oldCount == null ? 0 : oldCount.intValue() - 1;
    
    isHandlingExitCalled.set(Integer.valueOf(newCount));
    ExitCalled ex = instance;
    if ((newCount <= 0) && (ex != null)) {
      System.exit(ex.getExitCode());
    }
    return newCount;
  }
  
  public static int nesting() {
    Integer count = (Integer)isHandlingExitCalled.get();
    return count == null ? 0 : count.intValue();
  }
  
  public int getExitCode() { return exitCode; }
  
  public ExitCalled(int exitCode) {
    super("(exit-called)");
    this.exitCode = exitCode;
  }
  
  public static void doExit(int exitCode) {
    if (nesting() > 0) {
      ExitCalled ex = new ExitCalled(exitCode);
      instance = ex;
      throw ex;
    }
    
    System.exit(exitCode);
  }
}
