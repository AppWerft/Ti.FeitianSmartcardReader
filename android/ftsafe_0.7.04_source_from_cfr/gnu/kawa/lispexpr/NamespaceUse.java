/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.lispexpr.LispPackage;

class NamespaceUse {
    LispPackage imported = new LispPackage();
    NamespaceUse nextImported;
    LispPackage importing = new LispPackage();
    NamespaceUse nextImporting;

    NamespaceUse() {
    }
}

