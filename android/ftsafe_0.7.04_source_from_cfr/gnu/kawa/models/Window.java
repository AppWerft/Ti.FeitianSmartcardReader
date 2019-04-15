/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Display;

public interface Window {
    public Display getDisplay();

    public void setContent(Object var1);

    public void setTitle(String var1);

    public void setMenuBar(Object var1);

    public String getTitle();

    public void open();
}

