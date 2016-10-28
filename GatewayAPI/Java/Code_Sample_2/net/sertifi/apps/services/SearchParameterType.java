
package net.sertifi.apps.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchParameterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FileNumericId1"/>
 *     &lt;enumeration value="FileDateSigned"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchParameterType")
@XmlEnum
public enum SearchParameterType {

    @XmlEnumValue("FileNumericId1")
    FILE_NUMERIC_ID_1("FileNumericId1"),
    @XmlEnumValue("FileDateSigned")
    FILE_DATE_SIGNED("FileDateSigned");
    private final String value;

    SearchParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchParameterType fromValue(String v) {
        for (SearchParameterType c: SearchParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
