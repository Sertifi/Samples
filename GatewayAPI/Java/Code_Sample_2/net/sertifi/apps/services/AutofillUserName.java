
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
 *         &lt;element name="pstr_UserEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_AutoFillUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pstrUserEmail",
    "pstrUserName",
    "pstrAutoFillUser"
})
@XmlRootElement(name = "AutofillUserName")
public class AutofillUserName {

    @XmlElement(name = "pstr_APICode")
    protected String pstrAPICode;
    @XmlElement(name = "pstr_UserEmail")
    protected String pstrUserEmail;
    @XmlElement(name = "pstr_UserName")
    protected String pstrUserName;
    @XmlElement(name = "pstr_AutoFillUser")
    protected String pstrAutoFillUser;

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
     * Gets the value of the pstrUserEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrUserEmail() {
        return pstrUserEmail;
    }

    /**
     * Sets the value of the pstrUserEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrUserEmail(String value) {
        this.pstrUserEmail = value;
    }

    /**
     * Gets the value of the pstrUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrUserName() {
        return pstrUserName;
    }

    /**
     * Sets the value of the pstrUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrUserName(String value) {
        this.pstrUserName = value;
    }

    /**
     * Gets the value of the pstrAutoFillUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrAutoFillUser() {
        return pstrAutoFillUser;
    }

    /**
     * Sets the value of the pstrAutoFillUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrAutoFillUser(String value) {
        this.pstrAutoFillUser = value;
    }

}
