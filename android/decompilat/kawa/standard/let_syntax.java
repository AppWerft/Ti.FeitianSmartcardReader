// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.ScopeExp;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import java.util.Stack;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import gnu.expr.LetExp;
import kawa.lang.SyntaxForm;
import kawa.lang.Macro;
import gnu.expr.Declaration;
import gnu.lists.Pair;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Syntax;

public class let_syntax extends Syntax
{
    public static final let_syntax let_syntax;
    public static final let_syntax letrec_syntax;
    boolean recursive;
    
    public let_syntax(final boolean recursive, final String name) {
        super(name);
        this.recursive = recursive;
    }
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing let-syntax arguments");
        }
        final Pair pair = (Pair)obj;
        Object bindings = pair.getCar();
        final Object body = pair.getCdr();
        final int decl_count = Translator.listLength(bindings);
        if (decl_count < 0) {
            return tr.syntaxError("bindings not a proper list");
        }
        Stack renamedAliases = null;
        int renamedAliasesCount = 0;
        final Declaration[] decls = new Declaration[decl_count];
        final Macro[] macros = new Macro[decl_count];
        final Pair[] transformers = new Pair[decl_count];
        final SyntaxForm[] trSyntax = new SyntaxForm[decl_count];
        final LetExp let = new LetExp();
        SyntaxForm listSyntax = null;
        for (int i = 0; i < decl_count; ++i) {
            while (bindings instanceof SyntaxForm) {
                listSyntax = (SyntaxForm)bindings;
                bindings = listSyntax.getDatum();
            }
            SyntaxForm bindingSyntax = listSyntax;
            final Pair bind_pair = (Pair)bindings;
            Object bind_pair_car = bind_pair.getCar();
            if (bind_pair_car instanceof SyntaxForm) {
                bindingSyntax = (SyntaxForm)bind_pair_car;
                bind_pair_car = bindingSyntax.getDatum();
            }
            if (!(bind_pair_car instanceof Pair)) {
                return tr.syntaxError(this.getName() + " binding is not a pair");
            }
            Pair binding = (Pair)bind_pair_car;
            Object name;
            SyntaxForm nameSyntax;
            for (name = binding.getCar(), nameSyntax = bindingSyntax; name instanceof SyntaxForm; name = nameSyntax.getDatum()) {
                nameSyntax = (SyntaxForm)name;
            }
            if (!(name instanceof String) && !(name instanceof Symbol)) {
                return tr.syntaxError("variable in " + this.getName() + " binding is not a symbol");
            }
            Object binding_cdr;
            for (binding_cdr = binding.getCdr(); binding_cdr instanceof SyntaxForm; binding_cdr = bindingSyntax.getDatum()) {
                bindingSyntax = (SyntaxForm)binding_cdr;
            }
            if (!(binding_cdr instanceof Pair)) {
                return tr.syntaxError(this.getName() + " has no value for '" + name + "'");
            }
            binding = (Pair)binding_cdr;
            if (binding.getCdr() != LList.Empty) {
                return tr.syntaxError("let binding for '" + name + "' is improper list");
            }
            final Declaration decl = new Declaration(name);
            final Macro macro = Macro.make(decl);
            macros[i] = macro;
            transformers[i] = binding;
            trSyntax[i] = bindingSyntax;
            let.addDeclaration(decl);
            final ScopeExp templateScope = (nameSyntax == null) ? null : nameSyntax.getScope();
            if (templateScope != null) {
                final Declaration alias = tr.makeRenamedAlias(decl, templateScope);
                if (renamedAliases == null) {
                    renamedAliases = new Stack();
                }
                renamedAliases.push(alias);
                ++renamedAliasesCount;
            }
            macro.setCapturedScope((bindingSyntax != null) ? bindingSyntax.getScope() : (this.recursive ? let : tr.currentScope()));
            (decls[i] = decl).setInitValue(QuoteExp.nullExp);
            bindings = bind_pair.getCdr();
        }
        if (this.recursive) {
            this.push(let, tr, renamedAliases);
        }
        final Macro savedMacro = tr.currentMacroDefinition;
        for (int j = 0; j < decl_count; ++j) {
            final Macro macro2 = macros[j];
            tr.currentMacroDefinition = macro2;
            final Expression value = tr.rewrite_car(transformers[j], trSyntax[j]);
            final Declaration decl2 = decls[j];
            decl2.setInitValue(value);
            macro2.expander = value;
            decl2.noteValue(new QuoteExp(macro2));
            if (value instanceof LambdaExp) {
                final LambdaExp lvalue = (LambdaExp)value;
                lvalue.nameDecl = decl2;
                lvalue.setSymbol(decl2.getSymbol());
            }
        }
        tr.currentMacroDefinition = savedMacro;
        if (!this.recursive) {
            this.push(let, tr, renamedAliases);
        }
        final Expression result = tr.rewrite_body(body);
        tr.pop(let);
        tr.popRenamedAlias(renamedAliasesCount);
        return result;
    }
    
    private void push(final LetExp let, final Translator tr, final Stack renamedAliases) {
        tr.push(let);
        if (renamedAliases != null) {
            int i = renamedAliases.size();
            while (--i >= 0) {
                tr.pushRenamedAlias(renamedAliases.pop());
            }
        }
    }
    
    static {
        let_syntax = new let_syntax(false, "let-syntax");
        letrec_syntax = new let_syntax(true, "letrec-syntax");
    }
}
