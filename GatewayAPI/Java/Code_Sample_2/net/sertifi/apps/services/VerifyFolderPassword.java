
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
 *         &lt;element name="lstr_RoomID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pstr_Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "lstrRoomID",
    "pstrPassword"
})
@XmlRootElement(name = "VerifyFolderPassword")
public class VerifyFolderPassword {

    @XmlElement(name = "lstr_RoomID")
    protected String lstrRoomID;
    @XmlElement(name = "pstr_Password")
    protected String pstrPassword;

    /**
     * Gets the value of the lstrRoomID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLstrRoomID() {
        return lstrRoomID;
    }

    /**
     * Sets the value of the lstrRoomID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLstrRoomID(String value) {
        this.lstrRoomID = value;
    }

    /**
     * Gets the value of the pstrPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstrPassword() {
        return pstrPassword;
    }

    /**
     * Sets the value of the pstrPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstrPassword(String value) {
        this.pstrPassword = value;
    }

}
