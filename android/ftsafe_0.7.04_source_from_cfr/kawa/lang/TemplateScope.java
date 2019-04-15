/*
 * Decompiled with CFR 0.139.
 */
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
import kawa.lang.Macro;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class TemplateScope
extends LetExp
implements Externalizable {
    Declaration macroContext;
    Object macroMark;
    private Syntax syntax;

    public TemplateScope() {
    }

    public TemplateScope(ScopeExp outer) {
        this.setOuter(outer);
    }

    public static TemplateScope make() {
        return TemplateScope.make((Translator)Compilation.getCurrent(), null);
    }

    public static TemplateScope make(Translator tr, ScopeExp savedScope) {
        TemplateScope templateScope = new TemplateScope(savedScope);
        if (tr != null) {
            templateScope.macroMark = tr.currentMacroMark;
            Syntax curSyntax = tr.getCurrentSyntax();
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

    public static TemplateScope make(ModuleExp module, String mname) {
        TemplateScope templateScope = new TemplateScope();
        templateScope.setOuter(module);
        return templateScope;
    }

    void init(Macro macro) {
        this.setOuter(macro.getCapturedScope());
        this.macroContext = this.getOuter().lookup(macro.getName());
        this.syntax = macro;
        this.macroMark = macro;
    }

    public static TemplateScope make(String moduleClassName) {
        TemplateScope templateScope = new TemplateScope();
        templateScope.setOuter(moduleClassName);
        return templateScope;
    }

    void setOuter(String moduleClassName) {
        this.setOuter(ModuleInfo.find(ClassType.make(moduleClassName)).getModuleExp());
    }

    @Override
    public String toString() {
        return super.toString() + "(for " + this.syntax + ")";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        ClassType moduleClass;
        String moduleClassName = null;
        if (this.getOuter() instanceof ModuleExp && (moduleClass = ((ModuleExp)this.getOuter()).getClassType()) != null) {
            moduleClassName = moduleClass.getName();
        }
        out.writeObject(moduleClassName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readObject();
    }
}

