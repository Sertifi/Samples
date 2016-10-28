
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
 *         &lt;element name="p_APICode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parameters" type="{http://apps.sertifi.net/services/}ArrayOfLinkParameter" minOccurs="0"/>
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
    "papiCode",
    "parameters"
})
@XmlRootElement(name = "GetLink")
public class GetLink {

    @XmlElement(name = "p_APICode")
    protected String papiCode;
    protected ArrayOfLinkParameter parameters;

    /**
     * Gets the value of the papiCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAPICode() {
        return papiCode;
    }

    /**
     * Sets the value of the papiCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAPICode(String value) {
        this.papiCode = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLinkParameter }
     *     
     */
    public ArrayOfLinkParameter getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLinkParameter }
     *     
     */
    public void setParameters(ArrayOfLinkParameter value) {
        this.parameters = value;
    }

}
