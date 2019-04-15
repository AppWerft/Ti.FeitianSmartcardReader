/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xslt;

import gnu.kawa.xslt.TemplateEntry;
import gnu.kawa.xslt.XSLT;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class TemplateTable {
    Symbol name;
    static final TemplateTable nullModeTable = new TemplateTable(XSLT.nullMode);
    TemplateEntry entries;

    public TemplateTable(Symbol mode) {
        this.name = mode;
    }

    static TemplateTable getTemplateTable(Symbol name) {
        if (name == XSLT.nullMode) {
            return nullModeTable;
        }
        return null;
    }

    public void enter(String pattern, double priority, Procedure procedure) {
        TemplateEntry entry = new TemplateEntry();
        entry.procedure = procedure;
        entry.priority = priority;
        entry.pattern = pattern;
        entry.next = this.entries;
        this.entries = entry;
    }

    public Procedure find(String name) {
        TemplateEntry entry = this.entries;
        while (entry != null) {
            if (entry.pattern.equals(name)) {
                return entry.procedure;
            }
            entry = entry.next;
        }
        return null;
    }
}

