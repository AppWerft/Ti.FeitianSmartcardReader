/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.ModuleManager;

public abstract class ModuleSet {
    public static final String MODULES_MAP = "$ModulesMap$";
    ModuleSet next;

    public abstract void register(ModuleManager var1);
}

