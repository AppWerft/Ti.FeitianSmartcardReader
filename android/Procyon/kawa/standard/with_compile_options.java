// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.BeginExp;
import gnu.expr.Expression;
import gnu.text.Options;
import gnu.lists.FString;
import gnu.expr.Keyword;
import kawa.lang.SyntaxForm;
import java.util.Vector;
import gnu.lists.LList;
import java.util.Stack;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class with_compile_options extends Syntax
{
    public static final with_compile_options with_compile_options;
    
    @Override
    public void scanForm(final Pair form, final ScopeExp defs, final Translator tr) {
        final Stack stack = new Stack();
        Object rest = getOptions(form.getCdr(), stack, this, tr);
        if (rest == LList.Empty) {
            return;
        }
        if (rest == form.getCdr()) {
            tr.scanBody(rest, defs, false);
            return;
        }
        rest = tr.scanBody(rest, defs, true);
        rest = new Pair(stack, rest);
        tr.currentOptions.popOptionValues(stack);
        tr.pushForm(Translator.makePair(form, form.getCar(), rest));
    }
    
    public static Object getOptions(Object form, final Stack stack, final Syntax command, final Translator tr) {
        boolean seenKey = false;
        final Options options = tr.currentOptions;
        SyntaxForm syntax = null;
        while (true) {
            if (form instanceof SyntaxForm) {
                syntax = (SyntaxForm)form;
                form = syntax.getDatum();
            }
            else {
                if (!(form instanceof Pair)) {
                    break;
                }
                Pair pair = (Pair)form;
                final Object pair_car = Translator.stripSyntax(pair.getCar());
                if (!(pair_car instanceof Keyword)) {
                    break;
                }
                final String key = ((Keyword)pair_car).getName();
                seenKey = true;
                final Object savePos = tr.pushPositionOf(pair);
                try {
                    for (form = pair.getCdr(); form instanceof SyntaxForm; form = syntax.getDatum()) {
                        syntax = (SyntaxForm)form;
                    }
                    if (!(form instanceof Pair)) {
                        tr.error('e', "keyword " + key + " not followed by value");
                        return LList.Empty;
                    }
                    pair = (Pair)form;
                    Object value = Translator.stripSyntax(pair.getCar());
                    form = pair.getCdr();
                    final Object oldValue = options.getLocal(key);
                    if (options.getInfo(key) == null) {
                        tr.error('w', "unknown compile option: " + key);
                    }
                    else {
                        if (value instanceof FString) {
                            value = value.toString();
                        }
                        else if (!(value instanceof Boolean)) {
                            if (!(value instanceof Number)) {
                                value = null;
                                tr.error('e', "invalid literal value for key " + key);
                            }
                        }
                        options.set(key, value, tr.getMessages());
                        if (stack == null) {
                            continue;
                        }
                        stack.push(key);
                        stack.push(oldValue);
                        stack.push(value);
                    }
                }
                finally {
                    tr.popPositionOf(savePos);
                }
            }
        }
        if (!seenKey) {
            tr.error('e', "no option keyword in " + command.getName());
        }
        return Translator.wrapSyntax(form, syntax);
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Object obj = form.getCdr();
        final Pair p;
        Stack stack;
        Object rest;
        if (obj instanceof Pair && (p = (Pair)obj).getCar() instanceof Stack) {
            stack = (Stack)p.getCar();
            rest = p.getCdr();
            tr.currentOptions.pushOptionValues(stack);
        }
        else {
            stack = new Stack();
            rest = getOptions(obj, stack, this, tr);
        }
        try {
            final Expression result = tr.rewrite_body(rest);
            BeginExp bresult;
            if (result instanceof BeginExp) {
                bresult = (BeginExp)result;
            }
            else {
                bresult = new BeginExp(new Expression[] { result });
            }
            bresult.setCompileOptions(stack);
            return bresult;
        }
        finally {
            tr.currentOptions.popOptionValues(stack);
        }
    }
    
    static {
        (with_compile_options = new with_compile_options()).setName("with-compile-options");
    }
}
