// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.kawa.lispexpr.ReadTable;

class Lisp2ReadTable extends ReadTable
{
    @Override
    protected Object makeSymbol(final String name) {
        return Lisp2.asSymbol(name.intern());
    }
}
