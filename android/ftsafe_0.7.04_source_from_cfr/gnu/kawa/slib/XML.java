/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.xml.Document;
import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KComment;
import gnu.kawa.xml.KDocument;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KProcessingInstruction;
import gnu.kawa.xml.OutputAsXML;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;

public class XML
extends ModuleBody {
    public static OutputAsXML as$Mnxml;
    public static final Class comment;
    public static final Class processing$Mninstruction;
    public static final ModuleMethod parse$Mnxml$Mnfrom$Mnurl;
    public static final ModuleMethod element$Mnname;
    public static final ModuleMethod attribute$Mnname;
    public static XML $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        as$Mnxml = new OutputAsXML();
    }

    public static KDocument parseXmlFromUrl(Object url) {
        return Document.parse(url);
    }

    public static Symbol elementName(KElement element) {
        return element.getNodeSymbol();
    }

    public static Symbol attributeName(KAttr attr) {
        return attr.getNodeSymbol();
    }

    public static {
        Lit2 = Symbol.valueOf("attribute-name");
        Lit1 = Symbol.valueOf("element-name");
        Lit0 = Symbol.valueOf("parse-xml-from-url");
        processing$Mninstruction = KProcessingInstruction.class;
        comment = KComment.class;
        XML xML = $instance = new XML();
        parse$Mnxml$Mnfrom$Mnurl = new ModuleMethod(xML, 1, Lit0, 4097);
        element$Mnname = new ModuleMethod(xML, 2, Lit1, 4097);
        attribute$Mnname = new ModuleMethod(xML, 3, Lit2, 4097);
        XML.$runBody$();
    }

    public XML() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3: {
                Object object3 = Promise.force(object2, KAttr.class);
                if (!(object3 instanceof KAttr)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                Object object4 = Promise.force(object2, KElement.class);
                if (!(object4 instanceof KElement)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return XML.parseXmlFromUrl(object2);
            }
            case 2: {
                return XML.elementName((KElement)Promise.force(object2, KElement.class));
            }
            case 3: {
                return XML.attributeName((KAttr)Promise.force(object2, KAttr.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "element-name", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "attribute-name", 1, object2);
        }
    }
}

