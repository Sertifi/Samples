
package net.sertifi.apps.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReferenceDocumentPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReferenceDocumentPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReferenceDocumentPermission" type="{http://apps.sertifi.net/services/}ReferenceDocumentPermission" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReferenceDocumentPermission", propOrder = {
    "referenceDocumentPermission"
})
public class ArrayOfReferenceDocumentPermission {

    @XmlElement(name = "ReferenceDocumentPermission", nillable = true)
    protected List<ReferenceDocumentPermission> referenceDocumentPermission;

    /**
     * Gets the value of the referenceDocumentPermission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referenceDocumentPermission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferenceDocumentPermission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceDocumentPermission }
     * 
     * 
     */
    public List<ReferenceDocumentPermission> getReferenceDocumentPermission() {
        if (referenceDocumentPermission == null) {
            referenceDocumentPermission = new ArrayList<ReferenceDocumentPermission>();
        }
        return this.referenceDocumentPermission;
    }

}
