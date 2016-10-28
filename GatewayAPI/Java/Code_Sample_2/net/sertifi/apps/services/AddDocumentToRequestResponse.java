
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
 *         &lt;element name="AddDocumentToRequestResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "addDocumentToRequestResult"
})
@XmlRootElement(name = "AddDocumentToRequestResponse")
public class AddDocumentToRequestResponse {

    @XmlElement(name = "AddDocumentToRequestResult")
    protected String addDocumentToRequestResult;

    /**
     * Gets the value of the addDocumentToRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddDocumentToRequestResult() {
        return addDocumentToRequestResult;
    }

    /**
     * Sets the value of the addDocumentToRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddDocumentToRequestResult(String value) {
        this.addDocumentToRequestResult = value;
    }

}
