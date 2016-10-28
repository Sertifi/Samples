
package net.sertifi.apps.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentOperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentOperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pay"/>
 *     &lt;enumeration value="Authorize"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentOperationType")
@XmlEnum
public enum PaymentOperationType {

    @XmlEnumValue("Pay")
    PAY("Pay"),
    @XmlEnumValue("Authorize")
    AUTHORIZE("Authorize");
    private final String value;

    PaymentOperationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentOperationType fromValue(String v) {
        for (PaymentOperationType c: PaymentOperationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
