// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.expr.Declaration;
import gnu.mapping.Symbol;
import gnu.kawa.xml.MakeElement;
import gnu.bytecode.Type;
import gnu.expr.QuoteExp;
import gnu.kawa.xml.XmlNamespace;
import gnu.mapping.Namespace;
import gnu.xml.NamespaceBinding;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.lists.Pair;
import gnu.bytecode.ClassType;
import kawa.lang.Syntax;

public class MakeXmlElement extends Syntax
{
    public static final MakeXmlElement makeXml;
    static final ClassType typeNamespace;
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Pair pair1 = (Pair)form.getCdr();
        Object namespaceList = pair1.getCar();
        final Object obj = pair1.getCdr();
        boolean nsSeen = false;
        NamespaceBinding nsBindings;
        final NamespaceBinding saveBindings = nsBindings = tr.xmlElementNamespaces;
        while (namespaceList instanceof Pair) {
            if (!nsSeen) {
                tr.letStart();
                nsSeen = true;
            }
            final Pair namespacePair = (Pair)namespaceList;
            final Pair namespaceNode = (Pair)namespacePair.getCar();
            String nsPrefix = namespaceNode.getCar().toString();
            nsPrefix = ((nsPrefix.length() == 0) ? null : nsPrefix.intern());
            Object valueList = namespaceNode.getCdr();
            final StringBuilder sbuf = new StringBuilder();
            while (valueList instanceof Pair) {
                final Pair valuePair = (Pair)valueList;
                final Object valueForm = valuePair.getCar();
                Object value;
                if (LList.listLength(valueForm, false) == 2 && valueForm instanceof Pair && ((Pair)valueForm).getCar() == ReaderXmlElement.xmlTextSymbol) {
                    value = ((Pair)((Pair)valueForm).getCdr()).getCar();
                }
                else {
                    final Expression valueExp = tr.rewrite_car(valuePair, false);
                    value = valueExp.valueIfConstant();
                }
                if (value == null) {
                    final Object savePos = tr.pushPositionOf(valuePair);
                    tr.error('e', "namespace URI must be literal");
                    tr.popPositionOf(savePos);
                }
                else {
                    sbuf.append(value);
                }
                valueList = valuePair.getCdr();
            }
            final String nsUri = sbuf.toString().intern();
            nsBindings = new NamespaceBinding(nsPrefix, (nsUri == "") ? null : nsUri, nsBindings);
            Namespace namespace;
            if (nsPrefix == null) {
                namespace = Namespace.valueOf(nsUri);
                nsPrefix = "$default-element-namespace$";
            }
            else {
                namespace = XmlNamespace.getInstance(nsPrefix, nsUri);
            }
            final Symbol nsSymbol = Namespace.EmptyNamespace.getSymbol(nsPrefix);
            final Declaration decl = tr.letVariable(nsSymbol, MakeXmlElement.typeNamespace, new QuoteExp(namespace));
            decl.setFlag(2121728L);
            namespaceList = namespacePair.getCdr();
        }
        final MakeElement mkElement = new MakeElement();
        mkElement.setNamespaceNodes(nsBindings);
        mkElement.setStringIsText(true);
        tr.xmlElementNamespaces = nsBindings;
        try {
            if (nsSeen) {
                tr.letEnter();
            }
            final Expression result = tr.rewrite(Translator.makePair(form, mkElement, obj));
            return nsSeen ? tr.letDone(result) : result;
        }
        finally {
            tr.xmlElementNamespaces = saveBindings;
        }
    }
    
    static {
        (makeXml = new MakeXmlElement()).setName("$make-xml$");
        typeNamespace = ClassType.make("gnu.mapping.Namespace");
    }
}
