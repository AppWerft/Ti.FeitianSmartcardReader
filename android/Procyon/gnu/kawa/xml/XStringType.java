// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.xml.XName;
import gnu.xml.TextUtils;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import java.util.regex.Pattern;

public class XStringType extends XDataType
{
    Pattern pattern;
    static ClassType XStringType;
    public static final XStringType normalizedStringType;
    public static final XStringType tokenType;
    public static final XStringType languageType;
    public static final XStringType NMTOKENType;
    public static final XStringType NameType;
    public static final XStringType NCNameType;
    public static final XStringType IDType;
    public static final XStringType IDREFType;
    public static final XStringType ENTITYType;
    
    public XStringType(final String name, final XDataType base, final int typeCode, final String pattern) {
        super(name, gnu.kawa.xml.XStringType.XStringType, typeCode);
        this.baseType = base;
        if (pattern != null) {
            this.pattern = Pattern.compile(pattern);
        }
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        if (!(obj instanceof XString)) {
            return false;
        }
        for (XDataType objType = ((XString)obj).getStringType(); objType != null; objType = objType.baseType) {
            if (objType == this) {
                return true;
            }
        }
        return false;
    }
    
    public String matches(final String value) {
        boolean status = false;
        switch (this.typeCode) {
            case 39:
            case 40: {
                final boolean collapse = this.typeCode != 39;
                status = (value == TextUtils.replaceWhitespace(value, collapse));
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
                status = (this.pattern == null || this.pattern.matcher(value).matches());
                break;
            }
        }
        return status ? null : ("not a valid XML " + this.getName());
    }
    
    @Override
    public Object valueOf(String value) {
        value = TextUtils.replaceWhitespace(value, this != gnu.kawa.xml.XStringType.normalizedStringType);
        final String err = this.matches(value);
        if (err != null) {
            throw new ClassCastException("cannot cast " + value + " to " + this.name);
        }
        return new XString(value, this);
    }
    
    @Override
    public Object cast(final Object value) {
        if (value instanceof XString) {
            final XString xvalue = (XString)value;
            if (xvalue.getStringType() == this) {
                return xvalue;
            }
        }
        return this.valueOf((String)gnu.kawa.xml.XStringType.stringType.cast(value));
    }
    
    public static XString makeNCName(final String value) {
        return (XString)gnu.kawa.xml.XStringType.NCNameType.valueOf(value);
    }
    
    static {
        gnu.kawa.xml.XStringType.XStringType = ClassType.make("gnu.kawa.xml.XString");
        normalizedStringType = new XStringType("normalizedString", gnu.kawa.xml.XStringType.stringType, 39, null);
        tokenType = new XStringType("token", gnu.kawa.xml.XStringType.normalizedStringType, 40, null);
        languageType = new XStringType("language", gnu.kawa.xml.XStringType.tokenType, 41, "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*");
        NMTOKENType = new XStringType("NMTOKEN", gnu.kawa.xml.XStringType.tokenType, 42, "\\c+");
        NameType = new XStringType("Name", gnu.kawa.xml.XStringType.tokenType, 43, null);
        NCNameType = new XStringType("NCName", gnu.kawa.xml.XStringType.NameType, 44, null);
        IDType = new XStringType("ID", gnu.kawa.xml.XStringType.NCNameType, 45, null);
        IDREFType = new XStringType("IDREF", gnu.kawa.xml.XStringType.NCNameType, 46, null);
        ENTITYType = new XStringType("ENTITY", gnu.kawa.xml.XStringType.NCNameType, 47, null);
    }
}
