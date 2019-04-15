/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.lists.UnescapedData;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Symbol;

public class MakeUnescapedData
extends Procedure1 {
    public static final MakeUnescapedData unescapedData = new MakeUnescapedData();

    public MakeUnescapedData() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyMakeUnescapedData");
    }

    @Override
    public Object apply1(Object arg) {
        return new UnescapedData(arg == null ? "" : arg.toString());
    }
}

