
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
 *         &lt;element name="GetLinkResult" type="{http://apps.sertifi.net/services/}ArrayOfUrlQueryResult" minOccurs="0"/>
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
    "getLinkResult"
})
@XmlRootElement(name = "GetLinkResponse")
public class GetLinkResponse {

    @XmlElement(name = "GetLinkResult")
    protected ArrayOfUrlQueryResult getLinkResult;

    /**
     * Gets the value of the getLinkResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUrlQueryResult }
     *     
     */
    public ArrayOfUrlQueryResult getGetLinkResult() {
        return getLinkResult;
    }

    /**
     * Sets the value of the getLinkResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUrlQueryResult }
     *     
     */
    public void setGetLinkResult(ArrayOfUrlQueryResult value) {
        this.getLinkResult = value;
    }

}
