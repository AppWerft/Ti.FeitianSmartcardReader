/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.BeginExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.Options;
import gnu.text.SourceMessages;
import java.util.Stack;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class with_compile_options
extends Syntax {
    public static final with_compile_options with_compile_options = new with_compile_options();

    @Override
    public void scanForm(Pair form, ScopeExp defs2, Translator tr) {
        Stack stack = new Stack();
        Object rest = with_compile_options.getOptions(form.getCdr(), stack, this, tr);
        if (rest == LList.Empty) {
            return;
        }
        if (rest == form.getCdr()) {
            tr.scanBody(rest, defs2, false);
            return;
        }
        rest = tr.scanBody(rest, defs2, true);
        rest = new Pair(stack, rest);
        tr.currentOptions.popOptionValues(stack);
        tr.pushForm(Translator.makePair(form, form.getCar(), rest));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object getOptions(Object form, Stack stack, Syntax command, Translator tr) {
        seenKey = false;
        options = tr.currentOptions;
        syntax = null;
        do lbl-1000: // 6 sources:
        {
            if (form instanceof SyntaxForm) {
                syntax = (SyntaxForm)form;
                form = syntax.getDatum();
                continue;
            }
            if (!(form instanceof Pair) || !((pair_car = Translator.stripSyntax((pair = (Pair)form).getCar())) instanceof Keyword)) ** break;
            key = ((Keyword)pair_car).getName();
            seenKey = true;
            savePos = tr.pushPositionOf(pair);
            try {
                form = pair.getCdr();
                while (form instanceof SyntaxForm) {
                    syntax = (SyntaxForm)form;
                    form = syntax.getDatum();
                }
                if (!(form instanceof Pair)) {
                    tr.error('e', "keyword " + key + " not followed by value");
                    var11_11 = LList.Empty;
                    return var11_11;
                }
                pair = (Pair)form;
                value = Translator.stripSyntax(pair.getCar());
                form = pair.getCdr();
                oldValue = options.getLocal(key);
                if (options.getInfo(key) == null) {
                    tr.error('w', "unknown compile option: " + key);
                }
                if (value instanceof FString) {
                    value = value.toString();
                } else if (!(value instanceof Boolean) && !(value instanceof Number)) {
                    value = null;
                    tr.error('e', "invalid literal value for key " + key);
                }
                options.set(key, value, tr.getMessages());
                if (stack == null) ** GOTO lbl-1000
                stack.push(key);
                stack.push(oldValue);
                stack.push(value);
            }
            finally {
                tr.popPositionOf(savePos);
                continue;
            }
            break;
        } while (true);
        ** GOTO lbl-1000
        if (seenKey != false) return Translator.wrapSyntax(form, syntax);
        tr.error('e', "no option keyword in " + command.getName());
        return Translator.wrapSyntax(form, syntax);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Pair p;
        Stack stack;
        Object rest;
        Object obj = form.getCdr();
        if (obj instanceof Pair && (p = (Pair)obj).getCar() instanceof Stack) {
            stack = (Stack)p.getCar();
            rest = p.getCdr();
            tr.currentOptions.pushOptionValues(stack);
        } else {
            stack = new Stack();
            rest = with_compile_options.getOptions(obj, stack, this, tr);
        }
        try {
            Expression result = tr.rewrite_body(rest);
            BeginExp bresult = result instanceof BeginExp ? (BeginExp)result : new BeginExp(new Expression[]{result});
            bresult.setCompileOptions(stack);
            BeginExp beginExp = bresult;
            return beginExp;
        }
        finally {
            tr.currentOptions.popOptionValues(stack);
        }
    }

    static {
        with_compile_options.setName("with-compile-options");
    }
}

