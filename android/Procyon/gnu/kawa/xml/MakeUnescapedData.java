// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.UnescapedData;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;

public class MakeUnescapedData extends Procedure1
{
    public static final MakeUnescapedData unescapedData;
    
    public MakeUnescapedData() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyMakeUnescapedData");
    }
    
    @Override
    public Object apply1(final Object arg) {
        return new UnescapedData((arg == null) ? "" : arg.toString());
    }
    
    static {
        unescapedData = new MakeUnescapedData();
    }
}
