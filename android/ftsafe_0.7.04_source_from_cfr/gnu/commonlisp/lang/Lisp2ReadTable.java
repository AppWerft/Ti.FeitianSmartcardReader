/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.commonlisp.lang.Lisp2;
import gnu.kawa.lispexpr.ReadTable;

class Lisp2ReadTable
extends ReadTable {
    Lisp2ReadTable() {
    }

    @Override
    protected Object makeSymbol(String name) {
        return Lisp2.asSymbol(name.intern());
    }
}

