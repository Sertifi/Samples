
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
 *         &lt;element name="pstr_OriginalEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_NewEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_SignerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pshr_Sequence" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
    "pstrOriginalEmail",
    "pstrNewEmail",
    "pstrSignerType",
    "pshrSequence"
})
@XmlRootElement(name = "EditUser")
public class EditUser {

    @XmlElement(name = "pstr_APICode")
    protected String pstrAPICode;
    @XmlElement(name = "pstr_FileID")
    protected String pstrFileID;
    @XmlElement(name = "pstr_OriginalEmail")
    protected String pstrOriginalEmail;
    @XmlElement(name = "pstr_NewEmail")
    protected String pstrNewEmail;
    @XmlElement(name = "pstr_SignerType")
    protected String pstrSignerType;
    @XmlElement(name = "pshr_Sequence")
    protected short pshrSequence;

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
     * Gets the value of the pstrOriginalEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrOriginalEmail() {
        return pstrOriginalEmail;
    }

    /**
     * Sets the value of the pstrOriginalEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrOriginalEmail(String value) {
        this.pstrOriginalEmail = value;
    }

    /**
     * Gets the value of the pstrNewEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrNewEmail() {
        return pstrNewEmail;
    }

    /**
     * Sets the value of the pstrNewEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrNewEmail(String value) {
        this.pstrNewEmail = value;
    }

    /**
     * Gets the value of the pstrSignerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrSignerType() {
        return pstrSignerType;
    }

    /**
     * Sets the value of the pstrSignerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrSignerType(String value) {
        this.pstrSignerType = value;
    }

    /**
     * Gets the value of the pshrSequence property.
     * 
     */
    public short getPshrSequence() {
        return pshrSequence;
    }

    /**
     * Sets the value of the pshrSequence property.
     * 
     */
    public void setPshrSequence(short value) {
        this.pshrSequence = value;
    }

}
