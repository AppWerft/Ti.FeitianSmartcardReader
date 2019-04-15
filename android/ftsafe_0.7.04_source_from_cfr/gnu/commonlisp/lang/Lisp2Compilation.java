/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.NameLookup;
import gnu.expr.ReferenceExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.SourceMessages;
import kawa.lang.Translator;

public class Lisp2Compilation
extends Translator {
    static final Method isTrueMethod = ClassType.make("gnu.commonlisp.lang.Lisp2").getDeclaredMethod("isTrueLisp", 1);

    public Lisp2Compilation(Language language, SourceMessages messages, NameLookup lexical) {
        super(language, messages, lexical);
    }

    @Override
    public void emitPushBoolean(boolean value) {
        CodeAttr code = this.getCode();
        if (value) {
            code.emitGetStatic(ClassType.make("gnu.commonlisp.lang.Lisp2").getDeclaredField("TRUE"));
        } else {
            code.emitGetStatic(Compilation.scmListType.getDeclaredField("Empty"));
        }
    }

    @Override
    public Type asBooleanValue(ConditionalTarget target, Type stackType) {
        if (stackType instanceof ObjectType) {
            this.getCode().emitInvoke(isTrueMethod);
            stackType = Type.booleanType;
        }
        return stackType;
    }

    @Override
    protected void rewriteBody(LList list) {
        if (list.isEmpty()) {
            return;
        }
        Object head = ((Pair)list).getCar();
        Object body = ((Pair)list).getCdr();
        if (head instanceof Pair && this.matches(((Pair)head).getCar(), "declare")) {
            Object decls = ((Pair)head).getCdr();
            this.letStart();
            while (decls != LList.Empty) {
                Object save;
                Object vars;
                if (!(decls instanceof Pair) || !(((Pair)decls).getCar() instanceof Pair)) {
                    this.errorWithPosition("Arguments to declare must be proper lists", decls);
                    break;
                }
                Pair declItem = (Pair)((Pair)decls).getCar();
                if (!(declItem.getCdr() instanceof Pair)) {
                    this.errorWithPosition("Bad declare syntax, expected a list but got something else.", declItem);
                    break;
                }
                if (this.matches(declItem.getCar(), "type")) {
                    if (!((declItem = (Pair)declItem.getCdr()).getCdr() instanceof Pair)) {
                        save = this.pushPositionOf(declItem);
                        this.error('e', "A type specifier must be applied to at least one declaration.");
                        this.popPositionOf(save);
                        break;
                    }
                    vars = (Pair)declItem.getCdr();
                } else {
                    vars = (Pair)declItem.getCdr();
                }
                while (vars != LList.Empty) {
                    if (!(vars instanceof Pair)) {
                        save = this.pushPositionOf(vars);
                        this.error('e', "The variable list in a declare form must be a proper list.");
                        this.popPositionOf(save);
                        break;
                    }
                    Object var = ((Pair)vars).getCar();
                    Declaration varDecl = (Declaration)this.lexical.get(var);
                    if (varDecl != null) {
                        Declaration aliasedDecl = new Declaration(varDecl.getSymbol());
                        ReferenceExp ref = new ReferenceExp(varDecl);
                        this.letVariable(aliasedDecl, ref);
                        aliasedDecl.setType(this.exp2Type(declItem));
                        aliasedDecl.setFlag(8192L);
                        aliasedDecl.setFlag(262144L);
                    } else {
                        this.error('w', "No declaration seen for `" + var + "`");
                    }
                    vars = ((Pair)vars).getCdr();
                }
                decls = ((Pair)decls).getCdr();
            }
            this.letEnter();
            this.pushForm(this.letDone(super.rewrite_body(body)));
        } else {
            super.rewriteBody(list);
        }
    }
}

