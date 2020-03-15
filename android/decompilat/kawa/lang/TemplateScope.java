// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.expr.ModuleInfo;
import gnu.bytecode.ClassType;
import gnu.expr.ModuleExp;
import gnu.expr.Compilation;
import gnu.expr.ScopeExp;
import gnu.expr.Declaration;
import java.io.Externalizable;
import gnu.expr.LetExp;

public class TemplateScope extends LetExp implements Externalizable
{
    Declaration macroContext;
    Object macroMark;
    private Syntax syntax;
    
    public TemplateScope() {
    }
    
    public TemplateScope(final ScopeExp outer) {
        this.setOuter(outer);
    }
    
    public static TemplateScope make() {
        return make((Translator)Compilation.getCurrent(), null);
    }
    
    public static TemplateScope make(final Translator tr, final ScopeExp savedScope) {
        final TemplateScope templateScope = new TemplateScope(savedScope);
        if (tr != null) {
            templateScope.macroMark = tr.currentMacroMark;
            final Syntax curSyntax = tr.getCurrentSyntax();
            if (curSyntax instanceof Macro) {
                templateScope.macroContext = tr.macroContext;
                if (savedScope == null) {
                    templateScope.setOuter(((Macro)curSyntax).getCapturedScope());
                }
            }
            templateScope.syntax = curSyntax;
        }
        return templateScope;
    }
    
    public static TemplateScope make(final ModuleExp module, final String mname) {
        final TemplateScope templateScope = new TemplateScope();
        templateScope.setOuter(module);
        return templateScope;
    }
    
    void init(final Macro macro) {
        this.setOuter(macro.getCapturedScope());
        this.macroContext = this.getOuter().lookup(macro.getName());
        this.syntax = macro;
        this.macroMark = macro;
    }
    
    public static TemplateScope make(final String moduleClassName) {
        final TemplateScope templateScope = new TemplateScope();
        templateScope.setOuter(moduleClassName);
        return templateScope;
    }
    
    void setOuter(final String moduleClassName) {
        this.setOuter(ModuleInfo.find(ClassType.make(moduleClassName)).getModuleExp());
    }
    
    @Override
    public String toString() {
        return super.toString() + "(for " + this.syntax + ")";
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        String moduleClassName = null;
        if (this.getOuter() instanceof ModuleExp) {
            final ClassType moduleClass = ((ModuleExp)this.getOuter()).getClassType();
            if (moduleClass != null) {
                moduleClassName = moduleClass.getName();
            }
        }
        out.writeObject(moduleClassName);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        in.readObject();
    }
}
