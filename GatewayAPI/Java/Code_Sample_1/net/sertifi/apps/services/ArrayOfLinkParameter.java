
package net.sertifi.apps.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import https.apps_sertifi_net.services.linkparameter.LinkParameter;


/**
 * <p>Java class for ArrayOfLinkParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLinkParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LinkParameter" type="{https://apps.sertifi.net/services/LinkParameter}LinkParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLinkParameter", propOrder = {
    "linkParameter"
})
public class ArrayOfLinkParameter {

    @XmlElement(name = "LinkParameter", nillable = true)
    protected List<LinkParameter> linkParameter;

    /**
     * Gets the value of the linkParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkParameter }
     * 
     * 
     */
    public List<LinkParameter> getLinkParameter() {
        if (linkParameter == null) {
            linkParameter = new ArrayList<LinkParameter>();
        }
        return this.linkParameter;
    }

}
