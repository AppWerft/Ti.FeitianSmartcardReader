// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

class NamespaceUse
{
    LispPackage imported;
    NamespaceUse nextImported;
    LispPackage importing;
    NamespaceUse nextImporting;
    
    NamespaceUse() {
        this.imported = new LispPackage();
        this.importing = new LispPackage();
    }
}
