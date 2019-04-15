/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.mapping.Procedure;

public interface TypeValue
extends java.lang.reflect.Type {
    public Type getImplementationType();

    public void emitTestIf(Variable var1, Declaration var2, Compilation var3);

    public void emitIsInstance(Variable var1, Compilation var2, Target var3);

    public Procedure getConstructor();

    public Expression convertValue(Expression var1);

    public String encodeType(Language var1);
}

