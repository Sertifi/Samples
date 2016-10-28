
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
 *         &lt;element name="p_ApiCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_FileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_XMLContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_CustomMetadataXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pApiCode",
    "pFileID",
    "pxmlContent",
    "pCustomMetadataXML"
})
@XmlRootElement(name = "SetSignatureRequestParameters")
public class SetSignatureRequestParameters {

    @XmlElement(name = "p_ApiCode")
    protected String pApiCode;
    @XmlElement(name = "p_FileID")
    protected String pFileID;
    @XmlElement(name = "p_XMLContent")
    protected String pxmlContent;
    @XmlElement(name = "p_CustomMetadataXML")
    protected String pCustomMetadataXML;

    /**
     * Gets the value of the pApiCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPApiCode() {
        return pApiCode;
    }

    /**
     * Sets the value of the pApiCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPApiCode(String value) {
        this.pApiCode = value;
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
     * Gets the value of the pxmlContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPXMLContent() {
        return pxmlContent;
    }

    /**
     * Sets the value of the pxmlContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPXMLContent(String value) {
        this.pxmlContent = value;
    }

    /**
     * Gets the value of the pCustomMetadataXML property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCustomMetadataXML() {
        return pCustomMetadataXML;
    }

    /**
     * Sets the value of the pCustomMetadataXML property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCustomMetadataXML(String value) {
        this.pCustomMetadataXML = value;
    }

}
