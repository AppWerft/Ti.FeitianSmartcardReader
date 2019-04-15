/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class DefineNamespace
extends Syntax {
    private boolean makePrivate;
    private boolean makeXML;
    public static final DefineNamespace define_namespace = new DefineNamespace();
    public static final DefineNamespace define_private_namespace = new DefineNamespace();
    public static final DefineNamespace define_xml_namespace = new DefineNamespace();
    public static final String XML_NAMESPACE_MAGIC = "&xml&";

    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        Pair p2;
        Pair p1;
        Expression value;
        if (!(st.getCdr() instanceof Pair && (p1 = (Pair)st.getCdr()).getCar() instanceof Symbol && p1.getCdr() instanceof Pair && (p2 = (Pair)p1.getCdr()).getCdr() == LList.Empty)) {
            tr.error('e', "invalid syntax for define-namespace");
            return false;
        }
        Symbol name = (Symbol)p1.getCar();
        Declaration decl = defs2.getDefine(name, tr);
        tr.push(decl);
        decl.setFlag(2375680L);
        if (this.makePrivate) {
            decl.setFlag(0x1000000L);
            decl.setPrivate(true);
        } else if (defs2 instanceof ModuleExp) {
            decl.setCanRead(true);
        }
        Translator.setLine(decl, (Object)p1);
        String literal = null;
        if (p2.getCar() instanceof CharSequence) {
            Namespace namespace;
            literal = p2.getCar().toString();
            String prefix = name.getName();
            if (literal.startsWith("class:")) {
                String cname = literal.substring(6);
                namespace = ClassNamespace.getInstance(literal, ClassType.make(cname));
                decl.setType(ClassType.make("gnu.kawa.lispexpr.ClassNamespace"));
            } else if (this.makeXML) {
                namespace = XmlNamespace.getInstance(prefix, literal);
                decl.setType(ClassType.make("gnu.kawa.xml.XmlNamespace"));
            } else {
                namespace = Namespace.valueOf(literal, prefix);
                decl.setType(ClassType.make("gnu.mapping.Namespace"));
            }
            value = new QuoteExp(namespace);
            decl.setFlag(8192L);
        } else {
            value = tr.rewrite_car(p2, false);
        }
        decl.noteValue(value);
        tr.pushForm(SetExp.makeDefinition(decl, value));
        return true;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        return tr.syntaxError("define-namespace is only allowed in a <body>");
    }

    static {
        define_namespace.setName("define-namespace");
        define_private_namespace.setName("define-private-namespace");
        DefineNamespace.define_private_namespace.makePrivate = true;
        define_xml_namespace.setName("define-xml-namespace");
        DefineNamespace.define_xml_namespace.makeXML = true;
    }
}

