/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Macro;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class let_syntax
extends Syntax {
    public static final let_syntax let_syntax = new let_syntax(false, "let-syntax");
    public static final let_syntax letrec_syntax = new let_syntax(true, "letrec-syntax");
    boolean recursive;

    public let_syntax(boolean recursive, String name) {
        super(name);
        this.recursive = recursive;
    }

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing let-syntax arguments");
        }
        Pair pair = (Pair)obj;
        Object bindings = pair.getCar();
        Object body = pair.getCdr();
        int decl_count = Translator.listLength(bindings);
        if (decl_count < 0) {
            return tr.syntaxError("bindings not a proper list");
        }
        Stack<Declaration> renamedAliases = null;
        int renamedAliasesCount = 0;
        Declaration[] decls = new Declaration[decl_count];
        Macro[] macros = new Macro[decl_count];
        Pair[] transformers = new Pair[decl_count];
        SyntaxForm[] trSyntax = new SyntaxForm[decl_count];
        LetExp let2 = new LetExp();
        SyntaxForm listSyntax = null;
        for (int i = 0; i < decl_count; ++i) {
            TemplateScope templateScope;
            Macro macro;
            while (bindings instanceof SyntaxForm) {
                listSyntax = (SyntaxForm)bindings;
                bindings = listSyntax.getDatum();
            }
            SyntaxForm bindingSyntax = listSyntax;
            Pair bind_pair = (Pair)bindings;
            Object bind_pair_car = bind_pair.getCar();
            if (bind_pair_car instanceof SyntaxForm) {
                bindingSyntax = (SyntaxForm)bind_pair_car;
                bind_pair_car = bindingSyntax.getDatum();
            }
            if (!(bind_pair_car instanceof Pair)) {
                return tr.syntaxError(this.getName() + " binding is not a pair");
            }
            Pair binding = (Pair)bind_pair_car;
            Object name = binding.getCar();
            SyntaxForm nameSyntax = bindingSyntax;
            while (name instanceof SyntaxForm) {
                nameSyntax = (SyntaxForm)name;
                name = nameSyntax.getDatum();
            }
            if (!(name instanceof String) && !(name instanceof Symbol)) {
                return tr.syntaxError("variable in " + this.getName() + " binding is not a symbol");
            }
            Object binding_cdr = binding.getCdr();
            while (binding_cdr instanceof SyntaxForm) {
                bindingSyntax = (SyntaxForm)binding_cdr;
                binding_cdr = bindingSyntax.getDatum();
            }
            if (!(binding_cdr instanceof Pair)) {
                return tr.syntaxError(this.getName() + " has no value for '" + name + "'");
            }
            binding = (Pair)binding_cdr;
            if (binding.getCdr() != LList.Empty) {
                return tr.syntaxError("let binding for '" + name + "' is improper list");
            }
            Declaration decl = new Declaration(name);
            macros[i] = macro = Macro.make(decl);
            transformers[i] = binding;
            trSyntax[i] = bindingSyntax;
            let2.addDeclaration(decl);
            TemplateScope templateScope2 = templateScope = nameSyntax == null ? null : nameSyntax.getScope();
            if (templateScope != null) {
                Declaration alias = tr.makeRenamedAlias(decl, templateScope);
                if (renamedAliases == null) {
                    renamedAliases = new Stack<Declaration>();
                }
                renamedAliases.push(alias);
                ++renamedAliasesCount;
            }
            macro.setCapturedScope(bindingSyntax != null ? bindingSyntax.getScope() : (this.recursive ? let2 : tr.currentScope()));
            decls[i] = decl;
            decl.setInitValue(QuoteExp.nullExp);
            bindings = bind_pair.getCdr();
        }
        if (this.recursive) {
            this.push(let2, tr, renamedAliases);
        }
        Macro savedMacro = tr.currentMacroDefinition;
        for (int i = 0; i < decl_count; ++i) {
            Macro macro;
            tr.currentMacroDefinition = macro = macros[i];
            Expression value = tr.rewrite_car(transformers[i], trSyntax[i]);
            Declaration decl = decls[i];
            decl.setInitValue(value);
            macro.expander = value;
            decl.noteValue(new QuoteExp(macro));
            if (!(value instanceof LambdaExp)) continue;
            LambdaExp lvalue = (LambdaExp)value;
            lvalue.nameDecl = decl;
            lvalue.setSymbol(decl.getSymbol());
        }
        tr.currentMacroDefinition = savedMacro;
        if (!this.recursive) {
            this.push(let2, tr, renamedAliases);
        }
        Expression result = tr.rewrite_body(body);
        tr.pop(let2);
        tr.popRenamedAlias(renamedAliasesCount);
        return result;
    }

    private void push(LetExp let2, Translator tr, Stack renamedAliases) {
        tr.push(let2);
        if (renamedAliases != null) {
            int i = renamedAliases.size();
            while (--i >= 0) {
                tr.pushRenamedAlias((Declaration)renamedAliases.pop());
            }
        }
    }
}

