// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.QuoteExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.expr.Compilation;
import gnu.expr.ScopeExp;
import kawa.lang.SyntaxForm;
import gnu.mapping.Symbol;
import kawa.lang.BindDecls;
import gnu.expr.LetExp;
import gnu.mapping.SimpleEnvironment;
import java.util.Stack;
import gnu.expr.Declaration;
import java.util.ArrayList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Syntax;

public class let extends Syntax
{
    public static final let let;
    protected boolean settingProcedures;
    
    public let(final String name, final boolean settingProcedures) {
        this.setName(name);
        this.settingProcedures = settingProcedures;
    }
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        final ArrayList<Declaration> decls = new ArrayList<Declaration>();
        final Stack<Declaration> renamedAliases = new Stack<Declaration>();
        final SimpleEnvironment dupenv = new SimpleEnvironment();
        final LetExp let = new LetExp();
        final BindDecls bindDecls = new BindDecls() {
            @Override
            public Declaration define(final Symbol name, final SyntaxForm nameSyntax, final ScopeExp defs, final Translator comp) {
                final ScopeExp templateScope = (nameSyntax == null) ? null : nameSyntax.getScope();
                final Declaration decl = new Declaration(name);
                final Object old = dupenv.get(name, templateScope, null);
                if (old != null) {
                    ScopeExp.duplicateDeclarationError((Declaration)old, decl, tr);
                }
                dupenv.put(name, templateScope, decl);
                let.add(decl);
                decl.setFlag(262144L);
                if (templateScope != null) {
                    renamedAliases.push(tr.makeRenamedAlias(decl, templateScope));
                }
                return decl;
            }
        };
        bindDecls.allowShadowing = true;
        bindDecls.makeConstant = false;
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing " + this.getName() + " arguments");
        }
        final Pair pair = (Pair)obj;
        Object bindings = pair.getCar();
        final Object body = pair.getCdr();
        while (bindings != LList.Empty) {
            if (!(bindings instanceof Pair)) {
                return tr.syntaxError("bindings not a proper list");
            }
            final Pair bind_pair = (Pair)bindings;
            final Object bind_pair_car = bind_pair.getCar();
            if (!(bind_pair_car instanceof Pair)) {
                return tr.syntaxError(this.getName() + " binding is not a pair:" + bind_pair_car);
            }
            final Pair binding = (Pair)bind_pair_car;
            final Object saveLoc1 = tr.pushPositionOf(binding);
            final Object[] r = bindDecls.parsePatternCar(binding, 0, let, tr);
            Object binding_cdr = r[0];
            final Declaration decl = (Declaration)r[1];
            this.maybeSetProcedure(decl);
            if (binding_cdr instanceof Pair) {
                final Pair init = (Pair)binding_cdr;
                binding_cdr = init.getCdr();
                final Expression initExp = tr.rewrite_car(init, null);
                decl.setInitValue(initExp);
                if (initExp != QuoteExp.undefined_exp) {
                    decl.noteValueFromLet(let);
                }
                if (init.getCdr() != LList.Empty) {
                    final Object saveLoc2 = tr.pushPositionOf(init.getCdr());
                    tr.error('e', "junk after initializer");
                    tr.popPositionOf(saveLoc2);
                }
            }
            else {
                tr.error('e', "let has no initializer");
            }
            tr.popPositionOf(saveLoc1);
            bindings = bind_pair.getCdr();
        }
        int i;
        final int renamedAliasesCount = i = renamedAliases.size();
        while (--i >= 0) {
            tr.pushRenamedAlias(renamedAliases.pop());
        }
        tr.push(let);
        try {
            let.setBody(tr.rewrite_body(body));
        }
        finally {
            tr.pop(let);
            tr.popRenamedAlias(renamedAliasesCount);
        }
        return let;
    }
    
    protected void maybeSetProcedure(final Declaration decl) {
        if (this.settingProcedures) {
            decl.setProcedureDecl(true);
        }
    }
    
    static {
        let = new let("let", false);
    }
}
