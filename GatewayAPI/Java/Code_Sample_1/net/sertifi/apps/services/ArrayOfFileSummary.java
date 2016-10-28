
package net.sertifi.apps.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFileSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFileSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileSummary" type="{http://apps.sertifi.net/services/}FileSummary" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFileSummary", propOrder = {
    "fileSummary"
})
public class ArrayOfFileSummary {

    @XmlElement(name = "FileSummary", nillable = true)
    protected List<FileSummary> fileSummary;

    /**
     * Gets the value of the fileSummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileSummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileSummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileSummary }
     * 
     * 
     */
    public List<FileSummary> getFileSummary() {
        if (fileSummary == null) {
            fileSummary = new ArrayList<FileSummary>();
        }
        return this.fileSummary;
    }

}
