
package net.sertifi.apps.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.sertifi.apps.services.linkparameter.UrlQueryResult;


/**
 * <p>Java class for ArrayOfUrlQueryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUrlQueryResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UrlQueryResult" type="{http://apps.sertifi.net/services/LinkParameter}UrlQueryResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUrlQueryResult", propOrder = {
    "urlQueryResult"
})
public class ArrayOfUrlQueryResult {

    @XmlElement(name = "UrlQueryResult", nillable = true)
    protected List<UrlQueryResult> urlQueryResult;

    /**
     * Gets the value of the urlQueryResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the urlQueryResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUrlQueryResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UrlQueryResult }
     * 
     * 
     */
    public List<UrlQueryResult> getUrlQueryResult() {
        if (urlQueryResult == null) {
            urlQueryResult = new ArrayList<UrlQueryResult>();
        }
        return this.urlQueryResult;
    }

}
