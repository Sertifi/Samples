
package net.sertifi.apps.services;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recurrence" type="{http://apps.sertifi.net/services/}PaymentReccurence" minOccurs="0"/>
 *         &lt;element name="datePaymentDue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operation" type="{http://apps.sertifi.net/services/}PaymentOperationType" minOccurs="0"/>
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
    "amount",
    "description",
    "recurrence",
    "datePaymentDue",
    "operation"
})
@XmlRootElement(name = "Payment")
public class CreatePayment {

    @XmlElement(name = "p_APICode")
    protected String papiCode;
    @XmlElement(name = "p_FileID")
    protected String pFileID;
    @XmlElement(required = true)
    protected BigDecimal amount;
    protected String description;
    @XmlElement(defaultValue = "OneTime")
    @XmlSchemaType(name = "string")
    protected PaymentReccurence recurrence;
    protected String datePaymentDue;
    @XmlElement(defaultValue = "Pay")
    @XmlSchemaType(name = "string")
    protected PaymentOperationType operation;

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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the recurrence property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentReccurence }
     *     
     */
    public PaymentReccurence getRecurrence() {
        return recurrence;
    }

    /**
     * Sets the value of the recurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentReccurence }
     *     
     */
    public void setRecurrence(PaymentReccurence value) {
        this.recurrence = value;
    }

    /**
     * Gets the value of the datePaymentDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatePaymentDue() {
        return datePaymentDue;
    }

    /**
     * Sets the value of the datePaymentDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatePaymentDue(String value) {
        this.datePaymentDue = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentOperationType }
     *     
     */
    public PaymentOperationType getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentOperationType }
     *     
     */
    public void setOperation(PaymentOperationType value) {
        this.operation = value;
    }

}
