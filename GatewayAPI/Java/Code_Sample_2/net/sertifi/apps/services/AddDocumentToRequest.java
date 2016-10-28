
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
 *         &lt;element name="pbyt_File" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="pstr_FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Xml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pbytFile",
    "pstrFileName",
    "pstrTitle",
    "pstrXml"
})
@XmlRootElement(name = "AddDocumentToRequest")
public class AddDocumentToRequest {

    @XmlElement(name = "pstr_APICode")
    protected String pstrAPICode;
    @XmlElement(name = "pstr_FileID")
    protected String pstrFileID;
    @XmlElement(name = "pbyt_File")
    protected byte[] pbytFile;
    @XmlElement(name = "pstr_FileName")
    protected String pstrFileName;
    @XmlElement(name = "pstr_Title")
    protected String pstrTitle;
    @XmlElement(name = "pstr_Xml")
    protected String pstrXml;

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
     * Gets the value of the pbytFile property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPbytFile() {
        return pbytFile;
    }

    /**
     * Sets the value of the pbytFile property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPbytFile(byte[] value) {
        this.pbytFile = value;
    }

    /**
     * Gets the value of the pstrFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrFileName() {
        return pstrFileName;
    }

    /**
     * Sets the value of the pstrFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrFileName(String value) {
        this.pstrFileName = value;
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
     * Gets the value of the pstrXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrXml() {
        return pstrXml;
    }

    /**
     * Sets the value of the pstrXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrXml(String value) {
        this.pstrXml = value;
    }

}
