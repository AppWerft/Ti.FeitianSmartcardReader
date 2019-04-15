/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XString;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XStringType
extends XDataType {
    Pattern pattern;
    static ClassType XStringType = ClassType.make("gnu.kawa.xml.XString");
    public static final XStringType normalizedStringType = new XStringType("normalizedString", stringType, 39, null);
    public static final XStringType tokenType = new XStringType("token", normalizedStringType, 40, null);
    public static final XStringType languageType = new XStringType("language", tokenType, 41, "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*");
    public static final XStringType NMTOKENType = new XStringType("NMTOKEN", tokenType, 42, "\\c+");
    public static final XStringType NameType = new XStringType("Name", tokenType, 43, null);
    public static final XStringType NCNameType = new XStringType("NCName", NameType, 44, null);
    public static final XStringType IDType = new XStringType("ID", NCNameType, 45, null);
    public static final XStringType IDREFType = new XStringType("IDREF", NCNameType, 46, null);
    public static final XStringType ENTITYType = new XStringType("ENTITY", NCNameType, 47, null);

    public XStringType(String name, XDataType base2, int typeCode, String pattern) {
        super(name, XStringType, typeCode);
        this.baseType = base2;
        if (pattern != null) {
            this.pattern = Pattern.compile(pattern);
        }
    }

    @Override
    public boolean isInstance(Object obj) {
        if (!(obj instanceof XString)) {
            return false;
        }
        XDataType objType = ((XString)obj).getStringType();
        while (objType != null) {
            if (objType == this) {
                return true;
            }
            objType = objType.baseType;
        }
        return false;
    }

    public String matches(String value) {
        boolean status;
        switch (this.typeCode) {
            case 39: 
            case 40: {
                boolean collapse = this.typeCode != 39;
                status = value == TextUtils.replaceWhitespace(value, collapse);
                break;
            }
            case 43: {
                status = XName.isName(value);
                break;
            }
            case 44: 
            case 45: 
            case 46: 
            case 47: {
                status = XName.isNCName(value);
                break;
            }
            case 42: {
                status = XName.isNmToken(value);
                break;
            }
            default: {
                status = this.pattern == null || this.pattern.matcher(value).matches();
            }
        }
        return status ? null : "not a valid XML " + this.getName();
    }

    @Override
    public Object valueOf(String value) {
        String err = this.matches(value = TextUtils.replaceWhitespace(value, this != normalizedStringType));
        if (err != null) {
            throw new ClassCastException("cannot cast " + value + " to " + this.name);
        }
        return new XString(value, this);
    }

    @Override
    public Object cast(Object value) {
        XString xvalue;
        if (value instanceof XString && (xvalue = (XString)value).getStringType() == this) {
            return xvalue;
        }
        return this.valueOf((String)stringType.cast(value));
    }

    public static XString makeNCName(String value) {
        return (XString)NCNameType.valueOf(value);
    }
}

