/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class StandardColor
extends Color {
    String name;
    static Map<String, StandardColor> map = new HashMap<String, StandardColor>();
    public static final StandardColor aliceBlue = StandardColor.add("alice-blue", 15792383);
    public static final StandardColor antiqueWhite = StandardColor.add("antique-white", 16444375);
    public static final StandardColor aqua = StandardColor.add("aqua", 65535);
    public static final StandardColor aquamarine = StandardColor.add("aquamarine", 8388564);
    public static final StandardColor azure = StandardColor.add("azure", 15794175);
    public static final StandardColor beige = StandardColor.add("beige", 16119260);
    public static final StandardColor bisque = StandardColor.add("bisque", 16770244);
    public static final StandardColor black = StandardColor.add("black", 0);
    public static final StandardColor blanchedAlmond = StandardColor.add("blanched-almond", 16772045);
    public static final StandardColor blue = StandardColor.add("blue", 255);
    public static final StandardColor blueViolet = StandardColor.add("blue-violet", 9055202);
    public static final StandardColor brown = StandardColor.add("brown", 10824234);
    public static final StandardColor burlyWood = StandardColor.add("burly-wood", 14596231);
    public static final StandardColor cadetBlue = StandardColor.add("cadet-blue", 6266528);
    public static final StandardColor chartreuse = StandardColor.add("chartreuse", 8388352);
    public static final StandardColor chocolate = StandardColor.add("chocolate", 13789470);
    public static final StandardColor coral = StandardColor.add("coral", 16744272);
    public static final StandardColor cornflowerBlue = StandardColor.add("cornflower-blue", 6591981);
    public static final StandardColor cornsilk = StandardColor.add("cornsilk", 16775388);
    public static final StandardColor crimson = StandardColor.add("crimson", 14423100);
    public static final StandardColor cyan = StandardColor.add("cyan", 65535);
    public static final StandardColor darkBlue = StandardColor.add("dark-blue", 139);
    public static final StandardColor darkCyan = StandardColor.add("dark-cyan", 35723);
    public static final StandardColor darkGoldenrod = StandardColor.add("dark-goldenrod", 12092939);
    public static final StandardColor darkGray = StandardColor.add("dark-gray", 11119017);
    public static final StandardColor darkGreen = StandardColor.add("dark-green", 25600);
    public static final StandardColor darkGrey = StandardColor.add("dark-grey", 11119017);
    public static final StandardColor darkKhaki = StandardColor.add("dark-khaki", 12433259);
    public static final StandardColor darkMagenta = StandardColor.add("dark-magenta", 9109643);
    public static final StandardColor darkOliveGreen = StandardColor.add("dark-olive-green", 5597999);
    public static final StandardColor darkorange = StandardColor.add("darkorange", 16747520);
    public static final StandardColor darkOrchid = StandardColor.add("dark-orchid", 10040012);
    public static final StandardColor darkRed = StandardColor.add("dark-red", 9109504);
    public static final StandardColor darkSalmon = StandardColor.add("dark-salmon", 15308410);
    public static final StandardColor darkSeaGreen = StandardColor.add("dark-sea-green", 9419919);
    public static final StandardColor darkSlateBlue = StandardColor.add("dark-slate-blue", 4734347);
    public static final StandardColor darkSlateGray = StandardColor.add("dark-slate-gray", 3100495);
    public static final StandardColor darkSlateGrey = StandardColor.add("dark-slate-grey", 3100495);
    public static final StandardColor darkTurquoise = StandardColor.add("dark-turquoise", 52945);
    public static final StandardColor darkViolet = StandardColor.add("dark-violet", 9699539);
    public static final StandardColor deepPink = StandardColor.add("deep-pink", 16716947);
    public static final StandardColor deepSkyBlue = StandardColor.add("deep-sky-blue", 49151);
    public static final StandardColor dimGray = StandardColor.add("dim-gray", 6908265);
    public static final StandardColor dimGrey = StandardColor.add("dim-grey", 6908265);
    public static final StandardColor dodgerBlue = StandardColor.add("dodger-blue", 2003199);
    public static final StandardColor fireBrick = StandardColor.add("fire-brick", 11674146);
    public static final StandardColor floralWhite = StandardColor.add("floral-white", 16775920);
    public static final StandardColor forestGreen = StandardColor.add("forest-green", 2263842);
    public static final StandardColor fuchsia = StandardColor.add("fuchsia", 16711935);
    public static final StandardColor gainsboro = StandardColor.add("gainsboro", 14474460);
    public static final StandardColor ghostWhite = StandardColor.add("ghost-white", 16316671);
    public static final StandardColor gold = StandardColor.add("gold", 16766720);
    public static final StandardColor goldenrod = StandardColor.add("goldenrod", 14329120);
    public static final StandardColor gray = StandardColor.add("gray", 8421504);
    public static final StandardColor green = StandardColor.add("green", 32768);
    public static final StandardColor greenYellow = StandardColor.add("green-yellow", 11403055);
    public static final StandardColor grey = StandardColor.add("grey", 8421504);
    public static final StandardColor honeyDew = StandardColor.add("honey-dew", 15794160);
    public static final StandardColor hotPink = StandardColor.add("hot-pink", 16738740);
    public static final StandardColor indianRed = StandardColor.add("indian-red", 13458524);
    public static final StandardColor indigo = StandardColor.add("indigo", 4915330);
    public static final StandardColor ivory = StandardColor.add("ivory", 16777200);
    public static final StandardColor khaki = StandardColor.add("khaki", 15787660);
    public static final StandardColor lavender = StandardColor.add("lavender", 15132410);
    public static final StandardColor lavenderBlush = StandardColor.add("lavender-blush", 16773365);
    public static final StandardColor lawnGreen = StandardColor.add("lawn-green", 8190976);
    public static final StandardColor lemonChiffon = StandardColor.add("lemon-chiffon", 16775885);
    public static final StandardColor lightBlue = StandardColor.add("light-blue", 11393254);
    public static final StandardColor lightCoral = StandardColor.add("light-coral", 15761536);
    public static final StandardColor lightCyan = StandardColor.add("light-cyan", 14745599);
    public static final StandardColor lightGoldenrodYellow = StandardColor.add("light-goldenrod-yellow", 16448210);
    public static final StandardColor lightGray = StandardColor.add("light-gray", 13882323);
    public static final StandardColor lightGreen = StandardColor.add("light-green", 9498256);
    public static final StandardColor lightGrey = StandardColor.add("light-grey", 13882323);
    public static final StandardColor lightPink = StandardColor.add("light-pink", 16758465);
    public static final StandardColor lightSalmon = StandardColor.add("light-salmon", 16752762);
    public static final StandardColor lightSeaGreen = StandardColor.add("light-sea-green", 2142890);
    public static final StandardColor lightSkyBlue = StandardColor.add("light-sky-blue", 8900346);
    public static final StandardColor lightSlateGray = StandardColor.add("light-slate-gray", 7833753);
    public static final StandardColor lightSlateGrey = StandardColor.add("light-slate-grey", 7833753);
    public static final StandardColor lightSteelBlue = StandardColor.add("light-steel-blue", 11584734);
    public static final StandardColor lightYellow = StandardColor.add("light-yellow", 16777184);
    public static final StandardColor lime = StandardColor.add("lime", 65280);
    public static final StandardColor limeGreen = StandardColor.add("lime-green", 3329330);
    public static final StandardColor linen = StandardColor.add("linen", 16445670);
    public static final StandardColor magenta = StandardColor.add("magenta", 16711935);
    public static final StandardColor maroon = StandardColor.add("maroon", 8388608);
    public static final StandardColor mediumAquaMarine = StandardColor.add("medium-aqua-marine", 6737322);
    public static final StandardColor mediumBlue = StandardColor.add("medium-blue", 205);
    public static final StandardColor mediumOrchid = StandardColor.add("medium-orchid", 12211667);
    public static final StandardColor mediumPurple = StandardColor.add("medium-purple", 9662683);
    public static final StandardColor mediumSeaGreen = StandardColor.add("medium-sea-green", 3978097);
    public static final StandardColor mediumSlateBlue = StandardColor.add("medium-slate-blue", 8087790);
    public static final StandardColor mediumSpringGreen = StandardColor.add("medium-spring-green", 64154);
    public static final StandardColor mediumTurquoise = StandardColor.add("medium-turquoise", 4772300);
    public static final StandardColor mediumVioletRed = StandardColor.add("medium-violet-red", 13047173);
    public static final StandardColor midnightBlue = StandardColor.add("midnight-blue", 1644912);
    public static final StandardColor mintCream = StandardColor.add("mint-cream", 16121850);
    public static final StandardColor mistyRose = StandardColor.add("misty-rose", 16770273);
    public static final StandardColor moccasin = StandardColor.add("moccasin", 16770229);
    public static final StandardColor navajoWhite = StandardColor.add("navajo-white", 16768685);
    public static final StandardColor navy = StandardColor.add("navy", 128);
    public static final StandardColor oldLace = StandardColor.add("old-lace", 16643558);
    public static final StandardColor olive = StandardColor.add("olive", 8421376);
    public static final StandardColor oliveDrab = StandardColor.add("olive-drab", 7048739);
    public static final StandardColor orange = StandardColor.add("orange", 16753920);
    public static final StandardColor orangeRed = StandardColor.add("orange-red", 16729344);
    public static final StandardColor orchid = StandardColor.add("orchid", 14315734);
    public static final StandardColor paleGoldenrod = StandardColor.add("pale-goldenrod", 15657130);
    public static final StandardColor paleGreen = StandardColor.add("pale-green", 10025880);
    public static final StandardColor paleTurquoise = StandardColor.add("pale-turquoise", 11529966);
    public static final StandardColor paleVioletRed = StandardColor.add("pale-violet-red", 14381203);
    public static final StandardColor papayaWhip = StandardColor.add("papaya-whip", 16773077);
    public static final StandardColor peachPuff = StandardColor.add("peach-puff", 16767673);
    public static final StandardColor peru = StandardColor.add("peru", 13468991);
    public static final StandardColor pink = StandardColor.add("pink", 16761035);
    public static final StandardColor plum = StandardColor.add("plum", 14524637);
    public static final StandardColor powderBlue = StandardColor.add("powder-blue", 11591910);
    public static final StandardColor purple = StandardColor.add("purple", 8388736);
    public static final StandardColor red = StandardColor.add("red", 16711680);
    public static final StandardColor rosyBrown = StandardColor.add("rosy-brown", 12357519);
    public static final StandardColor royalBlue = StandardColor.add("royal-blue", 4286945);
    public static final StandardColor saddleBrown = StandardColor.add("saddle-brown", 9127187);
    public static final StandardColor salmon = StandardColor.add("salmon", 16416882);
    public static final StandardColor sandyBrown = StandardColor.add("sandy-brown", 16032864);
    public static final StandardColor seaGreen = StandardColor.add("sea-green", 3050327);
    public static final StandardColor seaShell = StandardColor.add("sea-shell", 16774638);
    public static final StandardColor sienna = StandardColor.add("sienna", 10506797);
    public static final StandardColor silver = StandardColor.add("silver", 12632256);
    public static final StandardColor skyBlue = StandardColor.add("sky-blue", 8900331);
    public static final StandardColor slateBlue = StandardColor.add("slate-blue", 6970061);
    public static final StandardColor slateGray = StandardColor.add("slate-gray", 7372944);
    public static final StandardColor slateGrey = StandardColor.add("slate-grey", 7372944);
    public static final StandardColor snow = StandardColor.add("snow", 16775930);
    public static final StandardColor springGreen = StandardColor.add("spring-green", 65407);
    public static final StandardColor steelBlue = StandardColor.add("steel-blue", 4620980);
    public static final StandardColor tan = StandardColor.add("tan", 13808780);
    public static final StandardColor teal = StandardColor.add("teal", 32896);
    public static final StandardColor thistle = StandardColor.add("thistle", 14204888);
    public static final StandardColor tomato = StandardColor.add("tomato", 16737095);
    public static final StandardColor turquoise = StandardColor.add("turquoise", 4251856);
    public static final StandardColor violet = StandardColor.add("violet", 15631086);
    public static final StandardColor wheat = StandardColor.add("wheat", 16113331);
    public static final StandardColor white = StandardColor.add("white", 16777215);
    public static final StandardColor whiteSmoke = StandardColor.add("white-smoke", 16119285);
    public static final StandardColor yellow = StandardColor.add("yellow", 16776960);
    public static final StandardColor yellowGreen = StandardColor.add("yellow-green", 10145074);
    public static final StandardColor transparent = StandardColor.add(new StandardColor("transparent", 0, 0, 0, 0));

    private StandardColor(String name, int rgb) {
        super(rgb);
        this.name = name;
    }

    private StandardColor(String name, int r, int g, int b, int alpha) {
        super(r, g, b, alpha);
        this.name = name;
    }

    private static StandardColor add(String name, int rgb) {
        StandardColor color = new StandardColor(name, rgb);
        map.put(name.replace("-", ""), color);
        return color;
    }

    private static StandardColor add(StandardColor color) {
        map.put(color.name.replace("-", ""), color);
        return color;
    }

    public String getName() {
        return this.name;
    }

    public static StandardColor valueOf(String name) {
        String cname = name.toLowerCase().replace("-", "");
        return map.get(cname);
    }

    @Override
    public String toString() {
        return "StandardColor[r=" + this.getRed() + ",g=" + this.getGreen() + ",b=" + this.getBlue() + ";" + this.name + "]";
    }
}

