// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class cxr extends ModuleBody
{
    public static final StaticFieldLocation caaar;
    public static final StaticFieldLocation caadr;
    public static final StaticFieldLocation cadar;
    public static final StaticFieldLocation caddr;
    public static final StaticFieldLocation cdaar;
    public static final StaticFieldLocation cdadr;
    public static final StaticFieldLocation cddar;
    public static final StaticFieldLocation cdddr;
    public static final StaticFieldLocation caaaar;
    public static final StaticFieldLocation caaadr;
    public static final StaticFieldLocation caadar;
    public static final StaticFieldLocation caaddr;
    public static final StaticFieldLocation cadaar;
    public static final StaticFieldLocation cadadr;
    public static final StaticFieldLocation caddar;
    public static final StaticFieldLocation cadddr;
    public static final StaticFieldLocation cdaaar;
    public static final StaticFieldLocation cdaadr;
    public static final StaticFieldLocation cdadar;
    public static final StaticFieldLocation cdaddr;
    public static final StaticFieldLocation cddaar;
    public static final StaticFieldLocation cddadr;
    public static final StaticFieldLocation cdddar;
    public static final StaticFieldLocation cddddr;
    public static cxr $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        cxr.$instance = new cxr();
        caaar = StaticFieldLocation.make("kawa.lib.lists", "caaar");
        caadr = StaticFieldLocation.make("kawa.lib.lists", "caadr");
        cadar = StaticFieldLocation.make("kawa.lib.lists", "cadar");
        caddr = StaticFieldLocation.make("kawa.lib.lists", "caddr");
        cdaar = StaticFieldLocation.make("kawa.lib.lists", "cdaar");
        cdadr = StaticFieldLocation.make("kawa.lib.lists", "cdadr");
        cddar = StaticFieldLocation.make("kawa.lib.lists", "cddar");
        cdddr = StaticFieldLocation.make("kawa.lib.lists", "cdddr");
        caaaar = StaticFieldLocation.make("kawa.lib.lists", "caaaar");
        caaadr = StaticFieldLocation.make("kawa.lib.lists", "caaadr");
        caadar = StaticFieldLocation.make("kawa.lib.lists", "caadar");
        caaddr = StaticFieldLocation.make("kawa.lib.lists", "caaddr");
        cadaar = StaticFieldLocation.make("kawa.lib.lists", "cadaar");
        cadadr = StaticFieldLocation.make("kawa.lib.lists", "cadadr");
        caddar = StaticFieldLocation.make("kawa.lib.lists", "caddar");
        cadddr = StaticFieldLocation.make("kawa.lib.lists", "cadddr");
        cdaaar = StaticFieldLocation.make("kawa.lib.lists", "cdaaar");
        cdaadr = StaticFieldLocation.make("kawa.lib.lists", "cdaadr");
        cdadar = StaticFieldLocation.make("kawa.lib.lists", "cdadar");
        cdaddr = StaticFieldLocation.make("kawa.lib.lists", "cdaddr");
        cddaar = StaticFieldLocation.make("kawa.lib.lists", "cddaar");
        cddadr = StaticFieldLocation.make("kawa.lib.lists", "cddadr");
        cdddar = StaticFieldLocation.make("kawa.lib.lists", "cdddar");
        cddddr = StaticFieldLocation.make("kawa.lib.lists", "cddddr");
        $runBody$();
    }
    
    public cxr() {
        ModuleInfo.register(this);
    }
}
