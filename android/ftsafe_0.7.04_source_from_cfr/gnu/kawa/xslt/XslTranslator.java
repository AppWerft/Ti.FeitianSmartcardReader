/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xslt;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.ModuleExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xslt.ApplyTemplates;
import gnu.kawa.xslt.XSLT;
import gnu.lists.Consumer;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.xml.XMLParser;
import gnu.xml.XName;
import gnu.xquery.lang.XQParser;
import gnu.xquery.lang.XQuery;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

public class XslTranslator
extends Lexer
implements Consumer {
    boolean inTemplate;
    Declaration consumerDecl;
    StringBuffer nesting = new StringBuffer(100);
    ModuleExp mexp;
    Compilation comp;
    boolean inAttribute;
    Object attributeType;
    StringBuffer attributeValue = new StringBuffer(100);
    boolean preserveSpace;
    XSLT interpreter;
    InPort in;
    LambdaExp templateLambda;
    static final String XSL_TRANSFORM_URI = "http://www.w3.org/1999/XSL/Transform";
    static final ClassType typeXSLT = ClassType.make("gnu.kawa.xslt.XSLT");
    static final ClassType typeTemplateTable = ClassType.make("gnu.kawa.xslt.TemplateTable");
    static final Method defineTemplateMethod = typeXSLT.getDeclaredMethod("defineTemplate", 5);
    static final Method runStylesheetMethod = typeXSLT.getDeclaredMethod("runStylesheet", 0);
    static final PrimProcedure defineTemplateProc = new PrimProcedure(defineTemplateMethod);
    static final PrimProcedure runStylesheetProc = new PrimProcedure(runStylesheetMethod);

    XslTranslator(InPort inp, SourceMessages messages, XSLT interpreter) {
        super(inp, messages);
        this.interpreter = interpreter;
        this.in = inp;
    }

    void maybeSkipWhitespace() {
        Expression expr;
        if (this.preserveSpace) {
            return;
        }
        int size = this.comp.exprStack.size();
        while (--size >= 0 && (expr = (Expression)this.comp.exprStack.elementAt(size)) instanceof QuoteExp) {
            Object value = ((QuoteExp)expr).getValue();
            String str = value == null ? "" : value.toString();
            int j = str.length();
            while (--j >= 0) {
                char ch = str.charAt(j);
                if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n') continue;
                return;
            }
        }
        this.comp.exprStack.setSize(size + 1);
    }

    public String popMatchingAttribute(String ns, String name, int start) {
        int size = this.comp.exprStack.size();
        for (int i = start; i < size; ++i) {
            Object el = this.comp.exprStack.elementAt(start);
            if (!(el instanceof ApplyExp)) {
                return null;
            }
            ApplyExp aexp = (ApplyExp)el;
            Expression function2 = aexp.getFunction();
            if (aexp.getFunction() != MakeAttribute.makeAttributeExp) {
                return null;
            }
            Expression[] args = aexp.getArgs();
            if (args.length != 2) {
                return null;
            }
            Expression arg0 = args[0];
            if (!(arg0 instanceof QuoteExp)) {
                return null;
            }
            Object tag = ((QuoteExp)arg0).getValue();
            if (!(tag instanceof Symbol)) {
                return null;
            }
            Symbol stag = (Symbol)tag;
            if (stag.getLocalPart() != name || stag.getNamespaceURI() != ns) continue;
            this.comp.exprStack.removeElementAt(i);
            return (String)((QuoteExp)args[1]).getValue();
        }
        return null;
    }

    Expression popTemplateBody(int start) {
        int i = this.comp.exprStack.size() - start;
        Expression[] args = new Expression[i];
        while (--i >= 0) {
            args[i] = this.comp.exprStack.pop();
        }
        return new ApplyExp(AppendValues.appendValues, args);
    }

    public static String isXslTag(Object type) {
        if (type instanceof QuoteExp) {
            type = ((QuoteExp)type).getValue();
        }
        if (!(type instanceof Symbol)) {
            return null;
        }
        Symbol qname = (Symbol)type;
        if (qname.getNamespaceURI() != XSL_TRANSFORM_URI) {
            return null;
        }
        return qname.getLocalName();
    }

    void append(Expression expr) {
    }

    @Override
    public void startElement(Object type) {
        this.maybeSkipWhitespace();
        String xslTag = XslTranslator.isXslTag(type);
        if (xslTag == "template") {
            if (this.templateLambda != null) {
                this.error("nested xsl:template");
            }
            this.templateLambda = new LambdaExp();
        } else if (xslTag == "text") {
            this.preserveSpace = false;
        }
        if (type instanceof XName) {
            XName xn = (XName)type;
            type = Symbol.make(xn.getNamespaceURI(), xn.getLocalPart(), xn.getPrefix());
        }
        this.nesting.append((char)this.comp.exprStack.size());
        this.push(type);
    }

    @Override
    public void startAttribute(Object attrType) {
        if (this.inAttribute) {
            this.error('f', "internal error - attribute inside attribute");
        }
        this.attributeType = attrType;
        this.attributeValue.setLength(0);
        this.nesting.append((char)this.comp.exprStack.size());
        this.inAttribute = true;
    }

    @Override
    public void endAttribute() {
        Expression[] args = new Expression[]{new QuoteExp(this.attributeType), new QuoteExp(this.attributeValue.toString())};
        this.push(new ApplyExp(MakeAttribute.makeAttributeExp, args));
        this.nesting.setLength(this.nesting.length() - 1);
        this.inAttribute = false;
    }

    @Override
    public void endElement() {
        this.maybeSkipWhitespace();
        int nlen = this.nesting.length() - 1;
        char start = this.nesting.charAt(nlen);
        this.nesting.setLength(nlen);
        Expression startTag = (Expression)this.comp.exprStack.elementAt(start);
        String xslTag = XslTranslator.isXslTag(startTag);
        if (xslTag == "value-of") {
            String select = this.popMatchingAttribute("", "select", start + '\u0001');
            if (select != null) {
                Expression exp = this.parseXPath(select);
                exp = new ApplyExp(XQParser.makeText, exp);
                this.comp.exprStack.pop();
                this.push(exp);
                return;
            }
        } else if (xslTag == "copy-of") {
            String select = this.popMatchingAttribute("", "select", start + '\u0001');
            if (select != null) {
                Expression exp = this.parseXPath(select);
                this.comp.exprStack.pop();
                this.push(exp);
                return;
            }
        } else if (xslTag == "apply-templates") {
            String select = this.popMatchingAttribute("", "select", start + '\u0001');
            String mode = this.popMatchingAttribute("", "mode", start + '\u0001');
            Expression[] args = new Expression[]{new QuoteExp(select), this.resolveQNameExpression(mode)};
            this.comp.exprStack.pop();
            this.push(new ApplyExp(ApplyTemplates.applyTemplatesProc, args));
        } else if (xslTag == "if") {
            String select = this.popMatchingAttribute("", "test", start + '\u0001');
            Expression test = this.parseXPath(select);
            test = XQParser.booleanValue(test);
            Expression clause = this.popTemplateBody(start + '\u0001');
            this.comp.exprStack.pop();
            this.push(new IfExp(test, clause, QuoteExp.voidExp));
        } else if (xslTag == "stylesheet" || xslTag == "transform") {
            String version = this.popMatchingAttribute("", "version", start + '\u0001');
            this.push(new ApplyExp(new QuoteExp(runStylesheetProc), Expression.noExpressions));
            Expression body = this.popTemplateBody(start + '\u0001');
            this.push(body);
            this.mexp.body = body;
        } else if (xslTag == "template") {
            String match = this.popMatchingAttribute("", "match", start + '\u0001');
            String name = this.popMatchingAttribute("", "name", start + '\u0001');
            String priority = this.popMatchingAttribute("", "priority", start + '\u0001');
            String mode = this.popMatchingAttribute("", "mode", start + '\u0001');
            this.templateLambda.body = this.popTemplateBody(start + '\u0001');
            this.comp.exprStack.pop();
            Expression[] args = new Expression[5];
            double prio = 0.0;
            args[0] = this.resolveQNameExpression(name);
            args[1] = new QuoteExp(match);
            args[2] = new QuoteExp(DFloNum.valueOf(prio));
            args[3] = this.resolveQNameExpression(mode);
            args[4] = this.templateLambda;
            this.push(new ApplyExp(new QuoteExp(defineTemplateProc), args));
            this.templateLambda = null;
        } else if (xslTag == "text") {
            this.preserveSpace = false;
            Expression[] args = new Expression[this.comp.exprStack.size() - start - 1];
            int i = args.length;
            while (--i >= 0) {
                args[i] = this.comp.exprStack.pop();
            }
            this.comp.exprStack.pop();
            ApplyExp exp = new ApplyExp(XQParser.makeText, args);
            this.push(exp);
            this.mexp.body = exp;
        } else {
            Expression[] args = new Expression[this.comp.exprStack.size() - start];
            int i = args.length;
            while (--i >= 0) {
                args[i] = this.comp.exprStack.pop();
            }
            MakeElement mkElement = new MakeElement();
            ApplyExp exp = new ApplyExp(new QuoteExp(mkElement), args);
            this.push(exp);
            this.mexp.body = exp;
        }
    }

    Expression parseXPath(String string) {
        SourceMessages messages = this.comp.getMessages();
        try {
            Expression sexp;
            XQParser parser = new XQParser(new CharArrayInPort(string), messages, this.interpreter);
            Vector<Expression> exps = new Vector<Expression>(20);
            while ((sexp = parser.parse(this.comp)) != null) {
                exps.addElement(sexp);
            }
            int nexps = exps.size();
            if (nexps == 0) {
                return QuoteExp.voidExp;
            }
            if (nexps == 1) {
                return (Expression)exps.elementAt(0);
            }
            throw new InternalError("too many xpath expressions");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new InternalError("caught " + ex);
        }
    }

    @Override
    public void write(int v) {
        if (this.inAttribute) {
            this.attributeValue.appendCodePoint(v);
        } else {
            String str;
            if (v < 65536) {
                str = String.valueOf(v);
            } else {
                char[] c2 = new char[]{(char)((v - 65536 >> 10) + 55296), (char)((v & 1023) + 56320)};
                str = new String(c2);
            }
            this.push(str);
        }
    }

    @Override
    public Consumer append(char v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        } else {
            this.push(String.valueOf(v));
        }
        return this;
    }

    @Override
    public Consumer append(CharSequence csq) {
        if (this.inAttribute) {
            this.attributeValue.append(csq);
        } else {
            this.push(((Object)csq).toString());
        }
        return this;
    }

    @Override
    public Consumer append(CharSequence csq, int start, int end) {
        return this.append(csq.subSequence(start, end));
    }

    void push(Expression exp) {
        this.comp.exprStack.push(exp);
    }

    void push(Object value) {
        this.push(new QuoteExp(value));
    }

    @Override
    public void writeBoolean(boolean v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        } else {
            this.push(v ? QuoteExp.trueExp : QuoteExp.falseExp);
        }
    }

    @Override
    public void writeFloat(float v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        } else {
            this.push(DFloNum.valueOf(v));
        }
    }

    @Override
    public void writeDouble(double v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        } else {
            this.push(DFloNum.valueOf(v));
        }
    }

    @Override
    public void writeInt(int v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        } else {
            this.push(IntNum.valueOf(v));
        }
    }

    @Override
    public void writeLong(long v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        } else {
            this.push(IntNum.valueOf(v));
        }
    }

    @Override
    public void startDocument() {
    }

    public void startDocument(ModuleExp mexp) {
        this.mexp = mexp;
        this.startDocument();
    }

    @Override
    public void endDocument() {
    }

    @Override
    public void writeObject(Object v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        } else {
            this.push(v);
        }
    }

    @Override
    public void write(char[] buf, int off, int len) {
        if (this.inAttribute) {
            this.attributeValue.append(buf, off, len);
        } else {
            this.push(new String(buf, off, len));
        }
    }

    @Override
    public void write(String str) {
        if (this.inAttribute) {
            this.attributeValue.append(str);
        } else {
            this.push(str);
        }
    }

    @Override
    public void write(CharSequence str, int start, int length) {
        this.write(((Object)str.subSequence(start, length)).toString());
    }

    @Override
    public boolean ignoring() {
        return false;
    }

    public Expression getExpression() {
        return this.comp.exprStack.pop();
    }

    @Override
    public void error(char kind, String message) {
        this.getMessages().error(kind, message);
    }

    Expression resolveQNameExpression(String name) {
        if (name == null) {
            return QuoteExp.nullExp;
        }
        return new QuoteExp(Symbol.make(null, name));
    }

    public void parse(Compilation comp) throws IOException {
        this.comp = comp;
        if (comp.exprStack == null) {
            comp.exprStack = new Stack();
        }
        ModuleExp mexp = comp.getModule();
        comp.mustCompileHere();
        this.startDocument(mexp);
        XMLParser.parse(this.in, this.getMessages(), (Consumer)this);
        this.endDocument();
        comp.pop(mexp);
    }
}

