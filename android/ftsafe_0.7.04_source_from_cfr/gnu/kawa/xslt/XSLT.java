/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xslt;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.kawa.io.InPort;
import gnu.kawa.xml.Document;
import gnu.kawa.xml.Focus;
import gnu.kawa.xml.KDocument;
import gnu.kawa.xslt.TemplateTable;
import gnu.kawa.xslt.XslTranslator;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.CallContext;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xquery.lang.XQParser;
import gnu.xquery.lang.XQResolveNames;
import gnu.xquery.lang.XQuery;
import java.io.IOException;

public class XSLT
extends XQuery {
    public static XSLT instance;
    public static Symbol nullMode;

    @Override
    public String getName() {
        return "XSLT";
    }

    public XSLT() {
        instance = this;
        ModuleBody.setMainPrintValues(true);
    }

    public static XSLT getXsltInstance() {
        if (instance == null) {
            new XSLT();
        }
        return instance;
    }

    @Override
    public Lexer getLexer(InPort inp, SourceMessages messages) {
        return new XslTranslator(inp, messages, this);
    }

    @Override
    public boolean parse(Compilation comp, int options) throws IOException, SyntaxException {
        Compilation.defaultCallConvention = 2;
        ((XslTranslator)comp.lexer).parse(comp);
        comp.setState(4);
        XQParser xqparser = new XQParser(null, comp.getMessages(), this);
        if (comp.mainLambda.body == null) {
            return false;
        }
        XQResolveNames resolver = new XQResolveNames(comp);
        resolver.functionNamespacePath = xqparser.functionNamespacePath;
        resolver.parser = xqparser;
        resolver.resolveModule(comp.mainLambda);
        return true;
    }

    public static void registerEnvironment() {
        Language.setDefaults(new XSLT());
    }

    public static void defineCallTemplate(Symbol name, double priority, Procedure template) {
    }

    public static void defineApplyTemplate(String pattern, double priority, Symbol mode, Procedure template) {
        if (mode == null) {
            mode = nullMode;
        }
        TemplateTable table = TemplateTable.getTemplateTable(mode);
        table.enter(pattern, priority, template);
    }

    public static void defineTemplate(Symbol name, String pattern, double priority, Symbol mode, Procedure template) {
        if (name != null) {
            XSLT.defineCallTemplate(name, priority, template);
        }
        if (pattern != null) {
            XSLT.defineApplyTemplate(pattern, priority, mode, template);
        }
    }

    public static void process(TreeList doc, Focus pos, CallContext ctx) throws Throwable {
        Consumer out = ctx.consumer;
        do {
            int ipos = pos.ipos;
            int kind = doc.getNextKind(ipos);
            switch (kind) {
                Object type;
                String name;
                Procedure proc;
                case 34: {
                    ipos = doc.firstChildPos(ipos);
                    break;
                }
                case 33: {
                    type = pos.getNextTypeObject();
                    name = pos.getNextTypeName();
                    proc = TemplateTable.nullModeTable.find(name);
                    if (proc != null) {
                        proc.check0(ctx);
                        ctx.runUntilDone();
                    } else {
                        out.startElement(type);
                        int child = doc.firstAttributePos(ipos);
                        if (child == 0) {
                            child = doc.firstChildPos(ipos);
                        }
                        pos.push(doc, child);
                        XSLT.process(doc, pos, ctx);
                        pos.pop();
                        out.endElement();
                    }
                    ipos = doc.nextDataIndex(ipos >>> 1) << 1;
                    pos.gotoNext();
                    break;
                }
                case 35: {
                    type = pos.getNextTypeObject();
                    name = pos.getNextTypeName();
                    proc = TemplateTable.nullModeTable.find("@" + name);
                    if (proc != null) {
                        proc.check0(ctx);
                        ctx.runUntilDone();
                        break;
                    }
                }
                case 29: {
                    int ichild = ipos >>> 1;
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
        } while (true);
    }

    public static void runStylesheet() throws Throwable {
        CallContext ctx = CallContext.getInstance();
        ApplicationMainSupport.processSetProperties();
        String[] args = ApplicationMainSupport.commandLineArgArray;
        for (int i = 0; i < args.length; ++i) {
            String arg = args[i];
            KDocument doc = Document.parse(arg);
            Focus pos = Focus.getCurrent();
            pos.push(doc.sequence, doc.ipos);
            XSLT.process((TreeList)doc.sequence, pos, ctx);
        }
    }

    static {
        nullMode = Symbol.make(null, "");
    }
}

