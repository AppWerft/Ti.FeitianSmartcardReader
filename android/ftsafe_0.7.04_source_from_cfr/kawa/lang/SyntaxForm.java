/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import kawa.lang.TemplateScope;

public interface SyntaxForm {
    public Object getDatum();

    public TemplateScope getScope();
}

