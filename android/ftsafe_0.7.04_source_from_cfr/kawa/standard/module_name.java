/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.Mangling;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class module_name
extends Syntax {
    public static final module_name module_name = new module_name();

    @Override
    public void scanForm(Pair form, ScopeExp defs2, Translator tr) {
        Pair p;
        Object arg;
        Object form_cdr = form.getCdr();
        SyntaxForm nameSyntax = null;
        while (form_cdr instanceof SyntaxForm) {
            nameSyntax = (SyntaxForm)form_cdr;
            form_cdr = nameSyntax.getDatum();
        }
        Object object2 = arg = form_cdr instanceof Pair ? ((Pair)form_cdr).getCar() : null;
        while (arg instanceof SyntaxForm) {
            nameSyntax = (SyntaxForm)arg;
            arg = nameSyntax.getDatum();
        }
        String name = null;
        String err = null;
        if (arg instanceof Pair && (p = (Pair)arg).getCar() == "quote") {
            arg = p.getCdr();
            if (!(arg instanceof Pair) || (p = (Pair)arg).getCdr() != LList.Empty || !(p.getCar() instanceof String)) {
                err = "invalid quoted symbol for 'module-name'";
            } else {
                name = (String)p.getCar();
            }
        } else if (arg instanceof Pair) {
            name = module_name.listToModuleName(arg, tr);
        } else if (arg instanceof FString || arg instanceof String) {
            name = arg.toString();
        } else if (arg instanceof Symbol) {
            name = arg.toString();
            int len = name.length();
            if (len > 2 && name.charAt(0) == '<' && name.charAt(len - 1) == '>') {
                name = name.substring(1, len - 1);
            }
        } else {
            err = "un-implemented expression in module-name";
        }
        if (err != null) {
            tr.pushForm(tr.syntaxError(err));
        } else {
            int index = name.lastIndexOf(46);
            String className = name;
            if (index >= 0) {
                tr.classPrefix = name.substring(0, index + 1);
            } else {
                className = tr.classPrefix + Mangling.mangleClassName(name);
            }
            ModuleExp module = tr.getModule();
            if (tr.mainClass == null) {
                tr.mainClass = new ClassType(className);
            } else {
                String oldName = tr.mainClass.getName();
                if (oldName == null) {
                    tr.mainClass.setName(className);
                } else if (!oldName.equals(className)) {
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

    public static String listToModuleName(Object list, Translator tr) {
        StringBuilder sbuf;
        block3 : {
            Object car;
            sbuf = new StringBuilder(Compilation.classPrefixDefault);
            boolean first = true;
            do {
                Pair parg = (Pair)list;
                if (!first) {
                    sbuf.append('.');
                }
                first = false;
                car = parg.getCar();
                if (car != null) {
                    sbuf.append(Mangling.mangleClassName(car.toString()));
                }
                if ((list = parg.getCdr()) == LList.Empty) break block3;
            } while (car != null && list instanceof Pair);
            tr.error('e', "invalid list in module name");
        }
        return sbuf.toString();
    }

    static {
        module_name.setName("module-name");
    }
}

