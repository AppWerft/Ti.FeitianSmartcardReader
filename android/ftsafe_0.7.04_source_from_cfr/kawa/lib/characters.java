/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

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
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.SourceMethodType;

public class characters
extends ModuleBody {
    public static final ModuleMethod char$Qu;
    public static final ModuleMethod char$Mn$Grinteger;
    public static final ModuleMethod integer$Mn$Grchar;
    public static final ModuleMethod digit$Mnvalue;
    public static characters $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean isChar(Object x) {
        boolean x2 = x instanceof Char;
        return x2 ? x2 : x instanceof Character;
    }

    @SourceMethodType(value={"", "character"})
    public static int char$To$Integer(int ch) {
        return ch;
    }

    @SourceMethodType(value={"character"})
    public static int integer$To$Char(int n) {
        return n;
    }

    @SourceMethodType(value={"", "character"})
    public static Object digitValue(int ch) {
        int r = Character.digit(characters.char$To$Integer(ch), 10);
        return r < 0 ? Boolean.FALSE : IntNum.make(r);
    }

    public static {
        Lit3 = Symbol.valueOf("digit-value");
        Lit2 = Symbol.valueOf("integer->char");
        Lit1 = Symbol.valueOf("char->integer");
        Lit0 = Symbol.valueOf("char?");
        characters characters2 = $instance = new characters();
        char$Qu = new ModuleMethod(characters2, 1, Lit0, 4097);
        ModuleMethod moduleMethod = new ModuleMethod(characters2, 2, Lit1, 4097);
        moduleMethod.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:charToIntegerValidateApply");
        char$Mn$Grinteger = moduleMethod;
        ModuleMethod moduleMethod2 = new ModuleMethod(characters2, 3, Lit2, 4097);
        moduleMethod2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:integerToCharValidateApply");
        integer$Mn$Grchar = moduleMethod2;
        digit$Mnvalue = new ModuleMethod(characters2, 4, Lit3, 4097);
        characters.$runBody$();
    }

    public characters() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 4: {
                Object object3 = Promise.force(object2);
                if (Char.checkCharOrEof(object3) < 0) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                Object object4 = Promise.force(object2);
                if (Char.checkCharOrEof(object4) < 0) {
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
                Boolean bl;
                if (characters.isChar(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                return characters.char$To$Integer(Char.castToCharacter(Promise.force(object2)));
            }
            case 3: {
                return Char.make(characters.integer$To$Char(((Number)Promise.force(object2)).intValue()));
            }
            case 4: {
                return characters.digitValue(Char.castToCharacter(Promise.force(object2)));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char->integer", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "integer->char", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "digit-value", 1, object2);
        }
    }
}

