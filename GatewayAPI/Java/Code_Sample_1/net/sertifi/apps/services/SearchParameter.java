
package net.sertifi.apps.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://apps.sertifi.net/services/}SearchParameterType"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchParameter", propOrder = {
    "type",
    "value"
})
public class SearchParameter {

    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected SearchParameterType type;
    @XmlElement(name = "Value")
    protected String value;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link SearchParameterType }
     *     
     */
    public SearchParameterType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchParameterType }
     *     
     */
    public void setType(SearchParameterType value) {
        this.type = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
