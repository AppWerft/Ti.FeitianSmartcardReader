// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.expr.QuoteExp;
import gnu.mapping.Namespace;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class ResolveNamespace extends Syntax
{
    public static final ResolveNamespace resolveNamespace;
    public static final ResolveNamespace resolveQName;
    boolean resolvingQName;
    
    public ResolveNamespace(final String name, final boolean resolvingQName) {
        super(name);
        this.resolvingQName = resolvingQName;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        Object cdr = form.getCdr();
        String local;
        if (this.resolvingQName) {
            final Pair pair = (Pair)cdr;
            local = pair.getCar().toString();
            cdr = pair.getCdr();
        }
        else {
            local = null;
        }
        if (!(cdr instanceof Pair)) {
            cdr = LList.list1(ReaderXmlElement.defaultElementNamespaceSymbol);
        }
        final Pair pair = (Pair)cdr;
        final Expression prefix = tr.rewrite_car(pair, false);
        Namespace namespace = tr.namespaceResolvePrefix(prefix);
        if (namespace == null) {
            final String pstr = pair.getCar().toString();
            if (pstr == "$default-element-namespace$") {
                namespace = Namespace.EmptyNamespace;
            }
            else {
                final Object savePos = tr.pushPositionOf(pair);
                tr.error('e', "unknown namespace prefix " + pstr);
                tr.popPositionOf(savePos);
                namespace = Namespace.valueOf(pstr, pstr);
            }
        }
        if (this.resolvingQName) {
            return new QuoteExp(namespace.getSymbol(local));
        }
        return new QuoteExp(namespace);
    }
    
    static {
        resolveNamespace = new ResolveNamespace("$resolve-namespace$", false);
        resolveQName = new ResolveNamespace("$resolve-qname$", true);
    }
}
