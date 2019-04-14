package gnu.kawa.models;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;


public class StandardColor
  extends Color
{
  String name;
  static Map<String, StandardColor> map = new HashMap();
  
  private StandardColor(String name, int rgb)
  {
    super(rgb);
    this.name = name;
  }
  
  private StandardColor(String name, int r, int g, int b, int alpha) { super(r, g, b, alpha);
    this.name = name;
  }
  
  private static StandardColor add(String name, int rgb) { StandardColor color = new StandardColor(name, rgb);
    map.put(name.replace("-", ""), color);
    return color;
  }
  
  private static StandardColor add(StandardColor color) { map.put(name.replace("-", ""), color);
    return color; }
  
  public String getName() { return name; }
  
  public static final StandardColor aliceBlue = add("alice-blue", 15792383);
  public static final StandardColor antiqueWhite = add("antique-white", 16444375);
  public static final StandardColor aqua = add("aqua", 65535);
  public static final StandardColor aquamarine = add("aquamarine", 8388564);
  public static final StandardColor azure = add("azure", 15794175);
  public static final StandardColor beige = add("beige", 16119260);
  public static final StandardColor bisque = add("bisque", 16770244);
  public static final StandardColor black = add("black", 0);
  public static final StandardColor blanchedAlmond = add("blanched-almond", 16772045);
  public static final StandardColor blue = add("blue", 255);
  public static final StandardColor blueViolet = add("blue-violet", 9055202);
  public static final StandardColor brown = add("brown", 10824234);
  public static final StandardColor burlyWood = add("burly-wood", 14596231);
  public static final StandardColor cadetBlue = add("cadet-blue", 6266528);
  public static final StandardColor chartreuse = add("chartreuse", 8388352);
  public static final StandardColor chocolate = add("chocolate", 13789470);
  public static final StandardColor coral = add("coral", 16744272);
  public static final StandardColor cornflowerBlue = add("cornflower-blue", 6591981);
  public static final StandardColor cornsilk = add("cornsilk", 16775388);
  public static final StandardColor crimson = add("crimson", 14423100);
  public static final StandardColor cyan = add("cyan", 65535);
  public static final StandardColor darkBlue = add("dark-blue", 139);
  public static final StandardColor darkCyan = add("dark-cyan", 35723);
  public static final StandardColor darkGoldenrod = add("dark-goldenrod", 12092939);
  public static final StandardColor darkGray = add("dark-gray", 11119017);
  public static final StandardColor darkGreen = add("dark-green", 25600);
  public static final StandardColor darkGrey = add("dark-grey", 11119017);
  public static final StandardColor darkKhaki = add("dark-khaki", 12433259);
  public static final StandardColor darkMagenta = add("dark-magenta", 9109643);
  public static final StandardColor darkOliveGreen = add("dark-olive-green", 5597999);
  public static final StandardColor darkorange = add("darkorange", 16747520);
  public static final StandardColor darkOrchid = add("dark-orchid", 10040012);
  public static final StandardColor darkRed = add("dark-red", 9109504);
  public static final StandardColor darkSalmon = add("dark-salmon", 15308410);
  public static final StandardColor darkSeaGreen = add("dark-sea-green", 9419919);
  public static final StandardColor darkSlateBlue = add("dark-slate-blue", 4734347);
  public static final StandardColor darkSlateGray = add("dark-slate-gray", 3100495);
  public static final StandardColor darkSlateGrey = add("dark-slate-grey", 3100495);
  public static final StandardColor darkTurquoise = add("dark-turquoise", 52945);
  public static final StandardColor darkViolet = add("dark-violet", 9699539);
  public static final StandardColor deepPink = add("deep-pink", 16716947);
  public static final StandardColor deepSkyBlue = add("deep-sky-blue", 49151);
  public static final StandardColor dimGray = add("dim-gray", 6908265);
  public static final StandardColor dimGrey = add("dim-grey", 6908265);
  public static final StandardColor dodgerBlue = add("dodger-blue", 2003199);
  public static final StandardColor fireBrick = add("fire-brick", 11674146);
  public static final StandardColor floralWhite = add("floral-white", 16775920);
  public static final StandardColor forestGreen = add("forest-green", 2263842);
  public static final StandardColor fuchsia = add("fuchsia", 16711935);
  public static final StandardColor gainsboro = add("gainsboro", 14474460);
  public static final StandardColor ghostWhite = add("ghost-white", 16316671);
  public static final StandardColor gold = add("gold", 16766720);
  public static final StandardColor goldenrod = add("goldenrod", 14329120);
  public static final StandardColor gray = add("gray", 8421504);
  public static final StandardColor green = add("green", 32768);
  public static final StandardColor greenYellow = add("green-yellow", 11403055);
  public static final StandardColor grey = add("grey", 8421504);
  public static final StandardColor honeyDew = add("honey-dew", 15794160);
  public static final StandardColor hotPink = add("hot-pink", 16738740);
  public static final StandardColor indianRed = add("indian-red", 13458524);
  public static final StandardColor indigo = add("indigo", 4915330);
  public static final StandardColor ivory = add("ivory", 16777200);
  public static final StandardColor khaki = add("khaki", 15787660);
  public static final StandardColor lavender = add("lavender", 15132410);
  public static final StandardColor lavenderBlush = add("lavender-blush", 16773365);
  public static final StandardColor lawnGreen = add("lawn-green", 8190976);
  public static final StandardColor lemonChiffon = add("lemon-chiffon", 16775885);
  public static final StandardColor lightBlue = add("light-blue", 11393254);
  public static final StandardColor lightCoral = add("light-coral", 15761536);
  public static final StandardColor lightCyan = add("light-cyan", 14745599);
  public static final StandardColor lightGoldenrodYellow = add("light-goldenrod-yellow", 16448210);
  public static final StandardColor lightGray = add("light-gray", 13882323);
  public static final StandardColor lightGreen = add("light-green", 9498256);
  public static final StandardColor lightGrey = add("light-grey", 13882323);
  public static final StandardColor lightPink = add("light-pink", 16758465);
  public static final StandardColor lightSalmon = add("light-salmon", 16752762);
  public static final StandardColor lightSeaGreen = add("light-sea-green", 2142890);
  public static final StandardColor lightSkyBlue = add("light-sky-blue", 8900346);
  public static final StandardColor lightSlateGray = add("light-slate-gray", 7833753);
  public static final StandardColor lightSlateGrey = add("light-slate-grey", 7833753);
  public static final StandardColor lightSteelBlue = add("light-steel-blue", 11584734);
  public static final StandardColor lightYellow = add("light-yellow", 16777184);
  public static final StandardColor lime = add("lime", 65280);
  public static final StandardColor limeGreen = add("lime-green", 3329330);
  public static final StandardColor linen = add("linen", 16445670);
  public static final StandardColor magenta = add("magenta", 16711935);
  public static final StandardColor maroon = add("maroon", 8388608);
  public static final StandardColor mediumAquaMarine = add("medium-aqua-marine", 6737322);
  public static final StandardColor mediumBlue = add("medium-blue", 205);
  public static final StandardColor mediumOrchid = add("medium-orchid", 12211667);
  public static final StandardColor mediumPurple = add("medium-purple", 9662683);
  public static final StandardColor mediumSeaGreen = add("medium-sea-green", 3978097);
  public static final StandardColor mediumSlateBlue = add("medium-slate-blue", 8087790);
  public static final StandardColor mediumSpringGreen = add("medium-spring-green", 64154);
  public static final StandardColor mediumTurquoise = add("medium-turquoise", 4772300);
  public static final StandardColor mediumVioletRed = add("medium-violet-red", 13047173);
  public static final StandardColor midnightBlue = add("midnight-blue", 1644912);
  public static final StandardColor mintCream = add("mint-cream", 16121850);
  public static final StandardColor mistyRose = add("misty-rose", 16770273);
  public static final StandardColor moccasin = add("moccasin", 16770229);
  public static final StandardColor navajoWhite = add("navajo-white", 16768685);
  public static final StandardColor navy = add("navy", 128);
  public static final StandardColor oldLace = add("old-lace", 16643558);
  public static final StandardColor olive = add("olive", 8421376);
  public static final StandardColor oliveDrab = add("olive-drab", 7048739);
  public static final StandardColor orange = add("orange", 16753920);
  public static final StandardColor orangeRed = add("orange-red", 16729344);
  public static final StandardColor orchid = add("orchid", 14315734);
  public static final StandardColor paleGoldenrod = add("pale-goldenrod", 15657130);
  public static final StandardColor paleGreen = add("pale-green", 10025880);
  public static final StandardColor paleTurquoise = add("pale-turquoise", 11529966);
  public static final StandardColor paleVioletRed = add("pale-violet-red", 14381203);
  public static final StandardColor papayaWhip = add("papaya-whip", 16773077);
  public static final StandardColor peachPuff = add("peach-puff", 16767673);
  public static final StandardColor peru = add("peru", 13468991);
  public static final StandardColor pink = add("pink", 16761035);
  public static final StandardColor plum = add("plum", 14524637);
  public static final StandardColor powderBlue = add("powder-blue", 11591910);
  public static final StandardColor purple = add("purple", 8388736);
  public static final StandardColor red = add("red", 16711680);
  public static final StandardColor rosyBrown = add("rosy-brown", 12357519);
  public static final StandardColor royalBlue = add("royal-blue", 4286945);
  public static final StandardColor saddleBrown = add("saddle-brown", 9127187);
  public static final StandardColor salmon = add("salmon", 16416882);
  public static final StandardColor sandyBrown = add("sandy-brown", 16032864);
  public static final StandardColor seaGreen = add("sea-green", 3050327);
  public static final StandardColor seaShell = add("sea-shell", 16774638);
  public static final StandardColor sienna = add("sienna", 10506797);
  public static final StandardColor silver = add("silver", 12632256);
  public static final StandardColor skyBlue = add("sky-blue", 8900331);
  public static final StandardColor slateBlue = add("slate-blue", 6970061);
  public static final StandardColor slateGray = add("slate-gray", 7372944);
  public static final StandardColor slateGrey = add("slate-grey", 7372944);
  public static final StandardColor snow = add("snow", 16775930);
  public static final StandardColor springGreen = add("spring-green", 65407);
  public static final StandardColor steelBlue = add("steel-blue", 4620980);
  public static final StandardColor tan = add("tan", 13808780);
  public static final StandardColor teal = add("teal", 32896);
  public static final StandardColor thistle = add("thistle", 14204888);
  public static final StandardColor tomato = add("tomato", 16737095);
  public static final StandardColor turquoise = add("turquoise", 4251856);
  public static final StandardColor violet = add("violet", 15631086);
  public static final StandardColor wheat = add("wheat", 16113331);
  public static final StandardColor white = add("white", 16777215);
  public static final StandardColor whiteSmoke = add("white-smoke", 16119285);
  public static final StandardColor yellow = add("yellow", 16776960);
  public static final StandardColor yellowGreen = add("yellow-green", 10145074);
  public static final StandardColor transparent = add(new StandardColor("transparent", 0, 0, 0, 0));
  
  public static StandardColor valueOf(String name)
  {
    String cname = name.toLowerCase().replace("-", "");
    return (StandardColor)map.get(cname);
  }
  
  public String toString() {
    return "StandardColor[r=" + getRed() + ",g=" + getGreen() + ",b=" + getBlue() + ";" + name + "]";
  }
}
