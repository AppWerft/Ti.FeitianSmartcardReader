/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class char
extends ModuleBody {
    public static final StaticFieldLocation digit$Mnvalue;
    public static final StaticFieldLocation char$Mnci$Eq$Qu;
    public static final StaticFieldLocation char$Mnci$Ls$Qu;
    public static final StaticFieldLocation char$Mnci$Gr$Qu;
    public static final StaticFieldLocation char$Mnci$Ls$Eq$Qu;
    public static final StaticFieldLocation char$Mnci$Gr$Eq$Qu;
    public static final StaticFieldLocation string$Mnci$Eq$Qu;
    public static final StaticFieldLocation string$Mnci$Ls$Qu;
    public static final StaticFieldLocation string$Mnci$Gr$Qu;
    public static final StaticFieldLocation string$Mnci$Ls$Eq$Qu;
    public static final StaticFieldLocation string$Mnci$Gr$Eq$Qu;
    public static final StaticFieldLocation char$Mnupcase;
    public static final StaticFieldLocation char$Mndowncase;
    public static final StaticFieldLocation char$Mnfoldcase;
    public static final StaticFieldLocation char$Mnalphabetic$Qu;
    public static final StaticFieldLocation char$Mnnumeric$Qu;
    public static final StaticFieldLocation char$Mnwhitespace$Qu;
    public static final StaticFieldLocation char$Mnupper$Mncase$Qu;
    public static final StaticFieldLocation char$Mnlower$Mncase$Qu;
    public static final StaticFieldLocation string$Mnupcase;
    public static final StaticFieldLocation string$Mndowncase;
    public static final StaticFieldLocation string$Mnfoldcase;
    public static char $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new char();
        digit$Mnvalue = StaticFieldLocation.make("kawa.lib.characters", "digit$Mnvalue");
        char$Mnci$Eq$Qu = StaticFieldLocation.make("kawa.lib.strings", "char$Mnci$Eq$Qu");
        char$Mnci$Ls$Qu = StaticFieldLocation.make("kawa.lib.strings", "char$Mnci$Ls$Qu");
        char$Mnci$Gr$Qu = StaticFieldLocation.make("kawa.lib.strings", "char$Mnci$Gr$Qu");
        char$Mnci$Ls$Eq$Qu = StaticFieldLocation.make("kawa.lib.strings", "char$Mnci$Ls$Eq$Qu");
        char$Mnci$Gr$Eq$Qu = StaticFieldLocation.make("kawa.lib.strings", "char$Mnci$Gr$Eq$Qu");
        string$Mnci$Eq$Qu = StaticFieldLocation.make("kawa.lib.strings", "string$Mnci$Eq$Qu");
        string$Mnci$Ls$Qu = StaticFieldLocation.make("kawa.lib.strings", "string$Mnci$Ls$Qu");
        string$Mnci$Gr$Qu = StaticFieldLocation.make("kawa.lib.strings", "string$Mnci$Gr$Qu");
        string$Mnci$Ls$Eq$Qu = StaticFieldLocation.make("kawa.lib.strings", "string$Mnci$Ls$Eq$Qu");
        string$Mnci$Gr$Eq$Qu = StaticFieldLocation.make("kawa.lib.strings", "string$Mnci$Gr$Eq$Qu");
        char$Mnupcase = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "char$Mnupcase");
        char$Mndowncase = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "char$Mndowncase");
        char$Mnfoldcase = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "char$Mnfoldcase");
        char$Mnalphabetic$Qu = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "char$Mnalphabetic$Qu");
        char$Mnnumeric$Qu = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "char$Mnnumeric$Qu");
        char$Mnwhitespace$Qu = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "char$Mnwhitespace$Qu");
        char$Mnupper$Mncase$Qu = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "char$Mnupper$Mncase$Qu");
        char$Mnlower$Mncase$Qu = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "char$Mnlower$Mncase$Qu");
        string$Mnupcase = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "string$Mnupcase");
        string$Mndowncase = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "string$Mndowncase");
        string$Mnfoldcase = StaticFieldLocation.make("kawa.lib.rnrs.unicode", "string$Mnfoldcase");
        char.$runBody$();
    }

    public char() {
        ModuleInfo.register(this);
    }
}

