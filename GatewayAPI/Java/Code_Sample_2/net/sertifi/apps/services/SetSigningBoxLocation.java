
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
 *         &lt;element name="pint_Page" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pint_Top" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pint_Left" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pstr_SignerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pintPage",
    "pintTop",
    "pintLeft",
    "pstrSignerEmail"
})
@XmlRootElement(name = "SetSigningBoxLocation")
public class SetSigningBoxLocation {

    @XmlElement(name = "pstr_APICode")
    protected String pstrAPICode;
    @XmlElement(name = "pstr_FileID")
    protected String pstrFileID;
    @XmlElement(name = "pstr_DocumentID")
    protected String pstrDocumentID;
    @XmlElement(name = "pint_Page")
    protected int pintPage;
    @XmlElement(name = "pint_Top")
    protected int pintTop;
    @XmlElement(name = "pint_Left")
    protected int pintLeft;
    @XmlElement(name = "pstr_SignerEmail")
    protected String pstrSignerEmail;

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
     * Gets the value of the pintPage property.
     * 
     */
    public int getPintPage() {
        return pintPage;
    }

    /**
     * Sets the value of the pintPage property.
     * 
     */
    public void setPintPage(int value) {
        this.pintPage = value;
    }

    /**
     * Gets the value of the pintTop property.
     * 
     */
    public int getPintTop() {
        return pintTop;
    }

    /**
     * Sets the value of the pintTop property.
     * 
     */
    public void setPintTop(int value) {
        this.pintTop = value;
    }

    /**
     * Gets the value of the pintLeft property.
     * 
     */
    public int getPintLeft() {
        return pintLeft;
    }

    /**
     * Sets the value of the pintLeft property.
     * 
     */
    public void setPintLeft(int value) {
        this.pintLeft = value;
    }

    /**
     * Gets the value of the pstrSignerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrSignerEmail() {
        return pstrSignerEmail;
    }

    /**
     * Sets the value of the pstrSignerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrSignerEmail(String value) {
        this.pstrSignerEmail = value;
    }

}
