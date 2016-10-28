
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
 *         &lt;element name="pstr_APICode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_FileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_DocumentID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_NameSigned" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_CustomField1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_CustomField2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_CustomField3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_CustomField4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pstrAPICode",
    "pstrFileID",
    "pstrDocumentID",
    "pstrNameSigned",
    "pstrEmail",
    "pstrCustomField1",
    "pstrCustomField2",
    "pstrCustomField3",
    "pstrCustomField4"
})
@XmlRootElement(name = "ApplySignature")
public class ApplySignature {

    @XmlElement(name = "pstr_APICode")
    protected String pstrAPICode;
    @XmlElement(name = "pstr_FileID")
    protected String pstrFileID;
    @XmlElement(name = "pstr_DocumentID")
    protected String pstrDocumentID;
    @XmlElement(name = "pstr_NameSigned")
    protected String pstrNameSigned;
    @XmlElement(name = "pstr_Email")
    protected String pstrEmail;
    @XmlElement(name = "pstr_CustomField1")
    protected String pstrCustomField1;
    @XmlElement(name = "pstr_CustomField2")
    protected String pstrCustomField2;
    @XmlElement(name = "pstr_CustomField3")
    protected String pstrCustomField3;
    @XmlElement(name = "pstr_CustomField4")
    protected String pstrCustomField4;

    /**
     * Gets the value of the pstrAPICode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrAPICode() {
        return pstrAPICode;
    }

    /**
     * Sets the value of the pstrAPICode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrAPICode(String value) {
        this.pstrAPICode = value;
    }

    /**
     * Gets the value of the pstrFileID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrFileID() {
        return pstrFileID;
    }

    /**
     * Sets the value of the pstrFileID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrFileID(String value) {
        this.pstrFileID = value;
    }

    /**
     * Gets the value of the pstrDocumentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrDocumentID() {
        return pstrDocumentID;
    }

    /**
     * Sets the value of the pstrDocumentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrDocumentID(String value) {
        this.pstrDocumentID = value;
    }

    /**
     * Gets the value of the pstrNameSigned property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrNameSigned() {
        return pstrNameSigned;
    }

    /**
     * Sets the value of the pstrNameSigned property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrNameSigned(String value) {
        this.pstrNameSigned = value;
    }

    /**
     * Gets the value of the pstrEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrEmail() {
        return pstrEmail;
    }

    /**
     * Sets the value of the pstrEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrEmail(String value) {
        this.pstrEmail = value;
    }

    /**
     * Gets the value of the pstrCustomField1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrCustomField1() {
        return pstrCustomField1;
    }

    /**
     * Sets the value of the pstrCustomField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrCustomField1(String value) {
        this.pstrCustomField1 = value;
    }

    /**
     * Gets the value of the pstrCustomField2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrCustomField2() {
        return pstrCustomField2;
    }

    /**
     * Sets the value of the pstrCustomField2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrCustomField2(String value) {
        this.pstrCustomField2 = value;
    }

    /**
     * Gets the value of the pstrCustomField3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrCustomField3() {
        return pstrCustomField3;
    }

    /**
     * Sets the value of the pstrCustomField3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrCustomField3(String value) {
        this.pstrCustomField3 = value;
    }

    /**
     * Gets the value of the pstrCustomField4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrCustomField4() {
        return pstrCustomField4;
    }

    /**
     * Sets the value of the pstrCustomField4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrCustomField4(String value) {
        this.pstrCustomField4 = value;
    }

}
