
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
 *         &lt;element name="pstr_StartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_EndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pstrStartDate",
    "pstrEndDate"
})
@XmlRootElement(name = "GetFilesStatus")
public class GetFilesStatus {

    @XmlElement(name = "pstr_APICode")
    protected String pstrAPICode;
    @XmlElement(name = "pstr_StartDate")
    protected String pstrStartDate;
    @XmlElement(name = "pstr_EndDate")
    protected String pstrEndDate;

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
     * Gets the value of the pstrStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrStartDate() {
        return pstrStartDate;
    }

    /**
     * Sets the value of the pstrStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrStartDate(String value) {
        this.pstrStartDate = value;
    }

    /**
     * Gets the value of the pstrEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrEndDate() {
        return pstrEndDate;
    }

    /**
     * Sets the value of the pstrEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrEndDate(String value) {
        this.pstrEndDate = value;
    }

}
