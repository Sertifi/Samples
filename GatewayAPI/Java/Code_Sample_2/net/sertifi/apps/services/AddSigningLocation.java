
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
 *         &lt;element name="pint_Height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pint_Width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pstr_SignerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Caption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pintHeight",
    "pintWidth",
    "pstrSignerEmail",
    "pstrCaption"
})
@XmlRootElement(name = "AddSigningLocation")
public class AddSigningLocation {

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
    @XmlElement(name = "pint_Height")
    protected int pintHeight;
    @XmlElement(name = "pint_Width")
    protected int pintWidth;
    @XmlElement(name = "pstr_SignerEmail")
    protected String pstrSignerEmail;
    @XmlElement(name = "pstr_Caption")
    protected String pstrCaption;

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
     * Gets the value of the pintHeight property.
     * 
     */
    public int getPintHeight() {
        return pintHeight;
    }

    /**
     * Sets the value of the pintHeight property.
     * 
     */
    public void setPintHeight(int value) {
        this.pintHeight = value;
    }

    /**
     * Gets the value of the pintWidth property.
     * 
     */
    public int getPintWidth() {
        return pintWidth;
    }

    /**
     * Sets the value of the pintWidth property.
     * 
     */
    public void setPintWidth(int value) {
        this.pintWidth = value;
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

    /**
     * Gets the value of the pstrCaption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrCaption() {
        return pstrCaption;
    }

    /**
     * Sets the value of the pstrCaption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrCaption(String value) {
        this.pstrCaption = value;
    }

}
