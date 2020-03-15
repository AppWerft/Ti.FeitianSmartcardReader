// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.kawa.util.AbstractHashTable;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.expr.Declaration;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ConditionalTarget;
import gnu.bytecode.CodeAttr;
import gnu.expr.Compilation;
import gnu.bytecode.ClassType;
import gnu.expr.NameLookup;
import gnu.text.SourceMessages;
import gnu.expr.Language;
import gnu.bytecode.Method;
import kawa.lang.Translator;

public class Lisp2Compilation extends Translator
{
    static final Method isTrueMethod;
    
    public Lisp2Compilation(final Language language, final SourceMessages messages, final NameLookup lexical) {
        super(language, messages, lexical);
    }
    
    @Override
    public void emitPushBoolean(final boolean value) {
        final CodeAttr code = this.getCode();
        if (value) {
            code.emitGetStatic(ClassType.make("gnu.commonlisp.lang.Lisp2").getDeclaredField("TRUE"));
        }
        else {
            code.emitGetStatic(Compilation.scmListType.getDeclaredField("Empty"));
        }
    }
    
    @Override
    public Type asBooleanValue(final ConditionalTarget target, Type stackType) {
        if (stackType instanceof ObjectType) {
            this.getCode().emitInvoke(Lisp2Compilation.isTrueMethod);
            stackType = Type.booleanType;
        }
        return stackType;
    }
    
    @Override
    protected void rewriteBody(final LList list) {
        if (list.isEmpty()) {
            return;
        }
        final Object head = ((Pair)list).getCar();
        final Object body = ((Pair)list).getCdr();
        if (head instanceof Pair && this.matches(((Pair)head).getCar(), "declare")) {
            Object decls = ((Pair)head).getCdr();
            this.letStart();
            while (decls != LList.Empty) {
                if (!(decls instanceof Pair) || !(((Pair)decls).getCar() instanceof Pair)) {
                    this.errorWithPosition("Arguments to declare must be proper lists", decls);
                    break;
                }
                Pair declItem = (Pair)((Pair)decls).getCar();
                if (!(declItem.getCdr() instanceof Pair)) {
                    this.errorWithPosition("Bad declare syntax, expected a list but got something else.", declItem);
                    break;
                }
                Object vars;
                if (this.matches(declItem.getCar(), "type")) {
                    declItem = (Pair)declItem.getCdr();
                    if (!(declItem.getCdr() instanceof Pair)) {
                        final Object save = this.pushPositionOf(declItem);
                        this.error('e', "A type specifier must be applied to at least one declaration.");
                        this.popPositionOf(save);
                        break;
                    }
                    vars = declItem.getCdr();
                }
                else {
                    vars = declItem.getCdr();
                }
                while (vars != LList.Empty) {
                    if (!(vars instanceof Pair)) {
                        final Object save = this.pushPositionOf(vars);
                        this.error('e', "The variable list in a declare form must be a proper list.");
                        this.popPositionOf(save);
                        break;
                    }
                    final Object var = ((Pair)vars).getCar();
                    final Declaration varDecl = ((AbstractHashTable<Entry, K, Declaration>)this.lexical).get(var);
                    if (varDecl != null) {
                        final Declaration aliasedDecl = new Declaration(varDecl.getSymbol());
                        final ReferenceExp ref = new ReferenceExp(varDecl);
                        this.letVariable(aliasedDecl, ref);
                        aliasedDecl.setType(this.exp2Type(declItem));
                        aliasedDecl.setFlag(8192L);
                        aliasedDecl.setFlag(262144L);
                    }
                    else {
                        this.error('w', "No declaration seen for `" + var + "`");
                    }
                    vars = ((Pair)vars).getCdr();
                }
                decls = ((Pair)decls).getCdr();
            }
            this.letEnter();
            this.pushForm(this.letDone(super.rewrite_body(body)));
        }
        else {
            super.rewriteBody(list);
        }
    }
    
    static {
        isTrueMethod = ClassType.make("gnu.commonlisp.lang.Lisp2").getDeclaredMethod("isTrueLisp", 1);
    }
}
