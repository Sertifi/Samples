
package net.sertifi.apps.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoomStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Archived"/>
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="ActiveCC"/>
 *     &lt;enumeration value="ArchivedCC"/>
 *     &lt;enumeration value="AwaitingVerification"/>
 *     &lt;enumeration value="Creating"/>
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="DeclinedAndArchived"/>
 *     &lt;enumeration value="Expired"/>
 *     &lt;enumeration value="Deleted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoomStatus")
@XmlEnum
public enum RoomStatus {

    @XmlEnumValue("Archived")
    ARCHIVED("Archived"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("ActiveCC")
    ACTIVE_CC("ActiveCC"),
    @XmlEnumValue("ArchivedCC")
    ARCHIVED_CC("ArchivedCC"),
    @XmlEnumValue("AwaitingVerification")
    AWAITING_VERIFICATION("AwaitingVerification"),
    @XmlEnumValue("Creating")
    CREATING("Creating"),
    @XmlEnumValue("Declined")
    DECLINED("Declined"),
    @XmlEnumValue("DeclinedAndArchived")
    DECLINED_AND_ARCHIVED("DeclinedAndArchived"),
    @XmlEnumValue("Expired")
    EXPIRED("Expired"),
    @XmlEnumValue("Deleted")
    DELETED("Deleted");
    private final String value;

    RoomStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoomStatus fromValue(String v) {
        for (RoomStatus c: RoomStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
