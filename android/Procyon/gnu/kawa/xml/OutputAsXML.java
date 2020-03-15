// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.FString;
import gnu.lists.PrintConsumer;
import gnu.xml.XMLPrinter;
import gnu.kawa.io.CharArrayOutPort;
import gnu.mapping.Procedure1;

public class OutputAsXML extends Procedure1
{
    @Override
    public int numArgs() {
        return 4097;
    }
    
    @Override
    public Object apply1(final Object arg) {
        final CharArrayOutPort port = new CharArrayOutPort();
        final XMLPrinter out = new XMLPrinter(port);
        out.writeObject(arg);
        out.flush();
        return new FString(port.toCharArray());
    }
}
