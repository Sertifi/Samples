
package https.apps_sertifi_net.services.linkparameter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkType" type="{https://apps.sertifi.net/services/LinkParameter}LinkParameterType"/>
 *         &lt;element name="SignerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalProperties" type="{https://apps.sertifi.net/services/LinkParameter}ArrayOfNameValuePair" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkParameter", propOrder = {
    "fileId",
    "documentId",
    "paymentId",
    "linkType",
    "signerEmail",
    "additionalProperties"
})
public class LinkParameter {

    @XmlElement(name = "FileId")
    protected String fileId;
    @XmlElement(name = "DocumentId")
    protected String documentId;
    @XmlElement(name = "PaymentId")
    protected String paymentId;
    @XmlElement(name = "LinkType", required = true)
    @XmlSchemaType(name = "string")
    protected LinkParameterType linkType;
    @XmlElement(name = "SignerEmail")
    protected String signerEmail;
    @XmlElement(name = "AdditionalProperties")
    protected ArrayOfNameValuePair additionalProperties;

    /**
     * Gets the value of the fileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * Sets the value of the fileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileId(String value) {
        this.fileId = value;
    }

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the paymentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the value of the paymentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentId(String value) {
        this.paymentId = value;
    }

    /**
     * Gets the value of the linkType property.
     * 
     * @return
     *     possible object is
     *     {@link LinkParameterType }
     *     
     */
    public LinkParameterType getLinkType() {
        return linkType;
    }

    /**
     * Sets the value of the linkType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkParameterType }
     *     
     */
    public void setLinkType(LinkParameterType value) {
        this.linkType = value;
    }

    /**
     * Gets the value of the signerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerEmail() {
        return signerEmail;
    }

    /**
     * Sets the value of the signerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerEmail(String value) {
        this.signerEmail = value;
    }

    /**
     * Gets the value of the additionalProperties property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfNameValuePair }
     *     
     */
    public ArrayOfNameValuePair getAdditionalProperties() {
        return additionalProperties;
    }

    /**
     * Sets the value of the additionalProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfNameValuePair }
     *     
     */
    public void setAdditionalProperties(ArrayOfNameValuePair value) {
        this.additionalProperties = value;
    }

}
