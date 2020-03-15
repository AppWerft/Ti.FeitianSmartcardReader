// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.expr.Expression;
import gnu.expr.Declaration;
import gnu.expr.SetExp;
import gnu.expr.QuoteExp;
import gnu.mapping.Namespace;
import gnu.kawa.xml.XmlNamespace;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.expr.ModuleExp;
import gnu.expr.Compilation;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class DefineNamespace extends Syntax
{
    private boolean makePrivate;
    private boolean makeXML;
    public static final DefineNamespace define_namespace;
    public static final DefineNamespace define_private_namespace;
    public static final DefineNamespace define_xml_namespace;
    public static final String XML_NAMESPACE_MAGIC = "&xml&";
    
    @Override
    public boolean scanForDefinitions(final Pair st, final ScopeExp defs, final Translator tr) {
        final Pair p1;
        final Pair p2;
        if (!(st.getCdr() instanceof Pair) || (!((p1 = (Pair)st.getCdr()).getCar() instanceof Symbol) || !(p1.getCdr() instanceof Pair)) || (p2 = (Pair)p1.getCdr()).getCdr() != LList.Empty) {
            tr.error('e', "invalid syntax for define-namespace");
            return false;
        }
        final Symbol name = (Symbol)p1.getCar();
        final Declaration decl = defs.getDefine(name, tr);
        tr.push(decl);
        decl.setFlag(2375680L);
        if (this.makePrivate) {
            decl.setFlag(16777216L);
            decl.setPrivate(true);
        }
        else if (defs instanceof ModuleExp) {
            decl.setCanRead(true);
        }
        Translator.setLine(decl, p1);
        String literal = null;
        Expression value;
        if (p2.getCar() instanceof CharSequence) {
            literal = p2.getCar().toString();
            final String prefix = name.getName();
            Namespace namespace;
            if (literal.startsWith("class:")) {
                final String cname = literal.substring(6);
                namespace = ClassNamespace.getInstance(literal, ClassType.make(cname));
                decl.setType(ClassType.make("gnu.kawa.lispexpr.ClassNamespace"));
            }
            else if (this.makeXML) {
                namespace = XmlNamespace.getInstance(prefix, literal);
                decl.setType(ClassType.make("gnu.kawa.xml.XmlNamespace"));
            }
            else {
                namespace = Namespace.valueOf(literal, prefix);
                decl.setType(ClassType.make("gnu.mapping.Namespace"));
            }
            value = new QuoteExp(namespace);
            decl.setFlag(8192L);
        }
        else {
            value = tr.rewrite_car(p2, false);
        }
        decl.noteValue(value);
        tr.pushForm(SetExp.makeDefinition(decl, value));
        return true;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return tr.syntaxError("define-namespace is only allowed in a <body>");
    }
    
    static {
        define_namespace = new DefineNamespace();
        define_private_namespace = new DefineNamespace();
        define_xml_namespace = new DefineNamespace();
        DefineNamespace.define_namespace.setName("define-namespace");
        DefineNamespace.define_private_namespace.setName("define-private-namespace");
        DefineNamespace.define_private_namespace.makePrivate = true;
        DefineNamespace.define_xml_namespace.setName("define-xml-namespace");
        DefineNamespace.define_xml_namespace.makeXML = true;
    }
}
