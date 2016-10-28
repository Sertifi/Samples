
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
 *         &lt;element name="pstr_FormID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pbln_MatchTitle" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "pstrFormID",
    "pstrTitle",
    "pblnMatchTitle"
})
@XmlRootElement(name = "RemoveFormFromRequest")
public class RemoveFormFromRequest {

    @XmlElement(name = "pstr_APICode")
    protected String pstrAPICode;
    @XmlElement(name = "pstr_FileID")
    protected String pstrFileID;
    @XmlElement(name = "pstr_FormID")
    protected String pstrFormID;
    @XmlElement(name = "pstr_Title")
    protected String pstrTitle;
    @XmlElement(name = "pbln_MatchTitle")
    protected boolean pblnMatchTitle;

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
     * Gets the value of the pstrFormID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrFormID() {
        return pstrFormID;
    }

    /**
     * Sets the value of the pstrFormID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrFormID(String value) {
        this.pstrFormID = value;
    }

    /**
     * Gets the value of the pstrTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrTitle() {
        return pstrTitle;
    }

    /**
     * Sets the value of the pstrTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrTitle(String value) {
        this.pstrTitle = value;
    }

    /**
     * Gets the value of the pblnMatchTitle property.
     * 
     */
    public boolean isPblnMatchTitle() {
        return pblnMatchTitle;
    }

    /**
     * Sets the value of the pblnMatchTitle property.
     * 
     */
    public void setPblnMatchTitle(boolean value) {
        this.pblnMatchTitle = value;
    }

}
