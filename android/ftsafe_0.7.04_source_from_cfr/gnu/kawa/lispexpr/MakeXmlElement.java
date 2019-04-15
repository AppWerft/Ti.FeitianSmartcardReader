/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.ReaderXmlElement;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class MakeXmlElement
extends Syntax {
    public static final MakeXmlElement makeXml = new MakeXmlElement();
    static final ClassType typeNamespace;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object nsPrefix;
        NamespaceBinding saveBindings;
        Pair pair1 = (Pair)form.getCdr();
        Object namespaceList = pair1.getCar();
        Object obj = pair1.getCdr();
        boolean nsSeen = false;
        NamespaceBinding nsBindings = saveBindings = tr.xmlElementNamespaces;
        while (namespaceList instanceof Pair) {
            Pair namespacePair;
            Pair namespaceNode;
            Namespace namespace;
            if (!nsSeen) {
                tr.letStart();
                nsSeen = true;
            }
            nsPrefix = ((String)(nsPrefix = (namespaceNode = (Pair)(namespacePair = (Pair)namespaceList).getCar()).getCar().toString())).length() == 0 ? null : ((String)nsPrefix).intern();
            Object valueList = namespaceNode.getCdr();
            StringBuilder sbuf = new StringBuilder();
            while (valueList instanceof Pair) {
                Object value;
                Pair valuePair = (Pair)valueList;
                Object valueForm = valuePair.getCar();
                if (LList.listLength(valueForm, false) == 2 && valueForm instanceof Pair && ((Pair)valueForm).getCar() == ReaderXmlElement.xmlTextSymbol) {
                    value = ((Pair)((Pair)valueForm).getCdr()).getCar();
                } else {
                    Expression valueExp = tr.rewrite_car(valuePair, false);
                    value = valueExp.valueIfConstant();
                }
                if (value == null) {
                    Object savePos = tr.pushPositionOf(valuePair);
                    tr.error('e', "namespace URI must be literal");
                    tr.popPositionOf(savePos);
                } else {
                    sbuf.append(value);
                }
                valueList = valuePair.getCdr();
            }
            String nsUri = sbuf.toString().intern();
            nsBindings = new NamespaceBinding((String)nsPrefix, nsUri == "" ? null : nsUri, nsBindings);
            if (nsPrefix == null) {
                namespace = Namespace.valueOf(nsUri);
                nsPrefix = "$default-element-namespace$";
            } else {
                namespace = XmlNamespace.getInstance((String)nsPrefix, nsUri);
            }
            Symbol nsSymbol = Namespace.EmptyNamespace.getSymbol((String)nsPrefix);
            Declaration decl = tr.letVariable(nsSymbol, typeNamespace, new QuoteExp(namespace));
            decl.setFlag(2121728L);
            namespaceList = namespacePair.getCdr();
        }
        MakeElement mkElement = new MakeElement();
        mkElement.setNamespaceNodes(nsBindings);
        mkElement.setStringIsText(true);
        tr.xmlElementNamespaces = nsBindings;
        try {
            if (nsSeen) {
                tr.letEnter();
            }
            Expression result = tr.rewrite(Translator.makePair(form, mkElement, obj));
            nsPrefix = nsSeen ? tr.letDone(result) : result;
            return nsPrefix;
        }
        finally {
            tr.xmlElementNamespaces = saveBindings;
        }
    }

    static {
        makeXml.setName("$make-xml$");
        typeNamespace = ClassType.make("gnu.mapping.Namespace");
    }
}

