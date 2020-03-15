// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xslt;

import java.io.IOException;
import gnu.expr.ScopeExp;
import gnu.xml.XMLParser;
import java.util.Stack;
import gnu.math.IntNum;
import java.util.Vector;
import gnu.xquery.lang.XQuery;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.xml.MakeElement;
import gnu.math.DFloNum;
import gnu.expr.IfExp;
import gnu.xquery.lang.XQParser;
import gnu.xml.XName;
import gnu.mapping.Procedure;
import gnu.kawa.functions.AppendValues;
import gnu.mapping.Symbol;
import gnu.kawa.xml.MakeAttribute;
import gnu.expr.ApplyExp;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.text.SourceMessages;
import gnu.expr.PrimProcedure;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.LambdaExp;
import gnu.kawa.io.InPort;
import gnu.expr.Compilation;
import gnu.expr.ModuleExp;
import gnu.expr.Declaration;
import gnu.lists.Consumer;
import gnu.text.Lexer;

public class XslTranslator extends Lexer implements Consumer
{
    boolean inTemplate;
    Declaration consumerDecl;
    StringBuffer nesting;
    ModuleExp mexp;
    Compilation comp;
    boolean inAttribute;
    Object attributeType;
    StringBuffer attributeValue;
    boolean preserveSpace;
    XSLT interpreter;
    InPort in;
    LambdaExp templateLambda;
    static final String XSL_TRANSFORM_URI = "http://www.w3.org/1999/XSL/Transform";
    static final ClassType typeXSLT;
    static final ClassType typeTemplateTable;
    static final Method defineTemplateMethod;
    static final Method runStylesheetMethod;
    static final PrimProcedure defineTemplateProc;
    static final PrimProcedure runStylesheetProc;
    
    XslTranslator(final InPort inp, final SourceMessages messages, final XSLT interpreter) {
        super(inp, messages);
        this.nesting = new StringBuffer(100);
        this.attributeValue = new StringBuffer(100);
        this.interpreter = interpreter;
        this.in = inp;
    }
    
    void maybeSkipWhitespace() {
        if (this.preserveSpace) {
            return;
        }
        int size = this.comp.exprStack.size();
        while (--size >= 0) {
            final Object expr = this.comp.exprStack.elementAt(size);
            if (!(expr instanceof QuoteExp)) {
                break;
            }
            final Object value = ((QuoteExp)expr).getValue();
            final String str = (value == null) ? "" : value.toString();
            int j = str.length();
            while (--j >= 0) {
                final char ch = str.charAt(j);
                if (ch != ' ' && ch != '\t' && ch != '\r' && ch != '\n') {
                    return;
                }
            }
        }
        this.comp.exprStack.setSize(size + 1);
    }
    
    public String popMatchingAttribute(final String ns, final String name, final int start) {
        for (int size = this.comp.exprStack.size(), i = start; i < size; ++i) {
            final Object el = this.comp.exprStack.elementAt(start);
            if (!(el instanceof ApplyExp)) {
                return null;
            }
            final ApplyExp aexp = (ApplyExp)el;
            final Expression function = aexp.getFunction();
            if (aexp.getFunction() != MakeAttribute.makeAttributeExp) {
                return null;
            }
            final Expression[] args = aexp.getArgs();
            if (args.length != 2) {
                return null;
            }
            final Expression arg0 = args[0];
            if (!(arg0 instanceof QuoteExp)) {
                return null;
            }
            final Object tag = ((QuoteExp)arg0).getValue();
            if (!(tag instanceof Symbol)) {
                return null;
            }
            final Symbol stag = (Symbol)tag;
            if (stag.getLocalPart() == name && stag.getNamespaceURI() == ns) {
                this.comp.exprStack.removeElementAt(i);
                return (String)((QuoteExp)args[1]).getValue();
            }
        }
        return null;
    }
    
    Expression popTemplateBody(final int start) {
        int i = this.comp.exprStack.size() - start;
        final Expression[] args = new Expression[i];
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
        final Symbol qname = (Symbol)type;
        if (qname.getNamespaceURI() != "http://www.w3.org/1999/XSL/Transform") {
            return null;
        }
        return qname.getLocalName();
    }
    
    void append(final Expression expr) {
    }
    
    @Override
    public void startElement(Object type) {
        this.maybeSkipWhitespace();
        final String xslTag = isXslTag(type);
        if (xslTag == "template") {
            if (this.templateLambda != null) {
                this.error("nested xsl:template");
            }
            this.templateLambda = new LambdaExp();
        }
        else if (xslTag == "text") {
            this.preserveSpace = false;
        }
        if (type instanceof XName) {
            final XName xn = (XName)type;
            type = Symbol.make(xn.getNamespaceURI(), xn.getLocalPart(), xn.getPrefix());
        }
        this.nesting.append((char)this.comp.exprStack.size());
        this.push(type);
    }
    
    @Override
    public void startAttribute(final Object attrType) {
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
        final Expression[] args = { new QuoteExp(this.attributeType), new QuoteExp((Object)this.attributeValue.toString()) };
        this.push(new ApplyExp(MakeAttribute.makeAttributeExp, args));
        this.nesting.setLength(this.nesting.length() - 1);
        this.inAttribute = false;
    }
    
    @Override
    public void endElement() {
        this.maybeSkipWhitespace();
        final int nlen = this.nesting.length() - 1;
        final int start = this.nesting.charAt(nlen);
        this.nesting.setLength(nlen);
        final Expression startTag = this.comp.exprStack.elementAt(start);
        final String xslTag = isXslTag(startTag);
        if (xslTag == "value-of") {
            final String select = this.popMatchingAttribute("", "select", start + 1);
            if (select != null) {
                Expression exp = this.parseXPath(select);
                exp = new ApplyExp(XQParser.makeText, new Expression[] { exp });
                this.comp.exprStack.pop();
                this.push(exp);
            }
        }
        else if (xslTag == "copy-of") {
            final String select = this.popMatchingAttribute("", "select", start + 1);
            if (select != null) {
                final Expression exp = this.parseXPath(select);
                this.comp.exprStack.pop();
                this.push(exp);
            }
        }
        else if (xslTag == "apply-templates") {
            final String select = this.popMatchingAttribute("", "select", start + 1);
            final String mode = this.popMatchingAttribute("", "mode", start + 1);
            final Expression[] args = { new QuoteExp((Object)select), this.resolveQNameExpression(mode) };
            this.comp.exprStack.pop();
            this.push(new ApplyExp(ApplyTemplates.applyTemplatesProc, args));
        }
        else if (xslTag == "if") {
            final String select = this.popMatchingAttribute("", "test", start + 1);
            Expression test = this.parseXPath(select);
            test = XQParser.booleanValue(test);
            final Expression clause = this.popTemplateBody(start + 1);
            this.comp.exprStack.pop();
            this.push(new IfExp(test, clause, QuoteExp.voidExp));
        }
        else if (xslTag == "stylesheet" || xslTag == "transform") {
            final String version = this.popMatchingAttribute("", "version", start + 1);
            this.push(new ApplyExp(new QuoteExp(XslTranslator.runStylesheetProc), Expression.noExpressions));
            final Expression body = this.popTemplateBody(start + 1);
            this.push(body);
            this.mexp.body = body;
        }
        else if (xslTag == "template") {
            final String match = this.popMatchingAttribute("", "match", start + 1);
            final String name = this.popMatchingAttribute("", "name", start + 1);
            final String priority = this.popMatchingAttribute("", "priority", start + 1);
            final String mode2 = this.popMatchingAttribute("", "mode", start + 1);
            this.templateLambda.body = this.popTemplateBody(start + 1);
            this.comp.exprStack.pop();
            final Expression[] args2 = new Expression[5];
            final double prio = 0.0;
            args2[0] = this.resolveQNameExpression(name);
            args2[1] = new QuoteExp((Object)match);
            args2[2] = new QuoteExp(DFloNum.valueOf(prio));
            args2[3] = this.resolveQNameExpression(mode2);
            args2[4] = this.templateLambda;
            this.push(new ApplyExp(new QuoteExp(XslTranslator.defineTemplateProc), args2));
            this.templateLambda = null;
        }
        else if (xslTag == "text") {
            this.preserveSpace = false;
            final Expression[] args3 = new Expression[this.comp.exprStack.size() - start - 1];
            int i = args3.length;
            while (--i >= 0) {
                args3[i] = this.comp.exprStack.pop();
            }
            this.comp.exprStack.pop();
            final Expression exp = new ApplyExp(XQParser.makeText, args3);
            this.push(exp);
            this.mexp.body = exp;
        }
        else {
            final Expression[] args3 = new Expression[this.comp.exprStack.size() - start];
            int i = args3.length;
            while (--i >= 0) {
                args3[i] = this.comp.exprStack.pop();
            }
            final MakeElement mkElement = new MakeElement();
            final Expression exp2 = new ApplyExp(new QuoteExp(mkElement), args3);
            this.push(exp2);
            this.mexp.body = exp2;
        }
    }
    
    Expression parseXPath(final String string) {
        final SourceMessages messages = this.comp.getMessages();
        try {
            final XQParser parser = new XQParser(new CharArrayInPort(string), messages, this.interpreter);
            final Vector exps = new Vector(20);
            while (true) {
                final Expression sexp = parser.parse(this.comp);
                if (sexp == null) {
                    break;
                }
                exps.addElement(sexp);
            }
            final int nexps = exps.size();
            if (nexps == 0) {
                return QuoteExp.voidExp;
            }
            if (nexps == 1) {
                return exps.elementAt(0);
            }
            throw new InternalError("too many xpath expressions");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new InternalError("caught " + ex);
        }
    }
    
    @Override
    public void write(final int v) {
        if (this.inAttribute) {
            this.attributeValue.appendCodePoint(v);
        }
        else {
            String str;
            if (v < 65536) {
                str = String.valueOf(v);
            }
            else {
                final char[] c2 = { (char)((v - 65536 >> 10) + 55296), (char)((v & 0x3FF) + 56320) };
                str = new String(c2);
            }
            this.push(str);
        }
    }
    
    @Override
    public Consumer append(final char v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        }
        else {
            this.push(String.valueOf(v));
        }
        return this;
    }
    
    @Override
    public Consumer append(final CharSequence csq) {
        if (this.inAttribute) {
            this.attributeValue.append(csq);
        }
        else {
            this.push(csq.toString());
        }
        return this;
    }
    
    @Override
    public Consumer append(final CharSequence csq, final int start, final int end) {
        return this.append(csq.subSequence(start, end));
    }
    
    void push(final Expression exp) {
        this.comp.exprStack.push(exp);
    }
    
    void push(final Object value) {
        this.push(new QuoteExp(value));
    }
    
    @Override
    public void writeBoolean(final boolean v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        }
        else {
            this.push(v ? QuoteExp.trueExp : QuoteExp.falseExp);
        }
    }
    
    @Override
    public void writeFloat(final float v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        }
        else {
            this.push(DFloNum.valueOf(v));
        }
    }
    
    @Override
    public void writeDouble(final double v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        }
        else {
            this.push(DFloNum.valueOf(v));
        }
    }
    
    @Override
    public void writeInt(final int v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        }
        else {
            this.push(IntNum.valueOf(v));
        }
    }
    
    @Override
    public void writeLong(final long v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        }
        else {
            this.push(IntNum.valueOf(v));
        }
    }
    
    @Override
    public void startDocument() {
    }
    
    public void startDocument(final ModuleExp mexp) {
        this.mexp = mexp;
        this.startDocument();
    }
    
    @Override
    public void endDocument() {
    }
    
    @Override
    public void writeObject(final Object v) {
        if (this.inAttribute) {
            this.attributeValue.append(v);
        }
        else {
            this.push(v);
        }
    }
    
    @Override
    public void write(final char[] buf, final int off, final int len) {
        if (this.inAttribute) {
            this.attributeValue.append(buf, off, len);
        }
        else {
            this.push(new String(buf, off, len));
        }
    }
    
    @Override
    public void write(final String str) {
        if (this.inAttribute) {
            this.attributeValue.append(str);
        }
        else {
            this.push(str);
        }
    }
    
    @Override
    public void write(final CharSequence str, final int start, final int length) {
        this.write(str.subSequence(start, length).toString());
    }
    
    @Override
    public boolean ignoring() {
        return false;
    }
    
    public Expression getExpression() {
        return this.comp.exprStack.pop();
    }
    
    @Override
    public void error(final char kind, final String message) {
        this.getMessages().error(kind, message);
    }
    
    Expression resolveQNameExpression(final String name) {
        if (name == null) {
            return QuoteExp.nullExp;
        }
        return new QuoteExp(Symbol.make(null, name));
    }
    
    public void parse(final Compilation comp) throws IOException {
        this.comp = comp;
        if (comp.exprStack == null) {
            comp.exprStack = new Stack<Expression>();
        }
        final ModuleExp mexp = comp.getModule();
        comp.mustCompileHere();
        this.startDocument(mexp);
        XMLParser.parse(this.in, this.getMessages(), this);
        this.endDocument();
        comp.pop(mexp);
    }
    
    static {
        typeXSLT = ClassType.make("gnu.kawa.xslt.XSLT");
        typeTemplateTable = ClassType.make("gnu.kawa.xslt.TemplateTable");
        defineTemplateMethod = XslTranslator.typeXSLT.getDeclaredMethod("defineTemplate", 5);
        runStylesheetMethod = XslTranslator.typeXSLT.getDeclaredMethod("runStylesheet", 0);
        defineTemplateProc = new PrimProcedure(XslTranslator.defineTemplateMethod);
        runStylesheetProc = new PrimProcedure(XslTranslator.runStylesheetMethod);
    }
}
