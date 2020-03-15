// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.ModuleExp;
import gnu.bytecode.ClassType;
import gnu.expr.Mangling;
import gnu.mapping.Symbol;
import gnu.lists.FString;
import gnu.lists.LList;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class module_name extends Syntax
{
    public static final module_name module_name;
    
    @Override
    public void scanForm(final Pair form, final ScopeExp defs, final Translator tr) {
        Object form_cdr = form.getCdr();
        for (SyntaxForm nameSyntax = null; form_cdr instanceof SyntaxForm; form_cdr = nameSyntax.getDatum()) {
            nameSyntax = (SyntaxForm)form_cdr;
        }
        SyntaxForm nameSyntax;
        Object arg;
        for (arg = ((form_cdr instanceof Pair) ? ((Pair)form_cdr).getCar() : null); arg instanceof SyntaxForm; arg = nameSyntax.getDatum()) {
            nameSyntax = (SyntaxForm)arg;
        }
        String name = null;
        String err = null;
        Pair p;
        if (arg instanceof Pair && (p = (Pair)arg).getCar() == "quote") {
            arg = p.getCdr();
            if (!(arg instanceof Pair) || (p = (Pair)arg).getCdr() != LList.Empty || !(p.getCar() instanceof String)) {
                err = "invalid quoted symbol for 'module-name'";
            }
            else {
                name = (String)p.getCar();
            }
        }
        else if (arg instanceof Pair) {
            name = listToModuleName(arg, tr);
        }
        else if (arg instanceof FString || arg instanceof String) {
            name = arg.toString();
        }
        else if (arg instanceof Symbol) {
            name = arg.toString();
            final int len = name.length();
            if (len > 2 && name.charAt(0) == '<' && name.charAt(len - 1) == '>') {
                name = name.substring(1, len - 1);
            }
        }
        else {
            err = "un-implemented expression in module-name";
        }
        if (err != null) {
            tr.pushForm(tr.syntaxError(err));
        }
        else {
            final int index = name.lastIndexOf(46);
            String className = name;
            if (index >= 0) {
                tr.classPrefix = name.substring(0, index + 1);
            }
            else {
                className = tr.classPrefix + Mangling.mangleClassName(name);
            }
            final ModuleExp module = tr.getModule();
            if (tr.mainClass == null) {
                tr.mainClass = new ClassType(className);
            }
            else {
                final String oldName = tr.mainClass.getName();
                if (oldName == null) {
                    tr.mainClass.setName(className);
                }
                else if (!oldName.equals(className)) {
                    tr.syntaxError("inconsistent module-name - old name: " + oldName);
                }
            }
            if (tr.getState() > 1) {
                tr.error('e', "too late to set module-name");
            }
            module.setType(tr.mainClass);
            module.setName(name);
            tr.mustCompileHere();
        }
    }
    
    public static String listToModuleName(Object list, final Translator tr) {
        final StringBuilder sbuf = new StringBuilder(Compilation.classPrefixDefault);
        boolean first = true;
        while (true) {
            final Pair parg = (Pair)list;
            if (!first) {
                sbuf.append('.');
            }
            first = false;
            final Object car = parg.getCar();
            if (car != null) {
                sbuf.append(Mangling.mangleClassName(car.toString()));
            }
            list = parg.getCdr();
            if (list == LList.Empty) {
                break;
            }
            if (car == null || !(list instanceof Pair)) {
                tr.error('e', "invalid list in module name");
                break;
            }
        }
        return sbuf.toString();
    }
    
    static {
        (module_name = new module_name()).setName("module-name");
    }
}
