/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.mapping.Symbol;

public abstract class AccessExp
extends Expression {
    public static final int PREFER_BINDING2 = 2;
    public static final int NEXT_AVAIL_FLAG = 4;
    Object symbol;
    Declaration binding;
    private Declaration context;

    public String string_name() {
        return this.symbol.toString();
    }

    @Override
    public final String getName() {
        return this.symbol == null ? null : (this.symbol instanceof Symbol ? ((Symbol)this.symbol).getName() : this.symbol.toString());
    }

    public final String getSimpleName() {
        if (this.symbol instanceof String) {
            return (String)this.symbol;
        }
        if (this.symbol instanceof Symbol) {
            Symbol sym = (Symbol)this.symbol;
            if (sym.hasEmptyNamespace()) {
                return sym.getLocalName();
            }
            if (sym.hasUnknownNamespace()) {
                return sym.getPrefix() + ':' + sym.getLocalPart();
            }
        }
        return null;
    }

    @Override
    public final Object getSymbol() {
        return this.symbol;
    }

    public final Declaration getBinding() {
        return this.binding;
    }

    public final void setBinding(Declaration decl) {
        if (decl != null && this.symbol == null) {
            this.symbol = decl.getSymbol();
        }
        this.binding = decl;
    }

    public final Declaration contextDecl() {
        return this.context;
    }

    public final void setContextDecl(Declaration decl) {
        this.context = decl;
    }
}

