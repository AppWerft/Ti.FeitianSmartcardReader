package gnu.expr;

public abstract class ModuleSet
{
  public static final String MODULES_MAP = "$ModulesMap$";
  ModuleSet next;
  
  public ModuleSet() {}
  
  public abstract void register(ModuleManager paramModuleManager);
}
