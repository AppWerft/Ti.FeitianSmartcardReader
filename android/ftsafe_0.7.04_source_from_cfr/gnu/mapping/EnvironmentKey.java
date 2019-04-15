/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Symbol;

public interface EnvironmentKey {
    public static final Object FUNCTION = Symbol.FUNCTION;

    public Symbol getKeySymbol();

    public Object getKeyProperty();

    public boolean matches(EnvironmentKey var1);

    public boolean matches(Symbol var1, Object var2);
}

