// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xslt;

import gnu.kawa.xml.KDocument;
import gnu.kawa.xml.Document;
import gnu.expr.ApplicationMainSupport;
import gnu.lists.Consumer;
import gnu.lists.AbstractSequence;
import gnu.mapping.CallContext;
import gnu.kawa.xml.Focus;
import gnu.lists.TreeList;
import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.xquery.lang.XQResolveNames;
import gnu.xquery.lang.XQParser;
import gnu.expr.Compilation;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.kawa.io.InPort;
import gnu.expr.ModuleBody;
import gnu.mapping.Symbol;
import gnu.xquery.lang.XQuery;

public class XSLT extends XQuery
{
    public static XSLT instance;
    public static Symbol nullMode;
    
    @Override
    public String getName() {
        return "XSLT";
    }
    
    public XSLT() {
        XSLT.instance = this;
        ModuleBody.setMainPrintValues(true);
    }
    
    public static XSLT getXsltInstance() {
        if (XSLT.instance == null) {
            new XSLT();
        }
        return XSLT.instance;
    }
    
    @Override
    public Lexer getLexer(final InPort inp, final SourceMessages messages) {
        return new XslTranslator(inp, messages, this);
    }
    
    @Override
    public boolean parse(final Compilation comp, final int options) throws IOException, SyntaxException {
        Compilation.defaultCallConvention = 2;
        ((XslTranslator)comp.lexer).parse(comp);
        comp.setState(4);
        final XQParser xqparser = new XQParser(null, comp.getMessages(), this);
        if (comp.mainLambda.body == null) {
            return false;
        }
        final XQResolveNames resolver = new XQResolveNames(comp);
        resolver.functionNamespacePath = xqparser.functionNamespacePath;
        resolver.parser = xqparser;
        resolver.resolveModule(comp.mainLambda);
        return true;
    }
    
    public static void registerEnvironment() {
        Language.setDefaults(new XSLT());
    }
    
    public static void defineCallTemplate(final Symbol name, final double priority, final Procedure template) {
    }
    
    public static void defineApplyTemplate(final String pattern, final double priority, Symbol mode, final Procedure template) {
        if (mode == null) {
            mode = XSLT.nullMode;
        }
        final TemplateTable table = TemplateTable.getTemplateTable(mode);
        table.enter(pattern, priority, template);
    }
    
    public static void defineTemplate(final Symbol name, final String pattern, final double priority, final Symbol mode, final Procedure template) {
        if (name != null) {
            defineCallTemplate(name, priority, template);
        }
        if (pattern != null) {
            defineApplyTemplate(pattern, priority, mode, template);
        }
    }
    
    public static void process(final TreeList doc, final Focus pos, final CallContext ctx) throws Throwable {
        final Consumer out = ctx.consumer;
        while (true) {
            int ipos = pos.ipos;
            final int kind = doc.getNextKind(ipos);
            switch (kind) {
                case 34: {
                    ipos = doc.firstChildPos(ipos);
                    break;
                }
                case 33: {
                    final Object type = pos.getNextTypeObject();
                    final String name = pos.getNextTypeName();
                    final Procedure proc = TemplateTable.nullModeTable.find(name);
                    if (proc != null) {
                        proc.check0(ctx);
                        ctx.runUntilDone();
                    }
                    else {
                        out.startElement(type);
                        int child = doc.firstAttributePos(ipos);
                        if (child == 0) {
                            child = doc.firstChildPos(ipos);
                        }
                        pos.push(doc, child);
                        process(doc, pos, ctx);
                        pos.pop();
                        out.endElement();
                    }
                    ipos = doc.nextDataIndex(ipos >>> 1) << 1;
                    pos.gotoNext();
                    break;
                }
                case 35: {
                    final Object type = pos.getNextTypeObject();
                    final String name = pos.getNextTypeName();
                    final Procedure proc = TemplateTable.nullModeTable.find("@" + name);
                    if (proc != null) {
                        proc.check0(ctx);
                        ctx.runUntilDone();
                        break;
                    }
                }
                case 29: {
                    final int ichild = ipos >>> 1;
                    int next = doc.nextNodeIndex(ichild, Integer.MAX_VALUE);
                    if (ichild == next) {
                        next = doc.nextDataIndex(ichild);
                    }
                    doc.consumeIRange(ichild, next, out);
                    ipos = next << 1;
                    break;
                }
                case 36:
                case 37: {
                    ipos = doc.nextDataIndex(ipos >>> 1) << 1;
                    break;
                }
                default: {
                    return;
                }
            }
            pos.ipos = ipos;
        }
    }
    
    public static void runStylesheet() throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        ApplicationMainSupport.processSetProperties();
        final String[] args = ApplicationMainSupport.commandLineArgArray;
        for (int i = 0; i < args.length; ++i) {
            final String arg = args[i];
            final KDocument doc = Document.parse(arg);
            final Focus pos = Focus.getCurrent();
            pos.push(doc.sequence, doc.ipos);
            process((TreeList)doc.sequence, pos, ctx);
        }
    }
    
    static {
        XSLT.nullMode = Symbol.make(null, "");
    }
}
