/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import org.xml.sax.Locator;

public interface SourceLocator
extends Locator {
    @Override
    public int getColumnNumber();

    @Override
    public int getLineNumber();

    @Override
    public String getPublicId();

    @Override
    public String getSystemId();

    public String getFileName();

    public boolean isStableSourceLocation();
}

