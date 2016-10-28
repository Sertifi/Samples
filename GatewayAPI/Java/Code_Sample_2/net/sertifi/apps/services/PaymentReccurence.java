
package net.sertifi.apps.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentReccurence.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentReccurence">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OneTime"/>
 *     &lt;enumeration value="Monthly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentReccurence")
@XmlEnum
public enum PaymentReccurence {

    @XmlEnumValue("OneTime")
    ONE_TIME("OneTime"),
    @XmlEnumValue("Monthly")
    MONTHLY("Monthly");
    private final String value;

    PaymentReccurence(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentReccurence fromValue(String v) {
        for (PaymentReccurence c: PaymentReccurence.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
