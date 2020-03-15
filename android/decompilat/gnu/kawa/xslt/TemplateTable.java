// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xslt;

import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class TemplateTable
{
    Symbol name;
    static final TemplateTable nullModeTable;
    TemplateEntry entries;
    
    public TemplateTable(final Symbol mode) {
        this.name = mode;
    }
    
    static TemplateTable getTemplateTable(final Symbol name) {
        if (name == XSLT.nullMode) {
            return TemplateTable.nullModeTable;
        }
        return null;
    }
    
    public void enter(final String pattern, final double priority, final Procedure procedure) {
        final TemplateEntry entry = new TemplateEntry();
        entry.procedure = procedure;
        entry.priority = priority;
        entry.pattern = pattern;
        entry.next = this.entries;
        this.entries = entry;
    }
    
    public Procedure find(final String name) {
        for (TemplateEntry entry = this.entries; entry != null; entry = entry.next) {
            if (entry.pattern.equals(name)) {
                return entry.procedure;
            }
        }
        return null;
    }
    
    static {
        nullModeTable = new TemplateTable(XSLT.nullMode);
    }
}
