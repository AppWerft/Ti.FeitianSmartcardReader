/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.ReaderXmlElement;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class ResolveNamespace
extends Syntax {
    public static final ResolveNamespace resolveNamespace = new ResolveNamespace("$resolve-namespace$", false);
    public static final ResolveNamespace resolveQName = new ResolveNamespace("$resolve-qname$", true);
    boolean resolvingQName;

    public ResolveNamespace(String name, boolean resolvingQName) {
        super(name);
        this.resolvingQName = resolvingQName;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        String local;
        Expression prefix;
        Pair pair;
        Namespace namespace;
        Object cdr = form.getCdr();
        if (this.resolvingQName) {
            pair = (Pair)cdr;
            local = pair.getCar().toString();
            cdr = pair.getCdr();
        } else {
            local = null;
        }
        if (!(cdr instanceof Pair)) {
            cdr = LList.list1(ReaderXmlElement.defaultElementNamespaceSymbol);
        }
        if ((namespace = tr.namespaceResolvePrefix(prefix = tr.rewrite_car(pair = (Pair)cdr, false))) == null) {
            String pstr = pair.getCar().toString();
            if (pstr == "$default-element-namespace$") {
                namespace = Namespace.EmptyNamespace;
            } else {
                Object savePos = tr.pushPositionOf(pair);
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
}

