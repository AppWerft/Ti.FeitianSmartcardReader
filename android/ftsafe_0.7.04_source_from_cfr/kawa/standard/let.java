/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;
import java.util.ArrayList;
import java.util.Stack;
import kawa.lang.BindDecls;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class let
extends Syntax {
    public static final let let = new let("let", false);
    protected boolean settingProcedures;

    public let(String name, boolean settingProcedures) {
        this.setName(name);
        this.settingProcedures = settingProcedures;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Expression rewrite(Object obj, final Translator tr) {
        LetExp let2;
        int renamedAliasesCount;
        ArrayList decls = new ArrayList();
        final Stack renamedAliases = new Stack();
        final SimpleEnvironment dupenv = new SimpleEnvironment();
        let2 = new LetExp();
        BindDecls bindDecls = new BindDecls(){

            @Override
            public Declaration define(Symbol name, SyntaxForm nameSyntax, ScopeExp defs2, Translator comp) {
                TemplateScope templateScope = nameSyntax == null ? null : nameSyntax.getScope();
                Declaration decl = new Declaration(name);
                Object old = dupenv.get(name, templateScope, null);
                if (old != null) {
                    ScopeExp.duplicateDeclarationError((Declaration)old, decl, tr);
                }
                dupenv.put(name, templateScope, decl);
                let2.add(decl);
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
        Pair pair = (Pair)obj;
        Object bindings = pair.getCar();
        Object body = pair.getCdr();
        while (bindings != LList.Empty) {
            if (!(bindings instanceof Pair)) {
                return tr.syntaxError("bindings not a proper list");
            }
            Pair bind_pair = (Pair)bindings;
            Object bind_pair_car = bind_pair.getCar();
            if (!(bind_pair_car instanceof Pair)) {
                return tr.syntaxError(this.getName() + " binding is not a pair:" + bind_pair_car);
            }
            Pair binding = (Pair)bind_pair_car;
            Object saveLoc1 = tr.pushPositionOf(binding);
            Object[] r = bindDecls.parsePatternCar(binding, 0, let2, tr);
            Object binding_cdr = r[0];
            Declaration decl = (Declaration)r[1];
            this.maybeSetProcedure(decl);
            if (binding_cdr instanceof Pair) {
                Pair init = (Pair)binding_cdr;
                binding_cdr = init.getCdr();
                Expression initExp = tr.rewrite_car(init, null);
                decl.setInitValue(initExp);
                if (initExp != QuoteExp.undefined_exp) {
                    decl.noteValueFromLet(let2);
                }
                if (init.getCdr() != LList.Empty) {
                    Object saveLoc2 = tr.pushPositionOf(init.getCdr());
                    tr.error('e', "junk after initializer");
                    tr.popPositionOf(saveLoc2);
                }
            } else {
                tr.error('e', "let has no initializer");
            }
            tr.popPositionOf(saveLoc1);
            bindings = bind_pair.getCdr();
        }
        int i = renamedAliasesCount = renamedAliases.size();
        while (--i >= 0) {
            tr.pushRenamedAlias((Declaration)renamedAliases.pop());
        }
        tr.push(let2);
        try {
            let2.setBody(tr.rewrite_body(body));
        }
        finally {
            tr.pop(let2);
            tr.popRenamedAlias(renamedAliasesCount);
        }
        return let2;
    }

    protected void maybeSetProcedure(Declaration decl) {
        if (this.settingProcedures) {
            decl.setProcedureDecl(true);
        }
    }

}

