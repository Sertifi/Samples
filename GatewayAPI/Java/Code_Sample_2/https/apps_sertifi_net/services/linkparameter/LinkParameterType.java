
package https.apps_sertifi_net.services.linkparameter;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LinkParameterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DocumentOriginalLink"/>
 *     &lt;enumeration value="DocumentPartiallySignedLink"/>
 *     &lt;enumeration value="DocumentSignedLink"/>
 *     &lt;enumeration value="DocumentEditLocationsLink"/>
 *     &lt;enumeration value="DocumentPrefillLink"/>
 *     &lt;enumeration value="DocumentPropertiesLink"/>
 *     &lt;enumeration value="FileSigningPageLink"/>
 *     &lt;enumeration value="FileMaintenanceLink"/>
 *     &lt;enumeration value="SigningPageLink"/>
 *     &lt;enumeration value="SecureDocumentOriginalLink"/>
 *     &lt;enumeration value="SecureDocumentPartiallySignedLink"/>
 *     &lt;enumeration value="SecureDocumentSignedLink"/>
 *     &lt;enumeration value="SecureSendingPageLink"/>
 *     &lt;enumeration value="SecureFileMaintenanceLink"/>
 *     &lt;enumeration value="SecureFileSigningPageLink"/>
 *     &lt;enumeration value="SecureHomePageLink"/>
 *     &lt;enumeration value="SecureDocumentPrefillLink"/>
 *     &lt;enumeration value="PrintablePdfLink"/>
 *     &lt;enumeration value="PaymentReceiptLink"/>
 *     &lt;enumeration value="SecurePaymentLink"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LinkParameterType")
@XmlEnum
public enum LinkParameterType {

    @XmlEnumValue("DocumentOriginalLink")
    DOCUMENT_ORIGINAL_LINK("DocumentOriginalLink"),
    @XmlEnumValue("DocumentPartiallySignedLink")
    DOCUMENT_PARTIALLY_SIGNED_LINK("DocumentPartiallySignedLink"),
    @XmlEnumValue("DocumentSignedLink")
    DOCUMENT_SIGNED_LINK("DocumentSignedLink"),
    @XmlEnumValue("DocumentEditLocationsLink")
    DOCUMENT_EDIT_LOCATIONS_LINK("DocumentEditLocationsLink"),
    @XmlEnumValue("DocumentPrefillLink")
    DOCUMENT_PREFILL_LINK("DocumentPrefillLink"),
    @XmlEnumValue("DocumentPropertiesLink")
    DOCUMENT_PROPERTIES_LINK("DocumentPropertiesLink"),
    @XmlEnumValue("FileSigningPageLink")
    FILE_SIGNING_PAGE_LINK("FileSigningPageLink"),
    @XmlEnumValue("FileMaintenanceLink")
    FILE_MAINTENANCE_LINK("FileMaintenanceLink"),
    @XmlEnumValue("SigningPageLink")
    SIGNING_PAGE_LINK("SigningPageLink"),
    @XmlEnumValue("SecureDocumentOriginalLink")
    SECURE_DOCUMENT_ORIGINAL_LINK("SecureDocumentOriginalLink"),
    @XmlEnumValue("SecureDocumentPartiallySignedLink")
    SECURE_DOCUMENT_PARTIALLY_SIGNED_LINK("SecureDocumentPartiallySignedLink"),
    @XmlEnumValue("SecureDocumentSignedLink")
    SECURE_DOCUMENT_SIGNED_LINK("SecureDocumentSignedLink"),
    @XmlEnumValue("SecureSendingPageLink")
    SECURE_SENDING_PAGE_LINK("SecureSendingPageLink"),
    @XmlEnumValue("SecureFileMaintenanceLink")
    SECURE_FILE_MAINTENANCE_LINK("SecureFileMaintenanceLink"),
    @XmlEnumValue("SecureFileSigningPageLink")
    SECURE_FILE_SIGNING_PAGE_LINK("SecureFileSigningPageLink"),
    @XmlEnumValue("SecureHomePageLink")
    SECURE_HOME_PAGE_LINK("SecureHomePageLink"),
    @XmlEnumValue("SecureDocumentPrefillLink")
    SECURE_DOCUMENT_PREFILL_LINK("SecureDocumentPrefillLink"),
    @XmlEnumValue("PrintablePdfLink")
    PRINTABLE_PDF_LINK("PrintablePdfLink"),
    @XmlEnumValue("PaymentReceiptLink")
    PAYMENT_RECEIPT_LINK("PaymentReceiptLink"),
    @XmlEnumValue("SecurePaymentLink")
    SECURE_PAYMENT_LINK("SecurePaymentLink");
    private final String value;

    LinkParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LinkParameterType fromValue(String v) {
        for (LinkParameterType c: LinkParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
