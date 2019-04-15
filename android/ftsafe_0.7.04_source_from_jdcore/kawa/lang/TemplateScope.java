package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ScopeExp;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;





public class TemplateScope
  extends LetExp
  implements Externalizable
{
  Declaration macroContext;
  Object macroMark;
  private Syntax syntax;
  
  public TemplateScope() {}
  
  public TemplateScope(ScopeExp outer)
  {
    setOuter(outer);
  }
  
  public static TemplateScope make()
  {
    return make((Translator)Compilation.getCurrent(), null);
  }
  
  public static TemplateScope make(Translator tr, ScopeExp savedScope) {
    TemplateScope templateScope = new TemplateScope(savedScope);
    if (tr != null) {
      macroMark = currentMacroMark;
      Syntax curSyntax = tr.getCurrentSyntax();
      if ((curSyntax instanceof Macro)) {
        macroContext = macroContext;
        if (savedScope == null)
          templateScope.setOuter(((Macro)curSyntax).getCapturedScope());
      }
      syntax = curSyntax;
    }
    return templateScope;
  }
  
  public static TemplateScope make(ModuleExp module, String mname) {
    TemplateScope templateScope = new TemplateScope();
    templateScope.setOuter(module);
    return templateScope;
  }
  
  void init(Macro macro) {
    setOuter(macro.getCapturedScope());
    macroContext = getOuter().lookup(macro.getName());
    syntax = macro;
    macroMark = macro;
  }
  
  public static TemplateScope make(String moduleClassName) {
    TemplateScope templateScope = new TemplateScope();
    templateScope.setOuter(moduleClassName);
    return templateScope;
  }
  
  void setOuter(String moduleClassName) {
    setOuter(ModuleInfo.find(ClassType.make(moduleClassName)).getModuleExp());
  }
  
  public String toString() { return super.toString() + "(for " + syntax + ")"; }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    String moduleClassName = null;
    if ((getOuter() instanceof ModuleExp)) {
      ClassType moduleClass = ((ModuleExp)getOuter()).getClassType();
      if (moduleClass != null)
        moduleClassName = moduleClass.getName();
    }
    out.writeObject(moduleClassName);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    in.readObject();
  }
}
