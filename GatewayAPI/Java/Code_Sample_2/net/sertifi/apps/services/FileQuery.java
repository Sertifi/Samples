
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
 *         &lt;element name="parameters" type="{http://apps.sertifi.net/services/}ArrayOfSearchParameter" minOccurs="0"/>
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
    "parameters"
})
@XmlRootElement(name = "FileQuery")
public class FileQuery {

    @XmlElement(name = "p_ApiCode")
    protected String pApiCode;
    protected ArrayOfSearchParameter parameters;

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
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSearchParameter }
     *     
     */
    public ArrayOfSearchParameter getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSearchParameter }
     *     
     */
    public void setParameters(ArrayOfSearchParameter value) {
        this.parameters = value;
    }

}
