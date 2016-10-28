
package net.sertifi.apps.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="p_APICode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_FileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "papiCode",
    "pFileID",
    "paymentId"
})
@XmlRootElement(name = "RemovePayment")
public class RemovePayment {

    @XmlElement(name = "p_APICode")
    protected String papiCode;
    @XmlElement(name = "p_FileID")
    protected String pFileID;
    protected String paymentId;

    /**
     * Gets the value of the papiCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAPICode() {
        return papiCode;
    }

    /**
     * Sets the value of the papiCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAPICode(String value) {
        this.papiCode = value;
    }

    /**
     * Gets the value of the pFileID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPFileID() {
        return pFileID;
    }

    /**
     * Sets the value of the pFileID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPFileID(String value) {
        this.pFileID = value;
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

}
