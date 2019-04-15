/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;

public class keywords
extends ModuleBody {
    public static final ModuleMethod keyword$Qu;
    public static final ModuleMethod keyword$Mn$Grstring;
    public static final ModuleMethod string$Mn$Grkeyword;
    public static keywords $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean isKeyword(Object object2) {
        return Keyword.isKeyword(object2);
    }

    public static CharSequence keyword$To$String(Keyword keyword) {
        return keyword.getName();
    }

    public static Keyword string$To$Keyword(String string) {
        return Keyword.make(string);
    }

    public static {
        Lit2 = Symbol.valueOf("string->keyword");
        Lit1 = Symbol.valueOf("keyword->string");
        Lit0 = Symbol.valueOf("keyword?");
        keywords keywords2 = $instance = new keywords();
        keyword$Qu = new ModuleMethod(keywords2, 1, Lit0, 4097);
        keyword$Mn$Grstring = new ModuleMethod(keywords2, 2, Lit1, 4097);
        string$Mn$Grkeyword = new ModuleMethod(keywords2, 3, Lit2, 4097);
        keywords.$runBody$();
    }

    public keywords() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3: {
                callContext.value1 = Promise.force(object2, String.class);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                Object object3 = Promise.force(object2, Keyword.class);
                if (!(object3 instanceof Keyword)) {
                    return -786431;
                }
                callContext.value1 = object3;
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
                Boolean bl;
                if (keywords.isKeyword(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                return keywords.keyword$To$String((Keyword)Promise.force(object2, Keyword.class));
            }
            case 3: {
                String string;
                Object object3 = Promise.force(object2, String.class);
                if (object3 == null) {
                    string = null;
                    return keywords.string$To$Keyword(string);
                }
                string = object3.toString();
                return keywords.string$To$Keyword(string);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "keyword->string", 1, object2);
        }
    }
}

